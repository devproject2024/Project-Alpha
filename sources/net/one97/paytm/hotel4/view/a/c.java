package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.b.f;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.h;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainItemViewModel;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.cm;

public final class c extends com.travel.a.c<FilterValuesItem> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28674b;

    /* renamed from: c  reason: collision with root package name */
    private SRPFilterLocalityAndHotelChainViewModel f28675c;

    /* renamed from: d  reason: collision with root package name */
    private String f28676d;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        FilterValuesItem filterValuesItem = (FilterValuesItem) obj;
        k.c(viewDataBinding, "binding");
        k.c(filterValuesItem, "item");
        if (viewDataBinding instanceof cm) {
            SRPFilterLocalityAndHotelChainItemViewModel sRPFilterLocalityAndHotelChainItemViewModel = new SRPFilterLocalityAndHotelChainItemViewModel(this.f28675c);
            sRPFilterLocalityAndHotelChainItemViewModel.setItemData(filterValuesItem, this.f28676d, i2);
            cm cmVar = (cm) viewDataBinding;
            cmVar.a(sRPFilterLocalityAndHotelChainItemViewModel);
            int imageId = this.f28675c.getImageId();
            if (imageId != 0) {
                Context context = this.f28674b;
                if (context == null) {
                    k.a();
                }
                cmVar.a(f.a(context.getResources(), imageId, (Resources.Theme) null));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel, String str) {
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
        k.c(sRPFilterLocalityAndHotelChainViewModel, "filterLocalityHotelChainViewMOdel");
        k.c(str, "filterParam");
        this.f28675c = sRPFilterLocalityAndHotelChainViewModel;
        this.f28676d = str;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28674b = viewGroup.getContext();
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.h4_locality_hotel_chain_filter_list_item, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
