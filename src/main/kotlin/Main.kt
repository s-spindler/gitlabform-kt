import gitlabformkt.gitlabForm
import kotlin.time.Duration.Companion.seconds

fun main(args: Array<String>) {
    val gf = gitlabForm {
        gitlab {
            url("https://gitlab.yourcompany.com")
            token("<private token of an admin user>")
            sslVerify(true)
            timeout(10.seconds)
        }

//        projectsAndGroups {
//            common()
//            allInGroup()
//            projects()
//        }
    }

    gf.println()
}
