package net.one97.paytm.chat;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.android.chat.d;
import kotlin.g.b.k;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationListener;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;

public final class ChatImplProvider$onPayButtonClick$1 implements ChatPaymentIntegrationListener {
    final /* synthetic */ String $channelUrl;
    final /* synthetic */ d.a $listener;
    final /* synthetic */ ChatImplProvider this$0;

    ChatImplProvider$onPayButtonClick$1(ChatImplProvider chatImplProvider, String str, d.a aVar) {
        this.this$0 = chatImplProvider;
        this.$channelUrl = str;
        this.$listener = aVar;
    }

    public final void onTransactionResponse(ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel) {
        k.c(chatPaymentIntegrationResponseModel, Payload.RESPONSE);
        ChatImplProvider.a(this.this$0, this.$channelUrl, chatPaymentIntegrationResponseModel, this.$listener);
    }
}
