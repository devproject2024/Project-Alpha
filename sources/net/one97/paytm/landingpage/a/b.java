package net.one97.paytm.landingpage.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.SFHomeFragment;
import java.util.List;
import net.one97.paytm.landingpage.f.c;

public final class b extends m {

    /* renamed from: a  reason: collision with root package name */
    public SFHomeFragment f52655a;

    /* renamed from: b  reason: collision with root package name */
    private List<Fragment> f52656b;

    /* renamed from: c  reason: collision with root package name */
    private Context f52657c;

    public b(j jVar, Context context, List<Fragment> list) {
        super(jVar, 1);
        this.f52656b = list;
        this.f52657c = context;
    }

    public final Fragment getItem(int i2) {
        Fragment fragment = this.f52656b.get(i2);
        if (fragment instanceof SFHomeFragment) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(CLPConstants.IS_PREWARMING_INITIALISED, true);
            fragment.setArguments(bundle);
            SFHomeFragment sFHomeFragment = (SFHomeFragment) fragment;
            this.f52655a = sFHomeFragment;
            sFHomeFragment.setCashbackListener(new c(this.f52657c));
            sFHomeFragment.setHomeListener(new net.one97.paytm.landingpage.f.b());
        }
        return fragment;
    }

    public final int getCount() {
        List<Fragment> list = this.f52656b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
