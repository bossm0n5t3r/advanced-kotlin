package me.bossm0n5t3r.advanced.chapter05

object JavaInteroperability19 {
    @JvmRecord
    data class Person(
        val name: String,
        val age: Int,
    )

//    public static record Person(String name, int age) {
//        public Person(@NotNull String name, int age) {
//            Intrinsics.checkNotNullParameter(name, "name");
//            super();
//            this.name = name;
//            this.age = age;
//        }
//
//        @NotNull
//        public final String name() {
//            return this.name;
//        }
//
//        @NotNull
//        public final String component1() {
//            return this.name;
//        }
//
//        public final int component2() {
//            return this.age;
//        }
//
//        @NotNull
//        public final Person copy(@NotNull String name, int age) {
//            Intrinsics.checkNotNullParameter(name, "name");
//            return new Person(name, age);
//        }
//
//        // $FF: synthetic method
//        public static Person copy$default(Person var0, String var1, int var2, int var3, Object var4) {
//            if ((var3 & 1) != 0) {
//            var1 = var0.name;
//        }
//
//            if ((var3 & 2) != 0) {
//            var2 = var0.age;
//        }
//
//            return var0.copy(var1, var2);
//        }
//
//        @NotNull
//        public String toString() {
//            return "Person(name=" + this.name + ", age=" + this.age + ')';
//        }
//
//        public int hashCode() {
//            int result = this.name.hashCode();
//            result = result * 31 + Integer.hashCode(this.age);
//            return result;
//        }
//
//        public boolean equals(@Nullable Object other) {
//            if (this == other) {
//                return true;
//            } else if (!(other instanceof Person)) {
//                return false;
//            } else {
//                Person var2 = (Person)other;
//                if (!Intrinsics.areEqual(this.name, var2.name)) {
//                    return false;
//                } else {
//                    return this.age == var2.age;
//                }
//            }
//        }
//    }
}
