package androidx.biometric;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.c;
import androidx.fragment.app.FragmentActivity;

public class DeviceCredentialHandlerActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14459a;

    public void onCreate(Bundle bundle) {
        d a2 = d.a();
        boolean z = true;
        if (a2.f14500b != 0) {
            setTheme(a2.f14500b);
            getTheme().applyStyle(R.style.TransparentStyle, true);
        }
        super.onCreate(bundle);
        if (bundle == null || !bundle.getBoolean("did_change_configuration", false)) {
            z = false;
        }
        this.f14459a = z;
        if (!this.f14459a) {
            a2.f14506h = 0;
        } else {
            this.f14459a = false;
        }
        setTitle((CharSequence) null);
        setContentView(R.layout.device_credential_handler_activity);
        if (a2.f14502d == null || a2.f14503e == null) {
            finish();
        } else {
            new c((FragmentActivity) this, a2.f14502d, a2.f14503e).b(new c.d(getIntent().getBundleExtra("prompt_info_bundle")), (c.C0197c) null);
        }
    }

    public void onPause() {
        super.onPause();
        d dVar = d.f14499a;
        if (isChangingConfigurations() && dVar != null) {
            if (dVar.f14506h == 0) {
                dVar.f14506h = 1;
            }
            this.f14459a = true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("did_change_configuration", this.f14459a);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(i3);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        d dVar = d.f14499a;
        if (dVar != null) {
            if (i2 == -1) {
                dVar.f14505g = 1;
                dVar.f14504f = false;
                dVar.f14506h = 2;
            } else {
                dVar.f14505g = 2;
                dVar.f14504f = false;
                dVar.f14506h = 2;
            }
        }
        finish();
    }
}
