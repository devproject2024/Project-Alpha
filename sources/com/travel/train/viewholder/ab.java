package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.b;
import com.travel.train.model.trainticket.CJRPNRPAXInformation;
import com.travel.train.model.trainticket.CJRPNRStatusMeta;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ab extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private CJRPNRStatusMeta f27753a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27754b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27755c;

    /* renamed from: d  reason: collision with root package name */
    private CJRPNRPAXInformation f27756d;

    /* renamed from: e  reason: collision with root package name */
    private Context f27757e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(View view, CJRPNRStatusMeta cJRPNRStatusMeta) {
        super(view);
        k.c(view, "itemView");
        k.c(cJRPNRStatusMeta, "pnrMeta");
        Context context = view.getContext();
        k.a((Object) context, "itemView.context");
        this.f27757e = context;
        View findViewById = view.findViewById(R.id.txt_passengerName);
        k.a((Object) findViewById, "itemView.findViewById(R.id.txt_passengerName)");
        this.f27754b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.txt_seatStatus);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.txt_seatStatus)");
        this.f27755c = (TextView) findViewById2;
        this.f27753a = cJRPNRStatusMeta;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        CJRPNRStatusMeta cJRPNRStatusMeta;
        k.c(iJRDataModel, "traveller");
        this.f27756d = (CJRPNRPAXInformation) iJRDataModel;
        TextView textView = this.f27754b;
        CJRPNRPAXInformation cJRPNRPAXInformation = this.f27756d;
        if (cJRPNRPAXInformation == null) {
            k.a("travellerInfo");
        }
        textView.setText(cJRPNRPAXInformation.getmPassengerName());
        CJRPNRPAXInformation cJRPNRPAXInformation2 = this.f27756d;
        if (cJRPNRPAXInformation2 == null) {
            k.a("travellerInfo");
        }
        if (p.a(cJRPNRPAXInformation2.getmCurrentStatus(), "CAN", true)) {
            TextView textView2 = this.f27755c;
            CJRPNRPAXInformation cJRPNRPAXInformation3 = this.f27756d;
            if (cJRPNRPAXInformation3 == null) {
                k.a("travellerInfo");
            }
            String str = cJRPNRPAXInformation3.getmCurrentStatus();
            String str2 = "";
            if (!(TextUtils.isEmpty(str) || (cJRPNRStatusMeta = this.f27753a) == null || cJRPNRStatusMeta.getBookingStatusMap() == null)) {
                for (Map.Entry next : this.f27753a.getBookingStatusMap().entrySet()) {
                    String str3 = (String) next.getValue();
                    if (p.a(str, (String) next.getKey(), true)) {
                        k.a((Object) str3, "value");
                        str2 = str3;
                    }
                }
            }
            textView2.setText(str2);
            return;
        }
        this.f27755c.setText(this.f27757e.getResources().getString(R.string.emptyFeed));
    }
}
