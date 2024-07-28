package com.alipay.mobile.nebula.dev;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.filecache.DiskUtil;
import com.alipay.mobile.nebula.process.ProcessLock;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class H5BugmeLogCollector {
    private static final String TAG = "H5BugmeLogCollector";
    private static final String UPLOAD_TAG = "NebulaDebug:dumpDebugData";
    private static int dumpLimit = 300;
    private static boolean hasReadFile = false;
    private static boolean needDump = false;
    private static String sFilePath = null;
    private static long sLastFlushAppLogTime = 0;
    private static final Queue<String> sQueue = new LinkedBlockingQueue();

    static {
        initConfig();
    }

    private static void initConfig() {
        H5ConfigProvider h5ConfigProvider;
        if (!H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_FORCE_NO_DUMP, false) && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null) {
            String config = h5ConfigProvider.getConfig("h5_bugmeConfig");
            if (TextUtils.isEmpty(config)) {
                H5Log.d(TAG, "not get config");
                return;
            }
            try {
                e parseObject = a.parseObject(config);
                needDump = parseObject.getBoolean("dump").booleanValue();
                dumpLimit = parseObject.getIntValue("dumpLimit");
            } catch (Throwable unused) {
                H5Log.d(TAG, "config init error");
            }
        }
    }

    public static boolean enabled() {
        return needDump;
    }

    public static void enqueueLog(e eVar) {
        if (eVar != null && enabled()) {
            String eVar2 = eVar.toString();
            if (System.currentTimeMillis() - sLastFlushAppLogTime < 5000) {
                H5Log.d(UPLOAD_TAG, eVar2);
            }
            synchronized (sQueue) {
                if (!hasReadFile) {
                    prepare();
                }
                if (sQueue.size() >= dumpLimit) {
                    sQueue.poll();
                }
                sQueue.offer(eVar2);
            }
        }
    }

    public static void flushFile() {
        if (enabled()) {
            H5Log.d(TAG, "flush " + sQueue.size() + " bugme logs");
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public final void run() {
                    StringBuilder sb;
                    long currentTimeMillis = System.currentTimeMillis();
                    List<String> readLog = H5BugmeLogCollector.readLog();
                    if (readLog != null && !readLog.isEmpty()) {
                        BufferedWriter bufferedWriter = null;
                        ProcessLock processLock = new ProcessLock(H5BugmeLogCollector.getLockFilePath());
                        try {
                            processLock.lock();
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(H5BugmeLogCollector.getFilePath(), false));
                            try {
                                for (String write : readLog) {
                                    bufferedWriter2.write(write);
                                    bufferedWriter2.newLine();
                                }
                                H5IOUtils.closeQuietly(bufferedWriter2);
                                processLock.unlock();
                                sb = new StringBuilder("flush log cost: ");
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    H5Log.e(H5BugmeLogCollector.TAG, "write bugme log file error ".concat(String.valueOf(th)));
                                    H5IOUtils.closeQuietly(bufferedWriter);
                                    processLock.unlock();
                                    sb = new StringBuilder("flush log cost: ");
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    H5Log.d(H5BugmeLogCollector.TAG, sb.toString());
                                } catch (Throwable th2) {
                                    H5IOUtils.closeQuietly(bufferedWriter);
                                    processLock.unlock();
                                    H5Log.d(H5BugmeLogCollector.TAG, "flush log cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            H5Log.e(H5BugmeLogCollector.TAG, "write bugme log file error ".concat(String.valueOf(th)));
                            H5IOUtils.closeQuietly(bufferedWriter);
                            processLock.unlock();
                            sb = new StringBuilder("flush log cost: ");
                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                            H5Log.d(H5BugmeLogCollector.TAG, sb.toString());
                        }
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        H5Log.d(H5BugmeLogCollector.TAG, sb.toString());
                    }
                }
            });
        }
    }

    public static void flushAppLog() {
        int i2;
        if (enabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            sLastFlushAppLogTime = currentTimeMillis;
            List<String> readLog = readLog();
            if (readLog == null) {
                i2 = 0;
            } else {
                i2 = readLog.size();
            }
            if (i2 > 0) {
                for (String d2 : readLog) {
                    H5Log.d(UPLOAD_TAG, d2);
                }
            }
            H5Log.d(TAG, "flush applog " + i2 + " cost : " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static List<String> readLog() {
        ArrayList arrayList;
        if (!enabled()) {
            return null;
        }
        synchronized (sQueue) {
            if (!hasReadFile) {
                prepare();
            }
            arrayList = new ArrayList(sQueue);
        }
        return arrayList;
    }

    private static void prepare() {
        StringBuilder sb;
        long currentTimeMillis = System.currentTimeMillis();
        ProcessLock processLock = new ProcessLock(getLockFilePath());
        BufferedReader bufferedReader = null;
        try {
            processLock.lock();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(getFilePath()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sQueue.offer(readLine);
                } catch (Throwable th) {
                    BufferedReader bufferedReader3 = bufferedReader2;
                    th = th;
                    bufferedReader = bufferedReader3;
                    try {
                        H5Log.e(TAG, "read bugme local log file error".concat(String.valueOf(th)));
                        H5IOUtils.closeQuietly(bufferedReader);
                        hasReadFile = true;
                        processLock.unlock();
                        sb = new StringBuilder("read log file cost: ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        H5Log.d(TAG, sb.toString());
                    } catch (Throwable th2) {
                        H5IOUtils.closeQuietly(bufferedReader);
                        hasReadFile = true;
                        processLock.unlock();
                        H5Log.d(TAG, "read log file cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        throw th2;
                    }
                }
            }
            H5IOUtils.closeQuietly(bufferedReader2);
            hasReadFile = true;
            processLock.unlock();
            sb = new StringBuilder("read log file cost: ");
        } catch (Throwable th3) {
            th = th3;
            H5Log.e(TAG, "read bugme local log file error".concat(String.valueOf(th)));
            H5IOUtils.closeQuietly(bufferedReader);
            hasReadFile = true;
            processLock.unlock();
            sb = new StringBuilder("read log file cost: ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            H5Log.d(TAG, sb.toString());
        }
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        H5Log.d(TAG, sb.toString());
    }

    /* access modifiers changed from: private */
    public static String getFilePath() {
        String str = sFilePath;
        if (str != null) {
            return str;
        }
        Context context = H5Utils.getContext();
        String subDir = DiskUtil.getSubDir(context, "/h5/bugme/dump-" + H5Utils.getProcessName() + ".log");
        if (!H5FileUtil.exists(subDir)) {
            H5FileUtil.create(subDir);
        }
        sFilePath = subDir;
        return subDir;
    }

    /* access modifiers changed from: private */
    public static String getLockFilePath() {
        return getFilePath() + ".lock";
    }
}
