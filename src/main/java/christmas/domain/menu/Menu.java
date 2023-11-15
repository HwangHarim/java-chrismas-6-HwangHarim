package christmas.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    NOTTING("없음", 0, FoodCategory.NOTTING),
    MUSHROOM_SOUP("양송이수프", 6_000, FoodCategory.APPETIZER),
    TAPAS("타파스", 5_500, FoodCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, FoodCategory.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, FoodCategory.MAIN),
    BBQ_RIB("바비큐립", 54_000, FoodCategory.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, FoodCategory.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, FoodCategory.MAIN),
    CHOCO_CAKE("초코케이크", 15_000, FoodCategory.DESSERT),
    ICE_CREAM("아이스크림", 5_000, FoodCategory.DESSERT),
    ZERO_COLA("제로콜라", 3_000, FoodCategory.BEVERAGE),
    RED_WINE("레드와인", 60_000, FoodCategory.BEVERAGE),
    CHAMPAGNE("샴페인", 25_000, FoodCategory.BEVERAGE);

    private final String name;
    private final int price;
    private final FoodCategory category;

    Menu(String name, int price, FoodCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public static Menu findByNameOfMatches(String name) {
        return Arrays.stream(values())
            .filter(menu -> menu.getName().equals(name))
            .findFirst().get();
    }

    public static List<Menu> findByCategoryOfMatches(FoodCategory foodCategory) {
        return Arrays.stream(values())
            .filter(menu -> menu.getCategory().getCategory().equals(foodCategory.getCategory()))
            .collect(Collectors.toList());
    }

    public static boolean isMenu(String name) {
        return Arrays.stream(Menu.values())
            .anyMatch(menu -> menu.getName().equals(name));
    }

    public int getPrice() {
        return price;
    }

    public FoodCategory getCategory() {
        return category;
    }
}