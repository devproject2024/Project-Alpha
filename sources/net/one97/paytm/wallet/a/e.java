package net.one97.paytm.wallet.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.paytm.utility.b;
import net.one97.paytm.wallet.f.c;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import net.one97.paytm.wallet.newdesign.activity.ShowCodeActivity;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public c f69875a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f69876b;

    public final void a(Boolean bool) {
        Activity activity = this.f69876b;
        if (activity != null && !activity.isFinishing()) {
            Context context = activity;
            if (!b.r(context)) {
                Intent intent = new Intent(context, PaySendInfoActivity.class);
                intent.putExtra("dest", "show_code");
                activity.startActivity(intent);
                activity.finish();
                return;
            }
            a aVar = a.f69839a;
            boolean z = false;
            a.c(bool != null ? bool.booleanValue() : false);
            a aVar2 = a.f69839a;
            if (bool != null) {
                z = bool.booleanValue();
            }
            a.d(z);
            activity.startActivity(new Intent(context, ShowCodeActivity.class));
        }
    }
}
