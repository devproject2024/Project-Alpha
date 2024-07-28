package com.travel.train.viewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.train.R;
import com.travel.train.i.e;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainOfferCode;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.Map;

public final class g extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f28096a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchResultsTrain f28097b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public e f28098c;

    /* renamed from: d  reason: collision with root package name */
    public String f28099d;

    /* renamed from: e  reason: collision with root package name */
    public String f28100e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<CJRTrainOfferCode> f28101f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f28102g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28103h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28104i;
    public String j;
    private LinearLayout k;
    private Button l;
    private ImageView m;
    private TextView n;
    private String o = "CJRIternaryOffersViewHolder";

    public g(View view, e eVar, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        super(view);
        this.f28096a = view.getContext();
        this.f28098c = eVar;
        this.f28097b = cJRTrainSearchResultsTrain;
        this.f28103h = (TextView) view.findViewById(R.id.review_iteneray_train_offer_tag);
        this.f28104i = (TextView) view.findViewById(R.id.review_iteneray_train_offer_txt);
        this.n = (TextView) view.findViewById(R.id.review_iteneray_train_promo_txt);
        this.m = (ImageView) view.findViewById(R.id.review_iteneray_train_promo_txt_close);
        this.f28102g = (RelativeLayout) view.findViewById(R.id.review_iteneray_train_offer_lyt);
        this.k = (LinearLayout) view.findViewById(R.id.offer_container);
        this.l = (Button) view.findViewById(R.id.btn_more);
        this.l.setOnClickListener(this);
        this.f28102g.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.m.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(this.f28099d);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f28096a);
            builder.setMessage(Html.fromHtml(String.format(this.f28096a.getString(R.string.remove_promo_cart), new Object[]{str})));
            builder.setPositiveButton(this.f28096a.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    g.this.f28102g.setVisibility(8);
                    String unused = g.this.f28099d = null;
                    String unused2 = g.this.f28100e = null;
                    g gVar = g.this;
                    gVar.a((ArrayList<CJRTrainOfferCode>) gVar.f28101f, true);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    public final void a() {
        this.f28099d = null;
        this.f28100e = null;
        this.f28102g.setVisibility(8);
        a(this.f28101f, true);
    }

    public final void a(ArrayList<CJRTrainOfferCode> arrayList, boolean z) {
        final ArrayList<CJRTrainOfferCode> arrayList2 = arrayList;
        if (arrayList2 != null && arrayList.size() > 0) {
            this.k.setVisibility(0);
            this.f28101f = arrayList2;
            this.k.findViewById(R.id.txt_offers_title).setVisibility(0);
            this.k.findViewById(R.id.lyt_offers_list_container).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.lyt_offers_list_container);
            linearLayout.removeAllViews();
            boolean z2 = true;
            if (arrayList.size() > 1) {
                final int i2 = 0;
                while (i2 < 2) {
                    final LinearLayout linearLayout2 = (LinearLayout) ((LayoutInflater) this.f28096a.getSystemService("layout_inflater")).inflate(R.layout.pre_t_lyt_flight_offer_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout2.findViewById(R.id.txt_flight_offer_radio_icon);
                    TextView textView2 = (TextView) linearLayout2.findViewById(R.id.txt_flight_offer_promo_msg);
                    TextView textView3 = (TextView) linearLayout2.findViewById(R.id.txt_flight_offer_terms);
                    textView3.setVisibility(8);
                    View findViewById = linearLayout2.findViewById(R.id.offer_sep);
                    findViewById.setVisibility(0);
                    if (z) {
                        findViewById.setVisibility(0);
                    } else if (!z && i2 == z2) {
                        findViewById.setVisibility(8);
                    }
                    textView.setText(arrayList2.get(i2).getCode());
                    arrayList2.get(i2).setIsOfferApplied(false);
                    if (this.f28100e != null) {
                        if (arrayList2.get(i2).getCode().equalsIgnoreCase(this.f28100e)) {
                            arrayList2.get(i2).setIsOfferApplied(z2);
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pre_t_icon_hotel_radio_on, 0, 0, 0);
                        } else {
                            arrayList2.get(i2).setIsOfferApplied(false);
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pre_t_icon_hotel_radio_off, 0, 0, 0);
                        }
                    }
                    if (arrayList2.get(i2) == null || TextUtils.isEmpty(arrayList2.get(i2).getOfferText())) {
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                        textView3.setVisibility(8);
                    } else {
                        String offerText = arrayList2.get(i2).getOfferText();
                        SpannableString spannableString = new SpannableString(offerText + this.f28096a.getString(R.string.t_and_c_train));
                        spannableString.setSpan(new ClickableSpan() {
                            public final void onClick(View view) {
                                b.b(g.this.f28096a, ((CJRTrainOfferCode) arrayList2.get(i2)).getTermsTitle(), Html.fromHtml(((CJRTrainOfferCode) arrayList2.get(i2)).getTerms()).toString());
                            }

                            public final void updateDrawState(TextPaint textPaint) {
                                textPaint.setColor(g.this.f28096a.getResources().getColor(R.color.paytm_blue));
                                textPaint.setUnderlineText(false);
                            }
                        }, offerText.length(), offerText.length() + this.f28096a.getString(R.string.t_and_c_train).length(), 0);
                        textView2.setMovementMethod(LinkMovementMethod.getInstance());
                        textView2.setText(spannableString);
                    }
                    linearLayout.addView(linearLayout2);
                    linearLayout2.setTag(arrayList2.get(i2).getCode());
                    linearLayout2.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            String str = (String) linearLayout2.getTag();
                            if (TextUtils.isEmpty(g.this.f28099d)) {
                                g gVar = g.this;
                                gVar.f28100e = str;
                                gVar.f28098c.c(str);
                            } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(g.this.f28099d)) {
                                g.this.a(str);
                            } else {
                                g.b(g.this, str);
                            }
                        }
                    });
                    i2++;
                    z2 = true;
                }
            } else {
                final LinearLayout linearLayout3 = (LinearLayout) ((LayoutInflater) this.f28096a.getSystemService("layout_inflater")).inflate(R.layout.pre_t_lyt_flight_offer_item, (ViewGroup) null);
                TextView textView4 = (TextView) linearLayout3.findViewById(R.id.txt_flight_offer_radio_icon);
                TextView textView5 = (TextView) linearLayout3.findViewById(R.id.txt_flight_offer_promo_msg);
                TextView textView6 = (TextView) linearLayout3.findViewById(R.id.txt_flight_offer_terms);
                textView6.setVisibility(8);
                textView4.setText(arrayList2.get(0).getCode());
                View findViewById2 = linearLayout3.findViewById(R.id.offer_sep);
                findViewById2.setVisibility(0);
                if (z) {
                    findViewById2.setVisibility(0);
                } else {
                    findViewById2.setVisibility(8);
                }
                if (arrayList2.get(0) == null || TextUtils.isEmpty(arrayList2.get(0).getOfferText())) {
                    textView4.setVisibility(8);
                    textView5.setVisibility(8);
                    textView6.setVisibility(8);
                } else {
                    String offerText2 = arrayList2.get(0).getOfferText();
                    SpannableString spannableString2 = new SpannableString(offerText2 + this.f28096a.getString(R.string.t_and_c_train));
                    spannableString2.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            b.b(g.this.f28096a, ((CJRTrainOfferCode) arrayList2.get(0)).getTermsTitle(), Html.fromHtml(((CJRTrainOfferCode) arrayList2.get(0)).getTerms()).toString());
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(g.this.f28096a.getResources().getColor(R.color.paytm_blue));
                            textPaint.setUnderlineText(false);
                        }
                    }, offerText2.length(), offerText2.length() + this.f28096a.getString(R.string.t_and_c_train).length(), 0);
                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                    textView5.setText(spannableString2);
                }
                if (arrayList2.get(0).getCode().equalsIgnoreCase(this.f28100e)) {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pre_t_icon_hotel_radio_on, 0, 0, 0);
                } else {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pre_t_icon_hotel_radio_off, 0, 0, 0);
                }
                linearLayout.addView(linearLayout3);
                linearLayout3.setTag(arrayList2.get(0).getCode());
                linearLayout3.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        String str = (String) linearLayout3.getTag();
                        if (TextUtils.isEmpty(g.this.f28099d)) {
                            g gVar = g.this;
                            gVar.f28100e = str;
                            gVar.f28098c.c(str);
                        } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(g.this.f28099d)) {
                            g.this.a(str);
                        } else {
                            g.b(g.this, str);
                        }
                    }
                });
            }
            if (z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        } else if (!z) {
            this.k.setVisibility(8);
            this.k.findViewById(R.id.txt_offers_title).setVisibility(8);
            this.k.findViewById(R.id.lyt_offers_list_container).setVisibility(8);
            this.k.findViewById(R.id.btn_more).setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.findViewById(R.id.txt_offers_title).setVisibility(8);
            this.k.findViewById(R.id.lyt_offers_list_container).setVisibility(8);
            this.k.findViewById(R.id.btn_more).setVisibility(0);
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_more) {
            this.f28098c.r();
        } else if (id == R.id.review_iteneray_train_offer_lyt) {
            this.f28098c.r();
        } else if (id == R.id.review_iteneray_train_promo_txt) {
            o.a("train_review_itinerary_have_a_promocode_clicked", this.f28097b.getSourceName(), this.f28097b.getDestinationName(), b.n(this.f28096a), (Map<String, Object>) null, this.f28096a);
            this.f28098c.r();
        }
    }

    static /* synthetic */ void b(g gVar, final String str) {
        if (!TextUtils.isEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(gVar.f28096a);
            builder.setMessage(Html.fromHtml("<B>" + gVar.f28099d + "</B> has already been applied. If you wish to apply <B>" + str + "</B>, your last offer will be replaced."));
            builder.setPositiveButton(gVar.f28096a.getString(R.string.cart_replace), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    o.a("train_review_itinerary_promocode_field_clicked", g.this.f28097b.getSourceName(), g.this.f28097b.getDestinationName(), b.n(g.this.f28096a), (Map<String, Object>) null, g.this.f28096a);
                    String unused = g.this.f28100e = str;
                    g.this.f28098c.c(str);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }
}
