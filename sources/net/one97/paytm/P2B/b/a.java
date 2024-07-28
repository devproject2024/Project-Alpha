package net.one97.paytm.p2b.b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.listener.b;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.m;
import net.one97.paytm.p2b.view.c.c;

public interface a {
    int a(String str, int i2);

    CJRError a(Context context, NetworkCustomError networkCustomError);

    Boolean a(Context context, Exception exc);

    String a();

    String a(Context context);

    String a(String str);

    String a(String str, String str2);

    String a(CJRPGTokenList cJRPGTokenList);

    void a(int i2, int i3, Intent intent);

    void a(Activity activity);

    void a(Activity activity, Bundle bundle, m mVar);

    void a(Activity activity, b bVar);

    void a(Activity activity, String str, boolean z);

    void a(Activity activity, b bVar);

    void a(Context context, NetworkCustomError networkCustomError, String str);

    void a(Context context, String str);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void a(IStaticWidget iStaticWidget, Context context, String str, String str2);

    void a(String str, String str2, String str3, String str4, Context context);

    void a(String str, Map<String, ? extends Object> map, Context context);

    void a(c cVar, e eVar);

    boolean a(String str, boolean z);

    Intent b(Context context);

    String b();

    String b(Context context, String str);

    void b(Activity activity);

    void b(String str, String str2);

    Intent c(Context context);

    CJRError c(Context context, String str);

    String c();

    void c(Activity activity);

    String d();

    String d(Context context);

    boolean d(Activity activity);

    ContextWrapper e(Context context);

    String e();

    Intent f(Context context);

    String f();

    String g();

    String h();

    String i();

    void j();

    String k();

    boolean l();

    int m();

    String n();

    void o();

    String p();

    void q();
}
