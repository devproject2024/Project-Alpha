package a.a.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f13405a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f13406b;

    public b(String str, Activity activity) {
        this.f13405a = str;
        this.f13406b = activity;
    }

    @JavascriptInterface
    public final int androidVersion() {
        return Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public final String getJwtToken() {
        return this.f13405a;
    }

    @JavascriptInterface
    public final void sdkCallback(String str) {
        Bundle bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
        } catch (JSONException unused) {
            bundle = null;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        this.f13406b.setResult(-1, intent);
        this.f13406b.finish();
    }
}
