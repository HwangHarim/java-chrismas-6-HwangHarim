package christmas.domain.event;

import christmas.domain.ReservationDay;
import christmas.domain.menu.FoodCategory;
import christmas.domain.menu.Menu;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;
import java.util.Map;

public class EventHandler {

    private final EventFactory event;

    public EventHandler(ReservationDay reservationDay, TotalAmount totalAmount, OrderMenu orderMenu) {
        this.event = selectEvent(reservationDay, totalAmount, orderMenu);
    }

    public EventFactory selectEvent(
        ReservationDay reservationDay,
        TotalAmount totalAmount,
        OrderMenu orderMenu
    ){
        if(isOverLimitTotalAmount(totalAmount) || isEventAllBeverage(orderMenu)){
            return new EventFactory();
        }
        return new EventFactory(reservationDay, totalAmount, orderMenu);
    }

    public boolean isOverLimitTotalAmount(TotalAmount totalAmount) {
        return totalAmount.getTotalAmount() < 10000;
    }

    private boolean isEventAllBeverage(OrderMenu orderMenu) {
        var beverageCount = 0;
        var notBeverageCount = 0;

        for (Map.Entry<Menu, Integer> entry : orderMenu.getOrderMenuMap().entrySet()) {
            if (entry.getKey().getCategory().getCategory()
                .equals(FoodCategory.BEVERAGE.getCategory())) {
                beverageCount += entry.getValue();
                continue;
            }
            notBeverageCount += entry.getValue();
        }
        return beverageCount != 0 && notBeverageCount == 0;
    }

    public EventFactory getEvent() {
        return event;
    }
}