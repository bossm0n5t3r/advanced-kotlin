package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability13 {
    class User {
        var name = "ABC"
        var isAdult = true
    }

//    public static final class User {
//        @NotNull
//        private String name = "ABC";
//        private boolean isAdult = true;
//
//        @NotNull
//        public final String getName() {
//            return this.name;
//        }
//
//        public final void setName(@NotNull String var1) {
//            Intrinsics.checkNotNullParameter(var1, "<set-?>");
//            this.name = var1;
//        }
//
//        public final boolean isAdult() {
//            return this.isAdult;
//        }
//
//        public final void setAdult(boolean var1) {
//            this.isAdult = var1;
//        }
//    }
}
