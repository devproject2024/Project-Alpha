package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class CJRSessionsItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "sid")

    /* renamed from: a  reason: collision with root package name */
    public String f75190a;
    @b(a = "pid")

    /* renamed from: b  reason: collision with root package name */
    public String f75191b;
    @b(a = "pkey")

    /* renamed from: c  reason: collision with root package name */
    public String f75192c;
    @b(a = "cid")

    /* renamed from: d  reason: collision with root package name */
    public String f75193d;
    @b(a = "mid")

    /* renamed from: e  reason: collision with root package name */
    public String f75194e;
    @b(a = "fid")

    /* renamed from: f  reason: collision with root package name */
    public String f75195f;
    @b(a = "showTime")

    /* renamed from: g  reason: collision with root package name */
    public String f75196g;
    @b(a = "total")

    /* renamed from: h  reason: collision with root package name */
    public String f75197h;
    @b(a = "avail")

    /* renamed from: i  reason: collision with root package name */
    public String f75198i;
    @b(a = "audi")
    public String j;
    @b(a = "premium")
    public Integer k;
    @b(a = "premiumLabel")
    public String l;
    @b(a = "tFeePkupTime")
    public Integer m;
    @b(a = "sType")
    public Integer n;
    @b(a = "tFee")
    public Integer o;
    @b(a = "maxTkt")
    public Integer p;
    @b(a = "scrnFmt")
    public String q;
    @b(a = "statusColor")
    public String r;
    @b(a = "areas")
    public ArrayList<CJRArea> s;
    @b(a = "uProvMCode")
    private String t;
    @b(a = "grpSeats")
    private Integer u;
    @b(a = "sndFmt")
    private String v;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString12 = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf6 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRArea) CJRArea.CREATOR.createFromParcel(parcel2));
                    readInt--;
                    valueOf = valueOf;
                }
            }
            return new CJRSessionsItem(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, valueOf, readString12, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, readString13, readString14, readString15, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRSessionsItem[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSessionsItem)) {
            return false;
        }
        CJRSessionsItem cJRSessionsItem = (CJRSessionsItem) obj;
        return k.a((Object) this.f75190a, (Object) cJRSessionsItem.f75190a) && k.a((Object) this.f75191b, (Object) cJRSessionsItem.f75191b) && k.a((Object) this.f75192c, (Object) cJRSessionsItem.f75192c) && k.a((Object) this.f75193d, (Object) cJRSessionsItem.f75193d) && k.a((Object) this.t, (Object) cJRSessionsItem.t) && k.a((Object) this.f75194e, (Object) cJRSessionsItem.f75194e) && k.a((Object) this.f75195f, (Object) cJRSessionsItem.f75195f) && k.a((Object) this.f75196g, (Object) cJRSessionsItem.f75196g) && k.a((Object) this.f75197h, (Object) cJRSessionsItem.f75197h) && k.a((Object) this.f75198i, (Object) cJRSessionsItem.f75198i) && k.a((Object) this.j, (Object) cJRSessionsItem.j) && k.a((Object) this.k, (Object) cJRSessionsItem.k) && k.a((Object) this.l, (Object) cJRSessionsItem.l) && k.a((Object) this.m, (Object) cJRSessionsItem.m) && k.a((Object) this.n, (Object) cJRSessionsItem.n) && k.a((Object) this.o, (Object) cJRSessionsItem.o) && k.a((Object) this.u, (Object) cJRSessionsItem.u) && k.a((Object) this.p, (Object) cJRSessionsItem.p) && k.a((Object) this.q, (Object) cJRSessionsItem.q) && k.a((Object) this.v, (Object) cJRSessionsItem.v) && k.a((Object) this.r, (Object) cJRSessionsItem.r) && k.a((Object) this.s, (Object) cJRSessionsItem.s);
    }

    public final int hashCode() {
        String str = this.f75190a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f75191b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f75192c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f75193d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.t;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f75194e;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f75195f;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f75196g;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f75197h;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f75198i;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.j;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Integer num = this.k;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 31;
        String str12 = this.l;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Integer num2 = this.m;
        int hashCode14 = (hashCode13 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.n;
        int hashCode15 = (hashCode14 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.o;
        int hashCode16 = (hashCode15 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.u;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.p;
        int hashCode18 = (hashCode17 + (num6 != null ? num6.hashCode() : 0)) * 31;
        String str13 = this.q;
        int hashCode19 = (hashCode18 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.v;
        int hashCode20 = (hashCode19 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.r;
        int hashCode21 = (hashCode20 + (str15 != null ? str15.hashCode() : 0)) * 31;
        ArrayList<CJRArea> arrayList = this.s;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode21 + i2;
    }

    public final String toString() {
        return "CJRSessionsItem(sid=" + this.f75190a + ", pid=" + this.f75191b + ", pKey=" + this.f75192c + ", cid=" + this.f75193d + ", uProvMCode=" + this.t + ", mid=" + this.f75194e + ", fid=" + this.f75195f + ", showTime=" + this.f75196g + ", total=" + this.f75197h + ", avail=" + this.f75198i + ", audi=" + this.j + ", premium=" + this.k + ", premiumLabel=" + this.l + ", tFeePkupTime=" + this.m + ", sType=" + this.n + ", tFee=" + this.o + ", grpSeats=" + this.u + ", maxTkt=" + this.p + ", scrnFmt=" + this.q + ", sndFmt=" + this.v + ", statusColor=" + this.r + ", areas=" + this.s + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f75190a);
        parcel.writeString(this.f75191b);
        parcel.writeString(this.f75192c);
        parcel.writeString(this.f75193d);
        parcel.writeString(this.t);
        parcel.writeString(this.f75194e);
        parcel.writeString(this.f75195f);
        parcel.writeString(this.f75196g);
        parcel.writeString(this.f75197h);
        parcel.writeString(this.f75198i);
        parcel.writeString(this.j);
        Integer num = this.k;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.l);
        Integer num2 = this.m;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.n;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num4 = this.o;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num5 = this.u;
        if (num5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num6 = this.p;
        if (num6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.q);
        parcel.writeString(this.v);
        parcel.writeString(this.r);
        ArrayList<CJRArea> arrayList = this.s;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRArea writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRSessionsItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str13, String str14, String str15, ArrayList<CJRArea> arrayList) {
        this.f75190a = str;
        this.f75191b = str2;
        this.f75192c = str3;
        this.f75193d = str4;
        this.t = str5;
        this.f75194e = str6;
        this.f75195f = str7;
        this.f75196g = str8;
        this.f75197h = str9;
        this.f75198i = str10;
        this.j = str11;
        this.k = num;
        this.l = str12;
        this.m = num2;
        this.n = num3;
        this.o = num4;
        this.u = num5;
        this.p = num6;
        this.q = str13;
        this.v = str14;
        this.r = str15;
        this.s = arrayList;
    }

    private /* synthetic */ CJRSessionsItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (ArrayList<CJRArea>) null);
    }
}
