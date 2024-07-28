package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.google.android.play.core.splitcompat.a;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.i.h;
import net.one97.paytm.utils.b.a;
import net.one97.paytm.vipcashback.c.a.b;
import net.one97.paytm.vipcashback.c.c;
import net.one97.paytm.vipcashback.c.d;
import net.one97.paytm.vipcashback.f.f;

public class PostTxnHelperFragment extends h implements e {

    /* renamed from: a  reason: collision with root package name */
    private c f20911a = new c();

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getContext() == null) {
            return null;
        }
        return new View(getContext());
    }

    public final boolean a(int i2, int i3) {
        Integer num;
        net.one97.paytm.utils.b.a aVar;
        c cVar = this.f20911a;
        if (cVar != null) {
            String str = null;
            if (i2 <= 0) {
                num = null;
            } else {
                num = Integer.valueOf(i2);
            }
            Integer valueOf = i3 <= 0 ? null : Integer.valueOf(i3);
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            List<Integer> b2 = f.b();
            if (!(num != null || valueOf == null || valueOf.intValue() == 0)) {
                a.C1408a aVar2 = net.one97.paytm.utils.b.a.Companion;
                int intValue = valueOf.intValue();
                net.one97.paytm.utils.b.a[] values = net.one97.paytm.utils.b.a.values();
                int length = values.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        aVar = null;
                        break;
                    }
                    aVar = values[i4];
                    if (aVar.getCategoryId() == intValue) {
                        break;
                    }
                    i4++;
                }
                num = Integer.valueOf(aVar != null ? aVar.getId() : 0);
            }
            if (num != null) {
                str = String.valueOf(num.intValue());
            }
            cVar.f20717b = str;
            if (b2.contains(num)) {
                f.a();
                if (f.a("cashbackFeatureEnabled")) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(net.one97.paytm.cashback.posttxn.f fVar, net.one97.paytm.cashback.posttxn.a aVar) {
        String str;
        c cVar = this.f20911a;
        if (cVar != null) {
            k.c(fVar, "initializer");
            cVar.f20719d = aVar;
            cVar.a();
            if (fVar.f49537a != null) {
                str = fVar.f49537a;
            } else if (fVar.f49539c != null) {
                str = fVar.f49539c;
            } else if (fVar.f49540d != null) {
                str = fVar.f49540d;
            } else {
                str = null;
            }
            d dVar = cVar.f20718c;
            if (dVar != null) {
                dVar.a(str, fVar.f49538b, d.a(fVar.f49541e, fVar.f49542f, fVar.f49543g, fVar.f49544h));
            }
        }
    }

    public final void a(AppCompatActivity appCompatActivity) {
        c cVar = this.f20911a;
        if (cVar != null) {
            cVar.a(appCompatActivity);
        }
    }

    public final void a(FragmentActivity fragmentActivity, net.one97.paytm.cashback.posttxn.a aVar, String str) {
        c cVar = this.f20911a;
        if (cVar != null && str != null) {
            cVar.a(fragmentActivity);
            c cVar2 = this.f20911a;
            k.c(fragmentActivity, "appCompatActivity");
            k.c(str, "data");
            if (p.a((CharSequence) str, (CharSequence) "APP_OPEN", false)) {
                cVar2.f20720e = true;
            }
            cVar2.f20719d = aVar;
            cVar2.f20716a = fragmentActivity;
            cVar2.a();
            d dVar = cVar2.f20718c;
            if (dVar != null) {
                k.c(str, "data");
                b bVar = dVar.f20727a;
                if (bVar == null) {
                    k.a("repository");
                }
                bVar.b(dVar.f20732f, str);
            }
        }
    }

    public final void a() {
        LiveData<String> liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        c cVar = this.f20911a;
        if (cVar != null) {
            FragmentActivity fragmentActivity = cVar.f20716a;
            if (fragmentActivity != null) {
                d dVar = cVar.f20718c;
                if (!(dVar == null || (liveData4 = dVar.f20729c) == null)) {
                    liveData4.removeObservers(fragmentActivity);
                }
                d dVar2 = cVar.f20718c;
                if (!(dVar2 == null || (liveData3 = dVar2.f20730d) == null)) {
                    liveData3.removeObservers(fragmentActivity);
                }
                d dVar3 = cVar.f20718c;
                if (!(dVar3 == null || (liveData2 = dVar3.f20731e) == null)) {
                    liveData2.removeObservers(fragmentActivity);
                }
                d dVar4 = cVar.f20718c;
                if (!(dVar4 == null || (liveData = dVar4.f20734h) == null)) {
                    liveData.removeObservers(fragmentActivity);
                }
            }
            cVar.f20716a = null;
            this.f20911a = null;
        }
    }
}
