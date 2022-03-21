pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([file(credentialsId: 'deploymv')]) {
                    echo 'conectando VPN'
                    sh '''
                    ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'ls -l'
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