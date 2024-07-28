package in.org.npci.commonlibrary;

public class f extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f46351a;

    /* renamed from: b  reason: collision with root package name */
    private String f46352b;

    public f() {
    }

    public f(g gVar) {
        super(gVar.a());
        this.f46351a = gVar.b();
        this.f46352b = gVar.a();
    }

    public String toString() {
        return "Error " + this.f46351a + " : " + this.f46352b;
    }
}
