package io.reactivex.rxjava3.c;

import io.reactivex.rxjava3.e.k.j;

public final class b {
    public static RuntimeException a(Throwable th) {
        throw j.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
