package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.service.model.details.TaxData;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fw;

public final class m extends c<TaxData> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28707b;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        TaxData taxData = (TaxData) obj;
        k.c(viewDataBinding, "binding");
        k.c(taxData, "item");
        if ((viewDataBinding instanceof fw) && taxData.getPrice() != null && !p.a(taxData.getPrice(), "0.0", false)) {
            a.C0498a aVar = a.f28631a;
            fw fwVar = (fw) viewDataBinding;
            TextView textView = fwVar.f29774b;
            String price = taxData.getPrice();
            if (price == null) {
                k.a();
            }
            a.C0498a.a(textView, Double.parseDouble(price));
            TextView textView2 = fwVar.f29773a;
            k.a((Object) textView2, "binding.tvRoomTaxDescri");
            textView2.setText(taxData.getDescri());
        }
    }

    public m() {
        super(new h.c<TaxData>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                TaxData taxData = (TaxData) obj;
                TaxData taxData2 = (TaxData) obj2;
                k.c(taxData, "oldItem");
                k.c(taxData2, "newItem");
                return k.a((Object) taxData, (Object) taxData2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                TaxData taxData = (TaxData) obj;
                TaxData taxData2 = (TaxData) obj2;
                k.c(taxData, "oldItem");
                k.c(taxData2, "newItem");
                return k.a((Object) taxData, (Object) taxData2);
            }
        });
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28707b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_room_config_tax, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
