package gitlabformkt

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = SkipDsl.SkipDslSerializer::class)
class SkipDsl {

    private var elementsToSkip: MutableList<String> = mutableListOf()

    operator fun String.unaryPlus() = this@SkipDsl.elementsToSkip.add(this)

    object SkipDslSerializer : KSerializer<SkipDsl> {

        private val listSerializer = ListSerializer(String.serializer())

        override val descriptor: SerialDescriptor = listSerializer.descriptor

        override fun deserialize(decoder: Decoder): SkipDsl {
            throw IllegalStateException("Deserialzation is not allowed for " + this::javaClass.name)
        }

        override fun serialize(encoder: Encoder, value: SkipDsl) {
            listSerializer.serialize(encoder, value.elementsToSkip)
        }

    }

}
