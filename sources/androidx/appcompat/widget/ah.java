package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public final class ah extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1704a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1705b;

    public ah(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1705b = new WeakReference<>(context);
    }

    public final Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = (Context) this.f1705b.get();
        if (context != null) {
            return u.a().a(context, this, i2);
        }
        return super.getDrawable(i2);
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    public static void b() {
        f1704a = true;
    }

    public static boolean a() {
        return f1704a && Build.VERSION.SDK_INT <= 20;
    }
}
