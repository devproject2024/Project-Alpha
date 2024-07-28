package net.one97.paytm.recharge.presentation.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.SectionWrapper;
import net.one97.paytm.recharge.presentation.a.j;
import net.one97.paytm.recharge.widgets.c.e;

public final class m extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f64921a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f64922b;

    /* renamed from: c  reason: collision with root package name */
    private final j.a f64923c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(View view, j.a aVar) {
        super(view);
        k.c(view, "itemView");
        k.c(aVar, "bankListener");
        this.f64923c = aVar;
        View findViewById = view.findViewById(R.id.ic_bank_logo);
        k.a((Object) findViewById, "itemView.findViewById(R.id.ic_bank_logo)");
        this.f64921a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.txt_bank_name);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.txt_bank_name)");
        this.f64922b = (TextView) findViewById2;
    }

    public final <T> void a(T t) {
        if (t != null && (t instanceof SectionWrapper)) {
            CJRPayChannelOptions childSections = ((SectionWrapper) t).getChildSections();
            if (childSections != null && !TextUtils.isEmpty(childSections.getIconUrl())) {
                w.a().a(childSections.getIconUrl()).a(this.f64921a);
            }
            this.f64922b.setText(childSections.getChannelName());
            View view = this.itemView;
            k.a((Object) view, "itemView");
            view.setTag(t);
            this.itemView.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        if (view != null && !e.INSTANCE.validateIsAlreadyClicked(view) && (view.getTag() instanceof SectionWrapper)) {
            j.a aVar = this.f64923c;
            Object tag = view.getTag();
            if (tag != null) {
                CJRPayChannelOptions childSections = ((SectionWrapper) tag).getChildSections();
                k.a((Object) childSections, "(v.tag as SectionWrapper).childSections");
                aVar.a(childSections);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.SectionWrapper");
        }
    }
}
