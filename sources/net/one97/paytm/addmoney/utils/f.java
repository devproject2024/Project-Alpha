package net.one97.paytm.addmoney.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.widgets.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f48967a;

    /* renamed from: b  reason: collision with root package name */
    public String f48968b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f48969c;

    /* renamed from: d  reason: collision with root package name */
    private Context f48970d;

    /* renamed from: e  reason: collision with root package name */
    private View f48971e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f48972f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48973g = false;

    public f(Context context) {
        this.f48970d = context;
    }

    public final void a() {
        Dialog dialog = this.f48969c;
        if (dialog == null || !dialog.isShowing()) {
            this.f48969c = new Dialog(this.f48970d);
            this.f48969c.requestWindowFeature(1);
            this.f48969c.setContentView(R.layout.uam_add_money_loader_dialog);
            if (!TextUtils.isEmpty(this.f48967a)) {
                ((TextView) this.f48969c.findViewById(R.id.tv_title)).setText(this.f48967a);
            }
            if (!TextUtils.isEmpty(this.f48968b)) {
                ((TextView) this.f48969c.findViewById(R.id.tv_title)).setText(this.f48967a);
            }
            this.f48971e = this.f48969c.findViewById(R.id.lyt_wallet_loader);
            View view = this.f48971e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.a((LottieAnimationView) this.f48971e.findViewById(R.id.wallet_loader));
            }
            this.f48969c.setCancelable(this.f48972f);
            this.f48969c.setCanceledOnTouchOutside(this.f48973g);
            try {
                if (!((Activity) this.f48970d).isFinishing()) {
                    this.f48969c.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        Dialog dialog = this.f48969c;
        if (dialog != null && dialog.isShowing()) {
            View view = this.f48971e;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.b((LottieAnimationView) this.f48971e.findViewById(R.id.wallet_loader));
            }
            this.f48969c.dismiss();
        }
    }
}
