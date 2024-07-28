package com.travel.flight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.travel.g.b;
import com.travel.utils.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;

public interface c {
    boolean A();

    String B();

    String C();

    String D();

    String E();

    String F();

    String G();

    String H();

    String I();

    int J();

    String K();

    String L();

    String M();

    String N();

    List<String> O();

    String P();

    String Q();

    String R();

    String S();

    String T();

    String U();

    String V();

    String W();

    String X();

    String Y();

    String Z();

    Context a();

    Intent a(Activity activity, m mVar, Locale locale, String str, long j, String str2, String str3, String str4);

    Intent a(Activity activity, Locale locale, String str, long j, String str2, String str3);

    Intent a(Activity activity, Locale locale, String str, long j, String str2, String str3, String str4, String str5);

    Fragment a(b bVar);

    Fragment a(WeakReference<View> weakReference);

    CJRError a(Context context, NetworkCustomError networkCustomError);

    String a(Context context);

    String a(String str);

    String a(String str, String str2);

    TreeMap<String, String> a(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8);

    void a(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Context context, Bundle bundle, net.one97.paytm.m mVar);

    void a(Context context, String str);

    void a(Context context, String str, String str2);

    void a(Fragment fragment);

    void a(a.c cVar, Activity activity, com.paytm.network.listener.b bVar);

    <T> void a(T t);

    void a(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, String str3);

    void a(String str, Context context, j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData);

    void a(String str, Context context, String str2);

    void a(String str, String str2, String str3, String str4, Map<String, Object> map);

    void a(String str, Map<String, Object> map, Context context);

    void a(List<TreeMap<String, String>> list, Context context);

    void a(CJRRechargePayment cJRRechargePayment, Intent intent);

    String aa();

    boolean ab();

    String ac();

    String b();

    void b(Context context, Intent intent);

    void b(Fragment fragment);

    boolean b(Context context);

    Intent c(Context context);

    String c();

    void c(Context context, Intent intent);

    Context d(Context context);

    String d();

    void d(Context context, Intent intent);

    String e();

    String e(Context context);

    void e(Context context, Intent intent);

    String f();

    void f(Context context, Intent intent);

    String g();

    void g(Context context, Intent intent);

    String h();

    void h(Context context, Intent intent);

    String i();

    String j();

    String k();

    String l();

    String m();

    String n();

    String o();

    String p();

    String q();

    String r();

    String s();

    String t();

    String u();

    String v();

    boolean w();

    String x();

    String y();

    boolean z();
}
