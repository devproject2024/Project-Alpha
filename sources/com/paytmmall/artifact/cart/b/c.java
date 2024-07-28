package com.paytmmall.artifact.cart.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.c.d;
import com.paytmmall.artifact.cart.entity.CJRBillingAddress;
import com.paytmmall.artifact.cart.entity.CJRCart;
import com.paytmmall.artifact.cart.entity.CJRCartProduct;
import com.paytmmall.artifact.cart.entity.CJREMIProductReviewDetails;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.d.n;
import com.paytmmall.b.a;
import com.paytmmall.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f15516a = "ExpressCheckoutDataProvider";

    private static String a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getQueryParameterNames().contains(CLPConstants.PRODUCT_ID)) {
                return parse.getQueryParameter(CLPConstants.PRODUCT_ID);
            }
            return "";
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    private static String a(CJREMIProductReviewDetails cJREMIProductReviewDetails, String str) {
        CJRCart cJRCart = new CJRCart();
        CJRCartProduct cJRCartProduct = new CJRCartProduct();
        if (!TextUtils.isEmpty(str)) {
            cJRCartProduct.setProductId(str);
            cJRCartProduct.setmQuantity("1");
            ArrayList arrayList = new ArrayList();
            arrayList.add(cJRCartProduct);
            cJRCart.setCartItems(arrayList);
        }
        if (cJREMIProductReviewDetails != null) {
            if (cJREMIProductReviewDetails.getDeliveryAddress() != null) {
                cJRCart.setmAddress(cJREMIProductReviewDetails.getDeliveryAddress());
            }
            if (cJREMIProductReviewDetails.getProductPromoInfo() != null) {
                cJRCart.setPromoCode(cJREMIProductReviewDetails.getProductPromoInfo().getAppliedPromoCode());
            }
            if (cJREMIProductReviewDetails.getGstinfo() != null) {
                cJRCart.setHasGstin(true);
                cJRCart.setGstinNumber(cJREMIProductReviewDetails.getGstinfo().getGstin());
                CJRBillingAddress cJRBillingAddress = new CJRBillingAddress();
                cJRBillingAddress.setAddress(cJREMIProductReviewDetails.getGstinfo().getAddress());
                cJRBillingAddress.setName(cJREMIProductReviewDetails.getGstinfo().getGstHolderName());
                cJRBillingAddress.setState(cJREMIProductReviewDetails.getGstinfo().getState());
                cJRCart.setBillingAddress(cJRBillingAddress);
            }
        }
        return new f().a((Object) cJRCart);
    }

    public final void a(Activity activity, final d dVar, CJREMIProductReviewDetails cJREMIProductReviewDetails, String str) {
        if (TextUtils.isEmpty(str)) {
            a(activity);
            return;
        }
        String a2 = a(str);
        if (a2.equalsIgnoreCase(H5BridgeContext.INVALID_ID)) {
            a(activity);
        } else if (!com.paytmmall.artifact.d.d.a((Context) activity)) {
            dVar.a(activity.getString(R.string.no_internet), (CJRShoppingCart) null);
        } else {
            String a3 = a(cJREMIProductReviewDetails, a2);
            com.paytmmall.artifact.d.d.a(activity, activity.getString(R.string.loading));
            Activity activity2 = activity;
            a.a(activity2, a.C0216a.POST, com.paytmmall.artifact.d.d.b(str), a3, com.paytmmall.artifact.d.d.a((HashMap<String, String>) new HashMap(), (Context) activity), new CJRShoppingCart(), new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    com.paytmmall.artifact.d.d.h();
                    CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
                    if (cJRShoppingCart != null && dVar != null) {
                        String a2 = c.a(cJRShoppingCart);
                        if (!TextUtils.isEmpty(a2)) {
                            dVar.a(a2, cJRShoppingCart);
                        } else {
                            dVar.a(cJRShoppingCart);
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    com.paytmmall.artifact.d.d.h();
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a(networkCustomError.getAlertMessage(), (CJRShoppingCart) null);
                    }
                }
            });
        }
    }

    private static void a(Activity activity) {
        activity.getClass();
        n.f15732b = new n.a(activity) {
            private final /* synthetic */ Activity f$0;

            {
                this.f$0 = r1;
            }

            public final void onOkClick() {
                this.f$0.finish();
            }
        };
        n.a(activity, activity.getString(R.string.error), activity.getString(R.string.some_went_wrong));
    }

    static /* synthetic */ String a(CJRShoppingCart cJRShoppingCart) {
        return (cJRShoppingCart == null || cJRShoppingCart.getCart() == null || TextUtils.isEmpty(cJRShoppingCart.getCart().getPromoFailureText())) ? "" : cJRShoppingCart.getCart().getPromoFailureText();
    }
}
