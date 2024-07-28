package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class n implements p {

    /* renamed from: a  reason: collision with root package name */
    protected a f36491a;

    n(Context context, ViewGroup viewGroup, View view) {
        this.f36491a = new a(context, viewGroup, view, this);
    }

    public final void a(Drawable drawable) {
        a aVar = this.f36491a;
        if (!aVar.f36497f) {
            if (aVar.f36495d == null) {
                aVar.f36495d = new ArrayList<>();
            }
            if (!aVar.f36495d.contains(drawable)) {
                aVar.f36495d.add(drawable);
                aVar.invalidate(drawable.getBounds());
                drawable.setCallback(aVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
    }

    public final void b(Drawable drawable) {
        a aVar = this.f36491a;
        if (aVar.f36495d != null) {
            aVar.f36495d.remove(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback((Drawable.Callback) null);
            if (aVar.getChildCount() != 0) {
                return;
            }
            if (aVar.f36495d == null || aVar.f36495d.size() == 0) {
                aVar.f36497f = true;
                aVar.f36493b.removeView(aVar);
            }
        }
    }

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f36492a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f36493b;

        /* renamed from: c  reason: collision with root package name */
        View f36494c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f36495d = null;

        /* renamed from: e  reason: collision with root package name */
        n f36496e;

        /* renamed from: f  reason: collision with root package name */
        boolean f36497f;

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f36492a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        }

        a(Context context, ViewGroup viewGroup, View view, n nVar) {
            super(context);
            this.f36493b = viewGroup;
            this.f36494c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f36496e = nVar;
        }

        /* access modifiers changed from: protected */
        public final boolean verifyDrawable(Drawable drawable) {
            if (super.verifyDrawable(drawable)) {
                return true;
            }
            ArrayList<Drawable> arrayList = this.f36495d;
            return arrayList != null && arrayList.contains(drawable);
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f36493b.getLocationOnScreen(iArr);
            this.f36494c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f36494c.getWidth(), this.f36494c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f36495d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f36495d.get(i2).draw(canvas);
            }
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f36493b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            ViewGroup viewGroup = this.f36493b;
            if (viewGroup != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                int[] iArr3 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                this.f36494c.getLocationOnScreen(iArr3);
                int[] iArr4 = {iArr3[0] - iArr2[0], iArr3[1] - iArr2[1]};
                rect.offset(iArr4[0], iArr4[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
