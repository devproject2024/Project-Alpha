package net.one97.paytm.utils;

import android.app.Dialog;
import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.wallet.R;

public final class z extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f69811a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f69812b = ((LottieAnimationView) findViewById(R.id.wallet_loader));

    public z(Context context) {
        super(context, R.style.ThemeDialogLoader);
        this.f69811a = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.wallet_custom_dialog_lottie_loader);
        a();
    }

    public z(Context context, int i2) {
        super(context, i2);
        this.f69811a = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.wallet_custom_dialog_lottie_loader);
        a();
    }

    private void a() {
        if (this.f69811a != null) {
            a.a(this.f69812b);
        }
    }
}
