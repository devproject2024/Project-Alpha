package net.one97.paytm.recharge.legacy.catalog.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import com.google.android.youtube.player.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.activity.CJRRechargeToolbarActivity;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.common.e.l;
import net.one97.paytm.recharge.common.e.v;

@Deprecated
public class AJRRechargeActivity extends CJRRechargeToolbarActivity implements am, l, v {

    /* renamed from: a  reason: collision with root package name */
    protected CJRItem f62797a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f62798b;

    public final void a() {
    }

    public final void a(c cVar, boolean z) {
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
    }

    public final void a(boolean z) {
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f62797a = (CJRItem) getIntent().getExtras().getSerializable("extra_home_data");
            this.f62798b = getIntent().getExtras().getBoolean("open_activity_in_automatic_mode");
        }
        if (!this.f62798b) {
            CJRItem cJRItem = this.f62797a;
            if (cJRItem != null) {
                str = cJRItem.getCategoryId();
                if (TextUtils.isEmpty(str)) {
                    String uRLType = this.f62797a.getURLType();
                    if (!TextUtils.isEmpty(uRLType)) {
                        char c2 = 65535;
                        switch (uRLType.hashCode()) {
                            case -1583447726:
                                if (uRLType.equals("mobile_prepaid")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 195158633:
                                if (uRLType.equals("mobile_postpaid")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 373568567:
                                if (uRLType.equals("mobile-postpaid")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1470348740:
                                if (uRLType.equals("mobile-prepaid")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0 || c2 == 1) {
                            str = "21";
                        } else if (c2 == 2 || c2 == 3) {
                            str = "17";
                        }
                    }
                }
            } else {
                str = "";
            }
            Intent intent = new Intent(this, AJRRechargeUtilityActivity.class);
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                intent.putExtras(getIntent().getExtras());
            }
            CJRItem cJRItem2 = this.f62797a;
            if (cJRItem2 instanceof CJRHomePageItem) {
                ((CJRHomePageItem) cJRItem2).setCategoryId(str);
                intent.putExtra("extra_home_data", this.f62797a);
            }
            startActivity(intent);
            finish();
        }
    }

    public final void al_() {
        super.al_();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
