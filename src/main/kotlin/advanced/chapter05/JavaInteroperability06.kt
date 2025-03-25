package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability06 {
    annotation class A

    class User {
        @A
        val name = "ABC"
    }

//    public static final class User {
//        @NotNull
//        private final String name = "ABC";
//
//        @NotNull
//        public final String getName() {
//            return this.name;
//        }
//
//        /** @deprecated */
//        // $FF: synthetic method
//        @JavaInteroperability06.A
//        public static void getName$annotations() {
//        }
//    }
}
