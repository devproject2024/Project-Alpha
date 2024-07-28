package net.one97.paytm.oauth.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.h;
import net.one97.paytm.oauth.view.OTPPasteEditText;

public final class OtpView extends ConstraintLayout implements TextWatcher, View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<OTPPasteEditText> f56835a;

    /* renamed from: b  reason: collision with root package name */
    private a f56836b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnFocusChangeListener f56837c;

    /* renamed from: d  reason: collision with root package name */
    private final OTPPasteEditText.a f56838d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f56839e;

    public interface a {
        void a(Editable editable, boolean z);
    }

    public OtpView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    private View a(int i2) {
        if (this.f56839e == null) {
            this.f56839e = new HashMap();
        }
        View view = (View) this.f56839e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f56839e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        boolean z2;
        k.c(context, "context");
        View a2 = h.a(this, R.layout.e_otp_view);
        a2.setId(View.generateViewId());
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        addView(a2);
        cVar.b((ConstraintLayout) this);
        h.a(cVar, a2, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.OtpView);
            z = obtainStyledAttributes.getBoolean(R.styleable.OtpView_enableFields, true);
            z2 = obtainStyledAttributes.getBoolean(R.styleable.OtpView_enableTransformation, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
            z2 = true;
        }
        OTPPasteEditText oTPPasteEditText = (OTPPasteEditText) a(R.id.editext1);
        k.a((Object) oTPPasteEditText, "editext1");
        OTPPasteEditText oTPPasteEditText2 = (OTPPasteEditText) a(R.id.editext2);
        k.a((Object) oTPPasteEditText2, "editext2");
        OTPPasteEditText oTPPasteEditText3 = (OTPPasteEditText) a(R.id.editext3);
        k.a((Object) oTPPasteEditText3, "editext3");
        OTPPasteEditText oTPPasteEditText4 = (OTPPasteEditText) a(R.id.editext4);
        k.a((Object) oTPPasteEditText4, "editext4");
        OTPPasteEditText oTPPasteEditText5 = (OTPPasteEditText) a(R.id.editext5);
        k.a((Object) oTPPasteEditText5, "editext5");
        OTPPasteEditText oTPPasteEditText6 = (OTPPasteEditText) a(R.id.editext6);
        k.a((Object) oTPPasteEditText6, "editext6");
        this.f56835a = kotlin.a.k.d(oTPPasteEditText, oTPPasteEditText2, oTPPasteEditText3, oTPPasteEditText4, oTPPasteEditText5, oTPPasteEditText6);
        b bVar = new b();
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        Iterator<OTPPasteEditText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            OTPPasteEditText next = it2.next();
            if (z2) {
                k.a((Object) next, "editText");
                next.setTransformationMethod(bVar);
            }
            if (!z) {
                k.a((Object) next, "editText");
                next.setEnabled(false);
            }
            k.a((Object) next, "editText");
            next.setOnFocusChangeListener(this.f56837c);
            next.addTextChangedListener(this);
            next.setOnKeyListener(this);
            next.setOTPListner(this.f56838d);
        }
        this.f56837c = b.f56840a;
        this.f56838d = new c(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtpView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final /* synthetic */ ArrayList a(OtpView otpView) {
        ArrayList<OTPPasteEditText> arrayList = otpView.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        return arrayList;
    }

    public final a getOtpTextChangeListener() {
        return this.f56836b;
    }

    public final void setOtpTextChangeListener(a aVar) {
        this.f56836b = aVar;
    }

    public final void setOtp(String str) {
        k.c(str, "otp");
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        int i2 = 0;
        for (OTPPasteEditText text : arrayList) {
            text.setText(String.valueOf(str.charAt(i2)));
            i2++;
        }
    }

    public final String getOtp() {
        StringBuilder sb = new StringBuilder();
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<OTPPasteEditText> arrayList2 = this.f56835a;
            if (arrayList2 == null) {
                k.a("otpEditViewsArr");
            }
            OTPPasteEditText oTPPasteEditText = arrayList2.get(i2);
            k.a((Object) oTPPasteEditText, "otpEditViewsArr[i]");
            sb.append(oTPPasteEditText.getText());
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "sb.toString()");
        if (sb2 != null) {
            return p.b(sb2).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56840a = new b();

        b() {
        }

        public final void onFocusChange(View view, boolean z) {
            Context context;
            int i2;
            if (view != null) {
                EditText editText = (EditText) view;
                if (z) {
                    context = editText.getContext();
                    i2 = R.color.color_00b9f5;
                } else {
                    context = editText.getContext();
                    i2 = R.color.color_002e6e;
                }
                editText.setTextColor(androidx.core.content.b.c(context, i2));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.EditText");
        }
    }

    static final class c implements OTPPasteEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OtpView f56841a;

        c(OtpView otpView) {
            this.f56841a = otpView;
        }

        public final void a(String str) {
            int i2 = 0;
            for (OTPPasteEditText text : OtpView.a(this.f56841a)) {
                text.setText(String.valueOf(str.charAt(i2)));
                i2++;
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
        boolean z;
        k.c(editable, "s");
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        Iterator<OTPPasteEditText> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            OTPPasteEditText next = it2.next();
            k.a((Object) next, "editText");
            if (TextUtils.isEmpty(next.getText().toString())) {
                z = false;
                break;
            }
        }
        ArrayList<OTPPasteEditText> arrayList2 = this.f56835a;
        if (arrayList2 == null) {
            k.a("otpEditViewsArr");
        }
        Iterator<OTPPasteEditText> it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            OTPPasteEditText next2 = it3.next();
            k.a((Object) next2, "editText");
            if (TextUtils.isEmpty(next2.getText().toString())) {
                next2.requestFocus();
                break;
            }
        }
        a aVar = this.f56836b;
        if (aVar != null) {
            aVar.a(editable, z);
        }
    }

    public final void a() {
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        Iterator<OTPPasteEditText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().setText("");
        }
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        k.c(view, "v");
        k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (i2 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        EditText editText = null;
        ArrayList<OTPPasteEditText> arrayList = this.f56835a;
        if (arrayList == null) {
            k.a("otpEditViewsArr");
        }
        Iterator<OTPPasteEditText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            OTPPasteEditText next = it2.next();
            if (k.a((Object) view, (Object) next)) {
                k.a((Object) next, "editText");
                EditText editText2 = next;
                if (!TextUtils.isEmpty(editText2.getText().toString())) {
                    editText2.setText("");
                } else {
                    if (editText != null) {
                        editText.setText("");
                    }
                    if (editText != null) {
                        editText.setEnabled(true);
                    }
                    if (editText != null) {
                        editText.requestFocus();
                    }
                }
            }
            editText = next;
        }
        return true;
    }
}
