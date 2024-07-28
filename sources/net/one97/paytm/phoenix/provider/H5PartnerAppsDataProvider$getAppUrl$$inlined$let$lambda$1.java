package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.paytm.network.a;
import net.one97.paytm.utils.r;

final class H5PartnerAppsDataProvider$getAppUrl$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ a $it;

    H5PartnerAppsDataProvider$getAppUrl$$inlined$let$lambda$1(a aVar, Context context) {
        this.$it = aVar;
        this.$context$inlined = context;
    }

    public final void run() {
        View findViewById;
        Context context = this.$context$inlined;
        if ((context instanceof Activity) && (findViewById = ((Activity) context).findViewById(16908290)) != null) {
            findViewById.postDelayed(new Runnable(this) {
                final /* synthetic */ H5PartnerAppsDataProvider$getAppUrl$$inlined$let$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    if (!((Activity) this.this$0.$context$inlined).isDestroyed() && !((Activity) this.this$0.$context$inlined).isFinishing()) {
                        r.a(this.this$0.$it, this.this$0.$context$inlined, (DialogInterface.OnCancelListener) null);
                    }
                }
            }, 100);
        }
    }
}
