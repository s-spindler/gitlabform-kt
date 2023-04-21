package gitlabformkt

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ProjectsAndGroupConfiguration.ProjectsAndGroupConfigurationSerializer::class)
class ProjectsAndGroupConfiguration {

    private val branches: MutableList<BranchDsl> = mutableListOf()

    fun branches(vararg branches: BranchDsl) {
        this.branches.addAll(branches)
    }

    object ProjectsAndGroupConfigurationSerializer : KSerializer<ProjectsAndGroupConfiguration> {

        private val mapSerializer = MapSerializer(String.serializer(), BranchDsl.serializer())

        override val descriptor: SerialDescriptor = mapSerializer.descriptor

        override fun deserialize(decoder: Decoder): ProjectsAndGroupConfiguration {
            throw IllegalStateException("Deserialzation is not allowed for " + this::javaClass.name)
        }

        override fun serialize(encoder: Encoder, value: ProjectsAndGroupConfiguration) {
            val asMap = value.branches.associateBy { it.name }
            mapSerializer.serialize(encoder, asMap)
        }

    }

}
