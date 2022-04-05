pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('SonarQube analysis') {
          withSonarQubeEnv(installationName: 'SonarQube') { // You can override the credential to be used
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
        }
        stage('Build') { 
            steps { 
                script{
                 app = docker.build("test")
                }
            }
        }
        stage('Deploy') {
            steps {
                script{
                        docker.withRegistry('https://046575588439.dkr.ecr.us-east-2.amazonaws.com', 'ecr:us-east-2:awsecr') {
                    //app.push("${env.BUILD_NUMBER}")
                    app.push("latest")
                    }
                }
            }
        }
    }
}