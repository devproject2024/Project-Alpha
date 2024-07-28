package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.paytm.utility.h;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class QuickPaymentActivity extends PaytmActivity {

    /* renamed from: b  reason: collision with root package name */
    protected ProgressDialog f59987b;

    public interface a {
        void a();
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.f59987b;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f59987b = new ProgressDialog(context);
                try {
                    this.f59987b.setProgressStyle(0);
                    this.f59987b.setMessage(str);
                    this.f59987b.setCancelable(false);
                    this.f59987b.setCanceledOnTouchOutside(false);
                    this.f59987b.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(d.a().t(context));
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ProgressDialog progressDialog = this.f59987b;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f59987b.dismiss();
            this.f59987b = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void b(int i2) {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Activity activity, String str, final a aVar) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.payment_reminder_creation_lyt);
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(R.id.qp_message_tv)).setText(str);
        if (!activity.isFinishing()) {
            dialog.getWindow();
            dialog.show();
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    dialog.dismiss();
                    aVar.a();
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        final h hVar = new h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCanceledOnTouchOutside(false);
        hVar.a(-3, getResources().getString(R.string.p2p_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
            }
        });
        if (!isFinishing()) {
            hVar.show();
        }
    }

    protected static String a(boolean z, String str, String str2, String str3, String str4, String str5) {
        if (z) {
            String str6 = "paytmmp://cash_wallet?featuretype=money_transfer&account=" + str + "&pn=" + str2 + "&ifsc=" + str3;
            if (!TextUtils.isEmpty(str4)) {
                str6 = str6 + "&bank_name=" + str4;
            }
            if (TextUtils.isEmpty(str5)) {
                return str6;
            }
            return str6 + "&am=" + str5;
        }
        String str7 = "paytmmp://cash_wallet?featuretype=money_transfer&pa=" + str + "&pn=" + str2;
        if (TextUtils.isEmpty(str5)) {
            return str7;
        }
        return str7 + "&am=" + str5;
    }
}
