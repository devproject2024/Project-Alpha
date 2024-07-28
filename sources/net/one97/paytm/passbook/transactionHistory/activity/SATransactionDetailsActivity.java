package net.one97.paytm.passbook.transactionHistory.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.utility.s;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;

public final class SATransactionDetailsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f59169a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f59170b;

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f59172a = new b();

        b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public final View a(int i2) {
        if (this.f59170b == null) {
            this.f59170b = new HashMap();
        }
        View view = (View) this.f59170b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f59170b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_sa_transaction_details);
        getSupportFragmentManager().a().a(R.id.fl_details_container, (Fragment) new net.one97.paytm.passbook.transactionHistory.fragments.a()).c();
    }

    public final void a() {
        Runnable runnable = this.f59169a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                a();
            } else if (androidx.core.app.a.a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText(this, "Storage permission is required to share the screen.", 0).show();
            } else {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new a(this));
                    builder.setNegativeButton(getResources().getString(R.string.cancel), b.f59172a);
                    builder.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SATransactionDetailsActivity f59171a;

        a(SATransactionDetailsActivity sATransactionDetailsActivity) {
            this.f59171a = sATransactionDetailsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b((Context) this.f59171a);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        j supportFragmentManager = getSupportFragmentManager();
        Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c(R.id.fl_details_container) : null;
        if (c2 != null && (c2 instanceof net.one97.paytm.passbook.transactionHistory.fragments.a)) {
            c2.onActivityResult(i2, i3, intent);
        }
    }
}
