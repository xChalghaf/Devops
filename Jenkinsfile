pipeline {
  agent any
  stages {
    stage('MVN COMPILE') {
      steps {
        sh 'mvn compile'
      }
    }
      //  stage('MVN TEST') {
       //     steps {
        //        sh 'mvn test'
        //    }
       // }
        
        stage ('Maven Test Sonar') {
            steps {
//                sh 'cd achat'
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:RELEASE:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
}

}
  
}
