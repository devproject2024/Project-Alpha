package com.business.merchant_payments.settlement.repo;

import com.business.merchant_payments.settlement.model.UTRResult;
import java.util.Comparator;
import kotlin.g.b.k;

public final class SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$2<T> implements Comparator<UTRResult> {
    public static final SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$2 INSTANCE = new SettlementRepo$getSettlementSummaryRangeForNonMigratedMerchants$2();

    public final int compare(UTRResult uTRResult, UTRResult uTRResult2) {
        if (uTRResult == null && uTRResult2 == null) {
            return 0;
        }
        k.b(uTRResult, "utr1");
        long creationDate = uTRResult.getCreationDate();
        k.b(uTRResult2, "utr2");
        if (creationDate > uTRResult2.getCreationDate()) {
            return -1;
        }
        if (uTRResult.getCreationDate() < uTRResult2.getCreationDate()) {
            return 1;
        }
        return 0;
    }
}
