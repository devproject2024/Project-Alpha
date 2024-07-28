package net.one97.paytm.o2o.amusementpark.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.o2o.amusementpark.R;

public final class q extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    int f73285a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f73286b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f73287c = -1;

    /* renamed from: d  reason: collision with root package name */
    b f73288d;

    public interface b {
        void a(int i2, int i3);
    }

    public q(b bVar) {
        this.f73288d = bVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_visiter_count_cell, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null) {
            a aVar = (a) vVar;
            int i3 = i2 + 1;
            aVar.f73290b = i3 - 1;
            aVar.f73289a.setText(String.valueOf(i3));
            if (i3 == q.this.f73286b) {
                aVar.f73289a.setSelected(true);
            } else {
                aVar.f73289a.setSelected(false);
            }
        }
    }

    public final int getItemCount() {
        return this.f73285a;
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f73289a = null;

        /* renamed from: b  reason: collision with root package name */
        int f73290b = -1;

        public a(View view) {
            super(view);
            this.f73289a = (TextView) view.findViewById(R.id.tv_visitor_count_cell);
            this.f73289a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = a.this;
                    int i2 = q.this.f73286b - 1;
                    if (i2 != aVar.f73290b) {
                        q.this.f73286b = aVar.f73290b + 1;
                        q.this.notifyItemChanged(aVar.f73290b);
                    } else {
                        q.this.f73286b = 0;
                    }
                    q.this.notifyItemChanged(i2);
                    if (q.this.f73288d != null) {
                        q.this.f73288d.a(q.this.f73286b, q.this.f73287c);
                    }
                }
            });
        }
    }
}
