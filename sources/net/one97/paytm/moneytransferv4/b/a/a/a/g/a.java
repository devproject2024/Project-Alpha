package net.one97.paytm.moneytransferv4.b.a.a.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final C1014a f55292b = new C1014a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upi.registration.b.a.b f55293a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f55294c = 1002;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f55295d = 1003;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f55296e = 1004;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f55297f = IuserActions.SCROLL_MAIN_RV;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.upi.j.a f55298g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f55299h = CJRGTMConstants.MT_V4_HOME_SCREEN_NAME;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f55300i = "mt_p2p_new_v1";
    private HashMap j;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.j.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…untViewModel::class.java)");
        this.f55298g = (net.one97.paytm.upi.j.a) a2;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_mt_v4_payment_options, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.optionsRv);
        k.a((Object) recyclerView, "recyclerView");
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new c(new b(this)));
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        }
        return inflate;
    }

    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55301a;

        b(a aVar) {
            this.f55301a = aVar;
        }

        public final void a(net.one97.paytm.moneytransferv4.a aVar) {
            k.c(aVar, "option");
            int i2 = b.f55302a[aVar.ordinal()];
            if (i2 == 1) {
                f.a(this.f55301a.getContext(), this.f55301a.f55300i, CJRGTMConstants.MT_V4_CHECK_BAL_HISTORY_CLICKED, this.f55301a.f55299h, "", "");
                if (this.f55301a.a()) {
                    if (!this.f55301a.c()) {
                        q.a aVar2 = q.f68356a;
                        Context context = this.f55301a.getContext();
                        if (context == null) {
                            k.a();
                        }
                        k.a((Object) context, "context!!");
                        q.a.a(context, this.f55301a.f55297f, (Fragment) this.f55301a);
                        return;
                    }
                    this.f55301a.a("money_transfer_check_balance");
                } else if (this.f55301a.b()) {
                    a aVar3 = this.f55301a;
                    a.a(aVar3, aVar3.f55295d);
                } else {
                    AccountProviderActivity.a((Fragment) this.f55301a, 288);
                }
            } else if (i2 == 2) {
                f.a(this.f55301a.getContext(), this.f55301a.f55300i, CJRGTMConstants.MT_V4_SELF_ACCOUNT_CLICKED, this.f55301a.f55299h, "", "");
                if (this.f55301a.a()) {
                    if (!this.f55301a.c()) {
                        q.a aVar4 = q.f68356a;
                        Context context2 = this.f55301a.getContext();
                        if (context2 == null) {
                            k.a();
                        }
                        k.a((Object) context2, "context!!");
                        q.a.a(context2, this.f55301a.f55297f, (Fragment) this.f55301a);
                        return;
                    }
                    this.f55301a.a("money_transfer_self");
                } else if (this.f55301a.b()) {
                    a aVar5 = this.f55301a;
                    a.a(aVar5, aVar5.f55294c);
                } else {
                    AccountProviderActivity.a((Fragment) this.f55301a, 288);
                }
            } else if (i2 == 3) {
                d.a aVar6 = d.f53996a;
                net.one97.paytm.moneytransfer.d.a b2 = d.b(d.a.a());
                Context context3 = this.f55301a.getContext();
                if (context3 == null) {
                    k.a();
                }
                k.a((Object) context3, "context!!");
                boolean b3 = b2.b(context3);
                if (this.f55301a.getContext() == null) {
                    k.a();
                }
                if (this.f55301a.getContext() == null) {
                    k.a();
                }
                net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
                k.a((Object) a2, "Injection.provideUpiRegi…ervices(context!!, null))");
                if (a2.e() || b3) {
                    this.f55301a.d();
                } else if (this.f55301a.b()) {
                    a aVar7 = this.f55301a;
                    a.a(aVar7, aVar7.f55296e);
                } else {
                    AccountProviderActivity.a((Fragment) this.f55301a, 288);
                }
            } else if (i2 == 4) {
                f.a(this.f55301a.getContext(), this.f55301a.f55300i, CJRGTMConstants.MT_V4_SCAN_UPI_QR_CLICKED, this.f55301a.f55299h, "", "");
                a.i(this.f55301a);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        Context context = getContext();
        String str = this.f55300i;
        String str2 = this.f55299h;
        net.one97.paytm.upi.registration.b.a.b bVar = this.f55293a;
        if (bVar == null) {
            k.a("registrationRepository");
        }
        f.a(context, str, "to_bank_account_clicked", str2, String.valueOf(bVar.e()), "");
        a("money_transfer_bankaccount");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            e eVar = e.f50261a;
            int i2 = arguments.getInt(e.h(), -1);
            if (i2 == e.C0905e.MONEY_TRANSFER.ordinal()) {
                this.f55299h = CJRGTMConstants.MT_V4_SEARCH_SCREEN_NAME;
            } else if (i2 == e.C0905e.MONEY_TRANSFER_VIEW_ALL.ordinal()) {
                this.f55299h = CJRGTMConstants.MT_V4_BENEFICIARY_SCREEN_NAME;
            }
        }
        net.one97.paytm.upi.j.a aVar = this.f55298g;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.f67011d.observe(getViewLifecycleOwner(), new c());
    }

    public static final class c implements z<Boolean> {
        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }

        c() {
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2010 && i3 == -1) {
            if (intent == null) {
                k.a();
            }
            intent.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
            intent.getStringExtra("ifsc_code");
            intent.getBooleanExtra("is_from_scan_text", false);
        } else if (i2 == this.f55295d && i3 == -1) {
            a("money_transfer_check_balance");
        } else if (i2 == this.f55294c && i3 == -1) {
            a("money_transfer_self");
        } else if (i2 == this.f55296e && i3 == -1) {
            d();
        } else if (i2 == this.f55297f && i3 == -1) {
            a("money_transfer_self");
        } else if (i2 == 288 && i3 == -1) {
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                if (!(serializableExtra instanceof AccountProviderBody.AccountProvider)) {
                    serializableExtra = null;
                }
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                if (accountProvider != null) {
                    UpiRegistrationActivity.a((Fragment) this, accountProvider, UpiConstants.UPI_ONBOARDING_SELF_DESTROY, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (i2 == 352 && i3 == -1) {
            a("money_transfer_self");
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        Intent intent = new Intent(getContext(), MoneyTransferV4Activity.class);
        DeepLinkData deepLinkData = new DeepLinkData();
        deepLinkData.f50288f = str;
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        startActivity(intent);
    }

    public final boolean a() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.f55293a;
        if (bVar == null) {
            k.a("registrationRepository");
        }
        return bVar.e();
    }

    public final boolean b() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.f55293a;
        if (bVar == null) {
            k.a("registrationRepository");
        }
        return bVar.f();
    }

    public final boolean c() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.f55293a;
        if (bVar == null) {
            k.a("registrationRepository");
        }
        return bVar.h();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.g.a$a  reason: collision with other inner class name */
    public static final class C1014a {
        private C1014a() {
        }

        public /* synthetic */ C1014a(byte b2) {
            this();
        }

        public static a a(Bundle bundle) {
            a aVar = new a();
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public final void onDestroyView() {
        j jVar;
        androidx.fragment.app.q a2;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            jVar = parentFragment.getChildFragmentManager();
        } else {
            FragmentActivity activity = getActivity();
            jVar = activity != null ? activity.getSupportFragmentManager() : null;
        }
        if (!(jVar == null || (a2 = jVar.a().a((Fragment) this)) == null)) {
            a2.c();
        }
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        Intent intent = new Intent(aVar.getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        aVar.startActivityForResult(intent, i2);
    }

    public static final /* synthetic */ void i(a aVar) {
        try {
            d.a aVar2 = d.f53996a;
            Intent intent = new Intent(aVar.getActivity(), Class.forName(d.b(d.a.a()).d()));
            intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
            intent.putExtra("read_text", true);
            aVar.startActivityForResult(intent, 2010);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
