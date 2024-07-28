package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.m.p;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.upi.util.UpiConstants;

public final class v extends RecyclerView.a<be> {

    /* renamed from: a  reason: collision with root package name */
    List<bb> f74781a = w.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    boolean f74782b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f74783c;

    /* renamed from: d  reason: collision with root package name */
    final a f74784d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f74785e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends CJRMoviesSession> f74786f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f74787g;

    public interface a {
        void a(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2);

        void b(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        be beVar = (be) vVar;
        k.c(beVar, "holder");
        bb bbVar = this.f74781a.get(i2);
        beVar.f74580b.setText(bbVar.f74537a);
        int i3 = 0;
        if (bbVar.f74542f.getIsPremium() != 1 || bbVar.f74542f.getDisplayPremiumLabel() != 1 || TextUtils.isEmpty(bbVar.f74542f.getPremiumLabel()) || this.f74783c) {
            beVar.f74582d.setVisibility(8);
        } else {
            beVar.f74582d.setText(bbVar.f74542f.getPremiumLabel());
            beVar.f74582d.setVisibility(0);
        }
        beVar.f74581c.setText(bbVar.f74538b);
        RoboTextView roboTextView = beVar.f74581c;
        boolean z = bbVar.f74539c;
        if (!z) {
            if (!z) {
                i3 = 8;
            } else {
                throw new m();
            }
        }
        roboTextView.setVisibility(i3);
        beVar.f74580b.setTextColor(androidx.core.content.b.c(this.f74787g, bbVar.f74540d));
        beVar.f74581c.setTextColor(androidx.core.content.b.c(this.f74787g, R.color.color_gray));
        if (this.f74783c) {
            beVar.f74579a.setBackground(androidx.core.content.b.a(this.f74787g, R.drawable.movie_show_timming_bg));
            if (bbVar.f74542f.isCurrentSession() == 1) {
                beVar.f74579a.setBackground(androidx.core.content.b.a(this.f74787g, R.drawable.movie_show_time_blue_bg));
                beVar.f74580b.setTextColor(androidx.core.content.b.c(this.f74787g, R.color.white));
                beVar.f74581c.setTextColor(androidx.core.content.b.c(this.f74787g, R.color.white));
            }
        }
        beVar.f74583e.setOnClickListener(new b(this, bbVar, i2));
        beVar.f74583e.setOnLongClickListener(new c(this, bbVar, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_session_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…sion_item, parent, false)");
        be beVar = new be(inflate);
        if (!this.f74783c) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.a(70, this.f74787g), -2);
            layoutParams.setMargins(0, n.a(12, this.f74787g), n.a(12, this.f74787g), 0);
            beVar.f74579a.setLayoutParams(layoutParams);
        }
        return beVar;
    }

    public v(List<? extends CJRMoviesSession> list, Context context, boolean z, a aVar) {
        k.c(list, "mSessionList");
        k.c(context, "mContext");
        k.c(aVar, "onSessionClickListener");
        this.f74786f = list;
        this.f74787g = context;
        this.f74783c = z;
        this.f74784d = aVar;
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r12 = this;
            java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession> r0 = r12.f74786f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            if (r1 == 0) goto L_0x0012
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0030
        L_0x0012:
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r1
            java.lang.String r1 = r1.getScreenFormat()
            java.lang.String r3 = "2D"
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0016
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            r12.f74785e = r2
            java.util.List<? extends net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession> r0 = r12.f74786f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.a.k.a(r0)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r0.next()
            r11 = r2
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r11
            net.one97.paytm.o2o.movies.adapter.bb r2 = new net.one97.paytm.o2o.movies.adapter.bb
            java.lang.String r3 = r11.getRealShowDateTime()
            java.lang.String r4 = net.one97.paytm.o2o.movies.utils.n.c((java.lang.String) r3)
            java.lang.String r3 = "CJRMoviesUtility.getForm…e(movie.realShowDateTime)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            int r5 = r11.totalSeats
            int r6 = r11.getSeatsAvailable()
            java.lang.String r3 = r11.getScreenFormat()
            if (r3 != 0) goto L_0x0070
            java.lang.String r3 = ""
        L_0x0070:
            r7 = r3
            boolean r8 = r12.f74785e
            java.lang.String r3 = r11.colorCode
            int r9 = net.one97.paytm.o2o.movies.utils.n.d(r3)
            java.lang.String r10 = r11.colorCode
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r1.add(r2)
            goto L_0x0046
        L_0x0083:
            java.util.List r1 = (java.util.List) r1
            r12.f74781a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.v.a():void");
    }

    public final int getItemCount() {
        return this.f74781a.size();
    }

    public final void a(List<? extends CJRMoviesSession> list) {
        k.c(list, "mList");
        this.f74786f = list;
        a();
        notifyDataSetChanged();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f74788a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bb f74789b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74790c;

        b(v vVar, bb bbVar, int i2) {
            this.f74788a = vVar;
            this.f74789b = bbVar;
            this.f74790c = i2;
        }

        public final void onClick(View view) {
            if ((TextUtils.isEmpty(this.f74789b.f74541e) || !p.a(this.f74789b.f74541e, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, true)) && !this.f74788a.f74783c) {
                a aVar = this.f74788a.f74784d;
                k.a((Object) view, "it");
                CJRMoviesSession cJRMoviesSession = this.f74789b.f74542f;
                Iterable<bb> iterable = this.f74788a.f74781a;
                Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
                for (bb bbVar : iterable) {
                    arrayList.add(bbVar.f74542f);
                }
                aVar.a(view, cJRMoviesSession, (ArrayList) ((List) arrayList), this.f74790c);
            }
            if ((TextUtils.isEmpty(this.f74789b.f74541e) || !p.a(this.f74789b.f74541e, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, true)) && this.f74788a.f74783c && !this.f74788a.f74782b && this.f74789b.f74542f.isCurrentSession() != 1) {
                for (bb bbVar2 : this.f74788a.f74781a) {
                    bbVar2.f74542f.setCurrentSession(0);
                }
                this.f74789b.f74542f.setCurrentSession(1);
                a aVar2 = this.f74788a.f74784d;
                k.a((Object) view, "it");
                CJRMoviesSession cJRMoviesSession2 = this.f74789b.f74542f;
                Iterable<bb> iterable2 = this.f74788a.f74781a;
                Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable2));
                for (bb bbVar3 : iterable2) {
                    arrayList2.add(bbVar3.f74542f);
                }
                aVar2.a(view, cJRMoviesSession2, (ArrayList) ((List) arrayList2), this.f74790c);
                this.f74788a.notifyDataSetChanged();
            }
        }
    }

    static final class c implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f74791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ bb f74792b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74793c;

        c(v vVar, bb bbVar, int i2) {
            this.f74791a = vVar;
            this.f74792b = bbVar;
            this.f74793c = i2;
        }

        public final boolean onLongClick(View view) {
            a aVar = this.f74791a.f74784d;
            k.a((Object) view, "it");
            CJRMoviesSession cJRMoviesSession = this.f74792b.f74542f;
            Iterable<bb> iterable = this.f74791a.f74781a;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (bb bbVar : iterable) {
                arrayList.add(bbVar.f74542f);
            }
            aVar.b(view, cJRMoviesSession, (ArrayList) ((List) arrayList), this.f74793c);
            return true;
        }
    }
}
