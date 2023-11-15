package christmas.domain.money;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ReservationDay;
import christmas.domain.event.EventFactory;
import christmas.domain.menu.OrderMenu;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalDiscountAmountTest {

    @Test
    @DisplayName("총 할인가 TEST")
    void calculateTotalDiscountAmount(){
        ReservationDay day = new ReservationDay(new ReservationDayRequest("7"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-3"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventFactory event = new EventFactory(day, totalAmount, orderMenu);

        TotalDiscountAmount discountAmount = new TotalDiscountAmount(event, orderMenu);

        assertThat(discountAmount.getTotalDiscountAmount()).isEqualTo(1600);
    }

}