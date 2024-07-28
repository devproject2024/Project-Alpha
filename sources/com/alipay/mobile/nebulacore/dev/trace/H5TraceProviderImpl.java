package com.alipay.mobile.nebulacore.dev.trace;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.a.e;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.provider.H5TraceProvider;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.dev.sampler.AbstractSampler;
import com.alipay.mobile.nebulacore.dev.sampler.ThreadSampler;
import com.business.merchant_payments.common.utility.AppConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5TraceProviderImpl implements H5TraceProvider {
    private static final long SAMPLE_INTERVAL = 10;
    private static final String TAG = "H5TraceProviderImpl";
    /* access modifiers changed from: private */
    public AtomicBoolean hasTraceBetweenInterval = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AtomicInteger idleCounter = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<String, Session> pendingBlockingSessions = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Map<String, Session> pendingNonBlockingSession = new ConcurrentHashMap();
    private final Queue<e> pendingReportList = new ConcurrentLinkedQueue();
    private ThreadSampler sampler;
    private final Set<String> sendedViewIdSet = new HashSet();

    private boolean isTraceSwitchEnabled() {
        return H5DevConfig.getBooleanConfig(H5DevConfig.H5_TRACE_DEBUG_SWITCH, false);
    }

    private String formatParam(e eVar) {
        return (eVar == null || eVar.keySet().size() == 0) ? "" : eVar.toJSONString();
    }

    private void traceComes() {
        if (isTraceSwitchEnabled()) {
            checkStartSampler();
            this.hasTraceBetweenInterval.set(true);
            if (this.idleCounter.get() != 0) {
                AtomicInteger atomicInteger = this.idleCounter;
                atomicInteger.set(atomicInteger.get() - 1);
            }
        }
    }

    private void checkStartSampler() {
        if (this.sampler == null) {
            this.idleCounter.set(0);
            this.sampler = new ThreadSampler(10);
            this.sampler.registerCallback(new AbstractSampler.SampleCallback() {
                public boolean onSample(e eVar) {
                    if (!H5TraceProviderImpl.this.hasTraceBetweenInterval.get() && H5TraceProviderImpl.this.idleCounter.incrementAndGet() == 100) {
                        return false;
                    }
                    int intValue = eVar.getInteger(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE).intValue();
                    for (Session onSampleThread : H5TraceProviderImpl.this.pendingBlockingSessions.values()) {
                        onSampleThread.onSampleThread(intValue);
                    }
                    for (Session onSampleThread2 : H5TraceProviderImpl.this.pendingNonBlockingSession.values()) {
                        onSampleThread2.onSampleThread(intValue);
                    }
                    H5TraceProviderImpl.this.hasTraceBetweenInterval.set(false);
                    return true;
                }
            });
        }
        this.sampler.start();
    }

    public void event(String str, final String str2, e eVar) {
        H5Log.d(TAG, "event ".concat(String.valueOf(str)));
        e eVar2 = new e();
        eVar2.put("type", (Object) "performance");
        eVar2.put("subType", (Object) AppConstants.NOTIFICATION_DETAILS.EVENT);
        eVar2.put("thread", (Object) Thread.currentThread().getName());
        eVar2.put("name", (Object) str);
        eVar2.put("viewId", (Object) str2);
        eVar2.put("params", (Object) formatParam(eVar));
        traceComes();
        if (isTraceSwitchEnabled() && !TextUtils.isEmpty(str2) && !this.sendedViewIdSet.contains(str2) && ("pageLoad".equals(str) || "domReady".equals(str))) {
            this.sendedViewIdSet.add(str2);
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
                        public void run() {
                            Bitmap takeScreenShot;
                            H5Service access$400 = H5TraceProviderImpl.this.getH5Service();
                            if (access$400 != null && access$400.getTopH5Page() != null && (takeScreenShot = H5PerformanceUtils.takeScreenShot(access$400.getTopH5Page())) != null) {
                                PoolingByteArrayOutputStream poolingByteArrayOutputStream = null;
                                try {
                                    PoolingByteArrayOutputStream poolingByteArrayOutputStream2 = new PoolingByteArrayOutputStream();
                                    try {
                                        takeScreenShot.compress(Bitmap.CompressFormat.JPEG, 100, poolingByteArrayOutputStream2);
                                        String encodeToString = Base64.encodeToString(poolingByteArrayOutputStream2.toByteArray(), 0);
                                        e eVar = new e();
                                        eVar.put("type", (Object) "screenshot");
                                        eVar.put("viewId", (Object) str2);
                                        eVar.put("subType", (Object) "upload");
                                        eVar.put("img", (Object) encodeToString);
                                        eVar.put(StringSet.ts, (Object) Long.valueOf(System.currentTimeMillis()));
                                        H5Log.d(H5TraceProviderImpl.TAG, "Send snapshot: ".concat(String.valueOf(eVar)));
                                        H5TraceProviderImpl.this.sendLogAsync(eVar);
                                        H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                                    } catch (Exception e2) {
                                        e = e2;
                                        poolingByteArrayOutputStream = poolingByteArrayOutputStream2;
                                        try {
                                            H5Log.e(H5TraceProviderImpl.TAG, (Throwable) e);
                                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                        } catch (Throwable th) {
                                            th = th;
                                            poolingByteArrayOutputStream2 = poolingByteArrayOutputStream;
                                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    H5Log.e(H5TraceProviderImpl.TAG, (Throwable) e);
                                    H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                }
                            }
                        }
                    });
                }
            }, 3000);
        }
        enqueueOrSend(eVar2);
    }

    public void sessionBegin(String str, String str2, e eVar) {
        H5Log.d(TAG, "sessionBegin ".concat(String.valueOf(str)));
        traceComes();
        String formatParam = formatParam(eVar);
        Session session = new Session(str, str2, formatParam);
        session.start();
        if ("true".equals(eVar.getString("async"))) {
            this.pendingNonBlockingSession.put(str + formatParam, session);
            return;
        }
        String name = Thread.currentThread().getName();
        Session session2 = this.pendingBlockingSessions.get(name);
        if (session2 == null) {
            this.pendingBlockingSessions.put(name, session);
        } else {
            session2.insert(session);
        }
    }

    public void sessionEnd(String str, String str2, e eVar) {
        H5Log.d(TAG, "sessionEnd ".concat(String.valueOf(str)));
        traceComes();
        String formatParam = formatParam(eVar);
        if ("true".equals(eVar.getString("async"))) {
            String str3 = str + formatParam;
            Session session = this.pendingNonBlockingSession.get(str3);
            if (session != null) {
                session.end();
                this.pendingNonBlockingSession.remove(str3);
                enqueueOrSend(session.toJSONObject());
                return;
            }
            return;
        }
        String name = Thread.currentThread().getName();
        Session session2 = this.pendingBlockingSessions.get(name);
        if (session2 != null && session2.end()) {
            this.pendingBlockingSessions.remove(name);
            enqueueOrSend(session2.toJSONObject());
        }
    }

    private void enqueueOrSend(e eVar) {
        eVar.put(StringSet.ts, (Object) Long.valueOf(System.currentTimeMillis()));
        String string = eVar.getString("viewId");
        if (TextUtils.isEmpty(string)) {
            H5Log.d(TAG, "not send " + eVar.getString("name") + " because no viewId");
            this.pendingReportList.offer(eVar);
            return;
        }
        if (this.pendingReportList.size() > 0) {
            for (e eVar2 : this.pendingReportList) {
                eVar2.put("viewId", (Object) string);
                sendLogAsync(eVar2);
            }
            this.pendingReportList.clear();
        }
        sendLogAsync(eVar);
    }

    /* access modifiers changed from: private */
    public void sendLogAsync(e eVar) {
        eVar.put("id", (Object) Long.valueOf((long) H5BugmeIdGenerator.nextId()));
        eVar.put("bugmeSwitchOpen", (Object) Boolean.TRUE);
        H5DevDebugProvider h5DevDebugProvider = (H5DevDebugProvider) H5Utils.getProvider(H5DevDebugProvider.class.getName());
        if (h5DevDebugProvider != null && h5DevDebugProvider.getScheduler() != null) {
            h5DevDebugProvider.getScheduler().post(eVar);
        }
    }

    /* access modifiers changed from: private */
    public H5Service getH5Service() {
        b a2 = b.a();
        if (a2 == null || a2.f14954a == null) {
            return null;
        }
        return (H5Service) c.a(H5Service.class.getName());
    }

    class Session {
        List<Session> childs = new ArrayList();
        String endThreadName;
        long endTs;
        int maxThread;
        int minThread = Integer.MAX_VALUE;
        String name;
        String paramStr;
        Stack<Session> pendingChildStack = new Stack<>();
        String startThreadName;
        long startTs;
        String viewId;

        Session(String str, String str2, String str3) {
            this.name = str;
            this.viewId = str2;
            this.paramStr = str3;
        }

        public e toJSONObject() {
            e eVar = new e();
            eVar.put("type", (Object) "performance");
            eVar.put("subType", (Object) "session");
            eVar.put("name", (Object) this.name);
            eVar.put("viewId", (Object) this.viewId);
            eVar.put("params", (Object) this.paramStr);
            eVar.put("startTs", (Object) Long.valueOf(this.startTs));
            eVar.put("endTs", (Object) Long.valueOf(this.endTs));
            List<Session> list = this.childs;
            if (list != null && list.size() > 0) {
                int size = this.childs.size();
                com.alibaba.a.b bVar = new com.alibaba.a.b();
                for (int i2 = 0; i2 < size; i2++) {
                    bVar.add(this.childs.get(i2).toJSONObject());
                }
                eVar.put("childrens", (Object) bVar);
            }
            int i3 = this.minThread;
            if (i3 == Integer.MAX_VALUE) {
                eVar.put("minThread", (Object) 0);
            } else {
                eVar.put("minThread", (Object) Integer.valueOf(i3));
            }
            eVar.put("maxThread", (Object) Integer.valueOf(this.maxThread));
            return eVar;
        }

        public void onSampleThread(int i2) {
            if (i2 < this.minThread) {
                this.minThread = i2;
            }
            if (i2 > this.maxThread) {
                this.maxThread = i2;
            }
        }

        public void start() {
            this.startTs = System.currentTimeMillis();
            this.startThreadName = Thread.currentThread().getName();
        }

        public boolean end() {
            if (isEnd()) {
                return false;
            }
            if (this.pendingChildStack.isEmpty()) {
                this.endTs = System.currentTimeMillis();
                this.endThreadName = Thread.currentThread().getName();
                return true;
            }
            Session peek = this.pendingChildStack.peek();
            if (peek.pendingChildStack.isEmpty()) {
                peek.endTs = System.currentTimeMillis();
                this.pendingChildStack.pop();
                if (this.pendingChildStack.isEmpty()) {
                    this.childs.add(peek);
                } else {
                    this.pendingChildStack.peek().childs.add(peek);
                }
            } else {
                peek.end();
            }
            return false;
        }

        public void insert(Session session) {
            if (isEnd()) {
                return;
            }
            if (this.pendingChildStack.isEmpty()) {
                this.pendingChildStack.push(session);
            } else {
                this.pendingChildStack.peek().insert(session);
            }
        }

        public String getKey() {
            return this.name + this.paramStr;
        }

        public boolean isEnd() {
            return this.endTs != 0;
        }
    }
}
