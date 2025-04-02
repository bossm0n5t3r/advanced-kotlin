package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.typeOf

object Exercise01FunctionCaller {
    class FunctionCaller {
        private val constants = mutableMapOf<KType, Any?>()

        inline fun <reified T> setConstant(value: T) {
            setConstant(typeOf<T>(), value)
        }

        fun setConstant(
            type: KType,
            value: Any?,
        ) {
            constants[type] = value
        }

        fun <T> call(function: KFunction<T>): T {
            val args =
                function.parameters
                    .filter { constants.containsKey(it.type) }
                    .associateWith { param ->
                        val type = param.type
                        val value = constants[type]
                        require(param.isOptional || value != null) {
                            "No value provided for parameter ${param.name} of type $type"
                        }
                        value
                    }
            return function.callBy(args = args)
        }
    }
}
