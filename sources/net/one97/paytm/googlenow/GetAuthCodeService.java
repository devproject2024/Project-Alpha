package net.one97.paytm.googlenow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.CjrSafeJobIntentService;
import com.google.android.c.c;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.utils.o;

public class GetAuthCodeService extends CjrSafeJobIntentService {
    public static void a(Context context, Intent intent) {
        a(context, (Class<?>) GetAuthCodeService.class, 4576, intent);
    }

    public final void a(Intent intent) {
        Intent intent2 = new Intent("com.google.api.services.paytm.now.paytmclient.BROADCAST");
        Bundle extras = intent.getExtras();
        String a2 = o.a("UnK_24esVfn6ALoNxAzM28qVGeHPeuUhvXKoEblqS8xprPKsUO5SFJzc1oEpdmeCOcNbLJfCJUah\n    FlrKRWcguAWZDzQnujGDHmAKoarMivM=");
        HashMap hashMap = new HashMap();
        if (extras != null) {
            intent2.putExtras(extras);
            Serializable serializable = extras.getSerializable("params");
            if (serializable != null) {
                hashMap.putAll((HashMap) serializable);
            }
        }
        try {
            intent2.putExtra("authCode", c.a(this, a2));
        } catch (IOException e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        } catch (c.a | c.C0111c | c.d unused) {
        } catch (c.b e3) {
            intent2.putExtra("access_token", e3.getAccessToken());
        } catch (SecurityException e4) {
            if (b.v) {
                q.b(e4.getMessage());
            }
        } catch (Throwable th) {
            intent2.setPackage(getPackageName());
            sendBroadcast(intent2);
            throw th;
        }
        intent2.setPackage(getPackageName());
        sendBroadcast(intent2);
    }
}
