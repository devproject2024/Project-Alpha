package com.travel.bus.busticket.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.b.b;
import com.travel.bus.busticket.e.d;
import com.travel.bus.busticket.e.g;
import com.travel.bus.busticket.i.h;
import com.travel.bus.busticket.widgets.BusHorizontalProgress;
import com.travel.bus.busticket.widgets.BusRatingProgress;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.c;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class r extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public c f21746a;

    /* renamed from: b  reason: collision with root package name */
    public CJRBusSearchItem f21747b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Object> f21748c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private Context f21749d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f21750e;

    /* renamed from: f  reason: collision with root package name */
    private b f21751f;

    public r() {
    }

    public r(Context context, c cVar, CJRBusSearchItem cJRBusSearchItem, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, b bVar) {
        this.f21749d = context;
        this.f21746a = cVar;
        this.f21747b = cJRBusSearchItem;
        this.f21750e = hashMap;
        this.f21751f = bVar;
        a();
    }

    public final void a() {
        a aVar = new a(this, (byte) 0);
        aVar.f21752a = "ratingdisplay";
        a aVar2 = new a(this, (byte) 0);
        aVar2.f21752a = "commonfeedback";
        a aVar3 = new a(this, (byte) 0);
        aVar3.f21752a = "reviewheader";
        a aVar4 = new a(this, (byte) 0);
        aVar4.f21752a = "amenityList";
        this.f21748c.add(aVar);
        if (this.f21746a.f22805d != null && this.f21746a.f22805d.size() > 0) {
            this.f21748c.add(aVar2);
        }
        if (this.f21747b.getAmenities() != null) {
            this.f21748c.add(aVar4);
        }
        this.f21748c.add(aVar3);
        if (this.f21746a.f22803b.size() > 0) {
            this.f21748c.addAll(this.f21746a.f22803b);
        }
    }

    public final int b() {
        return this.f21746a.f22803b.size() + 1;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_rating_graph_item, viewGroup, false), this.f21749d);
        }
        if (i2 == 1) {
            return new com.travel.bus.busticket.e.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_rating_feedback_item, viewGroup, false), this.f21749d);
        }
        if (i2 == 3) {
            return new com.travel.bus.busticket.e.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_lyt_bus_review_amenity, viewGroup, false), this.f21749d, this.f21751f);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_rating_review_item, viewGroup, false);
            ResourceUtils.loadBusImagesFromCDN((ImageView) inflate.findViewById(R.id.no_review), "no_reviews_revamp.png", false, false, n.a.V1);
            return new g(inflate, this.f21749d);
        } else if (i2 == 4) {
            return new ag(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_reviews_item, viewGroup, false), this.f21749d);
        } else {
            if (i2 == 5) {
                return new ah(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_reviews_loading, viewGroup, false));
            }
            return null;
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        boolean z;
        boolean z2;
        int i3;
        boolean z3 = true;
        if (vVar instanceof d) {
            d dVar = (d) vVar;
            com.travel.bus.pojo.busticket.a aVar = this.f21746a.f22804c;
            int count = this.f21747b.getBusRating().getCount();
            String valueOf = String.valueOf(this.f21747b.getBusRating().getAvgRating());
            dVar.f22146d = aVar;
            if (dVar.f22146d != null && (dVar.f22146d.f22788a > 0 || dVar.f22146d.f22789b > 0 || dVar.f22146d.f22790c > 0 || dVar.f22146d.f22791d > 0 || dVar.f22146d.f22792e > 0)) {
                View view = dVar.itemView;
                dVar.f22150h = (RelativeLayout) view.findViewById(R.id.excellent);
                dVar.f22151i = (RoboTextView) dVar.f22150h.findViewById(R.id.progress_value_name);
                dVar.j = (RoboTextView) dVar.f22150h.findViewById(R.id.progress_value_text);
                dVar.k = (BusHorizontalProgress) dVar.f22150h.findViewById(R.id.progress_value);
                dVar.l = (RelativeLayout) view.findViewById(R.id.good);
                dVar.m = (RoboTextView) dVar.l.findViewById(R.id.progress_value_name);
                dVar.n = (RoboTextView) dVar.l.findViewById(R.id.progress_value_text);
                dVar.o = (BusHorizontalProgress) dVar.l.findViewById(R.id.progress_value);
                dVar.p = (RelativeLayout) view.findViewById(R.id.average);
                dVar.q = (RoboTextView) dVar.p.findViewById(R.id.progress_value_name);
                dVar.r = (RoboTextView) dVar.p.findViewById(R.id.progress_value_text);
                dVar.s = (BusHorizontalProgress) dVar.p.findViewById(R.id.progress_value);
                dVar.t = (RelativeLayout) view.findViewById(R.id.below_avg);
                dVar.u = (RoboTextView) dVar.t.findViewById(R.id.progress_value_name);
                dVar.v = (RoboTextView) dVar.t.findViewById(R.id.progress_value_text);
                dVar.w = (BusHorizontalProgress) dVar.t.findViewById(R.id.progress_value);
                dVar.x = (RelativeLayout) view.findViewById(R.id.poor);
                dVar.y = (RoboTextView) dVar.x.findViewById(R.id.progress_value_name);
                dVar.z = (RoboTextView) dVar.x.findViewById(R.id.progress_value_text);
                dVar.A = (BusHorizontalProgress) dVar.x.findViewById(R.id.progress_value);
                dVar.y.setText(R.string.poor);
                dVar.z.setText("0");
                if (dVar.A != null) {
                    dVar.A.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                }
                dVar.u.setText(R.string.below_avg);
                dVar.u.setMaxLines(1);
                dVar.v.setText("0");
                dVar.w.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                dVar.q.setText(R.string.avergae);
                dVar.r.setText("0");
                dVar.s.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                dVar.m.setText(R.string.good);
                dVar.n.setText("0");
                dVar.o.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                dVar.f22151i.setText(R.string.excellent);
                dVar.j.setText("0");
                dVar.k.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
            }
            dVar.f22144b = count;
            dVar.G = valueOf;
            if (dVar.f22144b > 0 && dVar.f22146d != null) {
                if (dVar.G != null && !TextUtils.isEmpty(dVar.G) && dVar.f22144b > 0) {
                    try {
                        Float valueOf2 = Float.valueOf(dVar.G);
                        BusRatingProgress busRatingProgress = dVar.f22147e;
                        StringBuilder sb = new StringBuilder();
                        sb.append(d.a(valueOf2.floatValue()));
                        float parseFloat = Float.parseFloat(sb.toString());
                        if (parseFloat < 2.0f) {
                            i3 = androidx.core.content.b.c(dVar.f22143a, R.color.color_fd5c5c);
                        } else if (((double) parseFloat) < 3.5d) {
                            i3 = androidx.core.content.b.c(dVar.f22143a, R.color.color_ffa400);
                        } else {
                            i3 = androidx.core.content.b.c(dVar.f22143a, R.color.color_21c17a);
                        }
                        busRatingProgress.setPrimaryProgressColor(i3);
                        dVar.k.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                        com.travel.bus.busticket.d.d dVar2 = new com.travel.bus.busticket.d.d(dVar.f22147e, valueOf2.floatValue());
                        dVar2.setDuration(1000);
                        dVar.f22147e.startAnimation(dVar2);
                        RoboTextView roboTextView = dVar.H;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(d.a(valueOf2.floatValue()));
                        roboTextView.setText(sb2.toString());
                        dVar.f22148f.setText(dVar.f22143a.getString(R.string.rating_formatted_string, new Object[]{Integer.valueOf(dVar.f22144b)}));
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                }
                if (dVar.f22146d != null && (dVar.f22146d.f22788a > 0 || dVar.f22146d.f22789b > 0 || dVar.f22146d.f22790c > 0 || dVar.f22146d.f22791d > 0 || dVar.f22146d.f22792e > 0)) {
                    int i4 = dVar.f22146d.f22788a;
                    int i5 = dVar.f22146d.f22789b;
                    int i6 = dVar.f22146d.f22790c;
                    int i7 = dVar.f22146d.f22791d;
                    int i8 = dVar.f22146d.f22792e;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i4));
                    arrayList.add(Integer.valueOf(i5));
                    arrayList.add(Integer.valueOf(i6));
                    arrayList.add(Integer.valueOf(i7));
                    arrayList.add(Integer.valueOf(i8));
                    dVar.f22145c = ((Integer) Collections.max(arrayList)).intValue();
                    dVar.f22149g.setVisibility(0);
                    if (dVar.f22146d.f22788a > 0) {
                        dVar.B = dVar.f22146d.f22788a;
                        dVar.y.setText(R.string.poor);
                        RoboTextView roboTextView2 = dVar.z;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(dVar.B);
                        roboTextView2.setText(sb3.toString());
                        dVar.A.setmPrimaryProgressColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_fd5c5c));
                        if (dVar.A != null) {
                            dVar.A.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                        }
                        com.travel.bus.busticket.d.d dVar3 = new com.travel.bus.busticket.d.d(dVar.A, (float) dVar.a(dVar.B));
                        dVar3.setDuration(800);
                        dVar.A.startAnimation(dVar3);
                    }
                    if (dVar.f22146d.f22789b > 0) {
                        dVar.C = dVar.f22146d.f22789b;
                        dVar.u.setText(R.string.below_avg);
                        RoboTextView roboTextView3 = dVar.v;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(dVar.C);
                        roboTextView3.setText(sb4.toString());
                        dVar.w.setmPrimaryProgressColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_ffa400));
                        dVar.w.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                        com.travel.bus.busticket.d.d dVar4 = new com.travel.bus.busticket.d.d(dVar.w, (float) dVar.a(dVar.C));
                        dVar4.setDuration(800);
                        dVar.w.startAnimation(dVar4);
                    }
                    if (dVar.f22146d.f22790c > 0) {
                        dVar.D = dVar.f22146d.f22790c;
                        dVar.q.setText(R.string.avergae);
                        RoboTextView roboTextView4 = dVar.r;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(dVar.D);
                        roboTextView4.setText(sb5.toString());
                        com.travel.bus.busticket.d.d dVar5 = new com.travel.bus.busticket.d.d(dVar.s, (float) dVar.a(dVar.D));
                        dVar5.setDuration(800);
                        dVar.s.startAnimation(dVar5);
                        dVar.s.setmPrimaryProgressColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_ffa400));
                        dVar.s.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                    }
                    if (dVar.f22146d.f22791d > 0) {
                        dVar.E = dVar.f22146d.f22791d;
                        dVar.m.setText(R.string.good);
                        RoboTextView roboTextView5 = dVar.n;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(dVar.E);
                        roboTextView5.setText(sb6.toString());
                        dVar.o.setmPrimaryProgressColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_21c17a));
                        dVar.o.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                        com.travel.bus.busticket.d.d dVar6 = new com.travel.bus.busticket.d.d(dVar.o, (float) dVar.a(dVar.E));
                        dVar6.setDuration(800);
                        dVar.o.startAnimation(dVar6);
                    }
                    if (dVar.f22146d.f22792e > 0) {
                        dVar.F = dVar.f22146d.f22792e;
                        dVar.f22151i.setText(R.string.excellent);
                        RoboTextView roboTextView6 = dVar.j;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(dVar.F);
                        roboTextView6.setText(sb7.toString());
                        dVar.k.setmPrimaryProgressColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_21c17a));
                        dVar.k.setmBackgroundColor(androidx.core.content.b.c(dVar.f22143a, R.color.color_e2ebee));
                        com.travel.bus.busticket.d.d dVar7 = new com.travel.bus.busticket.d.d(dVar.k, (float) dVar.a(dVar.F));
                        dVar7.setDuration(800);
                        dVar.k.startAnimation(dVar7);
                    }
                }
            }
        }
        if (vVar instanceof com.travel.bus.busticket.e.c) {
            com.travel.bus.busticket.e.c cVar = (com.travel.bus.busticket.e.c) vVar;
            cVar.f22137b = this.f21746a.f22805d;
            cVar.a();
        }
        if (vVar instanceof com.travel.bus.busticket.e.b) {
            com.travel.bus.busticket.e.b bVar = (com.travel.bus.busticket.e.b) vVar;
            HashMap<String, CJRBusSearchAmenitiesInfo> hashMap = this.f21750e;
            CJRBusSearchItem cJRBusSearchItem = this.f21747b;
            if (cJRBusSearchItem.getAmenities() != null) {
                bVar.f22131b.setVisibility(0);
                ArrayList<Integer> amenities = cJRBusSearchItem.getAmenities();
                Context context = bVar.f22130a;
                float f2 = h.l;
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i9 = (int) (((double) (((((float) displayMetrics.widthPixels) / displayMetrics.density) - ((float) h.f22434b)) / f2)) + 0.5d);
                bVar.f22133d = new s(bVar.f22130a, com.travel.bus.b.b.a(amenities, hashMap, i9), amenities, i9, hashMap, bVar.f22134e);
                bVar.f22132c.setAdapter(bVar.f22133d);
                bVar.f22133d.notifyDataSetChanged();
                bVar.f22132c.setNestedScrollingEnabled(false);
            } else {
                bVar.f22131b.setVisibility(8);
            }
        }
        if (vVar instanceof g) {
            g gVar = (g) vVar;
            int review_count = this.f21747b.getBusRating().getReview_count();
            List<com.travel.bus.pojo.busticket.b> list = this.f21746a.f22803b;
            gVar.f22156b = review_count;
            if (list == null || review_count <= 0) {
                gVar.f22158d.setVisibility(8);
                gVar.f22159e.setVisibility(0);
            } else {
                gVar.f22158d.setVisibility(0);
                gVar.f22159e.setVisibility(8);
                StringBuilder sb8 = new StringBuilder();
                SpannableString spannableString = new SpannableString("(" + gVar.f22156b + ")");
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(gVar.f22155a, R.color.color_999999)), 0, spannableString.length(), 0);
                spannableString.setSpan(new AbsoluteSizeSpan(gVar.f22155a.getResources().getDimensionPixelSize(R.dimen.dimen_15sp)), 0, spannableString.length(), 0);
                spannableString.setSpan(new TypefaceSpan(gVar.f22155a.getResources().getString(R.string.font_family_roboto_regular)), 0, spannableString.length(), 0);
                sb8.append(spannableString);
                gVar.f22157c.setText(sb8);
            }
        }
        if (vVar instanceof ag) {
            ag agVar = (ag) vVar;
            agVar.f21604g = (com.travel.bus.pojo.busticket.b) this.f21748c.get(i2);
            String str = agVar.f21604g.f22795c;
            float f3 = 0.0f;
            if (!TextUtils.isEmpty(str)) {
                f3 = Float.parseFloat(str);
            }
            if (agVar.f21604g != null) {
                String str2 = agVar.f21604g.f22794b;
                RoboTextView roboTextView7 = agVar.f21603f;
                roboTextView7.setText(String.format("%.1f", new Object[]{Float.valueOf(f3)}));
                Drawable f4 = androidx.core.graphics.drawable.a.f(androidx.core.content.b.a(agVar.f21605h, R.drawable.travel_res_bus_rating_background));
                agVar.f21603f.setBackground(f4);
                if (Build.VERSION.SDK_INT >= 21) {
                    androidx.core.graphics.drawable.a.a(f4, Color.parseColor(str2));
                } else {
                    f4.mutate().setColorFilter(Color.parseColor(str2), PorterDuff.Mode.SRC_IN);
                }
                if (agVar.f21604g.f22801i == null || TextUtils.isEmpty(agVar.f21604g.f22801i)) {
                    agVar.f21600c.setVisibility(8);
                    z = false;
                } else {
                    agVar.f21600c.setText(agVar.f21604g.f22801i);
                    z = true;
                }
                if (agVar.f21604g.f22799g == null || TextUtils.isEmpty(agVar.f21604g.f22799g)) {
                    agVar.f21601d.setVisibility(8);
                    z2 = false;
                } else {
                    RoboTextView roboTextView8 = agVar.f21601d;
                    roboTextView8.setText(AppConstants.COMMA + agVar.f21604g.f22799g);
                    z2 = true;
                }
                if (agVar.f21604g.f22800h == null || TextUtils.isEmpty(agVar.f21604g.f22800h)) {
                    agVar.f21602e.setVisibility(8);
                    z3 = false;
                } else {
                    agVar.f21602e.setText(agVar.f21605h.getString(R.string.bus_review_traveller_revamp, new Object[]{agVar.f21604g.f22800h}));
                }
                if ((!z && !z2) || ((!z && !z3) || (!z2 && !z3))) {
                    agVar.f21602e.setVisibility(8);
                    agVar.f21600c.setVisibility(8);
                    agVar.f21601d.setVisibility(8);
                }
                agVar.f21598a.setText(agVar.f21604g.f22793a);
                if (agVar.f21604g.f22793a != null) {
                    agVar.b(agVar.f21604g.f22793a);
                }
                long a2 = agVar.a(agVar.f21604g.f22797e);
                if (agVar.k) {
                    if (a2 == 1) {
                        RoboTextView roboTextView9 = agVar.f21599b;
                        roboTextView9.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_day_ago));
                        return;
                    }
                    RoboTextView roboTextView10 = agVar.f21599b;
                    roboTextView10.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_days_ago));
                } else if (agVar.j) {
                    if (a2 == 1) {
                        RoboTextView roboTextView11 = agVar.f21599b;
                        roboTextView11.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_week_ago));
                        return;
                    }
                    RoboTextView roboTextView12 = agVar.f21599b;
                    roboTextView12.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_weeks_ago));
                } else if (!agVar.f21606i) {
                } else {
                    if (a2 == 1) {
                        RoboTextView roboTextView13 = agVar.f21599b;
                        roboTextView13.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_month_ago));
                        return;
                    }
                    RoboTextView roboTextView14 = agVar.f21599b;
                    roboTextView14.setText(a2 + " " + agVar.f21605h.getString(R.string.bus_months_ago));
                }
            }
        }
    }

    public final int getItemCount() {
        ArrayList<Object> arrayList = this.f21748c;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f21748c.size();
    }

    public final int getItemViewType(int i2) {
        Object obj = this.f21748c.get(i2);
        if (!(obj instanceof a)) {
            return 4;
        }
        String str = ((a) obj).f21752a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1357984635:
                if (str.equals("ratingdisplay")) {
                    c2 = 0;
                    break;
                }
                break;
            case -548210715:
                if (str.equals("reviewheader")) {
                    c2 = 2;
                    break;
                }
                break;
            case -273320220:
                if (str.equals("reviewloading")) {
                    c2 = 4;
                    break;
                }
                break;
            case 91093616:
                if (str.equals("commonfeedback")) {
                    c2 = 1;
                    break;
                }
                break;
            case 249278199:
                if (str.equals("amenityList")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return 0;
        }
        if (c2 == 1) {
            return 1;
        }
        if (c2 == 2) {
            return 2;
        }
        if (c2 != 3) {
            return c2 != 4 ? 0 : 5;
        }
        return 3;
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f21752a;

        private a() {
        }

        public /* synthetic */ a(r rVar, byte b2) {
            this();
        }
    }
}
