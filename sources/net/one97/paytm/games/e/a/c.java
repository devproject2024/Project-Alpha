package net.one97.paytm.games.e.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import net.one97.paytm.games.R;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35593a = new a((byte) 0);

    private c() {
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static void a(Context context, String str, ImageView imageView, int i2, int i3) {
        k.c(context, "context");
        k.c(str, "imgUrl");
        k.c(imageView, "targetView");
        b.a aVar = b.f43744a;
        b.a.C0750a a2 = b.a.a(context);
        a2.f43753a = str;
        Drawable a3 = androidx.core.content.b.a(context, i3);
        if (a3 == null) {
            k.a();
        }
        k.a((Object) a3, "ContextCompat.getDrawable(context, placeHolder)!!");
        b.a.C0750a.a(a2.a((Object) a3).a(i2, b.a.ALL).a(com.paytm.utility.b.b.a.DATA_DISK_CACHE), imageView, (com.paytm.utility.b.b.b) null, 2);
    }

    public static void b(Context context, String str, ImageView imageView) {
        k.c(context, "context");
        k.c(str, "imgUrl");
        k.c(imageView, "targetView");
        com.google.android.play.core.splitcompat.a.a(context);
        b.a aVar = com.paytm.utility.b.b.f43744a;
        b.a.C0750a a2 = b.a.a(context);
        a2.f43753a = str;
        Drawable a3 = androidx.core.content.b.a(context, R.drawable.games_img_defult_midcard);
        if (a3 == null) {
            k.a();
        }
        k.a((Object) a3, "ContextCompat.getDrawabl…mes_img_defult_midcard)!!");
        b.a.C0750a.a(a2.a((Object) a3).a(8, b.a.ALL).a(com.paytm.utility.b.b.a.DATA_DISK_CACHE), imageView, (com.paytm.utility.b.b.b) null, 2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a() {
            return new c((byte) 0);
        }
    }
}
