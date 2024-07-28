package exfilepicker.ui.b;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.c;
import com.paytm.android.chat.R;
import exfilepicker.a.d;
import java.util.LinkedHashMap;

public final class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final c.a f46228a;

    /* renamed from: b  reason: collision with root package name */
    public a f46229b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedHashMap<String, String> f46230c;

    public interface a {
        void b(String str);
    }

    public c(Context context) {
        this.f46228a = new c.a(context);
        this.f46228a.a(R.string.chat_module_efp__storage);
        this.f46230c = d.a(context);
        this.f46228a.a((CharSequence[]) this.f46230c.values().toArray(new String[0]), (DialogInterface.OnClickListener) this);
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f46229b.b((String) this.f46230c.keySet().toArray()[i2]);
    }
}
