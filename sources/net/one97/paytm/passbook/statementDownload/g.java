package net.one97.paytm.passbook.statementDownload;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.crashlytics.c;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.utility.q;

public class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f58695a;

    /* renamed from: b  reason: collision with root package name */
    private a f58696b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f58697c;

    /* renamed from: d  reason: collision with root package name */
    private String f58698d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f58699e;

    /* renamed from: f  reason: collision with root package name */
    private BottomSheetBehavior.a f58700f = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                g.this.dismiss();
            }
        }
    };

    public interface a {
    }

    public void onCreate(Bundle bundle) {
        q.a(getContext(), "verification_popup_loaded", (String) null, (ArrayList<String>) null, "/bank/savings-account/statement");
        super.onCreate(bundle);
    }

    public g() {
    }

    private g(String str) {
        this.f58698d = str;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
                g.this.getDialog().getWindow().setSoftInputMode(16);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setContentView(View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_bottomsheet_verify_email, (ViewGroup) null));
        this.f58695a = dialog.findViewById(net.one97.paytm.passbook.R.id.ok_btn);
        this.f58695a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                q.a(g.this.getContext(), "verification_popup_ok_clicked", (String) null, (ArrayList<String>) null, "/bank/savings-account/statement");
                g.this.dismiss();
            }
        });
        this.f58697c = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.email);
        this.f58697c.setText(this.f58698d);
        this.f58699e = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.verifyDescr);
        this.f58699e.setText(net.one97.paytm.passbook.R.string.pass_verification_sent_on_email);
    }

    public static void a(j jVar, String str) {
        com.paytm.utility.q.b("openVerificationEmailBottomSheet");
        g gVar = new g(str);
        gVar.show(jVar, gVar.getTag());
        gVar.f58696b = new a() {
        };
    }

    public void show(j jVar, String str) {
        try {
            androidx.fragment.app.q a2 = jVar.a();
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException e2) {
            c.a().a((Throwable) e2);
        }
    }
}
