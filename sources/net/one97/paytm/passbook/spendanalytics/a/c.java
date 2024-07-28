package net.one97.paytm.passbook.spendanalytics.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.spendanalytics.b.a;

public final class c extends m {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f58500a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(j jVar, ArrayList<String> arrayList) {
        super(jVar);
        k.c(jVar, "fragmentManager");
        this.f58500a = arrayList;
    }

    public final Fragment getItem(int i2) {
        return new a(i2, this.f58500a);
    }

    public final int getCount() {
        ArrayList<String> arrayList = this.f58500a;
        Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.intValue();
    }
}
