package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability18 {
    fun a(): Unit = Unit

    fun main() {
        println(a()) // kotlin.Unit
    }

//    public final void a() {
//    }
//
//    public final void main() {
//        this.a();
//        Unit var1 = Unit.INSTANCE;
//        System.out.println(var1);
//    }
}
