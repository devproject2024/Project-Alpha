package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class ag extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    RoboTextView f21598a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f21599b;

    /* renamed from: c  reason: collision with root package name */
    RoboTextView f21600c;

    /* renamed from: d  reason: collision with root package name */
    RoboTextView f21601d;

    /* renamed from: e  reason: collision with root package name */
    RoboTextView f21602e;

    /* renamed from: f  reason: collision with root package name */
    RoboTextView f21603f;

    /* renamed from: g  reason: collision with root package name */
    b f21604g;

    /* renamed from: h  reason: collision with root package name */
    Context f21605h;

    /* renamed from: i  reason: collision with root package name */
    boolean f21606i;
    boolean j;
    boolean k;
    private LinearLayout l;
    private String m;
    private String n;
    private String o;
    private String p;
    private SpannableString q;
    private int r = 100;
    private long s = 0;
    private String t = "CJRReviewItemViewHolder";

    public ag(View view, Context context) {
        super(view);
        this.f21605h = context;
        this.l = (LinearLayout) view.findViewById(R.id.review_item);
        this.f21603f = (RoboTextView) view.findViewById(R.id.review_rating);
        this.f21599b = (RoboTextView) view.findViewById(R.id.time_lapsed);
        this.f21598a = (RoboTextView) view.findViewById(R.id.review_text);
        this.f21600c = (RoboTextView) view.findViewById(R.id.passenger_gender);
        this.f21601d = (RoboTextView) view.findViewById(R.id.passenger_age);
        this.f21602e = (RoboTextView) view.findViewById(R.id.pax_count);
    }

    /* access modifiers changed from: package-private */
    public final long a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            int time = (int) ((simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime())).getTime() - simpleDateFormat.parse(simpleDateFormat.format(simpleDateFormat.parse(str))).getTime()) / 86400000);
            if (time < 7) {
                this.k = true;
                this.s = (long) time;
                this.j = false;
                this.f21606i = false;
            } else if (time >= 30) {
                this.s = (((long) (time % 365)) / 30) + ((long) ((time / 365) * 12));
                this.f21606i = true;
                this.j = false;
                this.k = false;
            } else if (time < 30) {
                this.s = (((long) (time % 365)) % 30) / 7;
                this.j = true;
                this.k = false;
                this.f21606i = false;
            }
            return this.s;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        this.m = str;
        String str2 = this.m;
        this.n = str2;
        this.o = "read more";
        this.p = "read less";
        if (str2.length() > this.r) {
            this.l.setOnClickListener(new View.OnClickListener(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ag.this.b(this.f$1, view);
                }
            });
            this.f21598a.setOnClickListener(new View.OnClickListener(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ag.this.a(this.f$1, view);
                }
            });
            if (this.f21604g.j) {
                this.m = str.substring(0, this.r);
                this.n = this.m + AppConstants.DOTS;
                this.q = new SpannableString(this.n + this.o);
                this.f21598a.setMaxLines(2);
            } else {
                this.m = str;
                this.n = this.m + AppConstants.DOTS;
                this.q = new SpannableString(this.n + this.p);
                this.f21598a.setMaxLines(Integer.MAX_VALUE);
            }
            this.q.setSpan(new ForegroundColorSpan(this.f21605h.getResources().getColor(R.color.bus_paytm_blue)), this.n.length(), this.n.length() + this.o.length(), 0);
            this.f21598a.setText(this.q);
            this.f21598a.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        this.q = new SpannableString(this.n);
        this.f21598a.setText(this.q);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str, View view) {
        if (this.f21604g.j) {
            this.f21604g.j = false;
            c(str);
            return;
        }
        this.f21604g.j = true;
        c(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        if (this.f21604g.j) {
            this.f21604g.j = false;
            c(str);
            return;
        }
        this.f21604g.j = true;
        c(str);
    }

    private void c(String str) {
        if (this.f21604g.j) {
            this.m = str.substring(0, this.r);
            this.n = this.m + AppConstants.DOTS;
            this.f21598a.setMaxLines(2);
            this.q = new SpannableString(this.n + this.o);
        } else {
            this.m = str;
            this.n = this.m + AppConstants.DOTS;
            this.f21598a.setMaxLines(Integer.MAX_VALUE);
            this.q = new SpannableString(this.n + this.p);
        }
        this.q.setSpan(new ForegroundColorSpan(this.f21605h.getResources().getColor(R.color.bus_paytm_blue)), this.n.length(), this.n.length() + this.o.length(), 0);
        this.f21598a.setText(this.q);
        this.f21598a.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
