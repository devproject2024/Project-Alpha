package net.one97.paytm.landingpage.f;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.paytmmall.clpartifact.ICashBackListener;
import net.one97.paytm.common.b.d;

public final class c implements ICashBackListener {

    /* renamed from: a  reason: collision with root package name */
    private AppCompatActivity f52778a;

    public c(Context context) {
        if (context instanceof AppCompatActivity) {
            this.f52778a = (AppCompatActivity) context;
        }
    }

    public final void onPopupOpen() {
        if (this.f52778a != null) {
            d.b().b(this.f52778a);
        }
    }
}
