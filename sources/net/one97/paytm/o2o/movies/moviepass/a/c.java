package net.one97.paytm.o2o.movies.moviepass.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.d.l;
import net.one97.paytm.o2o.movies.moviepass.e.f;
import net.one97.paytm.o2o.movies.utils.n;

public final class c extends RecyclerView.a<l> {

    /* renamed from: a  reason: collision with root package name */
    private List<f> f75442a;

    /* renamed from: b  reason: collision with root package name */
    private b f75443b;

    /* renamed from: c  reason: collision with root package name */
    private Context f75444c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        l lVar = (l) vVar;
        if (lVar != null) {
            f fVar = this.f75442a.get(i2);
            b bVar = this.f75443b;
            Context context = this.f75444c;
            n.a(lVar.f75552a, fVar.f75593b);
            if (fVar.f75594c) {
                lVar.f75552a.setBackground(context.getResources().getDrawable(R.drawable.shape_rectangle_round_edges_blue_bg_border));
                lVar.f75552a.setTypeface((Typeface) null, 1);
            } else {
                lVar.f75552a.setBackground(context.getResources().getDrawable(R.drawable.shape_rectangle_round_edges_large_grey_border));
                lVar.f75552a.setTypeface((Typeface) null, 0);
            }
            lVar.f75552a.setOnClickListener(new View.OnClickListener(bVar, fVar) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f75553a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ f f75554b;

                {
                    this.f75553a = r2;
                    this.f75554b = r3;
                }

                public final void onClick(View view) {
                    this.f75553a.b(this.f75554b.f75592a);
                }
            });
        }
    }

    public c(List<f> list, b bVar, Context context) {
        this.f75442a = list;
        this.f75443b = bVar;
        this.f75444c = context;
    }

    public final int getItemCount() {
        return this.f75442a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new l(LayoutInflater.from(this.f75444c).inflate(R.layout.pass_type_item_view, viewGroup, false));
    }
}
