package com.travel.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;

public interface b {
    Intent a(Context context, String str, String str2, String str3, String str4);

    Intent a(String str, Context context, CJRHomePageItem cJRHomePageItem);

    String a(Context context);

    String a(String str);

    String a(String str, String str2);

    String a(CJRHomePageItem cJRHomePageItem);

    List<String> a();

    void a(Activity activity);

    void a(Activity activity, NetworkCustomError networkCustomError);

    void a(Activity activity, Exception exc, boolean z);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Fragment fragment);

    void a(String str, Context context);

    void a(String str, String str2, Context context);

    void a(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap);

    void a(String str, Map<String, Object> map, Context context);

    void a(CJRUrlUtmData cJRUrlUtmData);

    boolean a(Context context, NetworkCustomError networkCustomError, String str);

    boolean a(Context context, String str);

    Fragment b();

    void b(Context context);

    void b(Context context, Intent intent, int i2);

    Context c(Context context);

    String c();

    Class d();

    String e();

    String f();

    boolean g();

    Map<String, Map<String, String>> h();
}
