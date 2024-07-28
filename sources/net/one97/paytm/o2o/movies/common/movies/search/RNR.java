package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class RNR implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "rating")

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Rating> f75202a;
    @b(a = "hasUReview")

    /* renamed from: b  reason: collision with root package name */
    public Integer f75203b;
    @b(a = "hasContent")

    /* renamed from: c  reason: collision with root package name */
    public Integer f75204c;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            Integer num = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Rating) Rating.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new RNR(arrayList, valueOf, num);
        }

        public final Object[] newArray(int i2) {
            return new RNR[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RNR)) {
            return false;
        }
        RNR rnr = (RNR) obj;
        return k.a((Object) this.f75202a, (Object) rnr.f75202a) && k.a((Object) this.f75203b, (Object) rnr.f75203b) && k.a((Object) this.f75204c, (Object) rnr.f75204c);
    }

    public final int hashCode() {
        ArrayList<Rating> arrayList = this.f75202a;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        Integer num = this.f75203b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.f75204c;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "RNR(rating=" + this.f75202a + ", hasUReview=" + this.f75203b + ", hasContent=" + this.f75204c + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<Rating> arrayList = this.f75202a;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (Rating writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.f75203b;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.f75204c;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public RNR(ArrayList<Rating> arrayList, Integer num, Integer num2) {
        this.f75202a = arrayList;
        this.f75203b = num;
        this.f75204c = num2;
    }

    private /* synthetic */ RNR() {
        this((ArrayList<Rating>) null, 0, 0);
    }
}
