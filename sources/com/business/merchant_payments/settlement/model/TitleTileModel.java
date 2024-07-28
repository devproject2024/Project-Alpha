package com.business.merchant_payments.settlement.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TitleTileModel {
    public String dateRangeText;
    public String labelTitle;
    public boolean shouldHighlightDateRange;
    public boolean shouldShowDateRange;

    public static /* synthetic */ TitleTileModel copy$default(TitleTileModel titleTileModel, String str, boolean z, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = titleTileModel.labelTitle;
        }
        if ((i2 & 2) != 0) {
            z = titleTileModel.shouldShowDateRange;
        }
        if ((i2 & 4) != 0) {
            str2 = titleTileModel.dateRangeText;
        }
        if ((i2 & 8) != 0) {
            z2 = titleTileModel.shouldHighlightDateRange;
        }
        return titleTileModel.copy(str, z, str2, z2);
    }

    public final String component1() {
        return this.labelTitle;
    }

    public final boolean component2() {
        return this.shouldShowDateRange;
    }

    public final String component3() {
        return this.dateRangeText;
    }

    public final boolean component4() {
        return this.shouldHighlightDateRange;
    }

    public final TitleTileModel copy(String str, boolean z, String str2, boolean z2) {
        k.d(str, "labelTitle");
        k.d(str2, "dateRangeText");
        return new TitleTileModel(str, z, str2, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleTileModel)) {
            return false;
        }
        TitleTileModel titleTileModel = (TitleTileModel) obj;
        return k.a((Object) this.labelTitle, (Object) titleTileModel.labelTitle) && this.shouldShowDateRange == titleTileModel.shouldShowDateRange && k.a((Object) this.dateRangeText, (Object) titleTileModel.dateRangeText) && this.shouldHighlightDateRange == titleTileModel.shouldHighlightDateRange;
    }

    public final int hashCode() {
        String str = this.labelTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.shouldShowDateRange;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.dateRangeText;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = (i3 + i2) * 31;
        boolean z2 = this.shouldHighlightDateRange;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "TitleTileModel(labelTitle=" + this.labelTitle + ", shouldShowDateRange=" + this.shouldShowDateRange + ", dateRangeText=" + this.dateRangeText + ", shouldHighlightDateRange=" + this.shouldHighlightDateRange + ")";
    }

    public TitleTileModel(String str, boolean z, String str2, boolean z2) {
        k.d(str, "labelTitle");
        k.d(str2, "dateRangeText");
        this.labelTitle = str;
        this.shouldShowDateRange = z;
        this.dateRangeText = str2;
        this.shouldHighlightDateRange = z2;
    }

    public final String getLabelTitle() {
        return this.labelTitle;
    }

    public final void setLabelTitle(String str) {
        k.d(str, "<set-?>");
        this.labelTitle = str;
    }

    public final boolean getShouldShowDateRange() {
        return this.shouldShowDateRange;
    }

    public final void setShouldShowDateRange(boolean z) {
        this.shouldShowDateRange = z;
    }

    public final String getDateRangeText() {
        return this.dateRangeText;
    }

    public final void setDateRangeText(String str) {
        k.d(str, "<set-?>");
        this.dateRangeText = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleTileModel(String str, boolean z, String str2, boolean z2, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? false : z2);
    }

    public final boolean getShouldHighlightDateRange() {
        return this.shouldHighlightDateRange;
    }

    public final void setShouldHighlightDateRange(boolean z) {
        this.shouldHighlightDateRange = z;
    }
}
