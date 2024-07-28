package com.travel.flight.flightticket.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.google.android.material.tabs.TabLayout;
import com.travel.flight.R;

public class CJRFlightCustomTabLayout extends TabLayout {
    private Context y;
    private ViewPager z;

    public CJRFlightCustomTabLayout(Context context) {
        super(context);
        this.y = context;
        d();
    }

    public CJRFlightCustomTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = context;
        d();
    }

    public CJRFlightCustomTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.y = context;
        d();
    }

    public void setupWithViewPager(ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        this.z = viewPager;
        a(viewPager);
        viewPager.addOnAdapterChangeListener(new ViewPager.d(viewPager) {
            private final /* synthetic */ ViewPager f$1;

            {
                this.f$1 = r2;
            }

            public final void onAdapterChanged(ViewPager viewPager, a aVar, a aVar2) {
                CJRFlightCustomTabLayout.this.a(this.f$1, viewPager, aVar, aVar2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ViewPager viewPager, ViewPager viewPager2, a aVar, a aVar2) {
        new Handler().post(new Runnable(viewPager) {
            private final /* synthetic */ ViewPager f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CJRFlightCustomTabLayout.this.a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setCustomTabs */
    public void a(ViewPager viewPager) {
        for (int i2 = 0; i2 < getTabCount(); i2++) {
            TabLayout.f a2 = a(i2);
            if (viewPager.getCurrentItem() == i2) {
                c(a2, true);
            } else {
                c(a2, false);
            }
        }
    }

    private void d() {
        a((TabLayout.b) new TabLayout.c() {
            public final void onTabReselected(TabLayout.f fVar) {
            }

            public final void onTabSelected(TabLayout.f fVar) {
                CJRFlightCustomTabLayout.this.c(fVar, true);
            }

            public final void onTabUnselected(TabLayout.f fVar) {
                CJRFlightCustomTabLayout.this.c(fVar, false);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TabLayout.f fVar, View view) {
        this.z.setCurrentItem(fVar.f36765e);
    }

    /* access modifiers changed from: private */
    public void c(TabLayout.f fVar, boolean z2) {
        String charSequence = fVar.f36763c.toString();
        TextView textView = (TextView) fVar.f36766f;
        if (textView == null) {
            textView = (TextView) LayoutInflater.from(this.y).inflate(R.layout.pre_f_flight_home_custom_tab_view, (ViewGroup) null, false);
            textView.setText(charSequence);
            textView.setOnClickListener(new View.OnClickListener(fVar) {
                private final /* synthetic */ TabLayout.f f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CJRFlightCustomTabLayout.this.a(this.f$1, view);
                }
            });
            fVar.a((View) textView);
        }
        textView.setTextColor(this.y.getResources().getColor(z2 ? R.color.movies_promo_text_color : R.color.payment_success_text_black));
        textView.setTypeface(textView.getTypeface(), 1);
    }
}
