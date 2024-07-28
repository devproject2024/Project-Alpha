package net.one97.paytm.fastag;

import android.app.ProgressDialog;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;

public class BaseActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private static ProgressDialog f13554a;

    public static void a(Context context, String str) {
        ProgressDialog progressDialog = f13554a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            f13554a = new ProgressDialog(context);
            try {
                f13554a.setProgressStyle(0);
                f13554a.setMessage(str);
                f13554a.setCancelable(false);
                f13554a.setCanceledOnTouchOutside(false);
                f13554a.show();
            } catch (IllegalArgumentException e2) {
                if (b.v) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void X_() {
        ProgressDialog progressDialog = f13554a;
        if (progressDialog != null && progressDialog.isShowing()) {
            f13554a.dismiss();
            f13554a = null;
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
