#!/usr/bin/env python3
from passlib.hash import sha512_crypt

hash = sha512_crypt.using(rounds=5000).hash("toor")
print(f"Passwordhash for 'toor': {hash}")
hash = sha512_crypt.using(rounds=5000).hash("kali")
print(f"Passwordhash for 'kali': {hash}")