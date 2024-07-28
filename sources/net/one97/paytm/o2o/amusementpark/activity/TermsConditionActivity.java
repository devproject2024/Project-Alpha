package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.o2o.amusementpark.utils.m;

public class TermsConditionActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f73401a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f73402b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f73403c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f73404d;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView(R.layout.am_park_terms_condition_layout);
        this.f73401a = (Toolbar) findViewById(R.id.toolbar);
        this.f73402b = (ImageView) this.f73401a.findViewById(R.id.back_arrow);
        this.f73402b.setOnClickListener(this);
        this.f73403c = (RoboTextView) this.f73401a.findViewById(R.id.toolbar_title);
        this.f73403c.setText(getResources().getString(R.string.terms_and_conditions));
        this.f73404d = (RoboTextView) findViewById(R.id.tv_term_and_condition);
        RoboTextView roboTextView = this.f73404d;
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            String string = getIntent().getExtras().getString("terms_and_condition_key");
            if (!TextUtils.isEmpty(string)) {
                if (string != null) {
                    if (string.contains("\n*")) {
                        str2 = string.replace("*", "•");
                    } else {
                        str2 = string.replace("*", "\n•");
                    }
                    string = d.a(str2);
                }
                str = string.trim();
                roboTextView.setText(str);
            }
        }
        str = "";
        roboTextView.setText(str);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back_arrow) {
            onBackPressed();
        }
    }

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
