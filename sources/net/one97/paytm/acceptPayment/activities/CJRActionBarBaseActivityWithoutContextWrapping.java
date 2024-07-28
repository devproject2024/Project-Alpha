package net.one97.paytm.acceptPayment.activities;

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

public abstract class CJRActionBarBaseActivityWithoutContextWrapping extends PaytmActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    public ActionBar f52033a;

    /* renamed from: b  reason: collision with root package name */
    protected DrawerLayout f52034b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f52035c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f52036d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52037e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f52038f = CJRActionBarBaseActivity.class.getName();

    /* renamed from: g  reason: collision with root package name */
    private a f52039g;

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.action_bar_layout);
        this.f52034b = (DrawerLayout) findViewById(R.id.drawer_layout);
        AnonymousClass1 r0 = new a(this, this.f52034b, R.string.ap_open_drawer, R.string.ap_close_drawer) {
            public final void onDrawerClosed(View view) {
                d.f49594a = false;
                CJRActionBarBaseActivityWithoutContextWrapping.this.supportInvalidateOptionsMenu();
                if (view instanceof LinearLayout) {
                    try {
                        CJRActionBarBaseActivityWithoutContextWrapping.this.f52034b.setDrawerLockMode(0, 8388613);
                        CJRActionBarBaseActivityWithoutContextWrapping.this.f52034b.setDrawerLockMode(0, 8388611);
                    } catch (Exception unused) {
                    }
                }
            }

            public final void onDrawerOpened(View view) {
                ((InputMethodManager) this.getSystemService("input_method")).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
                CJRActionBarBaseActivityWithoutContextWrapping.this.supportInvalidateOptionsMenu();
                if ((view instanceof LinearLayout) && CJRActionBarBaseActivityWithoutContextWrapping.this.f52034b.e(5)) {
                    CJRActionBarBaseActivityWithoutContextWrapping.this.f52034b.setDrawerLockMode(1, 8388611);
                    CJRActionBarBaseActivityWithoutContextWrapping.this.f52034b.setDrawerLockMode(2, 8388613);
                }
            }
        };
        this.f52039g = r0;
        DrawerLayout drawerLayout = this.f52034b;
        if (drawerLayout != null) {
            drawerLayout.setDrawerListener(r0);
        }
        ActionBar supportActionBar = getSupportActionBar();
        this.f52033a = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.b(true);
            this.f52033a.c(false);
            this.f52033a.a(true);
            int i2 = R.drawable.action_bar_logo_with_bg;
            this.f52037e = true;
            this.f52033a.b();
            this.f52033a.a(R.layout.action_bar_title);
            this.f52033a.a(2.0f);
            TextView textView = (TextView) findViewById(R.id.text1);
            this.f52035c = textView;
            textView.setInputType(524288);
            this.f52035c.setEllipsize(TextUtils.TruncateAt.END);
            this.f52035c.setTextSize(19.0f);
            this.f52035c.setMaxLines(1);
            this.f52036d = (TextView) findViewById(R.id.text2);
            com.paytm.utility.b.d(this.f52035c);
            this.f52033a.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
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
}
