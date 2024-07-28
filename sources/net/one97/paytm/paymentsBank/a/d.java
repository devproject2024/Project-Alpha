package net.one97.paytm.paymentsBank.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class d<T> extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public Context f17309a;

    /* renamed from: b  reason: collision with root package name */
    a<T> f17310b;

    /* renamed from: c  reason: collision with root package name */
    private List<T> f17311c;

    public interface a<T> {
    }

    /* access modifiers changed from: protected */
    public abstract View a(Context context, ViewGroup viewGroup, int i2);

    /* access modifiers changed from: protected */
    public abstract void a(T t, b bVar, int i2);

    public /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a(a(i2), (b) vVar, i2);
    }

    public class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private Map<Integer, View> f17313b = new HashMap();

        public b(View view, a aVar) {
            super(view);
            this.f17313b.put(0, view);
            if (aVar != null) {
                view.setOnClickListener(this);
            }
        }

        public final void onClick(View view) {
            if (d.this.f17310b != null) {
                getAdapterPosition();
                d.this.a(getAdapterPosition());
            }
        }

        public final View a(int i2) {
            if (this.f17313b.containsKey(Integer.valueOf(i2))) {
                return this.f17313b.get(Integer.valueOf(i2));
            }
            b(i2);
            return this.f17313b.get(Integer.valueOf(i2));
        }

        private void b(int i2) {
            View findViewById = a(0) != null ? a(0).findViewById(i2) : null;
            if (findViewById != null) {
                this.f17313b.put(Integer.valueOf(i2), findViewById);
            }
        }
    }

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b2) {
        this.f17309a = context;
        this.f17310b = null;
        this.f17311c = new ArrayList();
    }

    public int getItemCount() {
        return this.f17311c.size();
    }

    public final T a(int i2) {
        List<T> list = this.f17311c;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f17311c.get(i2);
    }

    public final void a(List<T> list) {
        this.f17311c.addAll(list);
        notifyDataSetChanged();
    }

    public final void a() {
        this.f17311c.clear();
        notifyDataSetChanged();
    }

    public /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(a(this.f17309a, viewGroup, i2), this.f17310b);
    }
}
