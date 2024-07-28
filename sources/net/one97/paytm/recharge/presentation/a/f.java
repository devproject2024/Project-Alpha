package net.one97.paytm.recharge.presentation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.presentation.d.c;
import net.one97.paytm.recharge.presentation.f.i;

public final class f extends RecyclerView.a<i> {

    /* renamed from: a  reason: collision with root package name */
    private final String f64602a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<CJRPayChannelOptions> f64603b;

    /* renamed from: c  reason: collision with root package name */
    private final c f64604c;

    public f(String str, ArrayList<CJRPayChannelOptions> arrayList, c cVar) {
        k.c(str, "paymentMode");
        this.f64602a = str;
        this.f64603b = arrayList;
        this.f64604c = cVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        i iVar = (i) vVar;
        k.c(iVar, "holder");
        ArrayList<CJRPayChannelOptions> arrayList = this.f64603b;
        if (arrayList != null) {
            iVar.a(arrayList.get(i2));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_emandate_grid_item, (ViewGroup) null, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…_grid_item, null , false)");
        return new i(inflate, this.f64602a, this.f64604c);
    }

    public final int getItemCount() {
        ArrayList<CJRPayChannelOptions> arrayList = this.f64603b;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        return this.f64603b.size();
    }
}
