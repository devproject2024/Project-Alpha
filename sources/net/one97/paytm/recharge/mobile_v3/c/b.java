package net.one97.paytm.recharge.mobile_v3.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.mobile_v3.model.CJRFooterRecyclerItemModelV3;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.c.e;

public final class b extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f63889a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f63890b;

    /* renamed from: c  reason: collision with root package name */
    public final View f63891c;

    /* renamed from: d  reason: collision with root package name */
    public Object f63892d;

    public enum a {
        FAQ,
        SCRATCH_CARD,
        SUPPORT,
        AUTO_PAY
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "itemView");
        View findViewById = view.findViewById(R.id.icon);
        this.f63889a = (ImageView) (!(findViewById instanceof ImageView) ? null : findViewById);
        View findViewById2 = view.findViewById(R.id.title);
        this.f63890b = (TextView) (!(findViewById2 instanceof TextView) ? null : findViewById2);
        View findViewById3 = view.findViewById(R.id.divider);
        this.f63891c = !(findViewById3 instanceof View) ? null : findViewById3;
    }

    public final void onClick(View view) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (!e.INSTANCE.validateIsAlreadyClicked("bottom_menu_item_clicked", H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY)) {
            Object tag = view != null ? view.getTag() : null;
            if (!(tag instanceof CJRFooterRecyclerItemModelV3)) {
                tag = null;
            }
            CJRFooterRecyclerItemModelV3 cJRFooterRecyclerItemModelV3 = (CJRFooterRecyclerItemModelV3) tag;
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            Context context = view2.getContext();
            if (cJRFooterRecyclerItemModelV3 != null) {
                if (cJRFooterRecyclerItemModelV3.getType() == a.FAQ) {
                    k.a((Object) context, "context");
                    d dVar = new d(context);
                    Object obj5 = this.f63892d;
                    if (obj5 == null) {
                        obj4 = "";
                    } else {
                        obj4 = obj5;
                    }
                    d.a(dVar, obj4, "faq_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                } else if (cJRFooterRecyclerItemModelV3.getType() == a.SCRATCH_CARD) {
                    k.a((Object) context, "context");
                    d dVar2 = new d(context);
                    Object obj6 = this.f63892d;
                    if (obj6 == null) {
                        obj3 = "";
                    } else {
                        obj3 = obj6;
                    }
                    d.a(dVar2, obj3, "scratch_card_offers_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                } else if (cJRFooterRecyclerItemModelV3.getType() == a.SUPPORT) {
                    k.a((Object) context, "context");
                    d dVar3 = new d(context);
                    Object obj7 = this.f63892d;
                    if (obj7 == null) {
                        obj2 = "";
                    } else {
                        obj2 = obj7;
                    }
                    d.a(dVar3, obj2, "customer_support_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                } else if (cJRFooterRecyclerItemModelV3.getType() == a.AUTO_PAY) {
                    k.a((Object) context, "context");
                    d dVar4 = new d(context);
                    Object obj8 = this.f63892d;
                    if (obj8 == null) {
                        obj = "";
                    } else {
                        obj = obj8;
                    }
                    d.a(dVar4, obj, "setup_autopay_clicked", "", "Bottom menu", (Object) null, (Object) null, (Object) null, 112);
                }
            }
            if (cJRFooterRecyclerItemModelV3 != null && !TextUtils.isEmpty(cJRFooterRecyclerItemModelV3.getDeeplink())) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                k.a((Object) context, "context");
                String deeplink = cJRFooterRecyclerItemModelV3.getDeeplink();
                if (deeplink == null) {
                    k.a();
                }
                cJRRechargeUtilities.launchDeeplink(context, deeplink, new CJRHomePageItem());
            }
        }
    }
}
