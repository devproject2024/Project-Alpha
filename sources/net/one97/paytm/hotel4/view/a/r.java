package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.gg;

public final class r extends c<SRPDataItem> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28731b;

    /* renamed from: c  reason: collision with root package name */
    private final SRPViewModel f28732c;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        boolean z;
        SRPDataItem sRPDataItem = (SRPDataItem) obj;
        k.c(viewDataBinding, "binding");
        k.c(sRPDataItem, "item");
        if (viewDataBinding instanceof gg) {
            gg ggVar = (gg) viewDataBinding;
            if (ggVar.a() == null) {
                ggVar.a(new SRPListItemViewModel(this.f28732c));
            } else {
                viewDataBinding.invalidateAll();
            }
            SRPListItemViewModel a2 = ggVar.a();
            if (a2 != null) {
                a2.setData(sRPDataItem, i2);
            }
            View root = ggVar.getRoot();
            k.a((Object) root, "binding.root");
            GridLayoutManager gridLayoutManager = new GridLayoutManager(root.getContext(), 1, 0, false);
            RecyclerView recyclerView = ggVar.j;
            k.a((Object) recyclerView, "binding.recyclerHeaderImage");
            recyclerView.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView2 = ggVar.j;
            k.a((Object) recyclerView2, "binding.recyclerHeaderImage");
            SRPListItemViewModel a3 = ggVar.a();
            if (a3 == null) {
                k.a();
            }
            k.a((Object) a3, "binding.viewModel!!");
            s sVar = new s(a3);
            sVar.a(sRPDataItem.getPaytmImages().getFull());
            recyclerView2.setAdapter(sVar);
            ggVar.e((Integer) 8);
            ggVar.a((Integer) 8);
            ggVar.b((Integer) 8);
            ggVar.c((Integer) 8);
            ggVar.d((Integer) 8);
            String propertyTag = sRPDataItem.getPropertyTag();
            if (propertyTag != null) {
                ConstraintLayout constraintLayout = ggVar.f29823a;
                k.a((Object) constraintLayout, "binding.amazingDeals");
                constraintLayout.setVisibility(0);
                TextView textView = ggVar.f29829g;
                k.a((Object) textView, "binding.dealsText");
                textView.setText(propertyTag);
                a.C0498a aVar = a.f28631a;
                a.C0498a.a(ggVar.f29824b, f.c("dealtag"));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ConstraintLayout constraintLayout2 = ggVar.f29823a;
                k.a((Object) constraintLayout2, "binding.amazingDeals");
                constraintLayout2.setVisibility(8);
            }
            CharSequence starRating = sRPDataItem.getRatings().getStarRating();
            if ((starRating == null || starRating.length() == 0) || Integer.parseInt(sRPDataItem.getRatings().getStarRating()) <= 3) {
                TextView textView2 = ggVar.f29830h;
                k.a((Object) textView2, "binding.imageViewUpper");
                textView2.setVisibility(8);
            } else {
                TextView textView3 = ggVar.f29830h;
                k.a((Object) textView3, "binding.imageViewUpper");
                textView3.setVisibility(0);
            }
            List<String> amenitiesList = sRPDataItem.getAmenitiesList();
            if (amenitiesList != null) {
                if (!amenitiesList.isEmpty()) {
                    ggVar.a(amenitiesList.get(0));
                    ggVar.a((Integer) 0);
                }
                if (amenitiesList.size() > 1) {
                    ggVar.b(amenitiesList.get(1));
                    ggVar.b((Integer) 0);
                }
                if (amenitiesList.size() > 2) {
                    ggVar.c(amenitiesList.get(2));
                    ggVar.c((Integer) 0);
                }
                if (amenitiesList.size() > 3) {
                    ggVar.d(amenitiesList.get(3));
                    ggVar.d((Integer) 0);
                }
                if (amenitiesList.size() > 4) {
                    ggVar.e("+" + (amenitiesList.size() - 4));
                    ggVar.e((Integer) 0);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(SRPViewModel sRPViewModel) {
        super(new h.c<SRPDataItem>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                SRPDataItem sRPDataItem = (SRPDataItem) obj;
                SRPDataItem sRPDataItem2 = (SRPDataItem) obj2;
                k.c(sRPDataItem, "oldItem");
                k.c(sRPDataItem2, "newItem");
                return k.a((Object) sRPDataItem, (Object) sRPDataItem2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                SRPDataItem sRPDataItem = (SRPDataItem) obj;
                SRPDataItem sRPDataItem2 = (SRPDataItem) obj2;
                k.c(sRPDataItem, "oldItem");
                k.c(sRPDataItem2, "newItem");
                return k.a((Object) sRPDataItem, (Object) sRPDataItem2);
            }
        });
        k.c(sRPViewModel, "viewModel");
        this.f28732c = sRPViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28731b = viewGroup.getContext();
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_srp_list_items, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
