package net.one97.paytm.o2o.movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.b;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.Serializable;
import net.one97.paytm.common.c.a;
import net.one97.paytm.o2o.movies.R;

public class AJRFullMapDetailActivity extends AppBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f73989a = null;

    public void onCreate(Bundle bundle) {
        Serializable serializableExtra;
        super.onCreate(bundle);
        setContentView(R.layout.layout_map_activity);
        Intent intent = getIntent();
        if (!(intent == null || (serializableExtra = intent.getSerializableExtra(a.MAP_DATA_INTENT_KEY)) == null || !(serializableExtra instanceof a))) {
            this.f73989a = (a) serializableExtra;
        }
        a aVar = this.f73989a;
        if (aVar != null) {
            String addressHeader = aVar.getAddressHeader();
            if (addressHeader != null && !TextUtils.isEmpty(addressHeader)) {
                ((TextView) findViewById(R.id.txt_view_full_map_address_header)).setText(addressHeader);
            }
            String addressText = this.f73989a.getAddressText();
            if (addressText != null && !TextUtils.isEmpty(addressText)) {
                ((TextView) findViewById(R.id.txt_view_full_map_address_text)).setText(addressText);
            }
        }
        if (this.f73989a != null) {
            try {
                SupportMapFragment a2 = SupportMapFragment.a();
                getSupportFragmentManager().a().a(R.id.location_map, a2, "").b();
                a2.a(new e() {
                    public final void a(c cVar) {
                        LatLng latLng = new LatLng(AJRFullMapDetailActivity.this.f73989a.getAddressLatitue(), AJRFullMapDetailActivity.this.f73989a.getAddressLongitude());
                        cVar.a(AJRFullMapDetailActivity.a(latLng));
                        cVar.a(b.a(latLng, 12.0f), new c.a() {
                        });
                    }
                });
            } catch (Exception unused) {
            }
        }
        findViewById(R.id.id_fnb_dialog_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRFullMapDetailActivity.this.onBackPressed();
            }
        });
    }

    static /* synthetic */ MarkerOptions a(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.a(latLng);
        return markerOptions;
    }
}
