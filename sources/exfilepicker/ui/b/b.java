package exfilepicker.ui.b;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.c;
import com.paytm.android.chat.R;
import exfilepicker.a;

public final class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final c.a f46226a;

    /* renamed from: b  reason: collision with root package name */
    public a f46227b;

    public interface a {
        void a(a.b bVar);
    }

    public b(Context context) {
        this.f46226a = new c.a(context);
        this.f46226a.a((CharSequence[]) context.getResources().getStringArray(R.array.chat_module_efp__sorting_types), (DialogInterface.OnClickListener) this);
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        a.b bVar = a.b.NAME_ASC;
        if (i2 == 1) {
            bVar = a.b.NAME_DESC;
        } else if (i2 == 2) {
            bVar = a.b.SIZE_ASC;
        } else if (i2 == 3) {
            bVar = a.b.SIZE_DESC;
        } else if (i2 == 4) {
            bVar = a.b.DATE_ASC;
        } else if (i2 == 5) {
            bVar = a.b.DATE_DESC;
        }
        this.f46227b.a(bVar);
    }
}
