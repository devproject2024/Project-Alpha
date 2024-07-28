package net.one97.paytm.passbook.landing.e;

import androidx.appcompat.widget.AppCompatTextView;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CJRAccountSummary> f57662a;

    public j(f<? extends CJRAccountSummary> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57662a = fVar;
    }

    public static void a(PassbookBalanceCardView passbookBalanceCardView) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
        k.a((Object) appCompatTextView, "bankCard.tvCheckBalance");
        appCompatTextView.setVisibility(4);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
        k.a((Object) appCompatTextView2, "bankCard.tvAmount");
        appCompatTextView2.setVisibility(0);
    }
}
