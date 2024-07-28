package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.activity.AJRTicketOptionsActivity;
import net.one97.paytm.recharge.metro.d.d;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public final class h extends d {

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f63485b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f63486c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view, d.a aVar, LayoutInflater layoutInflater) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(layoutInflater, "inflater");
        this.f63485b = layoutInflater;
        View findViewById = view.findViewById(R.id.ll_item_container);
        if (findViewById != null) {
            this.f63486c = (LinearLayout) findViewById;
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public final void a(CJRUtilityVariantV2 cJRUtilityVariantV2, List<? extends CJRActiveMetroTicketModel> list, Context context) {
        k.c(cJRUtilityVariantV2, "variant");
        k.c(context, "context");
        CJRMetroQRFrequentOrderList recentsOrder = cJRUtilityVariantV2.getRecentsOrder();
        if (recentsOrder != null) {
            int i2 = 8;
            if (recentsOrder.getmOrderList().size() > 0) {
                View view = this.itemView;
                k.a((Object) view, "itemView");
                TextView textView = (TextView) view.findViewById(R.id.recent_tv);
                k.a((Object) textView, "itemView.recent_tv");
                textView.setVisibility(0);
                AJRTicketOptionsActivity.a aVar = AJRTicketOptionsActivity.f63243a;
                if (AJRTicketOptionsActivity.E) {
                    View view2 = this.itemView;
                    k.a((Object) view2, "itemView");
                    TextView textView2 = (TextView) view2.findViewById(R.id.view_more);
                    k.a((Object) textView2, "itemView.view_more");
                    textView2.setVisibility(0);
                } else {
                    View view3 = this.itemView;
                    k.a((Object) view3, "itemView");
                    TextView textView3 = (TextView) view3.findViewById(R.id.view_more);
                    k.a((Object) textView3, "itemView.view_more");
                    textView3.setVisibility(8);
                }
            }
            List<CJRMetroQRFrequentOrder> list2 = recentsOrder.getmOrderList();
            k.a((Object) list2, "it.getmOrderList()");
            int size = list2.size();
            int i3 = 0;
            while (i3 < size) {
                View inflate = this.f63485b.inflate(R.layout.recent_journey_item, (ViewGroup) null, false);
                View findViewById = inflate.findViewById(R.id.product_type);
                if (findViewById != null) {
                    TextView textView4 = (TextView) findViewById;
                    View findViewById2 = inflate.findViewById(R.id.buy_again);
                    if (findViewById2 != null) {
                        TextView textView5 = (TextView) findViewById2;
                        View findViewById3 = inflate.findViewById(R.id.source_dest_journey);
                        if (findViewById3 != null) {
                            TextView textView6 = (TextView) findViewById3;
                            View findViewById4 = inflate.findViewById(R.id.last_purchase_tv);
                            if (findViewById4 != null) {
                                TextView textView7 = (TextView) findViewById4;
                                View findViewById5 = inflate.findViewById(R.id.separator);
                                if (findViewById5 != null) {
                                    String value = c.e.SVP.getValue();
                                    CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder = recentsOrder.getmOrderList().get(i3);
                                    k.a((Object) cJRMetroQRFrequentOrder, "it.getmOrderList()[i]");
                                    if (value.equals(cJRMetroQRFrequentOrder.getProductType())) {
                                        textView6.setVisibility(i2);
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder2 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder2, "it.getmOrderList()[i]");
                                        if (!TextUtils.isEmpty(cJRMetroQRFrequentOrder2.getRechargeAmount())) {
                                            View view4 = this.itemView;
                                            k.a((Object) view4, "itemView");
                                            Context context2 = view4.getContext();
                                            int i4 = R.string.recharge_rs;
                                            CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder3 = recentsOrder.getmOrderList().get(i3);
                                            k.a((Object) cJRMetroQRFrequentOrder3, "it.getmOrderList()[i]");
                                            textView5.setText(context2.getString(i4, new Object[]{cJRMetroQRFrequentOrder3.getRechargeAmount()}));
                                        }
                                    } else {
                                        c.a aVar2 = c.f63576a;
                                        View view5 = this.itemView;
                                        k.a((Object) view5, "itemView");
                                        Context context3 = view5.getContext();
                                        k.a((Object) context3, "itemView.context");
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder4 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder4, "it.getmOrderList()[i]");
                                        String productType = cJRMetroQRFrequentOrder4.getProductType();
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder5 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder5, "it.getmOrderList()[i]");
                                        CJRMetroStationModel source = cJRMetroQRFrequentOrder5.getSource();
                                        k.a((Object) source, "it.getmOrderList()[i].source");
                                        String name = source.getName();
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder6 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder6, "it.getmOrderList()[i]");
                                        CJRMetroStationModel destination = cJRMetroQRFrequentOrder6.getDestination();
                                        k.a((Object) destination, "it.getmOrderList()[i].destination");
                                        textView6.setText(c.a.a(context3, productType, name, destination.getName(), "", false));
                                    }
                                    textView5.setVisibility(0);
                                    textView5.setOnClickListener(new a(recentsOrder, i3, this));
                                    CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder7 = recentsOrder.getmOrderList().get(i3);
                                    k.a((Object) cJRMetroQRFrequentOrder7, "it.getmOrderList()[i]");
                                    if (!TextUtils.isEmpty(cJRMetroQRFrequentOrder7.getCreatedDescription())) {
                                        textView7.setVisibility(0);
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder8 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder8, "it.getmOrderList()[i]");
                                        textView7.setText(cJRMetroQRFrequentOrder8.getCreatedDescription());
                                    }
                                    CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder9 = recentsOrder.getmOrderList().get(i3);
                                    k.a((Object) cJRMetroQRFrequentOrder9, "it.getmOrderList()[i]");
                                    if (!TextUtils.isEmpty(cJRMetroQRFrequentOrder9.getProductLabel())) {
                                        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder10 = recentsOrder.getmOrderList().get(i3);
                                        k.a((Object) cJRMetroQRFrequentOrder10, "it.getmOrderList()[i]");
                                        textView4.setText(cJRMetroQRFrequentOrder10.getProductLabel());
                                    }
                                    if (i3 == recentsOrder.getmOrderList().size() - 1) {
                                        findViewById5.setVisibility(4);
                                    }
                                    this.f63486c.addView(inflate, i3);
                                    i3++;
                                    i2 = 8;
                                } else {
                                    throw new u("null cannot be cast to non-null type android.view.View");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
            View view6 = this.itemView;
            k.a((Object) view6, "itemView");
            ((TextView) view6.findViewById(R.id.view_more)).setOnClickListener(new b(this));
            this.f63486c.setVisibility(0);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMetroQRFrequentOrderList f63487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f63488b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f63489c;

        a(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList, int i2, h hVar) {
            this.f63487a = cJRMetroQRFrequentOrderList;
            this.f63488b = i2;
            this.f63489c = hVar;
        }

        public final void onClick(View view) {
            d.a aVar = this.f63489c.f63456a;
            if (aVar != null) {
                CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder = this.f63487a.getmOrderList().get(this.f63488b);
                k.a((Object) cJRMetroQRFrequentOrder, "it.getmOrderList()[i]");
                aVar.a(cJRMetroQRFrequentOrder);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63490a;

        b(h hVar) {
            this.f63490a = hVar;
        }

        public final void onClick(View view) {
            d.a aVar = this.f63490a.f63456a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
