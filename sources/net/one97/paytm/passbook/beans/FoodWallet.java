package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.R;

public final class FoodWallet extends WalletDetailInfo {
    public FoodWallet() {
        super(R.string.food_wallet, R.string.paytm_food_wallet, R.string.food_wallet_detail, R.array.food_wallet_know_more_points, Integer.valueOf(R.drawable.pass_food_detail_icon), R.array.food_wallet_how_it_works_points);
    }
}
