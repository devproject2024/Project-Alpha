package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public final class CustomerChatPayeeUser extends ChatPayeeUser {
    private final String mobileNo;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public final String getMobileNo() {
        return this.mobileNo;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatPayeeUser(String str, String str2, String str3) {
        super(ChatUserType.CUSTOMER, str);
        k.c(str, "identifier");
        this.name = str2;
        this.mobileNo = str3;
    }

    public final MTSDKTransferDetail toMTSDKTransferDetail() {
        return new MTSDKTransferDetail(1, getIdentifier(), this.mobileNo, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 504, (g) null);
    }
}
