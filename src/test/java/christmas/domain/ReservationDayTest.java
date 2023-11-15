package christmas.domain;


import static org.assertj.core.api.Assertions.*;

import christmas.dto.request.ReservationDayRequest;
import christmas.error.exception.ReservationDayInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationDayTest {

    @Test
    @DisplayName("잘못된 타입의 입력된 경우")
    void validateDateType() {
        String init = "한글";
        String init2 = "abc";
        String init3 = ")(*@&&#*!";

        assertThatThrownBy(
            ()-> new ReservationDay(new ReservationDayRequest(init)))
            .isInstanceOf(ReservationDayInputException.class);
        assertThatThrownBy(
            ()-> new ReservationDay(new ReservationDayRequest(init2)))
            .isInstanceOf(ReservationDayInputException.class);
        assertThatThrownBy(
            ()-> new ReservationDay(new ReservationDayRequest(init3)))
            .isInstanceOf(ReservationDayInputException.class);
    }

    @Test
    @DisplayName("입력한 날짜 범위를 이탈한 경우")
    void validateDateInPeriod() {
        String init = "0";
        String init2 = "32";

        assertThatThrownBy(
            ()-> new ReservationDay(new ReservationDayRequest(init)))
            .isInstanceOf(ReservationDayInputException.class);
        assertThatThrownBy(
            ()-> new ReservationDay(new ReservationDayRequest(init2)))
            .isInstanceOf(ReservationDayInputException.class);
    }
}