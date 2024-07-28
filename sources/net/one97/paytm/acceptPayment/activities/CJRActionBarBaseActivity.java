package net.one97.paytm.acceptPayment.activities;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.a;
import androidx.drawerlayout.widget.DrawerLayout;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.utility.d;

public abstract class CJRActionBarBaseActivity extends PaytmActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    private TextView f52024a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f52025b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBar f52026c;

    /* renamed from: d  reason: collision with root package name */
    protected DrawerLayout f52027d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52028e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f52029f = CJRActionBarBaseActivity.class.getName();

    /* renamed from: g  reason: collision with root package name */
    private a f52030g;

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.action_bar_layout);
        this.f52027d = (DrawerLayout) findViewById(R.id.drawer_layout);
        AnonymousClass1 r0 = new a(this, this.f52027d, R.string.ap_open_drawer, R.string.ap_close_drawer) {
            public final void onDrawerClosed(View view) {
                d.f49594a = false;
                CJRActionBarBaseActivity.this.supportInvalidateOptionsMenu();
                if (view instanceof LinearLayout) {
                    try {
                        CJRActionBarBaseActivity.this.f52027d.setDrawerLockMode(0, 8388613);
                        CJRActionBarBaseActivity.this.f52027d.setDrawerLockMode(0, 8388611);
                    } catch (Exception unused) {
                    }
                }
            }

            public final void onDrawerOpened(View view) {
                ((InputMethodManager) this.getSystemService("input_method")).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
                CJRActionBarBaseActivity.this.supportInvalidateOptionsMenu();
                if ((view instanceof LinearLayout) && CJRActionBarBaseActivity.this.f52027d.e(5)) {
                    CJRActionBarBaseActivity.this.f52027d.setDrawerLockMode(1, 8388611);
                    CJRActionBarBaseActivity.this.f52027d.setDrawerLockMode(2, 8388613);
                }
            }
        };
        this.f52030g = r0;
        DrawerLayout drawerLayout = this.f52027d;
        if (drawerLayout != null) {
            drawerLayout.setDrawerListener(r0);
        }
        ActionBar supportActionBar = getSupportActionBar();
        this.f52026c = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.b(true);
            this.f52026c.c(false);
            this.f52026c.a(true);
            int i2 = R.drawable.action_bar_logo_with_bg;
            this.f52028e = true;
            this.f52026c.b();
            this.f52026c.a(R.layout.action_bar_title);
            this.f52026c.a(2.0f);
            TextView textView = (TextView) findViewById(R.id.text1);
            this.f52024a = textView;
            textView.setInputType(524288);
            this.f52024a.setEllipsize(TextUtils.TruncateAt.END);
            this.f52024a.setTextSize(19.0f);
            this.f52024a.setMaxLines(1);
            this.f52025b = (TextView) findViewById(R.id.text2);
            com.paytm.utility.b.d(this.f52024a);
            this.f52026c.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
        net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a(getClass().getSimpleName(), "Activity Created");
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && !v.a(networkCustomError.getFullUrl())) {
            net.one97.paytm.acceptPayment.b.b.a();
            String a2 = net.one97.paytm.acceptPayment.b.b.a("logoutIfRequired");
            if (!TextUtils.isEmpty(a2) && networkCustomError.getFullUrl().contains(a2)) {
                isFinishing();
            }
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a(context));
    }
}
