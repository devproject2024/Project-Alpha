package net.one97.paytm.passbook.statementDownload;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import net.one97.paytm.passbook.R;

public final class c extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f58672a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f58673b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f58674c;

    public final void onClick(View view) {
    }

    public final void onPointerCaptureChanged(boolean z) {
    }

    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
    }

    public c(Context context, String str) {
        super(context);
        this.f58672a = str;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.pass_custom_statement_dialog);
        this.f58673b = (TextView) findViewById(R.id.messageTv);
        this.f58673b.setText(this.f58672a);
        this.f58674c = (TextView) findViewById(R.id.ok_btn);
        this.f58674c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
    }
}
