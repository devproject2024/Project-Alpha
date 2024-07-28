package com.paytm.android.chat.utils;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.paytm.android.chat.c;

public class CTextUtils {
    public static boolean isEmojiCharacter(char c2) {
        if (c2 == 0 || c2 == 9 || c2 == 10 || c2 == 13) {
            return false;
        }
        if (c2 >= ' ' && c2 <= '~') {
            return false;
        }
        if (c2 >= 160 && c2 <= 255) {
            return false;
        }
        if (c2 < 256 || c2 > 383) {
            return c2 < 384 || c2 > 591;
        }
        return false;
    }

    public static Builder getBuilder(CharSequence charSequence) {
        return new Builder(charSequence);
    }

    public static class Builder {
        private Layout.Alignment align;
        private int backgroundColor;
        private Bitmap bitmap;
        private int bulletColor;
        private ClickableSpan clickSpan;
        private int defaultValue;
        private Drawable drawable;
        private int first;
        private int flag;
        private String fontFamily;
        private int foregroundColor;
        private int gapWidth;
        private boolean imageIsBitmap;
        private boolean imageIsDrawable;
        private boolean imageIsResourceId;
        private boolean imageIsUri;
        private boolean isBlur;
        private boolean isBold;
        private boolean isBoldItalic;
        private boolean isBullet;
        private boolean isItalic;
        private boolean isLeadingMargin;
        private boolean isStrikethrough;
        private boolean isSubscript;
        private boolean isSuperscript;
        private boolean isUnderline;
        private SpannableStringBuilder mBuilder;
        private float proportion;
        private int quoteColor;
        private float radius;
        private int resourceId;
        private int rest;
        private BlurMaskFilter.Blur style;
        private CharSequence text;
        private Uri uri;
        private String url;
        private float xProportion;

        private Builder(CharSequence charSequence) {
            this.defaultValue = 301989888;
            this.text = charSequence;
            this.flag = 33;
            int i2 = this.defaultValue;
            this.foregroundColor = i2;
            this.backgroundColor = i2;
            this.quoteColor = i2;
            this.proportion = -1.0f;
            this.xProportion = -1.0f;
            this.mBuilder = new SpannableStringBuilder();
        }

        public Builder setFlag(int i2) {
            this.flag = i2;
            return this;
        }

        public Builder setForegroundColor(int i2) {
            this.foregroundColor = i2;
            return this;
        }

        public Builder setBackgroundColor(int i2) {
            this.backgroundColor = i2;
            return this;
        }

        public Builder setQuoteColor(int i2) {
            this.quoteColor = i2;
            return this;
        }

        public Builder setLeadingMargin(int i2, int i3) {
            this.first = i2;
            this.rest = i3;
            this.isLeadingMargin = true;
            return this;
        }

        public Builder setBullet(int i2, int i3) {
            this.gapWidth = i2;
            this.bulletColor = i3;
            this.isBullet = true;
            return this;
        }

        public Builder setProportion(float f2) {
            this.proportion = f2;
            return this;
        }

        public Builder setXProportion(float f2) {
            this.xProportion = f2;
            return this;
        }

        public Builder setStrikethrough() {
            this.isStrikethrough = true;
            return this;
        }

        public Builder setUnderline() {
            this.isUnderline = true;
            return this;
        }

        public Builder setSuperscript() {
            this.isSuperscript = true;
            return this;
        }

        public Builder setSubscript() {
            this.isSubscript = true;
            return this;
        }

        public Builder setBold() {
            this.isBold = true;
            return this;
        }

        public Builder setItalic() {
            this.isItalic = true;
            return this;
        }

        public Builder setBoldItalic() {
            this.isBoldItalic = true;
            return this;
        }

        public Builder setFontFamily(String str) {
            this.fontFamily = str;
            return this;
        }

        public Builder setAlign(Layout.Alignment alignment) {
            this.align = alignment;
            return this;
        }

        public Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            this.imageIsBitmap = true;
            return this;
        }

        public Builder setDrawable(Drawable drawable2) {
            this.drawable = drawable2;
            this.imageIsDrawable = true;
            return this;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            this.imageIsUri = true;
            return this;
        }

        public Builder setResourceId(int i2) {
            this.resourceId = i2;
            this.imageIsResourceId = true;
            return this;
        }

        public Builder setClickSpan(ClickableSpan clickableSpan) {
            this.clickSpan = clickableSpan;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setBlur(float f2, BlurMaskFilter.Blur blur) {
            this.radius = f2;
            this.style = blur;
            this.isBlur = true;
            return this;
        }

        public Builder append(CharSequence charSequence) {
            setSpan();
            this.text = charSequence;
            return this;
        }

        public SpannableStringBuilder create() {
            setSpan();
            return this.mBuilder;
        }

        public void into(TextView textView) {
            setSpan();
            if (textView != null) {
                textView.setText(this.mBuilder);
            }
        }

        private void setSpan() {
            int length = this.mBuilder.length();
            this.mBuilder.append(this.text);
            int length2 = this.mBuilder.length();
            int i2 = this.backgroundColor;
            if (i2 != this.defaultValue) {
                this.mBuilder.setSpan(new BackgroundColorSpan(i2), length, length2, this.flag);
                this.backgroundColor = this.defaultValue;
            }
            if (this.isLeadingMargin) {
                this.mBuilder.setSpan(new LeadingMarginSpan.Standard(this.first, this.rest), length, length2, this.flag);
                this.isLeadingMargin = false;
            }
            int i3 = this.quoteColor;
            if (i3 != this.defaultValue) {
                this.mBuilder.setSpan(new QuoteSpan(i3), length, length2, 0);
                this.quoteColor = this.defaultValue;
            }
            if (this.isBullet) {
                this.mBuilder.setSpan(new BulletSpan(this.gapWidth, this.bulletColor), length, length2, 0);
                this.isBullet = false;
            }
            float f2 = this.proportion;
            if (f2 != -1.0f) {
                this.mBuilder.setSpan(new RelativeSizeSpan(f2), length, length2, this.flag);
                this.proportion = -1.0f;
            }
            float f3 = this.xProportion;
            if (f3 != -1.0f) {
                this.mBuilder.setSpan(new ScaleXSpan(f3), length, length2, this.flag);
                this.xProportion = -1.0f;
            }
            if (this.isStrikethrough) {
                this.mBuilder.setSpan(new StrikethroughSpan(), length, length2, this.flag);
                this.isStrikethrough = false;
            }
            if (this.isUnderline) {
                this.mBuilder.setSpan(new UnderlineSpan(), length, length2, this.flag);
                this.isUnderline = false;
            }
            if (this.isSuperscript) {
                this.mBuilder.setSpan(new SuperscriptSpan(), length, length2, this.flag);
                this.isSuperscript = false;
            }
            if (this.isSubscript) {
                this.mBuilder.setSpan(new SubscriptSpan(), length, length2, this.flag);
                this.isSubscript = false;
            }
            if (this.isBold) {
                this.mBuilder.setSpan(new StyleSpan(1), length, length2, this.flag);
                this.isBold = false;
            }
            if (this.isItalic) {
                this.mBuilder.setSpan(new StyleSpan(2), length, length2, this.flag);
                this.isItalic = false;
            }
            if (this.isBoldItalic) {
                this.mBuilder.setSpan(new StyleSpan(3), length, length2, this.flag);
                this.isBoldItalic = false;
            }
            String str = this.fontFamily;
            if (str != null) {
                this.mBuilder.setSpan(new TypefaceSpan(str), length, length2, this.flag);
                this.fontFamily = null;
            }
            Layout.Alignment alignment = this.align;
            if (alignment != null) {
                this.mBuilder.setSpan(new AlignmentSpan.Standard(alignment), length, length2, this.flag);
                this.align = null;
            }
            if (this.imageIsBitmap || this.imageIsDrawable || this.imageIsUri || this.imageIsResourceId) {
                if (this.imageIsBitmap) {
                    if (Build.VERSION.SDK_INT >= 4) {
                        this.mBuilder.setSpan(new ImageSpan(c.a(), this.bitmap), length, length2, this.flag);
                    }
                    this.bitmap = null;
                    this.imageIsBitmap = false;
                } else if (this.imageIsDrawable) {
                    this.mBuilder.setSpan(new ImageSpan(this.drawable), length, length2, this.flag);
                    this.drawable = null;
                    this.imageIsDrawable = false;
                } else if (this.imageIsUri) {
                    this.mBuilder.setSpan(new ImageSpan(c.a(), this.uri), length, length2, this.flag);
                    this.uri = null;
                    this.imageIsUri = false;
                } else {
                    this.mBuilder.setSpan(new ImageSpan(c.a(), this.resourceId), length, length2, this.flag);
                    this.resourceId = 0;
                    this.imageIsResourceId = false;
                }
            }
            ClickableSpan clickableSpan = this.clickSpan;
            if (clickableSpan != null) {
                this.mBuilder.setSpan(clickableSpan, length, length2, this.flag);
                this.clickSpan = null;
            }
            int i4 = this.foregroundColor;
            if (i4 != this.defaultValue) {
                this.mBuilder.setSpan(new ForegroundColorSpan(i4), length, length2, this.flag);
                this.foregroundColor = this.defaultValue;
            }
            String str2 = this.url;
            if (str2 != null) {
                this.mBuilder.setSpan(new URLSpan(str2), length, length2, this.flag);
                this.url = null;
            }
            if (this.isBlur) {
                this.mBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.radius, this.style)), length, length2, this.flag);
                this.isBlur = false;
            }
            this.flag = 33;
        }
    }

    public static boolean containsEmoji(String str) {
        int length = str.length();
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            z = isEmojiCharacter(str.charAt(i3));
            if (z) {
                i2++;
            }
        }
        if (i2 < length || i2 > 10) {
            return false;
        }
        return z;
    }
}
