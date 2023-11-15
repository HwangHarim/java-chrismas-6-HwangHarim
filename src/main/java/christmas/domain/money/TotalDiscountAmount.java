package christmas.domain.money;

import christmas.domain.event.EventFactory;
import christmas.domain.menu.OrderMenu;

public class TotalDiscountAmount {

    private int totalDiscountAmount;

    public TotalDiscountAmount(EventFactory event, OrderMenu orderMenu) {
        calculateTotalDiscountAmount(event, orderMenu);
    }

    private void calculateTotalDiscountAmount(EventFactory event, OrderMenu orderMenu) {
        totalDiscountAmount += event.getChristMasCountdownDiscount().getDiscount();
        totalDiscountAmount += event.getSpecialDiscount().getDiscount();
        totalDiscountAmount += event.getWeekDiscountType().getDiscount() * orderMenu.findByOrderCountMatcher(
            event.getWeekDiscountType().getFoodCategory());

        if (event.getGiftEvent().isGift()) {
            totalDiscountAmount += event.getGiftEvent().getDiscount();
        }
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }
}