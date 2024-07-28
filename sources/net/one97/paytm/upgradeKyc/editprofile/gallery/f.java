package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.v;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.landingpage.R;

public final class f extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.g f65856a = v.a(this, y.b(j.class), new a(this), new b(this));

    /* renamed from: b  reason: collision with root package name */
    private boolean f65857b = true;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f65858c;

    private View a(int i2) {
        if (this.f65858c == null) {
            this.f65858c = new HashMap();
        }
        View view = (View) this.f65858c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65858c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.ProfileBottomSheetDialogTheme;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        this.f65857b = arguments != null ? arguments.getBoolean("isProfileEmpty") : true;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return layoutInflater.inflate(R.layout.edit_profile_pic_bottomsheet_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f65857b) {
            Group group = (Group) a(R.id.userPicUiGroup);
            if (group != null) {
                group.setVisibility(8);
            }
        } else {
            Group group2 = (Group) a(R.id.userPicUiGroup);
            if (group2 != null) {
                group2.setVisibility(0);
            }
        }
        ((AppCompatImageView) a(R.id.closeProfileSheetIv)).setOnClickListener(new c(this));
        ((TextView) a(R.id.chooseGalleryTv)).setOnClickListener(new d(this));
        ((TextView) a(R.id.clickPhotoTv)).setOnClickListener(new e(this));
        ((TextView) a(R.id.viewProfileTv)).setOnClickListener(new C1310f(this));
        ((TextView) a(R.id.removePhotoTv)).setOnClickListener(new g(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65859a;

        c(f fVar) {
            this.f65859a = fVar;
        }

        public final void onClick(View view) {
            this.f65859a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65860a;

        d(f fVar) {
            this.f65860a = fVar;
        }

        public final void onClick(View view) {
            this.f65860a.dismiss();
            f.a(this.f65860a).p.setValue(x.f47997a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65861a;

        e(f fVar) {
            this.f65861a = fVar;
        }

        public final void onClick(View view) {
            this.f65861a.dismiss();
            f.a(this.f65861a).v.setValue(x.f47997a);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.gallery.f$f  reason: collision with other inner class name */
    static final class C1310f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65862a;

        C1310f(f fVar) {
            this.f65862a = fVar;
        }

        public final void onClick(View view) {
            this.f65862a.dismiss();
            j a2 = f.a(this.f65862a);
            String al = com.paytm.utility.b.al(a2.f65883a);
            k.a((Object) al, "CJRAppCommonUtility.getProfileImage(application)");
            a2.o = al;
            a2.x.setValue(x.f47997a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f65863a;

        g(f fVar) {
            this.f65863a = fVar;
        }

        public final void onClick(View view) {
            this.f65863a.dismiss();
            f.a(this.f65863a).B.setValue(x.f47997a);
        }
    }

    public static final class a extends l implements kotlin.g.a.a<an> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final an invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            an viewModelStore = requireActivity.getViewModelStore();
            k.a((Object) viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class b extends l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final al.b invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            al.b defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            k.a((Object) defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final /* synthetic */ j a(f fVar) {
        return (j) fVar.f65856a.getValue();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65858c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
