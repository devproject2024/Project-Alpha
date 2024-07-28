package net.one97.paytm.paymentsBank.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.paymentsBank.R;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public String f18513a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f18514b;

    /* renamed from: c  reason: collision with root package name */
    private String f18515c;

    /* renamed from: d  reason: collision with root package name */
    private Context f18516d;

    /* renamed from: e  reason: collision with root package name */
    private View f18517e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18518f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18519g = false;

    public h(Context context) {
        this.f18516d = context;
    }

    public final void a() {
        Dialog dialog = this.f18514b;
        if (dialog == null || !dialog.isShowing()) {
            this.f18514b = new Dialog(this.f18516d);
            this.f18514b.requestWindowFeature(1);
            this.f18514b.setContentView(R.layout.pb_lottie_loader_dialog);
            if (!TextUtils.isEmpty(this.f18513a)) {
                ((TextView) this.f18514b.findViewById(R.id.tv_title)).setText(this.f18513a);
            }
            if (!TextUtils.isEmpty(this.f18515c)) {
                ((TextView) this.f18514b.findViewById(R.id.tv_title)).setText(this.f18513a);
            }
            this.f18517e = this.f18514b.findViewById(R.id.lyt_wallet_loader);
            View view = this.f18517e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.a((LottieAnimationView) this.f18517e.findViewById(R.id.wallet_loader));
            }
            this.f18514b.setCancelable(this.f18518f);
            this.f18514b.setCanceledOnTouchOutside(this.f18519g);
            try {
                if (!((Activity) this.f18516d).isFinishing()) {
                    this.f18514b.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        Dialog dialog = this.f18514b;
        if (dialog != null && dialog.isShowing()) {
            View view = this.f18517e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.b((LottieAnimationView) this.f18517e.findViewById(R.id.wallet_loader));
            }
            this.f18514b.dismiss();
        }
    }
}
