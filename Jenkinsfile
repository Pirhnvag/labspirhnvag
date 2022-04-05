pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('SonarQube analysis') {
    withSonarQubeEnv('SonarQube') {
      sh 'mvn clean package sonar:sonar'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
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