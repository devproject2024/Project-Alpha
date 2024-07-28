package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a;

import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f17850a = new g();

    private g() {
    }

    public static ArrayList<d> a(ChequeBookNames chequeBookNames) {
        k.c(chequeBookNames, "chequeBookNames");
        ArrayList<d> arrayList = new ArrayList<>();
        List<String> suggestedNames = chequeBookNames.getSuggestedNames();
        if (suggestedNames == null) {
            k.a();
        }
        for (String dVar : suggestedNames) {
            arrayList.add(new d(0, "", dVar));
        }
        return arrayList;
    }
}
