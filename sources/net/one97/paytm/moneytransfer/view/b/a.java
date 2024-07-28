package net.one97.paytm.moneytransfer.view.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final C0974a f54376a = new C0974a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f54377b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f54378c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f54379d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f54380e;

    /* renamed from: f  reason: collision with root package name */
    private String f54381f = "";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f54382g;

    public interface d {
        void onDismiss();
    }

    public final void a(d dVar) {
        k.c(dVar, "listener");
        this.f54377b = dVar;
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.dialog_upi_security, viewGroup, false);
        Bundle arguments = getArguments();
        this.f54378c = arguments != null ? arguments.getBoolean("from_scan_pay") : false;
        Bundle arguments2 = getArguments();
        this.f54379d = arguments2 != null ? arguments2.getBoolean("mid_scan_pay") : false;
        Bundle arguments3 = getArguments();
        this.f54380e = arguments3 != null ? arguments3.getBoolean("IS_FROM_COLLECT", false) : false;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("collect_vpa")) == null) {
            str = "";
        }
        this.f54381f = str;
        if (this.f54378c) {
            PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context!!.applicationContext");
            String b2 = companion.getPref(applicationContext).b("userName", "", true);
            if (TextUtils.isEmpty(b2)) {
                View findViewById = inflate.findViewById(R.id.tv_header);
                k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_header)");
                ((TextView) findViewById).setText(getString(R.string.upi_scan_pay_empty_header));
            } else {
                View findViewById2 = inflate.findViewById(R.id.tv_header);
                k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.tv_header)");
                TextView textView = (TextView) findViewById2;
                aa aaVar = aa.f47921a;
                String string = getString(R.string.upi_scan_pay_header);
                k.a((Object) string, "getString(R.string.upi_scan_pay_header)");
                Object[] objArr = new Object[1];
                String a2 = f.a(b2);
                if (a2 == null) {
                    k.a();
                }
                objArr[0] = a2;
                String format = String.format(string, Arrays.copyOf(objArr, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                textView.setText(format);
            }
            View findViewById3 = inflate.findViewById(R.id.blue_bg_view);
            k.a((Object) findViewById3, "view.findViewById<View>(R.id.blue_bg_view)");
            findViewById3.getBackground().setColorFilter(Color.parseColor("#e6faff"), PorterDuff.Mode.SRC_ATOP);
            k.a((Object) inflate, "view");
            ((ImageView) inflate.findViewById(R.id.ivIcon)).setImageDrawable(androidx.core.content.b.a(inflate.getContext(), R.drawable.ic_scan_and_pay_popup_bg));
            Bundle arguments5 = getArguments();
            String string2 = arguments5 != null ? arguments5.getString("name") : null;
            if (TextUtils.isEmpty(string2)) {
                string2 = "";
            }
            View findViewById4 = inflate.findViewById(R.id.tv_heading);
            k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.tv_heading)");
            TextView textView2 = (TextView) findViewById4;
            aa aaVar2 = aa.f47921a;
            String string3 = getString(R.string.upi_scan_pay_dialog_info_header);
            k.a((Object) string3, "getString(R.string.upi_s…n_pay_dialog_info_header)");
            Object[] objArr2 = new Object[1];
            String a3 = f.a(string2);
            if (a3 == null) {
                k.a();
            }
            objArr2[0] = a3;
            String format2 = String.format(string3, Arrays.copyOf(objArr2, 1));
            k.a((Object) format2, "java.lang.String.format(format, *args)");
            textView2.setText(format2);
            View findViewById5 = inflate.findViewById(R.id.tv_desc);
            k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.tv_desc)");
            ((TextView) findViewById5).setText(getString(R.string.upi_gallery_scan_alert_info));
            ((TextView) inflate.findViewById(R.id.tv_desc)).setTextColor(androidx.core.content.b.c(inflate.getContext(), R.color.color_popup_text));
        } else {
            Bundle arguments6 = getArguments();
            if (arguments6 == null || !arguments6.getBoolean("from_upi_landing")) {
                View findViewById6 = inflate.findViewById(R.id.tv_got_it);
                k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.tv_got_it)");
                ((TextView) findViewById6).setText(getString(R.string.upi_proceed_to_pay));
                View findViewById7 = inflate.findViewById(R.id.ivCross);
                k.a((Object) findViewById7, "view.findViewById<ImageView>(R.id.ivCross)");
                ((ImageView) findViewById7).setVisibility(0);
                View findViewById8 = inflate.findViewById(R.id.tv_desc);
                k.a((Object) findViewById8, "view.findViewById<TextView>(R.id.tv_desc)");
                ((TextView) findViewById8).setGravity(17);
            } else {
                View findViewById9 = inflate.findViewById(R.id.tv_desc);
                k.a((Object) findViewById9, "view.findViewById<TextView>(R.id.tv_desc)");
                ((TextView) findViewById9).setGravity(17);
                setCancelable(false);
            }
        }
        ((TextView) inflate.findViewById(R.id.tv_got_it)).setOnClickListener(new b(this, inflate));
        ((ImageView) inflate.findViewById(R.id.ivCross)).setOnClickListener(new c(this));
        if (!this.f54378c) {
            CJRSendGTMTag.sendCustomGTMEvents(getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "upi_security_pop_show", "", "", "", "");
        }
        if (this.f54380e) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext(), Events.Category.COLLECT, "security_pop_up_shown", "", "", "", this.f54381f, "", Events.Screen.SECURITY_POPUP, "");
        }
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54383a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f54384b;

        b(a aVar, View view) {
            this.f54383a = aVar;
            this.f54384b = view;
        }

        public final void onClick(View view) {
            boolean z;
            View findViewById = this.f54384b.findViewById(R.id.checkbox);
            k.a((Object) findViewById, "view.findViewById<CheckBox>(R.id.checkbox)");
            if (((CheckBox) findViewById).isChecked()) {
                z = true;
                if (!this.f54383a.f54378c) {
                    PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
                    Context context = this.f54383a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    Context applicationContext = context.getApplicationContext();
                    k.a((Object) applicationContext, "context!!.applicationContext");
                    companion.getPref(applicationContext).a(UpiConstants.PREF_UPI_SECURITY_POPUP, false, false);
                } else {
                    PaytmUpiPrefUtil.Companion companion2 = PaytmUpiPrefUtil.Companion;
                    Context context2 = this.f54383a.getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    k.a((Object) context2, "context!!");
                    Context applicationContext2 = context2.getApplicationContext();
                    k.a((Object) applicationContext2, "context!!.applicationContext");
                    companion2.getPref(applicationContext2).a(UpiConstants.PREF_UPI_SCAN_PAY_POPUP, false, false);
                }
            } else {
                z = false;
            }
            a.a(this.f54383a, z);
            d b2 = this.f54383a.f54377b;
            if (b2 != null) {
                b2.onDismiss();
            }
            this.f54383a.dismissAllowingStateLoss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54385a;

        c(a aVar) {
            this.f54385a = aVar;
        }

        public final void onClick(View view) {
            this.f54385a.dismissAllowingStateLoss();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        CheckBox checkBox;
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.f54378c) {
            View view = getView();
            if (view == null || (checkBox = (CheckBox) view.findViewById(R.id.checkbox)) == null || !checkBox.isChecked()) {
                a(false);
            } else {
                a(true);
            }
        }
    }

    private final void a(boolean z) {
        CJRSendGTMTag.sendCustomGTMEvents(getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "upi_security_pop_not_show_again", String.valueOf(z), "", "", "");
        if (this.f54380e) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext(), Events.Category.COLLECT, "security_pop_checked_box_not_show_again", String.valueOf(z), "", "", this.f54381f, "", Events.Screen.SECURITY_POPUP, "");
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.b.a$a  reason: collision with other inner class name */
    public static final class C0974a {
        private C0974a() {
        }

        public /* synthetic */ C0974a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(a aVar, boolean z) {
        a aVar2 = aVar;
        if (!z || !aVar2.f54378c) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(aVar.getContext(), Events.Category.COLLECT, Events.Action.SECURITY_POPUP_PROCEED_CLICKED, "", "", "", aVar2.f54381f, String.valueOf(z), Events.Screen.SECURITY_POPUP, "");
        } else if (aVar2.f54379d) {
            CJRSendGTMTag.sendCustomGTMEvents(aVar.getContext(), "mt_p2p_new_v1", "gallery_security_pop_not_show_again", "flow_through_scan_icon", "", Events.Screen.SECURITY_POPUP, "");
        } else {
            CJRSendGTMTag.sendCustomGTMEvents(aVar.getContext(), "mt_p2p_new_v1", "gallery_security_pop_not_show_again", "flow_through_pay_icon", "", Events.Screen.SECURITY_POPUP, "");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54382g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
