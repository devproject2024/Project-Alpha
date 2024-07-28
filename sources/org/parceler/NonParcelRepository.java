package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.parceler.g;

final class NonParcelRepository implements h<g.b> {

    /* renamed from: a  reason: collision with root package name */
    private static final NonParcelRepository f35763a = new NonParcelRepository();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, g.b> f35764b = new HashMap();

    private NonParcelRepository() {
        this.f35764b.put(Collection.class, new h((byte) 0));
        this.f35764b.put(List.class, new p((byte) 0));
        this.f35764b.put(ArrayList.class, new p((byte) 0));
        this.f35764b.put(Set.class, new t((byte) 0));
        this.f35764b.put(HashSet.class, new t((byte) 0));
        this.f35764b.put(TreeSet.class, new y((byte) 0));
        this.f35764b.put(SparseArray.class, new u((byte) 0));
        this.f35764b.put(Map.class, new r((byte) 0));
        this.f35764b.put(HashMap.class, new r((byte) 0));
        this.f35764b.put(TreeMap.class, new x((byte) 0));
        this.f35764b.put(Integer.class, new l((byte) 0));
        this.f35764b.put(Long.class, new q((byte) 0));
        this.f35764b.put(Double.class, new i((byte) 0));
        this.f35764b.put(Float.class, new j((byte) 0));
        this.f35764b.put(Byte.class, new e((byte) 0));
        this.f35764b.put(String.class, new w((byte) 0));
        this.f35764b.put(Character.class, new g((byte) 0));
        this.f35764b.put(Boolean.class, new b((byte) 0));
        this.f35764b.put(byte[].class, new d((byte) 0));
        this.f35764b.put(char[].class, new f((byte) 0));
        this.f35764b.put(boolean[].class, new a((byte) 0));
        this.f35764b.put(IBinder.class, new k((byte) 0));
        this.f35764b.put(Bundle.class, new c((byte) 0));
        this.f35764b.put(SparseBooleanArray.class, new v((byte) 0));
        this.f35764b.put(LinkedList.class, new o((byte) 0));
        this.f35764b.put(LinkedHashMap.class, new m((byte) 0));
        this.f35764b.put(SortedMap.class, new x((byte) 0));
        this.f35764b.put(SortedSet.class, new y((byte) 0));
        this.f35764b.put(LinkedHashSet.class, new n((byte) 0));
    }

    public static NonParcelRepository a() {
        return f35763a;
    }

    public final Map<Class, g.b> b() {
        return this.f35764b;
    }

    static class p implements g.b<List> {
        private p() {
        }

        /* synthetic */ p(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new ListParcelable((List) obj);
        }
    }

    static class g implements g.b<Character> {
        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new CharacterParcelable((Character) obj);
        }
    }

    static class b implements g.b<Boolean> {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new BooleanParcelable(((Boolean) obj).booleanValue());
        }
    }

    static class d implements g.b<byte[]> {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new ByteArrayParcelable((byte[]) obj);
        }
    }

    static class f implements g.b<char[]> {
        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new CharArrayParcelable((char[]) obj);
        }
    }

    static class a implements g.b<boolean[]> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new BooleanArrayParcelable((boolean[]) obj);
        }
    }

    static class k implements g.b<IBinder> {
        private k() {
        }

        /* synthetic */ k(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new IBinderParcelable((IBinder) obj);
        }
    }

    static class c implements g.b<Bundle> {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ Parcelable a(Object obj) {
            return (Bundle) obj;
        }
    }

    static class v implements g.b<SparseBooleanArray> {
        private v() {
        }

        /* synthetic */ v(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new SparseBooleanArrayParcelable((SparseBooleanArray) obj);
        }
    }

    static class o implements g.b<LinkedList> {
        private o() {
        }

        /* synthetic */ o(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new LinkedListParcelable((LinkedList) obj);
        }
    }

    static class m implements g.b<LinkedHashMap> {
        private m() {
        }

        /* synthetic */ m(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new LinkedHashMapParcelable((LinkedHashMap) obj);
        }
    }

    static class n implements g.b<LinkedHashSet> {
        private n() {
        }

        /* synthetic */ n(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new LinkedHashSetParcelable((LinkedHashSet) obj);
        }
    }

    static class t implements g.b<Set> {
        private t() {
        }

        /* synthetic */ t(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new SetParcelable((Set) obj);
        }
    }

    static class y implements g.b<Set> {
        private y() {
        }

        /* synthetic */ y(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new TreeSetParcelable((Set) obj);
        }
    }

    static class r implements g.b<Map> {
        private r() {
        }

        /* synthetic */ r(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new MapParcelable((Map) obj);
        }
    }

    static class x implements g.b<Map> {
        private x() {
        }

        /* synthetic */ x(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new TreeMapParcelable((Map) obj);
        }
    }

    static class h implements g.b<Collection> {
        private h() {
        }

        /* synthetic */ h(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new CollectionParcelable((Collection) obj);
        }
    }

    static class u implements g.b<SparseArray> {
        private u() {
        }

        /* synthetic */ u(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new SparseArrayParcelable((SparseArray) obj);
        }
    }

    static class l implements g.b<Integer> {
        private l() {
        }

        /* synthetic */ l(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new IntegerParcelable((Integer) obj);
        }
    }

    static class q implements g.b<Long> {
        private q() {
        }

        /* synthetic */ q(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new LongParcelable((Long) obj);
        }
    }

    static class i implements g.b<Double> {
        private i() {
        }

        /* synthetic */ i(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new DoubleParcelable((Double) obj);
        }
    }

    static class j implements g.b<Float> {
        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new FloatParcelable((Float) obj);
        }
    }

    static class e implements g.b<Byte> {
        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new ByteParcelable((Byte) obj);
        }
    }

    static class w implements g.b<String> {
        private w() {
        }

        /* synthetic */ w(byte b2) {
            this();
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new StringParcelable((String) obj, (byte) 0);
        }
    }

    static class s implements g.b<Parcelable> {
        s() {
        }

        public final /* synthetic */ Parcelable a(Object obj) {
            return new ParcelableParcelable((Parcelable) obj, (byte) 0);
        }
    }

    public static final class ListParcelable extends ConverterParcelable<List> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.a f35781a = new org.parceler.a.a() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(ListParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ListParcelable(Parcel parcel) {
            super(parcel, (i) f35781a, (byte) 0);
        }

        public ListParcelable(List list) {
            super((Object) list, (i) f35781a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<ListParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ListParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ListParcelable(parcel);
            }
        }
    }

    public static final class LinkedListParcelable extends ConverterParcelable<LinkedList> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.i f35780a = new org.parceler.a.i() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedListParcelable(Parcel parcel) {
            super(parcel, (i) f35780a, (byte) 0);
        }

        public LinkedListParcelable(LinkedList linkedList) {
            super((Object) linkedList, (i) f35780a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<LinkedListParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LinkedListParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }
        }
    }

    public static final class MapParcelable extends ConverterParcelable<Map> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.e f35783a = new org.parceler.a.e() {
            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final void b(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object b(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public MapParcelable(Parcel parcel) {
            super(parcel, (i) f35783a, (byte) 0);
        }

        public MapParcelable(Map map) {
            super((Object) map, (i) f35783a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<MapParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new MapParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MapParcelable(parcel);
            }
        }
    }

    public static final class LinkedHashMapParcelable extends ConverterParcelable<LinkedHashMap> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.g f35778a = new org.parceler.a.g() {
            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final void b(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object b(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedHashMapParcelable(Parcel parcel) {
            super(parcel, (i) f35778a, (byte) 0);
        }

        public LinkedHashMapParcelable(LinkedHashMap linkedHashMap) {
            super((Object) linkedHashMap, (i) f35778a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<LinkedHashMapParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LinkedHashMapParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedHashMapParcelable(parcel);
            }
        }
    }

    public static final class TreeMapParcelable extends ConverterParcelable<Map> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.m f35789a = new org.parceler.a.m() {
            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final void b(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }

            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            public final Object b(Parcel parcel) {
                return g.a(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public TreeMapParcelable(Parcel parcel) {
            super(parcel, (i) f35789a, (byte) 0);
        }

        public TreeMapParcelable(Map map) {
            super((Object) map, (i) f35789a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<TreeMapParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new TreeMapParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new TreeMapParcelable(parcel);
            }
        }
    }

    public static final class SetParcelable extends ConverterParcelable<Set> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.f f35785a = new org.parceler.a.f() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(SetParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SetParcelable(Parcel parcel) {
            super(parcel, (i) f35785a, (byte) 0);
        }

        public SetParcelable(Set set) {
            super((Object) set, (i) f35785a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<SetParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SetParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SetParcelable(parcel);
            }
        }
    }

    public static final class TreeSetParcelable extends ConverterParcelable<Set> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.n f35790a = new org.parceler.a.n() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public TreeSetParcelable(Parcel parcel) {
            super(parcel, (i) f35790a, (byte) 0);
        }

        public TreeSetParcelable(Set set) {
            super((Object) set, (i) f35790a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<TreeSetParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new TreeSetParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }
        }
    }

    public static final class LinkedHashSetParcelable extends ConverterParcelable<LinkedHashSet> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.h f35779a = new org.parceler.a.h() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LinkedHashSetParcelable(Parcel parcel) {
            super(parcel, (i) f35779a, (byte) 0);
        }

        public LinkedHashSetParcelable(LinkedHashSet linkedHashSet) {
            super((Object) linkedHashSet, (i) f35779a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<LinkedHashSetParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LinkedHashSetParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }
        }
    }

    public static final class CollectionParcelable extends ConverterParcelable<Collection> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.d f35771a = new org.parceler.a.a() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CollectionParcelable(Parcel parcel) {
            super(parcel, (i) f35771a, (byte) 0);
        }

        public CollectionParcelable(Collection collection) {
            super((Object) collection, (i) f35771a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<CollectionParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new CollectionParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CollectionParcelable(parcel);
            }
        }
    }

    public static final class SparseArrayParcelable extends ConverterParcelable<SparseArray> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.l f35786a = new org.parceler.a.l() {
            public final Object a(Parcel parcel) {
                return g.a(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
            }

            public final void a(Object obj, Parcel parcel) {
                parcel.writeParcelable(g.a(obj), 0);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SparseArrayParcelable(Parcel parcel) {
            super(parcel, (i) f35786a, (byte) 0);
        }

        public SparseArrayParcelable(SparseArray sparseArray) {
            super((Object) sparseArray, (i) f35786a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<SparseArrayParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SparseArrayParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }
        }
    }

    public static final class SparseBooleanArrayParcelable extends ConverterParcelable<SparseBooleanArray> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<SparseBooleanArray> f35787a = new org.parceler.a.k<SparseBooleanArray>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeSparseBooleanArray((SparseBooleanArray) obj);
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return parcel.readSparseBooleanArray();
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public SparseBooleanArrayParcelable(Parcel parcel) {
            super(parcel, (i) f35787a, (byte) 0);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray sparseBooleanArray) {
            super((Object) sparseBooleanArray, (i) f35787a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<SparseBooleanArrayParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SparseBooleanArrayParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }
        }
    }

    public static final class IntegerParcelable extends ConverterParcelable<Integer> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Integer> f35777a = new org.parceler.a.k<Integer>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeInt(((Integer) obj).intValue());
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Integer.valueOf(parcel.readInt());
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public IntegerParcelable(Parcel parcel) {
            super(parcel, (i) f35777a, (byte) 0);
        }

        public IntegerParcelable(Integer num) {
            super((Object) num, (i) f35777a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<IntegerParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new IntegerParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IntegerParcelable(parcel);
            }
        }
    }

    public static final class LongParcelable extends ConverterParcelable<Long> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Long> f35782a = new org.parceler.a.k<Long>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeLong(((Long) obj).longValue());
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Long.valueOf(parcel.readLong());
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public LongParcelable(Parcel parcel) {
            super(parcel, (i) f35782a, (byte) 0);
        }

        public LongParcelable(Long l) {
            super((Object) l, (i) f35782a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<LongParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LongParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LongParcelable(parcel);
            }
        }
    }

    public static final class DoubleParcelable extends ConverterParcelable<Double> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Double> f35774a = new org.parceler.a.k<Double>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeDouble(((Double) obj).doubleValue());
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Double.valueOf(parcel.readDouble());
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public DoubleParcelable(Parcel parcel) {
            super(parcel, (i) f35774a, (byte) 0);
        }

        public DoubleParcelable(Double d2) {
            super((Object) d2, (i) f35774a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<DoubleParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new DoubleParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DoubleParcelable(parcel);
            }
        }
    }

    public static final class FloatParcelable extends ConverterParcelable<Float> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Float> f35775a = new org.parceler.a.k<Float>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeFloat(((Float) obj).floatValue());
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Float.valueOf(parcel.readFloat());
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public FloatParcelable(Parcel parcel) {
            super(parcel, (i) f35775a, (byte) 0);
        }

        public FloatParcelable(Float f2) {
            super((Object) f2, (i) f35775a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<FloatParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new FloatParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new FloatParcelable(parcel);
            }
        }
    }

    public static final class ByteParcelable extends ConverterParcelable<Byte> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Byte> f35768a = new org.parceler.a.k<Byte>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeByte(((Byte) obj).byteValue());
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Byte.valueOf(parcel.readByte());
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ByteParcelable(Parcel parcel) {
            super(parcel, (i) f35768a, (byte) 0);
        }

        public ByteParcelable(Byte b2) {
            super((Object) b2, (i) f35768a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<ByteParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ByteParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ByteParcelable(parcel);
            }
        }
    }

    public static final class IBinderParcelable extends ConverterParcelable<IBinder> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<IBinder> f35776a = new org.parceler.a.k<IBinder>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeStrongBinder((IBinder) obj);
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return parcel.readStrongBinder();
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public IBinderParcelable(Parcel parcel) {
            super(parcel, (i) f35776a, (byte) 0);
        }

        public IBinderParcelable(IBinder iBinder) {
            super((Object) iBinder, (i) f35776a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<IBinderParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new IBinderParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IBinderParcelable(parcel);
            }
        }
    }

    public static final class ByteArrayParcelable extends ConverterParcelable<byte[]> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<byte[]> f35767a = new org.parceler.a.k<byte[]>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeByteArray((byte[]) obj);
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return parcel.createByteArray();
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public ByteArrayParcelable(Parcel parcel) {
            super(parcel, (i) f35767a, (byte) 0);
        }

        public ByteArrayParcelable(byte[] bArr) {
            super((Object) bArr, (i) f35767a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<ByteArrayParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ByteArrayParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }
        }
    }

    public static final class BooleanArrayParcelable extends ConverterParcelable<boolean[]> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.b f35765a = new org.parceler.a.b();

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public BooleanArrayParcelable(Parcel parcel) {
            super(parcel, (i) f35765a, (byte) 0);
        }

        public BooleanArrayParcelable(boolean[] zArr) {
            super((Object) zArr, (i) f35765a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<BooleanArrayParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new BooleanArrayParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }
        }
    }

    public static final class BooleanParcelable extends ConverterParcelable<Boolean> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Boolean> f35766a = new org.parceler.a.k<Boolean>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeBooleanArray(new boolean[]{((Boolean) obj).booleanValue()});
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Boolean.valueOf(parcel.createBooleanArray()[0]);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public BooleanParcelable(Parcel parcel) {
            super(parcel, (i) f35766a, (byte) 0);
        }

        public BooleanParcelable(boolean z) {
            super((Object) Boolean.valueOf(z), (i) f35766a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<BooleanParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new BooleanParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BooleanParcelable(parcel);
            }
        }
    }

    public static final class CharArrayParcelable extends ConverterParcelable<char[]> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.c f35769a = new org.parceler.a.c();

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CharArrayParcelable(Parcel parcel) {
            super(parcel, (i) f35769a, (byte) 0);
        }

        public CharArrayParcelable(char[] cArr) {
            super((Object) cArr, (i) f35769a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<CharArrayParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new CharArrayParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }
        }
    }

    public static final class CharacterParcelable extends ConverterParcelable<Character> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private static final org.parceler.a.k<Character> f35770a = new org.parceler.a.k<Character>() {
            public final /* synthetic */ void a(Object obj, Parcel parcel) {
                parcel.writeCharArray(new char[]{((Character) obj).charValue()});
            }

            public final /* synthetic */ Object a(Parcel parcel) {
                return Character.valueOf(parcel.createCharArray()[0]);
            }
        };

        public final /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        public final /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
        }

        public CharacterParcelable(Parcel parcel) {
            super(parcel, (i) f35770a, (byte) 0);
        }

        public CharacterParcelable(Character ch) {
            super((Object) ch, (i) f35770a, (byte) 0);
        }

        static final class a implements Parcelable.Creator<CharacterParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new CharacterParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CharacterParcelable(parcel);
            }
        }
    }

    public static final class StringParcelable implements Parcelable, e<String> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private String f35788a;

        public final int describeContents() {
            return 0;
        }

        /* synthetic */ StringParcelable(Parcel parcel, byte b2) {
            this(parcel);
        }

        /* synthetic */ StringParcelable(String str, byte b2) {
            this(str);
        }

        private StringParcelable(Parcel parcel) {
            this.f35788a = parcel.readString();
        }

        private StringParcelable(String str) {
            this.f35788a = str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f35788a);
        }

        static final class a implements Parcelable.Creator<StringParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new StringParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StringParcelable(parcel, (byte) 0);
            }
        }

        public final /* bridge */ /* synthetic */ Object getParcel() {
            return this.f35788a;
        }
    }

    static class ConverterParcelable<T> implements Parcelable, e<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f35772a;

        /* renamed from: b  reason: collision with root package name */
        private final i<T, T> f35773b;

        public int describeContents() {
            return 0;
        }

        /* synthetic */ ConverterParcelable(Parcel parcel, i iVar, byte b2) {
            this(parcel, iVar);
        }

        /* synthetic */ ConverterParcelable(Object obj, i iVar, byte b2) {
            this(obj, iVar);
        }

        private ConverterParcelable(Parcel parcel, i<T, T> iVar) {
            this(iVar.c(parcel), iVar);
        }

        private ConverterParcelable(T t, i<T, T> iVar) {
            this.f35773b = iVar;
            this.f35772a = t;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f35773b.c(this.f35772a, parcel);
        }

        public T getParcel() {
            return this.f35772a;
        }
    }

    public static final class ParcelableParcelable implements Parcelable, e<Parcelable> {
        public static final a CREATOR = new a((byte) 0);

        /* renamed from: a  reason: collision with root package name */
        private Parcelable f35784a;

        public final int describeContents() {
            return 0;
        }

        /* synthetic */ ParcelableParcelable(Parcel parcel, byte b2) {
            this(parcel);
        }

        /* synthetic */ ParcelableParcelable(Parcelable parcelable, byte b2) {
            this(parcelable);
        }

        private ParcelableParcelable(Parcel parcel) {
            this.f35784a = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.f35784a = parcelable;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f35784a, i2);
        }

        static final class a implements Parcelable.Creator<ParcelableParcelable> {
            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ParcelableParcelable[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ParcelableParcelable(parcel, (byte) 0);
            }
        }

        public final /* bridge */ /* synthetic */ Object getParcel() {
            return this.f35784a;
        }
    }
}
