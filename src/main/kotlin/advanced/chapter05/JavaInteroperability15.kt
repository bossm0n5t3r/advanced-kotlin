package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability15 {
    class Pizza(
        val tomatoSauce: Int = 1,
        val cheese: Int = 0,
        val ham: Int = 0,
        val onion: Int = 0,
    )

    class EmailSender {
        fun send(
            receiver: String,
            title: String = "",
            message: String = "",
        ) {
            // ...
        }
    }

//    public static final class Pizza {
//        private final int tomatoSauce;
//        private final int cheese;
//        private final int ham;
//        private final int onion;
//
//        public Pizza(int tomatoSauce, int cheese, int ham, int onion) {
//            this.tomatoSauce = tomatoSauce;
//            this.cheese = cheese;
//            this.ham = ham;
//            this.onion = onion;
//        }
//
//        // $FF: synthetic method
//        public Pizza(int var1, int var2, int var3, int var4, int var5, DefaultConstructorMarker var6) {
//            if ((var5 & 1) != 0) {
//                var1 = 1;
//            }
//
//            if ((var5 & 2) != 0) {
//                var2 = 0;
//            }
//
//            if ((var5 & 4) != 0) {
//                var3 = 0;
//            }
//
//            if ((var5 & 8) != 0) {
//                var4 = 0;
//            }
//
//            this(var1, var2, var3, var4);
//        }
//
//        public final int getTomatoSauce() {
//            return this.tomatoSauce;
//        }
//
//        public final int getCheese() {
//            return this.cheese;
//        }
//
//        public final int getHam() {
//            return this.ham;
//        }
//
//        public final int getOnion() {
//            return this.onion;
//        }
//
//        public Pizza() {
//            this(0, 0, 0, 0, 15, (DefaultConstructorMarker)null);
//        }
//    }
//
//    public static final class EmailSender {
//        public final void send(@NotNull String receiver, @NotNull String title, @NotNull String message) {
//            Intrinsics.checkNotNullParameter(receiver, "receiver");
//            Intrinsics.checkNotNullParameter(title, "title");
//            Intrinsics.checkNotNullParameter(message, "message");
//        }
//
//        // $FF: synthetic method
//        public static void send$default(EmailSender var0, String var1, String var2, String var3, int var4, Object var5) {
//            if ((var4 & 2) != 0) {
//                var2 = "";
//            }
//
//            if ((var4 & 4) != 0) {
//                var3 = "";
//            }
//
//            var0.send(var1, var2, var3);
//        }
//    }
}
