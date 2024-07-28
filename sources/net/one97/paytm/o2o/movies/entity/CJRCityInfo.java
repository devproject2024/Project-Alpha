package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRCityInfo implements IJRDataModel {
    @b(a = "id")
    private Integer id;
    @b(a = "imgPath")
    private String imgPath;
    @b(a = "lat")
    private Double lat;
    @b(a = "lon")
    private Double lon;
    @b(a = "name")
    private String name;
    @b(a = "searchable")
    private ArrayList<String> searchable;
    @b(a = "value")
    private String value;

    public CJRCityInfo() {
        this((Integer) null, (String) null, (String) null, (ArrayList) null, (String) null, (Double) null, (Double) null, 127, (g) null);
    }

    public static /* synthetic */ CJRCityInfo copy$default(CJRCityInfo cJRCityInfo, Integer num, String str, String str2, ArrayList<String> arrayList, String str3, Double d2, Double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRCityInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = cJRCityInfo.name;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = cJRCityInfo.value;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            arrayList = cJRCityInfo.searchable;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i2 & 16) != 0) {
            str3 = cJRCityInfo.imgPath;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            d2 = cJRCityInfo.lat;
        }
        Double d4 = d2;
        if ((i2 & 64) != 0) {
            d3 = cJRCityInfo.lon;
        }
        return cJRCityInfo.copy(num, str4, str5, arrayList2, str6, d4, d3);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.value;
    }

    public final ArrayList<String> component4() {
        return this.searchable;
    }

    public final String component5() {
        return this.imgPath;
    }

    public final Double component6() {
        return this.lat;
    }

    public final Double component7() {
        return this.lon;
    }

    public final CJRCityInfo copy(Integer num, String str, String str2, ArrayList<String> arrayList, String str3, Double d2, Double d3) {
        return new CJRCityInfo(num, str, str2, arrayList, str3, d2, d3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCityInfo)) {
            return false;
        }
        CJRCityInfo cJRCityInfo = (CJRCityInfo) obj;
        return k.a((Object) this.id, (Object) cJRCityInfo.id) && k.a((Object) this.name, (Object) cJRCityInfo.name) && k.a((Object) this.value, (Object) cJRCityInfo.value) && k.a((Object) this.searchable, (Object) cJRCityInfo.searchable) && k.a((Object) this.imgPath, (Object) cJRCityInfo.imgPath) && k.a((Object) this.lat, (Object) cJRCityInfo.lat) && k.a((Object) this.lon, (Object) cJRCityInfo.lon);
    }

    public final int hashCode() {
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.searchable;
        int hashCode4 = (hashCode3 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str3 = this.imgPath;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d2 = this.lat;
        int hashCode6 = (hashCode5 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.lon;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CJRCityInfo(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ", searchable=" + this.searchable + ", imgPath=" + this.imgPath + ", lat=" + this.lat + ", lon=" + this.lon + ")";
    }

    public CJRCityInfo(Integer num, String str, String str2, ArrayList<String> arrayList, String str3, Double d2, Double d3) {
        this.id = num;
        this.name = str;
        this.value = str2;
        this.searchable = arrayList;
        this.imgPath = str3;
        this.lat = d2;
        this.lon = d3;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final ArrayList<String> getSearchable() {
        return this.searchable;
    }

    public final void setSearchable(ArrayList<String> arrayList) {
        this.searchable = arrayList;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final void setImgPath(String str) {
        this.imgPath = str;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final void setLat(Double d2) {
        this.lat = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRCityInfo(java.lang.Integer r7, java.lang.String r8, java.lang.String r9, java.util.ArrayList r10, java.lang.String r11, java.lang.Double r12, java.lang.Double r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRCityInfo.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.Double, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getLon() {
        return this.lon;
    }

    public final void setLon(Double d2) {
        this.lon = d2;
    }
}
