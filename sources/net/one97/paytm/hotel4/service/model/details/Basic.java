package net.one97.paytm.hotel4.service.model.details;

import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class Basic {
    public static final Companion Companion = new Companion((g) null);
    private String airConditioning;
    private String bar;
    private String businessCentre;
    private String gym;
    private String hairdryer;
    private String iron;
    private String minibar;
    private String parking;
    private String restaurant;
    private String roomService;
    private String swimmingPool;
    private String telephone;
    private String television;
    private String toiletries;
    private String twentyFourHrCheckIn;
    private String wifi;

    public Basic() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 65535, (g) null);
    }

    public Basic(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.twentyFourHrCheckIn = str;
        this.airConditioning = str2;
        this.wifi = str3;
        this.roomService = str4;
        this.restaurant = str5;
        this.bar = str6;
        this.gym = str7;
        this.swimmingPool = str8;
        this.businessCentre = str9;
        this.parking = str10;
        this.minibar = str11;
        this.television = str12;
        this.telephone = str13;
        this.iron = str14;
        this.hairdryer = str15;
        this.toiletries = str16;
    }

    public final String getTwentyFourHrCheckIn() {
        return this.twentyFourHrCheckIn;
    }

    public final void setTwentyFourHrCheckIn(String str) {
        this.twentyFourHrCheckIn = str;
    }

    public final String getAirConditioning() {
        return this.airConditioning;
    }

    public final void setAirConditioning(String str) {
        this.airConditioning = str;
    }

    public final String getWifi() {
        return this.wifi;
    }

    public final void setWifi(String str) {
        this.wifi = str;
    }

    public final String getRoomService() {
        return this.roomService;
    }

    public final void setRoomService(String str) {
        this.roomService = str;
    }

    public final String getRestaurant() {
        return this.restaurant;
    }

    public final void setRestaurant(String str) {
        this.restaurant = str;
    }

    public final String getBar() {
        return this.bar;
    }

    public final void setBar(String str) {
        this.bar = str;
    }

    public final String getGym() {
        return this.gym;
    }

    public final void setGym(String str) {
        this.gym = str;
    }

    public final String getSwimmingPool() {
        return this.swimmingPool;
    }

    public final void setSwimmingPool(String str) {
        this.swimmingPool = str;
    }

    public final String getBusinessCentre() {
        return this.businessCentre;
    }

    public final void setBusinessCentre(String str) {
        this.businessCentre = str;
    }

    public final String getParking() {
        return this.parking;
    }

    public final void setParking(String str) {
        this.parking = str;
    }

    public final String getMinibar() {
        return this.minibar;
    }

    public final void setMinibar(String str) {
        this.minibar = str;
    }

    public final String getTelevision() {
        return this.television;
    }

    public final void setTelevision(String str) {
        this.television = str;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final void setTelephone(String str) {
        this.telephone = str;
    }

    public final String getIron() {
        return this.iron;
    }

    public final void setIron(String str) {
        this.iron = str;
    }

    public final String getHairdryer() {
        return this.hairdryer;
    }

    public final void setHairdryer(String str) {
        this.hairdryer = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Basic(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.g.b.g r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r22
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r23
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r24
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r25
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r26
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r27
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r28
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r29
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r30
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r31
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r32
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0083
            r0 = 0
            goto L_0x0085
        L_0x0083:
            r0 = r33
        L_0x0085:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.Basic.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getToiletries() {
        return this.toiletries;
    }

    public final void setToiletries(String str) {
        this.toiletries = str;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final List<String> getAmenitiesList(Basic basic) {
            k.c(basic, "amenities");
            List<String> arrayList = new ArrayList<>();
            if (p.a(basic.getTwentyFourHrCheckIn(), "true", false)) {
                arrayList.add("twentyFourHrCheckIn");
            }
            if (p.a(basic.getAirConditioning(), "true", false)) {
                arrayList.add("airConditioning");
            }
            if (p.a(basic.getWifi(), "true", false)) {
                arrayList.add("wifi");
            }
            if (p.a(basic.getRoomService(), "true", false)) {
                arrayList.add("roomService");
            }
            if (p.a(basic.getRestaurant(), "true", false)) {
                arrayList.add("restaurant");
            }
            if (p.a(basic.getBar(), "true", false)) {
                arrayList.add("bar");
            }
            if (p.a(basic.getGym(), "true", false)) {
                arrayList.add("gym");
            }
            if (p.a(basic.getSwimmingPool(), "true", false)) {
                arrayList.add("swimmingPool");
            }
            if (p.a(basic.getBusinessCentre(), "true", false)) {
                arrayList.add("businessCentre");
            }
            if (p.a(basic.getParking(), "true", false)) {
                arrayList.add("parking");
            }
            if (p.a(basic.getMinibar(), "true", false)) {
                arrayList.add("minibar");
            }
            if (p.a(basic.getTelevision(), "true", false)) {
                arrayList.add("television");
            }
            if (p.a(basic.getTelephone(), "true", false)) {
                arrayList.add("telephone");
            }
            if (p.a(basic.getIron(), "true", false)) {
                arrayList.add("iron");
            }
            if (p.a(basic.getHairdryer(), "true", false)) {
                arrayList.add("hairdryer");
            }
            if (p.a(basic.getToiletries(), "true", false)) {
                arrayList.add("toiletries");
            }
            return arrayList;
        }
    }
}
