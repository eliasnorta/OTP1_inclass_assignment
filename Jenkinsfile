pipeline {
    agent any

    tools {
        maven 'Maven3' // MUST match the exact name in Jenkins → Manage Jenkins → Maven
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
    }
}
