package net.one97.paytm;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import net.one97.paytm.ad;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.dialog.a.c;

public final class ab {
    public static void a(AppCompatActivity appCompatActivity, final View view, int i2, CharSequence charSequence, int i3, long j) {
        if (view.getTag() != null) {
            ((ad) view.getTag()).b();
            view.setTag((Object) null);
            return;
        }
        ad a2 = a(appCompatActivity, a(appCompatActivity, charSequence, i3), view, i2);
        if (j > 0) {
            a2.a(j);
        } else {
            a2.a();
        }
        view.setTag(a2);
        a2.f52281a = new ad.b() {
            public final void a() {
                view.setTag((Object) null);
            }
        };
    }

    private static c a(AppCompatActivity appCompatActivity, CharSequence charSequence, int i2) {
        Resources resources = appCompatActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dimen_20dp);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.cart_12sp);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.wallet_3_dp);
        c.a aVar = new c.a();
        aVar.f70283a = charSequence;
        aVar.f70289g = (LinearLayout) appCompatActivity.getLayoutInflater().inflate(R.layout.web_view_tooltip, (ViewGroup) null);
        aVar.f70288f = 100;
        aVar.f70290h = true;
        aVar.f70284b = -1;
        aVar.f70285c = (float) dimensionPixelSize2;
        aVar.f70286d = i2;
        c.a a2 = aVar.a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        a2.f70287e = (float) dimensionPixelSize3;
        return a2.a();
    }

    private static ad a(AppCompatActivity appCompatActivity, c cVar, View view, int i2) {
        ad.a aVar = new ad.a(appCompatActivity);
        aVar.f52293a = view;
        aVar.f52294b = cVar;
        aVar.f52295c = i2;
        return aVar.a();
    }
}
