package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new RatingCompat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f856a;

    /* renamed from: b  reason: collision with root package name */
    private final float f857b;

    RatingCompat(int i2, float f2) {
        this.f856a = i2;
        this.f857b = f2;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f856a);
        sb.append(" rating=");
        float f2 = this.f857b;
        if (f2 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f2);
        }
        sb.append(str);
        return sb.toString();
    }

    public final int describeContents() {
        return this.f856a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f856a);
        parcel.writeFloat(this.f857b);
    }
}
