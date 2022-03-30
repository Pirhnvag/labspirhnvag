pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') { 
            steps { 
                script{
                 app = docker.build("roomti-keycloak")
                }
            }
        }
        stage('Deploy') {
            steps {
                script{
                        docker.withRegistry('https://046575588439.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:awsecr') {
                    app.push("${env.BUILD_NUMBER}")
                    app.push("latest")
                    }
                }
            }
        }
    }
}