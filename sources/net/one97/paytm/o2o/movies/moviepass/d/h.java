package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.Serializable;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.d;

public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    TextView f75533a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f75534b;

    /* renamed from: c  reason: collision with root package name */
    View f75535c;

    public h(View view) {
        super(view);
        this.f75533a = (TextView) view.findViewById(R.id.title);
        this.f75534b = (RelativeLayout) view.findViewById(R.id.rlContainer);
        this.f75535c = view.findViewById(R.id.hDivider);
    }

    public final void a(final net.one97.paytm.o2o.movies.moviepass.e.a aVar, final b bVar, Context context) {
        d dVar = aVar.f75577h;
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.f75586a)) {
                this.f75533a.setText(dVar.f75586a);
            }
            this.f75534b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    bVar.a(aVar.f75577h.f75587b);
                }
            });
            if (dVar.f75588c) {
                this.f75535c.setVisibility(8);
            } else {
                this.f75535c.setVisibility(0);
            }
        }
    }

    public enum a implements Serializable {
        FAQ(1),
        HTR(2);
        
        private int id;

        private a(int i2) {
            this.id = i2;
        }
    }
}
