package christmas.controller;

import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import christmas.dto.response.BadgeResponse;
import christmas.dto.response.DiscountResponse;
import christmas.dto.response.DiscountedTotalAmountResponse;
import christmas.dto.response.GiftResponse;
import christmas.dto.response.OrderMenuResponse;
import christmas.dto.response.TotalAmountResponse;
import christmas.dto.response.TotalDiscountAmountResponse;
import christmas.service.ChristmasService;

public class ChristmasController {

    private final ChristmasService christmasService = new ChristmasService();

    public void receiveReservationDay(ReservationDayRequest request) {
        christmasService.createReservationDay(request);
    }

    public void receiveOrderMenu(OrderMenuRequest request) {
        christmasService.createOrderMenu(request);
    }

    public OrderMenuResponse getOrderMenuResult() {
        return christmasService.getOrderMenuResult();
    }

    public TotalAmountResponse getTotalAmountResult() {
        return christmasService.getTotalAmountResult();
    }

    public GiftResponse getGiftResult() {
        return christmasService.getGiftResult();
    }

    public DiscountResponse getDiscountHistory() {
        return christmasService.getDiscountHistory();
    }

    public TotalDiscountAmountResponse getTotalDiscountAmountResult() {
        return christmasService.getTotalDiscountAmountResult();
    }

    public DiscountedTotalAmountResponse getDiscountedTotalAmountResult() {
        return christmasService.getDiscountedTotalAmountResult();
    }

    public BadgeResponse getBadgeResult() {
        return christmasService.getBadgeResult();
    }
}