resource "digitalocean_firewall" "fw" {
    name = "only-22-and-services"

    droplet_ids = [
        digitalocean_droplet.server.id]

    inbound_rule {
        protocol = "tcp"
        port_range = "22"
        source_addresses = [
            "0.0.0.0/0",
            "::/0"]
    }

    inbound_rule {
        protocol = "tcp"
        port_range = "80"
        source_addresses = [
            "0.0.0.0/0",
            "::/0"]
    }

    inbound_rule {
        protocol = "tcp"
        port_range = "8080"
        source_addresses = [
            "0.0.0.0/0",
            "::/0"]
    }

    outbound_rule {
        protocol = "tcp"
        port_range = "1-65535"
        destination_addresses = [
            "0.0.0.0/0", "::/0"]
    }

    outbound_rule {
        protocol = "udp"
        port_range = "1-65535"
        destination_addresses = [
            "0.0.0.0/0", "::/0"]
    }

    #inbound_rule {
    #  protocol         = "tcp"
    #  port_range       = "8082"
    #  source_addresses = ["0.0.0.0/0", "::/0"]
    #}

}

resource "digitalocean_database_firewall" "db-fw" {
    cluster_id = digitalocean_database_cluster.mysql.id

    rule {
        type = "droplet"
        value = digitalocean_droplet.server.id
    }
}

