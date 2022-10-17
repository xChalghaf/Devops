pipeline {
    agent any
    stages {
        stage('SonarQube analysis 2') {
            steps {
                sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=ayoub123'
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
