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
    stage('Build desde el nodo maestro') {
            agent docker {
                image 'maven:3.8.1-adoptopenjdk-11'
                args '-v /root/.m2:/root/.m2' 
            }
            steps {
                sh 'mvn --version'
            }
        }
    }
}