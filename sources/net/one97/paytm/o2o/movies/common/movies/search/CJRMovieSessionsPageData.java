package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class CJRMovieSessionsPageData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "sessions")

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<CJRSessionsItem>> f75178a;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            HashMap hashMap;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    String readString = parcel.readString();
                    int readInt2 = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt2);
                    while (readInt2 != 0) {
                        arrayList.add((CJRSessionsItem) CJRSessionsItem.CREATOR.createFromParcel(parcel));
                        readInt2--;
                    }
                    hashMap.put(readString, arrayList);
                    readInt--;
                }
            } else {
                hashMap = null;
            }
            return new CJRMovieSessionsPageData(hashMap);
        }

        public final Object[] newArray(int i2) {
            return new CJRMovieSessionsPageData[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMovieSessionsPageData) && k.a((Object) this.f75178a, (Object) ((CJRMovieSessionsPageData) obj).f75178a);
        }
        return true;
    }

    public final int hashCode() {
        HashMap<String, ArrayList<CJRSessionsItem>> hashMap = this.f75178a;
        if (hashMap != null) {
            return hashMap.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMovieSessionsPageData(sessions=" + this.f75178a + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        HashMap<String, ArrayList<CJRSessionsItem>> hashMap = this.f75178a;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, ArrayList<CJRSessionsItem>> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                ArrayList<CJRSessionsItem> value = next.getValue();
                parcel.writeInt(value.size());
                for (CJRSessionsItem writeToParcel : value) {
                    writeToParcel.writeToParcel(parcel, 0);
                }
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMovieSessionsPageData(HashMap<String, ArrayList<CJRSessionsItem>> hashMap) {
        this.f75178a = hashMap;
    }

    private /* synthetic */ CJRMovieSessionsPageData() {
        this((HashMap<String, ArrayList<CJRSessionsItem>>) null);
    }
}
