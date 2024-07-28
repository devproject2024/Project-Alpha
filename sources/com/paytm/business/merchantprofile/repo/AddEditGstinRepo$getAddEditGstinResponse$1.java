package com.paytm.business.merchantprofile.repo;

import java.util.HashMap;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import okhttp3.RequestBody;

@f(b = "AddEditGstinRepo.kt", c = {13}, d = "getAddEditGstinResponse", e = "com.paytm.business.merchantprofile.repo.AddEditGstinRepo")
public final class AddEditGstinRepo$getAddEditGstinResponse$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AddEditGstinRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddEditGstinRepo$getAddEditGstinResponse$1(AddEditGstinRepo addEditGstinRepo, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = addEditGstinRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAddEditGstinResponse((String) null, (HashMap<String, Object>) null, (RequestBody) null, this);
    }
}
