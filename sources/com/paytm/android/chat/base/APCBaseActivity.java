package com.paytm.android.chat.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.base.e;
import com.paytm.android.chat.base.f;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.LoadingDialog;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;

public abstract class APCBaseActivity<ViewModel extends f<State>, State extends e> extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private c f41801a;

    /* renamed from: b  reason: collision with root package name */
    private LoadingDialog f41802b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f41803c;

    /* renamed from: h  reason: collision with root package name */
    State f41804h;

    /* access modifiers changed from: protected */
    public abstract int a();

    public View a(int i2) {
        if (this.f41803c == null) {
            this.f41803c = new HashMap();
        }
        View view = (View) this.f41803c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41803c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public abstract void a(State state);

    /* access modifiers changed from: protected */
    public abstract ViewModel c();

    /* access modifiers changed from: protected */
    public abstract void d();

    /* access modifiers changed from: protected */
    public abstract void e();

    static final class a<T> implements g<State> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCBaseActivity f41805a;

        a(APCBaseActivity aPCBaseActivity) {
            this.f41805a = aPCBaseActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            State state = (e) obj;
            if (state != null) {
                this.f41805a.a(state);
                this.f41805a.f41804h = state;
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f41801a = c().a().toFlowable(io.reactivex.rxjava3.a.a.BUFFER).a(io.reactivex.rxjava3.android.b.a.a()).b(new a(this));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a());
        com.paytm.android.chat.c.a(this);
        e();
        d();
    }

    public void onResume() {
        super.onResume();
        com.paytm.android.chat.c.a(this);
        ChatManager.b().d();
    }

    public void onPause() {
        com.paytm.android.chat.c.e();
        super.onPause();
    }

    public void onStop() {
        i();
        super.onStop();
    }

    public void onDestroy() {
        com.paytm.android.chat.c.e();
        i();
        this.f41802b = null;
        c cVar = this.f41801a;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        super.onDestroy();
    }

    public final void h() {
        if (this.f41802b == null) {
            this.f41802b = new LoadingDialog(this, false);
        }
        LoadingDialog loadingDialog = this.f41802b;
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    public final void i() {
        LoadingDialog loadingDialog = this.f41802b;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        if (!(resources == null || resources.getConfiguration().fontScale == 1.0f)) {
            Configuration configuration = resources.getConfiguration();
            k.a((Object) configuration, "resources.configuration");
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        try {
            AppUtilKt.reInitializeChatManager(context);
        } catch (Exception unused) {
        }
    }
}
