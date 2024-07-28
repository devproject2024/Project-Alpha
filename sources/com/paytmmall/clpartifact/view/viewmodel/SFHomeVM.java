package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.gms.common.util.f;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.User;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.repositories.HomeRepository;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.actionmodel.HomeActionModel;
import com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel;
import com.paytmmall.clpartifact.view.actionmodel.IActionModel;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory;
import com.paytmmall.clpartifact.widgets.providers.BaseWidgetProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import kotlin.u;

public final class SFHomeVM extends a {
    static final /* synthetic */ i[] $$delegatedProperties = {y.a((v) new w(y.b(SFHomeVM.class), "responseLiveData", "getResponseLiveData()Landroidx/lifecycle/MediatorLiveData;"))};
    /* access modifiers changed from: private */
    public static int ACTION_DISABLE_GA = 200;
    /* access modifiers changed from: private */
    public static int ACTION_ENABLE_GA = 201;
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final int SHOW_NAV = SHOW_NAV;
    /* access modifiers changed from: private */
    public static final int SHOW_POPUP = 2001;
    private final androidx.lifecycle.y<IActionModel> actionLiveData = new SingleEventLiveData();
    private String adRequestID;
    private final androidx.lifecycle.y<IActionModel> categoryActionLiveData = new SingleEventLiveData();
    private final androidx.lifecycle.y<Boolean> floatinWidgetPresentLiveData = new androidx.lifecycle.y<>();
    private final androidx.lifecycle.y<IWidgetProvider> floatingNavLiveData = new androidx.lifecycle.y<>();
    /* access modifiers changed from: private */
    public boolean isHomeLoading;
    /* access modifiers changed from: private */
    public boolean isHomeRefreshed;
    private boolean isSFCacheResponse = true;
    private final SingleEventLiveData<Integer> noNetworkLiveData = new SingleEventLiveData<>();
    private boolean prewarmResponseFetchInitiated;
    private final SingleEventLiveData<Integer> progressLiveData = new SingleEventLiveData<>();
    /* access modifiers changed from: private */
    public HomeRepository repository;
    private final kotlin.g responseLiveData$delegate;
    private final androidx.lifecycle.y<SanitizedResponseModel> sanitizeModelLiveData = new androidx.lifecycle.y<>();

    /* access modifiers changed from: private */
    public final androidx.lifecycle.w<Resource<List<View>>> getResponseLiveData() {
        return (androidx.lifecycle.w) this.responseLiveData$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SFHomeVM(Application application) {
        super(application);
        k.c(application, "application");
        Context applicationContext = application.getApplicationContext();
        k.a((Object) applicationContext, "application.applicationContext");
        this.repository = new HomeRepository(applicationContext);
        this.responseLiveData$delegate = h.a(new SFHomeVM$responseLiveData$2(this, application));
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getSHOW_POPUP() {
            return SFHomeVM.SHOW_POPUP;
        }

        public final int getACTION_DISABLE_GA() {
            return SFHomeVM.ACTION_DISABLE_GA;
        }

        public final void setACTION_DISABLE_GA(int i2) {
            SFHomeVM.ACTION_DISABLE_GA = i2;
        }

        public final int getACTION_ENABLE_GA() {
            return SFHomeVM.ACTION_ENABLE_GA;
        }

        public final void setACTION_ENABLE_GA(int i2) {
            SFHomeVM.ACTION_ENABLE_GA = i2;
        }

        public final int getSHOW_NAV() {
            return SFHomeVM.SHOW_NAV;
        }
    }

    public final String getAdRequestID() {
        return this.adRequestID;
    }

    public final void setAdRequestID(String str) {
        this.adRequestID = str;
    }

    public final boolean getPrewarmResponseFetchInitiated() {
        return this.prewarmResponseFetchInitiated;
    }

    public final void setPrewarmResponseFetchInitiated(boolean z) {
        this.prewarmResponseFetchInitiated = z;
    }

    public final androidx.lifecycle.y<IActionModel> getActionLiveData() {
        return this.actionLiveData;
    }

    public final androidx.lifecycle.y<IActionModel> getCategoryActionLiveData() {
        return this.categoryActionLiveData;
    }

    public final SingleEventLiveData<Integer> getProgressLiveData() {
        return this.progressLiveData;
    }

    public final SingleEventLiveData<Integer> getNoNetworkLiveData() {
        return this.noNetworkLiveData;
    }

    public final androidx.lifecycle.y<Boolean> getFloatinWidgetPresentLiveData() {
        return this.floatinWidgetPresentLiveData;
    }

    public final androidx.lifecycle.y<IWidgetProvider> getFloatingNavLiveData() {
        return this.floatingNavLiveData;
    }

    public final androidx.lifecycle.y<SanitizedResponseModel> getSanitizeModelLiveData() {
        return this.sanitizeModelLiveData;
    }

    public final boolean isSFCacheResponse() {
        return this.isSFCacheResponse;
    }

    public final void setSFCacheResponse(boolean z) {
        this.isSFCacheResponse = z;
    }

    /* access modifiers changed from: private */
    public final void handleResponse(androidx.lifecycle.y<Resource<List<View>>> yVar, Resource<HomeResponse> resource) {
        Status status = null;
        if ((resource != null ? resource.getStatus() : null) == Status.SUCCESS) {
            HomeResponse data = resource.getData();
            boolean z = data == null || data.getDataSource() != HomeUtils.INSTANCE.getDATA_SOURCE_NETWORK();
            this.isSFCacheResponse = z;
            enableDisableGA(z);
            HomeUtils.d("Launching sanitize on ", true);
            SFInterface sFInterface = SFInterface.INSTANCE;
            HomeResponse data2 = resource.getData();
            k.a((Object) data2, "homeResponse.data");
            SanitizedResponseModel sanitizedResponse = sFInterface.getSanitizedResponse(data2, z, "/", 1001, new SFHomeVM$handleResponse$sanitizedResponse$1(this));
            applyHomeChecks(sanitizedResponse.getRvWidgets());
            addBlueStrip(sanitizedResponse.getRvWidgets());
            updateAdRequestID(sanitizedResponse.getAdRequestId());
            boolean handleSanitizedList = handleSanitizedList(sanitizedResponse.getRvWidgets(), yVar, resource);
            this.sanitizeModelLiveData.setValue(sanitizedResponse);
            try {
                AsyncTask.SERIAL_EXECUTOR.execute(new SFHomeVM$handleResponse$1(this, handleSanitizedList, resource));
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new SFHomeVM$handleResponse$2(this, sanitizedResponse, resource));
            } catch (Error | Exception unused) {
            }
        } else {
            if (resource != null) {
                status = resource.getStatus();
            }
            if (status == Status.FAIL) {
                constructFailureResponse(yVar, resource);
            }
        }
    }

    private final void applyHomeChecks(List<? extends View> list) {
        if (list != null) {
            Iterator it2 = ((ArrayList) list).iterator();
            k.a((Object) it2, "(rvWidgets as ArrayList).iterator()");
            while (it2.hasNext()) {
                View view = (View) it2.next();
                if (ViewHolderFactory.TYPE_BANNER_3XN.equals(view.getType())) {
                    view.setClassName(ViewHolderFactory.CLASS_HOME);
                } else if (HomeUtils.INSTANCE.isProhibittedView(view)) {
                    it2.remove();
                }
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View>");
    }

    private final void updateAdRequestID(String str) {
        if (str != null) {
            this.adRequestID = str;
        }
    }

    private final void addBlueStrip(List<? extends View> list) {
        if ((list instanceof ArrayList) && (!list.isEmpty())) {
            ((ArrayList) list).add(HomeUtils.INSTANCE.getBlueStripItem());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleOtherWidget(java.util.List<? extends com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider> r6) {
        /*
            r5 = this;
            int r0 = r6.size()
            r1 = 0
            if (r0 <= 0) goto L_0x002a
            int r0 = r6.size()
            r2 = 0
        L_0x000c:
            if (r1 >= r0) goto L_0x0029
            java.lang.Object r3 = r6.get(r1)
            com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider r3 = (com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider) r3
            int r3 = r3.getWidgetType()
            r4 = 104(0x68, float:1.46E-43)
            if (r3 != r4) goto L_0x0026
            androidx.lifecycle.y<com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider> r2 = r5.floatingNavLiveData
            java.lang.Object r3 = r6.get(r1)
            r2.postValue(r3)
            r2 = 1
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0029:
            r1 = r2
        L_0x002a:
            androidx.lifecycle.y<java.lang.Boolean> r6 = r5.floatinWidgetPresentLiveData
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6.postValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewmodel.SFHomeVM.handleOtherWidget(java.util.List):void");
    }

    private final HomeActionModel getNavWidgetModel(IWidgetProvider iWidgetProvider) {
        int i2 = SHOW_NAV;
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.TYPE_FLOAITNG_NAV, iWidgetProvider);
        return new HomeActionModel(i2, hashMap);
    }

    /* access modifiers changed from: private */
    public final List<IWidgetProvider> handleNonRVWidgets(LinkedHashMap<Integer, IWidgetProvider> linkedHashMap, boolean z) {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = linkedHashMap.keySet();
        k.a((Object) keySet, "sfWidgets.keys");
        boolean z2 = false;
        for (Integer num : keySet) {
            IWidgetProvider iWidgetProvider = linkedHashMap.get(num);
            if (iWidgetProvider instanceof BaseWidgetProvider) {
                BaseWidgetProvider baseWidgetProvider = (BaseWidgetProvider) iWidgetProvider;
                boolean isApiOnlyWidget = SFWidgetFactory.isApiOnlyWidget(baseWidgetProvider.getView().getType());
                if (z && !z2 && isApiOnlyWidget) {
                    z2 = true;
                    this.actionLiveData.postValue(getShowPopupModel(baseWidgetProvider));
                } else if (!isApiOnlyWidget) {
                    arrayList.add(iWidgetProvider);
                }
            }
        }
        return arrayList;
    }

    private final HomeParentActionModel getUpdateMenuWidgetModel(IWidgetProvider iWidgetProvider) {
        int i2 = SharedHomeVM.UPDATE_NON_RV_WIDGETS;
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.NON_RV_WIDGETS, iWidgetProvider);
        return new HomeParentActionModel(i2, hashMap);
    }

    private final HomeActionModel getShowPopupModel(BaseWidgetProvider baseWidgetProvider) {
        int i2 = SHOW_POPUP;
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.POPUP_WIDGET, baseWidgetProvider);
        return new HomeActionModel(i2, hashMap);
    }

    private final void enableDisableGA(boolean z) {
        this.actionLiveData.setValue(new HomeParentActionModel(z ? ACTION_DISABLE_GA : ACTION_ENABLE_GA, new HashMap()));
    }

    /* access modifiers changed from: private */
    public final void updateCategoryUrl(HomeParentActionModel homeParentActionModel) {
        HomeUtils.d("Updating livedata for action ", true);
        this.categoryActionLiveData.postValue(homeParentActionModel);
    }

    /* access modifiers changed from: private */
    public final HomeParentActionModel getCategoryUpdateModel(HomeResponse homeResponse) {
        List<Page> page;
        List<View> views;
        List<Item> items;
        Utils.assertBackgroundThread();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (!f.a(homeResponse.getPage()) && (page = homeResponse.getPage()) != null) {
            for (Page page2 : page) {
                Long id = page2 != null ? page2.getId() : null;
                if (!(id == null || id.longValue() != 9367 || (views = page2.getViews()) == null)) {
                    for (View view : views) {
                        if (!(view == null || (items = view.getItems()) == null)) {
                            for (Item item : items) {
                                String categoryIdFromUrl = getCategoryIdFromUrl(item.getUrl());
                                if (!TextUtils.isEmpty(categoryIdFromUrl)) {
                                    hashMap.put(categoryIdFromUrl, item.getUrl());
                                    hashMap2.put(categoryIdFromUrl, item.getUrlType());
                                }
                            }
                        }
                    }
                }
            }
        }
        HomeUtils.d("CategoryExtraction done on Thread", true);
        int i2 = SharedHomeVM.UPDATE_CATEGORY_MAPS;
        HashMap hashMap3 = new HashMap();
        hashMap3.put(CLPConstants.CATEGORY_URL_MAP, hashMap);
        hashMap3.put(CLPConstants.CATEGORY_URLTYPE_MAP, hashMap2);
        return new HomeParentActionModel(i2, hashMap3);
    }

    private final String getCategoryIdFromUrl(String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return str;
        }
        int a2 = p.a(charSequence, "?", 0, false, 6);
        if (a2 != -1) {
            if (str != null) {
                String substring = str.substring(0, a2);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int a3 = p.a((CharSequence) substring, "/", p.d(substring)) + 1;
                if (a3 < substring.length()) {
                    if (substring != null) {
                        str2 = substring.substring(a3);
                        k.a((Object) str2, "(this as java.lang.String).substring(startIndex)");
                        return String.valueOf(Integer.parseInt(str2));
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        str2 = "";
        try {
            return String.valueOf(Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final void saveUserContextData(HomeResponse homeResponse) {
        String str;
        UserContext context;
        User user;
        Utils.assertBackgroundThread();
        if (homeResponse == null || (context = homeResponse.getContext()) == null || (user = context.getUser()) == null || (str = user.getExperimentId()) == null) {
            str = e.s;
        }
        e.a(str);
    }

    private final boolean handleSanitizedList(List<? extends View> list, androidx.lifecycle.y<Resource<List<View>>> yVar, Resource<HomeResponse> resource) {
        HomeUtils.d("Got Sanitize response on ", true);
        boolean isValidList = HomeUtils.INSTANCE.isValidList(list);
        List<View> filterForSHV2AndCIcon4x = filterForSHV2AndCIcon4x(list);
        if (!isValidList) {
            constructFailureResponse(yVar, resource);
        } else if (filterForSHV2AndCIcon4x != null) {
            constructSuccessResponse(yVar, resource, filterForSHV2AndCIcon4x);
        }
        HomeUtils.d$default("Sanitization Validity = ".concat(String.valueOf(isValidList)), false, 2, (Object) null);
        return isValidList;
    }

    private final boolean handleForcedSantisedRes(List<? extends View> list, androidx.lifecycle.y<Resource<List<View>>> yVar, Resource<HomeResponse> resource) {
        HomeUtils.d("Got Sanitize response on ", true);
        boolean isValidList = HomeUtils.INSTANCE.isValidList(list);
        if (isValidList) {
            constructSuccessResponse(yVar, resource, list);
        } else {
            constructFailureResponse(yVar, resource);
        }
        HomeUtils.d$default("Sanitization Validity = ".concat(String.valueOf(isValidList)), false, 2, (Object) null);
        return isValidList;
    }

    private final List<View> filterForSHV2AndCIcon4x(List<? extends View> list) {
        Collection collection = list;
        if (!(collection == null || collection.isEmpty()) && list.size() != 0) {
            View view = null;
            boolean z = false;
            int i2 = 0;
            for (View view2 : list) {
                if (view2.getType().equals(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER_V2)) {
                    view = view2;
                    z = true;
                }
                if (!view2.getType().equals(ViewHolderFactory.TYPE_CAROUSEL_ICON_4X)) {
                    view2.setSmartHeaderV2(false);
                } else if (z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
                    view2.setGaData(hashMap);
                    view2.setSmartHeaderV2(true);
                    if (view != null) {
                        view.setmView(view2);
                    }
                    if (view != null) {
                        view.setSmartHeaderV2(true);
                    }
                }
                i2++;
            }
        }
        return list;
    }

    private final void constructSuccessResponse(androidx.lifecycle.y<Resource<List<View>>> yVar, Resource<HomeResponse> resource, List<? extends View> list) {
        yVar.setValue(new Resource.Builder().status(resource.getStatus()).requestType(resource.getRequestType()).body(list).build());
    }

    private final void constructFailureResponse(androidx.lifecycle.y<Resource<List<View>>> yVar, Resource<HomeResponse> resource) {
        yVar.setValue(new Resource.Builder().status(Status.FAIL).requestType(resource.getRequestType()).error(resource.getError()).build());
    }

    public final void refreshHome() {
        if (this.isHomeLoading) {
            HomeUtils.d$default("Api hit is already in progress.", false, 2, (Object) null);
            return;
        }
        this.isHomeLoading = true;
        HomeUtils.d$default("API HIT initiated.", false, 2, (Object) null);
        getResponseLiveData().addSource(this.repository.getHomeResponse(), new SFHomeVM$refreshHome$1(this));
    }

    public final void forceReloadHome() {
        if (this.isHomeLoading) {
            HomeUtils.d$default("Api hit is already in progress.", false, 2, (Object) null);
            return;
        }
        this.isHomeLoading = true;
        HomeUtils.d$default("API HIT initiated.", false, 2, (Object) null);
        getResponseLiveData().addSource(this.repository.forceReloadHome(), new SFHomeVM$forceReloadHome$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleFilteredResponse(androidx.lifecycle.w<Resource<List<View>>> wVar, Resource<HomeResponse> resource) {
        ArrayList arrayList;
        x.e eVar = new x.e();
        Resource value = wVar.getValue();
        HomeResponse homeResponse = null;
        eVar.element = (ArrayList) (value != null ? (List) value.getData() : null);
        x.e eVar2 = new x.e();
        if (resource != null) {
            homeResponse = resource.getData();
        }
        eVar2.element = constructNewList(homeResponse);
        Collection collection = (ArrayList) eVar2.element;
        if (!(collection == null || collection.isEmpty())) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new SFHomeVM$handleFilteredResponse$1(this, eVar2, eVar));
            if (resource != null && (arrayList = (ArrayList) eVar.element) != null) {
                handleForcedSantisedRes(arrayList, wVar, resource);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isHeaderV2InOldRes(ArrayList<View> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                k.a((Object) view, "it.get(i)");
                if (k.a((Object) view.getType(), (Object) ViewHolderFactory.LAYOUT_SMART_ICON_HEADER_V2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isSmartHeaderPresent(ArrayList<View> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                k.a((Object) view, "it.get(i)");
                if (view.isSmartHeaderV2()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final int getIndex(View view, ArrayList<View> arrayList) {
        if (arrayList == null) {
            return -1;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).equals(view)) {
                return i2;
            }
        }
        return -1;
    }

    private final ArrayList<View> constructNewList(HomeResponse homeResponse) {
        List<View> views;
        List<Page> page = homeResponse != null ? homeResponse.getPage() : null;
        ArrayList<View> arrayList = new ArrayList<>();
        if (page != null) {
            for (Page page2 : page) {
                if (((page2 == null || (views = page2.getViews()) == null) ? 0 : views.size()) > 0) {
                    k.a((Object) page2, H5Param.PAGE);
                    arrayList.addAll(page2.getViews());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: getResponseLiveData  reason: collision with other method in class */
    public final LiveData<Resource<List<View>>> m526getResponseLiveData() {
        return getResponseLiveData();
    }

    public final void setProgressVisibility(int i2) {
        if (i2 == 0 || i2 == 8) {
            this.progressLiveData.setValue(Integer.valueOf(i2));
        }
    }

    public final void setNoNetworkVisibility(int i2) {
        if (i2 == 0 || i2 == 8) {
            this.noNetworkLiveData.setValue(Integer.valueOf(i2));
        }
    }

    public final void setScanClick() {
        androidx.lifecycle.y<IActionModel> yVar = this.actionLiveData;
        if (yVar != null) {
            int i2 = SharedHomeVM.SCAN_CLICK;
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.SCAN_CLICKED, Boolean.TRUE);
            yVar.setValue(new HomeParentActionModel(i2, hashMap));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<*>");
    }
}
