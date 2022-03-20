pipeline {
    agent any
    stages {
        stage('Build desde el agente de compilacion esclavo para maven') {
            agent {
                label '10.0.0.5'
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy jar') {
            agent {
                label '10.0.0.5'
            }
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([file(credentialsId: 'azure_credentials_dockermv', variable: 'SSH_KEY_DOCKER')]) {
                    echo 'conectando VPN'
                    sh '''
                    ssh azureuser@20.127.128.16 'df -h'
                    '''
                }
            }
        }
        stage('Build desde el agente de compilacion esclavo para nodejs') {
            agent {
                label '10.0.0.5'
            }
            steps {
                sh 'node --version'
            }
        }
    }
}