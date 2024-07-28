package net.one97.paytm.o2o.amusementpark.c.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.utils.d;

public class g extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f73525a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f73526b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f73527c;

    /* renamed from: d  reason: collision with root package name */
    private String f73528d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f73529e;

    /* renamed from: f  reason: collision with root package name */
    private String f73530f;

    /* renamed from: g  reason: collision with root package name */
    private String f73531g;

    /* renamed from: h  reason: collision with root package name */
    private CJRAmParkDateTimeModel.Time f73532h;

    public interface a {
        void c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ampark_booking_minimized_venue_summary, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73528d = arguments.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            this.f73529e = arguments.getBoolean("is-single-venue-and-date-and-time");
            this.f73532h = (CJRAmParkDateTimeModel.Time) arguments.getSerializable("time");
            this.f73530f = arguments.getString("title");
            this.f73531g = arguments.getString("category");
        }
        if (inflate != null) {
            this.f73526b = (TextView) inflate.findViewById(R.id.events_venue_minimized_date_textview);
            this.f73527c = (TextView) inflate.findViewById(R.id.events_venue_minimized_time_textview);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.events_minimized_image_button);
            inflate.findViewById(R.id.events_booking_minimized_venue_summary_container).setOnClickListener(this);
            if (!this.f73529e) {
                getContext();
                b.d(this.f73526b);
                this.f73526b.setTextSize(14.0f);
                this.f73526b.setTextColor(getResources().getColor(R.color.event_text_color_black));
            } else {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.events_booking_minimized_venue_summary_container);
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_fafafa));
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                getContext();
                b.c(this.f73526b);
            }
            CJRAmParkDateTimeModel.Time time = this.f73532h;
            if (time != null && !TextUtils.isEmpty(time.getmStart()) && !TextUtils.isEmpty(this.f73532h.getmTo())) {
                String a2 = d.a(getContext(), this.f73532h.getmStart());
                String a3 = d.a(getContext(), this.f73532h.getmTo());
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    TextView textView = this.f73527c;
                    textView.setText(a2 + getString(R.string.to) + a3);
                }
            }
            String a4 = a(this.f73528d);
            if (!TextUtils.isEmpty(a4)) {
                this.f73526b.setText(a4);
            } else if (!TextUtils.isEmpty(this.f73528d)) {
                this.f73526b.setText(this.f73528d);
            }
        }
        return inflate;
    }

    public void onClick(View view) {
        a aVar = this.f73525a;
        if (aVar != null) {
            aVar.c();
        }
    }

    private static String a(String str) {
        try {
            return new SimpleDateFormat("E, dd MMM").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }
}
