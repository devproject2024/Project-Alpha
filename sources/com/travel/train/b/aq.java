package com.travel.train.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.fragment.ag;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class aq extends RecyclerView.a<a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    List<? extends CJRTrainLSSearchResult.Schedule> f26289a;

    /* renamed from: b  reason: collision with root package name */
    List<? extends CJRTrainLSSearchResult.Schedule> f26290b;

    /* renamed from: c  reason: collision with root package name */
    boolean f26291c;

    /* renamed from: d  reason: collision with root package name */
    private String f26292d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f26293e;

    /* renamed from: f  reason: collision with root package name */
    private com.travel.train.k.a f26294f;

    /* renamed from: g  reason: collision with root package name */
    private FragmentActivity f26295g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f26296h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainLSSearchResult.Schedule f26297i;
    private String j;
    private int k;
    private Boolean l;
    private ag m;

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f26304a = new c();

        c() {
        }

        public final void onClick(View view) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:218:0x030e, code lost:
        if (kotlin.m.p.a(r3, r1 == null ? r1.getStationCode() : null, false) != false) goto L_0x0347;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r10, int r11) {
        /*
            r9 = this;
            com.travel.train.b.aq$a r10 = (com.travel.train.b.aq.a) r10
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r10, r0)
            r0 = 0
            r10.setIsRecyclable(r0)
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r1 = r9.f26289a
            r2 = 0
            if (r1 == 0) goto L_0x0017
            java.lang.Object r1 = r1.get(r11)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            java.lang.String r3 = r9.f26292d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = ""
            r5 = 1
            if (r3 != 0) goto L_0x005e
            if (r1 == 0) goto L_0x002c
            java.lang.String r3 = r1.getStationName()
            goto L_0x002d
        L_0x002c:
            r3 = r2
        L_0x002d:
            java.lang.String r6 = r9.f26292d
            if (r6 == 0) goto L_0x0040
            if (r3 == 0) goto L_0x0040
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r6, (boolean) r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0041
        L_0x0040:
            r3 = r2
        L_0x0041:
            if (r3 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x006f
            android.widget.TextView r3 = r10.f26300c
            if (r3 == 0) goto L_0x006f
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            android.content.Context r6 = (android.content.Context) r6
            int r7 = com.travel.train.R.color.color_e2ff00
            int r6 = androidx.core.content.b.c(r6, r7)
            r3.setBackgroundColor(r6)
            goto L_0x006f
        L_0x005e:
            java.lang.String r3 = r9.f26292d
            if (r3 == 0) goto L_0x006f
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r0)
            if (r3 == 0) goto L_0x006f
            android.widget.TextView r3 = r10.f26300c
            if (r3 == 0) goto L_0x006f
            r3.setBackgroundColor(r0)
        L_0x006f:
            if (r1 == 0) goto L_0x0076
            java.lang.String r3 = r1.getStationCode()
            goto L_0x0077
        L_0x0076:
            r3 = r2
        L_0x0077:
            java.lang.String r6 = r9.f26293e
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r0)
            if (r3 == 0) goto L_0x0087
            if (r1 != 0) goto L_0x0084
            kotlin.g.b.k.a()
        L_0x0084:
            r9.a((com.travel.train.b.aq.a) r10, (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1)
        L_0x0087:
            androidx.constraintlayout.widget.ConstraintLayout r3 = r10.f26298a
            if (r3 == 0) goto L_0x0095
            com.travel.train.b.aq$d r6 = new com.travel.train.b.aq$d
            r6.<init>(r9, r1, r10)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r3.setOnClickListener(r6)
        L_0x0095:
            android.widget.TextView r3 = r10.f26299b
            if (r3 == 0) goto L_0x00a8
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.dimen.dimen_14sp
            float r6 = r6.getDimension(r7)
            r3.setTextSize(r0, r6)
        L_0x00a8:
            android.widget.TextView r3 = r10.f26299b
            if (r3 == 0) goto L_0x00b9
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            android.content.Context r6 = (android.content.Context) r6
            int r7 = com.travel.train.R.color.color_2d2d2d
            int r6 = androidx.core.content.b.c(r6, r7)
            r3.setTextColor(r6)
        L_0x00b9:
            android.widget.TextView r3 = r10.f26299b
            if (r3 == 0) goto L_0x00ca
            if (r1 == 0) goto L_0x00c4
            java.lang.String r6 = r1.getStationCode()
            goto L_0x00c5
        L_0x00c4:
            r6 = r2
        L_0x00c5:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x00ca:
            android.widget.TextView r3 = r10.f26300c
            if (r3 == 0) goto L_0x00db
            if (r1 == 0) goto L_0x00d5
            java.lang.String r6 = r1.getStationName()
            goto L_0x00d6
        L_0x00d5:
            r6 = r2
        L_0x00d6:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x00db:
            android.widget.TextView r3 = r10.f26300c
            if (r3 == 0) goto L_0x00ec
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            android.content.Context r6 = (android.content.Context) r6
            int r7 = com.travel.train.R.color.color_2d2d2d
            int r6 = androidx.core.content.b.c(r6, r7)
            r3.setTextColor(r6)
        L_0x00ec:
            android.widget.TextView r3 = r10.f26299b
            if (r3 == 0) goto L_0x00ff
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.dimen.dimen_14sp
            float r6 = r6.getDimension(r7)
            r3.setTextSize(r0, r6)
        L_0x00ff:
            android.widget.TextView r3 = r10.f26301d
            if (r3 == 0) goto L_0x0106
            r3.setVisibility(r0)
        L_0x0106:
            android.widget.TextView r3 = r10.f26302e
            if (r3 == 0) goto L_0x010d
            r3.setVisibility(r0)
        L_0x010d:
            java.lang.Boolean r3 = r9.l
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x015d
            if (r1 == 0) goto L_0x011e
            java.lang.String r3 = r1.getDayCount()
            goto L_0x011f
        L_0x011e:
            r3 = r2
        L_0x011f:
            if (r3 == 0) goto L_0x015d
            if (r1 == 0) goto L_0x0132
            java.lang.String r3 = r1.getDayCount()
            if (r3 == 0) goto L_0x0132
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0133
        L_0x0132:
            r3 = r2
        L_0x0133:
            if (r3 != 0) goto L_0x0138
            kotlin.g.b.k.a()
        L_0x0138:
            int r3 = r3.intValue()
            int r6 = r9.k
            int r3 = r3 - r6
            java.lang.String r6 = r9.j
            java.lang.String r3 = com.travel.train.j.i.a((java.lang.String) r6, (int) r3)
            boolean r6 = r9.f26291c
            if (r6 != 0) goto L_0x0153
            android.widget.TextView r6 = r10.f26302e
            if (r6 == 0) goto L_0x0184
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
            goto L_0x0184
        L_0x0153:
            android.widget.TextView r6 = r10.f26302e
            if (r6 == 0) goto L_0x0184
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
            goto L_0x0184
        L_0x015d:
            android.widget.TextView r3 = r10.f26302e
            if (r3 == 0) goto L_0x0184
            androidx.fragment.app.FragmentActivity r6 = r9.f26295g
            if (r6 == 0) goto L_0x0172
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L_0x0172
            int r7 = com.travel.train.R.string.train_ls_day_count
            java.lang.String r6 = r6.getString(r7)
            goto L_0x0173
        L_0x0172:
            r6 = r2
        L_0x0173:
            if (r1 == 0) goto L_0x017a
            java.lang.String r7 = r1.getDayCount()
            goto L_0x017b
        L_0x017a:
            r7 = r2
        L_0x017b:
            java.lang.String r6 = kotlin.g.b.k.a((java.lang.String) r6, (java.lang.Object) r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0184:
            boolean r3 = r9.f26291c
            java.lang.String r6 = ", "
            java.lang.String r7 = "--"
            if (r3 != 0) goto L_0x01c1
            android.widget.TextView r3 = r10.f26301d
            if (r3 == 0) goto L_0x01f5
            if (r1 == 0) goto L_0x0197
            java.lang.String r8 = r1.getDepartureTime()
            goto L_0x0198
        L_0x0197:
            r8 = r2
        L_0x0198:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01bb
            if (r1 == 0) goto L_0x01a7
            java.lang.String r8 = r1.getDepartureTime()
            goto L_0x01a8
        L_0x01a7:
            r8 = r2
        L_0x01a8:
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r7)
            r7 = r7 ^ r5
            if (r7 == 0) goto L_0x01bb
            if (r1 == 0) goto L_0x01b6
            java.lang.String r4 = r1.getDepartureTime()
            goto L_0x01b7
        L_0x01b6:
            r4 = r2
        L_0x01b7:
            java.lang.String r4 = kotlin.g.b.k.a((java.lang.String) r4, (java.lang.Object) r6)
        L_0x01bb:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x01f5
        L_0x01c1:
            android.widget.TextView r3 = r10.f26301d
            if (r3 == 0) goto L_0x01f5
            if (r1 == 0) goto L_0x01cc
            java.lang.String r8 = r1.getArrivalTime()
            goto L_0x01cd
        L_0x01cc:
            r8 = r2
        L_0x01cd:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01f0
            if (r1 == 0) goto L_0x01dc
            java.lang.String r8 = r1.getArrivalTime()
            goto L_0x01dd
        L_0x01dc:
            r8 = r2
        L_0x01dd:
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r7)
            r7 = r7 ^ r5
            if (r7 == 0) goto L_0x01f0
            if (r1 == 0) goto L_0x01eb
            java.lang.String r4 = r1.getArrivalTime()
            goto L_0x01ec
        L_0x01eb:
            r4 = r2
        L_0x01ec:
            java.lang.String r4 = kotlin.g.b.k.a((java.lang.String) r4, (java.lang.Object) r6)
        L_0x01f0:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x01f5:
            android.widget.TextView r3 = r10.f26301d
            if (r3 == 0) goto L_0x0206
            androidx.fragment.app.FragmentActivity r4 = r9.f26295g
            android.content.Context r4 = (android.content.Context) r4
            int r6 = com.travel.train.R.color.color_2d2d2d
            int r4 = androidx.core.content.b.c(r4, r6)
            r3.setTextColor(r4)
        L_0x0206:
            android.widget.TextView r3 = r10.f26299b
            if (r3 == 0) goto L_0x0219
            androidx.fragment.app.FragmentActivity r4 = r9.f26295g
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.travel.train.R.dimen.dimen_14sp
            float r4 = r4.getDimension(r6)
            r3.setTextSize(r0, r4)
        L_0x0219:
            boolean r3 = r9.f26291c
            r4 = 6
            if (r3 != 0) goto L_0x027e
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r3 = r9.f26289a
            if (r3 == 0) goto L_0x027e
            java.lang.Object r3 = r3.get(r11)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r3
            if (r3 == 0) goto L_0x027e
            java.lang.String r3 = r3.getStationCode()
            if (r3 == 0) goto L_0x027e
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r6 = r9.f26290b
            if (r6 == 0) goto L_0x0258
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r7 = r9.f26297i
            if (r7 == 0) goto L_0x0241
            int r7 = r7.getSourceSelectedPosition()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0242
        L_0x0241:
            r7 = r2
        L_0x0242:
            if (r7 != 0) goto L_0x0247
            kotlin.g.b.k.a()
        L_0x0247:
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.get(r7)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r6
            if (r6 == 0) goto L_0x0258
            java.lang.String r6 = r6.getStationCode()
            goto L_0x0259
        L_0x0258:
            r6 = r2
        L_0x0259:
            boolean r3 = r3.equals(r6)
            if (r3 != r5) goto L_0x027e
            androidx.constraintlayout.widget.ConstraintLayout r3 = r10.f26298a
            if (r3 == 0) goto L_0x0268
            int r6 = com.travel.train.R.drawable.blue_border
            r3.setBackgroundResource(r6)
        L_0x0268:
            androidx.recyclerview.widget.RecyclerView r3 = r9.f26296h
            int r6 = r10.getAdapterPosition()
            r3.smoothScrollToPosition(r6)
            int r3 = r10.getAdapterPosition()
            if (r3 <= r4) goto L_0x027e
            com.travel.train.k.a r3 = r9.f26294f
            if (r3 == 0) goto L_0x027e
            r3.a((boolean) r5)
        L_0x027e:
            boolean r3 = r9.f26291c
            if (r3 == 0) goto L_0x02e2
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r3 = r9.f26289a
            if (r3 == 0) goto L_0x02e2
            java.lang.Object r3 = r3.get(r11)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r3
            if (r3 == 0) goto L_0x02e2
            java.lang.String r3 = r3.getStationCode()
            if (r3 == 0) goto L_0x02e2
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r6 = r9.f26290b
            if (r6 == 0) goto L_0x02bc
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r7 = r9.f26297i
            if (r7 == 0) goto L_0x02a5
            int r7 = r7.getDestSelectedPosition()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x02a6
        L_0x02a5:
            r7 = r2
        L_0x02a6:
            if (r7 != 0) goto L_0x02ab
            kotlin.g.b.k.a()
        L_0x02ab:
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.get(r7)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r6
            if (r6 == 0) goto L_0x02bc
            java.lang.String r6 = r6.getStationCode()
            goto L_0x02bd
        L_0x02bc:
            r6 = r2
        L_0x02bd:
            boolean r3 = r3.equals(r6)
            if (r3 != r5) goto L_0x02e2
            androidx.constraintlayout.widget.ConstraintLayout r3 = r10.f26298a
            if (r3 == 0) goto L_0x02cc
            int r6 = com.travel.train.R.drawable.blue_border
            r3.setBackgroundResource(r6)
        L_0x02cc:
            androidx.recyclerview.widget.RecyclerView r3 = r9.f26296h
            int r6 = r10.getAdapterPosition()
            r3.smoothScrollToPosition(r6)
            int r3 = r10.getAdapterPosition()
            if (r3 <= r4) goto L_0x02e2
            com.travel.train.k.a r3 = r9.f26294f
            if (r3 == 0) goto L_0x02e2
            r3.a((boolean) r5)
        L_0x02e2:
            boolean r3 = r9.f26291c
            if (r3 != 0) goto L_0x0310
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r3 = r9.f26290b
            if (r3 == 0) goto L_0x0301
            if (r3 != 0) goto L_0x02ef
            kotlin.g.b.k.a()
        L_0x02ef:
            int r4 = r3.size()
            int r4 = r4 - r5
            java.lang.Object r3 = r3.get(r4)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r3
            if (r3 == 0) goto L_0x0301
            java.lang.String r3 = r3.getStationCode()
            goto L_0x0302
        L_0x0301:
            r3 = r2
        L_0x0302:
            if (r1 == 0) goto L_0x0309
            java.lang.String r1 = r1.getStationCode()
            goto L_0x030a
        L_0x0309:
            r1 = r2
        L_0x030a:
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r0)
            if (r1 != 0) goto L_0x0347
        L_0x0310:
            boolean r1 = r9.f26291c
            if (r1 == 0) goto L_0x0363
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r9.f26297i
            if (r1 == 0) goto L_0x0321
            int r1 = r1.getSourceSelectedPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0322
        L_0x0321:
            r1 = r2
        L_0x0322:
            if (r1 != 0) goto L_0x0327
            kotlin.g.b.k.a()
        L_0x0327:
            int r1 = r1.intValue()
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r3 = r9.f26289a
            if (r3 == 0) goto L_0x033b
            java.lang.Object r11 = r3.get(r11)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r11 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r11
            if (r11 == 0) goto L_0x033b
            java.lang.String r2 = r11.getStnSerialNumber()
        L_0x033b:
            if (r2 != 0) goto L_0x0340
            kotlin.g.b.k.a()
        L_0x0340:
            int r11 = java.lang.Integer.parseInt(r2)
            int r11 = r11 - r5
            if (r1 < r11) goto L_0x0363
        L_0x0347:
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.f26298a
            if (r11 == 0) goto L_0x034e
            r11.setEnabled(r0)
        L_0x034e:
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.f26298a
            if (r11 == 0) goto L_0x0359
            com.travel.train.b.aq$c r0 = com.travel.train.b.aq.c.f26304a
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r11.setOnClickListener(r0)
        L_0x0359:
            androidx.constraintlayout.widget.ConstraintLayout r10 = r10.f26298a
            if (r10 == 0) goto L_0x0363
            r11 = 1050253722(0x3e99999a, float:0.3)
            r10.setAlpha(r11)
        L_0x0363:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.aq.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f26295g).inflate(R.layout.pre_t_search_by_train_booking_bs_adapter_item, viewGroup, false);
        inflate.setPadding((int) this.f26295g.getResources().getDimension(R.dimen.dimen_16dp), (int) this.f26295g.getResources().getDimension(R.dimen.dimen_16dp), 0, (int) this.f26295g.getResources().getDimension(R.dimen.dimen_16dp));
        if (inflate == null) {
            k.a();
        }
        return new a(inflate);
    }

    public aq(FragmentActivity fragmentActivity, RecyclerView recyclerView, List<? extends CJRTrainLSSearchResult.Schedule> list, boolean z, CJRTrainLSSearchResult.Schedule schedule, String str, int i2, Boolean bool, ag agVar) {
        k.c(fragmentActivity, "mActivity");
        k.c(recyclerView, "stationList");
        this.f26295g = fragmentActivity;
        this.f26296h = recyclerView;
        this.f26290b = list;
        this.f26291c = z;
        this.f26297i = schedule;
        this.j = str;
        this.k = i2;
        this.l = bool;
        this.m = agVar;
        FragmentActivity fragmentActivity2 = this.f26295g;
        if (fragmentActivity2 != null) {
            this.f26294f = (com.travel.train.k.a) am.a(fragmentActivity2, (al.b) new g(new g.a(g.b.LS).a(com.travel.train.a.a.f25797a.a(new com.travel.train.a.a.a(fragmentActivity2))))).a(com.travel.train.k.a.class);
        }
        this.f26289a = this.f26290b;
    }

    public final int getItemCount() {
        List<? extends CJRTrainLSSearchResult.Schedule> list = this.f26289a;
        if (list == null) {
            return 0;
        }
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aq f26305a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRTrainLSSearchResult.Schedule f26306b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f26307c;

        d(aq aqVar, CJRTrainLSSearchResult.Schedule schedule, a aVar) {
            this.f26305a = aqVar;
            this.f26306b = schedule;
            this.f26307c = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                com.travel.train.b.aq r4 = r3.f26305a
                boolean r4 = r4.f26291c
                r0 = 0
                r1 = 0
                if (r4 != 0) goto L_0x0057
                com.travel.train.b.aq r4 = r3.f26305a
                java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r4 = r4.f26290b
                if (r4 == 0) goto L_0x002a
                com.travel.train.b.aq r2 = r3.f26305a
                java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r2 = r2.f26290b
                if (r2 != 0) goto L_0x0017
                kotlin.g.b.k.a()
            L_0x0017:
                int r2 = r2.size()
                int r2 = r2 + -1
                java.lang.Object r4 = r4.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
                if (r4 == 0) goto L_0x002a
                java.lang.String r4 = r4.getStationCode()
                goto L_0x002b
            L_0x002a:
                r4 = r1
            L_0x002b:
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r3.f26306b
                if (r2 == 0) goto L_0x0034
                java.lang.String r2 = r2.getStationCode()
                goto L_0x0035
            L_0x0034:
                r2 = r1
            L_0x0035:
                boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r0)
                if (r4 != 0) goto L_0x0057
                com.travel.train.b.aq r4 = r3.f26305a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r3.f26306b
                if (r0 == 0) goto L_0x0045
                java.lang.String r1 = r0.getStationCode()
            L_0x0045:
                r4.f26293e = r1
                com.travel.train.b.aq r4 = r3.f26305a
                com.travel.train.b.aq$a r0 = r3.f26307c
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r3.f26306b
                if (r1 != 0) goto L_0x0053
                kotlin.g.b.k.a()
            L_0x0053:
                r4.a((com.travel.train.b.aq.a) r0, (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1)
                return
            L_0x0057:
                com.travel.train.b.aq r4 = r3.f26305a
                boolean r4 = r4.f26291c
                if (r4 == 0) goto L_0x009c
                com.travel.train.b.aq r4 = r3.f26305a
                java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r4 = r4.f26290b
                if (r4 == 0) goto L_0x0070
                java.lang.Object r4 = r4.get(r0)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
                if (r4 == 0) goto L_0x0070
                java.lang.String r4 = r4.getStationCode()
                goto L_0x0071
            L_0x0070:
                r4 = r1
            L_0x0071:
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r3.f26306b
                if (r2 == 0) goto L_0x007a
                java.lang.String r2 = r2.getStationCode()
                goto L_0x007b
            L_0x007a:
                r2 = r1
            L_0x007b:
                boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r0)
                if (r4 != 0) goto L_0x009c
                com.travel.train.b.aq r4 = r3.f26305a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r3.f26306b
                if (r0 == 0) goto L_0x008b
                java.lang.String r1 = r0.getStationCode()
            L_0x008b:
                r4.f26293e = r1
                com.travel.train.b.aq r4 = r3.f26305a
                com.travel.train.b.aq$a r0 = r3.f26307c
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r3.f26306b
                if (r1 != 0) goto L_0x0099
                kotlin.g.b.k.a()
            L_0x0099:
                r4.a((com.travel.train.b.aq.a) r0, (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r1)
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.aq.d.onClick(android.view.View):void");
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f26298a;

        /* renamed from: b  reason: collision with root package name */
        TextView f26299b;

        /* renamed from: c  reason: collision with root package name */
        TextView f26300c;

        /* renamed from: d  reason: collision with root package name */
        TextView f26301d;

        /* renamed from: e  reason: collision with root package name */
        TextView f26302e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.main_lyt);
            if (findViewById != null) {
                this.f26298a = (ConstraintLayout) findViewById;
                View findViewById2 = view.findViewById(R.id.train_no_txt);
                if (findViewById2 != null) {
                    this.f26299b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.train_name_txt);
                    if (findViewById3 != null) {
                        this.f26300c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.time_txt);
                        if (findViewById4 != null) {
                            this.f26301d = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.date_txt);
                            if (findViewById5 != null) {
                                this.f26302e = (TextView) findViewById5;
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }
    }

    public final void a(String str) {
        k.c(str, "mSearchedTxt");
        this.f26292d = str;
    }

    public static final class b extends Filter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aq f26303a;

        b(aq aqVar) {
            this.f26303a = aqVar;
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() <= 0) {
                List<? extends CJRTrainLSSearchResult.Schedule> list = this.f26303a.f26290b;
                if (list == null) {
                    k.a();
                }
                filterResults.count = list.size();
                filterResults.values = this.f26303a.f26290b;
            } else {
                List arrayList = new ArrayList();
                int i2 = 0;
                List<? extends CJRTrainLSSearchResult.Schedule> list2 = this.f26303a.f26290b;
                if (list2 == null) {
                    k.a();
                }
                int size = list2.size();
                while (i2 < size) {
                    List<? extends CJRTrainLSSearchResult.Schedule> list3 = this.f26303a.f26290b;
                    if (list3 == null) {
                        k.a();
                    }
                    String stationName = ((CJRTrainLSSearchResult.Schedule) list3.get(i2)).getStationName();
                    k.a((Object) stationName, "mBoardingPoints!!.get(i).stationName");
                    if (stationName != null) {
                        String upperCase = stationName.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        CharSequence charSequence2 = upperCase;
                        String obj = charSequence.toString();
                        if (obj != null) {
                            String upperCase2 = obj.toUpperCase();
                            k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                            if (!p.a(charSequence2, (CharSequence) upperCase2, false)) {
                                List<? extends CJRTrainLSSearchResult.Schedule> list4 = this.f26303a.f26290b;
                                if (list4 == null) {
                                    k.a();
                                }
                                String stationCode = ((CJRTrainLSSearchResult.Schedule) list4.get(i2)).getStationCode();
                                k.a((Object) stationCode, "mBoardingPoints!!.get(i).stationCode");
                                if (stationCode != null) {
                                    String upperCase3 = stationCode.toUpperCase();
                                    k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                                    CharSequence charSequence3 = upperCase3;
                                    String obj2 = charSequence.toString();
                                    if (obj2 != null) {
                                        String upperCase4 = obj2.toUpperCase();
                                        k.a((Object) upperCase4, "(this as java.lang.String).toUpperCase()");
                                        if (!p.a(charSequence3, (CharSequence) upperCase4, false)) {
                                            i2++;
                                        }
                                    } else {
                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            List<? extends CJRTrainLSSearchResult.Schedule> list5 = this.f26303a.f26290b;
                            if (list5 == null) {
                                k.a();
                            }
                            arrayList.add(list5.get(i2));
                            i2++;
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            aq aqVar = this.f26303a;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                aqVar.f26289a = (List) obj;
                this.f26303a.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.List<com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule>");
        }
    }

    public final Filter getFilter() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r3 = (r3 = r3.f26302e).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.train.b.aq.a r3, com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule r4) {
        /*
            r2 = this;
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.f26298a
            if (r0 == 0) goto L_0x0009
            int r1 = com.travel.train.R.drawable.blue_border
            r0.setBackgroundResource(r1)
        L_0x0009:
            boolean r0 = r2.f26291c
            if (r0 != 0) goto L_0x0032
            com.travel.train.k.a r0 = r2.f26294f
            if (r0 == 0) goto L_0x0026
            if (r3 == 0) goto L_0x0022
            android.widget.TextView r3 = r3.f26302e
            if (r3 == 0) goto L_0x0022
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x0022
            java.lang.String r3 = r3.toString()
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            r0.a((java.lang.String) r3)
        L_0x0026:
            com.travel.train.k.a r3 = r2.f26294f
            if (r3 == 0) goto L_0x003d
            int r4 = r4.getDefaultStationPosition()
            r3.a((int) r4)
            goto L_0x003d
        L_0x0032:
            com.travel.train.k.a r3 = r2.f26294f
            if (r3 == 0) goto L_0x003d
            int r4 = r4.getDefaultStationPosition()
            r3.b(r4)
        L_0x003d:
            com.travel.train.fragment.ag r3 = r2.m
            if (r3 == 0) goto L_0x0044
            r3.a()
        L_0x0044:
            com.travel.train.fragment.ag r3 = r2.m
            if (r3 == 0) goto L_0x004b
            r3.dismiss()
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.aq.a(com.travel.train.b.aq$a, com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule):void");
    }
}
