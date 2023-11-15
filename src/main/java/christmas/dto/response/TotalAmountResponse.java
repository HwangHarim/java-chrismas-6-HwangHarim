package christmas.dto.response;

import christmas.domain.money.TotalAmount;

public class TotalAmountResponse {
    private final int totalAmount;

    public TotalAmountResponse(TotalAmount totalAmount) {
        this.totalAmount = totalAmount.getTotalAmount();
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
