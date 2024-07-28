package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.g;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public final class g extends RecyclerView.a<b> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f74626a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<CJRCinemas> f74627b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRCinemas> f74628c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f74629d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RoboTextView f74630e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f74631f;

    /* renamed from: g  reason: collision with root package name */
    private a f74632g;

    /* renamed from: h  reason: collision with root package name */
    private String f74633h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public c f74634i;

    public interface c {
        void a(CJRCinemas cJRCinemas);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        CJRCinemas cJRCinemas = this.f74627b.get(i2);
        bVar.f74638b.setText(cJRCinemas.getName());
        bVar.f74639c.setText(cJRCinemas.getAddress());
        if (cJRCinemas.is_preferred_cinema().intValue() == 1) {
            bVar.f74637a.setVisibility(0);
        } else {
            bVar.f74637a.setVisibility(8);
        }
        double round = ((double) Math.round(cJRCinemas.getDistance() * 10.0d)) / 10.0d;
        if (round > 0.0d) {
            bVar.f74641e.setVisibility(0);
            if (round > 99.0d) {
                bVar.f74640d.setText("99+ km");
                return;
            }
            RoboTextView roboTextView = bVar.f74640d;
            roboTextView.setText(round + " km");
        }
    }

    public g(Activity activity, List<CJRCinemas> list, RoboTextView roboTextView, LinearLayout linearLayout, String str, c cVar) {
        this.f74626a = activity;
        this.f74628c = list;
        this.f74627b = new ArrayList(list);
        this.f74629d = (LayoutInflater) this.f74626a.getSystemService("layout_inflater");
        this.f74631f = linearLayout;
        this.f74630e = roboTextView;
        this.f74633h = str;
        this.f74634i = cVar;
    }

    public final int getItemCount() {
        List<CJRCinemas> list = this.f74627b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final Filter getFilter() {
        if (this.f74632g == null) {
            this.f74632g = new a();
        }
        return this.f74632g;
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f74637a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f74638b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f74639c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f74640d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f74641e;

        public b(View view) {
            super(view);
            this.f74637a = (RoboTextView) view.findViewById(R.id.tv_preffered_cinema);
            this.f74638b = (RoboTextView) view.findViewById(R.id.tv_cinema_name);
            this.f74639c = (RoboTextView) view.findViewById(R.id.tv_cinema_address);
            this.f74640d = (RoboTextView) view.findViewById(R.id.tv_distance);
            this.f74641e = (LinearLayout) view.findViewById(R.id.ll_distance);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    g.b.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            InputMethodManager inputMethodManager;
            if (!(g.this.f74626a == null || (inputMethodManager = (InputMethodManager) g.this.f74626a.getSystemService("input_method")) == null)) {
                inputMethodManager.hideSoftInputFromWindow(this.f74638b.getWindowToken(), 0);
            }
            CJRCinemas cJRCinemas = (CJRCinemas) g.this.f74627b.get(getAdapterPosition());
            g.this.f74634i.a(cJRCinemas);
            g.a(g.this, this.f74638b.getText().toString(), String.valueOf(cJRCinemas.getPaytmCinemaId()), getAdapterPosition());
            g.d(g.this);
        }
    }

    class a extends Filter {

        /* renamed from: b  reason: collision with root package name */
        private String f74636b;

        a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            this.f74636b = charSequence.toString();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = g.this.f74628c;
                filterResults.count = g.this.f74628c.size();
            } else {
                ArrayList arrayList = new ArrayList();
                String[] split = ((String) charSequence).toLowerCase().split(" ");
                for (CJRCinemas cJRCinemas : g.this.f74628c) {
                    String lowerCase = cJRCinemas.getName().toLowerCase();
                    int length = split.length;
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (lowerCase.indexOf(split[i2]) == -1) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        arrayList.add(cJRCinemas);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            List unused = g.this.f74627b = (ArrayList) filterResults.values;
            if (g.this.f74631f != null) {
                if (g.this.f74627b == null || g.this.f74627b.size() <= 0) {
                    g.this.f74631f.setVisibility(0);
                    if (g.this.f74630e != null) {
                        g.this.f74630e.setText(g.this.f74626a.getString(R.string.movies_err_msg, new Object[]{this.f74636b}));
                    }
                } else {
                    g.this.f74631f.setVisibility(8);
                }
            }
            g.this.notifyDataSetChanged();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f74629d.inflate(R.layout.home_search_landing_cinema_v1_new, viewGroup, false));
    }

    static /* synthetic */ void a(g gVar, String str, String str2, int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.S);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.y);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, str + "|" + str2 + "|" + i2);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) gVar.f74626a)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) gVar.f74626a));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, gVar.f74626a);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void d(g gVar) {
        try {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEvents("mov_search_performed", gVar.f74626a);
        } catch (Exception unused) {
        }
    }
}
