package net.one97.paytm.upi.mandate.p2p.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.f;

public final class c extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67293a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.mandate.p2p.b f67294b;

    /* renamed from: c  reason: collision with root package name */
    private int f67295c = -1;

    /* renamed from: d  reason: collision with root package name */
    private d f67296d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f67297e;

    public final void b() {
        HashMap hashMap = this.f67297e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    /* renamed from: net.one97.paytm.upi.mandate.p2p.a.c$c  reason: collision with other inner class name */
    static final class C1368c extends l implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1368c(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return x.f47997a;
        }

        public final void invoke(int i2) {
            net.one97.paytm.upi.mandate.p2p.b a2 = this.this$0.f67294b;
            if (a2 != null) {
                a2.c(i2 + 1);
            }
            this.this$0.dismiss();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.upi.mandate.p2p.b) {
            this.f67294b = (net.one97.paytm.upi.mandate.p2p.b) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f67295c = arguments.getInt("current selected index", -1);
    }

    public final int a() {
        return R.layout.bottom_sheet_generic_payment_day;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        f a2 = f.a(view);
        k.a((Object) a2, "BottomSheetGenericPaymentDayBinding.bind(view)");
        this.f67296d = new d(this.f67295c - 1, new C1368c(this));
        a2.f66803a.setOnClickListener(new b(this));
        RecyclerView recyclerView = a2.f66804b;
        k.a((Object) recyclerView, "paymentDayRecyclerView");
        recyclerView.setItemAnimator((RecyclerView.f) null);
        RecyclerView recyclerView2 = a2.f66804b;
        k.a((Object) recyclerView2, "paymentDayRecyclerView");
        d dVar = this.f67296d;
        if (dVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(dVar);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67298a;

        b(c cVar) {
            this.f67298a = cVar;
        }

        public final void onClick(View view) {
            this.f67298a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
