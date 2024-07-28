package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.R;

public final class GiftWallet extends WalletDetailInfo {
    public GiftWallet() {
        super(R.string.gift_wallet, R.string.paytm_gift_wallet, R.string.gift_wallet_detail, R.array.gift_wallet_know_more_points, Integer.valueOf(R.drawable.pass_gift_wallet_detail_icon), R.array.gift_wallet_how_it_works_points);
    }
}
