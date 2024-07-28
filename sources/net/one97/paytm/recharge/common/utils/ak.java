package net.one97.paytm.recharge.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.ah;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.fragment.d;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRMyBillData;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class ak extends d implements TextWatcher, View.OnClickListener, View.OnTouchListener, ai {

    /* renamed from: a  reason: collision with root package name */
    public static final b f61510a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private int f61511b;

    /* renamed from: c  reason: collision with root package name */
    private String f61512c;

    /* renamed from: d  reason: collision with root package name */
    private String f61513d;

    /* renamed from: e  reason: collision with root package name */
    private String f61514e;

    /* renamed from: f  reason: collision with root package name */
    private String f61515f;

    /* renamed from: g  reason: collision with root package name */
    private String f61516g;

    /* renamed from: h  reason: collision with root package name */
    private String f61517h;

    /* renamed from: i  reason: collision with root package name */
    private w f61518i;
    private EditText j;
    private Integer k;
    private View l;
    private TextView m;
    private View n;
    private View o;
    private LottieAnimationView p;
    private HashMap q;

    public interface c {
        void a(CJRMyBillData cJRMyBillData);
    }

    public final View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f61511b = arguments.getInt("bottom_sheet_type", 0);
            k.a((Object) arguments, "it");
            this.f61512c = arguments.getString(StringSet.operator, (String) null);
            this.f61513d = arguments.getString("input_field_title", (String) null);
            this.f61514e = arguments.getString("input_field_value", (String) null);
            this.f61515f = arguments.getString("operator_icon_url", (String) null);
            this.f61516g = arguments.getString("request_body_json_string", (String) null);
            this.f61517h = arguments.getString("mobile_number_config_key", (String) null);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.anim.slide_up;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        return layoutInflater.inflate(R.layout.layout_view_my_bill_bottom_sheet, (ViewGroup) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x014c, code lost:
        r7 = (r7 = r7.getWindow()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r8 = "view"
            kotlin.g.b.k.c(r7, r8)
            android.content.Context r8 = r6.getContext()
            if (r8 == 0) goto L_0x0140
            net.one97.paytm.recharge.common.utils.w r8 = new net.one97.paytm.recharge.common.utils.w
            android.content.Context r0 = r6.getContext()
            if (r0 != 0) goto L_0x0017
            kotlin.g.b.k.a()
        L_0x0017:
            r8.<init>(r0)
            r6.f61518i = r8
            int r8 = net.one97.paytm.recharge.R.id.info_txt_view
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r0 = net.one97.paytm.recharge.R.id.ic_cross
            android.view.View r0 = r7.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = net.one97.paytm.recharge.R.id.input_field_details
            android.view.View r1 = r7.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.recharge.R.id.operator_image
            android.view.View r2 = r7.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r3 = net.one97.paytm.recharge.R.id.edit_no
            android.view.View r3 = r7.findViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r6.j = r3
            int r3 = net.one97.paytm.recharge.R.id.number_sep_1
            android.view.View r3 = r7.findViewById(r3)
            r6.l = r3
            int r3 = net.one97.paytm.recharge.R.id.message_input_field
            android.view.View r3 = r7.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r6.m = r3
            android.widget.TextView r3 = r6.m
            if (r3 == 0) goto L_0x006e
            android.content.Context r4 = r6.getContext()
            if (r4 != 0) goto L_0x0065
            kotlin.g.b.k.a()
        L_0x0065:
            int r5 = net.one97.paytm.recharge.R.color.error_color
            int r4 = androidx.core.content.b.c(r4, r5)
            r3.setTextColor(r4)
        L_0x006e:
            android.view.View r3 = r6.l
            if (r3 == 0) goto L_0x0084
            android.content.Context r4 = r6.getContext()
            if (r4 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            int r5 = net.one97.paytm.recharge.R.color.viewColor
            int r4 = androidx.core.content.b.c(r4, r5)
            r3.setBackgroundColor(r4)
        L_0x0084:
            int r3 = net.one97.paytm.recharge.R.id.proceed_btn
            android.view.View r3 = r7.findViewById(r3)
            r6.n = r3
            int r3 = net.one97.paytm.recharge.R.id.loading_threedots_lav
            android.view.View r3 = r7.findViewById(r3)
            com.airbnb.lottie.LottieAnimationView r3 = (com.airbnb.lottie.LottieAnimationView) r3
            r6.p = r3
            int r3 = net.one97.paytm.recharge.R.id.loading_threedots_view
            android.view.View r7 = r7.findViewById(r3)
            r6.o = r7
            java.lang.String r7 = r6.f61512c
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00c0
            java.lang.String r7 = "operatorDetailsTextView"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            int r7 = net.one97.paytm.recharge.R.string.view_my_bill_operator_details
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.String r5 = r6.f61512c
            r3[r4] = r5
            java.lang.String r7 = r6.getString(r7, r3)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8.setText(r7)
        L_0x00c0:
            java.lang.String r7 = r6.f61513d
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00f6
            java.lang.String r7 = r6.f61514e
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00f6
            java.lang.String r7 = "inputFieldDetailTextView"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r6.f61513d
            r7.append(r8)
            java.lang.String r8 = " : "
            r7.append(r8)
            java.lang.String r8 = r6.f61514e
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x00f6:
            java.lang.String r7 = r6.f61515f
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0118
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            java.lang.String r8 = r6.f61515f
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r8)
            net.one97.paytm.recharge.common.utils.ak$a r8 = new net.one97.paytm.recharge.common.utils.ak$a
            r8.<init>()
            com.squareup.picasso.ah r8 = (com.squareup.picasso.ah) r8
            com.squareup.picasso.aa r7 = r7.a((com.squareup.picasso.ah) r8)
            r7.a((android.widget.ImageView) r2)
        L_0x0118:
            android.widget.EditText r7 = r6.j
            if (r7 == 0) goto L_0x011f
            r7.requestFocus()
        L_0x011f:
            r7 = r6
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r0.setOnClickListener(r7)
            android.view.View r8 = r6.n
            if (r8 == 0) goto L_0x012c
            r8.setOnClickListener(r7)
        L_0x012c:
            android.widget.EditText r7 = r6.j
            if (r7 == 0) goto L_0x0136
            r8 = r6
            android.view.View$OnTouchListener r8 = (android.view.View.OnTouchListener) r8
            r7.setOnTouchListener(r8)
        L_0x0136:
            android.widget.EditText r7 = r6.j
            if (r7 == 0) goto L_0x0140
            r8 = r6
            android.text.TextWatcher r8 = (android.text.TextWatcher) r8
            r7.addTextChangedListener(r8)
        L_0x0140:
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            if (r7 == 0) goto L_0x0159
            android.view.Window r7 = r7.getWindow()
            if (r7 == 0) goto L_0x0159
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
            if (r7 == 0) goto L_0x0159
            int r7 = r7.softInputMode
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x015a
        L_0x0159:
            r7 = 0
        L_0x015a:
            r6.k = r7
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            if (r7 == 0) goto L_0x016d
            android.view.Window r7 = r7.getWindow()
            if (r7 == 0) goto L_0x016d
            r8 = 32
            r7.setSoftInputMode(r8)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.ak.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView textView;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        EditText editText = this.j;
        if (editText != null) {
            num = Integer.valueOf(editText.getId());
        }
        if (!k.a((Object) valueOf, (Object) num) || (textView = this.m) == null) {
            return false;
        }
        if (textView == null) {
            k.a();
        }
        a(textView);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000c
            int r6 = r6.getId()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x000d
        L_0x000c:
            r6 = r0
        L_0x000d:
            int r1 = net.one97.paytm.recharge.R.id.proceed_btn
            r2 = 1
            if (r6 != 0) goto L_0x0014
            goto L_0x009f
        L_0x0014:
            int r3 = r6.intValue()
            if (r3 != r1) goto L_0x009f
            android.widget.EditText r6 = r5.j
            if (r6 == 0) goto L_0x003b
            if (r6 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            android.text.Editable r6 = r6.getText()
            int r6 = r6.length()
            r1 = 10
            if (r6 == r1) goto L_0x003c
            android.widget.TextView r6 = r5.m
            if (r6 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            java.lang.String r1 = "Enter a valid Mobile Number"
            a(r6, r1)
        L_0x003b:
            r2 = 0
        L_0x003c:
            if (r2 == 0) goto L_0x009e
            net.one97.paytm.recharge.common.utils.w r6 = r5.f61518i
            if (r6 == 0) goto L_0x009e
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r2 = r5.f61516g
            r1.<init>(r2)
            java.lang.String r2 = r5.f61517h
            android.widget.EditText r3 = r5.j
            if (r3 != 0) goto L_0x0052
            kotlin.g.b.k.a()
        L_0x0052:
            android.text.Editable r3 = r3.getText()
            r1.put(r2, r3)
            android.view.View r2 = r5.n
            android.view.View r3 = r5.o
            com.airbnb.lottie.LottieAnimationView r4 = r5.p
            if (r2 == 0) goto L_0x0064
            net.one97.paytm.recharge.common.utils.ai.b(r2)
        L_0x0064:
            if (r3 == 0) goto L_0x0069
            net.one97.paytm.recharge.common.utils.ai.a(r3)
        L_0x0069:
            net.one97.paytm.recharge.common.utils.ba.a((com.airbnb.lottie.LottieAnimationView) r4)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            r0.setErrorType(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x0086
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x0086:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x0095
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.VIEW_MY_BILL
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x0095:
            r2 = r5
            net.one97.paytm.recharge.common.e.ai r2 = (net.one97.paytm.recharge.common.e.ai) r2
            java.lang.String r3 = "view_my_bill"
            r6.a((java.lang.String) r3, (net.one97.paytm.recharge.common.e.ai) r2, (org.json.JSONObject) r1, (java.lang.Object) r0)
        L_0x009e:
            return
        L_0x009f:
            int r0 = net.one97.paytm.recharge.R.id.ic_cross
            if (r6 != 0) goto L_0x00a4
            return
        L_0x00a4:
            int r6 = r6.intValue()
            if (r6 != r0) goto L_0x00c4
            android.widget.EditText r6 = r5.j
            if (r6 == 0) goto L_0x00c1
            boolean r6 = r6.isFocused()
            if (r6 != r2) goto L_0x00c1
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            android.content.Context r6 = (android.content.Context) r6
            android.widget.EditText r0 = r5.j
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r6, (android.view.View) r0)
        L_0x00c1:
            r5.dismiss()
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.ak.onClick(android.view.View):void");
    }

    private static void a(TextView textView, String str) {
        textView.setText(str);
        textView.setVisibility(0);
    }

    private static void a(TextView textView) {
        textView.setText("");
        textView.setVisibility(8);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        String str2;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRMyBillData) {
            a(this.n, this.o, this.p);
            EditText editText = this.j;
            if (editText != null) {
                TextView textView = editText;
                if (networkCustomError == null || (str2 = networkCustomError.getAlertMessage()) == null) {
                    str2 = "";
                }
                a(textView, str2);
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel.setErrorMsg(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
                cJRRechargeErrorModel.setErrorType(ERROR_TYPE.INLINE_ERROR);
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.INLINE_ERROR.name());
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
                return;
            }
            return;
        }
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRMyBillData) {
            a(this.n, this.o, this.p);
            CJRMyBillData cJRMyBillData = (CJRMyBillData) iJRPaytmDataModel;
            if (cJRMyBillData.getError() != null) {
                TextView textView = this.m;
                if (textView != null) {
                    String error = cJRMyBillData.getError().getError();
                    if (error == null) {
                        Context context = getContext();
                        if (context == null) {
                            k.a();
                        }
                        k.a((Object) context, "context!!");
                        Resources resources = context.getResources();
                        if (resources == null) {
                            k.a();
                        }
                        error = resources.getString(R.string.error_msg_default);
                        k.a((Object) error, "context!!.resources!!.ge…string.error_msg_default)");
                    }
                    a(textView, error);
                    return;
                }
                return;
            }
            EditText editText = this.j;
            if (editText != null && editText.isFocused()) {
                ba.a((Context) getActivity(), (View) this.j);
            }
            if (getActivity() instanceof c) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    ((c) activity).a(cJRMyBillData);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.utils.FJRCommonBottomSheet.IJRCommonBottomSheetListner");
                }
            } else if (getParentFragment() instanceof c) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    ((c) parentFragment).a(cJRMyBillData);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.utils.FJRCommonBottomSheet.IJRCommonBottomSheetListner");
                }
            }
            dismissAllowingStateLoss();
        }
    }

    public void onDestroy() {
        FragmentActivity activity;
        Window window;
        if (!(this.k == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null)) {
            Integer num = this.k;
            if (num == null) {
                k.a();
            }
            window.setSoftInputMode(num.intValue());
        }
        super.onDestroy();
    }

    private static void a(View view, View view2, LottieAnimationView lottieAnimationView) {
        if (view != null) {
            ai.a(view);
        }
        if (view2 != null) {
            ai.b(view2);
        }
        ba.b(lottieAnimationView);
    }

    public final class a implements ah {
        public final String key() {
            return "circle";
        }

        public a() {
        }

        public final Bitmap transform(Bitmap bitmap) {
            k.c(bitmap, "source");
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (!k.a((Object) createBitmap, (Object) bitmap)) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            k.a((Object) createBitmap2, "bitmap");
            return createBitmap2;
        }
    }

    public void afterTextChanged(Editable editable) {
        TextView textView = this.m;
        if (textView != null) {
            if (textView == null) {
                k.a();
            }
            a(textView);
        }
    }
}
