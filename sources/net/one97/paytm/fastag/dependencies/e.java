package net.one97.paytm.fastag.dependencies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRTrackingParams;
import net.one97.paytm.fastag.ui.activity.FasTagPostPaymentActivity;

public class e extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13671a = e.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private k f13672b;

    /* renamed from: c  reason: collision with root package name */
    private View f13673c = null;

    /* renamed from: d  reason: collision with root package name */
    private CJROrderSummary f13674d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f13675e;

    /* renamed from: f  reason: collision with root package name */
    private String f13676f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13677g;

    /* renamed from: h  reason: collision with root package name */
    private NestedScrollView f13678h;

    /* renamed from: i  reason: collision with root package name */
    private String f13679i;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CJRAddress cJRAddress;
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13674d = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13677g = arguments.getBoolean("contact_us_key");
                this.f13679i = arguments.getString("order_item_id");
                this.f13672b = new m(getActivity(), this.f13674d.getId(), this.f13679i);
                FasTagPostPaymentActivity fasTagPostPaymentActivity = (FasTagPostPaymentActivity) getActivity();
                a aVar = new a(fasTagPostPaymentActivity, fasTagPostPaymentActivity);
                aVar.a(this.f13674d);
                this.f13672b.a(aVar);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        CJROrderedCart cJROrderedCart = null;
        this.f13673c = layoutInflater.inflate(R.layout.lyt_auto_cancelled_item_ft, (ViewGroup) null);
        this.f13678h = (NestedScrollView) this.f13673c.findViewById(R.id.scroll_view);
        if (getActivity() != null) {
            this.f13675e = getActivity().getResources().getString(R.string.seller_to_courier);
            this.f13676f = getActivity().getResources().getString(R.string.courier_to_you);
        }
        CJROrderSummary cJROrderSummary = this.f13674d;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        int i2 = 0;
        while (true) {
            if (i2 >= orderedCartList.size()) {
                break;
            }
            if (this.f13679i.equalsIgnoreCase(String.valueOf(orderedCartList.get(i2).getId()))) {
                cJROrderedCart = orderedCartList.get(i2);
                break;
            }
            i2++;
        }
        if (this.f13672b != null) {
            this.f13672b.b(cJROrderedCart, this.f13673c.findViewById(R.id.item_detail_auto_cancelled_item_card));
            this.f13672b.a(cJROrderedCart, this.f13673c.findViewById(R.id.item_detail_seller_card), true);
            LinearLayout linearLayout = (LinearLayout) this.f13673c.findViewById(R.id.generic_actions_container);
            CJRCards cards = cJROrderedCart.getCards();
            if (cards != null) {
                linearLayout.setTag(cJROrderedCart);
                this.f13672b.a(cJROrderSummary, cards.getGeneric(), (ViewGroup) linearLayout, cJROrderedCart.getErrorActions());
                View findViewById = this.f13673c.findViewById(R.id.seller_card_container);
                k kVar = this.f13672b;
                kVar.a(cJROrderSummary, cards, kVar.a(), findViewById);
            } else {
                linearLayout.setVisibility(8);
            }
            this.f13672b.c(cJROrderedCart, this.f13673c.findViewById(R.id.item_detail_promo_card));
            CJRTrackingParams trackingParams = cJROrderedCart.getTrackingParams();
            if (!(trackingParams == null || (cJRAddress = trackingParams.getmReturnAddress()) == null)) {
                this.f13672b.a(cJRAddress, this.f13673c.findViewById(R.id.item_detail_delivery_address_card));
            }
            this.f13672b.d(cJROrderedCart, this.f13673c.findViewById(R.id.item_detail_refund_desc_card));
            View findViewById2 = this.f13673c.findViewById(R.id.exchange_card_layout);
            this.f13672b.e(cJROrderedCart, findViewById2);
            findViewById2.setVisibility(8);
            View findViewById3 = this.f13673c.findViewById(R.id.item_detail_zero_cost_emi_card);
            if (cJROrderSummary.getIsZeroEMIOrder() == 0) {
                findViewById3.setVisibility(8);
            } else {
                this.f13672b.f(cJROrderedCart, findViewById3);
            }
        }
        return this.f13673c;
    }

    public static e a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void onResume() {
        super.onResume();
    }
}
