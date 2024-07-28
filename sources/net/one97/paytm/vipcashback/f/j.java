package net.one97.paytm.vipcashback.f;

import kotlin.g.b.k;
import net.one97.paytm.vipcashback.R;

public enum j {
    LANDING_VICTORY_THEME("#F02674", "#FF428B", R.drawable.ic_confetti_victory, "#FFFFFF"),
    LANDING_TRUMP_THEME("#3252F0", "#3B68FF", R.drawable.ic_confetti_trump, "#FFFFFF"),
    LANDING_DIAMOND_THEME("#101F5C", "#661A75FF", R.drawable.ic_confetti_diamond, "#FFFFFF"),
    LANDING_SUNGLASSES_THEME("#FEDB31", "#FFF536", R.drawable.ic_confetti_sunglasses, "#000000"),
    GAME_CAMPAIGN_THEME("#00AAFF", "#00C4FF", R.drawable.ic_confetti_sunglasses, "#FFFFFF"),
    LUCKY_DRAW_THEME("#00ADFF", "#009DFF", R.drawable.ic_confetti_lucky_card, "#FFFFFF"),
    SCRATCH_CARD_VICTORY_THEME("#F02674", "#FF428B", R.drawable.ic_fingers_unit, "#FFFFFF"),
    SCRATCH_CARD_TRUMP_THEME("#3252F0", "#3B68FF", R.drawable.ic_trumpet_unit, "#FFFFFF"),
    SCRATCH_CARD_DIAMOND_THEME("#101F5C", "#22378A", R.drawable.ic_diamond_unit, "#FFFFFF"),
    SCRATCH_CARD_SUNGLASSES_THEME("#FEDB31", "#FFF536", R.drawable.ic_sunglass_unit, "#000000");
    
    private final String bgColor;
    private final int icon;
    private final String textBgColor;
    private final String textColor;

    protected j(String str, String str2, int i2, String str3) {
        k.c(str, "bgColor");
        k.c(str2, "textBgColor");
        k.c(str3, "textColor");
        this.bgColor = str;
        this.textBgColor = str2;
        this.icon = i2;
        this.textColor = str3;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getTextBgColor() {
        return this.textBgColor;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getTextColor() {
        return this.textColor;
    }
}
