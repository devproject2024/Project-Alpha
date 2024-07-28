package net.one97.paytm.passbook.beans;

import android.content.Context;
import java.util.Arrays;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class LoyaltyWalletGeneric extends WalletDetailInfo {
    public LoyaltyWalletGeneric() {
        super(R.string.loyalty_wallet, R.string.paytm_loyalty_wallet, R.string.loyalty_wallet_generic_detail, R.array.loyalty_wallet_generic_know_more_points, Integer.valueOf(R.drawable.pass_loyality_detail_icon), R.array.loyalty_wallet_generic_how_it_works_points);
    }

    public final String getDetailText(Context context, String... strArr) {
        k.c(context, "context");
        k.c(strArr, "placeholderString");
        return super.getDetailText(context, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
