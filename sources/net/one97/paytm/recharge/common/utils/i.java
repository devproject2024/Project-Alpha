package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.fragment.d;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public final class i extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61643a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<b> f61644b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f61645c;

    public interface b {
        void b();
    }

    public final View a(int i2) {
        if (this.f61645c == null) {
            this.f61645c = new HashMap();
        }
        View view = (View) this.f61645c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61645c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f61645c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i a(b bVar, CJRCreditCardModelV8 cJRCreditCardModelV8, String str) {
            k.c(bVar, "listener");
            k.c(str, "amount");
            i.f61644b = new WeakReference(bVar);
            Bundle bundle = new Bundle();
            bundle.putSerializable("selectedVariant", cJRCreditCardModelV8);
            bundle.putString("amount", str);
            i iVar = new i();
            iVar.setArguments(bundle);
            return iVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_confirm_bottom_sheet, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            CJRCreditCardModelV8 cJRCreditCardModelV8 = (CJRCreditCardModelV8) arguments.getSerializable("selectedVariant");
            String str2 = null;
            if (cJRCreditCardModelV8 != null) {
                TextView textView = (TextView) a(R.id.info_txt_view);
                if (textView != null) {
                    Context context = getContext();
                    if (context != null) {
                        int i2 = R.string.confirm_credit_card_header_text;
                        Object[] objArr = new Object[1];
                        Bundle arguments2 = getArguments();
                        if (arguments2 == null) {
                            k.a();
                        }
                        objArr[0] = arguments2.getString("amount");
                        str = context.getString(i2, objArr);
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                }
                TextView textView2 = (TextView) a(R.id.credit_card_number);
                k.a((Object) textView2, "credit_card_number");
                textView2.setText(cJRCreditCardModelV8.getDisplayCardNumber());
                TextView textView3 = (TextView) a(R.id.bank_name);
                k.a((Object) textView3, PayUtility.BANK_NAME);
                textView3.setText(cJRCreditCardModelV8.getBankName());
                w.a().a(cJRCreditCardModelV8.getOperaterImage()).a((ImageView) a(R.id.img_bank));
            }
            View.OnClickListener onClickListener = this;
            ((TextView) a(R.id.proceed_btn)).setOnClickListener(onClickListener);
            ((ImageView) a(R.id.ic_cross)).setOnClickListener(onClickListener);
            TextView textView4 = (TextView) a(R.id.proceed_btn);
            k.a((Object) textView4, "proceed_btn");
            Context context2 = getContext();
            if (context2 != null) {
                int i3 = R.string.proceed_btn_ff_selected;
                Object[] objArr2 = new Object[1];
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    k.a();
                }
                objArr2[0] = arguments3.getString("amount");
                str2 = context2.getString(i3, objArr2);
            }
            textView4.setText(str2);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        WeakReference<b> weakReference = f61644b;
        if (weakReference != null) {
            weakReference.clear();
        }
        a();
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.proceed_btn;
        if (valueOf != null && valueOf.intValue() == i2) {
            WeakReference<b> weakReference = f61644b;
            if (weakReference != null) {
                if (weakReference == null) {
                    k.a();
                }
                if (weakReference.get() != null) {
                    WeakReference<b> weakReference2 = f61644b;
                    if (weakReference2 == null) {
                        k.a();
                    }
                    b bVar = (b) weakReference2.get();
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            }
            dismiss();
            return;
        }
        int i3 = R.id.ic_cross;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
        }
    }
}
