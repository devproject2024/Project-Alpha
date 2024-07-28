package net.one97.paytm.upgradeKyc.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;

public final class q extends h {

    /* renamed from: a  reason: collision with root package name */
    private final a f65740a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    private final b f65741b = new b(this);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f65742c;

    public final View b(int i2) {
        if (this.f65742c == null) {
            this.f65742c = new HashMap();
        }
        View view = (View) this.f65742c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65742c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_otp_editboxes_lyt, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((EditText) b(R.id.edit_otp_char1)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char2)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char3)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char4)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char5)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char6)).addTextChangedListener(this.f65741b);
        ((EditText) b(R.id.edit_otp_char1)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char2)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char3)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char4)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char5)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char6)).setOnKeyListener(this.f65740a);
        ((EditText) b(R.id.edit_otp_char1)).requestFocus();
        a(1);
    }

    public static final class a implements View.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f65743a;

        a(q qVar) {
            this.f65743a = qVar;
        }

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            k.c(view, "v");
            k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (i2 != 67 || keyEvent.getAction() != 0) {
                return false;
            }
            if (k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char1))) {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char1), (EditText) null);
                return true;
            } else if (k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char2))) {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char2), (EditText) this.f65743a.b(R.id.edit_otp_char1));
                return true;
            } else if (k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char3))) {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char3), (EditText) this.f65743a.b(R.id.edit_otp_char2));
                return true;
            } else if (k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char4))) {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char4), (EditText) this.f65743a.b(R.id.edit_otp_char3));
                return true;
            } else if (k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char5))) {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char5), (EditText) this.f65743a.b(R.id.edit_otp_char4));
                return true;
            } else if (!k.a((Object) view, (Object) (EditText) this.f65743a.b(R.id.edit_otp_char6))) {
                return true;
            } else {
                q.a((EditText) this.f65743a.b(R.id.edit_otp_char6), (EditText) this.f65743a.b(R.id.edit_otp_char5));
                return true;
            }
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f65744a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        b(q qVar) {
            this.f65744a = qVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            TextView textView = (TextView) this.f65744a.b(R.id.error_otp_tv);
            k.a((Object) textView, "error_otp_tv");
            textView.setVisibility(8);
            EditText editText = (EditText) this.f65744a.b(R.id.edit_otp_char1);
            k.a((Object) editText, "edit_otp_char1");
            if (editText.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char1)).requestFocus();
                this.f65744a.a(1);
                return;
            }
            EditText editText2 = (EditText) this.f65744a.b(R.id.edit_otp_char2);
            k.a((Object) editText2, "edit_otp_char2");
            if (editText2.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char2)).requestFocus();
                EditText editText3 = (EditText) this.f65744a.b(R.id.edit_otp_char1);
                k.a((Object) editText3, "edit_otp_char1");
                editText3.setEnabled(false);
                EditText editText4 = (EditText) this.f65744a.b(R.id.edit_otp_char3);
                k.a((Object) editText4, "edit_otp_char3");
                editText4.setEnabled(true);
                this.f65744a.a(2);
                return;
            }
            EditText editText5 = (EditText) this.f65744a.b(R.id.edit_otp_char3);
            k.a((Object) editText5, "edit_otp_char3");
            if (editText5.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char3)).requestFocus();
                EditText editText6 = (EditText) this.f65744a.b(R.id.edit_otp_char2);
                k.a((Object) editText6, "edit_otp_char2");
                editText6.setEnabled(false);
                EditText editText7 = (EditText) this.f65744a.b(R.id.edit_otp_char4);
                k.a((Object) editText7, "edit_otp_char4");
                editText7.setEnabled(true);
                this.f65744a.a(3);
                return;
            }
            EditText editText8 = (EditText) this.f65744a.b(R.id.edit_otp_char4);
            k.a((Object) editText8, "edit_otp_char4");
            if (editText8.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char4)).requestFocus();
                EditText editText9 = (EditText) this.f65744a.b(R.id.edit_otp_char3);
                k.a((Object) editText9, "edit_otp_char3");
                editText9.setEnabled(false);
                EditText editText10 = (EditText) this.f65744a.b(R.id.edit_otp_char5);
                k.a((Object) editText10, "edit_otp_char5");
                editText10.setEnabled(true);
                this.f65744a.a(4);
                return;
            }
            EditText editText11 = (EditText) this.f65744a.b(R.id.edit_otp_char5);
            k.a((Object) editText11, "edit_otp_char5");
            if (editText11.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char5)).requestFocus();
                EditText editText12 = (EditText) this.f65744a.b(R.id.edit_otp_char4);
                k.a((Object) editText12, "edit_otp_char4");
                editText12.setEnabled(false);
                EditText editText13 = (EditText) this.f65744a.b(R.id.edit_otp_char6);
                k.a((Object) editText13, "edit_otp_char6");
                editText13.setEnabled(true);
                this.f65744a.a(5);
                return;
            }
            EditText editText14 = (EditText) this.f65744a.b(R.id.edit_otp_char6);
            k.a((Object) editText14, "edit_otp_char6");
            if (editText14.getText().toString().equals("")) {
                ((EditText) this.f65744a.b(R.id.edit_otp_char6)).requestFocus();
                EditText editText15 = (EditText) this.f65744a.b(R.id.edit_otp_char5);
                k.a((Object) editText15, "edit_otp_char5");
                editText15.setEnabled(false);
                this.f65744a.a(6);
            }
        }
    }

    public final void a(int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3 = R.drawable.otp_boxes_selector_blue;
        int i4 = R.drawable.otp_boxes_selector;
        if (Build.VERSION.SDK_INT >= 21) {
            Resources resources = getResources();
            FragmentActivity activity = getActivity();
            Resources.Theme theme = null;
            drawable2 = resources.getDrawable(i3, activity != null ? activity.getTheme() : null);
            Resources resources2 = getResources();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                theme = activity2.getTheme();
            }
            drawable = resources2.getDrawable(i4, theme);
        } else {
            drawable2 = getResources().getDrawable(i3);
            drawable = getResources().getDrawable(i4);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 1) {
                EditText editText = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText, "edit_otp_char1");
                editText.setBackground(drawable2);
                EditText editText2 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText2, "edit_otp_char2");
                editText2.setBackground(drawable);
                EditText editText3 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText3, "edit_otp_char3");
                editText3.setBackground(drawable);
                EditText editText4 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText4, "edit_otp_char4");
                editText4.setBackground(drawable);
                EditText editText5 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText5, "edit_otp_char5");
                editText5.setBackground(drawable);
                EditText editText6 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText6, "edit_otp_char6");
                editText6.setBackground(drawable);
            } else if (i2 == 2) {
                EditText editText7 = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText7, "edit_otp_char1");
                editText7.setBackground(drawable);
                EditText editText8 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText8, "edit_otp_char2");
                editText8.setBackground(drawable2);
                EditText editText9 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText9, "edit_otp_char3");
                editText9.setBackground(drawable);
                EditText editText10 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText10, "edit_otp_char4");
                editText10.setBackground(drawable);
                EditText editText11 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText11, "edit_otp_char5");
                editText11.setBackground(drawable);
                EditText editText12 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText12, "edit_otp_char6");
                editText12.setBackground(drawable);
            } else if (i2 == 3) {
                EditText editText13 = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText13, "edit_otp_char1");
                editText13.setBackground(drawable);
                EditText editText14 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText14, "edit_otp_char2");
                editText14.setBackground(drawable);
                EditText editText15 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText15, "edit_otp_char3");
                editText15.setBackground(drawable2);
                EditText editText16 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText16, "edit_otp_char4");
                editText16.setBackground(drawable);
                EditText editText17 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText17, "edit_otp_char5");
                editText17.setBackground(drawable);
                EditText editText18 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText18, "edit_otp_char6");
                editText18.setBackground(drawable);
            } else if (i2 == 4) {
                EditText editText19 = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText19, "edit_otp_char1");
                editText19.setBackground(drawable);
                EditText editText20 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText20, "edit_otp_char2");
                editText20.setBackground(drawable);
                EditText editText21 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText21, "edit_otp_char3");
                editText21.setBackground(drawable);
                EditText editText22 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText22, "edit_otp_char4");
                editText22.setBackground(drawable2);
                EditText editText23 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText23, "edit_otp_char5");
                editText23.setBackground(drawable);
                EditText editText24 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText24, "edit_otp_char6");
                editText24.setBackground(drawable);
            } else if (i2 == 5) {
                EditText editText25 = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText25, "edit_otp_char1");
                editText25.setBackground(drawable);
                EditText editText26 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText26, "edit_otp_char2");
                editText26.setBackground(drawable);
                EditText editText27 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText27, "edit_otp_char3");
                editText27.setBackground(drawable);
                EditText editText28 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText28, "edit_otp_char4");
                editText28.setBackground(drawable);
                EditText editText29 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText29, "edit_otp_char5");
                editText29.setBackground(drawable2);
                EditText editText30 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText30, "edit_otp_char6");
                editText30.setBackground(drawable);
            } else if (i2 == 6) {
                EditText editText31 = (EditText) b(R.id.edit_otp_char1);
                k.a((Object) editText31, "edit_otp_char1");
                editText31.setBackground(drawable);
                EditText editText32 = (EditText) b(R.id.edit_otp_char2);
                k.a((Object) editText32, "edit_otp_char2");
                editText32.setBackground(drawable);
                EditText editText33 = (EditText) b(R.id.edit_otp_char3);
                k.a((Object) editText33, "edit_otp_char3");
                editText33.setBackground(drawable);
                EditText editText34 = (EditText) b(R.id.edit_otp_char4);
                k.a((Object) editText34, "edit_otp_char4");
                editText34.setBackground(drawable);
                EditText editText35 = (EditText) b(R.id.edit_otp_char5);
                k.a((Object) editText35, "edit_otp_char5");
                editText35.setBackground(drawable);
                EditText editText36 = (EditText) b(R.id.edit_otp_char6);
                k.a((Object) editText36, "edit_otp_char6");
                editText36.setBackground(drawable2);
            }
        } else if (i2 == 1) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable2);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable);
        } else if (i2 == 2) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable2);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable);
        } else if (i2 == 3) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable2);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable);
        } else if (i2 == 4) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable2);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable);
        } else if (i2 == 5) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable2);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable);
        } else if (i2 == 6) {
            ((EditText) b(R.id.edit_otp_char1)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char2)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char3)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char4)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char5)).setBackgroundDrawable(drawable);
            ((EditText) b(R.id.edit_otp_char6)).setBackgroundDrawable(drawable2);
        }
    }

    public static final /* synthetic */ boolean a(EditText editText, EditText editText2) {
        if (!String.valueOf(editText != null ? editText.getText() : null).equals("")) {
            if (editText != null) {
                editText.setText("");
            }
            return true;
        }
        if (editText2 != null) {
            editText2.setText("");
            editText2.setEnabled(true);
            editText2.requestFocus();
        }
        return true;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65742c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
