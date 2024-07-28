package net.one97.paytm.wallet.p2p;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.paytm.utility.h;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.utility.a;

public class P2PAppCompatActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f71490a;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        final h hVar = new h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.a(-3, getResources().getString(R.string.p2p_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
            }
        });
        hVar.show();
    }

    public final void a(boolean z) {
        if (z) {
            if (this.f71490a == null) {
                this.f71490a = a.b((Activity) this);
            }
            Dialog dialog = this.f71490a;
            if (dialog != null && !dialog.isShowing()) {
                this.f71490a.show();
                return;
            }
            return;
        }
        Dialog dialog2 = this.f71490a;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f71490a.dismiss();
        }
    }
}
