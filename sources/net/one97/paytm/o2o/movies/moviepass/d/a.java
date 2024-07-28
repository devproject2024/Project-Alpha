package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.paytm.utility.v;
import com.squareup.picasso.aa;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.b;

public final class a extends j {

    /* renamed from: a  reason: collision with root package name */
    ImageView f75505a;

    /* renamed from: b  reason: collision with root package name */
    View f75506b;

    public a(View view) {
        super(view);
        this.f75505a = (ImageView) view.findViewById(R.id.brand_prom_img);
        this.f75506b = view.findViewById(R.id.bottomSpace);
    }

    public final void a(net.one97.paytm.o2o.movies.moviepass.e.a aVar, b bVar, Context context) {
        net.one97.paytm.o2o.movies.moviepass.e.b bVar2 = aVar.f75572c;
        if (bVar2 != null) {
            if (!v.a(bVar2.f75579a)) {
                aa a2 = w.a().a(bVar2.f75579a);
                a2.f45353b = true;
                a2.b(context.getResources().getDrawable(R.drawable.moviepass_logo_placeholder)).a(context.getResources().getDrawable(R.drawable.moviepass_logo_placeholder)).a(this.f75505a, (e) null);
            }
            if (bVar2.f75581c) {
                this.f75506b.setVisibility(8);
            } else {
                this.f75506b.setVisibility(0);
            }
        }
    }
}
