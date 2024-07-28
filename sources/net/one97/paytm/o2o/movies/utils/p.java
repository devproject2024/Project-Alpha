package net.one97.paytm.o2o.movies.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.paytm.utility.h;
import net.one97.paytm.o2o.movies.R;

public final class p {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f75975a;

    /* renamed from: b  reason: collision with root package name */
    static a f75976b;

    public interface a {
    }

    public interface b {
        void onDialogDismissed();
    }

    private static WindowManager.LayoutParams a(Dialog dialog) {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                return layoutParams;
            } catch (Exception unused) {
                return layoutParams;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2, final b bVar) {
        if (!f75975a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    p.f75975a = false;
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.onDialogDismissed();
                    }
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f75975a = true;
        }
    }

    public static void a(Context context, String str, String str2) {
        b(context, str, str2);
    }

    private static void b(Context context, String str, String str2) {
        boolean z = context instanceof Activity;
        if (z && !f75975a && z && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            hVar.f43822b = false;
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    if (p.f75976b != null) {
                        p.f75976b = null;
                    }
                    hVar.cancel();
                    p.f75975a = false;
                }
            });
            hVar.show();
            if (!(a2 == null || hVar.getWindow() == null)) {
                hVar.getWindow().setAttributes(a2);
            }
            f75975a = true;
            hVar.setOnDismissListener($$Lambda$p$Q5kMuUAcpydmpk8mAkoJbDSn3Zg.INSTANCE);
        }
    }
}
