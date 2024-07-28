package com.google.android.material.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import androidx.core.content.b.f;
import com.google.android.material.R;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final float f36362a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f36363b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f36364c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f36365d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36366e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36367f;

    /* renamed from: g  reason: collision with root package name */
    public final String f36368g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36369h;

    /* renamed from: i  reason: collision with root package name */
    public final ColorStateList f36370i;
    public final float j;
    public final float k;
    public final float l;
    boolean m = false;
    Typeface n;
    private final int o;

    public d(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.f36362a = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f36363b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f36364c = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f36365d = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f36366e = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f36367f = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i3 = R.styleable.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? R.styleable.TextAppearance_android_fontFamily : i3;
        this.o = obtainStyledAttributes.getResourceId(i3, 0);
        this.f36368g = obtainStyledAttributes.getString(i3);
        this.f36369h = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f36370i = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.j = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.k = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.l = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private Typeface a(Context context) {
        Typeface typeface;
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                int i2 = this.o;
                if (context.isRestricted()) {
                    typeface = null;
                } else {
                    typeface = f.a(context, i2, new TypedValue(), 0, (f.a) null, false);
                }
                this.n = typeface;
                if (this.n != null) {
                    this.n = Typeface.create(this.n, this.f36366e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                new StringBuilder("Error loading font ").append(this.f36368g);
            }
        }
        b();
        this.m = true;
        return this.n;
    }

    private void c(Context context, final TextPaint textPaint, final f fVar) {
        a(textPaint, a());
        a(context, (f) new f() {
            public final void a(Typeface typeface, boolean z) {
                d.this.a(textPaint, typeface);
                fVar.a(typeface, z);
            }

            public final void a(int i2) {
                fVar.a(i2);
            }
        });
    }

    public final Typeface a() {
        b();
        return this.n;
    }

    private void b() {
        String str;
        if (this.n == null && (str = this.f36368g) != null) {
            this.n = Typeface.create(str, this.f36366e);
        }
        if (this.n == null) {
            int i2 = this.f36367f;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.f36366e);
        }
    }

    public final void a(Context context, TextPaint textPaint, f fVar) {
        b(context, textPaint, fVar);
        ColorStateList colorStateList = this.f36363b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, this.f36363b.getDefaultColor()) : -16777216);
        float f2 = this.l;
        float f3 = this.j;
        float f4 = this.k;
        ColorStateList colorStateList2 = this.f36370i;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, this.f36370i.getDefaultColor()) : 0);
    }

    public final void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f36366e;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f36362a);
    }

    public final void a(Context context, final f fVar) {
        if (e.f36376a) {
            a(context);
        } else {
            b();
        }
        if (this.o == 0) {
            this.m = true;
        }
        if (this.m) {
            fVar.a(this.n, true);
            return;
        }
        try {
            f.a(context, this.o, (f.a) new f.a() {
                public final void a(Typeface typeface) {
                    d dVar = d.this;
                    dVar.n = Typeface.create(typeface, dVar.f36366e);
                    d dVar2 = d.this;
                    dVar2.m = true;
                    fVar.a(dVar2.n, false);
                }

                public final void a(int i2) {
                    d.this.m = true;
                    fVar.a(i2);
                }
            });
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            fVar.a(1);
        } catch (Exception unused2) {
            new StringBuilder("Error loading font ").append(this.f36368g);
            this.m = true;
            fVar.a(-3);
        }
    }

    public final void b(Context context, TextPaint textPaint, f fVar) {
        if (e.f36376a) {
            a(textPaint, a(context));
        } else {
            c(context, textPaint, fVar);
        }
    }
}
