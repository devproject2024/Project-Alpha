package net.one97.paytm.acceptPayment.webviewcomponents;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import java.lang.ref.WeakReference;
import net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity;
import net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity;
import net.one97.paytm.acceptPayment.webviewutils.b.c;

public class OnboardingReactHandler extends c {
    public OnboardingReactHandler(BaseWebViewActivity baseWebViewActivity) {
        super(baseWebViewActivity);
    }

    public void handleMessage(Message message) {
        WeakReference<BaseWebViewActivity> weakReference = this.mActivity;
        if (weakReference != null && weakReference.get() != null) {
            int i2 = message.what;
            if (i2 == 15 || i2 == 16) {
                processOnBoardingCompleted();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private void processOnBoardingCompleted() {
        WeakReference<BaseWebViewActivity> weakReference = this.mActivity;
        if (weakReference != null && weakReference.get() != null) {
            if (((BaseWebViewActivity) this.mActivity.get()).getCallingActivity() != null) {
                ((BaseWebViewActivity) this.mActivity.get()).setResult(-1);
            } else {
                Intent intent = new Intent((Context) this.mActivity.get(), AcceptPaymentInitActivity.class);
                intent.putExtra("show_welcome_page", false);
                ((BaseWebViewActivity) this.mActivity.get()).startActivity(intent);
            }
            ((BaseWebViewActivity) this.mActivity.get()).finish();
        }
    }
}
