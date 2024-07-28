package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class f extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30359a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30360b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30361c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30362d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.status_image_view);
        if (imageView != null) {
            this.f30359a = imageView;
            TextView textView = (TextView) view.findViewById(R.id.booking_confirmation_text);
            if (textView != null) {
                this.f30360b = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.booking_confirmation_text_desc);
                if (textView2 != null) {
                    this.f30361c = textView2;
                    TextView textView3 = (TextView) view.findViewById(R.id.retry_tv);
                    if (textView3 != null) {
                        this.f30362d = textView3;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        if (orderSummaryBodyItem != null) {
            if (orderSummaryBodyItem.getStatusMessage() != null) {
                this.f30361c.setText(orderSummaryBodyItem.getStatusMessage());
            }
            if (orderSummaryBodyItem.getStatus() != null) {
                this.f30360b.setText(orderSummaryBodyItem.getStatus());
            }
            if (aVar.f()) {
                this.f30362d.setVisibility(0);
                this.f30362d.setOnClickListener(new a(bVar, aVar, i2));
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f30363a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30364b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30365c;

        a(b bVar, net.one97.travelpass.ordersummary.g.a aVar, int i2) {
            this.f30363a = bVar;
            this.f30364b = aVar;
            this.f30365c = i2;
        }

        public final void onClick(View view) {
            b bVar = this.f30363a;
            if (bVar != null) {
                net.one97.travelpass.ordersummary.g.a aVar = this.f30364b;
                Integer.valueOf(this.f30365c);
                net.one97.travelpass.ui.a aVar2 = net.one97.travelpass.ui.a.f30575a;
                bVar.a(aVar, Integer.valueOf(net.one97.travelpass.ui.a.g()));
            }
        }
    }
}
