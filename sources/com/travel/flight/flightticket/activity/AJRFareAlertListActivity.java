package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.e;
import com.travel.flight.flightticket.e.l;
import com.travel.flight.flightticket.g.a;
import com.travel.flight.flightticket.i.d;
import com.travel.flight.pojo.flightticket.CJRViewFareAlerts;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.HashMap;
import java.util.List;

public class AJRFareAlertListActivity extends Activity implements View.OnClickListener, e.b, l.a, d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f24744a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRViewFareAlerts.a> f24745b;

    /* renamed from: c  reason: collision with root package name */
    private int f24746c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressDialog f24747d;

    /* renamed from: e  reason: collision with root package name */
    private a f24748e;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_activity_fare_alert_list);
        this.f24748e = new a(this);
        ((TextView) findViewById(R.id.txt_fare_alert_subscribed)).setText(String.format(getString(R.string.note_fare_alert_subscribed), new Object[]{getIntent().getStringExtra("citysearched")}));
        this.f24744a = (RecyclerView) findViewById(R.id.recycler_view_fare_alert);
        this.f24744a.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.f24744a.setItemAnimator(new g());
        findViewById(R.id.txt_fare_alert_list_add_alert).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.img_alert_list_back);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(this);
        findViewById(R.id.lyt_note_subscribed).setOnClickListener(this);
        findViewById(R.id.txt_fare_alert_list_terms).setOnClickListener(this);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) findViewById(R.id.img_fare_alert_list_bell), "bell_alert.png", false, false, n.a.V1);
        ((ImageView) findViewById(R.id.img_fare_alert_list_close)).setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        a aVar = this.f24748e;
        if (!b.c(aVar.f25004b.getApplicationContext())) {
            aVar.f25003a.c();
            return;
        }
        aVar.f25003a.a(aVar.f25004b.getApplicationContext().getString(R.string.pre_f_please_wait_progress_msg));
        Context applicationContext = aVar.f25004b.getApplicationContext();
        CJRViewFareAlerts cJRViewFareAlerts = new CJRViewFareAlerts();
        a.AnonymousClass1 r3 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                a.this.f25003a.b();
                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRViewFareAlerts)) {
                    a.this.f25003a.a(((CJRViewFareAlerts) iJRPaytmDataModel).getBody());
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a.a(a.this, networkCustomError);
                a.this.f25003a.b();
            }
        };
        if (applicationContext != null) {
            com.travel.flight.b.a();
            String E = com.travel.flight.b.b().E();
            if (URLUtil.isValidUrl(E)) {
                HashMap hashMap = new HashMap();
                hashMap.put("sso-token", com.paytm.utility.a.q(applicationContext));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = applicationContext.getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = applicationContext.getClass().getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = E;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = cJRViewFareAlerts;
                bVar.j = r3;
                bVar.t = null;
                com.paytm.network.a l = bVar.l();
                l.f42860d = true;
                l.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        q.a(this);
    }

    public final void a(List<CJRViewFareAlerts.a> list) {
        if (list.size() > 0) {
            this.f24745b = list;
            this.f24744a.setAdapter(new e(this, this, list));
            new androidx.recyclerview.widget.l(new l(this)).a(this.f24744a);
        }
    }

    public final void a() {
        com.travel.flight.flightticket.fragment.a.a();
        this.f24745b.remove(this.f24746c);
        this.f24744a.getAdapter().notifyDataSetChanged();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_fare_alert_list_add_alert) {
            startActivity(new Intent(this, AJRFareAlertSubscribeActivity.class));
            finish();
        } else if (id == R.id.img_alert_list_back) {
            onBackPressed();
        } else if (id == R.id.lyt_note_subscribed) {
            view.setVisibility(8);
        } else if (id == R.id.lyt_fare_alert_list_edit) {
            view.setVisibility(8);
        } else if (id == R.id.txt_fare_alert_list_edit) {
            findViewById(R.id.lyt_fare_alert_list_edit).setVisibility(8);
            Intent intent = new Intent(this, AJRFareAlertSubscribeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("fare_alert_obj", this.f24745b.get(this.f24746c));
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else if (id == R.id.txt_fare_alert_list_delete) {
            findViewById(R.id.lyt_fare_alert_list_edit).setVisibility(8);
            this.f24748e.a(this.f24745b.get(this.f24746c));
        } else if (id == R.id.txt_fare_alert_list_terms) {
            Intent intent2 = new Intent();
            com.travel.flight.b.a();
            intent2.putExtra("url", com.travel.flight.b.b().x());
            intent2.putExtra("title", getString(R.string.terms_and_conditions));
            com.travel.flight.b.a();
            com.travel.flight.b.b().f(this, intent2);
        }
    }

    public final void a(String str) {
        ProgressDialog progressDialog = this.f24747d;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f24747d = new ProgressDialog(this);
            try {
                this.f24747d.setProgressStyle(0);
                this.f24747d.setMessage(str);
                this.f24747d.setCancelable(false);
                this.f24747d.setCanceledOnTouchOutside(false);
                this.f24747d.show();
            } catch (Exception | IllegalArgumentException unused) {
            }
        }
    }

    public final void b() {
        try {
            if (this.f24747d != null && this.f24747d.isShowing() && !isFinishing()) {
                this.f24747d.dismiss();
                this.f24747d = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public final void a(int i2) {
        this.f24746c = i2;
        this.f24748e.a(this.f24745b.get(i2));
    }

    public void onBackPressed() {
        setResult(-1, new Intent());
        finish();
    }
}
