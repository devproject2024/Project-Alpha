package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.h.c;
import com.google.android.material.h.d;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.k.h;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.ref.WeakReference;

public final class BadgeDrawable extends Drawable implements i.a {

    /* renamed from: b  reason: collision with root package name */
    private static final int f35881b = R.style.Widget_MaterialComponents_Badge;

    /* renamed from: c  reason: collision with root package name */
    private static final int f35882c = R.attr.badgeStyle;

    /* renamed from: a  reason: collision with root package name */
    final SavedState f35883a;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<Context> f35884d;

    /* renamed from: e  reason: collision with root package name */
    private final h f35885e = new h();

    /* renamed from: f  reason: collision with root package name */
    private final i f35886f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f35887g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private final float f35888h;

    /* renamed from: i  reason: collision with root package name */
    private final float f35889i;
    private final float j;
    private float k;
    private float l;
    private int m;
    private float n;
    private float o;
    private float p;
    private WeakReference<View> q;
    private WeakReference<ViewGroup> r;

    public final int getOpacity() {
        return -3;
    }

    public final boolean isStateful() {
        return false;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f35890a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f35891b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f35892c = PriceRangeSeekBar.INVALID_POINTER_ID;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f35893d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f35894e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f35895f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f35896g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f35897h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f35898i;
        /* access modifiers changed from: private */
        public int j;
        /* access modifiers changed from: private */
        public int k;

        public final int describeContents() {
            return 0;
        }

        public SavedState(Context context) {
            this.f35891b = new d(context, R.style.TextAppearance_MaterialComponents_Badge).f36363b.getDefaultColor();
            this.f35895f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.f35896g = R.plurals.mtrl_badge_content_description;
            this.f35897h = R.string.mtrl_exceed_max_badge_number_content_description;
        }

        protected SavedState(Parcel parcel) {
            this.f35890a = parcel.readInt();
            this.f35891b = parcel.readInt();
            this.f35892c = parcel.readInt();
            this.f35893d = parcel.readInt();
            this.f35894e = parcel.readInt();
            this.f35895f = parcel.readString();
            this.f35896g = parcel.readInt();
            this.f35898i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f35890a);
            parcel.writeInt(this.f35891b);
            parcel.writeInt(this.f35892c);
            parcel.writeInt(this.f35893d);
            parcel.writeInt(this.f35894e);
            parcel.writeString(this.f35895f.toString());
            parcel.writeInt(this.f35896g);
            parcel.writeInt(this.f35898i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }
    }

    static BadgeDrawable a(Context context, SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.d(savedState.f35894e);
        if (savedState.f35893d != -1) {
            badgeDrawable.c(savedState.f35893d);
        }
        badgeDrawable.a(savedState.f35890a);
        badgeDrawable.b(savedState.f35891b);
        badgeDrawable.e(savedState.f35898i);
        badgeDrawable.f(savedState.j);
        badgeDrawable.g(savedState.k);
        return badgeDrawable;
    }

    public static BadgeDrawable a(Context context) {
        int i2 = f35882c;
        int i3 = f35881b;
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        TypedArray a2 = k.a(context, (AttributeSet) null, R.styleable.Badge, i2, i3, new int[0]);
        badgeDrawable.d(a2.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (a2.hasValue(R.styleable.Badge_number)) {
            badgeDrawable.c(a2.getInt(R.styleable.Badge_number, 0));
        }
        badgeDrawable.a(a(context, a2, R.styleable.Badge_backgroundColor));
        if (a2.hasValue(R.styleable.Badge_badgeTextColor)) {
            badgeDrawable.b(a(context, a2, R.styleable.Badge_badgeTextColor));
        }
        badgeDrawable.e(a2.getInt(R.styleable.Badge_badgeGravity, 8388661));
        badgeDrawable.f(a2.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        badgeDrawable.g(a2.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        a2.recycle();
        return badgeDrawable;
    }

    private static int a(Context context, TypedArray typedArray, int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    private BadgeDrawable(Context context) {
        d dVar;
        Context context2;
        this.f35884d = new WeakReference<>(context);
        k.b(context);
        Resources resources = context.getResources();
        this.f35888h = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.j = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f35889i = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        this.f35886f = new i(this);
        this.f35886f.f36480a.setTextAlign(Paint.Align.CENTER);
        this.f35883a = new SavedState(context);
        int i2 = R.style.TextAppearance_MaterialComponents_Badge;
        Context context3 = (Context) this.f35884d.get();
        if (context3 != null && this.f35886f.f36483d != (dVar = new d(context3, i2)) && (context2 = (Context) this.f35884d.get()) != null) {
            this.f35886f.a(dVar, context2);
            e();
        }
    }

    public final void a(View view, ViewGroup viewGroup) {
        this.q = new WeakReference<>(view);
        this.r = new WeakReference<>(viewGroup);
        e();
        invalidateSelf();
    }

    private void a(int i2) {
        int unused = this.f35883a.f35890a = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.f35885e.G.f36539d != valueOf) {
            this.f35885e.g(valueOf);
            invalidateSelf();
        }
    }

    private void b(int i2) {
        int unused = this.f35883a.f35891b = i2;
        if (this.f35886f.f36480a.getColor() != i2) {
            this.f35886f.f36480a.setColor(i2);
            invalidateSelf();
        }
    }

    private boolean c() {
        return this.f35883a.f35893d != -1;
    }

    private int d() {
        if (!c()) {
            return 0;
        }
        return this.f35883a.f35893d;
    }

    private void c(int i2) {
        int max = Math.max(0, i2);
        if (this.f35883a.f35893d != max) {
            int unused = this.f35883a.f35893d = max;
            this.f35886f.f36481b = true;
            e();
            invalidateSelf();
        }
    }

    private void d(int i2) {
        if (this.f35883a.f35894e != i2) {
            int unused = this.f35883a.f35894e = i2;
            g();
            this.f35886f.f36481b = true;
            e();
            invalidateSelf();
        }
    }

    private void e(int i2) {
        if (this.f35883a.f35898i != i2) {
            int unused = this.f35883a.f35898i = i2;
            WeakReference<View> weakReference = this.q;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.q.get();
                WeakReference<ViewGroup> weakReference2 = this.r;
                a(view, weakReference2 != null ? (ViewGroup) weakReference2.get() : null);
            }
        }
    }

    public final int getAlpha() {
        return this.f35883a.f35892c;
    }

    public final void setAlpha(int i2) {
        int unused = this.f35883a.f35892c = i2;
        this.f35886f.f36480a.setAlpha(i2);
        invalidateSelf();
    }

    public final int getIntrinsicHeight() {
        return this.f35887g.height();
    }

    public final int getIntrinsicWidth() {
        return this.f35887g.width();
    }

    public final void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f35885e.draw(canvas);
            if (c()) {
                Rect rect = new Rect();
                String f2 = f();
                this.f35886f.f36480a.getTextBounds(f2, 0, f2.length(), rect);
                canvas.drawText(f2, this.k, this.l + ((float) (rect.height() / 2)), this.f35886f.f36480a);
            }
        }
    }

    public final void a() {
        invalidateSelf();
    }

    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final CharSequence b() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!c()) {
            return this.f35883a.f35895f;
        }
        if (this.f35883a.f35896g <= 0 || (context = (Context) this.f35884d.get()) == null) {
            return null;
        }
        if (d() <= this.m) {
            return context.getResources().getQuantityString(this.f35883a.f35896g, d(), new Object[]{Integer.valueOf(d())});
        }
        return context.getString(this.f35883a.f35897h, new Object[]{Integer.valueOf(this.m)});
    }

    private void f(int i2) {
        int unused = this.f35883a.j = i2;
        e();
    }

    private void g(int i2) {
        int unused = this.f35883a.k = i2;
        e();
    }

    private void e() {
        Context context = (Context) this.f35884d.get();
        WeakReference<View> weakReference = this.q;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f35887g);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<ViewGroup> weakReference2 = this.r;
            if (weakReference2 != null) {
                viewGroup = (ViewGroup) weakReference2.get();
            }
            if (viewGroup != null || a.f35899a) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            a(context, rect2, view);
            a.a(this.f35887g, this.k, this.l, this.o, this.p);
            this.f35885e.o(this.n);
            if (!rect.equals(this.f35887g)) {
                this.f35885e.setBounds(this.f35887g);
            }
        }
    }

    private void a(Context context, Rect rect, View view) {
        float f2;
        float f3;
        int e2 = this.f35883a.f35898i;
        if (e2 == 8388691 || e2 == 8388693) {
            this.l = (float) (rect.bottom - this.f35883a.k);
        } else {
            this.l = (float) (rect.top + this.f35883a.k);
        }
        if (d() <= 9) {
            this.n = !c() ? this.f35888h : this.f35889i;
            float f4 = this.n;
            this.p = f4;
            this.o = f4;
        } else {
            this.n = this.f35889i;
            this.p = this.n;
            this.o = (this.f35886f.a(f()) / 2.0f) + this.j;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(c() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int e3 = this.f35883a.f35898i;
        if (e3 == 8388659 || e3 == 8388691) {
            if (u.j(view) == 0) {
                f2 = (((float) rect.left) - this.o) + ((float) dimensionPixelSize) + ((float) this.f35883a.j);
            } else {
                f2 = ((((float) rect.right) + this.o) - ((float) dimensionPixelSize)) - ((float) this.f35883a.j);
            }
            this.k = f2;
            return;
        }
        if (u.j(view) == 0) {
            f3 = ((((float) rect.right) + this.o) - ((float) dimensionPixelSize)) - ((float) this.f35883a.j);
        } else {
            f3 = (((float) rect.left) - this.o) + ((float) dimensionPixelSize) + ((float) this.f35883a.j);
        }
        this.k = f3;
    }

    private String f() {
        if (d() <= this.m) {
            return Integer.toString(d());
        }
        Context context = (Context) this.f35884d.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.m), "+"});
    }

    private void g() {
        this.m = ((int) Math.pow(10.0d, ((double) this.f35883a.f35894e) - 1.0d)) - 1;
    }
}
