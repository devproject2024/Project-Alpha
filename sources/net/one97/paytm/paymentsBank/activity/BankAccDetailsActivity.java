package net.one97.paytm.paymentsBank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.a;
import net.one97.paytm.paymentsBank.utils.o;

public class BankAccDetailsActivity extends PBBaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private String f17363b;

    /* renamed from: c  reason: collision with root package name */
    private IsaDetailsModel f17364c;

    /* renamed from: d  reason: collision with root package name */
    private CustProductList f17365d;

    /* renamed from: e  reason: collision with root package name */
    private NomineeModel f17366e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17367f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_acc_details);
        setTitle(getString(R.string.pb_savings_account));
        ag_();
        TextView textView = (TextView) findViewById(R.id.tv_nominee);
        findViewById(R.id.lyt_acc_nominee).setOnClickListener(this);
        findViewById(R.id.lyt_debit_card).setOnClickListener(this);
        findViewById(R.id.lyt_passbook).setOnClickListener(this);
        findViewById(R.id.lyt_receive_money).setOnClickListener(this);
        findViewById(R.id.lyt_add_money).setOnClickListener(this);
        findViewById(R.id.lyt_money_transfer).setOnClickListener(this);
        findViewById(R.id.lyt_cheque_demand_draft).setOnClickListener(this);
        if (getIntent() != null) {
            this.f17363b = getIntent().getStringExtra("ACCOUNT_NUMBER");
            this.f17364c = (IsaDetailsModel) getIntent().getSerializableExtra("ISA_DETAILS");
            this.f17365d = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
        }
        a aVar = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("ISA_DETAILS", this.f17364c);
        bundle2.putBoolean("SHOW_MOTIF", true);
        aVar.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.activity_bank_acc_details_lyt_card, aVar, (String) null).c();
        IsaDetailsModel isaDetailsModel = this.f17364c;
        if (isaDetailsModel == null || isaDetailsModel.getNomineeList() == null || this.f17364c.getNomineeList().size() <= 0) {
            this.f17367f = false;
            textView.setText(getString(R.string.pb_add_nominee));
            return;
        }
        textView.setText(getString(R.string.acc_nominee));
        this.f17367f = true;
        this.f17366e = this.f17364c.getNomineeList().get(0);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lyt_debit_card) {
            Intent intent = new Intent(this, ManageDebitCardActivity.class);
            intent.putExtra("CUST_PRODUCT", this.f17365d);
            startActivity(intent);
        } else if (id == R.id.lyt_passbook) {
            Intent intent2 = new Intent(this, o.a().getPassbookMainActivityClass());
            intent2.putExtra("outerTab", 2);
            startActivity(intent2);
        } else if (id == R.id.lyt_acc_nominee) {
            if (this.f17367f) {
                Intent intent3 = new Intent(this, AJRNomineeDetails.class);
                intent3.putExtra("NOMINEE_ITEM", this.f17366e);
                startActivity(intent3);
                return;
            }
            Intent intent4 = new Intent(this, PaymentsBankBaseActivity.class);
            intent4.putExtra("extraDefaultFrame", 2);
            intent4.putExtra("DO_CREATE_ACCOUNT", false);
            intent4.putExtra("ACCOUNT_NUMBER", this.f17363b);
            startActivityForResult(intent4, 201);
        } else if (id == R.id.lyt_money_transfer) {
            startActivity(new Intent(this, o.a().getMoneyTransferActivityClass()));
        } else if (id == R.id.lyt_add_money) {
        } else {
            if (id == R.id.lyt_receive_money) {
                Intent intent5 = new Intent(this, ReceiveMoneyActivity.class);
                intent5.putExtra("ISA_DETAILS", this.f17364c);
                startActivity(intent5);
            } else if (id == R.id.lyt_cheque_demand_draft) {
                startActivity(new Intent(this, ChequeBookDDActivity.class));
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1) {
            Intent intent2 = new Intent(this, o.a().getMainActivityClass());
            intent2.setFlags(67108864);
            intent2.putExtra("open_bank_tab", true);
            startActivity(intent2);
            finish();
        }
    }
}
