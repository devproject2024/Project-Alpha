package net.one97.paytm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public final class aa extends f {

    /* renamed from: a  reason: collision with root package name */
    boolean f51959a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f51960b;

    public final int getTheme() {
        return R.style.ProfileBottomSheetDialogTheme;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return layoutInflater.inflate(R.layout.screen_recorder_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.recorderOkBtn;
        if (this.f51960b == null) {
            this.f51960b = new HashMap();
        }
        View view3 = (View) this.f51960b.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((Button) view2).setOnClickListener(new a(this));
            }
            view3 = view4.findViewById(i2);
            this.f51960b.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((Button) view2).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f51961a;

        a(aa aaVar) {
            this.f51961a = aaVar;
        }

        public final void onClick(View view) {
            aa aaVar = this.f51961a;
            aaVar.f51959a = true;
            FragmentActivity activity = aaVar.getActivity();
            if (activity != null) {
                com.paytm.b.a.a a2 = ((AJRScreenRecordingActivity) activity).a();
                a2.a("screen_disable_recording", false, true);
                Calendar instance = Calendar.getInstance();
                k.a((Object) instance, "Calendar.getInstance()");
                a2.a("screen_enable_time", instance.getTimeInMillis(), true);
                FragmentActivity activity2 = this.f51961a.getActivity();
                if (activity2 != null) {
                    ((AJRScreenRecordingActivity) activity2).a(1800000);
                    net.one97.paytm.j.a.a((Context) this.f51961a.getActivity(), "allow_screen_recording", "Okay_clicked", "", "", "", "");
                    this.f51961a.dismiss();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.AJRScreenRecordingActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.AJRScreenRecordingActivity");
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        if (!this.f51959a) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRScreenRecordingActivity) activity).b();
                net.one97.paytm.j.a.a((Context) getActivity(), "allow_screen_recording", "popup_closed", "", "", "", "");
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.AJRScreenRecordingActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f51960b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
