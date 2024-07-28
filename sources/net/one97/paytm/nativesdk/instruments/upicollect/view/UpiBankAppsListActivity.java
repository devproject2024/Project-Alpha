package net.one97.paytm.nativesdk.instruments.upicollect.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.databinding.ActivityUpiAppsBinding;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upicollect.view.AllUpiAppListAdapter;

public class UpiBankAppsListActivity extends PaytmActivity {
    /* access modifiers changed from: private */
    public ActivityUpiAppsBinding upiAppsBinding;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.upiAppsBinding = (ActivityUpiAppsBinding) f.a(this, R.layout.activity_upi_apps);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("upi").authority("pay");
        this.upiAppsBinding.rvAppsList.setLayoutManager(new LinearLayoutManager(this));
        final List<UpiOptionsModel> upiAppsInstalled = SDKUtility.getUpiAppsInstalled(this, builder.toString());
        final AllUpiAppListAdapter allUpiAppListAdapter = new AllUpiAppListAdapter(upiAppsInstalled);
        this.upiAppsBinding.rvAppsList.setAdapter(allUpiAppListAdapter);
        allUpiAppListAdapter.setBankAppItemClick(new AllUpiAppListAdapter.BankAppItemClickListener() {
            public void onClick(UpiOptionsModel upiOptionsModel) {
                Intent intent = new Intent();
                intent.putExtra("dataName", upiOptionsModel.getAppName());
                intent.putExtra("dataInfo", upiOptionsModel.getResolveInfo());
                intent.setAction(SDKConstants.APP_SELECTED_FROM_UPI_LIST);
                a.a((Context) UpiBankAppsListActivity.this).a(intent);
                UpiBankAppsListActivity.this.finish();
            }
        });
        this.upiAppsBinding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiBankAppsListActivity.this.finish();
            }
        });
        this.upiAppsBinding.searchView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    UpiBankAppsListActivity.this.upiAppsBinding.imgEdtCross.setVisibility(8);
                    allUpiAppListAdapter.setUpiOptionsModels(upiAppsInstalled);
                    return;
                }
                UpiBankAppsListActivity.this.upiAppsBinding.imgEdtCross.setVisibility(0);
                allUpiAppListAdapter.setUpiOptionsModels(UpiBankAppsListActivity.this.getFilteredList(upiAppsInstalled, charSequence.toString()));
            }
        });
        this.upiAppsBinding.imgEdtCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiBankAppsListActivity.this.upiAppsBinding.searchView.setText("");
            }
        });
        this.upiAppsBinding.ivBackArrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiBankAppsListActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public List<UpiOptionsModel> getFilteredList(List<UpiOptionsModel> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.isEmpty(list.get(i2).getAppName()) && !TextUtils.isEmpty(str.toLowerCase()) && list.get(i2).getAppName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setAction(SDKConstants.APP_SELECTED_FROM_UPI_LIST);
        a.a((Context) this).a(intent);
    }
}
