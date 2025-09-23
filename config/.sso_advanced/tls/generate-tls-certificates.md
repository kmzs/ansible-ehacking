# Generate CA key and certificate
openssl genrsa -out hackmanit-ca.key 4096
openssl req -x509 -new -nodes -key hackmanit-ca.key -sha256 -days 3650 -extensions v3_req -config tls-cert-ca.conf -out hackmanit-ca.crt

# Generate IdP key and certificate request
openssl genrsa -out idp.example.key 4096
openssl req -new -sha256 -key idp.example.key -extensions v3_req -config tls-cert-idp.conf -out idp.example.csr

# Generate IdP certificate
openssl x509 -req -in idp.example.csr -CA hackmanit-ca.crt -CAkey hackmanit-ca.key -CAcreateserial -days 3650 -sha256 -extfile tls-cert-idp.conf -out idp.example.crt