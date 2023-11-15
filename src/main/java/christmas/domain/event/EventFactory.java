package christmas.domain.event;

import christmas.domain.ReservationDay;
import christmas.domain.discount.ChristMasCountdownDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekDiscountType;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;

public class EventFactory {

    private static final int WEEK = 7;
    private static final int WEEK_WEEKEND_START_RANG = 1;
    private static final int WEEK_WEEKEND_END_RANG = 2;
    private final ChristMasCountdownDiscount christMasCountdownDiscount;
    private final SpecialDiscount specialDiscount;
    private final WeekDiscountType weekDiscountType;

    private final GiftEvent giftEvent;

    public EventFactory() {
        this.christMasCountdownDiscount = new ChristMasCountdownDiscount();
        this.specialDiscount = SpecialDiscount.NOTTING;
        this.weekDiscountType = WeekDiscountType.NOTTING;
        this.giftEvent = new GiftEvent();
    }

    public EventFactory(
        ReservationDay reservationDay,
        TotalAmount totalAmount,
        OrderMenu orderMenu
    ) {
        this.christMasCountdownDiscount = new ChristMasCountdownDiscount(reservationDay);
        this.specialDiscount = checkSpecialDiscount(reservationDay);
        this.weekDiscountType = checkWeekDiscountNullType(
            checkWeekDiscountType(reservationDay),
            orderMenu);
        this.giftEvent = new GiftEvent(totalAmount);
    }

    private SpecialDiscount checkSpecialDiscount(ReservationDay reservationDay) {
        if (!SpecialDiscount.isSpecialDiscount(reservationDay.getReservationDay())) {
            return SpecialDiscount.NOTTING;
        }
        return SpecialDiscount.findByReservationDayOfMatches(reservationDay.getReservationDay());
    }

    private WeekDiscountType checkWeekDiscountType(ReservationDay reservationDay) {
        if (WEEK_WEEKEND_START_RANG <= reservationDay.getReservationDay() % WEEK
            && reservationDay.getReservationDay() % WEEK <= WEEK_WEEKEND_END_RANG) {
            return WeekDiscountType.WEEKEND_DISCOUNT;
        }
        return WeekDiscountType.WEEKDAY_DISCOUNT;
    }

    private WeekDiscountType checkWeekDiscountNullType(
        WeekDiscountType weekDiscountType,
        OrderMenu orderMenu
    ) {
        if (orderMenu.findByOrderCountMatcher(weekDiscountType.getFoodCategory()) == 0) {
            return WeekDiscountType.NOTTING;
        }
        return weekDiscountType;
    }

    public ChristMasCountdownDiscount getChristMasCountdownDiscount() {
        return christMasCountdownDiscount;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public WeekDiscountType getWeekDiscountType() {
        return weekDiscountType;
    }

    public GiftEvent getGiftEvent() {
        return giftEvent;
    }
}