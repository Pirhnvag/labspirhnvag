pipeline {
    agent {
     label '10.0.0.5'
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
                sh 'mvn ' --version
            }
        }
		stage('Deploy') { 
            steps {
                sh 'mvn ' --version
            }
        }
    }