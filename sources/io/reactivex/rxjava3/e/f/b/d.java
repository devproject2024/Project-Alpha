package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.c.c;

public final class d<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final g<? super T> f46784c;

    /* renamed from: d  reason: collision with root package name */
    final g<? super Throwable> f46785d;

    /* renamed from: e  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46786e;

    /* renamed from: f  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46787f;

    public d(h<T> hVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2) {
        super(hVar);
        this.f46784c = gVar;
        this.f46785d = gVar2;
        this.f46786e = aVar;
        this.f46787f = aVar2;
    }

    public final void b(org.a.b<? super T> bVar) {
        if (bVar instanceof c) {
            this.f46770b.a(new a((c) bVar, this.f46784c, this.f46785d, this.f46786e, this.f46787f));
            return;
        }
        this.f46770b.a(new b(bVar, this.f46784c, this.f46785d, this.f46786e, this.f46787f));
    }

    static final class b<T> extends io.reactivex.rxjava3.e.i.b<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final g<? super T> f46792a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super Throwable> f46793b;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46794c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46795d;

        b(org.a.b<? super T> bVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2) {
            super(bVar);
            this.f46792a = gVar;
            this.f46793b = gVar2;
            this.f46794c = aVar;
            this.f46795d = aVar2;
        }

        public final void onNext(T t) {
            if (!this.f47725h) {
                if (this.f47726i != 0) {
                    this.f47722e.onNext(null);
                    return;
                }
                try {
                    this.f46792a.accept(t);
                    this.f47722e.onNext(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47725h) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            boolean z = true;
            this.f47725h = true;
            try {
                this.f46793b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                this.f47722e.onError(new io.reactivex.rxjava3.c.a(th, th2));
                z = false;
            }
            if (z) {
                this.f47722e.onError(th);
            }
            try {
                this.f46795d.run();
            } catch (Throwable th3) {
                io.reactivex.rxjava3.c.b.b(th3);
                io.reactivex.rxjava3.h.a.a(th3);
            }
        }

        public final void onComplete() {
            if (!this.f47725h) {
                try {
                    this.f46794c.run();
                    this.f47725h = true;
                    this.f47722e.onComplete();
                    try {
                        this.f46795d.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        io.reactivex.rxjava3.h.a.a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        /* JADX INFO: finally extract failed */
        public final T poll() throws Throwable {
            try {
                T poll = this.f47724g.poll();
                if (poll != null) {
                    try {
                        this.f46792a.accept(poll);
                        this.f46795d.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        throw new io.reactivex.rxjava3.c.a(th, th);
                    }
                } else if (this.f47726i == 1) {
                    this.f46794c.run();
                    this.f46795d.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                throw new io.reactivex.rxjava3.c.a(th, th2);
            }
        }
    }

    static final class a<T> extends io.reactivex.rxjava3.e.i.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final g<? super T> f46788a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super Throwable> f46789b;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46790c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46791d;

        a(c<? super T> cVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2) {
            super(cVar);
            this.f46788a = gVar;
            this.f46789b = gVar2;
            this.f46790c = aVar;
            this.f46791d = aVar2;
        }

        public final void onNext(T t) {
            if (!this.f47720h) {
                if (this.f47721i != 0) {
                    this.f47717e.onNext(null);
                    return;
                }
                try {
                    this.f46788a.accept(t);
                    this.f47717e.onNext(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final boolean a(T t) {
            if (this.f47720h) {
                return false;
            }
            try {
                this.f46788a.accept(t);
                return this.f47717e.a(t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }

        public final void onError(Throwable th) {
            if (this.f47720h) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            boolean z = true;
            this.f47720h = true;
            try {
                this.f46789b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                this.f47717e.onError(new io.reactivex.rxjava3.c.a(th, th2));
                z = false;
            }
            if (z) {
                this.f47717e.onError(th);
            }
            try {
                this.f46791d.run();
            } catch (Throwable th3) {
                io.reactivex.rxjava3.c.b.b(th3);
                io.reactivex.rxjava3.h.a.a(th3);
            }
        }

        public final void onComplete() {
            if (!this.f47720h) {
                try {
                    this.f46790c.run();
                    this.f47720h = true;
                    this.f47717e.onComplete();
                    try {
                        this.f46791d.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        io.reactivex.rxjava3.h.a.a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        /* JADX INFO: finally extract failed */
        public final T poll() throws Throwable {
            try {
                T poll = this.f47719g.poll();
                if (poll != null) {
                    try {
                        this.f46788a.accept(poll);
                        this.f46791d.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        throw new io.reactivex.rxjava3.c.a(th, th);
                    }
                } else if (this.f47721i == 1) {
                    this.f46790c.run();
                    this.f46791d.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                throw new io.reactivex.rxjava3.c.a(th, th2);
            }
        }
    }
}
