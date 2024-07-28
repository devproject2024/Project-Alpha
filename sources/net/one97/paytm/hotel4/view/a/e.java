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
import net.one97.paytm.hotels2.b.fk;
import net.one97.paytm.upi.util.UpiConstants;

public final class e extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28680b;

    /* renamed from: c  reason: collision with root package name */
    private PagerGalleryViewModel f28681c;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "item");
        if (viewDataBinding instanceof fk) {
            viewDataBinding.invalidateAll();
            fk fkVar = (fk) viewDataBinding;
            fkVar.a(this.f28681c);
            fkVar.a("6");
            fkVar.b(str);
            a.C0498a aVar = a.f28631a;
            a.C0498a.b(fkVar.f29721a, str, Integer.valueOf(UpiConstants.REQUEST_CODE_BANK_DETAIL));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(PagerGalleryViewModel pagerGalleryViewModel) {
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
        this.f28681c = pagerGalleryViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28680b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_gallery_image_list_items, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
