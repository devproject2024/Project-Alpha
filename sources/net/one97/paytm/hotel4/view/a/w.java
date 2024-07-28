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
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.gc;

public final class w extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28755b;

    /* renamed from: c  reason: collision with root package name */
    private final SRPViewModel f28756c;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "locationName");
        if (viewDataBinding instanceof gc) {
            gc gcVar = (gc) viewDataBinding;
            gcVar.a(this.f28756c);
            viewDataBinding.invalidateAll();
            gcVar.a(str);
            TextView textView = gcVar.f29805a;
            k.a((Object) textView, "binding.tvSelectedCityName");
            textView.setText(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(SRPViewModel sRPViewModel) {
        super(new h.c<String>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return k.a((Object) str, (Object) str2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return k.a((Object) str, (Object) str2);
            }
        });
        k.c(sRPViewModel, "viewModel");
        this.f28756c = sRPViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28755b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_selected_city_list_items, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
