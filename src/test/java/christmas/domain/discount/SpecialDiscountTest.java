package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {

    @Test
    @DisplayName("날짜로 SpecialDiscount 찾는 TEST")
    void findByReservationDayOfMatches() {
        int n = 3;
        SpecialDiscount specialDiscount = SpecialDiscount.findByReservationDayOfMatches(n);

        assertThat(SpecialDiscount.THREE_STAR_DISCOUNT).isEqualTo(specialDiscount);
    }

    @Test
    @DisplayName("특별 혜택날 확인 TEST")
    void isSpecialDiscount() {
        int[] init ={3,10,17,24,25,31};

        for (int j : init) {
            assertThat(SpecialDiscount.isSpecialDiscount(j)).isTrue();
        }

    }
}