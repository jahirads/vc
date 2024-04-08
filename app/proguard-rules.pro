# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-flattenpackagehierarchy
-ignorewarnings

-keep class freecall.videocall.freelivechat.global.livecall.adx12s51cd5.** { *; }
-keep class freecall.videocall.freelivechat.global.livecall.fc2ds63526.** { *; }
-keep class freecall.videocall.freelivechat.global.livecall.s2d1s31d.** { *; }
-keep class freecall.videocall.freelivechat.global.livecall.szxd4s545.** { *; }

-keep class com.ads.sdk.cgvfd5g4v1.** { *; }
-keep class com.ads.sdk.dsdsd1s513.** { *; }
-keep class com.ads.sdk.dsf4d5.** { *; }
-keep class com.ads.sdk.sfdsf1.** { *; }

-keep class dev.shreyaspatil.easyupipayment.exception.* { *; }
-keep class dev.shreyaspatil.easyupipayment.listener.* { *; }
-keep class dev.shreyaspatil.easyupipayment.model.* { *; }
-keep class dev.shreyaspatil.easyupipayment.ui.* { *; }

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int w(...);
    public static int i(...);
    public static int d(...);
    public static int e(...);
}