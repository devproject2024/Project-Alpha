package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.R;

public final class CommunicationWallet extends WalletDetailInfo {
    public CommunicationWallet() {
        super(R.string.communication_wallet, R.string.paytm_communication_wallet, R.string.communication_wallet_detail, R.array.communication_wallet_know_more_points, Integer.valueOf(R.drawable.pass_loyality_detail_icon), R.array.communication_wallet_how_it_works_points);
    }
}
