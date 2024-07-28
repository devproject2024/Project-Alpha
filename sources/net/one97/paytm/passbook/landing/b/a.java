package net.one97.paytm.passbook.landing.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.R;

public final class a extends com.google.android.material.bottomsheet.b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f57583a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f57584b;

    private View a(int i2) {
        if (this.f57584b == null) {
            this.f57584b = new HashMap();
        }
        View view = (View) this.f57584b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57584b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_wallet_activation_under_progress, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            z = arguments.getBoolean("is_activated", false);
        }
        this.f57583a = z;
        ((TextView) a(R.id.ok_got_it_tv)).setOnClickListener(new C1087a(this));
        if (!this.f57583a) {
            TextView textView = (TextView) a(R.id.under_process_tv);
            k.a((Object) textView, "under_process_tv");
            textView.setText(getString(R.string.activate_wallet_failed));
            TextView textView2 = (TextView) a(R.id.it_may_take_tv);
            k.a((Object) textView2, "it_may_take_tv");
            textView2.setText(getString(R.string.activate_wallet_please_try_again));
            if (getContext() != null) {
                ImageView imageView = (ImageView) a(R.id.kyc_status_cross_btn);
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.pass_ic_failed));
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(b.f57586a);
        return onCreateDialog;
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57586a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) findViewById);
                    k.a((Object) from, "BottomSheetBehavior.from<View>(bottomSheet)");
                    from.setState(3);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* renamed from: net.one97.paytm.passbook.landing.b.a$a  reason: collision with other inner class name */
    static final class C1087a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57585a;

        C1087a(a aVar) {
            this.f57585a = aVar;
        }

        public final void onClick(View view) {
            this.f57585a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57584b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
