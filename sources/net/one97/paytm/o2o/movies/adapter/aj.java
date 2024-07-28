package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gson.o;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.t;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMoviesInfo;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.utils.n;

public final class aj extends RecyclerView.a<c> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<CJRUpcomingMoviesInfo> f74357a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<CJRUpcomingMoviesInfo> f74358b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f74359c;

    /* renamed from: d  reason: collision with root package name */
    private b f74360d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f74361e;

    /* renamed from: f  reason: collision with root package name */
    private int f74362f;

    /* renamed from: g  reason: collision with root package name */
    private int f74363g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f74364h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f74365i;
    /* access modifiers changed from: private */
    public o j;
    /* access modifiers changed from: private */
    public Context k;

    public interface a {
        void a(String str);

        void a(String str, com.paytm.network.listener.b bVar);

        void c(boolean z);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((c) vVar).a(this.f74357a.get(i2), i2);
    }

    public final void a(o oVar) {
        this.j = oVar;
        notifyDataSetChanged();
    }

    public aj(CJRUpcomingMovies cJRUpcomingMovies, int i2, Context context, a aVar) {
        this.f74358b.addAll(cJRUpcomingMovies.getUpcomingMovieData());
        this.f74357a = new ArrayList();
        this.f74357a.addAll(this.f74358b);
        this.k = context;
        this.f74359c = i2;
        this.f74361e = aVar;
        this.f74364h = i2 == 3 || i2 == 4;
        int b2 = n.b(context);
        if (this.f74364h) {
            int a2 = n.a(context) / 2;
            this.f74362f = ((b2 / 2) - a2) - (a2 / 2);
            this.f74363g = (int) (((double) this.f74362f) * 1.16d);
        }
        if (this.f74359c == 1) {
            this.f74362f = n.a((int) Constants.ACTION_UID_VIEWER, context);
            this.f74363g = n.a(200, context);
        }
        this.f74365i = n.a(3, context);
    }

    public final int getItemCount() {
        List<CJRUpcomingMoviesInfo> list = this.f74357a;
        if (list == null) {
            return 0;
        }
        if (this.f74359c != 1 || list.size() <= 6) {
            return this.f74357a.size();
        }
        return 6;
    }

    public final void a(ArrayList<CJRUpcomingMoviesInfo> arrayList) {
        if (this.f74357a != null) {
            this.f74358b.clear();
            this.f74358b.addAll(arrayList);
            this.f74357a.clear();
            this.f74357a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        if (this.f74360d == null) {
            this.f74360d = new b(this, (byte) 0);
        }
        return this.f74360d;
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74367a;

        /* renamed from: b  reason: collision with root package name */
        ConstraintLayout f74368b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74369c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f74370d;

        /* renamed from: f  reason: collision with root package name */
        private TextView f74372f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f74373g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f74374h;

        /* renamed from: i  reason: collision with root package name */
        private RelativeLayout f74375i;
        private TextView j;

        public c(View view) {
            super(view);
            this.f74368b = (ConstraintLayout) view.findViewById(R.id.upcoming_movies_info_lyt);
            this.f74367a = (ImageView) view.findViewById(R.id.upcoming_tile_img);
            this.f74374h = (TextView) view.findViewById(R.id.upcoming_tile_release);
            this.f74372f = (TextView) view.findViewById(R.id.upcoming_tile_title);
            this.f74373g = (TextView) view.findViewById(R.id.upcoming_tile_genre);
            this.f74375i = (RelativeLayout) view.findViewById(R.id.layout_release_date);
            this.f74370d = (ImageView) view.findViewById(R.id.thumbs_up_icon_iv);
            this.f74369c = (TextView) view.findViewById(R.id.like_data_tv);
            this.j = (TextView) view.findViewById(R.id.like_data_indicator_tv);
        }

        public final void a(final CJRUpcomingMoviesInfo cJRUpcomingMoviesInfo, final int i2) {
            Drawable b2 = androidx.appcompat.a.a.a.b(aj.this.k, net.one97.paytm.common.assets.R.drawable.img_movie_placeholder_163_x_190_dp);
            t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory());
            this.f74367a.getContext();
            t.a(cJRUpcomingMoviesInfo.getMoviePosterUrl(), aj.this.f74365i, b2, b2, this.f74367a);
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            cJRHomePageItem.setName("/movies/homescreen-upcoming-movies ");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpression(cJRHomePageItem, this.f74368b.getContext(), i2, net.one97.paytm.o2o.movies.common.b.b.O, cJRUpcomingMoviesInfo.getMovieTitle());
            this.f74368b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    c cVar = c.this;
                    CJRUpcomingMoviesInfo cJRUpcomingMoviesInfo = cJRUpcomingMoviesInfo;
                    int i2 = i2;
                    if (cJRUpcomingMoviesInfo.getIsContentAvailable() == 1 && aj.this.f74361e != null) {
                        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                        cJRHomePageItem.setName("/movies/homescreen-upcoming-movies ");
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpressionClick(cJRHomePageItem, cVar.f74368b.getContext(), i2, net.one97.paytm.o2o.movies.common.b.b.O, cJRUpcomingMoviesInfo.getMovieTitle());
                        aj.this.f74361e.a(cJRUpcomingMoviesInfo.getPaytmMovieCode());
                    }
                }
            });
            String releaseDate = cJRUpcomingMoviesInfo.getReleaseDate();
            if (!TextUtils.isEmpty(releaseDate)) {
                this.f74374h.setText(com.paytm.utility.b.h(releaseDate, "yyyy-MM-dd", "dd MMM yy"));
            } else if (aj.this.f74359c == 4) {
                this.f74375i.setVisibility(8);
            } else {
                this.f74375i.setVisibility(0);
                this.f74374h.setText("Coming Soon");
            }
            this.f74372f.setText(cJRUpcomingMoviesInfo.getMovieTitle());
            TextView textView = this.f74373g;
            String language = cJRUpcomingMoviesInfo.getLanguage();
            List<String> genre = cJRUpcomingMoviesInfo.getGenre();
            StringBuilder sb = new StringBuilder(language);
            sb.append(", ");
            for (String append : genre) {
                sb.append(append);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(", "));
            textView.setText(sb.toString());
            if (aj.this.j == null) {
                this.f74369c.setVisibility(8);
                this.f74370d.setVisibility(8);
                this.j.setVisibility(8);
            } else if (aj.this.j.b(cJRUpcomingMoviesInfo.getPaytmMovieCode()) != null) {
                o e2 = aj.this.j.e(cJRUpcomingMoviesInfo.getPaytmMovieCode()).e("interested");
                double d2 = e2.e("countInfo").b(H5Param.DEFAULT_LONG_PRESSO_LOGIN).d();
                int i3 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
                if (i3 <= 0) {
                    this.f74369c.setText(aj.this.k.getString(R.string.interest_first_time_user_upcoming));
                } else if (d2 < 1001.0d) {
                    this.f74369c.setVisibility(8);
                } else {
                    this.f74369c.setText(a(d2));
                }
                if (e2.c("userInput") != null && e2.c("userInput").c().trim().equalsIgnoreCase(H5Param.DEFAULT_LONG_PRESSO_LOGIN)) {
                    if (i3 <= 0) {
                        this.f74369c.setText("You like this");
                    } else if (d2 < 1001.0d) {
                        this.f74369c.setVisibility(8);
                    } else {
                        TextView textView2 = this.f74369c;
                        textView2.setText("You and " + a(d2) + " others");
                    }
                    this.f74370d.setImageResource(R.drawable.ic_upcoming_movies_thumb_selected);
                }
                this.f74370d.setOnClickListener(new View.OnClickListener(cJRUpcomingMoviesInfo, d2) {
                    private final /* synthetic */ CJRUpcomingMoviesInfo f$1;
                    private final /* synthetic */ double f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        aj.c.this.a(this.f$1, this.f$2, view);
                    }
                });
            } else {
                this.f74369c.setVisibility(8);
                this.f74370d.setVisibility(8);
                this.j.setVisibility(8);
            }
            this.f74368b.setVisibility(0);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(CJRUpcomingMoviesInfo cJRUpcomingMoviesInfo, final double d2, View view) {
            aj.this.f74361e.a(cJRUpcomingMoviesInfo.getPaytmMovieCode(), new com.paytm.network.listener.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (d2 > 1001.0d) {
                        TextView textView = c.this.f74369c;
                        textView.setText("You and " + c.a(d2) + " others");
                    } else {
                        c.this.f74369c.setText("You like this");
                    }
                    c.this.f74370d.setImageResource(R.drawable.ic_upcoming_movies_thumb_selected);
                }
            });
        }

        static String a(double d2) {
            if (d2 == 0.0d || d2 < 0.0d) {
                return "0";
            }
            DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
            int log10 = ((int) StrictMath.log10(d2)) / 3;
            String str = decimalFormat.format(d2 / Math.pow(10.0d, (double) (log10 * 3))) + " kmbt".charAt(log10);
            return str.length() > 4 ? str.replaceAll("\\.[0-9]+", "") : str;
        }
    }

    class b extends Filter {
        private b() {
        }

        /* synthetic */ b(aj ajVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            aj.this.f74357a.clear();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                aj.this.f74357a.clear();
                aj.this.f74357a.addAll(aj.this.f74358b);
            } else {
                for (CJRUpcomingMoviesInfo cJRUpcomingMoviesInfo : aj.this.f74358b) {
                    if (!(cJRUpcomingMoviesInfo == null || cJRUpcomingMoviesInfo.getMovieTitle() == null || !cJRUpcomingMoviesInfo.getMovieTitle().toUpperCase().trim().contains(charSequence.toString().toUpperCase().trim()))) {
                        aj.this.f74357a.add(cJRUpcomingMoviesInfo);
                    }
                }
                filterResults.values = aj.this.f74357a;
                filterResults.count = aj.this.f74357a.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (aj.this.f74357a != null && aj.this.f74357a.size() > 0) {
                aj.this.f74361e.c(false);
            } else if (TextUtils.isEmpty(charSequence)) {
                aj.this.f74361e.c(false);
            } else {
                aj.this.f74361e.c(true);
            }
            aj.this.notifyDataSetChanged();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcoming_movies_tile_view, viewGroup, false));
        if (this.f74364h || this.f74359c == 1) {
            ViewGroup.LayoutParams layoutParams = cVar.f74367a.getLayoutParams();
            layoutParams.height = this.f74363g;
            layoutParams.width = this.f74362f;
            cVar.f74368b.getLayoutParams().width = this.f74362f;
        }
        return cVar;
    }
}
