FROM amazoncorretto:17-alpine-jdk

WORKDIR /code

COPY ./app /code/app

RUN apk add --no-cache openssl && \
   wget https://truststore.pki.rds.amazonaws.com/global/global-bundle.pem && \
   mv global-bundle.pem app/global-bundle.pem && \
   openssl pkcs12 -export -in app/global-bundle.pem -out app/certificate.p12 -name "certificate" && \
   keytool -importkeystore -srckeystore app/certificate.p12 -srcstoretype pkcs12 -destkeystore app/truststore.jks -deststoretype JKS

CMD ["sh", "-c", "java -jar /code/app/app-fastfood.jar"]