package net.one97.paytm.coins.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.a.a.a;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.squareup.picasso.aa;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import kotlin.g.b.k;

public final class RoundedImageView extends View implements af {

    /* renamed from: a  reason: collision with root package name */
    public View f16735a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f16736b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16737c;

    /* renamed from: d  reason: collision with root package name */
    private Float f16738d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f16738d = Float.valueOf(0.0f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoundedImageView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    private final void setMdrawable(Drawable drawable) {
        this.f16736b = drawable;
        postInvalidate();
    }

    public final View getView() {
        View view = this.f16735a;
        if (view == null) {
            k.a("view");
        }
        return view;
    }

    public final void setView(View view) {
        k.c(view, "<set-?>");
        this.f16735a = view;
    }

    public final void a(String str, Integer num, Integer num2, ImageView.ScaleType scaleType, Float f2, View view, boolean z) {
        int i2;
        Drawable b2;
        Drawable b3;
        k.c(view, "view");
        if (str == null) {
            setMdrawable((Drawable) null);
            return;
        }
        this.f16735a = view;
        this.f16737c = z;
        this.f16738d = f2;
        aa a2 = w.a().a(str);
        if (a2 != null) {
            if (!(num == null || (b3 = a.b(getContext(), num.intValue())) == null)) {
                a2.a(b3);
            }
            if (!(num2 == null || (b2 = a.b(getContext(), num2.intValue())) == null)) {
                a2.b(b2);
            }
            if (!(scaleType == null || (i2 = b.f16753a[scaleType.ordinal()]) == 1 || i2 != 2)) {
                a2.d();
                a2.a(getMeasuredWidth(), getMeasuredWidth());
            }
            a2.a((af) this);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Drawable drawable = this.f16736b;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
        Drawable drawable2 = this.f16736b;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void onPrepareLoad(Drawable drawable) {
        setMdrawable(drawable);
    }

    public final void onBitmapFailed(Exception exc, Drawable drawable) {
        setMdrawable(drawable);
    }

    public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
        b a2 = d.a(getResources(), bitmap);
        k.a((Object) a2, "RoundedBitmapDrawableFac…create(resources, bitmap)");
        Float f2 = this.f16738d;
        a2.a(f2 != null ? f2.floatValue() : 0.0f);
        setMdrawable(a2);
        if (this.f16737c) {
            View view = this.f16735a;
            if (view == null) {
                k.a("view");
            }
            view.setVisibility(0);
            return;
        }
        View view2 = this.f16735a;
        if (view2 == null) {
            k.a("view");
        }
        view2.setVisibility(8);
    }
}
