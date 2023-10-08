# Teste Java Inter

Para rodar o projeto e os testes, basta selecionar e executar um Run na aplicação.

## Features

> Registrar usuario e seu(s) respectivo(s) cargo(s).

> Validar e efetuar o login do usuario.

> Obter a cotação  da moeda selecionada.

Aplicacao foi feita utilizando Spring e o banco de dados h2 implementanto funcionalidades como:

### Registration :heavy_check_mark:

O registro e feito utilizando a confirmacao da senha e um auto login atraves 
de um token gerado para o acesso do usuario.

> Rota:http://localhost:8888/api/v1/auth/registrar

### Login :heavy_check_mark:

O login e realizado somente quando esse token for marcado como "authenticated". Caso o contrario, o login ira falhar.

### Validation :heavy_check_mark:

A validacao dos campos como email e password sao feitas atraves da classe
"validator", na qual toda a regra de validacao e implementada nela.

> Rota:http://localhost:8888/api/v1/auth/autenticar
