package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66928a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66929b;

    /* renamed from: c  reason: collision with root package name */
    public final CircularImageView f66930c;

    /* renamed from: d  reason: collision with root package name */
    public final View f66931d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f66932e;

    private y(ConstraintLayout constraintLayout, TextView textView, TextView textView2, CircularImageView circularImageView, View view) {
        this.f66932e = constraintLayout;
        this.f66928a = textView;
        this.f66929b = textView2;
        this.f66930c = circularImageView;
        this.f66931d = view;
    }

    public final ConstraintLayout a() {
        return this.f66932e;
    }

    public static y a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.mandate_detail_timeline_item_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.date);
        if (textView != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.message);
            if (textView2 != null) {
                CircularImageView circularImageView = (CircularImageView) inflate.findViewById(R.id.timelineCircle);
                if (circularImageView != null) {
                    View findViewById = inflate.findViewById(R.id.verticalLine);
                    if (findViewById != null) {
                        return new y((ConstraintLayout) inflate, textView, textView2, circularImageView, findViewById);
                    }
                    str = "verticalLine";
                } else {
                    str = "timelineCircle";
                }
            } else {
                str = "message";
            }
        } else {
            str = CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
