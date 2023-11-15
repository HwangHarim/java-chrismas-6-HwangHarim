package christmas.domain.RoleType;



import christmas.domain.ReservationDay;
import christmas.domain.event.EventFactory;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;
import christmas.domain.money.TotalDiscountAmount;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    @DisplayName("배지 판별 TEST")
    void searchBadge() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("1"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-3"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        String badge = Badge.searchBadge(totalDiscountAmount).getValue();

        Assertions.assertThat(badge).isEqualTo("없음");
    }
}