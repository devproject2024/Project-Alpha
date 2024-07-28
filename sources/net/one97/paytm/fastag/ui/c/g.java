package net.one97.paytm.fastag.ui.c;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.dependencies.c;
import net.one97.paytm.fastag.dependencies.i;
import net.one97.paytm.fastag.dependencies.n;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.model.CJRAction;
import net.one97.paytm.fastag.model.CJRCards;
import net.one97.paytm.fastag.model.CJRExchangeInfo;
import net.one97.paytm.fastag.model.CJRGeneric;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryProductDetail;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRReverseItemInfo;
import net.one97.paytm.fastag.model.CJRSellerCourierCard;
import net.one97.paytm.fastag.model.CJRStatusFlow;

public final class g implements net.one97.paytm.fastag.f.g {

    /* renamed from: a  reason: collision with root package name */
    String f13940a = "orderdetail";

    /* renamed from: b  reason: collision with root package name */
    Activity f13941b;

    /* renamed from: c  reason: collision with root package name */
    i f13942c;

    /* renamed from: d  reason: collision with root package name */
    String f13943d;

    /* renamed from: e  reason: collision with root package name */
    String f13944e;

    /* renamed from: f  reason: collision with root package name */
    private String f13945f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13946g = false;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f13947h = new View.OnClickListener() {
        public final void onClick(View view) {
            a aVar;
            if (view.getId() == R.id.contact_seller) {
                Object tag = view.getTag();
                if (tag instanceof CJROrderedCart) {
                    CJROrderedCart cJROrderedCart = (CJROrderedCart) tag;
                    new n(g.this.f13941b, cJROrderedCart).show(g.this.f13941b.getFragmentManager(), n.class.getName());
                    g.a(g.this, cJROrderedCart, "item_details_contact_seller_clicked");
                }
            } else if (view.getId() == R.id.action_view && g.this.f13942c != null && (aVar = (a) view.getTag()) != null) {
                if (aVar.f13949a == null || !aVar.f13949a.isError()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("KEY_ORDERED_CART", aVar.f13950b);
                    if (aVar.f13949a.getType().equalsIgnoreCase(g.this.f13940a)) {
                        hashMap.put("order_id", g.this.f13943d);
                    }
                    g.this.f13942c.a(aVar.f13951c, aVar.f13949a, hashMap, g.this.f13944e);
                    String name = aVar.f13949a.getName();
                    if (!TextUtils.isEmpty(name) && aVar.f13951c != null && aVar.f13951c.getOrderedCartList() != null && aVar.f13951c.getOrderedCartList().size() > 0) {
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
                            g.a(g.this, aVar.f13951c.getOrderedCartList().get(0), "item_details_cancel_order_clicked");
                        } else if (c2 == 1) {
                            g.a(g.this, aVar.f13951c.getOrderedCartList().get(0), "item_details_download_invoice_clicked");
                        }
                    }
                } else {
                    g gVar = g.this;
                    b.b((Context) gVar.f13941b, aVar.f13949a.getErrorTitle(), aVar.f13949a.getErrorDescription());
                }
            }
        }
    };

    public g(Activity activity, String str, String str2) {
        this.f13941b = activity;
        this.f13943d = str;
        this.f13945f = this.f13941b.getResources().getString(R.string.auto_cancelled);
        this.f13944e = str2;
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
                    View inflate = LayoutInflater.from(this.f13941b).inflate(R.layout.lyt_item_detail_action_row_ft, (ViewGroup) null);
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
                            this.f13941b.getApplicationContext();
                            a2.a(genericActionImage, imageView);
                        } else {
                            imageView.setVisibility(8);
                        }
                    }
                    inflate.setTag(new a(cJRAction, viewGroup.getTag(), cJROrderSummary));
                    inflate.setOnClickListener(this.f13947h);
                    if (i2 == size - 1) {
                        inflate.findViewById(R.id.seperator).setVisibility(8);
                    }
                    viewGroup.addView(inflate);
                }
            }
        }
    }

    public final void a(CJROrderedCart cJROrderedCart, View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.offer_applied);
        TextView textView2 = (TextView) view.findViewById(R.id.offer_text);
        TextView textView3 = (TextView) view.findViewById(R.id.promo_desc);
        if (cJROrderedCart != null) {
            textView.setText(cJROrderedCart.getPromoCode() + " applied");
            double totalCashBack = cJROrderedCart.getTotalCashBack();
            String promoText = cJROrderedCart.getPromoText();
            if (totalCashBack > 0.0d) {
                str = this.f13941b.getString(R.string.promo_cashback, new Object[]{h.b(Double.valueOf(totalCashBack))});
            } else {
                str = cJROrderedCart.getPromoCode();
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(promoText)) {
                textView2.setText(str);
                textView2.setText(cJROrderedCart.getCashBackText());
                if (!TextUtils.isEmpty(promoText)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((int) totalCashBack);
                    textView3.setText(a(promoText, sb.toString(), cJROrderedCart.getPromoCode()));
                }
            } else if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void b(CJROrderedCart cJROrderedCart, View view) {
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
                textView2.setText(this.f13941b.getString(R.string.rupee_symbol) + exchangeInfo.getTotalAmount());
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

    public final void a(CJROrderSummary cJROrderSummary, CJRCards cJRCards, i iVar, View view) {
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList != null && orderedCartList.size() > 0) {
            CJROrderedCart cJROrderedCart = orderedCartList.get(0);
            if (!(cJROrderedCart == null || cJROrderedCart.getRefund() == null || !cJROrderedCart.getRefund().isRefundInitiated()) || !(view instanceof LinearLayout)) {
                view.setVisibility(8);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) view;
            View a2 = new c(this.f13941b, cJROrderSummary, iVar, cJRCards.getStatusFlow()).a();
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
        this.f13942c = iVar;
    }

    public final i a() {
        return this.f13942c;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CJRAction f13949a;

        /* renamed from: b  reason: collision with root package name */
        Object f13950b;

        /* renamed from: c  reason: collision with root package name */
        CJROrderSummary f13951c;

        a(CJRAction cJRAction, Object obj, CJROrderSummary cJROrderSummary) {
            this.f13949a = cJRAction;
            this.f13950b = obj;
            this.f13951c = cJROrderSummary;
        }
    }

    static /* synthetic */ void a(g gVar, CJROrderedCart cJROrderedCart, String str) {
        if (cJROrderedCart != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_details_item_state", a(cJROrderedCart));
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            if (productDetail != null) {
                hashMap.put("item_details_vertical_label", productDetail.getVertical() + "");
            }
            hashMap.put("item_details_order_id", cJROrderedCart.getOrderId() + "");
            hashMap.put("item_details_item_id", cJROrderedCart.getId() + "");
            net.one97.paytm.fastag.c.b bVar = net.one97.paytm.fastag.c.a.a().f13559b;
            bVar.sendCustomEventWithMap(str + "", hashMap, gVar.f13941b);
        }
    }
}
