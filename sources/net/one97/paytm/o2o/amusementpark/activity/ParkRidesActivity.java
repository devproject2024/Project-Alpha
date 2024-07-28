package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.a.o;
import net.one97.paytm.o2o.amusementpark.utils.m;

public class ParkRidesActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f73396a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f73397b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f73398c;

    /* renamed from: d  reason: collision with root package name */
    private o f73399d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f73400e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.am_park_rides_layout);
        this.f73396a = (Toolbar) findViewById(R.id.toolbar);
        this.f73397b = (ImageView) this.f73396a.findViewById(R.id.back_arrow);
        this.f73397b.setOnClickListener(this);
        this.f73398c = (RoboTextView) this.f73396a.findViewById(R.id.toolbar_title);
        this.f73398c.setText(getResources().getString(R.string.rides));
        this.f73400e = (RecyclerView) findViewById(R.id.recylerView);
        ArrayList arrayList = (getIntent() == null || getIntent().getExtras() == null) ? null : (ArrayList) getIntent().getExtras().getSerializable("rides_key");
        if (arrayList != null && arrayList.size() > 0) {
            this.f73399d = new o(this, arrayList);
            this.f73400e.setLayoutManager(new LinearLayoutManager(this));
            this.f73400e.setAdapter(this.f73399d);
        }
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
