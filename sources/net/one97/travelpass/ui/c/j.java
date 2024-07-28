package net.one97.travelpass.ui.c;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.ui.b.a;
import net.one97.travelpass.ui.b.b;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private String f30661a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f30662b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f30663c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f30664d = "";

    /* renamed from: e  reason: collision with root package name */
    private boolean f30665e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30666f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f30667g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f30668h = 0;

    /* renamed from: i  reason: collision with root package name */
    private b f30669i;
    private a j;
    private ArrayList<j> k;
    private int l = 0;
    private boolean m = false;
    private int n = -1;
    private int o = -1;
    private boolean p = true;
    private String q = "";
    private IJRPaytmDataModel r;

    public final ArrayList<j> a() {
        return this.k;
    }

    public final void a(ArrayList<j> arrayList) {
        this.k = arrayList;
    }

    public final IJRPaytmDataModel b() {
        return this.r;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.r = iJRPaytmDataModel;
    }

    public final b c() {
        return this.f30669i;
    }

    public final void a(b bVar) {
        this.f30669i = bVar;
    }

    public final boolean d() {
        return this.f30665e;
    }

    public final void e() {
        this.f30665e = true;
    }

    public final boolean f() {
        return this.f30666f;
    }

    public final void g() {
        this.f30666f = true;
    }

    public final boolean h() {
        return this.f30667g;
    }

    public final void a(boolean z) {
        this.f30667g = z;
    }

    public final a i() {
        return this.j;
    }

    public final void a(a aVar) {
        this.j = aVar;
    }

    public final int j() {
        return this.l;
    }

    public final void a(int i2) {
        this.l = i2;
    }

    public final double k() {
        IJRPaytmDataModel iJRPaytmDataModel = this.r;
        if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof PassData)) {
            return -1.0d;
        }
        return ((PassData) iJRPaytmDataModel).getPrice();
    }

    public final void a(String str) {
        this.f30661a = str;
    }

    public final String l() {
        return this.f30661a;
    }

    public final void b(String str) {
        this.f30662b = str;
    }

    public final String m() {
        return this.f30662b;
    }

    public final void c(String str) {
        this.f30664d = str;
    }

    public final void d(String str) {
        this.f30663c = str;
    }

    public final String n() {
        return this.f30663c;
    }

    public final String o() {
        return this.f30664d;
    }

    public final int p() {
        return this.f30668h;
    }

    public final void b(int i2) {
        this.f30668h = i2;
    }
}
