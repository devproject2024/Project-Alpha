package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class TrackSelectionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f33569a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f33570b;

    /* renamed from: c  reason: collision with root package name */
    private final CheckedTextView f33571c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckedTextView f33572d;

    /* renamed from: e  reason: collision with root package name */
    private final a f33573e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<DefaultTrackSelector.SelectionOverride> f33574f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33575g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f33576h;

    /* renamed from: i  reason: collision with root package name */
    private d f33577i;
    private CheckedTextView[][] j;
    private d.a k;
    private int l;
    private TrackGroupArray m;
    private boolean n;
    private b o;

    public interface b {
    }

    public TrackSelectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        this.f33574f = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        this.f33569a = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        this.f33570b = LayoutInflater.from(context);
        this.f33573e = new a(this, (byte) 0);
        this.f33577i = new a(getResources());
        this.m = TrackGroupArray.f32783a;
        this.f33571c = (CheckedTextView) this.f33570b.inflate(17367055, this, false);
        this.f33571c.setBackgroundResource(this.f33569a);
        this.f33571c.setText(R.string.exo_track_selection_none);
        this.f33571c.setEnabled(false);
        this.f33571c.setFocusable(true);
        this.f33571c.setOnClickListener(this.f33573e);
        this.f33571c.setVisibility(8);
        addView(this.f33571c);
        addView(this.f33570b.inflate(R.layout.exo_list_divider, this, false));
        this.f33572d = (CheckedTextView) this.f33570b.inflate(17367055, this, false);
        this.f33572d.setBackgroundResource(this.f33569a);
        this.f33572d.setText(R.string.exo_track_selection_auto);
        this.f33572d.setEnabled(false);
        this.f33572d.setFocusable(true);
        this.f33572d.setOnClickListener(this.f33573e);
        addView(this.f33572d);
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.f33575g != z) {
            this.f33575g = z;
            a();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.f33576h != z) {
            this.f33576h = z;
            if (!z && this.f33574f.size() > 1) {
                for (int size = this.f33574f.size() - 1; size > 0; size--) {
                    this.f33574f.remove(size);
                }
            }
            a();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.f33571c.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(d dVar) {
        this.f33577i = (d) com.google.android.exoplayer2.g.a.a(dVar);
        a();
    }

    public boolean getIsDisabled() {
        return this.n;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f33574f.size());
        for (int i2 = 0; i2 < this.f33574f.size(); i2++) {
            arrayList.add(this.f33574f.valueAt(i2));
        }
        return arrayList;
    }

    private void a() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.k == null) {
            this.f33571c.setEnabled(false);
            this.f33572d.setEnabled(false);
            return;
        }
        this.f33571c.setEnabled(true);
        this.f33572d.setEnabled(true);
        this.m = this.k.f33495d[this.l];
        this.j = new CheckedTextView[this.m.f32784b][];
        boolean c2 = c();
        for (int i2 = 0; i2 < this.m.f32784b; i2++) {
            TrackGroup trackGroup = this.m.f32785c[i2];
            boolean a2 = a(i2);
            this.j[i2] = new CheckedTextView[trackGroup.f32780a];
            for (int i3 = 0; i3 < trackGroup.f32780a; i3++) {
                if (i3 == 0) {
                    addView(this.f33570b.inflate(R.layout.exo_list_divider, this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f33570b.inflate((a2 || c2) ? 17367056 : 17367055, this, false);
                checkedTextView.setBackgroundResource(this.f33569a);
                checkedTextView.setText(this.f33577i.a(trackGroup.f32781b[i3]));
                if (this.k.a(this.l, i2, i3) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setTag(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
                    checkedTextView.setOnClickListener(this.f33573e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.j[i2][i3] = checkedTextView;
                addView(checkedTextView);
            }
        }
        b();
    }

    private void b() {
        this.f33571c.setChecked(this.n);
        this.f33572d.setChecked(!this.n && this.f33574f.size() == 0);
        for (int i2 = 0; i2 < this.j.length; i2++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = this.f33574f.get(i2);
            int i3 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.j;
                if (i3 >= checkedTextViewArr[i2].length) {
                    break;
                }
                checkedTextViewArr[i2][i3].setChecked(selectionOverride != null && selectionOverride.a(i3));
                i3++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onClick(View view) {
        if (view == this.f33571c) {
            this.n = true;
            this.f33574f.clear();
        } else {
            if (view == this.f33572d) {
                this.n = false;
                this.f33574f.clear();
            } else {
                this.n = false;
                Pair pair = (Pair) view.getTag();
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                DefaultTrackSelector.SelectionOverride selectionOverride = this.f33574f.get(intValue);
                com.google.android.exoplayer2.g.a.a(this.k);
                if (selectionOverride == null) {
                    if (!this.f33576h && this.f33574f.size() > 0) {
                        this.f33574f.clear();
                    }
                    this.f33574f.put(intValue, new DefaultTrackSelector.SelectionOverride(intValue, intValue2));
                } else {
                    int i2 = selectionOverride.f33433c;
                    int[] iArr = selectionOverride.f33432b;
                    boolean isChecked = ((CheckedTextView) view).isChecked();
                    boolean a2 = a(intValue);
                    boolean z = a2 || c();
                    if (!isChecked || !z) {
                        if (!isChecked) {
                            if (a2) {
                                int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
                                copyOf[copyOf.length - 1] = intValue2;
                                this.f33574f.put(intValue, new DefaultTrackSelector.SelectionOverride(intValue, copyOf));
                            } else {
                                this.f33574f.put(intValue, new DefaultTrackSelector.SelectionOverride(intValue, intValue2));
                            }
                        }
                    } else if (i2 == 1) {
                        this.f33574f.remove(intValue);
                    } else {
                        int[] iArr2 = new int[(iArr.length - 1)];
                        int i3 = 0;
                        for (int i4 : iArr) {
                            if (i4 != intValue2) {
                                iArr2[i3] = i4;
                                i3++;
                            }
                        }
                        this.f33574f.put(intValue, new DefaultTrackSelector.SelectionOverride(intValue, iArr2));
                    }
                }
            }
        }
        b();
        if (this.o != null) {
            getIsDisabled();
            getOverrides();
        }
    }

    @RequiresNonNull({"mappedTrackInfo"})
    private boolean a(int i2) {
        if (!this.f33575g || this.m.f32785c[i2].f32780a <= 1 || this.k.a(this.l, i2) == 0) {
            return false;
        }
        return true;
    }

    private boolean c() {
        return this.f33576h && this.m.f32784b > 1;
    }

    class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(TrackSelectionView trackSelectionView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            TrackSelectionView.this.onClick(view);
        }
    }
}
