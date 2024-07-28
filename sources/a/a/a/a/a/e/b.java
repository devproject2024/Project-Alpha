package a.a.a.a.a.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static float f734a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b  reason: collision with root package name */
    private static WindowManager f735b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f736c = {"x", "y", StringSet.width, StringSet.height};

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final float f737a;

        /* renamed from: b  reason: collision with root package name */
        final float f738b;

        a(float f2, float f3) {
            this.f737a = f2;
            this.f738b = f3;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            f734a = context.getResources().getDisplayMetrics().density;
            f735b = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            StringBuilder sb = new StringBuilder("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
        }
    }

    public static void a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static JSONObject a(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i2) / f734a));
            jSONObject.put("y", (double) (((float) i3) / f734a));
            jSONObject.put(StringSet.width, (double) (((float) i4) / f734a));
            jSONObject.put(StringSet.height, (double) (((float) i5) / f734a));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject) {
        float f2;
        JSONObject jSONObject2 = jSONObject;
        float f3 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject2.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f4 = 0.0f;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble(StringSet.width);
                        double optDouble4 = optJSONObject.optDouble(StringSet.height);
                        f3 = Math.max(f3, (float) (optDouble + optDouble3));
                        f4 = Math.max(f4, (float) (optDouble2 + optDouble4));
                    }
                }
                f2 = f4;
                a aVar = new a(f3, f2);
                jSONObject2.put(StringSet.width, (double) aVar.f737a);
                jSONObject2.put(StringSet.height, (double) aVar.f738b);
            }
        } else if (f735b != null) {
            Point point = new Point(0, 0);
            f735b.getDefaultDisplay().getRealSize(point);
            f3 = ((float) point.x) / f734a;
            f2 = ((float) point.y) / f734a;
            a aVar2 = new a(f3, f2);
            jSONObject2.put(StringSet.width, (double) aVar2.f737a);
            jSONObject2.put(StringSet.height, (double) aVar2.f738b);
        }
        f2 = 0.0f;
        a aVar22 = new a(f3, f2);
        try {
            jSONObject2.put(StringSet.width, (double) aVar22.f737a);
            jSONObject2.put(StringSet.height, (double) aVar22.f738b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(org.json.JSONObject r10, org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x009e
            if (r11 == 0) goto L_0x009e
            java.lang.String[] r2 = f736c
            int r3 = r2.length
            r4 = 0
        L_0x000f:
            if (r4 >= r3) goto L_0x0024
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0021
            r2 = 0
            goto L_0x0025
        L_0x0021:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0024:
            r2 = 1
        L_0x0025:
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x0047
            if (r2 == 0) goto L_0x0068
        L_0x0047:
            boolean r5 = a((org.json.JSONArray) r4, (org.json.JSONArray) r2)
            if (r5 != 0) goto L_0x004f
        L_0x004d:
            r2 = 0
            goto L_0x0069
        L_0x004f:
            r5 = 0
        L_0x0050:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x0068
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0065
            goto L_0x004d
        L_0x0065:
            int r5 = r5 + 1
            goto L_0x0050
        L_0x0068:
            r2 = 1
        L_0x0069:
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L_0x0079
            if (r11 == 0) goto L_0x009a
        L_0x0079:
            boolean r2 = a((org.json.JSONArray) r10, (org.json.JSONArray) r11)
            if (r2 != 0) goto L_0x0081
        L_0x007f:
            r10 = 0
            goto L_0x009b
        L_0x0081:
            r2 = 0
        L_0x0082:
            int r3 = r10.length()
            if (r2 >= r3) goto L_0x009a
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = b(r3, r4)
            if (r3 != 0) goto L_0x0097
            goto L_0x007f
        L_0x0097:
            int r2 = r2 + 1
            goto L_0x0082
        L_0x009a:
            r10 = 1
        L_0x009b:
            if (r10 == 0) goto L_0x009e
            return r0
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.e.b.b(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
