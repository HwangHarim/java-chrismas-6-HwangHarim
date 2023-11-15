package christmas.domain.event;


import static org.assertj.core.api.Assertions.*;

import christmas.domain.ReservationDay;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventHandlerTest {

    @Test
    @DisplayName("10000이상 으로 혜택을 받을 경우 TEST")
    void selectEvent() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-2"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventHandler eh = new EventHandler(day, totalAmount, orderMenu);

        assertThat(eh.getEvent().getSpecialDiscount())
            .isEqualTo(new EventFactory(day, totalAmount, orderMenu).getSpecialDiscount());
    }

    @Test
    @DisplayName("10000 이하여서 해택을 못 받을 경우 TEST")
    void isOverLimitTotalAmountDown() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventHandler eh = new EventHandler(day, totalAmount, orderMenu);

        assertThat(eh.isOverLimitTotalAmount(totalAmount)).isTrue();
    }

    @Test
    @DisplayName("음료만 주문하여 할인 혜택을 못 받을 경우 TEST")
    void isEventAllBeverage() {
        ReservationDay day = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("레드와인-1"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);
        EventHandler eh = new EventHandler(day, totalAmount, orderMenu);

        assertThat(eh.selectEvent(day, totalAmount, orderMenu)
            .getSpecialDiscount()).isEqualTo(SpecialDiscount.NOTTING);
    }
}