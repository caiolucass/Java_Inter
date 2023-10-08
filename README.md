# Spring-Register-Login

## Features

> Registrar usuario e seu(s) respectivo(s) cargo(s).

> Validar e efetuar o login do usuario.

> Obter a cotação  da moeda selecionada.

Aplicacao foi feita utilizando Spring e o banco de dados h2 implementanto funcionalidades como:

### Registration :heavy_check_mark:

O registro e feito utilizando a confirmacao da senha e um auto login atraves 
de um token gerado para o acesso do usuario.

### Login :heavy_check_mark:

O login e realizado somente quando esse token for marcado como "authenticated". Caso o contrario, o login ira falhar.

### Validation :heavy_check_mark:

A validacao dos campos como userName e password sao feitas atraves da classe
"validator", na qual toda a regra de validacao e implementada nela.

## DevTools :hammer:
> H2 :heavy_check_mark:

> Maven :heavy_check_mark:

> Lombok :heavy_check_mark:

> JPA :heavy_check_mark:

> Security :heavy_check_mark:

> Devtools :heavy_check_mark:

> Starter-web :heavy_check_mark:
