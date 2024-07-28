package net.one97.paytm.fastag.f;

import android.app.Dialog;
import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.fastag.R;

public final class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f13773a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f13774b = ((LottieAnimationView) findViewById(R.id.wallet_loader));

    public d(Context context) {
        super(context, R.style.ThemeDialogLoader);
        this.f13773a = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.w_custom_dialog_lottie_loader_ft);
        if (this.f13773a != null) {
            a.a(this.f13774b);
        }
    }
}
