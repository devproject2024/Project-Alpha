package net.one97.paytm.wallet.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.paytm_finance.R;

public final class b<T> extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<T> f69968a;

    /* renamed from: b  reason: collision with root package name */
    a<T> f69969b;

    /* renamed from: c  reason: collision with root package name */
    public View f69970c;

    /* renamed from: d  reason: collision with root package name */
    public int f69971d = -1;

    public interface a<T> {
        void a(T t, int i2);

        void b();
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(List<T> list, a<T> aVar) {
        this.f69968a = list;
        this.f69969b = aVar;
        this.f69970c = null;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1413b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.slab_view, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        C1413b bVar = (C1413b) vVar;
        TextView textView = bVar.f69974a;
        textView.setText("₹ " + this.f69968a.get(i2));
        bVar.f69975b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.this.f69970c == null || view != b.this.f69970c) {
                    if (b.this.f69970c != null) {
                        b.this.f69970c.setSelected(false);
                    }
                    b.this.f69969b.a(b.this.f69968a.get(i2), i2);
                    b bVar = b.this;
                    bVar.f69970c = view;
                    bVar.f69971d = i2;
                    view.setSelected(true);
                } else {
                    view.setSelected(false);
                    b.this.f69969b.b();
                    b bVar2 = b.this;
                    bVar2.f69970c = null;
                    bVar2.f69971d = -1;
                }
                b.this.notifyDataSetChanged();
            }
        });
    }

    public final int getItemCount() {
        return this.f69968a.size();
    }

    /* renamed from: net.one97.paytm.wallet.b.b$b  reason: collision with other inner class name */
    public class C1413b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f69974a;

        /* renamed from: b  reason: collision with root package name */
        View f69975b;

        public C1413b(View view) {
            super(view);
            this.f69975b = view;
            this.f69974a = (TextView) view.findViewById(R.id.slab_text);
        }
    }
}
