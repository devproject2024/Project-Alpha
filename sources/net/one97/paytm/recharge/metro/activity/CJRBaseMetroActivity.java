package net.one97.paytm.recharge.metro.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.youtube.player.c;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.am;

public class CJRBaseMetroActivity extends CJRRechargeBaseActivity implements am {

    /* renamed from: a  reason: collision with root package name */
    private c f63263a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f63264b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f63265c;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f63266f;

    public View a(int i2) {
        if (this.f63265c == null) {
            this.f63265c = new HashMap();
        }
        View view = (View) this.f63265c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63265c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
    }

    public final void n() {
    }

    public final FrameLayout c() {
        FrameLayout frameLayout = this.f63266f;
        if (frameLayout == null) {
            k.a("mFrameLayout");
        }
        return frameLayout;
    }

    public final void a(c cVar, boolean z) {
        k.c(cVar, "player");
        this.f63263a = cVar;
        this.f63264b = z;
    }

    public void onBackPressed() {
        c cVar;
        if (!this.f63264b || (cVar = this.f63263a) == null) {
            super.onBackPressed();
        } else if (cVar != null) {
            cVar.a(false);
        }
    }

    public void onCreate(Bundle bundle) {
        setTheme(R.style.WhiteStatusBarTheme);
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_metro);
        setSupportActionBar((Toolbar) findViewById(R.id.common_toolbar));
        this.p = getSupportActionBar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.a((CharSequence) "");
        }
        p();
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.e(R.drawable.back_arrow_re);
        }
        View findViewById = findViewById(R.id.container);
        k.a((Object) findViewById, "findViewById(R.id.container)");
        this.f63266f = (FrameLayout) findViewById;
    }

    public void setTitle(int i2) {
        ((TextView) findViewById(R.id.title)).setText(i2);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        k.c(menu, "menu");
        return super.onPrepareOptionsMenu(menu);
    }
}
