package net.one97.paytm.fastag.dependencies;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.b;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryProductDetail;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRSellerCourierCard;
import net.one97.paytm.fastag.model.CJRStatusFlow;
import net.one97.paytm.fastag.model.CJRTrackingParams;
import net.one97.paytm.fastag.ui.activity.FasTagPostPaymentActivity;

public class f extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    private static final String f13680c = f.class.getName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13681a;

    /* renamed from: b  reason: collision with root package name */
    public a f13682b = a.SERVICIABLELessThan60NSSLessThan400NLMD;

    /* renamed from: d  reason: collision with root package name */
    private k f13683d;

    /* renamed from: e  reason: collision with root package name */
    private View f13684e = null;

    /* renamed from: f  reason: collision with root package name */
    private CJROrderSummary f13685f = null;

    /* renamed from: g  reason: collision with root package name */
    private NestedScrollView f13686g;

    /* renamed from: h  reason: collision with root package name */
    private String f13687h;

    public enum a {
        SERVICIABLELessThan60NSSLessThan400NLMD,
        SERVICIABLEGreater60,
        NSSGreaterThan400
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CJRAddress cJRAddress;
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13685f = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13681a = arguments.getBoolean("contact_us_key");
                this.f13687h = arguments.getString("order_item_id");
                this.f13683d = new m(getActivity(), this.f13685f.getId(), this.f13687h);
                FasTagPostPaymentActivity fasTagPostPaymentActivity = (FasTagPostPaymentActivity) getActivity();
                a aVar = new a(fasTagPostPaymentActivity, fasTagPostPaymentActivity);
                aVar.a(this.f13685f);
                this.f13683d.a(aVar);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        this.f13684e = layoutInflater.inflate(R.layout.lyt_returned_item_tracking_ft, (ViewGroup) null);
        this.f13686g = (NestedScrollView) this.f13684e.findViewById(R.id.scroll_view);
        final CJROrderSummary cJROrderSummary = this.f13685f;
        final CJROrderedCart a2 = a(cJROrderSummary.getOrderedCartList());
        if (this.f13683d != null) {
            this.f13683d.a(a2, this.f13684e.findViewById(R.id.item_detail_returned_item_card));
            this.f13683d.d(a2, this.f13684e.findViewById(R.id.item_detail_refund_desc_card));
            this.f13683d.a(a2, this.f13684e.findViewById(R.id.item_detail_seller_card), false);
            View findViewById = this.f13684e.findViewById(R.id.item_detail_delivery_address_card);
            LinearLayout linearLayout = (LinearLayout) this.f13684e.findViewById(R.id.return_steps_template);
            View findViewById2 = this.f13684e.findViewById(R.id.replacement_order_action);
            if (findViewById2 != null) {
                if (a2.hasReplacement()) {
                    findViewById2.setVisibility(0);
                    findViewById2.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (f.this.getActivity() != null) {
                                f.a(f.this, cJROrderSummary, "my_orders_view_replacement_order_clicked");
                                Intent intent = new Intent(f.this.getActivity(), net.one97.paytm.fastag.c.a.a().f13559b.getOrderDetailsActivity());
                                intent.putExtra("KEY_ORDER_ID_TO_TRACK", String.valueOf(a2.getChildOrderId()));
                                intent.putExtra("KEY_ITEM_ID_TO_TRACK", String.valueOf(a2.getChildItemId()));
                                f.this.getActivity().startActivity(intent);
                            }
                        }
                    });
                } else {
                    findViewById2.setVisibility(8);
                }
            }
            if (this.f13682b == a.NSSGreaterThan400) {
                findViewById.setVisibility(8);
                linearLayout.setVisibility(0);
                CJRTrackingParams trackingParams = a2.getTrackingParams();
                if (trackingParams != null) {
                    this.f13683d.a(trackingParams.getNextStep(), (ViewGroup) linearLayout, a2);
                }
            } else {
                CJRTrackingParams trackingParams2 = a2.getTrackingParams();
                if (!(trackingParams2 == null || (cJRAddress = trackingParams2.getmReturnAddress()) == null)) {
                    this.f13683d.a(cJRAddress, findViewById);
                }
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f13684e.findViewById(R.id.generic_actions_container);
            CJRCards cards = a2.getCards();
            if (cards != null) {
                linearLayout2.setTag(a2);
                this.f13683d.a(cJROrderSummary, cards.getGeneric(), (ViewGroup) linearLayout2, a2.getErrorActions());
                View findViewById3 = this.f13684e.findViewById(R.id.return_card_container);
                if (this.f13682b == a.SERVICIABLELessThan60NSSLessThan400NLMD || this.f13682b == a.NSSGreaterThan400) {
                    findViewById3.setVisibility(8);
                } else {
                    k kVar = this.f13683d;
                    kVar.a(cJROrderSummary, cards, kVar.a(), findViewById3);
                }
            } else {
                linearLayout2.setVisibility(8);
            }
        }
        return this.f13684e;
    }

    public static f a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onResume() {
        super.onResume();
    }

    private static String a(CJRSellerCourierCard cJRSellerCourierCard) {
        if (!(cJRSellerCourierCard == null || cJRSellerCourierCard.getStatusFlow() == null || cJRSellerCourierCard.getStatusFlow().size() <= 0)) {
            Iterator<CJRStatusFlow> it2 = cJRSellerCourierCard.getStatusFlow().iterator();
            while (it2.hasNext()) {
                CJRStatusFlow next = it2.next();
                if (next.ismIsCurrentStatus()) {
                    return next.getText();
                }
            }
        }
        return "";
    }

    private static String a(CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart == null || cJROrderedCart.getCards() == null) {
            return "";
        }
        String a2 = a(cJROrderedCart.getCards().getSellerCard());
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return a(cJROrderedCart.getCards().getCourierCard());
    }

    private CJROrderedCart a(ArrayList<CJROrderedCart> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (this.f13687h.equalsIgnoreCase(String.valueOf(arrayList.get(i2).getId()))) {
                return arrayList.get(i2);
            }
        }
        return null;
    }

    static /* synthetic */ void a(f fVar, CJROrderSummary cJROrderSummary, String str) {
        CJROrderedCart a2;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0 && fVar.getActivity() != null && (a2 = fVar.a(cJROrderSummary.getOrderedCartList())) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_details_item_state", a(a2));
            CJROrderSummaryProductDetail productDetail = a2.getProductDetail();
            if (productDetail != null) {
                hashMap.put("item_details_vertical_label", productDetail.getVertical() + "");
            }
            hashMap.put("item_details_order_id", cJROrderSummary.getId() + "");
            hashMap.put("item_details_item_id", a2.getId() + "");
            b bVar = net.one97.paytm.fastag.c.a.a().f13559b;
            bVar.sendCustomEventWithMap(str + "", hashMap, fVar.getActivity());
        }
    }
}
