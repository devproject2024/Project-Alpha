package net.one97.paytm.recharge.common.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.common.entity.shopping.CJRServiceOptions;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.h;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.mobile_v3.d.b;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class CustomDthInputLayout extends CustomInputLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final CJRAmountInputFieldWidgetV8 f61987a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61988b;
    private CJRRechargeCart n;
    private CJRCustomerPlanDetails o;
    private h p;
    private CJRDisclaimerWidget q;
    private b r;

    public final void a(CJRInputFieldsItem cJRInputFieldsItem) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomDthInputLayout(Context context) {
        super(context);
        k.c(context, "context");
        this.f61987a = new CJRAmountInputFieldWidgetV8(context);
    }

    public final void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        setVisibility(8);
        setLayoutTransition(new LayoutTransition());
        setAmountFieldInlineMessage();
    }

    public final View getAmountContainerView() {
        int c2 = com.paytm.utility.b.c(20);
        CJRInputFieldsItem amountInputfieldObject = getAmountInputfieldObject();
        if (this.f61988b) {
            this.f61987a.setLargeAmount();
        } else if (Build.VERSION.SDK_INT >= 23) {
            EditText editText = (EditText) this.f61987a.findViewById(R.id.txt_input);
            if (editText != null) {
                editText.setTextAppearance(R.style.RechargeInputFieldV8);
            }
            ((TextView) this.f61987a.findViewById(R.id.hint_amount)).setTextAppearance(R.style.RechargeInputFieldNormalV8);
        } else {
            EditText editText2 = (EditText) this.f61987a.findViewById(R.id.txt_input);
            if (editText2 != null) {
                editText2.setTextAppearance(getContext(), R.style.RechargeInputFieldV8);
            }
            ((TextView) this.f61987a.findViewById(R.id.hint_amount)).setTextAppearance(getContext(), R.style.RechargeInputFieldNormalV8);
        }
        ViewGroup.LayoutParams layoutParams = this.f61987a.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(c2, c2, c2, 0);
            this.f61987a.b();
            this.f61987a.setInputHintText(amountInputfieldObject != null ? amountInputfieldObject.getTitle() : null);
            this.f61987a.setInputType(524290);
            this.f61987a.setTag(amountInputfieldObject);
            return this.f61987a;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final EditText a(View view) {
        return (CJRRechargeEditText) this.f61987a.findViewById(R.id.txt_input);
    }

    public final CJRRechargeEditText getAmountView() {
        return (CJRRechargeEditText) this.f61987a.findViewById(R.id.txt_input);
    }

    public final TextView b(View view) {
        TextView textView = (TextView) this.f61987a.findViewById(R.id.txt_error);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.b.c(getContext(), R.color.gray));
        }
        return textView;
    }

    public final CJRFetchingAmountLoader getLoaderWidget() {
        View findViewById = this.f61987a.findViewById(R.id.loader_widget);
        k.a((Object) findViewById, "amountInputLayout.findVi…ader>(R.id.loader_widget)");
        return (CJRFetchingAmountLoader) findViewById;
    }

    public final void setAmountFromBrowsePlan(String str) {
        k.c(str, "amount");
        this.f61987a.c();
        p();
        super.setAmountFromBrowsePlan(str);
    }

    public final View c(View view) {
        return this.f61987a.findViewById(R.id.lyt_divider);
    }

    public final void setHint(View view, String str) {
        k.c(view, "container");
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.text_input_layout_utility_amount);
        if (textInputLayout != null) {
            textInputLayout.setHint((CharSequence) null);
        }
        EditText editText = (EditText) view.findViewById(R.id.edit_no);
        if (editText != null) {
            editText.setHint(str);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (editText != null) {
                editText.setTextAppearance(R.style.RechargeInputFieldV8);
            }
        } else if (editText != null) {
            editText.setTextAppearance(getContext(), R.style.RechargeInputFieldV8);
        }
        if (editText != null) {
            editText.setPadding(0, com.paytm.utility.b.c(4), 0, 0);
        }
    }

    public final RoboTextView d(View view) {
        k.c(view, "customAutoCompleteTextViewContainer");
        RoboTextView d2 = super.d(view);
        ViewGroup.LayoutParams layoutParams = d2.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(com.paytm.utility.b.c(20), com.paytm.utility.b.c(7), com.paytm.utility.b.c(20), 0);
            d2.setLayoutParams(layoutParams2);
            return d2;
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void setAmountTextChangeListener(EditText editText) {
        k.c(editText, "autoCompleteTextView");
        this.f61987a.setInputFieldTextChangeListener(getMAmountTextWatcher());
        if (!TextUtils.isEmpty(this.f61987a.getInputText())) {
            this.f61987a.a(true);
        }
    }

    public final void b() {
        List<CJRProductsItem> products;
        CJRProductsItem cJRProductsItem;
        List<CJRProductsItem> products2;
        CJRProductsItem cJRProductsItem2;
        CJRCart cart;
        CJRRechargeCart cJRRechargeCart = this.n;
        String str = null;
        if (cJRRechargeCart != null) {
            if (cJRRechargeCart == null) {
                k.a();
            }
            CJRCart cart2 = cJRRechargeCart.getCart();
            if ((cart2 != null ? cart2.getCartItems() : null) != null) {
                CJRRechargeCart cJRRechargeCart2 = this.n;
                if (cJRRechargeCart2 == null) {
                    k.a();
                }
                CJRCart cart3 = cJRRechargeCart2.getCart();
                ArrayList<CJRCartProduct> cartItems = cart3 != null ? cart3.getCartItems() : null;
                if (cartItems == null) {
                    k.a();
                }
                if (!cartItems.isEmpty()) {
                    CJRRechargeCart cJRRechargeCart3 = this.n;
                    ArrayList<CJRCartProduct> cartItems2 = (cJRRechargeCart3 == null || (cart = cJRRechargeCart3.getCart()) == null) ? null : cart.getCartItems();
                    if (cartItems2 == null) {
                        k.a();
                    }
                    CJRCartProduct cJRCartProduct = cartItems2.get(0);
                    k.a((Object) cJRCartProduct, "mRechargeCart?.cart?.cartItems!![0]");
                    CJRServiceOptions serviceOptions = cJRCartProduct.getServiceOptions();
                    ArrayList<CJRServiceActions> actions = serviceOptions != null ? serviceOptions.getActions() : null;
                    if (actions != null && (!actions.isEmpty())) {
                        CJRServiceActions cJRServiceActions = actions.get(0);
                        k.a((Object) cJRServiceActions, "actions[0]");
                        ArrayList<CJRDisplayValues> displayValues = cJRServiceActions.getDisplayValues();
                        if (!(displayValues == null || !(!displayValues.isEmpty()) || getContext() == null)) {
                            setErrorViewLayoutParam(true);
                            CJRCustomerPlanDetails cJRCustomerPlanDetails = this.o;
                            if (cJRCustomerPlanDetails == null) {
                                Context context = getContext();
                                if (context == null) {
                                    k.a();
                                }
                                this.o = new CJRCustomerPlanDetails(context, displayValues);
                                if (getAmountIndex() != -1) {
                                    addView(this.o, getAmountIndex() + 1);
                                } else {
                                    addView(this.o);
                                }
                            } else if (cJRCustomerPlanDetails != null) {
                                ai.a(cJRCustomerPlanDetails);
                            }
                            o();
                            setFetchAmountMessageShown(true);
                            CJRCustomerPlanDetails cJRCustomerPlanDetails2 = this.o;
                            if (cJRCustomerPlanDetails2 != null) {
                                cJRCustomerPlanDetails2.postDelayed(new a(this), 500);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        if (this.q == null) {
            Context context2 = getContext();
            k.a((Object) context2, "context");
            CJRProductList productList = getProductList();
            String disclaimerNew = (productList == null || (products2 = productList.getProducts()) == null || (cJRProductsItem2 = products2.get(0)) == null) ? null : cJRProductsItem2.getDisclaimerNew();
            CJRProductList productList2 = getProductList();
            if (!(productList2 == null || (products = productList2.getProducts()) == null || (cJRProductsItem = products.get(0)) == null)) {
                str = cJRProductsItem.getDisclaimerImage();
            }
            this.q = new CJRDisclaimerWidget(context2, disclaimerNew, str);
            addView(this.q);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomDthInputLayout f61989a;

        a(CustomDthInputLayout customDthInputLayout) {
            this.f61989a = customDthInputLayout;
        }

        public final void run() {
            this.f61989a.setErrorViewLayoutParam(false);
        }
    }

    public final void setRechargeCartResponse(CJRRechargeCart cJRRechargeCart) {
        k.c(cJRRechargeCart, "cartResponse");
        this.n = cJRRechargeCart;
    }

    public final void c() {
        super.c();
        b();
    }

    public final void setFetchAmountListener(h hVar) {
        k.c(hVar, "listener");
        this.p = hVar;
    }

    public final void d() {
        h hVar = this.p;
        if (hVar != null && hVar != null) {
            hVar.b();
        }
    }

    public final void e() {
        CJRFetchingAmountLoader loaderWidget = getLoaderWidget();
        loaderWidget.setVisibility(8);
        TextView textView = (TextView) loaderWidget.a(R.id.label);
        if (textView != null) {
            ai.b(textView);
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) loaderWidget.a(R.id.loading_threedots_amount);
        if (cJRRechargeLottieAnimationView != null) {
            ExtensionsKt.stopLoaderAnimation(cJRRechargeLottieAnimationView);
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = (CJRRechargeLottieAnimationView) loaderWidget.a(R.id.loading_threedots_amount);
        if (cJRRechargeLottieAnimationView2 != null) {
            ai.b(cJRRechargeLottieAnimationView2);
        }
    }

    public final void f() {
        TextView b2 = b(this.f61987a);
        if (b2 != null) {
            ai.b(b2);
        }
    }

    public final void a(boolean z) {
        if (!z) {
            return;
        }
        if (getLoaderWidget().getVisibility() == 0 || this.o != null) {
            f();
        }
    }

    public final void setAmountFetchMessage(String str) {
        k.c(str, "amount");
        if (this.o == null) {
            super.setAmountFetchMessage(str);
        }
    }

    public final void g() {
        CJRCustomerPlanDetails cJRCustomerPlanDetails = this.o;
        if (cJRCustomerPlanDetails != null) {
            if (cJRCustomerPlanDetails != null) {
                ai.b(cJRCustomerPlanDetails);
            }
            this.o = null;
        }
    }

    public final void setErrorViewLayoutParam(boolean z) {
        TextView b2 = b(this.f61987a);
        ViewGroup.LayoutParams layoutParams = b2 != null ? b2.getLayoutParams() : null;
        if (layoutParams != null) {
            if (z) {
                layoutParams.height = 0;
                layoutParams.width = 0;
            } else {
                layoutParams.height = -1;
                layoutParams.width = -2;
            }
            b2.setLayoutParams(layoutParams);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setOnKeyUpDownListener(b bVar) {
        k.c(bVar, "onKeyListener");
        this.r = bVar;
        View findViewById = this.f61987a.findViewById(R.id.txt_input);
        if (!(findViewById instanceof CJRRechargeEditText)) {
            findViewById = null;
        }
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) findViewById;
        if (cJRRechargeEditText != null) {
            cJRRechargeEditText.setOnKeyUpDownListener(bVar);
        }
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        b bVar = this.r;
        if (bVar != null) {
            if (bVar == null) {
                k.a();
            }
            bVar.a("dispatch.key.event", keyEvent);
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
