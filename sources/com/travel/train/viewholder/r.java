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

public final class r extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    private CJRPNRStatusMeta f28210a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f28211b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f28212c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f28213d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f28214e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f28215f;

    /* renamed from: g  reason: collision with root package name */
    private CJRPNRPAXInformation f28216g;

    /* renamed from: h  reason: collision with root package name */
    private Context f28217h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(View view, CJRPNRStatusMeta cJRPNRStatusMeta) {
        super(view);
        k.c(view, "itemView");
        k.c(cJRPNRStatusMeta, "pnrMeta");
        Context context = view.getContext();
        k.a((Object) context, "itemView.context");
        this.f28217h = context;
        View findViewById = view.findViewById(R.id.txt_passengerName);
        k.a((Object) findViewById, "itemView.findViewById(R.id.txt_passengerName)");
        this.f28211b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.txt_berth_no);
        k.a((Object) findViewById2, "itemView.findViewById(R.id.txt_berth_no)");
        this.f28212c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.txt_coach_no);
        k.a((Object) findViewById3, "itemView.findViewById(R.id.txt_coach_no)");
        this.f28213d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.txt_seatStatus);
        k.a((Object) findViewById4, "itemView.findViewById(R.id.txt_seatStatus)");
        this.f28214e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.txt_berth_type);
        k.a((Object) findViewById5, "itemView.findViewById(R.id.txt_berth_type)");
        this.f28215f = (TextView) findViewById5;
        this.f28210a = cJRPNRStatusMeta;
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        k.c(iJRDataModel, "traveller");
        this.f28216g = (CJRPNRPAXInformation) iJRDataModel;
        CJRPNRPAXInformation cJRPNRPAXInformation = this.f28216g;
        if (cJRPNRPAXInformation == null) {
            k.a("travellerInfo");
        }
        if (p.a(cJRPNRPAXInformation.getmCurrentBerthNo(), "0", true)) {
            CJRPNRPAXInformation cJRPNRPAXInformation2 = this.f28216g;
            if (cJRPNRPAXInformation2 == null) {
                k.a("travellerInfo");
            }
            if (TextUtils.isEmpty(cJRPNRPAXInformation2.getmCurrentCoachId())) {
                TextView textView = this.f28211b;
                CJRPNRPAXInformation cJRPNRPAXInformation3 = this.f28216g;
                if (cJRPNRPAXInformation3 == null) {
                    k.a("travellerInfo");
                }
                textView.setText(cJRPNRPAXInformation3.getmPassengerName());
                TextView textView2 = this.f28212c;
                CJRPNRPAXInformation cJRPNRPAXInformation4 = this.f28216g;
                if (cJRPNRPAXInformation4 == null) {
                    k.a("travellerInfo");
                }
                textView2.setText(cJRPNRPAXInformation4.getmBookingBirthNo());
                TextView textView3 = this.f28213d;
                CJRPNRPAXInformation cJRPNRPAXInformation5 = this.f28216g;
                if (cJRPNRPAXInformation5 == null) {
                    k.a("travellerInfo");
                }
                textView3.setText(cJRPNRPAXInformation5.getmBookingCoachId());
                TextView textView4 = this.f28215f;
                CJRPNRPAXInformation cJRPNRPAXInformation6 = this.f28216g;
                if (cJRPNRPAXInformation6 == null) {
                    k.a("travellerInfo");
                }
                textView4.setText(a(cJRPNRPAXInformation6.getmBookingBirthCode()));
                TextView textView5 = this.f28214e;
                CJRPNRPAXInformation cJRPNRPAXInformation7 = this.f28216g;
                if (cJRPNRPAXInformation7 == null) {
                    k.a("travellerInfo");
                }
                textView5.setText(b(cJRPNRPAXInformation7.getmBookingStatus()));
                return;
            }
        }
        TextView textView6 = this.f28211b;
        CJRPNRPAXInformation cJRPNRPAXInformation8 = this.f28216g;
        if (cJRPNRPAXInformation8 == null) {
            k.a("travellerInfo");
        }
        textView6.setText(cJRPNRPAXInformation8.getmPassengerName());
        TextView textView7 = this.f28212c;
        CJRPNRPAXInformation cJRPNRPAXInformation9 = this.f28216g;
        if (cJRPNRPAXInformation9 == null) {
            k.a("travellerInfo");
        }
        textView7.setText(cJRPNRPAXInformation9.getmCurrentBerthNo());
        TextView textView8 = this.f28213d;
        CJRPNRPAXInformation cJRPNRPAXInformation10 = this.f28216g;
        if (cJRPNRPAXInformation10 == null) {
            k.a("travellerInfo");
        }
        textView8.setText(cJRPNRPAXInformation10.getmCurrentCoachId());
        TextView textView9 = this.f28215f;
        CJRPNRPAXInformation cJRPNRPAXInformation11 = this.f28216g;
        if (cJRPNRPAXInformation11 == null) {
            k.a("travellerInfo");
        }
        textView9.setText(a(cJRPNRPAXInformation11.getCurrentBerthCode()));
        TextView textView10 = this.f28214e;
        CJRPNRPAXInformation cJRPNRPAXInformation12 = this.f28216g;
        if (cJRPNRPAXInformation12 == null) {
            k.a("travellerInfo");
        }
        textView10.setText(b(cJRPNRPAXInformation12.getmCurrentStatus()));
    }

    private final String a(String str) {
        CJRPNRStatusMeta cJRPNRStatusMeta;
        String str2 = "";
        if (!(TextUtils.isEmpty(str) || (cJRPNRStatusMeta = this.f28210a) == null || cJRPNRStatusMeta.getmBerths() == null)) {
            for (Map.Entry next : this.f28210a.getmBerths().entrySet()) {
                String str3 = (String) next.getValue();
                if (p.a(str, (String) next.getKey(), true)) {
                    k.a((Object) str3, "value");
                    str2 = str3;
                }
            }
        }
        return str2;
    }

    private final String b(String str) {
        CJRPNRStatusMeta cJRPNRStatusMeta;
        String str2 = "";
        if (!(TextUtils.isEmpty(str) || (cJRPNRStatusMeta = this.f28210a) == null || cJRPNRStatusMeta.getBookingStatusMap() == null)) {
            for (Map.Entry next : this.f28210a.getBookingStatusMap().entrySet()) {
                String str3 = (String) next.getValue();
                if (p.a(str, (String) next.getKey(), true)) {
                    k.a((Object) str3, "value");
                    str2 = str3;
                }
            }
        }
        return str2;
    }
}
