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
import net.one97.paytm.upi.e.e;

public final class b extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67286a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.mandate.p2p.b f67287b;

    /* renamed from: c  reason: collision with root package name */
    private int f67288c = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67289d;

    public final void b() {
        HashMap hashMap = this.f67289d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class c extends l implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return x.f47997a;
        }

        public final void invoke(int i2) {
            net.one97.paytm.upi.mandate.p2p.b a2 = this.this$0.f67287b;
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
            this.f67287b = (net.one97.paytm.upi.mandate.p2p.b) context;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f67288c = arguments.getInt("current selected index", -1);
    }

    public final int a() {
        return R.layout.bottom_sheet_fortnightly_payment_day;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        e a2 = e.a(view);
        k.a((Object) a2, "BottomSheetFortnightlyPaymentDayBinding.bind(view)");
        a aVar = new a(this.f67288c - 1, new c(this));
        e eVar = new e(this.f67288c - 1);
        a2.f66799a.setOnClickListener(new C1367b(this, aVar, eVar));
        RecyclerView recyclerView = a2.f66800b;
        k.a((Object) recyclerView, "firstFortnightRecyclerView");
        recyclerView.setAdapter(aVar);
        RecyclerView recyclerView2 = a2.f66801c;
        k.a((Object) recyclerView2, "secondFortnightRecyclerView");
        recyclerView2.setAdapter(eVar);
    }

    /* renamed from: net.one97.paytm.upi.mandate.p2p.a.b$b  reason: collision with other inner class name */
    static final class C1367b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f67291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f67292c;

        C1367b(b bVar, a aVar, e eVar) {
            this.f67290a = bVar;
            this.f67291b = aVar;
            this.f67292c = eVar;
        }

        public final void onClick(View view) {
            this.f67290a.dismiss();
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
