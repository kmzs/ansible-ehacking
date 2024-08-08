#!/usr/bin/env bash
set -e

if ! command -v ansible-playbook &> /dev/null || ! command -v git &> /dev/null; then
    echo "### Updating Packages"
    sudo apt update
    echo "### Installing ansible and git"
    sudo apt install -y ansible git
else
    echo "### Ansible and git already installed, skipping installation..."
fi
if [ ! -d "ansible-ehacking" ]; then
    echo "### Cloning Git Repository"
    git clone --depth 1 https://git.noc.ruhr-uni-bochum.de/CheariX/ansible-ehacking.git
    cd ansible-ehacking
else
    echo "### Git repository already exists, updating..."
    cd ansible-ehacking
    git pull
fi
echo "### Deployment via ansible"
sudo ansible-playbook -c local -i localhost, provisioning/playbook.yml --skip-tags="postman"