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

        skipProjects {
            +"my-group/this-project-will-not-be-processed-with-gitlabform"
            +"my-group/and-this-project0too"
            +"my-group/everything-under/*"
        }

        skipGroups {
            +"my-other-group"
            +"this-group-and-all-sub-groups/*"
        }
    }

    gf.println()
}
