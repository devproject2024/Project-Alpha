package net.one97.paytm.ups.network;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import java.util.List;

public interface UpsNetworkHelper {
    a getConsentNetworkCall(Context context, b bVar, List<String> list, String str);

    a putConsentNetworkCall(Context context, b bVar, String str, String str2);
}
