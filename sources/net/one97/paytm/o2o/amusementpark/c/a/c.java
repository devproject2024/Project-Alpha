package net.one97.paytm.o2o.amusementpark.c.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.utils.d;

public class c extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f73488a;

    /* renamed from: b  reason: collision with root package name */
    private String f73489b;

    /* renamed from: c  reason: collision with root package name */
    private CJRAmParkDateTimeModel.Time f73490c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f73491d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f73492e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f73493f;

    /* renamed from: g  reason: collision with root package name */
    private Button f73494g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f73495h;

    /* renamed from: i  reason: collision with root package name */
    private String f73496i;
    private String j;

    public interface a {
        void d();

        void e();

        void f();

        void g();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ampark_booking_maximized_venue_summary, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73489b = arguments.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            this.f73490c = (CJRAmParkDateTimeModel.Time) arguments.getSerializable("time");
            this.f73495h = arguments.getBoolean("show_continue");
            this.f73496i = arguments.getString("title");
            this.j = arguments.getString("category");
        }
        if (inflate != null) {
            this.f73493f = (ImageView) inflate.findViewById(R.id.events_maximized_image_button);
            this.f73493f.setOnClickListener(this);
            this.f73491d = (TextView) inflate.findViewById(R.id.events_date_maximized_event_title_textview);
            this.f73492e = (TextView) inflate.findViewById(R.id.events_time_maximized_event_title_textview);
            this.f73491d.setOnClickListener(this);
            this.f73492e.setOnClickListener(this);
            if (this.f73489b != null) {
                ImageView imageView = this.f73493f;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                ImageView imageView2 = this.f73493f;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.f73489b)) {
                getContext();
                this.f73491d.setText(d.a(this.f73489b, "yyyy-MM-dd", "dd/MM/yyyy"));
            }
            CJRAmParkDateTimeModel.Time time = this.f73490c;
            if (time != null && !TextUtils.isEmpty(time.getmStart())) {
                this.f73492e.setText(d.a(getContext(), this.f73490c.getmStart()));
            }
            this.f73494g = (Button) inflate.findViewById(R.id.events_book_venue_summary_continue_button);
            this.f73494g.setOnClickListener(this);
            a(this.f73495h);
        }
        return inflate;
    }

    private void a(boolean z) {
        Button button = this.f73494g;
        if (button == null) {
            return;
        }
        if (z) {
            button.setVisibility(0);
        } else {
            button.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        TextView textView = this.f73491d;
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            a(this.f73495h);
        }
    }

    public void onClick(View view) {
        a aVar;
        if (view == this.f73493f) {
            a aVar2 = this.f73488a;
            if (aVar2 != null) {
                aVar2.d();
                return;
            }
            return;
        }
        TextView textView = this.f73491d;
        if (view == textView) {
            a aVar3 = this.f73488a;
            if (aVar3 != null) {
                aVar3.e();
            }
        } else if (view == this.f73492e) {
            a aVar4 = this.f73488a;
            if (aVar4 != null) {
                aVar4.f();
            }
        } else if (view == this.f73494g && a(textView) && a(this.f73492e) && (aVar = this.f73488a) != null) {
            aVar.g();
            this.f73495h = false;
        }
    }

    private static boolean a(TextView textView) {
        return (textView == null || textView.getText() == null || TextUtils.isEmpty(textView.getText().toString())) ? false : true;
    }
}
