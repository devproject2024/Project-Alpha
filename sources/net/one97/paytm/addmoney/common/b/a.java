package net.one97.paytm.addmoney.common.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.paytm.utility.b;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    int f48428a = 0;

    public a(Activity activity) {
        super(activity);
        if (activity != null) {
            this.f48428a = b.f((Context) activity) * 14;
        }
    }

    public void show() {
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170443);
        window.addFlags(2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int i2 = this.f48428a;
        if (i2 > 0) {
            layoutParams.width = i2;
        }
        layoutParams.height = -2;
        layoutParams.dimAmount = 0.7f;
        super.show();
        getWindow().setAttributes(layoutParams);
    }
}
