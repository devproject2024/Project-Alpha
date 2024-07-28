package net.one97.paytm.recharge.presentation.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import net.one97.paytm.recharge.presentation.f.j;

public final class g extends RecyclerView.a<j> {

    /* renamed from: a  reason: collision with root package name */
    private Context f64605a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRAutomaticSubscriptionHistory> f64606b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        j jVar = (j) vVar;
        k.c(jVar, "holder");
        List<CJRAutomaticSubscriptionHistory> list = this.f64606b;
        if (list != null) {
            CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory = list != null ? list.get(i2) : null;
            if (cJRAutomaticSubscriptionHistory != null) {
                cJRAutomaticSubscriptionHistory.setPosition(i2);
            }
            jVar.a(cJRAutomaticSubscriptionHistory);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f64605a).inflate(R.layout.list_item_payment_history, viewGroup, false);
        if (inflate == null) {
            k.a();
        }
        List<CJRAutomaticSubscriptionHistory> list = this.f64606b;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return new j(inflate, valueOf.intValue());
    }

    public g(Context context, List<CJRAutomaticSubscriptionHistory> list) {
        k.c(context, "mContext");
        this.f64605a = context;
        this.f64606b = list;
    }

    public final int getItemCount() {
        List<CJRAutomaticSubscriptionHistory> list = this.f64606b;
        if (list == null) {
            return 0;
        }
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }
}
