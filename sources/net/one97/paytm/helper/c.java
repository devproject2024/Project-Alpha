package net.one97.paytm.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.utils.b.a;
import net.one97.paytm.wallet.f.h;
import net.one97.paytm.wallet.newdesign.addmoney.c.e;

public interface c {
    Context a(Context context);

    Intent a(FragmentActivity fragmentActivity);

    View a(Context context, j jVar, String str);

    View a(SFWidget sFWidget, Context context, j jVar, String str, String str2, a aVar, String str3);

    IJRPaytmDataModel a(String str);

    String a(int i2);

    String a(String str, String str2);

    String a(CJRPGTokenList cJRPGTokenList);

    void a(Activity activity);

    void a(Activity activity, Intent intent);

    void a(Activity activity, Intent intent, net.one97.paytm.wallet.d.c cVar);

    void a(Activity activity, b bVar);

    void a(Activity activity, String str, Bundle bundle);

    void a(Activity activity, String str, Bundle bundle, Boolean bool, Boolean bool2);

    void a(Activity activity, CJRCart cJRCart);

    void a(Context context, int i2);

    void a(Context context, b bVar);

    void a(Context context, Item item, int i2, String str);

    void a(Context context, Integer num, Integer num2, String str);

    void a(Context context, Integer num, net.one97.paytm.newaddmoney.b.a aVar);

    void a(Context context, String str);

    void a(Context context, String str, Bundle bundle);

    void a(Context context, String str, String str2, String str3);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void a(Context context, CJRRechargePayment cJRRechargePayment, net.one97.paytm.addmoney.togv.b.c cVar);

    void a(Context context, e eVar);

    void a(FragmentActivity fragmentActivity, Bundle bundle);

    void a(FragmentActivity fragmentActivity, String str, h hVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void a(j jVar, int i2);

    void a(Exception exc);

    void a(String str, String str2, Context context);

    void a(String str, String str2, String str3, String str4, Context context);

    void a(String str, Map<String, Object> map, Context context);

    void a(CJRRechargePayment cJRRechargePayment, Intent intent);

    boolean a();

    boolean a(Activity activity, NetworkCustomError networkCustomError);

    boolean a(Context context, NetworkCustomError networkCustomError);

    Intent b(Activity activity);

    Intent b(FragmentActivity fragmentActivity);

    String b();

    void b(Context context, int i2);

    void b(String str);

    void b(String str, String str2, Context context);

    boolean b(Context context);

    Intent c(Activity activity);

    Object c();

    void c(Context context);

    void c(String str);

    Class<? extends Activity> d(String str);

    String d();

    void d(Activity activity);

    void d(Context context);

    Intent e(Activity activity);

    String e();

    void e(Context context);

    void e(String str);

    Intent f(Activity activity);

    String f();

    String f(String str);

    boolean f(Context context);

    int g();

    void g(Activity activity);

    boolean g(Context context);

    boolean g(String str);

    int h(String str);

    void h(Activity activity);

    boolean h();

    boolean h(Context context);

    Intent i(Context context);

    String i();

    String i(String str);

    Context j();

    Intent j(Context context);

    Intent k(Context context);

    void k();

    Intent l(Context context);

    String l();

    String m();

    boolean m(Context context);
}
