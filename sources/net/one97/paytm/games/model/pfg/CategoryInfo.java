package net.one97.paytm.games.model.pfg;

import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CategoryInfo extends BaseResult {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final int TYPE_ICON = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_IMAGE = 1;
    /* access modifiers changed from: private */
    public static final int TYPE_RECENT = 3;
    /* access modifiers changed from: private */
    public static final int TYPE_SVG = 2;
    private int cardType = -1;
    private List<Game> data;
    private String titleIconUrl = "";
    private String titleName = "";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getTYPE_ICON() {
            return CategoryInfo.TYPE_ICON;
        }

        public final int getTYPE_IMAGE() {
            return CategoryInfo.TYPE_IMAGE;
        }

        public final int getTYPE_SVG() {
            return CategoryInfo.TYPE_SVG;
        }

        public final int getTYPE_RECENT() {
            return CategoryInfo.TYPE_RECENT;
        }
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final void setTitleName(String str) {
        k.c(str, "<set-?>");
        this.titleName = str;
    }

    public final String getTitleIconUrl() {
        return this.titleIconUrl;
    }

    public final void setTitleIconUrl(String str) {
        k.c(str, "<set-?>");
        this.titleIconUrl = str;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final void setCardType(int i2) {
        this.cardType = i2;
    }

    public final List<Game> getData() {
        return this.data;
    }

    public final void setData(List<Game> list) {
        this.data = list;
    }
}
