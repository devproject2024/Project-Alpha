package net.one97.paytm.common.utility;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.c;
import kotlin.g.b.k;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f49603a = new e();

    private e() {
    }

    public static void a(Activity activity) {
        k.c(activity, "activity");
        int a2 = c.a().a((Context) activity);
        if (a2 != 0 && c.a().a(a2)) {
            activity.runOnUiThread(new Thread(new a(activity, a2)));
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f49604a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f49605b;

        a(Activity activity, int i2) {
            this.f49604a = activity;
            this.f49605b = i2;
        }

        public final void run() {
            try {
                c.a().a(this.f49604a, this.f49605b, 0).show();
            } catch (Exception unused) {
            }
        }
    }
}
