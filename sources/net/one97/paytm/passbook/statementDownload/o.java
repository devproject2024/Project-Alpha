package net.one97.paytm.passbook.statementDownload;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.i.f;

public class o extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f58742a;

    /* renamed from: b  reason: collision with root package name */
    private String f58743b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f58744c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f58745d;

    /* renamed from: e  reason: collision with root package name */
    private a f58746e;

    public interface a {
        void onDismiss();
    }

    public o() {
    }

    public o(String str, String str2, a aVar) {
        this.f58742a = str;
        this.f58743b = str2;
        this.f58746e = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_dialog_statement_successfully_sent, (ViewGroup) null);
        dialog.setContentView(inflate);
        try {
            ((View) inflate.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
        this.f58744c = (TextView) inflate.findViewById(net.one97.paytm.passbook.R.id.msgTV);
        this.f58745d = (TextView) inflate.findViewById(net.one97.paytm.passbook.R.id.emailIdTv);
        dialog.findViewById(net.one97.paytm.passbook.R.id.doneBtn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.a(view);
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                o.this.b(dialogInterface);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                o.this.a(dialogInterface);
            }
        });
        String str = this.f58742a;
        if (str != null) {
            this.f58744c.setText(str);
        }
        TextView textView = this.f58745d;
        if (textView != null) {
            textView.setText(getString(net.one97.paytm.passbook.R.string.pass_to) + " " + a(this.f58743b));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.f58746e.onDismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f58746e.onDismiss();
    }

    private static String a(String str) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '@') {
                z = true;
            }
            if (i2 <= 1 || z) {
                obj = Character.valueOf(charAt);
            } else {
                obj = "x";
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f58746e.onDismiss();
        super.onDismiss(dialogInterface);
    }
}
