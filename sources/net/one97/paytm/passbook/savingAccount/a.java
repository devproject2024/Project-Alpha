package net.one97.paytm.passbook.savingAccount;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import net.one97.paytm.passbook.savingAccount.b;
import net.one97.paytm.passbook.utility.d;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends o implements d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f58256a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f58257b;

    /* renamed from: c  reason: collision with root package name */
    private int f58258c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f58259d;

    public a(j jVar, ArrayList<String> arrayList, Fragment fragment, int i2, boolean z) {
        super(jVar);
        this.f58256a = arrayList;
        this.f58257b = fragment;
        this.f58258c = i2;
        this.f58259d = z;
    }

    public final Fragment getItem(int i2) {
        Bundle bundle = new Bundle();
        String str = this.f58256a.get(i2);
        if (str.equalsIgnoreCase("Withdrawals")) {
            bundle.putString("entrytype", b.a.DEBIT.getSavingAccountPassbookConstantName());
        } else if (str.equalsIgnoreCase("Deposits")) {
            bundle.putString("entrytype", b.a.CREDIT.getSavingAccountPassbookConstantName());
        } else {
            bundle.putString("entrytype", StringSet.all);
        }
        bundle.putInt("wallet card type", this.f58257b.getArguments().getInt("wallet card type"));
        bundle.putInt("filterpos", this.f58258c);
        bundle.putBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, this.f58259d);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    public final int getCount() {
        return this.f58256a.size();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f58256a.get(i2);
    }
}
