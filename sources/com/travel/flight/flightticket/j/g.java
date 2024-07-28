package com.travel.flight.flightticket.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class g extends RecyclerView.v implements r {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f25151a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f25152b;

    public g(View view) {
        super(view);
        this.f25151a = (RoboTextView) view.findViewById(R.id.header_text);
        this.f25152b = (RelativeLayout) view.findViewById(R.id.header_layout);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, String str, boolean z, List<CJRFlightStops> list) {
        String headerTitle = ((CJRMiniRulesLayoutItem) iJRDataModel).getHeaderTitle();
        if (iJRDataModel != null && (iJRDataModel instanceof CJRMiniRulesLayoutItem) && headerTitle != null && !TextUtils.isEmpty(headerTitle)) {
            if (headerTitle.equals("Onward") || headerTitle.equals("Return")) {
                this.f25151a.setText(headerTitle);
                this.f25152b.setVisibility(0);
                return;
            }
            this.f25152b.setVisibility(8);
        }
    }
}
