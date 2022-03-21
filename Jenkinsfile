pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['deploymv']) {
            sh '''
               ssh -l azureuser 20.127.128.16 -i $SSH_KEY_DOCKER
            '''
          }
      }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}