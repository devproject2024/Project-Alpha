package com.google.android.material.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.h.c;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.k.f;
import com.google.android.material.k.g;
import com.google.android.material.k.h;
import com.google.android.material.k.j;
import com.google.android.material.k.m;
import easypay.manager.Constants;

public class a extends h implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36608a = R.style.Widget_MaterialComponents_Tooltip;

    /* renamed from: b  reason: collision with root package name */
    private static final int f36609b = R.attr.tooltipStyle;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f36610c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f36611d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint.FontMetrics f36612e = new Paint.FontMetrics();

    /* renamed from: f  reason: collision with root package name */
    private final i f36613f = new i(this);

    /* renamed from: g  reason: collision with root package name */
    private final View.OnLayoutChangeListener f36614g = new View.OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.c(view);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Rect f36615h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private int f36616i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public static a a(Context context, int i2) {
        Class<a> cls = a.class;
        a aVar = new a(context, i2);
        TypedArray a2 = k.a(aVar.f36611d, (AttributeSet) null, R.styleable.Tooltip, 0, i2, new int[0]);
        aVar.m = aVar.f36611d.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        m.a b2 = aVar.G.f36536a.b();
        b2.k = aVar.c();
        aVar.setShapeAppearanceModel(b2.a());
        aVar.a(a2.getText(R.styleable.Tooltip_android_text));
        aVar.f36613f.a(c.c(aVar.f36611d, a2, R.styleable.Tooltip_android_textAppearance), aVar.f36611d);
        int a3 = b.a(aVar.f36611d, R.attr.colorOnBackground, cls.getCanonicalName());
        aVar.g(ColorStateList.valueOf(a2.getColor(R.styleable.Tooltip_backgroundTint, androidx.core.graphics.a.a(androidx.core.graphics.a.b(a3, Constants.ACTION_REMOVE_NB_LAYOUT), androidx.core.graphics.a.b(b.a(aVar.f36611d, 16842801, cls.getCanonicalName()), 229)))));
        aVar.h(ColorStateList.valueOf(b.a(aVar.f36611d, R.attr.colorSurface, cls.getCanonicalName())));
        aVar.f36616i = a2.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        aVar.j = a2.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        aVar.k = a2.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        aVar.l = a2.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        a2.recycle();
        return aVar;
    }

    private a(Context context, int i2) {
        super(context, (AttributeSet) null, 0, i2);
        this.f36611d = context;
        this.f36613f.f36480a.density = context.getResources().getDisplayMetrics().density;
        this.f36613f.f36480a.setTextAlign(Paint.Align.CENTER);
    }

    public final void a(CharSequence charSequence) {
        if (!TextUtils.equals(this.f36610c, charSequence)) {
            this.f36610c = charSequence;
            this.f36613f.f36481b = true;
            invalidateSelf();
        }
    }

    public final void a(View view) {
        if (view != null) {
            c(view);
            view.addOnLayoutChangeListener(this.f36614g);
        }
    }

    public final void b(View view) {
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f36614g);
        }
    }

    public int getIntrinsicWidth() {
        float f2;
        float f3 = (float) (this.f36616i * 2);
        CharSequence charSequence = this.f36610c;
        if (charSequence == null) {
            f2 = 0.0f;
        } else {
            f2 = this.f36613f.a(charSequence.toString());
        }
        return (int) Math.max(f3 + f2, (float) this.j);
    }

    public int getIntrinsicHeight() {
        return (int) Math.max(this.f36613f.f36480a.getTextSize(), (float) this.k);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(b(), (float) (-((((double) this.m) * Math.sqrt(2.0d)) - ((double) this.m))));
        super.draw(canvas);
        if (this.f36610c != null) {
            Rect bounds = getBounds();
            this.f36613f.f36480a.getFontMetrics(this.f36612e);
            int centerY = (int) (((float) bounds.centerY()) - ((this.f36612e.descent + this.f36612e.ascent) / 2.0f));
            if (this.f36613f.f36483d != null) {
                this.f36613f.f36480a.drawableState = getState();
                this.f36613f.a(this.f36611d);
            }
            CharSequence charSequence = this.f36610c;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) centerY, this.f36613f.f36480a);
        }
        canvas.restore();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m.a b2 = this.G.f36536a.b();
        b2.k = c();
        setShapeAppearanceModel(b2.a());
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final void a() {
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.n = iArr[0];
        view.getWindowVisibleDisplayFrame(this.f36615h);
    }

    private float b() {
        int i2;
        if (((this.f36615h.right - getBounds().right) - this.n) - this.l < 0) {
            i2 = ((this.f36615h.right - getBounds().right) - this.n) - this.l;
        } else if (((this.f36615h.left - getBounds().left) - this.n) + this.l <= 0) {
            return 0.0f;
        } else {
            i2 = ((this.f36615h.left - getBounds().left) - this.n) + this.l;
        }
        return (float) i2;
    }

    private f c() {
        float width = ((float) (((double) getBounds().width()) - (((double) this.m) * Math.sqrt(2.0d)))) / 2.0f;
        return new j(new g((float) this.m), Math.min(Math.max(-b(), -width), width));
    }
}
