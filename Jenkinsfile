node {
    def SONARQUBE_HOSTNAME = 'sonarqube'

    def GRADLE_HOME = tool name: 'gradle-4.10.2', type: 'hudson.plugins.gradle.GradleInstallation'
    sh "${GRADLE_HOME}/bin/gradle tasks"

    stage('prep') {
        git url: 'https://github.com/mahouESPRIT/cicd.git'                
    }

    stage('build') {
        sh "${GRADLE_HOME}/bin/gradle build"
    }

    stage('sonar-scanner') {
      
        sh "mvn sonar:sonar \
          -Dsonar.projectKey=ayoubmahou \
          -Dsonar.host.url=http://172.17.0.3:9000 \
          -Dsonar.login=05ed0a5f4adda16f4b394b0296f74e9eadb27b7b"
      }
    

}
