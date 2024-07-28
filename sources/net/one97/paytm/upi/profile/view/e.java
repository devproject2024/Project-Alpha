package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.e.ac;
import net.one97.paytm.upi.e.r;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.j.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.d;
import net.one97.paytm.upi.registration.view.h;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class e extends h implements d.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68228a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f68229b = "paytmmp://payment_bank?featuretype=bank_landing";

    /* renamed from: c  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68230c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upi.j.a f68231d;

    /* renamed from: e  reason: collision with root package name */
    private r f68232e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f68233f;

    /* renamed from: net.one97.paytm.upi.profile.view.e$e  reason: collision with other inner class name */
    static final class C1384e<T> implements z<o<? extends String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68237a;

        C1384e(e eVar) {
            this.f68237a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final o oVar = (o) obj;
            ConstraintLayout constraintLayout = e.b(this.f68237a).f66878a;
            k.a((Object) constraintLayout, "viewBinding.accountOpenContainer");
            f.b((View) constraintLayout);
            if (oVar != null || this.f68237a.getContext() == null) {
                Context context = this.f68237a.getContext();
                if (context == null) {
                    k.a();
                }
                com.bumptech.glide.b.b(context).a(oVar != null ? (String) oVar.getFirst() : null).a(e.b(this.f68237a).f66881d);
                e.b(this.f68237a).f66878a.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ C1384e f68239a;

                    {
                        this.f68239a = r1;
                    }

                    public final void onClick(View view) {
                        e eVar = this.f68239a.f68237a;
                        o oVar = oVar;
                        if (oVar == null) {
                            k.a();
                        }
                        e.a(eVar, (String) oVar.getSecond());
                    }
                });
                return;
            }
            ImageView imageView = e.b(this.f68237a).f66881d;
            k.a((Object) imageView, "viewBinding.ppblBanner");
            Context context2 = this.f68237a.getContext();
            if (context2 == null) {
                k.a();
            }
            imageView.setBackground(androidx.core.content.b.a(context2, R.drawable.upi_ppbl_account_opening_banner));
            e.b(this.f68237a).f66878a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C1384e f68238a;

                {
                    this.f68238a = r1;
                }

                public final void onClick(View view) {
                    e.a(this.f68238a.f68237a, this.f68238a.f68237a.f68229b);
                }
            });
        }
    }

    public static final /* synthetic */ r b(e eVar) {
        r rVar = eVar.f68232e;
        if (rVar == null) {
            k.a("viewBinding");
        }
        return rVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(AccountProviderBody.AccountProvider accountProvider) {
            k.c(accountProvider, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(UpiConstants.EXTRA_SELECTED_BANK) : null;
        if (serializable != null) {
            this.f68230c = (AccountProviderBody.AccountProvider) serializable;
            ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.j.a.class);
            k.a((Object) a2, "ViewModelProviders.of(th…untViewModel::class.java)");
            this.f68231d = (net.one97.paytm.upi.j.a) a2;
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_NO_BANK_ACC_FOUND, "");
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_no_bank_account_found, viewGroup, false);
        r a2 = r.a(inflate);
        k.a((Object) a2, "FragmentNoBankAccountFoundBinding.bind(view)");
        this.f68232e = a2;
        r rVar = this.f68232e;
        if (rVar == null) {
            k.a("viewBinding");
        }
        if (this.f68230c != null) {
            if (this.f68230c == null) {
                k.a("provider");
            }
            TextView textView = rVar.f66879b.f66738b;
            k.a((Object) textView, "accountSwitch.accountChange");
            textView.setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
        }
        ac acVar = rVar.f66879b;
        k.a((Object) acVar, "accountSwitch");
        acVar.a().setOnClickListener(new b(this));
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.upi.j.a aVar = this.f68231d;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.f67008a.a((a.C1389a) new a.b(aVar), "", "");
        net.one97.paytm.upi.j.a aVar2 = this.f68231d;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        aVar2.f67010c.observe(getViewLifecycleOwner(), new c(this));
        net.one97.paytm.upi.j.a aVar3 = this.f68231d;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c().g(aVar3.getApplication()) == a.C1348a.ISSUED.getNumVal()) {
            aVar3.f67011d.setValue(Boolean.TRUE);
        } else {
            aVar3.f67009b.b(new a.c(aVar3));
        }
        net.one97.paytm.upi.j.a aVar4 = this.f68231d;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        aVar4.f67011d.observe(getViewLifecycleOwner(), new d(this));
    }

    public static final class c implements z<List<? extends AccountProviderBody.AccountProvider>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68235a;

        c(e eVar) {
            this.f68235a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                e eVar = this.f68235a;
                if (list != null) {
                    e.a(eVar, (List) e.a(eVar, (ArrayList) list));
                    return;
                }
                throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider>");
            }
        }
    }

    public static final class d implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68236a;

        d(e eVar) {
            this.f68236a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            e.a(this.f68236a, (Boolean) obj);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        k.c(accountProvider, "bankProvider");
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof b)) {
            parentFragment = null;
        }
        b bVar = (b) parentFragment;
        if (bVar != null) {
            bVar.a(accountProvider);
        }
        Fragment parentFragment2 = getParentFragment();
        if (!(parentFragment2 instanceof b)) {
            parentFragment2 = null;
        }
        b bVar2 = (b) parentFragment2;
        if (bVar2 != null) {
            bVar2.d(GAConstants.ACTION.TOP_BANK_SELECTED);
        }
    }

    public final void a() {
        AccountProviderActivity.a((Activity) getActivity(), 2);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof b)) {
            parentFragment = null;
        }
        b bVar = (b) parentFragment;
        if (bVar != null) {
            bVar.d(GAConstants.ACTION.OTHER_BANK_SELECTED);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68234a;

        b(e eVar) {
            this.f68234a = eVar;
        }

        public final void onClick(View view) {
            e.a(this.f68234a);
        }
    }

    public static final /* synthetic */ void a(e eVar, List list) {
        if (eVar.isAdded() && eVar.getActivity() != null) {
            r rVar = eVar.f68232e;
            if (rVar == null) {
                k.a("viewBinding");
            }
            RecyclerView recyclerView = rVar.f66880c;
            k.a((Object) recyclerView, "viewBinding.favBanksRecycler");
            recyclerView.setLayoutManager(new GridLayoutManager(eVar.getContext(), 5));
            r rVar2 = eVar.f68232e;
            if (rVar2 == null) {
                k.a("viewBinding");
            }
            RecyclerView recyclerView2 = rVar2.f66880c;
            k.a((Object) recyclerView2, "viewBinding.favBanksRecycler");
            recyclerView2.setAdapter(new net.one97.paytm.upi.registration.view.d(list, eVar));
        }
    }

    public static final /* synthetic */ ArrayList a(e eVar, ArrayList arrayList) {
        Iterator it2 = arrayList.iterator();
        k.a((Object) it2, "list.iterator()");
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (it2.hasNext()) {
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) it2.next();
            String iin = accountProvider.getIin();
            AccountProviderBody.AccountProvider accountProvider2 = eVar.f68230c;
            if (accountProvider2 == null) {
                k.a("provider");
            }
            if (!k.a((Object) iin, (Object) accountProvider2.getIin())) {
                if (i2 >= 4) {
                    break;
                }
                arrayList2.add(accountProvider);
                i2++;
            }
        }
        AccountProviderBody.AccountProvider accountProvider3 = new AccountProviderBody.AccountProvider();
        if (eVar.getContext() != null) {
            Context context = eVar.getContext();
            accountProvider3.setAccountProvider(context != null ? context.getString(R.string.upi_others) : null);
            arrayList2.add(accountProvider3);
        }
        return arrayList2;
    }

    public static final /* synthetic */ void a(e eVar, Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            net.one97.paytm.upi.j.a aVar = eVar.f68231d;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.f67009b.a((a.c) new a.d(aVar));
            aVar.f67012e.observe(eVar.getViewLifecycleOwner(), new C1384e(eVar));
            return;
        }
        r rVar = eVar.f68232e;
        if (rVar == null) {
            k.a("viewBinding");
        }
        ConstraintLayout constraintLayout = rVar.f66878a;
        k.a((Object) constraintLayout, "viewBinding.accountOpenContainer");
        f.a((View) constraintLayout);
    }

    public static final /* synthetic */ void a(e eVar) {
        if (eVar.getActivity() != null && eVar.isAdded()) {
            h.a aVar = net.one97.paytm.upi.registration.view.h.f68882a;
            new net.one97.paytm.upi.registration.view.h().showNow(eVar.getChildFragmentManager(), net.one97.paytm.upi.registration.view.h.class.getName());
        }
    }

    public static final /* synthetic */ void a(e eVar, String str) {
        FragmentActivity activity;
        if (eVar.getActivity() != null && eVar.isAdded()) {
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            net.one97.paytm.upi.h c2 = a2.c();
            if (c2 != null) {
                c2.a((Activity) eVar.getActivity(), str);
            }
            if (eVar.isAdded() && (activity = eVar.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f68233f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
