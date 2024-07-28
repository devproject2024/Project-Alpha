package net.one97.paytm.hotel4.service.model.details;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Address extends IJRPaytmDataModel {
    private String city;
    private String country;
    private Double lat;
    private Double lng;
    private String locality;
    private String streetAddress;
    private String zip;

    public Address() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, 127, (g) null);
    }

    public final String getStreetAddress() {
        return this.streetAddress;
    }

    public final void setStreetAddress(String str) {
        this.streetAddress = str;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final void setLocality(String str) {
        this.locality = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getZip() {
        return this.zip;
    }

    public final void setZip(String str) {
        this.zip = str;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final void setLat(Double d2) {
        this.lat = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Address(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.Double r12, java.lang.Double r13, int r14, kotlin.g.b.g r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.Address.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getLng() {
        return this.lng;
    }

    public final void setLng(Double d2) {
        this.lng = d2;
    }

    public Address(String str, String str2, String str3, String str4, String str5, Double d2, Double d3) {
        this.streetAddress = str;
        this.locality = str2;
        this.city = str3;
        this.country = str4;
        this.zip = str5;
        this.lat = d2;
        this.lng = d3;
    }

    public final String toString() {
        String str = this.locality;
        if (str == null) {
            str = "";
        } else if (str == null) {
            k.a();
        }
        boolean z = true;
        if (this.city != null) {
            if (str.length() == 0) {
                str = this.city;
                if (str == null) {
                    k.a();
                }
            } else {
                str = str + ", " + this.city;
            }
        }
        if (this.country == null) {
            return str;
        }
        if (str.length() != 0) {
            z = false;
        }
        if (z) {
            String str2 = this.country;
            if (str2 != null) {
                return str2;
            }
            k.a();
            return str2;
        }
        return str + ", " + this.country;
    }
}
