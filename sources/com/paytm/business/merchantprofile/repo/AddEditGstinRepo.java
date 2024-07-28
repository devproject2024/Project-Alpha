package com.paytm.business.merchantprofile.repo;

public final class AddEditGstinRepo {
    public static final AddEditGstinRepo INSTANCE = new AddEditGstinRepo();

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAddEditGstinResponse(java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.Object> r6, okhttp3.RequestBody r7, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.paytm.business.merchantprofile.repo.AddEditGstinRepo$getAddEditGstinResponse$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.paytm.business.merchantprofile.repo.AddEditGstinRepo$getAddEditGstinResponse$1 r0 = (com.paytm.business.merchantprofile.repo.AddEditGstinRepo$getAddEditGstinResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.paytm.business.merchantprofile.repo.AddEditGstinRepo$getAddEditGstinResponse$1 r0 = new com.paytm.business.merchantprofile.repo.AddEditGstinRepo$getAddEditGstinResponse$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0050
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r8)
            com.paytm.business.merchantprofile.ProfileConfig r8 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r2 = "ProfileConfig.getInstance()"
            kotlin.g.b.k.b(r8, r2)     // Catch:{ Exception -> 0x0071 }
            com.paytm.business.merchantprofile.common.utility.ProfileKotlinNetworkService r8 = r8.getKotlinNetworkService()     // Catch:{ Exception -> 0x0071 }
            r0.L$0 = r4     // Catch:{ Exception -> 0x0071 }
            r0.L$1 = r5     // Catch:{ Exception -> 0x0071 }
            r0.L$2 = r6     // Catch:{ Exception -> 0x0071 }
            r0.L$3 = r7     // Catch:{ Exception -> 0x0071 }
            r0.label = r3     // Catch:{ Exception -> 0x0071 }
            java.lang.Object r8 = r8.getAddEditGstinLead(r5, r6, r7, r0)     // Catch:{ Exception -> 0x0071 }
            if (r8 != r1) goto L_0x0050
            return r1
        L_0x0050:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x0071 }
            boolean r5 = r8.isSuccessful()     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0067
            java.lang.Object r5 = r8.body()     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0067
            java.lang.Object r5 = r8.body()     // Catch:{ Exception -> 0x0071 }
            com.business.common_module.utilities.a.b r5 = com.business.common_module.utilities.a.b.a(r8, r5)     // Catch:{ Exception -> 0x0071 }
            goto L_0x006b
        L_0x0067:
            com.business.common_module.utilities.a.b r5 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r8)     // Catch:{ Exception -> 0x0071 }
        L_0x006b:
            java.lang.String r6 = "if(response.isSuccessful…taWrapper.error(response)"
            kotlin.g.b.k.b(r5, r6)     // Catch:{ Exception -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r5 = move-exception
            com.business.common_module.utilities.a.b r5 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r5)
            java.lang.String r6 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r5, r6)
        L_0x007b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.repo.AddEditGstinRepo.getAddEditGstinResponse(java.lang.String, java.util.HashMap, okhttp3.RequestBody, kotlin.d.d):java.lang.Object");
    }
}
