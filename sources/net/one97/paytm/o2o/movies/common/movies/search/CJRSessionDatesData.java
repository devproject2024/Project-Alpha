package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class CJRSessionDatesData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "sessionDates")

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f75187a;
    @b(a = "cinemasOrder")

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f75188b;
    @b(a = "pageSize")

    /* renamed from: c  reason: collision with root package name */
    public Integer f75189c;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            k.c(parcel, "in");
            Integer num = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(parcel.readString());
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add(Integer.valueOf(parcel.readInt()));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new CJRSessionDatesData(arrayList, arrayList2, num);
        }

        public final Object[] newArray(int i2) {
            return new CJRSessionDatesData[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSessionDatesData)) {
            return false;
        }
        CJRSessionDatesData cJRSessionDatesData = (CJRSessionDatesData) obj;
        return k.a((Object) this.f75187a, (Object) cJRSessionDatesData.f75187a) && k.a((Object) this.f75188b, (Object) cJRSessionDatesData.f75188b) && k.a((Object) this.f75189c, (Object) cJRSessionDatesData.f75189c);
    }

    public final int hashCode() {
        ArrayList<String> arrayList = this.f75187a;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<Integer> arrayList2 = this.f75188b;
        int hashCode2 = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        Integer num = this.f75189c;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRSessionDatesData(sessionDates=" + this.f75187a + ", cinemasOrder=" + this.f75188b + ", pageSize=" + this.f75189c + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<String> arrayList = this.f75187a;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (String writeString : arrayList) {
                parcel.writeString(writeString);
            }
        } else {
            parcel.writeInt(0);
        }
        ArrayList<Integer> arrayList2 = this.f75188b;
        if (arrayList2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            for (Integer intValue : arrayList2) {
                parcel.writeInt(intValue.intValue());
            }
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.f75189c;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public CJRSessionDatesData(ArrayList<String> arrayList, ArrayList<Integer> arrayList2, Integer num) {
        this.f75187a = arrayList;
        this.f75188b = arrayList2;
        this.f75189c = num;
    }

    private /* synthetic */ CJRSessionDatesData() {
        this((ArrayList<String>) null, (ArrayList<Integer>) null, 0);
    }
}
