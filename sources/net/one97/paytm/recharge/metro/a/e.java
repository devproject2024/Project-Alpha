package net.one97.paytm.recharge.metro.a;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.metro.d.e;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceModel;

public final class e extends RecyclerView.a<net.one97.paytm.recharge.metro.d.e> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRMetroPriceModel> f63168a;

    /* renamed from: b  reason: collision with root package name */
    private final a f63169b;

    public interface a {
        void a(int i2);
    }

    public e(ArrayList<CJRMetroPriceModel> arrayList, a aVar) {
        k.c(arrayList, "tripPassArray");
        k.c(aVar, "tripPassListener");
        this.f63168a = arrayList;
        this.f63169b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        net.one97.paytm.recharge.metro.d.e eVar = (net.one97.paytm.recharge.metro.d.e) vVar;
        k.c(eVar, "holder");
        CJRMetroPriceModel cJRMetroPriceModel = this.f63168a.get(i2);
        k.a((Object) cJRMetroPriceModel, "tripPassArray[position]");
        CJRMetroPriceModel cJRMetroPriceModel2 = cJRMetroPriceModel;
        a aVar = this.f63169b;
        k.c(cJRMetroPriceModel2, "cjrMetroPriceModel");
        TextView textView = eVar.f63464b;
        if (textView != null) {
            textView.setText(String.valueOf(cJRMetroPriceModel2.getNoOfTrips()));
        }
        TextView textView2 = eVar.f63466d;
        if (textView2 != null) {
            View view = eVar.itemView;
            k.a((Object) view, "itemView");
            textView2.setText(view.getContext().getString(R.string.rupee, new Object[]{ba.a(String.valueOf(cJRMetroPriceModel2.getFare()), true)}));
        }
        TextView textView3 = eVar.f63465c;
        if (textView3 != null) {
            textView3.setText(cJRMetroPriceModel2.getValidFor().toString());
        }
        CheckBox checkBox = eVar.f63463a;
        if (checkBox != null) {
            checkBox.setChecked(cJRMetroPriceModel2.isSelected());
        }
        View view2 = eVar.itemView;
        k.a((Object) view2, "itemView");
        view2.setSelected(cJRMetroPriceModel2.isSelected());
        TextView textView4 = eVar.f63464b;
        if (textView4 != null) {
            textView4.setTypeface((Typeface) null, 0);
        }
        TextView textView5 = eVar.f63465c;
        if (textView5 != null) {
            textView5.setTypeface((Typeface) null, 0);
        }
        TextView textView6 = eVar.f63466d;
        if (textView6 != null) {
            textView6.setTypeface((Typeface) null, 0);
        }
        eVar.a(cJRMetroPriceModel2.isSelected());
        eVar.itemView.setOnClickListener(new e.a(eVar, cJRMetroPriceModel2, aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip_pass_price_layout, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…ce_layout, parent, false)");
        return new net.one97.paytm.recharge.metro.d.e(inflate);
    }

    public final int getItemCount() {
        return this.f63168a.size();
    }
}
