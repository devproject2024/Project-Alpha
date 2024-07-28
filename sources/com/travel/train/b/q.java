package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.i.h;
import com.travel.train.i.i;
import com.travel.train.model.metro.CJRClearRecentDataModel;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import com.travel.train.model.metro.CJRRecentTagModel;
import com.travel.train.model.metro.CJRSearchedMetroLineModel;
import com.travel.train.model.metro.CJRSelectStationModel;
import com.travel.train.model.metro.CJRStationAutoSuggestModel;
import com.travel.train.model.metro.CJRStationTagModel;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class q extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final h f26519a;

    /* renamed from: b  reason: collision with root package name */
    final i f26520b;

    /* renamed from: c  reason: collision with root package name */
    final int f26521c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f26522d;

    /* renamed from: e  reason: collision with root package name */
    private final List<CJRSelectStationModel> f26523e;

    /* renamed from: f  reason: collision with root package name */
    private final int f26524f;

    public q(Context context, List<CJRSelectStationModel> list, h hVar, i iVar, int i2, int i3) {
        k.c(context, "context");
        k.c(list, "stationList");
        k.c(hVar, "iJRSelectedMetroStationListener");
        k.c(iVar, "pairSelectedListner");
        this.f26522d = context;
        this.f26523e = list;
        this.f26519a = hVar;
        this.f26520b = iVar;
        this.f26521c = i2;
        this.f26524f = i3;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == com.travel.train.j.g.M) {
            View inflate = LayoutInflater.from(this.f26522d).inflate(R.layout.pre_t_stations_tag_layout, viewGroup, false);
            if (inflate == null) {
                k.a();
            }
            return new c(inflate);
        } else if (i2 == com.travel.train.j.g.N) {
            View inflate2 = LayoutInflater.from(this.f26522d).inflate(R.layout.pre_t_recent_tag_layout, viewGroup, false);
            if (inflate2 == null) {
                k.a();
            }
            return new b(inflate2);
        } else if (i2 == com.travel.train.j.g.O) {
            View inflate3 = LayoutInflater.from(this.f26522d).inflate(R.layout.pre_t_recent_metro_search_model_layout, viewGroup, false);
            if (inflate3 == null) {
                k.a();
            }
            return new a(inflate3);
        } else if (i2 == com.travel.train.j.g.P) {
            View inflate4 = LayoutInflater.from(this.f26522d).inflate(R.layout.pre_t_search_metro_station_model_layout, viewGroup, false);
            if (inflate4 == null) {
                k.a();
            }
            return new d(inflate4);
        } else {
            View inflate5 = LayoutInflater.from(this.f26522d).inflate(R.layout.pre_t_search_metro_station_model_layout, viewGroup, false);
            if (inflate5 == null) {
                k.a();
            }
            return new c(inflate5);
        }
    }

    public final int getItemCount() {
        return this.f26523e.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        CJRSelectStationModel cJRSelectStationModel = this.f26523e.get(i2);
        int type = cJRSelectStationModel.getType();
        if (type == com.travel.train.j.g.M) {
            if (cJRSelectStationModel.getData() instanceof CJRStationTagModel) {
                TextView textView = ((c) vVar).f26529a;
                Object data = cJRSelectStationModel.getData();
                if (data != null) {
                    textView.setText(((CJRStationTagModel) data).getStationString());
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationTagModel");
            }
        } else if (type == com.travel.train.j.g.N) {
            if (cJRSelectStationModel.getData() instanceof CJRRecentTagModel) {
                b bVar = (b) vVar;
                RoboTextView roboTextView = bVar.f26527a;
                Object data2 = cJRSelectStationModel.getData();
                if (data2 != null) {
                    roboTextView.setText(((CJRRecentTagModel) data2).getRecentString());
                    RoboTextView roboTextView2 = bVar.f26528b;
                    Object data3 = cJRSelectStationModel.getData();
                    if (data3 != null) {
                        roboTextView2.setText(((CJRRecentTagModel) data3).getClearString());
                        bVar.f26528b.setOnClickListener(e.f26533a);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRRecentTagModel");
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRRecentTagModel");
            }
        } else if (type == com.travel.train.j.g.O) {
            if (cJRSelectStationModel.getData() instanceof CJRParcelableMetroStationModel) {
                a aVar = (a) vVar;
                RoboTextView roboTextView3 = aVar.f26525a;
                Object data4 = cJRSelectStationModel.getData();
                if (data4 != null) {
                    roboTextView3.setText(((CJRParcelableMetroStationModel) data4).sourceStation);
                    RoboTextView roboTextView4 = aVar.f26526b;
                    Object data5 = cJRSelectStationModel.getData();
                    if (data5 != null) {
                        roboTextView4.setText(((CJRParcelableMetroStationModel) data5).destinationStation);
                        vVar.itemView.setOnClickListener(new f(this, cJRSelectStationModel));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRParcelableMetroStationModel");
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRParcelableMetroStationModel");
            }
        } else if (type == com.travel.train.j.g.P) {
            d dVar = (d) vVar;
            RoboTextView roboTextView5 = dVar.f26530a;
            Object data6 = cJRSelectStationModel.getData();
            if (data6 != null) {
                roboTextView5.setText(((CJRStationAutoSuggestModel) data6).name);
                RoboTextView roboTextView6 = dVar.f26532c;
                Object data7 = cJRSelectStationModel.getData();
                if (data7 != null) {
                    roboTextView6.setText(((CJRStationAutoSuggestModel) data7).stationid);
                    if (this.f26524f >= com.travel.train.j.g.U) {
                        dVar.f26531b.setLayoutManager(new LinearLayoutManager(this.f26522d, 0, false));
                    } else {
                        dVar.f26531b.setLayoutManager(new LinearLayoutManager(this.f26522d, 1, false));
                    }
                    RecyclerView recyclerView = dVar.f26531b;
                    Context context = this.f26522d;
                    Object data8 = cJRSelectStationModel.getData();
                    if (data8 != null) {
                        List<CJRSearchedMetroLineModel> list = ((CJRStationAutoSuggestModel) data8).line_info;
                        k.a((Object) list, "(station.data as CJRStat…toSuggestModel).line_info");
                        recyclerView.setAdapter(new p(context, list));
                        dVar.f26531b.setHasFixedSize(true);
                        vVar.itemView.setOnClickListener(new g(this, cJRSelectStationModel));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationAutoSuggestModel");
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationAutoSuggestModel");
            }
            throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationAutoSuggestModel");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f26533a = new e();

        e() {
        }

        public final void onClick(View view) {
            com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) new CJRClearRecentDataModel(true));
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f26534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRSelectStationModel f26535b;

        f(q qVar, CJRSelectStationModel cJRSelectStationModel) {
            this.f26534a = qVar;
            this.f26535b = cJRSelectStationModel;
        }

        public final void onClick(View view) {
            i iVar = this.f26534a.f26520b;
            Object data = this.f26535b.getData();
            if (data != null) {
                iVar.a((CJRParcelableMetroStationModel) data);
                return;
            }
            throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRParcelableMetroStationModel");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f26536a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRSelectStationModel f26537b;

        g(q qVar, CJRSelectStationModel cJRSelectStationModel) {
            this.f26536a = qVar;
            this.f26537b = cJRSelectStationModel;
        }

        public final void onClick(View view) {
            if (this.f26536a.f26521c == com.travel.train.j.g.F) {
                h hVar = this.f26536a.f26519a;
                int i2 = com.travel.train.j.g.F;
                Object data = this.f26537b.getData();
                if (data != null) {
                    hVar.a(i2, (CJRStationAutoSuggestModel) data);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationAutoSuggestModel");
            }
            h hVar2 = this.f26536a.f26519a;
            int i3 = com.travel.train.j.g.G;
            Object data2 = this.f26537b.getData();
            if (data2 != null) {
                hVar2.a(i3, (CJRStationAutoSuggestModel) data2);
                return;
            }
            throw new u("null cannot be cast to non-null type com.travel.train.model.metro.CJRStationAutoSuggestModel");
        }
    }

    public final int getItemViewType(int i2) {
        int type = this.f26523e.get(i2).getType();
        if (type == com.travel.train.j.g.M) {
            return com.travel.train.j.g.M;
        }
        if (type == com.travel.train.j.g.N) {
            return com.travel.train.j.g.N;
        }
        if (type == com.travel.train.j.g.O) {
            return com.travel.train.j.g.O;
        }
        if (type == com.travel.train.j.g.P) {
            return com.travel.train.j.g.P;
        }
        return com.travel.train.j.g.P;
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f26529a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.stations_tag_textview);
            k.a((Object) findViewById, "itemView.findViewById(R.id.stations_tag_textview)");
            this.f26529a = (TextView) findViewById;
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26527a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26528b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.recent_textview);
            k.a((Object) findViewById, "itemView.findViewById(R.id.recent_textview)");
            this.f26527a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.clear_textview);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.clear_textview)");
            this.f26528b = (RoboTextView) findViewById2;
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26525a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f26526b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.source_station_recent_search);
            k.a((Object) findViewById, "itemView.findViewById(R.…ce_station_recent_search)");
            this.f26525a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.destination_station_recent_search);
            k.a((Object) findViewById2, "itemView.findViewById(R.…on_station_recent_search)");
            this.f26526b = (RoboTextView) findViewById2;
        }
    }

    public static final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f26530a;

        /* renamed from: b  reason: collision with root package name */
        final RecyclerView f26531b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f26532c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.station_name_in_searched_station);
            k.a((Object) findViewById, "itemView.findViewById(R.…name_in_searched_station)");
            this.f26530a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.line_recyclerview_searched_station);
            k.a((Object) findViewById2, "itemView.findViewById(R.…lerview_searched_station)");
            this.f26531b = (RecyclerView) findViewById2;
            View findViewById3 = view.findViewById(R.id.station_id_in_searched_station);
            k.a((Object) findViewById3, "itemView.findViewById(R.…n_id_in_searched_station)");
            this.f26532c = (RoboTextView) findViewById3;
        }
    }
}
