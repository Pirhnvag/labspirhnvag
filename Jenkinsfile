pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([string(credentialsId: 'azure_credentials_dockermv', variable: 'SSH_KEY_DOCKER')]) {
                    echo 'conectando VPN'
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