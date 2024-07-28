package net.one97.paytm.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.paytm.utility.b;
import com.paytm.utility.q;

public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static ProgressDialog f69714a;

    public static void a(Context context, String str) {
        ProgressDialog progressDialog = f69714a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            f69714a = new ProgressDialog(context);
            try {
                f69714a.setProgressStyle(0);
                f69714a.setMessage(str);
                f69714a.setCancelable(false);
                f69714a.setCanceledOnTouchOutside(false);
                f69714a.show();
            } catch (IllegalArgumentException e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context) {
        ProgressDialog progressDialog;
        if (!((Activity) context).isDestroyed() && (progressDialog = f69714a) != null && progressDialog.isShowing()) {
            f69714a.dismiss();
            f69714a = null;
        }
    }
}
