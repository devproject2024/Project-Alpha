package net.one97.paytm.moneytransferv4.b.a.a.a.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.moneytransfer.c.ad;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;

public final class b extends e<a> {

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.moneytransferv4.b.a.a.d f55229b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<UpiPendingRequestModel> f55230c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f55231d;

    public final /* bridge */ /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        a((a) vVar);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        a(aVar);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        return new a(f.a.a(viewGroup, g.WIDGET_TYPE_COLLECT_REQUEST.getId()));
    }

    public b(ArrayList<UpiPendingRequestModel> arrayList) {
        k.c(arrayList, "pendingRequests");
        this.f55230c = arrayList;
        this.f55231d = this.f55230c.size() <= 1 ? false : true;
    }

    public final int a() {
        return g.WIDGET_TYPE_COLLECT_REQUEST.getId();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.d.b$b  reason: collision with other inner class name */
    static final class C1007b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55237a;

        C1007b(b bVar) {
            this.f55237a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransferv4.b.a.a.d dVar;
            if (this.f55237a.f55230c.size() > 0 && (dVar = this.f55237a.f55229b) != null) {
                UpiPendingRequestModel upiPendingRequestModel = this.f55237a.f55230c.get(0);
                k.a((Object) upiPendingRequestModel, "pendingRequests[0]");
                dVar.a(upiPendingRequestModel);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55238a;

        c(b bVar) {
            this.f55238a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55238a.f55229b;
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55239a;

        d(b bVar) {
            this.f55239a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransferv4.b.a.a.d dVar = this.f55239a.f55229b;
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    public final void a(net.one97.paytm.moneytransferv4.b.a.a.d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55229b = dVar;
    }

    public final int getItemCount() {
        Collection collection = this.f55230c;
        return collection == null || collection.isEmpty() ? 0 : 1;
    }

    public final void a(ArrayList<UpiPendingRequestModel> arrayList) {
        k.c(arrayList, "it");
        this.f55230c = arrayList;
        boolean z = true;
        if (this.f55230c.size() <= 1) {
            z = false;
        }
        this.f55231d = z;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        k.c(str, "txId");
        if (!this.f55230c.isEmpty()) {
            boolean z = false;
            this.f55230c.remove(0);
            if (this.f55230c.size() > 1) {
                z = true;
            }
            this.f55231d = z;
            notifyDataSetChanged();
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ConstraintLayout f55232a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f55233b;

        /* renamed from: c  reason: collision with root package name */
        final View f55234c;

        /* renamed from: d  reason: collision with root package name */
        private final ad f55235d;

        /* renamed from: e  reason: collision with root package name */
        private final View f55236e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            this.f55236e = view;
            ViewDataBinding a2 = androidx.databinding.f.a(this.f55236e);
            if (a2 != null) {
                this.f55235d = (ad) a2;
                ConstraintLayout constraintLayout = this.f55235d.l;
                k.a((Object) constraintLayout, "dataBinding.root");
                this.f55232a = constraintLayout;
                TextView textView = this.f55235d.n;
                k.a((Object) textView, "dataBinding.viewAllRequest");
                this.f55233b = textView;
                View view2 = this.f55235d.f53624g;
                k.a((Object) view2, "dataBinding.paddedView");
                this.f55234c = view2;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.databinding.MtV4CollectRequestWidgetBinding");
        }

        public final void a(UpiPendingRequestModel upiPendingRequestModel, boolean z) {
            k.c(upiPendingRequestModel, "upiPendingRequestModel");
            ad adVar = this.f55235d;
            adVar.setVariable(net.one97.paytm.moneytransfer.a.f53531c, upiPendingRequestModel);
            adVar.setVariable(net.one97.paytm.moneytransfer.a.f53529a, 0);
            adVar.setVariable(net.one97.paytm.moneytransfer.a.f53530b, Boolean.valueOf(z));
            adVar.executePendingBindings();
        }
    }

    private void a(a aVar) {
        k.c(aVar, "holder");
        aVar.f55232a.setOnClickListener(new C1007b(this));
        aVar.f55233b.setOnClickListener(new c(this));
        if (this.f55230c.size() > 0) {
            UpiPendingRequestModel upiPendingRequestModel = this.f55230c.get(0);
            k.a((Object) upiPendingRequestModel, "pendingRequests[0]");
            aVar.a(upiPendingRequestModel, this.f55231d);
        }
        if (this.f55231d) {
            aVar.f55234c.setOnClickListener(new d(this));
        } else {
            aVar.f55234c.setOnClickListener((View.OnClickListener) null);
        }
    }
}
