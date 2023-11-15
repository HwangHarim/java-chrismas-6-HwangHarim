package christmas.filter;

import christmas.error.ErrorMessage;
import christmas.error.exception.OrderMenuInputException;
import christmas.error.exception.ReservationDayInputException;
import java.util.Objects;

public class BlankInputFilter {

    public String blankInputReservationDayFilter(String input) {
        if (Objects.equals(input, "")) {
            throw new ReservationDayInputException(ErrorMessage.INPUT_RESERVATION_DAY_EXCEPTION);
        }
        return input;
    }

    public String blankInputOrderMenuFilter(String input) {
        if (Objects.equals(input, "")) {
            throw new OrderMenuInputException(ErrorMessage.INPUT_ORDER_MENU_EXCEPTION);
        }
        return input;
    }
}