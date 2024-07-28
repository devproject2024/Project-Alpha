package com.travel.bus.busticket.e;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.busticket.b.d;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;

public final class h extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22160a;

    /* renamed from: b  reason: collision with root package name */
    private d f22161b;

    public h(View view, d dVar) {
        super(view);
        this.f22160a = (RoboTextView) view.findViewById(R.id.amenityCount);
        this.f22161b = dVar;
    }

    public final void a(ArrayList<Integer> arrayList, int i2, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        this.f22160a.setText(String.format("+%s", new Object[]{String.valueOf(i2)}));
        this.f22160a.setOnClickListener(new View.OnClickListener(arrayList, hashMap) {
            private final /* synthetic */ ArrayList f$1;
            private final /* synthetic */ HashMap f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                h.this.a(this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList, HashMap hashMap, View view) {
        this.f22161b.onExpandAmenityClick(arrayList, hashMap);
    }
}
