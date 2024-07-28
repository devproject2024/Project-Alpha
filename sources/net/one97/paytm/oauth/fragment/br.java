package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.p;

public final class br extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56514a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f56515b;

    private View a(int i2) {
        if (this.f56515b == null) {
            this.f56515b = new HashMap();
        }
        View view = (View) this.f56515b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56515b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56516a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(R.id.design_bottom_sheet);
                if (findViewById2 == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheetInternal!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(b.f56516a);
        }
        return layoutInflater.inflate(net.one97.paytm.oauth.R.layout.fragment_sim_changed_bottom, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OauthModule.b().sendOpenScreenWithDeviceInfo("/sim-card-change", p.f56796a, getContext());
        a("sim_card_changed_popup_loaded", new ArrayList());
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(net.one97.paytm.oauth.R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(net.one97.paytm.oauth.R.id.btnProceed);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(net.one97.paytm.oauth.R.id.lblUpdateLater);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = net.one97.paytm.oauth.R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("sim_card_changed_popup_cancelled", new ArrayList());
            dismissAllowingStateLoss();
            return;
        }
        int i3 = net.one97.paytm.oauth.R.id.lblUpdateLater;
        if (valueOf != null && valueOf.intValue() == i3) {
            a("update_later_from_profile_clicked", new ArrayList());
            net.one97.paytm.oauth.utils.a.a aVar = net.one97.paytm.oauth.utils.a.a.f56764a;
            net.one97.paytm.oauth.utils.a.a.b(getActivity());
            dismissAllowingStateLoss();
            return;
        }
        int i4 = net.one97.paytm.oauth.R.id.btnProceed;
        if (valueOf != null && valueOf.intValue() == i4) {
            a("proceed_to_update_number_clicked", new ArrayList());
            OauthModule.b().openProfileActivity(getActivity());
            dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "sim_card_change", str, arrayList, (String) null, "/sim-card-change", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56515b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
