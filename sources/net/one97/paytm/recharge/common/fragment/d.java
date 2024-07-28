package net.one97.paytm.recharge.common.fragment;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f61159a;

    public View a(int i2) {
        if (this.f61159a == null) {
            this.f61159a = new HashMap();
        }
        View view = (View) this.f61159a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61159a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f61159a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }
}
