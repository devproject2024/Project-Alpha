package net.one97.paytm.oauth.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import kotlin.g.b.k;
import net.one97.paytm.oauth.e.b;
import net.one97.paytm.oauth.fragment.ac;
import net.one97.paytm.oauth.fragment.ad;
import net.one97.paytm.oauth.fragment.be;
import net.one97.paytm.oauth.fragment.bs;
import net.one97.paytm.oauth.fragment.bt;
import net.one97.paytm.oauth.fragment.bu;
import net.one97.paytm.oauth.fragment.bv;
import net.one97.paytm.oauth.fragment.ce;

public final class e {
    public static void a(g gVar, Bundle bundle, Fragment fragment, int i2) {
        Fragment fragment2;
        k.c(gVar, "state");
        k.c(fragment, "parentFragment");
        b bVar = (b) fragment;
        switch (f.f56768a[gVar.ordinal()]) {
            case 1:
                ce.b bVar2 = ce.f56565a;
                fragment2 = ce.b.a(bundle, bVar);
                break;
            case 2:
                be.a aVar = be.f56407a;
                fragment2 = be.a.a(bundle, bVar);
                break;
            case 3:
                bu.a aVar2 = bu.f56529a;
                fragment2 = bu.a.a(bundle, bVar);
                break;
            case 4:
                bv.a aVar3 = bv.f56537a;
                fragment2 = bv.a.a(bundle, bVar);
                break;
            case 5:
                bt.a aVar4 = bt.f56521a;
                fragment2 = bt.a.a(bundle, bVar);
                break;
            case 6:
                bs.a aVar5 = bs.f56517a;
                fragment2 = bs.a.a(bundle, bVar);
                break;
            case 7:
                ad.a aVar6 = ad.f56300a;
                fragment2 = ad.a.a(bundle, bVar);
                break;
            case 8:
                ac.a aVar7 = ac.f56296a;
                fragment2 = ac.a.a(bundle, bVar);
                break;
            default:
                fragment2 = null;
                break;
        }
        q a2 = fragment.getChildFragmentManager().a();
        k.a((Object) a2, "parentFragment.childFrag…anager.beginTransaction()");
        a2.b(i2, fragment2);
        a2.c();
    }
}
