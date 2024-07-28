package net.one97.paytm.paymentsBank.createfd.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.c.c;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.utils.o;

public final class CreateFdActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18076a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f18077b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_fd_parent_layout);
        int i2 = R.id.iv_back;
        if (this.f18077b == null) {
            this.f18077b = new HashMap();
        }
        View view = (View) this.f18077b.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f18077b.put(Integer.valueOf(i2), view);
        }
        ImageView imageView = (ImageView) view;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.a().a(R.id.createFd_layout, new net.one97.paytm.paymentsBank.createfd.b.a(), "createfd").c();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateFdActivity f18078a;

        b(CreateFdActivity createFdActivity) {
            this.f18078a = createFdActivity;
        }

        public final void onClick(View view) {
            this.f18078a.onBackPressed();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        if (valueOf != null && valueOf.intValue() == 16908332) {
            try {
                Object systemService = getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    View currentFocus = getCurrentFocus();
                    if (currentFocus == null) {
                        k.a();
                    }
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    try {
                        onBackPressed();
                    } catch (IllegalStateException unused) {
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            } catch (Exception unused2) {
                boolean z = com.paytm.utility.b.v;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            j supportFragmentManager = getSupportFragmentManager();
            String str = null;
            Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c("createfd") : null;
            if (!(c2 instanceof net.one97.paytm.paymentsBank.createfd.b.a)) {
                c2 = null;
            }
            net.one97.paytm.paymentsBank.createfd.b.a aVar = (net.one97.paytm.paymentsBank.createfd.b.a) c2;
            if (aVar == null) {
                return;
            }
            if (intent == null || TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                aVar.a((Integer) 400, new NetworkCustomError());
                return;
            }
            c.a aVar2 = aVar.f18083a;
            if (aVar2 == null) {
                k.a("presenter");
            }
            String stringExtra = intent.getStringExtra("passcode");
            k.a((Object) stringExtra, "data.getStringExtra(PBConstants.EXTRA_PASSCODE)");
            CustomAmountTextInputEditText customAmountTextInputEditText = (CustomAmountTextInputEditText) aVar.a(R.id.tv_amount);
            k.a((Object) customAmountTextInputEditText, "tv_amount");
            Editable text = customAmountTextInputEditText.getText();
            if (text != null) {
                str = text.toString();
            }
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(str);
            k.a((Object) ab, "CJRAppUtility.getCleanSt…_amount.text?.toString())");
            aVar2.a(stringExtra, ab);
        }
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Integer num = -1;
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.hasExtra("status")) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            Bundle extras = intent.getExtras();
            num = extras != null ? Integer.valueOf(extras.getInt("status")) : null;
        }
        j supportFragmentManager = getSupportFragmentManager();
        Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c("createfd") : null;
        if (!(c2 instanceof net.one97.paytm.paymentsBank.createfd.b.a)) {
            c2 = null;
        }
        net.one97.paytm.paymentsBank.createfd.b.a aVar = (net.one97.paytm.paymentsBank.createfd.b.a) c2;
        if (aVar != null) {
            b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            int b2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18188c;
            if (num == null || num.intValue() != b2) {
                c.a aVar3 = aVar.f18083a;
                if (aVar3 == null) {
                    k.a("presenter");
                }
                aVar3.a(b.a.C0305a.ADDMONEY_MODULE_RESPONSE);
                aVar.f18086d.postDelayed(aVar.f18087e, 3000);
            }
        }
    }

    public final void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
