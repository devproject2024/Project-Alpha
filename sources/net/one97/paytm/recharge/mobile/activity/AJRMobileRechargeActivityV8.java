package net.one97.paytm.recharge.mobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.utility.b;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeToolbarActivity;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.a.i;

public final class AJRMobileRechargeActivityV8 extends CJRRechargeToolbarActivity implements FJRRechargeUtilityBaseV2.b {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f63672a;

    public final void a() {
    }

    public final void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.v8_activity_recharge);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            k.a((Object) window, "window");
            View decorView = window.getDecorView();
            k.a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        this.f63672a = getSupportFragmentManager().c("parent");
        if (this.f63672a == null) {
            Bundle bundleExtra = getIntent().getBundleExtra("arguments");
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            Intent intent = getIntent();
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("extra_home_data") : null;
            if (!(serializableExtra instanceof CJRItem)) {
                serializableExtra = null;
            }
            CJRItem cJRItem = (CJRItem) serializableExtra;
            Intent intent2 = getIntent();
            boolean booleanExtra = intent2 != null ? intent2.getBooleanExtra("open_activity_in_automatic_mode", false) : false;
            bundleExtra.putSerializable("recharge_item", cJRItem);
            bundleExtra.putBoolean("open_activity_in_automatic_mode", booleanExtra);
            bundleExtra.putBoolean("isInitialFragment", false);
            this.f63672a = Fragment.instantiate(this, i.class.getName(), bundleExtra);
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                q a2 = supportFragmentManager.a();
                int i2 = R.id.container_frame;
                Fragment fragment = this.f63672a;
                if (fragment == null) {
                    k.a();
                }
                a2.b(i2, fragment, "parent").a((Runnable) new a(this)).c();
            }
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMobileRechargeActivityV8 f63673a;

        a(AJRMobileRechargeActivityV8 aJRMobileRechargeActivityV8) {
            this.f63673a = aJRMobileRechargeActivityV8;
        }

        public final void run() {
            this.f63673a.al_();
        }
    }

    public final int m() {
        return R.style.Recharge_NoTitle;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b(false);
            this.t.a();
        } else if (!r()) {
            b(true);
            this.t.a(str);
        }
    }

    public final void onBackPressed() {
        Fragment fragment = this.f63672a;
        if (!(fragment instanceof i)) {
            return;
        }
        if (fragment == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile.fragment.FJRMobileLandingFragment");
        } else if (((i) fragment).d()) {
            super.onBackPressed();
        }
    }
}
