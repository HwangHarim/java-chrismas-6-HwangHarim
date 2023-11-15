package christmas.error.exception;

import christmas.error.ErrorMessage;

public class OrderMenuInputException extends IllegalArgumentException {

    public OrderMenuInputException(ErrorMessage message) {
        super(message.getMessage());
    }
}
