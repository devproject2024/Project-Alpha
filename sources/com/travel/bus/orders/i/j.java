package com.travel.bus.orders.i;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.i.j;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    Context f22731a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f22732b;

    /* renamed from: c  reason: collision with root package name */
    a f22733c;

    /* renamed from: d  reason: collision with root package name */
    CJRBusOrderSummary f22734d;

    /* renamed from: e  reason: collision with root package name */
    com.travel.bus.orders.f.a f22735e;

    /* renamed from: f  reason: collision with root package name */
    Activity f22736f;

    /* renamed from: g  reason: collision with root package name */
    int f22737g = 1;

    /* renamed from: h  reason: collision with root package name */
    boolean f22738h = false;

    /* renamed from: i  reason: collision with root package name */
    protected BusOrderSummary.a f22739i;

    public j(View view, CJRBusOrderSummary cJRBusOrderSummary, com.travel.bus.orders.f.a aVar, Activity activity, boolean z, BusOrderSummary.a aVar2) {
        this.f22731a = view.getContext();
        this.f22734d = cJRBusOrderSummary;
        this.f22735e = aVar;
        this.f22736f = activity;
        this.f22738h = z;
        this.f22739i = aVar2;
        this.f22732b = (RecyclerView) view.findViewById(R.id.horizontal_list_view_train_download_ticket);
        this.f22732b.setLayoutManager(new LinearLayoutManager(this.f22731a, 0, false));
    }

    public class a extends RecyclerView.a<RecyclerView.v> {

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<CJROrderSummaryAction> f22741b;

        /* JADX WARNING: type inference failed for: r2v0, types: [java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderSummaryAction>, net.one97.paytm.common.entity.shopping.CJROrderedCart] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(net.one97.paytm.common.entity.shopping.CJROrderedCart r2) {
            /*
                r0 = this;
                com.travel.bus.orders.i.j.this = r1
                r0.<init>()
                r0.f22741b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.j.a.<init>(com.travel.bus.orders.i.j, java.util.ArrayList):void");
        }

        public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_lyt_flight_download_ticket_item, viewGroup, false);
            int a2 = (com.paytm.utility.b.a(j.this.f22736f) - com.paytm.utility.b.a(35.0f, (Context) j.this.f22736f)) / j.this.f22737g;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_root);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = a2;
            linearLayout.setLayoutParams(layoutParams);
            return new b(inflate);
        }

        public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            CJROrderSummaryAction cJROrderSummaryAction = this.f22741b.get(i2);
            if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getLabel() == null)) {
                if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Invoice")) {
                    bVar.f22742a.setText(j.this.f22731a.getString(R.string.bus_order_summary_download_ticket));
                } else {
                    cJROrderSummaryAction.getLabel().split("\\s+");
                    bVar.f22742a.setText(cJROrderSummaryAction.getLabel());
                    bVar.f22742a.setSelected(true);
                }
            }
            bVar.f22743b.setOnClickListener(new View.OnClickListener(cJROrderSummaryAction) {
                private final /* synthetic */ CJROrderSummaryAction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    j.a.this.a(this.f$1, view);
                }
            });
        }

        public final int getItemCount() {
            return this.f22741b.size();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(CJROrderSummaryAction cJROrderSummaryAction, View view) {
            if (cJROrderSummaryAction != null) {
                if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Invoice") && j.this.f22738h) {
                    j jVar = j.this;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event_category", "bus_summary");
                    hashMap.put("event_action", "download_clicked");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-summary");
                    hashMap.put("vertical_name", "bus");
                    hashMap.put("user_id", com.paytm.utility.b.n(jVar.f22731a));
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, jVar.f22731a);
                }
                j.this.f22735e.a(com.travel.bus.orders.b.a.DOWNLOAD_TICKET_CLICK, cJROrderSummaryAction);
            }
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22742a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f22743b;

        public b(View view) {
            super(view);
            this.f22742a = (TextView) view.findViewById(R.id.item_text);
            this.f22743b = (LinearLayout) view.findViewById(R.id.layout_root);
        }
    }
}
