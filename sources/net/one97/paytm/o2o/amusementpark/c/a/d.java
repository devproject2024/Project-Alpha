package net.one97.paytm.o2o.amusementpark.c.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;

public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    public a f73497a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f73498b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f73499c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f73500d;

    /* renamed from: e  reason: collision with root package name */
    private String f73501e;

    /* renamed from: f  reason: collision with root package name */
    private String f73502f;

    /* renamed from: g  reason: collision with root package name */
    private int f73503g;

    /* renamed from: h  reason: collision with root package name */
    private String f73504h;

    /* renamed from: i  reason: collision with root package name */
    private String f73505i;

    public interface a {
        void h();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_booking_minimized_traveller_summary, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73501e = arguments.getString("traveller-minimized-name");
            this.f73502f = arguments.getString("traveller-minimized-desc");
            this.f73503g = arguments.getInt("traveller-minimized-count");
            this.f73504h = arguments.getString("title");
            this.f73505i = arguments.getString("category");
        }
        if (inflate != null) {
            this.f73498b = (TextView) inflate.findViewById(R.id.events_traveller_minimized_title_textview);
            this.f73499c = (TextView) inflate.findViewById(R.id.events_traveller_minimized_desc_textview);
            this.f73500d = (ImageView) inflate.findViewById(R.id.events_seat_minimized_image_button);
            this.f73500d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (d.this.f73497a != null) {
                        d.this.f73497a.h();
                    }
                }
            });
            this.f73498b.setText(this.f73501e);
            this.f73499c.setText(this.f73502f);
        }
        return inflate;
    }
}
