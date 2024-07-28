package com.travel.flight.flightticket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.n;
import com.travel.flight.pojo.flightticket.a;
import com.travel.flight.pojo.flightticket.f;
import com.travel.utils.n;
import net.one97.paytm.activity.PaytmActivity;

public class AJRMultiAirlineMessageDisplay extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_multi_airline_message_display);
        Intent intent = getIntent();
        if (!intent.hasExtra("INTENT_EXTRA_MULTI_AIRLINE_MESSAGE")) {
            a();
            return;
        }
        f fVar = (f) intent.getSerializableExtra("INTENT_EXTRA_MULTI_AIRLINE_MESSAGE");
        if (fVar == null || fVar.getDistance() == null) {
            a();
            return;
        }
        a distance = fVar.getDistance();
        ((TextView) findViewById(R.id.text_view_multi_airline_tab_header)).setText(distance.getHeading());
        TextView textView = (TextView) findViewById(R.id.text_view_multi_airline_tab_sub_header_1);
        TextView textView2 = (TextView) findViewById(R.id.text_view_multi_airline_tab_sub_header_2);
        String[] tableHeader = distance.getTableHeader();
        if (tableHeader == null || tableHeader.length < 2) {
            textView.setText((CharSequence) null);
            textView2.setText((CharSequence) null);
        } else {
            textView.setText(tableHeader[0]);
            textView2.setText(tableHeader[1]);
        }
        ((RecyclerView) findViewById(R.id.rv_multi_airline_messages)).setAdapter(new n(LayoutInflater.from(this), distance.getTableRows()));
        ImageView imageView = (ImageView) findViewById(R.id.img_view_multi_airline_tab_close);
        ResourceUtils.loadFlightImagesFromCDN(imageView, "clear_recent.png", false, false, n.a.V1);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMultiAirlineMessageDisplay.this.b(view);
            }
        });
        findViewById(R.id.lyt_parent).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMultiAirlineMessageDisplay.this.a(view);
            }
        });
        findViewById(R.id.lyt_child).startAnimation(AnimationUtils.loadAnimation(this, R.anim.flight_anim_slide_in_from_bottom));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.flight_anim_slide_out_from_top);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AJRMultiAirlineMessageDisplay.this.finish();
                AJRMultiAirlineMessageDisplay.this.overridePendingTransition(0, 0);
            }
        });
        findViewById(R.id.lyt_child).startAnimation(loadAnimation);
    }

    public void onBackPressed() {
        a();
    }
}
