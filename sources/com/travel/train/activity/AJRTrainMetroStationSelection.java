package com.travel.train.activity;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.i;

public class AJRTrainMetroStationSelection extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private i f26022a;

    /* renamed from: b  reason: collision with root package name */
    private j f26023b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_action_bar_layout);
        View findViewById = findViewById(R.id.base_toolbar);
        View findViewById2 = findViewById(R.id.view_separator_bottom);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        this.f26023b = getSupportFragmentManager();
        q a2 = this.f26023b.a();
        this.f26022a = new i();
        this.f26022a.setArguments(getIntent().getBundleExtra("intent_metro_station_data"));
        a2.b(R.id.content_frame, this.f26022a, (String) null);
        a2.b();
    }
}
