package net.one97.paytm.recharge.automatic.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.c.c;
import net.one97.paytm.recharge.automatic.c.d;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60256a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static c f60257b = d.a();

    static {
        d dVar = d.f60262c;
    }

    private a() {
    }

    public static ContextWrapper a(Context context) {
        k.c(context, "context");
        return f60257b.a(context);
    }

    public static void a(String str, Bundle bundle, Context context) {
        k.c(context, "context");
        f60257b.a(str, bundle, context);
    }

    public static void a(String str, j jVar) {
        k.c(jVar, "fragmentManager");
        f60257b.a(str, jVar);
    }

    public static String a() {
        return f60257b.b();
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError, int i2) {
        k.c(networkCustomError, "error");
        f60257b.a(activity, networkCustomError, i2);
    }

    public static void a(Activity activity, Fragment fragment, NetworkCustomError networkCustomError, int i2) {
        k.c(fragment, "fragment");
        k.c(networkCustomError, "error");
        f60257b.a(activity, fragment, networkCustomError, i2);
    }

    public static void a(Activity activity, int i2) {
        f60257b.a(activity, i2);
    }

    public static void a(Context context, String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        f60257b.a(context, str);
    }

    public static void a(Context context, String str, CJRHomePageItem cJRHomePageItem) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(cJRHomePageItem, "searchItem");
        f60257b.a(context, str, cJRHomePageItem);
    }

    public static Class<? extends Activity> b() {
        return f60257b.c();
    }

    public static Class<? extends Activity> c() {
        return f60257b.d();
    }

    public static /* synthetic */ void a(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i2) {
        a(context, obj, obj2, (i2 & 8) != 0 ? "" : obj3, (i2 & 16) != 0 ? "" : obj4, (i2 & 32) != 0 ? "recharges_utilities" : obj5, (i2 & 64) != 0 ? "" : obj6);
    }

    public static void a(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        k.c(context, "context");
        k.c(obj, "eventCategory");
        k.c(obj2, "eventAction");
        k.c(obj3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(obj4, "label");
        k.c(obj5, "vertical");
        k.c(obj6, "label2");
        f60257b.a(context, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static void a(Context context, int i2) {
        k.c(context, "context");
        f60257b.a(context, i2);
    }

    public static boolean a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, CJRFrequentOrder cJRFrequentOrder) {
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionItemModel");
        k.c(cJRFrequentOrder, "recent");
        return f60257b.a(cJRAutomaticSubscriptionItemModel, cJRFrequentOrder);
    }

    public static void b(Context context) {
        k.c(context, "context");
        f60257b.b(context);
    }

    public static boolean c(Context context) {
        k.c(context, "context");
        return f60257b.c(context);
    }
}
