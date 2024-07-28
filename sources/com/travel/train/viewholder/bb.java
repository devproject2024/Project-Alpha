package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.j.o;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class bb extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public View f27926a;

    /* renamed from: b  reason: collision with root package name */
    public View f27927b;

    /* renamed from: c  reason: collision with root package name */
    public View f27928c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f27929d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27930e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27931f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27932g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27933h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27934i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Context n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public RelativeLayout s;
    public LinearLayout t;
    public LinearLayout u;
    public LottieAnimationView v;
    public LinearLayout w;
    public RelativeLayout x;
    public View y;
    private String z = "CJRTrainLSViewHolder";

    public bb(View view, Context context) {
        super(view);
        this.n = context;
        this.y = view;
        this.f27926a = view.findViewById(R.id.blue_dot_icon);
        this.f27932g = (TextView) view.findViewById(R.id.stn_date_txt);
        this.f27929d = (ImageView) view.findViewById(R.id.reached_location_icon);
        this.f27928c = view.findViewById(R.id.top_white_vertical_line);
        this.f27927b = view.findViewById(R.id.vertical_line);
        this.f27930e = (TextView) view.findViewById(R.id.station_name_txt);
        this.f27931f = (TextView) view.findViewById(R.id.distance_txt);
        this.f27933h = (TextView) view.findViewById(R.id.block1_header_txt);
        this.f27934i = (TextView) view.findViewById(R.id.block2_header_txt);
        this.j = (TextView) view.findViewById(R.id.block3_header_txt);
        this.k = (TextView) view.findViewById(R.id.block1_value_txt);
        this.l = (TextView) view.findViewById(R.id.block2_value_txt);
        this.m = (TextView) view.findViewById(R.id.block3_value_txt);
        this.r = (RelativeLayout) view.findViewById(R.id.delay_lyt);
        this.s = (RelativeLayout) view.findViewById(R.id.delay_lyt_2);
        this.o = (TextView) view.findViewById(R.id.delay_txt1);
        this.p = (TextView) view.findViewById(R.id.delay_txt2);
        this.q = (TextView) view.findViewById(R.id.delay_txt3);
        this.t = (LinearLayout) view.findViewById(R.id.selected_bp_lyt);
        this.u = (LinearLayout) view.findViewById(R.id.upcoming_item_dest_lyt);
        this.v = (LottieAnimationView) view.findViewById(R.id.current_location_view);
        this.w = (LinearLayout) view.findViewById(R.id.current_location_view_lyt);
        this.x = (RelativeLayout) view.findViewById(R.id.extra_station_info_lyt);
    }

    public final void a(boolean z2) {
        if (z2) {
            if (!this.v.isAnimating()) {
                String c2 = o.c(this.n, "train_live_status_animation.json");
                if (!TextUtils.isEmpty(c2)) {
                    this.v.setAnimationFromJson(c2, (String) null);
                    this.v.loop(true);
                    this.v.setSpeed(3.0f);
                    this.v.playAnimation();
                }
            }
        } else if (this.v.isAnimating()) {
            this.v.clearAnimation();
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
            Calendar instance = Calendar.getInstance(TimeZone.getDefault());
            instance.setTime(parse);
            int i2 = instance.get(5);
            String displayName = instance.getDisplayName(7, 1, Locale.ENGLISH);
            String displayName2 = instance.getDisplayName(2, 1, Locale.ENGLISH);
            return displayName + ", " + i2 + " " + displayName2;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }
}
