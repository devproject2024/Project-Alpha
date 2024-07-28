package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.h.u;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ag implements ai {

    /* renamed from: a  reason: collision with root package name */
    protected a f4746a;

    ag(Context context, ViewGroup viewGroup, View view) {
        this.f4746a = new a(context, viewGroup, view, this);
    }

    private static ViewGroup a(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static ag c(View view) {
        ViewGroup a2 = a(view);
        if (a2 == null) {
            return null;
        }
        int childCount = a2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = a2.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f4751e;
            }
        }
        return new ab(a2.getContext(), a2, view);
    }

    public final void a(Drawable drawable) {
        a aVar = this.f4746a;
        aVar.a();
        if (aVar.f4750d == null) {
            aVar.f4750d = new ArrayList<>();
        }
        if (!aVar.f4750d.contains(drawable)) {
            aVar.f4750d.add(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback(aVar);
        }
    }

    public final void b(Drawable drawable) {
        a aVar = this.f4746a;
        if (aVar.f4750d != null) {
            aVar.f4750d.remove(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback((Drawable.Callback) null);
            aVar.b();
        }
    }

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f4747a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f4748b;

        /* renamed from: c  reason: collision with root package name */
        View f4749c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f4750d = null;

        /* renamed from: e  reason: collision with root package name */
        ag f4751e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4752f;

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f4747a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ag agVar) {
            super(context);
            this.f4748b = viewGroup;
            this.f4749c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4751e = agVar;
        }

        /* access modifiers changed from: protected */
        public final boolean verifyDrawable(Drawable drawable) {
            if (super.verifyDrawable(drawable)) {
                return true;
            }
            ArrayList<Drawable> arrayList = this.f4750d;
            return arrayList != null && arrayList.contains(drawable);
        }

        public final void a(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f4748b || viewGroup.getParent() == null || !u.M(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4748b.getLocationOnScreen(iArr2);
                    u.g(view, iArr[0] - iArr2[0]);
                    u.f(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void b(View view) {
            super.removeView(view);
            b();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.f4752f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f4750d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4752f = true;
                    this.f4748b.removeView(this);
                }
            }
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f4748b.getLocationOnScreen(iArr);
            this.f4749c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f4749c.getWidth(), this.f4749c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f4750d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4750d.get(i2).draw(canvas);
            }
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4748b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            ViewGroup viewGroup = this.f4748b;
            if (viewGroup instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                int[] iArr3 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                this.f4749c.getLocationOnScreen(iArr3);
                int[] iArr4 = {iArr3[0] - iArr2[0], iArr3[1] - iArr2[1]};
                rect.offset(iArr4[0], iArr4[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
