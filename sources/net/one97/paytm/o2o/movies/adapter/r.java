package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails;
import net.one97.paytm.o2o.movies.utils.n;

public final class r extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRMoviesSessionDetails> f74736a = null;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f74737b;

    /* renamed from: c  reason: collision with root package name */
    private Context f74738c;

    /* renamed from: d  reason: collision with root package name */
    private String f74739d;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public r(Context context, ArrayList<CJRMoviesSessionDetails> arrayList, LayoutInflater layoutInflater, String str) {
        this.f74739d = str;
        this.f74738c = context;
        this.f74737b = layoutInflater;
        this.f74736a = arrayList;
    }

    public final int getCount() {
        return this.f74736a.size();
    }

    public final Object getItem(int i2) {
        return this.f74736a.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f74737b.inflate(R.layout.lyt_movie_price_list_item, (ViewGroup) null);
            aVar = new a();
            aVar.f74740a = (TextView) view.findViewById(R.id.category);
            aVar.f74741b = (TextView) view.findViewById(R.id.price);
            aVar.f74742c = (TextView) view.findViewById(R.id.availableseat);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        CJRMoviesSessionDetails cJRMoviesSessionDetails = (CJRMoviesSessionDetails) getItem(i2);
        aVar.f74740a.setText(cJRMoviesSessionDetails.getMoviesPriceDetails().getTypeDescription());
        TextView textView = aVar.f74741b;
        textView.setText(this.f74738c.getResources().getString(R.string.rs_symbol) + " " + cJRMoviesSessionDetails.getMoviesPriceDetails().getPrice());
        if (cJRMoviesSessionDetails.getSeatsAvailable() > 1) {
            TextView textView2 = aVar.f74742c;
            textView2.setText(cJRMoviesSessionDetails.getSeatsAvailable() + " " + this.f74738c.getResources().getString(R.string.movies_seats_available));
        } else if (cJRMoviesSessionDetails.getSeatsAvailable() == 1) {
            TextView textView3 = aVar.f74742c;
            textView3.setText(cJRMoviesSessionDetails.getSeatsAvailable() + " " + this.f74738c.getResources().getString(R.string.movie_seat_available));
        } else {
            aVar.f74742c.setText(this.f74738c.getResources().getString(R.string.movies_no_seats_available));
        }
        aVar.f74742c.setTextColor(this.f74738c.getResources().getColor(n.a(cJRMoviesSessionDetails.getSeatsAvailable(), cJRMoviesSessionDetails.getTotalSeats())));
        return view;
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f74740a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74741b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74742c;

        public a() {
        }
    }
}
