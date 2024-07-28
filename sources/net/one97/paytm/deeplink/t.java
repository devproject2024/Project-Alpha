package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRUpdateMessage;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.nativesdk.orflow.Utility;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f50368a = new t();

    private t() {
    }

    public static void a(Context context) {
        k.c(context, "context");
        Intent intent = new Intent(context, AJRUpdateMessage.class);
        intent.setFlags(268435456);
        context.startActivity(new Intent(intent));
    }

    public static boolean a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        if (str != null) {
            String str2 = null;
            switch (str.hashCode()) {
                case -2037733451:
                    if (str.equals("order_summary")) {
                        return true;
                    }
                    break;
                case -1820761141:
                    if (str.equals("external")) {
                        i iVar = i.f50350a;
                        i.c(context, deepLinkData);
                        if (TextUtils.isEmpty(deepLinkData.f50286d) && TextUtils.isEmpty(deepLinkData.f50285c)) {
                            return false;
                        }
                        q.d("External tpe " + deepLinkData.f50287e + "   : " + deepLinkData.f50286d);
                        try {
                            if (p.a(deepLinkData.f50287e, "external", false)) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(deepLinkData.f50286d));
                                intent.addFlags(268435456);
                                context.startActivity(intent);
                            } else {
                                h.a aVar = h.f50349a;
                                h.a.a(context, deepLinkData.f50285c, (Bundle) null);
                            }
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                        return true;
                    }
                    break;
                case -1498372469:
                    if (str.equals("payment_reminder") || str.equals("payment_reminder")) {
                        return true;
                    }
                    break;
                case -1271338501:
                    if (str.equals("flyout")) {
                        return true;
                    }
                    break;
                case -1236338706:
                    if (str.equals("add_card")) {
                        return true;
                    }
                    break;
                case -1094525428:
                    if (str.equals("signin_profile")) {
                        return true;
                    }
                    break;
                case -1077105972:
                    if (str.equals("fastpay")) {
                        return true;
                    }
                    break;
                case -763938680:
                    if (str.equals("embed-mall")) {
                        return true;
                    }
                    break;
                case -497491755:
                    if (str.equals("payment_bank")) {
                        return true;
                    }
                    break;
                case -486141186:
                    if (str.equals("ae_embed")) {
                        return true;
                    }
                    break;
                case -309425751:
                    if (str.equals("profile")) {
                        return true;
                    }
                    break;
                case -155866469:
                    if (str.equals("luckylifafa")) {
                        return true;
                    }
                    break;
                case 3343892:
                    if (str.equals(Utility.VERTICAL_NAME_MALL)) {
                        return true;
                    }
                    break;
                case 3417674:
                    if (str.equals("open")) {
                        return true;
                    }
                    break;
                case 96620249:
                    if (str.equals(CLPConstants.URL_TYPE_EMBED)) {
                        i iVar2 = i.f50350a;
                        i.c(context, deepLinkData);
                        if (TextUtils.isEmpty(deepLinkData.f50286d)) {
                            return false;
                        }
                        Intent intent2 = new Intent(context, AJREmbedWebView.class);
                        intent2.setFlags(268435456);
                        try {
                            String str3 = deepLinkData.f50286d;
                            if (str3 != null) {
                                Uri parse = Uri.parse(str3);
                                k.a((Object) parse, "Uri.parse(this)");
                                if (parse != null) {
                                    str2 = parse.getQueryParameter("title");
                                }
                            }
                            intent2.putExtra("title", str2);
                        } catch (Exception unused) {
                        }
                        intent2.putExtra("url", deepLinkData.f50286d);
                        context.startActivity(new Intent(intent2));
                        return true;
                    }
                    break;
                case 489368233:
                    if (str.equals("delivery_address")) {
                        return true;
                    }
                    break;
                case 505665287:
                    if (str.equals("change_language")) {
                        return true;
                    }
                    break;
                case 570410685:
                    if (str.equals("internal")) {
                        return true;
                    }
                    break;
                case 576675254:
                    if (str.equals("active_subscription")) {
                        return true;
                    }
                    break;
                case 673186429:
                    if (str.equals("myprofile")) {
                        return true;
                    }
                    break;
                case 1216389502:
                    if (str.equals("passcode")) {
                        return true;
                    }
                    break;
                case 1266450626:
                    if (str.equals("sellerstore")) {
                        return true;
                    }
                    break;
                case 1316207773:
                    if (str.equals("edc_receipt")) {
                        return true;
                    }
                    break;
                case 1392888250:
                    if (str.equals("brandstore")) {
                        return true;
                    }
                    break;
                case 1536803272:
                    if (str.equals("saved_card")) {
                        return true;
                    }
                    break;
                case 1874165940:
                    if (str.equals("payment_preference")) {
                        return true;
                    }
                    break;
                case 2026502613:
                    if (str.equals("merchant-loan")) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r11, net.one97.paytm.deeplink.DeepLinkData r12) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = r12.f50284b
            r1 = 0
            java.lang.String r2 = "external"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 != 0) goto L_0x0399
            java.lang.String r0 = r12.f50284b
            java.lang.String r2 = "embed"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 != 0) goto L_0x0399
            java.lang.String r0 = r12.f50284b
            java.lang.String r3 = "weexoffer"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
            if (r0 == 0) goto L_0x002c
            goto L_0x0399
        L_0x002c:
            java.lang.String r0 = r12.f50283a
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = net.one97.paytm.utils.c.a((android.content.Context) r11, (java.lang.String) r0)
            java.lang.String r3 = r12.f50284b
            java.lang.String r4 = "internal"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r1)
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = r12.f50288f
            java.lang.String r5 = "force_app_update"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r1)
            if (r3 == 0) goto L_0x005b
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRUpdateMessage> r0 = net.one97.paytm.AJRUpdateMessage.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x005b:
            java.lang.String r3 = r12.f50284b
            r5 = 1
            java.lang.String r6 = "change_language"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r5)
            if (r3 == 0) goto L_0x006c
            java.lang.String r12 = "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MvcHJlZmVycmVkLWxhbmd1YWdlIiwic3BhcmFtcyI6eyJjYW5QdWxsRG93biI6ZmFsc2UsInB1bGxSZWZyZXNoIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://paytm.com"
            net.one97.paytm.payments.d.a.a((android.content.Context) r11, (java.lang.String) r12)
            return
        L_0x006c:
            java.lang.String r3 = r12.f50284b
            java.lang.String r6 = "payment_reminder"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r5)
            if (r3 == 0) goto L_0x0086
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.quickpay.activity.QuickViewAll> r0 = net.one97.paytm.quickpay.activity.QuickViewAll.class
            r12.<init>(r11, r0)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x0086:
            java.lang.String r3 = r12.f50284b
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r1)
            if (r2 != 0) goto L_0x0399
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "embed-mall"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x00ab
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRWebViewActivity> r0 = net.one97.paytm.AJRWebViewActivity.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x00ab:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "order_summary"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x00d4
            java.lang.String r12 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0399
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJROrderSummaryActivity> r0 = net.one97.paytm.AJROrderSummaryActivity.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x00d4:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "saved_card"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 != 0) goto L_0x037b
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "add_card"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x00ea
            goto L_0x037b
        L_0x00ea:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "active_subscription"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x011b
            java.lang.String r12 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0399
            net.one97.paytm.p.a$a r12 = net.one97.paytm.p.a.f12661b
            r12 = r11
            android.app.Activity r12 = (android.app.Activity) r12
            net.one97.paytm.p.a r12 = net.one97.paytm.p.a.C0166a.a(r12)
            if (r12 == 0) goto L_0x0399
            android.content.Intent r12 = r12.a()
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x011b:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "passcode"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x0142
            java.lang.String r12 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0399
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRSecuritySettings> r0 = net.one97.paytm.AJRSecuritySettings.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            r12.putExtra(r3, r5)
            r11.startActivity(r12)
            return
        L_0x0142:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "myprofile"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x0152
            java.lang.String r12 = "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MiLCJzcGFyYW1zIjp7ImNhblB1bGxEb3duIjpmYWxzZSwicHVsbFJlZnJlc2giOmZhbHNlLCJzaG93VGl0bGVCYXIiOmZhbHNlfX0=&url=https://paytm.com"
            net.one97.paytm.payments.d.a.a((android.content.Context) r11, (java.lang.String) r12)
            return
        L_0x0152:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "profile"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x017b
            java.lang.String r12 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0399
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRProfileActivity> r0 = net.one97.paytm.AJRProfileActivity.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x017b:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "mall"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x01a2
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRWebViewActivity> r0 = net.one97.paytm.AJRWebViewActivity.class
            r12.<init>(r11, r0)
            r11.startActivity(r12)
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r0 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            java.lang.String r0 = "resultant fragment type"
            r12.putExtra(r0, r3)
            r11.startActivity(r12)
            return
        L_0x01a2:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "ae_embed"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x01b7
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJREmbedWebView> r0 = net.one97.paytm.AJREmbedWebView.class
            r12.<init>(r11, r0)
            r11.startActivity(r12)
            return
        L_0x01b7:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "signin_profile"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r5)
            r3 = 0
            java.lang.String r7 = "show_full_screen"
            if (r2 == 0) goto L_0x01fb
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r4 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r2.<init>(r11, r4)
            android.os.Bundle r12 = r12.f50290h
            if (r12 == 0) goto L_0x01d5
            boolean r1 = r12.getBoolean(r7)
        L_0x01d5:
            r2.putExtra(r7, r1)
            java.lang.String r12 = "redirectVertical"
            java.lang.String r1 = "login_signup"
            r2.putExtra(r12, r1)
            if (r0 == 0) goto L_0x01f1
            java.lang.String r12 = r0.getUtmSource()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x01f1
            java.lang.String r3 = r0.getUtmSource()
        L_0x01f1:
            java.lang.String r12 = "utmsource"
            r2.putExtra(r12, r3)
            r11.startActivity(r2)
            return
        L_0x01fb:
            java.lang.String r2 = r12.f50284b
            java.lang.String r8 = "payment_bank"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r5)
            java.lang.String r8 = "resultant activity_bundle"
            java.lang.String r9 = "extra_home_data"
            if (r2 == 0) goto L_0x022d
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r1 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r12.<init>(r11, r1)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.io.Serializable r0 = (java.io.Serializable) r0
            r1.putSerializable(r9, r0)
            java.lang.String r0 = "origin"
            java.lang.String r2 = "deeplinking"
            r1.putString(r0, r2)
            java.lang.String r0 = "is_deep_linking_data"
            r12.putExtra(r0, r5)
            r12.putExtra(r8, r1)
            r11.startActivity(r12)
            return
        L_0x022d:
            java.lang.String r2 = r12.f50284b
            java.lang.String r10 = "edc_receipt"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r10, (boolean) r5)
            if (r2 == 0) goto L_0x024e
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity> r1 = net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity.class
            r0.<init>(r11, r1)
            java.lang.String r12 = r12.f50283a
            java.lang.String r1 = "EXTRA_DEEP_LINK_DATA"
            r0.putExtra(r1, r12)
            java.lang.String r12 = "EXTRA_DEEP_LINK_FLAG"
            r0.putExtra(r12, r5)
            r11.startActivity(r0)
            return
        L_0x024e:
            java.lang.String r2 = r12.f50284b
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r5)
            if (r2 == 0) goto L_0x0261
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.quickpay.activity.PaymentReminderCreationActivity> r0 = net.one97.paytm.quickpay.activity.PaymentReminderCreationActivity.class
            r12.<init>(r11, r0)
            r11.startActivity(r12)
            return
        L_0x0261:
            java.lang.String r2 = r12.f50284b
            java.lang.String r6 = "fastpay"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r5)
            if (r2 == 0) goto L_0x0284
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.quickpay.activity.QuickPayDeeplinkActivity> r1 = net.one97.paytm.quickpay.activity.QuickPayDeeplinkActivity.class
            r12.<init>(r11, r1)
            if (r0 == 0) goto L_0x0278
            java.lang.String r3 = r0.getSsId()
        L_0x0278:
            java.lang.String r0 = "id"
            r12.putExtra(r0, r3)
            r12.setFlags(r4)
            r11.startActivity(r12)
            return
        L_0x0284:
            java.lang.String r2 = r12.f50284b
            java.lang.String r6 = "flyout"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r5)
            if (r2 == 0) goto L_0x02cf
            if (r0 == 0) goto L_0x02a5
            java.lang.String r12 = r0.getDeeplink()
            if (r12 == 0) goto L_0x02a5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String r0 = "targetPage=home"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r12 = kotlin.m.p.a((java.lang.CharSequence) r12, (java.lang.CharSequence) r0, false)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r12)
        L_0x02a5:
            if (r3 != 0) goto L_0x02aa
            kotlin.g.b.k.a()
        L_0x02aa:
            boolean r12 = r3.booleanValue()
            if (r12 == 0) goto L_0x02c2
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r0 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r12.<init>(r11, r0)
            java.lang.String r0 = "ACTION"
            java.lang.String r1 = "OPEN_DRAWER"
            r12.putExtra(r0, r1)
            r11.startActivity(r12)
            return
        L_0x02c2:
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class r0 = net.one97.paytm.marketplace.a.e()
            r12.<init>(r11, r0)
            r11.startActivity(r12)
            return
        L_0x02cf:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "merchant-loan"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 != 0) goto L_0x034f
            android.net.Uri r2 = r12.f50289g
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "paytmba"
            boolean r2 = kotlin.m.p.b(r2, r3, r1)
            if (r2 == 0) goto L_0x02e8
            goto L_0x034f
        L_0x02e8:
            java.lang.String r2 = r12.f50284b
            java.lang.String r3 = "delivery_address"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == 0) goto L_0x0347
            java.lang.String r2 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "address_from_account"
            if (r2 != 0) goto L_0x0316
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRProfileActivity> r0 = net.one97.paytm.AJRProfileActivity.class
            r12.<init>(r11, r0)
            r12.putExtra(r3, r5)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
            return
        L_0x0316:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r4 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r2.<init>(r11, r4)
            android.os.Bundle r12 = r12.f50290h
            if (r12 == 0) goto L_0x0325
            boolean r1 = r12.getBoolean(r7)
        L_0x0325:
            r2.putExtra(r7, r1)
            java.lang.Class<net.one97.paytm.AJRProfileActivity> r12 = net.one97.paytm.AJRProfileActivity.class
            java.lang.String r12 = r12.getName()
            java.lang.String r1 = "resultant activity"
            r2.putExtra(r1, r12)
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            java.io.Serializable r0 = (java.io.Serializable) r0
            r12.putSerializable(r9, r0)
            r12.putBoolean(r3, r5)
            r2.putExtra(r8, r12)
            r11.startActivity(r2)
            return
        L_0x0347:
            java.lang.String r11 = r12.f50284b
            java.lang.String r12 = "open"
            kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r12, (boolean) r1)
            goto L_0x0399
        L_0x034f:
            android.content.Intent r0 = new android.content.Intent
            android.net.Uri r12 = r12.f50289g
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r12)
            android.content.pm.PackageManager r12 = r11.getPackageManager()
            android.content.ComponentName r12 = r0.resolveActivity(r12)
            if (r12 == 0) goto L_0x0369
            r0.addFlags(r4)
            r11.startActivity(r0)
            return
        L_0x0369:
            android.content.Intent r12 = new android.content.Intent
            java.lang.String r0 = "http://play.google.com/store/apps/details?id=com.paytm.business"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r12.<init>(r1, r0)
            r12.addFlags(r4)
            r11.startActivity(r12)
            return
        L_0x037b:
            java.lang.String r12 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0399
            android.content.Intent r12 = new android.content.Intent
            java.lang.Class<net.one97.paytm.savedPaymentItem.AJRSavedPaymentActivity> r0 = net.one97.paytm.savedPaymentItem.AJRSavedPaymentActivity.class
            r12.<init>(r11, r0)
            r12.setFlags(r4)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r12)
            r11.startActivity(r0)
        L_0x0399:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.t.b(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }
}
