package net.one97.paytm.o2o.movies.adapter;

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
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;

public final class ac extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final a f74254a;

    /* renamed from: b  reason: collision with root package name */
    String f74255b;

    /* renamed from: c  reason: collision with root package name */
    Context f74256c;

    /* renamed from: d  reason: collision with root package name */
    String f74257d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJROfferCode> f74258e;

    public interface a {
        void a(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        final CJROfferCode cJROfferCode = this.f74258e.get(i2);
        if (cJROfferCode != null) {
            if (TextUtils.isEmpty(cJROfferCode.getTerms()) || cJROfferCode.getTerms().equalsIgnoreCase("N/A")) {
                bVar.f74269b.setText(cJROfferCode.getOfferText());
            } else {
                String obj = Html.fromHtml(cJROfferCode.getOfferText()).toString();
                SpannableString spannableString = new SpannableString(obj + " *T&Cs");
                AnonymousClass1 r3 = new ClickableSpan() {
                    public final void onClick(View view) {
                        ac acVar = ac.this;
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/promocode");
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.C);
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Promocode TnC Clicked");
                            if (!TextUtils.isEmpty(acVar.f74257d)) {
                                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, acVar.f74257d);
                            }
                            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                            if (com.paytm.utility.b.r(acVar.f74256c)) {
                                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(acVar.f74256c));
                            }
                            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, acVar.f74256c);
                        } catch (Exception e2) {
                            q.c(e2.getMessage());
                        }
                        com.paytm.utility.b.b(ac.this.f74256c, cJROfferCode.getTermsTitle(), Html.fromHtml(cJROfferCode.getTerms()).toString(), true);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(true);
                        textPaint.setColor(androidx.core.content.b.c(ac.this.f74256c, R.color.paytm_blue));
                    }
                };
                spannableString.setSpan(obj, 0, obj.length(), 33);
                spannableString.setSpan(r3, obj.length() + 1, obj.length() + 6, 33);
                bVar.f74269b.setText(spannableString);
                bVar.f74269b.setMovementMethod(LinkMovementMethod.getInstance());
            }
            bVar.f74268a.setText(cJROfferCode.getCode());
            bVar.f74271d.setTag(cJROfferCode.getCode());
            bVar.f74271d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str = (String) view.getTag();
                    if (TextUtils.isEmpty(ac.this.f74255b)) {
                        ac.this.f74254a.a(cJROfferCode.getCode());
                    } else if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(ac.this.f74255b)) {
                        ac acVar = ac.this;
                        if (!TextUtils.isEmpty(str)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(acVar.f74256c);
                            builder.setMessage(Html.fromHtml(String.format(acVar.f74256c.getString(R.string.remove_promo_cart), new Object[]{str})));
                            builder.setPositiveButton(acVar.f74256c.getString(R.string.menu_delete), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    ac acVar = ac.this;
                                    acVar.f74255b = null;
                                    acVar.notifyDataSetChanged();
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
                        ac acVar2 = ac.this;
                        String code = cJROfferCode.getCode();
                        if (!TextUtils.isEmpty(code)) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(acVar2.f74256c);
                            builder2.setMessage(Html.fromHtml("<B>" + acVar2.f74255b + "</B> has already been applied. If you wish to apply <B>" + code + "</B>, your last offer will be replaced."));
                            builder2.setPositiveButton(acVar2.f74256c.getString(R.string.cart_replace), new DialogInterface.OnClickListener(code) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ String f74263a;

                                {
                                    this.f74263a = r2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    ac.this.f74254a.a(this.f74263a);
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
            if (TextUtils.isEmpty(this.f74255b)) {
                bVar.f74272e.setVisibility(8);
                bVar.f74270c.setVisibility(0);
                bVar.f74271d.setBackground(this.f74256c.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add));
            } else if (cJROfferCode.getCode().equalsIgnoreCase(this.f74255b)) {
                bVar.f74272e.setVisibility(0);
                bVar.f74270c.setVisibility(8);
                bVar.f74271d.setBackground(this.f74256c.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add_selected));
            } else {
                bVar.f74272e.setVisibility(8);
                bVar.f74270c.setVisibility(0);
                bVar.f74271d.setBackground(this.f74256c.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.bg_btn_coupon_add));
            }
        }
    }

    public ac(Context context, ArrayList<CJROfferCode> arrayList, String str, a aVar) {
        this.f74256c = context;
        this.f74258e = arrayList;
        this.f74255b = str;
        this.f74254a = aVar;
    }

    public final int getItemCount() {
        ArrayList<CJROfferCode> arrayList = this.f74258e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74268a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74269b;

        /* renamed from: c  reason: collision with root package name */
        TextView f74270c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f74271d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f74272e;

        public b(View view) {
            super(view);
            this.f74268a = (TextView) view.findViewById(R.id.offer_code_text_view);
            this.f74269b = (TextView) view.findViewById(R.id.offer_desc_text_view);
            this.f74271d = (RelativeLayout) view.findViewById(R.id.apply_promo_layout_train);
            this.f74272e = (ImageView) view.findViewById(R.id.apply_tick_image);
            this.f74270c = (TextView) view.findViewById(R.id.apply_text);
            TextView textView = this.f74270c;
            textView.setText(textView.getContext().getString(R.string.apply));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_offers_list_item, (ViewGroup) null));
    }
}
