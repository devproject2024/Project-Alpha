package net.one97.paytm.quickpay.utilities;

import android.content.Context;
import android.view.View;
import com.paytm.utility.h;
import net.one97.paytm.paytm_finance.R;

public final class d {
    public static void a(Context context, String str, String str2) {
        final h hVar = new h(context);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.a(-3, context.getResources().getString(R.string.p2p_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
            }
        });
        hVar.show();
    }
}
