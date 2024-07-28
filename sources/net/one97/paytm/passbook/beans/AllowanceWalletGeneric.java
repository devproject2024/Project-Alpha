package net.one97.paytm.passbook.beans;

import android.content.Context;
import java.util.Arrays;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class AllowanceWalletGeneric extends WalletDetailInfo {
    public AllowanceWalletGeneric() {
        super(R.string.allowance_wallet, R.string.paytm_allowance_wallet, R.string.allowance_generic_wallet_detail, R.array.allowance_generic_wallet_know_more_points, Integer.valueOf(R.drawable.pass_loyality_detail_icon), R.array.allowance_generic_wallet_how_it_works_points);
    }

    public final String getDetailText(Context context, String... strArr) {
        k.c(context, "context");
        k.c(strArr, "placeholderString");
        return super.getDetailText(context, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
