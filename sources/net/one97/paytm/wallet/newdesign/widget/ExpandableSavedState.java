package net.one97.paytm.wallet.newdesign.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ExpandableSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ExpandableSavedState> CREATOR = new Parcelable.Creator<ExpandableSavedState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ExpandableSavedState[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ExpandableSavedState(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f71484a;

    /* renamed from: b  reason: collision with root package name */
    private float f71485b;

    /* synthetic */ ExpandableSavedState(Parcel parcel, byte b2) {
        this(parcel);
    }

    ExpandableSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private ExpandableSavedState(Parcel parcel) {
        super(parcel);
        this.f71484a = parcel.readInt();
        this.f71485b = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f71484a);
        parcel.writeFloat(this.f71485b);
    }
}
