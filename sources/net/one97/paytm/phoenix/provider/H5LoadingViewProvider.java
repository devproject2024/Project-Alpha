package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import net.one97.paytm.h5.b;

public class H5LoadingViewProvider implements PhoenixLoadingViewProvider {
    public void updateProgress(int i2) {
    }

    public boolean hideLoadingView(Activity activity) {
        b bVar = b.f50536a;
        b.b(activity);
        return true;
    }

    public boolean showLoadingView(Activity activity) {
        b bVar = b.f50536a;
        b.a(activity);
        return true;
    }
}
