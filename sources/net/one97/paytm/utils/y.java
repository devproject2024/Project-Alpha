package net.one97.paytm.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.paytm.utility.h;
import com.paytm.utility.q;
import net.one97.paytm.paytm_finance.R;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    static boolean f69807a;

    public interface a {
        void onDialogDismissed();
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
            q.b(e.getMessage());
            return layoutParams;
        }
        return layoutParams;
    }

    public static void a(Context context, String str, String str2, final a aVar) {
        if (!f69807a && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            final h hVar = new h(context);
            if (str != null) {
                hVar.setTitle(str);
            }
            if (str2 != null) {
                hVar.a(str2);
            }
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a(hVar);
            hVar.a(-1, context.getString(R.string.string_report_error), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    y.f69807a = false;
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onDialogDismissed();
                    }
                }
            });
            hVar.a(-2, context.getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    y.f69807a = false;
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            f69807a = true;
        }
    }
}
