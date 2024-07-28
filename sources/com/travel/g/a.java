package com.travel.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.m;

public interface a {
    String A();

    List<String> B();

    String C();

    Context D();

    int E();

    String F();

    String G();

    int H();

    String I();

    String J();

    String K();

    String L();

    List<String> M();

    String N();

    boolean O();

    String P();

    boolean Q();

    String R();

    String S();

    int a(String str, int i2);

    Intent a(Activity activity, String str, String str2, long j, String str3);

    Fragment a(b bVar);

    Fragment a(WeakReference<View> weakReference);

    String a();

    String a(String str, String str2);

    String a(CJRPGTokenList cJRPGTokenList);

    TreeMap<String, String> a(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8);

    void a(Activity activity);

    void a(Activity activity, NetworkCustomError networkCustomError);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Context context, Bundle bundle, m mVar);

    void a(Context context, String str, Double d2);

    void a(Context context, String str, String str2, String str3, String str4);

    void a(Context context, CJRCart cJRCart);

    void a(Fragment fragment);

    void a(a.c cVar, Activity activity, b bVar);

    void a(String str, Context context);

    void a(String str, String str2, Context context);

    void a(String str, String str2, String str3, String str4, Context context);

    void a(String str, Map<String, Object> map, Context context);

    void a(String str, CJRHomePageItem cJRHomePageItem, Context context);

    void a(List<TreeMap<String, String>> list, Context context);

    void a(CJRUrlUtmData cJRUrlUtmData);

    boolean a(Context context);

    boolean a(String str);

    boolean a(String str, boolean z);

    String b();

    String b(Context context);

    String b(String str);

    void b(Context context, Intent intent);

    void b(Fragment fragment);

    void b(String str, Context context);

    void b(String str, String str2, Context context);

    Intent c(Context context);

    String c();

    String c(String str);

    void c(Context context, Intent intent);

    String d(Context context);

    String d(String str);

    void d(Context context, Intent intent);

    boolean d();

    String e();

    String e(String str);

    void e(Context context, Intent intent);

    String f();

    String f(String str);

    String g();

    String h();

    int i();

    int j();

    boolean k();

    String l();

    boolean m();

    String n();

    String o();

    String p();

    boolean q();

    String r();

    String s();

    String t();

    String u();

    String v();

    String w();

    String x();

    String y();

    String z();
}
