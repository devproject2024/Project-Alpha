package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.t;
import com.paytm.utility.v;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.g;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.utils.n;

public final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    View f75524a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f75525b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75526c;

    public f(View view) {
        super(view);
        this.f75525b = (ImageView) view.findViewById(R.id.benefit_img);
        this.f75526c = (TextView) view.findViewById(R.id.benefit_tv);
        this.f75524a = view.findViewById(R.id.bottomSpace);
    }

    public final void a(a aVar, b bVar, Context context) {
        net.one97.paytm.o2o.movies.moviepass.e.b bVar2 = aVar.f75572c;
        if (bVar2 != null) {
            try {
                if (!v.a(bVar2.f75579a)) {
                    g.a();
                    String str = bVar2.f75579a;
                    int i2 = R.drawable.moviepass_default_placeholder;
                    w.a().a(str).a((ah) new t.b(0, 0, true)).b(i2).a(i2).a(this.f75525b, (e) null);
                }
            } catch (Exception unused) {
            }
            n.a(this.f75526c, bVar2.f75580b);
            if (bVar2.f75581c) {
                this.f75524a.setVisibility(8);
            } else {
                this.f75524a.setVisibility(0);
            }
        }
    }
}
