package net.one97.paytm.recharge.presentation.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.d.b;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    final b f64848a;

    /* renamed from: b  reason: collision with root package name */
    private final View f64849b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, b bVar) {
        super(view);
        k.c(view, "mItemView");
        k.c(bVar, "itemClickListener");
        this.f64849b = view;
        this.f64848a = bVar;
    }

    public final <T> void a(T t) {
        if (t instanceof CJRFrequentOrder) {
            View findViewById = this.f64849b.findViewById(R.id.text_recharge_number);
            k.a((Object) findViewById, "mItemView.findViewById<T….id.text_recharge_number)");
            CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) t;
            ((TextView) findViewById).setText(TextUtils.isEmpty(cJRFrequentOrder.getName()) ? cJRFrequentOrder.getRechargeNumber() : cJRFrequentOrder.getName());
            View findViewById2 = this.f64849b.findViewById(R.id.txt_nick_name);
            k.a((Object) findViewById2, "mItemView.findViewById<T…View>(R.id.txt_nick_name)");
            ((TextView) findViewById2).setText(TextUtils.isEmpty(cJRFrequentOrder.getName()) ? cJRFrequentOrder.getOperatorDisplayLabel() : cJRFrequentOrder.getName());
            w.a().a(cJRFrequentOrder.getOperatorLogoURL()).a((ImageView) this.f64849b.findViewById(R.id.ic_operator_icon));
            this.f64849b.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64850a;

        a(c cVar) {
            this.f64850a = cVar;
        }

        public final void onClick(View view) {
            this.f64850a.f64848a.a(this.f64850a.getAdapterPosition());
        }
    }
}
