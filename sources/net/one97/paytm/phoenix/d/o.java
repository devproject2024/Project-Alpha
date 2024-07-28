package net.one97.paytm.phoenix.d;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.model.CJRH5UserAddressInfo;
import net.one97.paytm.phoenix.util.d;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    b f19838a;

    public o() {
        super("paytmFetchCustomerId", "paytmGetUserInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03d9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r25, net.one97.paytm.phoenix.api.b r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.String r3 = "event"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r3 = "bridgeContext"
            kotlin.g.b.k.c(r2, r3)
            super.a((net.one97.paytm.phoenix.api.H5Event) r25, (net.one97.paytm.phoenix.api.b) r26)
            b(r25, r26)
            r0.f19838a = r2
            android.app.Activity r2 = r25.getActivity()
            if (r2 == 0) goto L_0x045d
            java.lang.String r4 = r25.getBridgeName()
            if (r4 != 0) goto L_0x0026
            goto L_0x045d
        L_0x0026:
            int r5 = r4.hashCode()
            r6 = -1490564946(0xffffffffa727c8ae, float:-2.3284694E-15)
            r7 = 0
            if (r5 == r6) goto L_0x004f
            r6 = 376555666(0x1671c892, float:1.9531114E-25)
            if (r5 == r6) goto L_0x0037
            goto L_0x045d
        L_0x0037:
            java.lang.String r5 = "paytmFetchCustomerId"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x045d
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.a.a((android.content.Context) r2)
            if (r2 != 0) goto L_0x0049
            java.lang.String r2 = ""
        L_0x0049:
            r4 = 4
            net.one97.paytm.phoenix.core.a.a(r0, r1, r2, r7, r4)
            goto L_0x045d
        L_0x004f:
            java.lang.String r5 = "paytmGetUserInfo"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x045d
            r4 = 0
            org.json.JSONObject r5 = r25.getParams()
            if (r5 == 0) goto L_0x006d
            java.lang.String r6 = "infoKeys"
            java.lang.Object r5 = r5.get(r6)
            if (r5 == 0) goto L_0x006d
            boolean r6 = r5 instanceof org.json.JSONArray
            if (r6 == 0) goto L_0x006d
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            r4 = r5
        L_0x006d:
            net.one97.paytm.phoenix.util.d$a r5 = net.one97.paytm.phoenix.util.d.f19890a
            net.one97.paytm.phoenix.api.b r5 = r0.f19838a
            r6 = 16
            java.lang.String r8 = "whitelisted_aids_userinfo"
            boolean r2 = net.one97.paytm.phoenix.util.d.a.a((net.one97.paytm.phoenix.api.H5Event) r1, (net.one97.paytm.phoenix.api.b) r5, (android.app.Activity) r2, (java.lang.String) r8, (int) r6)
            if (r2 != 0) goto L_0x045d
            if (r4 != 0) goto L_0x0080
            r2 = 1
            goto L_0x0081
        L_0x0080:
            r2 = 0
        L_0x0081:
            java.lang.String r5 = "isPayTmMinKYC"
            java.lang.String r6 = "isUserPrimeKYC"
            java.lang.String r8 = "hasCreditCard"
            java.lang.String r9 = "picture"
            java.lang.String r10 = "userId"
            java.lang.String r11 = "kycState"
            java.lang.String r12 = "lastName"
            java.lang.String r13 = "firstName"
            java.lang.String r14 = "mobile"
            java.lang.String r15 = "gender"
            java.lang.String r3 = "dob"
            java.lang.String r7 = "email"
            r17 = r2
            java.lang.String r2 = "name"
            if (r4 == 0) goto L_0x0159
            int r1 = r4.length()
            r0 = 0
        L_0x00a5:
            if (r0 >= r1) goto L_0x0159
            r18 = r1
            java.lang.Object r1 = r4.get(r0)
            r19 = r4
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x014c
            java.lang.String r1 = (java.lang.String) r1
            r4 = 0
            boolean r16 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r4)
            if (r16 != 0) goto L_0x0149
            boolean r16 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r16 != 0) goto L_0x0149
            boolean r16 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r4)
            if (r16 != 0) goto L_0x0149
            boolean r16 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r15, (boolean) r4)
            if (r16 != 0) goto L_0x0149
            boolean r16 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r14, (boolean) r4)
            if (r16 != 0) goto L_0x0149
            r16 = r7
            java.lang.String r7 = "address"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r13, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r12, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r11, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r10, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r9, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isUserFullKYC"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isEmailVerified"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isMobileVerified"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "hasDigitalGold"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isPrimeUser"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isEmailNotificationEnabled"
            boolean r7 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r7 != 0) goto L_0x014f
            java.lang.String r7 = "isBankCustomer"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r4)
            if (r1 != 0) goto L_0x014f
            r17 = 1
            goto L_0x014f
        L_0x0149:
            r16 = r7
            goto L_0x014f
        L_0x014c:
            r16 = r7
            r4 = 0
        L_0x014f:
            int r0 = r0 + 1
            r7 = r16
            r1 = r18
            r4 = r19
            goto L_0x00a5
        L_0x0159:
            r19 = r4
            r16 = r7
            r4 = 0
            if (r17 == 0) goto L_0x0178
            net.one97.paytm.phoenix.util.d$a r0 = net.one97.paytm.phoenix.util.d.f19890a
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r24
            net.one97.paytm.phoenix.api.b r7 = r1.f19838a
            java.lang.String r4 = "Key not found"
            r1 = r25
            net.one97.paytm.phoenix.util.d.a.a(r1, r0, r4, r7)
            goto L_0x017a
        L_0x0178:
            r1 = r25
        L_0x017a:
            r0 = 1
            r4 = r17 ^ 1
            if (r4 == 0) goto L_0x045a
            if (r19 != 0) goto L_0x0184
            kotlin.g.b.k.a()
        L_0x0184:
            android.app.Activity r0 = r25.getActivity()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            int r7 = r19.length()
            r1 = 0
            r17 = 0
        L_0x0194:
            if (r1 >= r7) goto L_0x03ea
            r20 = r7
            r7 = r19
            r19 = r8
            java.lang.String r8 = r7.getString(r1)
            boolean r21 = r8.equals(r2)
            if (r21 == 0) goto L_0x01c0
            r21 = r0
            android.content.Context r21 = (android.content.Context) r21
            java.lang.String r22 = com.paytm.utility.b.j((android.content.Context) r21)
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            boolean r22 = android.text.TextUtils.isEmpty(r22)
            if (r22 != 0) goto L_0x01c0
            r22 = r7
            java.lang.String r7 = com.paytm.utility.b.j((android.content.Context) r21)
            r4.put(r2, r7)
            goto L_0x01c2
        L_0x01c0:
            r22 = r7
        L_0x01c2:
            boolean r7 = r8.equals(r14)
            if (r7 == 0) goto L_0x01de
            r7 = r0
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r21 = com.paytm.utility.b.l((android.content.Context) r7)
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x01de
            java.lang.String r7 = com.paytm.utility.b.l((android.content.Context) r7)
            r4.put(r14, r7)
        L_0x01de:
            boolean r7 = r8.equals(r3)
            if (r7 == 0) goto L_0x01fa
            r7 = r0
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r21 = com.paytm.utility.b.F((android.content.Context) r7)
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x01fa
            java.lang.String r7 = com.paytm.utility.b.F((android.content.Context) r7)
            r4.put(r3, r7)
        L_0x01fa:
            boolean r7 = r8.equals(r15)
            if (r7 == 0) goto L_0x0216
            r7 = r0
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r21 = com.paytm.utility.b.G((android.content.Context) r7)
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x0216
            java.lang.String r7 = com.paytm.utility.b.G((android.content.Context) r7)
            r4.put(r15, r7)
        L_0x0216:
            r7 = r16
            boolean r16 = r8.equals(r7)
            if (r16 == 0) goto L_0x0238
            r16 = r0
            android.content.Context r16 = (android.content.Context) r16
            java.lang.String r21 = com.paytm.utility.b.m((android.content.Context) r16)
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x0238
            r21 = r2
            java.lang.String r2 = com.paytm.utility.b.m((android.content.Context) r16)
            r4.put(r7, r2)
            goto L_0x023a
        L_0x0238:
            r21 = r2
        L_0x023a:
            boolean r2 = r8.equals(r13)
            if (r2 == 0) goto L_0x0256
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.h((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x0256
            java.lang.String r2 = com.paytm.utility.b.h((android.content.Context) r2)
            r4.put(r13, r2)
        L_0x0256:
            boolean r2 = r8.equals(r12)
            if (r2 == 0) goto L_0x0272
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.i((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x0272
            java.lang.String r2 = com.paytm.utility.b.i((android.content.Context) r2)
            r4.put(r12, r2)
        L_0x0272:
            boolean r2 = r8.equals(r11)
            if (r2 == 0) goto L_0x028e
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x028e
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            r4.put(r11, r2)
        L_0x028e:
            boolean r2 = r8.equals(r10)
            if (r2 == 0) goto L_0x02aa
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.a.a((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x02aa
            java.lang.String r2 = com.paytm.utility.a.a((android.content.Context) r2)
            r4.put(r10, r2)
        L_0x02aa:
            boolean r2 = r8.equals(r9)
            if (r2 == 0) goto L_0x02c6
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.D((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x02c6
            java.lang.String r2 = com.paytm.utility.b.D((android.content.Context) r2)
            r4.put(r9, r2)
        L_0x02c6:
            java.lang.String r2 = "isPrimeUser"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x02dd
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.I((android.content.Context) r2)
            r16 = r3
            java.lang.String r3 = "isPrimeUser"
            r4.put(r3, r2)
            goto L_0x02df
        L_0x02dd:
            r16 = r3
        L_0x02df:
            java.lang.String r2 = "isMobileVerified"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x02f9
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r2 = com.paytm.utility.b.k((android.content.Context) r2)
            r3 = 1
            if (r2 != r3) goto L_0x02f3
            r2 = 1
            goto L_0x02f4
        L_0x02f3:
            r2 = 0
        L_0x02f4:
            java.lang.String r3 = "isMobileVerified"
            r4.put(r3, r2)
        L_0x02f9:
            java.lang.String r2 = "isEmailVerified"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0313
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r2 = com.paytm.utility.b.E((android.content.Context) r2)
            r3 = 1
            if (r2 != r3) goto L_0x030d
            r2 = 1
            goto L_0x030e
        L_0x030d:
            r2 = 0
        L_0x030e:
            java.lang.String r3 = "isEmailVerified"
            r4.put(r3, r2)
        L_0x0313:
            boolean r2 = r8.equals(r6)
            if (r2 == 0) goto L_0x0329
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r3 = "PAYTM_PRIME_WALLET"
            boolean r2 = r2.equals(r3)
            r4.put(r6, r2)
        L_0x0329:
            boolean r2 = r8.equals(r5)
            if (r2 == 0) goto L_0x033f
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r3 = "PAYTM_MIN_KYC"
            boolean r2 = r2.equals(r3)
            r4.put(r5, r2)
        L_0x033f:
            java.lang.String r2 = "isUserFullKYC"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x037f
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = com.paytm.utility.b.H((android.content.Context) r2)
            r23 = r5
            java.lang.String r5 = "CJRAppCommonUtility.getMinKYCState(activity)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r5 = "PAYTM_PRIME_WALLET"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r3 = kotlin.m.p.c((java.lang.CharSequence) r3, (java.lang.CharSequence) r5)
            if (r3 == 0) goto L_0x0378
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r3 = "CJRAppCommonUtility.getMinKYCState(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = "PAYTM_ADHAR_OTP_KYC"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = kotlin.m.p.c((java.lang.CharSequence) r2, (java.lang.CharSequence) r3)
            if (r2 == 0) goto L_0x0378
            r2 = 1
            goto L_0x0379
        L_0x0378:
            r2 = 0
        L_0x0379:
            java.lang.String r3 = "isUserFullKYC"
            r4.put(r3, r2)
            goto L_0x0381
        L_0x037f:
            r23 = r5
        L_0x0381:
            r2 = r19
            boolean r3 = r8.equals(r2)
            if (r3 == 0) goto L_0x0393
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            boolean r3 = com.paytm.utility.b.y((android.content.Context) r3)
            r4.put(r2, r3)
        L_0x0393:
            java.lang.String r3 = "hasDigitalGold"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x03a7
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            boolean r3 = com.paytm.utility.b.o((android.content.Context) r3)
            java.lang.String r5 = "hasDigitalGold"
            r4.put(r5, r3)
        L_0x03a7:
            java.lang.String r3 = "isBankCustomer"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x03bb
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            boolean r3 = com.paytm.utility.b.p((android.content.Context) r3)
            java.lang.String r5 = "isBankCustomer"
            r4.put(r5, r3)
        L_0x03bb:
            java.lang.String r3 = "isEmailNotificationEnabled"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x03cf
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            boolean r3 = com.paytm.utility.b.q((android.content.Context) r3)
            java.lang.String r5 = "isEmailNotificationEnabled"
            r4.put(r5, r3)
        L_0x03cf:
            java.lang.String r3 = "address"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x03d9
            r17 = 1
        L_0x03d9:
            int r1 = r1 + 1
            r8 = r2
            r3 = r16
            r2 = r21
            r19 = r22
            r5 = r23
            r16 = r7
            r7 = r20
            goto L_0x0194
        L_0x03ea:
            if (r17 == 0) goto L_0x044e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r2 = net.one97.paytm.j.c.c()
            r1.append(r2)
            android.content.Context r0 = (android.content.Context) r0
            r2 = 1
            java.lang.String r3 = com.paytm.utility.c.a((android.content.Context) r0, (boolean) r2)
            r1.append(r3)
            java.lang.String r6 = r1.toString()
            java.util.Map r8 = net.one97.paytm.utils.t.e(r0)
            net.one97.paytm.phoenix.d.o$a r1 = new net.one97.paytm.phoenix.d.o$a
            r2 = r24
            r3 = r25
            r1.<init>(r2, r4, r3)
            r7 = r1
            com.paytm.network.listener.b r7 = (com.paytm.network.listener.b) r7
            r9 = 0
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.GET
            r11 = 0
            net.one97.paytm.phoenix.model.CJRH5UserAddressInfo r1 = new net.one97.paytm.phoenix.model.CJRH5UserAddressInfo
            r1.<init>()
            r12 = r1
            com.paytm.network.model.IJRPaytmDataModel r12 = (com.paytm.network.model.IJRPaytmDataModel) r12
            com.paytm.network.a$c r13 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r14 = com.paytm.network.a.b.SILENT
            r5 = r0
            com.paytm.network.a r1 = net.one97.paytm.common.b.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x043a
            if (r1 == 0) goto L_0x045e
            r1.a()
            goto L_0x045e
        L_0x043a:
            net.one97.paytm.phoenix.util.d$a r0 = net.one97.paytm.phoenix.util.d.f19890a
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            net.one97.paytm.phoenix.api.b r1 = r2.f19838a
            java.lang.String r4 = "Unable to process your request"
            net.one97.paytm.phoenix.util.d.a.a(r3, r0, r4, r1)
            goto L_0x045e
        L_0x044e:
            r2 = r24
            r3 = r25
            net.one97.paytm.phoenix.util.d$a r0 = net.one97.paytm.phoenix.util.d.f19890a
            net.one97.paytm.phoenix.api.b r0 = r2.f19838a
            net.one97.paytm.phoenix.util.d.a.a(r3, r4, r0)
            goto L_0x045e
        L_0x045a:
            r2 = r24
            goto L_0x045e
        L_0x045d:
            r2 = r0
        L_0x045e:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.o.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f19839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f19840b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f19841c;

        a(o oVar, JSONObject jSONObject, H5Event h5Event) {
            this.f19839a = oVar;
            this.f19840b = jSONObject;
            this.f19841c = h5Event;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRH5UserAddressInfo) {
                CJRH5UserAddressInfo cJRH5UserAddressInfo = (CJRH5UserAddressInfo) iJRPaytmDataModel;
                JSONArray jSONArray = new JSONArray();
                Collection address = cJRH5UserAddressInfo.getAddress();
                int i2 = 0;
                if (!(address == null || address.isEmpty())) {
                    ArrayList<CJRAddress> address2 = cJRH5UserAddressInfo.getAddress();
                    if (address2 == null) {
                        k.a();
                    }
                    if (address2.size() > 0) {
                        ArrayList<CJRAddress> address3 = cJRH5UserAddressInfo.getAddress();
                        if (address3 == null) {
                            k.a();
                        }
                        int size = address3.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                JSONObject jSONObject = new JSONObject();
                                ArrayList<CJRAddress> address4 = cJRH5UserAddressInfo.getAddress();
                                if (address4 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress = address4.get(i2);
                                k.a((Object) cJRAddress, "addressList.address!![i]");
                                jSONObject.put("address1", cJRAddress.getAddress1());
                                ArrayList<CJRAddress> address5 = cJRH5UserAddressInfo.getAddress();
                                if (address5 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress2 = address5.get(i2);
                                k.a((Object) cJRAddress2, "addressList.address!![i]");
                                jSONObject.put("address2", cJRAddress2.getAddress2());
                                ArrayList<CJRAddress> address6 = cJRH5UserAddressInfo.getAddress();
                                if (address6 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress3 = address6.get(i2);
                                k.a((Object) cJRAddress3, "addressList.address!![i]");
                                jSONObject.put("title", cJRAddress3.getTitle());
                                ArrayList<CJRAddress> address7 = cJRH5UserAddressInfo.getAddress();
                                if (address7 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress4 = address7.get(i2);
                                k.a((Object) cJRAddress4, "addressList.address!![i]");
                                jSONObject.put("priority", cJRAddress4.getPriority());
                                ArrayList<CJRAddress> address8 = cJRH5UserAddressInfo.getAddress();
                                if (address8 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress5 = address8.get(i2);
                                k.a((Object) cJRAddress5, "addressList.address!![i]");
                                jSONObject.put("state", cJRAddress5.getState());
                                ArrayList<CJRAddress> address9 = cJRH5UserAddressInfo.getAddress();
                                if (address9 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress6 = address9.get(i2);
                                k.a((Object) cJRAddress6, "addressList.address!![i]");
                                jSONObject.put("pin", cJRAddress6.getPin());
                                ArrayList<CJRAddress> address10 = cJRH5UserAddressInfo.getAddress();
                                if (address10 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress7 = address10.get(i2);
                                k.a((Object) cJRAddress7, "addressList.address!![i]");
                                jSONObject.put("city", cJRAddress7.getCity());
                                ArrayList<CJRAddress> address11 = cJRH5UserAddressInfo.getAddress();
                                if (address11 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress8 = address11.get(i2);
                                k.a((Object) cJRAddress8, "addressList.address!![i]");
                                jSONObject.put("mobile", cJRAddress8.getMobile());
                                ArrayList<CJRAddress> address12 = cJRH5UserAddressInfo.getAddress();
                                if (address12 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress9 = address12.get(i2);
                                k.a((Object) cJRAddress9, "addressList.address!![i]");
                                jSONObject.put("name", cJRAddress9.getName());
                                jSONArray.put(jSONObject);
                                if (i2 == size) {
                                    break;
                                }
                                i2++;
                            }
                        }
                        this.f19840b.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, jSONArray);
                    }
                }
                d.a aVar = d.f19890a;
                d.a.a(this.f19841c, this.f19840b, this.f19839a.f19838a);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            d.a aVar = d.f19890a;
            d.a.a(this.f19841c, Integer.valueOf(net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR.ordinal()), "Unable to process your request", this.f19839a.f19838a);
        }
    }
}
