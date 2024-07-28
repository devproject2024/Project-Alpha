package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.moviepass.a.c;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.utils.n;

public final class m extends j {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f75556a;

    public m(View view) {
        super(view);
        this.f75556a = (RecyclerView) view.findViewById(R.id.passTypeSelectorRv);
    }

    public final void a(a aVar, b bVar, final Context context) {
        if (!d.a((List) aVar.f75573d)) {
            c cVar = new c(aVar.f75573d, bVar, context);
            this.f75556a.setLayoutManager(new LinearLayoutManager(context, 0, false));
            int i2 = 0;
            while (true) {
                if (i2 >= aVar.f75573d.size()) {
                    i2 = 0;
                    break;
                } else if (aVar.f75573d.get(i2).f75594c) {
                    break;
                } else {
                    i2++;
                }
            }
            if (this.f75556a.getItemDecorationCount() == 0) {
                this.f75556a.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                            rect.left = n.a(20, context);
                        }
                        rect.right = n.a(9, context);
                    }
                });
            }
            this.f75556a.setAdapter(cVar);
            this.f75556a.getLayoutManager().scrollToPosition(i2);
        }
    }
}
