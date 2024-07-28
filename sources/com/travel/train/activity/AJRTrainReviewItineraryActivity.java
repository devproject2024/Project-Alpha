package com.travel.train.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.ab;
import com.travel.train.fragment.c;

public class AJRTrainReviewItineraryActivity extends CJRTrainBaseActivity implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private ab f26085a;

    /* renamed from: b  reason: collision with root package name */
    private j f26086b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_iteneray_screen);
        setSupportActionBar((Toolbar) findViewById(R.id.train_review_toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(getResources().getString(R.string.review_itinerary));
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainReviewItineraryActivity.this.onBackPressed();
            }
        });
        this.f26086b = getSupportFragmentManager();
        q a2 = this.f26086b.a();
        this.f26085a = ab.a(getIntent().getExtras());
        a2.b(R.id.fragment_container, this.f26085a, (String) null);
        a2.b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ab abVar;
        super.onActivityResult(i2, i3, intent);
        if ((i3 == -1 || i3 == 0) && (abVar = this.f26085a) != null) {
            abVar.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        ab abVar = this.f26085a;
        if (!(abVar != null ? abVar.onBackPressed() : false)) {
            super.onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void a() {
        ab abVar = this.f26085a;
        if (abVar != null) {
            abVar.s();
        }
    }
}
