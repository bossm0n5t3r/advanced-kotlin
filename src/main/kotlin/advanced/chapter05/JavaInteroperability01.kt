package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability01 {
    class MessageSender {
        fun sendMessage(
            title: String,
            content: String?,
        ) {}
    }

    // public static final class MessageSender {
    //    public final void sendMessage(@NotNull String title, @Nullable String content) {
    //       Intrinsics.checkNotNullParameter(title, "title");
    //    }
    // }
}
