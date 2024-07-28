package net.one97.paytm.common.utility;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public final class m extends Toast {
    private m(Context context) {
        super(context);
    }

    public final void show() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.show();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    m.super.show();
                }
            });
        }
    }

    public static Toast a(Context context, int i2) throws Resources.NotFoundException {
        Toast makeText = Toast.makeText(context, context.getResources().getText(i2), 0);
        m mVar = new m(context);
        mVar.setView(makeText.getView());
        mVar.setDuration(makeText.getDuration());
        return mVar;
    }
}
