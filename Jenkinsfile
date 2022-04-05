pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "./gradlew sonarqube"
                }
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