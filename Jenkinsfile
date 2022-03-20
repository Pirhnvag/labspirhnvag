pipeline {
    agent any
    stages {
        stage('Build desde el agente de compilacion esclavo') {
            agent {
                label '10.0.0.5'
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build desde el agente de compilacion esclavo') {
            agent {
                label '10.0.0.5'
            }
            steps {
                sh 'node --version'
            }
        }
    }
}