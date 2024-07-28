package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class hk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12109a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hi f12110b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ hi f12111c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ hl f12112d;

    hk(hl hlVar, boolean z, hi hiVar, hi hiVar2) {
        this.f12112d = hlVar;
        this.f12109a = z;
        this.f12110b = hiVar;
        this.f12111c = hiVar2;
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.f12112d.H_().d((String) null, o.Y)) {
            z = this.f12109a && this.f12112d.f12113a != null;
            if (z) {
                hl hlVar = this.f12112d;
                hlVar.a(hlVar.f12113a, true);
            }
        } else {
            if (this.f12109a && this.f12112d.f12113a != null) {
                hl hlVar2 = this.f12112d;
                hlVar2.a(hlVar2.f12113a, true);
            }
            z = false;
        }
        hi hiVar = this.f12110b;
        if (hiVar == null || hiVar.f12107c != this.f12111c.f12107c || !jq.c(this.f12110b.f12106b, this.f12111c.f12106b) || !jq.c(this.f12110b.f12105a, this.f12111c.f12105a)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            hl.a(this.f12111c, bundle, true);
            hi hiVar2 = this.f12110b;
            if (hiVar2 != null) {
                if (hiVar2.f12105a != null) {
                    bundle.putString("_pn", this.f12110b.f12105a);
                }
                bundle.putString("_pc", this.f12110b.f12106b);
                bundle.putLong("_pi", this.f12110b.f12107c);
            }
            if (this.f12112d.H_().d((String) null, o.Y) && z) {
                long a2 = this.f12112d.s().f12228c.a();
                if (a2 > 0) {
                    this.f12112d.L_().a(bundle, a2);
                }
            }
            this.f12112d.b().b("auto", "_vs", bundle);
        }
        hl hlVar3 = this.f12112d;
        hlVar3.f12113a = this.f12111c;
        hlVar3.d().a(this.f12111c);
    }
}
