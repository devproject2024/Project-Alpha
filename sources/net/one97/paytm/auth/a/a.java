package net.one97.paytm.auth.a;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

public class a extends Dialog {

    /* renamed from: d  reason: collision with root package name */
    int f49088d;

    public a(Activity activity) {
        this(activity, (byte) 0);
    }

    private a(Activity activity, byte b2) {
        super(activity, 0);
        this.f49088d = 0;
        if (activity != null) {
            this.f49088d = com.paytm.utility.a.t(activity) * 14;
        }
    }

    public void show() {
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170443);
        window.addFlags(2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int i2 = this.f49088d;
        if (i2 > 0) {
            layoutParams.width = i2;
        }
        layoutParams.height = -2;
        layoutParams.dimAmount = 0.7f;
        super.show();
        getWindow().setAttributes(layoutParams);
    }
}
