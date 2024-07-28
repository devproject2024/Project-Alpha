package net.one97.paytm.landingpage.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.i.b;
import net.one97.paytm.paytm_finance.R;

public class FJRScanFragment extends b {
    public void onEditViewClick(View view) {
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
    }

    public void onServerDataLoaded() {
    }

    public void updateData(CJRItem cJRItem) {
    }

    public void updateFragment(boolean z) {
    }

    public void updateHeading() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onStart() {
        super.onStart();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.barcode_scan_fragment, (ViewGroup) null);
    }
}
