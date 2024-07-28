package net.one97.paytm.phoenix.provider;

import android.widget.ImageView;
import com.squareup.picasso.w;
import kotlin.g.b.k;

public final class TitleBarImageProviderImpl implements TitleBarImageProvider {
    public final void setTitleBarImage(int i2, int i3, ImageView imageView, String str) {
        k.c(imageView, "imageView");
        k.c(str, "imageUrl");
        w.a().a(str).a(i2, i3).a(imageView);
    }
}
