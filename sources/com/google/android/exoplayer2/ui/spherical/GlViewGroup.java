package com.google.android.exoplayer2.ui.spherical;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.widget.FrameLayout;

public final class GlViewGroup extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final a f33589a;

    public final void dispatchDraw(Canvas canvas) {
        a aVar = this.f33589a;
        Canvas canvas2 = null;
        if (aVar.f33610a != null) {
            canvas2 = aVar.f33610a.lockCanvas((Rect) null);
        }
        if (canvas2 == null) {
            postInvalidate();
            return;
        }
        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas2);
        a aVar2 = this.f33589a;
        if (canvas2 != null && aVar2.f33610a != null) {
            aVar2.f33610a.unlockCanvasAndPost(canvas2);
        }
    }

    public final a getRenderer() {
        return this.f33589a;
    }
}
