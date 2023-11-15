package christmas.domain.event;


import christmas.domain.menu.OrderMenu;
import christmas.domain.money.TotalAmount;
import christmas.dto.request.OrderMenuRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftEventTest {

    @Test
    @DisplayName("gift 기준 TEST")
    void isGift() {
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("레드와인-1"));
        TotalAmount total = new TotalAmount(orderMenu);
        GiftEvent gift = new GiftEvent(total);

        Assertions.assertThat(gift.isGift()).isFalse();
    }

    @Test
    @DisplayName("gift 결과 출력 TEST")
    void  getEventResult() {
        OrderMenu orderMenu = new OrderMenu(new OrderMenuRequest("레드와인-1"));
        TotalAmount total = new TotalAmount(orderMenu);
        GiftEvent gift = new GiftEvent(total);

        Assertions.assertThat(gift.getEventResult()).isEqualTo("없음");
    }
}