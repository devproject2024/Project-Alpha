package net.one97.paytm.quickpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.activity.PaymentReminderCreationActivity;
import net.one97.paytm.quickpay.activity.QuickViewAll;

public class FastForwardPaymentView extends View implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f59821a;

    /* renamed from: b  reason: collision with root package name */
    private List<IJRDataModel> f59822b;

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_add_new) {
            view.setEnabled(false);
            if (a.p(this.f59821a)) {
                Intent intent = new Intent(this.f59821a, PaymentReminderCreationActivity.class);
                intent.setFlags(536870912);
                this.f59821a.startActivity(intent);
            } else {
                String name = PaymentReminderCreationActivity.class.getName();
                String string = this.f59821a.getString(R.string.hello_sign_in);
                Intent e2 = d.a().e(this.f59821a);
                if (name != null) {
                    e2.putExtra("resultant activity", name);
                    a.c();
                }
                e2.putExtra("sign_in_sign_up_with_step_2", true);
                if (!TextUtils.isEmpty(string)) {
                    e2.putExtra("sign_in_title", string);
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    e2.putExtra("sign_up_title", (String) null);
                }
                e2.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                ((Activity) this.f59821a).startActivityForResult(e2, 111);
            }
            if (!view.isEnabled()) {
                view.setEnabled(true);
            }
        } else if (id == R.id.ll_view_all_reminder) {
            Intent intent2 = new Intent(this.f59821a, QuickViewAll.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("QuickPaymentList", (ArrayList) this.f59822b);
            intent2.putExtras(bundle);
            Activity activity = (Activity) this.f59821a;
            if (activity != null) {
                activity.startActivityForResult(intent2, 800);
            }
        }
    }
}
