package net.one97.paytm.o2o.movies.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ak;
import net.one97.paytm.o2o.movies.adapter.al;
import net.one97.paytm.o2o.movies.adapter.am;
import net.one97.paytm.o2o.movies.adapter.an;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieFilterData;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieReleaseDate;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;
import net.one97.paytm.o2o.movies.entity.ComingSoonMovie;

public class AJRUpcomingMovieFilter extends AppBaseActivity implements View.OnClickListener, al.b, am.a, an.b {

    /* renamed from: a  reason: collision with root package name */
    private CJRUpcomingMovieFilterData f74102a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRMovieLanguages> f74103b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRMovieLanguages> f74104c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRUpcomingMovieReleaseDate> f74105d;

    /* renamed from: e  reason: collision with root package name */
    private ComingSoonMovie f74106e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f74107f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f74108g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f74109h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f74110i;
    private ak j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.upcoming_movie_filter_layout);
        Intent intent = getIntent();
        if (intent.hasExtra("upcoming_filter_data")) {
            this.f74102a = (CJRUpcomingMovieFilterData) intent.getSerializableExtra("upcoming_filter_data");
            this.f74103b = this.f74102a.getmLanguageList();
            this.f74104c = this.f74102a.getmGenreList();
            this.f74105d = this.f74102a.getmReleaseDateList();
            this.f74106e = this.f74102a.getComingSoonMovie();
        }
        this.f74110i = (RecyclerView) findViewById(R.id.filter_recycler_view);
        if (this.f74102a != null) {
            this.f74110i.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f74110i.setHasFixedSize(true);
            this.j = new ak(this.f74102a, this, this, this);
            this.f74110i.setAdapter(this.j);
        }
        this.f74107f = (ImageView) findViewById(R.id.upcoming_filters_cross);
        this.f74108g = (TextView) findViewById(R.id.upcoming_filters_clearall);
        this.f74109h = (TextView) findViewById(R.id.upcoming_filters_apply);
        this.f74107f.setOnClickListener(this);
        this.f74108g.setOnClickListener(this);
        this.f74109h.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        int id = view.getId();
        if (id == R.id.upcoming_filters_cross) {
            finish();
            findViewById(R.id.filter_progress_bar).setVisibility(0);
            CJRUpcomingMovieFilterData cJRUpcomingMovieFilterData = new CJRUpcomingMovieFilterData();
            cJRUpcomingMovieFilterData.setmLanguageList(this.f74103b);
            cJRUpcomingMovieFilterData.setmGenreList(this.f74104c);
            cJRUpcomingMovieFilterData.setmReleaseDateList(this.f74105d);
            cJRUpcomingMovieFilterData.setComingSoonMovie(this.f74106e);
            intent.putExtra("upcoming_filter_result", cJRUpcomingMovieFilterData);
            intent.putExtra("clear_all", false);
            setResult(-1, intent);
            finish();
        } else if (id == R.id.upcoming_filters_apply) {
            findViewById(R.id.filter_progress_bar).setVisibility(0);
            CJRUpcomingMovieFilterData cJRUpcomingMovieFilterData2 = new CJRUpcomingMovieFilterData();
            cJRUpcomingMovieFilterData2.setmLanguageList(this.f74103b);
            cJRUpcomingMovieFilterData2.setmGenreList(this.f74104c);
            cJRUpcomingMovieFilterData2.setmReleaseDateList(this.f74105d);
            cJRUpcomingMovieFilterData2.setComingSoonMovie(this.f74106e);
            intent.putExtra("upcoming_filter_result", cJRUpcomingMovieFilterData2);
            intent.putExtra("clear_all", false);
            setResult(-1, intent);
            finish();
        } else if (id == R.id.upcoming_filters_clearall) {
            findViewById(R.id.filter_progress_bar).setVisibility(0);
            intent.putExtra("clear_all", true);
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(int i2, String str) {
        if (str.equals("genre")) {
            for (int i3 = 0; i3 < this.f74104c.size(); i3++) {
                CJRMovieLanguages cJRMovieLanguages = this.f74104c.get(i3);
                if (i3 == i2) {
                    if (cJRMovieLanguages.getIsSelected()) {
                        cJRMovieLanguages.setIsSelected(false);
                    } else {
                        cJRMovieLanguages.setIsSelected(true);
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList = new ArrayList();
                        Iterator<CJRMovieLanguages> it2 = this.f74104c.iterator();
                        while (it2.hasNext()) {
                            CJRMovieLanguages next = it2.next();
                            if (next.getIsSelected()) {
                                hashSet.add(next.getLanguage());
                            }
                        }
                        arrayList.addAll(hashSet);
                        a((ArrayList<String>) null, arrayList, (ArrayList<String>) null);
                    }
                }
            }
            ak akVar = this.j;
            ArrayList<CJRMovieLanguages> arrayList2 = this.f74104c;
            akVar.f74384d = arrayList2;
            if (!akVar.f74386f.isEmpty()) {
                akVar.f74382b.f74392c.a(arrayList2);
                akVar.f74382b.f74390a.scrollToPosition(i2);
            }
        } else if (str.equals("language")) {
            for (int i4 = 0; i4 < this.f74103b.size(); i4++) {
                CJRMovieLanguages cJRMovieLanguages2 = this.f74103b.get(i4);
                if (i4 == i2) {
                    if (cJRMovieLanguages2.getIsSelected()) {
                        cJRMovieLanguages2.setIsSelected(false);
                    } else {
                        cJRMovieLanguages2.setIsSelected(true);
                        a(a(), (ArrayList<String>) null, (ArrayList<String>) null);
                    }
                }
            }
            ak akVar2 = this.j;
            ArrayList<CJRMovieLanguages> arrayList3 = this.f74103b;
            akVar2.f74383c = arrayList3;
            if (!akVar2.f74386f.isEmpty()) {
                akVar2.f74381a.f74395b.a(arrayList3);
                akVar2.f74381a.f74394a.scrollToPosition(i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087 A[SYNTHETIC, Splitter:B:18:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012b A[Catch:{ Exception -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a0 A[Catch:{ Exception -> 0x01b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<java.lang.String> r12, java.util.ArrayList<java.lang.String> r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x01b2 }
            r0.<init>()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r1 = "screenName"
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.O     // Catch:{ Exception -> 0x01b2 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.t     // Catch:{ Exception -> 0x01b2 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r1 = ","
            r2 = 0
            java.lang.String r3 = ""
            if (r12 == 0) goto L_0x0081
            boolean r4 = r12.isEmpty()     // Catch:{ Exception -> 0x01b2 }
            if (r4 != 0) goto L_0x0081
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r4.<init>()     // Catch:{ Exception -> 0x01b2 }
            r4.append(r3)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r5 = "language_selected"
            r4.append(r5)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01b2 }
            java.util.Iterator r5 = r12.iterator()     // Catch:{ Exception -> 0x01b2 }
            r6 = r3
            r7 = 0
        L_0x0037:
            boolean r8 = r5.hasNext()     // Catch:{ Exception -> 0x01b2 }
            if (r8 == 0) goto L_0x006c
            java.lang.Object r8 = r5.next()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x01b2 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r9.<init>()     // Catch:{ Exception -> 0x01b2 }
            r9.append(r6)     // Catch:{ Exception -> 0x01b2 }
            r9.append(r8)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x01b2 }
            int r8 = r12.size()     // Catch:{ Exception -> 0x01b2 }
            int r8 = r8 + -1
            if (r7 >= r8) goto L_0x0069
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r8.<init>()     // Catch:{ Exception -> 0x01b2 }
            r8.append(r6)     // Catch:{ Exception -> 0x01b2 }
            r8.append(r1)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x0069:
            int r7 = r7 + 1
            goto L_0x0037
        L_0x006c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r12.<init>()     // Catch:{ Exception -> 0x01b2 }
            r12.append(r3)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r5 = "language_"
            r12.append(r5)     // Catch:{ Exception -> 0x01b2 }
            r12.append(r6)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01b2 }
            goto L_0x0083
        L_0x0081:
            r12 = r3
            r4 = r12
        L_0x0083:
            java.lang.String r5 = "/"
            if (r13 == 0) goto L_0x0108
            boolean r6 = r13.isEmpty()     // Catch:{ Exception -> 0x01b2 }
            if (r6 != 0) goto L_0x0108
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r6.<init>()     // Catch:{ Exception -> 0x01b2 }
            r6.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r4 = "genre_selected"
            r6.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x01b2 }
            java.util.Iterator r6 = r13.iterator()     // Catch:{ Exception -> 0x01b2 }
            r7 = r3
            r8 = 0
        L_0x00a4:
            boolean r9 = r6.hasNext()     // Catch:{ Exception -> 0x01b2 }
            if (r9 == 0) goto L_0x00d9
            java.lang.Object r9 = r6.next()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x01b2 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r10.<init>()     // Catch:{ Exception -> 0x01b2 }
            r10.append(r7)     // Catch:{ Exception -> 0x01b2 }
            r10.append(r9)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x01b2 }
            int r9 = r13.size()     // Catch:{ Exception -> 0x01b2 }
            int r9 = r9 + -1
            if (r8 >= r9) goto L_0x00d6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r9.<init>()     // Catch:{ Exception -> 0x01b2 }
            r9.append(r7)     // Catch:{ Exception -> 0x01b2 }
            r9.append(r1)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x00d6:
            int r8 = r8 + 1
            goto L_0x00a4
        L_0x00d9:
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01b2 }
            if (r13 != 0) goto L_0x00f4
            int r13 = r12.length()     // Catch:{ Exception -> 0x01b2 }
            if (r13 <= 0) goto L_0x00f4
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r13.<init>()     // Catch:{ Exception -> 0x01b2 }
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            r13.append(r5)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x00f4:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r13.<init>()     // Catch:{ Exception -> 0x01b2 }
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = "genre_"
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            r13.append(r7)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x0108:
            if (r14 == 0) goto L_0x0189
            boolean r13 = r14.isEmpty()     // Catch:{ Exception -> 0x01b2 }
            if (r13 != 0) goto L_0x0189
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r13.<init>()     // Catch:{ Exception -> 0x01b2 }
            r13.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r4 = "release_date_selected"
            r13.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r4 = r13.toString()     // Catch:{ Exception -> 0x01b2 }
            java.util.Iterator r13 = r14.iterator()     // Catch:{ Exception -> 0x01b2 }
        L_0x0125:
            boolean r6 = r13.hasNext()     // Catch:{ Exception -> 0x01b2 }
            if (r6 == 0) goto L_0x015a
            java.lang.Object r6 = r13.next()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01b2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r7.<init>()     // Catch:{ Exception -> 0x01b2 }
            r7.append(r3)     // Catch:{ Exception -> 0x01b2 }
            r7.append(r6)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x01b2 }
            int r6 = r14.size()     // Catch:{ Exception -> 0x01b2 }
            int r6 = r6 + -1
            if (r2 >= r6) goto L_0x0157
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r6.<init>()     // Catch:{ Exception -> 0x01b2 }
            r6.append(r3)     // Catch:{ Exception -> 0x01b2 }
            r6.append(r1)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x0157:
            int r2 = r2 + 1
            goto L_0x0125
        L_0x015a:
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01b2 }
            if (r13 != 0) goto L_0x0175
            int r13 = r12.length()     // Catch:{ Exception -> 0x01b2 }
            if (r13 <= 0) goto L_0x0175
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r13.<init>()     // Catch:{ Exception -> 0x01b2 }
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            r13.append(r5)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x0175:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r13.<init>()     // Catch:{ Exception -> 0x01b2 }
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = "release_date_"
            r13.append(r12)     // Catch:{ Exception -> 0x01b2 }
            r13.append(r3)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x0189:
            java.lang.String r13 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x01b2 }
            r0.put(r13, r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r13 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x01b2 }
            r0.put(r13, r12)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r12 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r13 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x01b2 }
            r0.put(r12, r13)     // Catch:{ Exception -> 0x01b2 }
            boolean r12 = com.paytm.utility.b.r((android.content.Context) r11)     // Catch:{ Exception -> 0x01b2 }
            if (r12 == 0) goto L_0x01a9
            java.lang.String r12 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r13 = com.paytm.utility.b.n((android.content.Context) r11)     // Catch:{ Exception -> 0x01b2 }
            r0.put(r12, r13)     // Catch:{ Exception -> 0x01b2 }
        L_0x01a9:
            net.one97.paytm.o2o.movies.common.c.b r12 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.o2o.movies.common.c.c r12 = r12.f75033b     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r13 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x01b2 }
            r12.sendCustomEventWithMap(r13, r0, r11)     // Catch:{ Exception -> 0x01b2 }
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMovieFilter.a(java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):void");
    }

    public final void a(int i2) {
        ArrayList<CJRUpcomingMovieReleaseDate> arrayList = this.f74105d;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < this.f74105d.size(); i3++) {
                if (i3 != i2 || this.f74105d.get(i3).isExpanded()) {
                    this.f74105d.get(i3).setExpanded(false);
                } else {
                    this.f74105d.get(i3).setExpanded(true);
                }
            }
            ak akVar = this.j;
            if (akVar != null) {
                akVar.a(this.f74105d);
            }
        }
    }

    public final void a(int i2, int i3) {
        ArrayList<CJRUpcomingMovieReleaseDate> arrayList = this.f74105d;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i4 = 0; i4 < this.f74105d.get(i2).getReleaseMonths().size(); i4++) {
                if (i4 == i3) {
                    if (this.f74105d.get(i2).getReleaseMonths().get(i4).getIsSelected()) {
                        this.f74105d.get(i2).getReleaseMonths().get(i4).setIsSelected(false);
                    } else {
                        this.f74105d.get(i2).getReleaseMonths().get(i4).setIsSelected(true);
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<CJRUpcomingMovieReleaseDate> it2 = this.f74105d.iterator();
                        while (it2.hasNext()) {
                            Iterator<CJRMovieLanguages> it3 = it2.next().getReleaseMonths().iterator();
                            while (it3.hasNext()) {
                                CJRMovieLanguages next = it3.next();
                                if (next.getIsSelected()) {
                                    hashSet.add(next.getLanguage());
                                }
                            }
                        }
                        arrayList2.addAll(hashSet);
                        a((ArrayList<String>) null, (ArrayList<String>) null, arrayList2);
                    }
                }
            }
        }
        ak akVar = this.j;
        if (akVar != null) {
            akVar.a(this.f74105d);
        }
    }

    private ArrayList<String> a() {
        HashSet hashSet = new HashSet();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CJRMovieLanguages> it2 = this.f74103b.iterator();
        while (it2.hasNext()) {
            CJRMovieLanguages next = it2.next();
            if (next.getIsSelected()) {
                hashSet.add(next.getLanguage());
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void a(RecyclerView recyclerView) {
        Rect rect = new Rect();
        this.f74110i.getDrawingRect(rect);
        float y = recyclerView.getY();
        if (!(((float) rect.top) < y && ((float) rect.bottom) > ((float) recyclerView.getHeight()) + y)) {
            this.f74110i.smoothScrollToPosition(15);
        }
    }
}
