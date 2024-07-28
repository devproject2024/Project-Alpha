package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.play.core.d.ar;
import com.google.android.play.core.d.b;
import com.google.android.play.core.d.c;
import com.google.android.play.core.d.d;
import com.google.android.play.core.d.e;
import com.google.android.play.core.d.m;
import com.google.android.play.core.splitcompat.r;
import com.paytm.utility.a;
import com.paytm.utility.q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleManager {
    private static final String TAG = "PlayCore-DynamicManager";
    private static DynamicModuleManager sInstance;
    private int DOWNLOAD_CHECK_THRESHHOLD = 5000;
    private WeakReference<Activity> activity;
    private volatile boolean isAnyActiveSession;
    private String mActiveModuleName = null;
    private Context mContext = CJRJarvisApplication.getAppContext();
    private ArrayDeque<String> mDeque = new ArrayDeque<>();
    private Handler mHandler;
    private DynamicModuleLoaderItem mLastActiveModule = null;
    private ConcurrentLinkedQueue<Listener> mListeners = new ConcurrentLinkedQueue<>();
    private b mSplitInstallManager;

    public interface Listener {
        void onCancelled(String str);

        void onDownloaded(String str);

        void onDownloading(String str, int i2);

        void onInstalled(String str);

        void onPending(String str);

        void onRequestFailed(String str, REQUEST_FAILED request_failed, int i2, String str2);

        void onRequestRetry(String str, REQUEST_FAILED request_failed);

        void onRequestSuccess(String str);
    }

    public enum REQUEST_FAILED_ERROR_TYPE {
        INSUFFICIENT_STORAGE,
        INTERNAL_ERROR,
        NETWORK_ERROR,
        MODULE_UNAVAILABLE,
        API_NOT_AVAILABLE,
        ACCESS_DENIED,
        OTHER
    }

    static /* synthetic */ void lambda$checkAndCancelExistingSessions$6(Void voidR) {
    }

    private void log(String str) {
    }

    public static DynamicModuleManager getInstance() {
        if (sInstance == null) {
            synchronized (DynamicModuleManager.class) {
                if (sInstance == null) {
                    sInstance = new DynamicModuleManager();
                }
            }
        }
        return sInstance;
    }

    private DynamicModuleManager() {
        init();
    }

    private void init() {
        this.mSplitInstallManager = new ar(this.mContext, r.a(), new m((byte) 0));
        this.mSplitInstallManager.a((e) new e() {
            public final void onStateUpdate(Object obj) {
                DynamicModuleManager.this.lambda$init$0$DynamicModuleManager((d) obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$0$DynamicModuleManager(d dVar) {
        log("onStateUpdate: " + dVar.toString());
        if (this.mLastActiveModule != null && dVar.a() == this.mLastActiveModule.getSessionId()) {
            switch (dVar.b()) {
                case 1:
                    Iterator<Listener> it2 = this.mListeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().onPending(this.mActiveModuleName);
                    }
                    log("onStateUpdate: PENDING");
                    return;
                case 2:
                    int d2 = (int) ((dVar.d() * 100) / dVar.e());
                    this.mLastActiveModule.setRequestInitiatedButNotDownload(false);
                    this.mLastActiveModule.setDownloadPercent(d2);
                    this.mLastActiveModule.setStatusText(this.mContext.getString(R.string.lbl_downloading));
                    for (String next : dVar.f()) {
                        Iterator<Listener> it3 = this.mListeners.iterator();
                        while (it3.hasNext()) {
                            it3.next().onDownloading(next, d2);
                        }
                    }
                    return;
                case 3:
                    this.mLastActiveModule.setStatusText(this.mContext.getString(R.string.lbl_installing));
                    for (String next2 : dVar.f()) {
                        Iterator<Listener> it4 = this.mListeners.iterator();
                        while (it4.hasNext()) {
                            it4.next().onDownloaded(next2);
                        }
                    }
                    this.mLastActiveModule.setSize(dVar.e());
                    this.mLastActiveModule.setStatusCode(3);
                    DynamicModuleHelper.sendEvents(this.mContext, this.mLastActiveModule, false);
                    return;
                case 5:
                    this.mLastActiveModule.setStatusText(this.mContext.getString(R.string.lbl_installed));
                    try {
                        this.mDeque.removeAll(dVar.f());
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                    for (String next3 : dVar.f()) {
                        Iterator<Listener> it5 = this.mListeners.iterator();
                        while (it5.hasNext()) {
                            it5.next().onInstalled(next3);
                        }
                        DynamicModuleHelper.sendEvents(this.mContext, next3, 5, -5000, (String) null);
                    }
                    resetSessionAndCheckForNext();
                    return;
                case 6:
                    this.mLastActiveModule.setFailed(true);
                    if (dVar.c() == -6) {
                        setFailureState(REQUEST_FAILED.NETWORK_ERROR, dVar.c(), dVar.toString());
                    } else if (dVar.c() == -10) {
                        setFailureState(REQUEST_FAILED.INSUFFICIENT_STORAGE, dVar.c(), dVar.toString());
                    } else if (dVar.c() == -2) {
                        setFailureState(REQUEST_FAILED.MODULE_UNAVAILABLE, dVar.c(), dVar.toString());
                    } else if (dVar.c() == -5) {
                        setFailureState(REQUEST_FAILED.API_NOT_AVAILABLE, dVar.c(), dVar.toString());
                    } else if (dVar.a() == -1) {
                        revokeLimitExceeded(true);
                        setFailureState(REQUEST_FAILED.SERVICE_DIED, dVar.c(), dVar.toString());
                    } else {
                        setFailureState(REQUEST_FAILED.OTHER, dVar.c(), dVar.toString());
                    }
                    for (String next4 : dVar.f()) {
                        Iterator<Listener> it6 = this.mListeners.iterator();
                        while (it6.hasNext()) {
                            it6.next().onInstalled(next4);
                        }
                        DynamicModuleHelper.sendEvents(this.mContext, next4, 6, dVar.c(), dVar.toString());
                    }
                    return;
                case 7:
                    this.mLastActiveModule.setFailed(true);
                    this.mLastActiveModule.setStatusText(this.mContext.getString(R.string.lbl_cancelled));
                    for (String next5 : dVar.f()) {
                        Iterator<Listener> it7 = this.mListeners.iterator();
                        while (it7.hasNext()) {
                            it7.next().onCancelled(next5);
                        }
                    }
                    this.mLastActiveModule.setStatusCode(7);
                    this.mLastActiveModule.setFailureDump(dVar.toString());
                    DynamicModuleHelper.sendEvents(this.mContext, this.mLastActiveModule, false);
                    this.mDeque.remove(this.mLastActiveModule.getName());
                    resetSessionAndCheckForNext();
                    return;
                case 8:
                    WeakReference<Activity> weakReference = this.activity;
                    if (weakReference == null || weakReference.get() == null) {
                        checkAndCancelExistingSessions();
                    } else {
                        try {
                            this.mSplitInstallManager.a(dVar, (Activity) this.activity.get(), 100);
                        } catch (IntentSender.SendIntentException e3) {
                            q.b(e3.getMessage());
                        }
                    }
                    this.mLastActiveModule.setStatusCode(8);
                    this.mLastActiveModule.setFailureDump(dVar.toString());
                    DynamicModuleHelper.sendEvents(this.mContext, this.mLastActiveModule, false);
                    return;
                default:
                    return;
            }
        }
    }

    private void setFailureState(REQUEST_FAILED request_failed, int i2, String str) {
        this.mLastActiveModule.setStatusText(DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, request_failed));
        Iterator<Listener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onRequestFailed(this.mActiveModuleName, request_failed, i2, str);
        }
    }

    private void resetSessionAndCheckForNext() {
        this.isAnyActiveSession = false;
        this.mActiveModuleName = null;
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                DynamicModuleManager.this.lambda$resetSessionAndCheckForNext$1$DynamicModuleManager();
            }
        }, 1000);
    }

    public void startInstall(ArrayList<String> arrayList, Activity activity2) {
        this.activity = new WeakReference<>(activity2);
        if (a.m(this.mContext)) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                addInQueue(it2.next(), false);
            }
            lambda$resetSessionAndCheckForNext$1$DynamicModuleManager();
        }
    }

    public void startInstall(String str, Activity activity2) {
        this.activity = new WeakReference<>(activity2);
        addInQueue(str, true);
        this.isAnyActiveSession = false;
        lambda$resetSessionAndCheckForNext$1$DynamicModuleManager();
    }

    private void addInQueue(String str, boolean z) {
        if (!this.mSplitInstallManager.b().contains(str) && !str.equalsIgnoreCase(this.mActiveModuleName)) {
            if (!this.mDeque.contains(str)) {
                if (z) {
                    this.mDeque.addFirst(str);
                } else {
                    this.mDeque.addLast(str);
                }
            } else if (z) {
                this.mDeque.remove(str);
                this.mDeque.addFirst(str);
            }
        }
    }

    private void installModuleIfPending() {
        log("mDeque size: " + this.mDeque.size());
        log("isAnyActiveSession: " + this.isAnyActiveSession);
        if (!this.mDeque.isEmpty() && !this.isAnyActiveSession) {
            this.isAnyActiveSession = true;
            this.mActiveModuleName = this.mDeque.peek();
            log("Now Active: " + this.mActiveModuleName);
            this.mLastActiveModule = new DynamicModuleLoaderItem(this.mActiveModuleName);
            if (!a.m(this.mContext)) {
                log("isNetworkAvailable: false");
                this.mLastActiveModule.setFailed(true);
                this.mLastActiveModule.setStatusText(DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, REQUEST_FAILED.NETWORK_ERROR));
                Iterator<Listener> it2 = this.mListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.NETWORK_ERROR, -6, "No Internet Connection...!!!");
                }
            } else if (isInstalled(this.mActiveModuleName)) {
                Iterator<Listener> it3 = this.mListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().onInstalled(this.mActiveModuleName);
                }
                log("Module is already installed returning");
                resetSessionAndCheckForNext();
            } else {
                c.a aVar = new c.a((byte) 0);
                ArrayList<String> preRequisiteModuleDependencyList = DynamicModuleHelper.getPreRequisiteModuleDependencyList(this.mActiveModuleName);
                if (preRequisiteModuleDependencyList != null && !preRequisiteModuleDependencyList.isEmpty()) {
                    Iterator<String> it4 = preRequisiteModuleDependencyList.iterator();
                    while (it4.hasNext()) {
                        String next = it4.next();
                        if (!isInstalled(next)) {
                            aVar.a(next);
                        }
                    }
                }
                Iterator<String> it5 = this.mDeque.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    log("from queue: ".concat(String.valueOf(next2)));
                    if (!isInstalled(next2)) {
                        aVar.a(next2);
                        DynamicModuleHelper.sendEvents(this.mContext, next2, -5000, -5000, (String) null);
                        log("Adding Module queue: ".concat(String.valueOf(next2)));
                    } else {
                        this.mDeque.remove(next2);
                        Iterator<Listener> it6 = this.mListeners.iterator();
                        while (it6.hasNext()) {
                            it6.next().onInstalled(next2);
                        }
                    }
                }
                log("queue size: " + this.mDeque.size());
                this.mSplitInstallManager.a(new c(aVar)).a(new com.google.android.play.core.e.c() {
                    public final void onSuccess(Object obj) {
                        DynamicModuleManager.this.lambda$installModuleIfPending$2$DynamicModuleManager((Integer) obj);
                    }
                }).a(new com.google.android.play.core.e.a() {
                    public final void onComplete(com.google.android.play.core.e.e eVar) {
                        DynamicModuleManager.this.lambda$installModuleIfPending$3$DynamicModuleManager(eVar);
                    }
                }).a((com.google.android.play.core.e.b) new com.google.android.play.core.e.b() {
                    public final void onFailure(Exception exc) {
                        DynamicModuleManager.this.lambda$installModuleIfPending$4$DynamicModuleManager(exc);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$installModuleIfPending$2$DynamicModuleManager(Integer num) {
        cancelDownloadCheckHandler();
        log("onSuccess");
        this.mLastActiveModule.setRequestInitiatedButNotDownload(true);
        this.mLastActiveModule.setSessionId(num.intValue());
        this.mLastActiveModule.setStatusText(this.mContext.getString(R.string.msg_request_started_but_not_download));
        Iterator<Listener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onRequestSuccess(this.mActiveModuleName);
        }
    }

    public /* synthetic */ void lambda$installModuleIfPending$3$DynamicModuleManager(com.google.android.play.core.e.e eVar) {
        try {
            log("onComplete" + eVar.c());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            log("onComplete" + e2.getMessage());
            log("exception in oncomplete");
        }
    }

    public /* synthetic */ void lambda$installModuleIfPending$4$DynamicModuleManager(Exception exc) {
        cancelDownloadCheckHandler();
        int errorCode = exc instanceof com.google.android.play.core.d.a ? ((com.google.android.play.core.d.a) exc).getErrorCode() : -5000;
        log("onFailure:: errorCode: ".concat(String.valueOf(errorCode)));
        this.mLastActiveModule.setFailed(true);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        this.mLastActiveModule.setStatusCode(6);
        this.mLastActiveModule.setErrorCode(errorCode);
        this.mLastActiveModule.setFailureDump(stringWriter.toString());
        DynamicModuleHelper.sendEvents(this.mContext, this.mLastActiveModule, true);
        if (errorCode == -10) {
            this.mLastActiveModule.setStatusText(DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, REQUEST_FAILED.INSUFFICIENT_STORAGE));
            Iterator<Listener> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.INSUFFICIENT_STORAGE, errorCode, stringWriter.toString());
            }
        } else if (errorCode == -9) {
        } else {
            if (errorCode == -7) {
                Iterator<Listener> it3 = this.mListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.ACCESS_DENIED, errorCode, stringWriter.toString());
                }
            } else if (errorCode == -6) {
                this.mLastActiveModule.setStatusText(DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, REQUEST_FAILED.NETWORK_ERROR));
                Iterator<Listener> it4 = this.mListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.NETWORK_ERROR, errorCode, stringWriter.toString());
                }
            } else if (errorCode == -5) {
                Iterator<Listener> it5 = this.mListeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.API_NOT_AVAILABLE, errorCode, stringWriter.toString());
                }
            } else if (errorCode == -2) {
                Iterator<Listener> it6 = this.mListeners.iterator();
                while (it6.hasNext()) {
                    it6.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.MODULE_UNAVAILABLE, errorCode, stringWriter.toString());
                }
            } else if (errorCode != -1) {
                this.mLastActiveModule.setStatusText(DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, REQUEST_FAILED.OTHER));
                Iterator<Listener> it7 = this.mListeners.iterator();
                while (it7.hasNext()) {
                    it7.next().onRequestFailed(this.mActiveModuleName, REQUEST_FAILED.OTHER, errorCode, stringWriter.toString());
                }
            } else {
                revokeLimitExceeded(false);
                setFailureState(REQUEST_FAILED.SERVICE_DIED, errorCode, stringWriter.toString());
            }
        }
    }

    private void cancelDownloadCheckHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }

    private void downloadCheckHandler(DynamicModuleLoaderItem dynamicModuleLoaderItem) {
        this.mHandler = new Handler();
        this.mHandler.postDelayed(new Runnable(dynamicModuleLoaderItem) {
            private final /* synthetic */ DynamicModuleLoaderItem f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DynamicModuleManager.this.lambda$downloadCheckHandler$5$DynamicModuleManager(this.f$1);
            }
        }, (long) this.DOWNLOAD_CHECK_THRESHHOLD);
    }

    public /* synthetic */ void lambda$downloadCheckHandler$5$DynamicModuleManager(DynamicModuleLoaderItem dynamicModuleLoaderItem) {
        DynamicModuleLoaderItem dynamicModuleLoaderItem2 = this.mLastActiveModule;
        if (dynamicModuleLoaderItem2 != null && dynamicModuleLoaderItem2 == dynamicModuleLoaderItem) {
            resetSessionAddAndCheckForNext(dynamicModuleLoaderItem2);
        }
    }

    private void resetSessionAddAndCheckForNext(DynamicModuleLoaderItem dynamicModuleLoaderItem) {
        addInQueue(dynamicModuleLoaderItem.getName(), true);
        resetSessionAndCheckForNext();
        Iterator<Listener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onRequestRetry(this.mActiveModuleName, REQUEST_FAILED.OTHER);
        }
    }

    public void deferredInstall(ArrayList<String> arrayList) {
        this.mSplitInstallManager.b(arrayList);
    }

    public void deferredInstall(String str) {
        if (!this.mSplitInstallManager.b().contains(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.mSplitInstallManager.b(arrayList);
        }
    }

    public void deferredUninstall(String str) {
        if (this.mSplitInstallManager.b().contains(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.mSplitInstallManager.a((List<String>) arrayList);
        }
    }

    public Set<String> getInstalledModules() {
        return this.mSplitInstallManager.b();
    }

    public boolean isInstalled(String str) {
        return this.mSplitInstallManager.b().contains(str);
    }

    private void checkAndCancelExistingSessions() {
        log("checkAndCancelExistingSessions");
        this.mSplitInstallManager.a(this.mLastActiveModule.getSessionId()).a($$Lambda$DynamicModuleManager$FYG1eDvJ0MjCo5tjqxFfxJOMdlA.INSTANCE).a((com.google.android.play.core.e.b) new com.google.android.play.core.e.b() {
            public final void onFailure(Exception exc) {
                DynamicModuleManager.this.lambda$checkAndCancelExistingSessions$7$DynamicModuleManager(exc);
            }
        });
    }

    public /* synthetic */ void lambda$checkAndCancelExistingSessions$7$DynamicModuleManager(Exception exc) {
        log("cancelInstall - onFailure: " + exc.getMessage());
        q.b(exc.getMessage());
    }

    private void revokeLimitExceeded(boolean z) {
        try {
            this.mSplitInstallManager.a().a(new com.google.android.play.core.e.a(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(com.google.android.play.core.e.e eVar) {
                    DynamicModuleManager.this.lambda$revokeLimitExceeded$8$DynamicModuleManager(this.f$1, eVar);
                }
            });
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public /* synthetic */ void lambda$revokeLimitExceeded$8$DynamicModuleManager(boolean z, com.google.android.play.core.e.e eVar) {
        if (eVar.b()) {
            for (d dVar : (List) eVar.c()) {
                if (dVar.b() == 2) {
                    this.mSplitInstallManager.a(dVar.a()).a(new com.google.android.play.core.e.c<Void>() {
                        public void onSuccess(Void voidR) {
                        }
                    });
                } else if (z) {
                    this.mSplitInstallManager.a(dVar.a());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: isAnyActiveDownload */
    public void lambda$resetSessionAndCheckForNext$1$DynamicModuleManager() {
        this.mSplitInstallManager.a().a(new com.google.android.play.core.e.a() {
            public final void onComplete(com.google.android.play.core.e.e eVar) {
                DynamicModuleManager.this.lambda$isAnyActiveDownload$9$DynamicModuleManager(eVar);
            }
        });
    }

    public /* synthetic */ void lambda$isAnyActiveDownload$9$DynamicModuleManager(com.google.android.play.core.e.e eVar) {
        if (eVar.b()) {
            for (d dVar : (List) eVar.c()) {
                if (dVar.b() == 2) {
                    try {
                        for (String next : dVar.f()) {
                            Iterator<Listener> it2 = this.mListeners.iterator();
                            while (it2.hasNext()) {
                                it2.next().onDownloading(next, 0);
                            }
                        }
                        return;
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                        return;
                    }
                }
            }
            installModuleIfPending();
            return;
        }
        installModuleIfPending();
    }

    public ArrayList<DynamicModuleLoaderItem> getCurrentQueue() {
        ArrayList<DynamicModuleLoaderItem> arrayList = new ArrayList<>();
        Iterator<String> it2 = this.mDeque.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (!this.mContext.getString(R.string.app_name).equalsIgnoreCase(next)) {
                arrayList.add(new DynamicModuleLoaderItem(next));
            }
        }
        log("returning items :; " + arrayList + "returning items size:; " + arrayList.size());
        return arrayList;
    }

    public void registerListener(Listener listener) {
        if (!this.mListeners.contains(listener)) {
            this.mListeners.add(listener);
        }
    }

    public void unRegisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    public enum REQUEST_FAILED {
        NETWORK_ERROR(-6),
        INSUFFICIENT_STORAGE(-10),
        SERVICE_DIED(-9),
        ACCESS_DENIED(-7),
        MODULE_UNAVAILABLE(-2),
        API_NOT_AVAILABLE(-5),
        OTHER(6);
        
        private int splitInstallErrorCode;

        private REQUEST_FAILED(int i2) {
            this.splitInstallErrorCode = i2;
        }

        public final int getSplitInstallErrorCode() {
            return this.splitInstallErrorCode;
        }
    }

    public void sendFeedBack(Context context, String str, int i2, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"dd.feedback@paytm.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "Error Report for ".concat(String.valueOf(str)));
        intent.putExtra("android.intent.extra.TEXT", "PS: Please don't change the subject line.\n\nError Details:\nModule: " + str + "\nError code: " + i2 + "\nStorage available: " + com.paytm.erroranalytics.b.b.a() + "%\nAppVersion: " + com.paytm.utility.b.Q(context) + "\nOS Version: " + com.paytm.utility.b.d() + "\nBrand Model :" + a.f() + "\nException : " + str2 + StringUtility.NEW_LINE);
        intent.setType("message/rfc822");
        try {
            context.startActivity(Intent.createChooser(intent, "Send email using..."));
        } catch (ActivityNotFoundException e2) {
            q.b(e2.getMessage());
        }
    }

    public void openStorageSettings(Context context) {
        try {
            context.startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r6.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(r1)))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openPaytmInPlaystore(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            java.lang.String r1 = r6.getPackageName()     // Catch:{ Exception -> 0x0034 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x001d }
            java.lang.String r3 = "market://details?id="
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ ActivityNotFoundException -> 0x001d }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ ActivityNotFoundException -> 0x001d }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ ActivityNotFoundException -> 0x001d }
            r2.<init>(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x001d }
            r6.startActivity(r2)     // Catch:{ ActivityNotFoundException -> 0x001d }
            return
        L_0x001d:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "https://play.google.com/store/apps/details?id="
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r3.concat(r1)     // Catch:{ Exception -> 0x0034 }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0034 }
            r2.<init>(r0, r1)     // Catch:{ Exception -> 0x0034 }
            r6.startActivity(r2)     // Catch:{ Exception -> 0x0034 }
            return
        L_0x0034:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.DynamicModuleManager.openPaytmInPlaystore(android.content.Context):void");
    }
}
