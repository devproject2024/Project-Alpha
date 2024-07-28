package com.google.android.gms.location.places.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.R;
import com.google.android.gms.location.places.a.a;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.maps.model.LatLngBounds;

@Deprecated
public class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private View f11407a;

    /* renamed from: b  reason: collision with root package name */
    private View f11408b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f11409c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f11410d;

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f11411e;

    /* renamed from: f  reason: collision with root package name */
    private AutocompleteFilter f11412f;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.f11407a = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.f11408b = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.f11409c = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        f fVar = new f(this);
        this.f11407a.setOnClickListener(fVar);
        this.f11409c.setOnClickListener(fVar);
        this.f11408b.setOnClickListener(new e(this));
        a();
        return inflate;
    }

    public void onDestroyView() {
        this.f11407a = null;
        this.f11408b = null;
        this.f11409c = null;
        super.onDestroyView();
    }

    public final void a(CharSequence charSequence) {
        this.f11409c.setText(charSequence);
        a();
    }

    private final void a() {
        this.f11408b.setVisibility(this.f11409c.getText().toString().isEmpty() ^ true ? 0 : 8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f11410d = false;
        if (i2 == 30421) {
            if (i3 == -1) {
                FragmentActivity activity = getActivity();
                s.a(intent, (Object) "intent must not be null");
                s.a(activity, (Object) "context must not be null");
                a((CharSequence) ((com.google.android.gms.location.places.b) c.a(intent, "selected_place", PlaceEntity.CREATOR)).a().toString());
            } else if (i3 == 2) {
                FragmentActivity activity2 = getActivity();
                s.a(intent, (Object) "intent must not be null");
                s.a(activity2, (Object) "context must not be null");
                c.a(intent, "status", Status.CREATOR);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    static /* synthetic */ void b(b bVar) {
        int i2;
        try {
            Intent a2 = new a.C0159a().a(bVar.f11411e).a(bVar.f11412f).a(bVar.f11409c.getText().toString()).a().a(bVar.getActivity());
            bVar.f11410d = true;
            bVar.startActivityForResult(a2, 30421);
            i2 = -1;
        } catch (f e2) {
            i2 = e2.getConnectionStatusCode();
        } catch (e e3) {
            i2 = e3.errorCode;
        }
        if (i2 != -1) {
            com.google.android.gms.common.c.a().a((Activity) bVar.getActivity(), i2, 30422, (DialogInterface.OnCancelListener) null);
        }
    }
}
