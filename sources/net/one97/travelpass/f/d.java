package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class d extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30351a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30352b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30353c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f30354d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30351a = (ImageView) view.findViewById(R.id.trust_icon);
        this.f30352b = (TextView) view.findViewById(R.id.paytm_trust_text);
        this.f30353c = (TextView) view.findViewById(R.id.paytm_contact_us);
        this.f30354d = (LinearLayout) view.findViewById(R.id.contact_us_container);
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        CharSequence charSequence;
        CharSequence charSequence2;
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        String str = null;
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        String logo = orderSummaryBodyItem != null ? orderSummaryBodyItem.getLogo() : null;
        if (!(logo == null || context == null)) {
            b.a aVar2 = com.paytm.utility.b.b.f43744a;
            b.a.C0750a a3 = b.a.a(context);
            a3.f43753a = logo;
            Drawable a4 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
            if (a4 == null) {
                k.a();
            }
            k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a b2 = a3.b(a4);
            Drawable a5 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
            if (a5 == null) {
                k.a();
            }
            k.a((Object) a5, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a.a(b2.a((Object) a5), this.f30351a, (com.paytm.utility.b.b.b) null, 2);
        }
        TextView textView = this.f30352b;
        if (textView != null) {
            if ((orderSummaryBodyItem != null ? orderSummaryBodyItem.getFooterText() : null) != null) {
                charSequence2 = orderSummaryBodyItem != null ? orderSummaryBodyItem.getFooterText() : null;
            } else {
                charSequence2 = "";
            }
            textView.setText(charSequence2);
        }
        TextView textView2 = this.f30353c;
        if (textView2 != null) {
            if ((orderSummaryBodyItem != null ? orderSummaryBodyItem.getContactusText() : null) != null) {
                if (orderSummaryBodyItem != null) {
                    str = orderSummaryBodyItem.getContactusText();
                }
                charSequence = str;
            } else {
                charSequence = "";
            }
            textView2.setText(charSequence);
        }
        LinearLayout linearLayout = this.f30354d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new a(bVar, aVar));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.b f30355a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30356b;

        a(com.one97.travelpass.a.b bVar, net.one97.travelpass.ordersummary.g.a aVar) {
            this.f30355a = bVar;
            this.f30356b = aVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.b bVar = this.f30355a;
            if (bVar != null) {
                b.a.a(bVar, this.f30356b, (Integer) null, 6);
            }
        }
    }
}
