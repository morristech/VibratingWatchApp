workflow "New workflow" {
  on = "push"
  resolves = ["GitHub Action for Google Cloud"]
}

action "GitHub Action for Google Cloud" {
  uses = "actions/gcloud/cli@8ec8bfa"
  secrets = ["GITHUB_TOKEN"]
}
