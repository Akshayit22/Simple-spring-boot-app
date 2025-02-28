pipeline {
    agent any

    environment {
        IMAGE_NAME = "my-java-app"
        IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8080:8080 --name my-container $IMAGE_NAME:$IMAGE_TAG'
            }
        }
    }

    post {
        always {
            sh 'docker stop my-container || true'
            sh 'docker rm my-container || true'
        }
    }
}

