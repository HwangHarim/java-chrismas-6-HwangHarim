package christmas.domain.menu;

public enum FoodCategory {
    NOTTING("없다"),
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String category;

    FoodCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}