package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import kotlin.u;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.f;

public final class z extends a {

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57704a;

        public a(PassbookBalanceCardView passbookBalanceCardView) {
            this.f57704a = passbookBalanceCardView;
        }

        public final void onClick(View view) {
            String a2 = d.b().a("passStickersDeeplink");
            if (!TextUtils.isEmpty(a2)) {
                f b2 = d.b();
                Context context = this.f57704a.getContext();
                if (context != null) {
                    b2.a(a2, (Activity) context);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }
}
