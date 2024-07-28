package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.paytm.utility.b;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    int f58656a;

    public a(Activity activity) {
        this(activity, (byte) 0);
    }

    private a(Activity activity, byte b2) {
        super(activity, 0);
        this.f58656a = 0;
        if (activity != null) {
            this.f58656a = b.f((Context) activity) * 14;
        }
    }

    public void show() {
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170443);
        window.addFlags(2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int i2 = this.f58656a;
        if (i2 > 0) {
            layoutParams.width = i2;
        }
        layoutParams.height = -2;
        layoutParams.dimAmount = 0.7f;
        super.show();
        getWindow().setAttributes(layoutParams);
    }
}
