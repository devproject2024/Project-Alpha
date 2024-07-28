package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRTransaction;
import net.one97.paytm.common.entity.wallet.CJRLedger;
import net.one97.paytm.i.h;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.d.j;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f12905a;

    /* renamed from: b  reason: collision with root package name */
    HashMap f12906b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.p2b.e.c f12907c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f12908d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f12909e;

    /* renamed from: f  reason: collision with root package name */
    private ConstraintLayout f12910f;

    /* renamed from: g  reason: collision with root package name */
    private j f12911g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f12912h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f12913i;
    private ImageView j;
    private ArrayList<CJRTransaction> k;
    private boolean l;

    /* renamed from: net.one97.paytm.p2b.view.c.a$a  reason: collision with other inner class name */
    static final class C0173a<T> implements z<net.one97.paytm.p2b.data.a<Double>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12914a;

        C0173a(a aVar) {
            this.f12914a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            NetworkCustomError networkCustomError = null;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                int i2 = b.f12918a[bVar.ordinal()];
                if (i2 == 1) {
                    TextView textView = this.f12914a.f12905a;
                    if (textView != null) {
                        textView.setText(this.f12914a.getString(R.string.p2b_updated_balance, "--,--"));
                    }
                } else if (i2 == 2) {
                    a.a(this.f12914a, (Double) aVar.f12730b);
                } else if (i2 == 3) {
                    a aVar2 = this.f12914a;
                    if (aVar != null) {
                        networkCustomError = aVar.f12731c;
                    }
                    a.a(aVar2, networkCustomError);
                }
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.p2b.data.a<CJRLedger>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12915a;

        b(a aVar) {
            this.f12915a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            NetworkCustomError networkCustomError = null;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                int i2 = b.f12919b[bVar.ordinal()];
                if (i2 == 1) {
                    a.a(this.f12915a);
                    a.a(this.f12915a, (CJRLedger) aVar.f12730b);
                } else if (i2 == 2) {
                    a aVar2 = this.f12915a;
                    if (aVar != null) {
                        networkCustomError = aVar.f12731c;
                    }
                    a.a(aVar2, networkCustomError);
                }
            }
        }
    }

    static final class c<T> implements z<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f12916a;

        c(a aVar) {
            this.f12916a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            View view;
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            net.one97.paytm.p2b.view.CustomView.a aVar = net.one97.paytm.p2b.view.CustomView.a.f12883a;
            androidx.fragment.app.j childFragmentManager = this.f12916a.getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            a aVar2 = this.f12916a;
            int i2 = R.id.fl_adv;
            if (aVar2.f12906b == null) {
                aVar2.f12906b = new HashMap();
            }
            View view2 = (View) aVar2.f12906b.get(Integer.valueOf(i2));
            if (view2 == null) {
                View view3 = aVar2.getView();
                if (view3 == null) {
                    view = null;
                    FrameLayout frameLayout = (FrameLayout) view;
                    k.a((Object) frameLayout, "fl_adv");
                    net.one97.paytm.p2b.view.CustomView.a.a(childFragmentManager, frameLayout, sanitizedResponseModel.getRvWidgets(), "P2B_post_txn", sanitizedResponseModel.getGaListener());
                }
                view2 = view3.findViewById(i2);
                aVar2.f12906b.put(Integer.valueOf(i2), view2);
            }
            view = view2;
            FrameLayout frameLayout2 = (FrameLayout) view;
            k.a((Object) frameLayout2, "fl_adv");
            net.one97.paytm.p2b.view.CustomView.a.a(childFragmentManager, frameLayout2, sanitizedResponseModel.getRvWidgets(), "P2B_post_txn", sanitizedResponseModel.getGaListener());
        }
    }

    /* JADX WARNING: type inference failed for: r5v18, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            java.lang.String r6 = "inflater"
            kotlin.g.b.k.c(r4, r6)
            int r6 = net.one97.paytm.p2b.R.layout.p2b_bottom_navigation_fragment
            r0 = 0
            android.view.View r4 = r4.inflate(r6, r5, r0)
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            r6 = 0
            if (r5 == 0) goto L_0x0033
            androidx.lifecycle.al r0 = new androidx.lifecycle.al
            r1 = r5
            androidx.lifecycle.ao r1 = (androidx.lifecycle.ao) r1
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            android.app.Application r5 = r5.getApplication()
            androidx.lifecycle.al$a r5 = androidx.lifecycle.al.a.a(r5)
            androidx.lifecycle.al$b r5 = (androidx.lifecycle.al.b) r5
            r0.<init>((androidx.lifecycle.ao) r1, (androidx.lifecycle.al.b) r5)
            java.lang.Class<net.one97.paytm.p2b.e.c> r5 = net.one97.paytm.p2b.e.c.class
            androidx.lifecycle.ai r5 = r0.a(r5)
            net.one97.paytm.p2b.e.c r5 = (net.one97.paytm.p2b.e.c) r5
            goto L_0x0034
        L_0x0033:
            r5 = r6
        L_0x0034:
            r3.f12907c = r5
            if (r4 == 0) goto L_0x0041
            int r5 = net.one97.paytm.p2b.R.id.cl_view_passbook
            android.view.View r5 = r4.findViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            goto L_0x0042
        L_0x0041:
            r5 = r6
        L_0x0042:
            r3.f12908d = r5
            if (r4 == 0) goto L_0x004f
            int r5 = net.one97.paytm.p2b.R.id.cl_cst_help
            android.view.View r5 = r4.findViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            goto L_0x0050
        L_0x004f:
            r5 = r6
        L_0x0050:
            r3.f12910f = r5
            if (r4 == 0) goto L_0x005d
            int r5 = net.one97.paytm.p2b.R.id.cl_add_money
            android.view.View r5 = r4.findViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            goto L_0x005e
        L_0x005d:
            r5 = r6
        L_0x005e:
            r3.f12909e = r5
            if (r4 == 0) goto L_0x006b
            int r5 = net.one97.paytm.p2b.R.id.walletBalanceTv
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x006c
        L_0x006b:
            r5 = r6
        L_0x006c:
            r3.f12905a = r5
            if (r4 == 0) goto L_0x0079
            int r5 = net.one97.paytm.p2b.R.id.ic_help_arrow
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            goto L_0x007a
        L_0x0079:
            r5 = r6
        L_0x007a:
            r3.f12912h = r5
            if (r4 == 0) goto L_0x0087
            int r5 = net.one97.paytm.p2b.R.id.ic_arrow_view_passbook
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            goto L_0x0088
        L_0x0087:
            r5 = r6
        L_0x0088:
            r3.f12913i = r5
            if (r4 == 0) goto L_0x0095
            int r5 = net.one97.paytm.p2b.R.id.ic_arrow_add_money
            android.view.View r5 = r4.findViewById(r5)
            r6 = r5
            android.widget.ImageView r6 = (android.widget.ImageView) r6
        L_0x0095:
            r3.j = r6
            android.widget.ImageView r5 = r3.f12912h
            if (r5 == 0) goto L_0x00a1
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00a1:
            android.widget.ImageView r5 = r3.j
            if (r5 == 0) goto L_0x00ab
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00ab:
            android.widget.ImageView r5 = r3.f12913i
            if (r5 == 0) goto L_0x00b5
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00b5:
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.f12908d
            if (r5 == 0) goto L_0x00bf
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00bf:
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.f12909e
            if (r5 == 0) goto L_0x00c9
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00c9:
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.f12910f
            if (r5 == 0) goto L_0x00d3
            r6 = r3
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
        L_0x00d3:
            net.one97.paytm.p2b.e.c r5 = r3.f12907c
            if (r5 == 0) goto L_0x00e8
            androidx.lifecycle.y<com.paytmmall.clpartifact.modal.SanitizedResponseModel> r5 = r5.f12786b
            if (r5 == 0) goto L_0x00e8
            r6 = r3
            androidx.lifecycle.q r6 = (androidx.lifecycle.q) r6
            net.one97.paytm.p2b.view.c.a$c r0 = new net.one97.paytm.p2b.view.c.a$c
            r0.<init>(r3)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r5.observe(r6, r0)
        L_0x00e8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        y<net.one97.paytm.p2b.data.a<CJRLedger>> yVar;
        y<net.one97.paytm.p2b.data.a<Double>> yVar2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.p2b.e.c cVar = this.f12907c;
        if (!(cVar == null || (yVar2 = cVar.f12788d) == null)) {
            yVar2.observe(this, new C0173a(this));
        }
        net.one97.paytm.p2b.e.c cVar2 = this.f12907c;
        if (cVar2 != null && (yVar = cVar2.f12791g) != null) {
            yVar.observe(this, new b(this));
        }
    }

    private final void a(String str) {
        String string = getString(R.string.p2b_error_title);
        k.a((Object) string, "getString(R.string.p2b_error_title)");
        String string2 = getString(R.string.p2b_default_error);
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        com.paytm.utility.h hVar = new com.paytm.utility.h(getContext());
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-1, getString(R.string.p2b_ok), new d(hVar));
        hVar.show();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f12917a;

        d(com.paytm.utility.h hVar) {
            this.f12917a = hVar;
        }

        public final void onClick(View view) {
            this.f12917a.dismiss();
        }
    }

    public final void onClick(View view) {
        j jVar;
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ic_arrow_add_money;
        if (valueOf != null && valueOf.intValue() == i2) {
            j jVar2 = this.f12911g;
            if (jVar2 != null) {
                jVar2.a();
                return;
            }
            return;
        }
        int i3 = R.id.cl_add_money;
        if (valueOf != null && valueOf.intValue() == i3) {
            j jVar3 = this.f12911g;
            if (jVar3 != null) {
                jVar3.a();
                return;
            }
            return;
        }
        int i4 = R.id.cl_cst_help;
        if (valueOf == null || valueOf.intValue() != i4) {
            int i5 = R.id.ic_help_arrow;
            if (valueOf == null || valueOf.intValue() != i5) {
                int i6 = R.id.ic_arrow_view_passbook;
                if (valueOf != null && valueOf.intValue() == i6) {
                    j jVar4 = this.f12911g;
                    if (jVar4 != null) {
                        jVar4.b();
                        return;
                    }
                    return;
                }
                int i7 = R.id.cl_view_passbook;
                if (valueOf != null && valueOf.intValue() == i7 && (jVar = this.f12911g) != null) {
                    jVar.b();
                    return;
                }
                return;
            }
        }
        ArrayList<CJRTransaction> arrayList = this.k;
        if (arrayList == null || arrayList.size() <= 0) {
            net.one97.paytm.p2b.e.c cVar = this.f12907c;
            if (cVar != null) {
                if (cVar != null) {
                    str = cVar.t;
                }
                cVar.a(str);
                return;
            }
            return;
        }
        j jVar5 = this.f12911g;
        if (jVar5 != null) {
            CJRTransaction cJRTransaction = arrayList.get(0);
            k.a((Object) cJRTransaction, "it.get(0)");
            jVar5.a(cJRTransaction);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof j) {
            this.f12911g = (j) context;
        }
    }

    public static final /* synthetic */ void a(a aVar, Double d2) {
        if (d2 != null) {
            String a2 = net.one97.paytm.p2b.d.k.a(String.valueOf(d2.doubleValue()), "");
            TextView textView = aVar.f12905a;
            if (textView != null) {
                textView.setText(aVar.getString(R.string.p2b_updated_balance, a2));
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, NetworkCustomError networkCustomError) {
        j jVar = aVar.f12911g;
        if (jVar != null) {
            jVar.d();
        }
        if (networkCustomError instanceof NetworkCustomError) {
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, valueOf, true) || p.a("403", valueOf, true) || p.a("410", valueOf, true)) {
                h.a aVar2 = net.one97.paytm.p2b.d.h.f12718a;
                new NetworkCustomError();
                net.one97.paytm.p2b.d.h.b(h.a.a()).a((Activity) aVar.getActivity(), (String) null, true);
                return;
            }
            aVar.a(networkCustomError.getAlertMessage());
            return;
        }
        aVar.a((String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r3 = r3.f12787c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.p2b.view.c.a r6) {
        /*
            boolean r0 = r6.l
            if (r0 != 0) goto L_0x0059
            r0 = 1
            r6.l = r0
            net.one97.paytm.p2b.e.c r0 = r6.f12907c
            r1 = 0
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.y<net.one97.paytm.p2b.data.a<net.one97.paytm.common.entity.wallet.CJRLedger>> r0 = r0.f12791g
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.p2b.data.a r0 = (net.one97.paytm.p2b.data.a) r0
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x0059
            ResultType r0 = r0.f12730b
            net.one97.paytm.common.entity.wallet.CJRLedger r0 = (net.one97.paytm.common.entity.wallet.CJRLedger) r0
            if (r0 == 0) goto L_0x0059
            net.one97.paytm.p2b.d.h$a r2 = net.one97.paytm.p2b.d.h.f12718a
            net.one97.paytm.p2b.d.h r2 = net.one97.paytm.p2b.d.h.a.a()
            net.one97.paytm.p2b.b.a r2 = net.one97.paytm.p2b.d.h.b(r2)
            net.one97.paytm.p2b.e.c r3 = r6.f12907c
            if (r3 == 0) goto L_0x0039
            androidx.lifecycle.y<com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget> r3 = r3.f12787c
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r3.getValue()
            com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget r3 = (com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget) r3
            goto L_0x003a
        L_0x0039:
            r3 = r1
        L_0x003a:
            android.content.Context r4 = r6.getContext()
            androidx.fragment.app.FragmentActivity r5 = r6.getActivity()
            if (r5 == 0) goto L_0x0047
            r5.getSupportFragmentManager()
        L_0x0047:
            net.one97.paytm.p2b.e.c r6 = r6.f12907c
            if (r6 == 0) goto L_0x004d
            java.lang.String r1 = r6.t
        L_0x004d:
            r0.getOrderId()
            com.paytm.network.a$c r6 = com.paytm.network.a.c.P2B
            java.lang.String r6 = r6.name()
            r2.a(r3, r4, r1, r6)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.a.a(net.one97.paytm.p2b.view.c.a):void");
    }

    public static final /* synthetic */ void a(a aVar, CJRLedger cJRLedger) {
        ArrayList<CJRTransaction> transactionList;
        j jVar;
        if (aVar.k == null) {
            aVar.k = cJRLedger != null ? cJRLedger.mTransactionList : null;
        } else if (cJRLedger != null && (transactionList = cJRLedger.getTransactionList()) != null) {
            aVar.k = transactionList;
            if (transactionList.size() > 0 && (jVar = aVar.f12911g) != null) {
                CJRTransaction cJRTransaction = transactionList.get(0);
                k.a((Object) cJRTransaction, "get(0)");
                jVar.a(cJRTransaction);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f12906b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
