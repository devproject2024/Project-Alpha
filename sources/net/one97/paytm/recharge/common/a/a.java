package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.widgets.c.d;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<String> f60427a;

    /* renamed from: b  reason: collision with root package name */
    C1168a f60428b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f60429c;

    /* renamed from: net.one97.paytm.recharge.common.a.a$a  reason: collision with other inner class name */
    public interface C1168a {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        Context context = bVar.itemView.getContext();
        int i3 = R.string.price_container_re_v8;
        d dVar = d.f64967a;
        bVar.f60430a.setText(context.getString(i3, new Object[]{d.a(this.f60427a.get(i2), true, -1, true)}));
    }

    public a(Context context, List<String> list, C1168a aVar) {
        this.f60427a = list;
        this.f60429c = LayoutInflater.from(context);
        this.f60428b = aVar;
    }

    public final int getItemCount() {
        List<String> list = this.f60427a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        Button f60430a;

        public b(View view) {
            super(view);
            this.f60430a = (Button) view.findViewById(R.id.amount_btn);
            this.f60430a.setOnClickListener(this);
        }

        public final void onClick(View view) {
            if (view.getId() == R.id.amount_btn) {
                a.this.f60428b.a(a.this.f60427a.get(getAdapterPosition()));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f60429c.inflate(R.layout.add_amount_btn, viewGroup, false));
    }
}
