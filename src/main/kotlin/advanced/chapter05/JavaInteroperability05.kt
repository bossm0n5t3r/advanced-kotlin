package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability05 {
    annotation class A

    annotation class B

    annotation class C

    annotation class D

    annotation class E

    class User {
        @property:A
        @get:B
        @set:C
        @field:D
        @setparam:E
        var name = "ABC"
    }

//    public static final class User {
//        @JavaInteroperability05.D
//        @NotNull
//        private String name = "ABC";
//
//        @JavaInteroperability05.B
//        @NotNull
//        public final String getName() {
//            return this.name;
//        }
//
//        @JavaInteroperability05.C
//        public final void setName(@JavaInteroperability05.E @NotNull String var1) {
//            Intrinsics.checkNotNullParameter(var1, "<set-?>");
//            this.name = var1;
//        }
//
//        /** @deprecated */
//        // $FF: synthetic method
//        @JavaInteroperability05.A
//        public static void getName$annotations() {
//        }
//    }
}
