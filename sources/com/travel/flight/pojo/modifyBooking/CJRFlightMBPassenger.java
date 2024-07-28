package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class CJRFlightMBPassenger extends IJRPaytmDataModel {
    @b(a = "firstname")
    private String firstname;
    @b(a = "id")
    private int id;
    @b(a = "lastname")
    private String lastname;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public CJRFlightMBPassenger() {
        this(0, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final void setFirstname(String str) {
        this.firstname = str;
    }

    public final String getLastname() {
        return this.lastname;
    }

    public final void setLastname(String str) {
        this.lastname = str;
    }

    public CJRFlightMBPassenger(int i2, String str, String str2, String str3, String str4) {
        this.id = i2;
        this.title = str;
        this.firstname = str2;
        this.lastname = str3;
        this.type = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRFlightMBPassenger(int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 0
        L_0x0005:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000b
            java.lang.String r5 = "Mr"
        L_0x000b:
            r10 = r5
            r5 = r9 & 4
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = r7
        L_0x001b:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            java.lang.String r8 = "adult"
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getFormattedFirstName() {
        return this.title + ' ' + this.firstname;
    }

    public final String getGenderType() {
        String str = this.type;
        if (str != null) {
            if (str != null) {
                String lowerCase = str.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (k.a((Object) lowerCase, (Object) "adult")) {
                    return "Adult";
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return this.type;
    }
}
