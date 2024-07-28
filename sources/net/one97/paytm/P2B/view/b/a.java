package net.one97.paytm.p2b.view.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.paytm.utility.b;
import net.one97.paytm.p2b.R;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    int f12895a = 0;

    public a(Activity activity) {
        super(activity);
        if (activity != null) {
            this.f12895a = b.f((Context) activity) * 14;
        }
    }

    public void show() {
        Window window = getWindow();
        window.setBackgroundDrawableResource(R.color.p2b_transparent);
        window.addFlags(2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int i2 = this.f12895a;
        if (i2 > 0) {
            layoutParams.width = i2;
        }
        layoutParams.height = -2;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        super.show();
    }
}
