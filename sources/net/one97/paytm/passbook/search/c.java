package net.one97.paytm.passbook.search;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import net.one97.paytm.passbook.utility.d;

public final class c extends o implements d {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f58394a;

    public c(j jVar, ArrayList<String> arrayList) {
        super(jVar);
        this.f58394a = arrayList;
    }

    public final Fragment getItem(int i2) {
        d.b bVar = d.b.values()[i2];
        if (bVar == d.b.TAB_AUTHORISED) {
            return new net.one97.paytm.passbook.subWallet.b.c();
        }
        Bundle bundle = new Bundle();
        if (d.b.TAB_PAID == bVar) {
            bundle.putString("entrytype", "DR");
        } else if (d.b.TAB_ADDED == bVar) {
            bundle.putString("entrytype", "CR_added");
        } else if (d.b.TAB_RECEIVED == bVar) {
            bundle.putString("entrytype", "CR");
        } else {
            bundle.putString("entrytype", StringSet.all);
        }
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public final int getCount() {
        return this.f58394a.size();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f58394a.get(i2);
    }
}
