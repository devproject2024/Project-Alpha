package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.a;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class l extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23306a;

    /* renamed from: b  reason: collision with root package name */
    private final List<p> f23307b;

    public l(Context context, List<p> list) {
        k.c(context, "context");
        k.c(list, "busStopList");
        this.f23306a = context;
        this.f23307b = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == a.f23177e) {
            View inflate = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_start_layout, viewGroup, false);
            if (inflate == null) {
                k.a();
            }
            return new f(inflate);
        } else if (i2 == a.f23178f) {
            View inflate2 = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_stop_layout, viewGroup, false);
            if (inflate2 == null) {
                k.a();
            }
            return new e(inflate2);
        } else if (i2 == a.f23174b) {
            View inflate3 = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_intermediate_points_layout, viewGroup, false);
            if (inflate3 == null) {
                k.a();
            }
            return new m(inflate3);
        } else if (i2 == a.f23175c) {
            View inflate4 = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_bp_layout, viewGroup, false);
            if (inflate4 == null) {
                k.a();
            }
            return new c(inflate4);
        } else if (i2 == a.f23176d) {
            View inflate5 = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_dp_layout, viewGroup, false);
            if (inflate5 == null) {
                k.a();
            }
            return new d(inflate5);
        } else {
            View inflate6 = LayoutInflater.from(this.f23306a).inflate(R.layout.stop_details_model_start_layout, viewGroup, false);
            if (inflate6 == null) {
                k.a();
            }
            return new f(inflate6);
        }
    }

    public final int getItemCount() {
        return this.f23307b.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        p pVar = this.f23307b.get(i2);
        int i3 = pVar.f23317a;
        if (i3 == a.f23177e) {
            if (pVar.f23318b instanceof r) {
                RoboTextView roboTextView = ((f) vVar).f23282a;
                StringBuilder sb = new StringBuilder();
                Object obj = pVar.f23318b;
                if (obj != null) {
                    sb.append(String.valueOf(((r) obj).f23321a));
                    sb.append(" Stops");
                    roboTextView.setText(sb.toString());
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.citybus.brts.citybus.CJRStartStopModel");
            }
        } else if (i3 == a.f23178f) {
            if (pVar.f23318b instanceof r) {
                RoboTextView roboTextView2 = ((e) vVar).f23281a;
                StringBuilder sb2 = new StringBuilder();
                Object obj2 = pVar.f23318b;
                if (obj2 != null) {
                    sb2.append(String.valueOf(((r) obj2).f23321a));
                    sb2.append(" Stops");
                    roboTextView2.setText(sb2.toString());
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.citybus.brts.citybus.CJRStartStopModel");
            }
        } else if (i3 == a.f23174b) {
            if (pVar.f23318b instanceof n) {
                RoboTextView roboTextView3 = ((m) vVar).f23308a;
                Object obj3 = pVar.f23318b;
                if (obj3 != null) {
                    roboTextView3.setText(((n) obj3).f23309a);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.citybus.brts.citybus.CJRIntermediateStopModel");
            }
        } else if (i3 == a.f23175c) {
            if (pVar.f23318b instanceof b) {
                RoboTextView roboTextView4 = ((c) vVar).f23279a;
                Object obj4 = pVar.f23318b;
                if (obj4 != null) {
                    roboTextView4.setText(((b) obj4).f23278a);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.travel.citybus.brts.citybus.CJRBPDPModel");
            }
        } else if (i3 == a.f23176d && (pVar.f23318b instanceof b)) {
            RoboTextView roboTextView5 = ((d) vVar).f23280a;
            Object obj5 = pVar.f23318b;
            if (obj5 != null) {
                roboTextView5.setText(((b) obj5).f23278a);
                return;
            }
            throw new u("null cannot be cast to non-null type com.travel.citybus.brts.citybus.CJRBPDPModel");
        }
    }

    public final int getItemViewType(int i2) {
        int i3 = this.f23307b.get(i2).f23317a;
        if (i3 == a.f23177e) {
            return a.f23177e;
        }
        if (i3 == a.f23178f) {
            return a.f23178f;
        }
        if (i3 == a.f23174b) {
            return a.f23174b;
        }
        if (i3 == a.f23175c) {
            return a.f23175c;
        }
        if (i3 == a.f23176d) {
            return a.f23176d;
        }
        return a.f23177e;
    }
}
