package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.i.h;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.data.a;
import net.one97.paytm.p2b.e.a;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2b.view.a.a;

public final class d extends h implements View.OnClickListener, a.C0172a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f12946c = new a((byte) 0);
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.p2b.e.a f12947a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.p2b.d.g f12948b;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12949d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f12950e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12951f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f12952g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f12953h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<BeneficiaryEntity> f12954i = new ArrayList<>();
    private ArrayList<BeneficiaryEntity> j = new ArrayList<>();
    private net.one97.paytm.p2b.view.a.a k;
    private net.one97.paytm.p2b.view.a.a l;
    private RelativeLayout m;
    private LottieAnimationView n;
    private Boolean o = Boolean.FALSE;
    private HashMap p;

    static final class b<T> implements z<o<? extends Boolean, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12955a;

        b(d dVar) {
            this.f12955a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!((Boolean) ((o) obj).getFirst()).booleanValue()) {
                d.a(this.f12955a);
                this.f12955a.b();
            }
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12956a;

        c(d dVar) {
            this.f12956a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            y<Boolean> yVar;
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "limitValidated");
            if (bool.booleanValue()) {
                this.f12956a.b();
                d dVar = this.f12956a;
                net.one97.paytm.p2b.d.g gVar = dVar.f12948b;
                if (gVar != null) {
                    gVar.b(true);
                }
                net.one97.paytm.p2b.e.a aVar = dVar.f12947a;
                if (aVar != null && (yVar = aVar.f12774h) != null) {
                    yVar.setValue(Boolean.FALSE);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.p2b.view.c.d$d  reason: collision with other inner class name */
    static final class C0174d<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12957a;

        C0174d(d dVar) {
            this.f12957a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            y<NetworkCustomError> yVar;
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            if (networkCustomError != null) {
                String canonicalName = SendMoneyToBankActivity.class.getCanonicalName();
                Boolean bool = Boolean.FALSE;
                net.one97.paytm.p2b.d.k.a((Activity) this.f12957a.getActivity(), networkCustomError, canonicalName);
                this.f12957a.b();
                net.one97.paytm.p2b.e.a c2 = this.f12957a.f12947a;
                if (c2 != null && (yVar = c2.j) != null) {
                    yVar.setValue(null);
                }
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12958a;

        e(d dVar) {
            this.f12958a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null && e.f12961a[bVar.ordinal()] == 1) {
                d.a(this.f12958a, (ArrayList) aVar.f12730b);
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12959a;

        f(d dVar) {
            this.f12959a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null && e.f12962b[bVar.ordinal()] == 1) {
                d.b(this.f12959a, (ArrayList) aVar.f12730b);
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.p2b.data.a<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f12960a;

        g(d dVar) {
            this.f12960a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                int i2 = e.f12963c[bVar.ordinal()];
                if (i2 == 1) {
                    this.f12960a.a();
                } else if (i2 == 2) {
                    d.a(this.f12960a, aVar.f12731c);
                } else if (i2 == 3) {
                    this.f12960a.b();
                } else if (i2 == 4) {
                    d.a(this.f12960a, aVar.f12731c);
                } else if (i2 == 5) {
                    this.f12960a.a((Integer) aVar.f12730b);
                }
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        net.one97.paytm.p2b.e.a aVar;
        super.onCreate(bundle);
        this.o = Boolean.FALSE;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            aVar = (net.one97.paytm.p2b.e.a) new al((ao) activity, (al.b) al.a.a(activity.getApplication())).a(net.one97.paytm.p2b.e.a.class);
        } else {
            aVar = null;
        }
        this.f12947a = aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.p2b_fragment_beneficiary_list, viewGroup, false);
        LottieAnimationView lottieAnimationView = null;
        this.f12949d = inflate != null ? (TextView) inflate.findViewById(R.id.tv_add_account) : null;
        this.f12950e = inflate != null ? (TextView) inflate.findViewById(R.id.tv_own_account_header) : null;
        this.f12951f = inflate != null ? (TextView) inflate.findViewById(R.id.tv_other_account_header) : null;
        this.f12952g = inflate != null ? (RecyclerView) inflate.findViewById(R.id.rv_own_account) : null;
        RecyclerView recyclerView = this.f12952g;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        a.C0172a aVar = this;
        this.k = new net.one97.paytm.p2b.view.a.a(getActivity(), this.f12954i, aVar);
        RecyclerView recyclerView2 = this.f12952g;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.k);
        }
        this.f12953h = inflate != null ? (RecyclerView) inflate.findViewById(R.id.rv_other_account) : null;
        RecyclerView recyclerView3 = this.f12953h;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        this.l = new net.one97.paytm.p2b.view.a.a(getActivity(), this.j, aVar);
        RecyclerView recyclerView4 = this.f12953h;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.l);
        }
        TextView textView = this.f12949d;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.m = inflate != null ? (RelativeLayout) inflate.findViewById(R.id.rl_progress_view) : null;
        if (inflate != null) {
            lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lav_progress_loading);
        }
        this.n = lottieAnimationView;
        return inflate;
    }

    public final void onActivityCreated(Bundle bundle) {
        y<net.one97.paytm.p2b.data.a<Integer>> yVar;
        y<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> yVar2;
        y<net.one97.paytm.p2b.data.a<ArrayList<BeneficiaryEntity>>> yVar3;
        y<NetworkCustomError> yVar4;
        y<Boolean> yVar5;
        y<o<Boolean, String>> yVar6;
        super.onActivityCreated(bundle);
        net.one97.paytm.p2b.e.a aVar = this.f12947a;
        if (!(aVar == null || (yVar6 = aVar.f12775i) == null)) {
            yVar6.observe(getViewLifecycleOwner(), new b(this));
        }
        net.one97.paytm.p2b.e.a aVar2 = this.f12947a;
        if (!(aVar2 == null || (yVar5 = aVar2.f12774h) == null)) {
            yVar5.observe(getViewLifecycleOwner(), new c(this));
        }
        net.one97.paytm.p2b.e.a aVar3 = this.f12947a;
        if (!(aVar3 == null || (yVar4 = aVar3.j) == null)) {
            yVar4.observe(getViewLifecycleOwner(), new C0174d(this));
        }
        net.one97.paytm.p2b.e.a aVar4 = this.f12947a;
        if (!(aVar4 == null || (yVar3 = aVar4.f12769c) == null)) {
            yVar3.observe(getViewLifecycleOwner(), new e(this));
        }
        net.one97.paytm.p2b.e.a aVar5 = this.f12947a;
        if (!(aVar5 == null || (yVar2 = aVar5.f12770d) == null)) {
            yVar2.observe(this, new f(this));
        }
        net.one97.paytm.p2b.e.a aVar6 = this.f12947a;
        if (aVar6 != null && (yVar = aVar6.f12768b) != null) {
            yVar.observe(this, new g(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r3 = r3.f12771e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Integer r3) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x0044
            java.lang.String r1 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 != 0) goto L_0x0015
            return
        L_0x0015:
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x0044
            net.one97.paytm.p2b.e.a r3 = r2.f12947a
            if (r3 == 0) goto L_0x002a
            androidx.lifecycle.y<java.lang.Boolean> r3 = r3.f12771e
            if (r3 == 0) goto L_0x002a
            java.lang.Object r3 = r3.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            goto L_0x002b
        L_0x002a:
            r3 = 0
        L_0x002b:
            if (r3 == 0) goto L_0x0033
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x003b
        L_0x0033:
            net.one97.paytm.p2b.d.g r3 = r2.f12948b
            if (r3 == 0) goto L_0x003b
            r0 = 0
            r3.a(r0)
        L_0x003b:
            net.one97.paytm.p2b.e.a r3 = r2.f12947a
            if (r3 == 0) goto L_0x0044
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r3.b((java.lang.Boolean) r0)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.d.a(java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    public final void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            if (!activity.isFinishing()) {
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                net.one97.paytm.p2b.d.k.a(this.n);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            if (!activity.isFinishing()) {
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                net.one97.paytm.p2b.d.k.b(this.n);
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.p2b.d.g) {
            this.f12948b = (net.one97.paytm.p2b.d.g) context;
        }
    }

    public final void a(BeneficiaryEntity beneficiaryEntity) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            if (!activity.isFinishing() && beneficiaryEntity != null) {
                h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
                net.one97.paytm.p2b.d.h.b(h.a.a()).a(getContext(), "P2B", "Benefeciary_selected", (String) null, SendMoneyToBankActivity.f12799a, (String) null, "p2b", "P2B");
                BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                String str = otherBankAccountDetail.accountHolderName;
                String str2 = otherBankAccountDetail.accountNumber;
                String str3 = otherBankAccountDetail.ifscCode;
                String str4 = otherBankAccountDetail.bankName;
                net.one97.paytm.p2b.d.g gVar = this.f12948b;
                if (gVar != null) {
                    gVar.a(str2, str, str3, true, str4, "");
                }
                k.a((Object) str2, "accountNumberOrVpa");
                k.a((Object) str3, "ifsc");
                if (net.one97.paytm.p2b.d.k.a(getContext())) {
                    a();
                    net.one97.paytm.p2b.e.a aVar2 = this.f12947a;
                    if (aVar2 != null) {
                        Bundle arguments = getArguments();
                        double d2 = arguments != null ? arguments.getDouble("amount") : 0.0d;
                        String simpleName = d.class.getSimpleName();
                        k.a((Object) simpleName, "P2BWalletBeneficiaryList…nt::class.java.simpleName");
                        k.c(str2, "destinationAccNum");
                        k.c(str3, "destinationIfsc");
                        k.c(simpleName, "TAG");
                        net.one97.paytm.p2b.data.a.a aVar3 = aVar2.f12767a;
                        if (aVar3 != null) {
                            aVar3.a(new a.C0170a(aVar2), str2, str3, d2, simpleName);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
            }
        }
    }

    public final void onClick(View view) {
        net.one97.paytm.p2b.d.g gVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_add_account;
        if (valueOf != null && valueOf.intValue() == i2 && (gVar = this.f12948b) != null) {
            gVar.a(true);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.o = Boolean.TRUE;
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(d dVar) {
        y<o<Boolean, String>> yVar;
        com.paytm.utility.b.a((Context) dVar.getActivity(), dVar.getString(R.string.p2b_limit_error), true);
        net.one97.paytm.p2b.e.a aVar = dVar.f12947a;
        if (aVar != null && (yVar = aVar.f12775i) != null) {
            yVar.setValue(new o(Boolean.TRUE, null));
        }
    }

    public static final /* synthetic */ void a(d dVar, ArrayList arrayList) {
        dVar.b();
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() > 0) {
            ArrayList<BeneficiaryEntity> arrayList2 = dVar.f12954i;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            ArrayList<BeneficiaryEntity> arrayList3 = dVar.f12954i;
            if (arrayList3 != null) {
                arrayList3.addAll(arrayList);
            }
            net.one97.paytm.p2b.view.a.a aVar = dVar.k;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        TextView textView = dVar.f12950e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = dVar.f12951f;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        RecyclerView recyclerView = dVar.f12952g;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public static final /* synthetic */ void b(d dVar, ArrayList arrayList) {
        dVar.b();
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() > 0) {
            ArrayList<BeneficiaryEntity> arrayList2 = dVar.j;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            ArrayList<BeneficiaryEntity> arrayList3 = dVar.j;
            if (arrayList3 != null) {
                arrayList3.addAll(arrayList);
            }
            net.one97.paytm.p2b.view.a.a aVar = dVar.l;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        TextView textView = dVar.f12951f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = dVar.f12953h;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public static final /* synthetic */ void a(d dVar, NetworkCustomError networkCustomError) {
        NetworkResponse networkResponse;
        y<net.one97.paytm.p2b.data.a<Integer>> yVar;
        dVar.b();
        if (networkCustomError != null) {
            networkResponse = networkCustomError.networkResponse;
        } else {
            networkResponse = null;
        }
        if (networkResponse == null || ((networkCustomError == null || networkCustomError.getStatusCode() != 401) && ((networkCustomError == null || networkCustomError.getStatusCode() != 403) && (networkCustomError == null || networkCustomError.getStatusCode() != 410)))) {
            dVar.a((Integer) 0);
            return;
        }
        net.one97.paytm.p2b.d.g gVar = dVar.f12948b;
        if (gVar != null) {
            gVar.e();
        }
        net.one97.paytm.p2b.e.a aVar = dVar.f12947a;
        if (aVar != null && (yVar = aVar.f12768b) != null) {
            a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
            yVar.setValue(a.C0168a.a((NetworkCustomError) null));
        }
    }

    public static final Fragment a(double d2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putDouble("amount", d2);
        dVar.setArguments(bundle);
        return dVar;
    }
}
