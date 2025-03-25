package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability07 {
    annotation class A

    annotation class B

    @A
    class User
        @B
        constructor(
            val name: String,
        )

//    public static final class User {
//        @NotNull
//        private final String name;
//
//        @JavaInteroperability07.B
//        public User(@NotNull String name) {
//            Intrinsics.checkNotNullParameter(name, "name");
//            super();
//            this.name = name;
//        }
//
//        @NotNull
//        public final String getName() {
//            return this.name;
//        }
//    }
}
