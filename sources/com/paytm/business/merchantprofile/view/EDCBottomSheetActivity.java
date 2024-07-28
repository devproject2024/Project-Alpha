package com.paytm.business.merchantprofile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.adapter.EDCBottomSheetAdapter;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.listener.EDCSheetListener;

public class EDCBottomSheetActivity extends BaseActivity implements EDCSheetListener {
    public EDCBottomSheetAdapter mAdapter;
    public String[] mData;
    public RecyclerView mRecyclerView;
    public ImageView mTintView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pr_bottom_sheet_activity_layout);
        getDataFromIntent();
        iniUI();
    }

    private void iniUI() {
        this.mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        ImageView imageView = (ImageView) findViewById(R.id.tint_view);
        this.mTintView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EDCBottomSheetActivity.this.lambda$iniUI$0$EDCBottomSheetActivity(view);
            }
        });
        this.mAdapter = new EDCBottomSheetAdapter(this.mData, this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    public /* synthetic */ void lambda$iniUI$0$EDCBottomSheetActivity(View view) {
        finish();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.mData = intent.getExtras().getStringArray(AppConstants.RENTAL_SERIALIZABLE_DATA);
        }
    }

    public void onBottomSheetElementClick(int i2) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, i2);
        setResult(-1, intent);
        finish();
    }
}
