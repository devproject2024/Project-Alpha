package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class ac implements ad {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f4737a;

    ac(ViewGroup viewGroup) {
        this.f4737a = viewGroup.getOverlay();
    }

    public final void a(Drawable drawable) {
        this.f4737a.add(drawable);
    }

    public final void b(Drawable drawable) {
        this.f4737a.remove(drawable);
    }

    public final void a(View view) {
        this.f4737a.add(view);
    }

    public final void b(View view) {
        this.f4737a.remove(view);
    }
}
