pipeline {
    agent any
   
    stages {
        stage('GIT'){
            steps {
                git branch: 'Ala', url: 'https://github.com/xChalghaf/Devops.git'
               
            }
        }
       
        stage('CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
       
        stage('COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
       
        stage('SONAR') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
       
        stage('JUNIT') {
            steps {
                //sh 'mvn compile'
sh 'echo "Junit"'
            }
        }
       
        stage('NEXUS') {
            steps {
                sh 'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
            }
        }
       
    }
}
