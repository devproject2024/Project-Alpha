package com.travel.train.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.r;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainTicketStatusGuide;
import com.travel.train.model.trainticket.CJRTrainTicketStatusGuideTemplate;
import java.util.ArrayList;
import java.util.HashMap;

public class AJRTrainTicketStatusGuide extends CJRTrainBaseActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f26126a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f26127b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainTicketStatusGuide f26128c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ajrtrain_ticket_status_guide);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().c(false);
        this.f26126a = (ImageView) findViewById(R.id.back_arrow);
        this.f26126a.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.f26126a.setRotation(180.0f);
        this.f26126a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainTicketStatusGuide.this.finish();
            }
        });
        this.f26127b = (RecyclerView) findViewById(R.id.ticket_status_guide_list);
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        com.travel.train.b.a();
        String M = com.travel.train.b.b().M();
        if (!URLUtil.isValidUrl(M)) {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url_train));
            return;
        }
        showProgressDialog(this, getString(R.string.please_wait_progress_msg));
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, a.q(this));
        String b2 = o.b((Context) this, com.paytm.utility.b.s(this, M));
        if (com.paytm.utility.b.c((Context) this)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.n;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = hashMap;
            bVar.f42885i = new CJRTrainTicketStatusGuide();
            bVar.j = this;
            com.paytm.network.a l = bVar.l();
            l.f42859c = false;
            l.a();
            return;
        }
        removeProgressDialog();
        b();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        removeProgressDialog();
        if (iJRPaytmDataModel instanceof CJRTrainTicketStatusGuide) {
            this.f26128c = (CJRTrainTicketStatusGuide) iJRPaytmDataModel;
            if (this.f26128c != null) {
                ArrayList<CJRTrainTicketStatusGuideTemplate> arrayList = new ArrayList<>();
                if (this.f26128c.getBody() != null) {
                    arrayList = this.f26128c.getBody().getTemplates();
                }
                if (arrayList != null && arrayList.size() > 0) {
                    this.f26127b.setLayoutManager(new LinearLayoutManager(this, 1, false));
                    this.f26127b.setAdapter(new r(this, arrayList));
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        removeProgressDialog();
    }

    private void b() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet_train));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    AJRTrainTicketStatusGuide.this.a();
                }
            });
            builder.show();
        }
    }
}
