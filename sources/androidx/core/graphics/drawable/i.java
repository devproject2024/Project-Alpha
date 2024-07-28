package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class i extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f3013a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f3014b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f3015c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f3016d = g.f3005a;

    i(i iVar) {
        if (iVar != null) {
            this.f3013a = iVar.f3013a;
            this.f3014b = iVar.f3014b;
            this.f3015c = iVar.f3015c;
            this.f3016d = iVar.f3016d;
        }
    }

    public final Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public final Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new h(this, resources);
        }
        return new g(this, resources);
    }

    public final int getChangingConfigurations() {
        int i2 = this.f3013a;
        Drawable.ConstantState constantState = this.f3014b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }
}
