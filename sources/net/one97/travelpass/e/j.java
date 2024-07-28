package net.one97.travelpass.e;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.travelpass.R;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30335a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context) {
            k.c(context, "context");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.ok), C0512a.f30336a);
            builder.show();
        }

        /* renamed from: net.one97.travelpass.e.j$a$a  reason: collision with other inner class name */
        static final class C0512a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public static final C0512a f30336a = new C0512a();

            C0512a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        }

        public static SpannableStringBuilder a(String str, String str2, String str3, ClickableSpan clickableSpan) {
            k.c(str, "highlightedColor");
            k.c(str2, "value");
            k.c(str3, "highlighted");
            k.c(clickableSpan, "clickableSpan");
            CharSequence charSequence = str2;
            int a2 = p.a(charSequence, str3, 0, false, 6);
            int length = str3.length() + a2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(clickableSpan, a2, length, 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str)), a2, length, 34);
            return spannableStringBuilder;
        }

        public static void a(Context context, String str) {
            if (context != null) {
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    Object systemService = context.getSystemService("clipboard");
                    if (!(systemService instanceof ClipboardManager)) {
                        systemService = null;
                    }
                    ClipboardManager clipboardManager = (ClipboardManager) systemService;
                    if (clipboardManager != null) {
                        clipboardManager.setText(charSequence);
                    }
                    Toast.makeText(context, "Promocode " + str + " Copied", 0).show();
                }
            }
        }
    }
}
