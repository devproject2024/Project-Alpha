package net.one97.paytm.transport.iocl.c;

import android.app.Application;
import android.view.View;
import androidx.databinding.i;
import androidx.lifecycle.a;
import net.one97.paytm.transport.iocl.activity.IOCLBaseActivity;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public i<Long> f14314a = new i<>();

    public e(Application application) {
        super(application);
    }

    public static void a(View view) {
        if (view.getContext() instanceof IOCLBaseActivity) {
            ((IOCLBaseActivity) view.getContext()).b();
        }
    }

    public static void b(View view) {
        if (view.getContext() instanceof IOCLBaseActivity) {
            ((IOCLBaseActivity) view.getContext()).c();
        }
    }
}
