package androidx.fragment.app;

import androidx.lifecycle.ai;
import androidx.lifecycle.ak;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.k.c;

public final class v {

    static final class a extends l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        public final al.b invoke() {
            al.b defaultViewModelProviderFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
            k.a((Object) defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final <VM extends ai> g<VM> a(Fragment fragment, c<VM> cVar, kotlin.g.a.a<? extends an> aVar, kotlin.g.a.a<? extends al.b> aVar2) {
        k.c(fragment, "$this$createViewModelLazy");
        k.c(cVar, "viewModelClass");
        k.c(aVar, "storeProducer");
        if (aVar2 == null) {
            aVar2 = new a(fragment);
        }
        return new ak<>(cVar, aVar, aVar2);
    }
}
