pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
          sshagent(credentials: ['deploymv']) {
            sh '''
               sudo ssh -i /var/lib/jenkins/deployserver_key.pem -t azureuser@20.127.128.16 'sudo ls -l'
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