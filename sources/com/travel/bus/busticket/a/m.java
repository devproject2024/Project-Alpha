package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.utils.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;

public final class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private int f21697a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJROfferCode> f21698b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f21699c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f21700d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f21701e;

    /* renamed from: f  reason: collision with root package name */
    private String f21702f;

    public interface a {
        void a(String str);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public m(Context context, ArrayList<CJROfferCode> arrayList, a aVar, String str, int i2) {
        this.f21701e = context;
        this.f21700d = LayoutInflater.from(context);
        this.f21698b = arrayList;
        this.f21699c = aVar;
        this.f21702f = str;
        this.f21697a = i2;
    }

    public final int getCount() {
        int i2 = this.f21697a;
        if (i2 != 0) {
            return i2;
        }
        ArrayList<CJROfferCode> arrayList = this.f21698b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Object getItem(int i2) {
        return this.f21698b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f21700d.inflate(R.layout.pre_b_lyt_bus_offer_item, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.f21710a = (RoboTextView) view.findViewById(R.id.txt_promo_code);
            bVar.f21711b = (RoboTextView) view.findViewById(R.id.txt_promo_msg);
            bVar.f21712c = (RoboTextView) view.findViewById(R.id.txt_radio_icon);
            bVar.f21713d = view.findViewById(R.id.horizontal_sep);
            bVar.f21712c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (m.this.f21699c != null && view.getTag() != null) {
                        m.this.f21699c.a((String) view.getTag());
                    }
                }
            });
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        final CJROfferCode cJROfferCode = this.f21698b.get(i2);
        bVar2.f21712c.setTag(cJROfferCode.getCode());
        if (!TextUtils.isEmpty(cJROfferCode.getCode())) {
            bVar2.f21710a.setText(cJROfferCode.getCode());
        }
        if (TextUtils.isEmpty(cJROfferCode.getOfferText())) {
            bVar2.f21711b.setText("");
        } else if (TextUtils.isEmpty(cJROfferCode.getTerms())) {
            bVar2.f21711b.setText(cJROfferCode.getOfferText());
        } else {
            bVar2.f21711b.setMovementMethod(LinkMovementMethod.getInstance());
            String str = " " + this.f21701e.getString(R.string.view_t_and_c);
            SpannableString spannableString = new SpannableString(cJROfferCode.getOfferText() + str + " ");
            spannableString.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    if (m.this.f21699c != null) {
                        m.this.f21699c.a(cJROfferCode.getCode());
                    }
                }

                public final void updateDrawState(TextPaint textPaint) {
                    try {
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(androidx.core.content.b.c(m.this.f21701e, R.color.color_323232));
                    } catch (Exception unused) {
                    }
                }
            }, 0, cJROfferCode.getOfferText().length(), 33);
            spannableString.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    m.a(m.this, cJROfferCode);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    try {
                        textPaint.setColor(androidx.core.content.b.c(m.this.f21701e, R.color.bus_paytm_blue));
                        textPaint.setUnderlineText(false);
                    } catch (Exception unused) {
                    }
                }
            }, cJROfferCode.getOfferText().length() + 1, cJROfferCode.getOfferText().length() + str.length(), 33);
            spannableString.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    if (m.this.f21699c != null) {
                        m.this.f21699c.a(cJROfferCode.getCode());
                    }
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    try {
                        q.a(m.this.f21701e);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(androidx.core.content.b.c(m.this.f21701e, R.color.bus_color_000000));
                    } catch (Exception unused) {
                    }
                }
            }, cJROfferCode.getOfferText().length() + str.length(), spannableString.length(), 33);
            bVar2.f21711b.setText(spannableString);
        }
        return view;
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f21710a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f21711b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f21712c;

        /* renamed from: d  reason: collision with root package name */
        View f21713d;

        private b() {
        }

        /* synthetic */ b(m mVar, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(m mVar, CJROfferCode cJROfferCode) {
        if (!TextUtils.isEmpty(cJROfferCode.getTerms()) && !TextUtils.isEmpty(cJROfferCode.getTermsTitle())) {
            com.paytm.utility.b.b(mVar.f21701e, cJROfferCode.getTermsTitle(), Html.fromHtml(cJROfferCode.getTerms()).toString());
        }
    }
}
