package com.travel.train.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.train.R;
import com.travel.train.i.af;
import kotlin.g.b.k;

public final class au {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27878a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static View a(ViewGroup viewGroup, af afVar) {
            k.c(viewGroup, "parent");
            k.c(afVar, "cardType");
            if (av.f27880b[afVar.ordinal()] != 1) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.train_smart_icon_lyt_item, viewGroup, false);
                k.a((Object) inflate, "LayoutInflater.from(pare…_lyt_item, parent, false)");
                return inflate;
            }
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.train_smart_icon_lyt_item, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…_lyt_item, parent, false)");
            return inflate2;
        }
    }
}
