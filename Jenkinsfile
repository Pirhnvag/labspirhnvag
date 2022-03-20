pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            label '10.0.0.5' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
		stage('Test') { 
            steps {
                sh 'mvn --version'
            }
        }
        stage('Deploy') { 
            steps {
                sh 'mvn --version'
            }
        }
    }
}