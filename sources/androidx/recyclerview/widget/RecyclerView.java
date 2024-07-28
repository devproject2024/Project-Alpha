package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.a.c;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.aa;
import androidx.recyclerview.widget.ab;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.w;
import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public class RecyclerView extends ViewGroup implements androidx.core.h.j, androidx.core.h.k {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (Build.VERSION.SDK_INT >= 23);
    static final boolean ALLOW_THREAD_GAP_WORK = (Build.VERSION.SDK_INT >= 21);
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (Build.VERSION.SDK_INT <= 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (Build.VERSION.SDK_INT <= 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (Build.VERSION.SDK_INT >= 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    w mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    a mAdapter;
    a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private d mChildDrawingOrderCallback;
    f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    k mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private k mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    f mItemAnimator;
    private f.a mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final p mObserver;
    private List<i> mOnChildAttachStateListeners;
    private j mOnFlingListener;
    private final ArrayList<k> mOnItemTouchListeners;
    final List<v> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    k.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final n mRecycler;
    o mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private l mScrollListener;
    private List<l> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.h.l mScrollingChildHelper;
    final s mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final u mViewFlinger;
    private final ab.b mViewInfoProcessCallback;
    final ab mViewInfoStore;

    public interface d {
        int onGetChildDrawingOrder(int i2, int i3);
    }

    public interface i {
        void a(View view);

        void b(View view);
    }

    public static abstract class j {
        public abstract boolean onFling(int i2, int i3);
    }

    public interface k {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class l {
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public interface o {
        void onViewRecycled(v vVar);
    }

    public static class q implements k {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public static abstract class t {
        public abstract View a();
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    public void scrollTo(int i2, int i3) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new p();
        this.mRecycler = new n();
        this.mViewInfoStore = new ab();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public final void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutSuppressed) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new e();
        this.mItemAnimator = new g();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new u();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new k.a() : null;
        this.mState = new s();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public final void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ab.b() {
            public final void a(v vVar, f.b bVar, f.b bVar2) {
                RecyclerView.this.mRecycler.b(vVar);
                RecyclerView.this.animateDisappearance(vVar, bVar, bVar2);
            }

            public final void b(v vVar, f.b bVar, f.b bVar2) {
                RecyclerView.this.animateAppearance(vVar, bVar, bVar2);
            }

            public final void c(v vVar, f.b bVar, f.b bVar2) {
                vVar.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.a(vVar, vVar, bVar, bVar2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.c(vVar, bVar, bVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            public final void a(v vVar) {
                RecyclerView.this.mLayout.removeAndRecycleView(vVar.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.h.v.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.h.v.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f4060h = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (androidx.core.h.u.h(this) == 0) {
            androidx.core.h.u.c((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new w(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        if (this.mEnableFastScroller) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    private void initAutofill() {
        if (androidx.core.h.u.b(this) == 0) {
            androidx.core.h.u.c(this);
        }
    }

    public w getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(w wVar) {
        this.mAccessibilityDelegate = wVar;
        androidx.core.h.u.a((View) this, (androidx.core.h.a) this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e8);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(AppUtility.CENTER_DOT)) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new f(new f.b() {
            public final int a() {
                return RecyclerView.this.getChildCount();
            }

            public final void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.dispatchChildAttached(view);
            }

            public final int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public final void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            public final View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            public final v b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public final void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            public final void c(int i2) {
                v childViewHolderInt;
                View b2 = b(i2);
                if (!(b2 == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(b2)) == null)) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            public final void c(View view) {
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public final void d(View view) {
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            public final void b() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View b2 = b(i2);
                    RecyclerView.this.dispatchChildDetached(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new a(new a.C0068a() {
            public final v a(int i2) {
                v findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i2, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.d(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            public final void a(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f4092c += i3;
            }

            public final void b(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public final void a(int i2, int i3, Object obj) {
                RecyclerView.this.viewRangeUpdate(i2, i3, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            public final void a(a.b bVar) {
                c(bVar);
            }

            private void c(a.b bVar) {
                int i2 = bVar.f4154a;
                if (i2 == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, bVar.f4155b, bVar.f4157d);
                } else if (i2 == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, bVar.f4155b, bVar.f4157d);
                } else if (i2 == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, bVar.f4155b, bVar.f4157d, bVar.f4156c);
                } else if (i2 == 8) {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, bVar.f4155b, bVar.f4157d, 1);
                }
            }

            public final void b(a.b bVar) {
                c(bVar);
            }

            public final void c(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public final void d(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder("setScrollingTouchSlop(): bad argument constant ");
                sb.append(i2);
                sb.append("; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.a();
    }

    private void setAdapterInternal(a aVar, boolean z, boolean z2) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.a();
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(aVar3, this.mAdapter);
        }
        n nVar = this.mRecycler;
        a aVar4 = this.mAdapter;
        nVar.a();
        m d2 = nVar.d();
        if (aVar3 != null) {
            d2.c();
        }
        if (!z && d2.f4068b == 0) {
            d2.a();
        }
        if (aVar4 != null) {
            d2.b();
        }
        this.mState.f4095f = true;
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(o oVar) {
        this.mRecyclerListener = oVar;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(i iVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(iVar);
    }

    public void removeOnChildAttachStateChangeListener(i iVar) {
        List<i> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<i> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                f fVar = this.mItemAnimator;
                if (fVar != null) {
                    fVar.d();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.a();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.a();
            }
            f fVar2 = this.mChildHelper;
            f.a aVar = fVar2.f4203b;
            while (true) {
                aVar.f4205a = 0;
                if (aVar.f4206b == null) {
                    break;
                }
                aVar = aVar.f4206b;
            }
            for (int size = fVar2.f4204c.size() - 1; size >= 0; size--) {
                fVar2.f4202a.d(fVar2.f4204c.get(size));
                fVar2.f4204c.remove(size);
            }
            fVar2.f4202a.b();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    this.mLayout.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.b();
            requestLayout();
        }
    }

    public void setOnFlingListener(j jVar) {
        this.mOnFlingListener = jVar;
    }

    public j getOnFlingListener() {
        return this.mOnFlingListener;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.f4058a = savedState2.f4058a;
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.f4058a = layoutManager.onSaveInstanceState();
            } else {
                savedState.f4058a = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.f3245d);
        if (this.mLayout != null && this.mPendingSavedState.f4058a != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f4058a);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(v vVar) {
        View view = vVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.b(getChildViewHolder(view));
        if (vVar.isTmpDetached()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.a(view, -1, true);
        } else {
            f fVar = this.mChildHelper;
            int a2 = fVar.f4202a.a(view);
            if (a2 >= 0) {
                fVar.f4203b.a(a2);
                fVar.a(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        f fVar = this.mChildHelper;
        int a2 = fVar.f4202a.a(view);
        boolean z = true;
        if (a2 == -1) {
            fVar.b(view);
        } else if (fVar.f4203b.c(a2)) {
            fVar.f4203b.d(a2);
            fVar.b(view);
            fVar.f4202a.a(a2);
        } else {
            z = false;
        }
        if (z) {
            v childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.b(childViewHolderInt);
            this.mRecycler.a(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z);
        return z;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public m getRecycledViewPool() {
        return this.mRecycler.d();
    }

    public void setRecycledViewPool(m mVar) {
        n nVar = this.mRecycler;
        if (nVar.f4079g != null) {
            nVar.f4079g.c();
        }
        nVar.f4079g = mVar;
        if (nVar.f4079g != null && RecyclerView.this.getAdapter() != null) {
            nVar.f4079g.b();
        }
    }

    public void setViewCacheExtension(t tVar) {
        this.mRecycler.f4080h = tVar;
    }

    public void setItemViewCacheSize(int i2) {
        n nVar = this.mRecycler;
        nVar.f4077e = i2;
        nVar.b();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    public void addItemDecoration(h hVar, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(h hVar) {
        addItemDecoration(hVar, -1);
    }

    public h getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeItemDecoration(h hVar) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = dVar;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(l lVar) {
        this.mScrollListener = lVar;
    }

    public void addOnScrollListener(l lVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(lVar);
    }

    public void removeOnScrollListener(l lVar) {
        List<l> list = this.mScrollListeners;
        if (list != null) {
            list.remove(lVar);
        }
    }

    public void clearOnScrollListeners() {
        List<l> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.scrollToPosition(i2);
                awakenScrollBars();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i2) {
        LayoutManager layoutManager;
        if (!this.mLayoutSuppressed && (layoutManager = this.mLayout) != null) {
            layoutManager.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && !this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.d.m.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        androidx.core.d.m.a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.d.m.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.d.m.a();
        } else if (this.mAdapterHelper.d()) {
            if (this.mAdapterHelper.a(4) && !this.mAdapterHelper.a(11)) {
                androidx.core.d.m.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                androidx.core.d.m.a();
            } else if (this.mAdapterHelper.d()) {
                androidx.core.d.m.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                androidx.core.d.m.a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int a2 = this.mChildHelper.a();
        for (int i2 = 0; i2 < a2; i2++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        int i9 = i3;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i8, i9, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            i6 = i11;
            i7 = i10;
            i5 = i8 - i10;
            i4 = i9 - i11;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i12 = i7;
        dispatchNestedScroll(i7, i6, i5, i4, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i13 = i5 - iArr4[0];
        int i14 = i4 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i15 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i15 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), (float) i13, motionEvent.getY(), (float) i14);
                }
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        int i16 = i12;
        if (!(i16 == 0 && i6 == 0)) {
            dispatchOnScrolled(i16, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i16 == 0 && i6 == 0) ? false : true;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth <= 0) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, (Interpolator) null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && !this.mLayoutSuppressed) {
            int i5 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        startNestedScroll(i5, 1);
                    }
                    this.mViewFlinger.a(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public boolean fling(int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || this.mLayoutSuppressed) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        int i4 = (!canScrollHorizontally || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
        int i5 = (!canScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) ? 0 : i3;
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        float f2 = (float) i4;
        float f3 = (float) i5;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(f2, f3, z);
            j jVar = this.mOnFlingListener;
            if (jVar != null && jVar.onFling(i4, i5)) {
                return true;
            }
            if (z) {
                if (canScrollVertically) {
                    canScrollHorizontally |= true;
                }
                startNestedScroll(canScrollHorizontally ? 1 : 0, 1);
                int i6 = this.mMaxFlingVelocity;
                int max = Math.max(-i6, Math.min(i4, i6));
                int i7 = this.mMaxFlingVelocity;
                int max2 = Math.max(-i7, Math.min(i5, i7));
                u uVar = this.mViewFlinger;
                RecyclerView.this.setScrollState(2);
                uVar.f4100b = 0;
                uVar.f4099a = 0;
                Interpolator interpolator = uVar.f4102d;
                Interpolator interpolator2 = sQuinticInterpolator;
                if (interpolator != interpolator2) {
                    uVar.f4102d = interpolator2;
                    uVar.f4101c = new OverScroller(RecyclerView.this.getContext(), sQuinticInterpolator);
                }
                uVar.f4101c.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                uVar.a();
                return true;
            }
        }
        return false;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.d.a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.h.u.g(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.h.u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.h.u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            androidx.core.h.u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = e.a(this);
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = e.a(this);
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = e.a(this);
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = e.a(this);
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.g.f.a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                z = instance.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (isPreferredNextFocus(view, view2, i2)) {
                return view2;
            }
            return super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            requestChildOnScreen(view2, (View) null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            i3 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f4056e) {
                Rect rect = layoutParams2.f4055d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r4.mLayout
            if (r1 == 0) goto L_0x001e
            r1.dispatchAttachedToWindow(r4)
        L_0x001e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x006b
            java.lang.ThreadLocal<androidx.recyclerview.widget.k> r0 = androidx.recyclerview.widget.k.f4291a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.k r0 = (androidx.recyclerview.widget.k) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.k r0 = r4.mGapWorker
            if (r0 != 0) goto L_0x0064
            androidx.recyclerview.widget.k r0 = new androidx.recyclerview.widget.k
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.h.u.O(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.k r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f4295d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.k> r0 = androidx.recyclerview.widget.k.f4291a
            androidx.recyclerview.widget.k r1 = r4.mGapWorker
            r0.set(r1)
        L_0x0064:
            androidx.recyclerview.widget.k r0 = r4.mGapWorker
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView> r0 = r0.f4293b
            r0.add(r4)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        ab.a.b();
        if (ALLOW_THREAD_GAP_WORK && (kVar = this.mGapWorker) != null) {
            kVar.f4293b.remove(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            new IllegalStateException(exceptionLabel());
        }
    }

    public void addOnItemTouchListener(k kVar) {
        this.mOnItemTouchListeners.add(kVar);
    }

    public void removeOnItemTouchListener(k kVar) {
        this.mOnItemTouchListeners.remove(kVar);
        if (this.mInterceptingOnItemTouchListener == kVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        k kVar = this.mInterceptingOnItemTouchListener;
        if (kVar != null) {
            kVar.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i2 = 0;
        while (i2 < size) {
            k kVar = this.mOnItemTouchListeners.get(i2);
            if (!kVar.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.mInterceptingOnItemTouchListener = kVar;
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                StringBuilder sb = new StringBuilder("Error processing scroll; pointer index for id ");
                sb.append(this.mScrollPointerId);
                sb.append(" not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x01d7
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x01d7
        L_0x000f:
            boolean r0 = r17.dispatchToOnItemTouchListeners(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.cancelScroll()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.mNestedOffsets
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.mNestedOffsets
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01ab
            if (r0 == r9) goto L_0x0169
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01cc
        L_0x0066:
            r17.onPointerUp(r18)
            goto L_0x01cc
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x01cc
        L_0x0087:
            r17.cancelScroll()
            goto L_0x01cc
        L_0x008c:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00a6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.<init>(r1)
            int r1 = r6.mScrollPointerId
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            return r8
        L_0x00a6:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00ef
            if (r10 == 0) goto L_0x00d3
            if (r0 <= 0) goto L_0x00c8
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00cf
        L_0x00c8:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00cf:
            if (r0 == 0) goto L_0x00d3
            r2 = 1
            goto L_0x00d4
        L_0x00d3:
            r2 = 0
        L_0x00d4:
            if (r11 == 0) goto L_0x00ea
            if (r1 <= 0) goto L_0x00e0
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00e7
        L_0x00e0:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00e7:
            if (r1 == 0) goto L_0x00ea
            r2 = 1
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef
            r6.setScrollState(r9)
        L_0x00ef:
            r15 = r0
            r16 = r1
            int r0 = r6.mScrollState
            if (r0 != r9) goto L_0x01cc
            int[] r0 = r6.mReusableIntPair
            r0[r8] = r8
            r0[r9] = r8
            if (r10 == 0) goto L_0x0100
            r1 = r15
            goto L_0x0101
        L_0x0100:
            r1 = 0
        L_0x0101:
            if (r11 == 0) goto L_0x0106
            r2 = r16
            goto L_0x0107
        L_0x0106:
            r2 = 0
        L_0x0107:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0136
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0136:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0148
            r1 = r15
            goto L_0x0149
        L_0x0148:
            r1 = 0
        L_0x0149:
            if (r11 == 0) goto L_0x014d
            r2 = r0
            goto L_0x014e
        L_0x014d:
            r2 = 0
        L_0x014e:
            boolean r1 = r6.scrollByInternal(r1, r2, r7)
            if (r1 == 0) goto L_0x015b
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x015b:
            androidx.recyclerview.widget.k r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x01cc
            if (r15 != 0) goto L_0x0163
            if (r0 == 0) goto L_0x01cc
        L_0x0163:
            androidx.recyclerview.widget.k r1 = r6.mGapWorker
            r1.a((androidx.recyclerview.widget.RecyclerView) r6, (int) r15, (int) r0)
            goto L_0x01cc
        L_0x0169:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.mMaxFlingVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0185
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0186
        L_0x0185:
            r1 = 0
        L_0x0186:
            if (r11 == 0) goto L_0x0192
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x0193
        L_0x0192:
            r2 = 0
        L_0x0193:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x019b
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01a3
        L_0x019b:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01a6
        L_0x01a3:
            r6.setScrollState(r8)
        L_0x01a6:
            r17.resetScroll()
            r8 = 1
            goto L_0x01cc
        L_0x01ab:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r11 == 0) goto L_0x01c9
            r10 = r10 | 2
        L_0x01c9:
            r6.startNestedScroll(r10, r8)
        L_0x01cc:
            if (r8 != 0) goto L_0x01d3
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x01d3:
            r12.recycle()
            return r9
        L_0x01d7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f3 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            scrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.f4093d == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i2, i3);
                this.mState.f4098i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f4098i = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.k) {
                    this.mState.f4096g = true;
                } else {
                    this.mAdapterHelper.e();
                    this.mState.f4096g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.mAdapter;
            if (aVar != null) {
                this.mState.f4094e = aVar.getItemCount();
            } else {
                this.mState.f4094e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.f4096g = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingLeft() + getPaddingRight(), androidx.core.h.u.q(this)), LayoutManager.chooseSize(i3, getPaddingTop() + getPaddingBottom(), androidx.core.h.u.r(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.d();
            this.mItemAnimator.f4060h = null;
        }
        this.mItemAnimator = fVar;
        f fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.f4060h = this.mItemAnimatorListener;
        }
    }

    /* access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter <= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(EmiUtil.EMI_PLAN_REQUEST_CODE);
            androidx.core.h.a.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int b2 = accessibilityEvent != null ? androidx.core.h.a.b.b(accessibilityEvent) : 0;
        if (b2 == 0) {
            b2 = 0;
        }
        this.mEatenAccessibilityChangeFlags = b2 | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public f getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            androidx.core.h.u.a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.b();
        } else {
            this.mAdapterHelper.e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        s sVar = this.mState;
        if (sVar.j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        sVar.k = z;
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        if (this.mAdapter != null && this.mLayout != null) {
            s sVar = this.mState;
            boolean z = false;
            sVar.f4098i = false;
            if (sVar.f4093d == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                a aVar = this.mAdapterHelper;
                if (!aVar.f4147b.isEmpty() && !aVar.f4146a.isEmpty()) {
                    z = true;
                }
                if (!z && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                } else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    dispatchLayoutStep2();
                }
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int i2;
        v vVar = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            vVar = findContainingViewHolder(focusedChild);
        }
        if (vVar == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.hasStableIds() ? vVar.getItemId() : -1;
        s sVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i2 = -1;
        } else if (vVar.isRemoved()) {
            i2 = vVar.mOldPosition;
        } else {
            i2 = vVar.getAdapterPosition();
        }
        sVar.l = i2;
        this.mState.n = getDeepestFocusedViewWithId(vVar.itemView);
    }

    private void resetFocusInfo() {
        s sVar = this.mState;
        sVar.m = -1;
        sVar.l = -1;
        sVar.n = -1;
    }

    private View findNextViewToFocus() {
        v findViewHolderForAdapterPosition;
        int i2 = this.mState.l != -1 ? this.mState.l : 0;
        int a2 = this.mState.a();
        int i3 = i2;
        while (i3 < a2) {
            v findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i3++;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    private void recoverFocusFromState() {
        View view;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.d(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                v findViewHolderForItemId = (this.mState.m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m);
                if (findViewHolderForItemId != null && !this.mChildHelper.d(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view2 = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.a() > 0) {
                    view2 = findNextViewToFocus();
                }
                if (view2 != null) {
                    if (((long) this.mState.n) == -1 || (view = view2.findViewById(this.mState.n)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f4101c;
            sVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        sVar.o = 0;
        sVar.p = 0;
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f4098i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        s sVar = this.mState;
        sVar.f4097h = sVar.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        s sVar2 = this.mState;
        sVar2.f4096g = sVar2.k;
        this.mState.f4094e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int a2 = this.mChildHelper.a();
            for (int i2 = 0; i2 < a2; i2++) {
                v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    f.e(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.a(childViewHolderInt, new f.b().a(childViewHolderInt));
                    if (this.mState.f4097h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            boolean z = this.mState.f4095f;
            s sVar3 = this.mState;
            sVar3.f4095f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, sVar3);
            this.mState.f4095f = z;
            for (int i3 = 0; i3 < this.mChildHelper.a(); i3++) {
                v childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.b(i3));
                if (!childViewHolderInt2.shouldIgnore()) {
                    ab.a aVar = this.mViewInfoStore.f4165a.get(childViewHolderInt2);
                    if (!((aVar == null || (aVar.f4168a & 4) == 0) ? false : true)) {
                        f.e(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                        childViewHolderInt2.getUnmodifiedPayloads();
                        f.b a3 = new f.b().a(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a3);
                        } else {
                            ab abVar = this.mViewInfoStore;
                            ab.a aVar2 = abVar.f4165a.get(childViewHolderInt2);
                            if (aVar2 == null) {
                                aVar2 = ab.a.a();
                                abVar.f4165a.put(childViewHolderInt2, aVar2);
                            }
                            aVar2.f4168a |= 2;
                            aVar2.f4169b = a3;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f4093d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.e();
        this.mState.f4094e = this.mAdapter.getItemCount();
        s sVar = this.mState;
        sVar.f4092c = 0;
        sVar.f4096g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, sVar);
        s sVar2 = this.mState;
        sVar2.f4095f = false;
        this.mPendingSavedState = null;
        sVar2.j = sVar2.j && this.mItemAnimator != null;
        this.mState.f4093d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        s sVar = this.mState;
        sVar.f4093d = 1;
        if (sVar.j) {
            for (int a2 = this.mChildHelper.a() - 1; a2 >= 0; a2--) {
                v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(a2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    f.b a3 = new f.b().a(childViewHolderInt);
                    v a4 = this.mViewInfoStore.f4166b.a(changedHolderKey, null);
                    if (a4 != null && !a4.shouldIgnore()) {
                        boolean a5 = this.mViewInfoStore.a(a4);
                        boolean a6 = this.mViewInfoStore.a(childViewHolderInt);
                        if (!a5 || a4 != childViewHolderInt) {
                            f.b a7 = this.mViewInfoStore.a(a4, 4);
                            this.mViewInfoStore.b(childViewHolderInt, a3);
                            f.b a8 = this.mViewInfoStore.a(childViewHolderInt, 8);
                            if (a7 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a4);
                            } else {
                                animateChange(a4, childViewHolderInt, a7, a8, a5, a6);
                            }
                        }
                    }
                    this.mViewInfoStore.b(childViewHolderInt, a3);
                }
            }
            ab abVar = this.mViewInfoStore;
            ab.b bVar = this.mViewInfoProcessCallback;
            for (int size = abVar.f4165a.size() - 1; size >= 0; size--) {
                v b2 = abVar.f4165a.b(size);
                ab.a d2 = abVar.f4165a.d(size);
                if ((d2.f4168a & 3) == 3) {
                    bVar.a(b2);
                } else if ((d2.f4168a & 1) != 0) {
                    if (d2.f4169b == null) {
                        bVar.a(b2);
                    } else {
                        bVar.a(b2, d2.f4169b, d2.f4170c);
                    }
                } else if ((d2.f4168a & 14) == 14) {
                    bVar.b(b2, d2.f4169b, d2.f4170c);
                } else if ((d2.f4168a & 12) == 12) {
                    bVar.c(b2, d2.f4169b, d2.f4170c);
                } else if ((d2.f4168a & 4) != 0) {
                    bVar.a(b2, d2.f4169b, (f.b) null);
                } else if ((d2.f4168a & 8) != 0) {
                    bVar.b(b2, d2.f4169b, d2.f4170c);
                }
                ab.a.a(d2);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        s sVar2 = this.mState;
        sVar2.f4091b = sVar2.f4094e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        s sVar3 = this.mState;
        sVar3.j = false;
        sVar3.k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f4074b != null) {
            this.mRecycler.f4074b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            LayoutManager layoutManager = this.mLayout;
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.b();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j2, v vVar, v vVar2) {
        int a2 = this.mChildHelper.a();
        int i2 = 0;
        while (i2 < a2) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt == vVar || getChangedHolderKey(childViewHolderInt) != j2) {
                i2++;
            } else {
                a aVar = this.mAdapter;
                if (aVar == null || !aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + vVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + vVar + exceptionLabel());
            }
        }
        StringBuilder sb = new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb.append(vVar2);
        sb.append(" cannot be found but it is necessary for ");
        sb.append(vVar);
        sb.append(exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(v vVar, f.b bVar) {
        vVar.setFlags(0, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        if (this.mState.f4097h && vVar.isUpdated() && !vVar.isRemoved() && !vVar.shouldIgnore()) {
            this.mViewInfoStore.a(getChangedHolderKey(vVar), vVar);
        }
        this.mViewInfoStore.a(vVar, bVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int a2 = this.mChildHelper.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        v childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(v vVar) {
        return this.mAdapter.hasStableIds() ? vVar.getItemId() : (long) vVar.mPosition;
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(v vVar, f.b bVar, f.b bVar2) {
        vVar.setIsRecyclable(false);
        if (this.mItemAnimator.b(vVar, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(v vVar, f.b bVar, f.b bVar2) {
        addAnimatingView(vVar);
        vVar.setIsRecyclable(false);
        if (this.mItemAnimator.a(vVar, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(v vVar, v vVar2, f.b bVar, f.b bVar2, boolean z, boolean z2) {
        vVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                addAnimatingView(vVar2);
            }
            vVar.mShadowedHolder = vVar2;
            addAnimatingView(vVar);
            this.mRecycler.b(vVar);
            vVar2.setIsRecyclable(false);
            vVar2.mShadowingHolder = vVar;
        }
        if (this.mItemAnimator.a(vVar, vVar2, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.d.m.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.d.m.a();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((LayoutParams) this.mChildHelper.c(i2).getLayoutParams()).f4056e = true;
        }
        n nVar = this.mRecycler;
        int size = nVar.f4075c.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams = (LayoutParams) nVar.f4075c.get(i3).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f4056e = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.b()) {
            z2 = true;
        }
        if (z2) {
            androidx.core.h.u.g(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public boolean isAnimating() {
        f fVar = this.mItemAnimator;
        return fVar != null && fVar.b();
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        n nVar = this.mRecycler;
        int size = nVar.f4075c.size();
        for (int i3 = 0; i3 < size; i3++) {
            nVar.f4075c.get(i3).clearOldPosition();
        }
        int size2 = nVar.f4073a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            nVar.f4073a.get(i4).clearOldPosition();
        }
        if (nVar.f4074b != null) {
            int size3 = nVar.f4074b.size();
            for (int i5 = 0; i5 < size3; i5++) {
                nVar.f4074b.get(i5).clearOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int b2 = this.mChildHelper.b();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i10 = 0; i10 < b2; i10++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i10));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i6 && childViewHolderInt.mPosition <= i5) {
                if (childViewHolderInt.mPosition == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i4, false);
                }
                this.mState.f4095f = true;
            }
        }
        n nVar = this.mRecycler;
        if (i2 < i3) {
            i9 = i2;
            i8 = i3;
            i7 = -1;
        } else {
            i8 = i2;
            i9 = i3;
            i7 = 1;
        }
        int size = nVar.f4075c.size();
        for (int i11 = 0; i11 < size; i11++) {
            v vVar = nVar.f4075c.get(i11);
            if (vVar != null && vVar.mPosition >= i9 && vVar.mPosition <= i8) {
                if (vVar.mPosition == i2) {
                    vVar.offsetPosition(i3 - i2, false);
                } else {
                    vVar.offsetPosition(i7, false);
                }
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int b2 = this.mChildHelper.b();
        for (int i4 = 0; i4 < b2; i4++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f4095f = true;
            }
        }
        n nVar = this.mRecycler;
        int size = nVar.f4075c.size();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = nVar.f4075c.get(i5);
            if (vVar != null && vVar.mPosition >= i2) {
                vVar.offsetPosition(i3, true);
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int b2 = this.mChildHelper.b();
        for (int i5 = 0; i5 < b2; i5++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z);
                    this.mState.f4095f = true;
                } else if (childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                    this.mState.f4095f = true;
                }
            }
        }
        n nVar = this.mRecycler;
        for (int size = nVar.f4075c.size() - 1; size >= 0; size--) {
            v vVar = nVar.f4075c.get(size);
            if (vVar != null) {
                if (vVar.mPosition >= i4) {
                    vVar.offsetPosition(-i3, z);
                } else if (vVar.mPosition >= i2) {
                    vVar.addFlags(8);
                    nVar.d(size);
                }
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.mChildHelper.b();
        int i5 = i3 + i2;
        for (int i6 = 0; i6 < b2; i6++) {
            View c2 = this.mChildHelper.c(i6);
            v childViewHolderInt = getChildViewHolderInt(c2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2 && childViewHolderInt.mPosition < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) c2.getLayoutParams()).f4056e = true;
            }
        }
        n nVar = this.mRecycler;
        for (int size = nVar.f4075c.size() - 1; size >= 0; size--) {
            v vVar = nVar.f4075c.get(size);
            if (vVar != null && (i4 = vVar.mPosition) >= i2 && i4 < i5) {
                vVar.addFlags(2);
                nVar.d(size);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(v vVar) {
        f fVar = this.mItemAnimator;
        return fVar == null || fVar.a(vVar, vVar.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        n nVar = this.mRecycler;
        int size = nVar.f4075c.size();
        for (int i3 = 0; i3 < size; i3++) {
            v vVar = nVar.f4075c.get(i3);
            if (vVar != null) {
                vVar.addFlags(6);
                vVar.addChangePayload((Object) null);
            }
        }
        if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
            nVar.c();
        }
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public v getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public v findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    static v getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f4054c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        v childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        v childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        v childViewHolderInt;
        a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public v findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public v findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public v findViewHolderForAdapterPosition(int i2) {
        v vVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int b2 = this.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.d(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                vVar = childViewHolderInt;
            }
        }
        return vVar;
    }

    /* access modifiers changed from: package-private */
    public v findViewHolderForPosition(int i2, boolean z) {
        int b2 = this.mChildHelper.b();
        v vVar = null;
        for (int i3 = 0; i3 < b2; i3++) {
            v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i2) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.mChildHelper.d(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                vVar = childViewHolderInt;
            }
        }
        return vVar;
    }

    public v findViewHolderForItemId(long j2) {
        a aVar = this.mAdapter;
        v vVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int b2 = this.mChildHelper.b();
            for (int i2 = 0; i2 < b2; i2++) {
                v childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.d(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    vVar = childViewHolderInt;
                }
            }
        }
        return vVar;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int a2 = this.mChildHelper.a() - 1; a2 >= 0; a2--) {
            View b2 = this.mChildHelper.b(a2);
            float translationX = b2.getTranslationX();
            float translationY = b2.getTranslationY();
            if (f2 >= ((float) b2.getLeft()) + translationX && f2 <= ((float) b2.getRight()) + translationX && f3 >= ((float) b2.getTop()) + translationY && f3 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void offsetChildrenVertical(int i2) {
        int a2 = this.mChildHelper.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.mChildHelper.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int a2 = this.mChildHelper.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.mChildHelper.b(i3).offsetLeftAndRight(i2);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f4055d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f4056e) {
            return layoutParams.f4055d;
        }
        if (this.mState.f4096g && (layoutParams.f4054c.isUpdated() || layoutParams.f4054c.isInvalid())) {
            return layoutParams.f4055d;
        }
        Rect rect = layoutParams.f4055d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.f4056e = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        l lVar = this.mScrollListener;
        if (lVar != null) {
            lVar.onScrolled(this, i2, i3);
        }
        List<l> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        l lVar = this.mScrollListener;
        if (lVar != null) {
            lVar.onScrollStateChanged(this, i2);
        }
        List<l> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.d();
    }

    class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f4099a;

        /* renamed from: b  reason: collision with root package name */
        int f4100b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f4101c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f4102d = RecyclerView.sQuinticInterpolator;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4104f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4105g = false;

        u() {
            this.f4101c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public final void run() {
            int i2;
            int i3;
            if (RecyclerView.this.mLayout == null) {
                b();
                return;
            }
            this.f4105g = false;
            this.f4104f = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f4101c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f4099a;
                int i5 = currY - this.f4100b;
                this.f4099a = currX;
                this.f4100b = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i4, i5, recyclerView.mReusableIntPair, (int[]) null, 1)) {
                    i4 -= RecyclerView.this.mReusableIntPair[0];
                    i5 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i4, i5, recyclerView2.mReusableIntPair);
                    i3 = RecyclerView.this.mReusableIntPair[0];
                    i2 = RecyclerView.this.mReusableIntPair[1];
                    i4 -= i3;
                    i5 -= i2;
                    r rVar = RecyclerView.this.mLayout.mSmoothScroller;
                    if (rVar != null && !rVar.isPendingInitialRun() && rVar.isRunning()) {
                        int a2 = RecyclerView.this.mState.a();
                        if (a2 == 0) {
                            rVar.stop();
                        } else {
                            if (rVar.getTargetPosition() >= a2) {
                                rVar.setTargetPosition(a2 - 1);
                            }
                            rVar.onAnimation(i3, i2);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i3, i2, i4, i5, (int[]) null, 1, recyclerView3.mReusableIntPair);
                int i6 = i4 - RecyclerView.this.mReusableIntPair[0];
                int i7 = i5 - RecyclerView.this.mReusableIntPair[1];
                if (!(i3 == 0 && i2 == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i3, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                r rVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((rVar2 != null && rVar2.isPendingInitialRun()) || !z) {
                    a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.a(RecyclerView.this, i3, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i8, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.a();
                    }
                }
            }
            r rVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (rVar3 != null && rVar3.isPendingInitialRun()) {
                rVar3.onAnimation(0, 0);
            }
            this.f4104f = false;
            if (this.f4105g) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.f4104f) {
                this.f4105g = true;
            } else {
                c();
            }
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            androidx.core.h.u.a((View) RecyclerView.this, (Runnable) this);
        }

        public final void a(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f4102d != interpolator) {
                this.f4102d = interpolator;
                this.f4101c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f4100b = 0;
            this.f4099a = 0;
            RecyclerView.this.setScrollState(2);
            this.f4101c.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4101c.computeScrollOffset();
            }
            a();
        }

        private static float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int a(int i2, int i3) {
            int i4;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i5;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i4 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i4 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i4, 2000);
        }

        public final void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f4101c.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        int a2 = this.mChildHelper.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View b2 = this.mChildHelper.b(i2);
            v childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    class p extends c {
        p() {
        }

        public final void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView.this.mState.f4095f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.d()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
            if (r0.f4146a.size() == 1) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeChanged(int r5, int r6, java.lang.Object r7) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                r1 = 1
                if (r6 <= 0) goto L_0x0025
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r0.f4146a
                r3 = 4
                androidx.recyclerview.widget.a$b r5 = r0.a(r3, r5, r6, r7)
                r2.add(r5)
                int r5 = r0.f4152g
                r5 = r5 | r3
                r0.f4152g = r5
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r5 = r0.f4146a
                int r5 = r5.size()
                if (r5 != r1) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r1 = 0
            L_0x0026:
                if (r1 == 0) goto L_0x002b
                r4.a()
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.onItemRangeChanged(int, int, java.lang.Object):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
            if (r0.f4146a.size() == 1) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeInserted(int r5, int r6) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                r2 = 1
                if (r6 <= 0) goto L_0x0024
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r3 = r0.f4146a
                androidx.recyclerview.widget.a$b r5 = r0.a(r2, r5, r6, r1)
                r3.add(r5)
                int r5 = r0.f4152g
                r5 = r5 | r2
                r0.f4152g = r5
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r5 = r0.f4146a
                int r5 = r5.size()
                if (r5 != r2) goto L_0x0024
                goto L_0x0025
            L_0x0024:
                r2 = 0
            L_0x0025:
                if (r2 == 0) goto L_0x002a
                r4.a()
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.onItemRangeInserted(int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
            if (r0.f4146a.size() == 1) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeRemoved(int r6, int r7) {
            /*
                r5 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                r2 = 1
                if (r7 <= 0) goto L_0x0025
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r3 = r0.f4146a
                r4 = 2
                androidx.recyclerview.widget.a$b r6 = r0.a(r4, r6, r7, r1)
                r3.add(r6)
                int r6 = r0.f4152g
                r6 = r6 | r4
                r0.f4152g = r6
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r6 = r0.f4146a
                int r6 = r6.size()
                if (r6 != r2) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r2 = 0
            L_0x0026:
                if (r2 == 0) goto L_0x002b
                r5.a()
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.onItemRangeRemoved(int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
            if (r0.f4146a.size() == 1) goto L_0x0031;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeMoved(int r5, int r6, int r7) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                r1 = 0
                r0.assertNotInLayoutOrScroll(r1)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                r2 = 1
                if (r5 == r6) goto L_0x0030
                if (r7 != r2) goto L_0x0028
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r7 = r0.f4146a
                r3 = 8
                androidx.recyclerview.widget.a$b r5 = r0.a(r3, r5, r6, r1)
                r7.add(r5)
                int r5 = r0.f4152g
                r5 = r5 | r3
                r0.f4152g = r5
                java.util.ArrayList<androidx.recyclerview.widget.a$b> r5 = r0.f4146a
                int r5 = r5.size()
                if (r5 != r2) goto L_0x0030
                goto L_0x0031
            L_0x0028:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r6 = "Moving more than 1 item is not supported yet"
                r5.<init>(r6)
                throw r5
            L_0x0030:
                r2 = 0
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r4.a()
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.onItemRangeMoved(int, int, int):void");
        }

        private void a() {
            if (!RecyclerView.POST_UPDATES_ON_ANIMATION || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mAdapterUpdateDuringMeasure = true;
                recyclerView.requestLayout();
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            androidx.core.h.u.a((View) recyclerView2, recyclerView2.mUpdateChildViewsRunnable);
        }
    }

    public static class e {
        protected static EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class m {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f4067a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f4068b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<v> f4069a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f4070b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f4071c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f4072d = 0;

            a() {
            }
        }

        public final void a() {
            for (int i2 = 0; i2 < this.f4067a.size(); i2++) {
                this.f4067a.valueAt(i2).f4069a.clear();
            }
        }

        public final v a(int i2) {
            a aVar = this.f4067a.get(i2);
            if (aVar == null || aVar.f4069a.isEmpty()) {
                return null;
            }
            ArrayList<v> arrayList = aVar.f4069a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final void a(v vVar) {
            int itemViewType = vVar.getItemViewType();
            ArrayList<v> arrayList = b(itemViewType).f4069a;
            if (this.f4067a.get(itemViewType).f4070b > arrayList.size()) {
                vVar.resetInternal();
                arrayList.add(vVar);
            }
        }

        static long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, long j) {
            a b2 = b(i2);
            b2.f4071c = a(b2.f4071c, j);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int i2, long j, long j2) {
            long j3 = b(i2).f4071c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f4068b++;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f4068b--;
        }

        /* access modifiers changed from: package-private */
        public final a b(int i2) {
            a aVar = this.f4067a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f4067a.put(i2, aVar2);
            return aVar2;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(v vVar) {
        if (vVar.mNestedRecyclerView != null) {
            View view = (View) vVar.mNestedRecyclerView.get();
            while (view != null) {
                if (view != vVar.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            vVar.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class n {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<v> f4073a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<v> f4074b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<v> f4075c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final List<v> f4076d = Collections.unmodifiableList(this.f4073a);

        /* renamed from: e  reason: collision with root package name */
        int f4077e = 2;

        /* renamed from: f  reason: collision with root package name */
        int f4078f = 2;

        /* renamed from: g  reason: collision with root package name */
        m f4079g;

        /* renamed from: h  reason: collision with root package name */
        t f4080h;

        public n() {
        }

        public final void a() {
            this.f4073a.clear();
            c();
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f4078f = this.f4077e + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f4075c.size() - 1; size >= 0 && this.f4075c.size() > this.f4078f; size--) {
                d(size);
            }
        }

        private boolean c(v vVar) {
            if (vVar.isRemoved()) {
                return RecyclerView.this.mState.f4096g;
            }
            if (vVar.mPosition < 0 || vVar.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.f4096g && RecyclerView.this.mAdapter.getItemViewType(vVar.mPosition) != vVar.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.mAdapter.hasStableIds() || vVar.getItemId() == RecyclerView.this.mAdapter.getItemId(vVar.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        private boolean a(v vVar, int i2, int i3, long j) {
            vVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = vVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS) {
                long j2 = this.f4079g.b(itemViewType).f4072d;
                if (!(j2 == 0 || j2 + nanoTime < j)) {
                    return false;
                }
            }
            RecyclerView.this.mAdapter.bindViewHolder(vVar, i2);
            long nanoTime2 = RecyclerView.this.getNanoTime();
            m.a b2 = this.f4079g.b(vVar.getItemViewType());
            b2.f4072d = m.a(b2.f4072d, nanoTime2 - nanoTime);
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = vVar.itemView;
                if (androidx.core.h.u.h(view) == 0) {
                    androidx.core.h.u.c(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate != null) {
                    androidx.core.h.a a2 = RecyclerView.this.mAccessibilityDelegate.a();
                    if (a2 instanceof w.a) {
                        w.a aVar = (w.a) a2;
                        androidx.core.h.a e2 = androidx.core.h.u.e(view);
                        if (!(e2 == null || e2 == aVar)) {
                            aVar.f4363b.put(view, e2);
                        }
                    }
                    androidx.core.h.u.a(view, a2);
                }
            }
            if (RecyclerView.this.mState.f4096g) {
                vVar.mPreLayoutPosition = i3;
            }
            return true;
        }

        public final int a(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.mState.a()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.mState.a() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.f4096g) {
                return i2;
            } else {
                return RecyclerView.this.mAdapterHelper.b(i2);
            }
        }

        public final View b(int i2) {
            return c(i2);
        }

        /* access modifiers changed from: package-private */
        public final View c(int i2) {
            return a(i2, (long) RecyclerView.FOREVER_NS).itemView;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0191  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01ae  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01b1  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x01ef  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.recyclerview.widget.RecyclerView.v a(int r18, long r19) {
            /*
                r17 = this;
                r6 = r17
                r3 = r18
                if (r3 < 0) goto L_0x0212
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.mState
                int r0 = r0.a()
                if (r3 >= r0) goto L_0x0212
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.mState
                boolean r0 = r0.f4096g
                r1 = 0
                r7 = 1
                r8 = 0
                if (r0 == 0) goto L_0x0023
                androidx.recyclerview.widget.RecyclerView$v r0 = r17.e((int) r18)
                if (r0 == 0) goto L_0x0024
                r2 = 1
                goto L_0x0025
            L_0x0023:
                r0 = r1
            L_0x0024:
                r2 = 0
            L_0x0025:
                if (r0 != 0) goto L_0x0057
                androidx.recyclerview.widget.RecyclerView$v r0 = r17.f(r18)
                if (r0 == 0) goto L_0x0057
                boolean r4 = r6.c((androidx.recyclerview.widget.RecyclerView.v) r0)
                if (r4 != 0) goto L_0x0056
                r4 = 4
                r0.addFlags(r4)
                boolean r4 = r0.isScrap()
                if (r4 == 0) goto L_0x0048
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r5 = r0.itemView
                r4.removeDetachedView(r5, r8)
                r0.unScrap()
                goto L_0x0051
            L_0x0048:
                boolean r4 = r0.wasReturnedFromScrap()
                if (r4 == 0) goto L_0x0051
                r0.clearReturnedFromScrapFlag()
            L_0x0051:
                r6.a((androidx.recyclerview.widget.RecyclerView.v) r0)
                r0 = r1
                goto L_0x0057
            L_0x0056:
                r2 = 1
            L_0x0057:
                if (r0 != 0) goto L_0x0172
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r4 = r4.mAdapterHelper
                int r4 = r4.b((int) r3)
                if (r4 < 0) goto L_0x013d
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r5 = r5.mAdapter
                int r5 = r5.getItemCount()
                if (r4 >= r5) goto L_0x013d
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r5 = r5.mAdapter
                int r5 = r5.getItemViewType(r4)
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.mAdapter
                boolean r9 = r9.hasStableIds()
                if (r9 == 0) goto L_0x0090
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.mAdapter
                long r9 = r0.getItemId(r4)
                androidx.recyclerview.widget.RecyclerView$v r0 = r6.a((long) r9, (int) r5)
                if (r0 == 0) goto L_0x0090
                r0.mPosition = r4
                r2 = 1
            L_0x0090:
                if (r0 != 0) goto L_0x00df
                androidx.recyclerview.widget.RecyclerView$t r4 = r6.f4080h
                if (r4 == 0) goto L_0x00df
                android.view.View r4 = r4.a()
                if (r4 == 0) goto L_0x00df
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$v r0 = r0.getChildViewHolder(r4)
                if (r0 == 0) goto L_0x00c5
                boolean r4 = r0.shouldIgnore()
                if (r4 != 0) goto L_0x00ab
                goto L_0x00df
            L_0x00ab:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.<init>(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00c5:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.<init>(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00df:
                if (r0 != 0) goto L_0x00f5
                androidx.recyclerview.widget.RecyclerView$m r0 = r17.d()
                androidx.recyclerview.widget.RecyclerView$v r0 = r0.a((int) r5)
                if (r0 == 0) goto L_0x00f5
                r0.resetInternal()
                boolean r4 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r4 == 0) goto L_0x00f5
                r6.d((androidx.recyclerview.widget.RecyclerView.v) r0)
            L_0x00f5:
                if (r0 != 0) goto L_0x0172
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r15 = r0.getNanoTime()
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r19 > r9 ? 1 : (r19 == r9 ? 0 : -1))
                if (r0 == 0) goto L_0x0113
                androidx.recyclerview.widget.RecyclerView$m r9 = r6.f4079g
                r10 = r5
                r11 = r15
                r13 = r19
                boolean r0 = r9.a(r10, r11, r13)
                if (r0 != 0) goto L_0x0113
                return r1
            L_0x0113:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.mAdapter
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$v r0 = r0.createViewHolder(r1, r5)
                boolean r1 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r1 == 0) goto L_0x0130
                android.view.View r1 = r0.itemView
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r1)
                if (r1 == 0) goto L_0x0130
                java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
                r4.<init>(r1)
                r0.mNestedRecyclerView = r4
            L_0x0130:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                long r9 = r1.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$m r1 = r6.f4079g
                long r9 = r9 - r15
                r1.a((int) r5, (long) r9)
                goto L_0x0172
            L_0x013d:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.<init>(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.mState
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0172:
                r10 = r0
                r9 = r2
                if (r9 == 0) goto L_0x01a0
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.mState
                boolean r0 = r0.f4096g
                if (r0 != 0) goto L_0x01a0
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01a0
                r10.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.mState
                boolean r0 = r0.j
                if (r0 == 0) goto L_0x01a0
                androidx.recyclerview.widget.RecyclerView.f.e(r10)
                r10.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$f$b r0 = androidx.recyclerview.widget.RecyclerView.f.d(r10)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r10, r0)
            L_0x01a0:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.mState
                boolean r0 = r0.f4096g
                if (r0 == 0) goto L_0x01b1
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01b1
                r10.mPreLayoutPosition = r3
                goto L_0x01c4
            L_0x01b1:
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01c6
                boolean r0 = r10.needsUpdate()
                if (r0 != 0) goto L_0x01c6
                boolean r0 = r10.isInvalid()
                if (r0 == 0) goto L_0x01c4
                goto L_0x01c6
            L_0x01c4:
                r0 = 0
                goto L_0x01d9
            L_0x01c6:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                int r2 = r0.b((int) r3)
                r0 = r17
                r1 = r10
                r3 = r18
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x01d9:
                android.view.View r1 = r10.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x01ef
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x0207
            L_0x01ef:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0205
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x0207
            L_0x0205:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0207:
                r1.f4054c = r10
                if (r9 == 0) goto L_0x020e
                if (r0 == 0) goto L_0x020e
                goto L_0x020f
            L_0x020e:
                r7 = 0
            L_0x020f:
                r1.f4057f = r7
                return r10
            L_0x0212:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Invalid item position "
                r1.<init>(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.mState
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.a(int, long):androidx.recyclerview.widget.RecyclerView$v");
        }

        private void d(v vVar) {
            if (vVar.itemView instanceof ViewGroup) {
                a((ViewGroup) vVar.itemView, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void a(View view) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            a(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.c(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            for (int size = this.f4075c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.f4075c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void d(int i2) {
            a(this.f4075c.get(i2), true);
            this.f4075c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(v vVar) {
            boolean z;
            boolean z2 = false;
            if (vVar.isScrap() || vVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(vVar.isScrap());
                sb.append(" isAttached:");
                if (vVar.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (vVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.exceptionLabel());
            } else if (!vVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = vVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(vVar)) || vVar.isRecyclable()) {
                    if (this.f4078f <= 0 || vVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f4075c.size();
                        if (size >= this.f4078f && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.a(vVar.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.a(this.f4075c.get(i2).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f4075c.add(size, vVar);
                        z = true;
                    }
                    if (!z) {
                        a(vVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.d(vVar);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    vVar.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(v vVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(vVar);
            View view = vVar.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                androidx.core.h.a a2 = RecyclerView.this.mAccessibilityDelegate.a();
                androidx.core.h.u.a(view, a2 instanceof w.a ? ((w.a) a2).a(view) : null);
            }
            if (z) {
                e(vVar);
            }
            vVar.mOwnerRecyclerView = null;
            d().a(vVar);
        }

        /* access modifiers changed from: package-private */
        public final void b(View view) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            a(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        public final void c(View view) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f4074b == null) {
                    this.f4074b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f4074b.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f4073a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(v vVar) {
            if (vVar.mInChangeScrap) {
                this.f4074b.remove(vVar);
            } else {
                this.f4073a.remove(vVar);
            }
            vVar.mScrapContainer = null;
            vVar.mInChangeScrap = false;
            vVar.clearReturnedFromScrapFlag();
        }

        private v e(int i2) {
            int size;
            int a2;
            ArrayList<v> arrayList = this.f4074b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    v vVar = this.f4074b.get(i4);
                    if (vVar.wasReturnedFromScrap() || vVar.getLayoutPosition() != i2) {
                        i4++;
                    } else {
                        vVar.addFlags(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (a2 = RecyclerView.this.mAdapterHelper.a(i2, 0)) > 0 && a2 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(a2);
                    while (i3 < size) {
                        v vVar2 = this.f4074b.get(i3);
                        if (vVar2.wasReturnedFromScrap() || vVar2.getItemId() != itemId) {
                            i3++;
                        } else {
                            vVar2.addFlags(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        private v f(int i2) {
            View view;
            int size = this.f4073a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                v vVar = this.f4073a.get(i4);
                if (vVar.wasReturnedFromScrap() || vVar.getLayoutPosition() != i2 || vVar.isInvalid() || (!RecyclerView.this.mState.f4096g && vVar.isRemoved())) {
                    i4++;
                } else {
                    vVar.addFlags(32);
                    return vVar;
                }
            }
            f fVar = RecyclerView.this.mChildHelper;
            int size2 = fVar.f4204c.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    view = null;
                    break;
                }
                view = fVar.f4204c.get(i5);
                v b2 = fVar.f4202a.b(view);
                if (b2.getLayoutPosition() == i2 && !b2.isInvalid() && !b2.isRemoved()) {
                    break;
                }
                i5++;
            }
            if (view != null) {
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                f fVar2 = RecyclerView.this.mChildHelper;
                int a2 = fVar2.f4202a.a(view);
                if (a2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
                } else if (fVar2.f4203b.c(a2)) {
                    fVar2.f4203b.b(a2);
                    fVar2.b(view);
                    int c2 = RecyclerView.this.mChildHelper.c(view);
                    if (c2 != -1) {
                        RecyclerView.this.mChildHelper.d(c2);
                        c(view);
                        childViewHolderInt.addFlags(8224);
                        return childViewHolderInt;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                }
            } else {
                int size3 = this.f4075c.size();
                while (i3 < size3) {
                    v vVar2 = this.f4075c.get(i3);
                    if (vVar2.isInvalid() || vVar2.getLayoutPosition() != i2 || vVar2.isAttachedToTransitionOverlay()) {
                        i3++;
                    } else {
                        this.f4075c.remove(i3);
                        return vVar2;
                    }
                }
                return null;
            }
        }

        private v a(long j, int i2) {
            for (int size = this.f4073a.size() - 1; size >= 0; size--) {
                v vVar = this.f4073a.get(size);
                if (vVar.getItemId() == j && !vVar.wasReturnedFromScrap()) {
                    if (i2 == vVar.getItemViewType()) {
                        vVar.addFlags(32);
                        if (vVar.isRemoved() && !RecyclerView.this.mState.f4096g) {
                            vVar.setFlags(2, 14);
                        }
                        return vVar;
                    }
                    this.f4073a.remove(size);
                    RecyclerView.this.removeDetachedView(vVar.itemView, false);
                    b(vVar.itemView);
                }
            }
            int size2 = this.f4075c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.f4075c.get(size2);
                if (vVar2.getItemId() == j && !vVar2.isAttachedToTransitionOverlay()) {
                    if (i2 == vVar2.getItemViewType()) {
                        this.f4075c.remove(size2);
                        return vVar2;
                    }
                    d(size2);
                    return null;
                }
            }
        }

        private void e(v vVar) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.onViewRecycled(vVar);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(vVar);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.d(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final m d() {
            if (this.f4079g == null) {
                this.f4079g = new m();
            }
            return this.f4079g;
        }
    }

    public static abstract class a<VH extends v> {
        private boolean mHasStableIds = false;
        private final b mObservable = new b();

        public abstract int getItemCount();

        public long getItemId(int i2) {
            return -1;
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.d.m.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i2;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.d.m.a();
            }
        }

        public final void bindViewHolder(VH vh, int i2) {
            vh.mPosition = i2;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i2);
            }
            vh.setFlags(1, 519);
            androidx.core.d.m.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f4056e = true;
            }
            androidx.core.d.m.a();
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.a(i2, 1);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.a(i2, 1, obj);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.a(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.a(i2, i3, obj);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.b(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.b(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.c(i2, 1);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        v childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        a aVar = this.mAdapter;
        if (!(aVar == null || childViewHolderInt == null)) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<i> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        v childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        a aVar = this.mAdapter;
        if (!(aVar == null || childViewHolderInt == null)) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<i> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        f mChildHelper;
        private int mHeight;
        private int mHeightMode;
        aa mHorizontalBoundCheck = new aa(this.mHorizontalBoundCheckCallback);
        private final aa.b mHorizontalBoundCheckCallback = new aa.b() {
            public final View a(int i2) {
                return LayoutManager.this.getChildAt(i2);
            }

            public final int a() {
                return LayoutManager.this.getPaddingLeft();
            }

            public final int b() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public final int a(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int b(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        };
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        r mSmoothScroller;
        aa mVerticalBoundCheck = new aa(this.mVerticalBoundCheckCallback);
        private final aa.b mVerticalBoundCheckCallback = new aa.b() {
            public final View a(int i2) {
                return LayoutManager.this.getChildAt(i2);
            }

            public final int a() {
                return LayoutManager.this.getPaddingTop();
            }

            public final int b() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public final int a(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int b(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        };
        private int mWidth;
        private int mWidthMode;

        public static class Properties {

            /* renamed from: a  reason: collision with root package name */
            public int f4050a;

            /* renamed from: b  reason: collision with root package name */
            public int f4051b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f4052c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4053d;
        }

        public interface a {
            void a(int i2, int i3);
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i2, int i3, s sVar, a aVar) {
        }

        public void collectInitialPrefetchPositions(int i2, a aVar) {
        }

        public int computeHorizontalScrollExtent(s sVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(s sVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(s sVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(s sVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(s sVar) {
            return 0;
        }

        public int computeVerticalScrollRange(s sVar) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(n nVar, s sVar) {
            return 0;
        }

        public boolean isLayoutHierarchical(n nVar, s sVar) {
            return false;
        }

        public void onAdapterChanged(a aVar, a aVar2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i2, n nVar, s sVar) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i2) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onLayoutChildren(n nVar, s sVar) {
        }

        public void onLayoutCompleted(s sVar) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i2) {
        }

        public boolean performAccessibilityActionForItem(n nVar, s sVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i2, n nVar, s sVar) {
            return 0;
        }

        public void scrollToPosition(int i2) {
        }

        public int scrollVerticallyBy(int i2, n nVar, s sVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, s sVar, int i2) {
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i2, int i3) {
            this.mWidth = View.MeasureSpec.getSize(i2);
            this.mWidthMode = View.MeasureSpec.getMode(i2);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i3);
            this.mHeightMode = View.MeasureSpec.getMode(i3);
            if (this.mHeightMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i2, int i3) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i4) {
                    i4 = rect.left;
                }
                if (rect.right > i6) {
                    i6 = rect.right;
                }
                if (rect.top < i5) {
                    i5 = rect.top;
                }
                if (rect.bottom > i7) {
                    i7 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i4, i5, i6, i7);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i2, i3);
        }

        public void setMeasuredDimension(Rect rect, int i2, int i3) {
            setMeasuredDimension(chooseSize(i2, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i3, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.b();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, n nVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, nVar);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                androidx.core.h.u.a((View) recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, n nVar) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void startSmoothScroll(r rVar) {
            r rVar2 = this.mSmoothScroller;
            if (!(rVar2 == null || rVar == rVar2 || !rVar2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = rVar;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            r rVar = this.mSmoothScroller;
            return rVar != null && rVar.isRunning();
        }

        public int getLayoutDirection() {
            return androidx.core.h.u.j(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.c(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i2) {
            addViewInt(view, i2, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i2) {
            addViewInt(view, i2, false);
        }

        private void addViewInt(View view, int i2, boolean z) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int c2 = this.mChildHelper.c(view);
                if (i2 == -1) {
                    i2 = this.mChildHelper.a();
                }
                if (c2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (c2 != i2) {
                    this.mRecyclerView.mLayout.moveView(c2, i2);
                }
            } else {
                this.mChildHelper.a(view, i2, false);
                layoutParams.f4056e = true;
                r rVar = this.mSmoothScroller;
                if (rVar != null && rVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f4057f) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f4057f = false;
            }
        }

        public void removeView(View view) {
            f fVar = this.mChildHelper;
            int a2 = fVar.f4202a.a(view);
            if (a2 >= 0) {
                if (fVar.f4203b.d(a2)) {
                    fVar.b(view);
                }
                fVar.f4202a.a(a2);
            }
        }

        public void removeViewAt(int i2) {
            if (getChildAt(i2) != null) {
                this.mChildHelper.a(i2);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.a(childCount);
            }
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4054c.getLayoutPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.d(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.f4096g || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int c2 = this.mChildHelper.c(view);
            if (c2 >= 0) {
                detachViewInternal(c2, view);
            }
        }

        public void detachViewAt(int i2) {
            detachViewInternal(i2, getChildAt(i2));
        }

        private void detachViewInternal(int i2, View view) {
            this.mChildHelper.d(i2);
        }

        public void attachView(View view, int i2, LayoutParams layoutParams) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
            }
            this.mChildHelper.a(view, i2, layoutParams, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i2) {
            attachView(view, i2, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                detachViewAt(i2);
                attachView(childAt, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.mRecyclerView.toString());
        }

        public void detachAndScrapView(View view, n nVar) {
            scrapOrRecycleView(nVar, this.mChildHelper.c(view), view);
        }

        public void detachAndScrapViewAt(int i2, n nVar) {
            scrapOrRecycleView(nVar, i2, getChildAt(i2));
        }

        public void removeAndRecycleView(View view, n nVar) {
            removeView(view);
            nVar.a(view);
        }

        public void removeAndRecycleViewAt(int i2, n nVar) {
            View childAt = getChildAt(i2);
            removeViewAt(i2);
            nVar.a(childAt);
        }

        public int getChildCount() {
            f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.a();
            }
            return 0;
        }

        public View getChildAt(int i2) {
            f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.b(i2);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h.u.m(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h.u.n(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.d(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i2);
            }
        }

        public void offsetChildrenVertical(int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i2);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.d(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(n nVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(nVar, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(n nVar, int i2, View view) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i2);
                    nVar.c(view);
                    this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
                    return;
                }
                removeViewAt(i2);
                nVar.a(childViewHolderInt);
            }
        }

        public void measureChild(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i4, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i5, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i3, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i3, layoutParams.height);
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public void measureChildWithMargins(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r1 = 0
                goto L_0x001e
            L_0x000f:
                if (r3 < 0) goto L_0x0015
            L_0x0011:
                r1 = r3
            L_0x0012:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x001e
            L_0x0015:
                r4 = -1
                if (r3 != r4) goto L_0x0019
                goto L_0x0012
            L_0x0019:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L_0x001e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002e
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002e
                if (r5 == r3) goto L_0x0021
                goto L_0x002e
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r6 = 1073741824(0x40000000, float:2.0)
                goto L_0x002f
            L_0x001f:
                if (r7 != r1) goto L_0x0024
            L_0x0021:
                r7 = r4
                r6 = r5
                goto L_0x002f
            L_0x0024:
                if (r7 != r0) goto L_0x002e
                if (r5 == r2) goto L_0x002a
                if (r5 != r3) goto L_0x002c
            L_0x002a:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
            L_0x002c:
                r7 = r4
                goto L_0x002f
            L_0x002e:
                r7 = 0
            L_0x002f:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4055d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4055d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4055d;
            view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f4055d;
            view.layout(i2 + rect.left + layoutParams.leftMargin, i3 + rect.top + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f4055d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4055d.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4055d.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4055d.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4055d.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i2 = left - paddingLeft;
            int min = Math.min(0, i2);
            int i3 = top - paddingTop;
            int min2 = Math.min(0, i3);
            int i4 = width2 - width;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i2 = childRectangleOnScreenScrollAmount[0];
            int i3 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.smoothScrollBy(i2, i3);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.a(view) && this.mVerticalBoundCheck.a(view);
            if (z) {
                return z3;
            }
            return !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i2 >= width || rect.right - i2 <= paddingLeft || rect.top - i3 >= height || rect.bottom - i3 <= paddingTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, s sVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
            onItemsUpdated(recyclerView, i2, i3);
        }

        public void onMeasure(n nVar, s sVar, int i2, int i3) {
            this.mRecyclerView.defaultOnMeasure(i2, i3);
        }

        public void setMeasuredDimension(int i2, int i3) {
            this.mRecyclerView.setMeasuredDimension(i2, i3);
        }

        public int getMinimumWidth() {
            return androidx.core.h.u.q(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return androidx.core.h.u.r(this.mRecyclerView);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            r rVar = this.mSmoothScroller;
            if (rVar != null) {
                rVar.stop();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(r rVar) {
            if (this.mSmoothScroller == rVar) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(n nVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, nVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(androidx.core.h.a.c cVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, cVar);
        }

        public void onInitializeAccessibilityNodeInfo(n nVar, s sVar, androidx.core.h.a.c cVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                cVar.a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                cVar.j(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.j(true);
            }
            cVar.a((Object) c.b.a(getRowCountForAccessibility(nVar, sVar), getColumnCountForAccessibility(nVar, sVar), isLayoutHierarchical(nVar, sVar), getSelectionModeForAccessibility(nVar, sVar)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(n nVar, s sVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, androidx.core.h.a.c cVar) {
            v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.d(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, cVar);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(n nVar, s sVar, View view, androidx.core.h.a.c cVar) {
            cVar.b((Object) c.C0046c.a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(n nVar, s sVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(n nVar, s sVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i2, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i2, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.n r8, androidx.recyclerview.widget.RecyclerView.s r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.mRecyclerView
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.getHeight()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.mRecyclerView
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.getHeight()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.mRecyclerView
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.mRecyclerView
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.smoothScrollBy(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i2, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i2, bundle);
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i2, int i3) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, i3);
            properties.f4050a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            properties.f4051b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            properties.f4052c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            properties.f4053d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(n nVar) {
            int size = nVar.f4073a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = nVar.f4073a.get(i2).itemView;
                v childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.c(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    nVar.b(view);
                }
            }
            nVar.f4073a.clear();
            if (nVar.f4074b != null) {
                nVar.f4074b.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }
    }

    public static abstract class h {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, s sVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, s sVar) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).f4054c.getLayoutPosition(), recyclerView);
        }
    }

    public static abstract class v {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        n mScrapContainer = null;
        v mShadowedHolder = null;
        v mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public v(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z) {
            addFlags(8);
            offsetPosition(i3, z);
            this.mPosition = i2;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i2, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f4056e = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.b(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(n nVar, boolean z) {
            this.mScrapContainer = nVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i2;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.h.u.h(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            int i2 = this.mIsRecyclableCount;
            this.mIsRecyclableCount = z ? i2 - 1 : i2 + 1;
            int i3 = this.mIsRecyclableCount;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && i3 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.h.u.f(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.h.u.f(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setChildImportantForAccessibilityInternal(v vVar, int i2) {
        if (isComputingLayout()) {
            vVar.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(vVar);
            return false;
        }
        androidx.core.h.u.c(vVar.itemView, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            v vVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (vVar.itemView.getParent() == this && !vVar.shouldIgnore() && (i2 = vVar.mPendingAccessibilityState) != -1) {
                androidx.core.h.u.c(vVar.itemView, i2);
                vVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionFor(v vVar) {
        if (vVar.hasAnyOfTheFlags(524) || !vVar.isBound()) {
            return -1;
        }
        a aVar = this.mAdapterHelper;
        int i2 = vVar.mPosition;
        int size = aVar.f4146a.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.f4146a.get(i3);
            int i4 = bVar.f4154a;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 8) {
                        if (bVar.f4155b == i2) {
                            i2 = bVar.f4157d;
                        } else {
                            if (bVar.f4155b < i2) {
                                i2--;
                            }
                            if (bVar.f4157d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.f4155b > i2) {
                    continue;
                } else if (bVar.f4155b + bVar.f4157d > i2) {
                    return -1;
                } else {
                    i2 -= bVar.f4157d;
                }
            } else if (bVar.f4155b <= i2) {
                i2 += bVar.f4157d;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f3109a;
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().a(i2, 0);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().b(0);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().b(i2);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a(0);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().b(i2, i3, i4, i5, iArr, i6, (int[]) null);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: c  reason: collision with root package name */
        public v f4054c;

        /* renamed from: d  reason: collision with root package name */
        final Rect f4055d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        boolean f4056e = true;

        /* renamed from: f  reason: collision with root package name */
        boolean f4057f = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final int a() {
            return this.f4054c.getAdapterPosition();
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i2, int i3) {
        }

        public void onItemRangeInserted(int i2, int i3) {
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
        }

        public void onItemRangeRemoved(int i2, int i3) {
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            onItemRangeChanged(i2, i3);
        }
    }

    public static abstract class r {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final a mRecyclingAction = new a();
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public interface b {
            PointF computeScrollVectorForPosition(int i2);
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i2, int i3, s sVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, s sVar, a aVar);

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.b();
            if (this.mStarted) {
                StringBuilder sb = new StringBuilder("An instance of ");
                sb.append(getClass().getSimpleName());
                sb.append(" was started more than once. Each instance of");
                sb.append(getClass().getSimpleName());
                sb.append(" is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.mTargetPosition != -1) {
                this.mRecyclerView.mState.f4090a = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.a();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void setTargetPosition(int i2) {
            this.mTargetPosition = i2;
        }

        public PointF computeScrollVectorForPosition(int i2) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i2);
            }
            new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
            return null;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f4090a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i2, int i3) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.mPendingInitialRun || this.mTargetView != null || this.mLayoutManager == null || (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f))) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.a(recyclerView);
                    stop();
                } else {
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i2, i3, recyclerView.mState, this.mRecyclingAction);
                if (this.mRecyclingAction.f4083a >= 0) {
                    z = true;
                }
                this.mRecyclingAction.a(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i2) {
            return this.mRecyclerView.mLayout.findViewByPosition(i2);
        }

        @Deprecated
        public void instantScrollToPosition(int i2) {
            this.mRecyclerView.scrollToPosition(i2);
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            int f4083a;

            /* renamed from: b  reason: collision with root package name */
            private int f4084b;

            /* renamed from: c  reason: collision with root package name */
            private int f4085c;

            /* renamed from: d  reason: collision with root package name */
            private int f4086d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f4087e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f4088f;

            /* renamed from: g  reason: collision with root package name */
            private int f4089g;

            public a() {
                this((byte) 0);
            }

            private a(byte b2) {
                this.f4083a = -1;
                this.f4088f = false;
                this.f4089g = 0;
                this.f4084b = 0;
                this.f4085c = 0;
                this.f4086d = Integer.MIN_VALUE;
                this.f4087e = null;
            }

            /* access modifiers changed from: package-private */
            public final void a(RecyclerView recyclerView) {
                int i2 = this.f4083a;
                if (i2 >= 0) {
                    this.f4083a = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i2);
                    this.f4088f = false;
                } else if (this.f4088f) {
                    a();
                    recyclerView.mViewFlinger.a(this.f4084b, this.f4085c, this.f4086d, this.f4087e);
                    this.f4089g++;
                    this.f4088f = false;
                } else {
                    this.f4089g = 0;
                }
            }

            private void a() {
                if (this.f4087e != null && this.f4086d <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f4086d <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f4084b = i2;
                this.f4085c = i3;
                this.f4086d = i4;
                this.f4087e = interpolator;
                this.f4088f = true;
            }
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public final boolean a() {
            return !this.mObservers.isEmpty();
        }

        public final void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void a(int i2, int i3) {
            a(i2, i3, (Object) null);
        }

        public final void a(int i2, int i3, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
            }
        }

        public final void b(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeInserted(i2, i3);
            }
        }

        public final void c(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeRemoved(i2, i3);
            }
        }

        public final void d(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
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
        Parcelable f4058a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4058a = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f4058a, 0);
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        int f4090a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f4091b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f4092c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f4093d = 1;

        /* renamed from: e  reason: collision with root package name */
        int f4094e = 0;

        /* renamed from: f  reason: collision with root package name */
        boolean f4095f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4096g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f4097h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f4098i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            if ((this.f4093d & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f4093d));
            }
        }

        public final int a() {
            return this.f4096g ? this.f4091b - this.f4092c : this.f4094e;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f4090a + ", mData=" + this.q + ", mItemCount=" + this.f4094e + ", mIsMeasuring=" + this.f4098i + ", mPreviousLayoutItemCount=" + this.f4091b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4092c + ", mStructureChanged=" + this.f4095f + ", mInPreLayout=" + this.f4096g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    class g implements f.a {
        g() {
        }

        public final void a(v vVar) {
            vVar.setIsRecyclable(true);
            if (vVar.mShadowedHolder != null && vVar.mShadowingHolder == null) {
                vVar.mShadowedHolder = null;
            }
            vVar.mShadowingHolder = null;
            if (!vVar.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(vVar.itemView) && vVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(vVar.itemView, false);
            }
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Object> f4059a = new ArrayList<>();

        /* renamed from: h  reason: collision with root package name */
        a f4060h = null;

        /* renamed from: i  reason: collision with root package name */
        long f4061i = 120;
        long j = 120;
        long k = 250;
        long l = 250;

        interface a {
            void a(v vVar);
        }

        public abstract void a();

        public abstract boolean a(v vVar, b bVar, b bVar2);

        public abstract boolean a(v vVar, v vVar2, b bVar, b bVar2);

        public abstract boolean b();

        public abstract boolean b(v vVar, b bVar, b bVar2);

        public abstract void c(v vVar);

        public abstract boolean c(v vVar, b bVar, b bVar2);

        public abstract void d();

        public boolean g(v vVar) {
            return true;
        }

        static int e(v vVar) {
            int i2 = vVar.mFlags & 14;
            if (vVar.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int oldPosition = vVar.getOldPosition();
            int adapterPosition = vVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i2 : i2 | EmiUtil.EMI_PLAN_REQUEST_CODE;
        }

        public final void f(v vVar) {
            a aVar = this.f4060h;
            if (aVar != null) {
                aVar.a(vVar);
            }
        }

        public boolean a(v vVar, List<Object> list) {
            return g(vVar);
        }

        public final void e() {
            int size = this.f4059a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4059a.get(i2);
            }
            this.f4059a.clear();
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f4062a;

            /* renamed from: b  reason: collision with root package name */
            public int f4063b;

            /* renamed from: c  reason: collision with root package name */
            public int f4064c;

            /* renamed from: d  reason: collision with root package name */
            public int f4065d;

            public final b a(v vVar) {
                View view = vVar.itemView;
                this.f4062a = view.getLeft();
                this.f4063b = view.getTop();
                this.f4064c = view.getRight();
                this.f4065d = view.getBottom();
                return this;
            }
        }

        public static b d(v vVar) {
            return new b().a(vVar);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.mChildDrawingOrderCallback;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.onGetChildDrawingOrder(i2, i3);
    }

    private androidx.core.h.l getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.h.l(this);
        }
        return this.mScrollingChildHelper;
    }
}
