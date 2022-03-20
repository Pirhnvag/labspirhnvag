pipeline {
    agent none {
    stages {
	    stage('Build') 
            steps {
                echo 'Ejecutando deploy hacia la maquina docker'
                withCredentials([file(credentialsId: 'azure_credentials_dockermv', variable: 'SSH_KEY_DOCKER')]) {
                    echo 'conectando VPN'
                    sh '''
                    ssh -i $SSH_KEY_DOCKER -t azureuser@20.127.128.16 'df -h'
                    '''
                }
            }
		}	
	}
}			