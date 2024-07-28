package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<CJRCinemas> f74607a;

    /* renamed from: b  reason: collision with root package name */
    y.j f74608b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f74609c;

    /* renamed from: d  reason: collision with root package name */
    private Context f74610d;

    /* renamed from: e  reason: collision with root package name */
    private String f74611e;

    /* renamed from: f  reason: collision with root package name */
    private String f74612f;

    /* renamed from: g  reason: collision with root package name */
    private int f74613g;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        try {
            final CJRCinemas cJRCinemas = this.f74607a.get(i2);
            if (cJRCinemas.is_preferred_cinema().intValue() == 1) {
                aVar.f74618c.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.tv_preffered_cinema);
                layoutParams.setMargins(0, 6, 0, 0);
                aVar.f74617b.setLayoutParams(layoutParams);
                aVar.f74617b.setText(cJRCinemas.getName());
            } else {
                aVar.f74618c.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(10);
                layoutParams2.setMargins(0, n.a(20, this.f74610d), 0, 0);
                aVar.f74617b.setLayoutParams(layoutParams2);
                aVar.f74617b.setText(cJRCinemas.getName());
            }
            aVar.f74616a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    i.a().f75936f = cJRCinemas;
                    e.this.f74608b.a(cJRCinemas);
                }
            });
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public e(Context context, String str, y.j jVar) {
        this.f74610d = context;
        this.f74611e = str;
        Context context2 = this.f74610d;
        if (context2 != null) {
            this.f74609c = (LayoutInflater) context2.getSystemService("layout_inflater");
        }
        this.f74612f = context.getResources().getString(R.string.browse_cinema_hall);
        this.f74608b = jVar;
        this.f74613g = n.a(3, this.f74610d);
    }

    public final int getItemCount() {
        int size = this.f74607a.size();
        if (size < 10) {
            return size;
        }
        return 10;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74616a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74617b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74618c;

        public a(View view) {
            super(view);
            this.f74616a = (ImageView) view.findViewById(R.id.thumb_nail);
            this.f74617b = (TextView) view.findViewById(R.id.tv_cinema_name);
            this.f74618c = (TextView) view.findViewById(R.id.tv_preffered_cinema);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f74609c.inflate(R.layout.cinema_banner_grid_view, viewGroup, false));
    }
}
