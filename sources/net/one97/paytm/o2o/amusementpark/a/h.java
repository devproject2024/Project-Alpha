package net.one97.paytm.o2o.amusementpark.a;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.o2o.amusementpark.R;

public final class h extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final a f73151a;

    /* renamed from: b  reason: collision with root package name */
    public String f73152b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJROfferCode> f73153c;

    /* renamed from: d  reason: collision with root package name */
    Context f73154d;

    public interface a {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        final CJROfferCode cJROfferCode = this.f73153c.get(i2);
        if (cJROfferCode != null) {
            if (TextUtils.isEmpty(cJROfferCode.getTerms()) || cJROfferCode.getTerms().equalsIgnoreCase("N/A")) {
                bVar.f73165b.setText(cJROfferCode.getOfferText());
            } else {
                String obj = Html.fromHtml(cJROfferCode.getOfferText()).toString();
                SpannableString spannableString = new SpannableString(obj + " *T&Cs");
                AnonymousClass1 r3 = new ClickableSpan() {
                    public final void onClick(View view) {
                        com.paytm.utility.b.b(h.this.f73154d, cJROfferCode.getTermsTitle(), Html.fromHtml(cJROfferCode.getTerms()).toString(), true);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(true);
                        textPaint.setColor(androidx.core.content.b.c(h.this.f73154d, R.color.paytm_blue));
                    }
                };
                spannableString.setSpan(obj, 0, obj.length(), 33);
                spannableString.setSpan(r3, obj.length() + 1, obj.length() + 6, 33);
                bVar.f73165b.setText(spannableString);
                bVar.f73165b.setMovementMethod(LinkMovementMethod.getInstance());
            }
            bVar.f73164a.setText(cJROfferCode.getCode());
            bVar.f73167d.setTag(cJROfferCode.getCode());
            bVar.f73167d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str = (String) view.getTag();
                    if (TextUtils.isEmpty(h.this.f73152b)) {
                        h.this.f73151a.a(cJROfferCode.getCode());
                    } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(h.this.f73152b)) {
                        h hVar = h.this;
                        if (!TextUtils.isEmpty(str)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(hVar.f73154d);
                            builder.setMessage(Html.fromHtml(String.format(hVar.f73154d.getString(R.string.remove_promo_cart), new Object[]{str})));
                            builder.setPositiveButton(hVar.f73154d.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    h hVar = h.this;
                                    hVar.f73152b = null;
                                    hVar.notifyDataSetChanged();
                                }
                            });
                            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            });
                            builder.show();
                        }
                    } else {
                        h hVar2 = h.this;
                        String code = cJROfferCode.getCode();
                        if (!TextUtils.isEmpty(code)) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(hVar2.f73154d);
                            builder2.setMessage(Html.fromHtml("<B>" + hVar2.f73152b + "</B> has already been applied. If you wish to apply <B>" + code + "</B>, your last offer will be replaced."));
                            builder2.setPositiveButton(hVar2.f73154d.getString(R.string.cart_replace), new DialogInterface.OnClickListener(code) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ String f73159a;

                                {
                                    this.f73159a = r2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    h.this.f73151a.a(this.f73159a);
                                }
                            });
                            builder2.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    dialogInterface.dismiss();
                                }
                            });
                            builder2.show();
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.f73152b)) {
                bVar.f73168e.setVisibility(8);
                bVar.f73166c.setVisibility(0);
                bVar.f73167d.setBackground(this.f73154d.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add));
            } else if (cJROfferCode.getCode().equalsIgnoreCase(this.f73152b)) {
                bVar.f73168e.setVisibility(0);
                bVar.f73166c.setVisibility(8);
                bVar.f73167d.setBackground(this.f73154d.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add_selected));
            } else {
                bVar.f73168e.setVisibility(8);
                bVar.f73166c.setVisibility(0);
                bVar.f73167d.setBackground(this.f73154d.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add));
            }
        }
    }

    public h(Context context, ArrayList<CJROfferCode> arrayList, String str, a aVar) {
        this.f73154d = context;
        this.f73153c = arrayList;
        this.f73152b = str;
        this.f73151a = aVar;
    }

    public final int getItemCount() {
        ArrayList<CJROfferCode> arrayList = this.f73153c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f73164a;

        /* renamed from: b  reason: collision with root package name */
        TextView f73165b;

        /* renamed from: c  reason: collision with root package name */
        TextView f73166c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f73167d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f73168e;

        public b(View view) {
            super(view);
            this.f73164a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f73165b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f73167d = (RelativeLayout) view.findViewById(R.id.apply_promo_layout_train);
            this.f73168e = (ImageView) view.findViewById(R.id.apply_tick_image);
            this.f73166c = (TextView) view.findViewById(R.id.apply_text);
            TextView textView = this.f73166c;
            textView.setText(textView.getContext().getString(R.string.apply));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.park_offers_list_item, (ViewGroup) null));
    }
}
