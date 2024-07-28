package net.one97.paytm.paymentsBank.biometricAuthWall;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final C0265a f17441a = new C0265a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17442b;

    private View a(int i2) {
        if (this.f17442b == null) {
            this.f17442b = new HashMap();
        }
        View view = (View) this.f17442b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17442b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        setStyle(1, 16973936);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ask_for_fingerprint_fragment, viewGroup, true);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) a(R.id.iv_finger);
        k.a((Object) imageView, "iv_finger");
        imageView.setVisibility(8);
        TextView textView = (TextView) a(R.id.tv1);
        k.a((Object) textView, "tv1");
        textView.setText(getString(R.string.pb_paytm_bank_authentication));
        TextView textView2 = (TextView) a(R.id.tv2);
        k.a((Object) textView2, "tv2");
        textView2.setText(getString(R.string.pb_please_enable_fingerprint_in));
        Button button = (Button) a(R.id.btn_enable);
        k.a((Object) button, "btn_enable");
        button.setText(getString(R.string.pb_go_to_settings));
        ((Button) a(R.id.btn_enable)).setOnClickListener(new b(this));
        ((TextView) a(R.id.tv_do_it_later)).setOnClickListener(new c(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17443a;

        b(a aVar) {
            this.f17443a = aVar;
        }

        public final void onClick(View view) {
            if (this.f17443a.isAdded()) {
                this.f17443a.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                this.f17443a.dismiss();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17444a;

        c(a aVar) {
            this.f17444a = aVar;
        }

        public final void onClick(View view) {
            if (this.f17444a.isAdded()) {
                this.f17444a.dismiss();
            }
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.biometricAuthWall.a$a  reason: collision with other inner class name */
    public static final class C0265a {
        private C0265a() {
        }

        public /* synthetic */ C0265a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17442b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
