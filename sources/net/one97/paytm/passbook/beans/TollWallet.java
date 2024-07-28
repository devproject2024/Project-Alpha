package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.R;

public final class TollWallet extends WalletDetailInfo {
    public TollWallet() {
        super(R.string.toll_wallet, R.string.paytm_toll_wallet, R.string.toll_wallet_detail, R.array.toll_wallet_know_more_points, Integer.valueOf(R.drawable.pass_toll_detail_icon), R.array.toll_wallet_how_it_works_points);
    }
}
