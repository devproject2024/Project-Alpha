package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public final class VpaChatPayeeUser extends ChatPayeeUser {
    private final String bankName;
    private final Boolean isVerifiedMerchant;
    private final String mid;
    private final String name;
    private final String txnCategory;
    private final String vpa;

    public final String getVpa() {
        return this.vpa;
    }

    public final String getTxnCategory() {
        return this.txnCategory;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final Boolean isVerifiedMerchant() {
        return this.isVerifiedMerchant;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VpaChatPayeeUser(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool) {
        super(ChatUserType.VPA, str);
        k.c(str, "identifier");
        k.c(str2, "vpa");
        k.c(str3, "txnCategory");
        this.vpa = str2;
        this.txnCategory = str3;
        this.name = str4;
        this.mid = str5;
        this.bankName = str6;
        this.isVerifiedMerchant = bool;
    }

    public final MTSDKTransferDetail toMTSDKTransferDetail() {
        return new MTSDKTransferDetail(4, (String) null, (String) null, (String) null, (String) null, getIdentifier(), (String) null, (String) null, (String) null, 478, (g) null);
    }
}
