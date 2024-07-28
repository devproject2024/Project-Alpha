package com.travel.flight.flightticket.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRuleTC;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRuleTcTextObject;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class j extends RecyclerView.v implements r {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f25163a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f25164b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25165c;

    public j(View view) {
        super(view);
        this.f25165c = (TextView) view.findViewById(R.id.tnc_header);
        this.f25164b = (LinearLayout) view.findViewById(R.id.tandc_lyt);
        this.f25163a = (LinearLayout) view.findViewById(R.id.important_container);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, String str, boolean z, List<CJRFlightStops> list) {
        if (iJRDataModel != null && (iJRDataModel instanceof CJRMiniRulesLayoutItem)) {
            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem = (CJRMiniRulesLayoutItem) iJRDataModel;
            if (cJRMiniRulesLayoutItem.getTermsAndConditions() != null) {
                CJRMiniRuleTC termsAndConditions = cJRMiniRulesLayoutItem.getTermsAndConditions();
                if (!(termsAndConditions == null || termsAndConditions.getTitle() == null)) {
                    this.f25165c.setText(termsAndConditions.getTitle());
                }
                if (termsAndConditions != null) {
                    ArrayList<CJRMiniRuleTcTextObject> text = termsAndConditions.getText();
                    int size = text != null ? text.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        if (text.get(i2).isVisible() && text.get(i2).getMessage() != null) {
                            View inflate = LayoutInflater.from(context).inflate(R.layout.pre_f_flight_fare_rule_tnc_item, (ViewGroup) null);
                            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                            ((TextView) inflate.findViewById(R.id.item_tnc_text)).setText(text.get(i2).getMessage());
                            this.f25163a.setVisibility(0);
                            this.f25164b.addView(inflate);
                        }
                    }
                }
            }
        }
    }
}
