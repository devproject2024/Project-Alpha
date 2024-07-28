package net.one97.paytm.passbook.beans;

import android.content.Context;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.utility.n;

public class WalletDetailInfo {
    public static final Companion Companion = new Companion((g) null);
    private int detail;
    private int howItWorkArray;
    private Integer icon;
    private int oneLinerArray;
    private int title;
    private int walletName;

    public WalletDetailInfo(int i2, int i3, int i4, int i5, Integer num, int i6) {
        this.walletName = i2;
        this.title = i3;
        this.detail = i4;
        this.oneLinerArray = i5;
        this.icon = num;
        this.howItWorkArray = i6;
    }

    public final int getWalletName() {
        return this.walletName;
    }

    public final void setWalletName(int i2) {
        this.walletName = i2;
    }

    public final int getTitle() {
        return this.title;
    }

    public final void setTitle(int i2) {
        this.title = i2;
    }

    /* access modifiers changed from: protected */
    public final int getDetail() {
        return this.detail;
    }

    /* access modifiers changed from: protected */
    public final void setDetail(int i2) {
        this.detail = i2;
    }

    public final int getOneLinerArray() {
        return this.oneLinerArray;
    }

    public final void setOneLinerArray(int i2) {
        this.oneLinerArray = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletDetailInfo(int i2, int i3, int i4, int i5, Integer num, int i6, int i7, g gVar) {
        this(i2, i3, i4, i5, (i7 & 16) != 0 ? null : num, i6);
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final void setIcon(Integer num) {
        this.icon = num;
    }

    public final int getHowItWorkArray() {
        return this.howItWorkArray;
    }

    public final void setHowItWorkArray(int i2) {
        this.howItWorkArray = i2;
    }

    public String getDetailText(Context context, String... strArr) {
        k.c(context, "context");
        k.c(strArr, "placeholderString");
        String string = context.getString(this.detail, new Object[]{strArr[0], strArr[0]});
        k.a((Object) string, "context.getString(detail,it.get(0),it.get(0))");
        return string;
    }

    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[n.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[n.FOOD_WALLET.ordinal()] = 1;
                $EnumSwitchMapping$0[n.GIFT_CARDS.ordinal()] = 2;
                $EnumSwitchMapping$0[n.TOLL.ordinal()] = 3;
                $EnumSwitchMapping$0[n.ALLOWALANCE_WALLET.ordinal()] = 4;
                $EnumSwitchMapping$0[n.FUEL_WALLET.ordinal()] = 5;
                $EnumSwitchMapping$0[n.COMMUNICATION_WALLET.ordinal()] = 6;
                $EnumSwitchMapping$0[n.LOYALTY_WALLET.ordinal()] = 7;
                $EnumSwitchMapping$0[n.LOYALTY_WALLET_TYPE_7.ordinal()] = 8;
                $EnumSwitchMapping$0[n.PAYTM_COINS.ordinal()] = 9;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WalletDetailInfo getWalletData(CJRSubWallet cJRSubWallet) {
            k.c(cJRSubWallet, "subWallet");
            n passbookTypeByWalletType = n.getPassbookTypeByWalletType(cJRSubWallet);
            if (passbookTypeByWalletType == null) {
                return null;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[passbookTypeByWalletType.ordinal()]) {
                case 1:
                    return new FoodWallet();
                case 2:
                    return new GiftWallet();
                case 3:
                    return new TollWallet();
                case 4:
                    return new AllowanceWalletGeneric();
                case 5:
                    return new FuelWallet();
                case 6:
                    return new CommunicationWallet();
                case 7:
                case 8:
                    if (cJRSubWallet.getSubWalletType() == 7 && cJRSubWallet.getmIssuerId() != null) {
                        String str = cJRSubWallet.getmIssuerId();
                        f b2 = d.b();
                        k.a((Object) b2, "PassbookHelper.getImplListener()");
                        if (p.a(str, b2.b().getString(R.string.pass_gamepind_wallet_issuer_id), true)) {
                            return new PaytmFirstGameWallet();
                        }
                    }
                    return new LoyaltyWalletGeneric();
                case 9:
                    return new PaytmCoins();
                default:
                    return null;
            }
        }
    }
}
