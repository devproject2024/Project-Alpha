package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public abstract class UpgradeKycBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f65416a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f65417b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f65418c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f65419d;

    public abstract int a();

    public View a(int i2) {
        if (this.f65419d == null) {
            this.f65419d = new HashMap();
        }
        View view = (View) this.f65419d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65419d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract int b();

    public void c() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        setContentView(R.layout.activity_toolbar_upgrade_kyc);
        this.f65417b = (TextView) findViewById(R.id.tvHeaderMsg);
        if (b() != -1) {
            setTheme(R.style.KycThemeNoActionBar);
            View inflate = getLayoutInflater().inflate(b(), (ViewGroup) null);
            View findViewById = findViewById(R.id.toolbarLayout);
            if (findViewById != null) {
                ((ViewGroup) findViewById).addView(inflate);
                this.f65416a = (Toolbar) inflate.findViewById(R.id.toolbar);
                this.f65417b = (TextView) inflate.findViewById(R.id.tvHeaderMsg);
                setSupportActionBar(this.f65416a);
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.e(R.drawable.back_arrow);
                }
                ActionBar supportActionBar2 = getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.a(true);
                }
                ActionBar supportActionBar3 = getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.b(true);
                }
                ActionBar supportActionBar4 = getSupportActionBar();
                if (supportActionBar4 != null) {
                    supportActionBar4.c(false);
                }
                getSupportActionBar();
                ActionBar supportActionBar5 = getSupportActionBar();
                if (supportActionBar5 != null) {
                    supportActionBar5.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
                }
            } else {
                throw new u("null cannot be cast to non-null type android.view.ViewGroup");
            }
        } else {
            setTheme(R.style.KycThemeNoActionBar);
            ActionBar supportActionBar6 = getSupportActionBar();
            if (supportActionBar6 != null) {
                supportActionBar6.f();
            }
        }
        View findViewById2 = findViewById(R.id.container_framelayout);
        if (findViewById2 != null) {
            this.f65418c = (FrameLayout) findViewById2;
            if (a() != 0) {
                View inflate2 = getLayoutInflater().inflate(a(), (ViewGroup) null);
                FrameLayout frameLayout = this.f65418c;
                if (frameLayout == null) {
                    k.a("container");
                }
                frameLayout.addView(inflate2);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        e.a aVar = e.f66028b;
        super.attachBaseContext(e.a.b().a(context));
    }

    public void setTitle(int i2) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.c(true);
        }
        TextView textView = this.f65417b;
        if (textView != null) {
            textView.setText(getText(i2));
        }
        super.setTitle(i2);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            c();
            onBackPressed();
            return true;
        } catch (IllegalStateException unused) {
            return true;
        }
    }

    public static /* synthetic */ void a(UpgradeKycBaseActivity upgradeKycBaseActivity, String str, String str2, HashMap hashMap, String str3, int i2) {
        if ((i2 & 4) != 0) {
            hashMap = null;
        }
        if ((i2 & 8) != 0) {
            str3 = "signal";
        }
        upgradeKycBaseActivity.a(str, str2, hashMap, str3);
    }

    public final void a(String str, String str2, HashMap<String, Object> hashMap, String str3) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "action");
        k.c(str3, "analytics");
        e.a aVar = e.f66028b;
        e.a.b().a(this, "kyc", str2, hashMap, str, "kyc_new", str3, false);
    }

    private void b(String str, String str2, String str3) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "action");
        k.c(str3, "analytics");
        e.a aVar = e.f66028b;
        e.a.b().a(this, "kyc", str2, (HashMap<String, Object>) null, str, "kyc_new", str3, true);
    }

    public final void a(String str, String str2, String str3) {
        k.c(str3, "analytics");
        e.a aVar = e.f66028b;
        e.a.b().a(str, str2, this, str3);
    }

    public final void b(String str, String str2) {
        k.c(str, "action");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        b(str2, str, "signal");
    }
}
