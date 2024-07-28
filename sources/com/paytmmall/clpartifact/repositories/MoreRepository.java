package com.paytmmall.clpartifact.repositories;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.a;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class MoreRepository {
    private final Context context;
    private String loadUrl;

    public MoreRepository(Context context2) {
        k.c(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LiveData<Resource<HomeResponse>> getMoreResponse() {
        y yVar = new y();
        x.e eVar = new x.e();
        eVar.element = RequestType.NETWORKCACHE;
        x.e eVar2 = new x.e();
        eVar2.element = null;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (f) null, (CoroutineStart) null, new MoreRepository$getMoreResponse$1(this, eVar2, yVar, eVar, (d) null), 3, (Object) null);
        return yVar;
    }

    static /* synthetic */ void handleSucessResponse$default(MoreRepository moreRepository, y yVar, HomeResponse homeResponse, RequestType requestType, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            requestType = RequestType.FRESH;
        }
        moreRepository.handleSucessResponse(yVar, homeResponse, requestType);
    }

    /* access modifiers changed from: private */
    public final void handleSucessResponse(y<Resource<HomeResponse>> yVar, HomeResponse homeResponse, RequestType requestType) {
        yVar.postValue(new Resource.Builder().requestType(requestType).status(Status.SUCCESS).body(homeResponse).build());
    }

    private final HashMap<String, String> getHeaders() {
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = a.a(this.context);
        String q = a.q(this.context);
        if (!TextUtils.isEmpty(a2) && a.p(this.context)) {
            hashMap.put("user_id", a2);
        }
        if (!TextUtils.isEmpty(q)) {
            hashMap.put(AppConstants.SSO_TOKEN, q);
        }
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public final LiveData<Resource<HomeResponse>> hitApi() {
        y yVar = new y();
        String url = getUrl();
        if (url != null) {
            hitApi(url, getHeaders(), yVar);
        }
        return yVar;
    }

    private final void hitApi(String str, HashMap<String, String> hashMap, y<Resource<HomeResponse>> yVar) {
        com.paytm.network.a l = new b().a(this.context).a(a.c.HOME).a(a.C0715a.POST).a(a.b.SILENT).c(this.context.getClass().getSimpleName()).a(str).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new StringResponseModel()).a((com.paytm.network.listener.b) new MoreRepository$hitApi$networkCallBuilder$1(this, yVar)).l();
        l.b(false);
        l.a();
    }

    static /* synthetic */ void handleErrorResponse$default(MoreRepository moreRepository, y yVar, RequestType requestType, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            requestType = RequestType.FRESH;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        moreRepository.handleErrorResponse(yVar, requestType, th);
    }

    /* access modifiers changed from: private */
    public final void handleErrorResponse(y<Resource<HomeResponse>> yVar, RequestType requestType, Throwable th) {
        yVar.setValue(new Resource.Builder().requestType(requestType).status(Status.FAIL).error(th).build());
    }

    /* access modifiers changed from: private */
    public final String getUrl() {
        String str = this.loadUrl;
        if (str == null) {
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            str = instance.getCommunicationListener().getGTMUrl(CLPConstants.KEY_CATEGORY_V2_URL);
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + c.a(this.context, false);
    }

    public final void setLoadUrl(String str) {
        k.c(str, "url");
        this.loadUrl = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object getNetworkCacheData(d<? super HomeResponse> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MoreRepository$getNetworkCacheData$2(this, (d) null), dVar);
    }
}
