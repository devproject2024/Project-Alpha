package com.alipay.mobile.nebulacore.util;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class H5PPQueryThread implements Runnable {
    public static final String TAG = "H5PPQueryThread";
    private static final int TIMEOUT = 5000;
    private static H5PPQueryThread mInstance;
    private H5Page h5Page;
    private boolean isRunning = false;
    private OnGetQueryResult onGetQueryResult;
    private String queryUrl = "http://patriot.cs.pp.cn/api/resource.app.detect";
    private int type;
    private String url;

    public interface OnGetQueryResult {
        void onQueryResult(String str, String str2);
    }

    private H5PPQueryThread() {
    }

    public static synchronized H5PPQueryThread getInstance() {
        H5PPQueryThread h5PPQueryThread;
        synchronized (H5PPQueryThread.class) {
            if (mInstance == null) {
                mInstance = new H5PPQueryThread();
            }
            h5PPQueryThread = mInstance;
        }
        return h5PPQueryThread;
    }

    public void setParams(String str, int i2, OnGetQueryResult onGetQueryResult2, H5Page h5Page2) {
        this.url = str;
        this.type = i2;
        this.onGetQueryResult = onGetQueryResult2;
        this.h5Page = h5Page2;
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_ppConfig"));
        if (parseObject != null) {
            this.queryUrl = H5Utils.getString(parseObject, "h5_ppQueryUrl");
            H5Log.d(TAG, "queryUrl is " + this.queryUrl);
        }
    }

    public void run() {
        if (this.isRunning) {
            H5Log.d(TAG, "isRunning return");
            return;
        }
        try {
            this.isRunning = true;
            this.h5Page.sendEvent("showLoading", (e) null);
            String doPost = doPost(generateRequestJsonStr());
            H5Log.d(TAG, "result is ".concat(String.valueOf(doPost)));
            parseRespnseJsonStr(doPost);
        } catch (Exception e2) {
            H5Log.e(TAG, "catch exception", e2);
        } finally {
            this.h5Page.sendEvent(H5Plugin.CommonEvents.HIDE_LOADING, (e) null);
            this.isRunning = false;
        }
    }

    private String generateRequestJsonStr() {
        long currentTimeMillis = System.currentTimeMillis();
        String md5 = H5SecurityUtil.getMD5("secret.alipay.client" + ("query=" + this.url + "type=" + this.type) + "fjwofu4n2wg");
        e eVar = new e();
        try {
            eVar.put("id", (Object) String.valueOf(currentTimeMillis));
            eVar.put("encrypt", (Object) "md5");
            eVar.put("sign", (Object) md5);
            e eVar2 = new e();
            eVar2.put("caller", (Object) "secret.alipay.client");
            eVar.put("client", (Object) eVar2);
            e eVar3 = new e();
            eVar3.put("query", (Object) this.url);
            eVar3.put("type", (Object) Integer.valueOf(this.type));
            eVar.put("data", (Object) eVar3);
        } catch (Exception e2) {
            H5Log.e(TAG, "generateRequestJsonStr catch exception ", e2);
        }
        return eVar.toString();
    }

    public String doPost(String str) {
        PrintWriter printWriter;
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.queryUrl).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("charset", "utf-8");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(TIMEOUT);
            httpURLConnection.setConnectTimeout(TIMEOUT);
            if (str == null || str2.equals(str.trim())) {
                printWriter = null;
            } else {
                printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                try {
                    printWriter.print(str);
                    printWriter.flush();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        H5Log.e(TAG, "dopost catch exception ", e);
                        silentClose(bufferedReader);
                        silentClose(printWriter);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        silentClose(bufferedReader);
                        silentClose(printWriter);
                        throw th;
                    }
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (Exception e3) {
                        Exception exc = e3;
                        bufferedReader = bufferedReader2;
                        e = exc;
                        H5Log.e(TAG, "dopost catch exception ", e);
                        silentClose(bufferedReader);
                        silentClose(printWriter);
                        return str2;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        silentClose(bufferedReader);
                        silentClose(printWriter);
                        throw th;
                    }
                }
                bufferedReader = bufferedReader2;
            } else {
                e eVar = new e();
                eVar.put("queryUrl", (Object) this.queryUrl);
                eVar.put("queryParam", (Object) str);
                eVar.put("statusCode", (Object) Integer.valueOf(responseCode));
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_QUERY_PP, eVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            e eVar2 = new e();
            eVar2.put("httpcost", (Object) Long.valueOf(currentTimeMillis2));
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_QUERY_PP_COST, eVar2);
            H5Log.d(TAG, "http cost ".concat(String.valueOf(currentTimeMillis2)));
        } catch (Exception e4) {
            e = e4;
            printWriter = null;
            H5Log.e(TAG, "dopost catch exception ", e);
            silentClose(bufferedReader);
            silentClose(printWriter);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            printWriter = null;
            silentClose(bufferedReader);
            silentClose(printWriter);
            throw th;
        }
        silentClose(bufferedReader);
        silentClose(printWriter);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r5 = r5.getJSONObject("data");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseRespnseJsonStr(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "H5PPQueryThread"
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0056 }
            if (r2 != 0) goto L_0x0050
            com.alibaba.a.e r5 = com.alibaba.a.e.parseObject(r5)     // Catch:{ Exception -> 0x0056 }
            r0 = 0
            if (r5 == 0) goto L_0x0020
            java.lang.String r2 = "data"
            com.alibaba.a.e r5 = r5.getJSONObject(r2)     // Catch:{ Exception -> 0x0056 }
            if (r5 == 0) goto L_0x0020
            java.lang.String r2 = "app"
            com.alibaba.a.e r5 = r5.getJSONObject(r2)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0021
        L_0x0020:
            r5 = r0
        L_0x0021:
            if (r5 == 0) goto L_0x0049
            java.lang.String r0 = "detailUrl"
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = "packageName"
            java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x0056 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = "detailUrl is "
            r2.<init>(r3)     // Catch:{ Exception -> 0x0056 }
            r2.append(r0)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = ", packageName is "
            r2.append(r3)     // Catch:{ Exception -> 0x0056 }
            r2.append(r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0056 }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)     // Catch:{ Exception -> 0x0056 }
            goto L_0x004a
        L_0x0049:
            r5 = r0
        L_0x004a:
            com.alipay.mobile.nebulacore.util.H5PPQueryThread$OnGetQueryResult r2 = r4.onGetQueryResult     // Catch:{ Exception -> 0x0056 }
            r2.onQueryResult(r0, r5)     // Catch:{ Exception -> 0x0056 }
            return
        L_0x0050:
            com.alipay.mobile.nebulacore.util.H5PPQueryThread$OnGetQueryResult r5 = r4.onGetQueryResult     // Catch:{ Exception -> 0x0056 }
            r5.onQueryResult(r0, r0)     // Catch:{ Exception -> 0x0056 }
            return
        L_0x0056:
            r5 = move-exception
            java.lang.String r0 = "parseRespnseJsonStr catch exception "
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.util.H5PPQueryThread.parseRespnseJsonStr(java.lang.String):void");
    }

    private void silentClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                H5Log.e(TAG, "silentClose exception.", th);
            }
        }
    }
}
