pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
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
                    app.push("latest")
                    }
                }
            }
        }
    }
}