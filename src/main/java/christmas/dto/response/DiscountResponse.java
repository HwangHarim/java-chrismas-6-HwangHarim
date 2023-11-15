package christmas.dto.response;

import christmas.domain.discount.WeekDiscountType;
import christmas.domain.event.EventFactory;

public class DiscountResponse {

    private final int chrisMasCountDownDiscount;
    private final WeekDiscountType weekDiscountType;
    private final int weekDiscount;
    private final int specialDiscount;
    private final String giftDiscountResult;
    private final int giftDiscount;

    public DiscountResponse(EventFactory eventResult, int weekDiscount) {
        this.chrisMasCountDownDiscount = eventResult.getChristMasCountdownDiscount().getDiscount();
        this.weekDiscountType = eventResult.getWeekDiscountType();
        this.weekDiscount = weekDiscount;
        this.specialDiscount = eventResult.getSpecialDiscount().getDiscount();
        this.giftDiscountResult = eventResult.getGiftEvent().getEventResult();
        this.giftDiscount = eventResult.getGiftEvent().getDiscount();
    }

    public int getChrisMasCountDownDiscount() {
        return chrisMasCountDownDiscount;
    }

    public WeekDiscountType getWeekDiscountType() {
        return weekDiscountType;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getGiftDiscount() {
        return giftDiscount;
    }

    public String getGiftDiscountResult() {
        return giftDiscountResult;
    }

    public int getWeekDiscount() {
        return weekDiscount;
    }
}