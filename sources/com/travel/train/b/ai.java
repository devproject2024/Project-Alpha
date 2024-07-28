package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.i.a;
import com.travel.train.model.CJROfferItems;
import com.travel.train.model.h;
import com.travel.train.model.i;
import com.travel.train.model.trainticket.CJRTrainLSStation;
import com.travel.train.viewholder.aw;
import com.travel.train.viewholder.bb;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class ai extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<i> f26214a;

    /* renamed from: b  reason: collision with root package name */
    private Context f26215b;

    /* renamed from: c  reason: collision with root package name */
    private String f26216c;

    /* renamed from: d  reason: collision with root package name */
    private String f26217d;

    /* renamed from: e  reason: collision with root package name */
    private String f26218e;

    /* renamed from: f  reason: collision with root package name */
    private String f26219f;

    /* renamed from: g  reason: collision with root package name */
    private String f26220g;

    /* renamed from: h  reason: collision with root package name */
    private String f26221h;

    /* renamed from: i  reason: collision with root package name */
    private int f26222i;
    private String j;
    private String k;
    private boolean l;
    private int m = 1;
    private a n;
    private LayoutInflater o;

    public ai(Context context, List<CJRTrainLSStation> list, String str, String str2, String str3, String str4, int i2, String str5, String str6, boolean z, String str7, String str8, a aVar) {
        this.f26215b = context;
        this.f26216c = str;
        this.f26217d = str2;
        this.f26218e = str3;
        this.f26222i = i2;
        this.j = str5;
        this.k = str6;
        this.f26219f = str4;
        this.f26220g = str7;
        this.l = z;
        this.f26221h = str8;
        this.n = aVar;
        this.o = LayoutInflater.from(context);
        this.f26214a = new ArrayList();
        for (CJRTrainLSStation hVar : list) {
            this.f26214a.add(new h(hVar));
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new bb(this.o.inflate(R.layout.pre_t_lyt_train_ls_item, viewGroup, false), this.f26215b);
        }
        if (i2 != 2) {
            return null;
        }
        return new aw(this.f26215b, this.o.inflate(R.layout.pre_t_train_live_status_bottom_banner, viewGroup, false), this.n);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        boolean z;
        RecyclerView.v vVar2 = vVar;
        int i4 = i2;
        if (vVar2 != null) {
            vVar2.setIsRecyclable(false);
            boolean z2 = i4 < this.f26222i;
            int itemViewType = getItemViewType(i4);
            i iVar = this.f26214a.get(i4);
            if (itemViewType == 1) {
                CJRTrainLSStation cJRTrainLSStation = (CJRTrainLSStation) iVar.b();
                bb bbVar = (bb) vVar2;
                String str = this.f26216c;
                String str2 = this.f26217d;
                String str3 = this.f26218e;
                String str4 = this.f26219f;
                String str5 = this.j;
                String str6 = this.k;
                String str7 = this.f26220g;
                String str8 = this.f26221h;
                bbVar.r.setVisibility(8);
                bbVar.s.setVisibility(8);
                bbVar.x.setVisibility(8);
                if (i4 == 0) {
                    bbVar.f27928c.setVisibility(0);
                } else {
                    bbVar.f27928c.setVisibility(8);
                }
                bbVar.t.setVisibility(8);
                if (!TextUtils.isEmpty(str4) && cJRTrainLSStation.getStationCode().equalsIgnoreCase(str4)) {
                    bbVar.t.setVisibility(0);
                    bbVar.x.setVisibility(0);
                }
                bbVar.u.setVisibility(8);
                if (TextUtils.isEmpty(str7) || !cJRTrainLSStation.getStationCode().equalsIgnoreCase(str7)) {
                    i3 = 0;
                } else {
                    i3 = 0;
                    bbVar.u.setVisibility(0);
                    bbVar.x.setVisibility(0);
                }
                if (cJRTrainLSStation.getIsChanged()) {
                    bbVar.f27932g.setVisibility(i3);
                } else {
                    bbVar.f27932g.setVisibility(8);
                }
                if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase(cJRTrainLSStation.getStationCode())) {
                    if (z2) {
                        bbVar.v.setVisibility(4);
                        bbVar.f27929d.setVisibility(0);
                        bbVar.f27926a.setVisibility(4);
                        bbVar.a(false);
                        z = true;
                    } else {
                        bbVar.w.setVisibility(4);
                        bbVar.f27929d.setVisibility(4);
                        bbVar.f27926a.setVisibility(0);
                        bbVar.a(false);
                        z = false;
                    }
                    try {
                        if (!TextUtils.isEmpty(cJRTrainLSStation.getArrivalTime()) && !cJRTrainLSStation.getArrivalTime().equalsIgnoreCase("--") && !TextUtils.isEmpty(cJRTrainLSStation.getActualArrivalDate()) && !TextUtils.isEmpty(cJRTrainLSStation.getActualArrivalTime()) && !TextUtils.isEmpty(str8) && str8.equalsIgnoreCase(cJRTrainLSStation.getStationCode())) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HH:mm", Locale.ENGLISH);
                            Date parse = simpleDateFormat.parse(cJRTrainLSStation.getActualArrivalDate() + "T" + cJRTrainLSStation.getActualArrivalTime());
                            Date parse2 = simpleDateFormat.parse(str5 + "T" + cJRTrainLSStation.getArrivalTime());
                            if (cJRTrainLSStation.getDayCount() != null && Integer.parseInt(cJRTrainLSStation.getDayCount()) > 1) {
                                String dayCount = cJRTrainLSStation.getDayCount();
                                Calendar instance = Calendar.getInstance();
                                instance.setTime(parse2);
                                instance.add(5, Integer.parseInt(dayCount) - 1);
                                parse2 = instance.getTime();
                            }
                            long abs = Math.abs(parse.getTime() - parse2.getTime());
                            int i5 = (int) (abs / 86400000);
                            long j2 = abs - ((long) (86400000 * i5));
                            int i6 = (int) (j2 / 3600000);
                            int i7 = ((int) (j2 - ((long) (3600000 * i6)))) / 60000;
                            if (((i5 > 0) | (i6 > 0)) || (i7 > 0)) {
                                bbVar.r.setVisibility(0);
                                bbVar.s.setVisibility(0);
                            }
                            if (i5 > 0) {
                                bbVar.o.setText(String.valueOf(i5));
                                bbVar.p.setText(bbVar.n.getResources().getString(R.string.train_ls_day));
                            } else if (i6 > 0) {
                                bbVar.o.setText(String.valueOf(i6));
                                bbVar.p.setText(bbVar.n.getResources().getString(R.string.train_ls_hour));
                            } else if (i7 > 0) {
                                bbVar.o.setText(String.valueOf(i7));
                                bbVar.p.setText(bbVar.n.getResources().getString(R.string.train_ls_min));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Delay");
                            if (!TextUtils.isEmpty(str6)) {
                                sb.append("(updated ");
                                sb.append(str6);
                                sb.append(")");
                            }
                            bbVar.q.setText(sb.toString());
                        }
                    } catch (Exception e2) {
                        e2.getStackTrace();
                    }
                } else {
                    bbVar.w.setVisibility(0);
                    bbVar.f27929d.setVisibility(4);
                    bbVar.f27926a.setVisibility(4);
                    bbVar.a(true);
                    z = false;
                }
                bbVar.f27933h.setText(bbVar.n.getResources().getString(R.string.train_ls_arrival));
                bbVar.f27933h.setTextColor(b.c(bbVar.n, R.color.color_909090));
                bbVar.f27934i.setText(bbVar.n.getResources().getString(R.string.train_departure_block_live));
                bbVar.f27934i.setTextColor(b.c(bbVar.n, R.color.color_909090));
                bbVar.j.setText(bbVar.n.getResources().getString(R.string.train_ls_platform));
                bbVar.j.setTextColor(b.c(bbVar.n, R.color.color_909090));
                bbVar.f27927b.setVisibility(0);
                TextView textView = bbVar.f27930e;
                textView.setText(cJRTrainLSStation.getStationName() + " (" + cJRTrainLSStation.getStationCode() + ")");
                TextView textView2 = bbVar.f27931f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cJRTrainLSStation.getDistance());
                sb2.append(" km");
                textView2.setText(sb2.toString());
                bbVar.k.setText(cJRTrainLSStation.getActualArrivalTime());
                bbVar.l.setText(cJRTrainLSStation.getActualDepartureTime());
                if (cJRTrainLSStation.getExpectedPlatform() != null) {
                    bbVar.m.setText(cJRTrainLSStation.getExpectedPlatform());
                } else {
                    bbVar.m.setText("");
                }
                if (z) {
                    bbVar.f27927b.setBackgroundColor(b.c(bbVar.n, R.color.color_909090));
                    bbVar.f27930e.setTextColor(b.c(bbVar.n, R.color.color_909090));
                    bbVar.f27931f.setTextColor(b.c(bbVar.n, R.color.color_909090));
                    bbVar.k.setTextColor(b.c(bbVar.n, R.color.color_909090));
                    bbVar.l.setTextColor(b.c(bbVar.n, R.color.color_909090));
                    bbVar.m.setTextColor(b.c(bbVar.n, R.color.color_909090));
                } else {
                    bbVar.f27927b.setBackgroundColor(b.c(bbVar.n, R.color.paytm_blue));
                    bbVar.f27930e.setTextColor(b.c(bbVar.n, R.color.color_222222));
                    bbVar.f27931f.setTextColor(b.c(bbVar.n, R.color.color_222222));
                    bbVar.k.setTextColor(b.c(bbVar.n, R.color.color_222222));
                    bbVar.k.setVisibility(0);
                    bbVar.l.setTextColor(b.c(bbVar.n, R.color.color_222222));
                    bbVar.m.setTextColor(b.c(bbVar.n, R.color.color_222222));
                }
                if (cJRTrainLSStation.getStationCode().equalsIgnoreCase(str)) {
                    bbVar.f27933h.setVisibility(0);
                    bbVar.k.setText(bbVar.n.getResources().getString(R.string.train_ls_source));
                    if (!z2) {
                        bbVar.k.setTextColor(b.c(bbVar.n, R.color.color_0a286d));
                    } else {
                        bbVar.k.setTextColor(b.c(bbVar.n, R.color.color_909090));
                    }
                } else if (cJRTrainLSStation.getStationCode().equalsIgnoreCase(str3)) {
                    bbVar.f27934i.setVisibility(0);
                    bbVar.f27927b.setVisibility(4);
                    bbVar.l.setText(bbVar.n.getResources().getString(R.string.train_ls_destination));
                    bbVar.l.setTextColor(b.c(bbVar.n, R.color.color_0a286d));
                }
                bbVar.f27932g.setText(bb.a(cJRTrainLSStation.getActualArrivalDate()));
                bbVar.y.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                bbVar.f27927b.setMinimumHeight(bbVar.y.getMeasuredHeight());
            } else if (itemViewType == 2) {
                aw awVar = (aw) vVar2;
                awVar.f27883c = (CJROfferItems) iVar.b();
                b.a.C0750a a2 = com.paytm.utility.b.b.a(awVar.f27882b);
                a2.f43753a = awVar.f27883c.getmImageUrl();
                a2.m = true;
                a2.b(Integer.valueOf(R.drawable.homepage_default_icon)).a((Object) Integer.valueOf(R.drawable.homepage_default_icon)).a(awVar.f27881a);
                awVar.f27881a.setPadding(0, 0, 0, 0);
            }
        }
    }

    public final int getItemCount() {
        return this.f26214a.size();
    }

    public final int getItemViewType(int i2) {
        return this.f26214a.get(i2).a();
    }
}
