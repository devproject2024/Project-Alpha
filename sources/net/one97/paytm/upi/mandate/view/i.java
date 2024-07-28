package net.one97.paytm.upi.mandate.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.view.j;

public final class i extends o {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<MandateItem> f67534a = new ArrayList<>();

    public final int getItemPosition(Object obj) {
        k.c(obj, "item");
        return -2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(j jVar) {
        super(jVar);
        k.c(jVar, "fm");
    }

    public final Fragment getItem(int i2) {
        j.a aVar = j.f67535a;
        MandateItem mandateItem = this.f67534a.get(i2);
        k.a((Object) mandateItem, "dataList[position]");
        MandateItem mandateItem2 = mandateItem;
        k.c(mandateItem2, "mandateItem");
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("mandate_item", mandateItem2);
        jVar.setArguments(bundle);
        return jVar;
    }

    public final int getCount() {
        return this.f67534a.size();
    }
}
