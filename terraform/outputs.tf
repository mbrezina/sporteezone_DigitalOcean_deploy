output "instance_ip" {
  value = digitalocean_droplet.server.ipv4_address
}

output "db_ip" {
  value = digitalocean_database_cluster.mysql.host
}