package com.travel.bus.orders.i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.travel.bus.R;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.f.d;
import com.travel.bus.pojo.CJRNPSCaptureDataModel;
import com.travel.bus.pojo.busticket.CJRBusNpsCaptureDataModel;
import java.util.ArrayList;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private d f22707a;

    /* renamed from: b  reason: collision with root package name */
    private RadioGroup f22708b;

    /* renamed from: c  reason: collision with root package name */
    private CJRNPSCaptureDataModel f22709c;

    /* renamed from: d  reason: collision with root package name */
    private Button f22710d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup[] f22711e;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton[] f22712f;

    /* renamed from: g  reason: collision with root package name */
    private int f22713g = -1;

    public final void a(c.b bVar) {
    }

    public h(View view, d dVar, CJRNPSCaptureDataModel cJRNPSCaptureDataModel) {
        super(view);
        this.f22709c = cJRNPSCaptureDataModel;
        this.f22707a = dVar;
        this.f22708b = (RadioGroup) view.findViewById(R.id.nps_radiogroup);
        this.f22710d = (Button) view.findViewById(R.id.submit_recommendation);
        int childCount = this.f22708b.getChildCount();
        this.f22711e = new ViewGroup[childCount];
        this.f22712f = new RadioButton[childCount];
        for (int i2 = 0; i2 < this.f22708b.getChildCount(); i2++) {
            ViewGroup viewGroup = (ViewGroup) this.f22708b.getChildAt(i2);
            this.f22711e[i2] = viewGroup;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof RadioButton) {
                    this.f22712f[i2] = (RadioButton) childAt;
                }
            }
            viewGroup.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    h.this.b(view);
                }
            });
        }
        this.f22710d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        int i2 = 0;
        while (true) {
            ViewGroup[] viewGroupArr = this.f22711e;
            if (i2 >= viewGroupArr.length) {
                break;
            } else if (viewGroupArr[i2] == viewGroup) {
                this.f22713g = i2;
                break;
            } else {
                i2++;
            }
        }
        int i3 = 0;
        while (true) {
            RadioButton[] radioButtonArr = this.f22712f;
            if (i3 < radioButtonArr.length) {
                radioButtonArr[i3].setChecked(false);
                i3++;
            } else {
                radioButtonArr[this.f22713g].setChecked(true);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        int i2 = this.f22713g;
        if (i2 >= 0 && this.f22709c != null) {
            CJRBusNpsCaptureDataModel.a aVar = new CJRBusNpsCaptureDataModel.a();
            ArrayList unused = aVar.f22783a.itemIds = this.f22709c.getItemIds();
            String unused2 = aVar.f22783a.orderId = this.f22709c.getOrderId();
            int unused3 = aVar.f22783a.response = i2;
            this.f22707a.a(com.travel.bus.orders.b.a.SUMMARY_REVIEW_AND_RATINGS, aVar.f22783a);
        }
    }
}
