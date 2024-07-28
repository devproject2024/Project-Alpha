package net.one97.paytm.recharge.common.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public final class d extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, w.b bVar, List<? extends CJRBrowsePlanProductList> list) {
        super(view, bVar, list);
        k.c(view, "view");
        k.c(bVar, "mItemClickListner");
        k.c(list, "productList");
    }

    public final void a(int i2, CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "product");
        super.a(i2, cJRBrowsePlanProductList);
        View view = this.f61032a;
        k.a((Object) view, "divider");
        view.setVisibility(8);
        LinearLayout linearLayout = this.f61033b;
        k.a((Object) linearLayout, "parentContainerOfDataSmsTalkTime");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.f61034c;
        k.a((Object) linearLayout2, "layout_only_description");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = this.f61036e;
        k.a((Object) linearLayout3, "talkTimeWithValidityLayout");
        linearLayout3.setVisibility(0);
        TextView textView = this.f61035d;
        k.a((Object) textView, "talkTimeValidityWithoutTitle");
        textView.setVisibility(8);
    }
}
