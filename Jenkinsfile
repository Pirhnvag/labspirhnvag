pipeline {
    agent  {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            label '10.0.0.4'
            args  '-v /tmp:/tmp'
         }
           }
               }
               stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        }