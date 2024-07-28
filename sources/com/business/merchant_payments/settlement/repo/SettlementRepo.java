package com.business.merchant_payments.settlement.repo;

import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.settlement.model.UTRV2Request;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class SettlementRepo {
    public static final SettlementRepo INSTANCE = new SettlementRepo();

    private final Map<String, String> addUTRRequestURLParams(String str, String str2, String str3) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        String str4 = instance.getMerchantDataProvider().q() ? "MM/dd/yyyy" : "dd-MM-yyyy HH:mm:ss";
        String formattedDate = DateUtility.getFormattedDate(str2, "dd MMM yy", str4);
        k.b(formattedDate, "DateUtility.getFormatted…Format, outputDateFormat)");
        String formattedDate2 = DateUtility.getFormattedDate(str3, "dd MMM yy", str4);
        k.b(formattedDate2, "DateUtility.getFormatted…Format, outputDateFormat)");
        HashMap hashMap = new HashMap();
        hashMap.put("end", formattedDate2);
        hashMap.put("start", formattedDate);
        hashMap.put("limit", str);
        hashMap.put("status", "SUCCESS");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        if (instance2.getMerchantDataProvider().q()) {
            hashMap.put("fetchType", "creation");
        }
        return hashMap;
    }

    public static /* synthetic */ UTRV2Request getRequestObj$default(SettlementRepo settlementRepo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = "PAYOUT_SETTLED";
        }
        return settlementRepo.getRequestObj(str, str2, str3);
    }

    private final UTRV2Request getRequestObj(String str, String str2, String str3) {
        return new UTRV2Request(str2, (String) null, str, DateUtility.getStartDateOfDifferentFormat(str, "dd MMM yy", "yyyy-MM-dd'T'HH:mm:ssZZZZZ"), DateUtility.getEndDateOfDifferentFormat(str2, "dd MMM yy", "yyyy-MM-dd'T'HH:mm:ssZZZZZ"), str3, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[Catch:{ Exception -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A[Catch:{ Exception -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSettlementSummaryCard(java.lang.String r6, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryCard$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryCard$1 r0 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryCard$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryCard$1 r0 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryCard$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r7)     // Catch:{ Exception -> 0x008b }
            goto L_0x0062
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r7)
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r7, r2)
            android.content.Context r7 = r7.getAppContext()
            java.util.HashMap r7 = com.business.merchant_payments.common.utility.RequestParamUtil.getHeaders(r7)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x008b }
            kotlin.g.b.k.b(r4, r2)     // Catch:{ Exception -> 0x008b }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r4.getKotlinNetworkService()     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = "headers"
            kotlin.g.b.k.b(r7, r4)     // Catch:{ Exception -> 0x008b }
            r0.L$0 = r5     // Catch:{ Exception -> 0x008b }
            r0.L$1 = r6     // Catch:{ Exception -> 0x008b }
            r0.L$2 = r7     // Catch:{ Exception -> 0x008b }
            r0.label = r3     // Catch:{ Exception -> 0x008b }
            java.lang.Object r7 = r2.getTodaySettlementSummary(r6, r7, r0)     // Catch:{ Exception -> 0x008b }
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x008b }
            boolean r6 = r7.isSuccessful()     // Catch:{ Exception -> 0x008b }
            if (r6 == 0) goto L_0x0081
            int r6 = r7.code()     // Catch:{ Exception -> 0x008b }
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L_0x0081
            java.lang.Object r6 = r7.body()     // Catch:{ Exception -> 0x008b }
            if (r6 == 0) goto L_0x0081
            java.lang.Object r6 = r7.body()     // Catch:{ Exception -> 0x008b }
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a(r7, r6)     // Catch:{ Exception -> 0x008b }
            goto L_0x0085
        L_0x0081:
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r7)     // Catch:{ Exception -> 0x008b }
        L_0x0085:
            java.lang.String r7 = "if (response.isSuccessfu…taWrapper.error(response)"
            kotlin.g.b.k.b(r6, r7)     // Catch:{ Exception -> 0x008b }
            goto L_0x0095
        L_0x008b:
            r6 = move-exception
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r6)
            java.lang.String r7 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r6, r7)
        L_0x0095:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getSettlementSummaryCard(java.lang.String, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        r7 = r7.getResultInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f A[Catch:{ Exception -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094 A[Catch:{ Exception -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d A[Catch:{ Exception -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSettlementBillList(java.lang.String r7, okhttp3.RequestBody r8, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.settlement.model.SettlementBillListModel>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillList$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillList$1 r0 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillList$1 r0 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillList$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r9)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x006b
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r9)
            com.business.merchant_payments.PaymentsConfig r9 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r9, r2)
            android.content.Context r9 = r9.getAppContext()
            java.util.HashMap r9 = com.business.merchant_payments.common.utility.RequestParamUtil.getHeaders(r9)
            java.lang.String r4 = "headers"
            kotlin.g.b.k.b(r9, r4)
            java.lang.String r4 = "content-type"
            java.lang.String r5 = "application/json"
            r9.put(r4, r5)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00b0 }
            kotlin.g.b.k.b(r4, r2)     // Catch:{ Exception -> 0x00b0 }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r4.getKotlinNetworkService()     // Catch:{ Exception -> 0x00b0 }
            r0.L$0 = r6     // Catch:{ Exception -> 0x00b0 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x00b0 }
            r0.L$2 = r8     // Catch:{ Exception -> 0x00b0 }
            r0.L$3 = r9     // Catch:{ Exception -> 0x00b0 }
            r0.label = r3     // Catch:{ Exception -> 0x00b0 }
            java.lang.Object r9 = r2.getSettlementBillList(r7, r9, r8, r0)     // Catch:{ Exception -> 0x00b0 }
            if (r9 != r1) goto L_0x006b
            return r1
        L_0x006b:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch:{ Exception -> 0x00b0 }
            boolean r7 = r9.isSuccessful()     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x00a6
            int r7 = r9.code()     // Catch:{ Exception -> 0x00b0 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x00a6
            java.lang.Object r7 = r9.body()     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x00a6
            java.lang.Object r7 = r9.body()     // Catch:{ Exception -> 0x00b0 }
            com.business.merchant_payments.settlement.model.SettlementBillListModel r7 = (com.business.merchant_payments.settlement.model.SettlementBillListModel) r7     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x0094
            com.business.merchant_payments.settlement.model.SettlementResultInfoModel r7 = r7.getResultInfo()     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x0094
            java.lang.String r7 = r7.getResultCode()     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            java.lang.String r8 = "SUCCESS"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r3)     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x00a6
            java.lang.Object r7 = r9.body()     // Catch:{ Exception -> 0x00b0 }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r9, r7)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00aa
        L_0x00a6:
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r9)     // Catch:{ Exception -> 0x00b0 }
        L_0x00aa:
            java.lang.String r8 = "if (response.isSuccessfu…taWrapper.error(response)"
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00ba
        L_0x00b0:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r8 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r8)
        L_0x00ba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getSettlementBillList(java.lang.String, okhttp3.RequestBody, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        r6 = (r6 = r6.getM2b()).getResultInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSettlementBillListItemDetail(java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.Object> r7, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.settlement.model.SettlementBillListDetailModel>> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "PaymentsConfig.getInstance()"
            boolean r1 = r8 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillListItemDetail$1
            if (r1 == 0) goto L_0x0015
            r1 = r8
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillListItemDetail$1 r1 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillListItemDetail$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillListItemDetail$1 r1 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementBillListItemDetail$1
            r1.<init>(r5, r8)
        L_0x001a:
            java.lang.Object r8 = r1.result
            kotlin.d.a.a r2 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0031
            if (r3 != r4) goto L_0x0029
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0062
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.a((java.lang.Object) r8)
            com.business.merchant_payments.PaymentsConfig r8 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00ad }
            kotlin.g.b.k.b(r8, r0)     // Catch:{ Exception -> 0x00ad }
            com.business.merchant_payments.utility.APKotlinNetworkService r8 = r8.getKotlinNetworkService()     // Catch:{ Exception -> 0x00ad }
            com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00ad }
            kotlin.g.b.k.b(r3, r0)     // Catch:{ Exception -> 0x00ad }
            android.content.Context r0 = r3.getAppContext()     // Catch:{ Exception -> 0x00ad }
            java.util.HashMap r0 = com.business.merchant_payments.common.utility.RequestParamUtil.getHeaders(r0)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r3 = "RequestParamUtil.getHead…getInstance().appContext)"
            kotlin.g.b.k.b(r0, r3)     // Catch:{ Exception -> 0x00ad }
            r1.L$0 = r5     // Catch:{ Exception -> 0x00ad }
            r1.L$1 = r6     // Catch:{ Exception -> 0x00ad }
            r1.L$2 = r7     // Catch:{ Exception -> 0x00ad }
            r1.label = r4     // Catch:{ Exception -> 0x00ad }
            java.lang.Object r8 = r8.getSettlementBillListItemDetail(r6, r0, r7, r1)     // Catch:{ Exception -> 0x00ad }
            if (r8 != r2) goto L_0x0062
            return r2
        L_0x0062:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00ad }
            boolean r6 = r8.isSuccessful()     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x00a3
            int r6 = r8.code()     // Catch:{ Exception -> 0x00ad }
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x00a3
            java.lang.Object r6 = r8.body()     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x00a3
            java.lang.Object r6 = r8.body()     // Catch:{ Exception -> 0x00ad }
            com.business.merchant_payments.settlement.model.SettlementBillListDetailModel r6 = (com.business.merchant_payments.settlement.model.SettlementBillListDetailModel) r6     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x0091
            com.business.merchant_payments.settlement.model.M2BModel r6 = r6.getM2b()     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x0091
            com.business.merchant_payments.settlement.model.SettlementResultInfoModel r6 = r6.getResultInfo()     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x0091
            java.lang.String r6 = r6.getResultCode()     // Catch:{ Exception -> 0x00ad }
            goto L_0x0092
        L_0x0091:
            r6 = 0
        L_0x0092:
            java.lang.String r7 = "SUCCESS"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r4)     // Catch:{ Exception -> 0x00ad }
            if (r6 == 0) goto L_0x00a3
            java.lang.Object r6 = r8.body()     // Catch:{ Exception -> 0x00ad }
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a(r8, r6)     // Catch:{ Exception -> 0x00ad }
            goto L_0x00a7
        L_0x00a3:
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r8)     // Catch:{ Exception -> 0x00ad }
        L_0x00a7:
            java.lang.String r7 = "if(response.isSuccessful…r(response)\n            }"
            kotlin.g.b.k.b(r6, r7)     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b7
        L_0x00ad:
            r6 = move-exception
            com.business.common_module.utilities.a.b r6 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r6)
            java.lang.String r7 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r6, r7)
        L_0x00b7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getSettlementBillListItemDetail(java.lang.String, java.util.HashMap, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object getSettlementSummaryRangeForMigratedMerchant(java.lang.String r12, java.lang.String r13, java.util.HashMap<java.lang.String, java.lang.Object> r14, kotlin.d.d<? super com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel> r15) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            boolean r1 = r15 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForMigratedMerchant$1
            if (r1 == 0) goto L_0x0015
            r1 = r15
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForMigratedMerchant$1 r1 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForMigratedMerchant$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForMigratedMerchant$1 r1 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForMigratedMerchant$1
            r1.<init>(r11, r15)
        L_0x001a:
            java.lang.Object r15 = r1.result
            kotlin.d.a.a r2 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0031
            if (r3 != r4) goto L_0x0029
            kotlin.ResultKt.a((java.lang.Object) r15)     // Catch:{ Exception -> 0x0083 }
            goto L_0x007f
        L_0x0029:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0031:
            kotlin.ResultKt.a((java.lang.Object) r15)
            com.business.merchant_payments.PaymentsConfig r15 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r15, r3)     // Catch:{ Exception -> 0x0083 }
            com.business.common_module.b.f r15 = r15.getGTMDataProvider()     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r3.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r5 = "ump_base_url"
            java.lang.String r5 = r15.getString(r5, r0)     // Catch:{ Exception -> 0x0083 }
            r3.append(r5)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r5 = "v2_settlement_utr_summary"
            java.lang.String r0 = r15.getString(r5, r0)     // Catch:{ Exception -> 0x0083 }
            r3.append(r0)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0083 }
            r8 = 0
            r9 = 4
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            com.business.merchant_payments.settlement.model.UTRV2Request r3 = getRequestObj$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0083 }
            r1.L$0 = r11     // Catch:{ Exception -> 0x0083 }
            r1.L$1 = r12     // Catch:{ Exception -> 0x0083 }
            r1.L$2 = r13     // Catch:{ Exception -> 0x0083 }
            r1.L$3 = r14     // Catch:{ Exception -> 0x0083 }
            r1.L$4 = r15     // Catch:{ Exception -> 0x0083 }
            r1.L$5 = r0     // Catch:{ Exception -> 0x0083 }
            r1.L$6 = r3     // Catch:{ Exception -> 0x0083 }
            r1.label = r4     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r15 = r11.getMigratedMerchantSettlementSummary(r0, r14, r3, r1)     // Catch:{ Exception -> 0x0083 }
            if (r15 != r2) goto L_0x007f
            return r2
        L_0x007f:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r15 = (com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel) r15     // Catch:{ Exception -> 0x0083 }
            r12 = r15
            goto L_0x008f
        L_0x0083:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r12 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "--"
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x008f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getSettlementSummaryRangeForMigratedMerchant(java.lang.String, java.lang.String, java.util.HashMap, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        r1 = r1.getTotalNetAmount();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object getMigratedMerchantSettlementSummary(java.lang.String r19, java.util.HashMap<java.lang.String, java.lang.Object> r20, com.business.merchant_payments.settlement.model.UTRV2Request r21, kotlin.d.d<? super com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel> r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            boolean r5 = r4 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getMigratedMerchantSettlementSummary$1
            if (r5 == 0) goto L_0x001d
            r5 = r4
            com.business.merchant_payments.settlement.repo.SettlementRepo$getMigratedMerchantSettlementSummary$1 r5 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getMigratedMerchantSettlementSummary$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.label = r6
            goto L_0x0022
        L_0x001d:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getMigratedMerchantSettlementSummary$1 r5 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getMigratedMerchantSettlementSummary$1
            r5.<init>(r0, r4)
        L_0x0022:
            java.lang.Object r4 = r5.result
            kotlin.d.a.a r6 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r7 = r5.label
            r8 = 1
            if (r7 == 0) goto L_0x0039
            if (r7 != r8) goto L_0x0031
            kotlin.ResultKt.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x005a
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            kotlin.ResultKt.a((java.lang.Object) r4)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r7 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r4, r7)     // Catch:{ Exception -> 0x00d2 }
            com.business.merchant_payments.utility.APKotlinNetworkService r4 = r4.getKotlinNetworkService()     // Catch:{ Exception -> 0x00d2 }
            r5.L$0 = r0     // Catch:{ Exception -> 0x00d2 }
            r5.L$1 = r1     // Catch:{ Exception -> 0x00d2 }
            r5.L$2 = r2     // Catch:{ Exception -> 0x00d2 }
            r5.L$3 = r3     // Catch:{ Exception -> 0x00d2 }
            r5.label = r8     // Catch:{ Exception -> 0x00d2 }
            java.lang.Object r4 = r4.getUTRSummaryV2(r1, r2, r3, r5)     // Catch:{ Exception -> 0x00d2 }
            if (r4 != r6) goto L_0x005a
            return r6
        L_0x005a:
            retrofit2.Response r4 = (retrofit2.Response) r4     // Catch:{ Exception -> 0x00d2 }
            boolean r1 = r4.isSuccessful()     // Catch:{ Exception -> 0x00d2 }
            r2 = 2
            r3 = 0
            r5 = 0
            if (r1 == 0) goto L_0x00aa
            java.lang.Object r1 = r4.body()     // Catch:{ Exception -> 0x00d2 }
            com.business.merchant_payments.settlement.model.UTRV2Response r1 = (com.business.merchant_payments.settlement.model.UTRV2Response) r1     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x0078
            com.business.merchant_payments.settlement.model.UTRV2Response$TotalNetAmount r1 = r1.getTotalNetAmount()     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x0078
            java.lang.Double r1 = r1.getValue()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0079
        L_0x0078:
            r1 = r5
        L_0x0079:
            if (r1 == 0) goto L_0x00aa
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x00d2 }
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r6 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE     // Catch:{ Exception -> 0x00d2 }
            java.lang.Object r4 = r4.body()     // Catch:{ Exception -> 0x00d2 }
            com.business.merchant_payments.settlement.model.UTRV2Response r4 = (com.business.merchant_payments.settlement.model.UTRV2Response) r4     // Catch:{ Exception -> 0x00d2 }
            if (r4 == 0) goto L_0x009c
            com.business.merchant_payments.settlement.model.UTRV2Response$TotalNetAmount r4 = r4.getTotalNetAmount()     // Catch:{ Exception -> 0x00d2 }
            if (r4 == 0) goto L_0x009c
            java.lang.Double r4 = r4.getValue()     // Catch:{ Exception -> 0x00d2 }
            if (r4 == 0) goto L_0x009c
            double r7 = r4.doubleValue()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x009d
        L_0x009c:
            r4 = r5
        L_0x009d:
            java.lang.String r7 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString$default(r6, r4, r3, r2, r5)     // Catch:{ Exception -> 0x00d2 }
            r8 = 0
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00de
        L_0x00aa:
            boolean r1 = r4.isSuccessful()     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x00c3
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x00d2 }
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r4 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r6 = "0"
            java.lang.String r7 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString$default(r4, r6, r3, r2, r5)     // Catch:{ Exception -> 0x00d2 }
            r8 = 0
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00de
        L_0x00c3:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r13 = "--"
            r14 = 0
            r15 = 0
            r16 = 4
            r17 = 0
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00de
        L_0x00d2:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel
            r4 = 0
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "--"
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x00de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getMigratedMerchantSettlementSummary(java.lang.String, java.util.HashMap, com.business.merchant_payments.settlement.model.UTRV2Request, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchSettlementRangeSummary(java.lang.String r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.Object> r9, kotlin.d.d<? super com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$fetchSettlementRangeSummary$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.business.merchant_payments.settlement.repo.SettlementRepo$fetchSettlementRangeSummary$1 r0 = (com.business.merchant_payments.settlement.repo.SettlementRepo$fetchSettlementRangeSummary$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.settlement.repo.SettlementRepo$fetchSettlementRangeSummary$1 r0 = new com.business.merchant_payments.settlement.repo.SettlementRepo$fetchSettlementRangeSummary$1
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ Exception -> 0x0071 }
            goto L_0x006d
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0059
        L_0x0036:
            kotlin.ResultKt.a((java.lang.Object) r10)
            com.business.merchant_payments.common.utility.APSharedPreferences r10 = com.business.merchant_payments.common.utility.APSharedPreferences.getInstance()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r2 = "APSharedPreferences.getInstance()"
            kotlin.g.b.k.b(r10, r2)     // Catch:{ Exception -> 0x0071 }
            boolean r10 = r10.isMerchantMigrated()     // Catch:{ Exception -> 0x0071 }
            if (r10 == 0) goto L_0x005c
            r0.L$0 = r6     // Catch:{ Exception -> 0x0071 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x0071 }
            r0.L$2 = r8     // Catch:{ Exception -> 0x0071 }
            r0.L$3 = r9     // Catch:{ Exception -> 0x0071 }
            r0.label = r4     // Catch:{ Exception -> 0x0071 }
            java.lang.Object r10 = r6.getSettlementSummaryRangeForMigratedMerchant(r7, r8, r9, r0)     // Catch:{ Exception -> 0x0071 }
            if (r10 != r1) goto L_0x0059
            return r1
        L_0x0059:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r10 = (com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel) r10     // Catch:{ Exception -> 0x0071 }
            goto L_0x006f
        L_0x005c:
            r0.L$0 = r6     // Catch:{ Exception -> 0x0071 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x0071 }
            r0.L$2 = r8     // Catch:{ Exception -> 0x0071 }
            r0.L$3 = r9     // Catch:{ Exception -> 0x0071 }
            r0.label = r3     // Catch:{ Exception -> 0x0071 }
            java.lang.Object r10 = r6.getSettlementSummaryRangeForNonMigratedMerchants(r7, r8, r9, r0)     // Catch:{ Exception -> 0x0071 }
            if (r10 != r1) goto L_0x006d
            return r1
        L_0x006d:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r10 = (com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel) r10     // Catch:{ Exception -> 0x0071 }
        L_0x006f:
            r7 = r10
            goto L_0x007d
        L_0x0071:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r7 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "--"
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x007d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.fetchSettlementRangeSummary(java.lang.String, java.lang.String, java.util.HashMap, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        r1 = r1.getUTRResponse();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object getSettlementSummaryRangeForNonMigratedMerchants(java.lang.String r15, java.lang.String r16, java.util.HashMap<java.lang.String, java.lang.Object> r17, kotlin.d.d<? super com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel> r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            java.lang.String r5 = "response.body()!!"
            java.lang.String r6 = "PaymentsConfig.getInstance()"
            boolean r7 = r4 instanceof com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$1
            if (r7 == 0) goto L_0x001f
            r7 = r4
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$1 r7 = (com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$1) r7
            int r8 = r7.label
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = r8 & r9
            if (r10 == 0) goto L_0x001f
            int r8 = r8 - r9
            r7.label = r8
            goto L_0x0024
        L_0x001f:
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$1 r7 = new com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$1
            r7.<init>(r14, r4)
        L_0x0024:
            java.lang.Object r4 = r7.result
            kotlin.d.a.a r8 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r9 = r7.label
            r10 = 1
            if (r9 == 0) goto L_0x003b
            if (r9 != r10) goto L_0x0033
            kotlin.ResultKt.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x015e }
            goto L_0x0096
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            kotlin.ResultKt.a((java.lang.Object) r4)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.b(r4, r6)     // Catch:{ Exception -> 0x015e }
            com.business.common_module.b.i r4 = r4.getMerchantDataProvider()     // Catch:{ Exception -> 0x015e }
            boolean r4 = r4.q()     // Catch:{ Exception -> 0x015e }
            java.lang.String r9 = ""
            if (r4 == 0) goto L_0x005e
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r4 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r4 = r4.getMInstance()     // Catch:{ Exception -> 0x015e }
            java.lang.String r11 = "online_utr_details_api"
            java.lang.String r4 = r4.getString(r11, r9)     // Catch:{ Exception -> 0x015e }
            goto L_0x006b
        L_0x005e:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r4 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r4 = r4.getMInstance()     // Catch:{ Exception -> 0x015e }
            java.lang.String r11 = "utr_details_api"
            java.lang.String r4 = r4.getString(r11, r9)     // Catch:{ Exception -> 0x015e }
        L_0x006b:
            java.lang.String r9 = com.business.merchant_payments.common.utility.AppConstants.LAST_COLLECTED_PAYMENTS_LIMIT     // Catch:{ Exception -> 0x015e }
            java.lang.String r11 = "AppConstants.LAST_COLLECTED_PAYMENTS_LIMIT"
            kotlin.g.b.k.b(r9, r11)     // Catch:{ Exception -> 0x015e }
            java.util.Map r9 = r14.addUTRRequestURLParams(r9, r15, r2)     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.PaymentsConfig r11 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.b(r11, r6)     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.utility.APKotlinNetworkService r6 = r11.getKotlinNetworkService()     // Catch:{ Exception -> 0x015e }
            r7.L$0 = r0     // Catch:{ Exception -> 0x015e }
            r7.L$1 = r1     // Catch:{ Exception -> 0x015e }
            r7.L$2 = r2     // Catch:{ Exception -> 0x015e }
            r7.L$3 = r3     // Catch:{ Exception -> 0x015e }
            r7.L$4 = r4     // Catch:{ Exception -> 0x015e }
            r7.L$5 = r9     // Catch:{ Exception -> 0x015e }
            r7.label = r10     // Catch:{ Exception -> 0x015e }
            java.lang.Object r4 = r6.getUTRSummary(r4, r3, r9, r7)     // Catch:{ Exception -> 0x015e }
            if (r4 != r8) goto L_0x0096
            return r8
        L_0x0096:
            retrofit2.Response r4 = (retrofit2.Response) r4     // Catch:{ Exception -> 0x015e }
            boolean r1 = r4.isSuccessful()     // Catch:{ Exception -> 0x015e }
            if (r1 == 0) goto L_0x0151
            java.lang.Object r1 = r4.body()     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UtrSummaryModel r1 = (com.business.merchant_payments.settlement.model.UtrSummaryModel) r1     // Catch:{ Exception -> 0x015e }
            r2 = 0
            if (r1 == 0) goto L_0x00b2
            com.business.merchant_payments.settlement.model.UTRResponse r1 = r1.getUTRResponse()     // Catch:{ Exception -> 0x015e }
            if (r1 == 0) goto L_0x00b2
            java.util.List r1 = r1.getUTRResult()     // Catch:{ Exception -> 0x015e }
            goto L_0x00b3
        L_0x00b2:
            r1 = r2
        L_0x00b3:
            if (r1 == 0) goto L_0x0151
            java.lang.Object r1 = r4.body()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.b(r1, r5)     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UtrSummaryModel r1 = (com.business.merchant_payments.settlement.model.UtrSummaryModel) r1     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UTRResponse r1 = r1.getUTRResponse()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x015e }
            java.util.List r1 = r1.getUTRResult()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x015e }
            int r1 = r1.size()     // Catch:{ Exception -> 0x015e }
            r3 = 2
            r6 = 0
            if (r1 <= 0) goto L_0x013e
            java.lang.Object r1 = r4.body()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.b(r1, r5)     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UtrSummaryModel r1 = (com.business.merchant_payments.settlement.model.UtrSummaryModel) r1     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UTRResponse r1 = r1.getUTRResponse()     // Catch:{ Exception -> 0x015e }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x015e }
            java.util.List r1 = r1.getUTRResult()     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "list"
            kotlin.g.b.k.b(r1, r4)     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$2 r4 = com.business.merchant_payments.settlement.repo.SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$2.INSTANCE     // Catch:{ Exception -> 0x015e }
            kotlin.a.k.a(r1, r4)     // Catch:{ Exception -> 0x015e }
            r4 = 0
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x015e }
        L_0x00fe:
            boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x015e }
            if (r7 == 0) goto L_0x0126
            java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.model.UTRResult r7 = (com.business.merchant_payments.settlement.model.UTRResult) r7     // Catch:{ Exception -> 0x015e }
            java.lang.String r8 = "it"
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x015e }
            java.lang.String r8 = r7.getUtr()     // Catch:{ Exception -> 0x015e }
            if (r8 == 0) goto L_0x011d
            boolean r8 = kotlin.m.p.a(r8)     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x011d
            r8 = 0
            goto L_0x011e
        L_0x011d:
            r8 = 1
        L_0x011e:
            if (r8 != 0) goto L_0x00fe
            double r7 = r7.getPayAmount()     // Catch:{ Exception -> 0x015e }
            double r4 = r4 + r7
            goto L_0x00fe
        L_0x0126:
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 / r7
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r7 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x015e }
            java.lang.String r8 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString$default(r7, r4, r6, r3, r2)     // Catch:{ Exception -> 0x015e }
            r9 = 0
            r10 = 0
            r11 = 4
            r12 = 0
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x015e }
            return r1
        L_0x013e:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x015e }
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r4 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.INSTANCE     // Catch:{ Exception -> 0x015e }
            java.lang.String r5 = "0"
            java.lang.String r3 = com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString$default(r4, r5, r6, r3, r2)     // Catch:{ Exception -> 0x015e }
            r4 = 0
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x015e }
            return r1
        L_0x0151:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel     // Catch:{ Exception -> 0x015e }
            java.lang.String r9 = "--"
            r10 = 0
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x015e }
            return r1
        L_0x015e:
            com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel r1 = new com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel
            r4 = 0
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "--"
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.repo.SettlementRepo.getSettlementSummaryRangeForNonMigratedMerchants(java.lang.String, java.lang.String, java.util.HashMap, kotlin.d.d):java.lang.Object");
    }
}
