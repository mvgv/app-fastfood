FROM amazoncorretto:17-alpine-jdk

WORKDIR /code

COPY ./app /code/app

RUN apk add --no-cache openssl || echo "Failed to install OpenSSL" && \
   wget https://truststore.pki.rds.amazonaws.com/global/global-bundle.pem || echo "Failed to download global-bundle.pem" && \
   mv global-bundle.pem app/global-bundle.pem || echo "Failed to move global-bundle.pem" && \
   awk '/BEGIN CERTIFICATE/,/END CERTIFICATE/{ print }' app/global-bundle.pem > app/first-certificate.pem || echo "Failed to extract first certificate" && \
   openssl pkcs12 -export -in app/first-certificate.pem -out app/certificate.p12 -name "certificate" || echo "Failed to create PKCS12 file" && \
   keytool -importkeystore -srckeystore app/certificate.p12 -srcstoretype pkcs12 -destkeystore app/truststore.jks -deststoretype JKS || echo "Failed to create JKS file"

CMD ["sh", "-c", "java -jar /code/app/app-fastfood.jar"]