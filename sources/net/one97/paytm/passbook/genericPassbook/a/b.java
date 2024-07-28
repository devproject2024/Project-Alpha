package net.one97.paytm.passbook.genericPassbook.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.statementDownload.StatementDownloadActivityForPPB;

public final class b extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f57274a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f57275b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f57276c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_ica_cta, viewGroup, false);
        RelativeLayout relativeLayout = null;
        RelativeLayout relativeLayout2 = inflate != null ? (RelativeLayout) inflate.findViewById(R.id.rl_money_transfer_layout) : null;
        if (relativeLayout2 == null) {
            k.a();
        }
        this.f57275b = relativeLayout2;
        if (inflate != null) {
            relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_download_saving_account_statement);
        }
        if (relativeLayout == null) {
            k.a();
        }
        this.f57274a = relativeLayout;
        RelativeLayout relativeLayout3 = this.f57275b;
        if (relativeLayout3 == null) {
            k.a("rlMoneyTransferLayout");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout3.setOnClickListener(onClickListener);
        RelativeLayout relativeLayout4 = this.f57274a;
        if (relativeLayout4 == null) {
            k.a("rlDownloadSavingAccountStatement");
        }
        relativeLayout4.setOnClickListener(onClickListener);
        return inflate;
    }

    public final void onClick(View view) {
        if (view != null) {
            RelativeLayout relativeLayout = this.f57275b;
            if (relativeLayout == null) {
                k.a("rlMoneyTransferLayout");
            }
            if (!k.a((Object) view, (Object) relativeLayout)) {
                RelativeLayout relativeLayout2 = this.f57274a;
                if (relativeLayout2 == null) {
                    k.a("rlDownloadSavingAccountStatement");
                }
                if (k.a((Object) view, (Object) relativeLayout2)) {
                    Intent intent = new Intent(getContext(), StatementDownloadActivityForPPB.class);
                    intent.putExtra("accountType", "ICA");
                    startActivity(intent);
                }
            } else if (com.paytm.utility.b.r(getContext())) {
                Context context = getContext();
                f b2 = d.b();
                k.a((Object) b2, "PassbookHelper.getImplListener()");
                Intent intent2 = new Intent(context, b2.n());
                k.a((Object) d.b(), "PassbookHelper.getImplListener()");
                intent2.putExtra("send money to bank from passbbok", true);
                startActivityForResult(intent2, 126);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57276c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
