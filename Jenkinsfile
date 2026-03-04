pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        // Make sure all standard macOS paths are included so sh commands work
        PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin"
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        DOCKERHUB_REPO = 'eliasnorta/otp1_assignment'
        DOCKER_IMAGE_TAG = 'latest'
        DOCKER_CLI = '/usr/local/bin/docker'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/eliasnorta/OTP1_inclass_assignment.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
    steps {
        sh '/usr/local/bin/docker build -t eliasnorta/otp1_assignment:latest .'
    }
}

stage('Push Docker Image to Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", 
                                          usernameVariable: 'DOCKER_USER', 
                                          passwordVariable: 'DOCKER_PASS')]) {
            sh '/usr/local/bin/docker login -u $DOCKER_USER -p $DOCKER_PASS'
            sh '/usr/local/bin/docker push eliasnorta/otp1_assignment:latest'
        }
    }
}

    }
}
