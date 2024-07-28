package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fi;

public final class d extends c<FilterValuesItem> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28677b;

    /* renamed from: c  reason: collision with root package name */
    private SRPFilterViewModel f28678c;

    /* renamed from: d  reason: collision with root package name */
    private final String f28679d;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str;
        FilterValuesItem filterValuesItem = (FilterValuesItem) obj;
        k.c(viewDataBinding, "binding");
        k.c(filterValuesItem, "item");
        if (viewDataBinding instanceof fi) {
            SRPFilterItemViewModel sRPFilterItemViewModel = new SRPFilterItemViewModel(this.f28678c);
            sRPFilterItemViewModel.setItemData(filterValuesItem, this.f28679d, i2);
            fi fiVar = (fi) viewDataBinding;
            fiVar.a(sRPFilterItemViewModel);
            String id = filterValuesItem.getId();
            if (id != null) {
                str = p.a(id, " ", "", false);
            } else {
                str = null;
            }
            fiVar.a(f.a(str));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(SRPFilterViewModel sRPFilterViewModel, String str) {
        super(new h.c<FilterValuesItem>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                FilterValuesItem filterValuesItem = (FilterValuesItem) obj;
                FilterValuesItem filterValuesItem2 = (FilterValuesItem) obj2;
                k.c(filterValuesItem, "oldItem");
                k.c(filterValuesItem2, "newItem");
                return k.a((Object) filterValuesItem, (Object) filterValuesItem2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                FilterValuesItem filterValuesItem = (FilterValuesItem) obj;
                FilterValuesItem filterValuesItem2 = (FilterValuesItem) obj2;
                k.c(filterValuesItem, "oldItem");
                k.c(filterValuesItem2, "newItem");
                return k.a((Object) filterValuesItem, (Object) filterValuesItem2);
            }
        });
        k.c(sRPFilterViewModel, "srpFilterViewMOdel");
        k.c(str, "filterParamName");
        this.f28678c = sRPFilterViewModel;
        this.f28679d = str;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28677b = viewGroup.getContext();
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_filter_amenities_list_item, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
