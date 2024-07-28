package com.paytmmall.clpartifact.view.decoration;

import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.z;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SnapToBlock extends z {
    public static final Companion Companion = new Companion((g) null);
    private static final float MILLISECONDS_PER_INCH = 100.0f;
    private static final String TAG = "SnapToBlock";
    /* access modifiers changed from: private */
    public static final Interpolator sInterpolator = new SnapToBlock$Companion$sInterpolator$1();
    /* access modifiers changed from: private */
    public int mBlocksize;
    /* access modifiers changed from: private */
    public int mItemDimension;
    /* access modifiers changed from: private */
    public LayoutDirectionHelper mLayoutDirectionHelper;
    private final int mMaxFlingBlocks;
    /* access modifiers changed from: private */
    public int mMaxPositionsToMove;
    /* access modifiers changed from: private */
    public u mOrientationHelper;
    private int mPriorFirstPosition = -1;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private Scroller mScroller;
    private SnapBlockCallback mSnapBlockCallback;

    public interface SnapBlockCallback {
        void onBlockSnap(int i2);

        void onBlockSnapped(int i2);
    }

    public SnapToBlock(int i2) {
        this.mMaxFlingBlocks = i2;
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            this.mRecyclerView = recyclerView;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.canScrollHorizontally()) {
                    this.mOrientationHelper = u.a((RecyclerView.LayoutManager) linearLayoutManager);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    if (recyclerView2 == null) {
                        k.a();
                    }
                    this.mLayoutDirectionHelper = new LayoutDirectionHelper(androidx.core.h.u.j(recyclerView2));
                } else if (linearLayoutManager.canScrollVertically()) {
                    this.mOrientationHelper = u.b((RecyclerView.LayoutManager) linearLayoutManager);
                    this.mLayoutDirectionHelper = new LayoutDirectionHelper(0);
                } else {
                    throw new IllegalStateException("RecyclerView must be scrollable");
                }
                RecyclerView recyclerView3 = this.mRecyclerView;
                if (recyclerView3 == null) {
                    k.a();
                }
                this.mScroller = new Scroller(recyclerView3.getContext(), sInterpolator);
                initItemDimensionIfNeeded(linearLayoutManager);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
        super.attachToRecyclerView(recyclerView);
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        k.c(layoutManager, "layoutManager");
        k.c(view, "targetView");
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            LayoutDirectionHelper layoutDirectionHelper = this.mLayoutDirectionHelper;
            if (layoutDirectionHelper == null) {
                k.a();
            }
            iArr[0] = layoutDirectionHelper.getScrollToAlignView(view);
        }
        if (layoutManager.canScrollVertically()) {
            LayoutDirectionHelper layoutDirectionHelper2 = this.mLayoutDirectionHelper;
            if (layoutDirectionHelper2 == null) {
                k.a();
            }
            iArr[1] = layoutDirectionHelper2.getScrollToAlignView(view);
        }
        SnapBlockCallback snapBlockCallback = this.mSnapBlockCallback;
        if (snapBlockCallback != null) {
            if (iArr[0] == 0 && iArr[1] == 0) {
                if (snapBlockCallback == null) {
                    k.a();
                }
                snapBlockCallback.onBlockSnapped(layoutManager.getPosition(view));
            } else {
                SnapBlockCallback snapBlockCallback2 = this.mSnapBlockCallback;
                if (snapBlockCallback2 == null) {
                    k.a();
                }
                snapBlockCallback2.onBlockSnap(layoutManager.getPosition(view));
            }
        }
        return iArr;
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        k.c(layoutManager, "layoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        initItemDimensionIfNeeded(layoutManager);
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            k.a();
        }
        scroller.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Integer num = null;
        if (i2 != 0) {
            LayoutDirectionHelper layoutDirectionHelper = this.mLayoutDirectionHelper;
            if (layoutDirectionHelper != null) {
                Scroller scroller2 = this.mScroller;
                if (scroller2 == null) {
                    k.a();
                }
                num = Integer.valueOf(layoutDirectionHelper.getPositionsToMove(linearLayoutManager, scroller2.getFinalX(), this.mItemDimension));
            }
            if (num == null) {
                k.a();
            }
            return num.intValue();
        } else if (i3 == 0) {
            return -1;
        } else {
            LayoutDirectionHelper layoutDirectionHelper2 = this.mLayoutDirectionHelper;
            if (layoutDirectionHelper2 != null) {
                Scroller scroller3 = this.mScroller;
                if (scroller3 == null) {
                    k.a();
                }
                num = Integer.valueOf(layoutDirectionHelper2.getPositionsToMove(linearLayoutManager, scroller3.getFinalY(), this.mItemDimension));
            }
            if (num == null) {
                k.a();
            }
            return num.intValue();
        }
    }

    public final View findSnapView(RecyclerView.LayoutManager layoutManager) {
        k.c(layoutManager, "layoutManager");
        int calcTargetPosition = calcTargetPosition((LinearLayoutManager) layoutManager);
        if (calcTargetPosition == -1) {
            return null;
        }
        return layoutManager.findViewByPosition(calcTargetPosition);
    }

    private final int calcTargetPosition(LinearLayoutManager linearLayoutManager) {
        int i2;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1) {
            return -1;
        }
        initItemDimensionIfNeeded(linearLayoutManager);
        if (findFirstVisibleItemPosition >= this.mPriorFirstPosition) {
            i2 = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (i2 == -1 || i2 % this.mBlocksize != 0) {
                i2 = roundDownToBlockSize(this.mBlocksize + findFirstVisibleItemPosition);
            }
        } else {
            int roundDownToBlockSize = roundDownToBlockSize(findFirstVisibleItemPosition);
            if (linearLayoutManager.findViewByPosition(roundDownToBlockSize) == null) {
                LayoutDirectionHelper layoutDirectionHelper = this.mLayoutDirectionHelper;
                if (layoutDirectionHelper == null) {
                    k.a();
                }
                int[] calculateDistanceToScroll = layoutDirectionHelper.calculateDistanceToScroll(linearLayoutManager, roundDownToBlockSize);
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null) {
                    k.a();
                }
                recyclerView.smoothScrollBy(calculateDistanceToScroll[0], calculateDistanceToScroll[1], sInterpolator);
            }
            i2 = roundDownToBlockSize;
        }
        this.mPriorFirstPosition = findFirstVisibleItemPosition;
        return i2;
    }

    private final void initItemDimensionIfNeeded(RecyclerView.LayoutManager layoutManager) {
        View childAt;
        if (this.mItemDimension == 0 && (childAt = layoutManager.getChildAt(0)) != null) {
            Integer num = null;
            if (layoutManager.canScrollHorizontally()) {
                if (childAt != null) {
                    num = Integer.valueOf(childAt.getWidth());
                }
                if (num == null) {
                    k.a();
                }
                this.mItemDimension = num.intValue();
                int spanCount = getSpanCount(layoutManager);
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null) {
                    k.a();
                }
                this.mBlocksize = spanCount * (recyclerView.getWidth() / this.mItemDimension);
            } else if (layoutManager.canScrollVertically()) {
                if (childAt != null) {
                    num = Integer.valueOf(childAt.getHeight());
                }
                if (num == null) {
                    k.a();
                }
                this.mItemDimension = num.intValue();
                int spanCount2 = getSpanCount(layoutManager);
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 == null) {
                    k.a();
                }
                this.mBlocksize = spanCount2 * (recyclerView2.getHeight() / this.mItemDimension);
            }
            this.mMaxPositionsToMove = this.mBlocksize * this.mMaxFlingBlocks;
        }
    }

    private final int getSpanCount(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public final int roundDownToBlockSize(int i2) {
        return i2 - (i2 % this.mBlocksize);
    }

    /* access modifiers changed from: private */
    public final int roundUpToBlockSize(int i2) {
        return roundDownToBlockSize((i2 + this.mBlocksize) - 1);
    }

    /* access modifiers changed from: protected */
    public final p createScroller(RecyclerView.LayoutManager layoutManager) {
        k.c(layoutManager, "layoutManager");
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            k.a();
        }
        return new SnapToBlock$createScroller$1(this, recyclerView.getContext());
    }

    public final void setSnapBlockCallback(SnapBlockCallback snapBlockCallback) {
        this.mSnapBlockCallback = snapBlockCallback;
    }

    final class LayoutDirectionHelper {
        private final boolean mIsRTL;

        public LayoutDirectionHelper(int i2) {
            this.mIsRTL = i2 != 1 ? false : true;
        }

        public final int getScrollToAlignView(View view) {
            if (this.mIsRTL) {
                u access$getMOrientationHelper$p = SnapToBlock.this.mOrientationHelper;
                if (access$getMOrientationHelper$p == null) {
                    k.a();
                }
                int b2 = access$getMOrientationHelper$p.b(view);
                RecyclerView access$getMRecyclerView$p = SnapToBlock.this.mRecyclerView;
                if (access$getMRecyclerView$p == null) {
                    k.a();
                }
                return b2 - access$getMRecyclerView$p.getWidth();
            }
            u access$getMOrientationHelper$p2 = SnapToBlock.this.mOrientationHelper;
            if (access$getMOrientationHelper$p2 == null) {
                k.a();
            }
            return access$getMOrientationHelper$p2.a(view);
        }

        public final int[] calculateDistanceToScroll(LinearLayoutManager linearLayoutManager, int i2) {
            k.c(linearLayoutManager, "layoutManager");
            int[] iArr = new int[2];
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (linearLayoutManager.canScrollHorizontally() && i2 <= findFirstVisibleItemPosition) {
                if (this.mIsRTL) {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition());
                    u access$getMOrientationHelper$p = SnapToBlock.this.mOrientationHelper;
                    if (access$getMOrientationHelper$p == null) {
                        k.a();
                    }
                    iArr[0] = access$getMOrientationHelper$p.b(findViewByPosition) + ((findFirstVisibleItemPosition - i2) * SnapToBlock.this.mItemDimension);
                } else {
                    View findViewByPosition2 = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    u access$getMOrientationHelper$p2 = SnapToBlock.this.mOrientationHelper;
                    if (access$getMOrientationHelper$p2 == null) {
                        k.a();
                    }
                    iArr[0] = access$getMOrientationHelper$p2.a(findViewByPosition2) - ((findFirstVisibleItemPosition - i2) * SnapToBlock.this.mItemDimension);
                }
            }
            if (linearLayoutManager.canScrollVertically() && i2 <= findFirstVisibleItemPosition) {
                View findViewByPosition3 = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition3 == null) {
                    k.a();
                }
                iArr[1] = findViewByPosition3.getTop() - ((findFirstVisibleItemPosition - i2) * SnapToBlock.this.mItemDimension);
            }
            return iArr;
        }

        public final int getPositionsToMove(LinearLayoutManager linearLayoutManager, int i2, int i3) {
            int access$roundDownToBlockSize;
            k.c(linearLayoutManager, "llm");
            int access$roundUpToBlockSize = SnapToBlock.this.roundUpToBlockSize(Math.abs(i2) / i3);
            if (access$roundUpToBlockSize < SnapToBlock.this.mBlocksize) {
                access$roundUpToBlockSize = SnapToBlock.this.mBlocksize;
            } else if (access$roundUpToBlockSize > SnapToBlock.this.mMaxPositionsToMove) {
                access$roundUpToBlockSize = SnapToBlock.this.mMaxPositionsToMove;
            }
            if (i2 < 0) {
                access$roundUpToBlockSize *= -1;
            }
            if (this.mIsRTL) {
                access$roundUpToBlockSize *= -1;
            }
            LayoutDirectionHelper access$getMLayoutDirectionHelper$p = SnapToBlock.this.mLayoutDirectionHelper;
            if (access$getMLayoutDirectionHelper$p == null) {
                k.a();
            }
            if (access$getMLayoutDirectionHelper$p.isDirectionToBottom(i2 < 0)) {
                access$roundDownToBlockSize = SnapToBlock.this.roundDownToBlockSize(linearLayoutManager.findFirstVisibleItemPosition());
            } else {
                access$roundDownToBlockSize = SnapToBlock.this.roundDownToBlockSize(linearLayoutManager.findLastVisibleItemPosition());
            }
            return access$roundDownToBlockSize + access$roundUpToBlockSize;
        }

        public final boolean isDirectionToBottom(boolean z) {
            if (this.mIsRTL) {
                return z;
            }
            return !z;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
