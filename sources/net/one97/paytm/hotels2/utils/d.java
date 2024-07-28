package net.one97.paytm.hotels2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.listener.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.hotels2.a.a;

public interface d {
    Context a();

    Intent a(Context context, String str, String str2, String str3, String str4, String str5, int i2);

    Fragment a(WeakReference<View> weakReference);

    String a(Context context);

    String a(String str);

    String a(CJRPGTokenList cJRPGTokenList);

    void a(Activity activity, b bVar);

    void a(Activity activity, CJRRechargePayment cJRRechargePayment, a aVar);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Context context, String str);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void a(Context context, Map<String, String> map, String str);

    void a(Fragment fragment);

    void a(FragmentActivity fragmentActivity);

    void a(String str, String str2, String str3, String str4, Map<String, Object> map);

    Integer b(String str);

    String b();

    void b(Fragment fragment);

    String c();

    String d();

    String e();
}
