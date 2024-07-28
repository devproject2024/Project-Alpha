package androidx.databinding;

import android.view.View;
import android.view.ViewStub;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public ViewStub f3277a;

    /* renamed from: b  reason: collision with root package name */
    public ViewDataBinding f3278b;

    /* renamed from: c  reason: collision with root package name */
    public View f3279c;

    /* renamed from: d  reason: collision with root package name */
    ViewStub.OnInflateListener f3280d;

    /* renamed from: e  reason: collision with root package name */
    public ViewDataBinding f3281e;

    /* renamed from: f  reason: collision with root package name */
    private ViewStub.OnInflateListener f3282f = new ViewStub.OnInflateListener() {
        public final void onInflate(ViewStub viewStub, View view) {
            n nVar = n.this;
            nVar.f3279c = view;
            nVar.f3278b = f.a(nVar.f3281e.mBindingComponent, view, viewStub.getLayoutResource());
            n nVar2 = n.this;
            nVar2.f3277a = null;
            if (nVar2.f3280d != null) {
                n.this.f3280d.onInflate(viewStub, view);
                n.this.f3280d = null;
            }
            n.this.f3281e.invalidateAll();
            n.this.f3281e.forceExecuteBindings();
        }
    };

    public n(ViewStub viewStub) {
        this.f3277a = viewStub;
        this.f3277a.setOnInflateListener(this.f3282f);
    }

    public final void a(ViewStub.OnInflateListener onInflateListener) {
        if (this.f3277a != null) {
            this.f3280d = onInflateListener;
        }
    }
}
