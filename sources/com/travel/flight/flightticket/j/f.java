package com.travel.flight.flightticket.j;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.FareRules.CJRCancelRefund;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesJorneyRoute;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import com.travel.flight.utils.c;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class f extends RecyclerView.v implements r {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f25144a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f25145b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f25146c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f25147d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f25148e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f25149f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f25150g;

    public f(View view) {
        super(view);
        this.f25144a = (ImageView) view.findViewById(R.id.flight_icon);
        this.f25145b = (ImageView) view.findViewById(R.id.trip_icon);
        this.f25146c = (RoboTextView) view.findViewById(R.id.origin_text);
        this.f25147d = (RoboTextView) view.findViewById(R.id.destination_text);
        this.f25149f = (ViewGroup) view.findViewById(R.id.refundable_status_lyt);
        this.f25148e = (RoboTextView) view.findViewById(R.id.refundable_status_text);
        this.f25150g = (RoboTextView) view.findViewById(R.id.route_header_note_txt);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, String str, boolean z, List<CJRFlightStops> list) {
        if (iJRDataModel != null && (iJRDataModel instanceof CJRMiniRulesLayoutItem)) {
            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem = (CJRMiniRulesLayoutItem) iJRDataModel;
            if (cJRMiniRulesLayoutItem.getRoute() != null) {
                CJRFareRulesJorneyRoute route = cJRMiniRulesLayoutItem.getRoute();
                String headerTitle = cJRMiniRulesLayoutItem.getHeaderTitle();
                if (route != null) {
                    if (!z || list == null) {
                        c.a(route.getAirlineCode(), this.f25144a);
                    } else if (list.size() > 1) {
                        CJRFlightStops cJRFlightStops = list.get(0);
                        CJRFlightStops cJRFlightStops2 = list.get(1);
                        if (route.getDestination().equalsIgnoreCase(cJRFlightStops.getDestinationCity())) {
                            c.a(cJRFlightStops.getmAirLineCode(), this.f25144a);
                        }
                        if (route.getDestination().equalsIgnoreCase(cJRFlightStops2.getDestinationCity())) {
                            c.a(cJRFlightStops2.getmAirLineCode(), this.f25144a);
                        }
                    }
                    if (headerTitle == null || !headerTitle.equalsIgnoreCase("Combined")) {
                        this.f25145b.setImageResource(R.drawable.pre_f_actionbar_right_arrow);
                    } else {
                        this.f25145b.setImageResource(R.drawable.pre_f_actionbar_roundtrip_arrow);
                    }
                    this.f25146c.setText(route.getOrigin());
                    this.f25147d.setText(route.getDestination());
                    CJRCancelRefund refundable = cJRMiniRulesLayoutItem.getRefundable();
                    this.f25149f.setVisibility(0);
                    if (refundable == null || TextUtils.isEmpty(refundable.getLabel()) || str == null || !str.equals("Cancellation")) {
                        String headerNote = cJRMiniRulesLayoutItem.getHeaderNote();
                        if (headerNote != null && !TextUtils.isEmpty(headerNote)) {
                            this.f25150g.setText(headerNote);
                            this.f25150g.setVisibility(0);
                        } else if (refundable == null) {
                            this.f25150g.setVisibility(4);
                        }
                        if (headerNote == null || !headerNote.contains("Reschedule")) {
                            this.f25150g.setTextColor(context.getResources().getColor(R.color.color_222222));
                        } else {
                            this.f25150g.setTextColor(context.getResources().getColor(R.color.color_7b7b7b));
                        }
                    } else {
                        this.f25148e.setVisibility(0);
                        this.f25150g.setVisibility(8);
                        this.f25148e.setText(refundable.getLabel());
                        if (!TextUtils.isEmpty(refundable.getColor())) {
                            Drawable a2 = b.a(context, R.drawable.pre_f_flight_rounded_rect_with_4dp_radius);
                            a2.setColorFilter(new PorterDuffColorFilter(Color.parseColor(refundable.getColor()), PorterDuff.Mode.MULTIPLY));
                            if (Build.VERSION.SDK_INT < 16) {
                                this.f25148e.setBackgroundDrawable(a2);
                            } else {
                                this.f25148e.setBackground(a2);
                            }
                        }
                    }
                }
            }
        }
    }
}
