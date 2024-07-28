package com.travel.train.activity;

import android.os.Bundle;
import androidx.fragment.app.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.am;
import com.travel.train.fragment.h;

public class AJRSearchByTrainResultActivity extends CJRTrainBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ls_search_trains_layout);
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.fragment_container, h.a(getIntent().getExtras()), h.class.getSimpleName());
        a2.c();
    }

    public void onBackPressed() {
        am amVar = (am) getSupportFragmentManager().c(h.class.getSimpleName());
        if (!(amVar != null ? amVar.onBackPressed() : false)) {
            super.onBackPressed();
        }
    }
}
