package a.a.a.a.a.e;

import android.os.Build;
import com.sendbird.android.constant.StringSet;
import org.json.JSONObject;

public final class a {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        b.a(jSONObject, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        b.a(jSONObject, "os", StringSet.Android);
        return jSONObject;
    }
}
