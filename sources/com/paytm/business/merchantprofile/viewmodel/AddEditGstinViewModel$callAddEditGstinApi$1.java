package com.paytm.business.merchantprofile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;

@f(b = "AddEditGstinViewModel.kt", c = {59}, d = "invokeSuspend", e = "com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModel$callAddEditGstinApi$1")
public final class AddEditGstinViewModel$callAddEditGstinApi$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ String $businessName;
    public final /* synthetic */ EditGstinAddress $gstinAddress;
    public final /* synthetic */ String $optState;
    public final /* synthetic */ String $otp;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ AddEditGstinViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddEditGstinViewModel$callAddEditGstinApi$1(AddEditGstinViewModel addEditGstinViewModel, EditGstinAddress editGstinAddress, String str, String str2, String str3, d dVar) {
        super(2, dVar);
        this.this$0 = addEditGstinViewModel;
        this.$gstinAddress = editGstinAddress;
        this.$otp = str;
        this.$optState = str2;
        this.$businessName = str3;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        AddEditGstinViewModel$callAddEditGstinApi$1 addEditGstinViewModel$callAddEditGstinApi$1 = new AddEditGstinViewModel$callAddEditGstinApi$1(this.this$0, this.$gstinAddress, this.$otp, this.$optState, this.$businessName, dVar);
        addEditGstinViewModel$callAddEditGstinApi$1.p$ = (CoroutineScope) obj;
        return addEditGstinViewModel$callAddEditGstinApi$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AddEditGstinViewModel$callAddEditGstinApi$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        y yVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            ProfileConfig instance = ProfileConfig.getInstance();
            kotlin.g.b.k.b(instance, "ProfileConfig.getInstance()");
            String c2 = instance.getGTMDataProvider().getString("add_edit_gstin_url", "");
            if (c2 == null) {
                c2 = "";
            }
            HashMap<String, Object> headers = RequestParamUtil.getHeaders(this.this$0.getApplication());
            RequestBody access$getRequestBody = this.this$0.getRequestBody(this.$gstinAddress, this.$otp, this.$optState, this.$businessName);
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new AddEditGstinViewModel$callAddEditGstinApi$1$apiCall$1(c2, headers, access$getRequestBody, (d) null), 3, (Object) null);
            LiveData<b<AddUpdateGstinResponseModel>> mAddUpdateGstinLiveData = this.this$0.getMAddUpdateGstinLiveData();
            if (mAddUpdateGstinLiveData != null) {
                y yVar2 = (y) mAddUpdateGstinLiveData;
                this.L$0 = coroutineScope;
                this.L$1 = c2;
                this.L$2 = headers;
                this.L$3 = access$getRequestBody;
                this.L$4 = async$default;
                this.L$5 = yVar2;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == aVar) {
                    return aVar;
                }
                yVar = yVar2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.business.common_module.utilities.viewModel.LiveDataWrapper<com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel>>");
            }
        } else if (i2 == 1) {
            yVar = (y) this.L$5;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar.setValue(obj);
        return x.f47997a;
    }
}
