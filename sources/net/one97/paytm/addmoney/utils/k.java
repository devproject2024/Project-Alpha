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

public final class k {

    /* renamed from: b  reason: collision with root package name */
    private static k f48990b;

    /* renamed from: a  reason: collision with root package name */
    public String f48991a;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f48992c;

    /* renamed from: d  reason: collision with root package name */
    private String f48993d;

    /* renamed from: e  reason: collision with root package name */
    private Context f48994e;

    /* renamed from: f  reason: collision with root package name */
    private View f48995f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48996g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f48997h = false;

    public k(Context context) {
        this.f48994e = context;
    }

    public static k a(Context context) {
        if (f48990b == null) {
            f48990b = new k(context);
        }
        return f48990b;
    }

    public final void a() {
        Dialog dialog = this.f48992c;
        if (dialog == null || !dialog.isShowing()) {
            this.f48992c = new Dialog(this.f48994e);
            this.f48992c.requestWindowFeature(1);
            this.f48992c.setContentView(R.layout.new_wallet_loader_dialog);
            if (!TextUtils.isEmpty(this.f48991a)) {
                ((TextView) this.f48992c.findViewById(R.id.tv_title)).setText(this.f48991a);
            }
            if (this.f48993d != null) {
                ((TextView) this.f48992c.findViewById(R.id.tv_subtitle)).setText(this.f48993d);
            }
            this.f48995f = this.f48992c.findViewById(R.id.lyt_wallet_loader);
            View view = this.f48995f;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.a((LottieAnimationView) this.f48995f.findViewById(R.id.wallet_loader));
            }
            this.f48992c.setCancelable(this.f48996g);
            this.f48992c.setCanceledOnTouchOutside(this.f48997h);
            try {
                if (!((Activity) this.f48994e).isFinishing()) {
                    this.f48992c.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        Dialog dialog = this.f48992c;
        if (dialog != null && dialog.isShowing()) {
            View view = this.f48995f;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.b((LottieAnimationView) this.f48995f.findViewById(R.id.wallet_loader));
            }
            this.f48992c.dismiss();
        }
    }
}
