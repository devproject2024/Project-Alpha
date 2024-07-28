package net.one97.paytm.coins.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout;

public final class ScratchableRoundImageView extends CustomScratchableRelativeLayout implements af {

    /* renamed from: a  reason: collision with root package name */
    private a<x> f16739a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f16740b;

    /* renamed from: c  reason: collision with root package name */
    private Float f16741c;

    public final void setImageLoadListner(a<x> aVar) {
        k.c(aVar, "listner");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScratchableRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f16741c = Float.valueOf(0.0f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScratchableRoundImageView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    private final void setMdrawable(Drawable drawable) {
        this.f16740b = drawable;
        postInvalidate();
    }

    public final void onDraw(Canvas canvas) {
        Drawable drawable = this.f16740b;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
        Drawable drawable2 = this.f16740b;
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
        Float f2 = this.f16741c;
        a2.a(f2 != null ? f2.floatValue() : 0.0f);
        setMdrawable(a2);
        a<x> aVar = this.f16739a;
        if (aVar != null) {
            aVar.invoke();
        }
    }
}
