package net.one97.paytm.passbook.spendanalytics.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.customview.b;
import net.one97.paytm.passbook.spendanalytics.a.d;
import net.one97.paytm.passbook.spendanalytics.model.Response;
import net.one97.paytm.passbook.utility.c;

public class SpendsByCategoryActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_spends_by_category);
        Response response = (Response) getIntent().getSerializableExtra("spends_by_category_item");
        String stringExtra = getIntent().getStringExtra("view_pager_selected_month");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.travelRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new d(this, response, stringExtra));
        ((ImageButton) findViewById(R.id.backArrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SpendsByCategoryActivity.this.a(view);
            }
        });
        ((TextView) findViewById(R.id.categoryName)).setText(response.getDistribution().getKey());
        ((TextView) findViewById(R.id.amount)).setText("You Spent " + getString(R.string.pass_rs_symbol) + c.c(response.getDistribution().getSum()).replace(".00", ""));
        w.a().a(response.getDistribution().getLogo()).a((ah) new b()).a((ImageView) findViewById(R.id.categoryIcon), (e) null);
        TextView textView = (TextView) findViewById(R.id.noOfPayments);
        if (response.getDistribution().getCnt().equals("1")) {
            textView.setText(response.getDistribution().getCnt() + " PAYMENT");
            return;
        }
        textView.setText(response.getDistribution().getCnt() + " PAYMENTS");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }
}
