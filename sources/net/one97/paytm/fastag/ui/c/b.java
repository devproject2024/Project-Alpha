package net.one97.paytm.fastag.ui.c;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.paytm.network.b.h;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.widgets.CJRVolleyImageView;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.dependencies.a;
import net.one97.paytm.fastag.dependencies.i;
import net.one97.paytm.fastag.dependencies.l;
import net.one97.paytm.fastag.f.g;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryAction;
import net.one97.paytm.fastag.model.CJROrderedCart;

public class b extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13888b = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13889a;

    /* renamed from: c  reason: collision with root package name */
    private g f13890c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i f13891d;

    /* renamed from: e  reason: collision with root package name */
    private View f13892e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJROrderSummary f13893f = null;

    /* renamed from: g  reason: collision with root package name */
    private NestedScrollView f13894g;

    /* renamed from: h  reason: collision with root package name */
    private String f13895h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnClickListener f13896i = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == R.id.rnr) {
                Object tag = view.getTag();
                if (tag instanceof CJROrderedCart) {
                    CJROrderedCart cJROrderedCart = (CJROrderedCart) tag;
                    b.this.f13891d.a(b.this.f13893f, cJROrderedCart, b.b(cJROrderedCart.getAction()));
                    return;
                }
                return;
            }
            view.getId();
            int i2 = R.id.item_detail_item_image;
        }
    };

    public static b a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13893f = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13889a = arguments.getBoolean("contact_us_key");
                this.f13895h = arguments.getString("order_item_id");
                this.f13890c = new g(getActivity(), this.f13893f.getId(), this.f13895h);
                a aVar = new a((l) getActivity(), getActivity());
                aVar.a(this.f13893f);
                this.f13890c.a(aVar);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        CJROrderedCart cJROrderedCart = null;
        this.f13892e = layoutInflater.inflate(R.layout.fragment_post_payment_ft, (ViewGroup) null);
        this.f13894g = (NestedScrollView) this.f13892e.findViewById(R.id.scroll_view);
        this.f13894g.setNestedScrollingEnabled(false);
        CJROrderSummary cJROrderSummary = this.f13893f;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        int i2 = 0;
        while (true) {
            if (i2 >= orderedCartList.size()) {
                break;
            }
            if (this.f13895h.equalsIgnoreCase(String.valueOf(orderedCartList.get(i2).getId()))) {
                cJROrderedCart = orderedCartList.get(i2);
                break;
            }
            i2++;
        }
        View findViewById = this.f13892e.findViewById(R.id.lyt_item_delivered_card);
        findViewById.findViewById(R.id.delivered_item_name);
        CJRVolleyImageView cJRVolleyImageView = (CJRVolleyImageView) findViewById.findViewById(R.id.item_detail_item_image);
        cJROrderedCart.getName();
        String statusText = cJROrderedCart.getStatusText();
        String thumbnail = cJROrderedCart.getProductDetail().getThumbnail();
        ((TextView) findViewById.findViewById(R.id.delivered_status_text)).setText(Html.fromHtml(statusText));
        cJRVolleyImageView.setResponseObserver(new CJRVolleyImageView.a() {
        });
        cJRVolleyImageView.setImageUrl(thumbnail, h.INSTANCE.getImageLoader());
        cJRVolleyImageView.setOnClickListener(this.f13896i);
        if (b(cJROrderedCart.getAction()) != null) {
            View findViewById2 = this.f13892e.findViewById(R.id.lyt_item_delivered_card);
            View findViewById3 = findViewById2.findViewById(R.id.rnr_container);
            findViewById3.setVisibility(0);
            View findViewById4 = findViewById2.findViewById(R.id.rnr);
            findViewById3.setVisibility(8);
            findViewById4.setTag(cJROrderedCart);
            findViewById4.setOnClickListener(this.f13896i);
        }
        g gVar = this.f13890c;
        if (gVar != null) {
            this.f13891d = gVar.a();
            LinearLayout linearLayout = (LinearLayout) this.f13892e.findViewById(R.id.generic_actions_container);
            CJRCards cards = cJROrderedCart.getCards();
            if (cards != null) {
                linearLayout.setTag(cJROrderedCart);
                this.f13890c.a(cJROrderSummary, cards.getGeneric(), (ViewGroup) linearLayout, cJROrderedCart.getErrorActions());
                View findViewById5 = this.f13892e.findViewById(R.id.seller_card_container);
                g gVar2 = this.f13890c;
                gVar2.a(cJROrderSummary, cards, gVar2.a(), findViewById5);
            } else {
                linearLayout.setVisibility(8);
            }
            this.f13890c.a(cJROrderedCart, this.f13892e.findViewById(R.id.item_detail_promo_card));
            this.f13890c.b(cJROrderedCart, this.f13892e.findViewById(R.id.exchange_card_layout));
        }
        return this.f13892e;
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public static CJROrderSummaryAction b(ArrayList<CJROrderSummaryAction> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<CJROrderSummaryAction> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJROrderSummaryAction next = it2.next();
            if ("Replace_Item".equals(next.getActionName())) {
                return next;
            }
        }
        return null;
    }
}
