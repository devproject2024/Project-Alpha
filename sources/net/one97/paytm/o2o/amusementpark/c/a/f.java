package net.one97.paytm.o2o.amusementpark.c.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import net.one97.paytm.common.entity.amPark.AmParkInputForm;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;

public class f extends h {

    /* renamed from: a  reason: collision with root package name */
    public b f73514a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f73515b;

    /* renamed from: c  reason: collision with root package name */
    private AmParkTravellerResponseModel f73516c;

    /* renamed from: d  reason: collision with root package name */
    private Context f73517d;

    /* renamed from: e  reason: collision with root package name */
    private Button f73518e;

    /* renamed from: f  reason: collision with root package name */
    private String f73519f;

    /* renamed from: g  reason: collision with root package name */
    private String f73520g;

    public interface b {
        void h();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_booking_minimized_traveller_details, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73517d = getActivity().getApplicationContext();
            this.f73516c = (AmParkTravellerResponseModel) arguments.getSerializable("traveller-details");
            this.f73519f = arguments.getString("title");
            this.f73520g = arguments.getString("category");
        }
        if (inflate != null) {
            this.f73515b = (LinearLayout) inflate.findViewById(R.id.events_linear_add_traveller);
            this.f73518e = (Button) inflate.findViewById(R.id.event_continue);
            this.f73518e.setVisibility(8);
            LayoutInflater from = LayoutInflater.from(this.f73517d);
            int size = this.f73516c.getForm().size();
            Boolean bool = Boolean.TRUE;
            for (int i2 = 0; i2 < size; i2++) {
                View inflate2 = from.inflate(R.layout.park_booking_traveller_item_details, (ViewGroup) null);
                a aVar = new a(inflate2);
                Iterator it2 = this.f73516c.getForm().get(i2).iterator();
                String str = "";
                String str2 = str;
                boolean z = false;
                while (it2.hasNext()) {
                    AmParkInputForm amParkInputForm = (AmParkInputForm) it2.next();
                    if (amParkInputForm != null) {
                        if (amParkInputForm.getTitle() != null && amParkInputForm.getTitle().toLowerCase().contains("name") && !TextUtils.isEmpty(amParkInputForm.getAppliedData())) {
                            str = amParkInputForm.getAppliedData();
                        } else if (amParkInputForm.getType() != null && amParkInputForm.getType().toLowerCase().contains("heading")) {
                            str2 = amParkInputForm.getTitle();
                        }
                    }
                    if (!z && TextUtils.isEmpty(amParkInputForm.getAppliedData())) {
                        z = true;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    aVar.f73522b.setText(str);
                } else {
                    aVar.f73522b.setText(str2);
                }
                aVar.f73521a.setVisibility(8);
                if (z) {
                    aVar.f73521a.setVisibility(0);
                    bool = Boolean.FALSE;
                }
                this.f73515b.addView(inflate2);
            }
            this.f73518e.setEnabled(bool.booleanValue());
        }
        return inflate;
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f73521a;

        /* renamed from: b  reason: collision with root package name */
        TextView f73522b;

        /* renamed from: c  reason: collision with root package name */
        LinearLayout f73523c;

        public a(View view) {
            this.f73521a = (TextView) view.findViewById(R.id.txt_events_error_msg);
            this.f73522b = (TextView) view.findViewById(R.id.event_traveller_name);
            this.f73523c = (LinearLayout) view.findViewById(R.id.eventRootView);
            this.f73523c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            if (this.f73523c == view && f.this.f73514a != null) {
                f.this.f73514a.h();
            }
        }
    }
}
