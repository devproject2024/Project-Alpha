package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public final class MerchantChatPayeeUser extends ChatPayeeUser {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MerchantChatPayeeUser(String str) {
        super(ChatUserType.MERCHANT, str);
        k.c(str, "identifier");
    }

    public final MTSDKTransferDetail toMTSDKTransferDetail() {
        return new MTSDKTransferDetail(5, (String) null, (String) null, (String) null, (String) null, (String) null, getIdentifier(), (String) null, (String) null, 446, (g) null);
    }
}
