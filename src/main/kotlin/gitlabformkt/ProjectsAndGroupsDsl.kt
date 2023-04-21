package gitlabformkt

import kotlinx.serialization.Serializable

@Serializable
class ProjectsAndGroupsDsl {

    private val projectsAndGroupConfigurations: MutableList<ProjectsAndGroupConfiguration> = mutableListOf()

    operator fun String.unaryPlus(): ProjectsAndGroupConfiguration {
        val config = ProjectsAndGroupConfiguration(this)
        this@ProjectsAndGroupsDsl.projectsAndGroupConfigurations.add(config)
        return config
    }

    operator fun String.invoke(block: ProjectsAndGroupConfiguration.() -> Unit) {
        val config = ProjectsAndGroupConfiguration(this).apply(block)
        this@ProjectsAndGroupsDsl.projectsAndGroupConfigurations.add(config)
    }

}
