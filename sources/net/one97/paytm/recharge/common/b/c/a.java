package net.one97.paytm.recharge.common.b.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.at;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.model.CJRMerchantLoanAccounts;
import net.one97.paytm.recharge.model.CJRPromoCodeTerms;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetBillData;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f60907a;

    protected a(Context context) {
        k.c(context, "context");
        this.f60907a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r20, net.one97.paytm.recharge.common.e.ai r21, org.json.JSONObject r22, java.lang.String r23, com.paytm.network.a.b r24, java.lang.Object r25, int r26, boolean r27) {
        /*
            r19 = this;
            r0 = r19
            r2 = r20
            r14 = r25
            java.lang.String r1 = "tag"
            kotlin.g.b.k.c(r2, r1)
            java.lang.String r1 = "responseListener"
            r4 = r21
            kotlin.g.b.k.c(r4, r1)
            java.lang.String r1 = "jsonCart"
            r3 = r22
            kotlin.g.b.k.c(r3, r1)
            java.lang.String r1 = "screenName"
            r12 = r23
            kotlin.g.b.k.c(r12, r1)
            java.lang.String r1 = "userFacing"
            r11 = r24
            kotlin.g.b.k.c(r11, r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r5 = r1
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.put(r6, r7)
            android.content.Context r5 = r0.f60907a
            java.util.HashMap r7 = com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r1, (android.content.Context) r5)
            java.lang.String r1 = "CJRAppCommonUtility.addS…nHeader(headers, context)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.az.a((org.json.JSONObject) r22)
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r5 = net.one97.paytm.recharge.di.helper.c.c(r1)
            net.one97.paytm.recharge.common.utils.ay r6 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((java.lang.String) r2, (java.lang.Object) r14)
            boolean r6 = android.webkit.URLUtil.isValidUrl(r5)
            if (r6 == 0) goto L_0x0139
            if (r27 == 0) goto L_0x0060
            java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r1, (java.lang.String) r5)
        L_0x0060:
            android.content.Context r6 = r0.f60907a
            java.lang.String r5 = com.paytm.utility.b.s(r6, r5)
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r6 = r0.f60907a
            boolean r6 = net.one97.paytm.recharge.common.utils.az.f(r6)
            if (r6 == 0) goto L_0x0081
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "&is_reseller=1"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        L_0x0081:
            android.content.Context r6 = r0.f60907a
            boolean r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r6, (java.lang.String) r1)
            if (r1 == 0) goto L_0x00bd
            android.net.Uri r1 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.lang.String r6 = "payment_info_version"
            java.lang.String r8 = "2"
            android.net.Uri$Builder r1 = r1.appendQueryParameter(r6, r8)
            android.net.Uri r1 = r1.build()
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x00ab }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ab }
            r6.<init>(r1)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ac
        L_0x00ab:
        L_0x00ac:
            android.content.Context r1 = r0.f60907a
            boolean r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r1)
            if (r1 == 0) goto L_0x00bd
            java.lang.String r1 = "&show_bank_offers=1"
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r5, (java.lang.Object) r1)
            r16 = r1
            goto L_0x00bf
        L_0x00bd:
            r16 = r5
        L_0x00bf:
            android.content.Context r1 = r0.f60907a
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x010a
            net.one97.paytm.recharge.common.f.c r15 = new net.one97.paytm.recharge.common.f.c
            r1 = r15
            net.one97.paytm.common.entity.CJRRechargeCart r5 = new net.one97.paytm.common.entity.CJRRechargeCart
            r5.<init>()
            com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
            r6 = 0
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r8 = r22.toString()
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.POST
            com.paytm.network.a$c r10 = com.paytm.network.a.c.RECHARGES
            r13 = 0
            r3 = 0
            r18 = r15
            r15 = r3
            r17 = 10240(0x2800, float:1.4349E-41)
            r2 = r20
            r3 = r16
            r4 = r21
            r11 = r24
            r12 = r23
            r14 = r25
            r16 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.lang.String r1 = net.one97.paytm.recharge.common.utils.ba.f61539a
            java.lang.String r2 = "RechargeUtils.VOLLEY_REQ_TAG"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = r18
            r2.a((java.lang.String) r1)
            net.one97.paytm.recharge.common.f.d.a()
            r15 = r2
            net.one97.paytm.recharge.common.f.a r15 = (net.one97.paytm.recharge.common.f.a) r15
            net.one97.paytm.recharge.common.f.d.b(r15)
            return
        L_0x010a:
            boolean r1 = r14 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x0120
            r1 = r14
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r1.getFlowName()
            if (r1 == 0) goto L_0x0120
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            java.lang.String r3 = r3.name()
            r1.setErrorType(r3)
        L_0x0120:
            r3 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.as r1 = new net.one97.paytm.recharge.common.utils.as
            r6 = 0
            r7 = 1
            r8 = 0
            r1.<init>(r6, r7, r8)
            r6 = r1
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r1 = r21
            r2 = r20
            r4 = r5
            r5 = r6
            r6 = r25
            r1.a(r2, r3, r4, r5, r6)
            return
        L_0x0139:
            boolean r1 = r14 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x014f
            r1 = r14
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r1.getFlowName()
            if (r1 == 0) goto L_0x014f
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            java.lang.String r3 = r3.name()
            r1.setErrorType(r3)
        L_0x014f:
            r3 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.ap r1 = new net.one97.paytm.recharge.common.utils.ap
            r1.<init>()
            r6 = r1
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r1 = r21
            r2 = r20
            r4 = r5
            r5 = r6
            r6 = r25
            r1.a(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.a.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, org.json.JSONObject, java.lang.String, com.paytm.network.a$b, java.lang.Object, int, boolean):void");
    }

    public final void b(String str, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String t = net.one97.paytm.recharge.di.helper.c.t();
        Map hashMap = new HashMap();
        hashMap.put("ssotoken", CJRRechargeUtilities.INSTANCE.getSSOToken(this.f60907a));
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        if (!URLUtil.isValidUrl(t)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, t, aiVar, (IJRPaytmDataModel) new CJRCashWallet(), (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, obj);
            String str2 = ba.f61539a;
            k.a((Object) str2, "RechargeUtils.VOLLEY_REQ_TAG");
            cVar2.a(str2);
            d.a();
            d.b(cVar2);
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r11, net.one97.paytm.recharge.common.e.ai r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "responseListener"
            kotlin.g.b.k.c(r12, r0)
            net.one97.paytm.recharge.common.utils.ax$a r0 = net.one97.paytm.recharge.common.utils.ax.f61521a
            android.content.Context r0 = r10.f60907a
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0)
            r1 = 1
            java.lang.String r2 = "sso_token="
            java.lang.String r3 = ""
            r0.b((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            net.one97.paytm.recharge.common.utils.ay r0 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((java.lang.String) r11, (java.lang.Object) r13)
            boolean r0 = r13 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x003a
            r2 = r13
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r3 = net.one97.paytm.recharge.di.helper.c.a()
            r2.setUrl(r3)
        L_0x003a:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r3 = r10.f60907a
            java.lang.String r2 = r2.getWalletSSOToken(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 0
            if (r2 != 0) goto L_0x005d
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r4 = r10.f60907a
            long r4 = r2.getWalletTokenExpireTime(r4)
            long r6 = java.lang.System.currentTimeMillis()
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x005d
            r2 = 1
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 == 0) goto L_0x00a2
            net.one97.paytm.common.entity.CJRPGToken r0 = new net.one97.paytm.common.entity.CJRPGToken
            r0.<init>()
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r2 = r10.f60907a
            java.lang.String r1 = r1.getWalletSSOToken(r2)
            r0.setToken(r1)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r2 = r10.f60907a
            long r1 = r1.getWalletTokenExpireTime(r2)
            r0.setExpires(r1)
            java.lang.String r1 = "wallet"
            r0.setScopes(r1)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r2 = r10.f60907a
            java.lang.String r1 = r1.getResourceId(r2)
            r0.setResourceOwnerId(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r0)
            net.one97.paytm.common.entity.CJRPGTokenList r0 = new net.one97.paytm.common.entity.CJRPGTokenList
            r0.<init>()
            r0.setPGTokenList(r1)
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
            r12.a_(r11, r0, r13)
            return
        L_0x00a2:
            android.content.Context r2 = r10.f60907a
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 == 0) goto L_0x00b7
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r0 = r10.f60907a
            net.one97.paytm.recharge.common.e.b r1 = new net.one97.paytm.recharge.common.e.b
            r1.<init>(r12, r11)
            r13.fetchWalletToken(r0, r1)
            return
        L_0x00b7:
            if (r0 == 0) goto L_0x00cb
            r0 = r13
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r0.getFlowName()
            if (r0 == 0) goto L_0x00cb
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x00cb:
            r6 = 0
            r7 = 0
            net.one97.paytm.recharge.common.utils.as r0 = new net.one97.paytm.recharge.common.utils.as
            r2 = 0
            r0.<init>(r3, r1, r2)
            r8 = r0
            com.paytm.network.model.NetworkCustomError r8 = (com.paytm.network.model.NetworkCustomError) r8
            r4 = r12
            r5 = r11
            r9 = r13
            r4.a(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.a.a_(java.lang.String, net.one97.paytm.recharge.common.e.ai, java.lang.Object):void");
    }

    public final void a(String str, String str2, ai aiVar, String str3, String str4, boolean z, JSONObject jSONObject, boolean z2, String str5, Object obj) {
        CRUFlowModel flowName;
        String str6;
        CRUFlowModel flowName2;
        String str7 = str;
        String str8 = str2;
        String str9 = str5;
        Object obj2 = obj;
        k.c(str, "tag");
        k.c(str2, "walletToken");
        k.c(aiVar, "responseListener");
        k.c(jSONObject, "jsonCart");
        ay ayVar = ay.f61523a;
        ay.a(str, obj2);
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("wallet_token", str2);
        String a2 = com.paytm.utility.d.a(this.f60907a);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put(AppConstants.SSO_TOKEN, a2);
        if (!TextUtils.isEmpty(str9)) {
            if (str9 == null) {
                k.a();
            }
            hashMap.put("risk_extended_info", str9);
        }
        net.one97.paytm.f.b.a().c();
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String a3 = net.one97.paytm.recharge.di.helper.c.a(jSONObject);
        if (URLUtil.isValidUrl(a3)) {
            String s = com.paytm.utility.b.s(this.f60907a, a3);
            az azVar = az.f61525a;
            if (az.f(this.f60907a)) {
                s = s + "&is_reseller=1";
            }
            String k = com.paytm.utility.b.k();
            Uri parse = Uri.parse(s);
            k.a((Object) parse, "Uri.parse(url)");
            if (parse.getQuery() != null) {
                str6 = s + "&client_id=" + k;
            } else {
                str6 = s + "?client_id=" + k;
            }
            if (z2) {
                str6 = str6 + "&withdraw=1";
            }
            String b2 = ab.b(com.paytm.utility.b.d(str6, "POST"));
            StringBuilder sb = new StringBuilder();
            sb.append(b2);
            sb.append("json cart item ");
            sb.append(jSONObject.toString());
            com.paytm.utility.b.j();
            if (com.paytm.utility.b.c(this.f60907a)) {
                net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, b2, aiVar, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), obj);
                String str10 = ba.f61539a;
                k.a((Object) str10, "RechargeUtils.VOLLEY_REQ_TAG");
                cVar2.a(str10);
                d.a();
                d.b(cVar2);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, net.one97.paytm.recharge.common.e.ai r18, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r19, java.lang.Object r20) {
        /*
            r16 = this;
            r1 = r16
            r11 = r17
            r12 = r20
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "responseListener"
            r13 = r18
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "recentOrder"
            r2 = r19
            kotlin.g.b.k.c(r2, r0)
            net.one97.paytm.recharge.common.utils.ay r0 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((java.lang.String) r11, (java.lang.Object) r12)
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.u()
            boolean r3 = android.webkit.URLUtil.isValidUrl(r0)
            if (r3 == 0) goto L_0x0116
            android.content.Context r3 = r1.f60907a
            r14 = 1
            java.lang.String r3 = com.paytm.utility.c.a((android.content.Context) r3, (boolean) r14)
            java.lang.String r4 = kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r3)
            net.one97.paytm.recharge.model.rechargeutility.CJRFrequentOrderDeletResponse r0 = new net.one97.paytm.recharge.model.rechargeutility.CJRFrequentOrderDeletResponse
            r0.<init>()
            android.content.Context r3 = r1.f60907a
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            r10 = 0
            if (r3 == 0) goto L_0x00e9
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r5 = r3
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.put(r6, r7)
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            java.lang.String r2 = r19.getFavOrderId()
            r5.put(r2)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a7 }
            r2.<init>()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r6 = "favLabelId"
            r2.put(r6, r5)     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r5 = "channel"
            java.lang.String r6 = "android"
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r5 = "version"
            r6 = 2
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x00a7 }
            net.one97.paytm.recharge.common.f.c r9 = new net.one97.paytm.recharge.common.f.c     // Catch:{ JSONException -> 0x00a7 }
            r6 = r0
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6     // Catch:{ JSONException -> 0x00a7 }
            r7 = 0
            r8 = r3
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x00a7 }
            r2 = r9
            r3 = r17
            r5 = r18
            r14 = r9
            r9 = r0
            r15 = 0
            r10 = r20
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (net.one97.paytm.recharge.common.e.ai) r5, (com.paytm.network.model.IJRPaytmDataModel) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00a5 }
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.f61539a     // Catch:{ JSONException -> 0x00a5 }
            java.lang.String r2 = "RechargeUtils.VOLLEY_REQ_TAG"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x00a5 }
            r14.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x00a5 }
            net.one97.paytm.recharge.common.f.d.a()     // Catch:{ JSONException -> 0x00a5 }
            r9 = r14
            net.one97.paytm.recharge.common.f.a r9 = (net.one97.paytm.recharge.common.f.a) r9     // Catch:{ JSONException -> 0x00a5 }
            net.one97.paytm.recharge.common.f.d.b(r9)     // Catch:{ JSONException -> 0x00a5 }
            return
        L_0x00a5:
            r0 = move-exception
            goto L_0x00a9
        L_0x00a7:
            r0 = move-exception
            r15 = 0
        L_0x00a9:
            java.lang.String r2 = r0.getMessage()
            com.paytm.utility.q.d(r2)
            boolean r2 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r2 == 0) goto L_0x00d3
            r2 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x00c4
            java.lang.String r0 = r0.getMessage()
            r3.setOtherDetails(r0)
        L_0x00c4:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r2.getFlowName()
            if (r0 == 0) goto L_0x00d3
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_ARG
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x00d3:
            r4 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.as r0 = new net.one97.paytm.recharge.common.utils.as
            r2 = 0
            r3 = 1
            r0.<init>(r15, r3, r2)
            r6 = r0
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r2 = r18
            r3 = r17
            r7 = r20
            r2.a(r3, r4, r5, r6, r7)
            return
        L_0x00e9:
            r15 = 0
            boolean r0 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0100
            r0 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r0.getFlowName()
            if (r0 == 0) goto L_0x0100
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x0100:
            r4 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.as r0 = new net.one97.paytm.recharge.common.utils.as
            r2 = 0
            r3 = 1
            r0.<init>(r15, r3, r2)
            r6 = r0
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r2 = r18
            r3 = r17
            r7 = r20
            r2.a(r3, r4, r5, r6, r7)
            return
        L_0x0116:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x012c
            r0 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r0.getFlowName()
            if (r0 == 0) goto L_0x012c
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x012c:
            r4 = 0
            r5 = 0
            net.one97.paytm.recharge.common.utils.ap r0 = new net.one97.paytm.recharge.common.utils.ap
            r0.<init>()
            r6 = r0
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            r2 = r18
            r3 = r17
            r7 = r20
            r2.a(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.a.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, net.one97.paytm.common.entity.recharge.CJRFrequentOrder, java.lang.Object):void");
    }

    public final void a(String str, ai aiVar, String str2, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "offersUrl");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        az azVar = az.f61525a;
        if (az.f(this.f60907a)) {
            CharSequence charSequence = str2;
            if (!TextUtils.isEmpty(charSequence) && p.a(charSequence, (CharSequence) "?", false)) {
                str2 = str2 + "&isReseller=true";
            } else if (!TextUtils.isEmpty(charSequence) && !p.a(charSequence, (CharSequence) "?", false)) {
                str2 = str2 + "?isReseller=true";
            }
        }
        String str3 = str2 + "&sortType=2";
        if (URLUtil.isValidUrl(str3)) {
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(this.f60907a);
            if (a2 == null) {
                a2 = "";
            }
            hashMap.put(AppConstants.SSO_TOKEN, a2);
            if (com.paytm.utility.b.c(this.f60907a)) {
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.b(str, str3, aiVar, new CJROffers(), hashMap, obj));
                return;
            }
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_ARG.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public final void b(String str, ai aiVar, String str2, Object obj) {
        String str3;
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "categoryId");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.v());
        sb.append(str2);
        net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.w());
        if (p.a((CharSequence) sb, (CharSequence) "?", false)) {
            String a2 = com.paytm.utility.c.a(this.f60907a, false);
            k.a((Object) a2, "defaultParam");
            if (p.a((CharSequence) a2, (CharSequence) "?", false)) {
                a2 = p.a(a2, "?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, false);
            }
            sb.append(a2);
        } else {
            sb.append(com.paytm.utility.c.a(this.f60907a, false));
        }
        sb.append("&sortType=2");
        HashMap hashMap = new HashMap();
        String a3 = com.paytm.utility.d.a(this.f60907a);
        if (!TextUtils.isEmpty(a3)) {
            k.a((Object) a3, "ssoToken");
            hashMap.put(AppConstants.SSO_TOKEN, a3);
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "offerUrl.toString()");
        if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
            sb2 = "http://demo8221762.mockable.io/offers/" + str2 + '/';
        }
        az azVar = az.f61525a;
        if (az.f(this.f60907a)) {
            str3 = sb2 + "&isReseller=true";
        } else {
            str3 = sb2;
        }
        if (!URLUtil.isValidUrl(str3)) {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new at(new ap()), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            d.a();
            d.b(new net.one97.paytm.recharge.common.f.b(str, str3, (ai) new C1175a(aiVar), (IJRPaytmDataModel) new CJROffers(), (Map<String, String>) hashMap, obj, 30000));
        } else {
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new at(new as(false, 1, (g) null)), obj);
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.b.c.a$a  reason: collision with other inner class name */
    public static final class C1175a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f60908a;

        C1175a(ai aiVar) {
            this.f60908a = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f60908a.a(str, 0, (IJRPaytmDataModel) null, new at(networkCustomError), obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60908a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void c(String str, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        Class<a> cls = a.class;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        String a2 = com.paytm.utility.d.a(this.f60907a);
        if (!TextUtils.isEmpty(a2)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String b2 = net.one97.paytm.recharge.di.helper.c.b();
            if (TextUtils.isEmpty(b2) || !URLUtil.isValidUrl(b2)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog(cls.getSimpleName() + " getFrequentOrders() InvalidUrlError");
                if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
                return;
            }
            if (b2 == null) {
                b2 = "";
            }
            StringBuilder sb = new StringBuilder(b2);
            if (p.a((CharSequence) sb, (CharSequence) "?", false)) {
                String a3 = com.paytm.utility.c.a(this.f60907a, false);
                k.a((Object) a3, "defaultParam");
                if (p.a((CharSequence) a3, (CharSequence) "?", false)) {
                    a3 = p.a(a3, "?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, false);
                }
                sb.append(a3);
            } else {
                sb.append(com.paytm.utility.c.a(this.f60907a, false));
            }
            Map hashMap = new HashMap();
            k.a((Object) a2, "ssoToken");
            hashMap.put(AppConstants.SSO_TOKEN, a2);
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.b.c(this.f60907a)) {
                CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities2.debugLog(cls.getSimpleName() + " getFrequentOrders()");
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.b(str, sb.toString(), aiVar, new CJRFrequentOrderList(), hashMap, obj));
                return;
            }
            CJRRechargeUtilities cJRRechargeUtilities3 = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities3.debugLog(cls.getSimpleName() + " getFrequentOrders() NetworkError");
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    public final void d(String str, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        CRUFlowModel flowName3;
        Class<a> cls = a.class;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        String a2 = com.paytm.utility.d.a(this.f60907a);
        if (!TextUtils.isEmpty(a2)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String d2 = net.one97.paytm.recharge.di.helper.c.d("OPEN");
            if (URLUtil.isValidUrl(d2)) {
                StringBuilder sb = new StringBuilder(d2);
                if (p.a((CharSequence) sb, (CharSequence) "?", false)) {
                    String a3 = com.paytm.utility.c.a(this.f60907a, false);
                    k.a((Object) a3, "defaultParam");
                    if (p.a((CharSequence) a3, (CharSequence) "?", false)) {
                        a3 = p.a(a3, "?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, false);
                    }
                    sb.append(a3);
                } else {
                    sb.append(com.paytm.utility.c.a(this.f60907a, false));
                }
                Map hashMap = new HashMap();
                k.a((Object) a2, "ssoToken");
                hashMap.put(AppConstants.SSO_TOKEN, a2);
                hashMap.put("client_id", "APP");
                if (com.paytm.utility.b.c(this.f60907a)) {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    cJRRechargeUtilities.debugLog(cls.getSimpleName() + " getMerchantLoanAccounts()");
                    d.a();
                    d.b(new net.one97.paytm.recharge.common.f.b(str, sb.toString(), aiVar, new CJRMerchantLoanAccounts(), hashMap, obj));
                    return;
                }
                CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities2.debugLog(cls.getSimpleName() + " getMerchantLoanAccounts() NetworkError");
                if ((obj instanceof CJRRechargeErrorModel) && (flowName3 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
                return;
            }
            CJRRechargeUtilities cJRRechargeUtilities3 = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities3.debugLog(cls.getSimpleName() + " getMerchantLoanAccounts() InvalidUrlError");
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
            return;
        }
        CJRRechargeUtilities cJRRechargeUtilities4 = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities4.debugLog(cls.getSimpleName() + " getMerchantLoanAccounts() AuthError");
        if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.AUTH.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.c(), obj);
    }

    public final void e(String str, ai aiVar, Object obj) {
        LinkedList<String> logs;
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        String a2 = com.paytm.utility.d.a(this.f60907a);
        ax.a aVar = ax.f61521a;
        Context applicationContext = this.f60907a.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a3 = ax.a.a(applicationContext);
        String str2 = e.aQ;
        k.a((Object) str2, "CJRParamConstants.CUSTOMER_ID_SMS");
        String b2 = a3.b(str2, "", true);
        CharSequence charSequence = a2;
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(b2)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String c2 = net.one97.paytm.recharge.di.helper.c.c();
            if (URLUtil.isValidUrl(c2)) {
                String s = com.paytm.utility.b.s(this.f60907a, c2 + "?cust_id=" + b2);
                Map hashMap = new HashMap();
                k.a((Object) a2, "ssoToken");
                hashMap.put(AppConstants.SSO_TOKEN, a2);
                if (com.paytm.utility.b.c(this.f60907a)) {
                    d.a();
                    d.b(new net.one97.paytm.recharge.common.f.b(str, s, aiVar, new CJRAutomaticSubscriptionListModel(), hashMap, obj));
                    return;
                }
                if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
                return;
            }
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
            if (!(flowName3 == null || (logs = flowName3.getLogs()) == null)) {
                logs.push("TOKEN is EMPTY: " + TextUtils.isEmpty(charSequence) + " or CustID is EMPTY: " + TextUtils.isEmpty(b2));
            }
            az azVar = az.f61525a;
            az.a(cJRRechargeErrorModel);
        }
    }

    public final void c(String str, ai aiVar, String str2, Object obj) {
        LinkedList<String> logs;
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "rechargeNumber");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        String a2 = com.paytm.utility.d.a(this.f60907a);
        ax.a aVar = ax.f61521a;
        Context applicationContext = this.f60907a.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a3 = ax.a.a(applicationContext);
        String str3 = e.aQ;
        k.a((Object) str3, "CJRParamConstants.CUSTOMER_ID_SMS");
        String b2 = a3.b(str3, "", true);
        CharSequence charSequence = a2;
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(b2)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            String c2 = net.one97.paytm.recharge.di.helper.c.c();
            if (URLUtil.isValidUrl(c2)) {
                String s = com.paytm.utility.b.s(this.f60907a, (c2 + "?cust_id=" + b2) + "&rech_num=" + str2);
                Map hashMap = new HashMap();
                k.a((Object) a2, "ssoToken");
                hashMap.put(AppConstants.SSO_TOKEN, a2);
                if (com.paytm.utility.b.c(this.f60907a)) {
                    d.a();
                    d.b(new net.one97.paytm.recharge.common.f.b(str, s, aiVar, new CJRAutomaticSubscriptionCheckModel(), hashMap, obj));
                    return;
                }
                if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
                return;
            }
            if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
            if (!(flowName3 == null || (logs = flowName3.getLogs()) == null)) {
                logs.push("TOKEN is EMPTY: " + TextUtils.isEmpty(charSequence) + " or CustID is EMPTY: " + TextUtils.isEmpty(b2));
            }
            az azVar = az.f61525a;
            az.a(cJRRechargeErrorModel);
        }
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, Object obj) {
        CRUFlowModel flowName;
        String str2;
        CRUFlowModel flowName2;
        String str3 = str;
        ai aiVar2 = aiVar;
        Object obj2 = obj;
        k.c(str3, "tag");
        k.c(aiVar2, "responseListener");
        k.c(jSONObject, "body");
        ay ayVar = ay.f61523a;
        ay.a(str3, obj2);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String x = net.one97.paytm.recharge.di.helper.c.x();
        if (URLUtil.isValidUrl(x)) {
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, CJRRechargeUtilities.INSTANCE.getSSOToken(this.f60907a));
            if (x != null) {
                str2 = p.a(x, " ", "%20", false);
            } else {
                str2 = null;
            }
            net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, str2, (ai) new c(aiVar2), (IJRPaytmDataModel) new CJRSetUserConsentApiResponse((Integer) null, (String) null, (String) null, (String) null, 15, (g) null), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), obj);
            if (com.paytm.utility.b.c(this.f60907a)) {
                String str4 = ba.f61539a;
                k.a((Object) str4, "RechargeUtils.VOLLEY_REQ_TAG");
                cVar2.a(str4);
                d.a();
                d.b(cVar2);
                return;
            }
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f60910a;

        c(ai aiVar) {
            this.f60910a = aiVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60910a.a_(str, iJRPaytmDataModel, obj);
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f60910a.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.d(), obj);
        }
    }

    public final void d(String str, ai aiVar, String str2, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "body");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String a2 = k.a(net.one97.paytm.recharge.di.helper.c.y(), (Object) str2);
        if (URLUtil.isValidUrl(a2)) {
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            String a3 = com.paytm.utility.d.a(this.f60907a);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(context)");
            hashMap.put(AppConstants.SSO_TOKEN, a3);
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, p.a(a2, " ", "%20", false), new b(aiVar), new CJRGetUserConsentApiResponse((Integer) null, (CJRGetBillData) null, 3, (g) null), hashMap, obj);
            if (com.paytm.utility.b.c(this.f60907a)) {
                String str3 = ba.f61539a;
                k.a((Object) str3, "RechargeUtils.VOLLEY_REQ_TAG");
                bVar.a(str3);
                d.a();
                d.b(bVar);
                return;
            }
            if ((obj instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
            return;
        }
        if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f60909a;

        b(ai aiVar) {
            this.f60909a = aiVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f60909a.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.d(), obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60909a.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void a(String str, ai aiVar, String str2, HashMap<String, String> hashMap, Object obj) {
        CRUFlowModel flowName;
        String str3;
        CRUFlowModel flowName2;
        String str4 = str;
        HashMap<String, String> hashMap2 = hashMap;
        Object obj2 = obj;
        k.c(str, "tag");
        ai aiVar2 = aiVar;
        k.c(aiVar, "responseListener");
        String str5 = str2;
        k.c(str2, "body");
        k.c(hashMap, H5Logger.HEADER);
        ay ayVar = ay.f61523a;
        ay.a(str, obj2);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        String z = net.one97.paytm.recharge.di.helper.c.z();
        if (!URLUtil.isValidUrl(z)) {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.INVALID_URL.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new ap(), obj);
        } else if (com.paytm.utility.b.c(this.f60907a)) {
            if (z != null) {
                str3 = p.a(z, " ", "%20", false);
            } else {
                str3 = null;
            }
            d.a();
            d.b(new net.one97.paytm.recharge.common.f.c(str, str3, aiVar, (IJRPaytmDataModel) new UnsubscribeApiResponse((Integer) null, (String) null, 3, (g) null), (Map<String, String>) hashMap2, str2, a.C0715a.PUT, obj));
        } else {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
        }
    }

    public final void a(Context context, String str, String str2, CJRCreditCardModel cJRCreditCardModel, CJRCreditCardModel cJRCreditCardModel2, ai aiVar, Object obj) {
        CRUFlowModel flowName;
        CRUFlowModel flowName2;
        String str3 = str;
        CJRCreditCardModel cJRCreditCardModel3 = cJRCreditCardModel2;
        Object obj2 = obj;
        Context context2 = context;
        k.c(context, "context");
        k.c(str3, "tag");
        k.c(str2, "url");
        k.c(cJRCreditCardModel3, "responseBody");
        k.c(aiVar, "responseListener");
        ay ayVar = ay.f61523a;
        ay.a(str3, obj2);
        String a2 = new f().a((Object) cJRCreditCardModel);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(com.paytm.utility.d.a(context))) {
            if ((obj2 instanceof CJRRechargeErrorModel) && (flowName2 = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                flowName2.setErrorType(ERROR_TYPE.AUTH.name());
            }
            aiVar.a(str, 0, (IJRPaytmDataModel) null, new net.one97.paytm.recharge.common.utils.c(), obj);
            return;
        }
        Map map = hashMap;
        String a3 = com.paytm.utility.d.a(context);
        k.a((Object) a3, "CJRNetUtility.getSSOToken(context)");
        map.put("ssoToken", a3);
        net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(str, str2, aiVar, (IJRPaytmDataModel) cJRCreditCardModel3, (Map<String, String>) null, (Map<String, String>) map, a2, obj);
        if (com.paytm.utility.b.c(context)) {
            d.a();
            d.b(cVar);
            return;
        }
        if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
            flowName.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
        }
        aiVar.a(str, 0, (IJRPaytmDataModel) null, new as(false, 1, (g) null), obj);
    }

    public void a(String str, String str2, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(str2, "promoCode");
        k.c(aiVar, "onSuccess");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.bK());
        sb.append(str2);
        sb.append("/1/tnc");
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2) && com.paytm.utility.b.c(this.f60907a)) {
            d.a();
            d.b(new net.one97.paytm.recharge.common.f.b(str, sb2, aiVar, new CJRPromoCodeTerms((String) null, (String) null, (String) null, 7, (g) null), obj));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x006c, code lost:
        r7 = r20.getCart();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r16, net.one97.paytm.recharge.common.e.ai r17, java.lang.String r18, java.lang.String r19, net.one97.paytm.common.entity.CJRRechargeCart r20, java.lang.String r21, java.lang.String r22, net.one97.paytm.common.entity.shopping.CJRCartProduct r23, java.lang.Object r24) {
        /*
            r15 = this;
            r1 = r15
            r11 = r16
            r2 = r18
            r3 = r19
            r4 = r21
            r0 = r22
            r12 = r24
            java.lang.String r5 = "mMasterProduct.getmProductAttrubutes()"
            java.lang.String r6 = "tag"
            kotlin.g.b.k.c(r11, r6)
            java.lang.String r6 = "responseListener"
            r13 = r17
            kotlin.g.b.k.c(r13, r6)
            java.lang.String r6 = "url"
            kotlin.g.b.k.c(r2, r6)
            java.lang.String r6 = "productMasterNumber"
            kotlin.g.b.k.c(r3, r6)
            java.lang.String r6 = "productMasterId"
            kotlin.g.b.k.c(r4, r6)
            java.lang.String r6 = "rechargeMasterPrice"
            kotlin.g.b.k.c(r0, r6)
            net.one97.paytm.recharge.common.utils.ay r6 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((java.lang.String) r11, (java.lang.Object) r12)
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r8 = r7
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r7 = "Content-Type"
            java.lang.String r9 = "application/json"
            r8.put(r7, r9)
            android.content.Context r7 = r1.f60907a
            java.lang.String r7 = com.paytm.utility.d.a(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0069
            android.content.Context r7 = r1.f60907a
            java.lang.String r7 = com.paytm.utility.d.a(r7)
            java.lang.String r9 = "CJRNetUtility.getSSOToken(context)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r9 = "sso_token"
            r8.put(r9, r7)
        L_0x0069:
            r14 = 0
            if (r20 == 0) goto L_0x0077
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r20.getCart()
            if (r7 == 0) goto L_0x0077
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = r7.getCartProduct(r4)
            goto L_0x0078
        L_0x0077:
            r7 = r14
        L_0x0078:
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a(r9)
            if (r9 == 0) goto L_0x0091
            if (r20 == 0) goto L_0x008f
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r20.getCart()
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r0.getFinalPrice()
            if (r0 != 0) goto L_0x0091
        L_0x008f:
            java.lang.String r0 = ""
        L_0x0091:
            r9 = r0
            if (r7 == 0) goto L_0x00e8
            java.lang.String r0 = "vertical_id"
            java.lang.String r10 = r7.getVerticalId()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r10)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "merchant_id"
            java.lang.String r10 = r7.getMerchantId()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r10)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "operator"
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r10 = r7.getmProductAttrubutes()     // Catch:{ all -> 0x00e2 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = r10.getOperator()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r10)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "service"
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r10 = r7.getmProductAttrubutes()     // Catch:{ all -> 0x00e2 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = r10.getService()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r10)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "paytype"
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r10 = r7.getmProductAttrubutes()     // Catch:{ all -> 0x00e2 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = r10.getPaytype()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "brand"
            java.lang.String r5 = r7.getBrand()     // Catch:{ all -> 0x00e2 }
            r6.put(r0, r5)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e8
        L_0x00e2:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r5 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r5.debugLogExceptions(r0)
        L_0x00e8:
            android.content.Context r0 = r1.f60907a
            java.lang.String r9 = net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r9, (org.json.JSONObject) r6)
            boolean r0 = android.webkit.URLUtil.isValidUrl(r18)
            if (r0 == 0) goto L_0x0165
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = "&channel=android"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.content.Context r2 = r1.f60907a
            java.lang.String r4 = com.paytm.utility.b.s(r2, r0)
            java.lang.String r0 = "CJRAppCommonUtility.addD…WithoutSSO(context, mUrl)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.paytm.recharge.common.f.c r0 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.model.CJRPersonalInsurance r2 = new net.one97.paytm.recharge.model.CJRPersonalInsurance
            r2.<init>()
            r6 = r2
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
            r7 = 0
            r2 = r0
            r3 = r16
            r5 = r17
            r10 = r24
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (net.one97.paytm.recharge.common.e.ai) r5, (com.paytm.network.model.IJRPaytmDataModel) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8, (java.lang.String) r9, (java.lang.Object) r10)
            android.content.Context r2 = r1.f60907a
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 == 0) goto L_0x0136
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.a r0 = (net.one97.paytm.recharge.common.f.a) r0
            net.one97.paytm.recharge.common.f.d.b(r0)
            return
        L_0x0136:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x014c
            r0 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r0.getFlowName()
            if (r0 == 0) goto L_0x014c
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x014c:
            r0 = 0
            r2 = 0
            net.one97.paytm.recharge.common.utils.as r3 = new net.one97.paytm.recharge.common.utils.as
            r4 = 0
            r5 = 1
            r3.<init>(r4, r5, r14)
            com.paytm.network.model.NetworkCustomError r3 = (com.paytm.network.model.NetworkCustomError) r3
            r18 = r16
            r19 = r0
            r20 = r2
            r21 = r3
            r22 = r24
            r17.a(r18, r19, r20, r21, r22)
            return
        L_0x0165:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x017b
            r0 = r12
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r0.getFlowName()
            if (r0 == 0) goto L_0x017b
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            java.lang.String r2 = r2.name()
            r0.setErrorType(r2)
        L_0x017b:
            r0 = 0
            r2 = 0
            net.one97.paytm.recharge.common.utils.ap r3 = new net.one97.paytm.recharge.common.utils.ap
            r3.<init>()
            com.paytm.network.model.NetworkCustomError r3 = (com.paytm.network.model.NetworkCustomError) r3
            r18 = r16
            r19 = r0
            r20 = r2
            r21 = r3
            r22 = r24
            r17.a(r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.a.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, java.lang.String, java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart, java.lang.String, java.lang.String, net.one97.paytm.common.entity.shopping.CJRCartProduct, java.lang.Object):void");
    }
}
