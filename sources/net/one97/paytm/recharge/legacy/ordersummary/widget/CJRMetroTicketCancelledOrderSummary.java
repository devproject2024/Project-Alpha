package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRMetroTicketCancelledOrderSummary extends CJRFailedOrderSummary {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMetroTicketCancelledOrderSummary(Context context, ViewGroup viewGroup, int i2, int i3, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, r rVar, View.OnClickListener onClickListener, a aVar) {
        super(context, viewGroup, i2, i3, cJROrderSummary, cJROSActionResponseV2, rVar, onClickListener, aVar);
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "viewModel");
    }

    /* access modifiers changed from: protected */
    public final void c() {
        String str;
        CJROrderSummaryActionURLParams urlParams;
        String url;
        CJROrderedCart cJROrderedCart;
        CJROrderedCart cJROrderedCart2;
        CJROrderSummaryProductDetail productDetail;
        TextView description = getDescription();
        if (description != null) {
            a viewModel = getViewModel();
            Context context = getContext();
            k.a((Object) context, "context");
            description.setText(viewModel.F(context));
        }
        View findViewById = findViewById(R.id.message_layout);
        k.a((Object) findViewById, "findViewById<View>(R.id.message_layout)");
        findViewById.setVisibility(8);
        TextView title = getTitle();
        a viewModel2 = getViewModel();
        Context context2 = getContext();
        k.a((Object) context2, "context");
        title.setText(viewModel2.C(context2));
        c cVar = c.f62654a;
        if (!c.as()) {
            findViewById(R.id.need_help).setOnClickListener((View.OnClickListener) null);
            View findViewById2 = findViewById(R.id.need_help);
            k.a((Object) findViewById2, "findViewById<View>(R.id.need_help)");
            findViewById2.setVisibility(8);
        }
        d();
        r rechargeOrderSummaryInteractionListener = getRechargeOrderSummaryInteractionListener();
        Intent intent = rechargeOrderSummaryInteractionListener != null ? rechargeOrderSummaryInteractionListener.getIntent() : null;
        String stringExtra = intent != null ? intent.getStringExtra("reference_id") : null;
        boolean z = true;
        if (!TextUtils.isEmpty(stringExtra)) {
            str = getContext().getString(R.string.metro_mumbai_ticket_referenceid, new Object[]{stringExtra});
            k.a((Object) str, "context.getString(R.stri…icket_referenceid, refId)");
        } else {
            str = "";
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) findViewById(R.id.order_id);
            textView.setText(charSequence);
            textView.setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.order_id)).setVisibility(8);
            ArrayList<CJROrderedCart> orderedCartList = getOrderSummary().getOrderedCartList();
            Long valueOf = (orderedCartList == null || (cJROrderedCart2 = orderedCartList.get(0)) == null || (productDetail = cJROrderedCart2.getProductDetail()) == null) ? null : Long.valueOf(productDetail.getId());
            ArrayList<CJROrderedCart> orderedCartList2 = getOrderSummary().getOrderedCartList();
            CJROrderSummaryAction tapAction = (orderedCartList2 == null || (cJROrderedCart = orderedCartList2.get(0)) == null) ? null : cJROrderedCart.getTapAction();
            c cVar2 = c.f62654a;
            if (!(!kotlin.a.k.a(c.aI(), valueOf) || tapAction == null || (urlParams = tapAction.getUrlParams()) == null || (url = urlParams.getUrl()) == null)) {
                if (url.length() != 0) {
                    z = false;
                }
                if (!z) {
                    b.a aVar = b.f64312h;
                    Context context3 = getContext();
                    k.a((Object) context3, "context");
                    b a2 = b.a.a(context3);
                    d dVar = d.f64967a;
                    a2.a("tap_action", tapAction, d.a((ACTION_TYPE) null, (ERROR_TYPE) null), this);
                }
            }
        }
        Context context4 = getContext();
        if (!(context4 instanceof AJRechargeOrderSummaryActivity)) {
            context4 = null;
        }
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) context4;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.b();
        }
    }

    /* access modifiers changed from: protected */
    public final Integer[] getLateInflatingViewIds() {
        c cVar = c.f62654a;
        if (!c.as()) {
            return new Integer[]{Integer.valueOf(R.id.order_id)};
        }
        return new Integer[]{Integer.valueOf(R.id.order_id), Integer.valueOf(R.id.need_help)};
    }

    /* access modifiers changed from: protected */
    public final void d() {
        TextView description;
        CharSequence refundDetails = getRefundDetails();
        if (!TextUtils.isEmpty(refundDetails) && (description = getDescription()) != null) {
            description.setText(refundDetails);
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        String str2;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJROSActionResponseV2 cJROSActionResponseV2 = (CJROSActionResponseV2) iJRPaytmDataModel;
            List<CJRActiveMetroTicketModel> a2 = c.a.a((List<? extends CJRActiveMetroTicketModel>) cJROSActionResponseV2.getTickets(), (List<? extends CJRActiveMetroTicketModel>) cJROSActionResponseV2.getPasses());
            if (a2 != null && !a2.isEmpty()) {
                try {
                    if (a2.get(0).getQrCodes() != null) {
                        CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = a2.get(0).getQrCodes().get(0);
                        k.a((Object) cJRActiveMetroTicketQRItemModel, "activeMetroTickets.get(0).qrCodes.get(0)");
                        str2 = cJRActiveMetroTicketQRItemModel.getOperatorRefId();
                        k.a((Object) str2, "activeMetroTickets.get(0…odes.get(0).operatorRefId");
                    } else {
                        str2 = a2.get(0).getPassId();
                        k.a((Object) str2, "activeMetroTickets.get(0).passId");
                    }
                    String string = getContext().getString(R.string.metro_mumbai_ticket_referenceid, new Object[]{str2});
                    k.a((Object) string, "context.getString(R.stri…icket_referenceid, refId)");
                    if (!TextUtils.isEmpty(string)) {
                        View findViewById = findViewById(R.id.order_id);
                        k.a((Object) findViewById, "(findViewById<TextView>(R.id.order_id))");
                        ((TextView) findViewById).setText(string);
                    }
                } catch (Exception unused) {
                }
            }
        }
        super.a_(str, iJRPaytmDataModel, obj);
    }
}
