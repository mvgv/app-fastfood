# app-fastfood
BUILD DE DEV: 
docker-compose -f ./infra/dev/docker-compose.yaml up 
Esse comando compila o código java, executa o jar do monolito e gera uma imagem nova, usem quando forem testar alteracoes do codigo
Mantenham a pratica de alterar a versao da imagem no arquivo dev.env

BUILD DE PROD:
docker build -f ./infra/prod/Dockerfile . -t mvgv/appfastfood:LATEST - Builda a imagem com o jar compilado.

docker push  mvgv/appfastfood:LATEST - Publica a imagem no dockerhub

docker-compose -f ./infra/prod/docker-compose.yaml up - executa o nosso projeto a partir da imagem disponibilizada no docker hub

