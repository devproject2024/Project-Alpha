package com.travel.flight.flightticket.j;

import android.text.Html;
import android.view.View;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f25161a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f25162b;

    public i(View view) {
        this.f25161a = (RoboTextView) view.findViewById(R.id.display_name);
        this.f25162b = (RoboTextView) view.findViewById(R.id.display_msg);
    }

    public final void a(String str, String str2) {
        this.f25161a.setText(str);
        this.f25162b.setText(Html.fromHtml(str2));
    }
}
