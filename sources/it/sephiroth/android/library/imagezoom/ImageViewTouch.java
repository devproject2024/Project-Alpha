package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class ImageViewTouch extends ImageViewTouchBase {

    /* renamed from: a  reason: collision with root package name */
    protected ScaleGestureDetector f47824a;

    /* renamed from: b  reason: collision with root package name */
    protected GestureDetector f47825b;

    /* renamed from: c  reason: collision with root package name */
    protected int f47826c;

    /* renamed from: d  reason: collision with root package name */
    protected float f47827d;

    /* renamed from: e  reason: collision with root package name */
    protected int f47828e;

    /* renamed from: f  reason: collision with root package name */
    protected GestureDetector.OnGestureListener f47829f;

    /* renamed from: g  reason: collision with root package name */
    protected ScaleGestureDetector.OnScaleGestureListener f47830g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f47831h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f47832i;
    protected boolean j;
    /* access modifiers changed from: private */
    public b y;
    /* access modifiers changed from: private */
    public c z;

    public interface b {
    }

    public interface c {
        void a();
    }

    public ImageViewTouch(Context context) {
        super(context);
        this.f47831h = true;
        this.f47832i = true;
        this.j = true;
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f47831h = true;
        this.f47832i = true;
        this.j = true;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, AttributeSet attributeSet, int i2) {
        super.a(context, attributeSet, i2);
        this.f47826c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f47829f = getGestureListener();
        this.f47830g = getScaleListener();
        this.f47824a = new ScaleGestureDetector(getContext(), this.f47830g);
        this.f47825b = new GestureDetector(getContext(), this.f47829f, (Handler) null, true);
        this.f47828e = 1;
    }

    public void setDoubleTapListener(b bVar) {
        this.y = bVar;
    }

    public void setSingleTapListener(c cVar) {
        this.z = cVar;
    }

    public void setDoubleTapEnabled(boolean z2) {
        this.f47831h = z2;
    }

    public void setScaleEnabled(boolean z2) {
        this.f47832i = z2;
    }

    public void setScrollEnabled(boolean z2) {
        this.j = z2;
    }

    public boolean getDoubleTapEnabled() {
        return this.f47831h;
    }

    /* access modifiers changed from: protected */
    public GestureDetector.OnGestureListener getGestureListener() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public final void a(Drawable drawable, Matrix matrix, float f2, float f3) {
        super.a(drawable, matrix, f2, f3);
        this.f47827d = getMaxScale() / 3.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f47824a.onTouchEvent(motionEvent);
        if (!this.f47824a.isInProgress()) {
            this.f47825b.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID) == 1 && getScale() < getMinScale()) {
            b(getMinScale());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void a(float f2) {
        if (f2 < getMinScale()) {
            b(getMinScale());
        }
    }

    /* access modifiers changed from: protected */
    public final float a(float f2, float f3) {
        if (this.f47828e == 1) {
            float f4 = this.f47827d;
            if ((2.0f * f4) + f2 <= f3) {
                return f2 + f4;
            }
            this.f47828e = -1;
            return f3;
        }
        this.f47828e = 1;
        return 1.0f;
    }

    public final boolean b(float f2, float f3) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.q = true;
        c(-f2, -f3);
        invalidate();
        return true;
    }

    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y2 = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f2) <= 800.0f && Math.abs(f3) <= 800.0f) {
            return false;
        }
        this.q = true;
        d(x / 2.0f, y2 / 2.0f);
        invalidate();
        return true;
    }

    public final boolean a(int i2) {
        RectF bitmapRect = getBitmapRect();
        a(bitmapRect, this.x);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (bitmapRect == null) {
            return false;
        }
        if (bitmapRect.right < ((float) rect.right) || i2 >= 0) {
            if (((double) Math.abs(bitmapRect.left - this.x.left)) > 1.0d) {
                return true;
            }
            return false;
        } else if (Math.abs(bitmapRect.right - ((float) rect.right)) > 1.0f) {
            return true;
        } else {
            return false;
        }
    }

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }

        public a() {
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ImageViewTouch.this.z == null) {
                return true;
            }
            ImageViewTouch.this.z.a();
            return true;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            new StringBuilder("onDoubleTap. double tap enabled? ").append(ImageViewTouch.this.f47831h);
            if (ImageViewTouch.this.f47831h) {
                ImageViewTouch imageViewTouch = ImageViewTouch.this;
                imageViewTouch.q = true;
                float scale = imageViewTouch.getScale();
                ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                ImageViewTouch.this.a(Math.min(ImageViewTouch.this.getMaxScale(), Math.max(imageViewTouch2.a(scale, imageViewTouch2.getMaxScale()), ImageViewTouch.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                ImageViewTouch.this.invalidate();
            }
            if (ImageViewTouch.this.y != null) {
                b unused = ImageViewTouch.this.y;
            }
            return super.onDoubleTap(motionEvent);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (ImageViewTouch.this.isLongClickable() && !ImageViewTouch.this.f47824a.isInProgress()) {
                ImageViewTouch.this.setPressed(true);
                ImageViewTouch.this.performLongClick();
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (ImageViewTouch.this.j && motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1 && !ImageViewTouch.this.f47824a.isInProgress()) {
                return ImageViewTouch.this.b(f2, f3);
            }
            return false;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (ImageViewTouch.this.j && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1 && !ImageViewTouch.this.f47824a.isInProgress() && ImageViewTouch.this.getScale() != 1.0f) {
                return ImageViewTouch.this.a(motionEvent, motionEvent2, f2, f3);
            }
            return false;
        }
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f47834a = false;

        public d() {
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = ImageViewTouch.this.getScale() * scaleGestureDetector.getScaleFactor();
            if (ImageViewTouch.this.f47832i) {
                if (this.f47834a && currentSpan != 0.0f) {
                    ImageViewTouch imageViewTouch = ImageViewTouch.this;
                    imageViewTouch.q = true;
                    ImageViewTouch.this.a(Math.min(imageViewTouch.getMaxScale(), Math.max(scale, ImageViewTouch.this.getMinScale() - 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                    imageViewTouch2.f47828e = 1;
                    imageViewTouch2.invalidate();
                    return true;
                } else if (!this.f47834a) {
                    this.f47834a = true;
                }
            }
            return true;
        }
    }
}
