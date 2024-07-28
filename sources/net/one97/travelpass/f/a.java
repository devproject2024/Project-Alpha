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

public final class a extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30338a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30339b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30340c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30341d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f30342e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f30343f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30338a = (ImageView) view.findViewById(R.id.item1_image);
        this.f30339b = (ImageView) view.findViewById(R.id.item2_img);
        this.f30340c = (TextView) view.findViewById(R.id.item1_tv);
        this.f30341d = (TextView) view.findViewById(R.id.item2_tv);
        this.f30342e = (LinearLayout) view.findViewById(R.id.item1_container);
        this.f30343f = (LinearLayout) view.findViewById(R.id.item2_container);
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, com.one97.travelpass.a.b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        if (orderSummaryBodyItem != null && context != null) {
            TextView textView = this.f30340c;
            if (textView != null) {
                textView.setText(orderSummaryBodyItem != null ? orderSummaryBodyItem.getSubCatLine() : null);
            }
            b.a aVar2 = com.paytm.utility.b.b.f43744a;
            b.a.C0750a a3 = b.a.a(context);
            a3.f43753a = orderSummaryBodyItem.getSubCategoryIcon();
            Drawable a4 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
            if (a4 == null) {
                k.a();
            }
            k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a.a(a3.b(a4), this.f30338a, (com.paytm.utility.b.b.b) null, 2);
            TextView textView2 = this.f30341d;
            if (textView2 != null) {
                textView2.setText(orderSummaryBodyItem != null ? orderSummaryBodyItem.getMypassesText() : null);
            }
            b.a aVar3 = com.paytm.utility.b.b.f43744a;
            b.a.C0750a a5 = b.a.a(context);
            a5.f43753a = orderSummaryBodyItem.getMypassesIcon();
            Drawable a6 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
            if (a6 == null) {
                k.a();
            }
            k.a((Object) a6, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
            b.a.C0750a.a(a5.b(a6), this.f30339b, (com.paytm.utility.b.b.b) null, 2);
            LinearLayout linearLayout = this.f30342e;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new C0513a(bVar, aVar));
            }
            LinearLayout linearLayout2 = this.f30343f;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new b(bVar, aVar));
            }
        }
    }

    /* renamed from: net.one97.travelpass.f.a$a  reason: collision with other inner class name */
    static final class C0513a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.b f30344a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30345b;

        C0513a(com.one97.travelpass.a.b bVar, net.one97.travelpass.ordersummary.g.a aVar) {
            this.f30344a = bVar;
            this.f30345b = aVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.b bVar = this.f30344a;
            net.one97.travelpass.ordersummary.g.a aVar = this.f30345b;
            net.one97.travelpass.ui.a aVar2 = net.one97.travelpass.ui.a.f30575a;
            b.a.a(bVar, aVar, Integer.valueOf(net.one97.travelpass.ui.a.e()), 2);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.b f30346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30347b;

        b(com.one97.travelpass.a.b bVar, net.one97.travelpass.ordersummary.g.a aVar) {
            this.f30346a = bVar;
            this.f30347b = aVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.b bVar = this.f30346a;
            net.one97.travelpass.ordersummary.g.a aVar = this.f30347b;
            net.one97.travelpass.ui.a aVar2 = net.one97.travelpass.ui.a.f30575a;
            b.a.a(bVar, aVar, Integer.valueOf(net.one97.travelpass.ui.a.f()), 2);
        }
    }
}
