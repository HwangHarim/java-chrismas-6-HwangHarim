package christmas.domain.menu;

import christmas.dto.request.OrderMenuRequest;
import christmas.error.ErrorMessage;
import christmas.error.exception.OrderMenuInputException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class OrderMenu {

    private static final String ORDER_REGEX = "^[가-힣]+-\\d{1,2}$";
    private static final int MAX_MENU_COUNT = 20;
    private final Map<Menu, Integer> orderMenuMap = new HashMap<>();

    public OrderMenu(OrderMenuRequest request) {
        String[] menus = request.orderMenu().split(",");
        validateInput(menus);
        validateDuplication(menus);
        validateMaxCount(menus);
        validateIsMenu(menus);
        setupMenuMap();
        createMenuMap(menus);
    }

    private void setupMenuMap() {
        for (Menu menu : Menu.values()) {
            orderMenuMap.put(menu, 0);
        }
    }

    private void validateInput(String[] menus) {
        for (String menu : menus) {
            if (!Pattern.matches(ORDER_REGEX, menu)) {
                throw new OrderMenuInputException(ErrorMessage.INPUT_ORDER_MENU_EXCEPTION);
            }
        }
    }

    private void validateDuplication(String[] menus) {
        Set<String> menuSet = Arrays.stream(menus)
            .map(menu -> menu.split("-")[0])
            .collect(HashSet::new, HashSet::add, HashSet::addAll);

        if (menuSet.size() != menus.length) {
            throw new OrderMenuInputException(ErrorMessage.INPUT_ORDER_MENU_EXCEPTION);
        }
    }

    private void validateMaxCount(String[] menus) {
        int count = Arrays.stream(menus)
            .mapToInt(menu -> Integer.parseInt(menu.split("-")[1]))
            .sum();

        if (MAX_MENU_COUNT < count) {
            throw new OrderMenuInputException(ErrorMessage.INPUT_ORDER_MENU_EXCEPTION);
        }
    }

    private void validateIsMenu(String[] menus) {
        for (String menu : menus) {
            if (!Menu.isMenu(menu.split("-")[0])) {
                throw new OrderMenuInputException(ErrorMessage.INPUT_ORDER_MENU_EXCEPTION);
            }
        }
    }

    public void createMenuMap(String[] menus) {
        for (String menu : menus) {
            String[] menuData = menu.split("-");
            orderMenuMap.put(Menu.findByNameOfMatches(menuData[0]), Integer.parseInt(menuData[1]));
        }
    }

    public int findByOrderCountMatcher(FoodCategory foodCategory) {
        var count = 0;

        for (Menu menu: Menu.findByCategoryOfMatches(foodCategory)) {
            count += orderMenuMap.get(menu);
        }

        return count;
    }

    public Map<Menu, Integer> getOrderMenuMap() {
        return orderMenuMap;
    }
}