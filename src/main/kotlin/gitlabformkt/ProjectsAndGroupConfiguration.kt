package gitlabformkt

import kotlinx.serialization.Serializable

@Serializable
class ProjectsAndGroupConfiguration(private val name: String) {

}

fun projectsAndGroupConfiguration(name: String, block: ProjectsAndGroupConfiguration.() -> Unit) {
    ProjectsAndGroupConfiguration(name).apply(block)
}

