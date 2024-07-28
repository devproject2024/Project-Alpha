package net.one97.paytm.recharge.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRPaymentOptions;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.x;

public class AJRAmountSelectionActivity extends CJRRechargeBaseActivity implements View.OnClickListener, x.c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRPaymentOptions> f60736a;

    /* renamed from: b  reason: collision with root package name */
    private CJRPaymentOptions f60737b;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_amount_selection);
        this.s = true;
        Intent intent = getIntent();
        if (intent != null) {
            this.f60736a = (ArrayList) intent.getSerializableExtra("intent_extra_payment_options");
            this.f60737b = (CJRPaymentOptions) intent.getSerializableExtra("intent_extra_selected_amount");
            if (this.f60737b == null) {
                ArrayList<CJRPaymentOptions> arrayList = this.f60736a;
                this.f60737b = arrayList.get(arrayList.size() - 1);
            }
        }
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_amount_list);
        expandableListView.setAdapter(new x(this, this, expandableListView, this.f60736a, this.f60737b));
        findViewById(R.id.amount_selection_confirm_btn).setOnClickListener(this);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        setTitle(getString(R.string.title_activity_amount_selection));
        return super.onPrepareOptionsMenu(menu);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.amount_selection_confirm_btn) {
            Intent intent = new Intent();
            intent.putExtra("intent_extra_selected_amount", this.f60737b);
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(CJRPaymentOptions cJRPaymentOptions) {
        this.f60737b = cJRPaymentOptions;
    }
}
