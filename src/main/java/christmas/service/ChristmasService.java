package christmas.service;

import christmas.converter.Converter;
import christmas.domain.ReservationDay;
import christmas.domain.RoleType.Badge;
import christmas.domain.event.EventFactory;
import christmas.domain.event.EventHandler;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.DiscountedTotalAmount;
import christmas.domain.money.TotalAmount;
import christmas.domain.money.TotalDiscountAmount;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import christmas.dto.response.BadgeResponse;
import christmas.dto.response.DiscountResponse;
import christmas.dto.response.DiscountedTotalAmountResponse;
import christmas.dto.response.GiftResponse;
import christmas.dto.response.OrderMenuResponse;
import christmas.dto.response.TotalAmountResponse;
import christmas.dto.response.TotalDiscountAmountResponse;

public class ChristmasService {

    private final Converter converter = new Converter();
    private ReservationDay reservationDay;

    private OrderMenu orderMenu;
    private TotalAmount totalAmount;
    private TotalDiscountAmount totalDiscountAmount;
    private EventFactory event;

    public void createReservationDay(ReservationDayRequest request) {
        this.reservationDay = new ReservationDay(request);
    }

    public void createOrderMenu(OrderMenuRequest request) {
        this.orderMenu = new OrderMenu(request);
        this.totalAmount = new TotalAmount(orderMenu);
        this.event = new EventHandler(reservationDay, totalAmount, orderMenu).getEvent();
    }

    public OrderMenuResponse getOrderMenuResult() {
        return converter.orderMenuConvertToResponse(orderMenu);
    }

    public TotalAmountResponse getTotalAmountResult() {
        return new TotalAmountResponse(totalAmount);
    }

    public GiftResponse getGiftResult() {
        return new GiftResponse(event.getGiftEvent());
    }

    public DiscountResponse getDiscountHistory() {
        return new DiscountResponse(event,
            orderMenu.findByOrderCountMatcher(event.getWeekDiscountType().getFoodCategory()));
    }

    public TotalDiscountAmountResponse getTotalDiscountAmountResult() {
        this.totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        return new TotalDiscountAmountResponse(totalDiscountAmount);
    }

    public DiscountedTotalAmountResponse getDiscountedTotalAmountResult() {
        return new DiscountedTotalAmountResponse(
            new DiscountedTotalAmount(totalAmount, totalDiscountAmount,
                event.getGiftEvent().isGift())
        );
    }

    public BadgeResponse getBadgeResult() {
        return new BadgeResponse(Badge.searchBadge(totalDiscountAmount));
    }
}