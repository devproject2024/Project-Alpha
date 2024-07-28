package com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel;

import android.widget.ImageView;
import androidx.databinding.a;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import java.util.ArrayList;

public class SmartGridDataModel extends a {
    private ArrayList<GroupGridLayoutDataModel> finalList;
    private int position;

    public void setfinalList(ArrayList<GroupGridLayoutDataModel> arrayList) {
        this.finalList = arrayList;
        notifyChange();
    }

    public void setPosition(int i2) {
        this.position = i2;
        notifyChange();
    }

    public int getPagerIndicatorVisibility() {
        ArrayList<GroupGridLayoutDataModel> arrayList = this.finalList;
        return (arrayList == null || arrayList.size() <= 1) ? 4 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.size();
        r1 = r2.position;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTitle() {
        /*
            r2 = this;
            java.util.ArrayList<com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel> r0 = r2.finalList
            if (r0 == 0) goto L_0x0019
            int r0 = r0.size()
            int r1 = r2.position
            if (r0 <= r1) goto L_0x0019
            java.util.ArrayList<com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel> r0 = r2.finalList
            java.lang.Object r0 = r0.get(r1)
            com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel r0 = (com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel) r0
            java.lang.String r0 = r0.getMCategoryTitle()
            return r0
        L_0x0019:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SmartGridDataModel.getTitle():java.lang.String");
    }

    public String getTickerText() {
        int i2;
        ArrayList<GroupGridLayoutDataModel> arrayList = this.finalList;
        if (arrayList == null || arrayList.size() <= (i2 = this.position) || this.finalList.get(i2).getMTickerItem() == null || this.finalList.get(this.position).getMTickerItem().getName() == null) {
            return CLPArtifact.isCLPListenerAvailable() ? CLPArtifact.getInstance().getContext().getString(R.string.sf_get_upto_50_cashback_on_first_recharge) : "";
        }
        return this.finalList.get(this.position).getMTickerItem().getName();
    }

    public static void setImageWithDefault(ImageView imageView, SmartGridDataModel smartGridDataModel) {
        ArrayList<GroupGridLayoutDataModel> arrayList = smartGridDataModel.finalList;
        int i2 = smartGridDataModel.position;
        if (arrayList == null || arrayList.size() <= i2 || arrayList.get(i2).getMTickerItem() == null || arrayList.get(i2).getMTickerItem().getImageUrl() == null || ImageUtility.isActivitydestroyed(imageView)) {
            imageView.setImageResource(R.drawable.sf_cashback_right_swipe);
            return;
        }
        b.a.C0750a a2 = b.a(imageView.getContext());
        a2.f43753a = arrayList.get(i2).getMTickerItem().getImageUrl();
        b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
    }
}
