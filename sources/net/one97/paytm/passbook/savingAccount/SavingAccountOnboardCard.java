package net.one97.paytm.passbook.savingAccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class SavingAccountOnboardCard extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f58242a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavingAccountOnboardCard(Context context) {
        super(context);
        k.c(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_layout_saving_account_onboard_card, (ViewGroup) null);
        this.f58242a = (TextView) inflate.findViewById(R.id.openSavingAccountTV);
        addView(inflate);
        setVisibility(8);
    }

    public final TextView getOpenAccountTv() {
        return this.f58242a;
    }

    public final void setOpenAccountTv(TextView textView) {
        this.f58242a = textView;
    }
}
