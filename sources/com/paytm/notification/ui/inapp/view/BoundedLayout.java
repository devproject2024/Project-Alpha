package com.paytm.notification.ui.inapp.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import com.paytm.notification.R;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BoundedLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f43362a;

    /* renamed from: b  reason: collision with root package name */
    private int f43363b;

    /* renamed from: c  reason: collision with root package name */
    private float f43364c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f43365d;

    /* renamed from: e  reason: collision with root package name */
    private Path f43366e;

    public BoundedLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public BoundedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        a(context, attributeSet, i2, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BoundedLayout(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        a(context, attributeSet, i2, i3);
    }

    private final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.UrbanAirshipLayout, i2, i3);
            k.a((Object) obtainStyledAttributes, "context.theme.obtainStyl…t, defStyle, defResStyle)");
            this.f43362a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxWidth, 0);
            this.f43363b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UrbanAirshipLayout_urbanAirshipMaxHeight, 0);
            obtainStyledAttributes.recycle();
        }
        if (Build.VERSION.SDK_INT < 21) {
            this.f43366e = new Path();
            this.f43365d = new RectF();
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.f43362a;
        if (i4 > 0 && i4 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, View.MeasureSpec.getMode(i2));
        }
        int i5 = this.f43363b;
        if (i5 > 0 && i5 < size2) {
            i3 = View.MeasureSpec.makeMeasureSpec(i5, View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z && this.f43364c > 0.0f && Build.VERSION.SDK_INT < 21 && this.f43365d != null) {
            Path path = this.f43366e;
            if (path == null) {
                k.a();
            }
            path.reset();
            RectF rectF = this.f43365d;
            if (rectF == null) {
                k.a();
            }
            rectF.set(0.0f, 0.0f, (float) (i4 - i2), (float) (i5 - i3));
            float f2 = this.f43364c;
            float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
            Path path2 = this.f43366e;
            if (path2 == null) {
                k.a();
            }
            RectF rectF2 = this.f43365d;
            if (rectF2 == null) {
                k.a();
            }
            path2.addRoundRect(rectF2, fArr, Path.Direction.CW);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        k.c(canvas, "canvas");
        if (Build.VERSION.SDK_INT < 21 && this.f43364c != 0.0f) {
            Path path = this.f43366e;
            if (path == null) {
                k.a();
            }
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    public final void setClipPathBorderRadius(float f2) {
        Resources resources = getResources();
        k.a((Object) resources, "resources");
        float applyDimension = TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 21) {
            this.f43364c = applyDimension;
        } else if (applyDimension == 0.0f) {
            setClipToOutline(false);
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        } else {
            setClipToOutline(true);
            setOutlineProvider(new a(applyDimension));
        }
    }

    public static final class a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f43367a;

        a(float f2) {
            this.f43367a = f2;
        }

        public final void getOutline(View view, Outline outline) {
            k.c(view, "view");
            k.c(outline, "outline");
            outline.setRoundRect(0, 0, view.getRight() - view.getLeft(), view.getBottom() - view.getTop(), this.f43367a);
        }
    }
}
