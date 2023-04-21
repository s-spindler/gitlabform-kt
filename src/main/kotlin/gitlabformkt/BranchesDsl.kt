package gitlabformkt

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class BranchDsl(@Transient open val name: String = "") {

    fun unprotected() = UnprotectedBranchDsl(name)

    fun protected(block: ProtectedBranchDsl.() -> Unit): ProtectedBranchDsl {
        val protectedBranchDsl = ProtectedBranchDsl(name)
        protectedBranchDsl.apply(block)
        return protectedBranchDsl
    }
}

@Serializable
class UnprotectedBranchDsl(override val name: String) : BranchDsl(name) {
    val protected = false
}

@Serializable
class ProtectedBranchDsl(override val name: String) : BranchDsl(name) {

    val protected = true

    var pushAccessLevel: AccessLevel? = null

    var mergeAccessLevel: AccessLevel? = null

    var unprotectAccessLevel: AccessLevel? = null

}

@Serializable
enum class AccessLevel {
    no_access,
    minimal_access,
    guest,
    reporter,
    developer,
    maintainer,
    owner;

    override fun toString(): String {
        return this.name.replace('_', ' ')
    }
}

fun branch(name: String): BranchDsl {
    return BranchDsl(name)
}
