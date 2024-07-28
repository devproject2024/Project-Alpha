package net.one97.paytm.paymentsBank.slfd.b.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.g.b.k;

public final class b {
    public static final void a(ImageView imageView, int i2) {
        k.c(imageView, "receiver$0");
        imageView.setImageResource(i2);
    }

    public static final void a(View view, int i2) {
        k.c(view, "receiver$0");
        view.setBackground(androidx.core.content.b.a(view.getContext(), i2));
    }

    public static final void a(AppCompatActivity appCompatActivity, CharSequence charSequence) {
        k.c(appCompatActivity, "receiver$0");
        k.c(charSequence, "message");
        Toast.makeText(appCompatActivity, charSequence, 0).show();
    }

    public static final void a(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final void b(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(8);
    }

    public static final void c(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(4);
    }
}
