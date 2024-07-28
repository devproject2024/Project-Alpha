package net.one97.paytm.paymentsBank.nach.landing;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.u;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.nach.NachMandateResponse;
import net.one97.paytm.paymentsBank.model.nach.Payload;
import net.one97.paytm.paymentsBank.nach.landing.adapter.SectionListItem;

public class PBNachRequestListActivity extends PBBaseActivity implements View.OnClickListener, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f18568b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.nach.landing.adapter.a f18569c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f18570d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f18571e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f18572f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f18573g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressDialog f18574h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Toolbar f18575i;
    private a j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_nach_pending_req_list);
        this.f18568b = (RecyclerView) findViewById(R.id.nachRequestList);
        this.f18568b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f18569c = new net.one97.paytm.paymentsBank.nach.landing.adapter.a(this);
        this.f18568b.setAdapter(this.f18569c);
        u.c((View) this.f18568b, false);
        this.f18571e = (ViewGroup) findViewById(R.id.normalLayout);
        this.f18572f = (ViewGroup) findViewById(R.id.loaderLayout);
        this.f18570d = (LottieAnimationView) findViewById(R.id.loader);
        this.f18573g = findViewById(R.id.noItemTv);
        this.f18575i = (Toolbar) findViewById(R.id.toolbar);
        findViewById(R.id.back_arrow).setOnClickListener(this);
        ((ImageView) findViewById(R.id.tool_bar_back)).setOnClickListener(this);
        final float dimension = getResources().getDimension(R.dimen.dimen_10dp);
        ((AppBarLayout) findViewById(R.id.appbar_ll)).a((AppBarLayout.b) new AppBarLayout.b() {

            /* renamed from: a  reason: collision with root package name */
            boolean f18576a = false;

            /* renamed from: b  reason: collision with root package name */
            int f18577b = -1;

            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                if (i2 == 0 || ((float) Math.abs(i2)) < ((float) appBarLayout.getTotalScrollRange()) - dimension) {
                    PBNachRequestListActivity.this.f18575i.setVisibility(8);
                } else {
                    PBNachRequestListActivity.this.f18575i.setVisibility(0);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f c2 = net.one97.paytm.paymentsBank.b.a.c(this, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (!b.c((Context) this) || c2 == null) {
            a(c2, "");
            return;
        }
        LottieAnimationView lottieAnimationView = this.f18570d;
        this.f18572f.setVisibility(0);
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
        new c();
        c.a(c2);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing()) {
            a(this.f18570d);
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof NachMandateResponse)) {
                List<Payload> payload = ((NachMandateResponse) iJRPaytmDataModel).getPayload();
                e();
                if (payload == null || payload.size() <= 0) {
                    this.f18569c.a();
                    this.f18573g.setVisibility(0);
                    this.f18571e.setVisibility(8);
                    return;
                }
                this.j = new a();
                this.j.execute(new List[]{payload});
            }
        }
    }

    private void e() {
        a aVar = this.j;
        if (aVar != null && !aVar.isCancelled()) {
            this.j.cancel(true);
            this.j = null;
        }
    }

    public void onDestroy() {
        e();
        super.onDestroy();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            a(this.f18570d);
            this.f18571e.setVisibility(8);
            net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
        this.f18572f.setVisibility(8);
    }

    private void a(f fVar, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(str, fVar) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ f f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                PBNachRequestListActivity.this.a(this.f$1, this.f$2, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, f fVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (b.c((Context) this)) {
            a((Context) this, str);
            getApplicationContext();
            new c();
            c.a(fVar);
            return;
        }
        a(fVar, str);
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.f18574h;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f18574h = new ProgressDialog(context);
                try {
                    this.f18574h.setProgressStyle(0);
                    this.f18574h.setMessage(str);
                    this.f18574h.setCancelable(false);
                    this.f18574h.setCanceledOnTouchOutside(false);
                    this.f18574h.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void ah_() {
        try {
            if (this.f18574h != null && this.f18574h.isShowing() && !isFinishing()) {
                this.f18574h.dismiss();
                this.f18574h = null;
            }
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tool_bar_back || id == R.id.back_arrow) {
            onBackPressed();
        }
    }

    class a extends AsyncTask<List<Payload>, Void, List<SectionListItem>> {
        a() {
        }

        /* access modifiers changed from: protected */
        @SafeVarargs
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            String string = PBNachRequestListActivity.this.getString(R.string.pb_nach_recurring_payment);
            String string2 = PBNachRequestListActivity.this.getString(R.string.pb_nach_cancelled_payment);
            String string3 = PBNachRequestListActivity.this.getString(R.string.pb_nach_rejected_payment);
            for (Payload payload : ((List[]) objArr)[0]) {
                if ("PENDING".equalsIgnoreCase(payload.getStatus())) {
                    arrayList.add(new SectionListItem(payload));
                } else if ("ACCEPTED".equalsIgnoreCase(payload.getStatus())) {
                    arrayList2.add(new SectionListItem(payload));
                } else if (TxNotifyData.UPI_STATUS_CANCELLED.equalsIgnoreCase(payload.getStatus())) {
                    arrayList3.add(new SectionListItem(payload));
                } else if ("REJECTED".equalsIgnoreCase(payload.getStatus())) {
                    arrayList4.add(new SectionListItem(payload));
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new SectionListItem(true, string));
                arrayList.addAll(arrayList2);
            }
            if (arrayList4.size() > 0) {
                arrayList.add(new SectionListItem(true, string3));
                arrayList.addAll(arrayList4);
            }
            if (arrayList3.size() > 0) {
                arrayList.add(new SectionListItem(true, string2));
                arrayList.addAll(arrayList3);
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            if (!PBNachRequestListActivity.this.isFinishing()) {
                super.onPostExecute(list);
                if (list.size() > 0) {
                    PBNachRequestListActivity.this.f18571e.setVisibility(0);
                    PBNachRequestListActivity.this.f18573g.setVisibility(8);
                    PBNachRequestListActivity.this.f18569c.a();
                    PBNachRequestListActivity.this.f18569c.a(list);
                    return;
                }
                PBNachRequestListActivity.this.f18573g.setVisibility(0);
                PBNachRequestListActivity.this.f18571e.setVisibility(8);
            }
        }
    }
}
