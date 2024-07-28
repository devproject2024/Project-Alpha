package net.one97.paytm.o2o.amusementpark.c.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;

public class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRSeatDetailsModel> f73507a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f73508b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f73509c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f73510d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f73511e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f73512f;

    public interface a {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout;
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.park_booking_minimized_seat_summary, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73507a = (List) arguments.getSerializable("seat-summay-minimized-seat-list");
        }
        if (inflate != null) {
            this.f73508b = (TextView) inflate.findViewById(R.id.events_seat_minimized_title_textview);
            this.f73509c = (TextView) inflate.findViewById(R.id.events_seat_minimized_desc_textview);
            this.f73512f = (LinearLayout) inflate.findViewById(R.id.events_seat_minimized_desc_linear_layout);
            this.f73512f.removeAllViews();
            this.f73510d = (ImageView) inflate.findViewById(R.id.events_seat_minimized_image_button);
            this.f73510d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (e.this.f73511e != null) {
                        a unused = e.this.f73511e;
                    }
                }
            });
            List<CJRSeatDetailsModel> list = this.f73507a;
            if (list != null) {
                for (CJRSeatDetailsModel next : list) {
                    if (next.getSelectedQuantity() > 0) {
                        i2 += next.getSelectedQuantity();
                        View a2 = a(next);
                        if (!(a2 == null || (linearLayout = this.f73512f) == null)) {
                            linearLayout.addView(a2);
                        }
                    }
                }
                if (i2 == 1) {
                    TextView textView = this.f73508b;
                    textView.setText(String.valueOf(i2) + " Ticket");
                } else if (i2 > 1) {
                    TextView textView2 = this.f73508b;
                    textView2.setText(String.valueOf(i2) + " Tickets");
                }
            }
        }
        return inflate;
    }

    private View a(CJRSeatDetailsModel cJRSeatDetailsModel) {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.park_booking_seat_summary_minimized_list_item, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.events_seat_minimized_desc_textview)).setText(cJRSeatDetailsModel.getSeatType() + ", " + getContext().getString(R.string.rupees) + String.valueOf(cJRSeatDetailsModel.getPrice()));
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }
}
