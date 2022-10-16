pipeline {
  agent any
  stages {
    stage('MVN COMPILE') {
      steps {
        sh 'mvn compile'
      }
    }
        stage('MVN TEST') {
            steps {
                sh 'mvn test'
            }
        }
}


  
}

