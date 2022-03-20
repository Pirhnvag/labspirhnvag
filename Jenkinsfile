pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['deploymv']) {
            sh '''
                ssh -i env.SSH_KEY_DOCKER azureuser@20.127.128.16 'df -h'
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