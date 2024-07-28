package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.e;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.utils.n;

public final class g extends j {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f75527a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f75528b;

    /* renamed from: c  reason: collision with root package name */
    private e f75529c;

    /* renamed from: d  reason: collision with root package name */
    private View f75530d;

    public g(View view) {
        super(view);
        this.f75527a = (RecyclerView) view.findViewById(R.id.movies_horizontal_list);
        this.f75528b = (RoboTextView) view.findViewById(R.id.view_all);
        this.f75530d = view.findViewById(R.id.greyDividerV);
    }

    public final void a(a aVar, b bVar, final Context context) {
        if (aVar.f75575f != null && !d.a((List) aVar.f75575f.f75508b)) {
            this.f75530d.setVisibility(8);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
            ArrayList<CJRCinemas> arrayList = aVar.f75575f.f75508b;
            this.f75527a.setLayoutManager(linearLayoutManager);
            if (this.f75527a.getItemDecorationCount() == 0) {
                this.f75527a.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                            rect.left = n.a(20, context);
                        }
                        rect.right = n.a(10, context);
                    }
                });
            }
            this.f75529c = new e(context, aVar.f75575f.f75510d, aVar.f75575f.f75509c);
            this.f75527a.setAdapter(this.f75529c);
            this.f75529c.f74607a = arrayList;
            if (arrayList.size() > 10) {
                this.f75528b.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.f75575f.f75509c.g();
                    }
                });
            } else {
                this.f75528b.setVisibility(8);
            }
        }
    }
}
