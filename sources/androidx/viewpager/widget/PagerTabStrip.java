package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: g  reason: collision with root package name */
    private int f4939g;

    /* renamed from: h  reason: collision with root package name */
    private int f4940h;

    /* renamed from: i  reason: collision with root package name */
    private int f4941i;
    private int j;
    private int k;
    private int l;
    private final Paint m;
    private final Rect n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private float t;
    private float u;
    private int v;

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new Paint();
        this.n = new Rect();
        this.o = PriceRangeSeekBar.INVALID_POINTER_ID;
        this.p = false;
        this.q = false;
        this.f4939g = this.f4949f;
        this.m.setColor(this.f4939g);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f4940h = (int) ((3.0f * f2) + 0.5f);
        this.f4941i = (int) ((6.0f * f2) + 0.5f);
        this.j = (int) (64.0f * f2);
        this.l = (int) ((16.0f * f2) + 0.5f);
        this.r = (int) ((1.0f * f2) + 0.5f);
        this.k = (int) ((f2 * 32.0f) + 0.5f);
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4945b.setFocusable(true);
        this.f4945b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PagerTabStrip.this.f4944a.setCurrentItem(PagerTabStrip.this.f4944a.getCurrentItem() - 1);
            }
        });
        this.f4947d.setFocusable(true);
        this.f4947d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PagerTabStrip.this.f4944a.setCurrentItem(PagerTabStrip.this.f4944a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.p = true;
        }
    }

    public void setTabIndicatorColor(int i2) {
        this.f4939g = i2;
        this.m.setColor(this.f4939g);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        setTabIndicatorColor(b.c(getContext(), i2));
    }

    public int getTabIndicatorColor() {
        return this.f4939g;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.f4941i;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTextSpacing(int i2) {
        int i3 = this.j;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.q) {
            this.p = drawable == null;
        }
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (!this.q) {
            this.p = (i2 & -16777216) == 0;
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (!this.q) {
            this.p = i2 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.p = z;
        this.q = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.s) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.t = x;
            this.u = y;
            this.s = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.t) > ((float) this.v) || Math.abs(y - this.u) > ((float) this.v))) {
                this.s = true;
            }
        } else if (x < ((float) (this.f4946c.getLeft() - this.l))) {
            this.f4944a.setCurrentItem(this.f4944a.getCurrentItem() - 1);
        } else if (x > ((float) (this.f4946c.getRight() + this.l))) {
            this.f4944a.setCurrentItem(this.f4944a.getCurrentItem() + 1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4946c.getLeft() - this.l;
        int right = this.f4946c.getRight() + this.l;
        this.m.setColor((this.o << 24) | (this.f4939g & 16777215));
        float f2 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.f4940h), (float) right, f2, this.m);
        if (this.p) {
            this.m.setColor(-16777216 | (this.f4939g & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.r), (float) (getWidth() - getPaddingRight()), f2, this.m);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2, boolean z) {
        Rect rect = this.n;
        int height = getHeight();
        int left = this.f4946c.getLeft() - this.l;
        int right = this.f4946c.getRight() + this.l;
        int i3 = height - this.f4940h;
        rect.set(left, i3, right, height);
        super.a(i2, f2, z);
        this.o = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4946c.getLeft() - this.l, i3, this.f4946c.getRight() + this.l, height);
        invalidate(rect);
    }
}
