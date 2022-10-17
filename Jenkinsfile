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
stage ('Maven Test Sonar') {
            steps {
//              sh 'cd achat'
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:RELEASE:sonar -Dsonar.login=admin -Dsonar.password=ayoub123'
            }
    

}
