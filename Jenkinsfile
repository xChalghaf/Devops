pipeline {
    agent any
    stages {
        stage('SonarQube analysis 2') {
            steps {
                sh 'mvn clean package sonar:sonar -Dsonar.login=05ed0a5f4adda16f4b394b0296f74e9eadb27b7b -Dsonar.password=05ed0a5f4adda16f4b394b0296f74e9eadb27b7b'
            }
        }
        stage('SonarQube analysis 1') {
            steps {
                sh 'mvn clean package sonar:sonar'
            }
        }
        stage("Quality Gate 1") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
        stage('SonarQube analysis 2') {
            steps {
                sh 'gradle sonarqube'
            }
        }
        stage("Quality Gate 2") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    }
}
