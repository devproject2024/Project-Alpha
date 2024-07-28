package net.one97.paytm.passbook.landing.e;

import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;

public final class v extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CJRAccountSummary> f57695a;

    public v(f<? extends CJRAccountSummary> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57695a = fVar;
    }

    public static void a(PassbookBalanceCardView passbookBalanceCardView) {
        net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
        net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) passbookBalanceCardView.findViewById(R.id.loaderCheckBalance), false);
        AppCompatTextView appCompatTextView = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
        k.a((Object) appCompatTextView, "bankCard.tvCheckBalance");
        appCompatTextView.setVisibility(4);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
        k.a((Object) appCompatTextView2, "bankCard.tvAmount");
        appCompatTextView2.setVisibility(0);
    }

    public static void b(PassbookBalanceCardView passbookBalanceCardView) {
        net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
        net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) passbookBalanceCardView.findViewById(R.id.loaderCheckBalance), false);
        AppCompatTextView appCompatTextView = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
        k.a((Object) appCompatTextView, "bankCard.tvCheckBalance");
        appCompatTextView.setVisibility(0);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
        k.a((Object) appCompatTextView2, "bankCard.tvAmount");
        appCompatTextView2.setVisibility(4);
    }
}
