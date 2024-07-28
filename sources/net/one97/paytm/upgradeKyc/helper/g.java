package net.one97.paytm.upgradeKyc.helper;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.utils.l;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66031a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static g f66032b;

    public final String c() {
        return "1k9fbjvjknqhxoikaesrvdi6vanz05n8hd3zzzomeku37snlwpfvmwg3nrpb96fav8x8ylsfrthkc3g121td3mcoemirju47k17nwz19y6inw4jh77avjl9s44r96w8obv3x8j20aikyl9w35xsk0ji7ru345djgyiznx7owxgdox6mt9i1l3oj2xa9jd15r5ironfnwsahomu8vs0lfb2mx6i7d31ep5gmuyvuklea7sh1oz0h0tew323c0p2xwfkfoj6n0y8y82zha9cw6wyc15o44vhyf8dgv8iynh1jd6o55kwg8c0d76kon953miztjg619zcprxovkl2b5wlwkeh8i8c3bt06egtjiv4hms72snrwuovaafpbxst3izw9wscf6fpt1hqqb3vgq0934blwdbclhb7h20omvlm91awdlcylmychylg3xauk4a3x4o8pbyddlwqs54q9nk17m16emj6i1kzv6fxygdke829wxwhq9dpo0hcb378tzs5lq0eus7w4scsu1g7qhtlhmybiz8fkfne6721ncry4s05qtmetmabet904a42o55ksoufeofym418ke3wtdz32gdt691upgp4j4ufe0wmgdczlue4ml2l4yl52wt54econ40fun2ynlmocks1wrq5vzg00ewm5btvmhmosmd6fm0fbvxerhhuxc66lzqe7ag4xutzu6fae8yg6czxcsfptxas01xiyfevdeq20h5bii4en98a76ifjqu1wdnqdhcsvxd64d65l4lgadyktsm66ij94orc4yemlr9n8kle0f41meezetawkkjdx5eoki4qeurw7tdvkoeqpwghdt";
    }

    public final void b(Context context) {
        k.c(context, "ctx");
        h.a aVar = h.f50349a;
        h.a.a(context, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MiLCJzcGFyYW1zIjp7ImNhblB1bGxEb3duIjpmYWxzZSwicHVsbFJlZnJlc2giOmZhbHNlLCJzaG93VGl0bGVCYXIiOmZhbHNlfX0=&url=https://paytm.com", (Bundle) null);
    }

    public final String e() {
        String name = AJRMainActivity.class.getName();
        k.a((Object) name, "AJRMainActivity::class.java.name");
        return name;
    }

    public final void a(Activity activity, LinearLayout linearLayout) {
        k.c(activity, "activity");
        k.c(linearLayout, "container");
        l.a(linearLayout);
    }

    public final String d() {
        String name = AJREmbedWebView.class.getName();
        k.a((Object) name, "AJREmbedWebView ::class.java.name");
        return name;
    }

    public final void a(String str, HashMap<String, Object> hashMap, Context context) {
        k.c(str, "eventName");
        k.c(hashMap, "eventMap");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, context);
    }

    public final Context a() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final void a(Activity activity) {
        k.c(activity, "activity");
        Intent intent = new Intent(activity, AJRMainActivity.class);
        intent.setFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public final String b() {
        String name = AJRMainActivity.class.getName();
        k.a((Object) name, "AJRMainActivity::class.java.name");
        return name;
    }

    public final ContextWrapper a(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final boolean a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        h.a aVar = h.f50349a;
        return h.a.a(context, str, (Bundle) null);
    }

    public final void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        k.c(context, "context");
        k.c(str, "category");
        k.c(str2, "action");
        k.c(arrayList, "labels");
        k.c(str3, "value");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str5, "verticalId");
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public final void a(String str, String str2, Context context) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "vertical");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void a(Context context, String str, String str2, HashMap<String, Object> hashMap, String str3, String str4, String str5, boolean z) {
        k.c(context, "context");
        k.c(str, "category");
        k.c(str2, "action");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str4, "verticalId");
        k.c(str5, "analytics");
        net.one97.paytm.j.a.a(context, str, str2, hashMap, str3, str4, str5, z);
    }

    public final void a(String str, String str2, Context context, String str3) {
        k.c(str3, "sendto");
        net.one97.paytm.j.a.a(str, str2, context, str3);
    }

    public final String a(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, (String) null);
    }

    public final boolean a(String str, boolean z) {
        k.c(str, "key");
        c.a();
        return c.a(str, z);
    }

    public final int b(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, 0);
    }

    public final void b(Activity activity) {
        k.c(activity, "activity");
        Intent intent = new Intent(activity, AJRAuthActivity.class);
        intent.putExtra("authError", true);
        intent.setFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a() {
            if (g.f66032b == null) {
                g.f66032b = new g();
                e.a aVar = e.f66028b;
                g f2 = g.f66032b;
                if (f2 == null) {
                    k.a();
                }
                e.a.a(f2);
            }
        }
    }
}
