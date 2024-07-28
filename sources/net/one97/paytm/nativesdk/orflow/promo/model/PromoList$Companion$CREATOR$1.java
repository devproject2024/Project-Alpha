package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class PromoList$Companion$CREATOR$1 implements Parcelable.Creator<PromoList> {
    PromoList$Companion$CREATOR$1() {
    }

    public final PromoList createFromParcel(Parcel parcel) {
        k.c(parcel, "source");
        return new PromoList(parcel);
    }

    public final PromoList[] newArray(int i2) {
        return new PromoList[i2];
    }
}
