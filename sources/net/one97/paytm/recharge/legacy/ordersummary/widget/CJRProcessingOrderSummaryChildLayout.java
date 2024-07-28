package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public class CJRProcessingOrderSummaryChildLayout extends ConstraintLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryChildLayout(Context context, String str, String str2, String str3, int i2) {
        super(context, (AttributeSet) null, 0);
        k.c(context, "context");
        k.c(str, "title");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str3, "imageUrl");
        setBackgroundColor(b.c(context, 17170443));
        LayoutInflater.from(context).inflate(i2, this, true);
        View findViewById = findViewById(R.id.title);
        k.a((Object) findViewById, "findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setText(str);
        View findViewById2 = findViewById(R.id.description);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.description)");
        ((TextView) findViewById2).setText(str2);
        if (TextUtils.isEmpty(str3)) {
            setDefaultLogo();
            return;
        }
        try {
            w.a().a(str3).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a((ImageView) findViewById(R.id.logo));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryChildLayout(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, R.layout.processing_order_summary_child);
        k.c(context, "context");
        k.c(str, "title");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str3, "imageUrl");
    }

    /* access modifiers changed from: protected */
    public void setDefaultLogo() {
        ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.ic_order_summary_processing_payment);
    }
}
