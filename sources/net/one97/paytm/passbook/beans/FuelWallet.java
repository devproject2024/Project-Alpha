package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.R;

public final class FuelWallet extends WalletDetailInfo {
    public FuelWallet() {
        super(R.string.fuel_wallet, R.string.paytm_fuel_wallet, R.string.fuel_wallet_detail, R.array.fuel_wallet_know_more_points, Integer.valueOf(R.drawable.pass_loyality_detail_icon), R.array.fuel_wallet_how_it_works_points);
    }
}
