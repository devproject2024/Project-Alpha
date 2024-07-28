package net.one97.paytm.recharge.presentation.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class c extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f64735b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    String f64736a = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRPayChannelOptions f64737c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f64738d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f64739e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f64740f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f64741g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Object> f64742h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f64743i;

    public final View a(int i2) {
        if (this.f64743i == null) {
            this.f64743i = new HashMap();
        }
        View view = (View) this.f64743i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64743i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f64736a = str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CurvedCornerWithKeyboardBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("pay_channel") : null;
        if (!(serializable instanceof CJRPayChannelOptions)) {
            serializable = null;
        }
        this.f64737c = (CJRPayChannelOptions) serializable;
        Bundle arguments2 = getArguments();
        this.f64738d = arguments2 != null ? arguments2.getString("key_account") : null;
        Bundle arguments3 = getArguments();
        this.f64739e = arguments3 != null ? arguments3.getString("key_ifsc_code") : null;
        Bundle arguments4 = getArguments();
        this.f64741g = arguments4 != null ? arguments4.getString("key_account_holder_name") : null;
        Bundle arguments5 = getArguments();
        Serializable serializable2 = arguments5 != null ? arguments5.getSerializable("e_mandate_bundle") : null;
        if (!(serializable2 instanceof HashMap)) {
            serializable2 = null;
        }
        this.f64742h = (HashMap) serializable2;
        HashMap<String, Object> hashMap = this.f64742h;
        if (hashMap != null) {
            if (hashMap == null) {
                k.a();
            }
            if (hashMap.containsKey("ga_label_key")) {
                HashMap<String, Object> hashMap2 = this.f64742h;
                if (hashMap2 == null) {
                    k.a();
                }
                Object obj = hashMap2.get("ga_label_key");
                if (!(obj instanceof String)) {
                    obj = null;
                }
                this.f64740f = (String) obj;
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(3);
        }
        return onCreateDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_choose_authmode, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String channelName;
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_to_proceed);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setEnabled(false);
        }
        TextView textView = (TextView) a(R.id.tv_debit_card);
        String str2 = "";
        if (textView != null) {
            int i2 = R.string.select_debit_card_option;
            Object[] objArr = new Object[1];
            CJRPayChannelOptions cJRPayChannelOptions = this.f64737c;
            if (cJRPayChannelOptions == null || (str = cJRPayChannelOptions.getChannelName()) == null) {
                str = str2;
            }
            objArr[0] = str;
            textView.setText(getString(i2, objArr));
        }
        TextView textView2 = (TextView) a(R.id.tv_net_banking_card);
        if (textView2 != null) {
            int i3 = R.string.select_net_banking_option;
            Object[] objArr2 = new Object[1];
            CJRPayChannelOptions cJRPayChannelOptions2 = this.f64737c;
            if (!(cJRPayChannelOptions2 == null || (channelName = cJRPayChannelOptions2.getChannelName()) == null)) {
                str2 = channelName;
            }
            objArr2[0] = str2;
            textView2.setText(getString(i3, objArr2));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.debit_group);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new b(this));
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.net_banking_group);
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new C1276c(this));
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.debit_group);
        if (constraintLayout3 != null) {
            constraintLayout3.performClick();
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.btn_to_proceed);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setOnClickListener(new d(this));
        }
        ImageView imageView = (ImageView) a(R.id.ic_close);
        if (imageView != null) {
            imageView.setOnClickListener(new e(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64744a;

        b(c cVar) {
            this.f64744a = cVar;
        }

        public final void onClick(View view) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64744a.a(R.id.btn_to_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
            this.f64744a.a(SDKConstants.DEBIT);
            c.a(this.f64744a, 0);
        }
    }

    /* renamed from: net.one97.paytm.recharge.presentation.b.c$c  reason: collision with other inner class name */
    static final class C1276c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64745a;

        C1276c(c cVar) {
            this.f64745a = cVar;
        }

        public final void onClick(View view) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64745a.a(R.id.btn_to_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
            this.f64745a.a("NET_BANKING");
            c.a(this.f64745a, 1);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64746a;

        d(c cVar) {
            this.f64746a = cVar;
        }

        public final void onClick(View view) {
            if (this.f64746a.getActivity() != null) {
                c.a(this.f64746a);
                FragmentActivity activity = this.f64746a.getActivity();
                if (activity != null) {
                    Intent intent = new Intent(this.f64746a.getActivity(), AJRAutomaticEMandateConfirmationActivity.class);
                    intent.putExtra("choose_auth_mode", this.f64746a.f64736a);
                    intent.putExtra("pay_channel", this.f64746a.f64737c);
                    intent.putExtra("key_account", this.f64746a.f64738d);
                    intent.putExtra("key_ifsc_code", this.f64746a.f64739e);
                    intent.putExtra("ga_label_key", this.f64746a.f64740f);
                    intent.putExtra("key_account_holder_name", this.f64746a.f64741g);
                    if (this.f64746a.f64742h != null) {
                        intent.putExtra("e_mandate_bundle", this.f64746a.f64742h);
                    }
                    activity.startActivityForResult(intent, 1001);
                }
                this.f64746a.dismissAllowingStateLoss();
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64747a;

        e(c cVar) {
            this.f64747a = cVar;
        }

        public final void onClick(View view) {
            this.f64747a.dismissAllowingStateLoss();
        }
    }

    public static final /* synthetic */ void a(c cVar, int i2) {
        if (i2 == 0) {
            RadioButton radioButton = (RadioButton) cVar.a(R.id.radio_btn);
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            TextView textView = (TextView) cVar.a(R.id.tv_debit_card);
            if (textView != null) {
                textView.setTypeface((Typeface) null, 1);
            }
            RadioButton radioButton2 = (RadioButton) cVar.a(R.id.radio_btn_1);
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            TextView textView2 = (TextView) cVar.a(R.id.tv_net_banking_card);
            if (textView2 != null) {
                textView2.setTypeface((Typeface) null, 0);
            }
        } else if (i2 == 1) {
            RadioButton radioButton3 = (RadioButton) cVar.a(R.id.radio_btn_1);
            if (radioButton3 != null) {
                radioButton3.setChecked(true);
            }
            TextView textView3 = (TextView) cVar.a(R.id.tv_net_banking_card);
            if (textView3 != null) {
                textView3.setTypeface((Typeface) null, 1);
            }
            RadioButton radioButton4 = (RadioButton) cVar.a(R.id.radio_btn);
            if (radioButton4 != null) {
                radioButton4.setChecked(false);
            }
            TextView textView4 = (TextView) cVar.a(R.id.tv_debit_card);
            if (textView4 != null) {
                textView4.setTypeface((Typeface) null, 0);
            }
        }
        net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
        FragmentActivity activity = cVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context context = activity;
        a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
        a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        String G = net.one97.paytm.recharge.automatic.b.a.a.J;
        String str = cVar.f64740f;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, G, "", str2, net.one97.paytm.recharge.automatic.b.a.a.P, cVar.f64736a);
    }

    public static final /* synthetic */ void a(c cVar) {
        try {
            if (cVar.getActivity() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                FragmentActivity activity = cVar.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                Context context = activity;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String H = net.one97.paytm.recharge.automatic.b.a.a.K;
                String str = cVar.f64740f;
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, H, "", str2, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
            }
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64743i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
