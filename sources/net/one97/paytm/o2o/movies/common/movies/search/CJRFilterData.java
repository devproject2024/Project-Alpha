package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class CJRFilterData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "minSTime")

    /* renamed from: a  reason: collision with root package name */
    public String f75165a;
    @b(a = "maxSTime")

    /* renamed from: b  reason: collision with root package name */
    public String f75166b;
    @b(a = "minPrice")

    /* renamed from: c  reason: collision with root package name */
    public Double f75167c;
    @b(a = "maxPrice")

    /* renamed from: d  reason: collision with root package name */
    public Double f75168d;
    @b(a = "premium")

    /* renamed from: e  reason: collision with root package name */
    public Boolean f75169e;
    @b(a = "scnFrmts")

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f75170f;
    @b(a = "freeSeats")

    /* renamed from: g  reason: collision with root package name */
    private Boolean f75171g;
    @b(a = "groupSeats")

    /* renamed from: h  reason: collision with root package name */
    private Boolean f75172h;
    @b(a = "tokenFeeSeats")

    /* renamed from: i  reason: collision with root package name */
    private Boolean f75173i;
    @b(a = "sndFrmts")
    private ArrayList<String> j;
    @b(a = "mLangs")
    private ArrayList<String> k;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Double valueOf = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            if (parcel.readInt() != 0) {
                bool3 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool3 = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool4 = Boolean.valueOf(z);
            } else {
                bool4 = null;
            }
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
                    arrayList2.add(parcel.readString());
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList4.add(parcel.readString());
                    readInt3--;
                }
                arrayList3 = arrayList4;
            } else {
                arrayList3 = null;
            }
            return new CJRFilterData(readString, readString2, valueOf, valueOf2, bool, bool2, bool3, bool4, arrayList, arrayList2, arrayList3);
        }

        public final Object[] newArray(int i2) {
            return new CJRFilterData[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRFilterData)) {
            return false;
        }
        CJRFilterData cJRFilterData = (CJRFilterData) obj;
        return k.a((Object) this.f75165a, (Object) cJRFilterData.f75165a) && k.a((Object) this.f75166b, (Object) cJRFilterData.f75166b) && k.a((Object) this.f75167c, (Object) cJRFilterData.f75167c) && k.a((Object) this.f75168d, (Object) cJRFilterData.f75168d) && k.a((Object) this.f75169e, (Object) cJRFilterData.f75169e) && k.a((Object) this.f75171g, (Object) cJRFilterData.f75171g) && k.a((Object) this.f75172h, (Object) cJRFilterData.f75172h) && k.a((Object) this.f75173i, (Object) cJRFilterData.f75173i) && k.a((Object) this.f75170f, (Object) cJRFilterData.f75170f) && k.a((Object) this.j, (Object) cJRFilterData.j) && k.a((Object) this.k, (Object) cJRFilterData.k);
    }

    public final int hashCode() {
        String str = this.f75165a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f75166b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.f75167c;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.f75168d;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Boolean bool = this.f75169e;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.f75171g;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.f75172h;
        int hashCode7 = (hashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.f75173i;
        int hashCode8 = (hashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.f75170f;
        int hashCode9 = (hashCode8 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        ArrayList<String> arrayList2 = this.j;
        int hashCode10 = (hashCode9 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        ArrayList<String> arrayList3 = this.k;
        if (arrayList3 != null) {
            i2 = arrayList3.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "CJRFilterData(minSTime=" + this.f75165a + ", maxSTime=" + this.f75166b + ", minPrice=" + this.f75167c + ", maxPrice=" + this.f75168d + ", premium=" + this.f75169e + ", freeSeats=" + this.f75171g + ", groupSeats=" + this.f75172h + ", tokenFeeSeats=" + this.f75173i + ", scnFrmts=" + this.f75170f + ", sndFrmts=" + this.j + ", mLangs=" + this.k + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f75165a);
        parcel.writeString(this.f75166b);
        Double d2 = this.f75167c;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Double d3 = this.f75168d;
        if (d3 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d3.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.f75169e;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.f75171g;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool3 = this.f75172h;
        if (bool3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool4 = this.f75173i;
        if (bool4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        ArrayList<String> arrayList = this.f75170f;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (String writeString : arrayList) {
                parcel.writeString(writeString);
            }
        } else {
            parcel.writeInt(0);
        }
        ArrayList<String> arrayList2 = this.j;
        if (arrayList2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            for (String writeString2 : arrayList2) {
                parcel.writeString(writeString2);
            }
        } else {
            parcel.writeInt(0);
        }
        ArrayList<String> arrayList3 = this.k;
        if (arrayList3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList3.size());
            for (String writeString3 : arrayList3) {
                parcel.writeString(writeString3);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRFilterData(String str, String str2, Double d2, Double d3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        this.f75165a = str;
        this.f75166b = str2;
        this.f75167c = d2;
        this.f75168d = d3;
        this.f75169e = bool;
        this.f75171g = bool2;
        this.f75172h = bool3;
        this.f75173i = bool4;
        this.f75170f = arrayList;
        this.j = arrayList2;
        this.k = arrayList3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private /* synthetic */ CJRFilterData() {
        /*
            r14 = this;
            r0 = 0
            java.lang.Double r6 = java.lang.Double.valueOf(r0)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r3 = 0
            r4 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r2 = r14
            r5 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData.<init>():void");
    }
}
