package net.one97.paytm.acceptPayment.b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Map;
import org.json.JSONObject;

public interface a {
    Context a();

    ContextWrapper a(Context context);

    String a(String str);

    void a(Activity activity);

    void a(Activity activity, String str, Bundle bundle);

    void a(Activity activity, JSONObject jSONObject);

    void a(Context context, String str);

    void a(com.paytm.network.a aVar, Context context);

    void a(String str, String str2);

    void a(String str, Map<String, Object> map, Context context);

    boolean a(String str, boolean z);

    int b(String str);

    Class<? extends AppCompatActivity> b();

    String b(Context context);

    long c(String str);
}
