package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import com.paytm.network.b.b;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.repositories.ShowMoreRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.u;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class SFBrowseCategoryVM extends a {
    static final /* synthetic */ i[] $$delegatedProperties = {y.a((v) new w(y.b(SFBrowseCategoryVM.class), "responseLiveData", "getResponseLiveData()Landroidx/lifecycle/LiveData;"))};
    /* access modifiers changed from: private */
    public Context context;
    private boolean isFromCache;
    /* access modifiers changed from: private */
    public ShowMoreRepository repository;
    private final g responseLiveData$delegate = h.a(new SFBrowseCategoryVM$responseLiveData$2(this));

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RequestType.NETWORKCACHE.ordinal()] = 1;
            $EnumSwitchMapping$0[RequestType.REFRESH.ordinal()] = 2;
        }
    }

    public final LiveData<Resource<List<View>>> getResponseLiveData() {
        return (LiveData) this.responseLiveData$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SFBrowseCategoryVM(Application application) {
        super(application);
        k.c(application, "application");
        this.context = application.getApplicationContext();
        Context context2 = this.context;
        k.a((Object) context2, "context");
        this.repository = new ShowMoreRepository(context2);
    }

    public final boolean isFromCache() {
        return this.isFromCache;
    }

    public final void setFromCache(boolean z) {
        this.isFromCache = z;
    }

    /* access modifiers changed from: private */
    public final void handleResponse(androidx.lifecycle.w<Resource<List<View>>> wVar, Resource<HomeResponse> resource) {
        if (resource.getStatus() == Status.SUCCESS) {
            RequestType requestType = resource.getRequestType();
            k.a((Object) requestType, "response.requestType");
            handleSuccesResponse(wVar, resource, requestType);
        } else if (resource.getStatus() == Status.FAIL && resource.getRequestType() == RequestType.NETWORKCACHE) {
            handleErrorResponse(wVar, resource);
        }
        if (resource.getRequestType() != RequestType.NETWORKCACHE) {
            return;
        }
        if (b.a(getApplication())) {
            LiveData<Resource<List<View>>> responseLiveData = getResponseLiveData();
            if (responseLiveData != null) {
                ((androidx.lifecycle.w) responseLiveData).addSource(this.repository.hitApi(), new SFBrowseCategoryVM$handleResponse$1(this));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.lifecycle.MediatorLiveData<com.paytmmall.clpartifact.network.Resource<kotlin.collections.List<com.paytmmall.clpartifact.modal.clpCommon.View>>>");
        } else if (resource.getStatus() == Status.FAIL) {
            wVar.setValue(new Resource.Builder().requestType(RequestType.REFRESH).status(Status.FAIL).build());
        }
    }

    private final void handleSuccesResponse(androidx.lifecycle.w<Resource<List<View>>> wVar, Resource<HomeResponse> resource, RequestType requestType) {
        x.e eVar = new x.e();
        eVar.element = (List) new ArrayList();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (f) null, (CoroutineStart) null, new SFBrowseCategoryVM$handleSuccesResponse$1(this, resource.getData(), eVar, resource, wVar, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleErrorResponse(androidx.lifecycle.w<Resource<List<View>>> wVar, Resource<HomeResponse> resource) {
        wVar.setValue(new Resource.Builder().status(Status.FAIL).requestType(resource.getRequestType()).error(resource.getError()).build());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object sanitizeResponse(HomeResponse homeResponse, Context context2, d<? super List<? extends View>> dVar) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new SFBrowseCategoryVM$sanitizeResponse$2(homeResponse, (d) null), dVar);
    }

    public final void hitAPI() {
        if (b.a(getApplication())) {
            LiveData<Resource<List<View>>> responseLiveData = getResponseLiveData();
            if (responseLiveData != null) {
                ((androidx.lifecycle.w) responseLiveData).addSource(this.repository.hitApi(), new SFBrowseCategoryVM$hitAPI$1(this));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.lifecycle.MediatorLiveData<com.paytmmall.clpartifact.network.Resource<kotlin.collections.List<com.paytmmall.clpartifact.modal.clpCommon.View>>>");
        }
    }

    public final void setLoadUrl(String str) {
        k.c(str, "url");
        if (!TextUtils.isEmpty(str)) {
            this.repository.setLoadUrl(str);
        }
    }
}
