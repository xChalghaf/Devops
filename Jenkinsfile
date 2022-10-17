pipeline {
  agent any
   environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running. 'nexus-3' is defined in the docker-compose file
        NEXUS_URL = "172.17.0.4:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "repository-example"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexus1"
        NEXUS_SCRIPT = "maven-create-hosted"
    }

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
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:RELEASE:sonar -Dsonar.login=admin -Dsonar.password=ayoub123 -Dsonar.host.url=http://172.17.0.3:9000'
            }
}
    stage("clone code") {
            steps {
                script {
                    // Get the script and check the want we want to create does not exists
                    response = httpRequest authentication: NEXUS_CREDENTIAL_ID, url: "${NEXUS_PROTOCOL}://${NEXUS_URL}/service/rest/v1/script";
                    echo "Response: ${response.content}"
                    jsonGetResponse = readJSON text: response.content;
                    
                    findResult = jsonGetResponse.find{element -> element.name.trim().equals(NEXUS_SCRIPT)};
                    echo "Result of finding: ${findResult}"
                    if(findResult == null) {
                        echo "Creating script"
                        // Create it!
                        jsonPayload =   "{ " +
                                        "    \"name\": \"${NEXUS_SCRIPT}\", " +
                                        "    \"type\": \"groovy\", " +
                                        "    \"content\":\"repository.createMavenHosted('${NEXUS_REPOSITORY}', 'default', true, org.sonatype.nexus.repository.maven.VersionPolicy.MIXED, org.sonatype.nexus.repository.storage.WritePolicy.ALLOW, org.sonatype.nexus.repository.maven.LayoutPolicy.PERMISSIVE)\" " +
                                        "}";
                        httpRequest authentication: NEXUS_CREDENTIAL_ID, 
                                    url: "${NEXUS_PROTOCOL}://${NEXUS_URL}/service/rest/v1/script",
                                    contentType: 'APPLICATION_JSON',
                                    httpMode: 'POST',
                                    requestBody: jsonPayload;
                        echo "Using payload ${jsonPayload}"
                        
                        // Invoke it!
                        httpRequest authentication: NEXUS_CREDENTIAL_ID, 
                                    contentType: 'TEXT_PLAIN',
                                    url: "${NEXUS_PROTOCOL}://${NEXUS_URL}/service/rest/v1/script/${NEXUS_SCRIPT}/run",
                                    httpMode: 'POST';
                    }
                }
            }
        }
        

}
  
}
