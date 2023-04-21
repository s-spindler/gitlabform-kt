package gitlabformkt

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class GitLabFormDsl {

    private var gitlab: GitLabDsl? = null

    fun gitlab(block: GitLabDsl.() -> Unit) {
        this.gitlab= this.gitlab ?: GitLabDsl().apply(block)
    }

    fun println() = println(Json.encodeToString(this))

}

fun gitlabForm(block: GitLabFormDsl.() -> Unit) = GitLabFormDsl().apply(block)
