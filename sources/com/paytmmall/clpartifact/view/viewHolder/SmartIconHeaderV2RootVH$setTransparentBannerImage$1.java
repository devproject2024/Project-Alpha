package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.paytm.utility.b.b.b;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.R;
import kotlin.g.b.k;

public final class SmartIconHeaderV2RootVH$setTransparentBannerImage$1 implements b<Drawable> {
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    SmartIconHeaderV2RootVH$setTransparentBannerImage$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH) {
        this.this$0 = smartIconHeaderV2RootVH;
    }

    public final void onError(Exception exc) {
        ImageView imageView = this.this$0.getViewBinding().bannerImage;
        View root = this.this$0.getViewBinding().getRoot();
        k.a((Object) root, "viewBinding.root");
        imageView.setImageDrawable(androidx.core.content.b.a(root.getContext(), R.drawable.banner_placeholder));
    }

    public final void onSuccess(Drawable drawable, c cVar) {
        this.this$0.getViewBinding().bannerImage.setImageDrawable(drawable);
    }
}
