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
    @DisplayName("배지 산타 판별 TEST")
    void searchBadge() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        String badge = Badge.searchBadge(totalDiscountAmount).getValue();

        Assertions.assertThat(badge).isEqualTo("산타");
    }

    @Test
    @DisplayName("배지 없음 판별 TEST")
    void searchBadge2() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("티본스테이크-1,바비큐립-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        String badge = Badge.searchBadge(totalDiscountAmount).getValue();

        Assertions.assertThat(badge).isEqualTo("없음");
    }

    @Test
    @DisplayName("배지 별 판별 TEST")
    void searchBadge3() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("티본스테이크-1,초코케이크-2,제로콜라-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        String badge = Badge.searchBadge(totalDiscountAmount).getValue();

        Assertions.assertThat(badge).isEqualTo("별");
    }

    @Test
    @DisplayName("배지 트리 판별 TEST")
    void searchBadge4() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("초코케이크-4,제로콜라-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(event, orderMenu);
        String badge = Badge.searchBadge(totalDiscountAmount).getValue();

        Assertions.assertThat(badge).isEqualTo("트리");
    }
}