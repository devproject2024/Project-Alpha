package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.h.u;
import java.util.ArrayList;

final class i extends ViewGroup implements f {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f4799a;

    /* renamed from: b  reason: collision with root package name */
    View f4800b;

    /* renamed from: c  reason: collision with root package name */
    final View f4801c;

    /* renamed from: d  reason: collision with root package name */
    int f4802d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f4803e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f4804f = new ViewTreeObserver.OnPreDrawListener() {
        public final boolean onPreDraw() {
            u.g(i.this);
            if (i.this.f4799a == null || i.this.f4800b == null) {
                return true;
            }
            i.this.f4799a.endViewTransition(i.this.f4800b);
            u.g(i.this.f4799a);
            i iVar = i.this;
            iVar.f4799a = null;
            iVar.f4800b = null;
            return true;
        }
    };

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    private i(View view) {
        super(view.getContext());
        this.f4801c = view;
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
    }

    public final void setVisibility(int i2) {
        super.setVisibility(i2);
        if (b(this.f4801c) == this) {
            aj.a(this.f4801c, i2 == 0 ? 4 : 0);
        }
    }

    public final void a(ViewGroup viewGroup, View view) {
        this.f4799a = viewGroup;
        this.f4800b = view;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f4801c, this);
        this.f4801c.getViewTreeObserver().addOnPreDrawListener(this.f4804f);
        aj.a(this.f4801c, 4);
        if (this.f4801c.getParent() != null) {
            ((View) this.f4801c.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        this.f4801c.getViewTreeObserver().removeOnPreDrawListener(this.f4804f);
        aj.a(this.f4801c, 0);
        a(this.f4801c, (i) null);
        if (this.f4801c.getParent() != null) {
            ((View) this.f4801c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        b.a(canvas, true);
        canvas.setMatrix(this.f4803e);
        aj.a(this.f4801c, 0);
        this.f4801c.invalidate();
        aj.a(this.f4801c, 4);
        drawChild(canvas, this.f4801c, getDrawingTime());
        b.a(canvas, false);
    }

    private static void a(View view, View view2) {
        aj.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    private static i b(View view) {
        return (i) view.getTag(R.id.ghost_view);
    }

    private static void a(View view, i iVar) {
        view.setTag(R.id.ghost_view, iVar);
    }

    static i a(View view, ViewGroup viewGroup, Matrix matrix) {
        g gVar;
        if (view.getParent() instanceof ViewGroup) {
            g a2 = g.a(viewGroup);
            i b2 = b(view);
            int i2 = 0;
            if (!(b2 == null || (gVar = (g) b2.getParent()) == a2)) {
                i2 = b2.f4802d;
                gVar.removeView(b2);
                b2 = null;
            }
            if (b2 == null) {
                b2 = new i(view);
                b2.f4803e = matrix;
                if (a2 == null) {
                    a2 = new g(viewGroup);
                } else if (a2.f4791b) {
                    ae.a(a2.f4790a).b(a2);
                    ae.a(a2.f4790a).a(a2);
                } else {
                    throw new IllegalStateException("This GhostViewHolder is detached!");
                }
                a((View) viewGroup, (View) a2);
                a((View) viewGroup, (View) b2);
                ArrayList arrayList = new ArrayList();
                g.a(b2.f4801c, (ArrayList<View>) arrayList);
                int a3 = a2.a((ArrayList<View>) arrayList);
                if (a3 < 0 || a3 >= a2.getChildCount()) {
                    a2.addView(b2);
                } else {
                    a2.addView(b2, a3);
                }
                b2.f4802d = i2;
            } else {
                b2.f4803e = matrix;
            }
            b2.f4802d++;
            return b2;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void a(View view) {
        i b2 = b(view);
        if (b2 != null) {
            b2.f4802d--;
            if (b2.f4802d <= 0) {
                ((g) b2.getParent()).removeView(b2);
            }
        }
    }
}
