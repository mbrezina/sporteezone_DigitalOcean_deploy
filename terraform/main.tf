provider "digitalocean" {
  token = var.do_token
}

data "digitalocean_ssh_key" "example" {
  name = var.ssh_key_name
}

resource "digitalocean_vpc" "vpc" {
  name     = "sporteezone-project-network"
  region   = var.region
  ip_range = "10.2.0.0/16"
}

resource "digitalocean_droplet" "server" {
  image  = "ubuntu-20-04-x64"
  name   = "server-sporteezones"
  region = var.region
  size   = "s-2vcpu-2gb"
  vpc_uuid = digitalocean_vpc.vpc.id
  ssh_keys = [data.digitalocean_ssh_key.example.id]

  connection {
    host = self.ipv4_address
    user = "root"
    type = "ssh"
    agent = true
    timeout = "2m"
  }

  provisioner "remote-exec" {
    script = "install-docker.sh"
  }

  provisioner "remote-exec" {
    script = "run-docker-containers.sh"
  }
}

resource "digitalocean_database_cluster" "mysql" {
  name       = "sporteezone-mysql-cluster"
  engine     = "mysql"
  version    = "8"
  size       = "db-s-1vcpu-1gb"
  region     = var.region
  node_count = 1
  private_network_uuid = digitalocean_vpc.vpc.id
}

resource "digitalocean_project" "sporteezone-do-deployment" {
  name        = "sporteezone-do-deployment"
  environment = "Development"
  resources   = [
    digitalocean_droplet.server.urn,
    digitalocean_database_cluster.mysql.urn,
  ]
}
