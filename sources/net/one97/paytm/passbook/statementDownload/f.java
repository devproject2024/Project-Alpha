package net.one97.paytm.passbook.statementDownload;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.utility.q;

public final class f extends net.one97.paytm.i.f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public a f58682a;

    /* renamed from: b  reason: collision with root package name */
    private final String f58683b;

    /* renamed from: c  reason: collision with root package name */
    private String f58684c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f58685d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f58686e;

    /* renamed from: f  reason: collision with root package name */
    private View f58687f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58688g;

    /* renamed from: h  reason: collision with root package name */
    private BottomSheetBehavior.a f58689h = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                f.this.dismiss();
            }
        }
    };

    public interface a {
        void a(String str);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public f(String str, String str2) {
        this.f58684c = str;
        this.f58683b = str2;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
                f.this.getDialog().getWindow().setSoftInputMode(16);
            }
        });
        return aVar;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setContentView(View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_bottomsheet_enter_email, (ViewGroup) null));
        this.f58685d = (ImageView) dialog.findViewById(net.one97.paytm.passbook.R.id.iv_close);
        this.f58687f = dialog.findViewById(net.one97.paytm.passbook.R.id.proceed_btn);
        this.f58686e = (EditText) dialog.findViewById(net.one97.paytm.passbook.R.id.enterEmailId);
        this.f58688g = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.title_tv);
        this.f58686e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((InputMethodManager) f.this.getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
            }
        });
        if (!TextUtils.isEmpty(this.f58684c)) {
            this.f58688g.setText(this.f58684c);
        }
        if (!TextUtils.isEmpty(this.f58683b)) {
            this.f58686e.setText(this.f58683b);
        }
        if (this.f58684c == getString(net.one97.paytm.passbook.R.string.pass_enter_email_to_receive_account_statement)) {
            this.f58686e.setText((CharSequence) null);
        }
        this.f58685d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.f58687f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                q.a(f.this.getContext(), "change_email_proceed_clicked", (String) null, (ArrayList<String>) null, "/bank/savings-account/statement");
                String obj = f.this.f58686e.getText().toString();
                if (f.a(f.this, obj) && f.this.f58682a != null) {
                    f.this.f58682a.a(obj);
                    f.this.dismiss();
                }
            }
        });
    }

    static /* synthetic */ boolean a(f fVar, String str) {
        if (str.trim().length() == 0) {
            b.b(fVar.getContext(), fVar.getString(net.one97.paytm.passbook.R.string.pass_error), fVar.getString(net.one97.paytm.passbook.R.string.pass_msg_enter_email_id));
            return false;
        } else if (Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            return true;
        } else {
            b.b(fVar.getContext(), fVar.getString(net.one97.paytm.passbook.R.string.pass_error), fVar.getString(net.one97.paytm.passbook.R.string.pass_msg_enter_valid_email_id));
            return false;
        }
    }
}
