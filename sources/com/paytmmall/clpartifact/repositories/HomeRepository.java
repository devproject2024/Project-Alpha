package com.paytmmall.clpartifact.repositories;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.k;

public final class HomeRepository {
    private final Context context;

    public HomeRepository(Context context2) {
        k.c(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r3 = r3.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<com.paytmmall.clpartifact.network.Resource<com.paytmmall.clpartifact.view.viewmodel.HomeResponse>> loadInitialPage(boolean r7) {
        /*
            r6 = this;
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            r1 = 1
            java.lang.String r2 = "Trying to get data from Cache on "
            com.paytmmall.clpartifact.utils.HomeUtils.d(r2, r1)
            java.lang.String r2 = "Checking pre-warm data "
            com.paytmmall.clpartifact.utils.HomeUtils.d(r2, r1)
            kotlin.g.b.x$e r2 = new kotlin.g.b.x$e
            r2.<init>()
            com.paytmmall.clpartifact.common.CLPArtifact r3 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            if (r3 == 0) goto L_0x0026
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r3 = r3.getCommunicationListener()
            if (r3 == 0) goto L_0x0026
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r3 = r3.getPreHeatData()
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            r2.element = r3
            kotlin.g.b.x$a r3 = new kotlin.g.b.x$a
            r3.<init>()
            r4 = 0
            r3.element = r4
            T r5 = r2.element
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r5 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r5
            if (r5 != 0) goto L_0x006e
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = "prewarmingInProgress but preheat data is not available, waiting for prewarmed data... "
            com.paytmmall.clpartifact.utils.HomeUtils.d(r7, r1)
            com.paytmmall.clpartifact.common.CLPArtifact r7 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            if (r7 == 0) goto L_0x0054
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r7 = r7.getCommunicationListener()
            if (r7 == 0) goto L_0x0054
            com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$1 r4 = new com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$1
            r4.<init>(r6, r3, r0)
            com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener r4 = (com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener) r4
            r7.setSFPrewarmedResponseAvailableListener(r4, r1)
        L_0x0054:
            java.util.concurrent.Executor r7 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$2 r1 = new com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$2
            r1.<init>(r6, r3, r2, r0)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r7.execute(r1)
            goto L_0x007a
        L_0x0061:
            java.util.concurrent.Executor r7 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$3 r1 = new com.paytmmall.clpartifact.repositories.HomeRepository$loadInitialPage$3
            r1.<init>(r6, r2, r0)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r7.execute(r1)
            goto L_0x007a
        L_0x006e:
            java.lang.String r7 = "pre-warm data found"
            com.paytmmall.clpartifact.utils.HomeUtils.d(r7, r1)
            T r7 = r2.element
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r7 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r7
            r6.handleCacheResponse(r7, r0, r4)
        L_0x007a:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.repositories.HomeRepository.loadInitialPage(boolean):androidx.lifecycle.LiveData");
    }

    static /* synthetic */ void handleCacheResponse$default(HomeRepository homeRepository, HomeResponse homeResponse, y yVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        homeRepository.handleCacheResponse(homeResponse, yVar, z);
    }

    /* access modifiers changed from: private */
    public final void handleCacheResponse(HomeResponse homeResponse, y<Resource<HomeResponse>> yVar, boolean z) {
        if (homeResponse != null) {
            updateSuccessLiveData$default(this, yVar, homeResponse, (RequestType) null, z, 4, (Object) null);
            return;
        }
        updateErrorLiveData$default(this, yVar, new Throwable(this.context.getString(R.string.home_no_cache_eror)), (RequestType) null, z, 4, (Object) null);
    }

    static /* synthetic */ void updateErrorLiveData$default(HomeRepository homeRepository, y yVar, Throwable th, RequestType requestType, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            requestType = RequestType.FRESH;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        homeRepository.updateErrorLiveData(yVar, th, requestType, z);
    }

    private final void updateErrorLiveData(y<Resource<HomeResponse>> yVar, Throwable th, RequestType requestType, boolean z) {
        Resource build = new Resource.Builder().requestType(requestType).status(Status.FAIL).error(th).build();
        if (z) {
            yVar.postValue(build);
        } else {
            yVar.setValue(build);
        }
    }

    static /* synthetic */ void updateSuccessLiveData$default(HomeRepository homeRepository, y yVar, HomeResponse homeResponse, RequestType requestType, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            requestType = RequestType.FRESH;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        homeRepository.updateSuccessLiveData(yVar, homeResponse, requestType, z);
    }

    private final void updateSuccessLiveData(y<Resource<HomeResponse>> yVar, HomeResponse homeResponse, RequestType requestType, boolean z) {
        Resource build = new Resource.Builder().requestType(requestType).status(Status.SUCCESS).body(homeResponse).build();
        if (z) {
            yVar.postValue(build);
        } else {
            yVar.setValue(build);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d2 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00df A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0100 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0109 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0112 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0122 A[Catch:{ Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0141 A[Catch:{ Exception -> 0x0176 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getRequestBody() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = ""
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            android.content.Context r0 = r1.context
            java.lang.String r9 = com.paytm.utility.a.g(r0)
            android.content.Context r0 = r1.context
            java.lang.String r10 = com.paytm.utility.a.h(r0)
            java.lang.String r11 = android.os.Build.MANUFACTURER
            java.lang.String r12 = android.os.Build.MODEL
            java.lang.String r13 = android.os.Build.VERSION.RELEASE
            android.content.Context r0 = r1.context
            java.lang.String r14 = com.paytm.utility.a.l(r0)
            java.lang.String r15 = android.os.Build.DEVICE
            java.lang.String r0 = "http.agent"
            r16 = r7
            java.lang.String r7 = java.lang.System.getProperty(r0)
            android.content.Context r0 = r1.context
            r17 = r8
            java.lang.String r8 = com.paytm.utility.a.s(r0)
            android.content.Context r0 = r1.context
            r18 = r4
            java.lang.String r4 = com.paytm.utility.a.w(r0)
            android.content.Context r0 = r1.context
            android.content.ContentResolver r0 = r0.getContentResolver()
            r19 = r8
            java.lang.String r8 = "android_id"
            java.lang.String r8 = android.provider.Settings.Secure.getString(r0, r8)
            r20 = r8
            java.lang.String r8 = com.paytm.utility.a.d()
            android.content.Context r0 = r1.context     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0084 }
            r21 = r14
            android.content.Context r14 = r1.context     // Catch:{ NameNotFoundException -> 0x0082 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ NameNotFoundException -> 0x0082 }
            r22 = r15
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r14, r15)     // Catch:{ NameNotFoundException -> 0x0080 }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0080 }
            goto L_0x0091
        L_0x0080:
            r0 = move-exception
            goto L_0x0089
        L_0x0082:
            r0 = move-exception
            goto L_0x0087
        L_0x0084:
            r0 = move-exception
            r21 = r14
        L_0x0087:
            r22 = r15
        L_0x0089:
            boolean r14 = com.paytmmall.clpartifact.common.CLPArtifact.isDebug
            if (r14 == 0) goto L_0x0090
            r0.printStackTrace()
        L_0x0090:
            r0 = 0
        L_0x0091:
            android.content.Context r14 = r1.context
            boolean r14 = com.paytm.utility.a.p(r14)
            if (r14 == 0) goto L_0x00b3
            android.content.Context r14 = r1.context
            java.lang.String r14 = com.paytm.utility.a.a((android.content.Context) r14)
            r15 = r14
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r23 = android.text.TextUtils.isEmpty(r15)
            if (r23 != 0) goto L_0x00b3
            boolean r15 = android.text.TextUtils.isDigitsOnly(r15)
            if (r15 == 0) goto L_0x00b3
            long r14 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x00b3 }
            goto L_0x00b5
        L_0x00b3:
            r14 = 0
        L_0x00b5:
            java.lang.String r1 = "user_id"
            r3.put(r1, r14)     // Catch:{ Exception -> 0x0176 }
            if (r4 == 0) goto L_0x00c2
            java.lang.String r1 = "ga_id"
            r3.put(r1, r4)     // Catch:{ Exception -> 0x0176 }
        L_0x00c2:
            java.lang.String r1 = "experiment_id"
            java.lang.String r14 = com.paytm.utility.e.s     // Catch:{ Exception -> 0x0176 }
            r3.put(r1, r14)     // Catch:{ Exception -> 0x0176 }
            if (r9 == 0) goto L_0x00d0
            java.lang.String r1 = "lat"
            r5.put(r1, r9)     // Catch:{ Exception -> 0x0176 }
        L_0x00d0:
            if (r10 == 0) goto L_0x00d7
            java.lang.String r1 = "long"
            r5.put(r1, r10)     // Catch:{ Exception -> 0x0176 }
        L_0x00d7:
            java.lang.String r1 = "ua"
            r6.put(r1, r7)     // Catch:{ Exception -> 0x0176 }
            if (r8 == 0) goto L_0x00e4
            java.lang.String r1 = "ip"
            r6.put(r1, r8)     // Catch:{ Exception -> 0x0176 }
        L_0x00e4:
            java.lang.String r1 = "ip_v6"
            r6.put(r1, r2)     // Catch:{ Exception -> 0x0176 }
            if (r11 == 0) goto L_0x00f0
            java.lang.String r1 = "make"
            r6.put(r1, r11)     // Catch:{ Exception -> 0x0176 }
        L_0x00f0:
            if (r12 == 0) goto L_0x00f7
            java.lang.String r1 = "model_1"
            r6.put(r1, r12)     // Catch:{ Exception -> 0x0176 }
        L_0x00f7:
            if (r13 == 0) goto L_0x00fe
            java.lang.String r1 = "osv"
            r6.put(r1, r13)     // Catch:{ Exception -> 0x0176 }
        L_0x00fe:
            if (r22 == 0) goto L_0x0107
            java.lang.String r1 = "hwv"
            r7 = r22
            r6.put(r1, r7)     // Catch:{ Exception -> 0x0176 }
        L_0x0107:
            if (r21 == 0) goto L_0x0110
            java.lang.String r1 = "connection_type"
            r7 = r21
            r6.put(r1, r7)     // Catch:{ Exception -> 0x0176 }
        L_0x0110:
            if (r19 == 0) goto L_0x0119
            java.lang.String r1 = "carrier"
            r7 = r19
            r6.put(r1, r7)     // Catch:{ Exception -> 0x0176 }
        L_0x0119:
            if (r4 == 0) goto L_0x0120
            java.lang.String r1 = "aaid"
            r6.put(r1, r4)     // Catch:{ Exception -> 0x0176 }
        L_0x0120:
            if (r20 == 0) goto L_0x0129
            java.lang.String r1 = "browser_uuid"
            r4 = r20
            r6.put(r1, r4)     // Catch:{ Exception -> 0x0176 }
        L_0x0129:
            java.lang.String r1 = "device_type"
            java.lang.String r4 = "PHONE"
            r6.put(r1, r4)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r1 = "os"
            java.lang.String r4 = "Android"
            r6.put(r1, r4)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r1 = "user"
            r4 = r18
            r4.put(r1, r3)     // Catch:{ Exception -> 0x0176 }
            if (r0 == 0) goto L_0x0147
            java.lang.String r1 = "version"
            r4.put(r1, r0)     // Catch:{ Exception -> 0x0176 }
        L_0x0147:
            java.lang.String r0 = "geo"
            r4.put(r0, r5)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r0 = "device"
            r4.put(r0, r6)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r0 = "channel"
            java.lang.String r1 = "APP"
            r4.put(r0, r1)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r0 = "current_page"
            java.lang.String r1 = "paytm-home"
            r3 = r17
            r3.put(r0, r1)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r0 = "referer_ui_element"
            r3.put(r0, r2)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r0 = "context"
            r1 = r16
            r1.put(r0, r4)     // Catch:{ Exception -> 0x0174 }
            java.lang.String r0 = "tracking"
            r1.put(r0, r3)     // Catch:{ Exception -> 0x0174 }
            goto L_0x017c
        L_0x0174:
            r0 = move-exception
            goto L_0x0179
        L_0x0176:
            r0 = move-exception
            r1 = r16
        L_0x0179:
            r0.printStackTrace()
        L_0x017c:
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "mjsonData.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.repositories.HomeRepository.getRequestBody():java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r2 = r2.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.String, java.lang.String> getRequestHeaders() {
        /*
            r6 = this;
            java.util.HashMap r0 = com.paytm.utility.a.i()
            android.content.Context r1 = r6.context
            java.lang.String r1 = com.paytm.utility.a.a((android.content.Context) r1)
            com.paytmmall.clpartifact.common.CLPArtifact r2 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            if (r2 == 0) goto L_0x001d
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r2 = r2.getCommunicationListener()
            if (r2 == 0) goto L_0x001d
            android.content.Context r3 = r6.context
            java.lang.String r2 = r2.getSSOToken(r3)
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "headers"
            if (r3 != 0) goto L_0x003d
            android.content.Context r3 = r6.context
            boolean r3 = com.paytm.utility.a.p(r3)
            if (r3 == 0) goto L_0x003d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r3 = r0
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r5 = "user_id"
            r3.put(r5, r1)
        L_0x003d:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0052
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r3 = "sso_token"
            r1.put(r3, r2)
        L_0x0052:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.repositories.HomeRepository.getRequestHeaders():java.util.HashMap");
    }

    public final LiveData<Resource<HomeResponse>> getHomeResponse() {
        y yVar = new y();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new HomeRepository$getHomeResponse$1(this, yVar));
        return yVar;
    }

    static /* synthetic */ void handleApiResponse$default(HomeRepository homeRepository, y yVar, IJRPaytmDataModel iJRPaytmDataModel, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        homeRepository.handleApiResponse(yVar, iJRPaytmDataModel, z);
    }

    /* access modifiers changed from: private */
    public final void handleApiResponse(y<Resource<HomeResponse>> yVar, IJRPaytmDataModel iJRPaytmDataModel, boolean z) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new HomeRepository$handleApiResponse$1(this, iJRPaytmDataModel, z, yVar));
    }

    /* access modifiers changed from: private */
    public final HomeResponse getParsedResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        StringBuilder sb = new StringBuilder("Converting to Home pojo wrt SF");
        Thread currentThread = Thread.currentThread();
        k.a((Object) currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        HomeUtils.d$default(sb.toString(), false, 2, (Object) null);
        if (iJRPaytmDataModel instanceof StringResponseModel) {
            return (HomeResponse) SFGsonUtils.getPojoFromJsonWithoutCoroutine$default(SFGsonUtils.INSTANCE, ((StringResponseModel) iJRPaytmDataModel).getRawResponse(), HomeResponse.class, false, 4, (Object) null);
        }
        return (HomeResponse) SFGsonUtils.INSTANCE.getSFPojoWithoutCoroutine(iJRPaytmDataModel, HomeResponse.class);
    }

    public final LiveData<Resource<HomeResponse>> forceReloadHome() {
        y yVar = new y();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new HomeRepository$forceReloadHome$1(this, yVar));
        return yVar;
    }
}
