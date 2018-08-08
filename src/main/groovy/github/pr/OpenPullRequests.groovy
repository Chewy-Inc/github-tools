package github.pr

import github.base.GroovyGitHub

GroovyGitHub.session {
    organization('Chewy-Inc') {
        repository('backoffice') {
            pullRequests.OPEN.each {
                println "Pull request $it.number is $it.mergeableState"
                println "  Authored by ${it.user.name ?: it.user.login}: ${it.title}"
                // GET /repos/:owner/:repo/pulls/:number/reviews
                it.reviews.CHANGES_REQUESTED.each {
                    println "    Changes requested by: ${it.user.name ?: it.user.login}"
                }
                it.reviews.APPROVED.each {
                    println "    Approved by: ${it.user.name ?: it.user.login}"
                }
            }
        }
    }
}

