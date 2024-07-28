package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.HashMap;

public interface PhoenixGenerateShortLinkProvider {
    void generateShortLink(Context context, HashMap<String, String> hashMap, PhoenixGenerateShortLinkProviderCallback phoenixGenerateShortLinkProviderCallback);
}
