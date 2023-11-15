package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.money.TotalAmount;

public class GiftEvent {

    private final static String COUNT_TEXT = " 1개";
    private final static int LIMIT_TOTAL_AMOUNT = 120000;
    private int totalAmount = 0;

    public GiftEvent() {
    }

    public GiftEvent(TotalAmount totalAmount) {
        this.totalAmount = totalAmount.getTotalAmount();
    }

    public boolean isGift() {
        return LIMIT_TOTAL_AMOUNT < totalAmount;
    }

    public int getDiscount() {
        return Menu.CHAMPAGNE.getPrice();
    }

    public String getEventResult() {
        if (isGift()) {
            return Menu.CHAMPAGNE.getName() + COUNT_TEXT;
        }
        return Menu.NOTTING.getName();
    }
}