package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.j.t;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBenefits;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class o extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Context f24721a = this.f24724d;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends CJRInsuranceBenefits> f24722b = this.f24723c;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends CJRInsuranceBenefits> f24723c;

    /* renamed from: d  reason: collision with root package name */
    private Context f24724d;

    public o(List<? extends CJRInsuranceBenefits> list, Context context) {
        k.c(list, "data");
        k.c(context, "context");
        this.f24723c = list;
        this.f24724d = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f24721a).inflate(R.layout.flight_travel_insurance_benefit_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new t(inflate);
    }

    public final int getItemCount() {
        List<? extends CJRInsuranceBenefits> list = this.f24722b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        List<? extends CJRInsuranceBenefits> list = this.f24722b;
        if (list == null) {
            k.a();
        }
        CJRInsuranceBenefits cJRInsuranceBenefits = (CJRInsuranceBenefits) list.get(i2);
        if (vVar != null) {
            t tVar = (t) vVar;
            CharSequence imgUrl = cJRInsuranceBenefits.getImgUrl();
            boolean z = false;
            if (!(imgUrl == null || imgUrl.length() == 0)) {
                b.a aVar = b.f43744a;
                b.a.C0750a a2 = b.a.a(this.f24724d);
                a2.f43753a = cJRInsuranceBenefits.getImgUrl();
                b.a.C0750a.a(a2, tVar.f25211c, (com.paytm.utility.b.b.b) null, 2);
            }
            CharSequence type = cJRInsuranceBenefits.getType();
            if (!(type == null || type.length() == 0)) {
                tVar.f25209a.setText(cJRInsuranceBenefits.getType());
            }
            CharSequence text = cJRInsuranceBenefits.getText();
            if (!(text == null || text.length() == 0)) {
                String text2 = cJRInsuranceBenefits.getText();
                CharSequence amount = cJRInsuranceBenefits.getAmount();
                if (amount == null || amount.length() == 0) {
                    z = true;
                }
                if (!z) {
                    text2 = text2 + ' ' + cJRInsuranceBenefits.getAmount();
                }
                tVar.f25210b.setText("(" + text2 + ")");
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightticket.viewholders.CJRTravelInsuranceBenefitsViewHolder");
    }
}
