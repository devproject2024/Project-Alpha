package com.travel.bus.orders.c;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.bus.R;
import com.travel.bus.pojo.photos.BoardingPhoto;
import com.travel.bus.pojo.photos.CJRBusPhoto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.i.f;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<BoardingPhoto> f22589a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22590b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f22591c;

    private View a(int i2) {
        if (this.f22591c == null) {
            this.f22591c = new HashMap();
        }
        View view = (View) this.f22591c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f22591c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public b(ArrayList<BoardingPhoto> arrayList, String str) {
        k.c(arrayList, "photos");
        this.f22589a = arrayList;
        this.f22590b = str;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_bp_photos_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.tvBoardingPoint);
        k.a((Object) textView, "tvBoardingPoint");
        textView.setText(this.f22590b);
        ((AppCompatImageView) a(R.id.ivClose)).setImageResource(R.drawable.bus_close_normal);
        ((AppCompatImageView) a(R.id.ivClose)).setOnClickListener(new a(this));
        com.travel.bus.busticket.fragment.f fVar = new com.travel.bus.busticket.fragment.f();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("extra_photos", a());
        fVar.setArguments(bundle2);
        j childFragmentManager = getChildFragmentManager();
        q a2 = childFragmentManager != null ? childFragmentManager.a() : null;
        k.a((Object) a2, "childFragmentManager?.beginTransaction()");
        if (a2 != null) {
            a2.b(R.id.flContainer, fVar);
        }
        if (a2 != null) {
            a2.b();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f22592a;

        a(b bVar) {
            this.f22592a = bVar;
        }

        public final void onClick(View view) {
            Dialog dialog = this.f22592a.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    private final ArrayList<CJRBusPhoto> a() {
        ArrayList<CJRBusPhoto> arrayList = new ArrayList<>();
        Iterator<BoardingPhoto> it2 = this.f22589a.iterator();
        while (it2.hasNext()) {
            BoardingPhoto next = it2.next();
            CJRBusPhoto cJRBusPhoto = new CJRBusPhoto();
            k.a((Object) next, "photo");
            cJRBusPhoto.setPhoto(next.getDefault());
            cJRBusPhoto.setThumbnail(next.getThumbnail());
            arrayList.add(cJRBusPhoto);
        }
        return arrayList;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f22591c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
