package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.ReservationDay;
import christmas.dto.request.ReservationDayRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristMasCountdownDiscountTest {

    @Test
    @DisplayName("크리스마스 카운트 다운 혜택 TEST")
    void createChristMasCountdownDiscount() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        ChristMasCountdownDiscount discount = new ChristMasCountdownDiscount(day);
        int answer = 1200;

        assertThat(answer).isEqualTo(discount.getDiscount());
    }

    @Test
    @DisplayName("이벤트 기간이 아닐 경우 TEST")
    void validateEventDay() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("27"));
        ChristMasCountdownDiscount discount = new ChristMasCountdownDiscount(day);

        assertThat(0).isEqualTo(discount.getDiscount());
    }

    @Test
    void getDiscount() {
    }
}