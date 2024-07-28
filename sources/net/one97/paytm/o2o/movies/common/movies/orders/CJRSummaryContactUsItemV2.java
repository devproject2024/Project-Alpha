package net.one97.paytm.o2o.movies.common.movies.orders;

import java.util.List;
import net.one97.paytm.common.entity.cst.CJRCSTRaiseIssueList;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public class CJRSummaryContactUsItemV2 extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponseV2 metaDataresponse;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public CJRCSTRaiseIssueList raiseIssueList;
    /* access modifiers changed from: private */
    public List<CJRReplacementReason> reasons;

    public CJROrderSummaryMetadataResponseV2 getMetaDataresponse() {
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

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummaryContactUsItemV2 f75152a;

        public a() {
            this.f75152a = null;
            this.f75152a = new CJRSummaryContactUsItemV2();
        }

        public final a a(CJROrderSummary cJROrderSummary) {
            CJROrderSummary unused = this.f75152a.orderSummary = cJROrderSummary;
            return this;
        }

        public final a a(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2) {
            CJROrderSummaryMetadataResponseV2 unused = this.f75152a.metaDataresponse = cJROrderSummaryMetadataResponseV2;
            return this;
        }
    }
}
