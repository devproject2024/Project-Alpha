package com.travel.flight.pojo.flightticket;

import java.util.List;
import net.one97.paytm.common.entity.cst.CJRCSTRaiseIssueList;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse;

public class CJRSummaryContactUsItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponse metaDataresponse;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public CJRCSTRaiseIssueList raiseIssueList;
    /* access modifiers changed from: private */
    public List<CJRReplacementReason> reasons;

    public CJROrderSummaryMetadataResponse getMetaDataresponse() {
        return this.metaDataresponse;
    }

    public String getDescription() {
        return this.name;
    }

    public CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public String getName() {
        return this.name;
    }

    public CJRCSTRaiseIssueList getRaiseIssueList() {
        return this.raiseIssueList;
    }

    public List<CJRReplacementReason> getReasons() {
        return this.reasons;
    }
}
