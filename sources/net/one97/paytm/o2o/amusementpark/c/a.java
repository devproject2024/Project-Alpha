package net.one97.paytm.o2o.amusementpark.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.utility.b;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.d;
import net.one97.paytm.o2o.amusementpark.utils.j;
import net.one97.paytm.o2o.amusementpark.utils.k;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    List<String> f73405a = null;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.o2o.amusementpark.utils.a f73406b;

    /* renamed from: c  reason: collision with root package name */
    private d f73407c;

    /* renamed from: d  reason: collision with root package name */
    private View f73408d;

    /* renamed from: e  reason: collision with root package name */
    private String f73409e;

    /* renamed from: f  reason: collision with root package name */
    private String f73410f;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.f73408d = layoutInflater.inflate(R.layout.park_calendar_picker, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73405a = (ArrayList) arguments.getSerializable("event-date-list");
            this.f73409e = arguments.getString("title");
            this.f73410f = arguments.getString("category");
            net.one97.paytm.o2o.amusementpark.utils.a aVar = this.f73406b;
            if (aVar != null) {
                aVar.n = this.f73409e;
                aVar.o = this.f73410f;
            }
        }
        Context context = viewGroup.getContext();
        if (getArguments() == null) {
            str = "";
        } else {
            str = getArguments().getString("park_id");
        }
        k.a(context, 3, str);
        int g2 = b.g((Context) getActivity());
        this.f73408d.setPadding(g2, 0, g2, 0);
        return this.f73408d;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f73406b == null) {
            this.f73406b = new net.one97.paytm.o2o.amusementpark.utils.a();
        }
        this.f73407c = (d) activity;
        this.f73406b.a(activity);
        this.f73406b.j = this.f73407c;
    }

    public void onDetach() {
        super.onDetach();
        net.one97.paytm.o2o.amusementpark.utils.a aVar = this.f73406b;
        if (aVar != null) {
            aVar.a();
        }
        this.f73407c = null;
    }

    public void onResume() {
        super.onResume();
        net.one97.paytm.o2o.amusementpark.utils.a aVar = this.f73406b;
        View view = this.f73408d;
        List<String> list = this.f73405a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Calendar instance = Calendar.getInstance(new Locale("en"));
        instance.add(1, 1);
        Calendar.getInstance(new Locale("en"));
        aVar.k = (CalendarPickerView) view.findViewById(R.id.calendar_view);
        aVar.l = aVar.k.f45513h.getTime();
        aVar.l.setTime(0);
        new StringBuilder("dateToday").append(aVar.l);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2);
                arrayList.add(j.a(list.get(i2)));
                new StringBuilder().append(arrayList.get(i2));
            }
        }
        Collections.sort(arrayList);
        arrayList2.addAll(arrayList);
        if (arrayList2.size() > 0) {
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime((Date) arrayList2.get(arrayList2.size() - 1));
            instance2.add(5, 1);
            Date time = instance2.getTime();
            aVar.k.a((Date) arrayList2.get(0), time, new Locale("en")).a(CalendarPickerView.j.SINGLE).a((Date) arrayList2.get(0));
        } else {
            aVar.k.a(aVar.l, instance.getTime(), new Locale("en")).a(CalendarPickerView.j.SINGLE);
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new net.one97.paytm.o2o.amusementpark.utils.h(arrayList2));
        aVar.k.setDecorators(arrayList3);
        aVar.k.setCustomDayView(new c());
        aVar.k.setOnDateSelectedListener(aVar);
        d dVar = this.f73407c;
        if (dVar != null) {
            dVar.c();
        }
    }
}
