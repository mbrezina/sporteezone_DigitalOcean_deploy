// your DigitalOcean API token
variable "do_token" {}

// name (in DO) of the SSH key that will be deployed to the provisioned Droplet
variable "ssh_key_name" {}

// DigitalOcean region where the resources will be created
variable "region" {}
