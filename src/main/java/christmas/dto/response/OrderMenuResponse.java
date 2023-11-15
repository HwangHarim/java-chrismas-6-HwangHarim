package christmas.dto.response;

import christmas.domain.menu.Menu;
import java.util.Map;

public class OrderMenuResponse {

    private final Map<String, Integer> orderMenu;

    public OrderMenuResponse(Map<String, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public Map<String, Integer> getOrderMenu() {
        return orderMenu;
    }
}
