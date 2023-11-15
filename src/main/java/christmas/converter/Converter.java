package christmas.converter;

import christmas.domain.menu.Menu;
import christmas.domain.menu.OrderMenu;
import christmas.dto.response.DiscountResponse;
import christmas.dto.response.OrderMenuResponse;
import java.util.HashMap;
import java.util.Map;

public class Converter {

    public OrderMenuResponse orderMenuConvertToResponse(OrderMenu orderMenu) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Menu, Integer> entry : orderMenu.getOrderMenuMap().entrySet()) {
            if (0 < entry.getValue()) {
                result.put(entry.getKey().getName(), entry.getValue());
            }
        }

        return new OrderMenuResponse(result);
    }


    public String orderMenuConvertToString(OrderMenuResponse response) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : response.getOrderMenu().entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("개\n");
        }
        return sb.toString();
    }

    public String discountHistoryConvertToString(DiscountResponse response) {
        StringBuilder sb = new StringBuilder();
        if (response.getSpecialDiscount() != 0) {
            sb.append("크리스마스 디데이 할인: ")
                .append(convertMinusMoneyFormat(response.getChrisMasCountDownDiscount()));
        }
        if (response.getWeekDiscount() != 0) {
            sb.append(response.getWeekDiscountType().getType()).append(": ").append(
                convertMinusMoneyFormat(
                    response.getWeekDiscountType().getDiscount() * response.getWeekDiscount()));
        }
        if (response.getSpecialDiscount() != 0) {
            sb.append("특별 할인: ").append(convertMinusMoneyFormat(response.getSpecialDiscount()));
        }
        if (!response.getGiftDiscountResult().equals("없음")) {
            sb.append("증정 이벤트: ").append(convertMinusMoneyFormat(response.getGiftDiscount()));
        }

        return sb.toString();
    }

    public String convertMoneyFormat(int money) {
        if (money == 0) {
            return "0원";
        }
        return String.format("%,d원%n", money);
    }

    public String convertMinusMoneyFormat(int money) {
        if (money == 0) {
            return "0원";
        }
        return "-" + String.format("%,d원%n", money);
    }
}