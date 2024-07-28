package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;

public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.recharge.metro.a.h f63383a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f63384b;

    /* renamed from: c  reason: collision with root package name */
    private CJRMetroQRFrequentOrderList f63385c;

    /* renamed from: d  reason: collision with root package name */
    private String f63386d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f63387e;

    public final View a(int i2) {
        if (this.f63387e == null) {
            this.f63387e = new HashMap();
        }
        View view = (View) this.f63387e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f63387e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.f63386d = arguments != null ? arguments.getString("key_recent_product_type") : null;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.metro_recent_journey_view_type, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r3 = r3.getmOrderList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r3, r0)
            super.onViewCreated(r3, r4)
            int r3 = net.one97.paytm.recharge.R.id.clear_tv
            android.view.View r3 = r2.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            net.one97.paytm.recharge.metro.c.j$a r4 = new net.one97.paytm.recharge.metro.c.j$a
            r4.<init>(r2)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
            java.lang.String r3 = r2.f63386d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0033
            net.one97.paytm.recharge.metro.f.c$a r3 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r3 = r2.f63386d
            if (r3 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r3 = net.one97.paytm.recharge.metro.f.c.a.d((java.lang.String) r3)
            r2.f63385c = r3
        L_0x0033:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r3 = r2.f63385c
            if (r3 == 0) goto L_0x00ce
            net.one97.paytm.recharge.metro.f.c$a r3 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList r3 = r2.f63385c
            if (r3 == 0) goto L_0x004a
            java.util.List r3 = r3.getmOrderList()
            if (r3 == 0) goto L_0x004a
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r3 = kotlin.a.k.c(r3)
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            if (r3 != 0) goto L_0x0050
            kotlin.g.b.k.a()
        L_0x0050:
            java.util.List r3 = net.one97.paytm.recharge.metro.f.c.a.e((java.util.List<net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder>) r3)
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x00cb
            net.one97.paytm.recharge.metro.a.h r4 = new net.one97.paytm.recharge.metro.a.h
            net.one97.paytm.recharge.metro.c.c$a r0 = r2.f63384b
            if (r0 != 0) goto L_0x0066
            kotlin.g.b.k.a()
        L_0x0066:
            r4.<init>(r0)
            r2.f63383a = r4
            int r4 = net.one97.paytm.recharge.R.id.recent_journey_rv
            android.view.View r4 = r2.a((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r0 = "recent_journey_rv"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.paytm.recharge.metro.a.h r0 = r2.f63383a
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r4.setAdapter(r0)
            int r4 = r3.size()
            r0 = 3
            if (r4 <= r0) goto L_0x00a0
            int r4 = net.one97.paytm.recharge.R.id.view_more
            android.view.View r4 = r2.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r1 = 0
            if (r4 == 0) goto L_0x0094
            r4.setVisibility(r1)
        L_0x0094:
            net.one97.paytm.recharge.metro.a.h r4 = r2.f63383a
            if (r4 == 0) goto L_0x00b6
            java.util.List r0 = r3.subList(r1, r0)
            r4.a(r0)
            goto L_0x00b6
        L_0x00a0:
            int r4 = net.one97.paytm.recharge.R.id.view_more
            android.view.View r4 = r2.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00af
            r0 = 8
            r4.setVisibility(r0)
        L_0x00af:
            net.one97.paytm.recharge.metro.a.h r4 = r2.f63383a
            if (r4 == 0) goto L_0x00b6
            r4.a(r3)
        L_0x00b6:
            int r4 = net.one97.paytm.recharge.R.id.view_more
            android.view.View r4 = r2.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00ca
            net.one97.paytm.recharge.metro.c.j$b r0 = new net.one97.paytm.recharge.metro.c.j$b
            r0.<init>(r2, r3)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r4.setOnClickListener(r0)
        L_0x00ca:
            return
        L_0x00cb:
            r2.a()
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.j.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63388a;

        a(j jVar) {
            this.f63388a = jVar;
        }

        public final void onClick(View view) {
            this.f63388a.a();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f63390b;

        b(j jVar, List list) {
            this.f63389a = jVar;
            this.f63390b = list;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f63389a.a(R.id.view_more);
            if (textView != null) {
                textView.setVisibility(8);
            }
            List list = this.f63390b;
            List list2 = null;
            if ((list != null ? Integer.valueOf(list.size()) : null).intValue() > 5) {
                net.one97.paytm.recharge.metro.a.h hVar = this.f63389a.f63383a;
                if (hVar != null) {
                    List list3 = this.f63390b;
                    if (list3 != null) {
                        list2 = list3.subList(0, 5);
                    }
                    hVar.a(list2);
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.metro.a.h hVar2 = this.f63389a.f63383a;
            if (hVar2 != null) {
                hVar2.a(this.f63390b);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            ((c) parentFragment).a();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMMStationSearchListFragment");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof c.a) {
            this.f63384b = (c.a) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnStationSelectionListener");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63387e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
