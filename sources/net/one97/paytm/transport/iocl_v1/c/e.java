package net.one97.paytm.transport.iocl_v1.c;

import android.app.Application;
import android.view.View;
import androidx.databinding.i;
import androidx.lifecycle.a;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public i<Long> f14446a = new i<>();

    public e(Application application) {
        super(application);
    }

    public static void a(View view) {
        if (view.getContext() instanceof IOCLBaseActivity) {
            ((IOCLBaseActivity) view.getContext()).c();
        }
    }

    public static void b(View view) {
        if (view.getContext() instanceof IOCLBaseActivity) {
            ((IOCLBaseActivity) view.getContext()).d();
        }
    }
}
