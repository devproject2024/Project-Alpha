package net.one97.paytm.fastag.f;

import android.app.Dialog;
import android.view.WindowManager;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13765a;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();
    }

    public static WindowManager.LayoutParams a(Dialog dialog) {
        WindowManager.LayoutParams layoutParams;
        try {
            layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            layoutParams = null;
            e.printStackTrace();
            return layoutParams;
        }
        return layoutParams;
    }
}
