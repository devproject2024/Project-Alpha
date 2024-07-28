package net.one97.paytm.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CJRItem;

public abstract class a extends b {
    public void loadData() {
    }

    public void onEditViewClick(View view) {
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
    }

    public void updateData(CJRItem cJRItem) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
