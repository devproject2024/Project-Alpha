package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ak;
import net.one97.paytm.o2o.movies.adapter.al;
import net.one97.paytm.o2o.movies.adapter.am;
import net.one97.paytm.o2o.movies.adapter.an;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieFilterData;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieReleaseDate;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;
import net.one97.paytm.o2o.movies.entity.ComingSoonMovie;

public final class ak extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public b f74381a;

    /* renamed from: b  reason: collision with root package name */
    public a f74382b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRMovieLanguages> f74383c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRMovieLanguages> f74384d;

    /* renamed from: e  reason: collision with root package name */
    ComingSoonMovie f74385e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f74386f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CJRUpcomingMovieReleaseDate> f74387g;

    /* renamed from: h  reason: collision with root package name */
    private al.b f74388h;

    /* renamed from: i  reason: collision with root package name */
    private am.a f74389i;
    private an.b j;

    public ak(CJRUpcomingMovieFilterData cJRUpcomingMovieFilterData, al.b bVar, am.a aVar, an.b bVar2) {
        this.f74388h = bVar;
        this.f74389i = aVar;
        this.j = bVar2;
        this.f74383c = cJRUpcomingMovieFilterData.getmLanguageList();
        this.f74384d = cJRUpcomingMovieFilterData.getmGenreList();
        this.f74387g = cJRUpcomingMovieFilterData.getmReleaseDateList();
        this.f74385e = cJRUpcomingMovieFilterData.getComingSoonMovie();
        ArrayList<CJRMovieLanguages> arrayList = this.f74383c;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f74386f.add("type_language");
        }
        ArrayList<CJRMovieLanguages> arrayList2 = this.f74384d;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f74386f.add("type_genri");
        }
        ArrayList<CJRUpcomingMovieReleaseDate> arrayList3 = this.f74387g;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            this.f74386f.add("type_release_date");
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcoming_filter_item_type_language, viewGroup, false));
        }
        if (i2 == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcoming_filter_item_type_genri, viewGroup, false));
        }
        if (i2 == 2) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcoming_filter_item_type_release_date, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof b) {
            this.f74381a = (b) vVar;
            b bVar = this.f74381a;
            bVar.f74394a = new LinearLayoutManager(bVar.f74396c.getContext(), 0, false);
            this.f74381a.f74396c.setLayoutManager(this.f74381a.f74394a);
            b bVar2 = this.f74381a;
            bVar2.f74395b = new al(bVar2.f74396c.getContext(), this.f74383c, "language");
            this.f74381a.f74395b.f74404b = this.f74388h;
            this.f74381a.f74396c.setAdapter(this.f74381a.f74395b);
        } else if (vVar instanceof a) {
            this.f74382b = (a) vVar;
            a aVar = this.f74382b;
            aVar.f74392c = new al(aVar.f74391b.getContext(), this.f74384d, "genre");
            this.f74382b.f74392c.f74404b = this.f74388h;
            a aVar2 = this.f74382b;
            aVar2.f74390a = new LinearLayoutManager(aVar2.f74391b.getContext(), 0, false);
            this.f74382b.f74391b.setLayoutManager(this.f74382b.f74390a);
            this.f74382b.f74391b.setAdapter(this.f74382b.f74392c);
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            cVar.a();
            am amVar = new am(this.f74387g, this.f74389i, this.j);
            cVar.f74398a.setLayoutManager(new LinearLayoutManager(cVar.f74398a.getContext(), 1, false));
            cVar.f74398a.setAdapter(amVar);
            cVar.f74398a.addItemDecoration(new d(cVar.f74398a.getContext()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getItemViewType(int r7) {
        /*
            r6 = this;
            java.util.ArrayList<java.lang.String> r0 = r6.f74386f
            java.lang.Object r7 = r0.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            int r0 = r7.hashCode()
            r1 = -1529063989(0xffffffffa4dc55cb, float:-9.555513E-17)
            r2 = 0
            r3 = -1
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L_0x0036
            r1 = -1091557310(0xffffffffbef02842, float:-0.46905714)
            if (r0 == r1) goto L_0x002b
            r1 = -527059267(0xffffffffe095b6bd, float:-8.630414E19)
            if (r0 == r1) goto L_0x0020
            goto L_0x0041
        L_0x0020:
            java.lang.String r0 = "type_language"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0041
            r7 = 0
            goto L_0x0042
        L_0x002b:
            java.lang.String r0 = "type_genri"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0041
            r7 = 1
            goto L_0x0042
        L_0x0036:
            java.lang.String r0 = "type_release_date"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0041
            r7 = 2
            goto L_0x0042
        L_0x0041:
            r7 = -1
        L_0x0042:
            if (r7 == 0) goto L_0x004b
            if (r7 == r5) goto L_0x004a
            if (r7 == r4) goto L_0x0049
            return r3
        L_0x0049:
            return r4
        L_0x004a:
            return r5
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.ak.getItemViewType(int):int");
    }

    public final int getItemCount() {
        return this.f74386f.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayoutManager f74394a;

        /* renamed from: b  reason: collision with root package name */
        public al f74395b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView f74396c;

        b(View view) {
            super(view);
            this.f74396c = (RecyclerView) view.findViewById(R.id.upcoming_movies_filters_language);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayoutManager f74390a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f74391b;

        /* renamed from: c  reason: collision with root package name */
        public al f74392c;

        a(View view) {
            super(view);
            this.f74391b = (RecyclerView) view.findViewById(R.id.upcoming_movies_filters_genre);
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f74398a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74399b;

        c(View view) {
            super(view);
            this.f74398a = (RecyclerView) view.findViewById(R.id.upcoming_movies_filters_reldate);
            this.f74399b = (TextView) view.findViewById(R.id.txt_coming_soon);
            this.f74399b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ak.c.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            ak.this.f74385e.setSelected(!ak.this.f74385e.isSelected());
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (ak.this.f74385e.getHasComingSoonMovie()) {
                Context context = this.f74399b.getContext();
                if (ak.this.f74385e.isSelected()) {
                    this.f74399b.setBackground(androidx.core.content.b.a(context, net.one97.paytm.common.assets.R.drawable.rounded_corner_3dp_blue));
                    this.f74399b.setTextColor(androidx.core.content.b.c(context, R.color.white));
                } else {
                    this.f74399b.setBackground(androidx.core.content.b.a(context, net.one97.paytm.common.assets.R.drawable.bg_bright_sky_blue_3dp_rounded));
                    this.f74399b.setTextColor(androidx.core.content.b.c(context, R.color.paytm_blue));
                }
                this.f74399b.setVisibility(0);
                return;
            }
            this.f74399b.setVisibility(8);
        }
    }

    public final void a(ArrayList<CJRUpcomingMovieReleaseDate> arrayList) {
        this.f74387g = arrayList;
        if (!this.f74386f.isEmpty()) {
            notifyItemChanged(this.f74386f.indexOf("type_release_date"));
        }
    }

    class d extends RecyclerView.h {

        /* renamed from: b  reason: collision with root package name */
        private Drawable f74402b;

        d(Context context) {
            this.f74402b = androidx.core.content.b.a(context, R.drawable.line_divider);
        }

        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount - 1; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                this.f74402b.setBounds(com.paytm.utility.b.c(20), bottom, width, this.f74402b.getIntrinsicHeight() + bottom);
                this.f74402b.draw(canvas);
            }
        }
    }
}
