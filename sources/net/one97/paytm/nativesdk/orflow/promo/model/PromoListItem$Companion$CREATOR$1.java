package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class PromoListItem$Companion$CREATOR$1 implements Parcelable.Creator<PromoListItem> {
    PromoListItem$Companion$CREATOR$1() {
    }

    public final PromoListItem createFromParcel(Parcel parcel) {
        k.c(parcel, "source");
        return new PromoListItem(parcel);
    }

    public final PromoListItem[] newArray(int i2) {
        return new PromoListItem[i2];
    }
}
