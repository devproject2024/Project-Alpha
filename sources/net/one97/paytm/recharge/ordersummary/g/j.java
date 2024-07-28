package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import com.paytm.utility.CustomTypefaceSpan;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.d.o;
import net.one97.paytm.recharge.ordersummary.d.p;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.widgets.c.d;

public final class j extends c {
    public final boolean c() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final String f() {
        String name = p.class.getName();
        k.a((Object) name, "FJRPMCareFundStoreFrontFragment::class.java.name");
        return name;
    }

    public final String h() {
        String name = o.class.getName();
        k.a((Object) name, "FJRPMCareFundOrderDetailsFragment::class.java.name");
        return name;
    }

    public final String R(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_storefront_recharge_title_pm_care, new Object[]{super.R(context)});
        k.a((Object) string, "context.getString(R.stri…ntRechargeTitle(context))");
        return string;
    }

    public final SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        SpannableString spannableString = new SpannableString(context.getString(R.string.v8_os_storefront_subtitle_pm_care));
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 0, spannableString.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.6f), 0, spannableString.length(), 33);
        return spannableString;
    }

    public final String g(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        d dVar = d.f64967a;
        String h2 = d.h(cJROrderedCart.getAggregateItemPrice());
        String string = context.getString(R.string.price_container_re_v8, new Object[]{h2});
        k.a((Object) string, "context.getString(R.stri…er_re_v8, rechargeAmount)");
        return string;
    }
}
