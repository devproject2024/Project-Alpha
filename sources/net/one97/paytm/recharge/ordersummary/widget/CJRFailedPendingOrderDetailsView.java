package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRAmountView;

public final class CJRFailedPendingOrderDetailsView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64385a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final CJROrderedCart f64386b;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64387c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f64388d = false;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f64389e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.f.b f64390f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64391g;

    private View a(int i2) {
        if (this.f64391g == null) {
            this.f64391g = new HashMap();
        }
        View view = (View) this.f64391g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64391g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final CJROrderedCart getOrderedItem() {
        return this.f64386b;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64387c;
    }

    public final boolean getShowOtherItemsExplicitly() {
        return this.f64388d;
    }

    public final boolean getShowOnlyItemDetails() {
        return this.f64389e;
    }

    public final net.one97.paytm.recharge.ordersummary.f.b getActionListener() {
        return this.f64390f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRFailedPendingOrderDetailsView(Context context, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, boolean z, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        super(context);
        CharSequence charSequence;
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        k.c(aVar, "viewModel");
        this.f64386b = cJROrderedCart;
        this.f64387c = aVar;
        this.f64389e = z;
        this.f64390f = bVar;
        LayoutInflater.from(context).inflate(R.layout.content_os_order_details, this, true);
        CJROrderSummary cJROrderSummary = this.f64387c.f63998b;
        if (cJROrderSummary == null) {
            k.a();
        }
        TextView textView = (TextView) a(R.id.header_order_details);
        if (textView != null) {
            if (this.f64389e) {
                charSequence = context.getString(R.string.v8_os_order_details_header_2);
            } else {
                charSequence = context.getString(R.string.v8_os_order_details_header_1);
            }
            textView.setText(charSequence);
        }
        if (this.f64389e) {
            TextView textView2 = (TextView) a(R.id.operator_name);
            if (textView2 != null) {
                textView2.setText(this.f64387c.c(context, this.f64386b));
            }
            TextView textView3 = (TextView) a(R.id.recharge_number);
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
            TextView textView4 = (TextView) a(R.id.operator_name);
            if (textView4 != null) {
                textView4.setText(this.f64387c.f(context, this.f64386b));
            }
            TextView textView5 = (TextView) a(R.id.recharge_number);
            if (textView5 != null) {
                textView5.setText(this.f64387c.h(context, this.f64386b));
            }
        }
        if (this.f64389e || this.f64387c.k.size() == 1) {
            CJRAmountView cJRAmountView = (CJRAmountView) a(R.id.recharge_amount);
            if (cJRAmountView != null) {
                cJRAmountView.setText(this.f64387c.g(context, this.f64386b));
            }
        } else {
            CJRAmountView cJRAmountView2 = (CJRAmountView) a(R.id.recharge_amount);
            if (cJRAmountView2 != null) {
                cJRAmountView2.setText(this.f64387c.h(context));
            }
        }
        TextView textView6 = (TextView) a(R.id.order_id);
        if (textView6 != null) {
            textView6.setText(this.f64387c.o(context));
        }
        String aggregateItemPrice = this.f64386b.getAggregateItemPrice();
        k.a((Object) aggregateItemPrice, "orderedItem.aggregateItemPrice");
        double parseDouble = Double.parseDouble(aggregateItemPrice);
        if (cJROrderSummary.getOrderStatus() != 2) {
            if (!this.f64389e && this.f64388d) {
                o<Double, ArrayList<o<String, Double>>> a2 = a.a(context, this.f64387c);
                double doubleValue = parseDouble + a2.getFirst().doubleValue();
                final ArrayList second = a2.getSecond();
                RecyclerView recyclerView = (RecyclerView) a(R.id.other_items_recycler);
                if (recyclerView != null) {
                    recyclerView.setNestedScrollingEnabled(false);
                }
                RecyclerView recyclerView2 = (RecyclerView) a(R.id.other_items_recycler);
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context));
                }
                RecyclerView recyclerView3 = (RecyclerView) a(R.id.other_items_recycler);
                if (recyclerView3 != null) {
                    recyclerView3.setAdapter(new RecyclerView.a<b>() {
                        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                            b bVar = (b) vVar;
                            k.c(bVar, "holder");
                            Object obj = second.get(i2);
                            k.a(obj, "otherItems[position]");
                            bVar.a((o) obj);
                        }

                        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                            k.c(viewGroup, "parent");
                            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_order_details_item, viewGroup, false);
                            k.a((Object) inflate, "LayoutInflater.from(pare…ails_item, parent, false)");
                            return new b(inflate);
                        }

                        public final int getItemCount() {
                            return second.size();
                        }
                    });
                }
                if (!second.isEmpty()) {
                    CJRAmountView cJRAmountView3 = (CJRAmountView) a(R.id.total_amount);
                    if (cJRAmountView3 != null) {
                        cJRAmountView3.setText(context.getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(doubleValue), true)}));
                    }
                    Group group = (Group) a(R.id.group_payment_details);
                    if (group != null) {
                        group.setVisibility(0);
                    }
                }
            }
        } else if (!this.f64389e && (!this.f64387c.v().isEmpty())) {
            TextView textView7 = (TextView) a(R.id.action_view_payment_details);
            View view = !(textView7 instanceof View) ? null : textView7;
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static o<Double, ArrayList<o<String, Double>>> a(Context context, net.one97.paytm.recharge.ordersummary.b.a aVar) {
            double d2;
            String str;
            String str2;
            CJRAttributes attributes;
            String str3;
            String str4;
            Context context2 = context;
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = aVar;
            k.c(context2, "context");
            k.c(aVar2, "viewModel");
            List<CJROrderedCart> list = aVar2.f64005i;
            List<CJROrderedCart> list2 = aVar2.j;
            List list3 = aVar2.l;
            ArrayList arrayList = new ArrayList(2);
            if (!list.isEmpty()) {
                if (list.size() == 1) {
                    str4 = context2.getString(R.string.v8_os_order_details_other_deals);
                } else {
                    str4 = context2.getString(R.string.v8_os_order_details_other_deals_multiple, new Object[]{Integer.valueOf(list.size())});
                }
                k.a((Object) str4, "if(deals.size==1) contex…als_multiple, deals.size)");
                double d3 = 0.0d;
                for (CJROrderedCart aggregateItemPrice : list) {
                    String aggregateItemPrice2 = aggregateItemPrice.getAggregateItemPrice();
                    k.a((Object) aggregateItemPrice2, "it.aggregateItemPrice");
                    d3 += Double.parseDouble(aggregateItemPrice2);
                }
                d2 = d3 + 0.0d;
                arrayList.add(new o(str4, Double.valueOf(d3)));
            } else {
                d2 = 0.0d;
            }
            if (!list2.isEmpty()) {
                if (list2.size() == 1) {
                    str3 = context2.getString(R.string.v8_os_order_details_other_insurances);
                } else {
                    str3 = context2.getString(R.string.v8_os_order_details_other_insurances_multiple, new Object[]{Integer.valueOf(list2.size())});
                }
                k.a((Object) str3, "if(insurances.size==1) c…ultiple, insurances.size)");
                double d4 = 0.0d;
                for (CJROrderedCart aggregateItemPrice3 : list2) {
                    String aggregateItemPrice4 = aggregateItemPrice3.getAggregateItemPrice();
                    k.a((Object) aggregateItemPrice4, "it.aggregateItemPrice");
                    d4 += Double.parseDouble(aggregateItemPrice4);
                }
                d2 += d4;
                arrayList.add(new o(str3, Double.valueOf(d4)));
            }
            Map linkedHashMap = new LinkedHashMap();
            for (Object next : list3) {
                CJROrderSummaryProductDetail productDetail = ((CJROrderedCart) next).getProductDetail();
                if (productDetail == null || (attributes = productDetail.getAttributes()) == null || (str2 = attributes.getPayTypeLabel()) == null) {
                    str2 = context2.getString(R.string.other_items);
                    k.a((Object) str2, "context.getString(R.string.other_items)");
                }
                Object obj = linkedHashMap.get(str2);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(str2, obj);
                }
                ((List) obj).add(next);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((List) entry.getValue()).size() == 1) {
                    str = (String) entry.getKey();
                } else {
                    str = ((String) entry.getKey()) + " (" + ((List) entry.getValue()).size() + ')';
                }
                double d5 = 0.0d;
                for (CJROrderedCart aggregateItemPrice5 : (Iterable) entry.getValue()) {
                    String aggregateItemPrice6 = aggregateItemPrice5.getAggregateItemPrice();
                    k.a((Object) aggregateItemPrice6, "item.aggregateItemPrice");
                    d5 += Double.parseDouble(aggregateItemPrice6);
                }
                d2 += d5;
                arrayList.add(new o(str, Double.valueOf(d5)));
            }
            return new o<>(Double.valueOf(d2), arrayList);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        TextView textView = (TextView) a(R.id.action_view_payment_details);
        k.a((Object) textView, "action_view_payment_details");
        int id = textView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            view.setClickable(false);
            view.setEnabled(false);
            net.one97.paytm.recharge.ordersummary.f.b bVar = this.f64390f;
            if (bVar != null) {
                bVar.a(this.f64387c, (DialogInterface.OnDismissListener) new c(view));
            }
        }
    }

    static final class c implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f64395a;

        c(View view) {
            this.f64395a = view;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f64395a.setClickable(true);
            this.f64395a.setEnabled(true);
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f64393a;

        /* renamed from: b  reason: collision with root package name */
        private final CJRAmountView f64394b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            this.f64393a = (TextView) view.findViewById(R.id.order_detail_item_name);
            this.f64394b = (CJRAmountView) view.findViewById(R.id.order_detail_item_amount);
        }

        public final void a(o<String, Double> oVar) {
            k.c(oVar, "pair");
            TextView textView = this.f64393a;
            k.a((Object) textView, "itemName");
            textView.setText(oVar.getFirst());
            if (oVar.getSecond().doubleValue() == 0.0d) {
                CJRAmountView cJRAmountView = this.f64394b;
                k.a((Object) cJRAmountView, "itemAmount");
                View view = this.itemView;
                k.a((Object) view, "itemView");
                cJRAmountView.setText(view.getContext().getString(R.string.recharge_deals_free));
                return;
            }
            this.f64394b.setText(ba.a(String.valueOf(oVar.getSecond().doubleValue()), true));
        }
    }
}
