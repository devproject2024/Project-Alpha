package com.travel.bus.busticket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.travel.bus.R;
import com.travel.bus.busticket.a.n;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;

public class AJRBusPhotoViewActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajr_bus_photo_view);
        Intent intent = getIntent();
        if (!(intent == null || intent.getExtras() == null || intent.getExtras().getSerializable("photos") == null)) {
            n nVar = new n(this, (ArrayList) intent.getExtras().getSerializable("photos"));
            ViewPager viewPager = (ViewPager) findViewById(R.id.vpPhotos);
            viewPager.setAdapter(nVar);
            viewPager.setOffscreenPageLimit(3);
            viewPager.setCurrentItem(intent.getExtras().getInt("photo_position"), true);
        }
        findViewById(R.id.rvClose).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRBusPhotoViewActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }
}
