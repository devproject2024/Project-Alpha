package net.one97.paytm.paymentsBank.si.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.h;
import net.one97.paytm.paymentsBank.utils.o;

public class SIBaseActivity extends PBBaseActivity implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    private h f18830b;

    public void onCancel(DialogInterface dialogInterface) {
    }

    public final void a(f fVar) {
        ah_();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(fVar) {
            private final /* synthetic */ f f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                SIBaseActivity.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            getApplicationContext();
            new c();
            c.a(fVar);
            return;
        }
        a(fVar);
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            try {
                if (this.f18830b == null) {
                    this.f18830b = new h(this);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f18830b.f18513a = str;
                }
                this.f18830b.a();
            } catch (Exception unused) {
            }
        }
    }

    public final void ah_() {
        h hVar = this.f18830b;
        if (hVar != null) {
            hVar.b();
        }
    }

    protected static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(o.a().getBaseContext(context));
        a.a((Context) this);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }
}
