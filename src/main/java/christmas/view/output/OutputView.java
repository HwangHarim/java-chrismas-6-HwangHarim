package christmas.view.output;

public class OutputView {

    public void displayOutText(String orderResult){
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }
    public void displayOrderMenu(String orderResult){
        System.out.println("<주문 메뉴>");
        System.out.println(orderResult);
    }

    public void displayTotalAmount(int amount){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", amount);
        System.out.println();
    }

    public void displayGiftEvent(String gift){
        System.out.println("<증정 메뉴>");
        System.out.println(gift);
        System.out.println();
    }

    public void displayDiscountHistory(String history){
        System.out.println("<혜택 내역>");
        System.out.println(history);
    }

    public void displayTotalDiscountAmount(String totalDiscount){
        System.out.println("<총혜택 금액>");
        System.out.println(totalDiscount);
        System.out.println();
    }

    public void displayDiscountedTotalAmount(String discountedTotalAmount){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(discountedTotalAmount);
    }

    public void displayBadge(String badge){
        System.out.println("<12월 이벤트 배지>");
        System.out.print(badge);
    }
}
