package com.paytmmall.clpartifact.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;

final class SFBrowseCategoryActivity$initUI$4 implements View.OnClickListener {
    final /* synthetic */ SFBrowseCategoryActivity this$0;

    SFBrowseCategoryActivity$initUI$4(SFBrowseCategoryActivity sFBrowseCategoryActivity) {
        this.this$0 = sFBrowseCategoryActivity;
    }

    public final void onClick(View view) {
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        k.a((Object) communicationListener, "CLPArtifact.getInstance().communicationListener");
        Class<? extends Activity> searchActivity = communicationListener.getSearchActivity();
        if (searchActivity != null) {
            CLPArtifact instance2 = CLPArtifact.getInstance();
            k.a((Object) instance2, "CLPArtifact.getInstance()");
            instance2.getCommunicationListener().sendCustomGTMEvents(this.this$0, "", CLPConstants.ACTION_SEARCH_CLICKED, CLPConstants.PAYTM_MORE, "", "/", CLPConstants.VERTICAL_NAME_SMART_CATEGORY);
            SFBrowseCategoryActivity sFBrowseCategoryActivity = this.this$0;
            Intent intent = new Intent(sFBrowseCategoryActivity, searchActivity);
            intent.putExtra("from", CLPConstants.PAYTM_MORE);
            sFBrowseCategoryActivity.startActivity(intent);
        }
    }
}
