package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class m extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f30382a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30383b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30382a = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.f30383b = (TextView) view.findViewById(R.id.terms_text);
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        TextView textView;
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        RelativeLayout relativeLayout = this.f30382a;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new a(bVar, aVar));
        }
        if (orderSummaryBodyItem != null && (textView = this.f30383b) != null) {
            textView.setText(orderSummaryBodyItem.getLabel());
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f30384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30385b;

        a(b bVar, net.one97.travelpass.ordersummary.g.a aVar) {
            this.f30384a = bVar;
            this.f30385b = aVar;
        }

        public final void onClick(View view) {
            b bVar = this.f30384a;
            if (bVar != null) {
                b.a.a(bVar, this.f30385b, (Integer) null, 6);
            }
        }
    }
}
