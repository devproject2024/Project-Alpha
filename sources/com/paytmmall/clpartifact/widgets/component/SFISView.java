package com.paytmmall.clpartifact.widgets.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.k;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmall.clpartifact.widgets.viewmodel.InterStitialSharedViewModel;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class SFISView implements SFWidget {
    /* access modifiers changed from: private */
    public FragmentActivity activity;
    /* access modifiers changed from: private */
    public Intent intent;

    public void dismissWidget() {
    }

    public void setOnDismissListener(SFWidget.DismissListener dismissListener) {
    }

    public SFISView(FragmentActivity fragmentActivity, Class<? extends Activity> cls) {
        this.activity = fragmentActivity;
        this.intent = new Intent(fragmentActivity, cls);
    }

    protected SFISView() {
    }

    public void showWidget(HashMap<String, Object> hashMap) {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            boolean isAtLeast = fragmentActivity.getLifecycle().a().isAtLeast(k.b.RESUMED);
            if (!this.activity.isFinishing() && !this.activity.isDestroyed() && isAtLeast) {
                b.a.C0750a a2 = b.a(this.activity);
                a2.f43753a = this.intent.getStringExtra(CLPConstants.ISV_IMG_URL);
                a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                    public void onError(Exception exc) {
                    }

                    public void onSuccess(Drawable drawable, c cVar) {
                        if (!ImageUtility.isActivityDestroyed(SFISView.this.activity) && SFISView.this.activity.getLifecycle().a().isAtLeast(k.b.RESUMED)) {
                            SFISView sFISView = SFISView.this;
                            sFISView.setItemId(sFISView.activity, SFISView.this.intent.getSerializableExtra(CLPConstants.ISV_AD_ITEM));
                            SFISView.this.activity.startActivity(SFISView.this.intent);
                            FragmentActivity access$000 = SFISView.this.activity;
                            int i2 = R.anim.sf_fade_in;
                            access$000.overridePendingTransition(i2, i2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setItemId(FragmentActivity fragmentActivity, Serializable serializable) {
        ((InterStitialSharedViewModel) am.a(fragmentActivity).a(InterStitialSharedViewModel.class)).setItemId(serializable instanceof CJRHomePageItem ? ((CJRHomePageItem) serializable).getItemID() : serializable instanceof Item ? ((Item) serializable).getId() : null);
    }

    public void putExtra(String str, Serializable serializable) {
        Intent intent2 = this.intent;
        if (intent2 != null) {
            intent2.putExtra(str, serializable);
        }
    }
}
