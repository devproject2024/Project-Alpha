package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class b extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30348a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.paytm_banner);
        if (imageView != null) {
            this.f30348a = imageView;
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, com.one97.travelpass.a.b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        String travelPassImageUrl = orderSummaryBodyItem != null ? orderSummaryBodyItem.getTravelPassImageUrl() : null;
        if (travelPassImageUrl != null && context != null) {
            b.a aVar2 = com.paytm.utility.b.b.f43744a;
            b.a.C0750a a3 = b.a.a(context);
            a3.f43753a = travelPassImageUrl;
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
            b.a.C0750a.a(b2.a((Object) a5), this.f30348a, (com.paytm.utility.b.b.b) null, 2);
        }
    }
}
