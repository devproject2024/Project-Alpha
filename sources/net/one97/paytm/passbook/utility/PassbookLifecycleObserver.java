package net.one97.paytm.passbook.utility;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.c;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class PassbookLifecycleObserver implements p {

    /* renamed from: a  reason: collision with root package name */
    c f59224a;

    /* renamed from: b  reason: collision with root package name */
    AppCompatActivity f59225b;

    public PassbookLifecycleObserver(AppCompatActivity appCompatActivity) {
        k.c(appCompatActivity, "activity");
        this.f59225b = appCompatActivity;
    }

    @aa(a = k.a.ON_PAUSE)
    public final void activityOnPause() {
        a();
    }

    @aa(a = k.a.ON_STOP)
    public final void activityOnStop() {
        a();
    }

    public final void a() {
        c cVar = this.f59224a;
        if (cVar != null) {
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            if (cVar.isShowing()) {
                c cVar2 = this.f59224a;
                if (cVar2 == null) {
                    kotlin.g.b.k.a();
                }
                cVar2.dismiss();
            }
        }
    }

    public final void b() {
        Window window;
        View inflate = LayoutInflater.from(this.f59225b).inflate(R.layout.pass_activity_passbook_detail_info, (ViewGroup) this.f59225b.findViewById(16908290), false);
        a.a((LottieAnimationView) inflate.findViewById(R.id.wallet_loader));
        c.a aVar = new c.a(this.f59225b);
        aVar.a(inflate);
        aVar.a(false);
        this.f59224a = aVar.a();
        c cVar = this.f59224a;
        if (cVar == null) {
            kotlin.g.b.k.a();
        }
        Window window2 = cVar.getWindow();
        if (window2 == null) {
            kotlin.g.b.k.a();
        }
        window2.setBackgroundDrawableResource(17170445);
        c cVar2 = this.f59224a;
        if (!(cVar2 == null || (window = cVar2.getWindow()) == null)) {
            window.clearFlags(2);
        }
        c cVar3 = this.f59224a;
        if (cVar3 == null) {
            kotlin.g.b.k.a();
        }
        cVar3.show();
        c cVar4 = this.f59224a;
        if (cVar4 == null) {
            kotlin.g.b.k.a();
        }
        cVar4.setOnKeyListener(new a(this));
    }

    public static final class a implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookLifecycleObserver f59226a;

        a(PassbookLifecycleObserver passbookLifecycleObserver) {
            this.f59226a = passbookLifecycleObserver;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return true;
            }
            c cVar = this.f59226a.f59224a;
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            cVar.dismiss();
            this.f59226a.f59225b.onBackPressed();
            return true;
        }
    }
}
