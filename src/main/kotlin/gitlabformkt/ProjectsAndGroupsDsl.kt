package gitlabformkt

import kotlinx.serialization.Serializable

@Serializable
class ProjectsAndGroupsDsl {

    private val projectsAndGroupConfigurations: MutableMap<String, ProjectsAndGroupConfiguration> = mutableMapOf()

    operator fun String.invoke(block: ProjectsAndGroupConfiguration.() -> Unit) {
        val config = ProjectsAndGroupConfiguration().apply(block)
        this@ProjectsAndGroupsDsl.projectsAndGroupConfigurations[this] = config
    }

}
