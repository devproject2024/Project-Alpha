package net.one97.paytm.recharge.presentation.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRABCHLItems;
import net.one97.paytm.recharge.presentation.f.d;

public final class a extends RecyclerView.a<d> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f64562b = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public List<CJRABCHLItems> f64563a;

    /* renamed from: c  reason: collision with root package name */
    private Context f64564c;

    /* renamed from: d  reason: collision with root package name */
    private C1273a f64565d;

    /* renamed from: net.one97.paytm.recharge.presentation.a.a$a  reason: collision with other inner class name */
    public interface C1273a {
        void a(Integer num);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        d dVar = (d) vVar;
        k.c(dVar, "holder");
        List<CJRABCHLItems> list = this.f64563a;
        CJRABCHLItems cJRABCHLItems = null;
        if (!(list == null || list == null)) {
            cJRABCHLItems = list.get(i2);
        }
        dVar.a(cJRABCHLItems);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f64564c).inflate(R.layout.item_rv_add_new_bill, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        return new d(inflate, this.f64565d);
    }

    public a(Context context, List<CJRABCHLItems> list, C1273a aVar) {
        k.c(context, "mContext");
        k.c(aVar, "clickListener");
        this.f64564c = context;
        this.f64563a = list;
        this.f64565d = aVar;
    }

    public final int getItemCount() {
        List<CJRABCHLItems> list = this.f64563a;
        if (list != null) {
            return list.size();
        }
        return 4;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }
}
