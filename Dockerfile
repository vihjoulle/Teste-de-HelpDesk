# Use a imagem oficial do Maven 3.6 como base
FROM maven:3.6-jdk-11 AS build

MAINTAINER github.com/vihjoulle

# Defina o diretório de trabalho para o diretório raiz do projeto
WORKDIR /app

# Copie os arquivos de código-fonte e o arquivo pom.xml para o contêiner
COPY . .

# Build da aplicação com Maven
RUN mvn clean package

# Use uma imagem da OpenJDK 8 para a execução final
FROM openjdk:11-jdk

# Copie o artefato construído do estágio anterior
COPY --from=build /app/target/HelpDesk-0.0.1-SNAPSHOT.jar /app/HelpDesk-0.0.1-SNAPSHOT.jar

# Defina o diretório de trabalho para o diretório raiz da aplicação
WORKDIR /app

# Exponha a porta 8080 (se necessário)
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "HelpDesk-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
