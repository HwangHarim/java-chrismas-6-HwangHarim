package christmas.domain.event;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ReservationDay;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekDiscountType;
import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventFactoryTest {

    @Test
    @DisplayName("빈 이벤트 생성 TEST")
    void createNullEventFactory(){

        EventFactory factory = new EventFactory();

        assertThat(factory.getSpecialDiscount()).isEqualTo(SpecialDiscount.NOTTING);
        assertThat(factory.getWeekDiscountType()).isEqualTo(WeekDiscountType.NOTTING);
    }

    @Test
    @DisplayName("이벤트 생성 TEST")
    void createEventFactory(){
        ReservationDay reservation = new ReservationDay(new ReservationDayRequest("3"));
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("양송이수프-4"));
        TotalAmount totalAmount = new TotalAmount(orderMenu);

        EventFactory factory = new EventFactory(reservation, totalAmount, orderMenu);

        assertThat(factory.getChristMasCountdownDiscount().getDiscount())
            .isEqualTo(1200);
    }
}