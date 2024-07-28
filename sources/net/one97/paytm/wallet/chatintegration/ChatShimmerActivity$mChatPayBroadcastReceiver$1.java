package net.one97.paytm.wallet.chatintegration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.u;

public final class ChatShimmerActivity$mChatPayBroadcastReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatShimmerActivity f70131a;

    ChatShimmerActivity$mChatPayBroadcastReceiver$1(ChatShimmerActivity chatShimmerActivity) {
        this.f70131a = chatShimmerActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "data");
        a aVar = a.f70137f;
        if (a.c()) {
            a aVar2 = a.f70137f;
            ChatPaymentIntegrationListener b2 = a.b();
            if (b2 != null) {
                Serializable serializableExtra = intent.getSerializableExtra("chat_txn_response");
                if (serializableExtra != null) {
                    b2.onTransactionResponse((ChatPaymentIntegrationResponseModel) serializableExtra);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel");
                }
            }
        }
        this.f70131a.finish();
    }
}
