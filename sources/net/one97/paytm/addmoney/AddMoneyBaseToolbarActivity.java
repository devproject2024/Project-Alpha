package net.one97.paytm.addmoney;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.helper.a;

public abstract class AddMoneyBaseToolbarActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static int f48004a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f48005b;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f48006c;

    public abstract int a();

    public abstract int b();

    public void attachBaseContext(Context context) {
        super.attachBaseContext(a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.uam_activity_base_toolbar);
        if (b() != f48004a) {
            setTheme(R.style.JarvisAppThemeNoActionBar);
            View inflate = getLayoutInflater().inflate(b(), (ViewGroup) null);
            ((ViewGroup) findViewById(R.id.toolbarLayout)).addView(inflate);
            this.f48006c = (Toolbar) inflate.findViewById(R.id.toolbar);
            setSupportActionBar(this.f48006c);
            getSupportActionBar().e(R.drawable.back_arrow);
            getSupportActionBar().a(true);
            getSupportActionBar().b(true);
            getSupportActionBar().c(false);
            getSupportActionBar().a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        } else {
            setTheme(R.style.JarvisAppThemeNoActionBar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().f();
            }
        }
        this.f48005b = (FrameLayout) findViewById(R.id.container_framelayout);
        if (a() != 0) {
            this.f48005b.addView(getLayoutInflater().inflate(a(), (ViewGroup) null));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public static void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (lottieAnimationView != null) {
            try {
                net.one97.paytm.common.widgets.a.b(lottieAnimationView);
                if (z) {
                    net.one97.paytm.common.widgets.a.a(lottieAnimationView);
                } else {
                    net.one97.paytm.common.widgets.a.b(lottieAnimationView);
                }
            } catch (Exception unused) {
            }
        }
    }
}
