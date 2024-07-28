package com.travel.bus.busticket.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.travel.bus.R;

public final class s {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22471a;

    /* renamed from: b  reason: collision with root package name */
    static a f22472b;

    public interface a {
    }

    private static WindowManager.LayoutParams a(Dialog dialog) {
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
            q.c(e.getMessage());
            return layoutParams;
        }
        return layoutParams;
    }

    public static void a(final Context context, String str, String str2, String str3, final Intent intent) {
        boolean z = context instanceof Activity;
        if (z && !f22471a) {
            if (TextUtils.isEmpty(str3)) {
                str3 = context.getResources().getString(R.string.ok);
            }
            if (z && !((Activity) context).isFinishing()) {
                final h hVar = new h(context);
                hVar.setTitle(str);
                hVar.a(str2);
                hVar.setCancelable(false);
                WindowManager.LayoutParams a2 = a((Dialog) hVar);
                hVar.a(-3, str3, new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (s.f22472b != null) {
                            s.f22472b = null;
                        }
                        hVar.cancel();
                        s.f22471a = false;
                        Intent intent = intent;
                        if (intent != null) {
                            context.startActivity(intent);
                        }
                    }
                });
                hVar.show();
                if (!(a2 == null || hVar.getWindow() == null)) {
                    hVar.getWindow().setAttributes(a2);
                }
                f22471a = true;
                hVar.setOnDismissListener($$Lambda$s$TkQy5qErpuss2Y1XyOD3NDVv3yw.INSTANCE);
            }
        }
    }
}
