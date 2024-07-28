package net.one97.paytm.common.entity.chat.moneytransfer;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail;

public abstract class ChatPayeeUser implements IJRDataModel {
    private final String identifier;
    private final ChatUserType type;

    public abstract MTSDKTransferDetail toMTSDKTransferDetail();

    public ChatPayeeUser(ChatUserType chatUserType, String str) {
        k.c(chatUserType, "type");
        k.c(str, "identifier");
        this.type = chatUserType;
        this.identifier = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ChatUserType getType() {
        return this.type;
    }
}
