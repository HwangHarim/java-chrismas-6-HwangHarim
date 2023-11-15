package christmas.domain;

import christmas.dto.request.ReservationDayRequest;
import christmas.error.ErrorMessage;
import christmas.error.exception.ReservationDayInputException;
import java.util.regex.Pattern;

public class ReservationDay {

    private static final String REGEX_PROPERTY = "^[0-9]*$";
    private static final int DECEMBER_START = 1;
    private static final int DECEMBER_END = 31;

    private final int reservationDay;

    public ReservationDay(ReservationDayRequest request) {
        validateDateType(request.reservationDay());
        this.reservationDay = Integer.parseInt(request.reservationDay());
        validateDateInPeriod();
    }

    private void validateDateType(String day) {
        if (!Pattern.matches(REGEX_PROPERTY, day)) {
            throw new ReservationDayInputException(ErrorMessage.INPUT_RESERVATION_DAY_EXCEPTION);
        }
    }

    private void validateDateInPeriod() {
        if (reservationDay < DECEMBER_START || DECEMBER_END < reservationDay) {
            throw new ReservationDayInputException(ErrorMessage.INPUT_RESERVATION_DAY_EXCEPTION);
        }
    }

    public int getReservationDay() {
        return reservationDay;
    }
}