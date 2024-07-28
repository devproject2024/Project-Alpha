package net.one97.paytm.vipcashback.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbackoffers.ui.b;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.fragment.c;

public final class e extends o {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Fragment> f20629a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f20630b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20631c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20632d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20633e;

    public final int getCount() {
        return 2;
    }

    public final int getItemPosition(Object obj) {
        k.c(obj, "object");
        return -2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, j jVar, boolean z, boolean z2, String str) {
        super(jVar);
        k.c(context, "context");
        k.c(jVar, "fm");
        this.f20630b = context;
        this.f20631c = z;
        this.f20632d = z2;
        this.f20633e = str;
    }

    public final Fragment getItem(int i2) {
        if (i2 != 1) {
            c.a aVar = c.f20931h;
            boolean z = this.f20631c;
            boolean z2 = this.f20632d;
            String str = this.f20633e;
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_IS_FROM_DRAWER", z);
            bundle.putBoolean("LOAD_ON_CREATE_DATA", z2);
            bundle.putString("OFFER_TAG", str);
            cVar.setArguments(bundle);
            this.f20629a.add(cVar);
            return cVar;
        }
        Intent intent = new Intent();
        a.b.C0384a aVar2 = a.b.f20777a;
        intent.putExtra("offer_type_card", a.b.f20785i);
        intent.putExtra("status_type", 1);
        b.a aVar3 = b.j;
        b a2 = b.a.a(intent);
        this.f20629a.add(a2);
        return a2;
    }

    public final CharSequence getPageTitle(int i2) {
        if (i2 == 0) {
            return this.f20630b.getString(R.string.your_vouchers_deals);
        }
        if (i2 != 1) {
            return null;
        }
        return this.f20630b.getString(R.string.your_vouchers_deals);
    }
}
