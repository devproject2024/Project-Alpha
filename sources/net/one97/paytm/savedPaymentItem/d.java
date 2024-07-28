package net.one97.paytm.savedPaymentItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;

public final class d extends com.google.android.material.bottomsheet.a implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    private TextView f65020g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f65021h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f65022i;
    private TextView j;
    private ImageView k;
    private LottieAnimationView l;
    private final a m;
    private final int n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;

    public interface a {
        void b(int i2, String str, String str2, String str3, String str4, String str5);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, a aVar, int i2, String str, String str2, String str3, String str4, String str5) {
        super(context);
        k.c(context, "context");
        k.c(aVar, "listener");
        k.c(str, "firstSixDigit");
        k.c(str2, "lastFourDigit");
        k.c(str3, "expiryDate");
        k.c(str4, "customerId");
        k.c(str5, "cardType");
        this.m = aVar;
        this.n = i2;
        this.o = str;
        this.p = str2;
        this.q = str3;
        this.r = str4;
        this.s = str5;
        View inflate = View.inflate(getContext(), R.layout.visa_disable_one_click_bs_dialog, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_cancel);
        k.a((Object) findViewById, "view.findViewById(R.id.tv_cancel)");
        this.f65020g = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_disable);
        k.a((Object) findViewById2, "view.findViewById(R.id.tv_disable)");
        this.f65021h = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.loader);
        k.a((Object) findViewById3, "view.findViewById(R.id.loader)");
        this.l = (LottieAnimationView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.bs_title);
        k.a((Object) findViewById4, "view.findViewById(R.id.bs_title)");
        this.f65022i = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tv_sub_title);
        k.a((Object) findViewById5, "view.findViewById(R.id.tv_sub_title)");
        this.j = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.failed_iv);
        k.a((Object) findViewById6, "view.findViewById(R.id.failed_iv)");
        this.k = (ImageView) findViewById6;
        setContentView(inflate);
        TextView textView = this.f65022i;
        c.a();
        textView.setText(c.a("disable_oc_title", context.getString(R.string.disable_oc_title)));
        TextView textView2 = this.j;
        c.a();
        textView2.setText(c.a("disable_oc_subtext", context.getString(R.string.disable_oc_subtext)));
        View.OnClickListener onClickListener = this;
        this.f65020g.setOnClickListener(onClickListener);
        this.f65021h.setOnClickListener(onClickListener);
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.tv_cancel) {
                dismiss();
            } else if (id == R.id.tv_disable) {
                net.one97.paytm.common.widgets.a.a(this.l);
                this.f65021h.setEnabled(false);
                this.m.b(this.n, this.o, this.p, this.q, this.r, this.s);
            }
        }
    }

    public final void b() {
        this.f65021h.setEnabled(true);
        net.one97.paytm.common.widgets.a.b(this.l);
        TextView textView = this.f65022i;
        c.a();
        textView.setText(c.a("disable_oc_failed", getContext().getString(R.string.disable_oc_failed)));
        this.f65021h.setText(getContext().getString(R.string.retry));
        this.k.setVisibility(0);
        this.j.setVisibility(8);
    }
}
