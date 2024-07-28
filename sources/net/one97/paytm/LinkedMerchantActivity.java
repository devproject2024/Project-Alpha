package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRDelinkMerchant;
import net.one97.paytm.common.entity.CJRLinkedMerchants;
import net.one97.paytm.common.entity.CJRMerchantEntity;
import net.one97.paytm.j.c;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.bb;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public class LinkedMerchantActivity extends PaytmActivity implements View.OnClickListener, b, n {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f51858a = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (LinkedMerchantActivity.this.f51863f != null) {
                    LinkedMerchantActivity.this.f51863f.dismiss();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LinkedMerchantActivity.this.f51866i);
                    OauthModule.b().sendGAMultipleLabelEvent(LinkedMerchantActivity.this, "apps_linked_with_paytm", "yes_clicked", arrayList, (String) null, "/apps_linked_with_paytm", p.f56796a);
                    LinkedMerchantActivity.c(LinkedMerchantActivity.this);
                    LinkedMerchantActivity.d(LinkedMerchantActivity.this);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f51859b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f51860c;

    /* renamed from: d  reason: collision with root package name */
    private x f51861d;

    /* renamed from: e  reason: collision with root package name */
    private List<CJRMerchantEntity> f51862e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public k f51863f;

    /* renamed from: g  reason: collision with root package name */
    private int f51864g;

    /* renamed from: h  reason: collision with root package name */
    private String f51865h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f51866i;
    private ImageView j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_linked_merchant);
        this.f51859b = (RecyclerView) findViewById(R.id.linked_merchant_rv);
        this.f51860c = (RelativeLayout) findViewById(R.id.no_merchant_rl);
        this.f51861d = new x(this.f51862e, this, this);
        this.f51859b.setLayoutManager(new LinearLayoutManager(this));
        this.f51859b.setHasFixedSize(true);
        this.f51859b.setAdapter(this.f51861d);
        this.j = (ImageView) findViewById(R.id.iv_back_arrow_lm);
        this.j.setOnClickListener(this);
        c.a();
        String a2 = c.a("get_authorised_merchant", (String) null);
        if (URLUtil.isValidUrl(a2) && !TextUtils.isEmpty(t.b((Context) this))) {
            String e2 = com.paytm.utility.b.e((Context) this, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", t.b((Context) this));
            hashMap.put("Authorization", com.paytm.utility.b.m());
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.AUTH;
            bVar.n = a.b.SILENT;
            bVar.o = LinkedMerchantActivity.class.getName();
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = e2;
            bVar.f42882f = hashMap;
            bVar.f42885i = new CJRLinkedMerchants();
            bVar.j = this;
            a l = bVar.l();
            if (com.paytm.utility.a.m(this)) {
                bb.a(this, getString(R.string.please_wait));
                l.a();
                return;
            }
            a(l, this);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back_arrow_lm) {
            onBackPressed();
        }
    }

    private void a(a aVar, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(context, aVar) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ a f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                LinkedMerchantActivity.this.a(this.f$1, this.f$2, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, a aVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (com.paytm.utility.a.m(context)) {
            bb.a(this, getString(R.string.please_wait));
            aVar.a();
            return;
        }
        a(aVar, context);
    }

    public final void a(String str, String str2, int i2) {
        this.f51865h = str;
        this.f51864g = i2;
        this.f51866i = str2;
        this.f51863f = new k(this, str2, this.f51858a);
        this.f51863f.setCanceledOnTouchOutside(true);
        this.f51863f.show();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        bb.a(this);
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRLinkedMerchants) {
            CJRLinkedMerchants cJRLinkedMerchants = (CJRLinkedMerchants) iJRPaytmDataModel;
            if (cJRLinkedMerchants == null || cJRLinkedMerchants.getClients() == null) {
                this.f51860c.setVisibility(0);
                this.f51859b.setVisibility(8);
                return;
            }
            this.f51860c.setVisibility(8);
            this.f51859b.setVisibility(0);
            this.f51862e = cJRLinkedMerchants.getClients();
            this.f51861d = new x(this.f51862e, this, this);
            this.f51859b.setAdapter(this.f51861d);
            this.f51861d.notifyDataSetChanged();
        } else if (iJRPaytmDataModel instanceof CJRDelinkMerchant) {
            this.f51862e.remove(this.f51864g);
            this.f51861d.notifyDataSetChanged();
            if (this.f51862e.size() == 0) {
                this.f51860c.setVisibility(0);
                this.f51859b.setVisibility(8);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        bb.a(this);
        if (networkCustomError.getStatusCode() == 200) {
            List<CJRMerchantEntity> list = this.f51862e;
            if (list == null || list.size() == 0) {
                this.f51860c.setVisibility(0);
                this.f51859b.setVisibility(8);
                return;
            }
            return;
        }
        r.a((Activity) this, (Exception) networkCustomError, LinkedMerchantActivity.class.getName(), (Bundle) null);
    }

    public void onDestroy() {
        bb.a(this);
        super.onDestroy();
    }

    static /* synthetic */ void c(LinkedMerchantActivity linkedMerchantActivity) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_account_subscriptions_tab_name", "Merchants linked with Paytm account");
        hashMap.put("user_account_subscriptions_merchant_name", linkedMerchantActivity.f51866i);
        net.one97.paytm.j.a.b("user_account_subscriptions_delink_wallet_clicked", (Map<String, Object>) hashMap, (Context) linkedMerchantActivity);
    }

    static /* synthetic */ void d(LinkedMerchantActivity linkedMerchantActivity) {
        c.a();
        String a2 = c.a("delete_authorised_merchant", (String) null);
        if (URLUtil.isValidUrl(a2) && !TextUtils.isEmpty(t.b((Context) linkedMerchantActivity))) {
            String e2 = com.paytm.utility.b.e((Context) linkedMerchantActivity, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", t.b((Context) linkedMerchantActivity));
            hashMap.put("clientId", linkedMerchantActivity.f51865h);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = linkedMerchantActivity;
            bVar.f42878b = a.c.AUTH;
            bVar.n = a.b.SILENT;
            bVar.o = LinkedMerchantActivity.class.getName();
            bVar.f42879c = a.C0715a.DELETE;
            bVar.f42880d = e2;
            bVar.f42882f = hashMap;
            bVar.f42885i = new CJRDelinkMerchant();
            bVar.j = linkedMerchantActivity;
            a l = bVar.l();
            if (com.paytm.utility.a.m(linkedMerchantActivity)) {
                bb.a(linkedMerchantActivity, linkedMerchantActivity.getString(R.string.please_wait));
                l.a();
                return;
            }
            linkedMerchantActivity.a(l, linkedMerchantActivity);
        }
    }
}
