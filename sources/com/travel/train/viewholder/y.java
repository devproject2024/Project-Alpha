package com.travel.train.viewholder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.helper.i;
import com.travel.train.i.g;
import com.travel.train.j.p;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class y extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public CheckBox f28289a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f28290b;

    /* renamed from: c  reason: collision with root package name */
    RoboTextView f28291c;

    /* renamed from: d  reason: collision with root package name */
    Context f28292d;

    /* renamed from: e  reason: collision with root package name */
    g f28293e;

    /* renamed from: f  reason: collision with root package name */
    i f28294f;

    /* renamed from: g  reason: collision with root package name */
    CJRTrainDetailsBody f28295g;

    /* renamed from: h  reason: collision with root package name */
    CJRTrainSearchResultsTrain f28296h;

    /* renamed from: i  reason: collision with root package name */
    CJRTrainAvailability f28297i;
    String j;
    String k;

    public y(View view, g gVar, CJRTrainDetailsBody cJRTrainDetailsBody, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, String str, String str2, i iVar) {
        super(view);
        this.f28292d = view.getContext();
        this.f28293e = gVar;
        this.f28294f = iVar;
        this.f28295g = cJRTrainDetailsBody;
        this.f28296h = cJRTrainSearchResultsTrain;
        this.j = str;
        this.k = str2;
        if (this.f28295g.getmTrainAvailability() != null && this.f28295g.getmTrainAvailability().size() > 0) {
            this.f28297i = this.f28295g.getmTrainAvailability().get(this.f28295g.getMiSelectedPosition());
        }
        this.f28289a = (CheckBox) view.findViewById(R.id.check_refundPolicy);
        this.f28290b = (RoboTextView) view.findViewById(R.id.text_train_refund_policy);
        this.f28291c = (RoboTextView) view.findViewById(R.id.tv_view);
        this.f28289a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    y.this.f28290b.setTextColor(y.this.f28292d.getResources().getColor(R.color.color_222222));
                } else {
                    y.this.f28290b.setTextColor(y.this.f28292d.getResources().getColor(R.color.color_666666));
                }
                y.this.f28294f.a("train_traveller_details_cancellations_clicked", y.this.f28294f.b(), (HashMap<String, Object>) null);
                i iVar = y.this.f28294f;
                String str = d.dp;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", b.n((Context) iVar.f27313a.e()) != null ? b.n((Context) iVar.f27313a.e()) : "");
                    if (z) {
                        hashMap.put(d.dg, CommonPayParams.Builder.YES);
                    } else {
                        hashMap.put(d.dg, CommonPayParams.Builder.NO);
                    }
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/traveller-details");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) iVar.f27313a.e());
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        });
        this.f28291c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                p pVar = new p((Activity) y.this.f28292d, y.this.f28291c, y.this.f28293e);
                String totalFare = (y.this.f28295g == null || y.this.f28295g.getTrainFare() == null || TextUtils.isEmpty(y.this.f28295g.getTrainFare().getTotalFare())) ? "" : y.this.f28295g.getTrainFare().getTotalFare();
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = y.this.f28296h;
                pVar.f27589b = cJRTrainSearchResultsTrain;
                if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getTrainType())) {
                    pVar.f27596i = cJRTrainSearchResultsTrain.getTrainType();
                }
                if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getTrainNumber())) {
                    pVar.f27595h = cJRTrainSearchResultsTrain.getTrainNumber();
                }
                pVar.f27590c = y.this.j;
                pVar.f27591d = y.this.k;
                pVar.f27592e = "CNF";
                String mSearchedTrainDepartureTime = y.this.f28296h.getMSearchedTrainDepartureTime();
                String d2 = y.this.f28293e.d();
                String a2 = n.a(pVar.f27588a, n.a());
                if (a2.equalsIgnoreCase("mr") || a2.equalsIgnoreCase("bn")) {
                    pVar.f27593f = p.a(pVar.f27588a, p.a(mSearchedTrainDepartureTime));
                } else {
                    pVar.f27593f = p.a(mSearchedTrainDepartureTime);
                }
                pVar.f27594g = d2;
                pVar.j = totalFare;
                if (y.this.f28297i != null && !TextUtils.isEmpty(y.this.f28297i.getmSttaus())) {
                    pVar.f27592e = y.this.f28297i.getmSttaus();
                }
                pVar.onClick(y.this.f28291c);
            }
        });
    }
}
