package net.one97.paytm.moneytransfer.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.f;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class p extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54593a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private UpiBaseDataModel f54594b;

    /* renamed from: c  reason: collision with root package name */
    private String f54595c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f54596d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f54597e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f54598f;

    /* renamed from: g  reason: collision with root package name */
    private ConstraintLayout f54599g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f54600h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f54601i;
    private PPBCurrentAccountModel j;
    private HashMap k;

    static final class b<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54602a;

        b(p pVar) {
            this.f54602a = pVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                p.g(this.f54602a).setVisibility(0);
                TextView h2 = p.h(this.f54602a);
                aa aaVar = aa.f47921a;
                String string = this.f54602a.getString(R.string.money_transfer_updated_ppb_ica_bal);
                k.a((Object) string, "getString(R.string.money…sfer_updated_ppb_ica_bal)");
                String format = String.format(string, Arrays.copyOf(new Object[]{UpiAppUtils.priceToString(str)}, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                h2.setText(Html.fromHtml(format));
            }
        }
    }

    public static final /* synthetic */ ConstraintLayout g(p pVar) {
        ConstraintLayout constraintLayout = pVar.f54599g;
        if (constraintLayout == null) {
            k.a("viewPassbook");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ TextView h(p pVar) {
        TextView textView = pVar.f54600h;
        if (textView == null) {
            k.a("viewPassbookTv");
        }
        return textView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static p a(UpiBaseDataModel upiBaseDataModel, String str, String str2, boolean z, boolean z2, PPBCurrentAccountModel pPBCurrentAccountModel) {
            p pVar = new p();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_txn_data", upiBaseDataModel);
            bundle.putString("ifsc", str);
            bundle.putString("key_account_number", str2);
            bundle.putBoolean("is_from_upi_deep_link", z);
            bundle.putBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST, z2);
            bundle.putSerializable("ppb_ica", pPBCurrentAccountModel);
            pVar.setArguments(bundle);
            return pVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y<String> yVar;
        PPBCurrentAccountModel pPBCurrentAccountModel;
        net.one97.paytm.moneytransfer.b.a.b bVar;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_post_txn_actions, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.cl_view_passbook);
        if (findViewById != null) {
            this.f54599g = (ConstraintLayout) findViewById;
            View findViewById2 = inflate.findViewById(R.id.view_passbook_tv);
            if (findViewById2 != null) {
                this.f54600h = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.new_transfer_tv);
                k.a((Object) findViewById3, "view.findViewById(R.id.new_transfer_tv)");
                this.f54601i = (TextView) findViewById3;
                Bundle arguments = getArguments();
                String str = null;
                this.f54594b = (UpiBaseDataModel) (arguments != null ? arguments.getSerializable("post_txn_data") : null);
                Bundle arguments2 = getArguments();
                this.f54595c = arguments2 != null ? arguments2.getString("ifsc") : null;
                Bundle arguments3 = getArguments();
                this.f54596d = arguments3 != null ? arguments3.getString("key_account_number") : null;
                Bundle arguments4 = getArguments();
                Boolean valueOf = arguments4 != null ? Boolean.valueOf(arguments4.getBoolean("is_from_upi_deep_link")) : null;
                if (valueOf == null) {
                    k.a();
                }
                this.f54597e = valueOf.booleanValue();
                Bundle arguments5 = getArguments();
                Boolean valueOf2 = arguments5 != null ? Boolean.valueOf(arguments5.getBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST)) : null;
                if (valueOf2 == null) {
                    k.a();
                }
                this.f54598f = valueOf2.booleanValue();
                Bundle arguments6 = getArguments();
                this.j = (PPBCurrentAccountModel) (arguments6 != null ? arguments6.getSerializable("ppb_ica") : null);
                if (this.f54594b instanceof BaseUpiResponse) {
                    View findViewById4 = inflate.findViewById(R.id.cl_payment_history);
                    if (findViewById4 != null) {
                        ((ConstraintLayout) findViewById4).setVisibility(0);
                        ConstraintLayout constraintLayout = this.f54599g;
                        if (constraintLayout == null) {
                            k.a("viewPassbook");
                        }
                        constraintLayout.setVisibility(8);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                } else {
                    String str2 = this.f54596d;
                    if (str2 == null) {
                        k.a();
                    }
                    if (this.j != null) {
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        ai a2 = am.a(activity).a(net.one97.paytm.moneytransfer.viewmodel.f.class);
                        k.a((Object) a2, "ViewModelProviders.of(ac…ionViewModel::class.java)");
                        net.one97.paytm.moneytransfer.viewmodel.f fVar = (net.one97.paytm.moneytransfer.viewmodel.f) a2;
                        if (!(fVar == null || (pPBCurrentAccountModel = this.j) == null || (bVar = fVar.f54753a) == null)) {
                            a.C1382a aVar = new f.a(fVar);
                            PPBCurrentAccountModel.Ica ica = pPBCurrentAccountModel.getIca();
                            String accountNumber = ica != null ? ica.getAccountNumber() : null;
                            PPBCurrentAccountModel.Ica ica2 = pPBCurrentAccountModel.getIca();
                            if (ica2 != null) {
                                str = ica2.getCaId();
                            }
                            bVar.a(aVar, accountNumber, str);
                        }
                        if (!(fVar == null || (yVar = fVar.f54754b) == null)) {
                            yVar.observe(this, new b(this));
                        }
                    } else if (com.paytm.utility.a.m(getActivity())) {
                        net.one97.paytm.moneytransfer.b.a.b.a.a((Context) getActivity()).a((a.C1382a) new c(this), str2);
                    }
                    View findViewById5 = inflate.findViewById(R.id.cl_payment_history);
                    if (findViewById5 != null) {
                        ((ConstraintLayout) findViewById5).setVisibility(8);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                }
                if (this.f54597e || this.f54598f) {
                    TextView textView = this.f54601i;
                    if (textView == null) {
                        k.a("newTransferTV");
                    }
                    textView.setText(getString(R.string.upi_make_new_payment));
                } else {
                    TextView textView2 = this.f54601i;
                    if (textView2 == null) {
                        k.a("newTransferTV");
                    }
                    textView2.setText(getString(R.string.mt_make_new_transfer));
                }
                View findViewById6 = inflate.findViewById(R.id.cl_new_transfer);
                if (findViewById6 != null) {
                    ((ConstraintLayout) findViewById6).setOnClickListener(new d(this));
                    View findViewById7 = inflate.findViewById(R.id.cl_payment_history);
                    if (findViewById7 != null) {
                        ((ConstraintLayout) findViewById7).setOnClickListener(new e(this));
                        View findViewById8 = inflate.findViewById(R.id.cl_need_help);
                        if (findViewById8 != null) {
                            ((ConstraintLayout) findViewById8).setOnClickListener(new f(this));
                            View findViewById9 = inflate.findViewById(R.id.cl_view_passbook);
                            if (findViewById9 != null) {
                                ((ConstraintLayout) findViewById9).setOnClickListener(new g(this));
                                return inflate;
                            }
                            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                        }
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                }
                throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54604a;

        d(p pVar) {
            this.f54604a = pVar;
        }

        public final void onClick(View view) {
            p.a(this.f54604a);
            p pVar = this.f54604a;
            pVar.startActivity(new Intent(pVar.getActivity(), MoneyTransferV3Activity.class));
            FragmentActivity activity = this.f54604a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.finish();
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54605a;

        e(p pVar) {
            this.f54605a = pVar;
        }

        public final void onClick(View view) {
            p.b(this.f54605a);
            if (this.f54605a.f54598f) {
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f54605a.requireContext(), Events.Category.COLLECT, "upi_payment_history_clicked", "", "", "", this.f54605a.f54596d, "", Events.Screen.POST_TRANSACTION, "");
            }
            if (this.f54605a.f54597e) {
                p pVar = this.f54605a;
                String d2 = pVar.f54596d;
                if (d2 == null) {
                    d2 = "";
                }
                net.one97.paytm.moneytransfer.utils.e.a(pVar, Events.Category.INTENT, "upi_payment_history_clicked", Events.Screen.POST_TRANSACTION, d2, (String) null, (String) null, 48);
            }
            FragmentActivity activity = this.f54605a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.finish();
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54606a;

        f(p pVar) {
            this.f54606a = pVar;
        }

        public final void onClick(View view) {
            if (this.f54606a.f54598f) {
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f54606a.requireContext(), Events.Category.COLLECT, Events.Action.NEED_HELP_CLICKED, "", "", "", this.f54606a.f54596d, "", Events.Screen.POST_TRANSACTION, "");
            }
            if (this.f54606a.f54597e) {
                p pVar = this.f54606a;
                String d2 = pVar.f54596d;
                if (d2 == null) {
                    d2 = "";
                }
                net.one97.paytm.moneytransfer.utils.e.a(pVar, Events.Category.INTENT, Events.Action.NEED_HELP_CLICKED, Events.Screen.POST_TRANSACTION, d2, (String) null, (String) null, 48);
            }
            p.f(this.f54606a);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54607a;

        g(p pVar) {
            this.f54607a = pVar;
        }

        public final void onClick(View view) {
            p.b(this.f54607a);
            FragmentActivity activity = this.f54607a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.finish();
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f54603a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        c(p pVar) {
            this.f54603a = pVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel != null && (upiBaseDataModel instanceof CJRAccountSummary)) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (kotlin.m.p.a(cJRAccountSummary.getStatus(), "success", true) && this.f54603a.getActivity() != null && this.f54603a.isAdded()) {
                    AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                    k.a((Object) accountBalanceModel, "account");
                    double effectiveBalance = accountBalanceModel.getEffectiveBalance();
                    p.g(this.f54603a).setVisibility(0);
                    TextView h2 = p.h(this.f54603a);
                    aa aaVar = aa.f47921a;
                    String string = this.f54603a.getString(R.string.money_transfer_updated_ppb_bal);
                    k.a((Object) string, "getString(R.string.money_transfer_updated_ppb_bal)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{UpiAppUtils.priceToString(String.valueOf(effectiveBalance))}, 1));
                    k.a((Object) format, "java.lang.String.format(format, *args)");
                    h2.setText(Html.fromHtml(format));
                }
            }
        }
    }

    public static final /* synthetic */ void a(p pVar) {
        if (pVar.getActivity() instanceof MoneyTransferPostTransactionActivity) {
            FragmentActivity activity = pVar.getActivity();
            if (activity == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "summary_bottom_links_clicked", "/money_transfer/summary", "make_another_transaction", "");
        } else {
            FragmentActivity activity2 = pVar.getActivity();
            if (activity2 == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity2, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "summary_detail_bottom_links_clicked", "/money-transfer/summary-detail", "make_another_transaction", "");
        }
        if (pVar.f54598f) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(pVar.requireContext(), Events.Category.COLLECT, Events.Action.MAKE_NEW_PAYMENT, "", "", "", pVar.f54596d, "", Events.Screen.POST_TRANSACTION, "");
        } else if (pVar.f54597e) {
            String str = pVar.f54596d;
            if (str == null) {
                str = "";
            }
            net.one97.paytm.moneytransfer.utils.e.a(pVar, Events.Category.INTENT, Events.Action.MAKE_NEW_PAYMENT, Events.Screen.POST_TRANSACTION, str, (String) null, (String) null, 48);
        }
    }

    public static final /* synthetic */ void b(p pVar) {
        if (pVar.f54594b instanceof BaseUpiResponse) {
            if (pVar.getActivity() instanceof MoneyTransferPostTransactionActivity) {
                FragmentActivity activity = pVar.getActivity();
                if (activity == null) {
                    k.a();
                }
                net.one97.paytm.moneytransfer.utils.f.a(activity, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_VIEW_UPI_CLICKED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
            } else {
                FragmentActivity activity2 = pVar.getActivity();
                if (activity2 == null) {
                    k.a();
                }
                net.one97.paytm.moneytransfer.utils.f.a(activity2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_VIEW_UPI_CLICKED, CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME, "", "");
            }
            pVar.startActivity(new Intent(pVar.getActivity(), UpiPassbookActivity.class));
            return;
        }
        if (pVar.getActivity() instanceof MoneyTransferPostTransactionActivity) {
            FragmentActivity activity3 = pVar.getActivity();
            if (activity3 == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity3, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        } else {
            FragmentActivity activity4 = pVar.getActivity();
            if (activity4 == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity4, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_VIEW_PASSBOOK_CLICKED, CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME, "", "");
        }
        if (com.paytm.utility.k.b()) {
            return;
        }
        if (pVar.j != null) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity5 = pVar.getActivity();
            if (activity5 == null) {
                k.a();
            }
            k.a((Object) activity5, "activity!!");
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            b2.a((Context) activity5, net.one97.paytm.moneytransfer.d.d.b(d.a.a()).i());
            return;
        }
        d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        FragmentActivity activity6 = pVar.getActivity();
        if (activity6 == null) {
            k.a();
        }
        k.a((Object) activity6, "activity!!");
        d.a aVar4 = net.one97.paytm.moneytransfer.d.d.f53996a;
        b3.a((Context) activity6, net.one97.paytm.moneytransfer.d.d.b(d.a.a()).c());
    }

    public static final /* synthetic */ void f(p pVar) {
        if (pVar.getActivity() instanceof MoneyTransferPostTransactionActivity) {
            FragmentActivity activity = pVar.getActivity();
            if (activity == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_NEED_HELP_CLICKED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        } else {
            FragmentActivity activity2 = pVar.getActivity();
            if (activity2 == null) {
                k.a();
            }
            net.one97.paytm.moneytransfer.utils.f.a(activity2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_NEED_HELP_CLICKED, CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME, "", "");
        }
        if (pVar.f54594b instanceof BaseUpiResponse) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity3 = pVar.getActivity();
            if (activity3 == null) {
                k.a();
            }
            k.a((Object) activity3, "activity!!");
            b2.a((Context) activity3, "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=5&templateId=8");
            FragmentActivity activity4 = pVar.getActivity();
            if (activity4 == null) {
                k.a();
            }
            activity4.finish();
            return;
        }
        d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        Context context = pVar.getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        b3.a(context, new Bundle());
        FragmentActivity activity5 = pVar.getActivity();
        if (activity5 == null) {
            k.a();
        }
        activity5.finish();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
