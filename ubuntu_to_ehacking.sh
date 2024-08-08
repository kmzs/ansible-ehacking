#!/usr/bin/env bash
set -e

echo "### Updating Packages"
sudo apt update
echo "### Installing ansible"
sudo apt install -y ansible git
echo "### Cloning Git Repository"
if [ ! -d "ansible-ehacking" ]; then
    echo "### Cloning Git Repository"
git clone --depth 1 https://git.noc.ruhr-uni-bochum.de/CheariX/ansible-ehacking.git
else
    echo "### Git repository already exists, updating..."
    cd ansible-ehacking
    git pull origin master
fi
echo "### Deployment via ansible"
ansible-playbook -c local -i localhost, provisioning/playbook.yml --skip-tags="postman"