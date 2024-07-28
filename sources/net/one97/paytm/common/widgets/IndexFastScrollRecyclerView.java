package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class IndexFastScrollRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    public int f49852a = 12;

    /* renamed from: b  reason: collision with root package name */
    public float f49853b = 20.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f49854c = 5.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f49855d = 5;

    /* renamed from: e  reason: collision with root package name */
    public int f49856e = 5;

    /* renamed from: f  reason: collision with root package name */
    public float f49857f = 0.6f;

    /* renamed from: g  reason: collision with root package name */
    public String f49858g = "#000000";

    /* renamed from: h  reason: collision with root package name */
    public String f49859h = "#FFFFFF";

    /* renamed from: i  reason: collision with root package name */
    public String f49860i = "#000000";
    private k j = null;
    private GestureDetector k = null;
    private boolean l = true;

    public IndexFastScrollRecyclerView(Context context) {
        super(context);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.j = new k(context, this);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndexFastScrollRecyclerView, 0, 0)) != null) {
            try {
                this.f49852a = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexTextSize, this.f49852a);
                this.f49853b = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarWidth, this.f49853b);
                this.f49854c = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarMargin, this.f49854c);
                this.f49855d = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setPreviewPadding, this.f49855d);
                this.f49856e = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexBarCornerRadius, this.f49856e);
                this.f49857f = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexBarTransparentValue, this.f49857f);
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor) != null) {
                    this.f49858g = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor);
                }
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor) != null) {
                    this.f49859h = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor);
                }
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor) != null) {
                    this.f49860i = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        k kVar = this.j;
        if (kVar != null && kVar.q.booleanValue()) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(kVar.s));
            paint.setAlpha(kVar.v);
            paint.setAntiAlias(true);
            canvas.drawRoundRect(kVar.k, ((float) kVar.o) * kVar.f49927d, ((float) kVar.o) * kVar.f49927d, paint);
            if (kVar.j != null && kVar.j.length > 0) {
                if (kVar.n && kVar.f49931h >= 0 && kVar.j[kVar.f49931h] != "") {
                    Paint paint2 = new Paint();
                    paint2.setColor(-16777216);
                    paint2.setAlpha(96);
                    paint2.setAntiAlias(true);
                    paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                    Paint paint3 = new Paint();
                    paint3.setColor(-1);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(kVar.f49928e * 50.0f);
                    paint3.setTypeface(kVar.p);
                    float measureText = paint3.measureText(kVar.j[kVar.f49931h]);
                    float descent = ((kVar.f49926c * 2.0f) + paint3.descent()) - paint3.ascent();
                    RectF rectF = new RectF((((float) kVar.f49929f) - descent) / 2.0f, (((float) kVar.f49930g) - descent) / 2.0f, ((((float) kVar.f49929f) - descent) / 2.0f) + descent, ((((float) kVar.f49930g) - descent) / 2.0f) + descent);
                    canvas.drawRoundRect(rectF, kVar.f49927d * 5.0f, kVar.f49927d * 5.0f, paint2);
                    canvas.drawText(kVar.j[kVar.f49931h], (rectF.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF.top + kVar.f49926c) - paint3.ascent()) + 1.0f, paint3);
                    kVar.w.removeMessages(0);
                    kVar.w.sendEmptyMessageAtTime(1, SystemClock.uptimeMillis() + 300);
                }
                Paint paint4 = new Paint();
                paint4.setColor(Color.parseColor(kVar.t));
                paint4.setAntiAlias(true);
                paint4.setTextSize(((float) kVar.l) * kVar.f49928e);
                paint4.setTypeface(kVar.p);
                float height = (kVar.k.height() - (kVar.f49925b * 2.0f)) / 26.0f;
                float descent2 = (height - (paint4.descent() - paint4.ascent())) / 2.0f;
                for (int i2 = 0; i2 < kVar.j.length; i2++) {
                    if (kVar.r.booleanValue()) {
                        if (kVar.f49931h < 0 || i2 != kVar.f49931h) {
                            paint4.setTypeface(kVar.p);
                            paint4.setTextSize(((float) kVar.l) * kVar.f49928e);
                            paint4.setColor(Color.parseColor(kVar.t));
                        } else {
                            paint4.setTypeface(Typeface.create(kVar.p, 1));
                            paint4.setTextSize(((float) (kVar.l + 3)) * kVar.f49928e);
                            paint4.setColor(Color.parseColor(kVar.u));
                        }
                        canvas.drawText(kVar.j[i2], kVar.k.left + ((kVar.f49924a - paint4.measureText(kVar.j[i2])) / 2.0f), (((kVar.k.top + kVar.f49925b) + (((float) i2) * height)) + descent2) - paint4.ascent(), paint4);
                    } else {
                        canvas.drawText(kVar.j[i2], kVar.k.left + ((kVar.f49924a - paint4.measureText(kVar.j[i2])) / 2.0f), (((kVar.k.top + kVar.f49925b) + (((float) i2) * height)) + descent2) - paint4.ascent(), paint4);
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.l) {
            k kVar = this.j;
            if (kVar != null && kVar.a(motionEvent)) {
                return true;
            }
            if (this.k == null) {
                this.k = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                        return super.onFling(motionEvent, motionEvent2, f2, f3);
                    }
                });
            }
            this.k.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k kVar;
        if (!this.l || (kVar = this.j) == null || !kVar.a(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAdapter(RecyclerView.a aVar) {
        super.setAdapter(aVar);
        k kVar = this.j;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        k kVar = this.j;
        if (kVar != null) {
            kVar.f49929f = i2;
            kVar.f49930g = i3;
            float f2 = (float) i2;
            kVar.k = new RectF((f2 - kVar.f49925b) - kVar.f49924a, 150.0f, f2 - kVar.f49925b, ((float) i3) - kVar.f49925b);
        }
    }

    public void setIndexTextSize(int i2) {
        this.j.l = i2;
    }

    public void setIndexbarWidth(float f2) {
        this.j.f49924a = f2;
    }

    public void setIndexbarMargin(float f2) {
        this.j.f49925b = f2;
    }

    public void setPreviewPadding(int i2) {
        this.j.m = i2;
    }

    public void setIndexBarCornerRadius(int i2) {
        this.j.o = i2;
    }

    public void setIndexBarTransparentValue(float f2) {
        this.j.v = (int) (f2 * 255.0f);
    }

    public void setTypeface(Typeface typeface) {
        this.j.p = typeface;
    }

    public void setIndexBarVisibility(boolean z) {
        this.j.q = Boolean.valueOf(z);
        this.l = z;
    }

    public void setPreviewVisibility(boolean z) {
        this.j.n = z;
    }

    public void setIndexBarColor(String str) {
        this.j.s = str;
    }

    public void setIndexBarTextColor(String str) {
        this.j.t = str;
    }

    public void setIndexbarHighLateTextColor(String str) {
        this.j.u = str;
    }

    public void setIndexBarHighLateTextVisibility(boolean z) {
        this.j.r = Boolean.valueOf(z);
    }
}
