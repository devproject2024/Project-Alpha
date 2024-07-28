package com.business.merchant_payments.settlement.model;

public final class NoSettlementsDataAdapterModel {
    public int calendarViewVisibility;
    public int cardImageResourceId;
    public int cardTextResourceId;
    public boolean shouldHighLightDateRange;

    public static /* synthetic */ NoSettlementsDataAdapterModel copy$default(NoSettlementsDataAdapterModel noSettlementsDataAdapterModel, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = noSettlementsDataAdapterModel.cardImageResourceId;
        }
        if ((i5 & 2) != 0) {
            i3 = noSettlementsDataAdapterModel.cardTextResourceId;
        }
        if ((i5 & 4) != 0) {
            i4 = noSettlementsDataAdapterModel.calendarViewVisibility;
        }
        if ((i5 & 8) != 0) {
            z = noSettlementsDataAdapterModel.shouldHighLightDateRange;
        }
        return noSettlementsDataAdapterModel.copy(i2, i3, i4, z);
    }

    public final int component1() {
        return this.cardImageResourceId;
    }

    public final int component2() {
        return this.cardTextResourceId;
    }

    public final int component3() {
        return this.calendarViewVisibility;
    }

    public final boolean component4() {
        return this.shouldHighLightDateRange;
    }

    public final NoSettlementsDataAdapterModel copy(int i2, int i3, int i4, boolean z) {
        return new NoSettlementsDataAdapterModel(i2, i3, i4, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoSettlementsDataAdapterModel)) {
            return false;
        }
        NoSettlementsDataAdapterModel noSettlementsDataAdapterModel = (NoSettlementsDataAdapterModel) obj;
        return this.cardImageResourceId == noSettlementsDataAdapterModel.cardImageResourceId && this.cardTextResourceId == noSettlementsDataAdapterModel.cardTextResourceId && this.calendarViewVisibility == noSettlementsDataAdapterModel.calendarViewVisibility && this.shouldHighLightDateRange == noSettlementsDataAdapterModel.shouldHighLightDateRange;
    }

    public final int hashCode() {
        int i2 = ((((this.cardImageResourceId * 31) + this.cardTextResourceId) * 31) + this.calendarViewVisibility) * 31;
        boolean z = this.shouldHighLightDateRange;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public final String toString() {
        return "NoSettlementsDataAdapterModel(cardImageResourceId=" + this.cardImageResourceId + ", cardTextResourceId=" + this.cardTextResourceId + ", calendarViewVisibility=" + this.calendarViewVisibility + ", shouldHighLightDateRange=" + this.shouldHighLightDateRange + ")";
    }

    public NoSettlementsDataAdapterModel(int i2, int i3, int i4, boolean z) {
        this.cardImageResourceId = i2;
        this.cardTextResourceId = i3;
        this.calendarViewVisibility = i4;
        this.shouldHighLightDateRange = z;
    }

    public final int getCardImageResourceId() {
        return this.cardImageResourceId;
    }

    public final void setCardImageResourceId(int i2) {
        this.cardImageResourceId = i2;
    }

    public final int getCardTextResourceId() {
        return this.cardTextResourceId;
    }

    public final void setCardTextResourceId(int i2) {
        this.cardTextResourceId = i2;
    }

    public final int getCalendarViewVisibility() {
        return this.calendarViewVisibility;
    }

    public final void setCalendarViewVisibility(int i2) {
        this.calendarViewVisibility = i2;
    }

    public final boolean getShouldHighLightDateRange() {
        return this.shouldHighLightDateRange;
    }

    public final void setShouldHighLightDateRange(boolean z) {
        this.shouldHighLightDateRange = z;
    }
}
