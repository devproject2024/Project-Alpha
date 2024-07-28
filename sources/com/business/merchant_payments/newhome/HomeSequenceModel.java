package com.business.merchant_payments.newhome;

import kotlin.g.b.g;

public final class HomeSequenceModel {
    public final int customCardEndIndex;
    public final int customCardStartIndex;
    public final int tabWidgetEndIndex;
    public final int tabWidgetStartIndex;

    public HomeSequenceModel() {
        this(0, 0, 0, 0, 15, (g) null);
    }

    public static /* synthetic */ HomeSequenceModel copy$default(HomeSequenceModel homeSequenceModel, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = homeSequenceModel.customCardStartIndex;
        }
        if ((i6 & 2) != 0) {
            i3 = homeSequenceModel.customCardEndIndex;
        }
        if ((i6 & 4) != 0) {
            i4 = homeSequenceModel.tabWidgetStartIndex;
        }
        if ((i6 & 8) != 0) {
            i5 = homeSequenceModel.tabWidgetEndIndex;
        }
        return homeSequenceModel.copy(i2, i3, i4, i5);
    }

    public final int component1() {
        return this.customCardStartIndex;
    }

    public final int component2() {
        return this.customCardEndIndex;
    }

    public final int component3() {
        return this.tabWidgetStartIndex;
    }

    public final int component4() {
        return this.tabWidgetEndIndex;
    }

    public final HomeSequenceModel copy(int i2, int i3, int i4, int i5) {
        return new HomeSequenceModel(i2, i3, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeSequenceModel)) {
            return false;
        }
        HomeSequenceModel homeSequenceModel = (HomeSequenceModel) obj;
        return this.customCardStartIndex == homeSequenceModel.customCardStartIndex && this.customCardEndIndex == homeSequenceModel.customCardEndIndex && this.tabWidgetStartIndex == homeSequenceModel.tabWidgetStartIndex && this.tabWidgetEndIndex == homeSequenceModel.tabWidgetEndIndex;
    }

    public final int hashCode() {
        return (((((this.customCardStartIndex * 31) + this.customCardEndIndex) * 31) + this.tabWidgetStartIndex) * 31) + this.tabWidgetEndIndex;
    }

    public final String toString() {
        return "HomeSequenceModel(customCardStartIndex=" + this.customCardStartIndex + ", customCardEndIndex=" + this.customCardEndIndex + ", tabWidgetStartIndex=" + this.tabWidgetStartIndex + ", tabWidgetEndIndex=" + this.tabWidgetEndIndex + ")";
    }

    public HomeSequenceModel(int i2, int i3, int i4, int i5) {
        this.customCardStartIndex = i2;
        this.customCardEndIndex = i3;
        this.tabWidgetStartIndex = i4;
        this.tabWidgetEndIndex = i5;
    }

    public final int getCustomCardStartIndex() {
        return this.customCardStartIndex;
    }

    public final int getCustomCardEndIndex() {
        return this.customCardEndIndex;
    }

    public final int getTabWidgetStartIndex() {
        return this.tabWidgetStartIndex;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeSequenceModel(int i2, int i3, int i4, int i5, int i6, g gVar) {
        this((i6 & 1) != 0 ? -1 : i2, (i6 & 2) != 0 ? -1 : i3, (i6 & 4) != 0 ? -1 : i4, (i6 & 8) != 0 ? -1 : i5);
    }

    public final int getTabWidgetEndIndex() {
        return this.tabWidgetEndIndex;
    }
}
