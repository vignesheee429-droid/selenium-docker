FROM bellsoft/liberica-openjdk-alpine:21.0.11

# Install curl jq

RUN apk add --no-cache bash curl jq

# workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources ./
ADD runner.sh .

# Start the runner.sh
RUN chmod +x runner.sh

ENTRYPOINT ["./runner.sh"]