package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class v extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1813a;

    public v(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1813a = resources;
    }

    public CharSequence getText(int i2) throws Resources.NotFoundException {
        return this.f1813a.getText(i2);
    }

    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        return this.f1813a.getQuantityText(i2, i3);
    }

    public String getString(int i2) throws Resources.NotFoundException {
        return this.f1813a.getString(i2);
    }

    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f1813a.getString(i2, objArr);
    }

    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        return this.f1813a.getQuantityString(i2, i3, objArr);
    }

    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        return this.f1813a.getQuantityString(i2, i3);
    }

    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.f1813a.getText(i2, charSequence);
    }

    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        return this.f1813a.getTextArray(i2);
    }

    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        return this.f1813a.getStringArray(i2);
    }

    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        return this.f1813a.getIntArray(i2);
    }

    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return this.f1813a.obtainTypedArray(i2);
    }

    public float getDimension(int i2) throws Resources.NotFoundException {
        return this.f1813a.getDimension(i2);
    }

    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        return this.f1813a.getDimensionPixelOffset(i2);
    }

    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        return this.f1813a.getDimensionPixelSize(i2);
    }

    public float getFraction(int i2, int i3, int i4) {
        return this.f1813a.getFraction(i2, i3, i4);
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        return this.f1813a.getDrawable(i2);
    }

    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f1813a.getDrawable(i2, theme);
    }

    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        return this.f1813a.getDrawableForDensity(i2, i3);
    }

    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return this.f1813a.getDrawableForDensity(i2, i3, theme);
    }

    public Movie getMovie(int i2) throws Resources.NotFoundException {
        return this.f1813a.getMovie(i2);
    }

    public int getColor(int i2) throws Resources.NotFoundException {
        return this.f1813a.getColor(i2);
    }

    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return this.f1813a.getColorStateList(i2);
    }

    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        return this.f1813a.getBoolean(i2);
    }

    public int getInteger(int i2) throws Resources.NotFoundException {
        return this.f1813a.getInteger(i2);
    }

    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        return this.f1813a.getLayout(i2);
    }

    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        return this.f1813a.getAnimation(i2);
    }

    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return this.f1813a.getXml(i2);
    }

    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        return this.f1813a.openRawResource(i2);
    }

    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f1813a.openRawResource(i2, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        return this.f1813a.openRawResourceFd(i2);
    }

    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1813a.getValue(i2, typedValue, z);
    }

    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1813a.getValueForDensity(i2, i3, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1813a.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1813a.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1813a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f1813a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f1813a.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f1813a.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i2) throws Resources.NotFoundException {
        return this.f1813a.getResourceName(i2);
    }

    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return this.f1813a.getResourcePackageName(i2);
    }

    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return this.f1813a.getResourceTypeName(i2);
    }

    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return this.f1813a.getResourceEntryName(i2);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f1813a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f1813a.parseBundleExtra(str, attributeSet, bundle);
    }
}
