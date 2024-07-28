package net.one97.paytm.games.e.a;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.a;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.a.k;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.PFGGameWebActivity;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.pfg.Game;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f35596a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final List<Integer> f35597b = k.b((T[]) new Integer[]{1, 3});

    private e() {
    }

    public static /* synthetic */ void a(Context context, Game game) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(game, "game");
        if (!f.a(context)) {
            try {
                a aVar = a.f35590a;
                Toast.makeText(a.a(context), R.string.com_gamepind_no_internet_available, 0).show();
            } catch (Exception unused) {
                Toast.makeText(context, "No internet connection", 0).show();
            }
        } else if (a.p(context)) {
            Intent intent = new Intent(context, PFGGameWebActivity.class);
            intent.addFlags(67108864);
            intent.putExtra("object1", game);
            context.startActivity(intent);
        } else {
            g a2 = g.a();
            kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
            context.startActivity(a2.c().getLoginScreenIntent(context));
        }
    }

    public static JSONArray a(JSONArray jSONArray, String str, String str2) {
        kotlin.g.b.k.c(str, H5Param.PARAM);
        kotlin.g.b.k.c(str2, "value");
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Iterator<String> keys = jSONObject.keys();
            kotlin.g.b.k.a((Object) keys, "keys");
            while (keys.hasNext()) {
                keys.next();
                String string = jSONObject.getString("type");
                kotlin.g.b.k.a((Object) string, "jsonObject.getString(HOME_PAGE_TYPE)");
                if (str.contentEquals(string)) {
                    jSONObject.put("data", str2);
                }
            }
        }
        return jSONArray;
    }

    public static String a(String str) {
        kotlin.g.b.k.c(str, "str");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("HEONLCgF7Hj0owB2".getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            String replace = Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0).replace(StringUtility.NEW_LINE, "");
            kotlin.g.b.k.a((Object) replace, "AES.Encrypt(str, publickey)");
            return replace;
        } catch (Exception unused) {
            return "";
        }
    }
}
