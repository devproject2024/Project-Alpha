package com.paytmmall.artifact.cart.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.c.b;
import com.paytmmall.artifact.cart.c.c;
import com.paytmmall.artifact.cart.entity.CJROfferCode;
import com.paytmmall.artifact.cart.entity.CJRPromoCodeTermAndCondition;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.d.d;
import com.paytmmall.b.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Map;

public final class a extends RecyclerView.a<C0208a> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f15409a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJROfferCode> f15410b;

    /* renamed from: c  reason: collision with root package name */
    Activity f15411c;

    /* renamed from: d  reason: collision with root package name */
    int f15412d;

    /* renamed from: e  reason: collision with root package name */
    public String f15413e;

    /* renamed from: f  reason: collision with root package name */
    b f15414f;

    /* renamed from: g  reason: collision with root package name */
    c f15415g;

    /* renamed from: h  reason: collision with root package name */
    boolean f15416h;

    /* renamed from: i  reason: collision with root package name */
    boolean f15417i;
    public String j = "";
    private final WishListProduct k;
    private String l;
    private String m = "CJRCartOffersAdapter";

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        final C0208a aVar = (C0208a) vVar;
        CJROfferCode cJROfferCode = this.f15410b.get(i2);
        if (cJROfferCode != null) {
            aVar.f15424b.setText(cJROfferCode.getOfferText());
            aVar.f15423a.setText(cJROfferCode.getCode());
            if (!TextUtils.isEmpty(cJROfferCode.getSavingsPrice())) {
                try {
                    i3 = Integer.parseInt(cJROfferCode.getSavingsPrice());
                } catch (NumberFormatException e2) {
                    q.c(e2.getMessage());
                    i3 = 0;
                }
                if (i3 > 0) {
                    aVar.f15426d.setVisibility(0);
                    TextView textView = aVar.f15426d;
                    textView.setText("Save " + this.f15411c.getString(R.string.rupee_offer, new Object[]{cJROfferCode.getSavingsPrice()}));
                }
            }
            if (TextUtils.isEmpty(this.f15413e)) {
                aVar.f15425c.setChecked(false);
                aVar.f15423a.setTextColor(androidx.core.content.b.c(this.f15411c, R.color.color_666666));
                aVar.f15423a.setBackground((Drawable) null);
            } else if (this.f15413e.equalsIgnoreCase(cJROfferCode.getCode())) {
                aVar.f15425c.setChecked(true);
                aVar.f15423a.setText(a((Context) this.f15411c, this.f15413e));
                aVar.f15423a.setTextColor(androidx.core.content.b.c(this.f15411c, R.color.green_teal));
                aVar.f15423a.setBackground(androidx.core.content.b.a((Context) this.f15411c, R.drawable.mall_emi_cashback_container));
            } else {
                aVar.f15425c.setChecked(false);
                aVar.f15423a.setTextColor(androidx.core.content.b.c(this.f15411c, R.color.color_666666));
                aVar.f15423a.setBackground((Drawable) null);
            }
            if (TextUtils.isEmpty(this.j)) {
                aVar.f15427e.setBackground(androidx.core.content.b.a((Context) this.f15411c, R.drawable.mall_bg_rounded_white_rect_5dp_radius));
                aVar.f15428f.setVisibility(8);
            } else if (this.j.equalsIgnoreCase(cJROfferCode.getCode())) {
                aVar.f15427e.setBackground(androidx.core.content.b.a((Context) this.f15411c, R.drawable.mall_promo_screen_error_mode_item));
                aVar.f15428f.setVisibility(0);
                aVar.f15428f.setText(this.l);
            } else {
                aVar.f15427e.setBackground(androidx.core.content.b.a((Context) this.f15411c, R.drawable.mall_bg_rounded_white_rect_5dp_radius));
                aVar.f15428f.setVisibility(8);
            }
            aVar.f15425c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!aVar.f15423a.getText().toString().equalsIgnoreCase(a.a((Context) a.this.f15411c, a.this.f15413e))) {
                        aVar.f15425c.setChecked(false);
                    }
                    aVar.itemView.performClick();
                }
            });
        }
    }

    public a(ArrayList<CJROfferCode> arrayList, Activity activity, b bVar, String str, boolean z, WishListProduct wishListProduct, boolean z2, c cVar, boolean z3) {
        this.f15410b = arrayList;
        this.f15411c = activity;
        this.f15414f = bVar;
        this.f15415g = cVar;
        if (str != null) {
            this.f15413e = str;
        }
        this.f15409a = z;
        this.k = wishListProduct;
        this.f15416h = z2;
        this.f15417i = z3;
    }

    public final int getItemCount() {
        return this.f15410b.size();
    }

    public final void a(String str, String str2) {
        this.j = str;
        this.f15413e = "";
        this.l = str2;
        notifyDataSetChanged();
    }

    /* renamed from: com.paytmmall.artifact.cart.a.a$a  reason: collision with other inner class name */
    public class C0208a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f15423a;

        /* renamed from: b  reason: collision with root package name */
        TextView f15424b;

        /* renamed from: c  reason: collision with root package name */
        RadioButton f15425c;

        /* renamed from: d  reason: collision with root package name */
        TextView f15426d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f15427e;

        /* renamed from: f  reason: collision with root package name */
        TextView f15428f;

        /* renamed from: h  reason: collision with root package name */
        private TextView f15430h;

        public C0208a(View view) {
            super(view);
            this.f15423a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f15424b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f15426d = (TextView) view.findViewById(R.id.txv_save);
            this.f15427e = (ViewGroup) view.findViewById(R.id.item_rl_root);
            this.f15428f = (TextView) view.findViewById(R.id.promo_error);
            this.f15430h = (TextView) view.findViewById(R.id.txt_flight_offer_terms);
            this.f15425c = (RadioButton) view.findViewById(R.id.rb_promo);
            view.setOnClickListener(new View.OnClickListener(a.this) {
                public final void onClick(View view) {
                    int adapterPosition = C0208a.this.getAdapterPosition();
                    if (a.this.f15413e == null || adapterPosition < 0 || !a.this.f15413e.equals(a.this.f15410b.get(adapterPosition).getCode()) || (!a.this.f15409a && !a.this.f15416h)) {
                        if (adapterPosition >= 0) {
                            a.this.f15412d = adapterPosition;
                            if (a.this.f15416h) {
                                a.this.f15415g.a(a.this.f15410b.get(a.this.f15412d).getCode(), a.this.f15410b.get(a.this.f15412d).getSavingsPrice(), a.this.f15410b.get(a.this.f15412d).getOfferText());
                            } else {
                                a.this.f15414f.a(a.this.f15410b.get(a.this.f15412d).getCode());
                            }
                        }
                    } else if (!a.this.f15417i) {
                        a aVar = a.this;
                        String code = a.this.f15410b.get(adapterPosition).getCode();
                        AlertDialog.Builder builder = new AlertDialog.Builder(aVar.f15411c);
                        builder.setMessage(Html.fromHtml(String.format(aVar.f15411c.getString(R.string.remove_promo_cart), new Object[]{code})));
                        builder.setPositiveButton(aVar.f15411c.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                if (a.this.f15416h) {
                                    a.this.f15415g.c();
                                } else {
                                    a.this.f15414f.a();
                                }
                            }
                        });
                        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        builder.show();
                    }
                }
            });
            this.f15430h.setOnClickListener(new View.OnClickListener(a.this) {
                public final void onClick(View view) {
                    a aVar = a.this;
                    CJROfferCode cJROfferCode = aVar.f15410b.get(C0208a.this.getAdapterPosition());
                    if (!d.a((Context) aVar.f15411c) || cJROfferCode == null) {
                        d.b(aVar.f15411c, aVar.f15411c.getResources().getString(R.string.network_error_heading), aVar.f15411c.getResources().getString(R.string.network_error_message));
                        return;
                    }
                    d.a(aVar.f15411c, aVar.f15411c.getString(R.string.please_wait_progress_msg));
                    String str = "https://apiproxy.paytm.com/papi/v1/promosearch/" + cJROfferCode.getCode() + "/" + d.d() + "/tnc";
                    if (d.a(str)) {
                        com.paytmmall.b.a.a(aVar.f15411c, a.C0216a.GET, str, (String) null, (Map<String, String>) null, new CJRPromoCodeTermAndCondition(), new com.paytmmall.b.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                CJRPromoCodeTermAndCondition cJRPromoCodeTermAndCondition = (CJRPromoCodeTermAndCondition) iJRPaytmDataModel;
                                if (!TextUtils.isEmpty(cJRPromoCodeTermAndCondition.getTerms()) && !TextUtils.isEmpty(cJRPromoCodeTermAndCondition.getTermsTitle())) {
                                    d.c(a.this.f15411c, cJRPromoCodeTermAndCondition.getTermsTitle(), Html.fromHtml(cJRPromoCodeTermAndCondition.getTerms()).toString());
                                    d.h();
                                }
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                a aVar = a.this;
                                d.h();
                                if (networkCustomError != null && networkCustomError.getAlertMessage() != null) {
                                    if (networkCustomError.getAlertMessage().equalsIgnoreCase("parsing_error")) {
                                        Activity activity = aVar.f15411c;
                                        String alertMessage = networkCustomError.getAlertMessage();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(networkCustomError.getStatusCode());
                                        d.a((Context) activity, alertMessage, sb.toString());
                                        return;
                                    }
                                    d.b(aVar.f15411c, aVar.f15411c.getResources().getString(R.string.network_error_heading), aVar.f15411c.getResources().getString(R.string.network_error_message));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() > 10) {
            str = str.substring(0, 9).concat(AppConstants.DOTS);
        }
        return " " + String.format(context.getString(R.string.offer_applied_txt), new Object[]{str}) + " ";
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0208a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mall_offer_item_layout, (ViewGroup) null));
    }
}
