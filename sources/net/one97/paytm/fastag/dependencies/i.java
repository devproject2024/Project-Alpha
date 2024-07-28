package net.one97.paytm.fastag.dependencies;

import java.util.Map;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryAction;
import net.one97.paytm.fastag.model.CJROrderedCart;

public interface i {
    void a(CJROrderSummary cJROrderSummary);

    void a(CJROrderSummary cJROrderSummary, CJRAction cJRAction, Map<String, Object> map, String str);

    void a(CJROrderSummary cJROrderSummary, CJROrderedCart cJROrderedCart, CJROrderSummaryAction cJROrderSummaryAction);
}
