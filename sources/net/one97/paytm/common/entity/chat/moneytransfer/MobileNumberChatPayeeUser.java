package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public final class MobileNumberChatPayeeUser extends ChatPayeeUser {
    private final String name;

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileNumberChatPayeeUser(String str, String str2) {
        super(ChatUserType.MOBILE_NUMBER, str);
        k.c(str, "identifier");
        this.name = str2;
    }

    public final MTSDKTransferDetail toMTSDKTransferDetail() {
        return new MTSDKTransferDetail(3, (String) null, getIdentifier(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 506, (g) null);
    }
}
