package me.bossm0n5t3r.advanced.chapter01

object Exercise01 {
    private fun takeIntList(list: List<Int>) {}

    fun example01() {
//        takeIntList(listOf<Any>()) // Can't compile
        takeIntList(listOf<Nothing>())
    }

    private fun takeIntMutableList(list: MutableList<Int>) {}

    fun example02() {
//        takeIntMutableList(mutableListOf<Any>()) // Can't compile
//        takeIntMutableList(mutableListOf<Nothing>()) // Can't compile
    }

    private fun takeAnyList(list: List<Any>) {}

    fun example03() {
        takeAnyList(listOf<Int>())
        takeAnyList(listOf<Nothing>())
    }

    class BoxOut<out T>

    private fun takeBoxOutInt(box: BoxOut<Int>) {}

    fun example04() {
        takeBoxOutInt(BoxOut<Int>())
//        takeBoxOutInt(BoxOut<Number>()) // Can't compile
        takeBoxOutInt(BoxOut<Nothing>())
    }

    private fun takeBoxOutNumber(box: BoxOut<Number>) {}

    fun example05() {
        takeBoxOutNumber(BoxOut<Int>())
        takeBoxOutNumber(BoxOut<Number>())
        takeBoxOutNumber(BoxOut<Nothing>())
    }

    private fun takeBoxOutNothing(box: BoxOut<Nothing>) {}

    fun example06() {
//        takeBoxOutNothing(BoxOut<Int>()) // Can't compile
//        takeBoxOutNothing(BoxOut<Number>()) // Can't compile
        takeBoxOutNothing(BoxOut<Nothing>())
    }

    private fun takeBoxOutStar(box: BoxOut<*>) {}

    fun example07() {
        takeBoxOutStar(BoxOut<Int>())
        takeBoxOutStar(BoxOut<Number>())
        takeBoxOutStar(BoxOut<Nothing>())
    }

    class BoxIn<in T>

    private fun takeBoxInInt(box: BoxIn<Int>) {}

    fun example08() {
        takeBoxInInt(BoxIn<Int>())
        takeBoxInInt(BoxIn<Number>())
//        takeBoxInInt(BoxIn<Nothing>()) // Can't compile
        takeBoxInInt(BoxIn<Any>())
    }
}
