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

public class ImportantNotesActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f73392a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f73393b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f73394c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f73395d;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.am_park_important_notes_layout);
        this.f73392a = (Toolbar) findViewById(R.id.toolbar);
        this.f73393b = (ImageView) this.f73392a.findViewById(R.id.back_arrow);
        this.f73393b.setOnClickListener(this);
        this.f73394c = (RoboTextView) this.f73392a.findViewById(R.id.toolbar_title);
        this.f73394c.setText(getResources().getString(R.string.important_notes));
        this.f73395d = (RoboTextView) findViewById(R.id.tv_important_notes);
        RoboTextView roboTextView = this.f73395d;
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            String string = getIntent().getExtras().getString("instructions_key");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string)) {
                str = d.a(string);
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
        super.attachBaseContext(a.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
