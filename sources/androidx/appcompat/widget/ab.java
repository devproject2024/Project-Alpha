package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class ab extends v {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1668a;

    public ab(Context context, Resources resources) {
        super(resources);
        this.f1668a = new WeakReference<>(context);
    }

    public final Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = (Context) this.f1668a.get();
        if (!(drawable == null || context == null)) {
            u.a().a(context, i2, drawable);
        }
        return drawable;
    }
}
