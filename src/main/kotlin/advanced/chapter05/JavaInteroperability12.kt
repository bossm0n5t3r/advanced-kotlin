package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability12 {
    class MainWindow {
        // ...

        companion object {
            const val SIZE = 10
        }
    }

//    public static final class MainWindow {
//        @NotNull
//        public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
//        public static final int SIZE = 10;
//
//        public static final class Companion {
//            private Companion() {
//            }
//
//            // $FF: synthetic method
//            public Companion(DefaultConstructorMarker $constructor_marker) {
//                this();
//            }
//        }
//    }
}
