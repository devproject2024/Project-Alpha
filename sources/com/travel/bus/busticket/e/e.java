package com.travel.bus.busticket.e;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.busticket.b.b;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22152a;

    /* renamed from: b  reason: collision with root package name */
    private b f22153b;

    public e(View view, b bVar) {
        super(view);
        this.f22152a = (RoboTextView) view.findViewById(R.id.reviewAmenityCount);
        this.f22153b = bVar;
    }

    public final void a(ArrayList<Integer> arrayList, int i2, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        this.f22152a.setText(String.format("+%s", new Object[]{String.valueOf(i2)}));
        this.f22152a.setOnClickListener(new View.OnClickListener(arrayList, hashMap) {
            private final /* synthetic */ ArrayList f$1;
            private final /* synthetic */ HashMap f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                e.this.a(this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList, HashMap hashMap, View view) {
        this.f22153b.a(arrayList, hashMap);
    }
}
