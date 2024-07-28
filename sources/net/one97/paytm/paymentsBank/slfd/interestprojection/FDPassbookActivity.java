package net.one97.paytm.paymentsBank.slfd.interestprojection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.slfd.common.view.d;
import net.one97.paytm.paymentsBank.slfd.interestprojection.a.c;

public class FDPassbookActivity extends PaytmActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f19121a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f19122b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19123c;

    /* renamed from: d  reason: collision with root package name */
    private c f19124d;

    /* renamed from: e  reason: collision with root package name */
    private String f19125e;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(f.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.a_fd_history_passbook);
        findViewById(R.id.iv_back_arrow).setOnClickListener(this);
        this.f19121a = (RecyclerView) findViewById(R.id.rv_fixed_deposit_history);
        this.f19121a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19121a.setNestedScrollingEnabled(false);
        SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) getIntent().getSerializableExtra("extra_slfd_transaction_model");
        try {
            this.f19125e = slfdTransactionModel.getTransactionList().get(slfdTransactionModel.getTransactionList().size() - 1).getOrderId();
        } catch (Exception unused) {
        }
        this.f19124d = new c(this, slfdTransactionModel.getTransactionList());
        this.f19121a.setAdapter(this.f19124d);
        this.f19121a.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                int childCount = FDPassbookActivity.this.f19121a.getLayoutManager().getChildCount();
                int itemCount = FDPassbookActivity.this.f19121a.getLayoutManager().getItemCount();
                int findFirstVisibleItemPosition = ((LinearLayoutManager) FDPassbookActivity.this.f19121a.getLayoutManager()).findFirstVisibleItemPosition();
                if (!FDPassbookActivity.this.f19122b && !FDPassbookActivity.this.f19123c && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0) {
                    boolean unused = FDPassbookActivity.this.f19122b = true;
                    FDPassbookActivity.e(FDPassbookActivity.this);
                }
            }
        });
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SlfdTransactionModel) {
            SlfdTransactionModel slfdTransactionModel = (SlfdTransactionModel) iJRPaytmDataModel;
            if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(slfdTransactionModel.getStatus())) {
                b.b((Context) this, getString(R.string.error), slfdTransactionModel.getMessage());
                return;
            } else if (!(slfdTransactionModel == null || slfdTransactionModel.getTransactionList() == null || slfdTransactionModel.getTransactionList().size() <= 0)) {
                if (slfdTransactionModel.isLastPage()) {
                    this.f19123c = true;
                }
                try {
                    this.f19125e = slfdTransactionModel.getTransactionList().get(slfdTransactionModel.getTransactionList().size() - 1).getOrderId();
                } catch (Exception unused) {
                }
                this.f19124d.a(slfdTransactionModel.getTransactionList());
            }
        }
        this.f19122b = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
        } catch (Exception unused) {
        }
        this.f19122b = false;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_know_more) {
            startActivity(new Intent(this, FixedDepositOfferingActivity.class));
        } else if (view.getId() == R.id.tv_view_interest_table) {
            new d().show(getSupportFragmentManager(), "itTableBottomSheet");
        } else if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        }
    }

    static /* synthetic */ void e(FDPassbookActivity fDPassbookActivity) {
        if (b.c((Context) fDPassbookActivity)) {
            new net.one97.paytm.paymentsBank.slfd.a.a.b.a(fDPassbookActivity).a((g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    FDPassbookActivity.this.a((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    FDPassbookActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, "A", fDPassbookActivity.f19125e);
        }
    }
}
