package androidx.exifinterface.a;

import android.content.res.AssetManager;
import com.paytm.android.chat.utils.KeyList;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {
    private static final c A = new c("JPEGInterchangeFormat", 513, 4);
    private static final c B = new c("JPEGInterchangeFormatLength", 514, 4);
    private static final HashMap<Integer, c>[] C;
    private static final HashMap<String, c>[] D;
    private static final HashSet<String> E = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    private static final HashMap<Integer, Integer> F = new HashMap<>();
    private static final Pattern X = Pattern.compile(".*[1-9].*");
    private static final Pattern Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3310a = {8, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3311b = {4};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3312c = {8};

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f3313d = {-1, -40, -1};

    /* renamed from: e  reason: collision with root package name */
    static final String[] f3314e = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f3315f = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f3316g = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: h  reason: collision with root package name */
    static final c[][] f3317h;

    /* renamed from: i  reason: collision with root package name */
    static final Charset f3318i = Charset.forName("US-ASCII");
    static final byte[] j = "Exif\u0000\u0000".getBytes(f3318i);
    private static final List<Integer> k = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final List<Integer> l = Arrays.asList(new Integer[]{2, 7, 4, 5});
    private static final byte[] m = {79, 76, 89, 77, 80, 0};
    private static final byte[] n = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat o;
    private static final c[] p = {new c("NewSubfileType", 254, 4), new c("SubfileType", PriceRangeSeekBar.INVALID_POINTER_ID, 4), new c("ImageWidth", UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS), new c("ImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
    private static final c[] q = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962), new c("PixelYDimension", 40963), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
    private static final c[] r = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] s = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] t = {new c("NewSubfileType", 254, 4), new c("SubfileType", PriceRangeSeekBar.INVALID_POINTER_ID, 4), new c("ThumbnailImageWidth", UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS), new c("ThumbnailImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
    private static final c u = new c("StripOffsets", 273, 3);
    private static final c[] v = {new c("ThumbnailImage", UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] w = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] x = {new c("AspectFrame", 4371, 3)};
    private static final c[] y = {new c("ColorSpace", 55, 3)};
    private static final c[] z = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private final String G;
    private final AssetManager.AssetInputStream H;
    private int I;
    private final HashMap<String, b>[] J;
    private Set<Integer> K;
    private ByteOrder L = ByteOrder.BIG_ENDIAN;
    private boolean M;
    private int N;
    private int O;
    private byte[] P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;

    static {
        c[] cVarArr = p;
        f3317h = new c[][]{cVarArr, q, r, s, t, cVarArr, v, w, x, y};
        c[][] cVarArr2 = f3317h;
        C = new HashMap[cVarArr2.length];
        D = new HashMap[cVarArr2.length];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        o = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < f3317h.length; i2++) {
            C[i2] = new HashMap<>();
            D[i2] = new HashMap<>();
            for (c cVar : f3317h[i2]) {
                C[i2].put(Integer.valueOf(cVar.f3328a), cVar);
                D[i2].put(cVar.f3329b, cVar);
            }
        }
        F.put(Integer.valueOf(z[0].f3328a), 5);
        F.put(Integer.valueOf(z[1].f3328a), 1);
        F.put(Integer.valueOf(z[2].f3328a), 2);
        F.put(Integer.valueOf(z[3].f3328a), 3);
        F.put(Integer.valueOf(z[4].f3328a), 7);
        F.put(Integer.valueOf(z[5].f3328a), 8);
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f3332a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3333b;

        d(long j, long j2) {
            if (j2 == 0) {
                this.f3332a = 0;
                this.f3333b = 1;
                return;
            }
            this.f3332a = j;
            this.f3333b = j2;
        }

        public final String toString() {
            return this.f3332a + "/" + this.f3333b;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3325a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3326b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f3327c;

        b(int i2, int i3, byte[] bArr) {
            this.f3325a = i2;
            this.f3326b = i3;
            this.f3327c = bArr;
        }

        private static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f3315f[3] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                wrap.putShort((short) iArr[0]);
            }
            return new b(3, 1, wrap.array());
        }

        public static b a(int i2, ByteOrder byteOrder) {
            return a(new int[]{i2}, byteOrder);
        }

        private static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f3315f[4] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                wrap.putInt((int) jArr[0]);
            }
            return new b(4, 1, wrap.array());
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + 0).getBytes(a.f3318i);
            return new b(2, bytes.length, bytes);
        }

        private static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f3315f[5] * 1)]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 <= 0; i2++) {
                d dVar = dVarArr[0];
                wrap.putInt((int) dVar.f3332a);
                wrap.putInt((int) dVar.f3333b);
            }
            return new b(5, 1, wrap.array());
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public final String toString() {
            return "(" + a.f3314e[this.f3325a] + ", data length:" + this.f3327c.length + ")";
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0157 A[SYNTHETIC, Splitter:B:141:0x0157] */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x015e A[SYNTHETIC, Splitter:B:148:0x015e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(java.nio.ByteOrder r9) {
            /*
                r8 = this;
                r0 = 0
                androidx.exifinterface.a.a$a r1 = new androidx.exifinterface.a.a$a     // Catch:{ IOException -> 0x015b, all -> 0x0153 }
                byte[] r2 = r8.f3327c     // Catch:{ IOException -> 0x015b, all -> 0x0153 }
                r1.<init>((byte[]) r2)     // Catch:{ IOException -> 0x015b, all -> 0x0153 }
                r1.f3321a = r9     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r9 = r8.f3325a     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r2 = 1
                r3 = 0
                switch(r9) {
                    case 1: goto L_0x011c;
                    case 2: goto L_0x00d3;
                    case 3: goto L_0x00be;
                    case 4: goto L_0x00a9;
                    case 5: goto L_0x008b;
                    case 6: goto L_0x011c;
                    case 7: goto L_0x00d3;
                    case 8: goto L_0x0076;
                    case 9: goto L_0x0061;
                    case 10: goto L_0x0041;
                    case 11: goto L_0x002b;
                    case 12: goto L_0x0016;
                    default: goto L_0x0011;
                }
            L_0x0011:
                r1.close()     // Catch:{ IOException -> 0x014e }
                goto L_0x014e
            L_0x0016:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x001a:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x0027
                double r4 = r1.readDouble()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r4     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x001a
            L_0x0027:
                r1.close()     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                return r9
            L_0x002b:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x002f:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x003d
                float r2 = r1.readFloat()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                double r4 = (double) r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r4     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x002f
            L_0x003d:
                r1.close()     // Catch:{ IOException -> 0x0040 }
            L_0x0040:
                return r9
            L_0x0041:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                androidx.exifinterface.a.a$d[] r9 = new androidx.exifinterface.a.a.d[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x0045:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x005d
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                long r4 = (long) r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                long r6 = (long) r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                androidx.exifinterface.a.a$d r2 = new androidx.exifinterface.a.a$d     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x0045
            L_0x005d:
                r1.close()     // Catch:{ IOException -> 0x0060 }
            L_0x0060:
                return r9
            L_0x0061:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x0065:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x0072
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x0065
            L_0x0072:
                r1.close()     // Catch:{ IOException -> 0x0075 }
            L_0x0075:
                return r9
            L_0x0076:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x007a:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x0087
                short r2 = r1.readShort()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x007a
            L_0x0087:
                r1.close()     // Catch:{ IOException -> 0x008a }
            L_0x008a:
                return r9
            L_0x008b:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                androidx.exifinterface.a.a$d[] r9 = new androidx.exifinterface.a.a.d[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x008f:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x00a5
                long r4 = r1.a()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                long r6 = r1.a()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                androidx.exifinterface.a.a$d r2 = new androidx.exifinterface.a.a$d     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x008f
            L_0x00a5:
                r1.close()     // Catch:{ IOException -> 0x00a8 }
            L_0x00a8:
                return r9
            L_0x00a9:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                long[] r9 = new long[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x00ad:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x00ba
                long r4 = r1.a()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r4     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x00ad
            L_0x00ba:
                r1.close()     // Catch:{ IOException -> 0x00bd }
            L_0x00bd:
                return r9
            L_0x00be:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x00c2:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x00cf
                int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9[r3] = r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r3 + 1
                goto L_0x00c2
            L_0x00cf:
                r1.close()     // Catch:{ IOException -> 0x00d2 }
            L_0x00d2:
                return r9
            L_0x00d3:
                int r9 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte[] r4 = androidx.exifinterface.a.a.f3316g     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r4 = r4.length     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r9 < r4) goto L_0x00f4
                r9 = 0
            L_0x00db:
                byte[] r4 = androidx.exifinterface.a.a.f3316g     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r4 = r4.length     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r9 >= r4) goto L_0x00ef
                byte[] r4 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r4 = r4[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte[] r5 = androidx.exifinterface.a.a.f3316g     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r5 = r5[r9]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r4 == r5) goto L_0x00ec
                r2 = 0
                goto L_0x00ef
            L_0x00ec:
                int r9 = r9 + 1
                goto L_0x00db
            L_0x00ef:
                if (r2 == 0) goto L_0x00f4
                byte[] r9 = androidx.exifinterface.a.a.f3316g     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r3 = r9.length     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x00f4:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9.<init>()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x00f9:
                int r2 = r8.f3326b     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r3 >= r2) goto L_0x0114
                byte[] r2 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r2 = r2[r3]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r2 == 0) goto L_0x0114
                r4 = 32
                if (r2 < r4) goto L_0x010c
                char r2 = (char) r2     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9.append(r2)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                goto L_0x0111
            L_0x010c:
                r2 = 63
                r9.append(r2)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
            L_0x0111:
                int r3 = r3 + 1
                goto L_0x00f9
            L_0x0114:
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r1.close()     // Catch:{ IOException -> 0x011b }
            L_0x011b:
                return r9
            L_0x011c:
                byte[] r9 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r9 = r9.length     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r9 != r2) goto L_0x0141
                byte[] r9 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r9 < 0) goto L_0x0141
                byte[] r9 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                if (r9 > r2) goto L_0x0141
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte[] r4 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte r4 = r4[r3]     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r2[r3] = r4     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9.<init>(r2)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r1.close()     // Catch:{ IOException -> 0x0140 }
            L_0x0140:
                return r9
            L_0x0141:
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                byte[] r2 = r8.f3327c     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                java.nio.charset.Charset r3 = androidx.exifinterface.a.a.f3318i     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r9.<init>(r2, r3)     // Catch:{ IOException -> 0x0151, all -> 0x014f }
                r1.close()     // Catch:{ IOException -> 0x014d }
            L_0x014d:
                return r9
            L_0x014e:
                return r0
            L_0x014f:
                r9 = move-exception
                goto L_0x0155
            L_0x0151:
                goto L_0x015c
            L_0x0153:
                r9 = move-exception
                r1 = r0
            L_0x0155:
                if (r1 == 0) goto L_0x015a
                r1.close()     // Catch:{ IOException -> 0x015a }
            L_0x015a:
                throw r9
            L_0x015b:
                r1 = r0
            L_0x015c:
                if (r1 == 0) goto L_0x0161
                r1.close()     // Catch:{ IOException -> 0x0161 }
            L_0x0161:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.b.a(java.nio.ByteOrder):java.lang.Object");
        }

        public final int b(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a2 instanceof String) {
                return Integer.parseInt((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public final String c(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(AppConstants.COMMA);
                    }
                }
                return sb.toString();
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(AppConstants.COMMA);
                    }
                }
                return sb.toString();
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(AppConstants.COMMA);
                    }
                }
                return sb.toString();
            } else if (!(a2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) a2;
                while (i2 < dVarArr.length) {
                    sb.append(dVarArr[i2].f3332a);
                    sb.append('/');
                    sb.append(dVarArr[i2].f3333b);
                    i2++;
                    if (i2 != dVarArr.length) {
                        sb.append(AppConstants.COMMA);
                    }
                }
                return sb.toString();
            }
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3328a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3329b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3330c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3331d;

        c(String str, int i2, int i3) {
            this.f3329b = str;
            this.f3328a = i2;
            this.f3330c = i3;
            this.f3331d = -1;
        }

        c(String str, int i2) {
            this.f3329b = str;
            this.f3328a = i2;
            this.f3330c = 3;
            this.f3331d = 4;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int i2) {
            int i3;
            int i4 = this.f3330c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f3331d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((this.f3330c == 9 || this.f3331d == 9) && i2 == 8) {
                return true;
            }
            if ((this.f3330c == 12 || this.f3331d == 12) && i2 == 11) {
                return true;
            }
            return false;
        }
    }

    public a(String str) throws IOException {
        c[][] cVarArr = f3317h;
        this.J = new HashMap[cVarArr.length];
        this.K = new HashSet(cVarArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.H = null;
            this.G = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    a((InputStream) fileInputStream2);
                    a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    public a(InputStream inputStream) throws IOException {
        c[][] cVarArr = f3317h;
        this.J = new HashMap[cVarArr.length];
        this.K = new HashSet(cVarArr.length);
        if (inputStream != null) {
            this.G = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.H = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.H = null;
            }
            a(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    private b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < f3317h.length; i2++) {
            b bVar = this.J[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    private String c(String str) {
        double d2;
        b b2 = b(str);
        if (b2 != null) {
            if (!E.contains(str)) {
                return b2.c(this.L);
            }
            if (!str.equals("GPSTimeStamp")) {
                try {
                    Object a2 = b2.a(this.L);
                    if (a2 != null) {
                        if (a2 instanceof String) {
                            d2 = Double.parseDouble((String) a2);
                        } else if (a2 instanceof long[]) {
                            long[] jArr = (long[]) a2;
                            if (jArr.length == 1) {
                                d2 = (double) jArr[0];
                            } else {
                                throw new NumberFormatException("There are more than one component");
                            }
                        } else if (a2 instanceof int[]) {
                            int[] iArr = (int[]) a2;
                            if (iArr.length == 1) {
                                d2 = (double) iArr[0];
                            } else {
                                throw new NumberFormatException("There are more than one component");
                            }
                        } else if (a2 instanceof double[]) {
                            double[] dArr = (double[]) a2;
                            if (dArr.length == 1) {
                                d2 = dArr[0];
                            } else {
                                throw new NumberFormatException("There are more than one component");
                            }
                        } else if (a2 instanceof d[]) {
                            d[] dVarArr = (d[]) a2;
                            if (dVarArr.length == 1) {
                                d dVar = dVarArr[0];
                                d2 = ((double) dVar.f3332a) / ((double) dVar.f3333b);
                            } else {
                                throw new NumberFormatException("There are more than one component");
                            }
                        } else {
                            throw new NumberFormatException("Couldn't find a double value");
                        }
                        return Double.toString(d2);
                    }
                    throw new NumberFormatException("NULL can't be converted to a double value");
                } catch (NumberFormatException unused) {
                }
            } else if (b2.f3325a == 5 || b2.f3325a == 10) {
                d[] dVarArr2 = (d[]) b2.a(this.L);
                if (dVarArr2 == null || dVarArr2.length != 3) {
                    new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(dVarArr2));
                    return null;
                }
                return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr2[0].f3332a) / ((float) dVarArr2[0].f3333b))), Integer.valueOf((int) (((float) dVarArr2[1].f3332a) / ((float) dVarArr2[1].f3333b))), Integer.valueOf((int) (((float) dVarArr2[2].f3332a) / ((float) dVarArr2[2].f3333b)))});
            } else {
                new StringBuilder("GPS Timestamp format is not rational. format=").append(b2.f3325a);
                return null;
            }
        }
        return null;
    }

    public final int a(String str) {
        b b2 = b(str);
        if (b2 == null) {
            return 1;
        }
        try {
            return b2.b(this.L);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:101|102|103|104) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0243, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r11.W = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x024a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x024b, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x024e, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0245 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062 A[Catch:{ IOException -> 0x0245 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ IOException -> 0x0245 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0234 A[Catch:{ IOException -> 0x0245 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.InputStream r12) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "PhotographicSensitivity"
            r1 = 0
            r2 = 0
        L_0x0004:
            androidx.exifinterface.a.a$c[][] r3 = f3317h     // Catch:{ IOException -> 0x0245 }
            int r3 = r3.length     // Catch:{ IOException -> 0x0245 }
            if (r2 >= r3) goto L_0x0015
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r3 = r11.J     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ IOException -> 0x0245 }
            r4.<init>()     // Catch:{ IOException -> 0x0245 }
            r3[r2] = r4     // Catch:{ IOException -> 0x0245 }
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0015:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0245 }
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r12, r3)     // Catch:{ IOException -> 0x0245 }
            r12 = r2
            java.io.BufferedInputStream r12 = (java.io.BufferedInputStream) r12     // Catch:{ IOException -> 0x0245 }
            r12.mark(r3)     // Catch:{ IOException -> 0x0245 }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0245 }
            r12.read(r3)     // Catch:{ IOException -> 0x0245 }
            r12.reset()     // Catch:{ IOException -> 0x0245 }
            boolean r12 = a((byte[]) r3)     // Catch:{ IOException -> 0x0245 }
            r4 = 4
            r5 = 7
            r6 = 1
            if (r12 == 0) goto L_0x0035
            r12 = 4
            goto L_0x0087
        L_0x0035:
            boolean r12 = b((byte[]) r3)     // Catch:{ IOException -> 0x0245 }
            if (r12 == 0) goto L_0x003e
            r12 = 9
            goto L_0x0087
        L_0x003e:
            androidx.exifinterface.a.a$a r12 = new androidx.exifinterface.a.a$a     // Catch:{ IOException -> 0x0245 }
            r12.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r7 = c((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
            r11.L = r7     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r7 = r11.L     // Catch:{ IOException -> 0x0245 }
            r12.f3321a = r7     // Catch:{ IOException -> 0x0245 }
            short r7 = r12.readShort()     // Catch:{ IOException -> 0x0245 }
            r12.close()     // Catch:{ IOException -> 0x0245 }
            r12 = 20306(0x4f52, float:2.8455E-41)
            if (r7 == r12) goto L_0x005f
            r12 = 21330(0x5352, float:2.989E-41)
            if (r7 != r12) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r12 = 0
            goto L_0x0060
        L_0x005f:
            r12 = 1
        L_0x0060:
            if (r12 == 0) goto L_0x0064
            r12 = 7
            goto L_0x0087
        L_0x0064:
            androidx.exifinterface.a.a$a r12 = new androidx.exifinterface.a.a$a     // Catch:{ IOException -> 0x0245 }
            r12.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r3 = c((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
            r11.L = r3     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r3 = r11.L     // Catch:{ IOException -> 0x0245 }
            r12.f3321a = r3     // Catch:{ IOException -> 0x0245 }
            short r3 = r12.readShort()     // Catch:{ IOException -> 0x0245 }
            r12.close()     // Catch:{ IOException -> 0x0245 }
            r12 = 85
            if (r3 != r12) goto L_0x0080
            r12 = 1
            goto L_0x0081
        L_0x0080:
            r12 = 0
        L_0x0081:
            if (r12 == 0) goto L_0x0086
            r12 = 10
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r11.I = r12     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$a r12 = new androidx.exifinterface.a.a$a     // Catch:{ IOException -> 0x0245 }
            r12.<init>((java.io.InputStream) r2)     // Catch:{ IOException -> 0x0245 }
            int r2 = r11.I     // Catch:{ IOException -> 0x0245 }
            r3 = 3
            r7 = 5
            r8 = 6
            switch(r2) {
                case 0: goto L_0x01c4;
                case 1: goto L_0x01c4;
                case 2: goto L_0x01c4;
                case 3: goto L_0x01c4;
                case 4: goto L_0x01c0;
                case 5: goto L_0x01c4;
                case 6: goto L_0x01c4;
                case 7: goto L_0x00d6;
                case 8: goto L_0x01c4;
                case 9: goto L_0x00d1;
                case 10: goto L_0x0098;
                case 11: goto L_0x01c4;
                default: goto L_0x0096;
            }     // Catch:{ IOException -> 0x0245 }
        L_0x0096:
            goto L_0x01c7
        L_0x0098:
            r11.a((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r2 = r11.J     // Catch:{ IOException -> 0x0245 }
            r2 = r2[r1]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r9 = "JpgFromRaw"
            java.lang.Object r2 = r2.get(r9)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = (androidx.exifinterface.a.a.b) r2     // Catch:{ IOException -> 0x0245 }
            if (r2 == 0) goto L_0x00ae
            int r2 = r11.V     // Catch:{ IOException -> 0x0245 }
            r11.a(r12, r2, r7)     // Catch:{ IOException -> 0x0245 }
        L_0x00ae:
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r2 = r11.J     // Catch:{ IOException -> 0x0245 }
            r2 = r2[r1]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r7 = "ISO"
            java.lang.Object r2 = r2.get(r7)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = (androidx.exifinterface.a.a.b) r2     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r7 = r11.J     // Catch:{ IOException -> 0x0245 }
            r7 = r7[r6]     // Catch:{ IOException -> 0x0245 }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r7 = (androidx.exifinterface.a.a.b) r7     // Catch:{ IOException -> 0x0245 }
            if (r2 == 0) goto L_0x01c7
            if (r7 != 0) goto L_0x01c7
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r7 = r11.J     // Catch:{ IOException -> 0x0245 }
            r7 = r7[r6]     // Catch:{ IOException -> 0x0245 }
            r7.put(r0, r2)     // Catch:{ IOException -> 0x0245 }
            goto L_0x01c7
        L_0x00d1:
            r11.b((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
            goto L_0x01c7
        L_0x00d6:
            r11.a((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r6]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r2 = "MakerNote"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r0 = (androidx.exifinterface.a.a.b) r0     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x01c7
            androidx.exifinterface.a.a$a r2 = new androidx.exifinterface.a.a$a     // Catch:{ IOException -> 0x0245 }
            byte[] r0 = r0.f3327c     // Catch:{ IOException -> 0x0245 }
            r2.<init>((byte[]) r0)     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r0 = r11.L     // Catch:{ IOException -> 0x0245 }
            r2.f3321a = r0     // Catch:{ IOException -> 0x0245 }
            byte[] r0 = m     // Catch:{ IOException -> 0x0245 }
            int r0 = r0.length     // Catch:{ IOException -> 0x0245 }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0245 }
            r2.readFully(r0)     // Catch:{ IOException -> 0x0245 }
            r9 = 0
            r2.a(r9)     // Catch:{ IOException -> 0x0245 }
            byte[] r9 = n     // Catch:{ IOException -> 0x0245 }
            int r9 = r9.length     // Catch:{ IOException -> 0x0245 }
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x0245 }
            r2.readFully(r9)     // Catch:{ IOException -> 0x0245 }
            byte[] r10 = m     // Catch:{ IOException -> 0x0245 }
            boolean r0 = java.util.Arrays.equals(r0, r10)     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x0115
            r9 = 8
            r2.a(r9)     // Catch:{ IOException -> 0x0245 }
            goto L_0x0122
        L_0x0115:
            byte[] r0 = n     // Catch:{ IOException -> 0x0245 }
            boolean r0 = java.util.Arrays.equals(r9, r0)     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x0122
            r9 = 12
            r2.a(r9)     // Catch:{ IOException -> 0x0245 }
        L_0x0122:
            r11.b((androidx.exifinterface.a.a.C0054a) r2, (int) r8)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r5]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r2 = "PreviewImageStart"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r0 = (androidx.exifinterface.a.a.b) r0     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r2 = r11.J     // Catch:{ IOException -> 0x0245 }
            r2 = r2[r5]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r9 = "PreviewImageLength"
            java.lang.Object r2 = r2.get(r9)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = (androidx.exifinterface.a.a.b) r2     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x0153
            if (r2 == 0) goto L_0x0153
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r9 = r11.J     // Catch:{ IOException -> 0x0245 }
            r9 = r9[r7]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r10 = "JPEGInterchangeFormat"
            r9.put(r10, r0)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r7]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r7 = "JPEGInterchangeFormatLength"
            r0.put(r7, r2)     // Catch:{ IOException -> 0x0245 }
        L_0x0153:
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r2 = 8
            r0 = r0[r2]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r2 = "AspectFrame"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r0 = (androidx.exifinterface.a.a.b) r0     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x01c7
            java.nio.ByteOrder r2 = r11.L     // Catch:{ IOException -> 0x0245 }
            java.lang.Object r0 = r0.a((java.nio.ByteOrder) r2)     // Catch:{ IOException -> 0x0245 }
            int[] r0 = (int[]) r0     // Catch:{ IOException -> 0x0245 }
            int[] r0 = (int[]) r0     // Catch:{ IOException -> 0x0245 }
            if (r0 == 0) goto L_0x01b1
            int r2 = r0.length     // Catch:{ IOException -> 0x0245 }
            if (r2 == r4) goto L_0x0173
            goto L_0x01b1
        L_0x0173:
            r2 = 2
            r7 = r0[r2]     // Catch:{ IOException -> 0x0245 }
            r9 = r0[r1]     // Catch:{ IOException -> 0x0245 }
            if (r7 <= r9) goto L_0x01c7
            r7 = r0[r3]     // Catch:{ IOException -> 0x0245 }
            r9 = r0[r6]     // Catch:{ IOException -> 0x0245 }
            if (r7 <= r9) goto L_0x01c7
            r2 = r0[r2]     // Catch:{ IOException -> 0x0245 }
            r7 = r0[r1]     // Catch:{ IOException -> 0x0245 }
            int r2 = r2 - r7
            int r2 = r2 + r6
            r7 = r0[r3]     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r6]     // Catch:{ IOException -> 0x0245 }
            int r7 = r7 - r0
            int r7 = r7 + r6
            if (r2 >= r7) goto L_0x0192
            int r2 = r2 + r7
            int r7 = r2 - r7
            int r2 = r2 - r7
        L_0x0192:
            java.nio.ByteOrder r0 = r11.L     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r0 = androidx.exifinterface.a.a.b.a((int) r2, (java.nio.ByteOrder) r0)     // Catch:{ IOException -> 0x0245 }
            java.nio.ByteOrder r2 = r11.L     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = androidx.exifinterface.a.a.b.a((int) r7, (java.nio.ByteOrder) r2)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r7 = r11.J     // Catch:{ IOException -> 0x0245 }
            r7 = r7[r1]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r9 = "ImageWidth"
            r7.put(r9, r0)     // Catch:{ IOException -> 0x0245 }
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r1]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r7 = "ImageLength"
            r0.put(r7, r2)     // Catch:{ IOException -> 0x0245 }
            goto L_0x01c7
        L_0x01b1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0245 }
            java.lang.String r7 = "Invalid aspect frame values. frame="
            r2.<init>(r7)     // Catch:{ IOException -> 0x0245 }
            java.lang.String r0 = java.util.Arrays.toString(r0)     // Catch:{ IOException -> 0x0245 }
            r2.append(r0)     // Catch:{ IOException -> 0x0245 }
            goto L_0x01c7
        L_0x01c0:
            r11.a(r12, r1, r1)     // Catch:{ IOException -> 0x0245 }
            goto L_0x01c7
        L_0x01c4:
            r11.a((androidx.exifinterface.a.a.C0054a) r12)     // Catch:{ IOException -> 0x0245 }
        L_0x01c7:
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r11.J     // Catch:{ IOException -> 0x0245 }
            r0 = r0[r4]     // Catch:{ IOException -> 0x0245 }
            java.lang.String r2 = "Compression"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = (androidx.exifinterface.a.a.b) r2     // Catch:{ IOException -> 0x0245 }
            if (r2 == 0) goto L_0x0238
            java.nio.ByteOrder r4 = r11.L     // Catch:{ IOException -> 0x0245 }
            int r2 = r2.b(r4)     // Catch:{ IOException -> 0x0245 }
            r11.Q = r2     // Catch:{ IOException -> 0x0245 }
            int r2 = r11.Q     // Catch:{ IOException -> 0x0245 }
            if (r2 == r6) goto L_0x01ea
            if (r2 == r8) goto L_0x01e6
            if (r2 == r5) goto L_0x01ea
            goto L_0x023d
        L_0x01e6:
            r11.a((androidx.exifinterface.a.a.C0054a) r12, (java.util.HashMap) r0)     // Catch:{ IOException -> 0x0245 }
            goto L_0x023d
        L_0x01ea:
            java.lang.String r2 = "BitsPerSample"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r2 = (androidx.exifinterface.a.a.b) r2     // Catch:{ IOException -> 0x0245 }
            if (r2 == 0) goto L_0x0231
            java.nio.ByteOrder r4 = r11.L     // Catch:{ IOException -> 0x0245 }
            java.lang.Object r2 = r2.a((java.nio.ByteOrder) r4)     // Catch:{ IOException -> 0x0245 }
            int[] r2 = (int[]) r2     // Catch:{ IOException -> 0x0245 }
            int[] r2 = (int[]) r2     // Catch:{ IOException -> 0x0245 }
            int[] r4 = f3310a     // Catch:{ IOException -> 0x0245 }
            boolean r4 = java.util.Arrays.equals(r4, r2)     // Catch:{ IOException -> 0x0245 }
            if (r4 == 0) goto L_0x0208
        L_0x0206:
            r2 = 1
            goto L_0x0232
        L_0x0208:
            int r4 = r11.I     // Catch:{ IOException -> 0x0245 }
            if (r4 != r3) goto L_0x0231
            java.lang.String r3 = "PhotometricInterpretation"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ IOException -> 0x0245 }
            androidx.exifinterface.a.a$b r3 = (androidx.exifinterface.a.a.b) r3     // Catch:{ IOException -> 0x0245 }
            if (r3 == 0) goto L_0x0231
            java.nio.ByteOrder r4 = r11.L     // Catch:{ IOException -> 0x0245 }
            int r3 = r3.b(r4)     // Catch:{ IOException -> 0x0245 }
            if (r3 != r6) goto L_0x0226
            int[] r4 = f3312c     // Catch:{ IOException -> 0x0245 }
            boolean r4 = java.util.Arrays.equals(r2, r4)     // Catch:{ IOException -> 0x0245 }
            if (r4 != 0) goto L_0x0206
        L_0x0226:
            if (r3 != r8) goto L_0x0231
            int[] r3 = f3310a     // Catch:{ IOException -> 0x0245 }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ IOException -> 0x0245 }
            if (r2 == 0) goto L_0x0231
            goto L_0x0206
        L_0x0231:
            r2 = 0
        L_0x0232:
            if (r2 == 0) goto L_0x023d
            r11.b((androidx.exifinterface.a.a.C0054a) r12, (java.util.HashMap) r0)     // Catch:{ IOException -> 0x0245 }
            goto L_0x023d
        L_0x0238:
            r11.Q = r8     // Catch:{ IOException -> 0x0245 }
            r11.a((androidx.exifinterface.a.a.C0054a) r12, (java.util.HashMap) r0)     // Catch:{ IOException -> 0x0245 }
        L_0x023d:
            r11.W = r6     // Catch:{ IOException -> 0x0245 }
            r11.a()
            return
        L_0x0243:
            r12 = move-exception
            goto L_0x024b
        L_0x0245:
            r11.W = r1     // Catch:{ all -> 0x0243 }
            r11.a()
            return
        L_0x024b:
            r11.a()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.a(java.io.InputStream):void");
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f3313d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static boolean b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0086 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.exifinterface.a.a.C0054a r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r10.f3321a = r0
            long r0 = (long) r11
            r10.a(r0)
            byte r0 = r10.readByte()
            java.lang.String r1 = "Invalid marker: "
            r2 = -1
            if (r0 != r2) goto L_0x0151
            r3 = 1
            int r11 = r11 + r3
            byte r4 = r10.readByte()
            r5 = -40
            if (r4 != r5) goto L_0x0139
            int r11 = r11 + r3
        L_0x001c:
            byte r0 = r10.readByte()
            if (r0 != r2) goto L_0x011f
            int r11 = r11 + r3
            byte r0 = r10.readByte()
            int r11 = r11 + r3
            r1 = -39
            if (r0 == r1) goto L_0x011a
            r1 = -38
            if (r0 == r1) goto L_0x011a
            int r1 = r10.readUnsignedShort()
            int r1 = r1 + -2
            int r11 = r11 + 2
            java.lang.String r4 = "Invalid length"
            if (r1 < 0) goto L_0x0114
            r5 = -31
            r6 = 0
            java.lang.String r7 = "Invalid exif"
            if (r0 == r5) goto L_0x00b8
            r5 = -2
            if (r0 == r5) goto L_0x008e
            switch(r0) {
                case -64: goto L_0x0054;
                case -63: goto L_0x0054;
                case -62: goto L_0x0054;
                case -61: goto L_0x0054;
                default: goto L_0x0049;
            }
        L_0x0049:
            switch(r0) {
                case -59: goto L_0x0054;
                case -58: goto L_0x0054;
                case -57: goto L_0x0054;
                default: goto L_0x004c;
            }
        L_0x004c:
            switch(r0) {
                case -55: goto L_0x0054;
                case -54: goto L_0x0054;
                case -53: goto L_0x0054;
                default: goto L_0x004f;
            }
        L_0x004f:
            switch(r0) {
                case -51: goto L_0x0054;
                case -50: goto L_0x0054;
                case -49: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x00fb
        L_0x0054:
            int r0 = r10.skipBytes(r3)
            if (r0 != r3) goto L_0x0086
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r9.J
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.L
            androidx.exifinterface.a.a$b r5 = androidx.exifinterface.a.a.b.a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageLength"
            r0.put(r6, r5)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r0 = r9.J
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.L
            androidx.exifinterface.a.a$b r5 = androidx.exifinterface.a.a.b.a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageWidth"
            r0.put(r6, r5)
            int r1 = r1 + -5
            goto L_0x00fb
        L_0x0086:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid SOFx"
            r10.<init>(r11)
            throw r10
        L_0x008e:
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00b2
            java.lang.String r1 = "UserComment"
            java.lang.String r5 = r9.c((java.lang.String) r1)
            if (r5 != 0) goto L_0x00b0
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r5 = r9.J
            r5 = r5[r3]
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r8 = f3318i
            r7.<init>(r0, r8)
            androidx.exifinterface.a.a$b r0 = androidx.exifinterface.a.a.b.a((java.lang.String) r7)
            r5.put(r1, r0)
        L_0x00b0:
            r1 = 0
            goto L_0x00fb
        L_0x00b2:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00b8:
            r0 = 6
            if (r1 < r0) goto L_0x00fb
            byte[] r5 = new byte[r0]
            int r8 = r10.read(r5)
            if (r8 != r0) goto L_0x00f5
            int r11 = r11 + 6
            int r1 = r1 + -6
            byte[] r0 = j
            boolean r0 = java.util.Arrays.equals(r5, r0)
            if (r0 == 0) goto L_0x00fb
            if (r1 <= 0) goto L_0x00ef
            r9.R = r11
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00e9
            int r11 = r11 + r1
            androidx.exifinterface.a.a$a r1 = new androidx.exifinterface.a.a$a
            r1.<init>((byte[]) r0)
            int r0 = r0.length
            r9.a((androidx.exifinterface.a.a.C0054a) r1, (int) r0)
            r9.b((androidx.exifinterface.a.a.C0054a) r1, (int) r12)
            goto L_0x00b0
        L_0x00e9:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00ef:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00f5:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00fb:
            if (r1 < 0) goto L_0x010e
            int r0 = r10.skipBytes(r1)
            if (r0 != r1) goto L_0x0106
            int r11 = r11 + r1
            goto L_0x001c
        L_0x0106:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid JPEG segment"
            r10.<init>(r11)
            throw r10
        L_0x010e:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x0114:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x011a:
            java.nio.ByteOrder r11 = r9.L
            r10.f3321a = r11
            return
        L_0x011f:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Invalid marker:"
            r11.<init>(r12)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0139:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0151:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.a(androidx.exifinterface.a.a$a, int, int):void");
    }

    private void a(C0054a aVar) throws IOException {
        b bVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        b();
        if (this.I == 8 && (bVar = this.J[1].get("MakerNote")) != null) {
            C0054a aVar2 = new C0054a(bVar.f3327c);
            aVar2.f3321a = this.L;
            aVar2.a(6);
            b(aVar2, 9);
            b bVar2 = this.J[9].get("ColorSpace");
            if (bVar2 != null) {
                this.J[1].put("ColorSpace", bVar2);
            }
        }
    }

    private void b(C0054a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i2, 5);
        aVar.a((long) i3);
        aVar.f3321a = ByteOrder.BIG_ENDIAN;
        int readInt = aVar.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == u.f3328a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.L);
                b a3 = b.a((int) readShort2, this.L);
                this.J[0].put("ImageLength", a2);
                this.J[0].put("ImageWidth", a3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void a() {
        String c2 = c("DateTimeOriginal");
        if (c2 != null && c("DateTime") == null) {
            this.J[0].put("DateTime", b.a(c2));
        }
        if (c("ImageWidth") == null) {
            this.J[0].put("ImageWidth", b.a(0, this.L));
        }
        if (c("ImageLength") == null) {
            this.J[0].put("ImageLength", b.a(0, this.L));
        }
        if (c("Orientation") == null) {
            this.J[0].put("Orientation", b.a(0, this.L));
        }
        if (c("LightSource") == null) {
            this.J[1].put("LightSource", b.a(0, this.L));
        }
    }

    private static ByteOrder c(C0054a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void a(C0054a aVar, int i2) throws IOException {
        this.L = c(aVar);
        aVar.f3321a = this.L;
        int readUnsignedShort = aVar.readUnsignedShort();
        int i3 = this.I;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readInt)));
            }
            int i4 = readInt - 8;
            if (i4 > 0 && aVar.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(i4)));
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.exifinterface.a.a.C0054a r27, int r28) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r4 = r28
        L_0x0006:
            java.util.Set<java.lang.Integer> r5 = r0.K
            int r6 = r1.f3323c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.add(r6)
            int r5 = r1.f3323c
            int r5 = r5 + 2
            int r6 = r1.f3322b
            if (r5 <= r6) goto L_0x001a
            return
        L_0x001a:
            short r5 = r27.readShort()
            int r6 = r1.f3323c
            int r7 = r5 * 12
            int r6 = r6 + r7
            int r7 = r1.f3322b
            if (r6 > r7) goto L_0x027b
            if (r5 > 0) goto L_0x002b
            goto L_0x027b
        L_0x002b:
            r7 = 0
        L_0x002c:
            r8 = 0
            if (r7 >= r5) goto L_0x0238
            int r10 = r27.readUnsignedShort()
            int r11 = r27.readUnsignedShort()
            int r12 = r27.readInt()
            int r13 = r1.f3323c
            long r13 = (long) r13
            r15 = 4
            long r13 = r13 + r15
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.a.a$c>[] r17 = C
            r6 = r17[r4]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r6.get(r2)
            androidx.exifinterface.a.a$c r2 = (androidx.exifinterface.a.a.c) r2
            r6 = 7
            if (r2 == 0) goto L_0x009e
            if (r11 <= 0) goto L_0x009e
            int[] r3 = f3315f
            int r3 = r3.length
            if (r11 < r3) goto L_0x005b
            goto L_0x009e
        L_0x005b:
            boolean r3 = r2.a(r11)
            if (r3 != 0) goto L_0x007a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r15 = "Skip the tag entry since data format ("
            r3.<init>(r15)
            java.lang.String[] r15 = f3314e
            r15 = r15[r11]
            r3.append(r15)
            java.lang.String r15 = ") is unexpected for tag: "
            r3.append(r15)
            java.lang.String r15 = r2.f3329b
            r3.append(r15)
            goto L_0x009e
        L_0x007a:
            if (r11 != r6) goto L_0x007e
            int r11 = r2.f3330c
        L_0x007e:
            r3 = r7
            long r6 = (long) r12
            int[] r16 = f3315f
            r15 = r16[r11]
            r16 = r10
            r22 = r11
            long r10 = (long) r15
            long r6 = r6 * r10
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x009b
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x0097
            goto L_0x009b
        L_0x0097:
            r10 = 1
            r11 = r22
            goto L_0x00a3
        L_0x009b:
            r11 = r22
            goto L_0x00a2
        L_0x009e:
            r3 = r7
            r16 = r10
            r6 = r8
        L_0x00a2:
            r10 = 0
        L_0x00a3:
            if (r10 != 0) goto L_0x00b0
            r1.a(r13)
            r22 = r3
            r21 = r4
            r23 = r5
            goto L_0x022f
        L_0x00b0:
            java.lang.String r10 = "Compression"
            r19 = 4
            int r15 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r15 <= 0) goto L_0x014c
            int r15 = r27.readInt()
            int r8 = r0.I
            r9 = 7
            if (r8 != r9) goto L_0x0121
            java.lang.String r8 = r2.f3329b
            java.lang.String r9 = "MakerNote"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00ce
            r0.S = r15
            goto L_0x011a
        L_0x00ce:
            r8 = 6
            if (r4 != r8) goto L_0x011a
            java.lang.String r9 = r2.f3329b
            java.lang.String r8 = "ThumbnailImage"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x011a
            r0.T = r15
            r0.U = r12
            java.nio.ByteOrder r8 = r0.L
            r9 = 6
            androidx.exifinterface.a.a$b r8 = androidx.exifinterface.a.a.b.a((int) r9, (java.nio.ByteOrder) r8)
            int r9 = r0.T
            r22 = r3
            r21 = r4
            long r3 = (long) r9
            java.nio.ByteOrder r9 = r0.L
            androidx.exifinterface.a.a$b r3 = androidx.exifinterface.a.a.b.a((long) r3, (java.nio.ByteOrder) r9)
            int r4 = r0.U
            r9 = r5
            long r4 = (long) r4
            r23 = r9
            java.nio.ByteOrder r9 = r0.L
            androidx.exifinterface.a.a$b r4 = androidx.exifinterface.a.a.b.a((long) r4, (java.nio.ByteOrder) r9)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r5 = r0.J
            r9 = 4
            r5 = r5[r9]
            r5.put(r10, r8)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r5 = r0.J
            r5 = r5[r9]
            java.lang.String r8 = "JPEGInterchangeFormat"
            r5.put(r8, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r3 = r0.J
            r3 = r3[r9]
            java.lang.String r5 = "JPEGInterchangeFormatLength"
            r3.put(r5, r4)
            goto L_0x0137
        L_0x011a:
            r22 = r3
            r21 = r4
            r23 = r5
            goto L_0x0137
        L_0x0121:
            r22 = r3
            r21 = r4
            r23 = r5
            r3 = 10
            if (r8 != r3) goto L_0x0137
            java.lang.String r3 = r2.f3329b
            java.lang.String r4 = "JpgFromRaw"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0137
            r0.V = r15
        L_0x0137:
            long r3 = (long) r15
            long r8 = r3 + r6
            int r5 = r1.f3322b
            r24 = r6
            long r5 = (long) r5
            int r7 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0147
            r1.a(r3)
            goto L_0x0154
        L_0x0147:
            r1.a(r13)
            goto L_0x022f
        L_0x014c:
            r22 = r3
            r21 = r4
            r23 = r5
            r24 = r6
        L_0x0154:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = F
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            java.lang.Object r3 = r3.get(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            r4 = 8
            r5 = 3
            if (r3 == 0) goto L_0x01cc
            r6 = -1
            if (r11 == r5) goto L_0x0188
            r2 = 4
            if (r11 == r2) goto L_0x0183
            if (r11 == r4) goto L_0x017e
            r2 = 9
            if (r11 == r2) goto L_0x0179
            r2 = 13
            if (r11 == r2) goto L_0x0179
        L_0x0176:
            r4 = 0
            goto L_0x018e
        L_0x0179:
            int r2 = r27.readInt()
            goto L_0x018c
        L_0x017e:
            short r2 = r27.readShort()
            goto L_0x018c
        L_0x0183:
            long r6 = r27.a()
            goto L_0x0176
        L_0x0188:
            int r2 = r27.readUnsignedShort()
        L_0x018c:
            long r6 = (long) r2
            goto L_0x0176
        L_0x018e:
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x01c8
            int r2 = r1.f3322b
            long r4 = (long) r2
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x01c8
            java.util.Set<java.lang.Integer> r2 = r0.K
            int r4 = (int) r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x01b1
            r1.a(r6)
            int r2 = r3.intValue()
            r0.b((androidx.exifinterface.a.a.C0054a) r1, (int) r2)
            goto L_0x01c8
        L_0x01b1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Skip jump into the IFD since it has already been read: IfdType "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = " (at "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = ")"
            r2.append(r3)
        L_0x01c8:
            r1.a(r13)
            goto L_0x022f
        L_0x01cc:
            r6 = r24
            int r3 = (int) r6
            byte[] r3 = new byte[r3]
            r1.readFully(r3)
            androidx.exifinterface.a.a$b r6 = new androidx.exifinterface.a.a$b
            r6.<init>(r11, r12, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r3 = r0.J
            r3 = r3[r21]
            java.lang.String r7 = r2.f3329b
            r3.put(r7, r6)
            java.lang.String r3 = r2.f3329b
            java.lang.String r7 = "DNGVersion"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x01ee
            r0.I = r5
        L_0x01ee:
            java.lang.String r3 = r2.f3329b
            java.lang.String r5 = "Make"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x0202
            java.lang.String r3 = r2.f3329b
            java.lang.String r5 = "Model"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0210
        L_0x0202:
            java.nio.ByteOrder r3 = r0.L
            java.lang.String r3 = r6.c(r3)
            java.lang.String r5 = "PENTAX"
            boolean r3 = r3.contains(r5)
            if (r3 != 0) goto L_0x0223
        L_0x0210:
            java.lang.String r2 = r2.f3329b
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0225
            java.nio.ByteOrder r2 = r0.L
            int r2 = r6.b(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x0225
        L_0x0223:
            r0.I = r4
        L_0x0225:
            int r2 = r1.f3323c
            long r2 = (long) r2
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x022f
            r1.a(r13)
        L_0x022f:
            int r7 = r22 + 1
            short r7 = (short) r7
            r4 = r21
            r5 = r23
            goto L_0x002c
        L_0x0238:
            int r2 = r1.f3323c
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.f3322b
            if (r2 > r3) goto L_0x027b
            int r2 = r27.readInt()
            long r3 = (long) r2
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x027b
            int r5 = r1.f3322b
            if (r2 >= r5) goto L_0x027b
            java.util.Set<java.lang.Integer> r5 = r0.K
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r5.contains(r2)
            if (r2 != 0) goto L_0x027b
            r1.a(r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r2 = r0.J
            r9 = 4
            r2 = r2[r9]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x026c
            r4 = 4
            goto L_0x0006
        L_0x026c:
            java.util.HashMap<java.lang.String, androidx.exifinterface.a.a$b>[] r2 = r0.J
            r18 = 5
            r2 = r2[r18]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x027b
            r4 = 5
            goto L_0x0006
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.b(androidx.exifinterface.a.a$a, int):void");
    }

    private void c(C0054a aVar, int i2) throws IOException {
        b bVar;
        b bVar2 = this.J[i2].get("ImageLength");
        b bVar3 = this.J[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.J[i2].get("JPEGInterchangeFormat")) != null) {
            a(aVar, bVar.b(this.L), i2);
        }
    }

    private void a(C0054a aVar, HashMap hashMap) throws IOException {
        int i2;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int b2 = bVar.b(this.L);
            int min = Math.min(bVar2.b(this.L), aVar.available() - b2);
            int i3 = this.I;
            if (i3 == 4 || i3 == 9 || i3 == 10) {
                i2 = this.R;
            } else {
                if (i3 == 7) {
                    i2 = this.S;
                }
                if (b2 > 0 && min > 0) {
                    this.M = true;
                    this.N = b2;
                    this.O = min;
                    if (this.G == null && this.H == null) {
                        byte[] bArr = new byte[min];
                        aVar.a((long) b2);
                        aVar.readFully(bArr);
                        this.P = bArr;
                        return;
                    }
                    return;
                }
            }
            b2 += i2;
            if (b2 > 0) {
            }
        }
    }

    private void b(C0054a aVar, HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("StripOffsets");
        b bVar2 = (b) hashMap.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] a2 = a(bVar.a(this.L));
            long[] a3 = a(bVar2.a(this.L));
            if (a2 != null && a3 != null) {
                long j2 = 0;
                for (long j3 : a3) {
                    j2 += j3;
                }
                byte[] bArr = new byte[((int) j2)];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < a2.length; i4++) {
                    int i5 = (int) a2[i4];
                    int i6 = (int) a3[i4];
                    int i7 = i5 - i2;
                    aVar.a((long) i7);
                    int i8 = i2 + i7;
                    byte[] bArr2 = new byte[i6];
                    aVar.read(bArr2);
                    i2 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
                    i3 += bArr2.length;
                }
                this.M = true;
                this.P = bArr;
                this.O = bArr.length;
            }
        }
    }

    private boolean a(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.b(this.L) <= 512 && bVar2.b(this.L) <= 512;
    }

    private void b() throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.J[1].get("PixelXDimension");
        b bVar2 = this.J[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.J[0].put("ImageWidth", bVar);
            this.J[0].put("ImageLength", bVar2);
        }
        if (this.J[4].isEmpty() && a((HashMap) this.J[5])) {
            HashMap<String, b>[] hashMapArr = this.J;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        a((HashMap) this.J[4]);
    }

    private void d(C0054a aVar, int i2) throws IOException {
        b bVar;
        b bVar2;
        b bVar3 = this.J[i2].get("DefaultCropSize");
        b bVar4 = this.J[i2].get("SensorTopBorder");
        b bVar5 = this.J[i2].get("SensorLeftBorder");
        b bVar6 = this.J[i2].get("SensorBottomBorder");
        b bVar7 = this.J[i2].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f3325a == 5) {
                d[] dVarArr = (d[]) bVar3.a(this.L);
                if (dVarArr == null || dVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(dVarArr));
                    return;
                } else {
                    bVar2 = b.a(dVarArr[0], this.L);
                    bVar = b.a(dVarArr[1], this.L);
                }
            } else {
                int[] iArr = (int[]) bVar3.a(this.L);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    bVar2 = b.a(iArr[0], this.L);
                    bVar = b.a(iArr[1], this.L);
                }
            }
            this.J[i2].put("ImageWidth", bVar2);
            this.J[i2].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            c(aVar, i2);
        } else {
            int b2 = bVar4.b(this.L);
            int b3 = bVar6.b(this.L);
            int b4 = bVar7.b(this.L);
            int b5 = bVar5.b(this.L);
            if (b3 > b2 && b4 > b5) {
                b a2 = b.a(b3 - b2, this.L);
                b a3 = b.a(b4 - b5, this.L);
                this.J[i2].put("ImageLength", a2);
                this.J[i2].put("ImageWidth", a3);
            }
        }
    }

    /* renamed from: androidx.exifinterface.a.a$a  reason: collision with other inner class name */
    static class C0054a extends InputStream implements DataInput {

        /* renamed from: d  reason: collision with root package name */
        private static final ByteOrder f3319d = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: e  reason: collision with root package name */
        private static final ByteOrder f3320e = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        ByteOrder f3321a;

        /* renamed from: b  reason: collision with root package name */
        final int f3322b;

        /* renamed from: c  reason: collision with root package name */
        int f3323c;

        /* renamed from: f  reason: collision with root package name */
        private DataInputStream f3324f;

        public final String readLine() throws IOException {
            return null;
        }

        public C0054a(InputStream inputStream) throws IOException {
            this.f3321a = ByteOrder.BIG_ENDIAN;
            this.f3324f = new DataInputStream(inputStream);
            this.f3322b = this.f3324f.available();
            this.f3323c = 0;
            this.f3324f.mark(this.f3322b);
        }

        public C0054a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }

        public final void a(long j) throws IOException {
            int i2 = this.f3323c;
            if (((long) i2) > j) {
                this.f3323c = 0;
                this.f3324f.reset();
                this.f3324f.mark(this.f3322b);
            } else {
                j -= (long) i2;
            }
            int i3 = (int) j;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public final int available() throws IOException {
            return this.f3324f.available();
        }

        public final int read() throws IOException {
            this.f3323c++;
            return this.f3324f.read();
        }

        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f3324f.read(bArr, i2, i3);
            this.f3323c += read;
            return read;
        }

        public final int readUnsignedByte() throws IOException {
            this.f3323c++;
            return this.f3324f.readUnsignedByte();
        }

        public final boolean readBoolean() throws IOException {
            this.f3323c++;
            return this.f3324f.readBoolean();
        }

        public final char readChar() throws IOException {
            this.f3323c += 2;
            return this.f3324f.readChar();
        }

        public final String readUTF() throws IOException {
            this.f3323c += 2;
            return this.f3324f.readUTF();
        }

        public final void readFully(byte[] bArr, int i2, int i3) throws IOException {
            this.f3323c += i3;
            if (this.f3323c > this.f3322b) {
                throw new EOFException();
            } else if (this.f3324f.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final void readFully(byte[] bArr) throws IOException {
            this.f3323c += bArr.length;
            if (this.f3323c > this.f3322b) {
                throw new EOFException();
            } else if (this.f3324f.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final byte readByte() throws IOException {
            this.f3323c++;
            if (this.f3323c <= this.f3322b) {
                int read = this.f3324f.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final short readShort() throws IOException {
            this.f3323c += 2;
            if (this.f3323c <= this.f3322b) {
                int read = this.f3324f.read();
                int read2 = this.f3324f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f3321a;
                    if (byteOrder == f3319d) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f3320e) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f3321a);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final int readInt() throws IOException {
            this.f3323c += 4;
            if (this.f3323c <= this.f3322b) {
                int read = this.f3324f.read();
                int read2 = this.f3324f.read();
                int read3 = this.f3324f.read();
                int read4 = this.f3324f.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f3321a;
                    if (byteOrder == f3319d) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f3320e) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f3321a);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.f3322b - this.f3323c);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f3324f.skipBytes(min - i3);
            }
            this.f3323c += i3;
            return i3;
        }

        public final int readUnsignedShort() throws IOException {
            this.f3323c += 2;
            if (this.f3323c <= this.f3322b) {
                int read = this.f3324f.read();
                int read2 = this.f3324f.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f3321a;
                    if (byteOrder == f3319d) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f3320e) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f3321a);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final long a() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public final long readLong() throws IOException {
            this.f3323c += 8;
            if (this.f3323c <= this.f3322b) {
                int read = this.f3324f.read();
                int read2 = this.f3324f.read();
                int read3 = this.f3324f.read();
                int read4 = this.f3324f.read();
                int read5 = this.f3324f.read();
                int read6 = this.f3324f.read();
                int read7 = this.f3324f.read();
                int read8 = this.f3324f.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f3321a;
                    if (byteOrder == f3319d) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i2 = read2;
                    if (byteOrder == f3320e) {
                        return (((long) read) << 56) + (((long) i2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f3321a);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    private void a(int i2, int i3) throws IOException {
        if (!this.J[i2].isEmpty() && !this.J[i3].isEmpty()) {
            b bVar = this.J[i2].get("ImageLength");
            b bVar2 = this.J[i2].get("ImageWidth");
            b bVar3 = this.J[i3].get("ImageLength");
            b bVar4 = this.J[i3].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int b2 = bVar.b(this.L);
                int b3 = bVar2.b(this.L);
                int b4 = bVar3.b(this.L);
                int b5 = bVar4.b(this.L);
                if (b2 < b4 && b3 < b5) {
                    HashMap<String, b>[] hashMapArr = this.J;
                    HashMap<String, b> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
