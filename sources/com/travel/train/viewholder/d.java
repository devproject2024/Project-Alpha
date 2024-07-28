package com.travel.train.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.v;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.utils.n;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f28072a;

    /* renamed from: b  reason: collision with root package name */
    private Context f28073b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f28074c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f28075d;

    public d(View view) {
        super(view);
        this.f28073b = view.getContext();
        this.f28072a = (RelativeLayout) view.findViewById(R.id.lyt_alert);
        this.f28074c = (TextView) view.findViewById(R.id.lbl_alert);
        this.f28075d = (ImageView) view.findViewById(R.id.img_alert);
    }

    public final void a() {
        this.f28072a.setVisibility(0);
        ResourceUtils.loadTrainImagesFromCDN(this.f28075d, "img_alert.png", false, false, n.a.V1);
        b();
        this.f28072a.postDelayed(new Runnable() {
            public final void run() {
                d.this.f28072a.setVisibility(8);
            }
        }, 5000);
        this.f28072a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.f28072a.setVisibility(8);
            }
        });
    }

    private void b() {
        String string = this.f28073b.getString(R.string.train_alert_txt);
        if (g.f27551a == null || g.f27551a.getAvailabilityAlertText() == null || TextUtils.isEmpty(g.f27551a.getAvailabilityAlertText().trim())) {
            String a2 = v.a(this.f28073b.getString(R.string.train_alert_lbl), " ", string);
            int length = this.f28073b.getString(R.string.train_alert_lbl).length();
            SpannableString spannableString = new SpannableString(a2);
            spannableString.setSpan(new StyleSpan(1), 0, length, 0);
            spannableString.setSpan(new ForegroundColorSpan(b.c(this.f28073b, R.color.color_3063ad)), 0, length, 0);
            this.f28074c.setText(spannableString);
            return;
        }
        this.f28074c.setText(g.f27551a.getAvailabilityAlertText());
    }
}
