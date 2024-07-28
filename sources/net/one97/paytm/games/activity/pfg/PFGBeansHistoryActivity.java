package net.one97.paytm.games.activity.pfg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import net.one97.paytm.games.R;
import net.one97.paytm.games.a.a.a;
import net.one97.paytm.games.activity.GpBaseActivity;

public class PFGBeansHistoryActivity extends GpBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private final String f35550b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private ImageView f35551c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f35552d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f35553e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gpbeans_history);
        a((Activity) this);
        this.f35551c = (ImageView) findViewById(R.id.back);
        this.f35552d = (TextView) findViewById(R.id.tv_title);
        this.f35553e = (ViewPager) findViewById(R.id.view_pager);
        this.f35551c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PFGBeansHistoryActivity.this.a(view);
            }
        });
        this.f35552d.setText(getString(R.string.points_history));
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.all));
        arrayList.add(getString(R.string.earned));
        arrayList.add(getString(R.string.spent));
        arrayList.isEmpty();
        this.f35553e.setAdapter(new a(getSupportFragmentManager()));
        this.f35553e.setOffscreenPageLimit(3);
        this.f35553e.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }
}
