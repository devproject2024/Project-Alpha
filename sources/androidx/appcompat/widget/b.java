package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1707a;

    public final int getOpacity() {
        return 0;
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1707a = actionBarContainer;
    }

    public final void draw(Canvas canvas) {
        if (!this.f1707a.f1395d) {
            if (this.f1707a.f1392a != null) {
                this.f1707a.f1392a.draw(canvas);
            }
            if (this.f1707a.f1393b != null && this.f1707a.f1396e) {
                this.f1707a.f1393b.draw(canvas);
            }
        } else if (this.f1707a.f1394c != null) {
            this.f1707a.f1394c.draw(canvas);
        }
    }

    public final void getOutline(Outline outline) {
        if (this.f1707a.f1395d) {
            if (this.f1707a.f1394c != null) {
                this.f1707a.f1394c.getOutline(outline);
            }
        } else if (this.f1707a.f1392a != null) {
            this.f1707a.f1392a.getOutline(outline);
        }
    }
}
