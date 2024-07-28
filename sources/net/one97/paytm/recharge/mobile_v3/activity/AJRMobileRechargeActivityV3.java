package net.one97.paytm.recharge.mobile_v3.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.paytm.utility.b;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeToolbarActivity;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile_v3.b.c;
import net.one97.paytm.recharge.mobile_v3.b.g;
import net.one97.paytm.recharge.mobile_v3.b.j;
import net.one97.paytm.recharge.widgets.c.d;

public final class AJRMobileRechargeActivityV3 extends CJRRechargeToolbarActivity implements FJRRechargeUtilityBaseV2.b {
    public final void a() {
    }

    public final void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        d dVar = d.f64967a;
        d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " onCreate");
        setContentView(R.layout.v8_activity_recharge);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            k.a((Object) window, "window");
            View decorView = window.getDecorView();
            k.a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        if (bundle == null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            a(intent);
        }
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d dVar = d.f64967a;
        d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " onNewIntent");
        if (intent != null) {
            a(intent);
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

    private final void a(Intent intent) {
        Window window;
        Bundle bundleExtra = intent.getBundleExtra("arguments");
        Serializable serializableExtra = intent.getSerializableExtra("extra_home_data");
        String str = null;
        if (!(serializableExtra instanceof CJRItem)) {
            serializableExtra = null;
        }
        CJRItem cJRItem = (CJRItem) serializableExtra;
        boolean booleanExtra = intent.getBooleanExtra("open_activity_in_automatic_mode", false);
        if (bundleExtra != null) {
            str = bundleExtra.getString("recharge.component.name");
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence) && (k.a((Object) c.class.getName(), (Object) str) || k.a((Object) j.class.getName(), (Object) str))) {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setSoftInputMode(21);
            }
        } else if (!TextUtils.isEmpty(charSequence) && k.a((Object) net.one97.paytm.recharge.mobile_v3.b.d.class.getName(), (Object) str) && (window = getWindow()) != null) {
            window.setSoftInputMode(19);
        }
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putSerializable("recharge_item", cJRItem);
        bundleExtra.putBoolean("open_activity_in_automatic_mode", booleanExtra);
        Fragment instantiate = Fragment.instantiate(this, g.class.getName(), bundleExtra);
        k.a((Object) instantiate, "Fragment.instantiate(thi…:class.java.name, bundle)");
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.a().b(R.id.container_frame, instantiate, g.class.getName()).a((Runnable) new a(this)).c();
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMobileRechargeActivityV3 f63762a;

        a(AJRMobileRechargeActivityV3 aJRMobileRechargeActivityV3) {
            this.f63762a = aJRMobileRechargeActivityV3;
        }

        public final void run() {
            this.f63762a.al_();
        }
    }

    public final void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(R.id.container_frame);
        if ((c2 instanceof g) && ((g) c2).d()) {
            super.onBackPressed();
        }
    }
}
