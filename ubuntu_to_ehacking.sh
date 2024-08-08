#!/usr/bin/env bash

# echo "### Updating Packages"
# sudo apt update
# echo "### Installing ansible"
# sudo apt install -y ansible
echo "### Deployment via ansible"
ansible-playbook -c local -i localhost, provisioning/playbook.yml --skip-tags="postman"