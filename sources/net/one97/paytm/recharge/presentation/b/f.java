package net.one97.paytm.recharge.presentation.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64764a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f64765g;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f64766b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f64767c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f64768d;

    /* renamed from: e  reason: collision with root package name */
    private String f64769e;

    /* renamed from: f  reason: collision with root package name */
    private String f64770f;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64771h;

    private View a(int i2) {
        if (this.f64771h == null) {
            this.f64771h = new HashMap();
        }
        View view = (View) this.f64771h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64771h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            f fVar = new f();
            Bundle bundle = new Bundle();
            bundle.putString("operator_logo", str3);
            bundle.putString("operator_name", str2);
            bundle.putString("recharge_number", str);
            bundle.putString("nick_name", str4);
            bundle.putString(CLPConstants.PRODUCT_ID, str5);
            bundle.putString("service_paytype", str6);
            a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            bundle.putString(net.one97.paytm.recharge.automatic.b.a.a.f60240b, str7);
            fVar.setArguments(bundle);
            return fVar;
        }
    }

    static {
        String simpleName = f.class.getSimpleName();
        k.a((Object) simpleName, "CJROperatorConfirmationB…et::class.java.simpleName");
        f64765g = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomImpsBottomSheetDialogTheme);
        try {
            if (getContext() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                String str = this.f64770f;
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, str2, net.one97.paytm.recharge.automatic.b.a.a.m, "", "mobile_postpaid", (Object) null, (Object) null, 96);
            }
        } catch (Throwable unused) {
        }
        Bundle arguments = getArguments();
        String str3 = null;
        this.f64769e = arguments != null ? arguments.getString("service_paytype", (String) null) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            str3 = arguments2.getString(net.one97.paytm.recharge.automatic.b.a.a.f60240b, (String) null);
        }
        this.f64770f = str3;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_operator_detail_confirmation, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = null;
        Window window2 = dialog != null ? dialog.getWindow() : null;
        if (window2 == null) {
            k.a();
        }
        k.a((Object) window2, "dialog?.window!!");
        window2.getDecorView().findViewById(com.google.android.material.R.id.touch_outside).setOnClickListener((View.OnClickListener) null);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            window = dialog2.getWindow();
        }
        if (window == null) {
            k.a();
        }
        k.a((Object) window, "dialog?.window!!");
        BottomSheetBehavior from = BottomSheetBehavior.from(window.getDecorView().findViewById(com.google.android.material.R.id.design_bottom_sheet));
        k.a((Object) from, "BottomSheetBehavior.from(bottomSheetView)");
        from.setHideable(false);
    }

    public final f a(View.OnClickListener onClickListener) {
        k.c(onClickListener, "listener");
        this.f64766b = onClickListener;
        return this;
    }

    public final f b(View.OnClickListener onClickListener) {
        k.c(onClickListener, "listener");
        this.f64767c = onClickListener;
        return this;
    }

    public final f c(View.OnClickListener onClickListener) {
        k.c(onClickListener, "listener");
        this.f64768d = onClickListener;
        return this;
    }

    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        TextView textView = (TextView) a(R.id.txt_payment_automatic_update_operator);
        if (k.a((Object) valueOf, (Object) textView != null ? Integer.valueOf(textView.getId()) : null)) {
            dismissAllowingStateLoss();
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                String str5 = this.f64770f;
                if (str5 == null) {
                    str3 = "";
                } else {
                    str3 = str5;
                }
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String k = net.one97.paytm.recharge.automatic.b.a.a.n;
                String str6 = this.f64769e;
                if (str6 == null) {
                    str4 = "";
                } else {
                    str4 = str6;
                }
                net.one97.paytm.recharge.automatic.c.a.a.a(context, str3, k, "", str4, (Object) null, (Object) null, 96);
            } catch (Throwable unused) {
            }
            View.OnClickListener onClickListener = this.f64766b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) a(R.id.btn_payment_automatic_confirm);
        if (k.a((Object) valueOf, (Object) textView2 != null ? Integer.valueOf(textView2.getId()) : null)) {
            dismissAllowingStateLoss();
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "context!!");
                String str7 = this.f64770f;
                if (str7 == null) {
                    str = "";
                } else {
                    str = str7;
                }
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String l = net.one97.paytm.recharge.automatic.b.a.a.o;
                String str8 = this.f64769e;
                if (str8 == null) {
                    str2 = "";
                } else {
                    str2 = str8;
                }
                net.one97.paytm.recharge.automatic.c.a.a.a(context2, str, l, "", str2, (Object) null, (Object) null, 96);
            } catch (Throwable unused2) {
            }
            View.OnClickListener onClickListener2 = this.f64767c;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
                return;
            }
            return;
        }
        ImageView imageView = (ImageView) a(R.id.ic_payment_automatic_cross);
        if (imageView != null) {
            num = Integer.valueOf(imageView.getId());
        }
        if (k.a((Object) valueOf, (Object) num)) {
            dismissAllowingStateLoss();
            View.OnClickListener onClickListener3 = this.f64768d;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        TextView textView = (TextView) a(R.id.txt_operator_number);
        String str = null;
        if (textView != null) {
            Bundle arguments = getArguments();
            textView.setText(arguments != null ? arguments.getString("recharge_number") : null);
        }
        TextView textView2 = (TextView) a(R.id.txt_operator_type);
        if (textView2 != null) {
            Bundle arguments2 = getArguments();
            textView2.setText(arguments2 != null ? arguments2.getString("operator_name") : null);
        }
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("operator_logo") : null;
        if (!TextUtils.isEmpty(string)) {
            w.a().a(string).a((ImageView) a(R.id.ic_operator_icon));
        } else {
            ((ImageView) a(R.id.ic_operator_icon)).setImageResource(0);
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str = arguments4.getString("nick_name");
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView3 = (TextView) a(R.id.txt_name);
            k.a((Object) textView3, "txt_name");
            textView3.setText(charSequence);
            TextView textView4 = (TextView) a(R.id.txt_name);
            k.a((Object) textView4, "txt_name");
            textView4.setVisibility(0);
        } else {
            TextView textView5 = (TextView) a(R.id.txt_name);
            k.a((Object) textView5, "txt_name");
            textView5.setText("");
            TextView textView6 = (TextView) a(R.id.txt_name);
            k.a((Object) textView6, "txt_name");
            textView6.setVisibility(8);
        }
        TextView textView7 = (TextView) a(R.id.btn_payment_automatic_confirm);
        if (textView7 != null) {
            textView7.setOnClickListener(this);
        }
        TextView textView8 = (TextView) a(R.id.txt_payment_automatic_update_operator);
        if (textView8 != null) {
            textView8.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) a(R.id.ic_payment_automatic_cross);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64771h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
