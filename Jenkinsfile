pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([file(credentialsId: 'deploymv', variable: 'SSH_KEY_DOCKER')]) {
                    sh '''
                    ssh -i env.SSH_KEY_DOCKER -t azureuser@20.127.128.16
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