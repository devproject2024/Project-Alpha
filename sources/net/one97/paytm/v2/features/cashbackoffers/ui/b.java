package net.one97.paytm.v2.features.cashbackoffers.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.Facets;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.v2.features.cashbacklanding.d.e;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;

public final class b extends a {
    public static final a j = new a((byte) 0);
    private int k = 1;
    private Integer l = -1;
    private m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> m;
    private HashMap n;

    public final View b(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Intent intent) {
            k.c(intent, "intent");
            Bundle bundle = new Bundle();
            bundle.putInt("offer_type_card", intent.getIntExtra("offer_type_card", 2));
            bundle.putInt("status_type", intent.getIntExtra("status_type", 0));
            bundle.putString("offertag", intent.getStringExtra("offertag"));
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Integer num = null;
        this.l = arguments != null ? Integer.valueOf(arguments.getInt("offer_type_card")) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            num = Integer.valueOf(arguments2.getInt("status_type"));
        }
        if (num == null) {
            k.a();
        }
        this.k = num.intValue();
        net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20403c;
        if (aVar != null) {
            e eVar = (e) aVar;
            eVar.f20279d = this.k;
            eVar.f20280e = 1;
            eVar.f20278c.clear();
            eVar.f20276a.clear();
            eVar.g();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.VoucherViewModel");
    }

    public final void a(ArrayList<Facets> arrayList, m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> mVar) {
        k.c(arrayList, "data");
        k.c(mVar, "mVoucherFilterListener");
        this.m = mVar;
        b(arrayList);
    }

    private void b(ArrayList<Facets> arrayList) {
        k.c(arrayList, "data");
        if (getUserVisibleHint()) {
            net.one97.paytm.vipcashback.fragment.b bVar = new net.one97.paytm.vipcashback.fragment.b();
            bVar.a(arrayList);
            m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> mVar = this.m;
            if (mVar == null) {
                k.a();
            }
            bVar.a(mVar);
            bVar.f20920a = this.l;
            j fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                k.a();
            }
            bVar.show(fragmentManager, (String) null);
        }
    }

    public final void a(int i2) {
        Integer num = this.l;
        a.b.C0384a aVar = a.b.f20777a;
        int h2 = a.b.f20785i;
        if (num != null && num.intValue() == h2) {
            super.a(i2);
            return;
        }
        View b2 = b(R.id.no_network);
        k.a((Object) b2, "no_network");
        b2.setVisibility(8);
    }

    public final void a(ArrayList<VoucherFilterItem> arrayList) {
        net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20403c;
        if (aVar != null) {
            ((e) aVar).a(this.k, arrayList);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.VoucherViewModel");
    }
}
