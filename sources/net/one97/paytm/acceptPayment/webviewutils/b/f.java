package net.one97.paytm.acceptPayment.webviewutils.b;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.lang.ref.WeakReference;
import net.one97.paytm.acceptPayment.model.onBoarding.DownloadQRModel;
import net.one97.paytm.acceptPayment.model.onBoarding.OrderQRModel;
import net.one97.paytm.acceptPayment.webviewutils.a.d;
import net.one97.paytm.acceptPayment.webviewutils.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<Handler> f52265a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f52266b;

    public f(Handler handler, String str) {
        this.f52265a = new WeakReference<>(handler);
        this.f52266b = str;
    }

    public final String a() {
        String str = this.f52266b;
        if (str == null || str.toLowerCase().contains("ump")) {
            return "onMessageReceive";
        }
        return "onMessageReceive" + this.f52266b;
    }

    private static Message a(Exception exc) {
        Message message = new Message();
        message.obj = exc.toString();
        message.what = -1;
        return message;
    }

    private static Message d() {
        Message message = new Message();
        message.what = -2;
        return message;
    }

    private static Message g(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 == null) {
                return d();
            }
            d dVar = new d();
            if (jSONObject2.has("argument1")) {
                dVar.f52243b = jSONObject2.getString("argument1");
            }
            if (jSONObject2.has("argument2") && !TextUtils.isEmpty(jSONObject2.getString("argument2"))) {
                dVar.f52242a = jSONObject2.getString("argument2");
            }
            if (!jSONObject2.has("argument3")) {
                return d();
            }
            dVar.f52244c = jSONObject2.getString("argument3");
            Message message = new Message();
            message.what = 4;
            message.obj = dVar;
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(StringSet.token, a.q(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            jSONObject.put("mid", b.X(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            jSONObject.put("merchant_name", b.Y(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            jSONObject.put(AppConstants.VERSION, Build.VERSION.SDK_INT >= 21 || Build.VERSION.SDK_INT < 19);
            jSONObject.put("app_version", "1.0");
            jSONObject.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("build_number", "1");
            jSONObject.put("language", b.a(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()) + "-IN");
            net.one97.paytm.acceptPayment.b.b.a();
            jSONObject.put("client", net.one97.paytm.acceptPayment.b.b.a("androidClient"));
            jSONObject.put("device_identifier", b.A(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(JSONObject jSONObject) {
        return jSONObject.toString().replace("\"", "\\\"");
    }

    private Message f() {
        try {
            Message message = new Message();
            message.what = 3;
            message.obj = "javascript:" + a() + "(\"nativeData\",\"" + e().toString().replace("\"", "\\\"") + "\");";
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private Message h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 != null && jSONObject2.has("argument1")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("argument1");
                JSONObject jSONObject3 = new JSONObject();
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        net.one97.paytm.acceptPayment.b.b.a();
                        jSONObject3.put(string, net.one97.paytm.acceptPayment.b.b.a(jSONArray.getString(i2)));
                    }
                    String str = "javascript:" + a() + "(\"allGTMUrls\",\"" + jSONObject3.toString().replace("\"", "\\\"") + "\");";
                    Message message = new Message();
                    message.what = 3;
                    message.obj = str;
                    return message;
                }
            }
            return d();
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message i(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 == null || !jSONObject2.has("argument1")) {
                return d();
            }
            String string = jSONObject2.getString("argument1");
            Message message = new Message();
            message.what = 5;
            message.obj = string;
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 == null || !jSONObject2.has("argument1")) {
                return d();
            }
            Message message = new Message();
            message.what = 9;
            message.obj = Integer.valueOf(jSONObject2.getInt("argument1"));
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message k(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 == null || !jSONObject2.has("argument1")) {
                return d();
            }
            Message message = new Message();
            message.what = 10;
            message.obj = Integer.valueOf(jSONObject2.getInt("argument1"));
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message g() {
        Message message = new Message();
        message.what = 1;
        return message;
    }

    private static Message l(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has("parameters") ? jSONObject.getJSONObject("parameters") : null;
            if (jSONObject2 == null || !jSONObject2.has("argument1")) {
                return d();
            }
            String string = jSONObject2.getString("argument1");
            Message message = new Message();
            message.what = 7;
            message.obj = string;
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message b(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            if (!jSONObject.has("parameters") || (jSONObject2 = jSONObject.getJSONObject("parameters")) == null) {
                return d();
            }
            String str = "";
            String string = jSONObject2.has("argument1") ? jSONObject2.getString("argument1") : str;
            if (jSONObject2.has("argument2")) {
                str = jSONObject2.getString("argument2");
            }
            Message message = new Message();
            message.what = -5;
            message.obj = new net.one97.paytm.acceptPayment.webviewutils.a.b(string, str);
            return message;
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static Message m(JSONObject jSONObject) {
        try {
            if (jSONObject.has("parameters")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
                if (jSONObject2.has("argument1")) {
                    String string = jSONObject2.getString("argument1");
                    Message message = new Message();
                    message.what = -6;
                    message.obj = string;
                    return message;
                }
            }
        } catch (Exception e2) {
            a(e2);
        }
        return d();
    }

    private static Message n(JSONObject jSONObject) {
        try {
            if (jSONObject.has("parameters")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
                if (jSONObject2.has("argument1")) {
                    String string = jSONObject2.getString("argument1");
                    Message message = new Message();
                    message.obj = string;
                    message.what = -7;
                    return message;
                }
            }
            return d();
        } catch (Exception e2) {
            return a(e2);
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (!jSONObject.has("parameters")) {
            return null;
        }
        try {
            return jSONObject.getJSONObject("parameters");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Message d(JSONObject jSONObject) {
        Message message = new Message();
        message.what = 14;
        try {
            String str = "";
            String string = jSONObject.has("link") ? jSONObject.getString("link") : str;
            if (jSONObject.has("qrCodeId")) {
                str = jSONObject.getString("qrCodeId");
            }
            message.obj = new OrderQRModel(string, str);
            return message;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Message e(JSONObject jSONObject) {
        Message message = new Message();
        message.what = 13;
        try {
            String str = "";
            String string = jSONObject.has("displayName") ? jSONObject.getString("displayName") : str;
            String string2 = jSONObject.has("qrCodeId") ? jSONObject.getString("qrCodeId") : str;
            String string3 = jSONObject.has("qrType") ? jSONObject.getString("qrType") : str;
            if (jSONObject.has("deepLink")) {
                str = jSONObject.getString("deepLink");
            }
            message.obj = new DownloadQRModel(string, string2, string3, str);
            return message;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Message b() {
        Message message = new Message();
        message.what = 3;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : b.a.f52251a) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("features", jSONArray);
            message.obj = "javascript:onMessageReceive(\"featureListCallback\",\"" + net.one97.paytm.acceptPayment.utils.b.a(jSONObject) + "\");";
            return message;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Message c() {
        Message message = new Message();
        message.what = 16;
        return message;
    }

    public static String a(double d2, double d3, int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("permission_status", i2);
            jSONObject.put("latitude", d2);
            jSONObject.put("longitude", d3);
            String a2 = net.one97.paytm.acceptPayment.utils.b.a(jSONObject);
            return "javascript:onMessageReceive(\"" + str + "\",\"" + a2 + "\");";
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void postMessage(java.lang.String r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "eventActionName"
            java.lang.String r2 = "eventCategory"
            java.lang.String r3 = "eventType"
            java.lang.String r4 = "functionName"
            java.lang.String r5 = "eventLabels"
            java.lang.ref.WeakReference<android.os.Handler> r6 = r1.f52265a
            if (r6 == 0) goto L_0x04d9
            java.lang.Object r6 = r6.get()
            if (r6 == 0) goto L_0x04d9
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x04c9 }
            r7 = r17
            r6.<init>(r7)     // Catch:{ Exception -> 0x04c9 }
            boolean r7 = r6.has(r4)     // Catch:{ Exception -> 0x04c9 }
            if (r7 == 0) goto L_0x0028
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x04c9 }
            goto L_0x002a
        L_0x0028:
            java.lang.String r4 = ""
        L_0x002a:
            int r8 = r4.hashCode()     // Catch:{ Exception -> 0x04c9 }
            r9 = 12
            r10 = 21
            r12 = 15
            r13 = 17
            r14 = 6
            r15 = 19
            r7 = 18
            r11 = 20
            switch(r8) {
                case -2117664038: goto L_0x01c2;
                case -1927180151: goto L_0x01b8;
                case -1789066672: goto L_0x01ad;
                case -1724854704: goto L_0x01a2;
                case -1582148321: goto L_0x0196;
                case -1489008553: goto L_0x018c;
                case -1469525342: goto L_0x0181;
                case -1373464399: goto L_0x0177;
                case -1207110161: goto L_0x016c;
                case -1111243300: goto L_0x0161;
                case -1075005476: goto L_0x0155;
                case -1013284127: goto L_0x0148;
                case -888136026: goto L_0x013c;
                case -562267225: goto L_0x0130;
                case -447299664: goto L_0x0124;
                case -332286068: goto L_0x0118;
                case -135075465: goto L_0x010c;
                case 202273545: goto L_0x0100;
                case 402407612: goto L_0x00f4;
                case 495536441: goto L_0x00e9;
                case 512509569: goto L_0x00dd;
                case 563384548: goto L_0x00d1;
                case 844440553: goto L_0x00c6;
                case 1026644591: goto L_0x00ba;
                case 1427318147: goto L_0x00af;
                case 1442004378: goto L_0x00a3;
                case 1610941626: goto L_0x0096;
                case 1694238842: goto L_0x008a;
                case 1775708745: goto L_0x007e;
                case 1802825571: goto L_0x0071;
                case 1835625435: goto L_0x0065;
                case 1887631492: goto L_0x0059;
                case 1947884789: goto L_0x004e;
                case 2039140521: goto L_0x0042;
                default: goto L_0x0040;
            }     // Catch:{ Exception -> 0x04c9 }
        L_0x0040:
            goto L_0x01cd
        L_0x0042:
            java.lang.String r8 = "downloadQR"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 23
            goto L_0x01ce
        L_0x004e:
            java.lang.String r8 = "appManagerBridge"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 1
            goto L_0x01ce
        L_0x0059:
            java.lang.String r8 = "fetchSilentLocation"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 26
            goto L_0x01ce
        L_0x0065:
            java.lang.String r8 = "openApplicationStore"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 11
            goto L_0x01ce
        L_0x0071:
            java.lang.String r8 = "startGalleryForImageUpload"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 12
            goto L_0x01ce
        L_0x007e:
            java.lang.String r8 = "openHeaderLessWebView"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 16
            goto L_0x01ce
        L_0x008a:
            java.lang.String r8 = "fetchUserLocation"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 21
            goto L_0x01ce
        L_0x0096:
            java.lang.String r8 = "startCameraForImageUpload"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 8
            goto L_0x01ce
        L_0x00a3:
            java.lang.String r8 = "fetchFeatureList"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 22
            goto L_0x01ce
        L_0x00af:
            java.lang.String r8 = "redeemPointsPressed"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 0
            goto L_0x01ce
        L_0x00ba:
            java.lang.String r8 = "openWebView"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 15
            goto L_0x01ce
        L_0x00c6:
            java.lang.String r8 = "getGAEvents"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 5
            goto L_0x01ce
        L_0x00d1:
            java.lang.String r8 = "allEventsData"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 33
            goto L_0x01ce
        L_0x00dd:
            java.lang.String r8 = "changeBankAccount"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 30
            goto L_0x01ce
        L_0x00e9:
            java.lang.String r8 = "getAllGTMUrls"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 4
            goto L_0x01ce
        L_0x00f4:
            java.lang.String r8 = "completeKyc"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 29
            goto L_0x01ce
        L_0x0100:
            java.lang.String r8 = "processLink"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 17
            goto L_0x01ce
        L_0x010c:
            java.lang.String r8 = "moveToHomeScreen"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 25
            goto L_0x01ce
        L_0x0118:
            java.lang.String r8 = "changeFrequency"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 31
            goto L_0x01ce
        L_0x0124:
            java.lang.String r8 = "pushHawkeyeEvent"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 9
            goto L_0x01ce
        L_0x0130:
            java.lang.String r8 = "ppblBankAccount"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 27
            goto L_0x01ce
        L_0x013c:
            java.lang.String r8 = "hideLoadingScreen"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 14
            goto L_0x01ce
        L_0x0148:
            java.lang.String r8 = "settlementAmount"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 28
            goto L_0x01ce
        L_0x0155:
            java.lang.String r8 = "showErrorToast"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 6
            goto L_0x01ce
        L_0x0161:
            java.lang.String r8 = "onBackPressed"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 13
            goto L_0x01ce
        L_0x016c:
            java.lang.String r8 = "orderQR"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 24
            goto L_0x01ce
        L_0x0177:
            java.lang.String r8 = "sessionExpiryEvent"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 7
            goto L_0x01ce
        L_0x0181:
            java.lang.String r8 = "qrSuccess"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 19
            goto L_0x01ce
        L_0x018c:
            java.lang.String r8 = "getNativeData"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 3
            goto L_0x01ce
        L_0x0196:
            java.lang.String r8 = "sharePost"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 10
            goto L_0x01ce
        L_0x01a2:
            java.lang.String r8 = "onBoardingCompleted"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 18
            goto L_0x01ce
        L_0x01ad:
            java.lang.String r8 = "bankFrequencyChange"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 32
            goto L_0x01ce
        L_0x01b8:
            java.lang.String r8 = "onWindowClose"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 2
            goto L_0x01ce
        L_0x01c2:
            java.lang.String r8 = "qrFailMidSuccess"
            boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x04c9 }
            if (r4 == 0) goto L_0x01cd
            r4 = 20
            goto L_0x01ce
        L_0x01cd:
            r4 = -1
        L_0x01ce:
            java.lang.String r8 = "parameters"
            switch(r4) {
                case 0: goto L_0x04ae;
                case 1: goto L_0x0493;
                case 2: goto L_0x0483;
                case 3: goto L_0x0473;
                case 4: goto L_0x0463;
                case 5: goto L_0x0453;
                case 6: goto L_0x0443;
                case 7: goto L_0x042f;
                case 8: goto L_0x041f;
                case 9: goto L_0x041e;
                case 10: goto L_0x040f;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ec;
                case 13: goto L_0x03dc;
                case 14: goto L_0x03c8;
                case 15: goto L_0x03b8;
                case 16: goto L_0x03a8;
                case 17: goto L_0x038a;
                case 18: goto L_0x037a;
                case 19: goto L_0x036a;
                case 20: goto L_0x035a;
                case 21: goto L_0x0347;
                case 22: goto L_0x0335;
                case 23: goto L_0x031d;
                case 24: goto L_0x0305;
                case 25: goto L_0x02f2;
                case 26: goto L_0x02df;
                case 27: goto L_0x02cc;
                case 28: goto L_0x02b9;
                case 29: goto L_0x02a6;
                case 30: goto L_0x028b;
                case 31: goto L_0x0270;
                case 32: goto L_0x0255;
                case 33: goto L_0x01d4;
                default: goto L_0x01d3;
            }
        L_0x01d3:
            return
        L_0x01d4:
            r4 = 0
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x0250 }
            r7.<init>()     // Catch:{ Exception -> 0x0250 }
            boolean r9 = r6.has(r8)     // Catch:{ Exception -> 0x0250 }
            if (r9 == 0) goto L_0x0254
            org.json.JSONObject r6 = r6.getJSONObject(r8)     // Catch:{ Exception -> 0x0250 }
            if (r6 == 0) goto L_0x0254
            boolean r8 = r6.has(r3)     // Catch:{ Exception -> 0x0250 }
            if (r8 == 0) goto L_0x01f0
            java.lang.String r4 = r6.getString(r3)     // Catch:{ Exception -> 0x0250 }
        L_0x01f0:
            boolean r3 = r6.has(r2)     // Catch:{ Exception -> 0x0250 }
            if (r3 == 0) goto L_0x01ff
            java.lang.String r2 = r6.getString(r2)     // Catch:{ Exception -> 0x0250 }
            java.lang.String r3 = "event_category"
            r7.put(r3, r2)     // Catch:{ Exception -> 0x0250 }
        L_0x01ff:
            boolean r2 = r6.has(r0)     // Catch:{ Exception -> 0x0250 }
            if (r2 == 0) goto L_0x020e
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x0250 }
            java.lang.String r2 = "event_action"
            r7.put(r2, r0)     // Catch:{ Exception -> 0x0250 }
        L_0x020e:
            boolean r0 = r6.has(r5)     // Catch:{ Exception -> 0x0250 }
            if (r0 == 0) goto L_0x0234
            java.lang.Object r0 = r6.get(r5)     // Catch:{ Exception -> 0x0250 }
            boolean r0 = r0 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0250 }
            if (r0 == 0) goto L_0x0234
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x0250 }
            r0.<init>()     // Catch:{ Exception -> 0x0250 }
            org.json.JSONObject r2 = r6.getJSONObject(r5)     // Catch:{ Exception -> 0x0250 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0250 }
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            java.lang.Object r0 = r0.a((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x0250 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x0250 }
            r7.putAll(r0)     // Catch:{ Exception -> 0x0250 }
        L_0x0234:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0250 }
            if (r0 != 0) goto L_0x0254
            boolean r0 = r7.isEmpty()     // Catch:{ Exception -> 0x0250 }
            if (r0 != 0) goto L_0x0254
            java.lang.String r0 = "GA_PULSE"
            boolean r0 = r4.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0250 }
            if (r0 == 0) goto L_0x0254
            net.one97.paytm.acceptPayment.configs.a r0 = net.one97.paytm.acceptPayment.configs.a.f52046a     // Catch:{ Exception -> 0x0250 }
            android.app.Application r0 = r0.f52047b     // Catch:{ Exception -> 0x0250 }
            net.one97.paytm.acceptPayment.utils.b.a((android.content.Context) r0, (java.util.HashMap<java.lang.String, java.lang.Object>) r7)     // Catch:{ Exception -> 0x0250 }
            return
        L_0x0250:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x04c9 }
        L_0x0254:
            return
        L_0x0255:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = 288(0x120, float:4.04E-43)
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            org.json.JSONObject r3 = r6.optJSONObject(r8)     // Catch:{ Exception -> 0x04c9 }
            r2.obj = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0270:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = 225(0xe1, float:3.15E-43)
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            org.json.JSONObject r3 = r6.optJSONObject(r8)     // Catch:{ Exception -> 0x04c9 }
            r2.obj = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x028b:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = 224(0xe0, float:3.14E-43)
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            org.json.JSONObject r3 = r6.optJSONObject(r8)     // Catch:{ Exception -> 0x04c9 }
            r2.obj = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x02a6:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r11     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x02b9:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r15     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x02cc:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r7     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x02df:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r13     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x02f2:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r12     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0305:
            org.json.JSONObject r0 = c(r6)     // Catch:{ Exception -> 0x04c9 }
            if (r0 == 0) goto L_0x04d9
            android.os.Message r0 = d(r0)     // Catch:{ Exception -> 0x04c9 }
            if (r0 == 0) goto L_0x04d9
            java.lang.ref.WeakReference<android.os.Handler> r2 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r2 = (android.os.Handler) r2     // Catch:{ Exception -> 0x04c9 }
            r2.sendMessage(r0)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x031d:
            org.json.JSONObject r0 = c(r6)     // Catch:{ Exception -> 0x04c9 }
            if (r0 == 0) goto L_0x04d9
            android.os.Message r0 = e(r0)     // Catch:{ Exception -> 0x04c9 }
            if (r0 == 0) goto L_0x04d9
            java.lang.ref.WeakReference<android.os.Handler> r2 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r2 = (android.os.Handler) r2     // Catch:{ Exception -> 0x04c9 }
            r2.sendMessage(r0)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0335:
            android.os.Message r0 = b()     // Catch:{ Exception -> 0x04c9 }
            if (r0 == 0) goto L_0x04d9
            java.lang.ref.WeakReference<android.os.Handler> r2 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r2 = (android.os.Handler) r2     // Catch:{ Exception -> 0x04c9 }
            r2.sendMessage(r0)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0347:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r9     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x035a:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = g()     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x036a:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = c()     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x037a:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = c()     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x038a:
            android.os.Message r0 = n(r6)     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r2 = r0.obj     // Catch:{ Exception -> 0x04c9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x04c9 }
            java.lang.String r3 = "paytmmp://accept_money?featuretype=open-upi-flow"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x04c9 }
            if (r2 == 0) goto L_0x039c
            r0.what = r10     // Catch:{ Exception -> 0x04c9 }
        L_0x039c:
            java.lang.ref.WeakReference<android.os.Handler> r2 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r2 = (android.os.Handler) r2     // Catch:{ Exception -> 0x04c9 }
            r2.sendMessage(r0)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03a8:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = m(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03b8:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = b(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03c8:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = -3
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03dc:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = g()     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03ec:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = k(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x03fc:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r2.what = r14     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x040f:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = l(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
        L_0x041e:
            return
        L_0x041f:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = j(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x042f:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = 0
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0443:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = i(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0453:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = g(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0463:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = r1.h(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0473:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = r16.f()     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0483:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = f(r6)     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x0493:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            r3 = 267(0x10b, float:3.74E-43)
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            org.json.JSONObject r3 = r6.optJSONObject(r8)     // Catch:{ Exception -> 0x04c9 }
            r2.obj = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x04ae:
            java.lang.ref.WeakReference<android.os.Handler> r0 = r1.f52265a     // Catch:{ Exception -> 0x04c9 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x04c9 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Exception -> 0x04c9 }
            android.os.Message r2 = new android.os.Message     // Catch:{ Exception -> 0x04c9 }
            r2.<init>()     // Catch:{ Exception -> 0x04c9 }
            org.json.JSONObject r3 = r6.optJSONObject(r8)     // Catch:{ Exception -> 0x04c9 }
            r2.obj = r3     // Catch:{ Exception -> 0x04c9 }
            r3 = 367(0x16f, float:5.14E-43)
            r2.what = r3     // Catch:{ Exception -> 0x04c9 }
            r0.sendMessage(r2)     // Catch:{ Exception -> 0x04c9 }
            return
        L_0x04c9:
            r0 = move-exception
            java.lang.ref.WeakReference<android.os.Handler> r2 = r1.f52265a
            java.lang.Object r2 = r2.get()
            android.os.Handler r2 = (android.os.Handler) r2
            android.os.Message r0 = a((java.lang.Exception) r0)
            r2.sendMessage(r0)
        L_0x04d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.webviewutils.b.f.postMessage(java.lang.String):void");
    }

    private static Message f(JSONObject jSONObject) {
        if (!jSONObject.has("data")) {
            return d();
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            Message message = new Message();
            message.what = 879;
            message.obj = jSONObject2;
            return message;
        } catch (JSONException e2) {
            return a((Exception) e2);
        }
    }
}
