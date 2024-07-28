package net.one97.paytm.passbook.genericPassbook.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f57451a = "/net/one97/paytm/passbook";

    /* renamed from: b  reason: collision with root package name */
    private final Context f57452b;

    public interface a {
        void a(NetworkCustomError networkCustomError);

        void a(CJRP2BStatus cJRP2BStatus);
    }

    public d(Context context) {
        k.c(context, "mContext");
        this.f57452b = context;
    }

    public static final class b implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57453a;

        b(a aVar) {
            this.f57453a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            k.c(iJRDataModel, Payload.RESPONSE);
            if (iJRDataModel instanceof CJRP2BStatus) {
                this.f57453a.a((CJRP2BStatus) iJRDataModel);
            }
        }
    }

    public static void a(AppCompatActivity appCompatActivity, a aVar) {
        k.c(appCompatActivity, "activity");
        k.c(aVar, "listener");
        net.one97.paytm.passbook.utility.e.a(appCompatActivity, new b(aVar), new c(aVar));
    }

    public static final class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57454a;

        c(a aVar) {
            this.f57454a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f57454a.a(networkCustomError);
        }
    }

    public final void a(Spanned spanned, AppCompatActivity appCompatActivity) {
        k.c(spanned, "message");
        k.c(appCompatActivity, "activity");
        View inflate = appCompatActivity.getLayoutInflater().inflate(R.layout.pass_layout_passbook_preauth_overlay, (ViewGroup) null);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this.f57452b);
        aVar.setContentView(inflate);
        k.a((Object) inflate, "bottomSheetView");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
            k.a((Object) from, "BottomSheetBehavior.from…SheetView.parent as View)");
            aVar.setOnDismissListener(new C1079d(from));
            from.setState(3);
            aVar.show();
            TextView textView = (TextView) inflate.findViewById(R.id.added_msg);
            k.a((Object) textView, "msgTxt");
            textView.setText(spanned);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) inflate.findViewById(R.id.passbooksendtobank_okgotit_tv)).setOnClickListener(new e(aVar));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.d.a.d$d  reason: collision with other inner class name */
    static final class C1079d implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f57455a;

        C1079d(BottomSheetBehavior bottomSheetBehavior) {
            this.f57455a = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f57455a.setState(4);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f57456a;

        e(com.google.android.material.bottomsheet.a aVar) {
            this.f57456a = aVar;
        }

        public final void onClick(View view) {
            k.c(view, "v");
            this.f57456a.dismiss();
        }
    }

    public final void a() {
        try {
            new HashMap().put(SDKConstants.EVENT_KEY_SCREEN_NAME, this.f57451a);
        } catch (Exception unused) {
        }
    }

    public static void b() {
        try {
            new HashMap().put("new_wallet_screen_type", "net/one97/paytm/passbook");
        } catch (Exception unused) {
        }
    }
}
