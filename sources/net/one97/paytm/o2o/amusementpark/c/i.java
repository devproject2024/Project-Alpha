package net.one97.paytm.o2o.amusementpark.c;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.a;
import net.one97.paytm.o2o.amusementpark.d.l;

public class i extends h implements a.C1470a {

    /* renamed from: a  reason: collision with root package name */
    private a f73591a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRAmParkDateTimeModel.Time> f73592b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<CJRSeatDetailsModel>> f73593c;

    /* renamed from: d  reason: collision with root package name */
    private l f73594d;

    /* renamed from: e  reason: collision with root package name */
    private String f73595e;

    /* renamed from: f  reason: collision with root package name */
    private String f73596f;

    /* renamed from: g  reason: collision with root package name */
    private String f73597g;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_time_layout, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73592b = (List) arguments.getSerializable("event-time-slot-list");
            this.f73593c = (Map) arguments.getSerializable("event-time-slot-map");
            this.f73595e = arguments.getString("event-bundle-key-date");
            this.f73596f = arguments.getString("title");
            this.f73597g = arguments.getString("category");
        }
        this.f73591a = new a(this.f73592b, getActivity(), this, this.f73596f, this.f73597g);
        a aVar = this.f73591a;
        aVar.f73060a = this.f73595e;
        aVar.f73061b = this.f73593c;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.events_book_time_radio_button_container);
        for (int i2 = 0; i2 < this.f73592b.size(); i2++) {
            linearLayout.addView(this.f73591a.getView(i2, (View) null, (ViewGroup) null));
        }
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f73594d = (l) activity;
    }

    public void onResume() {
        super.onResume();
        l lVar = this.f73594d;
        if (lVar != null) {
            lVar.d();
        }
    }

    public final void a(CJRAmParkDateTimeModel.Time time) {
        l lVar = this.f73594d;
        if (lVar != null) {
            lVar.a(time);
        }
    }
}
