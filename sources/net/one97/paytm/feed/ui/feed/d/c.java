package net.one97.paytm.feed.ui.feed.d;

import android.os.Build;
import android.view.View;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.b.y;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.base.b;
import net.one97.paytm.feed.ui.feed.a;

public final class c extends b<y, FeedGeneric, a> {

    /* renamed from: b  reason: collision with root package name */
    private a f35036b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
    }

    public final void a(a aVar, int i2) {
        k.c(aVar, "viewModel");
        y yVar = (y) this.f34872a;
        yVar.setVariable(net.one97.paytm.feed.a.f33777d, aVar);
        yVar.setVariable(net.one97.paytm.feed.a.f33780g, aVar.f35027e);
        yVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        yVar.setVariable(net.one97.paytm.feed.a.m, Integer.valueOf(aVar.f35026d));
        if (this.f35036b == null) {
            this.f35036b = new a();
            yVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35036b);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            yVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            RoundedImageView roundedImageView = ((y) this.f34872a).f34242a;
            k.a((Object) roundedImageView, "dataBinding.articleImage");
            roundedImageView.setClipToOutline(true);
        }
        ((y) this.f34872a).executePendingBindings();
    }
}
