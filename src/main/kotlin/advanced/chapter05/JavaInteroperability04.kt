package me.bossm0n5t3r.advanced.chapter05

import kotlin.properties.Delegates.notNull

object JavaInteroperability04 {
    class User {
        var name = "ABC" // getter, setter, field
        var surname: String by notNull() // getter, setter, delegate
        val fullName: String // only getter
            get() = "$name $surname"
    }

//    public static final class User {
//        // $FF: synthetic field
//        static final KProperty[] $$delegatedProperties;
//        @NotNull
//        private String name = "ABC";
//        @NotNull
//        private final ReadWriteProperty surname$delegate;
//
//        public User() {
//            this.surname$delegate = Delegates.INSTANCE.notNull();
//        }
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
//        @NotNull
//        public final String getSurname() {
//            return (String)this.surname$delegate.getValue(this, $$delegatedProperties[0]);
//        }
//
//        public final void setSurname(@NotNull String var1) {
//            Intrinsics.checkNotNullParameter(var1, "<set-?>");
//            this.surname$delegate.setValue(this, $$delegatedProperties[0], var1);
//        }
//
//        @NotNull
//        public final String getFullName() {
//            return this.name + ' ' + this.getSurname();
//        }
//
//        static {
//            KProperty[] var0 = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(User.class, "surname", "getSurname()Ljava/lang/String;", 0)))};
//            $$delegatedProperties = var0;
//        }
//    }
}
