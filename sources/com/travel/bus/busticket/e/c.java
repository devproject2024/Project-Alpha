package com.travel.bus.busticket.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.widgets.BusFlowLayout;
import com.travel.bus.pojo.busticket.d;
import java.util.List;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    TextView f22136a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f22137b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f22138c;

    /* renamed from: d  reason: collision with root package name */
    int f22139d;

    /* renamed from: e  reason: collision with root package name */
    private Context f22140e;

    public c(View view, Context context) {
        super(view);
        this.f22140e = context;
        this.f22136a = (TextView) view.findViewById(R.id.txt_view_more);
        this.f22138c = (LinearLayout) view.findViewById(R.id.feedback_parent_layout);
    }

    public final void a() {
        int i2;
        List<d> list = this.f22137b;
        if (list != null && list.size() > 0) {
            this.f22139d = this.f22137b.size();
            final BusFlowLayout busFlowLayout = new BusFlowLayout(this.f22140e);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            busFlowLayout.setChildSpacing(10);
            busFlowLayout.setRowSpacing(20.0f);
            busFlowLayout.setFlow(true);
            busFlowLayout.setLayoutParams(layoutParams);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.f22139d;
                if (i4 >= i2) {
                    break;
                }
                int i5 = 0;
                while (i5 < (this.f22139d - i4) - 1) {
                    int i6 = i5 + 1;
                    if (this.f22137b.get(i5).f22808b < this.f22137b.get(i6).f22808b) {
                        int i7 = this.f22137b.get(i5).f22808b;
                        this.f22137b.get(i5).f22808b = this.f22137b.get(i6).f22808b;
                        this.f22137b.get(i6).f22808b = i7;
                    }
                    i5 = i6;
                }
                i4++;
            }
            if (i2 > 5) {
                while (i3 < 5) {
                    if (this.f22137b.get(i3) != null && this.f22137b.get(i3).f22808b > 0) {
                        a(i3, busFlowLayout);
                    }
                    this.f22138c.removeAllViews();
                    this.f22138c.addView(busFlowLayout);
                    i3++;
                }
                this.f22136a.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.f22136a.setVisibility(8);
                        for (int i2 = 5; i2 < c.this.f22139d; i2++) {
                            if (c.this.f22137b.get(i2) != null && c.this.f22137b.get(i2).f22808b > 0) {
                                c.this.a(i2, busFlowLayout);
                            }
                            c.this.f22138c.removeAllViews();
                            c.this.f22138c.addView(busFlowLayout);
                        }
                    }
                });
                return;
            }
            while (i3 < this.f22139d) {
                if (this.f22137b.get(i3) != null && this.f22137b.get(i3).f22808b > 0) {
                    a(i3, busFlowLayout);
                }
                this.f22138c.removeAllViews();
                this.f22138c.addView(busFlowLayout);
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, BusFlowLayout busFlowLayout) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.f22140e).inflate(R.layout.pre_b_bus_feedback_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.feedback_count_value);
        textView.setText(String.valueOf(this.f22137b.get(i2).f22808b));
        if (this.f22137b.get(i2).f22809c) {
            textView.setBackground(b.a(this.f22140e, R.drawable.travel_res_bus_feedback_circle_positive));
        } else {
            textView.setBackground(b.a(this.f22140e, R.drawable.travel_res_bus_feedback_circle_negative));
        }
        if (i2 == 4 && this.f22139d > 5 && (linearLayout = this.f22138c) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.f22138c.setLayoutParams(layoutParams);
            this.f22136a.setVisibility(0);
        }
        ((TextView) linearLayout2.findViewById(R.id.feedback_text)).setText(this.f22137b.get(i2).f22807a);
        busFlowLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-2, -2));
    }
}
