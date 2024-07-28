package androidx.core.f;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

public final class c implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2935b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Executor f2936c = null;

    /* renamed from: a  reason: collision with root package name */
    public final a f2937a;

    /* renamed from: d  reason: collision with root package name */
    private final Spannable f2938d;

    /* renamed from: e  reason: collision with root package name */
    private final PrecomputedText f2939e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f2940a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f2941b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2942c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2943d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f2944e;

        /* renamed from: androidx.core.f.c$a$a  reason: collision with other inner class name */
        public static class C0043a {

            /* renamed from: a  reason: collision with root package name */
            public TextDirectionHeuristic f2945a;

            /* renamed from: b  reason: collision with root package name */
            public int f2946b;

            /* renamed from: c  reason: collision with root package name */
            public int f2947c;

            /* renamed from: d  reason: collision with root package name */
            private final TextPaint f2948d;

            public C0043a(TextPaint textPaint) {
                this.f2948d = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2946b = 1;
                    this.f2947c = 1;
                } else {
                    this.f2947c = 0;
                    this.f2946b = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f2945a = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2945a = null;
                }
            }

            public final a a() {
                return new a(this.f2948d, this.f2945a, this.f2946b, this.f2947c);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2944e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2944e = null;
            }
            this.f2940a = textPaint;
            this.f2941b = textDirectionHeuristic;
            this.f2942c = i2;
            this.f2943d = i3;
        }

        public a(PrecomputedText.Params params) {
            this.f2940a = params.getTextPaint();
            this.f2941b = params.getTextDirection();
            this.f2942c = params.getBreakStrategy();
            this.f2943d = params.getHyphenationFrequency();
            this.f2944e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public final boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f2942c != aVar.f2942c || this.f2943d != aVar.f2943d)) || this.f2940a.getTextSize() != aVar.f2940a.getTextSize() || this.f2940a.getTextScaleX() != aVar.f2940a.getTextScaleX() || this.f2940a.getTextSkewX() != aVar.f2940a.getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f2940a.getLetterSpacing() != aVar.f2940a.getLetterSpacing() || !TextUtils.equals(this.f2940a.getFontFeatureSettings(), aVar.f2940a.getFontFeatureSettings()))) || this.f2940a.getFlags() != aVar.f2940a.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f2940a.getTextLocales().equals(aVar.f2940a.getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f2940a.getTextLocale().equals(aVar.f2940a.getTextLocale())) {
                return false;
            }
            if (this.f2940a.getTypeface() == null) {
                if (aVar.f2940a.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2940a.getTypeface().equals(aVar.f2940a.getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f2941b == aVar.f2941b;
        }

        public final int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return androidx.core.g.c.a(Float.valueOf(this.f2940a.getTextSize()), Float.valueOf(this.f2940a.getTextScaleX()), Float.valueOf(this.f2940a.getTextSkewX()), Float.valueOf(this.f2940a.getLetterSpacing()), Integer.valueOf(this.f2940a.getFlags()), this.f2940a.getTextLocales(), this.f2940a.getTypeface(), Boolean.valueOf(this.f2940a.isElegantTextHeight()), this.f2941b, Integer.valueOf(this.f2942c), Integer.valueOf(this.f2943d));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return androidx.core.g.c.a(Float.valueOf(this.f2940a.getTextSize()), Float.valueOf(this.f2940a.getTextScaleX()), Float.valueOf(this.f2940a.getTextSkewX()), Float.valueOf(this.f2940a.getLetterSpacing()), Integer.valueOf(this.f2940a.getFlags()), this.f2940a.getTextLocale(), this.f2940a.getTypeface(), Boolean.valueOf(this.f2940a.isElegantTextHeight()), this.f2941b, Integer.valueOf(this.f2942c), Integer.valueOf(this.f2943d));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return androidx.core.g.c.a(Float.valueOf(this.f2940a.getTextSize()), Float.valueOf(this.f2940a.getTextScaleX()), Float.valueOf(this.f2940a.getTextSkewX()), Integer.valueOf(this.f2940a.getFlags()), this.f2940a.getTextLocale(), this.f2940a.getTypeface(), this.f2941b, Integer.valueOf(this.f2942c), Integer.valueOf(this.f2943d));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return androidx.core.g.c.a(Float.valueOf(this.f2940a.getTextSize()), Float.valueOf(this.f2940a.getTextScaleX()), Float.valueOf(this.f2940a.getTextSkewX()), Integer.valueOf(this.f2940a.getFlags()), this.f2940a.getTextLocale(), this.f2940a.getTypeface(), this.f2941b, Integer.valueOf(this.f2942c), Integer.valueOf(this.f2943d));
            } else {
                return androidx.core.g.c.a(Float.valueOf(this.f2940a.getTextSize()), Float.valueOf(this.f2940a.getTextScaleX()), Float.valueOf(this.f2940a.getTextSkewX()), Integer.valueOf(this.f2940a.getFlags()), this.f2940a.getTypeface(), this.f2941b, Integer.valueOf(this.f2942c), Integer.valueOf(this.f2943d));
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2940a.getTextSize());
            sb.append(", textScaleX=" + this.f2940a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2940a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f2940a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2940a.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f2940a.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f2940a.getTextLocale());
            }
            sb.append(", typeface=" + this.f2940a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f2940a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2941b);
            sb.append(", breakStrategy=" + this.f2942c);
            sb.append(", hyphenationFrequency=" + this.f2943d);
            sb.append("}");
            return sb.toString();
        }
    }

    public final PrecomputedText a() {
        Spannable spannable = this.f2938d;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public final void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2939e.setSpan(obj, i2, i3, i4);
        } else {
            this.f2938d.setSpan(obj, i2, i3, i4);
        }
    }

    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2939e.removeSpan(obj);
        } else {
            this.f2938d.removeSpan(obj);
        }
    }

    public final <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2939e.getSpans(i2, i3, cls);
        }
        return this.f2938d.getSpans(i2, i3, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.f2938d.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.f2938d.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.f2938d.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2938d.nextSpanTransition(i2, i3, cls);
    }

    public final int length() {
        return this.f2938d.length();
    }

    public final char charAt(int i2) {
        return this.f2938d.charAt(i2);
    }

    public final CharSequence subSequence(int i2, int i3) {
        return this.f2938d.subSequence(i2, i3);
    }

    public final String toString() {
        return this.f2938d.toString();
    }
}
