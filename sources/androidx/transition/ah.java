package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class ah implements ai {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f4753a;

    ah(View view) {
        this.f4753a = view.getOverlay();
    }

    public final void a(Drawable drawable) {
        this.f4753a.add(drawable);
    }

    public final void b(Drawable drawable) {
        this.f4753a.remove(drawable);
    }
}
