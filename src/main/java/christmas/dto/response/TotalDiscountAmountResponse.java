package christmas.dto.response;

import christmas.domain.money.TotalDiscountAmount;

public class TotalDiscountAmountResponse {
    private final int totalDiscountAmount;

    public TotalDiscountAmountResponse(TotalDiscountAmount totalDiscountAmount) {
      this.totalDiscountAmount = totalDiscountAmount.getTotalDiscountAmount();
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }
}