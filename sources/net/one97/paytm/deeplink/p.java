package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.j.c;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f50364a = new p();

    private p() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x02cc A[Catch:{ ActivityNotFoundException -> 0x02d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r8, net.one97.paytm.deeplink.DeepLinkData r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r9, r0)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = r9.f50284b
            java.lang.String r2 = "joinprime"
            r3 = 0
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            java.lang.String r4 = "paytm_first.PaytmFirstInitActivity"
            java.lang.String r5 = "is_prime_enabled_android_v3"
            java.lang.String r6 = "deeplink"
            if (r1 == 0) goto L_0x0033
            net.one97.paytm.j.c.a()
            boolean r1 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r3)
            if (r1 == 0) goto L_0x0033
            r0.setClassName(r8, r4)
            java.lang.String r9 = r9.f50283a
            r0.putExtra(r6, r9)
            goto L_0x02c8
        L_0x0033:
            java.lang.String r1 = r9.f50284b
            java.lang.String r7 = "external"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r3)
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = r9.f50283a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = r9.f50283a
            if (r1 != 0) goto L_0x004e
            kotlin.g.b.k.a()
        L_0x004e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, false)
            if (r1 == 0) goto L_0x0070
            net.one97.paytm.j.c.a()
            boolean r1 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r3)
            if (r1 == 0) goto L_0x0070
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            r1.setClassName(r8, r4)
            java.lang.String r9 = r9.f50283a
            r1.putExtra(r6, r9)
            goto L_0x02c8
        L_0x0070:
            java.lang.String r1 = r9.f50284b
            java.lang.String r2 = "homepage_primary"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 == 0) goto L_0x0087
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r9 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r0.setClass(r8, r9)
            java.lang.String r9 = "url_type"
            r0.putExtra(r9, r2)
            goto L_0x02c8
        L_0x0087:
            java.lang.String r1 = r9.f50284b
            java.lang.String r2 = "paytmupdate"
            boolean r1 = r2.equals(r1)
            r2 = 1
            if (r1 == 0) goto L_0x00a8
            java.lang.String r1 = r9.f50288f
            java.lang.String r4 = "chat"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00a8
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r9 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r0.setClass(r8, r9)
            java.lang.String r9 = "extra_open_chat_feed_tab"
            r0.putExtra(r9, r2)
            goto L_0x02c8
        L_0x00a8:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "edit_cersai"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x00c5
            java.lang.String r9 = net.one97.paytm.utils.t.b((android.content.Context) r8)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x02c8
            java.lang.Class<net.one97.paytm.upgradeKyc.editprofile.view.StandAloneCersaiActivity> r9 = net.one97.paytm.upgradeKyc.editprofile.view.StandAloneCersaiActivity.class
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x00c5:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "automatic_payment"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x00dc
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.N()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x00dc:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "debug_setting"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x00f3
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.U()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x00f3:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "payment_limit"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x010a
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.O()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x010a:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "screen_recording"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0121
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.P()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x0121:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "security_shield"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0138
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.Q()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x0138:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "saved_card"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x014f
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.R()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x014f:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "paytm_assist"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0166
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.S()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x0166:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "remote_desktop"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x017d
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            java.lang.Class r9 = r9.T()
            r0.setClass(r8, r9)
            goto L_0x02c8
        L_0x017d:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "home_upi_request"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0210
            java.lang.String r9 = r9.f50283a
            android.net.Uri r9 = android.net.Uri.parse(r9)
            net.one97.paytm.upi.common.upi.UpiPendingRequestModel r1 = new net.one97.paytm.upi.common.upi.UpiPendingRequestModel
            r1.<init>()
            if (r9 == 0) goto L_0x02c8
            java.lang.String r2 = "payer_vpa"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x01a7
            java.lang.String r2 = r9.getQueryParameter(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setPayerVa(r2)
        L_0x01a7:
            java.lang.String r2 = "amount"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x01ba
            java.lang.String r2 = r9.getQueryParameter(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setAmount(r2)
        L_0x01ba:
            java.lang.String r2 = "payee_name"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x01cd
            java.lang.String r2 = r9.getQueryParameter(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setPayeeName(r2)
        L_0x01cd:
            java.lang.String r2 = "txn_id"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x01e1
            java.lang.String r2 = r9.getQueryParameter(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setTxnId(r2)
        L_0x01e1:
            java.lang.String r2 = "note"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x01f4
            java.lang.String r2 = r9.getQueryParameter(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setNote(r2)
        L_0x01f4:
            java.lang.String r2 = "payee_vpa"
            java.lang.String r3 = r9.getQueryParameter(r2)
            if (r3 == 0) goto L_0x0207
            java.lang.String r9 = r9.getQueryParameter(r2)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r1.setPayeeVa(r9)
        L_0x0207:
            net.one97.paytm.upi.q$a r9 = net.one97.paytm.upi.q.f68356a
            java.lang.String r9 = "homepage_widget"
            net.one97.paytm.upi.q.a.a((net.one97.paytm.upi.common.upi.UpiPendingRequestModel) r1, (android.content.Context) r8, (java.lang.String) r9)
            goto L_0x02c8
        L_0x0210:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "hamburger"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0226
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r9 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r0.setClass(r8, r9)
            java.lang.String r9 = "open_hamburger"
            r0.putExtra(r9, r2)
            goto L_0x02c8
        L_0x0226:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "paytmmore"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0255
            java.lang.Class<com.paytmmall.clpartifact.view.activity.SFBrowseCategoryActivity> r1 = com.paytmmall.clpartifact.view.activity.SFBrowseCategoryActivity.class
            r0.setClass(r8, r1)
            java.lang.String r1 = "url"
            java.lang.String r2 = "category"
            android.net.Uri r3 = r9.f50289g
            if (r3 == 0) goto L_0x0247
            java.lang.String r3 = r3.getQueryParameter(r1)
            if (r3 == 0) goto L_0x0247
            r0.putExtra(r1, r3)
        L_0x0247:
            android.net.Uri r9 = r9.f50289g
            if (r9 == 0) goto L_0x02c8
            java.lang.String r9 = r9.getQueryParameter(r2)
            if (r9 == 0) goto L_0x02c8
            r0.putExtra(r2, r9)
            goto L_0x02c8
        L_0x0255:
            java.lang.String r1 = r9.f50284b
            java.lang.String r4 = "pay-scanqr"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0288
            net.one97.paytm.p2mNewDesign.models.b r9 = net.one97.paytm.p2mNewDesign.models.b.c()
            java.lang.String r0 = "Scan"
            r9.a(r0)
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            android.content.Intent r0 = r9.c((android.content.Context) r8)
            java.lang.String r9 = "HomeHelper.getModuleInte…getPaySendIntent(context)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            java.lang.String r9 = "scan_only"
            r0.putExtra(r9, r2)
            java.lang.String r9 = "TRIGGER"
            java.lang.String r1 = "MIDDLE_SCAN"
            android.content.Intent r9 = r0.putExtra(r9, r1)
            java.lang.String r1 = "intent.putExtra(\"TRIGGER\", \"MIDDLE_SCAN\")"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            goto L_0x02c8
        L_0x0288:
            java.lang.String r1 = r9.f50284b
            java.lang.String r2 = "sflanding"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 == 0) goto L_0x02a9
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.SFDeeplinkActivity> r1 = net.one97.paytm.landingpage.activity.SFDeeplinkActivity.class
            r0.<init>(r8, r1)
            java.lang.String r9 = r9.f50283a
            java.lang.String r1 = "sf_deeplink"
            android.content.Intent r9 = r0.putExtra(r1, r9)
            java.lang.String r1 = "intent.putExtra(HomeCons…eepLinkData.mDeepLinkUrl)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            goto L_0x02c8
        L_0x02a9:
            java.lang.String r1 = r9.f50284b
            java.lang.String r2 = "search"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x02c8
            net.one97.paytm.common.b.e r0 = net.one97.paytm.common.b.d.a()
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.Intent r0 = r0.i((android.app.Activity) r1)
            java.lang.String r1 = "HomeHelper.getModuleInte…vity(context as Activity)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r9 = r9.f50283a
            r0.putExtra(r6, r9)
        L_0x02c8:
            boolean r9 = r8 instanceof android.app.Activity     // Catch:{ ActivityNotFoundException -> 0x02d5 }
            if (r9 != 0) goto L_0x02d1
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r9)     // Catch:{ ActivityNotFoundException -> 0x02d5 }
        L_0x02d1:
            r8.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x02d5 }
            return
        L_0x02d5:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            com.paytm.utility.q.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.p.b(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    public static boolean a(Context context, DeepLinkData deepLinkData) {
        String str;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (!TextUtils.isEmpty(deepLinkData.f50284b)) {
            str = deepLinkData.f50284b;
        } else if ("paytmmp://".equals(deepLinkData.f50283a)) {
            Uri parse = Uri.parse(deepLinkData.f50283a);
            k.a((Object) parse, "uri");
            str = parse.getHost();
        } else {
            str = "";
        }
        boolean z = false;
        if (kotlin.m.p.a(str, "joinprime", false) || kotlin.m.p.a(str, "hamburger", false)) {
            return true;
        }
        if (kotlin.m.p.a(str, "external", false) && !TextUtils.isEmpty(deepLinkData.f50283a)) {
            String str2 = deepLinkData.f50283a;
            if (str2 == null) {
                k.a();
            }
            if (kotlin.m.p.a((CharSequence) str2, (CharSequence) "joinprime", false)) {
                return true;
            }
        }
        if (kotlin.m.p.a(str, "external", false) && !TextUtils.isEmpty(deepLinkData.f50283a)) {
            String str3 = deepLinkData.f50283a;
            if (str3 == null) {
                k.a();
            }
            if (kotlin.m.p.a((CharSequence) str3, (CharSequence) "smart_retail_landing", false)) {
                return true;
            }
        }
        if (kotlin.m.p.a(str, "smart_retail_landing", false) || kotlin.m.p.a(str, "homepage_primary", false) || kotlin.m.p.a(str, "edit_cersai", false) || kotlin.m.p.a(str, "home_upi_request", false) || kotlin.m.p.a(str, "paytmmore", false) || kotlin.m.p.a(str, "pay-scanqr", false) || kotlin.m.p.a(str, "automatic_payment", false) || kotlin.m.p.a(str, "payment_limit", false) || kotlin.m.p.a(str, "screen_recording", false) || kotlin.m.p.a(str, "security_shield", false) || kotlin.m.p.a(str, "saved_card", false) || kotlin.m.p.a(str, "paytm_assist", false) || kotlin.m.p.a(str, "remote_desktop", false) || kotlin.m.p.a(str, "debug_setting", false)) {
            return true;
        }
        if (("paytmupdate".equals(str) && "chat".equals(deepLinkData.f50288f)) || "sflanding".equals(str) || "search".equals(str)) {
            return true;
        }
        if (!kotlin.m.p.a(str, CLPConstants.CONFIG_KEY_MY_ORDERS, false)) {
            return false;
        }
        if (!TextUtils.isEmpty(d.b().a("myoder_h5page_url"))) {
            d.b().a(context, d.b().a("myoder_h5page_url"));
            return true;
        } else if (!TextUtils.isEmpty(t.b(context))) {
            c.a();
            a.a(context, c.ar());
            return true;
        } else {
            Intent intent = new Intent(context, AJRAuthActivity.class);
            Bundle bundle = deepLinkData.f50290h;
            if (bundle != null) {
                z = bundle.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
            }
            intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z);
            intent.putExtra("resultant activity", net.one97.paytm.marketplace.a.f().getName());
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        }
    }
}
