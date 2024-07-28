package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public final class BankChatPayeeUser extends ChatPayeeUser {
    private final String accRefId;
    private final String bankLogoUrl;
    private final String bankName;
    private final String ifsc;
    private final String maskedAccNo;
    private final String mobileNo;
    private final String name;

    public final String getBankName() {
        return this.bankName;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final String getMaskedAccNo() {
        return this.maskedAccNo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMobileNo() {
        return this.mobileNo;
    }

    public final String getBankLogoUrl() {
        return this.bankLogoUrl;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankChatPayeeUser(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(ChatUserType.BANK, str);
        k.c(str, "identifier");
        k.c(str2, "bankName");
        k.c(str3, "accRefId");
        k.c(str4, "maskedAccNo");
        this.bankName = str2;
        this.accRefId = str3;
        this.maskedAccNo = str4;
        this.name = str5;
        this.mobileNo = str6;
        this.bankLogoUrl = str7;
        this.ifsc = str8;
    }

    public final MTSDKTransferDetail toMTSDKTransferDetail() {
        return new MTSDKTransferDetail(2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getIdentifier(), 254, (g) null);
    }
}
