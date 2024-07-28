package net.one97.paytm.hotel4.view.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.viewmodel.SRPSortListItemViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPSortViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ek;

public final class u extends c<SortKeysItem> {

    /* renamed from: b  reason: collision with root package name */
    private final SRPSortViewModel f28743b;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        SortKeysItem sortKeysItem = (SortKeysItem) obj;
        k.c(viewDataBinding, "binding");
        k.c(sortKeysItem, "item");
        if (viewDataBinding instanceof ek) {
            ek ekVar = (ek) viewDataBinding;
            if (ekVar.a() == null) {
                SRPSortListItemViewModel sRPSortListItemViewModel = new SRPSortListItemViewModel(this.f28743b);
                sRPSortListItemViewModel.setPosition(i2);
                ekVar.a(sRPSortListItemViewModel);
            } else {
                viewDataBinding.invalidateAll();
            }
            SRPSortListItemViewModel a2 = ekVar.a();
            if (a2 != null) {
                a2.setData(sortKeysItem);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(SRPSortViewModel sRPSortViewModel) {
        super(new h.c<SortKeysItem>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                SortKeysItem sortKeysItem = (SortKeysItem) obj;
                SortKeysItem sortKeysItem2 = (SortKeysItem) obj2;
                k.c(sortKeysItem, "oldItemSRP");
                k.c(sortKeysItem2, "newItemSRP");
                return k.a((Object) sortKeysItem, (Object) sortKeysItem2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                SortKeysItem sortKeysItem = (SortKeysItem) obj;
                SortKeysItem sortKeysItem2 = (SortKeysItem) obj2;
                k.c(sortKeysItem, "oldItemSRP");
                k.c(sortKeysItem2, "newItemSRP");
                return k.a((Object) sortKeysItem, (Object) sortKeysItem2);
            }
        });
        k.c(sRPSortViewModel, "viewmodel");
        this.f28743b = sRPSortViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.h4_sort_view_list_item, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
