package com.travel.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.NetworkCustomError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.m;

public interface a {
    String A();

    String B();

    String C();

    String D();

    String E();

    String F();

    String G();

    boolean H();

    int I();

    String J();

    String K();

    String L();

    String M();

    String N();

    String O();

    String P();

    String Q();

    int R();

    String S();

    String T();

    String U();

    int V();

    String W();

    String X();

    String Y();

    String Z();

    Context a();

    Intent a(Activity activity, Locale locale, Date date, long j, int i2, String str, String str2, String str3);

    Fragment a(WeakReference<View> weakReference);

    String a(String str);

    void a(Activity activity, NetworkCustomError networkCustomError);

    void a(Activity activity, String str);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Context context, Bundle bundle, m mVar);

    void a(Context context, String str);

    void a(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);

    void a(Fragment fragment);

    void a(String str, String str2, Context context);

    void a(String str, Map<String, Object> map, Context context);

    void a(CJRRechargePayment cJRRechargePayment, Intent intent);

    boolean a(Context context);

    boolean a(Context context, Exception exc, String str);

    boolean a(Context context, String str, Bundle bundle);

    String aa();

    String ab();

    String ac();

    String ad();

    String ae();

    String af();

    String ag();

    String ah();

    String ai();

    Intent b(Context context);

    String b();

    String b(String str);

    void b(Context context, Intent intent);

    void b(Fragment fragment);

    Context c(Context context);

    Map<String, Map<String, String>> c();

    void c(Context context, Intent intent);

    String d();

    void d(Context context, Intent intent);

    String e();

    String f();

    String g();

    String h();

    int i();

    List<String> j();

    String k();

    boolean l();

    String m();

    boolean n();

    boolean o();

    String p();

    String q();

    String r();

    String s();

    String t();

    String u();

    String v();

    boolean w();

    boolean x();

    String y();

    String z();
}
