package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.transition.Transition;
import androidx.transition.v;
import com.google.android.material.badge.a;
import com.google.android.material.internal.ParcelableSparseArray;

public final class BottomNavigationPresenter implements m {

    /* renamed from: a  reason: collision with root package name */
    BottomNavigationMenuView f35976a;

    /* renamed from: b  reason: collision with root package name */
    boolean f35977b = false;

    /* renamed from: c  reason: collision with root package name */
    int f35978c;

    /* renamed from: d  reason: collision with root package name */
    private g f35979d;

    public final void a(g gVar, boolean z) {
    }

    public final void a(m.a aVar) {
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(r rVar) {
        return false;
    }

    public final boolean b(i iVar) {
        return false;
    }

    public final boolean c(i iVar) {
        return false;
    }

    public final void a(Context context, g gVar) {
        this.f35979d = gVar;
        this.f35976a.f35974h = this.f35979d;
    }

    public final void a(boolean z) {
        if (!this.f35977b) {
            if (z) {
                this.f35976a.b();
                return;
            }
            BottomNavigationMenuView bottomNavigationMenuView = this.f35976a;
            if (bottomNavigationMenuView.f35974h != null && bottomNavigationMenuView.f35970d != null) {
                int size = bottomNavigationMenuView.f35974h.size();
                if (size != bottomNavigationMenuView.f35970d.length) {
                    bottomNavigationMenuView.b();
                    return;
                }
                int i2 = bottomNavigationMenuView.f35971e;
                for (int i3 = 0; i3 < size; i3++) {
                    MenuItem item = bottomNavigationMenuView.f35974h.getItem(i3);
                    if (item.isChecked()) {
                        bottomNavigationMenuView.f35971e = item.getItemId();
                        bottomNavigationMenuView.f35972f = i3;
                    }
                }
                if (i2 != bottomNavigationMenuView.f35971e) {
                    v.a((ViewGroup) bottomNavigationMenuView, (Transition) bottomNavigationMenuView.f35967a);
                }
                boolean a2 = BottomNavigationMenuView.a(bottomNavigationMenuView.f35969c, bottomNavigationMenuView.f35974h.i().size());
                for (int i4 = 0; i4 < size; i4++) {
                    bottomNavigationMenuView.f35973g.f35977b = true;
                    bottomNavigationMenuView.f35970d[i4].setLabelVisibilityMode(bottomNavigationMenuView.f35969c);
                    bottomNavigationMenuView.f35970d[i4].setShifting(a2);
                    bottomNavigationMenuView.f35970d[i4].a((i) bottomNavigationMenuView.f35974h.getItem(i4));
                    bottomNavigationMenuView.f35973g.f35977b = false;
                }
            }
        }
    }

    public final int b() {
        return this.f35978c;
    }

    public final Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f35980a = this.f35976a.getSelectedItemId();
        savedState.f35981b = a.a(this.f35976a.getBadgeDrawables());
        return savedState;
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.f35976a;
            SavedState savedState = (SavedState) parcelable;
            int i2 = savedState.f35980a;
            int size = bottomNavigationMenuView.f35974h.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                MenuItem item = bottomNavigationMenuView.f35974h.getItem(i3);
                if (i2 == item.getItemId()) {
                    bottomNavigationMenuView.f35971e = i2;
                    bottomNavigationMenuView.f35972f = i3;
                    item.setChecked(true);
                    break;
                }
                i3++;
            }
            this.f35976a.setBadgeDrawables(a.a(this.f35976a.getContext(), savedState.f35981b));
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f35980a;

        /* renamed from: b  reason: collision with root package name */
        ParcelableSparseArray f35981b;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f35980a = parcel.readInt();
            this.f35981b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f35980a);
            parcel.writeParcelable(this.f35981b, 0);
        }
    }
}
