package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability14 {
    @JvmName("averageLongList")
    fun List<Long>.average() = sum().toDouble() / size

    @JvmName("averageIntList")
    fun List<Int>.average() = sum().toDouble() / size

    fun main() {
        val ints: List<Int> = List(10) { it }
        println(ints.average()) // 4.5
        val longs: List<Long> = List(10) { it.toLong() }
        println(longs.average()) // 4.5
    }

//    public final void main() {
//        byte longs = 10;
//        ArrayList var3 = new ArrayList(longs);
//
//        for(int var4 = 0; var4 < longs; ++var4) {
//            int it = 0;
//            Integer var10 = var4;
//            var3.add(var10);
//        }
//
//        List ints = (List)var3;
//        double var11 = this.averageIntList(ints);
//        System.out.println(var11);
//        byte var13 = 10;
//        ArrayList var15 = new ArrayList(var13);
//
//        for(int var5 = 0; var5 < var13; ++var5) {
//            int var8 = 0;
//            Long var16 = (long)var5;
//            var15.add(var16);
//        }
//
//        List longs = (List)var15;
//        double var14 = this.averageLongList(longs);
//        System.out.println(var14);
//    }
}
