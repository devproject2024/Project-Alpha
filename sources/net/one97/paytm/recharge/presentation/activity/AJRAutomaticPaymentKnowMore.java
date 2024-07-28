package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.c.a.a;

public class AJRAutomaticPaymentKnowMore extends PaytmActivity {
    public void attachBaseContext(Context context) {
        a aVar = a.f60256a;
        super.attachBaseContext(a.a(context));
    }

    public void onCreate(Bundle bundle) {
        final String[] strArr;
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrautomatic_payment_know_more);
        boolean z = true;
        getSupportActionBar().b(true);
        getSupportActionBar().a(0.0f);
        if (getIntent() == null || !getIntent().hasExtra("from") || !SDKConstants.TYPE_BANK_MANDATE.equalsIgnoreCase(getIntent().getStringExtra("from"))) {
            z = false;
        }
        if (z) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().d(R.string.label_know_more_emandate);
            }
            strArr = getResources().getStringArray(R.array.new_automatic_emandate_know_more);
        } else {
            if (getSupportActionBar() != null) {
                getSupportActionBar().d(R.string.label_know_more);
            }
            strArr = getResources().getStringArray(R.array.new_automatic_payment_know_more);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.points);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.a() {
            public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                return new RecyclerView.v(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ap_know_more_item, viewGroup, false)) {
                };
            }

            public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
                ((TextView) vVar.itemView.findViewById(16908308)).setText(strArr[i2]);
            }

            public final int getItemCount() {
                return strArr.length;
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
