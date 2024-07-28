package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.view.View;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.moviepass.e.e;

public final class c extends j {

    /* renamed from: a  reason: collision with root package name */
    View f75511a;

    /* renamed from: b  reason: collision with root package name */
    View f75512b;

    /* renamed from: c  reason: collision with root package name */
    View f75513c;

    public c(View view) {
        super(view);
        this.f75511a = view.findViewById(R.id.topSpace);
        this.f75512b = view.findViewById(R.id.greyDivider);
        this.f75513c = view.findViewById(R.id.bottomSpace);
    }

    public final void a(a aVar, b bVar, Context context) {
        e eVar = aVar.f75578i;
        this.f75511a.setVisibility(0);
        this.f75512b.setVisibility(0);
        this.f75513c.setVisibility(0);
        if (eVar != null) {
            if (eVar.f75590b) {
                this.f75511a.setVisibility(8);
            }
            if (eVar.f75591c) {
                this.f75512b.setVisibility(8);
            }
            if (eVar.f75589a) {
                this.f75513c.setVisibility(8);
            }
        }
    }
}
