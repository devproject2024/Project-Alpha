package net.one97.paytm.bankOpen.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.bankOpen.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f16418a;

    /* renamed from: b  reason: collision with root package name */
    private String f16419b;

    /* renamed from: c  reason: collision with root package name */
    private String f16420c;

    /* renamed from: d  reason: collision with root package name */
    private Context f16421d;

    /* renamed from: e  reason: collision with root package name */
    private View f16422e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16423f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16424g = false;

    public a(Context context) {
        this.f16421d = context;
    }

    public final void a() {
        Dialog dialog = this.f16418a;
        if (dialog == null || !dialog.isShowing()) {
            this.f16418a = new Dialog(this.f16421d);
            this.f16418a.requestWindowFeature(1);
            this.f16418a.setContentView(R.layout.pb_ca_lottie_loader_dialog);
            if (!TextUtils.isEmpty(this.f16419b)) {
                ((TextView) this.f16418a.findViewById(R.id.tv_title)).setText(this.f16419b);
            }
            if (!TextUtils.isEmpty(this.f16420c)) {
                ((TextView) this.f16418a.findViewById(R.id.tv_title)).setText(this.f16419b);
            }
            this.f16422e = this.f16418a.findViewById(R.id.lyt_wallet_loader);
            View view = this.f16422e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f16422e.findViewById(R.id.wallet_loader));
            }
            this.f16418a.setCancelable(this.f16423f);
            this.f16418a.setCanceledOnTouchOutside(this.f16424g);
            try {
                if (!((Activity) this.f16421d).isFinishing()) {
                    this.f16418a.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        Dialog dialog = this.f16418a;
        if (dialog != null && dialog.isShowing()) {
            View view = this.f16422e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f16422e.findViewById(R.id.wallet_loader));
            }
            this.f16418a.dismiss();
        }
    }

    public final void a(String str) {
        this.f16419b = str;
    }
}
