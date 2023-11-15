package christmas.dto.response;

import christmas.domain.money.DiscountedTotalAmount;

public class DiscountedTotalAmountResponse {

    private final int discountedTotalAmount;

    public DiscountedTotalAmountResponse(DiscountedTotalAmount discountedTotalAmount) {
        this.discountedTotalAmount = discountedTotalAmount.getDiscountedTotalAmount();
    }

    public int getDiscountedTotalAmount() {
        return discountedTotalAmount;
    }
}
