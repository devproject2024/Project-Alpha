package net.one97.paytm.wallet.newdesign.nearby.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.ArrayList;
import net.one97.paytm.wallet.newdesign.nearby.b.c;
import net.one97.paytm.wallet.newdesign.nearby.b.e;

public final class f extends o {

    /* renamed from: c  reason: collision with root package name */
    public static String f71047c = "tabname";

    /* renamed from: d  reason: collision with root package name */
    public static String f71048d = "Pay With Paytm";

    /* renamed from: e  reason: collision with root package name */
    public static String f71049e = "Add Cash";

    /* renamed from: f  reason: collision with root package name */
    public static String f71050f = "Upgrade Account";

    /* renamed from: h  reason: collision with root package name */
    public static String f71051h = "nearby_type";

    /* renamed from: a  reason: collision with root package name */
    Context f71052a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f71053b;

    /* renamed from: g  reason: collision with root package name */
    boolean f71054g = true;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f71055i;

    public enum a {
        TAB_UPGRADE_ACCOUNT,
        TAB_PAY_WITH_PAYTM
    }

    public f(Context context, j jVar, ArrayList<String> arrayList, boolean z) {
        super(jVar);
        this.f71052a = context;
        this.f71053b = arrayList;
        this.f71055i = z;
    }

    public final Fragment getItem(int i2) {
        Bundle bundle = new Bundle();
        if (i2 >= 0 && i2 < a.values().length) {
            if (a.values()[i2].equals(a.TAB_PAY_WITH_PAYTM)) {
                c cVar = new c();
                bundle.putString(f71047c, f71048d);
                bundle.putBoolean(f71051h, this.f71054g);
                cVar.setArguments(bundle);
                return cVar;
            } else if (a.values()[i2].equals(a.TAB_UPGRADE_ACCOUNT)) {
                e eVar = new e();
                bundle.putString(f71047c, f71050f);
                bundle.putBoolean(f71051h, this.f71054g);
                bundle.putBoolean("isForFastTag", this.f71055i);
                eVar.setArguments(bundle);
                return eVar;
            }
        }
        return new Fragment();
    }

    public final int getCount() {
        return this.f71053b.size();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f71053b.get(i2);
    }
}
