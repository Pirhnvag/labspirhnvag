pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['deploymv']) {
            sh '''
               ssh -i $SSH_KEY_DOCKER -l azureuser 20.127.128.16 -t 'ls -l'
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