package com.travel.train.b;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytm.utility.w;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.j.i;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRPNRStatusDetails;
import com.travel.train.model.trainticket.CJRStationList;
import com.travel.train.model.trainticket.CJRTrainRouteBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class at extends RecyclerView.a<RecyclerView.v> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f26329a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f26330b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRStationList> f26331c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f26332d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<CJRStationList> f26333e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f26334f;

    /* renamed from: g  reason: collision with root package name */
    private String f26335g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f26336h;

    /* renamed from: i  reason: collision with root package name */
    private int f26337i = 0;
    private int j = 1;
    private int k = 2;
    private int l = -1;
    private int m = -1;
    private boolean n;
    private int o;
    /* access modifiers changed from: private */
    public int p = 0;
    private String q = "CJRTrainViewRouteAdapter";

    public final Filter getFilter() {
        return null;
    }

    public at(Context context, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainRouteBody cJRTrainRouteBody, CJRPNRStatusDetails cJRPNRStatusDetails) {
        this.f26334f = context;
        this.f26333e = cJRTrainRouteBody.getmStationList();
        if (cJRTrainSearchResultsTrain != null) {
            this.f26330b = cJRTrainSearchResultsTrain.getDestination();
            this.f26329a = cJRTrainSearchResultsTrain.getSource();
            this.f26331c = a(cJRTrainRouteBody.getmStationList(), this.f26330b, cJRTrainSearchResultsTrain.getSource());
            this.f26335g = cJRTrainSearchResultsTrain.getDeparture();
        } else {
            this.f26329a = cJRPNRStatusDetails.getmBoardingStation().getmStationCode();
            this.f26330b = cJRPNRStatusDetails.getmReservationUpTo().getmStationCode();
            this.f26331c = a(cJRTrainRouteBody.getmStationList(), cJRPNRStatusDetails.getmReservationUpTo().getmStationCode(), cJRPNRStatusDetails.getmBoardingStation().getmStationCode());
            this.f26335g = cJRPNRStatusDetails.getmDate() + "T" + cJRPNRStatusDetails.getmBoardingStation().getmDepartureTime() + ":00";
        }
        this.f26332d = (LayoutInflater) this.f26334f.getSystemService("layout_inflater");
    }

    /* access modifiers changed from: private */
    public List<CJRStationList> a(List<CJRStationList> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            list.get(i2).setIsDestination(false);
            list.get(i2).setSource(false);
            if (list.get(i2).getmStationCode() != null && list.get(i2).getmStationCode().toLowerCase().equalsIgnoreCase(str2.toLowerCase())) {
                list.get(i2).setSource(true);
                if (this.f26336h) {
                    this.m = i2;
                } else {
                    this.m = 0;
                }
            } else if (list.get(i2).getmStationCode() != null && !TextUtils.isEmpty(str) && list.get(i2).getmStationCode().toLowerCase().equalsIgnoreCase(str.toLowerCase())) {
                list.get(i2).setIsDestination(true);
                arrayList.add(list.get(i2));
                if (!this.f26336h) {
                    this.l = i3 + 1;
                    break;
                }
                this.l = i2;
            }
            if (!this.n) {
                if (this.m != -1) {
                    if (!list.get(i2).isDestination()) {
                        arrayList.add(list.get(i2));
                    }
                    i3++;
                }
            } else if (!list.get(i2).isDestination()) {
                arrayList.add(list.get(i2));
            }
            list.get(i2).setTrainDay((String) null);
            i2++;
        }
        b((List<CJRStationList>) arrayList);
        return arrayList;
    }

    private void b(List<CJRStationList> list) {
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (Integer.parseInt(list.get(i2).getmDayCount()) != this.p) {
                    this.p = Integer.parseInt(list.get(i2).getmDayCount());
                    list.get(i2).setTrainDay(list.get(i2).getmDayCount());
                }
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f26337i) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_view_route_item_lyt, viewGroup, false));
        }
        if (i2 == this.j) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_train_view_route_source, viewGroup, false));
        }
        if (i2 != this.k) {
            return null;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f26334f);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setGravity(17);
        return new c(relativeLayout);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        if (vVar instanceof b) {
            CJRStationList cJRStationList = this.f26331c.get(i2);
            if (i2 % 2 == 0) {
                ((b) vVar).itemView.setBackgroundColor(this.f26334f.getResources().getColor(R.color.account_separtor_bg));
            } else {
                ((b) vVar).itemView.setBackgroundColor(this.f26334f.getResources().getColor(R.color.white));
            }
            b bVar = (b) vVar;
            TextView textView = bVar.f26346a;
            textView.setText(o.a(cJRStationList.getmStationName().trim()) + " - " + cJRStationList.getmStationCode().trim());
            bVar.f26349d.setVisibility(0);
            TextView textView2 = bVar.f26349d;
            String str2 = cJRStationList.getmHaltTime();
            if (str2 == null || str2.equals("--")) {
                str = "--   ";
            } else {
                String[] split = str2.split(AppConstants.COLON);
                int parseInt = (Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60)) / 60;
                if (String.valueOf(parseInt).length() == 1) {
                    str = v.a("0", String.valueOf(parseInt), " ", this.f26334f.getString(R.string.train_mins_txt));
                } else {
                    str = v.a(String.valueOf(parseInt), " ", this.f26334f.getString(R.string.train_mins_txt));
                }
            }
            textView2.setText(str);
            bVar.f26347b.setText(cJRStationList.getmArrivalTime());
            bVar.f26348c.setText(cJRStationList.getmDepartureTime());
            cJRStationList.getmDayCount();
            com.paytm.utility.b.j();
            if (cJRStationList.getTrainDay() != null) {
                TextView textView3 = bVar.f26350e;
                textView3.setText(this.f26334f.getString(R.string.day_text) + " " + cJRStationList.getTrainDay());
                bVar.f26346a.setTypeface(Typeface.create("sans-serif-medium", 1));
                bVar.f26349d.setTypeface(Typeface.create("sans-serif-medium", 1));
                bVar.f26347b.setTypeface(Typeface.create("sans-serif-medium", 1));
                bVar.f26348c.setTypeface(Typeface.create("sans-serif-medium", 1));
                return;
            }
            bVar.f26350e.setText("");
            bVar.f26346a.setTypeface(Typeface.create("sans-serif", 0));
            bVar.f26349d.setTypeface(Typeface.create("sans-serif", 0));
            bVar.f26347b.setTypeface(Typeface.create("sans-serif", 0));
            bVar.f26348c.setTypeface(Typeface.create("sans-serif", 0));
        } else if (vVar instanceof a) {
            CJRStationList cJRStationList2 = this.f26331c.get(i2);
            a aVar = (a) vVar;
            aVar.f26339b.setBackgroundColor(this.f26334f.getResources().getColor(R.color.white));
            aVar.f26343f.setBackgroundColor(this.f26334f.getResources().getColor(R.color.white));
            if (cJRStationList2.isDestination()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f26340c.getLayoutParams();
                layoutParams.weight = 1.5f;
                aVar.f26340c.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f26341d.getLayoutParams();
                layoutParams2.weight = 3.5f;
                aVar.f26341d.setLayoutParams(layoutParams2);
                aVar.f26341d.setPadding(0, 0, 15, 0);
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) aVar.f26340c.getLayoutParams();
                layoutParams3.weight = 3.5f;
                aVar.f26340c.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) aVar.f26341d.getLayoutParams();
                layoutParams4.weight = 1.5f;
                aVar.f26341d.setLayoutParams(layoutParams4);
                aVar.f26341d.setPadding(0, 0, 17, 0);
            }
            TextView textView4 = aVar.f26339b;
            textView4.setText(o.a(cJRStationList2.getmStationName().trim()) + " - " + cJRStationList2.getmStationCode().trim());
            if (cJRStationList2.getmDayCount() != null) {
                int parseInt2 = Integer.parseInt(cJRStationList2.getmDayCount());
                if (i2 == this.l) {
                    aVar.f26341d.setVisibility(0);
                    aVar.f26341d.setText(a(parseInt2 - this.o));
                    aVar.f26340c.setText(cJRStationList2.getmArrivalTime());
                } else {
                    this.o = Integer.parseInt(cJRStationList2.getmDayCount());
                    aVar.f26340c.setVisibility(0);
                    aVar.f26340c.setText(i.a(this.f26335g));
                    aVar.f26341d.setText(cJRStationList2.getmDepartureTime());
                }
            }
            cJRStationList2.getmDayCount();
            com.paytm.utility.b.j();
            if (cJRStationList2.getTrainDay() != null) {
                TextView textView5 = aVar.f26344g;
                textView5.setText(this.f26334f.getString(R.string.day_text) + " " + cJRStationList2.getTrainDay());
            } else {
                aVar.f26344g.setText("");
            }
            aVar.f26338a.setVisibility(0);
            aVar.f26339b.setTextColor(androidx.core.content.b.c(this.f26334f, R.color.black));
            aVar.f26340c.setTextColor(androidx.core.content.b.c(this.f26334f, R.color.black));
            aVar.f26341d.setTextColor(androidx.core.content.b.c(this.f26334f, R.color.black));
            aVar.f26339b.setTypeface(w.a(this.f26334f, "Roboto-Medium.ttf"));
            aVar.f26340c.setTypeface(w.a(this.f26334f, "Roboto-Medium.ttf"));
            aVar.f26341d.setTypeface(w.a(this.f26334f, "Roboto-Medium.ttf"));
            if (cJRStationList2.isDestination()) {
                aVar.f26338a.setImageDrawable(this.f26334f.getResources().getDrawable(R.drawable.pre_t_route_destination));
            } else if (cJRStationList2.isSource()) {
                aVar.f26338a.setImageDrawable(this.f26334f.getResources().getDrawable(R.drawable.pre_t_route_source));
            }
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) aVar.f26339b.getLayoutParams();
            layoutParams5.leftMargin = (int) this.f26334f.getResources().getDimension(R.dimen.margin_default);
            aVar.f26339b.setLayoutParams(layoutParams5);
        } else if (!(vVar instanceof c)) {
        } else {
            if (!this.n) {
                c cVar = (c) vVar;
                cVar.f26351a.setText(this.f26334f.getString(R.string.show_all_stations_of_this_route));
                if (this.f26336h || i2 == this.f26333e.size()) {
                    cVar.f26351a.setVisibility(8);
                } else {
                    cVar.f26351a.setVisibility(0);
                }
            } else {
                ((c) vVar).f26351a.setVisibility(8);
            }
        }
    }

    private String a(int i2) {
        if (this.f26335g != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                long time = simpleDateFormat.parse(this.f26335g).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                return i.a(simpleDateFormat.format(new Date(time)));
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    public final int getItemCount() {
        if (this.l != -1) {
            return this.f26331c.size() + 1;
        }
        return this.f26331c.size();
    }

    public final void a(List<CJRStationList> list) {
        this.f26331c = list;
        this.l = -1;
        this.f26336h = true;
        this.m = -1;
        this.p = 0;
        a(this.f26331c, this.f26330b, this.f26329a);
        notifyDataSetChanged();
        this.n = true;
    }

    static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f26346a;

        /* renamed from: b  reason: collision with root package name */
        TextView f26347b;

        /* renamed from: c  reason: collision with root package name */
        TextView f26348c;

        /* renamed from: d  reason: collision with root package name */
        TextView f26349d;

        /* renamed from: e  reason: collision with root package name */
        TextView f26350e;

        public b(View view) {
            super(view);
            this.f26346a = (TextView) view.findViewById(R.id.view_route_source_name);
            this.f26347b = (TextView) view.findViewById(R.id.view_route_source_train_arival_time);
            this.f26348c = (TextView) view.findViewById(R.id.view_route_source_train_departure_time);
            this.f26349d = (TextView) view.findViewById(R.id.view_route_source_train_halt_time);
            this.f26350e = (TextView) view.findViewById(R.id.train_day);
        }
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f26338a = ((ImageView) this.itemView.findViewById(R.id.view_route_source_icon));

        /* renamed from: b  reason: collision with root package name */
        TextView f26339b = ((TextView) this.itemView.findViewById(R.id.view_route_source_name));

        /* renamed from: c  reason: collision with root package name */
        TextView f26340c = ((TextView) this.itemView.findViewById(R.id.view_route_source_train_arival_time));

        /* renamed from: d  reason: collision with root package name */
        TextView f26341d = ((TextView) this.itemView.findViewById(R.id.view_route_source_train_departure_time));

        /* renamed from: e  reason: collision with root package name */
        TextView f26342e = ((TextView) this.itemView.findViewById(R.id.view_route_source_train_halt_time));

        /* renamed from: f  reason: collision with root package name */
        LinearLayout f26343f = ((LinearLayout) this.itemView.findViewById(R.id.parentLyout));

        /* renamed from: g  reason: collision with root package name */
        TextView f26344g = ((TextView) this.itemView.findViewById(R.id.train_day));

        public a(View view) {
            super(view);
        }
    }

    class c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f26351a;

        public c(View view) {
            super(view);
            this.f26351a = new TextView(at.this.f26334f);
            this.f26351a.setGravity(17);
            this.f26351a.setTextSize(14.0f);
            this.f26351a.setPadding(0, 40, 0, 40);
            this.f26351a.setTextColor(at.this.f26334f.getResources().getColor(R.color.color_33b5e5));
            ((RelativeLayout) view).addView(this.f26351a);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            boolean unused = at.this.f26336h = true;
            int unused2 = at.this.p = 0;
            at atVar = at.this;
            List unused3 = atVar.f26331c = atVar.a(atVar.f26333e, at.this.f26330b, at.this.f26329a);
            at.this.notifyDataSetChanged();
        }
    }

    public final int getItemViewType(int i2) {
        boolean z = false;
        if (i2 == this.l || i2 == this.m) {
            return this.j;
        }
        if (i2 == this.f26331c.size()) {
            z = true;
        }
        if (z) {
            return this.k;
        }
        return this.f26337i;
    }
}
