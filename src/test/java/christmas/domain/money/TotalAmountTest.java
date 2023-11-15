package christmas.domain.money;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ReservationDay;
import christmas.domain.menu.OrderMenu;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalAmountTest {

    @Test
    @DisplayName("전체 금액 TEST")
    void calculateOrderTotal() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);

        assertThat(totalAmount.getTotalAmount()).isEqualTo(6000);
    }
}