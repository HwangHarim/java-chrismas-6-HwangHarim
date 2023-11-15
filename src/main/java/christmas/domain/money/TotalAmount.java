package christmas.domain.money;

import christmas.domain.menu.Menu;
import christmas.domain.menu.OrderMenu;
import java.util.Map;

public class TotalAmount {

    private int totalAmount;
    private final Map<Menu, Integer> orderMenuMap;

    public TotalAmount(OrderMenu orderMenu) {
        this.orderMenuMap = orderMenu.getOrderMenuMap();
        calculateOrderTotal();
    }

    public void calculateOrderTotal() {
        for (Map.Entry<Menu, Integer> order : orderMenuMap.entrySet()) {
            totalAmount += order.getKey().getPrice() * order.getValue();
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}