package gitlabformkt

class BranchesDsl {

}

open class BranchDsl(private val name: String) {

    fun unprotected() = UnprotectedBranchDsl(name)

    fun protected(block: ProtectedBranchDsl.() -> Unit): ProtectedBranchDsl {
        val protectedBranchDsl = ProtectedBranchDsl(name)
        protectedBranchDsl.apply(block)
        return protectedBranchDsl
    }
}

class UnprotectedBranchDsl(name: String) : BranchDsl(name)

class ProtectedBranchDsl(name: String) : BranchDsl(name) {

    var pushAccessLevel: AccessLevel? = null

    var mergeAccessLevel: AccessLevel? = null

    var unprotectAccessLevel: AccessLevel? = null

}

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

fun branches(vararg branches: BranchDsl): BranchesDsl {
    return BranchesDsl()
}

fun branch(name: String): BranchDsl {
    return BranchDsl(name)
}
