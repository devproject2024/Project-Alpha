package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.d.d;

public final class o extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(View view, d.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
    }

    public final void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, Context context) {
        LinearLayout linearLayout;
        CJRUtilityAttributesV2 attributes;
        k.c(cJRUtilityVariantV2, "variant");
        k.c(context, "context");
        View view = this.itemView;
        k.a((Object) view, "itemView");
        TextView textView = (TextView) view.findViewById(R.id.name_value_tv);
        k.a((Object) textView, "itemView.name_value_tv");
        textView.setText(cJRUtilityVariantV2.getDisplayName());
        View view2 = this.itemView;
        k.a((Object) view2, "itemView");
        TextView textView2 = (TextView) view2.findViewById(R.id.desc_value_tv);
        k.a((Object) textView2, "itemView.desc_value_tv");
        CJRUtilityFilterAttributesV2 attributes2 = cJRUtilityVariantV2.getAttributes();
        String str = null;
        textView2.setText(attributes2 != null ? attributes2.getDescription() : null);
        w a2 = w.a();
        CJRUtilityProductV2 product = cJRUtilityVariantV2.getProduct();
        if (!(product == null || (attributes = product.getAttributes()) == null)) {
            str = attributes.getIcon();
        }
        aa a3 = a2.a(str);
        View view3 = this.itemView;
        k.a((Object) view3, "itemView");
        a3.a((ImageView) view3.findViewById(R.id.circular_iv));
        View view4 = this.itemView;
        if (view4 != null && (linearLayout = (LinearLayout) view4.findViewById(R.id.ticket_options)) != null) {
            linearLayout.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f63519a;

        a(o oVar) {
            this.f63519a = oVar;
        }

        public final void onClick(View view) {
            d.a aVar = this.f63519a.f63456a;
            if (aVar != null) {
                aVar.a(this.f63519a.getAdapterPosition());
            }
        }
    }
}
