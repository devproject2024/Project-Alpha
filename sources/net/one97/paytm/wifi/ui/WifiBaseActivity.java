package net.one97.paytm.wifi.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.wifi.R;

public abstract class WifiBaseActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f21206b;

    public abstract int a();

    public abstract int b();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wifi_base);
        if (b() != -1) {
            setTheme(R.style.JarvisAppThemeNoActionBar);
            View inflate = getLayoutInflater().inflate(b(), (ViewGroup) null);
            ((ViewGroup) findViewById(R.id.toolbarLayout)).addView(inflate);
            setSupportActionBar((Toolbar) inflate.findViewById(R.id.toolbar));
            getSupportActionBar().e(R.drawable.wifi_back_arrow);
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
        this.f21206b = (FrameLayout) findViewById(R.id.container_framelayout);
        if (a() != 0) {
            this.f21206b.addView(getLayoutInflater().inflate(a(), (ViewGroup) null));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            onBackPressed();
            return true;
        } catch (IllegalStateException unused) {
            return true;
        }
    }
}
