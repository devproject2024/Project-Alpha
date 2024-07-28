package net.one97.paytm.moneytransferv4.a.c;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.g;
import net.one97.paytm.moneytransferv4.a.c.a;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends h implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54845a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private List<BeneficiaryEntity> f54846b;

    /* renamed from: c  reason: collision with root package name */
    private int f54847c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f54848d = 25;

    /* renamed from: e  reason: collision with root package name */
    private g f54849e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f54850f = new a(this, new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    private HashMap f54851g;

    public final void a(BeneficiaryEntity beneficiaryEntity) {
        k.c(beneficiaryEntity, "beneficiaryEntity");
    }

    static final class e<T> implements z<net.one97.paytm.moneytransfer.model.c<ArrayList<BeneficiaryEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54858a;

        e(b bVar) {
            this.f54858a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f54860a[dVar.ordinal()];
                if (i2 == 1) {
                    b bVar = this.f54858a;
                    ResultType resulttype = cVar.f54033b;
                    if (resulttype == null) {
                        k.a();
                    }
                    bVar.f54850f.a((ArrayList) resulttype);
                } else if (i2 == 2) {
                    b.a(this.f54858a, cVar.f54034c);
                }
            }
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54859a;

        f(b bVar) {
            this.f54859a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ae, code lost:
            if (kotlin.m.p.a((java.lang.CharSequence) r5, r9, true) != false) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0073, code lost:
            if (kotlin.m.p.a((java.lang.CharSequence) r5, r9, true) != false) goto L_0x0075;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0027 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.String r11 = (java.lang.String) r11
                net.one97.paytm.moneytransferv4.a.c.b r0 = r10.f54859a
                net.one97.paytm.moneytransferv4.a.c.a r0 = r0.f54850f
                java.lang.String r1 = "query"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
                kotlin.g.b.k.c(r11, r1)
                java.lang.String r1 = r0.f54835c
                r0.f54834b = r1
                r0.f54835c = r11
                java.util.List<? extends net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r1 = r0.f54833a
                java.util.List<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f54837e
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.Iterator r2 = r2.iterator()
            L_0x0027:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x00b8
                java.lang.Object r4 = r2.next()
                r5 = r4
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r6 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r6 = r6.otherBank
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r5 = r5.instrumentPreferences
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r5 = r5.upi
                r7 = 1
                r8 = 0
                if (r6 == 0) goto L_0x0077
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r5 = r6.accounts
                java.lang.Object r5 = r5.get(r8)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r5 = r5.accountDetail
                java.lang.String r5 = r5.accountHolderName
                java.lang.String r9 = "otherBank.accounts[0].ac…tDetail.accountHolderName"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r9 = r11
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r9, (boolean) r7)
                if (r5 != 0) goto L_0x0075
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r5 = r6.accounts
                java.lang.Object r5 = r5.get(r8)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccountDetail r5 = r5.accountDetail
                java.lang.String r5 = r5.accountNumber
                java.lang.String r6 = "otherBank.accounts[0].accountDetail.accountNumber"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r9, (boolean) r7)
                if (r5 == 0) goto L_0x00b1
            L_0x0075:
                r8 = 1
                goto L_0x00b1
            L_0x0077:
                if (r5 == 0) goto L_0x00b1
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r6 = r5.accounts
                java.lang.Object r6 = r6.get(r8)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r6 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r6
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r6 = r6.accountDetail
                java.lang.String r6 = r6.accountHolderName
                java.lang.String r9 = "upi.accounts[0].accountDetail.accountHolderName"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9 = r11
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r9, (boolean) r7)
                if (r6 != 0) goto L_0x0075
                java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r5 = r5.accounts
                java.lang.Object r5 = r5.get(r8)
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r5 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r5
                net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccountDetail r5 = r5.accountDetail
                java.lang.String r5 = r5.vpa
                java.lang.String r6 = "upi.accounts[0].accountDetail.vpa"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r9, (boolean) r7)
                if (r5 == 0) goto L_0x00b1
                goto L_0x0075
            L_0x00b1:
                if (r8 == 0) goto L_0x0027
                r3.add(r4)
                goto L_0x0027
            L_0x00b8:
                java.util.List r3 = (java.util.List) r3
                r0.f54833a = r3
                java.util.List<? extends net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r11 = r0.f54833a
                net.one97.paytm.moneytransferv4.a.c.a$c r2 = new net.one97.paytm.moneytransferv4.a.c.a$c
                r2.<init>(r0, r1, r11)
                androidx.recyclerview.widget.h$a r2 = (androidx.recyclerview.widget.h.a) r2
                androidx.recyclerview.widget.h$b r11 = androidx.recyclerview.widget.h.a(r2)
                java.lang.String r1 = "DiffUtil.calculateDiff(b…stToBeSearched, oldList))"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
                androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
                r11.a((androidx.recyclerview.widget.RecyclerView.a) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.a.c.b.f.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ g a(b bVar) {
        g gVar = bVar.f54849e;
        if (gVar == null) {
            k.a("viewModel");
        }
        return gVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_beneficiary_list, viewGroup, false);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("beneficiary_list_page_1");
            if (serializable != null) {
                this.f54846b = ab.c(serializable);
                this.f54847c = arguments.getInt("beneficiary_total_count", -1);
                this.f54848d = arguments.getInt("beneficiary_offset", 25);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity>");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.moneytransfer.c.k a2 = net.one97.paytm.moneytransfer.c.k.a(view);
        k.a((Object) a2, "FragmentBeneficiaryListBinding.bind(view)");
        a2.f53771a.setOnClickListener(new C0985b(this, a2));
        a2.f53773c.setOnClickListener(new c(this, a2));
        RecyclerView recyclerView = a2.f53772b;
        k.a((Object) recyclerView, "binding.beneficiaryRecyclerView");
        List<BeneficiaryEntity> list = this.f54846b;
        if (list == null) {
            k.a("initialBeneficiaryList");
        }
        this.f54850f.a(list);
        recyclerView.setAdapter(this.f54850f);
        ai a3 = am.a((Fragment) this).a(g.class);
        k.a((Object) a3, "ViewModelProviders.of(th…aryViewModel::class.java)");
        this.f54849e = (g) a3;
        g gVar = this.f54849e;
        if (gVar == null) {
            k.a("viewModel");
        }
        gVar.f54758c = this.f54847c;
        List<BeneficiaryEntity> list2 = this.f54846b;
        if (list2 == null) {
            k.a("initialBeneficiaryList");
        }
        gVar.a((List<? extends BeneficiaryEntity>) list2);
        if (this.f54847c > 25) {
            gVar.a(25);
        }
        g gVar2 = this.f54849e;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        gVar2.f54759d.observe(getViewLifecycleOwner(), new e(this));
        g gVar3 = this.f54849e;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        gVar3.f54760e.observe(getViewLifecycleOwner(), new f(this));
        a2.f53774d.requestFocus();
        EditText editText = a2.f53774d;
        k.a((Object) editText, "binding.searchEditText");
        editText.addTextChangedListener(new d(this, a2));
    }

    /* renamed from: net.one97.paytm.moneytransferv4.a.c.b$b  reason: collision with other inner class name */
    static final class C0985b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54852a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.k f54853b;

        C0985b(b bVar, net.one97.paytm.moneytransfer.c.k kVar) {
            this.f54852a = bVar;
            this.f54853b = kVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f54852a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54854a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.k f54855b;

        c(b bVar, net.one97.paytm.moneytransfer.c.k kVar) {
            this.f54854a = bVar;
            this.f54855b = kVar;
        }

        public final void onClick(View view) {
            EditText editText = this.f54855b.f53774d;
            k.a((Object) editText, "binding.searchEditText");
            Editable text = editText.getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54856a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.k f54857b;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public d(b bVar, net.one97.paytm.moneytransfer.c.k kVar) {
            this.f54856a = bVar;
            this.f54857b = kVar;
        }

        public final void afterTextChanged(Editable editable) {
            ImageView imageView = this.f54857b.f53773c;
            k.a((Object) imageView, "binding.clearSearch");
            View view = imageView;
            CharSequence obj = editable != null ? editable.toString() : null;
            net.one97.paytm.upi.f.a(view, !(obj == null || p.a(obj)));
            b.a(this.f54856a).a(String.valueOf(editable));
        }
    }

    public static final /* synthetic */ void a(b bVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getMessage(), true) || p.a("410", upiCustomVolleyError.getMessage(), true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = bVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            b2.a((Activity) activity, MoneyTransferV3Activity.class.getSimpleName());
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54851g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
