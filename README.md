# NOTE: we haved moved to github

This is the currently supported repository.

# eHacking Installation Script using ansible

This repository is meant to transform a basic Ubuntu system into a hacking platform. Previously, we used to deploy a Virtualbox image, but with the rise of different architectures, such as aarch64 (MacBook Silicon), and the variety of hypervisors, this was becoming a tough task.

The idea of this project is to transform a clean installation on any hypervisor into a hacking platform. All necessary software will be automatically deployed and installed using Ansible.

# Installation

Using wget:

```sh
wget -qO- https://github.com/eHacking-WebSec/ansible-ehacking/-/raw/main/ubuntu_to_ehacking.sh?ref_type=heads | bash
```

Using curl:

```sh
curl -s https://github.com/eHacking-WebSec/ansible-ehacking/-/raw/main/ubuntu_to_ehacking.sh?ref_type=heads | bash
```

# Successfully tested operating systems

- Ubuntu 22.04 LTS
- Ubuntu 24.04 LTS
- Kali Linux 2024.02

# Known Bugs

- [ ] Import of self-signed certificates into Firefox and Chromium store does not seem to work

# Future Work

- [ ] Test Kubuntu 22.04 LTS
- [ ] Test Kubuntu 24.04 LTS
- [ ] Test additional Ubuntu variants
- [ ] Maybe support Debian?
- [ ] Maybe support Fedora?
