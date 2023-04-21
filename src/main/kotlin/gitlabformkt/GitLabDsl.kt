package gitlabformkt

import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Serializable
class GitLabDsl {

    private var url: String? = null
    private var token: String? = null
    private var verify: Boolean = true
    private var timeout: Duration = 10.seconds

    fun url(url: String) {
        this.url = url
    }

    fun token(token: String) {
        this.token = token
    }

    fun sslVerify(verify: Boolean) {
        this.verify = verify
    }

    fun timeout(timeout: Duration) {
        this.timeout = timeout
    }

}
