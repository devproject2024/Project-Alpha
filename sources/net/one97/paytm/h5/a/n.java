package net.one97.paytm.h5.a;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5.model.CJRH5UserAddressInfo;
import net.one97.paytm.h5paytmsdk.b.ad;

public final class n extends ad {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public H5BridgeContext f16903a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n() {
        super(e.m, e.n);
        e.a aVar = e.f16836a;
        e.a aVar2 = e.f16836a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r22, com.alipay.mobile.h5container.api.H5BridgeContext r23) {
        /*
            r21 = this;
            r0 = r21
            super.handleEvent(r22, r23)
            boolean r1 = r21.a((com.alipay.mobile.h5container.api.H5Event) r22)
            if (r1 == 0) goto L_0x0468
            r1 = r23
            r0.f16903a = r1
            if (r22 == 0) goto L_0x0468
            if (r22 == 0) goto L_0x0468
            android.app.Activity r1 = r22.getActivity()
            if (r1 == 0) goto L_0x0468
            java.lang.String r3 = r22.getAction()
            net.one97.paytm.h5.a.e$a r4 = net.one97.paytm.h5.a.e.f16836a
            java.lang.String r4 = net.one97.paytm.h5.a.e.m
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0038
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = com.paytm.utility.a.a((android.content.Context) r1)
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = ""
        L_0x0033:
            r0.a((java.lang.Object) r1)
            goto L_0x0468
        L_0x0038:
            net.one97.paytm.h5.a.e$a r4 = net.one97.paytm.h5.a.e.f16836a
            java.lang.String r4 = net.one97.paytm.h5.a.e.n
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0468
            r3 = 0
            com.alibaba.a.e r4 = r22.getParam()
            if (r4 == 0) goto L_0x005a
            java.lang.String r5 = "infoKeys"
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L_0x005a
            boolean r5 = r4 instanceof com.alibaba.a.b
            if (r5 == 0) goto L_0x005a
            com.alibaba.a.b r4 = (com.alibaba.a.b) r4
            r3 = r4
        L_0x005a:
            net.one97.paytm.h5.a.e$a r4 = net.one97.paytm.h5.a.e.f16836a
            com.alipay.mobile.h5container.api.H5BridgeContext r4 = r0.f16903a
            r5 = 8
            java.lang.String r6 = "whitelisted_aids_userinfo"
            boolean r1 = net.one97.paytm.h5.a.e.a.a((com.alipay.mobile.h5container.api.H5BridgeContext) r4, (android.app.Activity) r1, (java.lang.String) r6, (int) r5)
            if (r1 != 0) goto L_0x0468
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0077
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r1 = 0
            goto L_0x0078
        L_0x0077:
            r1 = 1
        L_0x0078:
            java.lang.String r5 = "isPayTmMinKYC"
            java.lang.String r6 = "isUserPrimeKYC"
            java.lang.String r7 = "hasCreditCard"
            java.lang.String r8 = "picture"
            java.lang.String r9 = "userId"
            java.lang.String r10 = "kycState"
            java.lang.String r11 = "lastName"
            java.lang.String r12 = "firstName"
            java.lang.String r13 = "mobile"
            java.lang.String r14 = "gender"
            java.lang.String r15 = "dob"
            java.lang.String r2 = "email"
            java.lang.String r4 = "name"
            if (r3 == 0) goto L_0x014a
            java.util.Iterator r16 = r3.iterator()
        L_0x0099:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x0148
            java.lang.Object r17 = r16.next()
            r18 = r1
            r1 = r17
            java.lang.String r1 = (java.lang.String) r1
            r17 = r3
            r3 = 0
            boolean r19 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r19 != 0) goto L_0x013e
            boolean r19 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r19 != 0) goto L_0x013e
            boolean r19 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r15, (boolean) r3)
            if (r19 != 0) goto L_0x013e
            boolean r19 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r14, (boolean) r3)
            if (r19 != 0) goto L_0x013e
            boolean r19 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r13, (boolean) r3)
            if (r19 != 0) goto L_0x013e
            r19 = r2
            java.lang.String r2 = "address"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r12, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r11, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r10, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r9, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isUserFullKYC"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isEmailVerified"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isMobileVerified"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "hasDigitalGold"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isPrimeUser"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isEmailNotificationEnabled"
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r2 != 0) goto L_0x0140
            java.lang.String r2 = "isBankCustomer"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 != 0) goto L_0x0140
            r1 = 1
            goto L_0x0142
        L_0x013e:
            r19 = r2
        L_0x0140:
            r1 = r18
        L_0x0142:
            r3 = r17
            r2 = r19
            goto L_0x0099
        L_0x0148:
            r18 = r1
        L_0x014a:
            r19 = r2
            r17 = r3
            if (r1 == 0) goto L_0x0163
            net.one97.paytm.h5.a.e$a r2 = net.one97.paytm.h5.a.e.f16836a
            com.alipay.mobile.h5container.api.H5Event$Error r2 = com.alipay.mobile.h5container.api.H5Event.Error.NOT_FOUND
            int r2 = r2.ordinal()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.alipay.mobile.h5container.api.H5BridgeContext r3 = r0.f16903a
            java.lang.String r0 = "Key not found"
            net.one97.paytm.h5.a.e.a.a(r2, r0, r3)
        L_0x0163:
            r0 = 1
            r1 = r1 ^ r0
            if (r1 == 0) goto L_0x0465
            if (r17 != 0) goto L_0x016c
            kotlin.g.b.k.a()
        L_0x016c:
            android.app.Activity r0 = r22.getActivity()
            com.alibaba.a.e r1 = new com.alibaba.a.e
            r1.<init>()
            java.util.Iterator r2 = r17.iterator()
            r3 = 0
        L_0x017a:
            boolean r16 = r2.hasNext()
            if (r16 == 0) goto L_0x03f7
            r22 = r3
            java.lang.Object r3 = r2.next()
            boolean r16 = r3.equals(r4)
            if (r16 == 0) goto L_0x01a6
            r16 = r0
            android.content.Context r16 = (android.content.Context) r16
            java.lang.String r17 = com.paytm.utility.b.j((android.content.Context) r16)
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            if (r17 != 0) goto L_0x01a6
            r17 = r2
            java.lang.String r2 = com.paytm.utility.b.j((android.content.Context) r16)
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
            goto L_0x01a8
        L_0x01a6:
            r17 = r2
        L_0x01a8:
            boolean r2 = r3.equals(r13)
            if (r2 == 0) goto L_0x01c4
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.l((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x01c4
            java.lang.String r2 = com.paytm.utility.b.l((android.content.Context) r2)
            r1.put((java.lang.String) r13, (java.lang.Object) r2)
        L_0x01c4:
            boolean r2 = r3.equals(r15)
            if (r2 == 0) goto L_0x01e0
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.F((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x01e0
            java.lang.String r2 = com.paytm.utility.b.F((android.content.Context) r2)
            r1.put((java.lang.String) r15, (java.lang.Object) r2)
        L_0x01e0:
            boolean r2 = r3.equals(r14)
            if (r2 == 0) goto L_0x01fc
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r16 = com.paytm.utility.b.G((android.content.Context) r2)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x01fc
            java.lang.String r2 = com.paytm.utility.b.G((android.content.Context) r2)
            r1.put((java.lang.String) r14, (java.lang.Object) r2)
        L_0x01fc:
            r2 = r19
            boolean r16 = r3.equals(r2)
            if (r16 == 0) goto L_0x021e
            r16 = r0
            android.content.Context r16 = (android.content.Context) r16
            java.lang.String r18 = com.paytm.utility.b.m((android.content.Context) r16)
            java.lang.CharSequence r18 = (java.lang.CharSequence) r18
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 != 0) goto L_0x021e
            r18 = r4
            java.lang.String r4 = com.paytm.utility.b.m((android.content.Context) r16)
            r1.put((java.lang.String) r2, (java.lang.Object) r4)
            goto L_0x0220
        L_0x021e:
            r18 = r4
        L_0x0220:
            boolean r4 = r3.equals(r12)
            if (r4 == 0) goto L_0x023c
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r16 = com.paytm.utility.b.h((android.content.Context) r4)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x023c
            java.lang.String r4 = com.paytm.utility.b.h((android.content.Context) r4)
            r1.put((java.lang.String) r12, (java.lang.Object) r4)
        L_0x023c:
            boolean r4 = r3.equals(r11)
            if (r4 == 0) goto L_0x0258
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r16 = com.paytm.utility.b.i((android.content.Context) r4)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x0258
            java.lang.String r4 = com.paytm.utility.b.i((android.content.Context) r4)
            r1.put((java.lang.String) r11, (java.lang.Object) r4)
        L_0x0258:
            boolean r4 = r3.equals(r10)
            if (r4 == 0) goto L_0x0274
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r16 = com.paytm.utility.b.H((android.content.Context) r4)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x0274
            java.lang.String r4 = com.paytm.utility.b.H((android.content.Context) r4)
            r1.put((java.lang.String) r10, (java.lang.Object) r4)
        L_0x0274:
            boolean r4 = r3.equals(r9)
            if (r4 == 0) goto L_0x0290
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r16 = com.paytm.utility.a.a((android.content.Context) r4)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x0290
            java.lang.String r4 = com.paytm.utility.a.a((android.content.Context) r4)
            r1.put((java.lang.String) r9, (java.lang.Object) r4)
        L_0x0290:
            boolean r4 = r3.equals(r8)
            if (r4 == 0) goto L_0x02ac
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r16 = com.paytm.utility.b.D((android.content.Context) r4)
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x02ac
            java.lang.String r4 = com.paytm.utility.b.D((android.content.Context) r4)
            r1.put((java.lang.String) r8, (java.lang.Object) r4)
        L_0x02ac:
            java.lang.String r4 = "isPrimeUser"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x02c7
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            boolean r4 = com.paytm.utility.b.I((android.content.Context) r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r19 = r2
            java.lang.String r2 = "isPrimeUser"
            r1.put((java.lang.String) r2, (java.lang.Object) r4)
            goto L_0x02c9
        L_0x02c7:
            r19 = r2
        L_0x02c9:
            java.lang.String r2 = "isMobileVerified"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x02e7
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r2 = com.paytm.utility.b.k((android.content.Context) r2)
            r4 = 1
            if (r2 != r4) goto L_0x02dd
            r2 = 1
            goto L_0x02de
        L_0x02dd:
            r2 = 0
        L_0x02de:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "isMobileVerified"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
        L_0x02e7:
            java.lang.String r2 = "isEmailVerified"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0305
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r2 = com.paytm.utility.b.E((android.content.Context) r2)
            r4 = 1
            if (r2 != r4) goto L_0x02fb
            r2 = 1
            goto L_0x02fc
        L_0x02fb:
            r2 = 0
        L_0x02fc:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "isEmailVerified"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
        L_0x0305:
            boolean r2 = r3.equals(r6)
            if (r2 == 0) goto L_0x031f
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r4 = "PAYTM_PRIME_WALLET"
            boolean r2 = r2.equals(r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.put((java.lang.String) r6, (java.lang.Object) r2)
        L_0x031f:
            boolean r2 = r3.equals(r5)
            if (r2 == 0) goto L_0x0339
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r4 = "PAYTM_MIN_KYC"
            boolean r2 = r2.equals(r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.put((java.lang.String) r5, (java.lang.Object) r2)
        L_0x0339:
            java.lang.String r2 = "isUserFullKYC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0380
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r4 = com.paytm.utility.b.H((android.content.Context) r2)
            r16 = r5
            java.lang.String r5 = "CJRAppCommonUtility.getMinKYCState(activity)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "PAYTM_PRIME_WALLET"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r20 = r6
            r6 = 0
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6)
            if (r4 == 0) goto L_0x0375
            java.lang.String r2 = com.paytm.utility.b.H((android.content.Context) r2)
            java.lang.String r4 = "CJRAppCommonUtility.getMinKYCState(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r4 = "PAYTM_ADHAR_OTP_KYC"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r4, (boolean) r6)
            if (r2 == 0) goto L_0x0375
            r2 = 1
            goto L_0x0376
        L_0x0375:
            r2 = 0
        L_0x0376:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "isUserFullKYC"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
            goto L_0x0385
        L_0x0380:
            r16 = r5
            r20 = r6
            r6 = 0
        L_0x0385:
            boolean r2 = r3.equals(r7)
            if (r2 == 0) goto L_0x0399
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.y((android.content.Context) r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.put((java.lang.String) r7, (java.lang.Object) r2)
        L_0x0399:
            java.lang.String r2 = "hasDigitalGold"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x03b1
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.o((android.content.Context) r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "hasDigitalGold"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
        L_0x03b1:
            java.lang.String r2 = "isBankCustomer"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x03c9
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.p((android.content.Context) r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "isBankCustomer"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
        L_0x03c9:
            java.lang.String r2 = "isEmailNotificationEnabled"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x03e1
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            boolean r2 = com.paytm.utility.b.q((android.content.Context) r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "isEmailNotificationEnabled"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
        L_0x03e1:
            java.lang.String r2 = "address"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x03eb
            r3 = 1
            goto L_0x03ed
        L_0x03eb:
            r3 = r22
        L_0x03ed:
            r5 = r16
            r2 = r17
            r4 = r18
            r6 = r20
            goto L_0x017a
        L_0x03f7:
            r22 = r3
            if (r22 == 0) goto L_0x045b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r3 = net.one97.paytm.j.c.c()
            r2.append(r3)
            android.content.Context r0 = (android.content.Context) r0
            r3 = 1
            java.lang.String r4 = com.paytm.utility.c.a((android.content.Context) r0, (boolean) r3)
            r2.append(r4)
            java.lang.String r5 = r2.toString()
            java.util.Map r7 = net.one97.paytm.utils.t.e(r0)
            net.one97.paytm.h5.a.n$a r2 = new net.one97.paytm.h5.a.n$a
            r3 = r21
            r2.<init>(r3, r1)
            r6 = r2
            com.paytm.network.listener.b r6 = (com.paytm.network.listener.b) r6
            r8 = 0
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.GET
            r10 = 0
            net.one97.paytm.h5.model.CJRH5UserAddressInfo r1 = new net.one97.paytm.h5.model.CJRH5UserAddressInfo
            r1.<init>()
            r11 = r1
            com.paytm.network.model.IJRPaytmDataModel r11 = (com.paytm.network.model.IJRPaytmDataModel) r11
            com.paytm.network.a$c r12 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r13 = com.paytm.network.a.b.SILENT
            r4 = r0
            com.paytm.network.a r1 = net.one97.paytm.common.b.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0447
            if (r1 == 0) goto L_0x0469
            r1.a()
            goto L_0x0469
        L_0x0447:
            net.one97.paytm.h5.a.e$a r0 = net.one97.paytm.h5.a.e.f16836a
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.alipay.mobile.h5container.api.H5BridgeContext r1 = r3.f16903a
            java.lang.String r2 = "Unable to process your request"
            net.one97.paytm.h5.a.e.a.a(r0, r2, r1)
            goto L_0x0469
        L_0x045b:
            r3 = r21
            net.one97.paytm.h5.a.e$a r0 = net.one97.paytm.h5.a.e.f16836a
            com.alipay.mobile.h5container.api.H5BridgeContext r0 = r3.f16903a
            net.one97.paytm.h5.a.e.a.a((com.alibaba.a.e) r1, (com.alipay.mobile.h5container.api.H5BridgeContext) r0)
            goto L_0x0469
        L_0x0465:
            r3 = r21
            goto L_0x0469
        L_0x0468:
            r3 = r0
        L_0x0469:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.n.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f16904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.alibaba.a.e f16905b;

        a(n nVar, com.alibaba.a.e eVar) {
            this.f16904a = nVar;
            this.f16905b = eVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            if (iJRPaytmDataModel instanceof CJRH5UserAddressInfo) {
                CJRH5UserAddressInfo cJRH5UserAddressInfo = (CJRH5UserAddressInfo) iJRPaytmDataModel;
                ArrayList arrayList = new ArrayList();
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
                                com.alibaba.a.e eVar = new com.alibaba.a.e();
                                ArrayList<CJRAddress> address4 = cJRH5UserAddressInfo.getAddress();
                                if (address4 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress = address4.get(i2);
                                k.a((Object) cJRAddress, "addressList.address!![i]");
                                eVar.put("address1", (Object) cJRAddress.getAddress1());
                                ArrayList<CJRAddress> address5 = cJRH5UserAddressInfo.getAddress();
                                if (address5 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress2 = address5.get(i2);
                                k.a((Object) cJRAddress2, "addressList.address!![i]");
                                eVar.put("address2", (Object) cJRAddress2.getAddress2());
                                ArrayList<CJRAddress> address6 = cJRH5UserAddressInfo.getAddress();
                                if (address6 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress3 = address6.get(i2);
                                k.a((Object) cJRAddress3, "addressList.address!![i]");
                                eVar.put("title", (Object) cJRAddress3.getTitle());
                                ArrayList<CJRAddress> address7 = cJRH5UserAddressInfo.getAddress();
                                if (address7 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress4 = address7.get(i2);
                                k.a((Object) cJRAddress4, "addressList.address!![i]");
                                eVar.put("priority", (Object) Integer.valueOf(cJRAddress4.getPriority()));
                                ArrayList<CJRAddress> address8 = cJRH5UserAddressInfo.getAddress();
                                if (address8 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress5 = address8.get(i2);
                                k.a((Object) cJRAddress5, "addressList.address!![i]");
                                eVar.put("state", (Object) cJRAddress5.getState());
                                ArrayList<CJRAddress> address9 = cJRH5UserAddressInfo.getAddress();
                                if (address9 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress6 = address9.get(i2);
                                k.a((Object) cJRAddress6, "addressList.address!![i]");
                                eVar.put("pin", (Object) cJRAddress6.getPin());
                                ArrayList<CJRAddress> address10 = cJRH5UserAddressInfo.getAddress();
                                if (address10 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress7 = address10.get(i2);
                                k.a((Object) cJRAddress7, "addressList.address!![i]");
                                eVar.put("city", (Object) cJRAddress7.getCity());
                                ArrayList<CJRAddress> address11 = cJRH5UserAddressInfo.getAddress();
                                if (address11 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress8 = address11.get(i2);
                                k.a((Object) cJRAddress8, "addressList.address!![i]");
                                eVar.put("mobile", (Object) cJRAddress8.getMobile());
                                ArrayList<CJRAddress> address12 = cJRH5UserAddressInfo.getAddress();
                                if (address12 == null) {
                                    k.a();
                                }
                                CJRAddress cJRAddress9 = address12.get(i2);
                                k.a((Object) cJRAddress9, "addressList.address!![i]");
                                eVar.put("name", (Object) cJRAddress9.getName());
                                arrayList.add(eVar);
                                if (i2 == size) {
                                    break;
                                }
                                i2++;
                            }
                        }
                        this.f16905b.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, (Object) arrayList);
                    }
                }
                e.a aVar = e.f16836a;
                e.a.a(this.f16905b, this.f16904a.f16903a);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            e.a aVar = e.f16836a;
            e.a.a(Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()), "Unable to process your request", this.f16904a.f16903a);
        }
    }
}
