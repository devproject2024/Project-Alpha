package com.travel.train.viewholder;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.b.b;
import com.travel.train.helper.i;
import com.travel.train.i.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.BoardingStationData;
import com.travel.train.model.trainticket.CJRBoardingStationDetails;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;

public final class t extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public String f28233a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f28234b = "";

    /* renamed from: c  reason: collision with root package name */
    public Spinner f28235c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f28236d = this.itemView.getContext();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public g f28237e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRTrainDetailsBody f28238f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f28239g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<CJRBoardingStationDetails> f28240h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public i f28241i;
    /* access modifiers changed from: private */
    public CJRTrainSearchResultsTrain j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public int l = 0;
    private RelativeLayout m;
    private LinearLayout n;
    /* access modifiers changed from: private */
    public boolean o;

    public t(View view, g gVar, i iVar, CJRTrainDetailsBody cJRTrainDetailsBody, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, boolean z) {
        super(view);
        this.f28237e = gVar;
        this.f28238f = cJRTrainDetailsBody;
        this.j = cJRTrainSearchResultsTrain;
        this.f28241i = iVar;
        this.o = z;
        this.m = (RelativeLayout) view.findViewById(R.id.boardingStationLyt);
        this.n = (LinearLayout) view.findViewById(R.id.change_station_btn);
        this.f28235c = (Spinner) view.findViewById(R.id.boarding_station_spinner);
        CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f28238f;
        if (cJRTrainDetailsBody2 != null) {
            this.f28239g = cJRTrainDetailsBody2.getBoardingStation();
            this.f28240h = this.f28238f.getBoardingDetail();
        }
        ArrayList<String> arrayList = this.f28239g;
        if (arrayList == null || arrayList.size() <= 1) {
            this.m.setClickable(false);
            this.n.setVisibility(8);
            return;
        }
        this.m.setOnClickListener(this);
    }

    public final void a() {
        ArrayList<String> arrayList = this.f28239g;
        if (arrayList != null && arrayList.size() > 0) {
            final ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < this.f28239g.size(); i2++) {
                String[] split = this.f28239g.get(i2).split("-");
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                BoardingStationData boardingStationData = new BoardingStationData();
                if (split != null && split.length == 2) {
                    sb.append(split[1]);
                    sb.append("-");
                    sb.append(o.a(split[0]));
                }
                ArrayList<CJRBoardingStationDetails> arrayList3 = this.f28240h;
                if (!(arrayList3 == null || arrayList3.size() <= 0 || this.f28240h.get(i2) == null)) {
                    this.f28234b = this.f28240h.get(0).getDepartureTime();
                    if (this.f28240h.get(0) != null) {
                        this.l = this.f28240h.get(0).getDayCount();
                    }
                    int dayCount = this.f28240h.get(i2).getDayCount() - this.l;
                    sb2.append(AppConstants.COMMA);
                    this.f28233a = i.a(this.j, this.f28240h.get(0).getDayCount() - this.l, Boolean.TRUE);
                    String a2 = i.a(this.j, dayCount, Boolean.FALSE);
                    sb2.append(a2 + ", ");
                    sb2.append(this.f28240h.get(i2).getDepartureTime());
                }
                boardingStationData.setStationTitle(sb.toString());
                boardingStationData.setTravelDate(sb2.toString());
                arrayList2.add(boardingStationData);
            }
            this.f28235c.setAdapter(new b(this.f28236d, arrayList2, this.o));
            this.f28235c.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    o.a("train_traveller_details", t.this.j.getSourceName(), t.this.j.getDestinationName(), t.this.j.getDeparture(), (String) null, (String) null, (String) null, "boarding_point_dropdown", "/trains/traveller-details", t.this.f28236d, (Map<String, Object>) null);
                    return false;
                }
            });
            this.f28235c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                    View findViewById;
                    View view2 = view;
                    int i3 = i2;
                    if (!(view2 == null || (findViewById = view2.findViewById(R.id.view_separator_one)) == null)) {
                        findViewById.setVisibility(8);
                    }
                    if (t.this.f28240h != null) {
                        t tVar = t.this;
                        String unused = tVar.f28234b = ((CJRBoardingStationDetails) tVar.f28240h.get(i3)).getDepartureTime();
                    }
                    t tVar2 = t.this;
                    i unused2 = tVar2.f28241i;
                    String unused3 = tVar2.f28233a = i.a(t.this.j, ((CJRBoardingStationDetails) t.this.f28240h.get(i3)).getDayCount() - t.this.l, Boolean.TRUE);
                    t tVar3 = t.this;
                    String unused4 = tVar3.k = (String) tVar3.f28239g.get(i3);
                    HashMap hashMap = new HashMap();
                    if (t.this.k != null) {
                        hashMap.put(d.n, t.this.k);
                        String[] split = t.this.k.split("-");
                        Object obj = d.m;
                        i e2 = t.this.f28241i;
                        int i4 = 0;
                        String str = split[0];
                        if (e2.f27314b != null && e2.f27314b.getmSourceCityName().equalsIgnoreCase(str)) {
                            i4 = 1;
                        }
                        hashMap.put(obj, Integer.valueOf(i4));
                    }
                    o.a("train_traveller_details", t.this.j.getSourceName(), t.this.j.getDestinationName(), t.this.j.getDeparture(), (String) null, (String) null, (String) null, "boarding_point_selected", "/trains/traveller-details", t.this.f28236d, hashMap);
                    if (t.this.k != null) {
                        if (t.this.f28238f != null) {
                            t.this.f28238f.setSelectedBoardingStation(t.this.k);
                        }
                        CJRTrainDetailsBody h2 = t.this.f28238f;
                        h2.setFormattedBoardingStation(((BoardingStationData) arrayList2.get(i3)).getStationTitle() + ((BoardingStationData) arrayList2.get(i3)).getTravelDate());
                        if (t.this.o) {
                            t.this.f28237e.a(i3);
                        }
                    }
                }
            });
        }
    }

    public final void a(int i2) {
        Spinner spinner = this.f28235c;
        if (spinner != null) {
            spinner.setSelection(i2);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.boardingStationLyt) {
            this.f28235c.performClick();
        }
    }
}
