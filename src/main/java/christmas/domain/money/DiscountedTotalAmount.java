package christmas.domain.money;

import christmas.domain.menu.Menu;

public class DiscountedTotalAmount {

    private final int discountedTotalAmount;

    public DiscountedTotalAmount(
        TotalAmount totalAmount,
        TotalDiscountAmount totalDiscountAmount,
        boolean isGift) {
        this.discountedTotalAmount = createDiscountedTotalAmount(
            totalAmount, totalDiscountAmount, isGift);
    }

    private int createDiscountedTotalAmount(
        TotalAmount totalAmount,
        TotalDiscountAmount totalDiscountAmount,
        boolean isGift
    ) {
        if (isGift) {
            return totalAmount.getTotalAmount()
                - totalDiscountAmount.getTotalDiscountAmount()
                + Menu.CHAMPAGNE.getPrice();
        }
        return totalAmount.getTotalAmount() - totalDiscountAmount.getTotalDiscountAmount();
    }

    public int getDiscountedTotalAmount() {
        return discountedTotalAmount;
    }
}