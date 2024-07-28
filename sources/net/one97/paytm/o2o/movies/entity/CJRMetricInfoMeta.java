package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMetricInfoMeta implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "movieMappings")
    private HashMap<String, String> movieMappings;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            HashMap hashMap;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    hashMap.put(parcel.readString(), parcel.readString());
                    readInt--;
                }
            } else {
                hashMap = null;
            }
            return new CJRMetricInfoMeta(hashMap);
        }

        public final Object[] newArray(int i2) {
            return new CJRMetricInfoMeta[i2];
        }
    }

    public CJRMetricInfoMeta() {
        this((HashMap) null, 1, (g) null);
    }

    public static /* synthetic */ CJRMetricInfoMeta copy$default(CJRMetricInfoMeta cJRMetricInfoMeta, HashMap<String, String> hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hashMap = cJRMetricInfoMeta.movieMappings;
        }
        return cJRMetricInfoMeta.copy(hashMap);
    }

    public final HashMap<String, String> component1() {
        return this.movieMappings;
    }

    public final CJRMetricInfoMeta copy(HashMap<String, String> hashMap) {
        return new CJRMetricInfoMeta(hashMap);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMetricInfoMeta) && k.a((Object) this.movieMappings, (Object) ((CJRMetricInfoMeta) obj).movieMappings);
        }
        return true;
    }

    public final int hashCode() {
        HashMap<String, String> hashMap = this.movieMappings;
        if (hashMap != null) {
            return hashMap.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMetricInfoMeta(movieMappings=" + this.movieMappings + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        HashMap<String, String> hashMap = this.movieMappings;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, String> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                parcel.writeString(next.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMetricInfoMeta(HashMap<String, String> hashMap) {
        this.movieMappings = hashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMetricInfoMeta(HashMap hashMap, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : hashMap);
    }

    public final HashMap<String, String> getMovieMappings() {
        return this.movieMappings;
    }

    public final void setMovieMappings(HashMap<String, String> hashMap) {
        this.movieMappings = hashMap;
    }
}
