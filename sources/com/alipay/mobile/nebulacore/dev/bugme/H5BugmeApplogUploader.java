package com.alipay.mobile.nebulacore.dev.bugme;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5LoginProvider;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebulacore.Nebula;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class H5BugmeApplogUploader {
    private static final String SUFFIX_2ND_LOG = ".2nd";
    private static final String SUFFIX_NORMAL_ZIP = ".zip";
    private static final String SUFFIX_POSITIVE = ".pzt";
    private static final String TAG = "H5BugmeApplogUploader";
    private static final String UPLOAD_URL = "https://hpmweb.alipay.com/report/upload/android";
    private Context mContext;
    private SimpleDateFormat mDateHourFormat = new SimpleDateFormat("yyyyMMddHH");
    private Set<String> mUploadFileNames;
    private ArrayList<File> mUploadFiles;
    private String mViewId;

    public H5BugmeApplogUploader(Context context, String str) {
        this.mContext = context;
        this.mViewId = str;
    }

    public synchronized void uploadLog() {
        if (isNetworkUseWiFi()) {
            this.mUploadFiles = new ArrayList<>();
            this.mUploadFileNames = new HashSet();
            try {
                this.mContext.getCacheDir().mkdirs();
                File file = new File(this.mContext.getCacheDir(), System.currentTimeMillis() + "bugme.zip");
                if (file.exists() && file.isFile()) {
                    if (file.length() != 0) {
                        H5Log.d(TAG, "fileZipped path" + file.getAbsolutePath());
                        HashMap hashMap = new HashMap();
                        String str = "";
                        H5EnvProvider h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName());
                        if (h5EnvProvider != null) {
                            str = h5EnvProvider.getmDid();
                        }
                        String str2 = "";
                        H5LoginProvider h5LoginProvider = (H5LoginProvider) Nebula.getProviderManager().getProvider(H5LoginProvider.class.getName());
                        if (h5LoginProvider != null) {
                            str2 = h5LoginProvider.getUserId();
                        }
                        hashMap.put("did", str);
                        hashMap.put("viewId", this.mViewId);
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        hashMap.put(StringSet.ts, sb.toString());
                        hashMap.put("subType", "logfile");
                        hashMap.put("uid", str2);
                        hashMap.put("type", CommunityPostActivity.TYPE_FILE);
                        hashMap.put("fileTag", file.getName());
                        hashMap.put("fileType", "multipart");
                        uploadFile(hashMap, file);
                        return;
                    }
                }
                H5Log.e(TAG, "!fileZipped.exists()");
            } catch (Throwable th) {
                H5Log.e(TAG, "getCacheDir().mkdirs() exception ", th);
            }
        }
    }

    private void fillUploadFileList(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            long j = 0;
            for (int length = listFiles.length - 1; length >= 0; length--) {
                File file2 = listFiles[length];
                if (file2 != null) {
                    try {
                        if (file2.exists() && file2.isFile()) {
                            if (file2.length() != 0) {
                                String name = file2.getName();
                                if (!name.endsWith(".pzt.zip") && !name.endsWith(".pzt.2nd")) {
                                    if (!name.endsWith(SUFFIX_POSITIVE)) {
                                        long parseLong = Long.parseLong(name.split("_")[0]);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (parseLong > currentTimeMillis - 7200000 && parseLong < currentTimeMillis && !this.mUploadFileNames.contains(name) && j < 8000000) {
                                            this.mUploadFiles.add(file2);
                                            this.mUploadFileNames.add(name);
                                            j += file2.length();
                                            H5Log.d(TAG, "fillUploadFileList totalLength ".concat(String.valueOf(j)));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        H5Log.e(TAG, "fillUploadFileList: " + file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    private boolean isNetworkUseWiFi() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            H5Log.e(TAG, "isNetworkUseWiFi ", th);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01a4 A[SYNTHETIC, Splitter:B:33:0x01a4] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01ac A[Catch:{ Exception -> 0x01a8 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadFile(java.util.Map<java.lang.String, java.lang.String> r12, java.io.File r13) {
        /*
            r11 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "H5BugmeApplogUploader"
            r2 = 0
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x019a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r4.<init>()     // Catch:{ all -> 0x019a }
            java.util.Set r5 = r12.keySet()     // Catch:{ all -> 0x019a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x019a }
        L_0x001a:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "\"\r\n"
            java.lang.String r8 = "--"
            java.lang.String r9 = "\r\n"
            if (r6 == 0) goto L_0x006e
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x019a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r10.<init>(r8)     // Catch:{ all -> 0x019a }
            r10.append(r3)     // Catch:{ all -> 0x019a }
            r10.append(r9)     // Catch:{ all -> 0x019a }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x019a }
            r4.append(r8)     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            java.lang.String r10 = "Content-Disposition: form-data; name=\""
            r8.<init>(r10)     // Catch:{ all -> 0x019a }
            r8.append(r6)     // Catch:{ all -> 0x019a }
            r8.append(r7)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x019a }
            r4.append(r7)     // Catch:{ all -> 0x019a }
            r4.append(r9)     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r7.<init>()     // Catch:{ all -> 0x019a }
            java.lang.Object r6 = r12.get(r6)     // Catch:{ all -> 0x019a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x019a }
            r7.append(r6)     // Catch:{ all -> 0x019a }
            r7.append(r9)     // Catch:{ all -> 0x019a }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x019a }
            r4.append(r6)     // Catch:{ all -> 0x019a }
            goto L_0x001a
        L_0x006e:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r12.<init>(r8)     // Catch:{ all -> 0x019a }
            r12.append(r3)     // Catch:{ all -> 0x019a }
            r12.append(r9)     // Catch:{ all -> 0x019a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x019a }
            r4.append(r12)     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            java.lang.String r5 = "Content-Disposition: form-data; name=\"fileContent\"; filename=\""
            r12.<init>(r5)     // Catch:{ all -> 0x019a }
            java.lang.String r5 = r13.getName()     // Catch:{ all -> 0x019a }
            r12.append(r5)     // Catch:{ all -> 0x019a }
            r12.append(r7)     // Catch:{ all -> 0x019a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x019a }
            r4.append(r12)     // Catch:{ all -> 0x019a }
            java.lang.String r12 = "Content-Type: application/zip\r\n"
            r4.append(r12)     // Catch:{ all -> 0x019a }
            r4.append(r9)     // Catch:{ all -> 0x019a }
            java.lang.String r12 = r4.toString()     // Catch:{ all -> 0x019a }
            byte[] r12 = r12.getBytes(r0)     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            java.lang.String r5 = "\r\n--"
            r4.<init>(r5)     // Catch:{ all -> 0x019a }
            r4.append(r3)     // Catch:{ all -> 0x019a }
            java.lang.String r5 = "--\r\n"
            r4.append(r5)     // Catch:{ all -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x019a }
            byte[] r4 = r4.getBytes(r0)     // Catch:{ all -> 0x019a }
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x019a }
            java.lang.String r6 = "https://hpmweb.alipay.com/report/upload/android"
            r5.<init>(r6)     // Catch:{ all -> 0x019a }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ all -> 0x019a }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x019a }
            r6 = 1
            r5.setDoInput(r6)     // Catch:{ all -> 0x019a }
            r5.setDoOutput(r6)     // Catch:{ all -> 0x019a }
            r6 = 0
            r5.setUseCaches(r6)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "POST"
            r5.setRequestMethod(r7)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "Connection"
            java.lang.String r8 = "Keep-Alive"
            r5.setRequestProperty(r7, r8)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "accept"
            java.lang.String r8 = "*/*"
            r5.setRequestProperty(r7, r8)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "Charset"
            r5.setRequestProperty(r7, r0)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "Cache-Control"
            java.lang.String r8 = "no-cache"
            r5.setRequestProperty(r7, r8)     // Catch:{ all -> 0x019a }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "multipart/form-data; boundary="
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x019a }
            java.lang.String r3 = r8.concat(r3)     // Catch:{ all -> 0x019a }
            r5.setRequestProperty(r7, r3)     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "Content-Length"
            int r7 = r12.length     // Catch:{ all -> 0x019a }
            long r7 = (long) r7     // Catch:{ all -> 0x019a }
            long r9 = r13.length()     // Catch:{ all -> 0x019a }
            long r7 = r7 + r9
            int r9 = r4.length     // Catch:{ all -> 0x019a }
            long r9 = (long) r9     // Catch:{ all -> 0x019a }
            long r7 = r7 + r9
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x019a }
            r5.setRequestProperty(r3, r7)     // Catch:{ all -> 0x019a }
            java.lang.String r3 = "User-Agent"
            java.lang.String r7 = ""
            r5.setRequestProperty(r3, r7)     // Catch:{ all -> 0x019a }
            r3 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r3)     // Catch:{ all -> 0x019a }
            r3 = 60000(0xea60, float:8.4078E-41)
            r5.setReadTimeout(r3)     // Catch:{ all -> 0x019a }
            r5.connect()     // Catch:{ all -> 0x019a }
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ all -> 0x019a }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0198 }
            r7.<init>(r13)     // Catch:{ all -> 0x0198 }
            r3.write(r12)     // Catch:{ all -> 0x0195 }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r12 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r12)     // Catch:{ all -> 0x0195 }
        L_0x013f:
            int r2 = r7.read(r12)     // Catch:{ all -> 0x0195 }
            r8 = -1
            if (r2 == r8) goto L_0x014a
            r3.write(r12, r6, r2)     // Catch:{ all -> 0x0195 }
            goto L_0x013f
        L_0x014a:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r12)     // Catch:{ all -> 0x0195 }
            r3.write(r4)     // Catch:{ all -> 0x0195 }
            r3.flush()     // Catch:{ all -> 0x0195 }
            int r12 = r5.getResponseCode()     // Catch:{ all -> 0x0195 }
            java.io.InputStream r2 = r5.getInputStream()     // Catch:{ all -> 0x0195 }
            byte[] r2 = r11.getBytesByInputStream(r2)     // Catch:{ all -> 0x0195 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0195 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0195 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "statusCode "
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            r0.append(r12)     // Catch:{ all -> 0x0195 }
            java.lang.String r12 = ", responseBodyStr "
            r0.append(r12)     // Catch:{ all -> 0x0195 }
            r0.append(r4)     // Catch:{ all -> 0x0195 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x0195 }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r12)     // Catch:{ all -> 0x0195 }
            r13.delete()     // Catch:{ all -> 0x0195 }
            java.lang.String r12 = "uploadFile.delete() success"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r12)     // Catch:{ all -> 0x0195 }
            r7.close()     // Catch:{ Exception -> 0x0190 }
            if (r3 == 0) goto L_0x018f
            r3.close()     // Catch:{ Exception -> 0x0190 }
        L_0x018f:
            return
        L_0x0190:
            r12 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r12)
            return
        L_0x0195:
            r12 = move-exception
            r2 = r7
            goto L_0x019c
        L_0x0198:
            r12 = move-exception
            goto L_0x019c
        L_0x019a:
            r12 = move-exception
            r3 = r2
        L_0x019c:
            java.lang.String r13 = "uplodaFile catch exception "
            com.alipay.mobile.nebula.util.H5Log.e(r1, r13, r12)     // Catch:{ all -> 0x01b4 }
            if (r2 == 0) goto L_0x01aa
            r2.close()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x01aa
        L_0x01a8:
            r12 = move-exception
            goto L_0x01b0
        L_0x01aa:
            if (r3 == 0) goto L_0x01b3
            r3.close()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x01b3
        L_0x01b0:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r12)
        L_0x01b3:
            return
        L_0x01b4:
            r12 = move-exception
            if (r2 == 0) goto L_0x01bd
            r2.close()     // Catch:{ Exception -> 0x01bb }
            goto L_0x01bd
        L_0x01bb:
            r13 = move-exception
            goto L_0x01c3
        L_0x01bd:
            if (r3 == 0) goto L_0x01c6
            r3.close()     // Catch:{ Exception -> 0x01bb }
            goto L_0x01c6
        L_0x01c3:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r13)
        L_0x01c6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.bugme.H5BugmeApplogUploader.uploadFile(java.util.Map, java.io.File):void");
    }

    private byte[] getBytesByInputStream(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] buf = H5IOUtils.getBuf(TarConstants.EOF_BLOCK);
        while (true) {
            try {
                int read = bufferedInputStream.read(buf);
                if (read > 0) {
                    bufferedOutputStream.write(buf, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            } finally {
                H5IOUtils.closeQuietly(bufferedOutputStream);
                H5IOUtils.closeQuietly(bufferedInputStream);
                H5IOUtils.returnBuf(buf);
            }
        }
    }
}
