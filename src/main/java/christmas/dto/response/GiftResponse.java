package christmas.dto.response;

import christmas.domain.event.GiftEvent;

public class GiftResponse {

    private String gift;

    public GiftResponse(GiftEvent gift) {
        this.gift = gift.getEventResult();
    }

    public String getGift() {
        return gift;
    }
}