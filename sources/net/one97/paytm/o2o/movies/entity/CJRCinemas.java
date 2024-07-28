package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRCinemas implements Parcelable, Comparable<CJRCinemas>, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "address")
    private String address;
    @b(a = "amenities")
    private HashMap<String, Integer> amenitiesMap;
    @b(a = "appCovrImgUrl")
    private String appCovrImgUrl;
    @b(a = "bCode")
    private String bCode;
    @b(a = "chainLogoUrl")
    private String chainLogoUrl;
    @b(a = "city")
    private String city;
    @b(a = "covrImgUrl")
    private String covrImgUrl;
    @b(a = "distance")
    private double distance;
    @b(a = "fnb")
    private Integer fnb;
    @b(a = "isMapped")
    private Integer isCurrentCityCinema;
    @b(a = "isItemViewed")
    private Boolean isItemViewed;
    @b(a = "userPref")
    private Integer is_preferred_cinema;
    @b(a = "lat")
    private Double latitude;
    @b(a = "lon")
    private Double longitude;
    @b(a = "mTkt")
    private Integer mTkt;
    @b(a = "label")
    private String name;
    @b(a = "orderFactor")
    private Integer orderFactor;
    @b(a = "id")
    private Integer paytmCinemaId;
    @b(a = "promos")
    private ArrayList<Promo> promos;
    @b(a = "pid")
    private Long providerId;
    @b(a = "sessionCount")
    private Integer sessionCount;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            HashMap hashMap;
            Boolean bool;
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            Double valueOf = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            Long valueOf3 = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    hashMap.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
                    readInt--;
                }
            } else {
                hashMap = null;
            }
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Integer valueOf6 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            double readDouble = parcel.readDouble();
            Integer valueOf7 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString6 = parcel.readString();
            Integer valueOf8 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString7 = parcel.readString();
            Integer valueOf9 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf10 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add((Promo) Promo.CREATOR.createFromParcel(parcel2));
                    readInt2--;
                    valueOf6 = valueOf6;
                }
            }
            return new CJRCinemas(readString, readString2, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, hashMap, readString3, readString4, readString5, valueOf6, readDouble, valueOf7, readString6, valueOf8, readString7, valueOf9, valueOf10, bool, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRCinemas[i2];
        }
    }

    public CJRCinemas() {
        this((String) null, (String) null, (Double) null, (Double) null, (Long) null, (Integer) null, (Integer) null, (HashMap) null, (String) null, (String) null, (String) null, (Integer) null, 0.0d, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, (ArrayList) null, 2097151, (g) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.address);
        Double d2 = this.latitude;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Double d3 = this.longitude;
        if (d3 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d3.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Long l = this.providerId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.paytmCinemaId;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.isCurrentCityCinema;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        HashMap<String, Integer> hashMap = this.amenitiesMap;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, Integer> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                parcel.writeInt(next.getValue().intValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.chainLogoUrl);
        parcel.writeString(this.covrImgUrl);
        parcel.writeString(this.appCovrImgUrl);
        Integer num3 = this.sessionCount;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeDouble(this.distance);
        Integer num4 = this.fnb;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.city);
        Integer num5 = this.orderFactor;
        if (num5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.bCode);
        Integer num6 = this.mTkt;
        if (num6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num7 = this.is_preferred_cinema;
        if (num7 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num7.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isItemViewed;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        ArrayList<Promo> arrayList = this.promos;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (Promo writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRCinemas(String str, String str2, Double d2, Double d3, Long l, Integer num, Integer num2, HashMap<String, Integer> hashMap, String str3, String str4, String str5, Integer num3, double d4, Integer num4, String str6, Integer num5, String str7, Integer num6, Integer num7, Boolean bool, ArrayList<Promo> arrayList) {
        this.name = str;
        this.address = str2;
        this.latitude = d2;
        this.longitude = d3;
        this.providerId = l;
        this.paytmCinemaId = num;
        this.isCurrentCityCinema = num2;
        this.amenitiesMap = hashMap;
        this.chainLogoUrl = str3;
        this.covrImgUrl = str4;
        this.appCovrImgUrl = str5;
        this.sessionCount = num3;
        this.distance = d4;
        this.fnb = num4;
        this.city = str6;
        this.orderFactor = num5;
        this.bCode = str7;
        this.mTkt = num6;
        this.is_preferred_cinema = num7;
        this.isItemViewed = bool;
        this.promos = arrayList;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(Double d2) {
        this.latitude = d2;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(Double d2) {
        this.longitude = d2;
    }

    public final Long getProviderId() {
        return this.providerId;
    }

    public final void setProviderId(Long l) {
        this.providerId = l;
    }

    public final Integer getPaytmCinemaId() {
        return this.paytmCinemaId;
    }

    public final void setPaytmCinemaId(Integer num) {
        this.paytmCinemaId = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRCinemas(java.lang.String r24, java.lang.String r25, java.lang.Double r26, java.lang.Double r27, java.lang.Long r28, java.lang.Integer r29, java.lang.Integer r30, java.util.HashMap r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.Integer r35, double r36, java.lang.Integer r38, java.lang.String r39, java.lang.Integer r40, java.lang.String r41, java.lang.Integer r42, java.lang.Integer r43, java.lang.Boolean r44, java.util.ArrayList r45, int r46, kotlin.g.b.g r47) {
        /*
            r23 = this;
            r0 = r46
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r24
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r25
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r26
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r27
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r28
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r29
        L_0x0032:
            r8 = r0 & 64
            r9 = 0
            if (r8 == 0) goto L_0x003c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            goto L_0x003e
        L_0x003c:
            r8 = r30
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0044
            r10 = 0
            goto L_0x0046
        L_0x0044:
            r10 = r31
        L_0x0046:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004c
            r11 = 0
            goto L_0x004e
        L_0x004c:
            r11 = r32
        L_0x004e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0054
            r12 = 0
            goto L_0x0056
        L_0x0054:
            r12 = r33
        L_0x0056:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005c
            r13 = 0
            goto L_0x005e
        L_0x005c:
            r13 = r34
        L_0x005e:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0064
            r14 = 0
            goto L_0x0066
        L_0x0064:
            r14 = r35
        L_0x0066:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006d
            r15 = 0
            goto L_0x006f
        L_0x006d:
            r15 = r36
        L_0x006f:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0078
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x007a
        L_0x0078:
            r2 = r38
        L_0x007a:
            r9 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x0080
            r9 = 0
            goto L_0x0082
        L_0x0080:
            r9 = r39
        L_0x0082:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            java.lang.Integer r18 = java.lang.Integer.valueOf(r17)
            goto L_0x0094
        L_0x0090:
            r17 = 0
            r18 = r40
        L_0x0094:
            r19 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x009d
            r19 = 0
            goto L_0x009f
        L_0x009d:
            r19 = r41
        L_0x009f:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00aa
            java.lang.Integer r20 = java.lang.Integer.valueOf(r17)
            goto L_0x00ac
        L_0x00aa:
            r20 = r42
        L_0x00ac:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b7
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)
            goto L_0x00b9
        L_0x00b7:
            r17 = r43
        L_0x00b9:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c2
            java.lang.Boolean r21 = java.lang.Boolean.FALSE
            goto L_0x00c4
        L_0x00c2:
            r21 = r44
        L_0x00c4:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r22
            if (r0 == 0) goto L_0x00cc
            r0 = 0
            goto L_0x00ce
        L_0x00cc:
            r0 = r45
        L_0x00ce:
            r24 = r23
            r25 = r1
            r26 = r3
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r8
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r13
            r36 = r14
            r37 = r15
            r39 = r2
            r40 = r9
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r17
            r45 = r21
            r46 = r0
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRCinemas.<init>(java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Long, java.lang.Integer, java.lang.Integer, java.util.HashMap, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, double, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final Integer isCurrentCityCinema() {
        return this.isCurrentCityCinema;
    }

    public final void setCurrentCityCinema(Integer num) {
        this.isCurrentCityCinema = num;
    }

    public final HashMap<String, Integer> getAmenitiesMap() {
        return this.amenitiesMap;
    }

    public final void setAmenitiesMap(HashMap<String, Integer> hashMap) {
        this.amenitiesMap = hashMap;
    }

    public final String getChainLogoUrl() {
        return this.chainLogoUrl;
    }

    public final void setChainLogoUrl(String str) {
        this.chainLogoUrl = str;
    }

    public final String getCovrImgUrl() {
        return this.covrImgUrl;
    }

    public final void setCovrImgUrl(String str) {
        this.covrImgUrl = str;
    }

    public final String getAppCovrImgUrl() {
        return this.appCovrImgUrl;
    }

    public final void setAppCovrImgUrl(String str) {
        this.appCovrImgUrl = str;
    }

    public final Integer getSessionCount() {
        return this.sessionCount;
    }

    public final void setSessionCount(Integer num) {
        this.sessionCount = num;
    }

    public final double getDistance() {
        return this.distance;
    }

    public final void setDistance(double d2) {
        this.distance = d2;
    }

    public final Integer getFnb() {
        return this.fnb;
    }

    public final void setFnb(Integer num) {
        this.fnb = num;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final Integer getOrderFactor() {
        return this.orderFactor;
    }

    public final void setOrderFactor(Integer num) {
        this.orderFactor = num;
    }

    public final String getBCode() {
        return this.bCode;
    }

    public final void setBCode(String str) {
        this.bCode = str;
    }

    public final Integer getMTkt() {
        return this.mTkt;
    }

    public final void setMTkt(Integer num) {
        this.mTkt = num;
    }

    public final Integer is_preferred_cinema() {
        return this.is_preferred_cinema;
    }

    public final void set_preferred_cinema(Integer num) {
        this.is_preferred_cinema = num;
    }

    public final Boolean isItemViewed() {
        return this.isItemViewed;
    }

    public final void setItemViewed(Boolean bool) {
        this.isItemViewed = bool;
    }

    public final ArrayList<Promo> getPromos() {
        return this.promos;
    }

    public final void setPromos(ArrayList<Promo> arrayList) {
        this.promos = arrayList;
    }

    public final int compareTo(CJRCinemas cJRCinemas) {
        k.c(cJRCinemas, "other");
        double d2 = this.distance;
        double d3 = cJRCinemas.distance;
        if (d2 > d3) {
            return 1;
        }
        return d2 < d3 ? -1 : 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CJRCinemas)) {
            return false;
        }
        Integer num = ((CJRCinemas) obj).paytmCinemaId;
        Boolean valueOf = num != null ? Boolean.valueOf(num.equals(this.paytmCinemaId)) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.booleanValue();
    }

    public final int hashCode() {
        Integer num = this.paytmCinemaId;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
