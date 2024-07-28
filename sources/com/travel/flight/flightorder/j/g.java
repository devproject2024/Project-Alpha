package com.travel.flight.flightorder.j;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightorder.c.a;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.j.g;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;

public final class g extends com.travel.flight.flightorder.f.a {

    /* renamed from: a  reason: collision with root package name */
    public a f24487a;

    /* renamed from: b  reason: collision with root package name */
    com.travel.flight.flightorder.g.a f24488b;

    /* renamed from: c  reason: collision with root package name */
    Activity f24489c;

    /* renamed from: d  reason: collision with root package name */
    int f24490d;

    /* renamed from: e  reason: collision with root package name */
    public CJROrderSummaryAction f24491e;

    /* renamed from: f  reason: collision with root package name */
    private Context f24492f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f24493g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJROrderSummaryAction> f24494h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24495i;
    private com.travel.flight.flightorder.g.b j;
    private View k;

    public g(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar, Activity activity, com.travel.flight.flightorder.g.b bVar) {
        super(view);
        this.f24492f = view.getContext();
        this.f24495i = cJRFlightOrderSummaryResponse;
        this.f24488b = aVar;
        this.f24489c = activity;
        this.j = bVar;
        this.f24493g = (RecyclerView) view.findViewById(R.id.horizontal_list_view_train_download_ticket);
        this.f24493g.setLayoutManager(new LinearLayoutManager(this.f24492f, 0, false));
        this.k = view.findViewById(R.id.devider_view);
    }

    public final void a(b.C0467b bVar) {
        ArrayList<CJROrderSummaryAction> action;
        boolean z;
        boolean z2;
        ArrayList<CJROrderSummaryItems> items = this.f24495i.getBody().getItems();
        for (int i2 = 0; i2 < items.size(); i2++) {
            CJROrderSummaryItems cJROrderSummaryItems = items.get(i2);
            int i3 = 1;
            if (!(cJROrderSummaryItems == null || (action = cJROrderSummaryItems.getAction()) == null || action.size() <= 0)) {
                for (int i4 = 0; i4 < action.size(); i4++) {
                    CJROrderSummaryAction cJROrderSummaryAction = action.get(i4);
                    if (cJROrderSummaryAction.getLabel().equals("Share Ticket")) {
                        this.j.e();
                    }
                    if (((cJROrderSummaryAction.getLabel() != null && cJROrderSummaryAction.getLabel().equalsIgnoreCase("Invoice")) || ((cJROrderSummaryAction.getLabel() != null && cJROrderSummaryAction.getLabel().equalsIgnoreCase("download ticket")) || ((cJROrderSummaryAction.getLabel() != null && cJROrderSummaryAction.getLabel().equalsIgnoreCase(Item.CTA_URL_TYPE_DOWNLOAD)) || ((cJROrderSummaryAction.getLabel() != null && cJROrderSummaryAction.getLabel().equalsIgnoreCase("Cancel")) || (cJROrderSummaryAction.getLabel() != null && cJROrderSummaryAction.getLabel().equalsIgnoreCase("modify")))))) && cJROrderSummaryAction != null) {
                        String label = cJROrderSummaryAction.getLabel();
                        Iterator<CJROrderSummaryAction> it2 = this.f24494h.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().getLabel().equalsIgnoreCase(label)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (cJROrderSummaryAction.getOrderLevel() == null) {
                            z2 = false;
                        } else {
                            z2 = cJROrderSummaryAction.getOrderLevel().booleanValue();
                        }
                        if (!z && z2) {
                            this.f24494h.add(cJROrderSummaryAction);
                        }
                    }
                }
            }
            if (this.f24494h.size() != 1) {
                i3 = this.f24494h.size() == 2 ? 2 : 3;
            }
            this.f24490d = i3;
        }
        ArrayList<CJROrderSummaryAction> arrayList = this.f24494h;
        if (arrayList == null || arrayList.size() <= 0) {
            this.k.setVisibility(8);
            return;
        }
        this.f24487a = new a(this.f24494h);
        this.f24493g.setAdapter(this.f24487a);
        this.f24487a.notifyDataSetChanged();
        this.k.setVisibility(0);
    }

    public class a extends RecyclerView.a<RecyclerView.v> {

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<CJROrderSummaryAction> f24497b;

        /* renamed from: c  reason: collision with root package name */
        private Context f24498c;

        /* renamed from: d  reason: collision with root package name */
        private String f24499d;

        public a(ArrayList<CJROrderSummaryAction> arrayList) {
            this.f24497b = arrayList;
        }

        public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_lyt_flight_download_ticket_item, viewGroup, false);
            int a2 = com.paytm.utility.b.a(g.this.f24489c) / g.this.f24490d;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_root);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = a2;
            linearLayout.setLayoutParams(layoutParams);
            return new b(inflate);
        }

        public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b bVar = (b) vVar;
            CJROrderSummaryAction cJROrderSummaryAction = this.f24497b.get(i2);
            com.travel.flight.flightorder.c.a aVar = com.travel.flight.flightorder.c.a.DOWNLOAD_TICKET_CLICK;
            if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getLabel() == null)) {
                if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Invoice")) {
                    aVar = com.travel.flight.flightorder.c.a.DOWNLOAD_TICKET_CLICK;
                    bVar.f24500a.setText("Download \n Ticket");
                } else if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Cancel")) {
                    bVar.f24500a.setText("Cancel \n Booking");
                } else if (cJROrderSummaryAction.getLabel().equalsIgnoreCase("Modify")) {
                    aVar = com.travel.flight.flightorder.c.a.MODIFY_TICKET_CLICK;
                    bVar.f24500a.setText("Modify \n Booking");
                } else {
                    String[] split = cJROrderSummaryAction.getLabel().split("\\s+");
                    int length = split.length;
                    if (length > 1) {
                        TextView textView = bVar.f24500a;
                        textView.setText(split[length - 2] + " \n" + split[length - 1]);
                    } else {
                        bVar.f24500a.setText(cJROrderSummaryAction.getLabel());
                    }
                }
            }
            bVar.f24502c.setOnClickListener(new View.OnClickListener(aVar, cJROrderSummaryAction) {
                private final /* synthetic */ a f$1;
                private final /* synthetic */ CJROrderSummaryAction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    g.a.this.a(this.f$1, this.f$2, view);
                }
            });
            if (cJROrderSummaryAction != null && cJROrderSummaryAction.getImage_url() != null) {
                this.f24499d = cJROrderSummaryAction.getImage_url();
                try {
                    if (URLUtil.isValidUrl(this.f24499d)) {
                        b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f24498c);
                        a2.f43753a = this.f24499d;
                        a2.a((Object) Integer.valueOf(R.drawable.pre_f_defaultcarrier)).b(Integer.valueOf(R.drawable.pre_f_defaultcarrier)).a(bVar.f24501b);
                        return;
                    }
                    ResourceUtils.loadFlightImagesFromCDN(bVar.f24501b, "download_invoice.png", false, false, n.a.V1);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(com.travel.flight.flightorder.c.a aVar, CJROrderSummaryAction cJROrderSummaryAction, View view) {
            a(aVar, cJROrderSummaryAction);
        }

        public final int getItemCount() {
            return this.f24497b.size();
        }

        public final void a(com.travel.flight.flightorder.c.a aVar, CJROrderSummaryAction cJROrderSummaryAction) {
            if (cJROrderSummaryAction != null) {
                g.this.f24488b.a(aVar, (IJRDataModel) cJROrderSummaryAction);
                g.this.f24491e = cJROrderSummaryAction;
            }
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f24500a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f24501b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f24502c;

        public b(View view) {
            super(view);
            this.f24500a = (TextView) view.findViewById(R.id.item_text);
            this.f24502c = (LinearLayout) view.findViewById(R.id.layout_root);
            this.f24501b = (ImageView) view.findViewById(R.id.item_image);
        }
    }
}
