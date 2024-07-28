package net.one97.paytm.fastag.dependencies;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.d.a;
import net.one97.paytm.fastag.d.c;
import net.one97.paytm.fastag.d.d;
import net.one97.paytm.fastag.d.g;
import net.one97.paytm.fastag.model.CJRMerchantAddress;
import net.one97.paytm.fastag.model.CJRMerchantContact;
import net.one97.paytm.fastag.model.CJRMerchantContacts;
import net.one97.paytm.fastag.model.CJROrderSummaryProductDetail;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRSellerRatingList;
import net.one97.paytm.fastag.model.CJRSellerRatingProp;
import net.one97.paytm.fastag.model.CJRSellerRatings;

public class n extends DialogFragment implements g.a<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    Activity f13734a;

    /* renamed from: b  reason: collision with root package name */
    CJROrderedCart f13735b;

    /* renamed from: c  reason: collision with root package name */
    List<CJRSellerRatingProp> f13736c;

    /* renamed from: d  reason: collision with root package name */
    View f13737d;

    /* renamed from: e  reason: collision with root package name */
    TextView f13738e;

    /* renamed from: f  reason: collision with root package name */
    TextView f13739f;

    /* renamed from: g  reason: collision with root package name */
    TextView f13740g;

    /* renamed from: h  reason: collision with root package name */
    TextView f13741h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f13742i;
    ImageView j;
    LinearLayout k;
    private TextView l;

    public /* synthetic */ void onResponse(Object obj) {
        List<CJRMerchantContact> merchantContacts;
        CJRMerchantAddress cJRMerchantAddress;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRSellerRatingList) {
            ArrayList<CJRSellerRatings> ratingList = ((CJRSellerRatingList) iJRPaytmDataModel).getRatingList();
            if (ratingList != null) {
                Iterator<CJRSellerRatings> it2 = ratingList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRSellerRatings next = it2.next();
                    if (next != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f13735b.getMerchantId());
                        if (sb.toString().equals(next.getmMerchantId())) {
                            this.f13736c = next.getData();
                            break;
                        }
                    }
                }
                if (this.f13736c != null) {
                    a(this.f13737d);
                }
            }
        } else if ((iJRPaytmDataModel instanceof CJRMerchantContacts) && (merchantContacts = ((CJRMerchantContacts) iJRPaytmDataModel).getMerchantContacts()) != null && merchantContacts.size() > 0) {
            CJRMerchantContact cJRMerchantContact = merchantContacts.get(0);
            String name = cJRMerchantContact.getName();
            CJROrderSummaryProductDetail productDetail = this.f13735b.getProductDetail();
            if (!(this.f13735b == null || productDetail == null)) {
                String merchantName = productDetail.getMerchantName();
                if (!TextUtils.isEmpty(merchantName)) {
                    name = merchantName;
                }
            }
            String mobileNumber = cJRMerchantContact.getMobileNumber();
            String emailId = cJRMerchantContact.getEmailId();
            ArrayList<CJRMerchantAddress> merchantAddresses = cJRMerchantContact.getMerchantAddresses();
            if (!TextUtils.isEmpty(mobileNumber)) {
                this.f13740g.setText(mobileNumber);
                TextView textView = this.l;
                String[] split = name.split(" ");
                String str = "";
                if (split.length > 0 && split[0].length() > 0) {
                    str = str + split[0].charAt(0);
                }
                if (split.length > 1 && split[1].length() > 0) {
                    str = str + split[1].charAt(0);
                }
                textView.setText(str);
            }
            if (this.f13735b.getProductDetail() != null && !TextUtils.isEmpty(this.f13735b.getProductDetail().getMerchantName())) {
                this.f13739f.setText(name);
            }
            if (!TextUtils.isEmpty(emailId)) {
                this.f13741h.setText(emailId);
            }
            if (merchantAddresses != null && merchantAddresses.size() > 0 && (cJRMerchantAddress = merchantAddresses.get(0)) != null) {
                this.f13738e.setText(cJRMerchantAddress.getAddress());
            }
        }
    }

    public n(Activity activity, CJROrderedCart cJROrderedCart) {
        this.f13734a = activity;
        this.f13735b = cJROrderedCart;
    }

    public n() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lyt_merchant_detail_frag_ft, viewGroup, false);
        this.f13737d = inflate;
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.CustomAnimations_slide_in);
        getDialog().getWindow().getAttributes().gravity = 87;
        this.k = (LinearLayout) inflate.findViewById(R.id.ratings_container);
        this.f13738e = (TextView) inflate.findViewById(R.id.merchant_address);
        this.f13739f = (TextView) inflate.findViewById(R.id.merchant_title);
        this.f13740g = (TextView) inflate.findViewById(R.id.phone_number);
        this.f13741h = (TextView) inflate.findViewById(R.id.email_id);
        this.l = (TextView) inflate.findViewById(R.id.merchant_initails);
        this.j = (ImageView) inflate.findViewById(R.id.email_button);
        this.f13742i = (ImageView) inflate.findViewById(R.id.call_button);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                String charSequence = n.this.f13741h.getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:".concat(String.valueOf(charSequence))));
                    if (intent.resolveActivity(n.this.f13734a.getPackageManager()) != null) {
                        n.this.f13734a.startActivity(Intent.createChooser(intent, "Email To Seller"));
                    }
                }
            }
        });
        this.f13742i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                String charSequence = n.this.f13740g.getText().toString();
                if (!TextUtils.isEmpty(charSequence) && n.b(charSequence)) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse("tel:".concat(String.valueOf(charSequence))));
                    if (intent.resolveActivity(n.this.f13734a.getPackageManager()) != null) {
                        n.this.f13734a.startActivity(intent);
                    }
                }
            }
        });
        inflate.findViewById(R.id.close_icon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                n.this.getDialog().dismiss();
            }
        });
        String c2 = c("https://fulfillment.paytm.com/v1/seller/merchant_contact?merchant_id=");
        c.a();
        c.a(new a(c2, this, new d() {
            public final void onError(Throwable th) {
            }
        }, new CJRMerchantContacts(), (Map<String, String>) null));
        c(net.one97.paytm.fastag.c.a.a().f13559b.getSellerRatingUrl());
        this.k.setVisibility(8);
        return inflate;
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception | NumberFormatException unused) {
            return false;
        }
    }

    private String c(String str) {
        return com.paytm.utility.c.a(str + this.f13735b.getMerchantId(), (Context) this.f13734a);
    }

    private void a(View view) {
        List<CJRSellerRatingProp> list = this.f13736c;
        if (list != null && list.size() > 0 && this.f13734a != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ratings_container);
            for (CJRSellerRatingProp next : this.f13736c) {
                View inflate = this.f13734a.getLayoutInflater().inflate(R.layout.merchant_rating_detail_ft, (ViewGroup) null);
                RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.rating_bar_detail_pdp);
                ratingBar.setNumStars(5);
                ((TextView) inflate.findViewById(R.id.pdp_rating_desc)).setText(next.getmText());
                ((RoboTextView) inflate.findViewById(R.id.pdp_rating_number)).setText(next.getmRating() + "/5");
                ratingBar.setRating(Float.parseFloat(next.getmRating()));
                LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
                layerDrawable.getDrawable(2).setColorFilter(this.f13734a.getResources().getColor(R.color.orange_promo_msg), PorterDuff.Mode.SRC_ATOP);
                layerDrawable.getDrawable(1).setColorFilter(this.f13734a.getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                layerDrawable.getDrawable(0).setColorFilter(this.f13734a.getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                inflate.invalidate();
                linearLayout.addView(inflate);
            }
        }
    }
}
