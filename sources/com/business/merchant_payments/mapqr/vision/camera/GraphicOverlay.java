package com.business.merchant_payments.mapqr.vision.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.business.merchant_payments.mapqr.vision.camera.GraphicOverlay.Graphic;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class GraphicOverlay<T extends Graphic> extends View {
    public int mFacing = 0;
    public Set<T> mGraphics = new HashSet();
    public float mHeightScaleFactor = 1.0f;
    public final Object mLock = new Object();
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mWidthScaleFactor = 1.0f;

    public static abstract class Graphic {
        public GraphicOverlay mOverlay;

        public abstract void draw(Canvas canvas);

        public Graphic(GraphicOverlay graphicOverlay) {
            this.mOverlay = graphicOverlay;
        }

        public float scaleX(float f2) {
            return f2 * this.mOverlay.mWidthScaleFactor;
        }

        public float scaleY(float f2) {
            return f2 * this.mOverlay.mHeightScaleFactor;
        }

        public float translateX(float f2) {
            if (this.mOverlay.mFacing == 1) {
                return ((float) this.mOverlay.getWidth()) - scaleX(f2);
            }
            return scaleX(f2);
        }

        public float translateY(float f2) {
            return scaleY(f2);
        }

        public void postInvalidate() {
            this.mOverlay.postInvalidate();
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mGraphics.clear();
        }
        postInvalidate();
    }

    public void add(T t) {
        synchronized (this.mLock) {
            this.mGraphics.add(t);
        }
        postInvalidate();
    }

    public void remove(T t) {
        synchronized (this.mLock) {
            this.mGraphics.remove(t);
        }
        postInvalidate();
    }

    public List<T> getGraphics() {
        Vector vector;
        synchronized (this.mLock) {
            vector = new Vector(this.mGraphics);
        }
        return vector;
    }

    public float getWidthScaleFactor() {
        return this.mWidthScaleFactor;
    }

    public float getHeightScaleFactor() {
        return this.mHeightScaleFactor;
    }

    public void setCameraInfo(int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
            this.mFacing = i4;
        }
        postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.mLock) {
            if (!(this.mPreviewWidth == 0 || this.mPreviewHeight == 0)) {
                this.mWidthScaleFactor = ((float) canvas.getWidth()) / ((float) this.mPreviewWidth);
                this.mHeightScaleFactor = ((float) canvas.getHeight()) / ((float) this.mPreviewHeight);
            }
            for (T draw : this.mGraphics) {
                draw.draw(canvas);
            }
        }
    }
}
