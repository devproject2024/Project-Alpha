package exfilepicker.ui.b;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.paytm.android.chat.R;

public final class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public C0778a f46224a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f46225b;

    /* renamed from: exfilepicker.ui.b.a$a  reason: collision with other inner class name */
    public interface C0778a {
        void a(String str);
    }

    public a(Context context) {
        this.f46225b = new c.a(context);
        this.f46225b.a(R.string.chat_module_efp__new_folder);
        this.f46225b.a(LayoutInflater.from(context).inflate(R.layout.chat_efp__new_folder, (ViewGroup) null));
        this.f46225b.a(17039370, (DialogInterface.OnClickListener) this);
        this.f46225b.b(17039360, (DialogInterface.OnClickListener) null);
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        TextView textView = (TextView) ((c) dialogInterface).findViewById(R.id.name);
        C0778a aVar = this.f46224a;
        if (aVar != null && textView != null) {
            aVar.a(textView.getText().toString());
        }
    }

    public final void a() {
        this.f46225b.b();
    }
}
