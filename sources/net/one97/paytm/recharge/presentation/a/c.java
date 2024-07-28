package net.one97.paytm.recharge.presentation.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.AutomaticOptionListItemModel;
import net.one97.paytm.recharge.presentation.f.b;

public final class c extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f64590a;

    /* renamed from: b  reason: collision with root package name */
    private final List<AutomaticOptionListItemModel> f64591b;

    /* renamed from: c  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f64592c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        AutomaticOptionListItemModel automaticOptionListItemModel = this.f64591b.get(i2);
        bVar.f64843a.setText(automaticOptionListItemModel.getTitle());
        bVar.f64844b.setText(automaticOptionListItemModel.getDescription());
        bVar.f64845c.setImageResource(automaticOptionListItemModel.getIconId());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f64590a).inflate(R.layout.automatic_option_list_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…list_item, parent, false)");
        return new b(inflate, this.f64592c);
    }

    public c(Context context, List<AutomaticOptionListItemModel> list, AdapterView.OnItemClickListener onItemClickListener) {
        k.c(context, "context");
        k.c(list, "options");
        this.f64590a = context;
        this.f64591b = list;
        this.f64592c = onItemClickListener;
    }

    public final int getItemCount() {
        return this.f64591b.size();
    }
}
