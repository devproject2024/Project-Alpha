package net.one97.paytm.nativesdk.paymethods.widgets;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.a.j;
import com.bumptech.glide.e.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b.q;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.ShimmerFrameLayout;

public final class CustomInstrumentsToolbar$setToolbarValues$$inlined$let$lambda$1 implements g<Drawable> {
    final /* synthetic */ CustomInstrumentsToolbar this$0;

    CustomInstrumentsToolbar$setToolbarValues$$inlined$let$lambda$1(CustomInstrumentsToolbar customInstrumentsToolbar) {
        this.this$0 = customInstrumentsToolbar;
    }

    public final boolean onLoadFailed(q qVar, Object obj, j<Drawable> jVar, boolean z) {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(R.id.shimmer_logo_view);
        k.a((Object) shimmerFrameLayout, "shimmer_logo_view");
        ExtensionsKt.stopAnimation(shimmerFrameLayout);
        return false;
    }

    public final boolean onResourceReady(Drawable drawable, Object obj, j<Drawable> jVar, a aVar, boolean z) {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(R.id.shimmer_logo_view);
        k.a((Object) shimmerFrameLayout, "shimmer_logo_view");
        ExtensionsKt.stopAnimation(shimmerFrameLayout);
        return false;
    }
}
