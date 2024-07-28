package net.one97.paytm.moneytransferv4.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.view.a.g;
import net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a;
import net.one97.paytm.moneytransferv4.invite.b;
import net.one97.paytm.moneytransferv4.search.a;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends net.one97.paytm.moneytransferv4.b.a implements a.d {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a f55708a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.contacts.b.a f55709b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.view.a.g f55710c;

    /* renamed from: e  reason: collision with root package name */
    private a f55711e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.viewmodel.g f55712f;

    /* renamed from: g  reason: collision with root package name */
    private final int f55713g = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.c.l f55714h;

    /* renamed from: i  reason: collision with root package name */
    private kotlin.g.a.b<? super x, x> f55715i;
    private HashMap j;

    public final void c() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.search.b$b  reason: collision with other inner class name */
    static final class C1039b<T> implements z<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.model.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55717a;

        C1039b(b bVar) {
            this.f55717a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (c.f55729a[cVar.f54032a.ordinal()] == 1) {
                b bVar = this.f55717a;
                net.one97.paytm.moneytransfer.model.b bVar2 = (net.one97.paytm.moneytransfer.model.b) cVar.f54033b;
                ArrayList<ContactItemModel> arrayList = null;
                ArrayList<ContactItemModel> a2 = bVar2 != null ? bVar2.a() : null;
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.moneytransfer.model.b bVar3 = (net.one97.paytm.moneytransfer.model.b) cVar.f54033b;
                if (bVar3 != null) {
                    arrayList = bVar3.b();
                }
                if (arrayList == null) {
                    kotlin.g.b.k.a();
                }
                b.a(bVar, (ArrayList) a2);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.moneytransfer.model.c<a.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55718a;

        c(b bVar) {
            this.f55718a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar.f54032a == net.one97.paytm.moneytransfer.model.d.LOADING) {
                TextView textView = this.f55718a.a().m;
                kotlin.g.b.k.a((Object) textView, "binding.tvBtnProceed");
                if (net.one97.paytm.upi.f.d(textView)) {
                    b.a(this.f55718a.a());
                } else {
                    b.c(this.f55718a).a(true);
                }
            } else {
                TextView textView2 = this.f55718a.a().m;
                kotlin.g.b.k.a((Object) textView2, "binding.tvBtnProceed");
                if (net.one97.paytm.upi.f.d(textView2)) {
                    b.b(this.f55718a.a());
                } else {
                    b.c(this.f55718a).a(false);
                }
            }
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f55730b[dVar.ordinal()];
                if (i2 == 1) {
                    b.a(this.f55718a, (a.b) cVar.f54033b);
                } else if (i2 == 2) {
                    b.a(this.f55718a, cVar.f54034c);
                }
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.moneytransfer.model.c<a.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55719a;

        d(b bVar) {
            this.f55719a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            String str2;
            a.d dVar;
            a.d dVar2;
            String str3;
            a.d dVar3;
            a.d dVar4;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            String str4 = null;
            if (cVar == null || (dVar4 = (a.d) cVar.f54033b) == null) {
                str = null;
            } else {
                str = dVar4.f53982a;
            }
            CharSequence charSequence = str;
            if (!(charSequence == null || p.a(charSequence))) {
                net.one97.paytm.moneytransfer.contacts.b.a d2 = b.d(this.f55719a);
                if (cVar == null || (dVar3 = (a.d) cVar.f54033b) == null) {
                    str3 = null;
                } else {
                    str3 = dVar3.f53982a;
                }
                d2.f53974f = net.one97.paytm.moneytransfer.utils.m.f(str3);
            }
            if (!(cVar == null || (dVar2 = (a.d) cVar.f54033b) == null)) {
                str4 = dVar2.f53983b;
            }
            if (!TextUtils.isEmpty(str4)) {
                net.one97.paytm.moneytransfer.contacts.b.a d3 = b.d(this.f55719a);
                if (cVar == null || (dVar = (a.d) cVar.f54033b) == null || (str2 = dVar.f53983b) == null) {
                    str2 = "";
                }
                d3.f53975g = str2;
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.moneytransfer.model.c<a.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55720a;

        e(b bVar) {
            this.f55720a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar.f54032a == net.one97.paytm.moneytransfer.model.d.LOADING) {
                b.a(this.f55720a.a());
            } else {
                b.b(this.f55720a.a());
            }
            int i2 = c.f55731c[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                b.a(this.f55720a, (a.b) cVar.f54033b, this.f55720a.a());
            } else if (i2 == 2) {
                b.b(this.f55720a, cVar.f54034c);
            }
        }
    }

    static final class f<T> implements z<ArrayList<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55721a;

        f(b bVar) {
            this.f55721a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            net.one97.paytm.moneytransfer.view.a.g e2 = b.e(this.f55721a);
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            e2.a((List<String>) arrayList);
        }
    }

    static final class g<T> implements z<net.one97.paytm.moneytransfer.model.c<ArrayList<BeneficiaryEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55722a;

        g(b bVar) {
            this.f55722a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (c.f55732d[cVar.f54032a.ordinal()] == 1) {
                b.b(this.f55722a, (ArrayList) cVar.f54033b);
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.moneytransfer.model.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55723a;

        h(b bVar) {
            this.f55723a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar.f54032a == net.one97.paytm.moneytransfer.model.d.LOADING) {
                CustomWalletLoaderDialog.getInstance(this.f55723a.getContext()).showLoader();
            } else {
                CustomWalletLoaderDialog.getInstance(this.f55723a.getContext()).dismissLoader();
            }
            int i2 = c.f55733e[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                b bVar = this.f55723a;
                ResultType resulttype = cVar.f54033b;
                if (resulttype == null) {
                    kotlin.g.b.k.a();
                }
                b.a(bVar, (String) resulttype);
            } else if (i2 == 2) {
                b.c(this.f55723a, cVar.f54034c);
            }
        }
    }

    static final class j<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55725a;

        j(b bVar) {
            this.f55725a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (!kotlin.g.b.k.a((Object) b.c(this.f55725a).f55686d, (Object) str)) {
                this.f55725a.getChildFragmentManager().d();
                b.b(this.f55725a);
                kotlin.g.b.k.a((Object) str, "query");
                List<IJRDataModel> a2 = net.one97.paytm.moneytransfer.viewmodel.g.a(str, (List<? extends IJRDataModel>) b.c(this.f55725a).f55688f);
                a c2 = b.c(this.f55725a);
                kotlin.g.b.k.c(str, "query");
                c2.f55686d = str;
                a c3 = b.c(this.f55725a);
                kotlin.g.b.k.c(a2, "filteredList");
                c3.f55687e = a2;
                c3.notifyDataSetChanged();
                if (a2.isEmpty()) {
                    b bVar = this.f55725a;
                    b.b(bVar, bVar.a());
                    return;
                }
                RecyclerView recyclerView = this.f55725a.a().f53777b;
                kotlin.g.b.k.a((Object) recyclerView, "binding.contactsRecyclerView");
                net.one97.paytm.upi.f.b((View) recyclerView);
                TextView textView = this.f55725a.a().m;
                kotlin.g.b.k.a((Object) textView, "binding.tvBtnProceed");
                net.one97.paytm.upi.f.a((View) textView);
                RecyclerView recyclerView2 = this.f55725a.a().n;
                kotlin.g.b.k.a((Object) recyclerView2, "binding.vpaRecyclerView");
                net.one97.paytm.upi.f.a((View) recyclerView2);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.viewmodel.g b(b bVar) {
        net.one97.paytm.moneytransfer.viewmodel.g gVar = bVar.f55712f;
        if (gVar == null) {
            kotlin.g.b.k.a("moneyTransferViewAllBeneficiaryViewModel");
        }
        return gVar;
    }

    public static final /* synthetic */ a c(b bVar) {
        a aVar = bVar.f55711e;
        if (aVar == null) {
            kotlin.g.b.k.a("searchAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.contacts.b.a d(b bVar) {
        net.one97.paytm.moneytransfer.contacts.b.a aVar = bVar.f55709b;
        if (aVar == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.view.a.g e(b bVar) {
        net.one97.paytm.moneytransfer.view.a.g gVar = bVar.f55710c;
        if (gVar == null) {
            kotlin.g.b.k.a("upiTagsListAdapter");
        }
        return gVar;
    }

    /* access modifiers changed from: private */
    public final net.one97.paytm.moneytransfer.c.l a() {
        net.one97.paytm.moneytransfer.c.l lVar = this.f55714h;
        if (lVar == null) {
            kotlin.g.b.k.a();
        }
        return lVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_money_transfer_contact_search, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f55714h = net.one97.paytm.moneytransfer.c.l.a(view);
        net.one97.paytm.moneytransfer.c.l a2 = a();
        a2.m.setOnClickListener(new l(this));
        a2.f53781f.setOnClickListener(new m(this));
        this.f55710c = new net.one97.paytm.moneytransfer.view.a.g();
        net.one97.paytm.moneytransfer.view.a.g gVar = this.f55710c;
        if (gVar == null) {
            kotlin.g.b.k.a("upiTagsListAdapter");
        }
        gVar.a((g.a) new a(this));
        RecyclerView recyclerView = a().n;
        kotlin.g.b.k.a((Object) recyclerView, "binding.vpaRecyclerView");
        net.one97.paytm.moneytransfer.view.a.g gVar2 = this.f55710c;
        if (gVar2 == null) {
            kotlin.g.b.k.a("upiTagsListAdapter");
        }
        recyclerView.setAdapter(gVar2);
        this.f55711e = new a(new ArrayList(), this);
        RecyclerView recyclerView2 = a().f53777b;
        kotlin.g.b.k.a((Object) recyclerView2, "binding.contactsRecyclerView");
        a aVar = this.f55711e;
        if (aVar == null) {
            kotlin.g.b.k.a("searchAdapter");
        }
        recyclerView2.setAdapter(aVar);
        RecyclerView recyclerView3 = a().f53777b;
        kotlin.g.b.k.a((Object) recyclerView3, "binding.contactsRecyclerView");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        Fragment fragment = this;
        ai a3 = am.a(fragment, (al.b) null).a(net.one97.paytm.moneytransfer.contacts.b.a.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f55709b = (net.one97.paytm.moneytransfer.contacts.b.a) a3;
        ai a4 = am.a(fragment, (al.b) null).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.class);
        kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f55708a = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a) a4;
        ai a5 = am.a(fragment, (al.b) null).a(net.one97.paytm.moneytransfer.viewmodel.g.class);
        kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f55712f = (net.one97.paytm.moneytransfer.viewmodel.g) a5;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = this.f55708a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        aVar2.f55561a.observe(getViewLifecycleOwner(), new C1039b(this));
        net.one97.paytm.moneytransfer.contacts.b.a aVar3 = this.f55709b;
        if (aVar3 == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        aVar3.f53970b.observe(getViewLifecycleOwner(), new c(this));
        net.one97.paytm.moneytransfer.contacts.b.a aVar4 = this.f55709b;
        if (aVar4 == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        aVar4.f53971c.observe(getViewLifecycleOwner(), new d(this));
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar5 = this.f55708a;
        if (aVar5 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        aVar5.o.observe(getViewLifecycleOwner(), new e(this));
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar6 = this.f55708a;
        if (aVar6 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        aVar6.q.observe(getViewLifecycleOwner(), new f(this));
        net.one97.paytm.moneytransfer.viewmodel.g gVar3 = this.f55712f;
        if (gVar3 == null) {
            kotlin.g.b.k.a("moneyTransferViewAllBeneficiaryViewModel");
        }
        gVar3.f54759d.observe(getViewLifecycleOwner(), new g(this));
        net.one97.paytm.moneytransfer.contacts.b.a aVar7 = this.f55709b;
        if (aVar7 == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        aVar7.f53972d.observe(getViewLifecycleOwner(), new h(this));
        TextInputEditText textInputEditText = a().f53776a;
        kotlin.g.b.k.a((Object) textInputEditText, "binding.contactEditText");
        textInputEditText.addTextChangedListener(new i(this));
        net.one97.paytm.moneytransfer.viewmodel.g gVar4 = this.f55712f;
        if (gVar4 == null) {
            kotlin.g.b.k.a("moneyTransferViewAllBeneficiaryViewModel");
        }
        gVar4.f54760e.observe(getViewLifecycleOwner(), new j(this));
        a().f53782g.setOnClickListener(new k(this));
        net.one97.paytm.moneytransfer.viewmodel.g gVar5 = this.f55712f;
        if (gVar5 == null) {
            kotlin.g.b.k.a("moneyTransferViewAllBeneficiaryViewModel");
        }
        gVar5.f54758c = 100;
        gVar5.a(0);
        if (PermissionUtil.checkReadContactsPermission(getContext())) {
            b();
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, this.f55713g);
        }
    }

    private final void b() {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.f55708a;
        if (aVar == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        if (!aVar.f55562b) {
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = this.f55708a;
            if (aVar2 == null) {
                kotlin.g.b.k.a("moneyTransferActivityViewModel");
            }
            aVar2.a();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55727a;

        l(b bVar) {
            this.f55727a = bVar;
        }

        public final void onClick(View view) {
            b bVar = this.f55727a;
            b.a(bVar, bVar.a());
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55728a;

        m(b bVar) {
            this.f55728a = bVar;
        }

        public final void onClick(View view) {
            Intent intent;
            com.paytm.utility.b.c((Activity) this.f55728a.getActivity());
            FragmentActivity activity = this.f55728a.getActivity();
            boolean z = false;
            if (!(activity == null || (intent = activity.getIntent()) == null)) {
                z = intent.getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false);
            }
            if (z) {
                FragmentActivity activity2 = this.f55728a.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                    return;
                }
                return;
            }
            FragmentActivity activity3 = this.f55728a.getActivity();
            if (activity3 != null) {
                activity3.onBackPressed();
            }
        }
    }

    public static final class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55724a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public i(b bVar) {
            this.f55724a = bVar;
        }

        public final void afterTextChanged(Editable editable) {
            ImageView imageView = this.f55724a.a().f53782g;
            kotlin.g.b.k.a((Object) imageView, "binding.ivCrossSearch");
            View view = imageView;
            CharSequence obj = editable != null ? editable.toString() : null;
            net.one97.paytm.upi.f.a(view, !(obj == null || p.a(obj)));
            TextView textView = this.f55724a.a().k;
            kotlin.g.b.k.a((Object) textView, "binding.searchError");
            textView.setText("");
            b.b(this.f55724a).a(String.valueOf(editable));
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55726a;

        k(b bVar) {
            this.f55726a = bVar;
        }

        public final void onClick(View view) {
            TextInputEditText textInputEditText = this.f55726a.a().f53776a;
            kotlin.g.b.k.a((Object) textInputEditText, "binding.contactEditText");
            Editable text = textInputEditText.getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    public static final class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55716a;

        a(b bVar) {
            this.f55716a = bVar;
        }

        public final void b(String str) {
            kotlin.g.b.k.c(str, "tag");
            StringBuilder sb = new StringBuilder();
            TextInputEditText textInputEditText = this.f55716a.a().f53776a;
            kotlin.g.b.k.a((Object) textInputEditText, "binding.contactEditText");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (valueOf != null) {
                String obj = p.b(valueOf).toString();
                int a2 = p.a((CharSequence) obj, "@", 0, false, 6);
                if (a2 != -1) {
                    int i2 = a2 + 1;
                    if (obj != null) {
                        obj = obj.substring(0, i2);
                        kotlin.g.b.k.a((Object) obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                sb.append(obj);
                sb.append(str);
                this.f55716a.a().f53776a.setText(sb.toString());
                this.f55716a.a().f53776a.setSelection(sb.length());
                this.f55716a.a().m.callOnClick();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    private final void d() {
        if (getActivity() != null) {
            c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
            if (!TextUtils.isEmpty(net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53989d))) {
                f();
                return;
            }
        }
        e();
    }

    private final void e() {
        net.one97.paytm.moneytransfer.contacts.b.a aVar = this.f55709b;
        if (aVar == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        String str = aVar.f53973e;
        net.one97.paytm.moneytransferv4.b bVar = new net.one97.paytm.moneytransferv4.b();
        Bundle bundle = new Bundle();
        bundle.putString(ContactColumn.PHONE_NUMBER, str);
        bVar.setArguments(bundle);
        net.one97.paytm.moneytransfer.utils.m.a(R.id.container, (Fragment) bVar, "MoneyTransferEnterBankAccountOrUPIFragment", getFragmentManager());
    }

    private final void f() {
        net.one97.paytm.moneytransfer.contacts.b.a aVar = this.f55709b;
        if (aVar == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        String a2 = aVar.a();
        b.a aVar2 = net.one97.paytm.moneytransferv4.invite.b.f55654a;
        if (a2 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.moneytransfer.contacts.b.a aVar3 = this.f55709b;
        if (aVar3 == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        net.one97.paytm.moneytransfer.utils.m.a(R.id.inviteContainer, (Fragment) b.a.a(a2, aVar3.a()), "InviteContactFragment", getChildFragmentManager());
    }

    public final void a(IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(iJRDataModel, "item");
        if (!(iJRDataModel instanceof BeneficiaryEntity) && (iJRDataModel instanceof ContactItemModel)) {
            net.one97.paytm.moneytransfer.contacts.b.a aVar = this.f55709b;
            if (aVar == null) {
                kotlin.g.b.k.a("contactViewModel");
            }
            aVar.c();
            ContactItemModel contactItemModel = (ContactItemModel) iJRDataModel;
            aVar.f53974f = contactItemModel.getName();
            aVar.f53975g = contactItemModel.getPhotoUri();
            String phnNo = contactItemModel.getPhnNo();
            CharSequence charSequence = phnNo;
            if (!(charSequence == null || p.a(charSequence))) {
                net.one97.paytm.moneytransfer.contacts.b.a aVar2 = this.f55709b;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("contactViewModel");
                }
                aVar2.f53973e = phnNo;
                if (com.paytm.utility.a.m(getActivity())) {
                    net.one97.paytm.moneytransfer.contacts.b.a aVar3 = this.f55709b;
                    if (aVar3 == null) {
                        kotlin.g.b.k.a("contactViewModel");
                    }
                    aVar3.a(phnNo);
                    return;
                }
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (PermissionUtil.areAllPermissionsGranted(iArr)) {
            b();
            kotlin.g.a.b<? super x, x> bVar = this.f55715i;
            if (bVar != null) {
                bVar.invoke(x.f47997a);
            }
        }
    }

    public final void onDestroyView() {
        this.f55714h = null;
        super.onDestroyView();
        c();
    }

    public final void onDestroy() {
        this.f55715i = null;
        super.onDestroy();
    }

    public static final /* synthetic */ void a(b bVar, net.one97.paytm.moneytransfer.c.l lVar) {
        net.one97.paytm.moneytransfer.contacts.b.a aVar = bVar.f55709b;
        if (aVar == null) {
            kotlin.g.b.k.a("contactViewModel");
        }
        aVar.c();
        TextInputEditText textInputEditText = lVar.f53776a;
        kotlin.g.b.k.a((Object) textInputEditText, "contactEditText");
        String valueOf = String.valueOf(textInputEditText.getText());
        if (valueOf != null) {
            String obj = p.b(valueOf).toString();
            CharSequence charSequence = obj;
            boolean z = false;
            if (!net.one97.paytm.upi.f.b(charSequence)) {
                if (TextUtils.isEmpty(charSequence)) {
                    TextView textView = lVar.k;
                    kotlin.g.b.k.a((Object) textView, "binding.searchError");
                    textView.setText(bVar.getString(R.string.upi_empty_vpa_error));
                } else if (obj.length() > 255) {
                    TextView textView2 = lVar.k;
                    kotlin.g.b.k.a((Object) textView2, "binding.searchError");
                    textView2.setText(bVar.getString(R.string.upi_vpa_length_breach));
                } else if (!new kotlin.m.l("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+").matches(charSequence)) {
                    TextView textView3 = lVar.k;
                    kotlin.g.b.k.a((Object) textView3, "binding.searchError");
                    textView3.setText(bVar.getString(R.string.upi_invalid_upi));
                } else {
                    TextView textView4 = lVar.k;
                    kotlin.g.b.k.a((Object) textView4, "binding.searchError");
                    textView4.setText("");
                    z = true;
                }
                if (z) {
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = bVar.f55708a;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("moneyTransferActivityViewModel");
                    }
                    aVar2.a(obj, "");
                }
            } else if (net.one97.paytm.moneytransfer.utils.m.d(obj)) {
                bVar.a((IJRDataModel) new ContactItemModel(obj, obj, "", false));
            } else {
                TextView textView5 = lVar.k;
                kotlin.g.b.k.a((Object) textView5, "searchError");
                textView5.setText(bVar.getString(R.string.mt_invalid_phone_number));
            }
        } else {
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    public static final /* synthetic */ void b(b bVar, net.one97.paytm.moneytransfer.c.l lVar) {
        TextInputEditText textInputEditText = lVar.f53776a;
        kotlin.g.b.k.a((Object) textInputEditText, "binding.contactEditText");
        String valueOf = String.valueOf(textInputEditText.getText());
        if (valueOf != null) {
            String obj = p.b(valueOf).toString();
            RecyclerView recyclerView = lVar.f53777b;
            kotlin.g.b.k.a((Object) recyclerView, "binding.contactsRecyclerView");
            net.one97.paytm.upi.f.a((View) recyclerView);
            TextInputEditText textInputEditText2 = lVar.f53776a;
            kotlin.g.b.k.a((Object) textInputEditText2, "binding.contactEditText");
            if (p.a((CharSequence) String.valueOf(textInputEditText2.getText()), '@', false)) {
                TextView textView = lVar.m;
                kotlin.g.b.k.a((Object) textView, "binding.tvBtnProceed");
                net.one97.paytm.upi.f.b((View) textView);
                RecyclerView recyclerView2 = lVar.n;
                kotlin.g.b.k.a((Object) recyclerView2, "binding.vpaRecyclerView");
                net.one97.paytm.upi.f.b((View) recyclerView2);
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = bVar.f55708a;
                if (aVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                kotlin.g.b.k.c(obj, "query");
                String substring = obj.substring(p.a((CharSequence) obj, "@", 0, false, 6) + 1, obj.length());
                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (aVar.r == null || aVar.r.size() == 0) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.d.c.C;
                    List<String> a2 = p.a((CharSequence) net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53991f), new String[]{AppConstants.COMMA});
                    if (a2 != null && (!a2.isEmpty())) {
                        for (String next : a2) {
                            ArrayList<String> arrayList = aVar.r;
                            if (arrayList != null) {
                                arrayList.add(next);
                            }
                        }
                        aVar.q.setValue(aVar.r);
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                if (aVar.r != null) {
                    Iterator<String> it2 = aVar.r.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        kotlin.g.b.k.a((Object) next2, "t");
                        if (next2 != null) {
                            String lowerCase = next2.toLowerCase();
                            kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (p.b(lowerCase, substring, false)) {
                                arrayList2.add(next2);
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
                y<ArrayList<String>> yVar = aVar.q;
                if (yVar != null) {
                    yVar.setValue(arrayList2);
                    return;
                }
                return;
            }
            TextInputEditText textInputEditText3 = lVar.f53776a;
            kotlin.g.b.k.a((Object) textInputEditText3, "binding.contactEditText");
            if (net.one97.paytm.upi.f.b((CharSequence) String.valueOf(textInputEditText3.getText()))) {
                TextView textView2 = lVar.m;
                kotlin.g.b.k.a((Object) textView2, "binding.tvBtnProceed");
                net.one97.paytm.upi.f.b((View) textView2);
                RecyclerView recyclerView3 = lVar.n;
                kotlin.g.b.k.a((Object) recyclerView3, "binding.vpaRecyclerView");
                net.one97.paytm.upi.f.a((View) recyclerView3);
                return;
            }
            TextView textView3 = lVar.k;
            kotlin.g.b.k.a((Object) textView3, "binding.searchError");
            textView3.setText(bVar.getString(R.string.contact_not_found_error, obj));
            TextView textView4 = lVar.m;
            kotlin.g.b.k.a((Object) textView4, "binding.tvBtnProceed");
            net.one97.paytm.upi.f.a((View) textView4);
            RecyclerView recyclerView4 = lVar.n;
            kotlin.g.b.k.a((Object) recyclerView4, "binding.vpaRecyclerView");
            net.one97.paytm.upi.f.a((View) recyclerView4);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final /* synthetic */ void a(b bVar, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        String string = bVar.getString(R.string.mt_contacts);
        kotlin.g.b.k.a((Object) string, "getString(R.string.mt_contacts)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            kotlin.g.b.k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            arrayList2.add(new SearchTitleModel(upperCase));
            arrayList2.addAll(arrayList);
            a aVar = bVar.f55711e;
            if (aVar == null) {
                kotlin.g.b.k.a("searchAdapter");
            }
            aVar.a((ArrayList<IJRDataModel>) arrayList2, 0);
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.c.l lVar) {
        FrameLayout frameLayout = lVar.f53784i;
        kotlin.g.b.k.a((Object) frameLayout, "binding.moneyTransferLoaderContainer");
        net.one97.paytm.upi.f.b((View) frameLayout);
        UpiUtils.startWalletLoader(lVar.f53783h);
    }

    public static final /* synthetic */ void b(net.one97.paytm.moneytransfer.c.l lVar) {
        FrameLayout frameLayout = lVar.f53784i;
        kotlin.g.b.k.a((Object) frameLayout, "binding.moneyTransferLoaderContainer");
        net.one97.paytm.upi.f.a((View) frameLayout);
        UpiUtils.stopWalletLoader(lVar.f53783h);
    }

    public static final /* synthetic */ void a(b bVar, a.b bVar2) {
        if (bVar2 != null) {
            if (bVar2.f53978b) {
                bVar.d();
            }
            ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList = bVar2.f53977a;
            if (paymentOptionList != null) {
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment, "paymentOptionListItem.destinationPayment");
                if (destinationPayment.getError() != null) {
                    bVar.d();
                    return;
                }
                ConsolidatePaymentInstrumentationRes.SourcePayment sourcePayment = paymentOptionList.getSourcePayment();
                kotlin.g.b.k.a((Object) sourcePayment, "paymentOptionListItem.sourcePayment");
                if (p.a(sourcePayment.getPaymentType(), PaymentInstrumentationType.UPI_LEAD.name(), true)) {
                    bVar.e();
                    return;
                }
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment2 = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment2, "paymentOptionListItem.destinationPayment");
                if (p.a(destinationPayment2.getPaymentType(), PaymentInstrumentationType.UPI.name(), true)) {
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment3 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment3, "paymentOptionListItem.destinationPayment");
                    destinationPayment3.getVpaId();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment4 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment4, "paymentOptionListItem.destinationPayment");
                    destinationPayment4.getDisplayName();
                    net.one97.paytm.moneytransfer.utils.f.a(bVar.getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SELECTED_CONTACT_STATUS, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "linked_upi", "");
                    return;
                }
                ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment5 = paymentOptionList.getDestinationPayment();
                kotlin.g.b.k.a((Object) destinationPayment5, "paymentOptionListItem.destinationPayment");
                if (p.a(destinationPayment5.getPaymentType(), PaymentInstrumentationType.BANK.name(), true)) {
                    net.one97.paytm.moneytransfer.utils.f.a(bVar.getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SELECTED_CONTACT_STATUS, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "linked_bank", "");
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment6 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment6, "paymentOptionListItem.destinationPayment");
                    destinationPayment6.getBankAccountNumber();
                    net.one97.paytm.moneytransfer.contacts.b.a aVar = bVar.f55709b;
                    if (aVar == null) {
                        kotlin.g.b.k.a("contactViewModel");
                    }
                    aVar.a();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment7 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment7, "paymentOptionListItem.destinationPayment");
                    destinationPayment7.getIfscCode();
                    ConsolidatePaymentInstrumentationRes.DestinationPayment destinationPayment8 = paymentOptionList.getDestinationPayment();
                    kotlin.g.b.k.a((Object) destinationPayment8, "paymentOptionListItem.destinationPayment");
                    destinationPayment8.getBankName();
                }
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, UpiCustomVolleyError upiCustomVolleyError) {
        a aVar = bVar.f55711e;
        if (aVar == null) {
            kotlin.g.b.k.a("searchAdapter");
        }
        aVar.a(false);
        String str = null;
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
            net.one97.paytm.moneytransfer.utils.m.b((Activity) bVar.getActivity());
            return;
        }
        if (upiCustomVolleyError != null) {
            str = upiCustomVolleyError.getmErrorCode();
        }
        if ("1997".equals(str)) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            Context context = bVar.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.moneytransfer.contacts.b.a aVar3 = bVar.f55709b;
            if (aVar3 == null) {
                kotlin.g.b.k.a("contactViewModel");
            }
            b2.a(context, aVar3.b());
            return;
        }
        bVar.d();
    }

    public static final /* synthetic */ void a(b bVar, a.b bVar2, net.one97.paytm.moneytransfer.c.l lVar) {
        String str;
        String str2;
        Integer num = null;
        if (bVar2 != null) {
            str = bVar2.f55575b;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            TextInputEditText textInputEditText = lVar.f53776a;
            kotlin.g.b.k.a((Object) textInputEditText, "binding.contactEditText");
            String valueOf = String.valueOf(textInputEditText.getText());
            if (valueOf != null) {
                p.b(valueOf);
                if (str == null) {
                    kotlin.g.b.k.a();
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (bVar2 != null) {
            str2 = bVar2.f55576c;
        } else {
            str2 = null;
        }
        if (bVar2 != null) {
            num = Integer.valueOf(bVar2.f55574a);
        }
        if (num != null && num.intValue() == 1) {
            TextView textView = lVar.k;
            kotlin.g.b.k.a((Object) textView, "binding.searchError");
            textView.setText(bVar.getString(R.string.upi_unable_to_verify_vpa));
        } else if (num == null || num.intValue() != 2) {
        } else {
            if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str2, true)) {
                net.one97.paytm.moneytransfer.utils.m.b((Activity) bVar.getActivity());
            } else if (p.a("XH", str2, true) || p.a("J02", str2, true) || p.a("U17", str2, true) || p.a("0037", str2, true)) {
                TextView textView2 = lVar.k;
                kotlin.g.b.k.a((Object) textView2, "binding.searchError");
                textView2.setText(bVar.getString(R.string.upi_address_incorrect));
            } else if (p.a("INT-1470", str2, true)) {
                TextView textView3 = lVar.k;
                kotlin.g.b.k.a((Object) textView3, "binding.searchError");
                textView3.setText(bVar.getString(R.string.mt_vpa_verify_no_bank_linked_err));
            } else if (p.a("1006", str2, true)) {
                Intent intent = new Intent(bVar.getActivity(), UpiRegistrationActivity.class);
                intent.putExtra("redirect", 80);
                intent.setFlags(536870912);
                bVar.startActivityForResult(intent, 2013);
            }
        }
    }

    public static final /* synthetic */ void b(b bVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
            net.one97.paytm.moneytransfer.utils.m.b((Activity) bVar.getActivity());
        } else {
            bVar.f();
        }
    }

    public static final /* synthetic */ void b(b bVar, ArrayList arrayList) {
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            ArrayList arrayList2 = new ArrayList();
            a aVar = bVar.f55711e;
            if (aVar == null) {
                kotlin.g.b.k.a("searchAdapter");
            }
            if (!aVar.f55685c) {
                String string = bVar.getString(R.string.mt_saved_accounts_label);
                kotlin.g.b.k.a((Object) string, "getString(R.string.mt_saved_accounts_label)");
                if (string != null) {
                    String upperCase = string.toUpperCase();
                    kotlin.g.b.k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                    arrayList2.add(new SearchTitleModel(upperCase));
                    a aVar2 = bVar.f55711e;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("searchAdapter");
                    }
                    aVar2.f55685c = true;
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            arrayList2.addAll(collection);
            a aVar3 = bVar.f55711e;
            if (aVar3 == null) {
                kotlin.g.b.k.a("searchAdapter");
            }
            a aVar4 = bVar.f55711e;
            if (aVar4 == null) {
                kotlin.g.b.k.a("searchAdapter");
            }
            aVar3.a((ArrayList<IJRDataModel>) arrayList2, aVar4.f55688f.size());
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        Intent createChooser = Intent.createChooser(intent, "Share via");
        FragmentActivity activity = bVar.getActivity();
        if (activity != null) {
            activity.startActivity(createChooser);
        }
    }

    public static final /* synthetic */ void c(b bVar, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null || !upiCustomVolleyError.getmErrorCode().equals(UpiConstants.NETWORK_ERROR_CODE)) {
            Toast.makeText(bVar.getActivity(), net.one97.paytm.upi.R.string.upi_some_went_wrong, 0).show();
        } else {
            CustomDialog.showAlert(bVar.getActivity(), bVar.getString(net.one97.paytm.upi.R.string.no_connection), bVar.getString(net.one97.paytm.upi.R.string.no_internet_new_message));
        }
    }
}
