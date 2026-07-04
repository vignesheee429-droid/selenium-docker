pipeline{
    agent any
    stages{
        stage('Build Jar'){
            steps{
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image'){
            steps{
                bat "docker build -t=vigneshponniyappan/selenium:latest ."
            }
        }
        stage('Push Image'){
            environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps{
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push vigneshponniyappan/selenium:latest"
                bat "docker tag vigneshponniyappan/selenium:latest vigneshponniyappan/selenium:${env.BUILD_NUMBER}"
                bat "docker push vigneshponniyappan/selenium:${env.BUILD_NUMBER}"
            }
        }
    }
}