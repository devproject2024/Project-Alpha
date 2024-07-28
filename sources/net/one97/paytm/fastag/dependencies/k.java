package net.one97.paytm.fastag.dependencies;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJRGeneric;
import net.one97.paytm.fastag.model.CJRNextStep;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;

public interface k {
    i a();

    void a(i iVar);

    void a(CJRAddress cJRAddress, View view);

    void a(CJRNextStep cJRNextStep, ViewGroup viewGroup, CJROrderedCart cJROrderedCart);

    void a(CJROrderSummary cJROrderSummary, CJRCards cJRCards, i iVar, View view);

    void a(CJROrderSummary cJROrderSummary, CJRGeneric cJRGeneric, ViewGroup viewGroup, ArrayList<CJRAction> arrayList);

    void a(CJROrderedCart cJROrderedCart, View view);

    void a(CJROrderedCart cJROrderedCart, View view, boolean z);

    void b(CJROrderedCart cJROrderedCart, View view);

    void c(CJROrderedCart cJROrderedCart, View view);

    void d(CJROrderedCart cJROrderedCart, View view);

    void e(CJROrderedCart cJROrderedCart, View view);

    void f(CJROrderedCart cJROrderedCart, View view);
}
