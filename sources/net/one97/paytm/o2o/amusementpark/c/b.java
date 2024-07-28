package net.one97.paytm.o2o.amusementpark.c;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.b;
import net.one97.paytm.o2o.amusementpark.d.m;

public class b extends h implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f73533a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRAddressDetailModel> f73534b;

    /* renamed from: c  reason: collision with root package name */
    private m f73535c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f73534b = new ArrayList();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f73535c = (m) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        List<CJRAddressDetailModel> list;
        CJRAddressDetailModel cJRAddressDetailModel;
        View inflate = layoutInflater.inflate(R.layout.park_booking_home_layout, viewGroup, false);
        Bundle arguments = getArguments();
        if (!(arguments == null || (cJRAddressDetailModel = (CJRAddressDetailModel) arguments.getSerializable("event-address-list")) == null)) {
            this.f73534b.add(cJRAddressDetailModel);
        }
        if (inflate != null) {
            this.f73533a = (LinearLayout) inflate.findViewById(R.id.events_book_venue_radio_button_container);
            List<CJRAddressDetailModel> list2 = this.f73534b;
            if (list2 != null && list2.size() > 0 && (list = this.f73534b) != null && list.size() > 0) {
                net.one97.paytm.o2o.amusementpark.a.b bVar = new net.one97.paytm.o2o.amusementpark.a.b(getActivity(), list, this);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.f73533a.addView(bVar.getView(i2, (View) null, (ViewGroup) null));
                }
            }
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        m mVar = this.f73535c;
        if (mVar != null) {
            mVar.b();
        }
    }

    public final void a(String str) {
        m mVar;
        List<CJRAddressDetailModel> list;
        CJRAddressDetailModel cJRAddressDetailModel = null;
        if (!TextUtils.isEmpty(str) && (list = this.f73534b) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f73534b.size()) {
                    break;
                }
                CJRAddressDetailModel cJRAddressDetailModel2 = this.f73534b.get(i2);
                if (cJRAddressDetailModel2.getAddressName() != null && cJRAddressDetailModel2.getAddressName().equalsIgnoreCase(str)) {
                    cJRAddressDetailModel = cJRAddressDetailModel2;
                    break;
                }
                i2++;
            }
        }
        if (cJRAddressDetailModel != null && (mVar = this.f73535c) != null) {
            mVar.a(cJRAddressDetailModel);
        }
    }
}
