package net.one97.paytm.upi.paytmhome;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;

public final class UpiHomeQREducation extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67814a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f67815b;

    private View a(int i2) {
        if (this.f67815b == null) {
            this.f67815b = new HashMap();
        }
        View view = (View) this.f67815b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f67815b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_home_qreducation);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        TextView textView = (TextView) a(R.id.tv_upi_offer);
        k.a((Object) textView, "tv_upi_offer");
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        k.a((Object) instance, "UpiGTMLoader.getInstance()");
        textView.setText(instance.getUpiQRHomeOfferText());
        ((ImageView) a(R.id.iv_close)).setOnClickListener(new b(this));
        ((TextView) a(R.id.tv_scan_now)).setOnClickListener(new c(this));
        CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "upi_education_dialog", "", "", "", "/bhim-upi/upi-education", "wallet");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiHomeQREducation f67816a;

        b(UpiHomeQREducation upiHomeQREducation) {
            this.f67816a = upiHomeQREducation;
        }

        public final void onClick(View view) {
            this.f67816a.finish();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiHomeQREducation f67817a;

        c(UpiHomeQREducation upiHomeQREducation) {
            this.f67817a = upiHomeQREducation;
        }

        public final void onClick(View view) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f67817a, CJRGTMConstants.UPI_EVENT_CATEGORY, "upi_education_dialog_click", "", "", "", "/bhim-upi/upi-education", "wallet");
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            a2.c().e(this.f67817a);
            this.f67817a.finish();
        }
    }
}
