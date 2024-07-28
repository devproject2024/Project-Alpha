package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSearchCategory;
import net.one97.paytm.o2o.movies.utils.n;

public class h extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f75318c = h.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f75319a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Object> f75320b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f75321d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f75322e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f75323f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRMovieHomeListItem f75324g;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fjr_movie_search, viewGroup, false);
        this.f75323f = (RelativeLayout) inflate.findViewById(R.id.no_movies_err_lyt);
        this.f75322e = (ProgressBar) inflate.findViewById(R.id.movies_progress);
        this.f75321d = (RecyclerView) inflate.findViewById(R.id.movie_recycler_view);
        this.f75321d.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {
            if (Build.VERSION.SDK_INT < 21 && getActivity() != null) {
                getActivity().getWindow().setSoftInputMode(32);
            }
        } catch (Exception unused) {
        }
        this.f75321d.addOnScrollListener(new RecyclerView.l() {
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (h.this.getActivity() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) h.this.getActivity().getSystemService("input_method");
                    if (i3 > 0) {
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(h.this.f75321d.getWindowToken(), 0);
                        }
                    } else if (i3 < 0 && inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(h.this.f75321d.getWindowToken(), 0);
                    }
                }
            }
        });
        ArrayList<Object> arrayList = this.f75320b;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f75322e.setVisibility(8);
            this.f75323f.setVisibility(0);
        } else {
            a aVar = new a(getActivity(), this.f75320b);
            this.f75322e.setVisibility(8);
            this.f75323f.setVisibility(8);
            this.f75321d.setAdapter(aVar);
        }
        return inflate;
    }

    public class a extends RecyclerView.a<C1489a> {

        /* renamed from: a  reason: collision with root package name */
        public Context f75326a;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f75328c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Object> f75329d = new ArrayList<>();

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
            final C1489a aVar = (C1489a) vVar;
            Object a2 = a(i2);
            "------------POSITION-----------".concat(String.valueOf(i2));
            b.j();
            if (a2 instanceof CJRSearchCategory) {
                aVar.f75334b.setVisibility(0);
                aVar.f75335c.setVisibility(8);
                aVar.f75333a.setVisibility(8);
                CJRSearchCategory cJRSearchCategory = (CJRSearchCategory) a2;
                if (cJRSearchCategory.getCategoryTitle().equalsIgnoreCase("3D")) {
                    aVar.f75334b.setText(n.b(cJRSearchCategory.getCategoryTitle()).toUpperCase());
                } else {
                    aVar.f75334b.setText(n.b(cJRSearchCategory.getCategoryTitle()).toUpperCase());
                }
            } else if (a2 instanceof CJRMovieHomeListItem) {
                aVar.f75334b.setVisibility(8);
                aVar.f75335c.setVisibility(0);
                aVar.f75333a.setVisibility(0);
                CJRMovieHomeListItem unused = h.this.f75324g = (CJRMovieHomeListItem) a2;
                aVar.f75335c.setText(h.this.f75324g.getLabel());
                aVar.f75335c.setOnClickListener(new View.OnClickListener() {
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x01cd */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onClick(android.view.View r8) {
                        /*
                            r7 = this;
                            net.one97.paytm.o2o.movies.fragment.h$a r8 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r8 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            int r1 = r6     // Catch:{ Exception -> 0x01f0 }
                            java.lang.Object r0 = r0.a(r1)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem) r0     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem unused = r8.f75324g = r0     // Catch:{ Exception -> 0x01f0 }
                            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "--------MOVIE NAME---------"
                            r8.<init>(r0)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r0 = r0.f75324g     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = r0.getLabel()     // Catch:{ Exception -> 0x01f0 }
                            r8.append(r0)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "--------------MOVIE CODE-----------"
                            r8.append(r0)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r0 = r0.f75324g     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x01f0 }
                            r8.append(r0)     // Catch:{ Exception -> 0x01f0 }
                            com.paytm.utility.b.j()     // Catch:{ Exception -> 0x01f0 }
                            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x01f0 }
                            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity> r1 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.class
                            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "movie_ticket_city_selected"
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r1 = r1.f75319a     // Catch:{ Exception -> 0x01f0 }
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "movie_ticket_specific_city_selected"
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r1 = r1.f75319a     // Catch:{ Exception -> 0x01f0 }
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "movie_ticket_selected_item_type"
                            java.lang.String r1 = "movie"
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r0 = r0.f75324g     // Catch:{ Exception -> 0x01f0 }
                            if (r0 == 0) goto L_0x00a7
                            java.lang.String r0 = "movie_ticket_selected_item_value"
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r1 = r1.f75324g     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x01f0 }
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "movie_ticket_selected_format_id"
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r1 = r1.f75324g     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r1 = r1.getFrmtId()     // Catch:{ Exception -> 0x01f0 }
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = "movie_ticket_other_screen_formats"
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r1 = r1.f75324g     // Catch:{ Exception -> 0x01f0 }
                            r8.putExtra(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                        L_0x00a7:
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            android.content.Context r0 = r0.f75326a     // Catch:{ Exception -> 0x01f0 }
                            if (r0 == 0) goto L_0x00c7
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            android.content.Context r0 = r0.f75326a     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r1 = "input_method"
                            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ Exception -> 0x01f0 }
                            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch:{ Exception -> 0x01f0 }
                            if (r0 == 0) goto L_0x00c7
                            net.one97.paytm.o2o.movies.fragment.h$a$a r1 = r5     // Catch:{ Exception -> 0x01f0 }
                            com.paytm.utility.RoboTextView r1 = r1.f75335c     // Catch:{ Exception -> 0x01f0 }
                            android.os.IBinder r1 = r1.getWindowToken()     // Catch:{ Exception -> 0x01f0 }
                            r2 = 0
                            r0.hideSoftInputFromWindow(r1, r2)     // Catch:{ Exception -> 0x01f0 }
                        L_0x00c7:
                            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x01f0 }
                            r0.<init>()     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r1 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r1 = r1.f75324g     // Catch:{ Exception -> 0x01f0 }
                            r0.add(r1)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.utils.i r1 = net.one97.paytm.o2o.movies.utils.i.a()     // Catch:{ Exception -> 0x01f0 }
                            r1.f75937g = r0     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem r0 = r0.f75324g     // Catch:{ Exception -> 0x01f0 }
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = "----Movies Frag--------Language-----"
                            r1.<init>(r2)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = r0.getLang()     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r2)     // Catch:{ Exception -> 0x01f0 }
                            r1.append(r2)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = "----Title----"
                            r1.append(r2)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = r0.getLabel()     // Catch:{ Exception -> 0x01f0 }
                            r1.append(r2)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = "-----City----"
                            r1.append(r2)     // Catch:{ Exception -> 0x01f0 }
                            com.paytm.utility.b.j()     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r1 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = r0.getLang()     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r2 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r2)     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r0 = r0.getLabel()     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r3 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r3 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r3 = r3.f75319a     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r4 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            android.content.Context r4 = r4.f75326a     // Catch:{ Exception -> 0x01f0 }
                            java.lang.String r4 = com.paytm.utility.b.n((android.content.Context) r4)     // Catch:{ Exception -> 0x01f0 }
                            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01f0 }
                            if (r4 != 0) goto L_0x0136
                            net.one97.paytm.o2o.movies.fragment.h$a r4 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            android.content.Context r4 = r4.f75326a     // Catch:{ Exception -> 0x01f0 }
                            com.paytm.utility.b.n((android.content.Context) r4)     // Catch:{ Exception -> 0x01f0 }
                        L_0x0136:
                            java.lang.String r4 = "Movie"
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r6 = "-------------Movies Frag----- searchCategory---"
                            r5.<init>(r6)     // Catch:{ Exception -> 0x01cd }
                            r5.append(r2)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r6 = "------movieName ----"
                            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
                            r5.append(r0)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r6 = "------cinemaName-----"
                            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
                            r6 = 0
                            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r6 = "----cityName----"
                            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
                            r5.append(r3)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r3 = "---listingType--"
                            r5.append(r3)     // Catch:{ Exception -> 0x01cd }
                            r5.append(r4)     // Catch:{ Exception -> 0x01cd }
                            com.paytm.utility.b.j()     // Catch:{ Exception -> 0x01cd }
                            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x01cd }
                            r3.<init>()     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r4 = "screenName"
                            java.lang.String r5 = "/movies"
                            r3.put(r4, r5)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.x     // Catch:{ Exception -> 0x01cd }
                            r3.put(r4, r5)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r4 = "movie_search_category"
                            r3.put(r4, r2)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r2 = ""
                            if (r0 == 0) goto L_0x01a3
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
                            r2.<init>()     // Catch:{ Exception -> 0x01cd }
                            r2.append(r0)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r4 = "|NA"
                            r2.append(r4)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r5 = "Homescreen-"
                            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r0 = r5.concat(r0)     // Catch:{ Exception -> 0x01cd }
                            r3.put(r4, r0)     // Catch:{ Exception -> 0x01cd }
                        L_0x01a3:
                            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x01cd }
                            r3.put(r0, r2)     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x01cd }
                            r3.put(r0, r2)     // Catch:{ Exception -> 0x01cd }
                            android.content.Context r0 = r1.f75326a     // Catch:{ Exception -> 0x01cd }
                            boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x01cd }
                            if (r0 == 0) goto L_0x01c2
                            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x01cd }
                            android.content.Context r2 = r1.f75326a     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)     // Catch:{ Exception -> 0x01cd }
                            r3.put(r0, r2)     // Catch:{ Exception -> 0x01cd }
                        L_0x01c2:
                            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01cd }
                            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x01cd }
                            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x01cd }
                            android.content.Context r1 = r1.f75326a     // Catch:{ Exception -> 0x01cd }
                            r0.sendCustomEventWithMap(r2, r3, r1)     // Catch:{ Exception -> 0x01cd }
                        L_0x01cd:
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h.d(r0)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r0 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r0 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x01f0 }
                            r0.startActivity(r8)     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h$a r8 = net.one97.paytm.o2o.movies.fragment.h.a.this     // Catch:{ Exception -> 0x01f0 }
                            net.one97.paytm.o2o.movies.fragment.h r8 = net.one97.paytm.o2o.movies.fragment.h.this     // Catch:{ Exception -> 0x01f0 }
                            androidx.fragment.app.FragmentActivity r8 = r8.getActivity()     // Catch:{ Exception -> 0x01f0 }
                            int r0 = net.one97.paytm.common.assets.R.anim.slide_in_right     // Catch:{ Exception -> 0x01f0 }
                            r1 = 17432577(0x10a0001, float:2.53466E-38)
                            r8.overridePendingTransition(r0, r1)     // Catch:{ Exception -> 0x01f0 }
                            return
                        L_0x01f0:
                            r8 = move-exception
                            boolean r0 = com.paytm.utility.b.v
                            if (r0 == 0) goto L_0x01ff
                            java.lang.String unused = net.one97.paytm.o2o.movies.fragment.h.f75318c
                            java.lang.String r8 = r8.getMessage()
                            com.paytm.utility.q.c(r8)
                        L_0x01ff:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.h.a.AnonymousClass1.onClick(android.view.View):void");
                    }
                });
            }
        }

        public a(Context context, ArrayList<Object> arrayList) {
            this.f75326a = context;
            this.f75329d = arrayList;
            this.f75328c = (LayoutInflater) this.f75326a.getSystemService("layout_inflater");
        }

        public final int getItemCount() {
            new StringBuilder("---------------SIZE MOVIE SEARCH------------").append(this.f75329d.size());
            b.j();
            return this.f75329d.size();
        }

        /* access modifiers changed from: package-private */
        public final Object a(int i2) {
            return this.f75329d.get(i2);
        }

        /* renamed from: net.one97.paytm.o2o.movies.fragment.h$a$a  reason: collision with other inner class name */
        class C1489a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            final View f75333a;

            /* renamed from: b  reason: collision with root package name */
            RoboTextView f75334b;

            /* renamed from: c  reason: collision with root package name */
            RoboTextView f75335c;

            public C1489a(View view) {
                super(view);
                this.f75334b = (RoboTextView) view.findViewById(R.id.heading);
                this.f75335c = (RoboTextView) view.findViewById(R.id.value);
                this.f75333a = view.findViewById(R.id.bottom_border);
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C1489a(LayoutInflater.from(this.f75326a).inflate(R.layout.movies_search_item, viewGroup, false));
        }
    }

    static /* synthetic */ void d(h hVar) {
        try {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEvents("mov_search_performed", hVar.getActivity());
        } catch (Exception unused) {
        }
    }
}
