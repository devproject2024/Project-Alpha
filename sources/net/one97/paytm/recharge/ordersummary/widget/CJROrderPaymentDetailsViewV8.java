package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJROrderedCartInfoObj;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeOrderPaymentDetailsView;
import net.one97.paytm.recharge.ordersummary.widget.CJRFailedPendingOrderDetailsView;
import net.one97.paytm.recharge.widgets.c.d;

public final class CJROrderPaymentDetailsViewV8 extends CJRBaseRechargeOrderPaymentDetailsView {

    /* renamed from: a  reason: collision with root package name */
    protected RecyclerView f64456a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f64457b;

    public final View a(int i2) {
        if (this.f64457b == null) {
            this.f64457b = new HashMap();
        }
        View view = (View) this.f64457b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64457b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(CJRBaseRechargeOrderPaymentDetailsView.a aVar) {
        k.c(aVar, "holder");
    }

    public final RecyclerView.h getItemDecorator() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJROrderPaymentDetailsViewV8(Context context, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart) {
        super(context, aVar, cJROrderedCart, true, false);
        k.c(context, "context");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedCart");
    }

    /* access modifiers changed from: protected */
    public final RecyclerView getRvPaymentDetails() {
        RecyclerView recyclerView = this.f64456a;
        if (recyclerView == null) {
            k.a("rvPaymentDetails");
        }
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public final void setRvPaymentDetails(RecyclerView recyclerView) {
        k.c(recyclerView, "<set-?>");
        this.f64456a = recyclerView;
    }

    public final int getLayoutResId() {
        return R.layout.v8_content_os_payment_details;
    }

    public final void a() {
        String str;
        setBackgroundColor(-1);
        setPadding(0, 0, 0, b.c(17));
        CJROrderSummary cJROrderSummary = getViewModel().f63998b;
        if (cJROrderSummary == null) {
            k.a();
        }
        net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
        Context context = getContext();
        k.a((Object) context, "context");
        String h2 = viewModel.h(context);
        TextView textView = (TextView) a(R.id.operator_name);
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
            Context context2 = getContext();
            k.a((Object) context2, "context");
            textView.setText(viewModel2.k(context2, getOrderedCart()));
        }
        CJRAmountView cJRAmountView = (CJRAmountView) a(R.id.recharge_amount);
        if (cJRAmountView != null) {
            cJRAmountView.setText(h2);
        }
        d dVar = d.f64967a;
        double c2 = d.c(h2);
        CJRFailedPendingOrderDetailsView.a aVar = CJRFailedPendingOrderDetailsView.f64385a;
        Context context3 = getContext();
        k.a((Object) context3, "context");
        o<Double, ArrayList<o<String, Double>>> a2 = CJRFailedPendingOrderDetailsView.a.a(context3, getViewModel());
        double doubleValue = c2 + a2.getFirst().doubleValue();
        ArrayList second = a2.getSecond();
        RecyclerView recyclerView = (RecyclerView) a(R.id.other_items_recycler);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.other_items_recycler);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.other_items_recycler);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(new a(second));
        }
        double d2 = 0.0d;
        for (CJROrderedCart cJROrderedCart : getViewModel().k) {
            d dVar2 = d.f64967a;
            CJROrderedCartInfoObj infoObject = cJROrderedCart.getInfoObject();
            if (infoObject == null || (str = infoObject.getPgCf()) == null) {
                str = cJROrderedCart.getConvFee();
            }
            if (str == null) {
                str = "";
            }
            double c3 = d.c(str);
            if (c3 >= 0.0d) {
                d2 += c3;
            }
        }
        if (2 == cJROrderSummary.getOrderStatus()) {
            if (!second.isEmpty()) {
                if (d2 > 0.0d) {
                    CJRAmountView cJRAmountView2 = (CJRAmountView) a(R.id.convenience_fee);
                    if (cJRAmountView2 != null) {
                        cJRAmountView2.setText(getContext().getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(d2), true)}));
                    }
                    ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.container_other_items);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    TextView textView2 = (TextView) a(R.id.convenience_fee_txt);
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    CJRAmountView cJRAmountView3 = (CJRAmountView) a(R.id.convenience_fee);
                    if (cJRAmountView3 != null) {
                        cJRAmountView3.setVisibility(0);
                    }
                    doubleValue += d2;
                }
                CJRAmountView cJRAmountView4 = (CJRAmountView) a(R.id.total_amount);
                if (cJRAmountView4 != null) {
                    cJRAmountView4.setText(getContext().getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(doubleValue), true)}));
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.container_other_items);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
            } else if (d2 > 0.0d && second.isEmpty()) {
                CJRAmountView cJRAmountView5 = (CJRAmountView) a(R.id.convenience_fee);
                if (cJRAmountView5 != null) {
                    cJRAmountView5.setText(getContext().getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(d2), true)}));
                }
                ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.container_other_items);
                if (constraintLayout3 != null) {
                    constraintLayout3.setVisibility(0);
                }
                TextView textView3 = (TextView) a(R.id.convenience_fee_txt);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                CJRAmountView cJRAmountView6 = (CJRAmountView) a(R.id.convenience_fee);
                if (cJRAmountView6 != null) {
                    cJRAmountView6.setVisibility(0);
                }
                double d3 = doubleValue + d2;
                TextView textView4 = (TextView) a(R.id.header_other_items);
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                RecyclerView recyclerView4 = (RecyclerView) a(R.id.other_items_recycler);
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(8);
                }
                View a3 = a(R.id.details_divider_top);
                if (a3 != null) {
                    a3.setVisibility(8);
                }
                CJRAmountView cJRAmountView7 = (CJRAmountView) a(R.id.total_amount);
                if (cJRAmountView7 != null) {
                    cJRAmountView7.setText(getContext().getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(d3), true)}));
                }
                ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.container_other_items);
                if (constraintLayout4 != null) {
                    constraintLayout4.setVisibility(0);
                }
            }
        }
        View findViewById = findViewById(R.id.recycler_view);
        k.a((Object) findViewById, "findViewById(R.id.recycler_view)");
        this.f64456a = (RecyclerView) findViewById;
    }

    public static final class a extends RecyclerView.a<CJRFailedPendingOrderDetailsView.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f64458a;

        a(ArrayList arrayList) {
            this.f64458a = arrayList;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            CJRFailedPendingOrderDetailsView.b bVar = (CJRFailedPendingOrderDetailsView.b) vVar;
            k.c(bVar, "holder");
            Object obj = this.f64458a.get(i2);
            k.a(obj, "otherItems[position]");
            bVar.a((o) obj);
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_order_details_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ails_item, parent, false)");
            return new CJRFailedPendingOrderDetailsView.b(inflate);
        }

        public final int getItemCount() {
            return this.f64458a.size();
        }
    }

    public final int getAdapterLayout() {
        return R.layout.v8_content_os_payment_details_item;
    }

    public final void a(CJRBaseRechargeOrderPaymentDetailsView.a aVar, CJROrderSummaryPayment cJROrderSummaryPayment, int i2) {
        k.c(aVar, "holder");
        k.c(cJROrderSummaryPayment, "payMode");
        super.a(aVar, cJROrderSummaryPayment, i2);
        RecyclerView recyclerView = this.f64456a;
        if (recyclerView == null) {
            k.a("rvPaymentDetails");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            k.a();
        }
        k.a((Object) adapter, "rvPaymentDetails.adapter!!");
        if (i2 == adapter.getItemCount() - 1) {
            View findViewById = aVar.itemView.findViewById(R.id.divider);
            k.a((Object) findViewById, "divider");
            findViewById.setVisibility(4);
        }
    }

    public final String a(Context context, CJROrderSummaryPayment cJROrderSummaryPayment) {
        k.c(context, "context");
        k.c(cJROrderSummaryPayment, "payMode");
        String string = context.getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(cJROrderSummaryPayment.getPgAmount()), true)});
        k.a((Object) string, "context.getString(R.stri…Amount.toString(), true))");
        return string;
    }
}
