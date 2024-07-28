package net.one97.paytm.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRSavedCard;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ai;

@Deprecated
public final class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public CJRSavedCard f52317a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRSavedCard> f52318b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f52319c;

    /* renamed from: d  reason: collision with root package name */
    private Context f52320d;

    /* renamed from: e  reason: collision with root package name */
    private int f52321e = com.paytm.utility.a.u(this.f52320d);

    /* renamed from: f  reason: collision with root package name */
    private ImageLoader f52322f;

    /* renamed from: g  reason: collision with root package name */
    private String f52323g;

    public c(Context context, ArrayList<CJRSavedCard> arrayList, CJRSavedCard cJRSavedCard) {
        this.f52318b = arrayList;
        this.f52319c = LayoutInflater.from(context);
        this.f52320d = context;
        this.f52317a = cJRSavedCard;
    }

    public final int getCount() {
        return this.f52318b.size();
    }

    public final Object getItem(int i2) {
        return this.f52318b.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f52318b.get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            CJRSavedCard cJRSavedCard = this.f52318b.get(i2);
            if (view == null) {
                view = this.f52319c.inflate(R.layout.paytm_automatic_saved_cards_lyt, (ViewGroup) null);
                a aVar = new a();
                aVar.f52327b = (ImageView) view.findViewById(R.id.bank_name_radio_btn);
                aVar.f52329d = (TextView) view.findViewById(R.id.selectbank_txt_bankname);
                aVar.f52328c = (TextView) view.findViewById(R.id.card_number);
                aVar.f52330e = (ImageView) view.findViewById(R.id.card_img);
                aVar.f52326a = (RelativeLayout) view.findViewById(R.id.card_lyt);
                aVar.f52326a.setPadding(this.f52321e, 0, this.f52321e, 0);
                this.f52322f = ai.INSTANCE.getImageLoader();
                b.d(aVar.f52329d);
                b.a(aVar.f52328c);
                ViewGroup.LayoutParams layoutParams = aVar.f52330e.getLayoutParams();
                int t = (com.paytm.utility.a.t(this.f52320d) / 5) * 4;
                layoutParams.width = t * 3;
                layoutParams.height = t * 2;
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            if (cJRSavedCard.getCardBIN() == null || cJRSavedCard.getCardLastDigit() == null || cJRSavedCard.getCardBIN().trim().length() <= 0) {
                aVar2.f52328c.setVisibility(8);
            } else {
                aVar2.f52328c.setVisibility(0);
                String cardBIN = cJRSavedCard.getCardBIN();
                String str = cardBIN.substring(0, 4) + " " + cardBIN.substring(4, 6);
                aVar2.f52328c.setText(" " + str + "XX XXXX " + cJRSavedCard.getCardLastDigit());
            }
            if (cJRSavedCard.getCardID() == null || cJRSavedCard.getCardID().trim().length() <= 0) {
                aVar2.f52329d.setVisibility(8);
            } else {
                aVar2.f52329d.setVisibility(0);
                if (cJRSavedCard.getBankname() != null) {
                    aVar2.f52329d.setText(cJRSavedCard.getBankname());
                }
            }
            aVar2.f52330e.getLayoutParams();
            com.paytm.utility.a.u(this.f52320d);
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("SavedCard_thumbnail", (String) null) != null) {
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.j.c.a();
                sb.append(net.one97.paytm.j.c.a("SavedCard_thumbnail", (String) null));
                sb.append("/");
                sb.append(cJRSavedCard.getCardType());
                sb.append(".png");
                this.f52323g = sb.toString();
                this.f52323g = b.a(this.f52323g, aVar2.f52330e.getLayoutParams().width, aVar2.f52330e.getLayoutParams().height);
                final ImageView imageView = aVar2.f52330e;
                ai.INSTANCE.getImageLoader().get(this.f52323g, new ImageLoader.ImageListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                    }

                    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                        Bitmap bitmap;
                        if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
                if (this.f52317a == null || !cJRSavedCard.equals(this.f52317a)) {
                    aVar2.f52327b.setImageDrawable(this.f52320d.getResources().getDrawable(R.drawable.btn_radio_off_disabled_holo_light));
                } else {
                    aVar2.f52327b.setImageDrawable(this.f52320d.getResources().getDrawable(R.drawable.btn_radio_on_holo_light));
                }
            }
            return view;
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
            return view;
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f52326a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f52327b;

        /* renamed from: c  reason: collision with root package name */
        TextView f52328c;

        /* renamed from: d  reason: collision with root package name */
        TextView f52329d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f52330e;

        public a() {
        }
    }
}
