package com.google.android.gms.location.places.a;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import com.sendbird.android.constant.StringSet;

@Deprecated
public final class a extends c {

    /* renamed from: com.google.android.gms.location.places.a.a$a  reason: collision with other inner class name */
    public static class C0159a extends d {
        public C0159a() {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.f11413a.putExtra("gmscore_client_jar_version", c.f8646a);
            this.f11413a.putExtra("mode", 2);
            this.f11413a.putExtra("origin", 2);
        }

        public final C0159a a(LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.f11413a.putExtra("bounds", latLngBounds);
            } else {
                this.f11413a.removeExtra("bounds");
            }
            return this;
        }

        public final C0159a a(AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.f11413a.putExtra(StringSet.filter, autocompleteFilter);
            } else {
                this.f11413a.removeExtra(StringSet.filter);
            }
            return this;
        }

        public final C0159a a() {
            this.f11413a.putExtra("origin", 1);
            return this;
        }

        public final C0159a a(String str) {
            if (str != null) {
                this.f11413a.putExtra("initial_query", str);
            } else {
                this.f11413a.removeExtra("initial_query");
            }
            return this;
        }

        public final Intent a(Activity activity) throws f, e {
            return super.a(activity);
        }
    }
}
