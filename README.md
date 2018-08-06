# GitHub API tools in Groovy

with thanks to https://github.com/melix/grithub

## Setup

To use the Kohsuke GitHub API you'll want to set up a SSO-authorized GitHub API token and put it in the file ~/.github with the line:
`oauth=<token>`
  
## Operation

At this stage, the project is using the Gradle application plugin to target and run a main class. Change `build.gradle:mainClassName` to target the class you want to run.
  
OpenPullRequests.groovy dumps all open PRs and their authors. In the future we can easily add sorts for created_at or updated_at, or number of changed files. It would also be easy to add a filter for mergeable PRs, to aid in release planning.

MyCommits.groovy mines all closed PRs for review comments and filters them by a specified GitHub login. My purpose here was to generate a list of my own comments, so that I could compare them to our PR best practices. In this way we can each see if we’ve been flagging anything that hasn’t been documented there. 
