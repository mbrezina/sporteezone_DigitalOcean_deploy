
// your DigitalOcean API token
variable "do_token" {
  default = "59a542a2f12909543515000637385bacbb04a15687e7189861d54dc1f070848d"
}

// name (in DO) of the SSH key that will be deployed to the provisioned Droplet
variable "ssh_key_name" {
  default = "martinab"
}

// DigitalOcean region where the resources will be created
variable "region" {
  default = "ams3"
}
