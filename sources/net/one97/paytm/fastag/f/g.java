package net.one97.paytm.fastag.f;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import net.one97.paytm.fastag.dependencies.i;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJRGeneric;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;

public interface g {
    i a();

    void a(i iVar);

    void a(CJROrderSummary cJROrderSummary, CJRCards cJRCards, i iVar, View view);

    void a(CJROrderSummary cJROrderSummary, CJRGeneric cJRGeneric, ViewGroup viewGroup, ArrayList<CJRAction> arrayList);

    void a(CJROrderedCart cJROrderedCart, View view);

    void b(CJROrderedCart cJROrderedCart, View view);
}
