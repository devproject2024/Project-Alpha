package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;
import org.npci.upi.security.pinactivitycomponent.widget.a;
import org.npci.upi.security.pinactivitycomponent.widget.m;

public abstract class ae extends Fragment implements m {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f72922a = null;

    /* renamed from: b  reason: collision with root package name */
    protected JSONObject f72923b = null;

    /* renamed from: c  reason: collision with root package name */
    protected JSONArray f72924c = null;

    /* renamed from: d  reason: collision with root package name */
    protected Timer f72925d = null;

    /* renamed from: e  reason: collision with root package name */
    protected long f72926e = 45000;

    /* renamed from: f  reason: collision with root package name */
    protected ArrayList f72927f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    protected int f72928g = -1;

    /* renamed from: h  reason: collision with root package name */
    protected PopupWindow f72929h;

    /* renamed from: i  reason: collision with root package name */
    protected Timer f72930i = null;
    protected Timer j;
    protected Handler k;
    protected Runnable l;
    protected JSONObject m = null;
    protected JSONArray n = new JSONArray();
    protected long o = 3000;
    protected Context p;
    private boolean q = false;

    private void d() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        JSONObject jSONObject3 = null;
        JSONObject jSONObject4 = null;
        for (int i2 = 0; i2 < this.f72924c.length(); i2++) {
            try {
                String optString = ((JSONObject) this.f72924c.get(i2)).optString(CLConstants.FIELD_SUBTYPE, "");
                if (optString.equals("ATMPIN")) {
                    jSONObject = this.f72924c.getJSONObject(i2);
                }
                if (optString.matches("OTP|SMS|HOTP|TOTP")) {
                    jSONObject2 = this.f72924c.getJSONObject(i2);
                }
                if (optString.equals("MPIN")) {
                    jSONObject3 = this.f72924c.getJSONObject(i2);
                }
                if (optString.equals("NMPIN")) {
                    jSONObject4 = this.f72924c.getJSONObject(i2);
                }
            } catch (Exception e2) {
                ad.a("NPCIFragment", e2);
            }
        }
        if (!(this.f72924c.length() != 3 || jSONObject == null || jSONObject2 == null || jSONObject3 == null)) {
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject);
            arrayList.add(jSONObject3);
        }
        if (!(this.f72924c.length() != 2 || jSONObject2 == null || jSONObject3 == null)) {
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject3);
        }
        if (!(this.f72924c.length() != 2 || jSONObject3 == null || jSONObject4 == null)) {
            arrayList.add(jSONObject3);
            arrayList.add(jSONObject4);
        }
        if (arrayList.size() > 0) {
            this.f72924c = new JSONArray(arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(float f2) {
        return (int) (f2 * ((float) (getResources().getDisplayMetrics().densityDpi / 160)));
    }

    /* access modifiers changed from: protected */
    public FormItemView a(String str, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FormItemView formItemView = new FormItemView(getActivity());
        if (this.f72924c.length() == 1) {
            formItemView.setActionBarPositionTop(true);
            layoutParams.width = a(240.0f);
            layoutParams.topMargin = a(40.0f);
            formItemView.getFormInputView().setCharSize(0.0f);
            formItemView.getFormInputView().setSpace((float) a(15.0f));
            formItemView.getFormInputView().setFontSize((float) a(32.0f));
            formItemView.getFormInputView().setPadding(0, a(32.0f), 0, 0);
            formItemView.getFormInputView().setMargin(new int[]{0, a(32.0f), 0, 0});
            formItemView.getFormInputView().setLineStrokeCentered(true);
            formItemView.getFormInputView().setLineStrokeSelected((float) a(2.0f));
            formItemView.getFormInputView().setColorStates(b.b(getActivity(), R.color.form_item_input_colors_transparent));
        }
        formItemView.setLayoutParams(layoutParams);
        formItemView.setInputLength(i3);
        formItemView.setFormItemListener(this);
        formItemView.setTitle(str);
        formItemView.setFormItemTag(i2);
        return formItemView;
    }

    public abstract void a();

    /* access modifiers changed from: protected */
    public void a(Timer timer) {
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e2) {
                ad.a("NPCIFragment", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(am amVar) {
        try {
            if (this.f72928g != -1) {
                this.q = true;
                ((a) this.f72927f.get(this.f72928g)).setText(amVar.b());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void a(FormItemView formItemView) {
        this.f72930i = new Timer();
        this.f72930i.schedule(new al(this), this.f72926e);
        formItemView.a("", (Drawable) null, (View.OnClickListener) null, 0, false, false);
        formItemView.a((Drawable) null, false);
        formItemView.a(getString(R.string.detecting_otp), (View.OnClickListener) null, true, false);
        formItemView.a(true);
    }

    /* access modifiers changed from: protected */
    public void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                String string = arguments.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                if (string != null) {
                    this.f72922a = new JSONObject(string);
                }
                String string2 = arguments.getString(CLConstants.INPUT_KEY_CONTROLS);
                if (string2 != null) {
                    this.m = new JSONObject(string2);
                    String string3 = this.m.getString(CLConstants.FIELD_CRED_ALLOWED);
                    if (string3 != null) {
                        this.f72924c = new JSONArray(string3);
                        d();
                    }
                }
                String string4 = arguments.getString(CLConstants.INPUT_KEY_SALT);
                if (string4 != null) {
                    this.f72923b = new JSONObject(string4);
                }
                String string5 = arguments.getString(CLConstants.INPUT_KEY_PAY_INFO);
                if (string5 != null) {
                    this.n = new JSONArray(string5);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b(int i2) {
        if (getActivity() != null && (getActivity() instanceof GetCredential)) {
            ((GetCredential) getActivity()).setNumDigitsOfOTP(i2);
        }
        an anVar = new an(getActivity());
        this.f72925d = new Timer();
        this.f72925d.scheduleAtFixedRate(new af(this, anVar, i2), 100, 2000);
    }

    /* access modifiers changed from: protected */
    public void b(View view, String str) {
        PopupWindow popupWindow = this.f72929h;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.layout_popup_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.popup_text)).setText(str);
        this.f72929h = new PopupWindow(inflate, -2, a(60.0f));
        this.f72929h.setAnimationStyle(R.style.PopupAnimation);
        this.f72929h.showAtLocation(view, 17, 0, 0);
        inflate.findViewById(R.id.popup_button).setOnClickListener(new ah(this));
        this.j = new Timer();
        this.k = new Handler(Looper.getMainLooper());
        this.l = new ai(this);
        this.k.postDelayed(this.l, this.o);
    }

    public void b(am amVar) {
        a(amVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!this.f72922a.optString(CLConstants.CONFIGURATION_RESEND_OTP_FEATURE, "false").equals("false") && !this.q) {
            getActivity().runOnUiThread(new aj(this));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.p = context;
    }

    public void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        a(this.f72925d);
        a(this.f72930i);
        a(this.j);
        Handler handler = this.k;
        if (!(handler == null || (runnable = this.l) == null)) {
            handler.removeCallbacks(runnable);
        }
        PopupWindow popupWindow = this.f72929h;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() instanceof GetCredential) {
            ((GetCredential) getActivity()).setCurrentFragment(this);
        }
    }
}
