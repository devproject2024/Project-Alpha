package net.one97.paytm.passbook.genericPassbook.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.PaymentDestinationType;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivityForPPB;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class e extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CJRSubWallet f57298a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f57299b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f57300c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f57301d;

    /* renamed from: e  reason: collision with root package name */
    private String f57302e;

    /* renamed from: f  reason: collision with root package name */
    private String f57303f;

    /* renamed from: g  reason: collision with root package name */
    private final int f57304g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f57305h;

    public e() {
        this.f57303f = "---";
        this.f57304g = 203;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(CJRSubWallet cJRSubWallet) {
        this();
        k.c(cJRSubWallet, "subwallet");
        this.f57298a = cJRSubWallet;
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r3, android.view.ViewGroup r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r3, r5)
            int r5 = net.one97.paytm.passbook.R.layout.pass_saving_account_header
            r0 = 0
            android.view.View r3 = r3.inflate(r5, r4, r0)
            java.lang.String r4 = "ACCOUNT_NUMBER"
            r2.f57302e = r4
            net.one97.paytm.passbook.beans.CJRSubWallet r4 = r2.f57298a
            r5 = 0
            if (r4 == 0) goto L_0x001e
            double r0 = r4.getBalance()
            java.lang.String r4 = java.lang.String.valueOf(r0)
            goto L_0x001f
        L_0x001e:
            r4 = r5
        L_0x001f:
            r2.f57303f = r4
            if (r3 == 0) goto L_0x002c
            int r4 = net.one97.paytm.passbook.R.id.rl_add_money_saving_account_layout
            android.view.View r4 = r3.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            goto L_0x002d
        L_0x002c:
            r4 = r5
        L_0x002d:
            if (r4 != 0) goto L_0x0032
            kotlin.g.b.k.a()
        L_0x0032:
            r2.f57299b = r4
            if (r3 == 0) goto L_0x003f
            int r4 = net.one97.paytm.passbook.R.id.rl_money_transfer_layout
            android.view.View r4 = r3.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            if (r4 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            r2.f57301d = r4
            if (r3 == 0) goto L_0x0052
            int r4 = net.one97.paytm.passbook.R.id.rl_download_saving_account_statement
            android.view.View r4 = r3.findViewById(r4)
            r5 = r4
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
        L_0x0052:
            if (r5 != 0) goto L_0x0057
            kotlin.g.b.k.a()
        L_0x0057:
            r2.f57300c = r5
            android.widget.RelativeLayout r4 = r2.f57299b
            if (r4 != 0) goto L_0x0062
            java.lang.String r5 = "rlAddMoneyToSavingsAccount"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0062:
            r5 = r2
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            android.widget.RelativeLayout r4 = r2.f57301d
            if (r4 != 0) goto L_0x0071
            java.lang.String r0 = "rlMoneyTransferLayout"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0071:
            r4.setOnClickListener(r5)
            android.widget.RelativeLayout r4 = r2.f57300c
            if (r4 != 0) goto L_0x007d
            java.lang.String r0 = "rlDownloadSavingAccountStatement"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x007d:
            r4.setOnClickListener(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.a.e.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onClick(View view) {
        View view2 = view;
        if (view2 != null) {
            RelativeLayout relativeLayout = this.f57299b;
            if (relativeLayout == null) {
                k.a("rlAddMoneyToSavingsAccount");
            }
            if (k.a((Object) view2, (Object) relativeLayout)) {
                d.b().a(getContext(), "passbook", "ppb_add_money_to_saving_account", (String) null, "", "/passbook/ppb", "passbook");
                d.b().a(getContext(), "wallet_passbook", "savings_account_list_item_clicked", "add_money_to_savings_account", "", "/passbook/savings-account", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                q.a(getContext(), "passbook_ppb", "add_money_ppb_passbook_clicked", (ArrayList<String>) null, "/passbook/ppb");
                if (com.paytm.utility.k.b()) {
                    Intent e2 = d.b().e(getContext());
                    e2.putExtra("ACCOUNT_NUMBER", this.f57302e);
                    e2.putExtra("extra_saving_balance", this.f57303f);
                    startActivity(e2);
                    return;
                }
                Context context = getContext();
                f b2 = d.b();
                k.a((Object) b2, "PassbookHelper.getImplListener()");
                Intent intent = new Intent(context, b2.o());
                intent.putExtra("destinationAddMoney", PaymentDestinationType.TO_PAYTM_BANK.getNumVal());
                startActivityForResult(intent, this.f57304g);
                return;
            }
            RelativeLayout relativeLayout2 = this.f57301d;
            if (relativeLayout2 == null) {
                k.a("rlMoneyTransferLayout");
            }
            if (k.a((Object) view2, (Object) relativeLayout2)) {
                d.b().a(getContext(), "passbook", "ppb_money_transfer", (String) null, "", "/passbook/ppb", "passbook");
                if (b.r(getContext())) {
                    Context context2 = getContext();
                    f b3 = d.b();
                    k.a((Object) b3, "PassbookHelper.getImplListener()");
                    Intent intent2 = new Intent(context2, b3.n());
                    k.a((Object) d.b(), "PassbookHelper.getImplListener()");
                    intent2.putExtra("send money to bank from passbbok", true);
                    startActivityForResult(intent2, 126);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout3 = this.f57300c;
            if (relativeLayout3 == null) {
                k.a("rlDownloadSavingAccountStatement");
            }
            if (k.a((Object) view2, (Object) relativeLayout3)) {
                d.b().a(getContext(), "passbook", "ppb_request_account_statement", (String) null, "", "/passbook/ppb", "passbook");
                d.b().a(getContext(), "wallet_passbook", "savings_account_list_item_clicked", "account_statement", "", "/passbook/savings-account", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                q.a(getContext(), "passbook_ppb", "account_statement_ppb_passbook_clicked", (ArrayList<String>) null, "/passbook/ppb");
                startActivity(new Intent(getContext(), StatementDownloadActivityForPPB.class));
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57305h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
