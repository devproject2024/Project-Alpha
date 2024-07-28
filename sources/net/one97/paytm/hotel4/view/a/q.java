package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.ei;
import net.one97.paytm.upi.util.UpiConstants;

public final class q extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28728b;

    /* renamed from: c  reason: collision with root package name */
    private final PagerGalleryViewModel f28729c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28730d;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "item");
        if (viewDataBinding instanceof ei) {
            viewDataBinding.invalidateAll();
            ei eiVar = (ei) viewDataBinding;
            eiVar.a(this.f28729c);
            eiVar.a("7");
            eiVar.b(str);
            eiVar.a(Integer.valueOf(this.f28730d));
            a.C0498a aVar = a.f28631a;
            a.C0498a.b(eiVar.f29599a, str, Integer.valueOf(UpiConstants.REQUEST_CODE_BANK_DETAIL));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(PagerGalleryViewModel pagerGalleryViewModel, int i2) {
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
        k.c(pagerGalleryViewModel, "pagerGalleryViewModel");
        this.f28729c = pagerGalleryViewModel;
        this.f28730d = i2;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28728b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.h4_select_room_image_gallery, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
