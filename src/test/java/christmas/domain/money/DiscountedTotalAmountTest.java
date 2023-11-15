package christmas.domain.money;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ReservationDay;
import christmas.domain.event.EventHandler;
import christmas.domain.menu.OrderMenu;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountedTotalAmountTest {

    @Test
    @DisplayName("총 결과값 TEST")
    void getDiscountedTotalAmount() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("1"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-2"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventHandler eh = new EventHandler(day, totalAmount, orderMenu);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(eh.getEvent(), orderMenu);

        assertThat(new DiscountedTotalAmount(totalAmount, totalDiscountAmount, false)
            .getDiscountedTotalAmount()).isEqualTo(12000);
    }
}