pipeline {
    agent none
    stages {
        stage('Non-Sequential Stage') {
            agent {
                label '10.0.0.5'
            }
            steps {
                echo "On Non-Sequential Stage"
            }
        }