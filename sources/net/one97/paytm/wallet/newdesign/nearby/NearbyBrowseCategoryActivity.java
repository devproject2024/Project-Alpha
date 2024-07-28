package net.one97.paytm.wallet.newdesign.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.a.d;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public class NearbyBrowseCategoryActivity extends PaytmActivity implements View.OnClickListener, d.b {

    /* renamed from: a  reason: collision with root package name */
    private d f70999a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> f71000b;

    /* renamed from: c  reason: collision with root package name */
    private int f71001c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_activity_browse_category);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.browse_category_rv_browse_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f71001c = getIntent().getIntExtra(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, 0);
        this.f71000b = (ArrayList) getIntent().getSerializableExtra("category_list");
        this.f70999a = new d(this, this.f71001c, this.f71000b);
        recyclerView.setAdapter(this.f70999a);
        findViewById(R.id.header_back_button).setOnClickListener(this);
        this.f70999a.f71035b = this;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.header_back_button) {
            finish();
        }
    }

    public final void a(int i2) {
        d dVar = this.f70999a;
        dVar.f71034a = i2;
        dVar.notifyDataSetChanged();
        this.f71001c = i2;
        String categoryName = this.f71000b.get(i2).getCategoryName();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "nearby");
            hashMap.put("new_wallet_nearby_category_name", categoryName);
            d.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.d.f71130b;
            d.a.b().a("new_wallet_nearby_category_clicked", (HashMap<String, Object>) hashMap, getApplicationContext());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        Intent intent = new Intent();
        intent.putExtra(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, this.f71001c);
        setResult(-1, intent);
        finish();
    }
}
