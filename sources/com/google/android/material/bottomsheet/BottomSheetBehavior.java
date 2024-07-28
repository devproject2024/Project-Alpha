package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.a.c;
import androidx.core.h.a.f;
import androidx.core.h.ab;
import androidx.core.h.u;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.q;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    private final ArrayList<a> callbacks = new ArrayList<>();
    int collapsedOffset;
    private final c.a dragCallback = new c.a() {
        public final boolean b(View view, int i2) {
            if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i2) {
                View view2 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? (View) BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == view;
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.dispatchOnSlide(i3);
        }

        public final void a(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public final void a(View view, float f2, float f3) {
            int i2;
            int i3;
            int i4 = 3;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.fitToContents) {
                    i2 = BottomSheetBehavior.this.fitToContentsOffset;
                } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                    i2 = BottomSheetBehavior.this.halfExpandedOffset;
                } else {
                    i2 = BottomSheetBehavior.this.expandedOffset;
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
            } else if (!BottomSheetBehavior.this.hideable || !BottomSheetBehavior.this.shouldHide(view, f3)) {
                if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i2 = BottomSheetBehavior.this.fitToContentsOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
                        }
                        i3 = BottomSheetBehavior.this.collapsedOffset;
                    } else if (top < BottomSheetBehavior.this.halfExpandedOffset) {
                        if (top < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i2 = BottomSheetBehavior.this.expandedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
                        }
                        i2 = BottomSheetBehavior.this.halfExpandedOffset;
                    } else if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                        i2 = BottomSheetBehavior.this.halfExpandedOffset;
                    } else {
                        i3 = BottomSheetBehavior.this.collapsedOffset;
                    }
                } else {
                    if (!BottomSheetBehavior.this.fitToContents) {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            i2 = BottomSheetBehavior.this.halfExpandedOffset;
                        }
                    }
                    i3 = BottomSheetBehavior.this.collapsedOffset;
                }
                i4 = 4;
                BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
            } else {
                if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                    if (!(view.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i2 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                            i2 = BottomSheetBehavior.this.expandedOffset;
                        } else {
                            i2 = BottomSheetBehavior.this.halfExpandedOffset;
                        }
                        BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
                    }
                }
                i2 = BottomSheetBehavior.this.parentHeight;
                i4 = 5;
                BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
            }
            i4 = 6;
            BottomSheetBehavior.this.startSettlingAnimation(view, i4, i2, true);
        }

        public final int d(View view, int i2) {
            return androidx.core.c.a.a(i2, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
        }

        public final int c(View view, int i2) {
            return view.getLeft();
        }

        public final int b() {
            if (BottomSheetBehavior.this.hideable) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    float elevation = -1.0f;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = HIDE_THRESHOLD;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    /* access modifiers changed from: private */
    public h materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags = 0;
    private BottomSheetBehavior<V>.defpackage.b settleRunnable = null;
    private m shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    private VelocityTracker velocityTracker;
    c viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class a {
        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i2);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, com.google.android.material.h.c.a(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, HIDE_THRESHOLD));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.f3245d);
        restoreOptionalState(savedState);
        if (savedState.f36001a == 1 || savedState.f36001a == 2) {
            this.state = 4;
        } else {
            this.state = savedState.f36001a;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.d dVar) {
        super.onAttachedToLayoutParams(dVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
        h hVar;
        if (u.A(coordinatorLayout) && !u.A(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setSystemGestureInsets(v);
            this.viewRef = new WeakReference<>(v);
            if (this.shapeThemingEnabled && (hVar = this.materialShapeDrawable) != null) {
                u.a((View) v, (Drawable) hVar);
            }
            h hVar2 = this.materialShapeDrawable;
            if (hVar2 != null) {
                float f2 = this.elevation;
                if (f2 == -1.0f) {
                    f2 = u.v(v);
                }
                hVar2.r(f2);
                this.isShapeExpanded = this.state == 3;
                this.materialShapeDrawable.p(this.isShapeExpanded ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (u.h(v) == 0) {
                u.c((View) v, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = c.a((ViewGroup) coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.b(v, i2);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i3 = this.state;
        if (i3 == 3) {
            u.f((View) v, getExpandedOffset());
        } else if (i3 == 6) {
            u.f((View) v, this.halfExpandedOffset);
        } else if (!this.hideable || i3 != 5) {
            int i4 = this.state;
            if (i4 == 4) {
                u.f((View) v, this.collapsedOffset);
            } else if (i4 == 1 || i4 == 2) {
                u.f((View) v, top - v.getTop());
            }
        } else {
            u.f((View) v, this.parentHeight);
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r9.draggable
            if (r0 != 0) goto L_0x000e
            goto L_0x00d0
        L_0x000e:
            int r0 = r12.getActionMasked()
            if (r0 != 0) goto L_0x0017
            r9.reset()
        L_0x0017:
            android.view.VelocityTracker r3 = r9.velocityTracker
            if (r3 != 0) goto L_0x0021
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r9.velocityTracker = r3
        L_0x0021:
            android.view.VelocityTracker r3 = r9.velocityTracker
            r3.addMovement(r12)
            r3 = 0
            r4 = -1
            r5 = 2
            if (r0 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0031
            r11 = 3
            if (r0 == r11) goto L_0x0031
            goto L_0x007f
        L_0x0031:
            r9.touchingScrollingChild = r1
            r9.activePointerId = r4
            boolean r11 = r9.ignoreEvents
            if (r11 == 0) goto L_0x007f
            r9.ignoreEvents = r1
            return r1
        L_0x003c:
            float r6 = r12.getX()
            int r6 = (int) r6
            float r7 = r12.getY()
            int r7 = (int) r7
            r9.initialY = r7
            int r7 = r9.state
            if (r7 == r5) goto L_0x006e
            java.lang.ref.WeakReference<android.view.View> r7 = r9.nestedScrollingChildRef
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0058
        L_0x0057:
            r7 = r3
        L_0x0058:
            if (r7 == 0) goto L_0x006e
            int r8 = r9.initialY
            boolean r7 = r10.a((android.view.View) r7, (int) r6, (int) r8)
            if (r7 == 0) goto L_0x006e
            int r7 = r12.getActionIndex()
            int r7 = r12.getPointerId(r7)
            r9.activePointerId = r7
            r9.touchingScrollingChild = r2
        L_0x006e:
            int r7 = r9.activePointerId
            if (r7 != r4) goto L_0x007c
            int r4 = r9.initialY
            boolean r11 = r10.a((android.view.View) r11, (int) r6, (int) r4)
            if (r11 != 0) goto L_0x007c
            r11 = 1
            goto L_0x007d
        L_0x007c:
            r11 = 0
        L_0x007d:
            r9.ignoreEvents = r11
        L_0x007f:
            boolean r11 = r9.ignoreEvents
            if (r11 != 0) goto L_0x008e
            androidx.customview.a.c r11 = r9.viewDragHelper
            if (r11 == 0) goto L_0x008e
            boolean r11 = r11.a((android.view.MotionEvent) r12)
            if (r11 == 0) goto L_0x008e
            return r2
        L_0x008e:
            java.lang.ref.WeakReference<android.view.View> r11 = r9.nestedScrollingChildRef
            if (r11 == 0) goto L_0x0099
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x0099:
            if (r0 != r5) goto L_0x00cf
            if (r3 == 0) goto L_0x00cf
            boolean r11 = r9.ignoreEvents
            if (r11 != 0) goto L_0x00cf
            int r11 = r9.state
            if (r11 == r2) goto L_0x00cf
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.a((android.view.View) r3, (int) r11, (int) r0)
            if (r10 != 0) goto L_0x00cf
            androidx.customview.a.c r10 = r9.viewDragHelper
            if (r10 == 0) goto L_0x00cf
            int r10 = r9.initialY
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            androidx.customview.a.c r11 = r9.viewDragHelper
            int r11 = r11.f3235b
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00cf
            return r2
        L_0x00cf:
            return r1
        L_0x00d0:
            r9.ignoreEvents = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        c cVar = this.viewDragHelper;
        if (cVar != null) {
            cVar.b(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.f3235b)) {
            this.viewDragHelper.a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (!this.ignoreEvents) {
            return true;
        }
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        u.f((View) v, -iArr[1]);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i3;
                        u.f((View) v, -i3);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.collapsedOffset;
                    if (i5 > i6 && !this.hideable) {
                        iArr[1] = top - i6;
                        u.f((View) v, -iArr[1]);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i3;
                        u.f((View) v, -i3);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i3;
                this.nestedScrolled = true;
            }
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i3 = this.fitToContentsOffset;
                } else {
                    int top = v.getTop();
                    int i6 = this.halfExpandedOffset;
                    if (top > i6) {
                        i3 = i6;
                    } else {
                        i3 = this.expandedOffset;
                    }
                }
                startSettlingAnimation(v, i5, i3, false);
                this.nestedScrolled = false;
            } else if (!this.hideable || !shouldHide(v, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top2 = v.getTop();
                    if (!this.fitToContents) {
                        int i7 = this.halfExpandedOffset;
                        if (top2 < i7) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i3 = this.expandedOffset;
                                startSettlingAnimation(v, i5, i3, false);
                                this.nestedScrolled = false;
                            }
                            i3 = this.halfExpandedOffset;
                        } else if (Math.abs(top2 - i7) < Math.abs(top2 - this.collapsedOffset)) {
                            i3 = this.halfExpandedOffset;
                        } else {
                            i4 = this.collapsedOffset;
                        }
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i3 = this.fitToContentsOffset;
                        startSettlingAnimation(v, i5, i3, false);
                        this.nestedScrolled = false;
                    } else {
                        i4 = this.collapsedOffset;
                    }
                } else {
                    if (!this.fitToContents) {
                        int top3 = v.getTop();
                        if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                            i3 = this.halfExpandedOffset;
                        }
                    }
                    i4 = this.collapsedOffset;
                }
                i5 = 4;
                startSettlingAnimation(v, i5, i3, false);
                this.nestedScrolled = false;
            } else {
                i3 = this.parentHeight;
                i5 = 5;
                startSettlingAnimation(v, i5, i3, false);
                this.nestedScrolled = false;
            }
            i5 = 6;
            startSettlingAnimation(v, i5, i3, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get() || (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v, view, f2, f3))) {
            return false;
        }
        return true;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((!this.fitToContents || this.state != 6) ? this.state : 3);
            updateAccessibilityActions();
        }
    }

    public void setPeekHeight(int i2) {
        setPeekHeight(i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.peekHeightAuto
            if (r2 != 0) goto L_0x0017
            int r2 = r3.peekHeight
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.updatePeekHeight(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z) {
                    settleToStatePendingLayout(this.state);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHalfExpandedRatio(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f2;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int i2) {
        if (i2 >= 0) {
            this.expandedOffset = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setSaveFlags(int i2) {
        this.saveFlags = i2;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    @Deprecated
    public void setBottomSheetCallback(a aVar) {
        this.callbacks.clear();
        if (aVar != null) {
            this.callbacks.add(aVar);
        }
    }

    public void addBottomSheetCallback(a aVar) {
        if (!this.callbacks.contains(aVar)) {
            this.callbacks.add(aVar);
        }
    }

    public void removeBottomSheetCallback(a aVar) {
        this.callbacks.remove(aVar);
    }

    public void setState(int i2) {
        if (i2 != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.hideable && i2 == 5)) {
                this.state = i2;
            }
        }
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    private void settleToStatePendingLayout(final int i2) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !u.M(view)) {
                settleToState(view, i2);
            } else {
                view.post(new Runnable() {
                    public final void run() {
                        BottomSheetBehavior.this.settleToState(view, i2);
                    }
                });
            }
        }
    }

    public int getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i2) {
        View view;
        if (this.state != i2) {
            this.state = i2;
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i2 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i2);
                for (int i3 = 0; i3 < this.callbacks.size(); i3++) {
                    this.callbacks.get(i3).onStateChanged(view, i2);
                }
                updateAccessibilityActions();
            }
        }
    }

    private void updateDrawableForTargetState(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z = i2 == 3;
            if (this.isShapeExpanded != z) {
                this.isShapeExpanded = z;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    float f2 = z ? 0.0f : 1.0f;
                    this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f2, f2});
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        }
        return this.peekHeight + (this.gestureInsetBottomIgnored ? 0 : this.gestureInsetBottom);
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i2 = this.saveFlags;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.peekHeight = savedState.f36002b;
            }
            int i3 = this.saveFlags;
            if (i3 == -1 || (i3 & 2) == 2) {
                this.fitToContents = savedState.f36003e;
            }
            int i4 = this.saveFlags;
            if (i4 == -1 || (i4 & 4) == 4) {
                this.hideable = savedState.f36004f;
            }
            int i5 = this.saveFlags;
            if (i5 == -1 || (i5 & 8) == 8) {
                this.skipCollapsed = savedState.f36005g;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(View view, float f2) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f2 * HIDE_FRICTION)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > HIDE_THRESHOLD) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View findScrollingChild(View view) {
        if (u.G(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i2));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z) {
        createMaterialShapeDrawable(context, attributeSet, z, (ColorStateList) null);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = m.a(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).a();
            this.materialShapeDrawable = new h(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable.a(context);
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.g(colorStateList);
        }
    }

    private void createShapeValueAnimator() {
        this.interpolatorAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.p(floatValue);
                }
            }
        });
    }

    private void setSystemGestureInsets(View view) {
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.peekHeightAuto) {
            q.a(view, (q.a) new q.a() {
                public final ab a(View view, ab abVar, q.b bVar) {
                    int unused = BottomSheetBehavior.this.gestureInsetBottom = abVar.f3061b.i().f2976e;
                    BottomSheetBehavior.this.updatePeekHeight(false);
                    return abVar;
                }
            });
        }
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    /* access modifiers changed from: package-private */
    public void settleToState(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.collapsedOffset;
        } else if (i2 == 6) {
            int i5 = this.halfExpandedOffset;
            if (!this.fitToContents || i5 > (i4 = this.fitToContentsOffset)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = getExpandedOffset();
        } else if (!this.hideable || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(i2)));
        } else {
            i3 = this.parentHeight;
        }
        startSettlingAnimation(view, i2, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void startSettlingAnimation(View view, int i2, int i3, boolean z) {
        boolean z2;
        if (z) {
            z2 = this.viewDragHelper.a(view.getLeft(), i3);
        } else {
            z2 = this.viewDragHelper.a(view, view.getLeft(), i3);
        }
        if (z2) {
            setStateInternal(2);
            updateDrawableForTargetState(i2);
            if (this.settleRunnable == null) {
                this.settleRunnable = new b(view, i2);
            }
            if (!this.settleRunnable.f36009d) {
                BottomSheetBehavior<V>.defpackage.b bVar = this.settleRunnable;
                bVar.f36006a = i2;
                u.a(view, (Runnable) bVar);
                boolean unused = this.settleRunnable.f36009d = true;
                return;
            }
            this.settleRunnable.f36006a = i2;
            return;
        }
        setStateInternal(i2);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i2) {
        float f2;
        float f3;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i3 = this.collapsedOffset;
            if (i2 > i3 || i3 == getExpandedOffset()) {
                int i4 = this.collapsedOffset;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.parentHeight - i4);
            } else {
                int i5 = this.collapsedOffset;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - getExpandedOffset());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.callbacks.size(); i6++) {
                this.callbacks.get(i6).onSlide(view, f4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f36006a;

        /* renamed from: c  reason: collision with root package name */
        private final View f36008c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f36009d;

        b(View view, int i2) {
            this.f36008c = view;
            this.f36006a = i2;
        }

        public final void run() {
            if (BottomSheetBehavior.this.viewDragHelper == null || !BottomSheetBehavior.this.viewDragHelper.f()) {
                BottomSheetBehavior.this.setStateInternal(this.f36006a);
            } else {
                u.a(this.f36008c, (Runnable) this);
            }
            this.f36009d = false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final int f36001a;

        /* renamed from: b  reason: collision with root package name */
        int f36002b;

        /* renamed from: e  reason: collision with root package name */
        boolean f36003e;

        /* renamed from: f  reason: collision with root package name */
        boolean f36004f;

        /* renamed from: g  reason: collision with root package name */
        boolean f36005g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f36001a = parcel.readInt();
            this.f36002b = parcel.readInt();
            boolean z = false;
            this.f36003e = parcel.readInt() == 1;
            this.f36004f = parcel.readInt() == 1;
            this.f36005g = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f36001a = bottomSheetBehavior.state;
            this.f36002b = bottomSheetBehavior.peekHeight;
            this.f36003e = bottomSheetBehavior.fitToContents;
            this.f36004f = bottomSheetBehavior.hideable;
            this.f36005g = bottomSheetBehavior.skipCollapsed;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f36001a);
            parcel.writeInt(this.f36002b);
            parcel.writeInt(this.f36003e ? 1 : 0);
            parcel.writeInt(this.f36004f ? 1 : 0);
            parcel.writeInt(this.f36005g ? 1 : 0);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.d) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) layoutParams).f2603a;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    private void updateImportantForAccessibility(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.viewRef.get()) {
                        if (z) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                u.c(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            u.c(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                }
            }
        }
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            u.d(view, 524288);
            u.d(view, 262144);
            u.d(view, 1048576);
            if (this.hideable && this.state != 5) {
                addAccessibilityActionForState(view, c.a.u, 5);
            }
            int i2 = this.state;
            int i3 = 6;
            if (i2 == 3) {
                if (this.fitToContents) {
                    i3 = 4;
                }
                addAccessibilityActionForState(view, c.a.t, i3);
            } else if (i2 == 4) {
                if (this.fitToContents) {
                    i3 = 3;
                }
                addAccessibilityActionForState(view, c.a.s, i3);
            } else if (i2 == 6) {
                addAccessibilityActionForState(view, c.a.t, 4);
                addAccessibilityActionForState(view, c.a.s, 3);
            }
        }
    }

    private void addAccessibilityActionForState(V v, c.a aVar, final int i2) {
        u.a((View) v, aVar, (f) new f() {
            public final boolean a(View view) {
                BottomSheetBehavior.this.setState(i2);
                return true;
            }
        });
    }
}
