package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.dto.request.OrderMenuRequest;
import christmas.error.exception.OrderMenuInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenuTest {


    @Test
    @DisplayName("허용하지 않는 입력방식 TEST")
    void validateInput() {
        String init = "ㄱ,1,ㄴ,1"; // 입력 형식이 맞지 않는 경우
        String init2 = "1-ㄱ1-ㄴ"; //순서가 바뀐경우
        String init3 = "ㄱ/1,ㄴ/1"; // 분리 문자가 잘못된 경우
        String init4 = "a-1,b-1"; // 허용하지 않는 타입을 사용한 경우

        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init)))
            .isInstanceOf(OrderMenuInputException.class);
        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init2)))
            .isInstanceOf(OrderMenuInputException.class);
        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init3)))
            .isInstanceOf(OrderMenuInputException.class);
        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init4)))
            .isInstanceOf(OrderMenuInputException.class);

    }

    @Test
    @DisplayName("중복된 입력 예외 TEST")
    void validateDuplication(){
        String init ="a-1,a-2"; // 입력이 중복되는 경우

        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init)))
            .isInstanceOf(OrderMenuInputException.class);
    }

    @Test
    @DisplayName("입력 메뉴의 개수가 20을 초과하는 예외 TEST")
    void validateMaxCount(){
        String init ="a-19,a-2";
        String init2 ="a-23";

        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init)))
            .isInstanceOf(OrderMenuInputException.class);
        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init2)))
            .isInstanceOf(OrderMenuInputException.class);
    }

    @Test
    @DisplayName("없는 메뉴 주문시 예외 TEST")
    void validateIsMenu(){
        String init ="밥-1,김-2";

        assertThatThrownBy(
            ()-> new OrderMenu(new OrderMenuRequest(init)))
            .isInstanceOf(OrderMenuInputException.class);
    }

    @Test
    void findByOrderCountMatcher() {
    }
}