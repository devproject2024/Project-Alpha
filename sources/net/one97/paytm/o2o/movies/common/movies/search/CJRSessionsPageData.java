package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class CJRSessionsPageData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "sessions")

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRSessionsItem> f75199a;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRSessionsItem) CJRSessionsItem.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CJRSessionsPageData(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRSessionsPageData[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRSessionsPageData) && k.a((Object) this.f75199a, (Object) ((CJRSessionsPageData) obj).f75199a);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRSessionsItem> arrayList = this.f75199a;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRSessionsPageData(sessions=" + this.f75199a + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRSessionsItem> arrayList = this.f75199a;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRSessionsItem writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRSessionsPageData(ArrayList<CJRSessionsItem> arrayList) {
        this.f75199a = arrayList;
    }

    private /* synthetic */ CJRSessionsPageData() {
        this((ArrayList<CJRSessionsItem>) null);
    }
}
