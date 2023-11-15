package christmas.dto.response;

import christmas.domain.RoleType.Badge;

public class BadgeResponse {
    private final String badge;

    public BadgeResponse(Badge badge){
        this.badge = badge.getValue();
    }

    public String getBadge() {
        return badge;
    }
}