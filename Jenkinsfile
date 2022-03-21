pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['f385715f-c26e-497c-8969-e0bb277197e6']) {
            sh '''
               ssh -T azureuser@20.127.128.16 'sudo ls -l'
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