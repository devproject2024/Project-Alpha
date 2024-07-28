package com.paytm.business.merchantprofile.viewmodel;

import com.business.common_module.utilities.a.b;
import com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel;
import com.paytm.business.merchantprofile.repo.AddEditGstinRepo;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

@f(b = "AddEditGstinViewModel.kt", c = {57}, d = "invokeSuspend", e = "com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1")
public final class AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1 extends k implements m<CoroutineScope, d<? super b<AddUpdateGstinResponseModel>>, Object> {
    public final /* synthetic */ HashMap $headers;
    public final /* synthetic */ RequestBody $requestBody;
    public final /* synthetic */ String $url;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1(String str, HashMap hashMap, RequestBody requestBody, d dVar) {
        super(2, dVar);
        this.$url = str;
        this.$headers = hashMap;
        this.$requestBody = requestBody;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1 addEditGstinViewModel$callAddEditGstinApi$1$apiCall$1 = new AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1(this.$url, this.$headers, this.$requestBody, dVar);
        addEditGstinViewModel$callAddEditGstinApi$1$apiCall$1.p$ = (CoroutineScope) obj;
        return addEditGstinViewModel$callAddEditGstinApi$1$apiCall$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            AddEditGstinRepo addEditGstinRepo = AddEditGstinRepo.INSTANCE;
            String str = this.$url;
            HashMap hashMap = this.$headers;
            kotlin.g.b.k.b(hashMap, "headers");
            RequestBody requestBody = this.$requestBody;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = addEditGstinRepo.getAddEditGstinResponse(str, hashMap, requestBody, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
