package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability03 {
    fun readOnlyList(): List<Int> = listOf(1, 2, 3)

    fun mutableList(): MutableList<Int> = mutableListOf(1, 2, 3)

//    @NotNull
//    public final List readOnlyList() {
//        Integer[] var1 = new Integer[]{1, 2, 3};
//        return CollectionsKt.listOf(var1);
//    }
//
//    @NotNull
//    public final List mutableList() {
//        Integer[] var1 = new Integer[]{1, 2, 3};
//        return CollectionsKt.mutableListOf(var1);
//    }
}
