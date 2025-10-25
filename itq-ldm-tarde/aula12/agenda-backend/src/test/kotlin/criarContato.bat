curl --request POST --header "Content-Type: application/json" --data "{\"id\": null, \"nome\": \"Jose Almeida\", \"telefone\": \"(11) 3333-3333\", \"email\": \"jose@teste.com\"}" http://localhost:8080/contato

curl --request POST --header "Content-Type: application/json" --header "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHRlc3RlLmNvbSIsImlhdCI6MTc2MDcyOTYyNSwiZXhwIjoxNzYwODE2MDI1fQ.9qQFDy51cCAdnrBZIDMeX5x8fDnsuwKMwwggQ5rJWZU" --data "{\"id\": null, \"nome\": \"Jose Almeida\", \"telefone\": \"(11) 3333-3333\", \"email\": \"jose@teste.com\"}" http://localhost:8080/contato



curl --request POST --header "Content-Type: application/json" --data "{\"id\": null, \"nome\": \"Joao Silva\", \"telefone\": \"(11) 1111-1111\", \"email\": \"joao@teste.com\"}" http://localhost:8080/contato
curl --request POST --header "Content-Type: application/json" --data "{\"id\": null, \"nome\": \"Maria Silva\", \"telefone\": \"(11) 2222-2222\", \"email\": \"maria@teste.com\"}" http://localhost:8080/contato