package net.one97.paytm.hotel4.view.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.hotel4.utils.d;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;
import net.one97.paytm.hotels2.utils.c;

public class AJRHotelBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f29045a;

    /* renamed from: b  reason: collision with root package name */
    protected ProgressDialog f29046b;

    /* renamed from: c  reason: collision with root package name */
    private String f29047c = "AJRHotelBaseActivity";

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f29048d;

    /* renamed from: e  reason: collision with root package name */
    private View f29049e;

    public void onErrorBackButton(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        if (this.f29045a && this.f29049e.getVisibility() == 0) {
            this.f29049e.setVisibility(8);
            this.f29048d.setVisibility(0);
        } else if (b().booleanValue()) {
            new CJRHomePageItem().setUrl(d.a(c.b().a().getApplicationContext()).b("home_url", "", true));
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            if (b().booleanValue()) {
                intent.putExtra("Reset_fast_farward", true);
            }
            c.b().a((Context) this, intent);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.f29046b;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f29046b = new ProgressDialog(context);
                try {
                    this.f29046b.setProgressStyle(0);
                    this.f29046b.setMessage(str);
                    this.f29046b.setCancelable(false);
                    this.f29046b.setCanceledOnTouchOutside(false);
                    this.f29046b.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        q.c(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void attachBaseContext(Context context) {
        if (c.a() == null) {
            CJRHotelsUtilsLib.a(context);
        }
        super.attachBaseContext(context);
        a.a((Context) this);
        a.b((Context) this);
    }

    public final void a() {
        ProgressDialog progressDialog = this.f29046b;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f29046b.dismiss();
            this.f29046b = null;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        FrameLayout frameLayout = this.f29048d;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        View view = this.f29049e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private Boolean b() {
        if (getIntent() == null || !getIntent().hasExtra("from_payment")) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(getIntent().getBooleanExtra("from_payment", false));
    }
}
