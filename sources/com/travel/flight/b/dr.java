package com.travel.flight.b;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.e.a.a;
import com.travel.flight.flightorder.j.j;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytmflight.common.entity.flightticket.BundleCard;

public final class dr extends dq implements a.C0456a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final View.OnClickListener l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public dr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    private dr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[3], objArr[4], objArr[1], objArr[5], objArr[6], objArr[2]);
        this.m = -1;
        this.f23954a.setTag((Object) null);
        this.f23955b.setTag((Object) null);
        this.f23956c.setTag((Object) null);
        this.f23957d.setTag((Object) null);
        this.f23958e.setTag((Object) null);
        this.f23959f.setTag((Object) null);
        this.f23960g.setTag((Object) null);
        setRootTag(view);
        this.l = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23484h == i2) {
            a((BundleCard) obj);
        } else if (com.travel.flight.a.C != i2) {
            return false;
        } else {
            a((j.a) obj);
        }
        return true;
    }

    public final void a(BundleCard bundleCard) {
        this.f23961h = bundleCard;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(com.travel.flight.a.f23484h);
        super.requestRebind();
    }

    public final void a(j.a aVar) {
        this.f23962i = aVar;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.C);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        boolean z;
        int i2;
        String str4;
        String str5;
        int i3;
        String str6;
        boolean z2;
        String str7;
        String str8;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.m;
            this.m = 0;
        }
        BundleCard bundleCard = this.f23961h;
        String str9 = null;
        int i4 = ((j2 & 5) > 0 ? 1 : ((j2 & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (bundleCard != null) {
                str9 = bundleCard.getPromo_title();
                str7 = bundleCard.getTerms_condition_url();
                str4 = bundleCard.getPromo_code();
                z2 = bundleCard.isIs_pending();
                str3 = bundleCard.getPromo_use_hint();
                str6 = bundleCard.getPromo_code_validity();
                str8 = bundleCard.getTitle();
            } else {
                str8 = null;
                str7 = null;
                str4 = null;
                str3 = null;
                str6 = null;
                z2 = false;
            }
            if (i4 != 0) {
                if (z2) {
                    j4 = j2 | 16;
                    j3 = 64;
                } else {
                    j4 = j2 | 8;
                    j3 = 32;
                }
                j2 = j4 | j3;
            }
            i2 = 8;
            int i5 = z2 ? 8 : 0;
            if (z2) {
                i2 = 0;
            }
            z = !z2;
            str2 = str7;
            str = str9;
            str5 = str6;
            str9 = str8;
            i3 = i5;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            z = false;
        }
        if ((5 & j2) != 0) {
            this.f23955b.setEnabled(z);
            d.a(this.f23955b, (CharSequence) str4);
            this.f23955b.setVisibility(i3);
            this.f23956c.setVisibility(i2);
            d.a(this.f23957d, (CharSequence) str9);
            d.a(this.f23958e, (CharSequence) str5);
            TextView textView = this.f23959f;
            String string = textView.getResources().getString(R.string.t_and_c);
            String format = String.format("%s %s", new Object[]{str3, string});
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new ClickableSpan(str2, textView) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f24484a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ TextView f24485b;

                {
                    this.f24484a = r1;
                    this.f24485b = r2;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), FlightWebViewActivity.class);
                    intent.putExtra("url", this.f24484a);
                    view.getContext().startActivity(intent);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.f24485b.getResources().getColor(R.color.color_00b9f5));
                    textPaint.setUnderlineText(false);
                }
            }, format.indexOf(string), format.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setClickable(true);
            d.a(this.f23960g, (CharSequence) str);
        }
        if ((j2 & 4) != 0) {
            this.f23955b.setOnClickListener(this.l);
        }
    }

    public final void a(int i2, View view) {
        BundleCard bundleCard = this.f23961h;
        if (this.f23962i != null) {
            if (bundleCard != null) {
                String promo_code = bundleCard.getPromo_code();
                k.c(view, "view");
                CharSequence charSequence = promo_code;
                if (!TextUtils.isEmpty(charSequence)) {
                    if (Build.VERSION.SDK_INT < 11) {
                        Object systemService = view.getContext().getSystemService("clipboard");
                        if (systemService != null) {
                            ((ClipboardManager) systemService).setText(charSequence);
                        } else {
                            throw new u("null cannot be cast to non-null type android.text.ClipboardManager");
                        }
                    } else {
                        Object systemService2 = view.getContext().getSystemService("clipboard");
                        if (systemService2 != null) {
                            ((android.content.ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("text label", charSequence));
                        } else {
                            throw new u("null cannot be cast to non-null type android.content.ClipboardManager");
                        }
                    }
                    Context context = view.getContext();
                    k.a((Object) context, "view.context");
                    String string = context.getResources().getString(R.string.coupon_copied, new Object[]{promo_code});
                    k.a((Object) string, "view.context.resources.g…oupon_copied, couponCode)");
                    Toast.makeText(view.getContext(), string, 1).show();
                }
            }
        }
    }
}
