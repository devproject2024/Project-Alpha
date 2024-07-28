package net.one97.paytm.fastag.dependencies;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.b.h;
import com.paytm.utility.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.widgets.CJRVolleyImageView;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.b;
import net.one97.paytm.fastag.f.f;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRAttribute;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJRExchangeInfo;
import net.one97.paytm.fastag.model.CJRGeneric;
import net.one97.paytm.fastag.model.CJRNextStep;
import net.one97.paytm.fastag.model.CJRNextStepDetail;
import net.one97.paytm.fastag.model.CJRNextStepSubtitle;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryProductDetail;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRRefund;
import net.one97.paytm.fastag.model.CJRReverseItemInfo;
import net.one97.paytm.fastag.model.CJRSellerCourierCard;
import net.one97.paytm.fastag.model.CJRStatusFlow;
import net.one97.paytm.fastag.model.CJRTransactionDetails;
import net.one97.paytm.fastag.model.CJRZeroEMIItemInfo;

public final class m implements k {

    /* renamed from: a  reason: collision with root package name */
    Activity f13693a;

    /* renamed from: b  reason: collision with root package name */
    i f13694b;

    /* renamed from: c  reason: collision with root package name */
    String f13695c;

    /* renamed from: d  reason: collision with root package name */
    String f13696d;

    /* renamed from: e  reason: collision with root package name */
    AlertDialog f13697e;

    /* renamed from: f  reason: collision with root package name */
    String f13698f = "orderdetail";

    /* renamed from: g  reason: collision with root package name */
    private String f13699g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13700h = false;

    /* renamed from: i  reason: collision with root package name */
    private View.OnClickListener f13701i = new View.OnClickListener() {
        public final void onClick(View view) {
            a aVar;
            if (view.getId() == R.id.contact_seller) {
                Object tag = view.getTag();
                if (tag instanceof CJROrderedCart) {
                    CJROrderedCart cJROrderedCart = (CJROrderedCart) tag;
                    new n(m.this.f13693a, cJROrderedCart).show(m.this.f13693a.getFragmentManager(), n.class.getName());
                    m.a(m.this, cJROrderedCart, "item_details_contact_seller_clicked");
                }
            } else if (view.getId() == R.id.action_view && m.this.f13694b != null && (aVar = (a) view.getTag()) != null) {
                if (aVar.f13730a == null || TextUtils.isEmpty(aVar.f13730a.getType()) || !aVar.f13730a.getType().equalsIgnoreCase("nocancelpopup")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("KEY_ORDERED_CART", aVar.f13731b);
                    if (aVar.f13730a.getType().equalsIgnoreCase(m.this.f13698f)) {
                        hashMap.put("order_id", m.this.f13695c);
                    }
                    m.this.f13694b.a(aVar.f13732c, aVar.f13730a, hashMap, m.this.f13696d);
                    String name = aVar.f13730a.getName();
                    if (!TextUtils.isEmpty(name) && aVar.f13732c != null && aVar.f13732c.getOrderedCartList() != null && aVar.f13732c.getOrderedCartList().size() > 0) {
                        char c2 = 65535;
                        int hashCode = name.hashCode();
                        if (hashCode != -670115059) {
                            if (hashCode == 94969272 && name.equals("Cancel_Item")) {
                                c2 = 0;
                            }
                        } else if (name.equals("Invoice")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            m.a(m.this, aVar.f13732c.getOrderedCartList().get(0), "item_details_cancel_order_clicked");
                        } else if (c2 == 1) {
                            m.a(m.this, aVar.f13732c.getOrderedCartList().get(0), "item_details_download_invoice_clicked");
                        }
                    }
                } else {
                    m mVar = m.this;
                    String errorTitleText = aVar.f13730a.getErrorTitleText();
                    String errorText = aVar.f13730a.getErrorText();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mVar.f13693a);
                    View inflate = mVar.f13693a.getLayoutInflater().inflate(R.layout.alert_dialog_return_replace_ft, (ViewGroup) null);
                    builder.setInverseBackgroundForced(true);
                    builder.setView(inflate);
                    mVar.f13697e = builder.show();
                    mVar.f13697e.setCancelable(false);
                    ((TextView) inflate.findViewById(R.id.msg_tv)).setText(errorText);
                    ((TextView) inflate.findViewById(R.id.title)).setText(errorTitleText);
                    ((TextView) inflate.findViewById(R.id.ok_textview)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (m.this.f13697e != null && m.this.f13697e.isShowing()) {
                                m.this.f13697e.dismiss();
                            }
                        }
                    });
                }
            }
        }
    };

    public m(Activity activity, String str, String str2) {
        this.f13693a = activity;
        this.f13695c = str;
        this.f13699g = this.f13693a.getResources().getString(R.string.auto_cancelled);
        this.f13696d = str2;
    }

    public final void a(CJROrderedCart cJROrderedCart, View view) {
        int i2;
        String str;
        String str2;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.delivered_item_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.item_detail_status_text);
        CJRVolleyImageView cJRVolleyImageView = (CJRVolleyImageView) view2.findViewById(R.id.item_detail_item_image);
        cJRVolleyImageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        TextView textView3 = (TextView) view2.findViewById(R.id.item_price);
        view2.findViewById(R.id.actual_item_price);
        view2.findViewById(R.id.item_discount);
        textView3.setText(this.f13693a.getString(R.string.rs_str, new Object[]{Double.valueOf(cJROrderedCart.getSubTotal() + (!TextUtils.isEmpty(cJROrderedCart.getShippingCharge()) ? Double.valueOf(cJROrderedCart.getShippingCharge()).doubleValue() : 0.0d))}));
        TextView textView4 = (TextView) view2.findViewById(R.id.item_detail_item_info);
        String name = cJROrderedCart.getName();
        String statusText = cJROrderedCart.getStatusText();
        String thumbnail = cJROrderedCart.getProductDetail().getThumbnail();
        CJRAttribute attributes = cJROrderedCart.getAttributes();
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.view_item_detail);
        ImageView imageView = (ImageView) view2.findViewById(R.id.arrow_image);
        final LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.item_detail_layout);
        linearLayout2.setVisibility(8);
        final boolean[] zArr = {false};
        linearLayout2.getMeasuredHeight();
        if (Build.VERSION.SDK_INT >= 21) {
            i2 = f.bk;
        } else {
            i2 = f.bj;
        }
        AnonymousClass7 r12 = r0;
        LinearLayout linearLayout3 = linearLayout;
        final int i3 = i2;
        String str3 = thumbnail;
        final ImageView imageView2 = imageView;
        AnonymousClass7 r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                if (!zArr[0]) {
                    m.this.a((View) linearLayout2, i3);
                    zArr[0] = true;
                    imageView2.setBackground(m.this.f13693a.getResources().getDrawable(R.drawable.up_arrow_mall_ft));
                    return;
                }
                m.this.a((View) linearLayout2);
                zArr[0] = false;
                imageView2.setBackground(m.this.f13693a.getResources().getDrawable(R.drawable.down_arrow_mall));
            }
        };
        linearLayout3.setOnClickListener(r12);
        TextView textView5 = (TextView) view2.findViewById(R.id.seller_name);
        String merchantName = cJROrderedCart.getProductDetail().getMerchantName();
        TextView textView6 = (TextView) view2.findViewById(R.id.cart_item_seller_image);
        String[] strArr = null;
        if (!TextUtils.isEmpty(merchantName)) {
            strArr = merchantName.split(" ");
        }
        String str4 = "";
        if (strArr == null || strArr.length <= 1) {
            str = !TextUtils.isEmpty(merchantName) ? merchantName.length() > 1 ? merchantName.substring(0, 2) : merchantName : str4;
        } else {
            if (!TextUtils.isEmpty(strArr[0])) {
                str2 = str4 + String.valueOf(strArr[0].charAt(0));
            } else {
                str2 = str4;
            }
            if (!TextUtils.isEmpty(strArr[1])) {
                str = str2 + String.valueOf(strArr[1].charAt(0));
            } else {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "NA";
        }
        textView6.setText(str.toUpperCase());
        if (!TextUtils.isEmpty(merchantName)) {
            textView5.setText(merchantName);
        }
        if (!TextUtils.isEmpty(name)) {
            textView.setText(name);
        }
        if (!TextUtils.isEmpty(statusText)) {
            textView2.setText(Html.fromHtml(statusText));
        }
        if (!TextUtils.isEmpty(str3)) {
            cJRVolleyImageView.setResponseObserver(new CJRVolleyImageView.a() {
            });
            cJRVolleyImageView.setImageUrl(str3, h.INSTANCE.getImageLoader());
        }
        if (attributes != null) {
            if (!TextUtils.isEmpty(attributes.getColor())) {
                str4 = "Color: <b><font color='black'>" + attributes.getColor() + "</font></b>, ";
            }
            if (!TextUtils.isEmpty(attributes.getSize())) {
                str4 = str4 + "Size: <b><font color='black'>" + attributes.getSize() + "</font></b>";
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            textView4.setVisibility(0);
            textView4.setText(Html.fromHtml(str4), TextView.BufferType.SPANNABLE);
            return;
        }
        b(textView4);
    }

    public final void a(CJROrderedCart cJROrderedCart, View view, boolean z) {
        TextView textView = (TextView) view.findViewById(R.id.seller_name);
        TextView textView2 = (TextView) view.findViewById(R.id.contact_seller);
        this.f13700h = z;
        String merchantName = cJROrderedCart.getProductDetail().getMerchantName();
        textView2.setTag(cJROrderedCart);
        if (!TextUtils.isEmpty(merchantName)) {
            textView.setText(merchantName);
        }
        if (z) {
            textView2.setOnClickListener(this.f13701i);
        } else {
            textView2.setVisibility(8);
        }
    }

    public final void b(CJROrderedCart cJROrderedCart, View view) {
        int i2;
        String str;
        String str2;
        View view2 = view;
        TextView textView = (TextView) view2.findViewById(R.id.delivered_item_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.auto_cancelled_status_text);
        CJRVolleyImageView cJRVolleyImageView = (CJRVolleyImageView) view2.findViewById(R.id.item_detail_item_image);
        cJRVolleyImageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        TextView textView3 = (TextView) view2.findViewById(R.id.item_price);
        view2.findViewById(R.id.actual_item_price);
        view2.findViewById(R.id.item_discount);
        textView3.setText(this.f13693a.getString(R.string.rs_str, new Object[]{Double.valueOf(cJROrderedCart.getSubTotal() + (!TextUtils.isEmpty(cJROrderedCart.getShippingCharge()) ? Double.valueOf(cJROrderedCart.getShippingCharge()).doubleValue() : 0.0d))}));
        final View findViewById = view2.findViewById(R.id.view_detail_seperator);
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.view_item_detail);
        final ImageView imageView = (ImageView) view2.findViewById(R.id.arrow_image);
        final LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.item_detail_layout);
        linearLayout2.setVisibility(8);
        final boolean[] zArr = {false};
        linearLayout2.getMeasuredHeight();
        if (Build.VERSION.SDK_INT >= 21) {
            i2 = f.bk;
        } else {
            i2 = f.bj;
        }
        final int i3 = i2;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!zArr[0]) {
                    m.this.a((View) linearLayout2, i3);
                    zArr[0] = true;
                    findViewById.setVisibility(8);
                    imageView.setBackground(m.this.f13693a.getResources().getDrawable(R.drawable.up_arrow_mall_ft));
                    return;
                }
                m.this.a((View) linearLayout2);
                zArr[0] = false;
                findViewById.setVisibility(0);
                imageView.setBackground(m.this.f13693a.getResources().getDrawable(R.drawable.down_arrow_mall));
            }
        });
        textView.setText(cJROrderedCart.getProductDetail().getName());
        TextView textView4 = (TextView) view2.findViewById(R.id.seller_name);
        view2.findViewById(R.id.seller_address);
        TextView textView5 = (TextView) view2.findViewById(R.id.cart_item_seller_image);
        String merchantName = cJROrderedCart.getProductDetail().getMerchantName();
        String[] strArr = null;
        if (!TextUtils.isEmpty(merchantName)) {
            strArr = merchantName.split(" ");
        }
        String str3 = "";
        if (strArr == null || strArr.length <= 1) {
            str = !TextUtils.isEmpty(merchantName) ? merchantName.length() > 1 ? merchantName.substring(0, 2) : merchantName : str3;
        } else {
            if (!TextUtils.isEmpty(strArr[0])) {
                str2 = str3 + String.valueOf(strArr[0].charAt(0));
            } else {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(strArr[1])) {
                str = str2 + String.valueOf(strArr[1].charAt(0));
            } else {
                str = str2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "NA";
        }
        textView5.setText(str.toUpperCase());
        if (!TextUtils.isEmpty(merchantName)) {
            textView4.setText(merchantName);
        }
        cJROrderedCart.getName();
        String statusText = cJROrderedCart.getStatusText();
        String thumbnail = cJROrderedCart.getProductDetail().getThumbnail();
        TextView textView6 = (TextView) view2.findViewById(R.id.item_detail_item_info);
        if (!TextUtils.isEmpty(statusText)) {
            textView2.setText(Html.fromHtml(statusText));
        }
        CJRAttribute attributes = cJROrderedCart.getAttributes();
        if (attributes != null) {
            if (!TextUtils.isEmpty(attributes.getColor())) {
                str3 = "Color: <b><font color='black'>" + attributes.getColor() + "</font></b>, ";
            }
            if (!TextUtils.isEmpty(attributes.getSize())) {
                str3 = str3 + "Size: <b><font color='black'>" + attributes.getSize() + "</font></b>";
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            textView6.setVisibility(0);
            textView6.setText(Html.fromHtml(str3), TextView.BufferType.SPANNABLE);
        } else {
            b(textView6);
        }
        if (!TextUtils.isEmpty(thumbnail)) {
            cJRVolleyImageView.setResponseObserver(new CJRVolleyImageView.a() {
            });
            cJRVolleyImageView.setImageUrl(thumbnail, h.INSTANCE.getImageLoader());
        }
    }

    public final void a(CJROrderSummary cJROrderSummary, CJRGeneric cJRGeneric, ViewGroup viewGroup, ArrayList<CJRAction> arrayList) {
        if (cJRGeneric != null) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            if (cJRGeneric.getActions() != null) {
                arrayList2.addAll(cJRGeneric.getActions());
            }
            if (arrayList2.size() > 0) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRAction cJRAction = (CJRAction) arrayList2.get(i2);
                    View inflate = LayoutInflater.from(this.f13693a).inflate(R.layout.lyt_item_detail_action_row_ft, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.action_label);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.generic_action_image);
                    if (cJRAction != null) {
                        String label = cJRAction.getLabel();
                        if (!TextUtils.isEmpty(label)) {
                            textView.setText(label);
                        }
                        String genericActionImage = cJRAction.getGenericActionImage();
                        if (!TextUtils.isEmpty(genericActionImage)) {
                            imageView.setVisibility(0);
                            t a2 = t.a(true);
                            this.f13693a.getApplicationContext();
                            a2.a(genericActionImage, imageView);
                        } else {
                            imageView.setVisibility(8);
                        }
                    }
                    inflate.setTag(new a(cJRAction, viewGroup.getTag(), cJROrderSummary));
                    inflate.setOnClickListener(this.f13701i);
                    if (i2 == size - 1) {
                        inflate.findViewById(R.id.seperator).setVisibility(8);
                    }
                    viewGroup.addView(inflate);
                }
            }
        }
    }

    public final void c(CJROrderedCart cJROrderedCart, View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.offer_applied);
        TextView textView2 = (TextView) view.findViewById(R.id.offer_text);
        TextView textView3 = (TextView) view.findViewById(R.id.promo_desc);
        if (cJROrderedCart != null) {
            textView.setText(cJROrderedCart.getPromoCode() + " applied");
            double totalCashBack = cJROrderedCart.getTotalCashBack();
            String promoText = cJROrderedCart.getPromoText();
            if (totalCashBack > 0.0d) {
                str = this.f13693a.getString(R.string.promo_cashback, new Object[]{net.one97.paytm.fastag.f.h.b(Double.valueOf(totalCashBack))});
            } else {
                str = cJROrderedCart.getPromoCode();
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(promoText)) {
                textView2.setText(str);
                textView2.setText(cJROrderedCart.getCashBackText());
                if (!TextUtils.isEmpty(promoText)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((int) totalCashBack);
                    textView3.setText(Html.fromHtml(a(promoText, sb.toString(), cJROrderedCart.getPromoCode()).toString()));
                    textView3.setMovementMethod(LinkMovementMethod.getInstance());
                    return;
                }
                return;
            }
            b(view);
        }
    }

    public final void f(CJROrderedCart cJROrderedCart, View view) {
        view.setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.zero_cost_title);
        TextView textView2 = (TextView) view.findViewById(R.id.zero_cost_amount);
        TextView textView3 = (TextView) view.findViewById(R.id.zero_cost_desc);
        if (cJROrderedCart != null) {
            CJRZeroEMIItemInfo cJRZeroEMIItemInfo = cJROrderedCart.getCJRZeroEMIItemInfo();
            if (cJRZeroEMIItemInfo == null || cJRZeroEMIItemInfo.getZeroEMICashback() == 0) {
                view.setVisibility(8);
                return;
            }
            textView2.setText(this.f13693a.getString(R.string.rupee_symbol) + " " + cJRZeroEMIItemInfo.getZeroEMICashback());
            textView.setText(cJRZeroEMIItemInfo.getZeroEMICashbackTitle());
            textView3.setText(cJRZeroEMIItemInfo.getZeroEMICashbackText());
            return;
        }
        view.setVisibility(8);
    }

    public final void e(CJROrderedCart cJROrderedCart, View view) {
        TextView textView = (TextView) view.findViewById(R.id.exchange_title);
        TextView textView2 = (TextView) view.findViewById(R.id.exchnage_amount);
        TextView textView3 = (TextView) view.findViewById(R.id.exchange_brand_name);
        TextView textView4 = (TextView) view.findViewById(R.id.exchange_subtitle);
        TextView textView5 = (TextView) view.findViewById(R.id.exchange_desc);
        if (cJROrderedCart == null || cJROrderedCart.getIsExchangeForwardItem() != 1) {
            view.setVisibility(8);
            return;
        }
        CJRReverseItemInfo reverseItemInfo = cJROrderedCart.getReverseItemInfo();
        if (reverseItemInfo != null) {
            textView.setText(reverseItemInfo.getExchangeTitle());
            textView4.setText(reverseItemInfo.getExchangeSubtitle());
            textView5.setText(reverseItemInfo.getExchangeText());
            CJRExchangeInfo exchangeInfo = reverseItemInfo.getExchangeInfo();
            if (exchangeInfo != null) {
                textView3.setVisibility(0);
                textView2.setVisibility(0);
                textView3.setText(Html.fromHtml("with <b>" + exchangeInfo.getModel() + "</b>"));
                textView2.setText(this.f13693a.getString(R.string.rupee_symbol) + exchangeInfo.getTotalAmount());
                return;
            }
            textView3.setVisibility(8);
            textView2.setVisibility(8);
        }
    }

    private static SpannableString a(String str, String... strArr) {
        int length;
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2) && (length = str2.length()) > 0 && (indexOf = str.indexOf(str2)) >= 0 && indexOf < str.length()) {
                spannableString.setSpan(new StyleSpan(1), indexOf, length + indexOf, 33);
            }
        }
        return spannableString;
    }

    public final void a(CJRAddress cJRAddress, View view) {
        if (cJRAddress != null) {
            TextView textView = (TextView) view.findViewById(R.id.item_detail_delivery_name);
            TextView textView2 = (TextView) view.findViewById(R.id.item_detail_delivery_address);
            String name = cJRAddress.getName();
            String string = this.f13693a.getString(R.string.return_pickup_address_title);
            if (!TextUtils.isEmpty(name)) {
                textView.setText(string);
            }
            textView2.setText("");
            if (cJRAddress.getAddress1() != null) {
                textView2.append(Html.fromHtml(cJRAddress.getAddress1() + ", "));
            }
            if (cJRAddress.getAddress2() != null) {
                textView2.append(Html.fromHtml(cJRAddress.getAddress2() + ", "));
            }
            if (cJRAddress.getCity() != null) {
                textView2.append(Html.fromHtml(cJRAddress.getCity() + "- "));
            }
            if (cJRAddress.getPin() != null) {
                textView2.append(Html.fromHtml(cJRAddress.getPin() + ", "));
            }
            if (cJRAddress.getState() != null) {
                textView2.append(Html.fromHtml(cJRAddress.getState() + ",<br/>"));
            }
            if (cJRAddress.getMobile() != null) {
                textView2.append(Html.fromHtml(this.f13693a.getResources().getString(R.string.label_mobile) + ": +91" + cJRAddress.getMobile()));
                return;
            }
            return;
        }
        b(view);
    }

    public final void d(CJROrderedCart cJROrderedCart, View view) {
        ArrayList<CJRTransactionDetails> arrayList;
        final CJROrderedCart cJROrderedCart2 = cJROrderedCart;
        View view2 = view;
        CJRRefund refund = cJROrderedCart.getRefund();
        if (refund != null) {
            TextView textView = (TextView) view2.findViewById(R.id.refund_desc_text);
            TextView textView2 = (TextView) view2.findViewById(R.id.refund_value);
            View findViewById = view2.findViewById(R.id.refund_details_link);
            ImageView imageView = (ImageView) view2.findViewById(R.id.redund_detail_iv);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.refund_source_container);
            String status_text = refund.getStatus_text();
            int totalRefund = refund.getTotalRefund();
            String string = this.f13693a.getString(R.string.total_refund_amnt, new Object[]{net.one97.paytm.fastag.f.h.b(Double.valueOf((double) totalRefund))});
            ArrayList<CJRTransactionDetails> transactionDetails = refund.getTransactionDetails();
            if (!TextUtils.isEmpty(status_text)) {
                textView.setText(status_text);
            }
            textView2.setText(string);
            if (transactionDetails == null || transactionDetails.size() <= 0) {
                b(linearLayout);
            } else {
                int size = transactionDetails.size();
                int i2 = 0;
                while (i2 < size) {
                    CJRTransactionDetails cJRTransactionDetails = transactionDetails.get(i2);
                    if (cJRTransactionDetails != null) {
                        View inflate = LayoutInflater.from(this.f13693a).inflate(R.layout.lyt_refund_breakup_detail_cell_ft, (ViewGroup) null);
                        TextView textView3 = (TextView) inflate.findViewById(R.id.refund_source);
                        TextView textView4 = (TextView) inflate.findViewById(R.id.refund_amnt);
                        TextView textView5 = (TextView) inflate.findViewById(R.id.refund_time);
                        String payment_mode = cJRTransactionDetails.getPayment_mode();
                        double amount = cJRTransactionDetails.getAmount();
                        String message = cJRTransactionDetails.getMessage();
                        if (!TextUtils.isEmpty(payment_mode)) {
                            textView3.setText(payment_mode);
                            textView3.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    Intent intent = new Intent(m.this.f13693a, net.one97.paytm.fastag.c.a.a().f13559b.getPassbookActivityClass());
                                    intent.putExtra("orderVertical", "wallet");
                                    intent.putExtra(f.bw, f.bz);
                                    m.this.f13693a.startActivity(intent);
                                }
                            });
                        }
                        arrayList = transactionDetails;
                        textView4.setText(this.f13693a.getString(R.string.total_refund_amnt, new Object[]{net.one97.paytm.fastag.f.h.b(Double.valueOf(amount))}));
                        if (!TextUtils.isEmpty(message)) {
                            textView5.setText(message);
                        }
                        if (i2 == size - 1) {
                            inflate.findViewById(R.id.seperator).setVisibility(8);
                        }
                        linearLayout.addView(inflate);
                    } else {
                        arrayList = transactionDetails;
                    }
                    i2++;
                    transactionDetails = arrayList;
                }
            }
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    new g(cJROrderedCart2).show(m.this.f13693a.getFragmentManager(), g.class.getName());
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    new g(cJROrderedCart2).show(m.this.f13693a.getFragmentManager(), g.class.getName());
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    new g(cJROrderedCart2).show(m.this.f13693a.getFragmentManager(), g.class.getName());
                }
            });
            return;
        }
        b(view);
    }

    public final void a(CJRNextStep cJRNextStep, ViewGroup viewGroup, CJROrderedCart cJROrderedCart) {
        ViewGroup viewGroup2 = viewGroup;
        if (cJRNextStep != null) {
            ArrayList<CJRNextStepDetail> nextStepDetails = cJRNextStep.getNextStepDetails();
            if (nextStepDetails != null && nextStepDetails.size() > 0) {
                int size = nextStepDetails.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRNextStepDetail cJRNextStepDetail = nextStepDetails.get(i2);
                    if (cJRNextStepDetail != null) {
                        View inflate = LayoutInflater.from(this.f13693a).inflate(R.layout.lyt_return_steps_cell_ft, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.return_step_heading);
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.return_steps_subtitles_container);
                        String title = cJRNextStepDetail.getTitle();
                        ((TextView) inflate.findViewById(R.id.return_step_ctr)).setText(String.valueOf(i2 + 1));
                        if (!TextUtils.isEmpty(title)) {
                            textView.setText(title);
                        } else {
                            textView.setVisibility(4);
                        }
                        if (i2 != 1) {
                            ArrayList<CJRNextStepSubtitle> nextStepSubtitles = cJRNextStepDetail.getNextStepSubtitles();
                            if (nextStepSubtitles == null || nextStepSubtitles.size() <= 0) {
                                linearLayout.setVisibility(8);
                            } else {
                                int size2 = nextStepSubtitles.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    CJRNextStepSubtitle cJRNextStepSubtitle = nextStepSubtitles.get(i3);
                                    if (cJRNextStepSubtitle != null) {
                                        View inflate2 = LayoutInflater.from(this.f13693a).inflate(R.layout.lyt_return_steps_subtitle_ft, (ViewGroup) null);
                                        TextView textView2 = (TextView) inflate2.findViewById(R.id.return_step_subtitle);
                                        String heading = cJRNextStepSubtitle.getHeading();
                                        if (!TextUtils.isEmpty(heading)) {
                                            textView2.setText(heading);
                                            linearLayout.addView(inflate2);
                                        }
                                    }
                                }
                            }
                        } else {
                            View findViewById = inflate.findViewById(R.id.seller_address_container);
                            findViewById.setVisibility(0);
                            TextView textView3 = (TextView) findViewById.findViewById(R.id.seller_name);
                            if (!(cJROrderedCart == null || cJROrderedCart.getMerchantAdress() == null || cJROrderedCart.getProductDetail() == null)) {
                                String merchantName = cJROrderedCart.getProductDetail().getMerchantName();
                                if (!TextUtils.isEmpty(merchantName)) {
                                    textView3.setText(merchantName);
                                }
                            }
                        }
                        viewGroup2.addView(inflate);
                    }
                }
                return;
            }
            return;
        }
        viewGroup2.setVisibility(8);
    }

    private static String a(CJRSellerCourierCard cJRSellerCourierCard) {
        if (!(cJRSellerCourierCard == null || cJRSellerCourierCard.getStatusFlow() == null || cJRSellerCourierCard.getStatusFlow().size() <= 0)) {
            Iterator<CJRStatusFlow> it2 = cJRSellerCourierCard.getStatusFlow().iterator();
            while (it2.hasNext()) {
                CJRStatusFlow next = it2.next();
                if (next.ismIsCurrentStatus()) {
                    return next.getText();
                }
            }
        }
        return "";
    }

    private static String a(CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart == null || cJROrderedCart.getCards() == null) {
            return "";
        }
        String a2 = a(cJROrderedCart.getCards().getSellerCard());
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return a(cJROrderedCart.getCards().getCourierCard());
    }

    private static void b(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void a(CJROrderSummary cJROrderSummary, CJRCards cJRCards, i iVar, View view) {
        CJROrderedCart cJROrderedCart;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList != null && orderedCartList.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= orderedCartList.size()) {
                    cJROrderedCart = orderedCartList.get(0);
                    break;
                }
                if (this.f13696d.equalsIgnoreCase(String.valueOf(orderedCartList.get(i2).getId()))) {
                    cJROrderedCart = orderedCartList.get(i2);
                    break;
                }
                i2++;
            }
            if (!(cJROrderedCart == null || cJROrderedCart.getRefund() == null || !cJROrderedCart.getRefund().isRefundInitiated()) || !(view instanceof LinearLayout)) {
                view.setVisibility(8);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) view;
            View a2 = new c(this.f13693a, cJROrderSummary, iVar, cJRCards.getStatusFlow()).a();
            if (a2 != null) {
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                linearLayout.addView(a2);
                return;
            }
            view.setVisibility(8);
        }
    }

    public final void a(i iVar) {
        this.f13694b = iVar;
    }

    public final i a() {
        return this.f13694b;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CJRAction f13730a;

        /* renamed from: b  reason: collision with root package name */
        Object f13731b;

        /* renamed from: c  reason: collision with root package name */
        CJROrderSummary f13732c;

        a(CJRAction cJRAction, Object obj, CJROrderSummary cJROrderSummary) {
            this.f13730a = cJRAction;
            this.f13731b = obj;
            this.f13732c = cJROrderSummary;
        }
    }

    public final void a(final View view, int i2) {
        int height = view.getHeight();
        view.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{height, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.requestLayout();
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300);
        ofInt.start();
    }

    public final void a(final View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getHeight(), 0});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.requestLayout();
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300);
        ofInt.start();
    }

    static /* synthetic */ void a(m mVar, CJROrderedCart cJROrderedCart, String str) {
        if (cJROrderedCart != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_details_item_state", a(cJROrderedCart));
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            if (productDetail != null) {
                hashMap.put("item_details_vertical_label", productDetail.getVertical() + "");
            }
            hashMap.put("item_details_order_id", cJROrderedCart.getOrderId() + "");
            hashMap.put("item_details_item_id", cJROrderedCart.getId() + "");
            b bVar = net.one97.paytm.fastag.c.a.a().f13559b;
            bVar.sendCustomEventWithMap(str + "", hashMap, mVar.f13693a);
        }
    }
}
