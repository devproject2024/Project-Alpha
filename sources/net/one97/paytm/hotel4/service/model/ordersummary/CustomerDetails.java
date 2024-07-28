package net.one97.paytm.hotel4.service.model.ordersummary;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CustomerDetails extends IJRPaytmDataModel {
    @a
    @b(a = "country_phone_code")
    private Object countryPhoneCode;
    @a
    @b(a = "email")
    private String email;
    @a
    @b(a = "firstname")
    private String firstname;
    @a
    @b(a = "lastname")
    private String lastname;
    @a
    @b(a = "mobile")
    private String mobile;
    @a
    @b(a = "title")
    private String title;

    public CustomerDetails() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Object) null, 63, (g) null);
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getLastname() {
        return this.lastname;
    }

    public final void setLastname(String str) {
        this.lastname = str;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final void setFirstname(String str) {
        this.firstname = str;
    }

    public CustomerDetails(String str, String str2, String str3, String str4, String str5, Object obj) {
        this.email = str;
        this.title = str2;
        this.mobile = str3;
        this.lastname = str4;
        this.firstname = str5;
        this.countryPhoneCode = obj;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomerDetails(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Object r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x001e
            r3 = r7
            goto L_0x001f
        L_0x001e:
            r3 = r9
        L_0x001f:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0025
            r4 = r7
            goto L_0x0026
        L_0x0025:
            r4 = r10
        L_0x0026:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002c
            r12 = r0
            goto L_0x002d
        L_0x002c:
            r12 = r11
        L_0x002d:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.ordersummary.CustomerDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, int, kotlin.g.b.g):void");
    }

    public final Object getCountryPhoneCode() {
        return this.countryPhoneCode;
    }

    public final void setCountryPhoneCode(Object obj) {
        this.countryPhoneCode = obj;
    }
}
