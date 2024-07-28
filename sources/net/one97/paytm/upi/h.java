package net.one97.paytm.upi;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.upi.common.CJRReplacementReason;

public interface h {

    public interface a {
        void a();
    }

    int a(String str);

    int a(String str, int i2);

    String a();

    void a(int i2, Context context);

    void a(Activity activity);

    void a(Activity activity, Uri uri);

    void a(Activity activity, NetworkCustomError networkCustomError, String str);

    void a(Activity activity, Object obj, CJRReplacementReason cJRReplacementReason);

    void a(Activity activity, String str);

    void a(Context context);

    void a(Context context, Bundle bundle);

    void a(Context context, String str);

    void a(View view, RecyclerView recyclerView, String str, FragmentActivity fragmentActivity);

    void a(LinearLayout linearLayout);

    void a(Fragment fragment, Bundle bundle);

    void a(String str, String str2);

    void a(String str, String str2, Throwable th);

    void a(a aVar);

    boolean a(String str, boolean z);

    String b();

    String b(String str, String str2);

    void b(Activity activity);

    void b(Context context);

    void b(Context context, Bundle bundle);

    Context c();

    String c(Context context);

    String c(String str, String str2);

    void c(Activity activity);

    ContextWrapper d(Context context);

    Fragment d();

    void d(Activity activity);

    Class<?> e();

    void e(Context context);

    void f(Context context);

    int g(Context context);
}
