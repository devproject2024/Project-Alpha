package net.one97.paytm.recharge.metro.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.a.f;
import net.one97.paytm.recharge.metro.c.q;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public final class g extends f {

    /* renamed from: d  reason: collision with root package name */
    public CJRMetroStationModel f63177d;

    /* renamed from: e  reason: collision with root package name */
    final a f63178e;

    /* renamed from: f  reason: collision with root package name */
    private final int f63179f = 3;

    /* renamed from: g  reason: collision with root package name */
    private Context f63180g;

    /* renamed from: h  reason: collision with root package name */
    private String f63181h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f63182i;

    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, CJRMetroStationModel cJRMetroStationModel, List<? extends CJRMetroStationModel> list, q.a aVar, a aVar2, String str, boolean z) {
        super(cJRMetroStationModel, list, aVar);
        k.c(context, "mContext");
        k.c(cJRMetroStationModel, "sourceStation");
        k.c(list, "stationList");
        k.c(aVar, "listener");
        k.c(aVar2, "stationCheckCallBack");
        this.f63180g = context;
        this.f63178e = aVar2;
        this.f63181h = str;
        this.f63182i = z;
    }

    public final int getItemViewType(int i2) {
        if (this.f63181h != null || this.f63182i) {
            return this.f63179f;
        }
        return super.getItemViewType(i2);
    }

    public final void a(ArrayList<CJRMetroStationModel> arrayList) {
        k.c(arrayList, "filterdNames");
        this.f63171b = arrayList;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public final f.a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f63179f) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exit_station_change_layout, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ge_layout, parent, false)");
            return new b(this, inflate);
        }
        f.a a2 = super.onCreateViewHolder(viewGroup, i2);
        k.a((Object) a2, "super.onCreateViewHolder(parent, viewType)");
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(net.one97.paytm.recharge.metro.a.f.a r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "viewHolder"
            kotlin.g.b.k.c(r8, r0)
            java.util.List r0 = r7.f63171b
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r0
            boolean r1 = r8 instanceof net.one97.paytm.recharge.metro.a.g.b
            if (r1 == 0) goto L_0x00ed
            r1 = r8
            net.one97.paytm.recharge.metro.a.g$b r1 = (net.one97.paytm.recharge.metro.a.g.b) r1
            android.widget.TextView r2 = r1.f63183c
            if (r2 == 0) goto L_0x0026
            java.lang.String r3 = "station"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x0026:
            android.widget.RadioButton r0 = r1.f63185e
            r2 = 0
            r0.setVisibility(r2)
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r7.f63177d
            r3 = 0
            java.lang.String r4 = "mStationList[position]"
            r5 = 1
            if (r0 == 0) goto L_0x008a
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.getName()
            goto L_0x003c
        L_0x003b:
            r0 = r3
        L_0x003c:
            java.util.List r6 = r7.f63171b
            java.lang.Object r6 = r6.get(r9)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r6 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r6
            java.lang.String r6 = r6.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r5)
            if (r0 == 0) goto L_0x008a
            android.widget.RadioButton r0 = r1.f63185e
            r0.setChecked(r5)
            java.lang.String r0 = r7.f63181h
            java.util.List r2 = r7.f63171b
            java.lang.Object r2 = r2.get(r9)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r2 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r2
            java.lang.String r2 = r2.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r5)
            if (r0 != 0) goto L_0x0098
            android.widget.TextView r0 = r1.f63184d
            android.content.Context r2 = r7.f63180g
            int r6 = net.one97.paytm.recharge.R.string.metro_new_exit_station
            java.lang.String r2 = r2.getString(r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r1.f63184d
            android.content.Context r2 = r7.f63180g
            int r6 = net.one97.paytm.recharge.R.color.color_00bafb
            int r2 = androidx.core.content.b.c(r2, r6)
            r0.setTextColor(r2)
            goto L_0x0098
        L_0x008a:
            android.widget.TextView r0 = r1.f63184d
            java.lang.String r6 = ""
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            android.widget.RadioButton r0 = r1.f63185e
            r0.setChecked(r2)
        L_0x0098:
            java.lang.String r0 = r7.f63181h
            if (r0 == 0) goto L_0x00b0
            if (r0 == 0) goto L_0x00a8
            java.lang.String r3 = r0.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            goto L_0x00b0
        L_0x00a8:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L_0x00b0:
            java.util.List r0 = r7.f63171b
            java.lang.Object r0 = r0.get(r9)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r0
            java.lang.String r0 = r0.getName()
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r5)
            if (r0 == 0) goto L_0x00e1
            android.widget.TextView r0 = r1.f63184d
            android.content.Context r2 = r7.f63180g
            int r3 = net.one97.paytm.recharge.R.string.metro_original_exit_station
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r1.f63184d
            android.content.Context r1 = r7.f63180g
            int r2 = net.one97.paytm.recharge.R.color.color_999999
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
        L_0x00e1:
            android.view.View r0 = r8.itemView
            net.one97.paytm.recharge.metro.a.g$c r1 = new net.one97.paytm.recharge.metro.a.g$c
            r1.<init>(r7, r8, r9)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.a.g.onBindViewHolder(net.one97.paytm.recharge.metro.a.f$a, int):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f.a f63189b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f63190c;

        c(g gVar, f.a aVar, int i2) {
            this.f63188a = gVar;
            this.f63189b = aVar;
            this.f63190c = i2;
        }

        public final void onClick(View view) {
            if (((b) this.f63189b).f63186f) {
                ((b) this.f63189b).f63185e.setChecked(false);
                f.a aVar = this.f63189b;
                ((b) aVar).f63186f = !((b) aVar).f63186f;
                g gVar = this.f63188a;
                gVar.f63177d = null;
                a aVar2 = gVar.f63178e;
                if (aVar2 != null) {
                    aVar2.a(false);
                }
            } else {
                ((b) this.f63189b).f63185e.setChecked(true);
                f.a aVar3 = this.f63189b;
                ((b) aVar3).f63186f = !((b) aVar3).f63186f;
                g gVar2 = this.f63188a;
                gVar2.f63177d = (CJRMetroStationModel) gVar2.f63171b.get(this.f63190c);
                a aVar4 = this.f63188a.f63178e;
                if (aVar4 != null) {
                    aVar4.a(true);
                }
            }
            this.f63188a.notifyDataSetChanged();
        }
    }

    public final class b extends f.a {

        /* renamed from: c  reason: collision with root package name */
        TextView f63183c;

        /* renamed from: d  reason: collision with root package name */
        TextView f63184d;

        /* renamed from: e  reason: collision with root package name */
        RadioButton f63185e;

        /* renamed from: f  reason: collision with root package name */
        boolean f63186f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g f63187g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f63187g = gVar;
            View findViewById = view.findViewById(R.id.tv_station_name);
            if (findViewById != null) {
                this.f63183c = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_station_source);
                k.a((Object) findViewById2, "itemView.findViewById(R.id.tv_station_source)");
                this.f63184d = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.radio_station);
                k.a((Object) findViewById3, "itemView.findViewById(R.id.radio_station)");
                this.f63185e = (RadioButton) findViewById3;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
