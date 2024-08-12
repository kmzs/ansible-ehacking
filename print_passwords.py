#!/usr/bin/env python3
from passlib.hash import sha512_crypt

for pw in [ "toor", "kali", "student" ]:
    hash = sha512_crypt.using(rounds=5000).hash("toor")
    print(f"Passwordhash for '{pw}': {hash}")