package androidx.vectordrawable.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.b.g;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c extends h implements b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Object> f4866a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable.Callback f4867b;

    /* renamed from: d  reason: collision with root package name */
    private a f4868d;

    /* renamed from: e  reason: collision with root package name */
    private Context f4869e;

    /* renamed from: f  reason: collision with root package name */
    private ArgbEvaluator f4870f;

    /* renamed from: g  reason: collision with root package name */
    private Animator.AnimatorListener f4871g;

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    c() {
        this((Context) null, (byte) 0);
    }

    private c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        this.f4870f = null;
        this.f4871g = null;
        this.f4866a = null;
        this.f4867b = new Drawable.Callback() {
            public final void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.f4869e = context;
        this.f4868d = new a();
    }

    public final Drawable mutate() {
        if (this.f4883c != null) {
            this.f4883c.mutate();
        }
        return this;
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.f4883c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f4883c.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.f4883c != null) {
            return this.f4883c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4868d.f4873a;
    }

    public final void draw(Canvas canvas) {
        if (this.f4883c != null) {
            this.f4883c.draw(canvas);
            return;
        }
        this.f4868d.f4874b.draw(canvas);
        if (this.f4868d.f4875c.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.f4883c != null) {
            this.f4883c.setBounds(rect);
        } else {
            this.f4868d.f4874b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.f4883c != null) {
            return this.f4883c.setState(iArr);
        }
        return this.f4868d.f4874b.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i2) {
        if (this.f4883c != null) {
            return this.f4883c.setLevel(i2);
        }
        return this.f4868d.f4874b.setLevel(i2);
    }

    public final int getAlpha() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.b(this.f4883c);
        }
        return this.f4868d.f4874b.getAlpha();
    }

    public final void setAlpha(int i2) {
        if (this.f4883c != null) {
            this.f4883c.setAlpha(i2);
        } else {
            this.f4868d.f4874b.setAlpha(i2);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f4883c != null) {
            this.f4883c.setColorFilter(colorFilter);
        } else {
            this.f4868d.f4874b.setColorFilter(colorFilter);
        }
    }

    public final ColorFilter getColorFilter() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.d(this.f4883c);
        }
        return this.f4868d.f4874b.getColorFilter();
    }

    public final void setTint(int i2) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, i2);
        } else {
            this.f4868d.f4874b.setTint(i2);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, colorStateList);
        } else {
            this.f4868d.f4874b.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, mode);
        } else {
            this.f4868d.f4874b.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.f4883c != null) {
            return this.f4883c.setVisible(z, z2);
        }
        this.f4868d.f4874b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.f4883c != null) {
            return this.f4883c.isStateful();
        }
        return this.f4868d.f4874b.isStateful();
    }

    public final int getOpacity() {
        if (this.f4883c != null) {
            return this.f4883c.getOpacity();
        }
        return this.f4868d.f4874b.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.f4883c != null) {
            return this.f4883c.getIntrinsicWidth();
        }
        return this.f4868d.f4874b.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.f4883c != null) {
            return this.f4883c.getIntrinsicHeight();
        }
        return this.f4868d.f4874b.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.a(this.f4883c);
        }
        return this.f4868d.f4874b.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, z);
        } else {
            this.f4868d.f4874b.setAutoMirrored(z);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Animator animator;
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = g.a(resources, theme, attributeSet, a.f4861e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a3 = i.a(resources, resourceId, theme);
                        a3.f4886d = false;
                        a3.setCallback(this.f4867b);
                        if (this.f4868d.f4874b != null) {
                            this.f4868d.f4874b.setCallback((Drawable.Callback) null);
                        }
                        this.f4868d.f4874b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f4862f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4869e;
                        if (context != null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                animator = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                animator = e.a(context, context.getResources(), context.getTheme(), resourceId2);
                            }
                            animator.setTarget(this.f4868d.f4874b.f4885b.f4920b.k.get(string));
                            if (Build.VERSION.SDK_INT < 21) {
                                a(animator);
                            }
                            if (this.f4868d.f4876d == null) {
                                this.f4868d.f4876d = new ArrayList<>();
                                this.f4868d.f4877e = new androidx.a.a<>();
                            }
                            this.f4868d.f4876d.add(animator);
                            this.f4868d.f4877e.put(animator, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        a aVar = this.f4868d;
        if (aVar.f4875c == null) {
            aVar.f4875c = new AnimatorSet();
        }
        aVar.f4875c.playTogether(aVar.f4876d);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public final void applyTheme(Resources.Theme theme) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.c(this.f4883c);
        }
        return false;
    }

    static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4878a;

        public b(Drawable.ConstantState constantState) {
            this.f4878a = constantState;
        }

        public final Drawable newDrawable() {
            c cVar = new c();
            cVar.f4883c = this.f4878a.newDrawable();
            cVar.f4883c.setCallback(cVar.f4867b);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.f4883c = this.f4878a.newDrawable(resources);
            cVar.f4883c.setCallback(cVar.f4867b);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.f4883c = this.f4878a.newDrawable(resources, theme);
            cVar.f4883c.setCallback(cVar.f4867b);
            return cVar;
        }

        public final boolean canApplyTheme() {
            return this.f4878a.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f4878a.getChangingConfigurations();
        }
    }

    static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4873a;

        /* renamed from: b  reason: collision with root package name */
        i f4874b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f4875c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f4876d;

        /* renamed from: e  reason: collision with root package name */
        androidx.a.a<Animator, String> f4877e;

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final int getChangingConfigurations() {
            return this.f4873a;
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                a(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4870f == null) {
                    this.f4870f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4870f);
            }
        }
    }

    public final boolean isRunning() {
        if (this.f4883c != null) {
            return ((AnimatedVectorDrawable) this.f4883c).isRunning();
        }
        return this.f4868d.f4875c.isRunning();
    }

    public final void start() {
        if (this.f4883c != null) {
            ((AnimatedVectorDrawable) this.f4883c).start();
        } else if (!this.f4868d.f4875c.isStarted()) {
            this.f4868d.f4875c.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.f4883c != null) {
            ((AnimatedVectorDrawable) this.f4883c).stop();
        } else {
            this.f4868d.f4875c.end();
        }
    }
}
