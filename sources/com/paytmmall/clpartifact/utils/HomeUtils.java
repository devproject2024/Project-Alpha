package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.modal.ForceReloadHomeModel;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class HomeUtils {
    private static final int DATA_SORUCE_BUNDLE = 1001;
    private static final int DATA_SOURCE_LOCAL_FILE = 1002;
    private static final int DATA_SOURCE_NETWORK = 1005;
    private static final int DATA_SOURCE_NETWORK_CACHE = 1003;
    private static final int DATA_SOURCE_UNKNOWN = 1004;
    public static final HomeUtils INSTANCE = new HomeUtils();
    private static final String assetFileName = assetFileName;
    private static final HomeUtils$disAllowedViews$1 disAllowedViews = new HomeUtils$disAllowedViews$1();
    private static final y<ForceReloadHomeModel> forceRefreshLiveData = new y<>();
    private static final String mStoreFrontFileName = mStoreFrontFileName;

    private HomeUtils() {
    }

    public final int getDATA_SORUCE_BUNDLE() {
        return DATA_SORUCE_BUNDLE;
    }

    public final int getDATA_SOURCE_LOCAL_FILE() {
        return DATA_SOURCE_LOCAL_FILE;
    }

    public final int getDATA_SOURCE_NETWORK_CACHE() {
        return DATA_SOURCE_NETWORK_CACHE;
    }

    public final int getDATA_SOURCE_UNKNOWN() {
        return DATA_SOURCE_UNKNOWN;
    }

    public final int getDATA_SOURCE_NETWORK() {
        return DATA_SOURCE_NETWORK;
    }

    public final y<ForceReloadHomeModel> getForceRefreshLiveData() {
        return forceRefreshLiveData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytmmall.clpartifact.view.viewmodel.HomeResponse getCacheData(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "Interacting with various cache techniques on "
            r1 = 1
            d(r0, r1)
            com.paytmmall.clpartifact.common.CLPArtifact r0 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r0 = r0.getCommunicationListener()
            if (r0 == 0) goto L_0x001d
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = r0.getPreHeatData()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            r2 = 2
            r3 = 0
            if (r0 == 0) goto L_0x0028
            java.lang.String r5 = "Cache found from Pre-heat data"
            d$default(r5, r3, r2, r1)
            return r0
        L_0x0028:
            java.lang.String r0 = "Cache Not found from Pre-heat data"
            d$default(r0, r3, r2, r1)
            java.lang.String r0 = getUrl(r5)
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = r4.getNetworkCache(r0, r5)
            if (r0 == 0) goto L_0x0042
            int r5 = DATA_SOURCE_NETWORK_CACHE
            r0.setDataSource(r5)
            java.lang.String r5 = "Cache found from Volley Cache"
            d$default(r5, r3, r2, r1)
            return r0
        L_0x0042:
            java.lang.String r0 = "Volley Cache found no data"
            d$default(r0, r3, r2, r1)
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = r4.readFromFile(r5)
            if (r0 == 0) goto L_0x0058
            int r5 = DATA_SOURCE_LOCAL_FILE
            r0.setDataSource(r5)
            java.lang.String r5 = "Cache found from Local File"
            d$default(r5, r3, r2, r1)
            return r0
        L_0x0058:
            java.lang.String r0 = "No data in Local File"
            d$default(r0, r3, r2, r1)
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r5 = r4.readFromAsset(r5)
            if (r5 == 0) goto L_0x006e
            int r0 = DATA_SORUCE_BUNDLE
            r5.setDataSource(r0)
            java.lang.String r0 = "Cache found from Asset"
            d$default(r0, r3, r2, r1)
            return r5
        L_0x006e:
            java.lang.String r5 = "RED ALERT !! No cache data available "
            d$default(r5, r3, r2, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.getCacheData(android.content.Context):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getUrl(android.content.Context r3) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            com.paytmmall.clpartifact.common.CLPArtifact r0 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            if (r0 == 0) goto L_0x0018
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r0 = r0.getCommunicationListener()
            if (r0 == 0) goto L_0x0018
            java.lang.String r1 = "homeStorefrontUrlV2"
            java.lang.String r0 = r0.getGTMUrl(r1)
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            if (r1 == 0) goto L_0x0028
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 0
            goto L_0x0029
        L_0x0028:
            r1 = 1
        L_0x0029:
            if (r1 == 0) goto L_0x002d
            java.lang.String r0 = "https://storefront.paytm.com/v2/h/paytm-homepage"
        L_0x002d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = com.paytm.utility.c.a((android.content.Context) r3, (boolean) r2)
            r1.append(r0)
            java.lang.String r0 = "&device=android"
            r1.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "&resolution="
            r0.<init>(r2)
            int r3 = com.paytm.utility.a.v(r3)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.getUrl(android.content.Context):java.lang.String");
    }

    public final HomeResponse getNetworkCache(String str, Context context) {
        k.c(context, "context");
        d("Trying to get response from Volley Cache ", true);
        String a2 = f.a(str, context);
        StringBuilder sb = new StringBuilder("response from Volley Cache received, null = ");
        sb.append(a2 == null);
        d(sb.toString(), true);
        HomeResponse homeResponse = (HomeResponse) SFGsonUtils.getPojo$default(SFGsonUtils.INSTANCE, a2, HomeResponse.class, false, 4, (Object) null);
        d("volley cache parsing done ", true);
        return homeResponse;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x004b A[SYNTHETIC, Splitter:B:33:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005c A[SYNTHETIC, Splitter:B:42:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0066 A[SYNTHETIC, Splitter:B:48:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006b A[Catch:{ Exception -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0046=Splitter:B:30:0x0046, B:39:0x0057=Splitter:B:39:0x0057} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.paytmmall.clpartifact.view.viewmodel.HomeResponse readFromFile(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Reading from local file response "
            r1 = 1
            d(r0, r1)
            r0 = 0
            java.lang.String r1 = mStoreFrontFileName     // Catch:{ IOException -> 0x0054, ClassNotFoundException -> 0x0043, all -> 0x003e }
            java.io.FileInputStream r6 = r6.openFileInput(r1)     // Catch:{ IOException -> 0x0054, ClassNotFoundException -> 0x0043, all -> 0x003e }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0038, all -> 0x0033 }
            r2 = r6
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0038, all -> 0x0033 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0038, all -> 0x0033 }
            java.lang.Object r2 = r1.readObject()     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002f }
            if (r2 == 0) goto L_0x0027
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r2 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r2     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002f }
            r1.close()     // Catch:{ Exception -> 0x0025 }
            if (r6 == 0) goto L_0x0025
            r6.close()     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            r0 = r2
            goto L_0x0062
        L_0x0027:
            kotlin.u r2 = new kotlin.u     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002f }
            java.lang.String r3 = "null cannot be cast to non-null type com.paytmmall.clpartifact.view.viewmodel.HomeResponse"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002f }
            throw r2     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002f }
        L_0x002f:
            r2 = move-exception
            goto L_0x0046
        L_0x0031:
            r2 = move-exception
            goto L_0x0057
        L_0x0033:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0064
        L_0x0038:
            r2 = move-exception
            r1 = r0
            goto L_0x0046
        L_0x003b:
            r2 = move-exception
            r1 = r0
            goto L_0x0057
        L_0x003e:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L_0x0064
        L_0x0043:
            r2 = move-exception
            r6 = r0
            r1 = r6
        L_0x0046:
            r2.printStackTrace()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ Exception -> 0x0062 }
        L_0x004e:
            if (r6 == 0) goto L_0x0062
        L_0x0050:
            r6.close()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0062
        L_0x0054:
            r2 = move-exception
            r6 = r0
            r1 = r6
        L_0x0057:
            r2.printStackTrace()     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Exception -> 0x0062 }
        L_0x005f:
            if (r6 == 0) goto L_0x0062
            goto L_0x0050
        L_0x0062:
            return r0
        L_0x0063:
            r0 = move-exception
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ Exception -> 0x006e }
        L_0x0069:
            if (r6 == 0) goto L_0x006e
            r6.close()     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.readFromFile(android.content.Context):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050 A[SYNTHETIC, Splitter:B:29:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057 A[SYNTHETIC, Splitter:B:34:0x0057] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x003b=Splitter:B:17:0x003b, B:26:0x004b=Splitter:B:26:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytmmall.clpartifact.view.viewmodel.HomeResponse readFromAsset(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "Reading from file asset. "
            r1 = 1
            d(r0, r1)
            r0 = 0
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ IOException -> 0x0049, Exception -> 0x0039, all -> 0x0034 }
            java.lang.String r1 = assetFileName     // Catch:{ IOException -> 0x0049, Exception -> 0x0039, all -> 0x0034 }
            java.io.InputStream r6 = r6.open(r1)     // Catch:{ IOException -> 0x0049, Exception -> 0x0039, all -> 0x0034 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            com.paytmmall.clpartifact.utils.SFGsonUtils r2 = com.paytmmall.clpartifact.utils.SFGsonUtils.INSTANCE     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            java.lang.Class<com.paytmmall.clpartifact.view.viewmodel.HomeResponse> r3 = com.paytmmall.clpartifact.view.viewmodel.HomeResponse.class
            java.lang.Object r1 = r2.fromJson(r1, r3)     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r1 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r1     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            if (r6 == 0) goto L_0x002f
            r6.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x002f:
            return r1
        L_0x0030:
            r1 = move-exception
            goto L_0x003b
        L_0x0032:
            r1 = move-exception
            goto L_0x004b
        L_0x0034:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0055
        L_0x0039:
            r1 = move-exception
            r6 = r0
        L_0x003b:
            r1.printStackTrace()     // Catch:{ all -> 0x0054 }
            if (r6 == 0) goto L_0x0053
            r6.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0053
        L_0x0044:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0053
        L_0x0049:
            r1 = move-exception
            r6 = r0
        L_0x004b:
            r1.printStackTrace()     // Catch:{ all -> 0x0054 }
            if (r6 == 0) goto L_0x0053
            r6.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0053:
            return r0
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            if (r6 == 0) goto L_0x005f
            r6.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.readFromAsset(android.content.Context):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }

    public final Object getSanitizedResponse(Resource<HomeResponse> resource, d<? super SanitizedResponseModel> dVar) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new HomeUtils$getSanitizedResponse$2(resource, (d) null), dVar);
    }

    public final View getBlueStripItem() {
        View view = new View();
        view.setType(ViewHolderFactory.TYPE_BLUE_STRIP);
        return view;
    }

    public final boolean isProhibittedView(View view) {
        k.c(view, "view");
        return disAllowedViews.contains((Object) view.getType());
    }

    public static /* synthetic */ void d$default(String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        d(str, z);
    }

    public static final void d(String str, boolean z) {
        String str2;
        k.c(str, "message");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (z) {
            StringBuilder sb2 = new StringBuilder(" Thread = ");
            Thread currentThread = Thread.currentThread();
            k.a((Object) currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            str2 = sb2.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        LogUtils.d(HomeUtils.class.getSimpleName(), sb.toString());
    }

    public static final HomeResponse getPreWarmResponse(Context context) {
        k.c(context, "context");
        HomeResponse networkCache = INSTANCE.getNetworkCache(getUrl(context), context);
        if (networkCache != null) {
            networkCache.setDataSource(DATA_SOURCE_NETWORK_CACHE);
            d$default("Prewarming catered from Volley Cache", false, 2, (Object) null);
            return networkCache;
        }
        d$default("Prewarming catered from Local Asset", false, 2, (Object) null);
        HomeResponse readFromAsset = INSTANCE.readFromAsset(context);
        if (readFromAsset != null) {
            readFromAsset.setDataSource(DATA_SORUCE_BUNDLE);
        }
        return readFromAsset;
    }

    public final void saveInFile(HomeResponse homeResponse) {
        k.c(homeResponse, Payload.RESPONSE);
        Utils.assertBackgroundThread();
        try {
            d("Saving sanitized response in local file from API ", true);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(mStoreFrontFileName));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(homeResponse);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException unused) {
            System.out.println("File not found");
        } catch (IOException unused2) {
            System.out.println("Error initializing stream");
        }
    }

    public final boolean isValidList(List<? extends View> list) {
        k.c(list, "sanitizedList");
        return !list.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0023, code lost:
        r12 = r12.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytmmall.clpartifact.modal.SanitizedResponseModel getSanitizedResponseWithoutContext(com.paytmmall.clpartifact.network.Resource<com.paytmmall.clpartifact.view.viewmodel.HomeResponse> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "response"
            kotlin.g.b.k.c(r12, r0)
            kotlin.o r0 = r11.runSanitisation(r12)
            java.lang.Object r1 = r0.component1()
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r0 = r0.component2()
            r4 = r0
            java.util.LinkedHashMap r4 = (java.util.LinkedHashMap) r4
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r0 = new com.paytmmall.clpartifact.modal.SanitizedResponseModel
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r12 = r12.getData()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r12 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r12
            if (r12 == 0) goto L_0x002e
            com.paytmmall.clpartifact.view.viewmodel.UserContext r12 = r12.getContext()
            if (r12 == 0) goto L_0x002e
            java.lang.String r12 = r12.getMrequestid()
            goto L_0x002f
        L_0x002e:
            r12 = 0
        L_0x002f:
            r5 = r12
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 56
            r10 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.getSanitizedResponseWithoutContext(com.paytmmall.clpartifact.network.Resource):com.paytmmall.clpartifact.modal.SanitizedResponseModel");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        r6 = r4.getViews();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.o<java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View>, java.util.LinkedHashMap<java.lang.Integer, com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider>> runSanitisation(com.paytmmall.clpartifact.network.Resource<com.paytmmall.clpartifact.view.viewmodel.HomeResponse> r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r9.getData()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.lang.String r3 = "data"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.util.List r3 = r0.getPage()
            if (r3 == 0) goto L_0x006b
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0021:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r3.next()
            com.paytmmall.clpartifact.modal.clpCommon.Page r4 = (com.paytmmall.clpartifact.modal.clpCommon.Page) r4
            r5 = 0
            if (r4 == 0) goto L_0x003b
            java.util.List r6 = r4.getViews()
            if (r6 == 0) goto L_0x003b
            int r6 = r6.size()
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r4 == 0) goto L_0x0057
            java.util.List r7 = r4.getViews()
            if (r7 == 0) goto L_0x0057
            java.lang.Object r5 = r7.get(r5)
            com.paytmmall.clpartifact.modal.clpCommon.View r5 = (com.paytmmall.clpartifact.modal.clpCommon.View) r5
            if (r5 == 0) goto L_0x0057
            java.util.List r5 = r5.getItems()
            if (r5 == 0) goto L_0x0057
            int r5 = r5.size()
            goto L_0x0058
        L_0x0057:
            r5 = -1
        L_0x0058:
            if (r6 <= 0) goto L_0x0021
            if (r5 <= 0) goto L_0x0021
            java.lang.String r5 = "page"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.List r4 = r4.getViews()
            java.util.Collection r4 = (java.util.Collection) r4
            r1.addAll(r4)
            goto L_0x0021
        L_0x006b:
            java.util.Iterator r3 = r1.iterator()
            java.lang.String r4 = "filteredList.iterator()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
        L_0x0074:
            boolean r4 = r3.hasNext()
            r5 = 1
            if (r4 == 0) goto L_0x00f2
            java.lang.Object r4 = r3.next()
            com.paytmmall.clpartifact.modal.clpCommon.View r4 = (com.paytmmall.clpartifact.modal.clpCommon.View) r4
            boolean r6 = r8.isProhibittedView(r4)
            if (r6 != 0) goto L_0x00ee
            boolean r6 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.isSFWidget(r4)
            if (r6 == 0) goto L_0x00c4
            java.lang.String r6 = r4.getType()
            boolean r6 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.isApiOnlyWidget(r6)
            if (r6 == 0) goto L_0x009f
            com.paytmmall.clpartifact.network.RequestType r6 = r9.getRequestType()
            com.paytmmall.clpartifact.network.RequestType r7 = com.paytmmall.clpartifact.network.RequestType.REFRESH
            if (r6 != r7) goto L_0x00c0
        L_0x009f:
            com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider r6 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.getWidgetProvider(r4)
            if (r6 == 0) goto L_0x00c0
            boolean r7 = r6.isValid()
            if (r7 != r5) goto L_0x00c0
            r4.setItemData()
            java.lang.String r5 = r0.getGaKey()
            r4.setGaKey(r5)
            int r4 = r6.getWidgetType()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.put(r4, r6)
        L_0x00c0:
            r3.remove()
            goto L_0x0074
        L_0x00c4:
            com.paytmmall.clpartifact.utils.WidgetLayoutType$Companion r5 = com.paytmmall.clpartifact.utils.WidgetLayoutType.Companion
            int r5 = r5.getLayoutTypeIndexfromName((com.paytmmall.clpartifact.modal.clpCommon.View) r4)
            net.one97.paytm.common.entity.shopping.LayoutType r6 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_IGNORE_TYPE
            int r6 = r6.getIndex()
            if (r5 == r6) goto L_0x00ee
            java.lang.String r5 = r4.getType()
            java.lang.String r6 = "banner-3xn"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00e3
            java.lang.String r5 = "home"
            r4.setClassName(r5)
        L_0x00e3:
            r4.setItemData()
            java.lang.String r5 = r0.getGaKey()
            r4.setGaKey(r5)
            goto L_0x0074
        L_0x00ee:
            r3.remove()
            goto L_0x0074
        L_0x00f2:
            java.lang.String r9 = "sanitization complete on "
            d(r9, r5)
            kotlin.o r9 = new kotlin.o
            r9.<init>(r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils.runSanitisation(com.paytmmall.clpartifact.network.Resource):kotlin.o");
    }

    public final void setForceRefreshLiveData(String str) {
        k.c(str, "uniqueOrderID");
        forceRefreshLiveData.setValue(new ForceReloadHomeModel(str));
    }

    public final Bitmap decodeSampledBitmapFromResource(String str, Context context) {
        k.c(str, CommunityPostActivity.TYPE_FILE);
        k.c(context, "context");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int a2 = b.a(36.0f, context);
        options.inSampleSize = calculateInSampleSize(options, a2, a2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public final HomeResponse getParsedResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        StringBuilder sb = new StringBuilder("Converting to Home pojo wrt SF");
        Thread currentThread = Thread.currentThread();
        k.a((Object) currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        d$default(sb.toString(), false, 2, (Object) null);
        if (iJRPaytmDataModel instanceof StringResponseModel) {
            return (HomeResponse) SFGsonUtils.getPojoFromJsonWithoutCoroutine$default(SFGsonUtils.INSTANCE, ((StringResponseModel) iJRPaytmDataModel).getRawResponse(), HomeResponse.class, false, 4, (Object) null);
        }
        return (HomeResponse) SFGsonUtils.INSTANCE.getSFPojoWithoutCoroutine(iJRPaytmDataModel, HomeResponse.class);
    }
}
