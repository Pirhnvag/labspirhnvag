pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([file(credentialsId: 'deploymv', variable: 'SSH_KEY_DOCKER')]) {
                    echo 'conectando VPN'
                }
            }
        }
     }
}     