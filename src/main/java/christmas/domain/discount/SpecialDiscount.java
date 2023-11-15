package christmas.domain.discount;

import java.util.Arrays;

public enum SpecialDiscount {
    NOTTING(0, 0),
    THREE_STAR_DISCOUNT(3, 1_000),
    TEN_STAR_DISCOUNT(10, 1_000),
    SEVENTEEN_STAR_DISCOUNT(17, 1_000),
    TWENTY_FOUR_STAR_DISCOUNT(24, 1_000),
    TWENTY_FIVE_STAR_DISCOUNT(25, 1_000),
    THIRTY_ONE_STAR_DISCOUNT(31, 1_000),
    ;

    private final int reservationDay;
    private final int discount;

    SpecialDiscount(int reservationDay, int discount){
        this.reservationDay = reservationDay;
        this.discount = discount;
    }

    public static SpecialDiscount findByReservationDayOfMatches(int reservationDay){
        return Arrays.stream(values())
            .filter(specialDiscount -> specialDiscount.getReservationDay() == reservationDay)
            .findFirst().get();
    }

    public static boolean isSpecialDiscount(int reservationDay){
        return Arrays.stream(SpecialDiscount.values())
            .anyMatch(specialDiscount -> specialDiscount.getReservationDay() == reservationDay);
    }

    public int getReservationDay() {
        return reservationDay;
    }

    public int getDiscount() {
        return discount;
    }
}