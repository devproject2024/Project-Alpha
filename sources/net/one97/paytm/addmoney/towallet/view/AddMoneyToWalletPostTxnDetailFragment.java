package net.one97.paytm.addmoney.towallet.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.i;
import net.one97.paytm.addmoney.towallet.c.d;
import net.one97.paytm.autoaddmoney.views.AmAutomaticActivity;
import net.one97.paytm.i.h;
import net.one97.paytm.newaddmoney.utils.e;
import net.one97.paytm.newaddmoney.view.AddMoneyNewActivity;

public final class AddMoneyToWalletPostTxnDetailFragment extends h {

    /* renamed from: a  reason: collision with root package name */
    public i f48877a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.addmoney.towallet.c.a f48878b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f48879c = "";

    /* renamed from: d  reason: collision with root package name */
    private HashMap f48880d;

    static final class a<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnDetailFragment f48881a;

        a(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
            this.f48881a = addMoneyToWalletPostTxnDetailFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = this.f48881a.getString(R.string.add_paytm_balance_new) + " ₹" + ((String) obj);
            net.one97.paytm.addmoney.towallet.c.a aVar = this.f48881a.f48878b;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.k.set(str);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.fragment_add_money_to_wallet_post_detail_view, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        this.f48877a = (i) a2;
        i iVar = this.f48877a;
        if (iVar == null) {
            k.a("binder");
        }
        return iVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        View findViewById;
        View findViewById2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.addmoney.towallet.c.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.f48878b = (net.one97.paytm.addmoney.towallet.c.a) a2;
        i iVar = this.f48877a;
        if (iVar == null) {
            k.a("binder");
        }
        net.one97.paytm.addmoney.towallet.c.a aVar = this.f48878b;
        if (aVar == null) {
            k.a("viewModel");
        }
        iVar.a(aVar);
        net.one97.paytm.addmoney.towallet.c.a aVar2 = this.f48878b;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        q qVar = this;
        aVar2.n.observe(qVar, new a(this));
        net.one97.paytm.addmoney.towallet.c.a aVar3 = this.f48878b;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        aVar3.m.observe(qVar, new b(this));
        View view3 = getView();
        if (!(view3 == null || (findViewById2 = view3.findViewById(R.id.activate_full_kyc)) == null)) {
            findViewById2.setOnClickListener(new c(this));
        }
        boolean h2 = net.one97.paytm.helper.a.f50546a.a().h();
        int g2 = net.one97.paytm.helper.a.f50546a.a().g();
        if (h2 && g2 == 0 && (view2 = getView()) != null && (findViewById = view2.findViewById(R.id.full_kyc_layout)) != null) {
            findViewById.setVisibility(0);
        }
    }

    public static final class b implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnDetailFragment f48882a;

        b(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
            this.f48882a = addMoneyToWalletPostTxnDetailFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num == null) {
                k.a();
            }
            int intValue = num.intValue();
            if (intValue == R.id.ccFeeInfoImv) {
                AddMoneyToWalletPostTxnDetailFragment.a(this.f48882a);
            } else if (intValue == R.id.automaticAddMoneyBannerCl) {
                AddMoneyToWalletPostTxnDetailFragment.b(this.f48882a);
            } else if (intValue == R.id.viewDetailTv) {
                if (this.f48882a.isAdded() && (this.f48882a.getActivity() instanceof AddMoneyToWalletPostTxnActivity)) {
                    FragmentActivity activity = this.f48882a.getActivity();
                    if (activity != null) {
                        ((AddMoneyToWalletPostTxnActivity) activity).a(d.SUCCESS_DETAIL);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity");
                    }
                }
                net.one97.paytm.addmoney.utils.d.a((Context) this.f48882a.getActivity(), "add_money", "add_money_view_details", "/add-money", (ArrayList<String>) kotlin.a.k.d("", "", "", this.f48882a.f48879c), (String) null);
            } else if (intValue == R.id.tryAgainTv) {
                AddMoneyToWalletPostTxnDetailFragment.d(this.f48882a);
            } else if (intValue == R.id.moneyAlreadyDeductedTv) {
                AddMoneyToWalletPostTxnDetailFragment.e(this.f48882a);
            } else if (intValue == R.id.tv_repeat_payment) {
                AddMoneyToWalletPostTxnDetailFragment.f(this.f48882a);
            } else if (intValue == R.id.iv_share) {
                if (this.f48882a.isAdded() && (this.f48882a.getActivity() instanceof AddMoneyToWalletPostTxnActivity)) {
                    FragmentActivity activity2 = this.f48882a.getActivity();
                    if (activity2 != null) {
                        ((AddMoneyToWalletPostTxnActivity) activity2).a(d.SUCCESS_DETAIL);
                        FragmentActivity activity3 = this.f48882a.getActivity();
                        if (activity3 != null) {
                            ((ImageView) ((AddMoneyToWalletPostTxnActivity) activity3).a(R.id.shareImv)).callOnClick();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity");
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity");
                }
            } else if (intValue == R.id.cross_iv) {
                AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment = this.f48882a;
                addMoneyToWalletPostTxnDetailFragment.startActivity(new Intent(addMoneyToWalletPostTxnDetailFragment.getActivity(), AddMoneyNewActivity.class));
                FragmentActivity activity4 = this.f48882a.getActivity();
                if (activity4 != null) {
                    activity4.finish();
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AddMoneyToWalletPostTxnDetailFragment f48883a;

        c(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
            this.f48883a = addMoneyToWalletPostTxnDetailFragment;
        }

        public final void onClick(View view) {
            Context context = this.f48883a.getContext();
            if (context != null) {
                net.one97.paytm.addmoney.utils.d.a((Context) this.f48883a.getActivity(), "add_money", "add_money_full_kyc_selected", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d(e.a(this.f48883a.getContext()), "Wallet", "", this.f48883a.f48879c), "");
                AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment = this.f48883a;
                net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
                k.a((Object) context, "it");
                addMoneyToWalletPostTxnDetailFragment.startActivity(a2.l(context));
            }
        }
    }

    public static final /* synthetic */ void a(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
        net.one97.paytm.addmoney.towallet.c.a aVar = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar == null) {
            k.a("viewModel");
        }
        double d2 = aVar.v;
        net.one97.paytm.addmoney.towallet.c.a aVar2 = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        double d3 = aVar2.w;
        net.one97.paytm.addmoney.towallet.c.a aVar3 = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        double d4 = aVar3.x;
        net.one97.paytm.addmoney.towallet.c.a aVar4 = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        double d5 = aVar4.y;
        net.one97.paytm.addmoney.towallet.c.a aVar5 = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar5 == null) {
            k.a("viewModel");
        }
        new net.one97.paytm.passbook.transactionDetail.b.c(d2, d3, d4, d5, aVar5.a()).show(addMoneyToWalletPostTxnDetailFragment.getChildFragmentManager(), "AddMoneyToWalletBottomSheetCCFee");
    }

    public static final /* synthetic */ void b(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
        net.one97.paytm.addmoney.utils.d.a((Context) addMoneyToWalletPostTxnDetailFragment.getActivity(), "add_money", "add_money_auto_add_selected", "add_money_post_payment_screen", (ArrayList<String>) kotlin.a.k.d(e.a(addMoneyToWalletPostTxnDetailFragment.getContext()), "Wallet", "", addMoneyToWalletPostTxnDetailFragment.f48879c), "");
        Intent intent = new Intent(addMoneyToWalletPostTxnDetailFragment.getActivity(), AmAutomaticActivity.class);
        intent.putExtra("which_page", "add_money");
        addMoneyToWalletPostTxnDetailFragment.startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void d(net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnDetailFragment r6) {
        /*
            boolean r0 = r6.isAdded()
            if (r0 == 0) goto L_0x0084
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r6.getContext()
            java.lang.Class<net.one97.paytm.newaddmoney.view.AddMoneyNewActivity> r2 = net.one97.paytm.newaddmoney.view.AddMoneyNewActivity.class
            r0.<init>(r1, r2)
            net.one97.paytm.addmoney.towallet.c.a r1 = r6.f48878b
            java.lang.String r2 = "viewModel"
            if (r1 != 0) goto L_0x001b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001b:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r1.f48831b
            r3 = 0
            if (r1 == 0) goto L_0x0025
            java.util.ArrayList r1 = r1.getOrderedCartList()
            goto L_0x0026
        L_0x0025:
            r1 = r3
        L_0x0026:
            r4 = 0
            if (r1 == 0) goto L_0x006c
            net.one97.paytm.addmoney.towallet.c.a r1 = r6.f48878b
            if (r1 != 0) goto L_0x0031
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0031:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r1.f48831b
            if (r1 == 0) goto L_0x003a
            java.util.ArrayList r1 = r1.getOrderedCartList()
            goto L_0x003b
        L_0x003a:
            r1 = r3
        L_0x003b:
            if (r1 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x006c
            net.one97.paytm.addmoney.towallet.c.a r1 = r6.f48878b
            if (r1 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x004d:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r1.f48831b
            if (r1 == 0) goto L_0x0055
            java.util.ArrayList r3 = r1.getOrderedCartList()
        L_0x0055:
            if (r3 != 0) goto L_0x005a
            kotlin.g.b.k.a()
        L_0x005a:
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r2 = "viewModel.mOrderSummary?.orderedCartList!!.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            double r1 = r1.getTotalPrice()
            goto L_0x006d
        L_0x006c:
            r1 = r4
        L_0x006d:
            int r3 = java.lang.Double.compare(r1, r4)
            if (r3 <= 0) goto L_0x0078
            java.lang.String r3 = "amount"
            r0.putExtra(r3, r1)
        L_0x0078:
            r6.startActivity(r0)
            androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
            if (r6 == 0) goto L_0x0084
            r6.finish()
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnDetailFragment.d(net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnDetailFragment):void");
    }

    public static final /* synthetic */ void e(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
        if (addMoneyToWalletPostTxnDetailFragment.isAdded() && (addMoneyToWalletPostTxnDetailFragment.getActivity() instanceof AddMoneyToWalletPostTxnActivity)) {
            FragmentActivity activity = addMoneyToWalletPostTxnDetailFragment.getActivity();
            if (activity != null) {
                ((AddMoneyToWalletPostTxnActivity) activity).d();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.towallet.view.AddMoneyToWalletPostTxnActivity");
        }
    }

    public static final /* synthetic */ void f(AddMoneyToWalletPostTxnDetailFragment addMoneyToWalletPostTxnDetailFragment) {
        FragmentActivity activity;
        Intent intent = new Intent(addMoneyToWalletPostTxnDetailFragment.getActivity(), AddMoneyNewActivity.class);
        intent.putExtra("intent_extra_wallet_type", "wallet_type_add");
        net.one97.paytm.addmoney.towallet.c.a aVar = addMoneyToWalletPostTxnDetailFragment.f48878b;
        if (aVar == null) {
            k.a("viewModel");
        }
        intent.putExtra("amount", aVar.v);
        addMoneyToWalletPostTxnDetailFragment.startActivity(intent);
        if (addMoneyToWalletPostTxnDetailFragment.isAdded() && addMoneyToWalletPostTxnDetailFragment.getActivity() != null && (activity = addMoneyToWalletPostTxnDetailFragment.getActivity()) != null) {
            activity.finish();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f48880d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
