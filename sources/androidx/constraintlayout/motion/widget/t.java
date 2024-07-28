package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

final class t {
    private static final float[][] v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a  reason: collision with root package name */
    int f2421a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f2422b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2423c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f2424d = -1;

    /* renamed from: e  reason: collision with root package name */
    float f2425e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    float f2426f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    float f2427g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    float f2428h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    boolean f2429i = false;
    float[] j = new float[2];
    float k;
    float l;
    final MotionLayout m;
    float n = 4.0f;
    float o = 1.2f;
    boolean p = true;
    float q = 1.0f;
    int r = 0;
    float s = 10.0f;
    private int t = 0;
    private int u = 0;

    t(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.m = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnSwipe);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public final void a(boolean z) {
        if (z) {
            float[][] fArr = w;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = v;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = w;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = v;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = v;
        int i2 = this.t;
        this.f2426f = fArr5[i2][0];
        this.f2425e = fArr5[i2][1];
        float[][] fArr6 = w;
        int i3 = this.u;
        this.f2427g = fArr6[i3][0];
        this.f2428h = fArr6[i3][1];
    }

    private void a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f2422b = typedArray.getResourceId(index, this.f2422b);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                this.t = typedArray.getInt(index, this.t);
                float[][] fArr = v;
                int i3 = this.t;
                this.f2426f = fArr[i3][0];
                this.f2425e = fArr[i3][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                this.u = typedArray.getInt(index, this.u);
                float[][] fArr2 = w;
                int i4 = this.u;
                this.f2427g = fArr2[i4][0];
                this.f2428h = fArr2[i4][1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.n = typedArray.getFloat(index, this.n);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.o = typedArray.getFloat(index, this.o);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.p = typedArray.getBoolean(index, this.p);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.q = typedArray.getFloat(index, this.q);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.s = typedArray.getFloat(index, this.s);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f2423c = typedArray.getResourceId(index, this.f2423c);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f2421a = typedArray.getInt(index, this.f2421a);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.r = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f2424d = typedArray.getResourceId(index, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        View view;
        int i2 = this.f2422b;
        if (i2 != -1) {
            view = this.m.findViewById(i2);
            if (view == null) {
                new StringBuilder("cannot find TouchAnchorId @id/").append(a.a(this.m.getContext(), this.f2422b));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f2423c;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public final String toString() {
        return this.f2427g + " , " + this.f2428h;
    }
}
