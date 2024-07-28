package net.one97.paytm.bankCommon.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.c;
import net.one97.paytm.bankCommon.a.b;
import net.one97.paytm.bankOpen.R;

public final class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public C0221a f16219a;

    /* renamed from: b  reason: collision with root package name */
    private final ListView f16220b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16221c;

    /* renamed from: d  reason: collision with root package name */
    private c.a f16222d;

    /* renamed from: e  reason: collision with root package name */
    private c f16223e;

    /* renamed from: net.one97.paytm.bankCommon.c.a$a  reason: collision with other inner class name */
    public interface C0221a {
        void onItemSelected(int i2);
    }

    public a(Context context, String[] strArr, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.relationship_dialog_view, (ViewGroup) null);
        this.f16222d = new c.a(context);
        this.f16222d.a(inflate);
        this.f16221c = new b(context, strArr, this);
        this.f16220b = (ListView) inflate.findViewById(R.id.relationship_dialog_list);
        this.f16220b.setAdapter(this.f16221c);
        this.f16220b.setOnItemClickListener(this);
        this.f16220b.setDivider((Drawable) null);
        this.f16221c.a(i2);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        this.f16221c.a(i2);
        C0221a aVar = this.f16219a;
        if (aVar != null) {
            aVar.onItemSelected(i2);
        }
    }

    public final void a(C0221a aVar) {
        this.f16219a = aVar;
    }

    public final void a() {
        this.f16223e = this.f16222d.a();
        this.f16223e.show();
    }

    public final void b() {
        c cVar = this.f16223e;
        if (cVar != null && cVar.isShowing()) {
            this.f16223e.dismiss();
        }
    }
}
