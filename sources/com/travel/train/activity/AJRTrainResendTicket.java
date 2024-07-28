package com.travel.train.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.core.app.a;
import androidx.fragment.app.j;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.aa;

public class AJRTrainResendTicket extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private aa f26057a;

    /* renamed from: b  reason: collision with root package name */
    private j f26058b;

    /* renamed from: c  reason: collision with root package name */
    private String f26059c = "AJRTrainResendTicket";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_train_resend_ticket_layout);
        if (!s.a() || s.c((Context) this)) {
            a();
        } else {
            a.a(this, new String[]{"android.permission.READ_CONTACTS"}, 53);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 53) {
            return;
        }
        if (s.a(iArr)) {
            a();
            return;
        }
        a();
        if (s.a(strArr, iArr, "android.permission.READ_CONTACTS", this) == 1) {
            Toast.makeText(this, getResources().getString(R.string.read_contacts_rational_message), 0).show();
            finish();
            return;
        }
        try {
            c.a aVar = new c.a(this);
            aVar.a((CharSequence) "Alert");
            aVar.b((CharSequence) getResources().getString(R.string.read_contacts_permission_alert_msg));
            aVar.a((CharSequence) getResources().getString(R.string.action_settings), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    s.b((Context) AJRTrainResendTicket.this);
                    AJRTrainResendTicket.this.finish();
                }
            });
            aVar.b((CharSequence) getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRTrainResendTicket.this.finish();
                }
            });
            aVar.b();
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void a() {
        this.f26058b = getSupportFragmentManager();
        androidx.fragment.app.q a2 = this.f26058b.a();
        this.f26057a = aa.b();
        a2.b(R.id.fragment_container, this.f26057a, (String) null);
        a2.b();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }
}
