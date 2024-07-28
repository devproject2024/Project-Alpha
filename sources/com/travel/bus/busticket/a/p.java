package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.bus.R;
import com.travel.bus.pojo.mapmyindia.CJRMakeMyIndiaToken;
import com.travel.bus.pojo.mapmyindia.CJRSearchListLocation;
import com.travel.bus.pojo.mapmyindia.CJRSuggestedLocation;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.HashMap;

public final class p extends RecyclerView.a<b> implements com.paytm.network.listener.b {

    /* renamed from: e  reason: collision with root package name */
    private static final CharacterStyle f21721e = new StyleSpan(1);

    /* renamed from: a  reason: collision with root package name */
    Context f21722a;

    /* renamed from: b  reason: collision with root package name */
    Boolean f21723b = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    a f21724c;

    /* renamed from: d  reason: collision with root package name */
    private CJRMakeMyIndiaToken f21725d;

    /* renamed from: f  reason: collision with root package name */
    private String f21726f = "grant_type=";

    /* renamed from: g  reason: collision with root package name */
    private String f21727g = "&client_id=";

    /* renamed from: h  reason: collision with root package name */
    private String f21728h = "&client_secret=";

    /* renamed from: i  reason: collision with root package name */
    private String f21729i = "Authorization";
    /* access modifiers changed from: private */
    public CJRSearchListLocation j;
    private String k;
    private int l;

    public interface a {
        void a(CJRSuggestedLocation cJRSuggestedLocation, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        boolean z;
        b bVar = (b) vVar;
        if (this.j.getSuggestedLocations() == null || i2 > this.j.getSuggestedLocations().size()) {
            bVar.f21733b.setVisibility(8);
            bVar.f21734c.setVisibility(8);
            bVar.f21735d.setVisibility(8);
            bVar.f21736e.setVisibility(8);
            return;
        }
        bVar.f21733b.setText(this.j.getSuggestedLocations().get(i2).getPlaceName());
        bVar.f21734c.setText(this.j.getSuggestedLocations().get(i2).getPlaceAddress());
        bVar.f21733b.setVisibility(0);
        bVar.f21734c.setVisibility(0);
        bVar.f21735d.setVisibility(0);
        bVar.f21736e.setVisibility(8);
        if (this.j.getSuggestedLocations().get(i2).getPlaceName() != null && this.j.getSuggestedLocations().get(i2).getPlaceName().length() > 0) {
            String[] split = this.j.getSuggestedLocations().get(i2).getPlaceName().toString().split(" ");
            int i3 = 0;
            while (true) {
                z = true;
                if (i3 >= split.length) {
                    z = false;
                    break;
                } else if (split[i3].equalsIgnoreCase("bus") || split[i3].equalsIgnoreCase("busstand")) {
                    ResourceUtils.loadBusImagesFromCDN(bVar.f21735d, "ic_grey.png", false, false, n.a.V1);
                } else if (split[i3].equalsIgnoreCase("train") || split[i3].equalsIgnoreCase("railway") || split[i3].equalsIgnoreCase("metro")) {
                    ResourceUtils.loadBusImagesFromCDN(bVar.f21735d, "ic_train_grey.png", false, false, n.a.V1);
                } else if (split[i3].equalsIgnoreCase("flight") || split[i3].equalsIgnoreCase("airport")) {
                    ResourceUtils.loadBusImagesFromCDN(bVar.f21735d, "ic_flight_grey.png", false, false, n.a.V1);
                } else {
                    i3++;
                }
            }
            if (!z) {
                ResourceUtils.loadBusImagesFromCDN(bVar.f21735d, "ic_location_grey.png", false, false, n.a.V1);
            }
        }
        bVar.f21732a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                p.this.f21724c.a(p.this.j.getSuggestedLocations().get(i2), i2);
            }
        });
    }

    public p(Context context, int i2) {
        this.f21722a = context;
        this.l = i2;
        this.f21724c = (a) this.f21722a;
    }

    public final void a() {
        CJRSearchListLocation cJRSearchListLocation = this.j;
        if (cJRSearchListLocation != null && cJRSearchListLocation.getSuggestedLocations().size() > 0) {
            this.j.getSuggestedLocations().clear();
        }
    }

    public final void a(String str) {
        this.k = str;
        if (this.f21725d != null) {
            b();
            return;
        }
        com.travel.bus.a.a();
        if (com.travel.bus.a.b().a("isBusBPDPLocationViewVisible", false)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            com.travel.bus.a.a();
            String b2 = com.travel.bus.a.b().b("mmi_client_id");
            com.travel.bus.a.a();
            String str2 = this.f21726f + "client_credentials" + this.f21727g + b2 + this.f21728h + com.travel.bus.a.b().c("mmi_client_secret");
            com.travel.bus.a.a();
            String e2 = com.travel.bus.a.b().e("mmi_oauth_token");
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f21722a;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = e2;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = str2;
            bVar.v = "application/x-www-form-urlencoded";
            bVar.f42885i = new CJRMakeMyIndiaToken();
            bVar.j = this;
            bVar.n = a.b.SILENT;
            bVar.o = "bus-review-page";
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.f42860d = true;
            l2.a();
        }
    }

    private void b() {
        com.travel.bus.a.a();
        if (com.travel.bus.a.b().a("isBusBPDPLocationViewVisible", false)) {
            com.travel.bus.a.a();
            HashMap hashMap = new HashMap();
            hashMap.put(this.f21729i, this.f21725d.getTokenType() + " " + this.f21725d.getAccessToken());
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f21722a;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = com.travel.bus.a.b().d("mmi_search_query") + this.k;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42885i = new CJRSearchListLocation();
            bVar.j = this;
            bVar.n = a.b.SILENT;
            bVar.o = "bus-review-page";
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.f42860d = true;
            l2.a();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRMakeMyIndiaToken) {
            this.f21725d = (CJRMakeMyIndiaToken) iJRPaytmDataModel;
            b();
        } else if (iJRPaytmDataModel instanceof CJRSearchListLocation) {
            this.j = (CJRSearchListLocation) iJRPaytmDataModel;
            notifyDataSetChanged();
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if ((iJRPaytmDataModel instanceof CJRMakeMyIndiaToken) && this.f21725d != null) {
            this.f21725d = null;
            a(this.k);
        }
    }

    public final int getItemCount() {
        CJRSearchListLocation cJRSearchListLocation = this.j;
        if (cJRSearchListLocation == null || cJRSearchListLocation.getSuggestedLocations() == null) {
            return 0;
        }
        return this.j.getSuggestedLocations().size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f21732a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21733b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21734c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f21735d;

        /* renamed from: e  reason: collision with root package name */
        public View f21736e;

        public b(View view) {
            super(view);
            this.f21732a = (RelativeLayout) view.findViewById(R.id.predicted_row);
            this.f21733b = (TextView) view.findViewById(R.id.address);
            this.f21734c = (TextView) view.findViewById(R.id.address2);
            this.f21735d = (ImageView) view.findViewById(R.id.predicted_location_image);
            this.f21736e = view.findViewById(R.id.greyView);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(((LayoutInflater) this.f21722a.getSystemService("layout_inflater")).inflate(this.l, viewGroup, false));
    }
}
