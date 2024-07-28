package net.one97.scanner.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.one97.scanner.camera.GraphicOverlay.a;

public class GraphicOverlay<T extends a> extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Object f72446a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f72447b;

    /* renamed from: c  reason: collision with root package name */
    private float f72448c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f72449d;

    /* renamed from: e  reason: collision with root package name */
    private float f72450e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f72451f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Set<T> f72452g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    private T f72453h;

    public static abstract class a {
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        synchronized (this.f72446a) {
            this.f72452g.clear();
            this.f72453h = null;
        }
        postInvalidate();
    }

    public T getFirstGraphic() {
        T t;
        synchronized (this.f72446a) {
            t = this.f72453h;
        }
        return t;
    }

    public void setCameraInfo(int i2, int i3, int i4) {
        synchronized (this.f72446a) {
            this.f72447b = i2;
            this.f72449d = i3;
            this.f72451f = i4;
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f72446a) {
            if (!(this.f72447b == 0 || this.f72449d == 0)) {
                this.f72448c = ((float) canvas.getWidth()) / ((float) this.f72447b);
                this.f72450e = ((float) canvas.getHeight()) / ((float) this.f72449d);
            }
            Iterator<T> it2 = this.f72452g.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
