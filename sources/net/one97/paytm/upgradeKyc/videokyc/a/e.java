package net.one97.paytm.upgradeKyc.videokyc.a;

import android.app.Dialog;
import android.content.Context;
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
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;

public final class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66377a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private b f66378b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f66379c;

    public interface b {
        void d();

        void e();
    }

    private View a(int i2) {
        if (this.f66379c == null) {
            this.f66379c = new HashMap();
        }
        View view = (View) this.f66379c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f66379c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ b a(e eVar) {
        b bVar = eVar.f66378b;
        if (bVar == null) {
            k.a("mHost");
        }
        return bVar;
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
        return layoutInflater.inflate(R.layout.dialog_pan_essential, viewGroup, true);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66378b = (b) context;
            return;
        }
        throw new IllegalAccessException(context + " must implement PanEssentialInteractionListener");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new c(this));
        ((TextView) a(R.id.tv_ctn_without_pan)).setOnClickListener(new d(this));
        ((Button) a(R.id.btn_goback)).setOnClickListener(new C1334e(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f66380a;

        c(e eVar) {
            this.f66380a = eVar;
        }

        public final void onClick(View view) {
            if (this.f66380a.getContext() != null && (this.f66380a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66380a.getContext();
                if (!(context instanceof UpgradeKycBaseActivity)) {
                    context = null;
                }
                UpgradeKycBaseActivity upgradeKycBaseActivity = (UpgradeKycBaseActivity) context;
                if (upgradeKycBaseActivity != null) {
                    upgradeKycBaseActivity.b("go_back_clicked", "/kyc/video_kyc/pan_verify/form60_instruction");
                }
            }
            this.f66380a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f66381a;

        d(e eVar) {
            this.f66381a = eVar;
        }

        public final void onClick(View view) {
            if (this.f66381a.getContext() != null && (this.f66381a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66381a.getContext();
                if (!(context instanceof UpgradeKycBaseActivity)) {
                    context = null;
                }
                UpgradeKycBaseActivity upgradeKycBaseActivity = (UpgradeKycBaseActivity) context;
                if (upgradeKycBaseActivity != null) {
                    upgradeKycBaseActivity.b("form60_flow", "/kyc/video_kyc/pan_verify/form60_instruction");
                }
            }
            e.a(this.f66381a).e();
            this.f66381a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.a.e$e  reason: collision with other inner class name */
    static final class C1334e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f66382a;

        C1334e(e eVar) {
            this.f66382a = eVar;
        }

        public final void onClick(View view) {
            if (this.f66382a.getContext() != null && (this.f66382a.getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = this.f66382a.getContext();
                if (!(context instanceof UpgradeKycBaseActivity)) {
                    context = null;
                }
                UpgradeKycBaseActivity upgradeKycBaseActivity = (UpgradeKycBaseActivity) context;
                if (upgradeKycBaseActivity != null) {
                    upgradeKycBaseActivity.b("go_back_clicked", "/kyc/video_kyc/pan_verify/form60_instruction");
                }
            }
            e.a(this.f66382a).d();
            this.f66382a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66379c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
