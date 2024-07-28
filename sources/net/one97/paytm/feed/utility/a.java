package net.one97.paytm.feed.utility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.a.a.i;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.aa;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35384a = new a();

    private a() {
    }

    public static final void a(ImageView imageView, String str) {
        k.c(imageView, "view");
        k.c(str, "imageUrl");
        if (!(str.length() == 0)) {
            w.a().a(Uri.parse(str)).a(imageView, (e) null);
        }
    }

    public static final void a(View view, boolean z) {
        k.c(view, "view");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final void a(ImageView imageView, String str, String str2, String str3) {
        k.c(imageView, "imageView");
        w a2 = w.a();
        if (!URLUtil.isValidUrl(str)) {
            return;
        }
        if (str2 == null || str3 == null) {
            a2.a(Uri.parse(str)).a(imageView, (e) null);
        } else if (Integer.parseInt(str2) <= 0 || Integer.parseInt(str3) <= 0) {
            a2.a(Uri.parse(str)).a(imageView, (e) null);
        } else if (Integer.parseInt(str2) >= 800 || Integer.parseInt(str3) >= 800) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?height=");
            r rVar = r.f35432a;
            sb.append(r.b());
            sb.append("&width=");
            r rVar2 = r.f35432a;
            sb.append(r.a());
            a2.a(Uri.parse(sb.toString())).a(Integer.parseInt(str2), Integer.parseInt(str3)).a(imageView, (e) null);
        } else {
            a2.a(Uri.parse(str)).a(Integer.parseInt(str2), Integer.parseInt(str3)).a(imageView, (e) null);
        }
    }

    public static final void a(TextView textView, String str) {
        k.c(textView, "textView");
        k.c(str, "url");
        Context context = textView.getContext();
        k.a((Object) context, "textView.context");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, i.a(context.getResources(), R.drawable.feed_ic_view_all, (Resources.Theme) null), (Drawable) null);
    }

    public static final void b(TextView textView, String str) {
        k.c(textView, "textView");
        k.c(str, "url");
        Context context = textView.getContext();
        k.a((Object) context, "textView.context");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i.a(context.getResources(), R.drawable.feed_ic_download, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static final void b(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        w a2 = w.a();
        if (URLUtil.isValidUrl(str)) {
            a2.a(Uri.parse(str)).a(imageView, (e) null);
        }
    }

    public static final void c(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        Drawable b2 = androidx.appcompat.a.a.a.b(imageView.getContext(), R.drawable.feed_ic_placeholder);
        w a2 = w.a();
        if (URLUtil.isValidUrl(str)) {
            aa a3 = a2.a(Uri.parse(str));
            a3.f45352a = true;
            if (b2 == null) {
                k.a();
            }
            a3.a(b2).a(imageView, (e) null);
            return;
        }
        imageView.setImageDrawable(b2);
    }

    public static final void d(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        Drawable b2 = androidx.appcompat.a.a.a.b(imageView.getContext(), R.drawable.feed_ic_merchant_stores);
        w a2 = w.a();
        if (URLUtil.isValidUrl(str)) {
            aa a3 = a2.a(Uri.parse(str));
            a3.f45352a = true;
            if (b2 == null) {
                k.a();
            }
            a3.a(b2).a(imageView, (e) null);
            return;
        }
        imageView.setImageDrawable(b2);
    }

    public static final void b(ImageView imageView, String str, String str2, String str3) {
        k.c(imageView, "imageView");
        Drawable b2 = androidx.appcompat.a.a.a.b(imageView.getContext(), R.drawable.feed_ic_female_avatar);
        w a2 = w.a();
        if (!URLUtil.isValidUrl(str)) {
            imageView.setImageDrawable(b2);
        } else if (Integer.parseInt(str2) <= 0 || Integer.parseInt(str3) <= 0) {
            aa a3 = a2.a(Uri.parse(str));
            a3.f45352a = true;
            if (b2 == null) {
                k.a();
            }
            a3.a(b2).a(imageView, (e) null);
        } else {
            aa a4 = a2.a(Uri.parse(str));
            if (b2 == null) {
                k.a();
            }
            a4.a(b2).a(imageView, (e) null);
        }
    }

    public static final void a(TextView textView) {
        k.c(textView, "view");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final void b(View view, boolean z) {
        i iVar;
        k.c(view, "view");
        if (z) {
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            iVar = i.a(context.getResources(), R.drawable.feed_ic_send_empty, (Resources.Theme) null);
        } else {
            Context context2 = view.getContext();
            k.a((Object) context2, "view.context");
            iVar = i.a(context2.getResources(), R.drawable.feed_ic_send, (Resources.Theme) null);
        }
        ((ImageView) view).setImageDrawable(iVar);
    }

    public static final void a(View view, String str, String str2) {
        k.c(view, "view");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Integer num = null;
            Integer valueOf = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                if (str2 != null) {
                    num = Integer.valueOf(Integer.parseInt(str2));
                }
                if (num == null) {
                    k.a();
                }
                if (num.intValue() > 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        ((ConstraintLayout.LayoutParams) layoutParams).B = str + ':' + str2;
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                }
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams2).width = -1;
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                if (layoutParams3 != null) {
                    ((ConstraintLayout.LayoutParams) layoutParams3).height = -2;
                } else {
                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
            } else {
                throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public static final void a(ImageView imageView, boolean z, boolean z2) {
        k.c(imageView, "imageView");
        if (z) {
            Context context = imageView.getContext();
            k.a((Object) context, "imageView.context");
            imageView.setImageDrawable(i.a(context.getResources(), R.drawable.feed_ic_sensitive, (Resources.Theme) null));
        } else if (z2) {
            Context context2 = imageView.getContext();
            k.a((Object) context2, "imageView.context");
            imageView.setImageDrawable(i.a(context2.getResources(), R.drawable.feed_ic_blocked, (Resources.Theme) null));
        }
    }

    public static final void c(View view, boolean z) {
        i iVar;
        k.c(view, "view");
        if (z) {
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            iVar = i.a(context.getResources(), R.drawable.feed_ic_like, (Resources.Theme) null);
        } else {
            Context context2 = view.getContext();
            k.a((Object) context2, "view.context");
            iVar = i.a(context2.getResources(), R.drawable.feed_ic_unlike, (Resources.Theme) null);
        }
        ((ImageView) view).setImageDrawable(iVar);
    }

    public static final void a(TextView textView, boolean z) {
        k.c(textView, "view");
        if (!z) {
            textView.setTextColor(b.c(textView.getContext(), R.color.feed_colorAccent));
            textView.setText(R.string.feed_follow);
            return;
        }
        textView.setTextColor(b.c(textView.getContext(), R.color.feed_following));
        textView.setText(R.string.feed_following);
    }

    public static final void a(ImageView imageView, boolean z) {
        k.c(imageView, "view");
        if (z) {
            imageView.setImageResource(R.drawable.feed_ic_bookmark);
        } else {
            imageView.setImageResource(R.drawable.feed_ic_unbookmark);
        }
    }

    public static final void a(View view, float f2) {
        k.c(view, "view");
        int i2 = (int) f2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.setMargins(i2, i2, i2, i2);
            view.setLayoutParams(layoutParams2);
            if (i2 == 0) {
                Drawable mutate = ((ConstraintLayout) view).getBackground().mutate();
                k.a((Object) mutate, "(view as ConstraintLayout).background.mutate()");
                if (mutate != null) {
                    ((GradientDrawable) mutate).setCornerRadius(0.0f);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public static final void b(View view, float f2) {
        k.c(view, "view");
        int i2 = (int) f2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.setMargins(i2, 0, i2, 0);
            view.setLayoutParams(layoutParams2);
            if (i2 == 0) {
                Drawable mutate = ((ConstraintLayout) view).getBackground().mutate();
                k.a((Object) mutate, "(view as ConstraintLayout).background.mutate()");
                if (mutate != null) {
                    ((GradientDrawable) mutate).setCornerRadius(0.0f);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public static final void a(TextView textView, Integer num) {
        k.c(textView, "view");
        if (num != null) {
            textView.setText(String.valueOf(num.intValue() / 1000));
        }
    }

    public static final void a(RoundedImageView roundedImageView, int i2) {
        k.c(roundedImageView, "imageView");
        if (i2 == 1) {
            roundedImageView.setCornerRadius(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        r rVar = r.f35432a;
        Context context = roundedImageView.getContext();
        k.a((Object) context, "imageView.context");
        float a2 = r.a(10.0f, context);
        r rVar2 = r.f35432a;
        Context context2 = roundedImageView.getContext();
        k.a((Object) context2, "imageView.context");
        roundedImageView.setCornerRadius(a2, r.a(10.0f, context2), 0.0f, 0.0f);
    }

    public static final void a(View view, String str) {
        k.c(view, "view");
        k.c(str, "id");
        ImageView imageView = (ImageView) view;
        Context context = imageView.getContext();
        k.a((Object) context, "view.context");
        imageView.setImageDrawable(i.a(context.getResources(), R.drawable.feed_ic_banner_placeholder, (Resources.Theme) null));
    }
}
