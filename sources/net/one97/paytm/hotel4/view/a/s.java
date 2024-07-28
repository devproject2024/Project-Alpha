package net.one97.paytm.hotel4.view.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fm;

public final class s extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private SRPListItemViewModel f28733b;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "item");
        if (viewDataBinding instanceof fm) {
            fm fmVar = (fm) viewDataBinding;
            fmVar.a(str);
            fmVar.a(this.f28733b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(SRPListItemViewModel sRPListItemViewModel) {
        super(new h.c<String>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return p.a(str, str2, true);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return p.a(str, str2, true);
            }
        });
        k.c(sRPListItemViewModel, "viewModel");
        this.f28733b = sRPListItemViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_image_list_item, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
