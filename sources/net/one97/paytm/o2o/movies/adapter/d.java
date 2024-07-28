package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytm.utility.t;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.d;
import net.one97.paytm.o2o.movies.adapter.v;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidgetValue;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.o;

public final class d extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private final int f74587a = 21;

    /* renamed from: b  reason: collision with root package name */
    private final int f74588b = 22;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRMovieSessionDetails> f74589c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<CJRMovieSessionDetails> f74590d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<CJRCinemaV2> f74591e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f74592f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f74593g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f74594h;

    /* renamed from: i  reason: collision with root package name */
    private LayoutInflater f74595i;
    private r j;
    /* access modifiers changed from: private */
    public int k;
    private String l = "";

    public interface b {
        void a(String str);

        void a(CJRMoviesSession cJRMoviesSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, List<CJRMoviesSession> list, int i3);

        void b(String str);
    }

    public d(Context context, String str, List<CJRCinemaV2> list, b bVar) {
        this.f74593g = context;
        this.f74594h = str;
        this.f74591e = list;
        this.f74595i = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f74592f = bVar;
        this.k = n.a(12, this.f74593g);
    }

    public final int getItemViewType(int i2) {
        super.getItemViewType(i2);
        return net.one97.paytm.o2o.movies.common.d.a((List) this.f74590d) ? 21 : 22;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 22) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cinema_theatre_list_item, (ViewGroup) null));
        }
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.theatre_list_adapter_no_movie_lyt, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        try {
            if (vVar instanceof a) {
                ((a) vVar).a(i2);
            } else if (vVar instanceof c) {
                c cVar = (c) vVar;
                if (d.this.l.isEmpty()) {
                    d.this.l = d.this.f74593g.getString(R.string.your_search);
                }
                cVar.f74605a.setText(d.this.f74593g.getString(R.string.movies_err_msg, new Object[]{d.this.l}));
            }
        } catch (Exception e2) {
            ah.class.getSimpleName();
            q.c(e2.getMessage());
        }
    }

    public final int getItemCount() {
        if (net.one97.paytm.o2o.movies.common.d.a((List) this.f74590d)) {
            return 1;
        }
        return this.f74590d.size();
    }

    public final void a(List<CJRMovieSessionDetails> list) {
        this.f74589c.clear();
        this.f74589c.addAll(list);
        this.f74590d.clear();
        this.f74590d.addAll(list);
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        return new o(this.f74589c, new o.a() {
            public final void onFilterCompleted(String str, List list) {
                d.this.a(str, list);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, List list) {
        this.l = str;
        if (list.size() > 0) {
            this.f74590d.clear();
            this.f74590d.addAll(list);
        } else {
            this.f74590d.clear();
        }
        notifyDataSetChanged();
    }

    class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f74605a;

        public c(View view) {
            super(view);
            this.f74605a = (TextView) view.findViewById(R.id.error_msg2);
        }
    }

    class a extends RecyclerView.v implements v.a {

        /* renamed from: b  reason: collision with root package name */
        private final RelativeLayout f74597b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f74598c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f74599d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f74600e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f74601f;

        /* renamed from: g  reason: collision with root package name */
        private final ImageView f74602g;

        /* renamed from: h  reason: collision with root package name */
        private final View f74603h;

        /* renamed from: i  reason: collision with root package name */
        private final View f74604i;
        private final RecyclerView j;
        private final View k;
        private final RelativeLayout l;
        private final TextView m;
        private final TextView n;
        private final TextView o;
        private final View p;
        private final v q;
        private CJRMovieSessionDetails r;
        private int s;
        private final LinearLayout t;

        public a(View view) {
            super(view);
            this.f74597b = (RelativeLayout) view.findViewById(R.id.ll_theater_info);
            this.f74598c = (TextView) view.findViewById(R.id.txt_theatre_name);
            this.f74599d = (TextView) view.findViewById(R.id.txt_Langauage);
            this.f74603h = view.findViewById(R.id.txt_Langauage_dot);
            this.f74600e = (TextView) view.findViewById(R.id.txt_censor);
            this.f74604i = view.findViewById(R.id.txt_censor_dot);
            this.f74601f = (TextView) view.findViewById(R.id.txt_duration);
            this.f74602g = (ImageView) view.findViewById(R.id.moviePoster);
            this.j = (RecyclerView) view.findViewById(R.id.slots_recycler_view);
            this.k = view.findViewById(R.id.line_divider);
            this.l = (RelativeLayout) view.findViewById(R.id.movie_offer_rel_lyt);
            this.m = (TextView) view.findViewById(R.id.movie_offer_amount);
            this.n = (TextView) view.findViewById(R.id.movie_offer_desc);
            this.p = view.findViewById(R.id.bottom_space);
            this.o = (TextView) view.findViewById(R.id.txt_rating);
            this.t = (LinearLayout) view.findViewById(R.id.ll_movie_rating);
            this.j.setLayoutManager(new GridLayoutManager(d.this.f74593g, 4));
            this.q = new v(new ArrayList(), d.this.f74593g, false, this);
            this.j.setAdapter(this.q);
        }

        public final void a(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            String str;
            String b2 = n.b(cJRMoviesSession.getSeatsAvailable(), cJRMoviesSession.getTotalSeats());
            b b3 = d.this.f74592f;
            String str2 = this.r.getmLanguage();
            String str3 = this.r.getmLocalizedLanguage();
            String str4 = this.r.getmCensor();
            String str5 = this.r.getmImageUrl();
            String mmovietitle = this.r.getMmovietitle();
            String str6 = this.r.getmLocalizedMovieDisplay();
            String c2 = n.c(cJRMoviesSession.getRealShowDateTime());
            int duration = this.r.getDuration();
            if (com.paytm.utility.v.a(cJRMoviesSession.getMovieCode())) {
                str = this.r.getMmoviecode();
            } else {
                str = cJRMoviesSession.getMovieCode();
            }
            b3.a(cJRMoviesSession, str2, str3, str4, str5, mmovietitle, str6, b2, c2, duration, str, arrayList, i2);
        }

        public final void b(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            String str;
            String b2 = n.b(cJRMoviesSession.getSeatsAvailable(), cJRMoviesSession.getTotalSeats());
            String c2 = n.c(cJRMoviesSession.getRealShowDateTime());
            if (d.this.f74594h == null || !d.this.f74594h.equalsIgnoreCase("movie")) {
                str = this.r.getmLocalizedMovieDisplay();
            } else {
                str = this.r.getmLocalizedCinemaName();
            }
            d.a(d.this, cJRMoviesSession.getMoviesSessionDetails(), c2, str, view, this.s, b2, this.r, cJRMoviesSession, arrayList, i2);
            d.a(d.this, this.r.getMmovietitle(), this.r.getMmoviecode(), cJRMoviesSession.getCinemaName(), cJRMoviesSession.getCinemaID(), b2);
        }

        public final void a(int i2) {
            if (d.this.f74590d.get(i2) != null) {
                this.r = (CJRMovieSessionDetails) d.this.f74590d.get(i2);
                this.s = i2;
                if (d.this.f74594h == null || d.this.f74594h.equalsIgnoreCase("movie")) {
                    this.f74599d.setVisibility(8);
                    this.f74603h.setVisibility(8);
                    if (this.r.getRatings() == null || this.r.getRatings().getImdb() == null) {
                        this.t.setVisibility(8);
                    } else {
                        this.t.setVisibility(0);
                        TextView textView = this.o;
                        textView.setText(String.valueOf(this.r.getRatings().getImdb().getRating()) + "/" + this.r.getRatings().getImdb().getBase_rating() + " IMDb");
                    }
                    if (!TextUtils.isEmpty(this.r.getmLocalizedCinemaName())) {
                        this.f74598c.setText(this.r.getmLocalizedCinemaName());
                    } else {
                        this.f74598c.setText(this.r.getMcinemaName());
                    }
                } else {
                    if (this.r.getRatings() == null || this.r.getRatings().getImdb() == null) {
                        this.t.setVisibility(8);
                    } else {
                        this.t.setVisibility(0);
                        TextView textView2 = this.o;
                        textView2.setText(String.valueOf(this.r.getRatings().getImdb().getRating()) + "/" + this.r.getRatings().getImdb().getBase_rating() + " IMDb");
                    }
                    this.f74599d.setVisibility(0);
                    if (this.r.getmLanguage() != null) {
                        this.f74599d.setVisibility(0);
                        this.f74603h.setVisibility(0);
                        this.f74599d.setText(n.b(this.r.getmLocalizedLanguage()));
                    } else {
                        this.f74599d.setText("");
                        this.f74599d.setVisibility(8);
                        this.f74603h.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(this.r.getmLocalizedMovieDisplay())) {
                        this.f74598c.setText(this.r.getmLocalizedMovieDisplay());
                    } else {
                        this.f74598c.setText(this.r.getMmovietitle());
                    }
                    if (!TextUtils.isEmpty(this.r.getmCensor())) {
                        this.f74600e.setVisibility(0);
                        this.f74604i.setVisibility(0);
                        TextView textView3 = this.f74600e;
                        textView3.setText("(" + this.r.getmCensor() + ")");
                    } else {
                        this.f74600e.setVisibility(8);
                        this.f74604i.setVisibility(8);
                    }
                    if (this.r.getDuration() > 0) {
                        int duration = this.r.getDuration() / 60;
                        int duration2 = this.r.getDuration() - (duration * 60);
                        TextView textView4 = this.f74601f;
                        textView4.setText(textView4.getContext().getString(R.string.movies_cinema_movie_duration, new Object[]{Integer.valueOf(duration), Integer.valueOf(duration2)}));
                    }
                    try {
                        String str = this.r.getmImageUrl();
                        if (str != null && !str.startsWith("https://") && !str.startsWith("http://")) {
                            str = "https://".concat(String.valueOf(str));
                        }
                        this.f74602g.setTag(str);
                        Drawable b2 = androidx.appcompat.a.a.a.b(d.this.f74593g, R.drawable.ic_poster_icon);
                        aa a2 = w.a().a(str);
                        a2.f45353b = true;
                        a2.b(b2).a(b2).a((ah) new t.b(d.this.k, 0, true)).a(this.f74602g, (e) null);
                    } catch (Exception unused) {
                    }
                }
                if (d.this.f74594h != null && d.this.f74594h.equalsIgnoreCase("movie")) {
                    this.f74598c.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            d.a.this.b(view);
                        }
                    });
                } else if (d.this.f74594h != null && d.this.f74594h.equalsIgnoreCase("cinema")) {
                    this.f74597b.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            d.a.this.a(view);
                        }
                    });
                }
                ArrayList<CJRMoviesSession> arrayList = this.r.getmMoviesSession();
                if (arrayList != null) {
                    Collections.sort(arrayList, new CJRMoviesSession.a());
                    if (arrayList.size() > 0) {
                        CJRMovieWidget a3 = d.a(d.this, arrayList.get(0).getCinemaID());
                        if (a3 == null || a3.getInfo() == null || !a3.getInfo().getCategory().toLowerCase().contains("promo")) {
                            this.l.setVisibility(8);
                        } else {
                            ArrayList<CJRMovieWidgetValue> values = a3.getInfo().getValues();
                            if (values != null && values.size() > 0) {
                                this.l.setVisibility(0);
                                this.m.setText(values.get(0).getHeader());
                                this.n.setText(values.get(0).getText());
                            }
                        }
                    } else {
                        this.l.setVisibility(8);
                    }
                    this.q.a(arrayList);
                    if (i2 + 1 == d.this.getItemCount()) {
                        this.k.setVisibility(8);
                        this.p.setVisibility(0);
                        return;
                    }
                    this.p.setVisibility(8);
                    this.k.setVisibility(0);
                    return;
                }
                this.l.setVisibility(8);
                this.j.setVisibility(8);
                this.f74598c.setVisibility(8);
                this.j.setVisibility(8);
                this.f74599d.setVisibility(8);
                return;
            }
            this.f74598c.setText("");
            this.f74598c.setLayoutParams(new RelativeLayout.LayoutParams(-2, (int) d.this.f74593g.getResources().getDimension(R.dimen.movie_list_footer)));
            this.j.setVisibility(8);
            this.f74599d.setText("");
            this.f74599d.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            d.this.f74592f.a(this.r.getMcinemaid());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            String movieCode = (this.r.getmMoviesSession() == null || this.r.getmMoviesSession().isEmpty()) ? "" : this.r.getmMoviesSession().get(0).getMovieCode();
            if (TextUtils.isEmpty(movieCode)) {
                Toast.makeText(d.this.f74593g, R.string.error_something_went_wrong, 0).show();
            } else if (this.r.getIsContentAvailable() == 1) {
                d.this.f74592f.b(movieCode);
            } else {
                d dVar = d.this;
                d.a(dVar, dVar.f74593g);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMoviesSession cJRMoviesSession, View view, int i2, CJRMovieSessionDetails cJRMovieSessionDetails, String str, List list, int i3, Dialog dialog, AdapterView adapterView, View view2, int i4, long j2) {
        if (cJRMoviesSession.getSeatsAvailable() > 0) {
            this.f74592f.a(cJRMoviesSession, cJRMovieSessionDetails.getmLanguage(), cJRMovieSessionDetails.getmLocalizedLanguage(), cJRMovieSessionDetails.getmCensor(), cJRMovieSessionDetails.getmImageUrl(), cJRMovieSessionDetails.getMmovietitle(), cJRMovieSessionDetails.getmLocalizedMovieDisplay(), str, n.c(cJRMoviesSession.getRealShowDateTime()), cJRMovieSessionDetails.getDuration(), cJRMovieSessionDetails.getMmoviecode(), list, i3);
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMoviesSession cJRMoviesSession, View view, int i2, CJRMovieSessionDetails cJRMovieSessionDetails, String str, List list, int i3, Dialog dialog, View view2) {
        if (cJRMoviesSession.getSeatsAvailable() > 0) {
            this.f74592f.a(cJRMoviesSession, cJRMovieSessionDetails.getmLanguage(), cJRMovieSessionDetails.getmLocalizedLanguage(), cJRMovieSessionDetails.getmCensor(), cJRMovieSessionDetails.getmImageUrl(), cJRMovieSessionDetails.getMmovietitle(), cJRMovieSessionDetails.getmLocalizedMovieDisplay(), str, n.c(cJRMoviesSession.getRealShowDateTime()), cJRMovieSessionDetails.getDuration(), cJRMovieSessionDetails.getMmoviecode(), list, i3);
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    static /* synthetic */ void a(d dVar, ArrayList arrayList, String str, String str2, View view, int i2, String str3, CJRMovieSessionDetails cJRMovieSessionDetails, CJRMoviesSession cJRMoviesSession, List list, int i3) {
        d dVar2 = dVar;
        String str4 = str;
        try {
            Dialog dialog = new Dialog(dVar2.f74593g, R.style.MoviePriceDialog);
            View inflate = dVar2.f74595i.inflate(R.layout.lyt_movie_price_dialog, (ViewGroup) null);
            ((RelativeLayout) inflate.findViewById(R.id.movie_price_lyt)).requestDisallowInterceptTouchEvent(true);
            ListView listView = (ListView) inflate.findViewById(R.id.price_list);
            ((TextView) inflate.findViewById(R.id.slotname)).setText(str4);
            ((TextView) inflate.findViewById(R.id.cinema_movie_name)).setText(str2);
            dVar2.j = new r(dVar2.f74593g, arrayList, dVar2.f74595i, str4);
            listView.setAdapter(dVar2.j);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(cJRMoviesSession, view, i2, cJRMovieSessionDetails, str3, list, i3, dialog) {
                private final /* synthetic */ CJRMoviesSession f$1;
                private final /* synthetic */ View f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ CJRMovieSessionDetails f$4;
                private final /* synthetic */ String f$5;
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
                    d.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, adapterView, view, i2, j);
                }
            });
            dialog.requestWindowFeature(1);
            dialog.setContentView(inflate);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_corner_movie);
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.width = com.paytm.utility.b.a((Activity) dVar2.f74593g) - com.paytm.utility.b.a(20, dVar2.f74593g);
            dialog.getWindow().setAttributes(attributes);
            inflate.setOnClickListener(new View.OnClickListener(cJRMoviesSession, view, i2, cJRMovieSessionDetails, str3, list, i3, dialog) {
                private final /* synthetic */ CJRMoviesSession f$1;
                private final /* synthetic */ View f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ CJRMovieSessionDetails f$4;
                private final /* synthetic */ String f$5;
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
                    d.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, view);
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0087 A[Catch:{ Exception -> 0x009d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.o2o.movies.adapter.d r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x009d }
            r0.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.String r1 = r5.f74594h     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = "|"
            java.lang.String r3 = "screenName"
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r5.f74594h     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = "movie"
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x009d }
            if (r1 == 0) goto L_0x003b
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x009d }
            r0.put(r3, r8)     // Catch:{ Exception -> 0x009d }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x009d }
            java.lang.String r9 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x009d }
            r0.put(r8, r9)     // Catch:{ Exception -> 0x009d }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r9.<init>()     // Catch:{ Exception -> 0x009d }
            r9.append(r6)     // Catch:{ Exception -> 0x009d }
            r9.append(r2)     // Catch:{ Exception -> 0x009d }
            r9.append(r7)     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x009d }
            r0.put(r8, r6)     // Catch:{ Exception -> 0x009d }
            goto L_0x006c
        L_0x003b:
            java.lang.String r6 = r5.f74594h     // Catch:{ Exception -> 0x009d }
            if (r6 == 0) goto L_0x006c
            java.lang.String r6 = r5.f74594h     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = "cinema"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x009d }
            if (r6 == 0) goto L_0x006c
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x009d }
            r0.put(r3, r6)     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x009d }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r7.<init>()     // Catch:{ Exception -> 0x009d }
            r7.append(r8)     // Catch:{ Exception -> 0x009d }
            r7.append(r2)     // Catch:{ Exception -> 0x009d }
            r7.append(r9)     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x009d }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009d }
        L_0x006c:
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = "Showtime Longpress"
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x009d }
            r0.put(r6, r10)     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x009d }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009d }
            android.content.Context r6 = r5.f74593g     // Catch:{ Exception -> 0x009d }
            boolean r6 = com.paytm.utility.b.r((android.content.Context) r6)     // Catch:{ Exception -> 0x009d }
            if (r6 == 0) goto L_0x0092
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x009d }
            android.content.Context r7 = r5.f74593g     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x009d }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x009d }
        L_0x0092:
            net.one97.paytm.o2o.movies.common.c.b r6 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x009d }
            net.one97.paytm.o2o.movies.common.c.c r6 = r6.f75033b     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x009d }
            android.content.Context r5 = r5.f74593g     // Catch:{ Exception -> 0x009d }
            r6.sendCustomEventWithMap(r7, r0, r5)     // Catch:{ Exception -> 0x009d }
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.d.a(net.one97.paytm.o2o.movies.adapter.d, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ CJRMovieWidget a(d dVar, String str) {
        List<CJRCinemaV2> list = dVar.f74591e;
        CJRMovieWidget cJRMovieWidget = null;
        if (list != null && list.size() > 0) {
            for (CJRCinemaV2 next : dVar.f74591e) {
                if (next.getId().equalsIgnoreCase(str)) {
                    cJRMovieWidget = next.getWidgets();
                }
            }
        }
        return cJRMovieWidget;
    }

    static /* synthetic */ void a(d dVar, Context context) {
        String string = context.getResources().getString(R.string.no_content_available);
        String string2 = context.getResources().getString(R.string.content_not_available_warning);
        AlertDialog.Builder builder = new AlertDialog.Builder(dVar.f74593g);
        builder.setTitle(string).setMessage(string2).setCancelable(false);
        builder.setPositiveButton(context.getResources().getString(R.string.ok), $$Lambda$d$_eFQSQKXQ1dwT3NTxx6ZJthOlVs.INSTANCE);
        builder.show();
    }
}
