package christmas.error;

public enum ErrorMessage {
    INPUT_RESERVATION_DAY_EXCEPTION("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INPUT_ORDER_MENU_EXCEPTION("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}