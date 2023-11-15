package christmas.error.exception;

import christmas.error.ErrorMessage;

public class ReservationDayInputException extends IllegalArgumentException{

    public ReservationDayInputException(ErrorMessage message){
        super(message.getMessage());
    }
}
