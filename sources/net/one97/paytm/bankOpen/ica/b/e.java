package net.one97.paytm.bankOpen.ica.b;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.d.a;

public class e extends b {

    /* renamed from: b  reason: collision with root package name */
    private a f16483b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f16484c;

    public View a(int i2) {
        if (this.f16484c == null) {
            this.f16484c = new HashMap();
        }
        View view = (View) this.f16484c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16484c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void f() {
        HashMap hashMap = this.f16484c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f16483b = new a(getActivity());
    }

    public final void d() {
        a aVar = this.f16483b;
        if (aVar == null) {
            k.a("lottieAnimationLoaderDialog");
        }
        if (aVar != null) {
            a aVar2 = this.f16483b;
            if (aVar2 == null) {
                k.a("lottieAnimationLoaderDialog");
            }
            aVar2.a(getString(R.string.please_wait_progress_msg));
            a aVar3 = this.f16483b;
            if (aVar3 == null) {
                k.a("lottieAnimationLoaderDialog");
            }
            aVar3.a();
        }
    }

    public final void e() {
        a aVar = this.f16483b;
        if (aVar == null) {
            k.a("lottieAnimationLoaderDialog");
        }
        if (aVar != null) {
            a aVar2 = this.f16483b;
            if (aVar2 == null) {
                k.a("lottieAnimationLoaderDialog");
            }
            aVar2.b();
        }
    }
}
