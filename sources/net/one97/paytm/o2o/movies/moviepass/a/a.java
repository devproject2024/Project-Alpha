package net.one97.paytm.o2o.movies.moviepass.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.d.d;
import net.one97.paytm.o2o.movies.moviepass.d.e;
import net.one97.paytm.o2o.movies.moviepass.d.h;
import net.one97.paytm.o2o.movies.moviepass.e.c;

public final class a extends RecyclerView.a<RecyclerView.v> implements d.a {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f75435a;

    /* renamed from: b  reason: collision with root package name */
    private Context f75436b;

    /* renamed from: c  reason: collision with root package name */
    private C1490a f75437c;

    /* renamed from: net.one97.paytm.o2o.movies.moviepass.a.a$a  reason: collision with other inner class name */
    public interface C1490a {
        void a(int i2);
    }

    public a(Context context, List<c> list, C1490a aVar) {
        this.f75435a = list;
        this.f75436b = context;
        this.f75437c = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new d(LayoutInflater.from(this.f75436b).inflate(R.layout.mp_faq_row, (ViewGroup) null));
        }
        if (i2 == 2) {
            return new e(LayoutInflater.from(this.f75436b).inflate(R.layout.mp_htr_row, (ViewGroup) null));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null) {
            if (vVar instanceof d) {
                d dVar = (d) vVar;
                c cVar = this.f75435a.get(i2);
                dVar.f75514a.setText(cVar.f75583b);
                dVar.f75515b.setText(cVar.f75584c);
                if (cVar.f75582a) {
                    dVar.f75515b.setVisibility(0);
                    dVar.f75516c.setImageResource(R.drawable.ic_mp_arrow_up);
                } else {
                    dVar.f75515b.setVisibility(8);
                    dVar.f75516c.setImageResource(R.drawable.ic_mp_arrow_down);
                }
                dVar.f75516c.setClickable(false);
                dVar.f75517d.setOnClickListener(new View.OnClickListener(this, i2, cVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f75518a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ int f75519b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ c f75520c;

                    {
                        this.f75518a = r2;
                        this.f75519b = r3;
                        this.f75520c = r4;
                    }

                    public final void onClick(View view) {
                        this.f75518a.a(this.f75519b, this.f75520c);
                    }
                });
            } else if (vVar instanceof e) {
                e eVar = (e) vVar;
                c cVar2 = this.f75435a.get(i2);
                eVar.f75522a.setText(cVar2.f75583b);
                eVar.f75523b.setText(cVar2.f75584c);
            }
        }
    }

    public final int getItemViewType(int i2) {
        h.a aVar = this.f75435a.get(i2).f75585d;
        if (h.a.FAQ.equals(aVar)) {
            return 1;
        }
        if (h.a.HTR.equals(aVar)) {
            return 2;
        }
        return super.getItemViewType(i2);
    }

    public final int getItemCount() {
        if (net.one97.paytm.o2o.movies.common.d.a((List) this.f75435a)) {
            return 0;
        }
        return this.f75435a.size();
    }

    public final void a(int i2, c cVar) {
        if (cVar.f75582a) {
            cVar.f75582a = false;
            notifyItemChanged(i2);
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.f75435a.size(); i4++) {
            c cVar2 = this.f75435a.get(i4);
            if (cVar2.f75582a) {
                i3 = i4;
            }
            cVar2.f75582a = false;
        }
        this.f75435a.get(i2).f75582a = true;
        if (i3 >= 0) {
            notifyItemChanged(i3);
        }
        notifyItemChanged(i2);
        this.f75437c.a(i2);
    }
}
