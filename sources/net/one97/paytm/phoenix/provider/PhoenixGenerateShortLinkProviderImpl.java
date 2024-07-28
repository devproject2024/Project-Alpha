package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.utils.m;

public final class PhoenixGenerateShortLinkProviderImpl implements PhoenixGenerateShortLinkProvider {
    private final String channelName = "whatsapp";

    public final String getChannelName() {
        return this.channelName;
    }

    public final void generateShortLink(Context context, HashMap<String, String> hashMap, PhoenixGenerateShortLinkProviderCallback phoenixGenerateShortLinkProviderCallback) {
        k.c(context, "context");
        k.c(hashMap, "params");
        k.c(phoenixGenerateShortLinkProviderCallback, H5Event.TYPE_CALL_BACK);
        if (hashMap.size() > 0) {
            try {
                String str = hashMap.get("af_dp");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("af_dp", URLDecoder.decode(str, AppConstants.UTF_8));
                }
            } catch (UnsupportedEncodingException e2) {
                getClass().getCanonicalName();
                q.b(e2.getMessage());
            }
            m mVar = m.f69757a;
            m.a(context, this.channelName, hashMap, new PhoenixGenerateShortLinkProviderImpl$generateShortLink$generateShortUrl$1(phoenixGenerateShortLinkProviderCallback), 0);
            return;
        }
        phoenixGenerateShortLinkProviderCallback.onResult("");
    }
}
