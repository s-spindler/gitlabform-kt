package gitlabformkt

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class GitLabFormDsl {

    private var gitlab: GitLabDsl? = null
    private var skipGroups: SkipDsl? = null
    private var skipProjects: SkipDsl? = null
    private var projectsAndGroups: ProjectsAndGroupsDsl? = null

    fun gitlab(block: GitLabDsl.() -> Unit) {
        this.gitlab = this.gitlab ?: GitLabDsl().apply(block)
    }

    fun projectsAndGroups(block: ProjectsAndGroupsDsl.() -> Unit) {
        this.projectsAndGroups = this.projectsAndGroups ?: ProjectsAndGroupsDsl().apply(block)
    }

    fun skipGroups(block: SkipDsl.() -> Unit) {
        this.skipGroups = this.skipGroups ?: SkipDsl().apply(block)
    }

    fun skipProjects(block: SkipDsl.() -> Unit) {
        this.skipProjects = this.skipProjects ?: SkipDsl().apply(block)
    }

    fun println() = println(Json.encodeToString(this))

}

fun gitlabForm(block: GitLabFormDsl.() -> Unit) = GitLabFormDsl().apply(block)
