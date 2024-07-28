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
import net.one97.paytm.recharge.presentation.d.c;
import net.one97.paytm.recharge.widgets.c.e;

public final class i extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f64885a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f64886b;

    /* renamed from: c  reason: collision with root package name */
    private final String f64887c;

    /* renamed from: d  reason: collision with root package name */
    private final c f64888d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view, String str, c cVar) {
        super(view);
        k.c(view, "itemView");
        k.c(str, "paymentMode");
        this.f64887c = str;
        this.f64888d = cVar;
        this.f64885a = (ImageView) view.findViewById(R.id.ic_bank_logo);
        this.f64886b = (TextView) view.findViewById(R.id.txt_bank_name);
    }

    public final <T> void a(T t) {
        if (t != null && (t instanceof CJRPayChannelOptions)) {
            CJRPayChannelOptions cJRPayChannelOptions = (CJRPayChannelOptions) t;
            if (!TextUtils.isEmpty(cJRPayChannelOptions.getIconUrl())) {
                w.a().a(cJRPayChannelOptions.getIconUrl()).a(this.f64885a);
            }
            TextView textView = this.f64886b;
            k.a((Object) textView, "bankName");
            textView.setText(cJRPayChannelOptions.getChannelName());
            View view = this.itemView;
            k.a((Object) view, "itemView");
            view.setTag(t);
            this.itemView.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        c cVar;
        if (view != null && !e.INSTANCE.validateIsAlreadyClicked(view) && (view.getTag() instanceof CJRPayChannelOptions) && (cVar = this.f64888d) != null) {
            String str = this.f64887c;
            Object tag = view.getTag();
            if (tag != null) {
                cVar.a(str, (CJRPayChannelOptions) tag, true);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions");
        }
    }
}
