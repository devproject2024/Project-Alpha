package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

final class o {

    /* renamed from: a  reason: collision with root package name */
    boolean f4339a = true;

    /* renamed from: b  reason: collision with root package name */
    int f4340b;

    /* renamed from: c  reason: collision with root package name */
    int f4341c;

    /* renamed from: d  reason: collision with root package name */
    int f4342d;

    /* renamed from: e  reason: collision with root package name */
    int f4343e;

    /* renamed from: f  reason: collision with root package name */
    int f4344f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f4345g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f4346h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4347i;

    o() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(RecyclerView.s sVar) {
        int i2 = this.f4341c;
        return i2 >= 0 && i2 < sVar.a();
    }

    /* access modifiers changed from: package-private */
    public final View a(RecyclerView.n nVar) {
        View c2 = nVar.c(this.f4341c);
        this.f4341c += this.f4342d;
        return c2;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.f4340b + ", mCurrentPosition=" + this.f4341c + ", mItemDirection=" + this.f4342d + ", mLayoutDirection=" + this.f4343e + ", mStartLine=" + this.f4344f + ", mEndLine=" + this.f4345g + '}';
    }
}
