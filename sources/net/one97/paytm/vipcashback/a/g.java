package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbackoffers.ui.a;
import net.one97.paytm.v2.features.cashbackoffers.ui.b;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;

public final class g extends o {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f20641a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f20642b;

    public final int getCount() {
        return 2;
    }

    public final int getItemPosition(Object obj) {
        k.c(obj, "object");
        return -2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, j jVar) {
        super(jVar);
        k.c(context, "context");
        k.c(jVar, "fm");
        this.f20642b = context;
    }

    public final CharSequence getPageTitle(int i2) {
        if (i2 == 0) {
            return this.f20642b.getString(R.string.your_vouchers_deals);
        }
        if (i2 != 1) {
            return null;
        }
        return this.f20642b.getString(R.string.your_vouchers_deals);
    }

    public final /* synthetic */ Fragment getItem(int i2) {
        a aVar;
        if (i2 != 0) {
            Intent intent = new Intent();
            a.b.C0384a aVar2 = a.b.f20777a;
            intent.putExtra("offer_type_card", a.b.f20783g);
            intent.putExtra("status_type", 2);
            b.a aVar3 = b.j;
            b a2 = b.a.a(intent);
            this.f20641a.add(a2);
            aVar = a2;
        } else {
            Intent intent2 = new Intent();
            a.b.C0384a aVar4 = a.b.f20777a;
            intent2.putExtra("offer_type_card", a.b.f20783g);
            intent2.putExtra("status_type", 1);
            b.a aVar5 = b.j;
            b a3 = b.a.a(intent2);
            this.f20641a.add(a3);
            aVar = a3;
        }
        return aVar;
    }
}
