pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['deploymv', variable: 'SSH_KEY_DOCKER']) {
            sh '''
                ssh -i $SSH_KEY_DOCKER azureuser@20.127.128.16 'df -h'
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