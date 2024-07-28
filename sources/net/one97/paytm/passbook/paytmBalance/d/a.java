package net.one97.paytm.passbook.paytmBalance.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.beans.CJRP2BStatusResponse;
import net.one97.paytm.passbook.genericPassbook.d.a.d;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.mapping.g;
import net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment;
import net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivity;
import net.one97.paytm.passbook.utility.d;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class a implements View.OnClickListener, d.a {

    /* renamed from: a  reason: collision with root package name */
    public d f58210a;

    /* renamed from: b  reason: collision with root package name */
    public String f58211b;

    /* renamed from: c  reason: collision with root package name */
    public final PaytmBalanceHeaderFragment f58212c;

    /* renamed from: d  reason: collision with root package name */
    private CJRP2BStatus f58213d;

    public a(PaytmBalanceHeaderFragment paytmBalanceHeaderFragment) {
        k.c(paytmBalanceHeaderFragment, "paytmBalanceHeaderFragment");
        this.f58212c = paytmBalanceHeaderFragment;
    }

    public final void onClick(View view) {
        List list;
        if (view == null) {
            return;
        }
        if (k.a((Object) view, (Object) (RelativeLayout) this.f58212c.a(R.id.rl_download_statement))) {
            net.one97.paytm.passbook.d.b().a(this.f58212c.getContext(), "passbook", "wallet_download_statement", (String) null, "", "/passbook/wallet", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            d dVar = this.f58210a;
            if (dVar == null) {
                k.a("presenter");
            }
            dVar.a();
            if (this.f58210a == null) {
                k.a("presenter");
            }
            d.b();
            Intent intent = new Intent(this.f58212c.getContext(), StatementDownloadActivity.class);
            RoboTextView roboTextView = (RoboTextView) this.f58212c.a(R.id.tv_download_statement);
            k.a((Object) roboTextView, "paytmBalanceHeaderFragment.tv_download_statement");
            intent.putExtra("header_title", roboTextView.getText().toString());
            intent.putExtra("CallingFragment", "PassbookWalletFragment");
            this.f58212c.startActivityForResult(intent, 131);
            q.a(this.f58212c.getContext(), "uth_passbook", "total_bal_paytm_wallet_clicked", "request_statement", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
        } else if (k.a((Object) view, (Object) (RelativeLayout) this.f58212c.a(R.id.rl_send_money_layout))) {
            net.one97.paytm.passbook.d.b().a(this.f58212c.getContext(), "passbook", "send_money_wallet_to_bank", (String) null, "", "/passbook/wallet", "passbook");
            if (b.c(this.f58212c.getContext())) {
                f b2 = net.one97.paytm.passbook.d.b();
                this.f58212c.getContext();
                String l = b2.l();
                CharSequence charSequence = l;
                if (!TextUtils.isEmpty(charSequence)) {
                    k.a((Object) l, "p2bKycStatus");
                    list = p.a(charSequence, new String[]{AppConstants.COMMA});
                } else {
                    list = null;
                }
                if (list == null || !kotlin.a.k.a(list, this.f58211b)) {
                    if (this.f58210a == null) {
                        k.a("presenter");
                    }
                    FragmentActivity activity = this.f58212c.getActivity();
                    if (activity != null) {
                        d.a((AppCompatActivity) activity, (d.a) this);
                        q.a(this.f58212c.getContext(), "passbook_wallet", "passbook_wallet_send_money_clicked", (ArrayList<String>) null, "/passbook/wallet/");
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                } else {
                    Context context = this.f58212c.getContext();
                    f b3 = net.one97.paytm.passbook.d.b();
                    k.a((Object) b3, "PassbookHelper.getImplListener()");
                    Intent intent2 = new Intent(context, b3.d());
                    Context context2 = this.f58212c.getContext();
                    if (context2 != null) {
                        context2.startActivity(intent2);
                    }
                }
            } else {
                c.g(this.f58212c.getActivity());
            }
            q.a(this.f58212c.getContext(), "uth_passbook", "total_bal_paytm_wallet_clicked", "send_money_from_wallet_to_bank", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
        } else if (k.a((Object) view, (Object) (RelativeLayout) this.f58212c.a(R.id.rl_add_money_layout))) {
            net.one97.paytm.passbook.d.b().a(this.f58212c.getContext(), "passbook", "add_money_to_wallet", (String) null, "", "/passbook/wallet", "passbook");
            g.a();
            g.a(this.f58212c.getActivity(), "wallet");
            q.a(this.f58212c.getContext(), "uth_passbook", "total_bal_paytm_wallet_clicked", "add_money_to_wallet", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
        } else if (k.a((Object) view, (Object) (RelativeLayout) this.f58212c.a(R.id.rl_view_spend_analytics))) {
            net.one97.paytm.passbook.d.b().a(this.f58212c.getContext(), "passbook", "wallet_view_spend_analytics", (String) null, "", "/passbook/wallet", "passbook");
            PaytmBalanceHeaderFragment paytmBalanceHeaderFragment = this.f58212c;
            paytmBalanceHeaderFragment.startActivity(new Intent(paytmBalanceHeaderFragment.getContext(), SpendAnalyticsMainActivity.class));
            q.a(this.f58212c.getContext(), "uth_passbook", "total_bal_paytm_wallet_clicked", "view_spend_analytics", (String) null, "/uth_passbook/paytm_wallet", "PASSBOOK");
        }
    }

    public static String a(String str) {
        String str2 = "";
        for (d.a aVar : d.a.values()) {
            if (str != null && p.a(str, aVar.getWalletUserState(), true)) {
                str2 = aVar.getv2UserState();
                k.a((Object) str2, "mapping.getv2UserState()");
            }
        }
        return str2;
    }

    public final void a(CJRP2BStatus cJRP2BStatus) {
        k.c(cJRP2BStatus, Payload.RESPONSE);
        if (this.f58212c.getActivity() != null) {
            FragmentActivity activity = this.f58212c.getActivity();
            String str = null;
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue()) {
                this.f58213d = cJRP2BStatus;
                FragmentActivity activity2 = this.f58212c.getActivity();
                Boolean valueOf2 = activity2 != null ? Boolean.valueOf(activity2.isFinishing()) : null;
                if (valueOf2 == null) {
                    k.a();
                }
                if (!valueOf2.booleanValue()) {
                    CJRP2BStatus cJRP2BStatus2 = this.f58213d;
                    if (cJRP2BStatus2 == null) {
                        k.a("mP2BStatus");
                    }
                    if (cJRP2BStatus2 != null) {
                        CJRP2BStatus cJRP2BStatus3 = this.f58213d;
                        if (cJRP2BStatus3 == null) {
                            k.a("mP2BStatus");
                        }
                        if (cJRP2BStatus3.getResponse() != null) {
                            CJRP2BStatus cJRP2BStatus4 = this.f58213d;
                            if (cJRP2BStatus4 == null) {
                                k.a("mP2BStatus");
                            }
                            CJRP2BStatusResponse response = cJRP2BStatus4.getResponse();
                            k.a((Object) response, "mP2BStatus.response");
                            if (response.isValidForTxn()) {
                                a();
                                return;
                            }
                        }
                    }
                    f b2 = net.one97.paytm.passbook.d.b();
                    this.f58212c.getContext();
                    String q = b2.q();
                    if (TextUtils.isEmpty(q)) {
                        q = "0120 3888 388";
                    }
                    Context context = this.f58212c.getContext();
                    if (context != null) {
                        int i2 = R.string.help_text_send_to_bnk_err;
                        k.a((Object) q, "contactUsNumber");
                        str = context.getString(i2, new Object[]{p.a(q, " ", "", false), q});
                    }
                    net.one97.paytm.passbook.genericPassbook.d.a.d dVar = this.f58210a;
                    if (dVar == null) {
                        k.a("presenter");
                    }
                    Spanned fromHtml = Html.fromHtml(str);
                    k.a((Object) fromHtml, "Html.fromHtml(message)");
                    FragmentActivity activity3 = this.f58212c.getActivity();
                    if (activity3 != null) {
                        dVar.a(fromHtml, (AppCompatActivity) activity3);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "networkError");
        FragmentActivity activity = this.f58212c.getActivity();
        String str = null;
        Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (!valueOf.booleanValue()) {
            CJRP2BStatus cJRP2BStatus = this.f58213d;
            if (cJRP2BStatus == null) {
                k.a("mP2BStatus");
            }
            if (cJRP2BStatus != null) {
                CJRP2BStatus cJRP2BStatus2 = this.f58213d;
                if (cJRP2BStatus2 == null) {
                    k.a("mP2BStatus");
                }
                if (cJRP2BStatus2.getResponse() != null) {
                    CJRP2BStatus cJRP2BStatus3 = this.f58213d;
                    if (cJRP2BStatus3 == null) {
                        k.a("mP2BStatus");
                    }
                    CJRP2BStatusResponse response = cJRP2BStatus3.getResponse();
                    k.a((Object) response, "mP2BStatus.response");
                    if (response.isValidForTxn()) {
                        a();
                        return;
                    }
                }
            }
            f b2 = net.one97.paytm.passbook.d.b();
            this.f58212c.getContext();
            String q = b2.q();
            if (TextUtils.isEmpty(q)) {
                q = "0120 3888 388";
            }
            Context context = this.f58212c.getContext();
            if (context != null) {
                int i2 = R.string.help_text_send_to_bnk_err;
                k.a((Object) q, "contactUsNumber");
                str = context.getString(i2, new Object[]{p.a(q, " ", "", false), q});
            }
            net.one97.paytm.passbook.genericPassbook.d.a.d dVar = this.f58210a;
            if (dVar == null) {
                k.a("presenter");
            }
            Spanned fromHtml = Html.fromHtml(str);
            k.a((Object) fromHtml, "Html.fromHtml(message)");
            FragmentActivity activity2 = this.f58212c.getActivity();
            if (activity2 != null) {
                dVar.a(fromHtml, (AppCompatActivity) activity2);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[Catch:{ Exception -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r3 = this;
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r3.f58212c
            android.content.Context r0 = r0.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r3.f58212c     // Catch:{ Exception -> 0x005f }
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = "extra_home_data"
            if (r0 == 0) goto L_0x0022
            android.content.Intent r0 = r0.getIntent()     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0022
            java.io.Serializable r0 = r0.getSerializableExtra(r2)     // Catch:{ Exception -> 0x005f }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x005f
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r3.f58212c     // Catch:{ Exception -> 0x005f }
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0037
            android.content.Intent r0 = r0.getIntent()     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0037
            java.io.Serializable r1 = r0.getSerializableExtra(r2)     // Catch:{ Exception -> 0x005f }
        L_0x0037:
            java.lang.Class<net.one97.paytm.passbook.beans.CJRHomePageItem> r0 = net.one97.paytm.passbook.beans.CJRHomePageItem.class
            java.lang.Object r0 = net.one97.paytm.passbook.utility.q.a((java.lang.Object) r1, r0)     // Catch:{ Exception -> 0x005f }
            net.one97.paytm.passbook.beans.CJRHomePageItem r0 = (net.one97.paytm.passbook.beans.CJRHomePageItem) r0     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x005f
            java.lang.String r1 = "wallet_to_ppb"
            java.lang.String r2 = r0.getPushFeatureType()     // Catch:{ Exception -> 0x005f }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0052
            r3.b()     // Catch:{ Exception -> 0x005f }
            return
        L_0x0052:
            java.lang.String r1 = "cash_ledger"
            java.lang.String r0 = r0.getPushFeatureType()     // Catch:{ Exception -> 0x005f }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x005f
            return
        L_0x005f:
            r3.b()
            return
        L_0x0063:
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r3.f58212c
            android.content.Context r0 = r0.getContext()
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r2 = r3.f58212c
            android.content.Context r2 = r2.getContext()
            if (r2 == 0) goto L_0x0077
            int r1 = net.one97.paytm.passbook.R.string.err_nonetwork_msg
            java.lang.String r1 = r2.getString(r1)
        L_0x0077:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.d.a.a():void");
    }

    private final void b() {
        f b2 = net.one97.paytm.passbook.d.b();
        Activity activity = this.f58212c.getActivity();
        CJRP2BStatus cJRP2BStatus = this.f58213d;
        if (cJRP2BStatus == null) {
            k.a("mP2BStatus");
        }
        Intent a2 = b2.a(activity, cJRP2BStatus);
        FragmentActivity activity2 = this.f58212c.getActivity();
        Boolean valueOf = activity2 != null ? Boolean.valueOf(activity2.isFinishing()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (!valueOf.booleanValue()) {
            this.f58212c.startActivityForResult(a2, 127);
        }
    }

    /* renamed from: net.one97.paytm.passbook.paytmBalance.d.a$a  reason: collision with other inner class name */
    public static final class C1120a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58214a;

        public C1120a(a aVar) {
            this.f58214a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r1 = r1.getSupportFragmentManager();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.content.DialogInterface r1, int r2) {
            /*
                r0 = this;
                net.one97.paytm.passbook.paytmBalance.d.a r1 = r0.f58214a
                net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r1 = r1.f58212c
                net.one97.paytm.passbook.paytmBalance.e.a r1 = r1.a()
                r1.a()
                net.one97.paytm.passbook.paytmBalance.d.a r1 = r0.f58214a
                net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r1 = r1.f58212c
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                if (r1 == 0) goto L_0x0022
                androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
                if (r1 == 0) goto L_0x0022
                int r2 = net.one97.paytm.passbook.R.id.paytmBalanceTransactionsContainer
                androidx.fragment.app.Fragment r1 = r1.c((int) r2)
                goto L_0x0023
            L_0x0022:
                r1 = 0
            L_0x0023:
                boolean r2 = r1 instanceof net.one97.paytm.passbook.paytmBalance.fragment.a
                if (r2 == 0) goto L_0x002c
                net.one97.paytm.passbook.paytmBalance.fragment.a r1 = (net.one97.paytm.passbook.paytmBalance.fragment.a) r1
                r1.b()
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.d.a.C1120a.onClick(android.content.DialogInterface, int):void");
        }
    }
}
