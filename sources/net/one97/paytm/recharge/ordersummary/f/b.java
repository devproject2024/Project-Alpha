package net.one97.paytm.recharge.ordersummary.f;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import io.reactivex.rxjava3.j.e;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;

public interface b {
    androidx.fragment.app.b a(a aVar, CJROrderedCart cJROrderedCart, int i2, View.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener);

    void a(DialogInterface.OnClickListener onClickListener);

    void a(DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener);

    void a(String str);

    void a(String str, String str2);

    void a(String str, String str2, String str3);

    void a(HashMap<String, View> hashMap);

    void a(CJROrderSummaryAction cJROrderSummaryAction);

    void a(CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener);

    void a(CJROrderedCart cJROrderedCart, String str);

    void a(a aVar, DialogInterface.OnDismissListener onDismissListener);

    void a(a aVar, CJROrderedCart cJROrderedCart);

    void a(a aVar, CJROrderedCart cJROrderedCart, Bundle bundle);

    boolean a(String str, e<String> eVar, e<String> eVar2);

    void at_();

    void b(String str);

    void b(String str, String str2);

    void b(l lVar);

    void f(CJROrderedCart cJROrderedCart);

    CJROrderActionsListView getOrderActionClickListener();

    j getSupportFragmentManager();

    void o();

    void p();

    void setBillConsent(CJROrderSummaryAction cJROrderSummaryAction);

    void setupAutoPay(a aVar, CJROrderedCart cJROrderedCart, CJROrderSummaryAction cJROrderSummaryAction);
}
