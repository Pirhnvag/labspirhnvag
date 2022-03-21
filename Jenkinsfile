pipeline {
    agent any
    stages {
        stage('Build') {
        agent {
                label '10.0.0.5'
            } 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Sonar') { 
            steps {
                sh 'mvn --version'
            }
        }
        stage('Deploy jar en el servidor destino') {
            steps {
          sshagent(credentials: ['f385715f-c26e-497c-8969-e0bb277197e6']) {
            sh '''         
              scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/PIPELINE-API-REST-SPRINGBOOT/target/demo-0.0.1-SNAPSHOT.jar azureuser@20.127.128.16:/home/azureuser/
            '''                 
            }
        }
        }
        stage('Run jar en el servidor destino') {
        agent {
                label '10.0.0.5'
            } 
            steps {
          sshagent(credentials: ['f385715f-c26e-497c-8969-e0bb277197e6']) {
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'cd /home/ && ls -la'
            '''
                }
            }
        }
    }
}