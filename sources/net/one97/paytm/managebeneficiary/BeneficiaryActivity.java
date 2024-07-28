package net.one97.paytm.managebeneficiary;

import android.app.ProgressDialog;
import android.content.Context;
import com.paytm.utility.q;
import net.one97.paytm.activity.PaytmActivity;

public abstract class BeneficiaryActivity extends PaytmActivity {

    /* renamed from: b  reason: collision with root package name */
    protected ProgressDialog f53218b;

    /* access modifiers changed from: protected */
    public final void a(Context context, String str) {
        ProgressDialog progressDialog = this.f53218b;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f53218b = new ProgressDialog(context);
            try {
                this.f53218b.setProgressStyle(0);
                this.f53218b.setMessage(str);
                this.f53218b.setCancelable(false);
                this.f53218b.setCanceledOnTouchOutside(false);
                this.f53218b.show();
            } catch (IllegalArgumentException e2) {
                q.b(e2.getMessage());
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            if (this.f53218b != null && this.f53218b.isShowing() && !isFinishing()) {
                this.f53218b.dismiss();
                this.f53218b = null;
            }
        } catch (Exception unused) {
        }
    }
}
