package net.one97.paytm.recharge.presentation.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel;
import net.one97.paytm.recharge.presentation.d.b;

public final class e extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final b f64855a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f64856b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f64857c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.d.a f64858d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, b bVar, net.one97.paytm.recharge.presentation.d.a aVar) {
        super(view);
        k.c(view, "itemView");
        this.f64855a = bVar;
        this.f64858d = aVar;
        this.f64856b = (TextView) view.findViewById(R.id.tv_activation_text);
        this.f64857c = (TextView) view.findViewById(R.id.tv_activate);
    }

    public final <T> void a(T t) {
        if (t instanceof CJRAutomaticSubscriptionItemModel) {
            View findViewById = this.itemView.findViewById(R.id.txt_name);
            k.a((Object) findViewById, "itemView.findViewById<TextView>(R.id.txt_name)");
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) t;
            ((TextView) findViewById).setText(TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname()) ? cJRAutomaticSubscriptionItemModel.getRechargeNumber() : cJRAutomaticSubscriptionItemModel.getNickname());
            if (TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname())) {
                View findViewById2 = this.itemView.findViewById(R.id.txt_operator_number);
                k.a((Object) findViewById2, "itemView.findViewById<Te…R.id.txt_operator_number)");
                ((TextView) findViewById2).setVisibility(8);
            } else {
                View findViewById3 = this.itemView.findViewById(R.id.txt_operator_number);
                k.a((Object) findViewById3, "itemView.findViewById<Te…R.id.txt_operator_number)");
                ((TextView) findViewById3).setVisibility(0);
                View findViewById4 = this.itemView.findViewById(R.id.txt_operator_number);
                k.a((Object) findViewById4, "itemView.findViewById<Te…R.id.txt_operator_number)");
                ((TextView) findViewById4).setText(cJRAutomaticSubscriptionItemModel.getRechargeNumber());
            }
            View findViewById5 = this.itemView.findViewById(R.id.txt_name_with_operator_number);
            k.a((Object) findViewById5, "itemView.findViewById<Te…ame_with_operator_number)");
            ((TextView) findViewById5).setText(cJRAutomaticSubscriptionItemModel.getOperatorNameWithCircle());
            View findViewById6 = this.itemView.findViewById(R.id.txt_last_bill_paid_msg);
            k.a((Object) findViewById6, "itemView.findViewById<Te…d.txt_last_bill_paid_msg)");
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            ((TextView) findViewById6).setText(cJRAutomaticSubscriptionItemModel.getAutomaticPaymentStatusMessage(context));
            w a2 = w.a();
            CJRAutomaticSubscriptionProductModel product = cJRAutomaticSubscriptionItemModel.getProduct();
            a2.a(product != null ? product.getThumbnail() : null).a((ImageView) this.itemView.findViewById(R.id.ic_operator_icon));
            if (cJRAutomaticSubscriptionItemModel.getStatus() == net.one97.paytm.recharge.automatic.b.a.b.DISABLED.getStatus()) {
                View findViewById7 = this.itemView.findViewById(R.id.tv_activate);
                k.a((Object) findViewById7, "itemView.findViewById<TextView>(R.id.tv_activate)");
                ((TextView) findViewById7).setVisibility(0);
            } else {
                View findViewById8 = this.itemView.findViewById(R.id.tv_activate);
                k.a((Object) findViewById8, "itemView.findViewById<TextView>(R.id.tv_activate)");
                ((TextView) findViewById8).setVisibility(8);
            }
            TextView textView = this.f64857c;
            k.a((Object) textView, "activateTxtVw");
            textView.setTag(t);
            TextView textView2 = this.f64857c;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            this.itemView.setOnClickListener(new a(this));
            if (cJRAutomaticSubscriptionItemModel.getStatus() == 6) {
                TextView textView3 = this.f64856b;
                k.a((Object) textView3, "activationTxtVw");
                ExtensionsKt.visible(textView3);
                return;
            }
            TextView textView4 = this.f64856b;
            k.a((Object) textView4, "activationTxtVw");
            ExtensionsKt.gone(textView4);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f64859a;

        a(e eVar) {
            this.f64859a = eVar;
        }

        public final void onClick(View view) {
            b bVar = this.f64859a.f64855a;
            if (bVar != null) {
                bVar.a(this.f64859a.getAdapterPosition());
            }
        }
    }

    public final void onClick(View view) {
        net.one97.paytm.recharge.presentation.d.a aVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_activate;
        if (valueOf != null && valueOf.intValue() == i2 && (view.getTag() instanceof CJRAutomaticSubscriptionItemModel) && (aVar = this.f64858d) != null) {
            Object tag = view.getTag();
            if (tag != null) {
                aVar.a((CJRAutomaticSubscriptionItemModel) tag, getAdapterPosition());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel");
        }
    }
}
