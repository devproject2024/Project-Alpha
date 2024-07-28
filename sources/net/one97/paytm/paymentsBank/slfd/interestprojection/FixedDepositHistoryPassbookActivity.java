package net.one97.paytm.paymentsBank.slfd.interestprojection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.common.view.d;
import net.one97.paytm.paymentsBank.slfd.interestprojection.a.c;
import net.one97.paytm.paymentsBank.utils.j;

public class FixedDepositHistoryPassbookActivity extends PaytmActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f19136a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f19137b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19138c;

    /* renamed from: d  reason: collision with root package name */
    private c f19139d;

    /* renamed from: e  reason: collision with root package name */
    private String f19140e;

    /* renamed from: f  reason: collision with root package name */
    private String f19141f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19142g;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(f.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        Uri parse;
        super.onCreate(bundle);
        setContentView(R.layout.a_fixed_deposit_passbook);
        findViewById(R.id.tv_know_more).setOnClickListener(this);
        findViewById(R.id.tv_view_interest_table).setOnClickListener(this);
        findViewById(R.id.iv_back_arrow).setOnClickListener(this);
        this.f19136a = (RecyclerView) findViewById(R.id.rv_fixed_deposit_history);
        View findViewById = findViewById(R.id.rl_manage_fd);
        findViewById.setOnClickListener(this);
        if (j.b()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.f19136a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19136a.setNestedScrollingEnabled(false);
        this.f19139d = new c(this, ((SlfdTransactionModel) getIntent().getSerializableExtra("extra_slfd_transaction_model")).getTransactionList());
        this.f19136a.setAdapter(this.f19139d);
        this.f19136a.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                int childCount = FixedDepositHistoryPassbookActivity.this.f19136a.getLayoutManager().getChildCount();
                int itemCount = FixedDepositHistoryPassbookActivity.this.f19136a.getLayoutManager().getItemCount();
                int findFirstVisibleItemPosition = ((LinearLayoutManager) FixedDepositHistoryPassbookActivity.this.f19136a.getLayoutManager()).findFirstVisibleItemPosition();
                if (!FixedDepositHistoryPassbookActivity.this.f19137b && !FixedDepositHistoryPassbookActivity.this.f19138c && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    boolean unused = FixedDepositHistoryPassbookActivity.this.f19137b = true;
                    FixedDepositHistoryPassbookActivity.e(FixedDepositHistoryPassbookActivity.this);
                }
            }
        });
        if (getIntent().hasExtra("deeplink")) {
            this.f19141f = getIntent().getStringExtra("deeplink");
            if (!v.a(this.f19141f) && (parse = Uri.parse(this.f19141f)) != null && parse.getQueryParameter("featuretype") != null) {
                parse.getQueryParameter("featuretype");
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
            SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
            if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(slfdTransactionModel.getStatus())) {
                b.b((Context) this, getString(R.string.error), slfdTransactionModel.getMessage());
            } else if (slfdTransactionModel != null && slfdTransactionModel.getTransactionList() != null && slfdTransactionModel.getTransactionList().size() > 0) {
                if (slfdTransactionModel.isLastPage()) {
                    this.f19138c = true;
                }
                try {
                    this.f19140e = slfdTransactionModel.getTransactionList().get(slfdTransactionModel.getTransactionList().size() - 1).getOrderId();
                } catch (Exception unused) {
                }
                this.f19139d.a(slfdTransactionModel.getTransactionList());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_know_more) {
            startActivity(new Intent(this, FixedDepositOfferingActivity.class));
        } else if (view.getId() == R.id.tv_view_interest_table) {
            new d().show(getSupportFragmentManager(), "itTableBottomSheet");
        } else if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        } else if (view.getId() == R.id.rl_manage_fd) {
            try {
                net.one97.paytm.paymentsBank.slfd.a.a.b.a aVar = new net.one97.paytm.paymentsBank.slfd.a.a.b.a(this);
                String a2 = j.a();
                b.k(this, getString(R.string.please_wait));
                aVar.a((Context) this, (g.b<IJRPaytmDataModel>) new g.b() {
                    public final void onResponse(Object obj) {
                        FixedDepositHistoryPassbookActivity.this.a((IJRPaytmDataModel) obj);
                    }
                }, (g.a) $$Lambda$FixedDepositHistoryPassbookActivity$zYg_Wo7ocgNqp1SmmNRKlmDOniM.INSTANCE, a2);
            } catch (Exception e2) {
                b.p();
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRPaytmDataModel iJRPaytmDataModel) {
        b.p();
        if (!(iJRPaytmDataModel instanceof CustProductStatus)) {
            return;
        }
        if (!((CustProductStatus) iJRPaytmDataModel).getPanRec().equals("Y")) {
            a(false);
        } else {
            a(true);
        }
    }

    public void onPause() {
        super.onPause();
        this.f19142g = false;
    }

    public void onStop() {
        super.onStop();
        this.f19142g = false;
    }

    public void onResume() {
        super.onResume();
        this.f19142g = true;
    }

    private void a(boolean z) {
        try {
            if (this.f19142g) {
                net.one97.paytm.paymentsBank.form15g.a.b bVar = new net.one97.paytm.paymentsBank.form15g.a.b();
                Bundle bundle = new Bundle();
                bundle.putBoolean("show_tds", z);
                bundle.putBoolean("show_ic", true);
                if (!v.a(this.f19141f)) {
                    bundle.putString("deeplink", this.f19141f);
                }
                bVar.setArguments(bundle);
                bVar.show(getSupportFragmentManager(), bVar.getTag());
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void e(FixedDepositHistoryPassbookActivity fixedDepositHistoryPassbookActivity) {
        if (b.c((Context) fixedDepositHistoryPassbookActivity)) {
            new net.one97.paytm.paymentsBank.slfd.a.a.b.a(fixedDepositHistoryPassbookActivity).a((g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    FixedDepositHistoryPassbookActivity.this.b((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    FixedDepositHistoryPassbookActivity.this.b(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, "A", fixedDepositHistoryPassbookActivity.f19140e);
        }
    }
}
