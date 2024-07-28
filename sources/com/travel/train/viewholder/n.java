package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class n extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f28170a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchResultsTrain f28171b;

    /* renamed from: c  reason: collision with root package name */
    public CJRTrainDetailsBody f28172c;

    /* renamed from: d  reason: collision with root package name */
    public CJRTrainAvailability f28173d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f28174e;

    /* renamed from: f  reason: collision with root package name */
    String f28175f;

    /* renamed from: g  reason: collision with root package name */
    public String f28176g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28177h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28178i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public Spinner r;
    public TextView s;
    private LinearLayout t;
    private TextView u;
    private RoboTextView v;

    public n(View view, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainDetailsBody cJRTrainDetailsBody, CJRTrainBooking cJRTrainBooking, String str) {
        super(view);
        this.f28170a = view.getContext();
        this.f28171b = cJRTrainSearchResultsTrain;
        this.f28176g = str;
        this.f28172c = cJRTrainDetailsBody;
        CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f28172c;
        if (cJRTrainDetailsBody2 != null) {
            this.f28174e = cJRTrainDetailsBody2.getFormattedBoardingStation();
            this.f28173d = this.f28172c.getmTrainAvailability().get(this.f28172c.getMiSelectedPosition());
        }
        this.f28177h = (TextView) view.findViewById(R.id.review_iteneray_train_name);
        this.u = (TextView) view.findViewById(R.id.review_iteneray_train_status);
        this.k = (TextView) view.findViewById(R.id.review_iteneray_train_source_time);
        this.j = (TextView) view.findViewById(R.id.review_iteneray_train_source_date);
        this.l = (TextView) view.findViewById(R.id.review_iteneray_train_source_brd_point);
        this.n = (TextView) view.findViewById(R.id.review_iteneray_train_destination_time);
        this.m = (TextView) view.findViewById(R.id.review_iteneray_train_destination_date);
        this.o = (TextView) view.findViewById(R.id.review_iteneray_train_destination_brd_point);
        this.p = (TextView) view.findViewById(R.id.review_iteneray_train_duration);
        this.t = (LinearLayout) view.findViewById(R.id.txt_train_price_lyt);
        this.f28178i = (TextView) view.findViewById(R.id.review_iteneray_train_class);
        this.v = (RoboTextView) view.findViewById(R.id.seat_selection_alert);
        this.r = (Spinner) view.findViewById(R.id.review_iteneray_boarding_point_spinner);
        this.q = (TextView) view.findViewById(R.id.review_iteneray_train_boarding_point);
        this.s = (TextView) view.findViewById(R.id.review_iteneray_train_boarding_time);
        String string = this.f28170a.getString(R.string.select_seat_alert_message);
        if (cJRTrainBooking != null && cJRTrainBooking.getmConfirmation() != null && !TextUtils.isEmpty(cJRTrainBooking.getmConfirmation().getReviewItineraryMessage())) {
            string = cJRTrainBooking.getmConfirmation().getReviewItineraryMessage();
        } else if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getBerthAllotmentMessage())) {
            string = g.f27551a.getBerthAllotmentMessage();
        }
        if (this.v != null && string != null && !TextUtils.isEmpty(string.trim())) {
            this.v.setVisibility(0);
            this.v.setText(string);
        }
    }

    public final void a(CJRTrainBooking cJRTrainBooking) {
        if (cJRTrainBooking.getmConfirmation().getmTrainDetails() != null && cJRTrainBooking.getmConfirmation().getmTrainDetails().getmTrainAvailability() != null && cJRTrainBooking.getmConfirmation().getmTrainDetails().getmTrainAvailability().size() > 0) {
            ArrayList<CJRTrainAvailability> arrayList = cJRTrainBooking.getmConfirmation().getmTrainDetails().getmTrainAvailability();
            CJRTrainAvailability cJRTrainAvailability = arrayList.get(0);
            HashMap<String, String> typeMap = arrayList.get(0).getTypeMap();
            if (typeMap != null) {
                String str = cJRTrainAvailability.getmSttaus();
                for (Map.Entry next : typeMap.entrySet()) {
                    if (next.getValue().equals("1") || next.getValue().equals("2")) {
                        this.u.setText(str);
                        this.t.setBackgroundDrawable(b.a(this.f28170a, R.drawable.pre_t_train_bg_rec_green_border));
                        this.u.setTextColor(this.f28170a.getResources().getColor(R.color.color_available));
                    } else if (next.getValue().equals("0")) {
                        this.u.setText(str);
                        this.t.setBackgroundDrawable(b.a(this.f28170a, R.drawable.pre_t_train_bg_rec_red_border));
                        this.u.setTextColor(this.f28170a.getResources().getColor(R.color.color_waitlist));
                    } else {
                        this.t.setBackgroundDrawable(b.a(this.f28170a, R.drawable.pre_t_train_bg_rec_orange_border));
                        this.u.setText(str);
                        this.u.setTextColor(this.f28170a.getResources().getColor(R.color.seller_rating_star));
                    }
                }
                return;
            }
            this.u.setVisibility(8);
        }
    }

    public class a implements View.OnTouchListener, AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f28179a = false;

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        public a() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            if (this.f28179a) {
                n.this.f28172c.setMiSelectedPosition(i2);
                n.this.f28172c.setSelectedBoardingStation(n.this.f28172c.getBoardingStation().get(i2));
                n nVar = n.this;
                nVar.f28175f = nVar.f28172c.getBoardingStation().get(i2);
            }
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f28179a = true;
            return false;
        }
    }
}
