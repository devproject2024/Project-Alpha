package net.one97.paytm.recharge.presentation.f;

import android.view.View;
import kotlin.g.b.k;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final C1281a f64839a = new C1281a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private View f64840b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final net.one97.paytm.recharge.presentation.d.b f64841c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, net.one97.paytm.recharge.presentation.d.b bVar) {
        super(view);
        k.c(view, "mItemView");
        k.c(bVar, "itemClickListener");
        this.f64840b = view;
        this.f64841c = bVar;
    }

    /* renamed from: net.one97.paytm.recharge.presentation.f.a$a  reason: collision with other inner class name */
    public static final class C1281a {
        private C1281a() {
        }

        public /* synthetic */ C1281a(byte b2) {
            this();
        }
    }

    public final <T> void a(T t) {
        this.f64840b.setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64842a;

        b(a aVar) {
            this.f64842a = aVar;
        }

        public final void onClick(View view) {
            this.f64842a.f64841c.a(-5);
        }
    }
}
