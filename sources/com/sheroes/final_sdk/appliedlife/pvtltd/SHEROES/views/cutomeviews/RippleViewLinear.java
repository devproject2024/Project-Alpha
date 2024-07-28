package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.sheroes.final_sdk.R;

public class RippleViewLinear extends LinearLayout {
    private int HEIGHT;
    private int WIDTH;
    private boolean animationRunning = false;
    private Handler canvasHandler;
    private int durationEmpty = -1;
    private int frameRate = 10;
    private GestureDetector gestureDetector;
    private Boolean hasToZoom;
    private Boolean isCentered;
    private OnRippleCompleteListener onCompletionListener;
    private Bitmap originBitmap;
    private Paint paint;
    private float radiusMax = 0.0f;
    private int rippleAlpha = 90;
    private int rippleColor;
    private int rippleDuration = 200;
    private int ripplePadding;
    private Integer rippleType;
    private final Runnable runnable = new Runnable() {
        public void run() {
            RippleViewLinear.this.invalidate();
        }
    };
    private ScaleAnimation scaleAnimation;
    private int timer = 0;
    private int timerEmpty = 0;
    private float x = -1.0f;
    private float y = -1.0f;
    private int zoomDuration;
    private float zoomScale;

    public interface OnRippleCompleteListener {
        void onComplete(RippleViewLinear rippleViewLinear);
    }

    public RippleViewLinear(Context context) {
        super(context);
    }

    public RippleViewLinear(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RippleViewLinear(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RippleView);
            this.rippleColor = obtainStyledAttributes.getColor(R.styleable.RippleView_rv_color, getResources().getColor(R.color.sheroes_ripple_color));
            this.rippleType = Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.RippleView_rv_type, 0));
            this.hasToZoom = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.RippleView_rv_zoom, false));
            this.isCentered = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.RippleView_rv_centered, true));
            this.rippleDuration = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_rippleDuration, this.rippleDuration);
            this.frameRate = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_framerate, this.frameRate);
            this.rippleAlpha = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_alpha, this.rippleAlpha);
            this.ripplePadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RippleView_rv_ripplePadding, 0);
            this.canvasHandler = new Handler();
            this.zoomScale = obtainStyledAttributes.getFloat(R.styleable.RippleView_rv_zoomScale, 1.03f);
            this.zoomDuration = obtainStyledAttributes.getInt(R.styleable.RippleView_rv_zoomDuration, 200);
            obtainStyledAttributes.recycle();
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.rippleColor);
            this.paint.setAlpha(this.rippleAlpha);
            setWillNotDraw(false);
            this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return true;
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

                public void onLongPress(MotionEvent motionEvent) {
                    super.onLongPress(motionEvent);
                    RippleViewLinear.this.animateRipple(motionEvent);
                    RippleViewLinear.this.sendClickEvent(Boolean.TRUE);
                }
            });
            setDrawingCacheEnabled(true);
            setClickable(true);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.animationRunning) {
            int i2 = this.rippleDuration;
            int i3 = this.timer;
            int i4 = this.frameRate;
            if (i2 <= i3 * i4) {
                this.animationRunning = false;
                this.timer = 0;
                this.durationEmpty = -1;
                this.timerEmpty = 0;
                canvas.save();
                canvas.restore();
                invalidate();
                OnRippleCompleteListener onRippleCompleteListener = this.onCompletionListener;
                if (onRippleCompleteListener != null) {
                    onRippleCompleteListener.onComplete(this);
                    return;
                }
                return;
            }
            this.canvasHandler.postDelayed(this.runnable, (long) i4);
            if (this.timer == 0) {
                canvas.save();
            }
            canvas.drawCircle(this.x, this.y, this.radiusMax * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)), this.paint);
            this.paint.setColor(Color.parseColor("#ffff4444"));
            if (this.rippleType.intValue() == 1 && this.originBitmap != null) {
                int i5 = this.timer;
                int i6 = this.frameRate;
                float f2 = ((float) i5) * ((float) i6);
                int i7 = this.rippleDuration;
                if (f2 / ((float) i7) > 0.4f) {
                    if (this.durationEmpty == -1) {
                        this.durationEmpty = i7 - (i5 * i6);
                    }
                    this.timerEmpty++;
                    Bitmap circleBitmap = getCircleBitmap((int) (this.radiusMax * ((((float) this.timerEmpty) * ((float) this.frameRate)) / ((float) this.durationEmpty))));
                    canvas.drawBitmap(circleBitmap, 0.0f, 0.0f, this.paint);
                    circleBitmap.recycle();
                }
            }
            this.paint.setColor(this.rippleColor);
            if (this.rippleType.intValue() == 1) {
                int i8 = this.frameRate;
                if ((((float) this.timer) * ((float) i8)) / ((float) this.rippleDuration) > 0.6f) {
                    Paint paint2 = this.paint;
                    int i9 = this.rippleAlpha;
                    paint2.setAlpha((int) (((float) i9) - (((float) i9) * ((((float) this.timerEmpty) * ((float) i8)) / ((float) this.durationEmpty)))));
                } else {
                    this.paint.setAlpha(this.rippleAlpha);
                }
            } else {
                Paint paint3 = this.paint;
                int i10 = this.rippleAlpha;
                paint3.setAlpha((int) (((float) i10) - (((float) i10) * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)))));
            }
            this.timer++;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.WIDTH = i2;
        this.HEIGHT = i3;
        float f2 = this.zoomScale;
        this.scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, (float) (i2 / 2), (float) (i3 / 2));
        this.scaleAnimation.setDuration((long) this.zoomDuration);
        this.scaleAnimation.setRepeatMode(2);
        this.scaleAnimation.setRepeatCount(1);
    }

    public void animateRipple(MotionEvent motionEvent) {
        createAnimation(motionEvent.getX(), motionEvent.getY());
    }

    public void animateRipple(float f2, float f3) {
        createAnimation(f2, f3);
    }

    private void createAnimation(float f2, float f3) {
        if (isEnabled() && !this.animationRunning) {
            if (this.hasToZoom.booleanValue()) {
                startAnimation(this.scaleAnimation);
            }
            this.radiusMax = (float) Math.max(this.WIDTH, this.HEIGHT);
            if (this.rippleType.intValue() != 2) {
                this.radiusMax /= 2.0f;
            }
            this.radiusMax -= (float) this.ripplePadding;
            if (this.isCentered.booleanValue() || this.rippleType.intValue() == 1) {
                this.x = (float) (getMeasuredWidth() / 2);
                this.y = (float) (getMeasuredHeight() / 2);
            } else {
                this.x = f2;
                this.y = f3;
            }
            this.animationRunning = true;
            if (this.rippleType.intValue() == 1 && this.originBitmap == null) {
                this.originBitmap = getDrawingCache(true);
            }
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gestureDetector.onTouchEvent(motionEvent)) {
            animateRipple(motionEvent);
            sendClickEvent(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void sendClickEvent(Boolean bool) {
        if (getParent() instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) getParent();
            int positionForView = adapterView.getPositionForView(this);
            long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
            if (bool.booleanValue()) {
                if (adapterView.getOnItemLongClickListener() != null) {
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition);
                }
            } else if (adapterView.getOnItemClickListener() != null) {
                adapterView.getOnItemClickListener().onItemClick(adapterView, this, positionForView, itemIdAtPosition);
            }
        }
    }

    private Bitmap getCircleBitmap(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(this.originBitmap.getWidth(), this.originBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        float f2 = this.x;
        float f3 = (float) i2;
        float f4 = this.y;
        Rect rect = new Rect((int) (f2 - f3), (int) (f4 - f3), (int) (f2 + f3), (int) (f4 + f3));
        paint2.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.x, this.y, f3, paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.originBitmap, rect, rect, paint2);
        return createBitmap;
    }

    public void setRippleColor(int i2) {
        this.rippleColor = getResources().getColor(i2);
    }

    public int getRippleColor() {
        return this.rippleColor;
    }

    public RippleType getRippleType() {
        return RippleType.values()[this.rippleType.intValue()];
    }

    public void setRippleType(RippleType rippleType2) {
        this.rippleType = Integer.valueOf(rippleType2.ordinal());
    }

    public Boolean isCentered() {
        return this.isCentered;
    }

    public void setCentered(Boolean bool) {
        this.isCentered = bool;
    }

    public int getRipplePadding() {
        return this.ripplePadding;
    }

    public void setRipplePadding(int i2) {
        this.ripplePadding = i2;
    }

    public Boolean isZooming() {
        return this.hasToZoom;
    }

    public void setZooming(Boolean bool) {
        this.hasToZoom = bool;
    }

    public float getZoomScale() {
        return this.zoomScale;
    }

    public void setZoomScale(float f2) {
        this.zoomScale = f2;
    }

    public int getZoomDuration() {
        return this.zoomDuration;
    }

    public void setZoomDuration(int i2) {
        this.zoomDuration = i2;
    }

    public int getRippleDuration() {
        return this.rippleDuration;
    }

    public void setRippleDuration(int i2) {
        this.rippleDuration = i2;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public void setFrameRate(int i2) {
        this.frameRate = i2;
    }

    public int getRippleAlpha() {
        return this.rippleAlpha;
    }

    public void setRippleAlpha(int i2) {
        this.rippleAlpha = i2;
    }

    public void setOnRippleCompleteListener(OnRippleCompleteListener onRippleCompleteListener) {
        this.onCompletionListener = onRippleCompleteListener;
    }

    public enum RippleType {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);
        
        int type;

        private RippleType(int i2) {
            this.type = i2;
        }
    }
}
