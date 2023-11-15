package christmas.domain.discount;

import christmas.domain.ReservationDay;

public class ChristMasCountdownDiscount {

    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int DISCOUNT_UNIT = 100;
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;
    private int discount;

    public ChristMasCountdownDiscount() {
        this.discount = 0;
    }

    public ChristMasCountdownDiscount(ReservationDay reservationDay) {
        createChristMasCountdownDiscount(reservationDay.getReservationDay());
    }

    public void createChristMasCountdownDiscount(int reservationDay) {
        if (START_DAY < reservationDay && reservationDay < END_DAY) {
            discount = DEFAULT_DISCOUNT + (DISCOUNT_UNIT * (reservationDay - 1));
        }
    }

    public int getDiscount() {
        return discount;
    }
}