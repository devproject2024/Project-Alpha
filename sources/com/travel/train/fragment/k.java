package com.travel.train.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.b.s;
import com.travel.train.i.ad;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.u;
import net.one97.paytm.i.f;

public final class k extends f implements ad {

    /* renamed from: a  reason: collision with root package name */
    CJRTrainSearchResultsAlternateStationData f27036a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchResultsTrain f27037b;

    /* renamed from: c  reason: collision with root package name */
    int f27038c;

    /* renamed from: d  reason: collision with root package name */
    private s f27039d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f27040e;

    /* renamed from: f  reason: collision with root package name */
    private ad f27041f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f27042g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27043h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f27044i;
    private TextView j;
    private FrameLayout k;
    private TextView l;
    private Button m;
    private View n;
    private HashMap o;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("clicked_position")) {
                this.f27038c = arguments.getInt("clicked_position");
            }
            if (arguments.containsKey("alternate_station")) {
                Serializable serializable = arguments.getSerializable("alternate_station");
                if (serializable != null) {
                    this.f27036a = (CJRTrainSearchResultsAlternateStationData) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData");
                }
            }
            if (arguments.containsKey("train_detail")) {
                Serializable serializable2 = arguments.getSerializable("train_detail");
                if (serializable2 != null) {
                    this.f27037b = (CJRTrainSearchResultsTrain) serializable2;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSearchResultsTrain");
                }
            }
            if (arguments.containsKey("class_map")) {
                Serializable serializable3 = arguments.getSerializable("class_map");
                if (serializable3 != null) {
                    this.f27040e = (HashMap) serializable3;
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.alternative_option_bottom_sheet_layout, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        r7 = r7.getAlternateStationsData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            super.onViewCreated(r7, r8)
            androidx.fragment.app.Fragment r8 = r6.getParentFragment()
            if (r8 == 0) goto L_0x0017
            boolean r0 = r8 instanceof com.travel.train.i.ad
            if (r0 == 0) goto L_0x0017
            com.travel.train.i.ad r8 = (com.travel.train.i.ad) r8
            r6.f27041f = r8
        L_0x0017:
            int r8 = com.travel.train.R.id.tv_title
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.f27043h = r8
            int r8 = com.travel.train.R.id.train_number
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.f27044i = r8
            int r8 = com.travel.train.R.id.train_name
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.j = r8
            int r8 = com.travel.train.R.id.route_container
            android.view.View r8 = r7.findViewById(r8)
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r6.k = r8
            int r8 = com.travel.train.R.id.station_details_txt
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.l = r8
            int r8 = com.travel.train.R.id.proceed_btn
            android.view.View r8 = r7.findViewById(r8)
            android.widget.Button r8 = (android.widget.Button) r8
            r6.m = r8
            int r8 = com.travel.train.R.id.minimize_container
            android.view.View r8 = r7.findViewById(r8)
            r6.n = r8
            int r8 = com.travel.train.R.id.alternative_recycler
            android.view.View r7 = r7.findViewById(r8)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r6.f27042g = r7
            androidx.recyclerview.widget.LinearLayoutManager r7 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            android.content.Context r8 = (android.content.Context) r8
            r0 = 0
            r7.<init>(r8, r0, r0)
            androidx.recyclerview.widget.RecyclerView r8 = r6.f27042g
            if (r8 == 0) goto L_0x007a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r7
            r8.setLayoutManager(r7)
        L_0x007a:
            android.widget.TextView r7 = r6.f27044i
            java.lang.String r8 = "mTrainDetails"
            if (r7 == 0) goto L_0x0090
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r6.f27037b
            if (r1 != 0) goto L_0x0087
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0087:
            java.lang.String r1 = r1.getTrainNumber()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
        L_0x0090:
            android.widget.TextView r7 = r6.j
            if (r7 == 0) goto L_0x00a4
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r6.f27037b
            if (r1 != 0) goto L_0x009b
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x009b:
            java.lang.String r1 = r1.getTrainName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
        L_0x00a4:
            android.widget.Button r7 = r6.m
            if (r7 == 0) goto L_0x00b2
            com.travel.train.fragment.k$a r1 = new com.travel.train.fragment.k$a
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r7.setOnClickListener(r1)
        L_0x00b2:
            android.view.View r7 = r6.n
            if (r7 == 0) goto L_0x00c0
            com.travel.train.fragment.k$b r1 = new com.travel.train.fragment.k$b
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r7.setOnClickListener(r1)
        L_0x00c0:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r6.f27037b
            if (r7 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00c7:
            if (r7 == 0) goto L_0x015a
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r6.f27037b
            if (r7 != 0) goto L_0x00d0
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00d0:
            java.util.List r7 = r7.getAlternateStationsData()
            if (r7 == 0) goto L_0x015a
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r6.f27037b
            if (r7 != 0) goto L_0x00dd
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00dd:
            r1 = 0
            if (r7 == 0) goto L_0x00ef
            java.util.List r7 = r7.getAlternateStationsData()
            if (r7 == 0) goto L_0x00ef
            int r7 = r7.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x00f0
        L_0x00ef:
            r7 = r1
        L_0x00f0:
            if (r7 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            int r7 = r7.intValue()
            if (r7 <= 0) goto L_0x015a
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r6.f27037b
            if (r7 != 0) goto L_0x0102
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0102:
            if (r7 == 0) goto L_0x0110
            java.util.List r7 = r7.getAlternateStationsData()
            if (r7 == 0) goto L_0x0110
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.j.d r1 = kotlin.a.k.a((java.util.Collection<?>) r7)
        L_0x0110:
            if (r1 != 0) goto L_0x0115
            kotlin.g.b.k.a()
        L_0x0115:
            int r7 = r1.f47939a
            int r1 = r1.f47940b
            if (r7 > r1) goto L_0x015a
        L_0x011b:
            int r2 = r6.f27038c
            if (r7 != r2) goto L_0x013b
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r6.f27037b
            if (r2 != 0) goto L_0x0126
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0126:
            if (r2 == 0) goto L_0x0155
            java.util.List r2 = r2.getAlternateStationsData()
            if (r2 == 0) goto L_0x0155
            java.lang.Object r2 = r2.get(r7)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData) r2
            if (r2 == 0) goto L_0x0155
            r3 = 1
            r2.setSelected(r3)
            goto L_0x0155
        L_0x013b:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r6.f27037b
            if (r2 != 0) goto L_0x0142
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0142:
            if (r2 == 0) goto L_0x0155
            java.util.List r2 = r2.getAlternateStationsData()
            if (r2 == 0) goto L_0x0155
            java.lang.Object r2 = r2.get(r7)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData) r2
            if (r2 == 0) goto L_0x0155
            r2.setSelected(r0)
        L_0x0155:
            if (r7 == r1) goto L_0x015a
            int r7 = r7 + 1
            goto L_0x011b
        L_0x015a:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r6.f27037b
            if (r7 != 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0161:
            if (r7 == 0) goto L_0x018b
            com.travel.train.b.s r7 = new com.travel.train.b.s
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            r2 = r6
            com.travel.train.i.ad r2 = (com.travel.train.i.ad) r2
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r3 = r6.f27037b
            if (r3 != 0) goto L_0x0176
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0176:
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r6.f27040e
            com.travel.train.b.s$a r5 = com.travel.train.b.s.a.EXPANDED_VIEW
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f27039d = r7
            androidx.recyclerview.widget.RecyclerView r7 = r6.f27042g
            if (r7 == 0) goto L_0x018b
            com.travel.train.b.s r8 = r6.f27039d
            androidx.recyclerview.widget.RecyclerView$a r8 = (androidx.recyclerview.widget.RecyclerView.a) r8
            r7.setAdapter(r8)
        L_0x018b:
            r6.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.k.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f27045a;

        a(k kVar) {
            this.f27045a = kVar;
        }

        public final void onClick(View view) {
            k kVar = this.f27045a;
            int i2 = kVar.f27038c;
            CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData = this.f27045a.f27036a;
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27045a.f27037b;
            if (cJRTrainSearchResultsTrain == null) {
                kotlin.g.b.k.a("mTrainDetails");
            }
            kVar.b(i2, cJRTrainSearchResultsAlternateStationData, cJRTrainSearchResultsTrain);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f27046a;

        b(k kVar) {
            this.f27046a = kVar;
        }

        public final void onClick(View view) {
            this.f27046a.dismiss();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:176:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r14 = this;
            android.widget.FrameLayout r0 = r14.k
            if (r0 == 0) goto L_0x0007
            r0.removeAllViews()
        L_0x0007:
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss"
            java.lang.String r1 = "HH:mm, dd MMM"
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r2 = r14.f27036a
            r3 = 0
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.getNewDeparture()
            goto L_0x0017
        L_0x0016:
            r2 = r3
        L_0x0017:
            java.lang.String r2 = com.travel.train.j.i.b((java.lang.String) r2, (java.lang.String) r0, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r4 = r14.f27037b
            java.lang.String r5 = "mTrainDetails"
            if (r4 != 0) goto L_0x0024
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0024:
            java.lang.String r4 = r4.getDeparture()
            java.lang.String r4 = com.travel.train.j.i.b((java.lang.String) r4, (java.lang.String) r0, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r6 = r14.f27037b
            if (r6 != 0) goto L_0x0033
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0033:
            java.lang.String r6 = r6.getArrival()
            java.lang.String r6 = com.travel.train.j.i.b((java.lang.String) r6, (java.lang.String) r0, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r7 = r14.f27036a
            if (r7 == 0) goto L_0x0044
            java.lang.String r7 = r7.getNewArrival()
            goto L_0x0045
        L_0x0044:
            r7 = r3
        L_0x0045:
            java.lang.String r0 = com.travel.train.j.i.b((java.lang.String) r7, (java.lang.String) r0, (java.lang.String) r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r1 = r14.f27036a
            if (r1 == 0) goto L_0x0052
            java.lang.String r1 = r1.getNewSource()
            goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r14.f27037b
            if (r7 != 0) goto L_0x005a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x005a:
            java.lang.String r7 = r7.getSource()
            r8 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r7, (boolean) r8)
            java.lang.String r7 = "activity!!"
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.ImageView"
            java.lang.String r10 = "station.png"
            r11 = 0
            java.lang.String r12 = "null cannot be cast to non-null type android.widget.TextView"
            if (r1 != 0) goto L_0x01a3
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r1 = r14.f27036a
            if (r1 == 0) goto L_0x0078
            java.lang.String r1 = r1.getNewDestination()
            goto L_0x0079
        L_0x0078:
            r1 = r3
        L_0x0079:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r13 = r14.f27037b
            if (r13 != 0) goto L_0x0080
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0080:
            java.lang.String r13 = r13.getDestination()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r13, (boolean) r8)
            if (r1 != 0) goto L_0x01a3
            androidx.fragment.app.FragmentActivity r1 = r14.getActivity()
            if (r1 != 0) goto L_0x0093
            kotlin.g.b.k.a()
        L_0x0093:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            android.view.LayoutInflater r1 = r1.getLayoutInflater()
            int r7 = com.travel.train.R.layout.pre_t_train_alternative_type_1_lyt
            android.view.View r1 = r1.inflate(r7, r3)
            java.lang.String r7 = "activity!!.layoutInflate…rnative_type_1_lyt, null)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r7 = com.travel.train.R.id.source_station
            android.view.View r7 = r1.findViewById(r7)
            if (r7 == 0) goto L_0x019d
            android.widget.TextView r7 = (android.widget.TextView) r7
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r8 = r14.f27036a
            if (r8 == 0) goto L_0x00b8
            java.lang.String r8 = r8.getNewSourceName()
            goto L_0x00b9
        L_0x00b8:
            r8 = r3
        L_0x00b9:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            int r7 = com.travel.train.R.id.boarding_station
            android.view.View r7 = r1.findViewById(r7)
            if (r7 == 0) goto L_0x0197
            android.widget.TextView r7 = (android.widget.TextView) r7
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r8 = r14.f27037b
            if (r8 != 0) goto L_0x00cf
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00cf:
            java.lang.String r8 = r8.getSourceName()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            int r7 = com.travel.train.R.id.dropping_station
            android.view.View r7 = r1.findViewById(r7)
            if (r7 == 0) goto L_0x0191
            android.widget.TextView r7 = (android.widget.TextView) r7
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r8 = r14.f27037b
            if (r8 != 0) goto L_0x00e9
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00e9:
            java.lang.String r5 = r8.getDestinationName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7.setText(r5)
            int r5 = com.travel.train.R.id.destination_station
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x018b
            android.widget.TextView r5 = (android.widget.TextView) r5
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r7 = r14.f27036a
            if (r7 == 0) goto L_0x0105
            java.lang.String r7 = r7.getNewDestinationName()
            goto L_0x0106
        L_0x0105:
            r7 = r3
        L_0x0106:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r5.setText(r7)
            int r5 = com.travel.train.R.id.source_station_time
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x0185
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            int r2 = com.travel.train.R.id.boarding_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x017f
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            int r2 = com.travel.train.R.id.dropping_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0179
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            int r2 = com.travel.train.R.id.destination_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0173
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            int r0 = com.travel.train.R.id.booking_source
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x016d
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.utils.n$a r2 = com.travel.utils.n.a.V1
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r0, r10, r11, r11, r2)
            int r0 = com.travel.train.R.id.destination_source
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x0167
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.utils.n$a r2 = com.travel.utils.n.a.V1
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r0, r10, r11, r11, r2)
            goto L_0x0330
        L_0x0167:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x016d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x0173:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0179:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x017f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0185:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x018b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0191:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0197:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x019d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x01a3:
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r1 = r14.f27036a
            if (r1 == 0) goto L_0x01ac
            java.lang.String r1 = r1.getNewSource()
            goto L_0x01ad
        L_0x01ac:
            r1 = r3
        L_0x01ad:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r6 = r14.f27037b
            if (r6 != 0) goto L_0x01b4
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x01b4:
            java.lang.String r6 = r6.getSource()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r8)
            if (r1 == 0) goto L_0x028d
            androidx.fragment.app.FragmentActivity r1 = r14.getActivity()
            if (r1 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            android.view.LayoutInflater r1 = r1.getLayoutInflater()
            int r6 = com.travel.train.R.layout.pre_t_train_alternative_type_2_lyt
            android.view.View r1 = r1.inflate(r6, r3)
            java.lang.String r6 = "activity!!.layoutInflate…rnative_type_2_lyt, null)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            int r6 = com.travel.train.R.id.boarding_station
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x0287
            android.widget.TextView r6 = (android.widget.TextView) r6
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r7 = r14.f27036a
            if (r7 == 0) goto L_0x01ec
            java.lang.String r7 = r7.getNewSourceName()
            goto L_0x01ed
        L_0x01ec:
            r7 = r3
        L_0x01ed:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            int r6 = com.travel.train.R.id.dropping_station
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x0281
            android.widget.TextView r6 = (android.widget.TextView) r6
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r14.f27037b
            if (r7 != 0) goto L_0x0203
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0203:
            java.lang.String r5 = r7.getDestinationName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6.setText(r5)
            int r5 = com.travel.train.R.id.destination_station
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x027b
            android.widget.TextView r5 = (android.widget.TextView) r5
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r6 = r14.f27036a
            if (r6 == 0) goto L_0x021f
            java.lang.String r6 = r6.getNewDestinationName()
            goto L_0x0220
        L_0x021f:
            r6 = r3
        L_0x0220:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            int r5 = com.travel.train.R.id.boarding_station_time
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x0275
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            int r2 = com.travel.train.R.id.dropping_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x026f
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            int r2 = com.travel.train.R.id.destination_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0269
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            int r0 = com.travel.train.R.id.dropping_source
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x0263
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.utils.n$a r2 = com.travel.utils.n.a.V1
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r0, r10, r11, r11, r2)
            goto L_0x0330
        L_0x0263:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x0269:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x026f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0275:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x027b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0281:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0287:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x028d:
            androidx.fragment.app.FragmentActivity r1 = r14.getActivity()
            if (r1 != 0) goto L_0x0296
            kotlin.g.b.k.a()
        L_0x0296:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            android.view.LayoutInflater r1 = r1.getLayoutInflater()
            int r6 = com.travel.train.R.layout.pre_t_train_alternative_type_3_lyt
            android.view.View r1 = r1.inflate(r6, r3)
            java.lang.String r6 = "activity!!.layoutInflate…rnative_type_3_lyt, null)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            int r6 = com.travel.train.R.id.source_station
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x03b1
            android.widget.TextView r6 = (android.widget.TextView) r6
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r7 = r14.f27036a
            if (r7 == 0) goto L_0x02bb
            java.lang.String r7 = r7.getNewSourceName()
            goto L_0x02bc
        L_0x02bb:
            r7 = r3
        L_0x02bc:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            int r6 = com.travel.train.R.id.boarding_station
            android.view.View r6 = r1.findViewById(r6)
            if (r6 == 0) goto L_0x03ab
            android.widget.TextView r6 = (android.widget.TextView) r6
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r7 = r14.f27037b
            if (r7 != 0) goto L_0x02d2
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x02d2:
            java.lang.String r5 = r7.getSourceName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6.setText(r5)
            int r5 = com.travel.train.R.id.dropping_station
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x03a5
            android.widget.TextView r5 = (android.widget.TextView) r5
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r6 = r14.f27036a
            if (r6 == 0) goto L_0x02ee
            java.lang.String r6 = r6.getNewDestinationName()
            goto L_0x02ef
        L_0x02ee:
            r6 = r3
        L_0x02ef:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            int r5 = com.travel.train.R.id.source_station_time
            android.view.View r5 = r1.findViewById(r5)
            if (r5 == 0) goto L_0x039f
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            int r2 = com.travel.train.R.id.boarding_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0399
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            int r2 = com.travel.train.R.id.dropping_station_time
            android.view.View r2 = r1.findViewById(r2)
            if (r2 == 0) goto L_0x0393
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            int r0 = com.travel.train.R.id.boarding_image
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x038d
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.utils.n$a r2 = com.travel.utils.n.a.V1
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r0, r10, r11, r11, r2)
        L_0x0330:
            android.widget.FrameLayout r0 = r14.k
            if (r0 == 0) goto L_0x0337
            r0.addView(r1)
        L_0x0337:
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r0 = r14.f27036a
            if (r0 == 0) goto L_0x0340
            java.lang.String r0 = r0.getButtonText()
            goto L_0x0341
        L_0x0340:
            r0 = r3
        L_0x0341:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x035c
            android.widget.Button r0 = r14.m
            if (r0 == 0) goto L_0x035c
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r1 = r14.f27036a
            if (r1 == 0) goto L_0x0356
            java.lang.String r1 = r1.getButtonText()
            goto L_0x0357
        L_0x0356:
            r1 = r3
        L_0x0357:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x035c:
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r0 = r14.f27036a
            if (r0 == 0) goto L_0x0365
            java.lang.String r0 = r0.getExpandText()
            goto L_0x0366
        L_0x0365:
            r0 = r3
        L_0x0366:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0383
            android.widget.TextView r0 = r14.l
            if (r0 == 0) goto L_0x0383
            com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData r1 = r14.f27036a
            if (r1 == 0) goto L_0x037a
            java.lang.String r3 = r1.getExpandText()
        L_0x037a:
            android.text.Spanned r1 = android.text.Html.fromHtml(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0383:
            androidx.recyclerview.widget.RecyclerView r0 = r14.f27042g
            if (r0 == 0) goto L_0x038c
            int r1 = r14.f27038c
            r0.smoothScrollToPosition(r1)
        L_0x038c:
            return
        L_0x038d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x0393:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0399:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x039f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x03a5:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x03ab:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x03b1:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.k.a():void");
    }

    public final void show(j jVar, String str) {
        kotlin.g.b.k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            kotlin.g.b.k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final void a(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        this.f27038c = i2;
        this.f27036a = cJRTrainSearchResultsAlternateStationData;
        a();
    }

    public final void b(int i2, CJRTrainSearchResultsAlternateStationData cJRTrainSearchResultsAlternateStationData, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        ad adVar = this.f27041f;
        if (adVar != null) {
            adVar.b(i2, cJRTrainSearchResultsAlternateStationData, cJRTrainSearchResultsTrain);
        }
        dismiss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
