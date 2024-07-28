package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ah;
import net.one97.paytm.o2o.movies.adapter.v;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.Promo;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.o;

public class ah extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private final String f74319a = ah.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f74320b = 21;

    /* renamed from: c  reason: collision with root package name */
    private final int f74321c = 22;

    /* renamed from: d  reason: collision with root package name */
    private final int f74322d = 23;

    /* renamed from: e  reason: collision with root package name */
    private List<CJRMovieSessionDetails> f74323e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<CJRMovieSessionDetails> f74324f;

    /* renamed from: g  reason: collision with root package name */
    private List<CJRCinemaV2> f74325g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f74326h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Context f74327i;
    /* access modifiers changed from: private */
    public String j;
    private LayoutInflater k;
    private r l;
    private boolean m = true;
    private String n = "";
    private ConstraintLayout o;
    private boolean p = false;
    private Handler q = new Handler();
    private Runnable r = new Runnable() {
        public final void run() {
            ah.this.f74326h.e();
        }
    };

    public interface a {
        void a();

        void a(int i2);

        void a(int i2, CJRMoviesSession cJRMoviesSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, List<CJRMoviesSession> list, int i4);

        void a(String str);

        void a(boolean z, boolean z2);

        void b(String str);

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        boolean f();
    }

    public ah(Context context, String str, List<CJRCinemaV2> list, a aVar, ConstraintLayout constraintLayout) {
        this.f74327i = context;
        this.j = str;
        this.f74325g = list;
        this.k = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f74326h = aVar;
        this.o = constraintLayout;
    }

    public int getItemViewType(int i2) {
        super.getItemViewType(i2);
        if (i2 == 0 && this.f74324f.size() > 0 && this.f74324f.get(0).isSearchView) {
            return 23;
        }
        if (!net.one97.paytm.o2o.movies.common.d.a((List) this.f74324f)) {
            return (this.f74324f.size() != 1 || !this.f74324f.get(0).isSearchView || this.n.isEmpty()) ? 22 : 21;
        }
        return 21;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 22) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.theatre_list_item, (ViewGroup) null));
        }
        if (i2 == 23) {
            return new c(this.o);
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.theatre_list_adapter_no_movie_lyt, (ViewGroup) null));
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        try {
            if (vVar instanceof c) {
                vVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                if (!this.n.isEmpty() || this.f74326h.c()) {
                    EditText editText = (EditText) vVar.itemView.findViewById(R.id.search);
                    editText.setCursorVisible(true);
                    editText.setFocusable(true);
                    editText.requestFocus();
                }
                if (!this.p) {
                    this.f74326h.a();
                }
            } else if (vVar instanceof d) {
                ((d) vVar).a(i2);
            } else if (vVar instanceof b) {
                b bVar = (b) vVar;
                if (ah.this.n.isEmpty()) {
                    ah.this.n = ah.this.f74327i.getString(R.string.your_search);
                }
                bVar.f74329a.setText(ah.this.f74327i.getString(R.string.movies_err_msg, new Object[]{ah.this.n}));
            }
        } catch (Exception e2) {
            ah.class.getSimpleName();
            q.c(e2.getMessage());
        }
    }

    public int getItemCount() {
        List<CJRMovieSessionDetails> list = this.f74324f;
        if (list == null) {
            return 0;
        }
        if (list.size() == 1 && this.f74324f.get(0).isSearchView && !this.f74326h.d() && !this.f74326h.f()) {
            return 2;
        }
        if (net.one97.paytm.o2o.movies.common.d.a((List) this.f74324f)) {
            return 1;
        }
        return this.f74324f.size();
    }

    public final void a(List<CJRMovieSessionDetails> list) {
        this.f74323e.clear();
        this.f74323e.addAll(list);
    }

    public Filter getFilter() {
        return new o(this.f74323e, new o.a() {
            public final void onFilterCompleted(String str, List list) {
                ah.this.a(str, list);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, List list) {
        this.n = str;
        List<CJRMovieSessionDetails> list2 = this.f74324f;
        if (list2 == null) {
            this.f74324f = new ArrayList();
        } else {
            list2.clear();
        }
        this.q.removeCallbacks(this.r);
        this.q.post(this.r);
        if (list != null && list.size() > 0) {
            this.f74324f.addAll(list);
        }
        this.f74326h.a(list == null ? 0 : list.size());
        if (list == null || list.size() <= 3) {
            this.f74326h.a(false, true);
        } else {
            this.f74326h.a(true, false);
        }
        if ((this.f74324f.isEmpty() && !this.n.isEmpty()) || this.f74324f.size() > 3 || this.f74326h.b()) {
            CJRMovieSessionDetails cJRMovieSessionDetails = new CJRMovieSessionDetails();
            cJRMovieSessionDetails.isSearchView = true;
            if (this.f74324f.size() > 0) {
                this.p = true;
                if (!this.f74324f.get(0).isSearchView) {
                    this.f74324f.add(0, cJRMovieSessionDetails);
                } else {
                    this.f74324f.remove(0);
                    this.f74324f.add(0, cJRMovieSessionDetails);
                }
            } else {
                this.p = true;
                this.f74324f.add(0, cJRMovieSessionDetails);
            }
        }
        notifyDataSetChanged();
        if (this.f74326h.c()) {
            notifyItemChanged(0);
        }
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f74329a;

        public b(View view) {
            super(view);
            this.f74329a = (TextView) view.findViewById(R.id.error_msg2);
        }
    }

    class c extends RecyclerView.v {
        public c(View view) {
            super(view);
        }
    }

    class d extends RecyclerView.v implements v.a {

        /* renamed from: b  reason: collision with root package name */
        private final ImageView f74333b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f74334c;

        /* renamed from: d  reason: collision with root package name */
        private final LinearLayout f74335d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f74336e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f74337f;

        /* renamed from: g  reason: collision with root package name */
        private final RecyclerView f74338g;

        /* renamed from: h  reason: collision with root package name */
        private final View f74339h;

        /* renamed from: i  reason: collision with root package name */
        private final RelativeLayout f74340i;
        private final TextView j;
        private final TextView k;
        private final View l;
        private final v m;
        private CJRMovieSessionDetails n;
        private int o;

        public d(View view) {
            super(view);
            this.f74333b = (ImageView) view.findViewById(R.id.sortByDistanceImg);
            this.f74334c = (TextView) view.findViewById(R.id.txt_theatre_distance);
            this.f74335d = (LinearLayout) view.findViewById(R.id.ll_theater_info);
            this.f74336e = (TextView) view.findViewById(R.id.txt_theatre_name);
            this.f74337f = (TextView) view.findViewById(R.id.txt_Langauage);
            this.f74338g = (RecyclerView) view.findViewById(R.id.slots_recycler_view);
            this.f74339h = view.findViewById(R.id.line_divider);
            this.f74340i = (RelativeLayout) view.findViewById(R.id.movie_offer_rel_lyt);
            this.j = (TextView) view.findViewById(R.id.movie_offer_amount);
            this.k = (TextView) view.findViewById(R.id.movie_offer_desc);
            this.l = view.findViewById(R.id.bottom_space);
            this.f74338g.setLayoutManager(new GridLayoutManager(ah.this.f74327i, 4));
            this.m = new v(new ArrayList(), ah.this.f74327i, false, this);
            this.f74338g.setAdapter(this.m);
        }

        public final void a(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            ah.this.f74326h.a(this.o, cJRMoviesSession, this.n.getmLanguage(), this.n.getmLocalizedLanguage(), this.n.getmCensor(), this.n.getmImageUrl(), this.n.getMmovietitle(), this.n.getmLocalizedMovieDisplay(), n.b(cJRMoviesSession.getSeatsAvailable(), cJRMoviesSession.getTotalSeats()), n.c(cJRMoviesSession.getRealShowDateTime()), this.n.getDuration(), com.paytm.utility.v.a(cJRMoviesSession.getMovieCode()) ? this.n.getMmoviecode() : cJRMoviesSession.getMovieCode(), arrayList, i2);
        }

        public final void b(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            String str;
            String b2 = n.b(cJRMoviesSession.getSeatsAvailable(), cJRMoviesSession.getTotalSeats());
            String c2 = n.c(cJRMoviesSession.getRealShowDateTime());
            if (ah.this.j == null || !ah.this.j.equalsIgnoreCase("movie")) {
                str = this.n.getmLocalizedMovieDisplay();
            } else {
                str = this.n.getmLocalizedCinemaName();
            }
            ah.a(ah.this, cJRMoviesSession.getMoviesSessionDetails(), c2, str, view, this.o, b2, this.n, cJRMoviesSession, arrayList, i2);
            ah.a(ah.this, this.n.getMmovietitle(), this.n.getMmoviecode(), cJRMoviesSession.getCinemaName(), cJRMoviesSession.getCinemaID(), b2);
        }

        public final void a(int i2) {
            this.f74340i.setVisibility(8);
            if (ah.this.f74324f == null || ah.this.f74324f.get(i2) == null) {
                this.f74336e.setText("");
                this.f74336e.setLayoutParams(new RelativeLayout.LayoutParams(-2, (int) ah.this.f74327i.getResources().getDimension(R.dimen.movie_list_footer)));
                this.f74338g.setVisibility(8);
                this.f74337f.setText("");
                this.f74337f.setVisibility(8);
                return;
            }
            this.n = (CJRMovieSessionDetails) ah.this.f74324f.get(i2);
            ah.a(ah.this, this.n);
            this.o = i2;
            if (ah.this.j == null || ah.this.j.equalsIgnoreCase("movie")) {
                if (this.n.getDistanceKm() > 0.0f) {
                    double round = ((double) Math.round(((double) this.n.getDistanceKm()) * 10.0d)) / 10.0d;
                    this.f74334c.setVisibility(0);
                    this.f74333b.setVisibility(0);
                    if (round > 99.0d) {
                        this.f74334c.setText("99+ km");
                    } else {
                        TextView textView = this.f74334c;
                        textView.setText(round + " km");
                    }
                } else {
                    this.f74333b.setVisibility(8);
                    this.f74334c.setVisibility(8);
                }
                this.f74337f.setVisibility(8);
                if (!TextUtils.isEmpty(this.n.getmLocalizedCinemaName())) {
                    this.f74336e.setText(this.n.getmLocalizedCinemaName());
                } else {
                    this.f74336e.setText(this.n.getMcinemaName());
                }
            } else {
                this.f74337f.setVisibility(0);
                if (this.n.getmLanguage() != null) {
                    TextView textView2 = this.f74337f;
                    textView2.setText("(" + n.b(this.n.getmLocalizedLanguage()));
                    TextView textView3 = this.f74337f;
                    textView3.setText("(" + n.b(this.n.getmLanguage()) + ", " + this.n.getScreenFormat() + ")");
                } else {
                    this.f74337f.setText("");
                }
                if (!TextUtils.isEmpty(this.n.getmLocalizedMovieDisplay())) {
                    this.f74336e.setText(this.n.getmLocalizedMovieDisplay());
                } else {
                    this.f74336e.setText(this.n.getMmovietitle());
                }
            }
            if (ah.this.j != null && ah.this.j.equalsIgnoreCase("movie")) {
                this.f74336e.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ah.d.this.b(view);
                    }
                });
            } else if (ah.this.j != null && ah.this.j.equalsIgnoreCase("cinema")) {
                this.f74335d.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ah.d.this.a(view);
                    }
                });
            }
            ArrayList<CJRMoviesSession> arrayList = this.n.getmMoviesSession();
            if (arrayList != null) {
                Collections.sort(arrayList, new CJRMoviesSession.a());
                if (arrayList.size() > 0) {
                    Promo a2 = ah.a(ah.this, arrayList.get(0).getCinemaID());
                    if (a2 == null || a2.getCategory() == null || !a2.getCategory().toLowerCase().contains("promo")) {
                        this.f74340i.setVisibility(8);
                    } else if (!(a2.getHeader() == null || a2.getText() == null)) {
                        this.f74340i.setVisibility(0);
                        this.j.setText(a2.getHeader());
                        this.k.setText(a2.getText());
                    }
                } else {
                    this.f74340i.setVisibility(8);
                }
                this.m.a(arrayList);
                if (i2 + 1 == ah.this.getItemCount()) {
                    this.f74339h.setVisibility(8);
                    this.l.setVisibility(0);
                    return;
                }
                this.l.setVisibility(8);
                this.f74339h.setVisibility(0);
                return;
            }
            this.f74340i.setVisibility(8);
            this.f74338g.setVisibility(8);
            this.f74336e.setVisibility(8);
            this.f74338g.setVisibility(8);
            this.f74337f.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            CJRCinemas cJRCinemas = new CJRCinemas();
            cJRCinemas.setPaytmCinemaId(Integer.valueOf(this.n.getMcinemaid()));
            if (!(i.a().f75933c == null || i.a().f75933c.indexOf(cJRCinemas) == -1)) {
                i.a().f75936f = i.a().f75933c.get(i.a().f75933c.indexOf(cJRCinemas));
            }
            ah.this.f74326h.a(this.n.getMcinemaid());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            String movieCode = (this.n.getmMoviesSession() == null || this.n.getmMoviesSession().isEmpty()) ? "" : this.n.getmMoviesSession().get(0).getMovieCode();
            if (!TextUtils.isEmpty(movieCode)) {
                ah.this.f74326h.b(movieCode);
            } else {
                Toast.makeText(ah.this.f74327i, R.string.error_something_went_wrong, 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMoviesSession cJRMoviesSession, View view, int i2, String str, CJRMovieSessionDetails cJRMovieSessionDetails, List list, int i3, Dialog dialog, AdapterView adapterView, View view2, int i4, long j2) {
        if (cJRMoviesSession.getSeatsAvailable() > 0) {
            a(i2, cJRMoviesSession, str, cJRMovieSessionDetails, (List<CJRMoviesSession>) list, i3);
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMoviesSession cJRMoviesSession, View view, int i2, String str, CJRMovieSessionDetails cJRMovieSessionDetails, List list, int i3, Dialog dialog, View view2) {
        if (cJRMoviesSession.getSeatsAvailable() > 0) {
            a(i2, cJRMoviesSession, str, cJRMovieSessionDetails, (List<CJRMoviesSession>) list, i3);
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void a(int i2, CJRMoviesSession cJRMoviesSession, String str, CJRMovieSessionDetails cJRMovieSessionDetails, List<CJRMoviesSession> list, int i3) {
        this.f74326h.a(i2, cJRMoviesSession, cJRMovieSessionDetails.getmLanguage(), cJRMovieSessionDetails.getmLocalizedLanguage(), cJRMovieSessionDetails.getmCensor(), cJRMovieSessionDetails.getmImageUrl(), cJRMovieSessionDetails.getMmovietitle(), cJRMovieSessionDetails.getmLocalizedMovieDisplay(), str, n.c(cJRMoviesSession.getRealShowDateTime()), cJRMovieSessionDetails.getDuration(), com.paytm.utility.v.a(cJRMoviesSession.getMovieCode()) ? cJRMovieSessionDetails.getMmoviecode() : cJRMoviesSession.getMovieCode(), list, i3);
    }

    static /* synthetic */ void a(ah ahVar, ArrayList arrayList, String str, String str2, View view, int i2, String str3, CJRMovieSessionDetails cJRMovieSessionDetails, CJRMoviesSession cJRMoviesSession, List list, int i3) {
        ah ahVar2 = ahVar;
        String str4 = str;
        try {
            Dialog dialog = new Dialog(ahVar2.f74327i, R.style.MoviePriceDialog);
            View inflate = ahVar2.k.inflate(R.layout.lyt_movie_price_dialog, (ViewGroup) null);
            ((RelativeLayout) inflate.findViewById(R.id.movie_price_lyt)).requestDisallowInterceptTouchEvent(true);
            ListView listView = (ListView) inflate.findViewById(R.id.price_list);
            ((TextView) inflate.findViewById(R.id.slotname)).setText(str4);
            ((TextView) inflate.findViewById(R.id.cinema_movie_name)).setText(str2);
            ahVar2.l = new r(ahVar2.f74327i, arrayList, ahVar2.k, str4);
            listView.setAdapter(ahVar2.l);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(cJRMoviesSession, view, i2, str3, cJRMovieSessionDetails, list, i3, dialog) {
                private final /* synthetic */ CJRMoviesSession f$1;
                private final /* synthetic */ View f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ CJRMovieSessionDetails f$5;
                private final /* synthetic */ List f$6;
                private final /* synthetic */ int f$7;
                private final /* synthetic */ Dialog f$8;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                    this.f$8 = r9;
                }

                public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                    ah.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, adapterView, view, i2, j);
                }
            });
            dialog.requestWindowFeature(1);
            dialog.setContentView(inflate);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_corner_movie);
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.width = com.paytm.utility.b.a((Activity) ahVar2.f74327i) - com.paytm.utility.b.a(20, ahVar2.f74327i);
            dialog.getWindow().setAttributes(attributes);
            inflate.setOnClickListener(new View.OnClickListener(cJRMoviesSession, view, i2, str3, cJRMovieSessionDetails, list, i3, dialog) {
                private final /* synthetic */ CJRMoviesSession f$1;
                private final /* synthetic */ View f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ String f$4;
                private final /* synthetic */ CJRMovieSessionDetails f$5;
                private final /* synthetic */ List f$6;
                private final /* synthetic */ int f$7;
                private final /* synthetic */ Dialog f$8;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                    this.f$8 = r9;
                }

                public final void onClick(View view) {
                    ah.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, view);
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088 A[Catch:{ Exception -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.o2o.movies.adapter.ah r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x009e }
            r0.<init>()     // Catch:{ Exception -> 0x009e }
            java.lang.String r1 = r5.j     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = "|"
            java.lang.String r3 = "screenName"
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r5.j     // Catch:{ Exception -> 0x009e }
            java.lang.String r4 = "movie"
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x009e }
            if (r1 == 0) goto L_0x003c
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x009e }
            r0.put(r3, r8)     // Catch:{ Exception -> 0x009e }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x009e }
            java.lang.String r9 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x009e }
            r0.put(r8, r9)     // Catch:{ Exception -> 0x009e }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x009e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r9.<init>()     // Catch:{ Exception -> 0x009e }
            r9.append(r6)     // Catch:{ Exception -> 0x009e }
            r9.append(r2)     // Catch:{ Exception -> 0x009e }
            r9.append(r7)     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x009e }
            r0.put(r8, r6)     // Catch:{ Exception -> 0x009e }
            goto L_0x006d
        L_0x003c:
            java.lang.String r6 = r5.j     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x006d
            java.lang.String r6 = r5.j     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = "cinema"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x006d
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x009e }
            r0.put(r3, r6)     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x009e }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x009e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r7.<init>()     // Catch:{ Exception -> 0x009e }
            r7.append(r8)     // Catch:{ Exception -> 0x009e }
            r7.append(r2)     // Catch:{ Exception -> 0x009e }
            r7.append(r9)     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x009e }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009e }
        L_0x006d:
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = "Showtime Longpress"
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x009e }
            r0.put(r6, r10)     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x009e }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009e }
            android.content.Context r6 = r5.f74327i     // Catch:{ Exception -> 0x009e }
            boolean r6 = com.paytm.utility.b.r((android.content.Context) r6)     // Catch:{ Exception -> 0x009e }
            if (r6 == 0) goto L_0x0093
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x009e }
            android.content.Context r7 = r5.f74327i     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x009e }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009e }
        L_0x0093:
            net.one97.paytm.o2o.movies.common.c.b r6 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x009e }
            net.one97.paytm.o2o.movies.common.c.c r6 = r6.f75033b     // Catch:{ Exception -> 0x009e }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x009e }
            android.content.Context r5 = r5.f74327i     // Catch:{ Exception -> 0x009e }
            r6.sendCustomEventWithMap(r7, r0, r5)     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.ah.a(net.one97.paytm.o2o.movies.adapter.ah, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void a(ah ahVar, CJRMovieSessionDetails cJRMovieSessionDetails) {
        try {
            int indexOf = ahVar.f74323e != null ? ahVar.f74323e.indexOf(cJRMovieSessionDetails) : 0;
            HashMap hashMap = new HashMap();
            hashMap.put("name", cJRMovieSessionDetails.getMcinemaName());
            hashMap.put("id", cJRMovieSessionDetails.getMcinemaid());
            hashMap.put("price", 0);
            hashMap.put(CLPConstants.BRAND_PARAMS, "");
            hashMap.put("category", cJRMovieSessionDetails.getMmovietitle());
            hashMap.put("variant", cJRMovieSessionDetails.getScreenFormat());
            hashMap.put("list", "Theatre listing");
            hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(indexOf + 1));
            net.one97.paytm.o2o.movies.b.a.INSTANCE.addProductImpression(hashMap, false);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ Promo a(ah ahVar, String str) {
        List<CJRCinemaV2> list = ahVar.f74325g;
        if (list != null && list.size() > 0) {
            Iterator<CJRCinemaV2> it2 = ahVar.f74325g.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CJRCinemaV2 next = it2.next();
                if (next.getId().equalsIgnoreCase(str)) {
                    if (next.offerList != null) {
                        return next.offerList.get(0);
                    }
                }
            }
        }
        return null;
    }
}
