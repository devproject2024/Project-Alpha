package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.SelectedInstrumentSheetViewModel;

public class ActivityLoginBindingImpl extends ActivityLoginBinding {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        sIncludes = bVar;
        bVar.a(0, new String[]{"lyt_instrument_selected_sheet"}, new int[]{1}, new int[]{R.layout.lyt_instrument_selected_sheet});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_header, 2);
        sViewsWithIds.put(R.id.tv_amout, 3);
        sViewsWithIds.put(R.id.fragment_container, 4);
    }

    public ActivityLoginBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ActivityLoginBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[4], objArr[1], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.lytSelectedInstrument.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.lytSelectedInstrument.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBinding r0 = r6.lytSelectedInstrument
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.ActivityLoginBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.selectedInstrumentSheetViewModel != i2) {
            return false;
        }
        setSelectedInstrumentSheetViewModel((SelectedInstrumentSheetViewModel) obj);
        return true;
    }

    public void setSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel) {
        this.mSelectedInstrumentSheetViewModel = selectedInstrumentSheetViewModel;
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.lytSelectedInstrument.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeSelectedInstrumentSheetViewModel((SelectedInstrumentSheetViewModel) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeLytSelectedInstrument((LytInstrumentSelectedSheetBinding) obj, i3);
    }

    private boolean onChangeSelectedInstrumentSheetViewModel(SelectedInstrumentSheetViewModel selectedInstrumentSheetViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLytSelectedInstrument(LytInstrumentSelectedSheetBinding lytInstrumentSelectedSheetBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.lytSelectedInstrument);
    }
}
