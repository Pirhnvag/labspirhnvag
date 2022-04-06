pipeline {
    agent any
    tools {
		maven "Maven3"
	}
	
	environment {
		def pkgName = 'company-api-rest-crud-completo'
	}
    stages {
        stage('Build & Test') { 
            steps {
                sh 'mvn clean test jacoco:prepare-agent jacoco:report'
            }
        }
        stage('SonarQube') {
        steps {
				withSonarQubeEnv('SonarQube') {
					script {
						//def fixedBranchName = env.GIT_BRANCH.replace("origin/", "").replace("/", "_")
						sh 'mvn sonar:sonar -Dsonar.projectName=$pkgName:' + ' -Dsonar.projectKey=$pkgName:'
					}
				}
			}
		}
		stage('SonarQube Quality Gate') {
			steps {
				echo 'Esperando respuesta analisis SonarQube'
				timeout(5) {
					waitForQualityGate abortPipeline: false, credentialsId: 'SONARQUBE_TOKEN'
				}
			}
		}
        stage('package') {
			when {
				branch 'master'
			}
			steps {
				sh 'mvn package -DskipTests'
			}
		}
		stage('save artifacts') {
			when {
				branch 'master'
			}
			steps {
				archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
			}
		}
	}
	
	post {
		always {
			echo 'Build finalizado exitosamente'
		}
	}
}      