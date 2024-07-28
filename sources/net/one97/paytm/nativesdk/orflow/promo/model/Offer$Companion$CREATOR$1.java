package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class Offer$Companion$CREATOR$1 implements Parcelable.Creator<Offer> {
    Offer$Companion$CREATOR$1() {
    }

    public final Offer createFromParcel(Parcel parcel) {
        k.c(parcel, "source");
        return new Offer(parcel);
    }

    public final Offer[] newArray(int i2) {
        return new Offer[i2];
    }
}
