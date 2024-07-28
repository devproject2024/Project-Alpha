package net.one97.paytm;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.CjrSafeJobIntentService;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import com.paytm.utility.q;
import java.io.IOException;
import net.one97.paytm.utils.ag;

public class GoogleAdvertisementIDInfo extends CjrSafeJobIntentService {
    public static void a(Context context) {
        Class<GoogleAdvertisementIDInfo> cls = GoogleAdvertisementIDInfo.class;
        Intent intent = new Intent(context, cls);
        intent.setAction("net.one97.paytm.common.utility.action.GET_ADVERTISING_ID");
        a(context, (Class<?>) cls, 4289, intent);
    }

    public final void a(Intent intent) {
        if ("net.one97.paytm.common.utility.action.GET_ADVERTISING_ID".equals(intent.getAction())) {
            AdvertisingIdClient.a aVar = null;
            try {
                aVar = AdvertisingIdClient.a(getApplicationContext());
            } catch (IOException e2) {
                q.b(e2.getMessage());
            } catch (e e3) {
                q.b(e3.getMessage());
            } catch (f e4) {
                q.b(e4.getMessage());
            }
            if (aVar != null && aVar.f8043a != null) {
                ag.a(getApplicationContext()).a("ADVERTISING_ID", aVar.f8043a, true);
            }
        }
    }
}
