package net.one97.paytm.vipcashback.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.vipcashback.f.d;

public abstract class AJRCashBackBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f20643a;

    /* renamed from: b  reason: collision with root package name */
    final String f20644b = getClass().getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    Boolean f20645c;

    public View a(int i2) {
        if (this.f20643a == null) {
            this.f20643a = new HashMap();
        }
        View view = (View) this.f20643a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20643a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() != null) {
            Window window = getWindow();
            if (window == null) {
                k.a();
            }
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().clearFlags(67108864);
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(b.c(this, R.color.color_002d90));
            }
        }
        Resources resources = getResources();
        k.a((Object) resources, "resources");
        Configuration configuration = resources.getConfiguration();
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        k.a((Object) windowManager, "windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        baseContext.getResources().updateConfiguration(configuration, displayMetrics);
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        d.a aVar = d.f20859a;
        d.a.a(networkCustomError, (FragmentActivity) this, this.f20645c, 8);
    }

    public final void a(a aVar) {
        k.c(aVar, "request");
        d.a aVar2 = d.f20859a;
        d.a.a((Context) this, aVar, true);
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.vipcashback.c.a.b().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }
}
