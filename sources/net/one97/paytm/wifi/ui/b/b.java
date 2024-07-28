package net.one97.paytm.wifi.ui.b;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.g.b.k;

public final class b {
    public static final void a(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final void b(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(8);
    }

    public static final void a(AppCompatActivity appCompatActivity, CharSequence charSequence, int i2) {
        k.c(appCompatActivity, "receiver$0");
        k.c(charSequence, "message");
        Toast.makeText(appCompatActivity, charSequence, i2).show();
    }
}
